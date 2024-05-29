package com.krishna.dao;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class FilePost {
	public void postFiles(String fileName, InputStream fileContent) throws ClassNotFoundException, SQLException {
		Filedb fdb=new Filedb();

	Class.forName("com.mysql.cj.jdbc.Driver");
	Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/practice","root","KrishnaMySQL@5317");
    PreparedStatement statement = connection.prepareStatement("INSERT INTO files (name, content) VALUES (?, ?)");
	statement.setString(1, fileName);
    statement.setBinaryStream(2, fileContent);

   
    statement.executeUpdate();
	

}
}
