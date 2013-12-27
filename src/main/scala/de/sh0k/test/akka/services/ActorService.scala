package de.sh0k.test.akka.services

import org.springframework.stereotype.Component
import com.sun.jersey.spi.resource.Singleton
import de.sh0k.test.akka.actor.IndexActor
import akka.actor.{ActorRef, Props, ActorSystem}

/**
 * @author dweidenfeld
 */
@Component
@Singleton
class ActorService {

  val system = ActorSystem("scala-test")

  def indexActor(): ActorRef = system.actorOf(Props[IndexActor], "indexActor")
}
