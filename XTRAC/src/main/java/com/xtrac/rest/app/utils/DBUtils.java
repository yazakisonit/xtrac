package com.xtrac.rest.app.utils;
import java.sql.*;
public class DBUtils {

	public static Connection getConnection() throws Exception {

		// final String url = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1";
		String url = "jdbc:mysql://localhost:3306/xtrac";   //database specific url
		String user     = "root";
		String password = "";

		Class.forName("com.mysql.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, user, password);
		// connection.setAutoCommit(true);
		return connection;
	}

	public static String insertLogin(String emailId, String firstName, String lastName, String telephoneNumber) throws Exception {

		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		int telNo = Integer.parseInt(telephoneNumber);

		String sql = "INSERT INTO DEVELOPER VALUES('"+emailId+"', '" + firstName + "', '" + lastName + "' , " + telNo + ")";
		int status = statement.executeUpdate(sql);
		statement.close();
		connection.close();

		if(status==0){
			return "fail";
		}

		return "success";
	}

	public static String searchDeveloperInfo(String emailId) throws Exception {

		String fname = null;
		String lname = null;
		String telno = null;

		Connection connection = getConnection();
		Statement statement = connection.createStatement();

		String sql = "SELECT EMAIL_ID, FIRST_NAME, LAST_NAME, TELEPHONE_NO FROM DEVELOPER WHERE EMAIL_ID = '" + emailId  + "'";
		ResultSet resultSet = statement.executeQuery(sql);

		while(resultSet.next()) {
			fname = resultSet.getString("FIRST_NAME");
			lname = resultSet.getString("LAST_NAME");
			telno = resultSet.getString("TELEPHONE_NO");
		}

		resultSet.close();
		statement.close();
		connection.close();

		return "{"
		+ "firstName: "+ fname 
		+ "lastName: "+ lname
		+ "telephone number: "+ telno +
		"}";
	}

	public static String updateDeveloperInfo(String emailId, String firstName, String lastName, String telephoneNumber) throws Exception {

		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		int telNo = Integer.parseInt(telephoneNumber);

		String sql = " UPDATE DEVELOPER SET FIRST_NAME = '" + firstName + "', LAST_NAME = '" + lastName + "' , TELEPHONE_NO = " + telNo + 
				" WHERE EMAIL_ID = '" + emailId + "'";
		int status = statement.executeUpdate(sql);
		statement.close();
		connection.close();

		if(status==0){
			return "fail";
		}
		return "success";
	}

	public static String deleteDeveloperInfo(String emailId) throws Exception {

		Connection connection = getConnection();
		Statement statement = connection.createStatement();

		String sql = " DELETE FROM DEVELOPER WHERE EMAIL_ID = '" + emailId  + "'";
		int status = statement.executeUpdate(sql);
		statement.close();
		connection.close();

		if(status==0){
			return "fail";
		}
		return "success";
	}

	public static int registerApp(String emailId, String appName, String appDesc) throws Exception {

		Connection connection = getConnection();
		Statement statement = connection.createStatement();
		int regId = -1;

		int app_id = Util.randomNoGeneration();
		String app_secret = Util.randomPwdGeneration();
		String sql = "INSERT INTO REGISTRATION(EMAIL_ID, APP_NAME, APP_DESC, APP_ID, APP_SECRET) "
				+ " VALUES('"+emailId+"', '"+ appName +"', '"+appDesc+"', " + app_id +",'"+app_secret+"')";
		int status = statement.executeUpdate(sql);

		String sqlForRegId = "SELECT REG_ID FROM REGISTRATION "
				+ " WHERE EMAIL_ID = '" + emailId  + "' AND APP_NAME = '" + appName +"' AND APP_DESC = '" + appDesc + "' "
						+ "AND APP_ID = " + app_id + " AND APP_SECRET = '" + app_secret + "'";
		ResultSet resultSet = statement.executeQuery(sqlForRegId);

		while(resultSet.next()) {
			regId = resultSet.getInt("REG_ID");
		}

		resultSet.close();
		statement.close();
		connection.close();

		return regId;
	}
	
	public static String searchAppList(String emailId) throws Exception {
		String appName = null;
		String appId = null;
		String finalList = "";

		Connection connection = getConnection();
		Statement statement = connection.createStatement();

		String sql = "SELECT APP_NAME, APP_ID FROM REGISTRATION WHERE EMAIL_ID = '" + emailId  + "'";
		ResultSet resultSet = statement.executeQuery(sql);

		while(resultSet.next()) {
			appName = resultSet.getString("APP_NAME");
			appId = resultSet.getString("APP_ID");
			finalList += "App Name : " + appName + " App Id : " + appId + " | ";
		}

		resultSet.close();
		statement.close();
		connection.close();

		return finalList;
	}
}