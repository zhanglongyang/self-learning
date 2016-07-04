package actor_paths

import akka.actor.{Actor, ActorIdentity, ActorRef, ActorSystem, Identify, Props}

class Watcher extends Actor {
  var counterRef: ActorRef = _
  val selection = context.actorSelection("/user/counter")
  selection ! Identify(None)

  override def receive: Receive = {
    case ActorIdentity(_, Some(ref)) =>
      println(s"Actor Reference for counter is $ref")
    case ActorIdentity(_, None) =>
      println(s"Actor Selection for actor doesn't live")
  }
}

object Watch extends App {
  val system = ActorSystem("watch-actor-selection")
  val counter = system.actorOf(Props[Counter], "counter")
  val watcher = system.actorOf(Props[Watcher], "watcher")

  system.terminate()
}