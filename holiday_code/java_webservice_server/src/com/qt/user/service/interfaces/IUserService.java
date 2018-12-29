package com.qt.user.service.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(targetNamespace="http://thzm.com/wsdl")
public interface IUserService
{
	@WebMethod
	public String queryRoleData();
	
	
	// 找出学生表各个职务的学生数量和职务名称
	@WebMethod
	public String queryStuAndkmCount(String name);

	//学生所学课程的数量
	@WebMethod
	public String queryGroupByRoleCount();
	
	@WebMethod
	public String checkUserLogin(String username,String pwd);
	
	@WebMethod
	
	public String queryGirdMenuData();
	
	//查询每个班级的学生的数量
	@WebMethod
	public  String  queryClassToStuCount();
		
		
	//学生姓氏的部分 
	@WebMethod
	public  String   queryNameCount();


	
}
