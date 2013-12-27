package de.sh0k.test.akka.model

import javax.xml.bind.annotation._

/**
 * @author dweidenfeld
 */
@XmlRootElement(name = "job")
@XmlAccessorType(XmlAccessType.FIELD)
class Job {
  var running = false
}
