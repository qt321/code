package com.qt.user.service.interfaces;

import javax.jws.WebMethod;
import javax.jws.WebService;


@WebService(targetNamespace="http://thzm.com/wsdl")
public interface IUserService
{
	@WebMethod
	public String queryRoleData();
	
	
	// �ҳ�ѧ�������ְ���ѧ��������ְ������
	@WebMethod
	public String queryStuAndkmCount(String name);

	//ѧ����ѧ�γ̵�����
	@WebMethod
	public String queryGroupByRoleCount();
	
	@WebMethod
	public String checkUserLogin(String username,String pwd);
	
	@WebMethod
	
	public String queryGirdMenuData();
	
	//��ѯÿ���༶��ѧ��������
	@WebMethod
	public  String  queryClassToStuCount();
		
		
	//ѧ�����ϵĲ��� 
	@WebMethod
	public  String   queryNameCount();


	
}
