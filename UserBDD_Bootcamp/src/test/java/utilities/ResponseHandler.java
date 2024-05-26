package utilities;

//import java.io.IOException;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pojos.UserPojo;



//import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
//import com.fasterxml.jackson.databind.DeserializationFeature;
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.fasterxml.jackson.databind.introspect.VisibilityChecker;

import io.restassured.response.Response;


//public class ResponseHandler {

//	@SuppressWarnings("unchecked")
//	public static <T> T  deserializedResponse(Response response, Class T ){
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//		mapper.setVisibility(VisibilityChecker.Std.defaultInstance().withFieldVisibility(Visibility.ANY));
//		T responseDeserialized = null;
//		try {
//			responseDeserialized = (T) mapper.readValue(response.asString(), T);
//			String jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(responseDeserialized); // Pretty print JSON
//			System.out.println("Handling Response: \n"+responseDeserialized.toString());
//		} catch (IOException e) {
//			e.printStackTrace(System.out);
//		}
//		return responseDeserialized;
//	}
	
	public class ResponseHandler {
		static String jsonStr;
	    private final static ObjectMapper mapper = new ObjectMapper();   
		
		@SuppressWarnings("unchecked")
		public static <T>T toObject(Response response, Class T){
	        T t = null;
	        
	        try {
				t = (T) mapper.readValue(response.asString(), T);
				jsonStr = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(t);
				System.out.println("Handling Response: \n"+ t.toString());
			} catch (Exception e) {				
				e.printStackTrace();
			}
	        return t;
	    }
	}

//}



