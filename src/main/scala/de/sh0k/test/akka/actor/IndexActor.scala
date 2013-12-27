package de.sh0k.test.akka.actor

import akka.actor.Actor
import akka.event.Logging

/**
 * @author dweidenfeld
 */
class IndexActor extends Actor {
  val log = Logging(context.system, this)

  def receive: Actor.Receive = {
    case "process" => sender ! "working"
    case _      => log.info("unknown message received")
  }
}
