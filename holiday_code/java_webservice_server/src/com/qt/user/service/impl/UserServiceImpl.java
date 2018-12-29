package com.qt.user.service.impl;

import java.util.List;

import javax.jws.WebService;

import com.qt.model.Data;
import com.qt.model.Menu;
import com.qt.model.Role;
import com.qt.model.StuAndRole;
import com.qt.user.dao.DB;
import com.qt.user.dao.DBMysql;
import com.qt.user.service.interfaces.IUserService;
import com.sun.xml.internal.bind.v2.runtime.Name;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@WebService(portName="userservice",
serviceName="UserServiceImpl",
targetNamespace="http://thzm.com/wsdl",
endpointInterface="com.qt.user.service.interfaces.IUserService")
public  class UserServiceImpl implements IUserService
{
	@Override
	public String queryRoleData() {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl  is queryRoleData  start...  ");

		DBMysql dbm=new DBMysql();

		List<Role> lists = dbm.queryRoleData();

		System.out.println("--->" + lists.size());

		// webservice发布的数据应该是各个平台和语言统一能够解析的数据格式:
		// json [{},{},{}]

		JSONArray array = new JSONArray();
		for (Role role : lists) {

			JSONObject obj = new JSONObject();
			obj.put("id", role.getRid());
			obj.put("rname", role.getRname());
			array.add(obj);
		}
		System.out.println("JSON-->" + array.toString());

		return array.toString();
	}

	@Override
	public String queryGroupByRoleCount() {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl  is queryGroupByRoleCount  start...  ");
		
		DBMysql dbm=new DBMysql();
		
		List<StuAndRole> lists = dbm.queryRoleGroupCount();

		System.out.println("--->" + lists.size());
		JSONArray array = new JSONArray();
		for (StuAndRole crole : lists) {

			JSONObject obj = new JSONObject();
			obj.put("rname", crole.getRname());
			obj.put("rcount", crole.getRcount());
			array.add(obj);
		}
		System.out.println("JSON-->" + array.toString());

		return array.toString();
	}

	@Override
	public String queryStuAndkmCount(String name) {
		// TODO Auto-generated method stub
		System.out.println("UserServiceImpl  is queryGroupByRoleCount  start...  ");
		
		DBMysql dbm=new DBMysql();
		
		String  data=dbm.queryStuAndkmCount(name);
		
		System.out.println("data-->"+data);
		return data;
	}

	@Override
	public String checkUserLogin(String username, String pwd) {
		// TODO Auto-generated method stub
		DBMysql dbm=new DBMysql();
		
		System.out.println("UserServiceImpl  is checkUserLogin  start...  ");
		
		System.out.println(username+","+pwd);
		
		int count=dbm.checkUserLogin(username,pwd);
		System.out.println("count"+count);
		
		if(count>0)
		{
			return "登录成功";
		}
		return "登录失败";
	}
	
	@Override
	public String queryGirdMenuData()
	{
		System.out.println("UserServiceImpl  is queryGirdMenuData  start...  ");
	
		DBMysql dbm=new DBMysql();
		
		List<Menu> lists=dbm.queryMenuData();
		
		String strJson=com.alibaba.fastjson.JSONArray.toJSONString(lists);
	
		System.out.println("strJson-->" + strJson);

		return strJson;
	}
	@Override
	public String queryClassToStuCount()
	{
		System.out.println("UserServiceImpl  is queryClassToStuCount  start...  ");
	
		DBMysql dbm=new DBMysql();
		
		List<Data> lists=dbm.queryClassToStuCount();
		
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);
		
		System.out.println("List<Data>-->strJson-->" + strJson);
		return strJson;

	}
	@Override
	public String queryNameCount() {
		// TODO Auto-generated method stub
		System.out
		.println("UserServiceImpl  is queryNameCount  start...  ");

       DBMysql db = new DBMysql();
 
		List<Data> lists = db.queryNameCount();
		String strJson = com.alibaba.fastjson.JSONArray.toJSONString(lists);

		System.out.println("List<Data>Name-->strJson-->" + strJson);
		return strJson;
	}


}
