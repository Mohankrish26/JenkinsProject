package org.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT;

import org.omg.PortableInterceptor.USER_EXCEPTION;

import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;

public class BaseClass {
	RequestSpecification reqSpec;
	Response response;

	public void header(String key, String value) {
		reqSpec = RestAssured.given().header(key, value);

	}

	public void body(String data) {
		reqSpec = reqSpec.body(data);
	}

	public void body(Object data) {
		reqSpec = reqSpec.body(data);
	}

	public void pathParam(String key, String value) {
		reqSpec = reqSpec.pathParam(key, value);
	}

	public void queryParam(String key, String value) {
		reqSpec = reqSpec.queryParam(key, value);
	}
	
	public void headers(List<Header> h) {
Headers headers = new Headers(h);
reqSpec = RestAssured.given().headers(headers);
	}
	
	public String getPropertyValue(String key) throws IOException {
Properties properties = new Properties();
FileInputStream stream = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\Property\\config.properties");
	
properties.load(stream);
String value = (String) properties.get(key);
return value;
	}

	public void basicAuth(String username, String password) {
		reqSpec.auth().preemptive().basic(username, password);
	}

	public Response methodType(String type, String endPoint) {
		switch (type) {
		case "GET":
			response = reqSpec.log().all().get(endPoint);
			break;
		case "POST":
			response = reqSpec.log().all().post(endPoint);
			break;
		case "PUT":
			response = reqSpec.log().all().put(endPoint);
			break;
		case "DELETE":
			response = reqSpec.log().all().delete(endPoint);
			break;

		default:
			break;
		}
		return response;
	}

	public int getStatusCode(Response response) {
		int statusCode = response.getStatusCode();
		return statusCode;

	}

	public ResponseBody getBody(Response response) {
		ResponseBody body = response.getBody();
		return body;
	}

	public String getResponseBodyAsString(Response response) {
		String asString = getBody(response).asString();
		return asString;
	}

	public String getResponseBodyAsPrettyString(Response response) {
		String asPrettyString = getBody(response).asPrettyString();
		return asPrettyString;

	}

	public void jasonPath(Response response, String path) {
		JsonPath jsonPath = response.jsonPath();
		Object obj = jsonPath.get(path);
		String s = (String) obj;
		System.out.println(s);

	}
}
