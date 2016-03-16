package com.xtrac.rest.app;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/developer")
public interface IDeveloperService {

	// http://localhost:8080/XTRAC/developer/signup?emailId=test@gmail.com&firstName=testFirst&lastName=testLast&telNumber=12345
	@GET
	@Path("/signup")
	public Response developerSignup(@QueryParam("emailId") String emailId,
			@QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName,
			@QueryParam("telNumber") String telephoneNumber);

	// http://localhost:8080/XTRAC/developer/search?emailId=test@gmail.com
	@GET
	@Path("/search")
	public Response developerSearch(@QueryParam("emailId") String emailId);

	// http://localhost:8080/XTRAC/developer/update?emailId=test@yahoo.com&firstName=testFirst&last1Name=test2Last&telNumber=54321
	@GET
	@Path("/update")
	public Response developerDataUpdate(@QueryParam("emailId") String emailId,
			@QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName,
			@QueryParam("telNumber") String telephoneNumber);

	// http://localhost:8080/XTRAC/developer/delete?emailId=test@gmail.com
	@GET
	@Path("/delete")
	public Response developerDataDelete(@QueryParam("emailId") String emailId);

	// http://localhost:8080/XTRAC/developer/register?emailId=test@gmail.com&appName=testApp&appDesc=testAppDesc
	@GET
	@Path("/register")
	public Response developerAppRegister(@QueryParam("emailId") String emailId,
			@QueryParam("appName") String appName,
			@QueryParam("appDesc") String appDesc);

	// http://localhost:8080/XTRAC/developer/applist?emailId=test@gmail.com
	@GET
	@Path("/applist")
	public Response getAppList(@QueryParam("emailId") String emailId);
}