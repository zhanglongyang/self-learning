package routing

import akka.actor.{Actor, ActorRef, Props}
import routing.Worker.Work

class Router extends Actor {
  var routes: List[ActorRef] = _

  @scala.throws[Exception](classOf[Exception])
  override def preStart(): Unit = {
    routes = List.fill[ActorRef](5) (
      context.actorOf(Props[Worker])
    )
  }

  override def receive: Receive = {
    case msg: Work =>
      println(s"I'm A Router and I received a message: $msg")
      routes(util.Random.nextInt(routes.size)) forward msg
  }
}

class RouterGroup(routes: List[String]) extends Actor {
  override def receive: Receive = {
    case msg: Work =>
      println(s"I'm a Router Group and I received a message: $msg")
      context.actorSelection(routes(util.Random.nextInt(routes.size))) forward msg
  }
}
