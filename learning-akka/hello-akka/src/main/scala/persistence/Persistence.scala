package persistence

import akka.actor.{ActorSystem, Props}
import persistence.Counter.{Cmd, Decrement, Increment}

object Persistence extends App {
  val system = ActorSystem("persistence")

  val counter = system.actorOf(Props[Counter], "counter")
  counter ! Cmd(Increment(3))
  counter ! Cmd(Increment(5))
  counter ! Cmd(Decrement(5))
  counter ! "print"

  Thread.sleep(100)

  system.terminate()
}
