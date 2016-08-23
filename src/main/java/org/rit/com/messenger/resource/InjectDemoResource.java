package org.rit.com.messenger.resource;

import javax.ws.rs.Consumes;
import javax.ws.rs.CookieParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("annotation")
	public String getParamUsingAnnotaion(@MatrixParam("param")String matrixParam
			                             ,@HeaderParam("authSession")String headerValue
			                             ,@CookieParam("name")String val){
		return "test    :"+matrixParam+"   "+headerValue+" "+val;
	}
	@GET
	@Path("context")
	public String getParamUsingContext(@Context UriInfo uriinfo, @Context HttpHeaders headers){
		String path=uriinfo.getAbsolutePath().toString();
		String header=headers.getCookies().toString();
		return "test "+path+" "+header;
	}
	
}
