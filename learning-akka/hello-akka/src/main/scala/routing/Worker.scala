package routing

import akka.actor.Actor
import routing.Worker.Work

class Worker extends Actor {
  override def receive: Receive = {
    case msg: Work =>
      println(s"I received Work message and my ActorRef: $self")
  }
}

object Worker {
  case class Work()
}
