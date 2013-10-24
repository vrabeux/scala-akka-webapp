package de.sh0k.test.akka.controller

import javax.ws.rs.{Produces, GET, Path}
import com.sun.jersey.api.core.InjectParam
import de.sh0k.test.akka.services.{JobService, IndexService}
import javax.ws.rs.core.MediaType
import com.sun.jersey.api.view.Viewable
import de.sh0k.test.akka.model.JobStatus

/**
 * @author dweidenfeld
 */
@Path("/")
@Produces(Array(MediaType.TEXT_HTML))
class IndexController {

  @InjectParam
  var indexService: IndexService = null

  @InjectParam
  var jobService: JobService = null

  @GET
  def index = new Viewable(indexService.VIEW_PATH_INDEX)

  @GET
  @Path("/job")
  @Produces(Array(MediaType.APPLICATION_XML))
  def job = {
    val jobStatus: JobStatus = new JobStatus()

    jobStatus
  }
}
