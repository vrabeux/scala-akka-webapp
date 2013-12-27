package de.sh0k.test.akka.model

import javax.xml.bind.annotation.{XmlAccessType, XmlAccessorType, XmlRootElement}

/**
 * @author dweidenfeld
 */
@XmlRootElement(name = "job-ids")
@XmlAccessorType(XmlAccessType.FIELD)
class JobIdList {

  var ids: Set[Long] = Set()
}
