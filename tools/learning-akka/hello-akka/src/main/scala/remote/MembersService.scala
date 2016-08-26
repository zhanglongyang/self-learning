package remote

import akka.actor.{ActorSystem, Props}
import com.typesafe.config.ConfigFactory

object MembersService extends App {
  val config = ConfigFactory.load.getConfig("MembersService")

  val system = ActorSystem("MembersService", config)
  val worker = system.actorOf(Props[Worker], "remote-worker")

  println(s"Worker actor path is ${worker.path}")

//  system.terminate()
}

object MembersServiceLookup extends App {
  val config = ConfigFactory.load.getConfig("MembersServiceLookup")

  val system = ActorSystem("MembersServiceLookup", config)
  val worker = system.actorSelection("akka.tcp://MembersService@127.0.0.1:2552/user/remote-worker")
  worker ! Worker.Work("Hi Remote Worker")

//  system.terminate()
}
