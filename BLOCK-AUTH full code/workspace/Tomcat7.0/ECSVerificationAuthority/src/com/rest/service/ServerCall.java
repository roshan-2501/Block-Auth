package com.rest.service;

import java.io.IOException;

import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import com.rest.service.ReadProperty;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.client.filter.LoggingFilter;

public class ServerCall {
	static WebResource service = null;

	public ServerCall() throws IOException {
		ClientConfig config = new DefaultClientConfig();
		Client client = Client.create(config);
		client.addFilter(new LoggingFilter());
		ReadProperty property = new ReadProperty();
		String url = property.getURLDetails();
		service = client.resource(url);
	}

	/*-----------------------------Server Calls----------------------------*/
	public JSONObject sendQrCode(JSONObject jsonObject) throws JSONException {
		JSONObject sendJson = service.path("rest").path("cer")
				.path("docmethod").accept(MediaType.APPLICATION_JSON).type(
						MediaType.APPLICATION_JSON).post(JSONObject.class,
						jsonObject);
		return sendJson;
	}

}
