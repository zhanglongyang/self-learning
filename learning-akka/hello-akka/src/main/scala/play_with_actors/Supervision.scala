package play_with_actors

import java.util.concurrent.TimeUnit

import akka.actor.{Actor, ActorRef, ActorSystem, Props}
import akka.pattern.ask
import akka.util.Timeout
import play_with_actors.Checker.{BlackUser, CheckUser, WhiteUser}
import play_with_actors.Recorder.NewUser
import play_with_actors.Storage.AddUser

import scala.language.postfixOps

case class User(name: String, email: String)

object Recorder {
  sealed trait RecorderMsg

  case class NewUser(user: User) extends RecorderMsg
}

object Checker {
  sealed trait CheckerMsg
  case class CheckUser(user: User) extends CheckerMsg

  sealed trait CheckerResponse
  case class BlackUser(user: User) extends CheckerMsg
  case class WhiteUser(user: User) extends CheckerMsg
}

object Storage {
  sealed trait StorageMsg
  case class AddUser(user: User) extends StorageMsg
}

class Storage extends Actor {
  var users = List.empty[User]

  override def receive: Receive = {
    case AddUser(user) => {
      println(s"Storage: $user added")
      users = user :: users
    }
  }
}

class Checker extends Actor {
  val blackList = List(
    User("Adam", "adam@mail.com")
  )

  override def receive: Receive = {
    case CheckUser(user) if blackList.contains(user) =>
      println(s"Checker: $user in blacklist")
      sender() ! BlackUser(user)
    case CheckUser(user) =>
      println(s"Checker: $user not in blacklist")
      sender() ! WhiteUser(user)
  }
}

class Recorder(checker: ActorRef, storage: ActorRef) extends Actor {
  import scala.concurrent.ExecutionContext.Implicits.global
  implicit val timeout = Timeout(5, TimeUnit.SECONDS)

  override def receive: Receive = {
    case NewUser(user) =>
      checker ? CheckUser(user) map {
        case WhiteUser(user) =>
          storage ! AddUser(user)
        case BlackUser(user) =>
          println(s"Recorder: $user in blacklist")
      }
  }
}

object TalkToActor extends App {
  val system = ActorSystem("talk-to-actor")
  val checker = system.actorOf(Props[Checker], "checker")
  val storage = system.actorOf(Props[Storage], "storage")
  val recorder = system.actorOf(Props(new Recorder(checker, storage)), "recorder")

  recorder ! Recorder.NewUser(User("Jon", "jon@mail.com"))

  Thread.sleep(100)

  system.terminate()
}