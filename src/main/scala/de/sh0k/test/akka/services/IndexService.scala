package de.sh0k.test.akka.services

import org.springframework.stereotype.{Service, Component}
import com.sun.jersey.spi.resource.Singleton

/**
 * @author dweidenfeld
 */
@Component
@Singleton
class IndexService {

  val VIEW_PATH_INDEX = "/index"

}
