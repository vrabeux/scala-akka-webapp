package de.sh0k.test.akka.services

import org.springframework.stereotype.Component
import com.sun.jersey.spi.resource.Singleton
import de.sh0k.test.akka.model.{JobIdList, Job}


/**
 * @author dweidenfeld
 */
@Component
@Singleton
class JobService {

  var jobs: Map[Long, Job] = Map()

  {
    val job = new Job
    job.running = true
    jobs += 0L -> job
  }

  def findAllIds(): Option[JobIdList] = {
    val jobIdList: JobIdList = new JobIdList
    jobIdList.ids = jobs.keySet
    Option(jobIdList)
  }

  def findAll(): Option[List[Job]] = Option(jobs.values.toList)

  def find(id: Long): Option[Job] = jobs.get(id)
}
