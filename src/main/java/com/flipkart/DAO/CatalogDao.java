package com.flipkart.DAO;

import java.util.List;

import com.flipkart.exceptions.CourseNotFoundException;
import com.flipkart.model.Catalog;
import com.flipkart.model.Course;

public interface CatalogDao {

	//View Catalog
	public List<Course> viewCatalog();

	//Add Course in Course List
	void addCourse(Catalog catalog);

	//Delete Course from Course List
	void deleteCourse(int cId) throws CourseNotFoundException;
	
}
