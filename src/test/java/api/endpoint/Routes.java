package api.endpoint;

public class Routes {
	   
	
	    public static String base_url = "https://petstore.swagger.io/v2";

	    public static String post_url = base_url + "/user";                  // Correct POST URL
	    public static String get_url = base_url + "/user/{username}";         // Username as a path parameter
	    public static String update_url = base_url + "/user/{username}";      // Username as a path parameter
	    public static String delete_url = base_url + "/user/{username}";      // Username as a path parameter
	}

	


