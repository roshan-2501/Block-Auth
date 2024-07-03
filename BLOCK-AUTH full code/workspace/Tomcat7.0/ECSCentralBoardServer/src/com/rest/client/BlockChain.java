package com.rest.client;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.ParseException;

public class BlockChain {
	public static String USER_AGENT = "Mozilla/5.0";

	public static String getQrDetails(String email, String cers)
			throws Exception {
		String signature = "";
		ReadProperty property = new ReadProperty();
		String url = property.getURLDetails() + "chain";

		URL obj = new URL(url);
		HttpURLConnection con = (HttpURLConnection) obj.openConnection();

		con.setRequestMethod("GET");

		con.setRequestProperty("User-Agent", USER_AGENT);

		int responseCode = con.getResponseCode();
		System.out.println("\nSending 'GET' request to URL : " + url);
		System.out.println("Response Code : " + responseCode);

		BufferedReader in = new BufferedReader(new InputStreamReader(con
				.getInputStream()));
		String inputLine;
		StringBuffer response = new StringBuffer();

		while ((inputLine = in.readLine()) != null) {
			response.append(inputLine);
		}
		in.close();
		String data = response.toString();
		// System.out.println(data);
		Object obj1 = "";
		try {
			obj1 = new JSONParser().parse(data);
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		JSONObject jo = (JSONObject) obj1;

		JSONArray array = (JSONArray) jo.get("chain");
		JSONObject jsonObject = null;
		JSONArray array2 = null;
		ArrayList<String> al = new ArrayList<String>();
		String dec = "";
		String b = "";
		Multimap<String, String> multimap = ArrayListMultimap.create();
		for (int i = 1; i <= array.size(); i++) {
			try {
				jsonObject = (JSONObject) array.get(i);
				array2 = (JSONArray) jsonObject.get("transactions");
				jsonObject = (JSONObject) array2.get(0);
				String emailId = (String) jsonObject.get("sender");
				String documents = (String) jsonObject.get("recipient");
				multimap.put(emailId, documents);
			}

			catch (IndexOutOfBoundsException e) {
				continue;
			}
		}
		System.out.println("Multimap------------------->" + multimap);
		HashMap<String, String> hm = new HashMap<String, String>();
		for (String string : multimap.get(email)) {
			if (string.contains("-")) {
				String temp[] = string.split("-");
				hm.put(temp[0], temp[1]);
			}
		}
		System.out.println("Hash Map------------------->" + hm);
		String temp[] = cers.split(",");

		for (String string : temp) {
			signature += hm.get(string) + ",";
		}
		System.out.println("Final Signature is------------->"
				+ signature.substring(0, signature.length() - 1));

		return signature;
	}

	// public static void main(String[] args) throws Exception {
	// getQrDetails("nitish@gmail.com", "PAN Card,Aadhar Card,SSLC");
	// }

}
