package hotswap_behavior

import akka.actor.{Actor, ActorSystem, Props}
import akka.actor.Actor.Receive
import hotswap_behavior.UserStorage.{Connect, DBOperation, Disconnect, Operation}

case class User(username: String, email: String)

object UserStorage {
  trait DBOperation

  object DBOperation {
    case object Create extends DBOperation
    case object Update extends DBOperation
    case object Read extends DBOperation
    case object Delete extends DBOperation
  }

  case object Connect
  case object Disconnect
  case class Operation(dBOperation: DBOperation, user: User)
}

class UserStorage extends Actor {
  override def receive: Receive = disconnected

  def connected: Receive = {
    case Disconnect =>
      println(s"User Storage disconnected to DB")
      context.unbecome()
    case Operation(op, user) =>
      println(s"User Storage received $op to do in user: $user")
  }

  def disconnected: Receive = {
    case Connect =>
      println(s"User Storage connected to DB")
      context.become(connected)
  }
}

object BecomeHotSwapApp extends App {
  val system = ActorSystem("become-hot-swap")
  val userStorage = system.actorOf(Props[UserStorage], "userStorage")

  userStorage ! Connect
  userStorage ! Operation(DBOperation.Create, User("Admin", "admin@mail.com"))
  userStorage ! Disconnect

  Thread.sleep(100)

  system.terminate()
}
