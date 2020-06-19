package com.flipkart.DAO;

import com.flipkart.model.Admin;
import com.flipkart.model.Catalog;
import com.flipkart.model.User;

public interface AdminDao {

	//Delete User
	void deleteUser(int id);


	//Register Admin
	void register(Admin admin);

}
