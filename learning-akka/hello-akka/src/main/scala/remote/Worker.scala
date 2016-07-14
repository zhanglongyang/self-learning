package remote

import akka.actor.Actor
import remote.Worker.Work

class Worker extends Actor {
  override def receive: Receive = {
    case msg: Work =>
      println("============================================")
      println(s"I received Work Message and My ActorRef: $self")
      println("============================================")
  }
}

object Worker {
  case class Work(message: String)
}