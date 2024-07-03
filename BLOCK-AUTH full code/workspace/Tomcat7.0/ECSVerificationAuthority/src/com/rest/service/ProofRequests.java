package com.rest.service;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.QRPojo;
import model.QrDetailsPojo;

import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import service.AuthDao;

@Path("qr")
public class ProofRequests {
	@Path("qrcall")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONObject prrofRequests(JSONObject jsonObject) throws JSONException {
		String email = (String) jsonObject.get("email");
		String qrcode = (String) jsonObject.get("qrcode");
		String docs = (String) jsonObject.get("docs");
		System.out.println(email + "<------------->" + qrcode);
		JSONObject returnObj = new JSONObject();
		QRPojo qrPojo = new QRPojo(email, docs, qrcode, "pending");
		AuthDao authDao = new AuthDao();
		boolean result = authDao.saveQrRequest(qrPojo);
		if (result) {
			returnObj.put("response", "ok");
		} else {
			returnObj.put("response", "You already requested for " + docs);
		}
		return returnObj;
	}

	@Path("proofstatus")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public JSONArray proofStatus(JSONObject jsonObject) throws JSONException {
		String email = (String) jsonObject.get("email");
		AuthDao authDao = new AuthDao();
		List<QRPojo> list = authDao.loadRequestsByEmail(email);
		JSONArray jsonArray=new JSONArray();
		JSONObject responseJsonObject = null;
		if (!list.isEmpty()) {
			for (QRPojo qrPojo : list) {
				responseJsonObject=new JSONObject();
				responseJsonObject.put("type", qrPojo.getRequestType());
				responseJsonObject.put("status", qrPojo.getStatus());
				System.out.println(qrPojo.getRequestType()+"   "+qrPojo.getStatus());
				jsonArray.put(responseJsonObject);
			}
			System.out.println(jsonArray);
		} else {
			responseJsonObject=new JSONObject();
			responseJsonObject.put("type", "no");
			responseJsonObject.put("status", "no");
			jsonArray.put(responseJsonObject);
		}

		return jsonArray;
	}

}
