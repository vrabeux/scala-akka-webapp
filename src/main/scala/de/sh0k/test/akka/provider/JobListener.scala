package de.sh0k.test.akka.provider

import javax.ws.rs.ext.Provider
import com.sun.jersey.api.model.{AbstractResourceModelContext, AbstractResourceModelListener}
import de.sh0k.test.akka.services.JobService
import com.sun.jersey.api.core.InjectParam

/**
 * @author dweidenfeld
 */
@Provider
class JobListener extends AbstractResourceModelListener {

  @InjectParam
  var jobService: JobService = null

  def onLoaded(armc: AbstractResourceModelContext) {

  }
}
