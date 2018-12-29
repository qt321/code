package com.qt.user.dao;

//import java.sql.Connection;
//import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.qt.file.FilePropertiesUtils;
import com.qt.model.Menu;
import com.qt.model.Role;
import com.qt.model.StuAndRole;

public interface DB
{
	public List queryRoleData();
	
	public List queryRoleGroupCount();
	
	public String queryStuAndkmCount(String stuName);
	
	public int checkUserLogin(String name,String pwd);
	
	public List<Menu> queryMenuData();
	
	public List queryClassToStuCount();
	
	List queryNameCount();
//	static String urlimg="";
//	
//	static
//	{
//		urlimg=FilePropertiesUtils.getImageUtilPath();
//	}
//	
//	private Connection conn;
//	
//	public DB()
//	{
//		try
//		{
//			Class.forName("com.mysql.jdbc.Driver");
//			
//			conn=DriverManager.getConnection
//					("jdbc:mysql://127.0.0.1:3306/thzmdb2?user=root&password=&useUnicode=true&characterEncoding=UTF8");
//		
//		} catch (ClassNotFoundException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (SQLException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public List queryRoleData()
//	{
//		String sql="SELECT * FROM t_role";
//		
//		List<Role> lists=new ArrayList<Role>();
//		
//		try
//		{
//			PreparedStatement pstmt=conn.prepareStatement(sql);
//		
//			ResultSet rs=pstmt.executeQuery();
//			
//			while(rs.next())
//			{
//				Role role=new Role();
//				role.setRid(rs.getInt(1));
//				role.setRname(rs.getString(2));
//				
//				lists.add(role);
//			}
//		} catch (SQLException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		finally
//		{
//			if(null!=conn)
//			{
//				try
//				{
//					conn.close();
//				} catch (SQLException e)
//				{
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		return lists;
//	}
//	
//	public List queryRoleGroupCount()
//	{
//		String sql="SELECT  rname,COUNT(sjob)    FROM  t_stus  RIGHT  JOIN  t_role ON sjob=rid  GROUP BY  rname";
//		
//		List<StuAndRole> lists=new ArrayList<StuAndRole>();
//		
//		try
//		{
//			PreparedStatement pstmt=conn.prepareStatement(sql);
//		
//			ResultSet rs=pstmt.executeQuery();
//			
//			while(rs.next())
//			{
//				StuAndRole crole=new StuAndRole();
//				
//				crole.setRname(rs.getString(1));
//				
//				crole.setRcount(rs.getInt(2));
//			}
//		} catch (SQLException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		finally 
//		{
//			if(null!=conn)
//			{
//				try
//				{
//					conn.close();
//				} catch (SQLException e)
//				{
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		return lists;
//		
//	}
//	
//	public String queryStuAndkmCount(String stuName)
//	{
//		String sql="SELECT COUNT(kid),sname  FROM (SELECT   * FROM  t_stus  WHERE  sname='ÕÅÉ½') tmp INNER  JOIN  t_score  ON tmp.sid=t_score.sid  GROUP  BY sname";
//		
//		String data="";
//		
//		
//		try
//		{
//			PreparedStatement pstmt=conn.prepareStatement(sql);
//		
//			pstmt.setString(1, stuName);
//			
//			ResultSet rs=pstmt.executeQuery();
//			
//			while(rs.next())
//			{
//				data=rs.getInt(1)+","+rs.getString(2);
//			}
//		} catch (SQLException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} 
//		
//		finally
//		{
//			if(null!=conn)
//			{
//				try
//				{
//					conn.close();
//				} catch (SQLException e)
//				{
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		return data;
//	}
//	
//	public int checkUserLogin(String name,String pwd)
//	{
//		System.out.println(name+","+pwd);
//		String sql="SELECT  COUNT(*) FROM  t_stus  WHERE sname=? AND  spwd=?";
//		
//		
//		PreparedStatement pstmt=null;
//		
//		
//		
//		try
//		{
//			pstmt=conn.prepareStatement(sql);
//			pstmt.setString(1, name);
//			pstmt.setString(2, pwd);
//			
//			ResultSet rs=pstmt.executeQuery();
//			
//			while(rs.next())
//			{
//				System.out.println("------------------------>"+rs.getInt(1));
//				 return rs.getInt(1);
//				
//			}
//		} catch (SQLException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		finally
//		{
//			if(null!=conn)
//			{
//				try
//				{
//					conn.close();
//				} catch (SQLException e)
//				{
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		}
//		return 0;
//	
//		
//	}
//	
//	public List<Menu> queryMenuData()
//	{
//		String sql="SELECT * FROM t_menu";
//		
//		List<Menu> listMenu=new ArrayList<Menu>();
//		
//		try
//		{
//			PreparedStatement pstmt=conn.prepareStatement(sql);
//		
//			ResultSet rs=pstmt.executeQuery();
//			
//			while(rs.next())
//			{
//				Menu m=new Menu();
//				m.setTid(rs.getInt(1));
//				m.setTname(rs.getString(2));
//				m.setTurl(rs.getString(3));
//				m.setImgpath(urlimg+rs.getString(5));
//				
//				listMenu.add(m);
//				
//			}
//		} catch (SQLException e)
//		{
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		finally
//		{
//			if(null!=conn)
//			{
//				try
//				{
//					conn.close();
//				} catch (SQLException e)
//				{
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//	}
//		return listMenu;
//	
//	
//}

	
}
