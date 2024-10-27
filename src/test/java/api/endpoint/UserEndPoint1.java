package api.endpoint;


import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

import java.util.ResourceBundle;

public class UserEndPoint1 {

	// created method for getting URL'S FROM FILES
	
	static ResourceBundle getURL() {
	
		// create a object for reading file from property file
		
	ResourceBundle routesproperty1 = ResourceBundle.getBundle("routesproperty");  // load property file
	
	return routesproperty1;
	
	}
	
	 // POST (create) user data
    public static Response createUser(User payload) {
    	
    	String posturl= getURL().getString("post_url_propertyfile");
    	
        Response response = given()
        	.contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)    // Send payload in POST body
            .when()
            .post(posturl);   // POST request doesn't need username in the URL
             return response;
    }

    // GET user data
    public static Response readUser(String userName) {
    	
    	String geturl= getURL().getString("get_url_ropertyfile");
    	
        Response response = given()
            .accept(ContentType.JSON)
            .pathParam("username", userName)    // Path parameter for GET
            .when()
            .get(geturl);   // Use the GET route
        return response;
    }

    // PUT (update) user data
    public static Response updatUser(String userName, User payload) {
    	
    	String updateurlturl= getURL().getString("update_url_ropertyfile");

    	
    	
        Response response = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .pathParam("username", userName)    // Path parameter for PUT
            .body(payload)    // Pass the payload for the update
            .when()
            .put(updateurlturl);
        return response;
    }

    // DELETE user
    public static Response deleteUser(String userName) {
    	
    	
    	String deleteurl= getURL().getString("delete_url_ropertyfile");

        Response response = given()
            .pathParam("username", userName)    // Path parameter for DELETE
            .when()
            .delete(deleteurl);   // Use the DELETE route
        return response;
    }




	}



