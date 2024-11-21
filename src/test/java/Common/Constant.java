package Common;

public final class Constant {
	// Define general information to access test application
	public static final String BASE_URL		 			= "http://localhost:3000/";
	
	// User name and password to access website
	public static final String BASE_EMAIL				= "duong@gmail.com";
	public static final String BASE_PASSWORD			= "Abcd1234";
	
	public static final String BASE_EMAIL_ADMIN			= "admin@gmail.com";
	public static final String BASE_PASSWORD_ADMIN		= "123456";
	
	// Define string
	public static final String NULL_STRING				= "NULL";
	public static final String TITLE_STRING 			= "[TITLE]";
	
	// Define path
	public static final String IMAGES_PATH				= System.getProperty("user.dir") + "\\src\\test\\resources\\images\\";
	
	// Define timeout
	public static final double WAIT_INTERVAL 			= 1.5; 
	public static final int WAIT_ELEMENT_EXIST 			= 5;
	public static final int WAIT_ELEMENT_NOT_EXIST 		= 5;
	public static final double WAIT_REFRESH_SCREEN 		= 3.5;

	// Define threshold
	public static final double SIMILITY_THRESHOLD 		= 0.99;
	
	// Define browser
	public static final String IE_BROWSER 		= "IE";
	public static final String EDGE_BROWSER 	= "Edge";
	public static final String CHROME_BROWSER 	= "Chrome";
	public static final String FIREFOX_BROWSER 	= "FireFox";
	public static final String MSEDGE_BROWSER 	= "MSEdge";
}
