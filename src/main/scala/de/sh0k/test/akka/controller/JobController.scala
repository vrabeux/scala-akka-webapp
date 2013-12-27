package de.sh0k.test.akka.controller

import javax.ws.rs.{PathParam, GET, Produces, Path}
import scala.Array
import javax.ws.rs.core.MediaType
import com.sun.jersey.api.core.InjectParam
import de.sh0k.test.akka.services.{JobService, IndexService}
import de.sh0k.test.akka.model.Job

/**
 * @author dweidenfeld
 */
@Path("/job")
@Produces(Array(MediaType.TEXT_HTML))
class JobController {

  @InjectParam
  var indexService: IndexService = null

  @InjectParam
  var jobService: JobService = null

  @GET
  @Produces(Array(MediaType.APPLICATION_XML))
  def findAllIds = jobService.findAllIds().get

  @GET
  @Path("/{id}")
  @Produces(Array(MediaType.APPLICATION_XML))
  def find(@PathParam("id") id: Long) = jobService.find(id).getOrElse(new Job)
}
