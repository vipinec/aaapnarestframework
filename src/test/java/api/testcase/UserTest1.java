package api.testcase;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.AssertJUnit;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoint.UserEndPoint;
import api.endpoint.UserEndPoint1;
import api.payload.User;
import io.restassured.response.Response;

public class UserTest1 {
	
	 // Initialize Log4j2 logger
    private static final Logger logger = LogManager.getLogger(UserTest.class);


    Faker faker;
    User userpayload;

    @BeforeClass
    public void generateTestData() {
    	
        faker = new Faker();
        
        userpayload = new User();
        
        userpayload.setId(faker.idNumber().hashCode());
        userpayload.setUsername(faker.name().username());
        userpayload.setFirstName(faker.name().firstName());
        userpayload.setLastName(faker.name().lastName());
        userpayload.setEmail(faker.internet().safeEmailAddress());
        userpayload.setPassword(faker.internet().password(5, 10));
        userpayload.setPhone(faker.phoneNumber().cellPhone());
    }
    

    @Test(priority = 1)
    public void testCreateUser() {
    	
        logger.info("create API test for endpoint...");

        Response response = UserEndPoint1.createUser(userpayload);
        response.then().log().all();
        
        AssertJUnit.assertEquals(response.statusCode(), 200);
       // Assert.assertEquals(response.getStatusCode(), 200);
        
        logger.debug("Response: " + response);

        
        logger.info("Test completed successfully.");

    }

    @Test(priority = 2)
    public void getUserData() {
    	
    	
        logger.info("getuser API test for user get...");

        Response response = UserEndPoint1.readUser(this.userpayload.getUsername());
        response.then().log().all();
        AssertJUnit.assertEquals(response.getStatusCode(), 200);
        logger.debug("Response: " + response);

        
        logger.info("Test completed successfully.......");

    }

    @Test(priority = 3)
    public void updateUser() {
    	
    	
        logger.info("updare user API test for 3rd case...");

    	
        userpayload.setFirstName(faker.name().firstName()); 
        // Update firstName
        Response response = UserEndPoint1.updatUser(this.userpayload.getUsername(), userpayload);
        response.then().log().all();
       
        AssertJUnit.assertEquals(response.getStatusCode(), 200);
        
        logger.debug("Response: " + response);

        
        logger.info("Test completed successfully.");

    }

    @Test(priority = 4)
    public void deleteUser() {
    	
        logger.info("delete user API test for 4th case...");

        Response response = UserEndPoint1.deleteUser(this.userpayload.getUsername());
        response.then().log().all();
        AssertJUnit.assertEquals(response.getStatusCode(), 200);
        
        logger.debug("Response: " + response);

        
        logger.info("Test completed successfully.");

    }
}


