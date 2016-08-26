package play_with_actors

import akka.actor.{Actor, ActorSystem, Props}
import play_with_actors.MusicController.{Play, Stop}
import play_with_actors.MusicPlayer.{StartMusic, StopMusic}

object MusicController {
  sealed trait ControllerMsg
  case object Play extends ControllerMsg
  case object Stop extends ControllerMsg

  def props = Props[MusicController]
}

class MusicController extends Actor {
  override def receive: Receive = {
    case Play => println("Music Started")
    case Stop => println("Music Stopped")
  }
}

object MusicPlayer {
  sealed trait PlayMsg
  case object StartMusic extends PlayMsg
  case object StopMusic extends PlayMsg
}

class MusicPlayer extends Actor {
  override def receive: Receive = {
    case StopMusic => println("I don't want to stop music")
    case StartMusic => {
      val controller = context.actorOf(MusicController.props, "controller")
      controller ! Play
    }
    case _ => println("Unknown Message")
  }
}

object Creation extends App {
  val system = ActorSystem("creation")

  val player = system.actorOf(Props[MusicPlayer], "player")
  player ! StartMusic

  player ! StopMusic
}
