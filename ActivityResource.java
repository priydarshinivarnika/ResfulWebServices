package com.pluralsight;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;

import com.pluralsight.model.Activity;
import com.pluralsight.model.User;
import com.pluralsight.repository.ActivityRepository;
import com.pluralsight.repository.ActivityRepositoryStub;

@Path("activities") //http:locahost:8082/exercise-services/webapi/activities
public class ActivityResource {
	
	public ActivityRepository activityRepository = new ActivityRepositoryStub();
	
	
	@POST
	@Path("activity")
	@Consumes(MediaType.APPLICATION_FORM_URLENCODED)
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public Activity createActivityParams(MultivaluedMap<String, String> formParams	) {
		
		System.out.println(formParams.getFirst("description"));
		System.out.println(formParams.getFirst("duration"));
		return null;
	}

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public List<Activity> getAllActivities(){
		return activityRepository.findAllActivities();	
	}
	
	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}") //http:locahost:8082/exercise-services/webapi/activities/1234
	public Activity getActivity(@PathParam ("activityId") String activityId){
		return activityRepository.findActivity(activityId);	
	}
	
	@GET	
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("{activityId}/user") //http:locahost:8082/exercise-services/webapi/activities/1234
	public User getActivityUser(@PathParam ("activityId") String activityId){
		
		Activity activity =activityRepository.findActivity(activityId);
		User user = activity.getUser();
		return user;
		
		//return activityRepository.findActivity(activityId).getUser();	
	}
}
	