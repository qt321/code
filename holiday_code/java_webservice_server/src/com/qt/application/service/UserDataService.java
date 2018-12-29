package com.qt.application.service;

import javax.jws.soap.SOAPBinding;
import javax.xml.ws.Endpoint;

import com.qt.user.service.impl.UserServiceImpl;

@SOAPBinding(style=SOAPBinding.Style.RPC)
public class UserDataService
{
	public static void main(String[] args)
	{
		System.out.println("webservice is start-----");
		
		Endpoint.publish("http://127.0.0.1:8070/userdataservice/user", new UserServiceImpl());
		
		System.out.println("UserDataService 发布成功----");
	}

}
