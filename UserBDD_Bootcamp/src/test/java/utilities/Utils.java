package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Properties;
import io.restassured.authentication.BasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

public class Utils {
	
public static RequestSpecification requestSpec;
public static ResponseSpecification responseSpec;	
    
	
	public RequestSpecification requestSpecification() throws IOException {  

		if(requestSpec == null) 
		{
			BasicAuthScheme basicAuth = new BasicAuthScheme();
			basicAuth.setUserName(PropertiesFile.getProperty("username"));
			basicAuth.setPassword(PropertiesFile.getProperty("password"));
			PrintStream log = new PrintStream(new FileOutputStream("logging.txt"));
			requestSpec = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl"))
				    .setAuth(basicAuth)
					.addFilter(RequestLoggingFilter.logRequestTo(log))
					.addFilter(ResponseLoggingFilter.logResponseTo(log))
					.setContentType(ContentType.JSON)
					.build();
			return requestSpec;
		}		
		return requestSpec;
	}
	public static  RequestSpecification requestSpecification1() throws IOException { 		  
		requestSpec = new RequestSpecBuilder().setBaseUri(getGlobalValue("baseUrl")).build();
		   return requestSpec;
	 }
	
	
	public static String getGlobalValue(String key) throws IOException {
		
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("C:\\Users\\rajas\\eclipse-workspace\\UserBDD_Bootcamp\\src\\test\\resources\\global.properties");
		prop.load(fis);
		return prop.getProperty(key);
		
	}

	public static String getJsonPath(Response response,String key) {
		String str = response.asString();
		JsonPath js = new JsonPath(str);
		return js.get(key).toString();
	}

}
