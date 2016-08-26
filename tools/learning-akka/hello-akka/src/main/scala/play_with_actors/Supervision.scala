package play_with_actors

import scala.concurrent.duration._
import akka.actor.SupervisorStrategy.{Escalate, Restart, Resume, Stop}
import akka.actor.{Actor, ActorRef, ActorSystem, OneForOneStrategy, Props, SupervisorStrategy}
import play_with_actors.Aphrodite._

import scala.language.postfixOps

class Aphrodite extends Actor {
  @scala.throws[Exception](classOf[Exception])
  override def preStart(): Unit = {
    println("Aphrodite preStart hook ...")
  }

  @scala.throws[Exception](classOf[Exception])
  override def preRestart(reason: Throwable, message: Option[Any]): Unit = {
    println("Aphrodite preRestart hook ...")
    super.preRestart(reason, message)
  }


  @scala.throws[Exception](classOf[Exception])
  override def postRestart(reason: Throwable): Unit = {
    println("Aphrodite postRestart hook ...")
    super.postRestart(reason)
  }

  @scala.throws[Exception](classOf[Exception])
  override def postStop(): Unit = {
    println("Aphrodite postStop hook ...")
  }

  override def receive: Receive = {
    case "Resume" => throw ResumeException
    case "Stop" => throw StopException
    case "Restart" => throw RestartException
    case _ => throw new Exception
  }
}

object Aphrodite {
  case object ResumeException extends Exception
  case object StopException extends Exception
  case object RestartException extends Exception
}

class Hera extends Actor {
  var childRef: ActorRef = _

  override def supervisorStrategy: SupervisorStrategy = OneForOneStrategy(maxNrOfRetries = 10, withinTimeRange = 1 second) {
    case ResumeException => Resume
    case RestartException => Restart
    case StopException => Stop
    case _: Exception => Escalate
  }

  @scala.throws[Exception](classOf[Exception])
  override def preStart(): Unit = {
    childRef = context.actorOf(Props[Aphrodite], "Aphrodite")
    Thread.sleep(100)
  }

  override def receive = {
    case msg =>
      println(s"Hera received $msg")
      childRef ! msg
      Thread.sleep(100)
  }
}

object Supervision extends App {
  val system = ActorSystem("Supervision")
  val hera = system.actorOf(Props[Hera], "hera")

//  hera ! "Resume"
//  Thread.sleep(1000)
//  println()

  hera ! "Restart"
  Thread.sleep(1000)
  println()

//  hera ! "Stop"
//  Thread.sleep(1000)
//  println()

  system.terminate()
}
