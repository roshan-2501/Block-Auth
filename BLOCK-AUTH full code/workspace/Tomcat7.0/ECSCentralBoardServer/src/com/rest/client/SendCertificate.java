package com.rest.client;

import java.net.URI;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;

public class SendCertificate {
	static String urlCall = "http://localhost:9999/ECS";
	public static JSONObject callService(String email) throws JSONException{
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		client.addFilter(new LoggingFilter());
		WebResource resource = client.resource(getBaseURI());
		JSONObject requestObj = new JSONObject();
		requestObj.put("email", email);
		JSONObject jsonObject=resource.path("rest").path("cer").path("cermethod").type(MediaType.APPLICATION_JSON).post(JSONObject.class, requestObj);
		return jsonObject;
	}

	private static URI getBaseURI() {
		return UriBuilder.fromUri(urlCall).build();
	}

}
