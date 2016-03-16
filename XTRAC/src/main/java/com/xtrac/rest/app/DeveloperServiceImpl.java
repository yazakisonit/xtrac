package com.xtrac.rest.app;

import javax.ws.rs.core.Response;

import com.xtrac.rest.app.utils.DBUtils;
import com.xtrac.rest.app.utils.Util;

public class DeveloperServiceImpl implements IDeveloperService {

	@Override
	public Response developerSignup(String emailId, String firstName, String lastName, String telephoneNumber) {

		boolean emailCheck = Util.validationEmail(emailId);
		String insertStatus = null;

		System.out.println("emailId >>" + emailId);

		if(!emailCheck) {
			String emailStatus = "Invalid email id !! Please enter email id !!";
			return Response.status(200).entity(emailStatus).build();
		}

		try {
			insertStatus = DBUtils.insertLogin(emailId, firstName, lastName, telephoneNumber);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("***** insertStatus ************* " + insertStatus);

		String developerInfoForSignup = insertStatus;
		return Response.status(200).entity(developerInfoForSignup).build();
	}

	@Override
	public Response developerSearch(String emailId) {

		boolean emailCheck = Util.validationEmail(emailId);
		String searchStatus = null;

		if(!emailCheck) {
			String emailStatus = "Invalid email id !! Please enter email id !!";
			return Response.status(200).entity(emailStatus).build();
		}

		try {
			searchStatus = DBUtils.searchDeveloperInfo(emailId);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("***** searchStatus ************* " + searchStatus);

		String developerInfoUpdate = searchStatus;
		return Response.status(200).entity(developerInfoUpdate).build();
	}

	@Override
	public Response developerDataUpdate(String emailId, String firstName, String lastName, String telephoneNumber) {

		boolean emailCheck = Util.validationEmail(emailId);
		String updateStatus = null;

		if(!emailCheck) {
			String emailStatus = "Invalid email id !! Please enter email id !!";
			return Response.status(200).entity(emailStatus).build();
		}

		try {
			updateStatus = DBUtils.updateDeveloperInfo(emailId, firstName, lastName, telephoneNumber);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("***** updateStatus ************* " + updateStatus);

		String developerInfoUpdate = updateStatus;
		return Response.status(200).entity(developerInfoUpdate).build();
	}

	@Override
	public Response developerDataDelete(String emailId) {

		boolean emailCheck = Util.validationEmail(emailId);
		String deleteStatus = null;

		if(!emailCheck) {
			String emailStatus = "Invalid email id !! Please enter email id !!";
			return Response.status(200).entity(emailStatus).build();
		}

		try {
			deleteStatus = DBUtils.deleteDeveloperInfo(emailId);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("***** deleteStatus ************* " + deleteStatus);

		String developerInfoDelete = deleteStatus;
		return Response.status(200).entity(developerInfoDelete).build();
	}

	@Override
	public Response developerAppRegister(String emailId, String appName, String appDesc) {

		boolean emailCheck = Util.validationEmail(emailId);
		int  registrationStatus = -1;

		if(!emailCheck) {
			String emailStatus = "Invalid email id !! Please enter email id !!";
			return Response.status(200).entity(emailStatus).build();
		}

		try {
			registrationStatus = DBUtils.registerApp(emailId, appName, appDesc);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("***** registrationStatus ************* " + registrationStatus);
		String registrationApprRegisterMsg = String.valueOf(registrationStatus);
		return Response.status(200).entity(registrationApprRegisterMsg).build();
	}

	@Override
	public Response getAppList(String emailId) {
		boolean emailCheck = Util.validationEmail(emailId);
		String searchStatus = null;

		if(!emailCheck) {
			String emailStatus = "Invalid email id !! Please enter email id !!";
			return Response.status(200).entity(emailStatus).build();
		}

		try {
			searchStatus = DBUtils.searchAppList(emailId);
		} 
		catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("***** searchStatus ************* " + searchStatus);

		String appList = searchStatus;
		return Response.status(200).entity(appList).build();
	}
}