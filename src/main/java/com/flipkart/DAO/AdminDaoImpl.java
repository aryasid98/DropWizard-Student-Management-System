package com.flipkart.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.flipkart.constants.SQLConstantsQuery;
import com.flipkart.model.Admin;
import com.flipkart.model.Catalog;
import com.flipkart.model.User;
import com.flipkart.utils.DBUtil;

public class AdminDaoImpl implements AdminDao{
	
	private static Logger logger= Logger.getLogger(AdminDaoImpl.class);


	//Delete user
	@Override
	public void deleteUser(int id) {
		Connection connect=DBUtil.getConnection();
		try {
			
			String sql = SQLConstantsQuery.DELETE_USER;
			//String sql=SQLConstantsQuery.ADD_STUDENT;
			PreparedStatement stmt = connect.prepareStatement(sql);
			stmt.setInt(1, id);
			stmt.executeUpdate();
			return;
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		
	}

	
	//Register admin
	@Override
	public void register(Admin admin) {
		
		Connection connect=DBUtil.getConnection();
		try {
		// TODO Auto-generated method stub
			String sql=SQLConstantsQuery.ADD_ADMIN;
			PreparedStatement stmt = connect.prepareStatement(sql);
			stmt.setInt(1, admin.getAdminId());
			stmt.setString(2, admin.getUsername());
			stmt.setString(3, admin.getName());
			stmt.setString(4, admin.getContactNo());
			stmt.setString(5, admin.getGender());
			stmt.executeUpdate();
			return;
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}	
		
	}



}
