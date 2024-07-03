package com.rest.service;

import java.util.List;

import model.QRPojo;
import service.AuthDao;

public class Sample {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		AuthDao authDao = new AuthDao();
		List<QRPojo> list = authDao.loadRequestsByEmail("nitish@gmail.com");
		if (list.isEmpty()) {
			System.out.println("empty");
		} else {
			for (QRPojo qrPojo : list) {
				System.out.println(qrPojo.getRequestType()+"   "+qrPojo.getStatus());
			}
		}

	}

}
