package org.omrcucumber;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.base.BaseClass;
import org.omrcucumber.EndPoint;
import org.pojo.AddAddress_Output_Pojo;
import org.pojo.Add_Address_Input_Pojo;
import org.pojo.DeletAddress_Input_Pojo;
import org.pojo.GetAdress_OutPut_Pojo;
import org.pojo.Login_Output_Pojo;
import org.pojo.Update_Input_Pojo;
import org.pojo.Update_Output_Poja;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class StepDefinition extends BaseClass{
	Response response;
	static String logtoken;
	static int address_id;
	@Given("User add Headers Key {string} , Value {string}")
	public void user_add_Headers_Key_Value(String key, String value) {
	    header(key, value);
	    
	}

	@When("User add Authorization body for login Endpoint")
	public void user_add_request_body_for_login_Endpoint() throws IOException {
		basicAuth(getPropertyValue("username"), getPropertyValue("password"));
	    
	}

	@When("User sent POST Request for login and its Endpoint")
	public void user_sent_POST_Request_for_login_and_its_Endpoint() {
		 response = methodType("POST", EndPoint.LOGIN);
	    
	}

	@Then("User verify the response code {int}")
	public void user_verify_the_response_code(int int1) {
	    int statusCode = response.getStatusCode();
	    System.out.println(statusCode);
	    Assert.assertEquals(statusCode, int1, "verify Status code");
	    
	    
	}

	@Then("User verify the Message {string}")
	public void user_verify_the_Message(String expected) {
		Login_Output_Pojo login_Output_Pojo = response.as(Login_Output_Pojo.class);
		logtoken = login_Output_Pojo.getData().getLogtoken();
		System.out.println(logtoken);
		 String message = login_Output_Pojo.getMessage();
			Assert.assertEquals(message, expected, "verify role");
	    
	}

	@Given("User add Headers Key {string} , Value {string} and Token Header")
	public void user_add_Headers_Key_Value_and_Token_Header(String key, String value) {
		List<Header> h = new ArrayList<>();
		Header h1 = new Header(key, value);
		Header h2 = new Header("Authorization", "Bearer " + logtoken);
		h.add(h1);
		h.add(h2);
		headers(h);
	    
	}

	@When("User add request body for Add User Address Endpoint")
	public void user_add_request_body_for_Add_User_Address_Endpoint() {
		Add_Address_Input_Pojo add_Address_Input_Pojo = new Add_Address_Input_Pojo("Mohan", "Krish", "7845698736",
				"mullai", 2, 3, 1, "636002", "chennai", "Work");
		body(add_Address_Input_Pojo);
	    
	}

	@When("User sent POST Request for add address and its Endpoint")
	public void user_sent_POST_Request_for_add_address_and_its_Endpoint() {
		response = methodType("POST", EndPoint.ADD_ADDRESS);
	    
	}

	@Then("User verify the Message {string} and get Order Id")
	public void user_verify_the_Message_and_get_Order_Id(String expected) {
		AddAddress_Output_Pojo addAddress_Output_Pojo = response.as(AddAddress_Output_Pojo.class);

		  address_id = addAddress_Output_Pojo.getAddress_id();
		 System.out.println(address_id);
		 
		 String message = addAddress_Output_Pojo.getMessage();
		 System.out.println(message);
		 Assert.assertEquals(message, expected, "Verify address updated");
	}

	@When("User add request body for Update User Address Endpoint")
	public void user_add_request_body_for_Update_User_Address_Endpoint() {
		Update_Input_Pojo update_Input_Pojo = new Update_Input_Pojo(String.valueOf(address_id), "Mohan", "Krish", "7708815544", "apartment",
				33, 3378, 101, "636007", "64/63 partap nagar", "office");
		body(update_Input_Pojo);
	    
	}

	@When("User sent PUT Request for Update address and its Endpoint")
	public void user_sent_PUT_Request_for_Update_address_and_its_Endpoint() {
		response = methodType("PUT", EndPoint.UPDATE_ADDRESS);
	    
	}

	@Then("User verify the Message {string} for Confirmation")
	public void user_verify_the_Message_for_Confirmation(String expected) {
		Update_Output_Poja update_Output_Poja = response.as(Update_Output_Poja.class);
		String message = update_Output_Poja.getMessage();
		System.out.println(message);
		Assert.assertEquals(message,expected , "Verify address updated");
	    
	}

	@When("User sent GET Request for Update  address and its Endpoint")
	public void user_sent_GET_Request_for_Update_address_and_its_Endpoint() {
		response = methodType("GET", EndPoint.GET_ADDRESS);
	    
	}

	@Then("User verify the Message {string} for Confirmation of Get Address")
	public void user_verify_the_Message_for_Confirmation_of_Get_Address(String expected) {
		GetAdress_OutPut_Pojo getAdress_OutPut_Pojo = response.as(GetAdress_OutPut_Pojo.class);
		String message = getAdress_OutPut_Pojo.getMessage();
		System.out.println(message);
		Assert.assertEquals(message,expected , "Verify ok");
	    
	}

	@When("User add request body for Delete User Address Endpoint")
	public void user_add_request_body_for_Delete_User_Address_Endpoint() {
		DeletAddress_Input_Pojo deletAddress_Input_Pojo = new DeletAddress_Input_Pojo(String.valueOf(address_id));
		body(deletAddress_Input_Pojo);
	    
	}

	@When("User sent DELETE Request for Delete address and its Endpoint")
	public void user_sent_DELETE_Request_for_Delete_address_and_its_Endpoint() {
		 response = methodType("DELETE", EndPoint.DELETE_ADDRESS);
	    
	}

	@Then("User verify the Message {string} for Confirmation of Delete Address")
	public void user_verify_the_Message_for_Confirmation_of_Delete_Address(String expected) {
		Update_Output_Poja update_Output_Poja = response.as(Update_Output_Poja.class);
		String message = update_Output_Poja.getMessage();
		System.out.println(message);
		Assert.assertEquals(message,expected , "Verify ok");
	    
	}


}
