package persistence

import akka.actor.ActorLogging
import akka.persistence.{PersistentActor, SaveSnapshotFailure, SaveSnapshotSuccess, SnapshotOffer}
import persistence.Counter._

object Counter {

  sealed trait Operation {
    val count: Int
  }

  case class Increment(override val count: Int) extends Operation

  case class Decrement(override val count: Int) extends Operation

  case class Cmd(op: Operation)

  case class Evt(op: Operation)

  case class State(count: Int)

}

class Counter extends PersistentActor with ActorLogging {

  override def persistenceId: String = "persistent-counter-example"

  var state: State = State(count = 0)

  def updateState(evt: Evt): Unit = evt match {
    case Evt(Increment(count)) =>
      state = State(count = state.count + count)
      takeSnapshot
    case Evt(Decrement(count)) =>
      state = State(count = state.count - count)
      takeSnapshot
  }

  override def receiveRecover: Receive = {
    case evt: Evt =>
      println(s"Counter receive $evt on receiving mood")
      updateState(evt)
    case SnapshotOffer(_, snapshot: State) =>
      println(s"Counter received snapshot with data $snapshot on receiving mood")
      state = snapshot
  }

  override def receiveCommand: Receive = {
    case cmd@Cmd(op) =>
      println(s"Counter receive $cmd")
      persist(Evt(op)) { evt =>
        updateState(evt)
      }
    case "print" =>
      println(s"The Current state of counter is $state")
    case SaveSnapshotSuccess(metadata) =>
      println(s"save snapshot succeed.")
    case SaveSnapshotFailure(metadata, reason) =>
      println(s"save snapshot failed and failure is ${reason}")
  }

  def takeSnapshot = {
    if (state.count % 5 == 0) {
      saveSnapshot(state)
    }
  }
}
