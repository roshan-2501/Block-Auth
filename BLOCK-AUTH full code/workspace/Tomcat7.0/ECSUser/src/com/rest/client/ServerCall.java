package com.rest.client;

import java.io.IOException;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
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

	// qr requests
	public JSONObject sendQrCode(JSONObject jsonObject) throws JSONException {
		JSONObject sendJson = service.path("rest").path("qr").path("qrcall")
				.accept(MediaType.APPLICATION_JSON).type(
						MediaType.APPLICATION_JSON).post(JSONObject.class,
						jsonObject);
		return sendJson;
	}

	// passport status
	public JSONArray proofsStatus(JSONObject jsonObject) {
		JSONArray jsonArray = service.path("rest").path("qr").path(
				"proofstatus").accept(MediaType.APPLICATION_JSON).type(
				MediaType.APPLICATION_JSON).post(JSONArray.class, jsonObject);
		
		return jsonArray;
	}
	// public static void main(String args[]) throws JSONException, IOException
	// {
	// JSONObject jsonObject = new JSONObject();
	// jsonObject.put("email", "nitish@gmail.com");
	// jsonObject.put("qrcode", "sfsdfsdf");
	// jsonObject.put("docs", "passport");
	// ServerCall serverCall = new ServerCall();
	// JSONObject jan = serverCall.sendQrCode(jsonObject);
	// System.out.println("------------>" + jan);
	//
	// }
}
