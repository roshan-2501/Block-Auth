package controller;


import java.util.ArrayList;
import java.util.List;

public class UrlCall {
	
	public static String FACE_VERIFY = "http://10.0.0.112:5001/";
	public static String FACE_UPLOAD = "http://10.0.0.112:5001/register";
	public static String EYE_VERIFY = "http://10.0.0.42:8000/result/";
	public static String EYE_UPLOAD = "http://10.0.0.42:8000/upload/";
	
	public static List<String> pages = new ArrayList<String>(); 
}
