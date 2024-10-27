package api.endpoint;

import api.payload.User;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class UserEndPoint {

	
	 // POST (create) user data
    public static Response createUser(User payload) {
        Response response = given()
        	.contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .body(payload)    // Send payload in POST body
            .when()
            .post(Routes.post_url);   // POST request doesn't need username in the URL
             return response;
    }

    // GET user data
    public static Response readUser(String userName) {
        Response response = given()
            .accept(ContentType.JSON)
            .pathParam("username", userName)    // Path parameter for GET
            .when()
            .get(Routes.get_url);   // Use the GET route
        return response;
    }

    // PUT (update) user data
    public static Response updatUser(String userName, User payload) {
        Response response = given()
            .contentType(ContentType.JSON)
            .accept(ContentType.JSON)
            .pathParam("username", userName)    // Path parameter for PUT
            .body(payload)    // Pass the payload for the update
            .when()
            .put(Routes.update_url);
        return response;
    }

    // DELETE user
    public static Response deleteUser(String userName) {
        Response response = given()
            .pathParam("username", userName)    // Path parameter for DELETE
            .when()
            .delete(Routes.delete_url);   // Use the DELETE route
        return response;
    }




	}



