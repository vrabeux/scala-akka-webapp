package de.sh0k.test.akka.controller

import javax.ws.rs.{Produces, GET, Path}
import com.sun.jersey.api.core.InjectParam
import de.sh0k.test.akka.services.{ActorService, IndexService}
import javax.ws.rs.core.MediaType
import com.sun.jersey.api.view.Viewable
import akka.pattern.ask
import akka.util.Timeout
import java.util.concurrent.TimeUnit
import javax.ws.rs.container.{Suspended, AsyncResponse}
import scala.concurrent.ExecutionContext.Implicits.global

/**
 * @author dweidenfeld
 */
@Path("/")
@Produces(Array(MediaType.TEXT_HTML))
class IndexController {

  implicit val timeout = Timeout(100, TimeUnit.MILLISECONDS)

  @InjectParam
  var indexService: IndexService = null

  @InjectParam
  var actorService: ActorService = null

  @GET
  def index = new Viewable(indexService.VIEW_PATH_INDEX, "Hello World")

  @GET
  @Path("/process")
  def process(@Suspended asyncResponse: AsyncResponse) {
    actorService.indexActor().ask("process").onSuccess({
      case _ => asyncResponse.resume("working")
    })
  }
}
