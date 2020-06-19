package com.flipkart.DAO;

import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.flipkart.model.Catalog;
import com.flipkart.model.Course;
import com.flipkart.model.Student;

import org.apache.log4j.Logger;

import com.flipkart.constants.SQLConstantsQuery;
import com.flipkart.exceptions.CourseNotFoundException;
import com.flipkart.utils.DBUtil;

public class CatalogDaoImpl implements CatalogDao {
	
	private static Logger logger= Logger.getLogger(CatalogDaoImpl.class);
	
	
	//View Catalog
	@Override
	public List<Course> viewCatalog() {
		List <Course> courseList=new ArrayList<>();
		Connection connect=DBUtil.getConnection();
		try {
			
			String sql=SQLConstantsQuery.VIEW_CATALOG;
			PreparedStatement stmt = connect.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){					
		     int courseId= rs.getInt("courseId");
			 String courseName = rs.getString("courseName");
	         Course course=new Course();
	         course.courseId=courseId;
	         course.courseName=courseName;
	         courseList.add(course);
	         }
			
	       return courseList;
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		return null;
		
	}
	
	//Add Course in Course List
	@Override
	public void addCourse(Catalog catalog) {
		Connection connect=DBUtil.getConnection();
		try {
			String sql=SQLConstantsQuery.ADD_COURSE;
			PreparedStatement stmt = connect.prepareStatement(sql);
			stmt.setInt(1, catalog.getCourseId());
			stmt.setString(2, catalog.getCourseName());
			stmt.setInt(3, catalog.getFee());
			stmt.setInt(4, 1);
			stmt.executeUpdate();
			return;
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}	
		
		
		
	}

	//Delete Course from Course List
	@Override
	public void deleteCourse(int cId) throws CourseNotFoundException {
		Connection connect=DBUtil.getConnection();
		try {
			
			String sql = SQLConstantsQuery.DELETE_COURSE;
			PreparedStatement stmt = connect.prepareStatement(sql);
			stmt.setInt(1, cId);
			int row=stmt.executeUpdate();
			if(row==0)
				throw new CourseNotFoundException();
			return;
			
		} catch (SQLException e) {
			logger.error(e.getMessage());
		}
		
		
	}
	


	




}
