package RestAssu;

import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class ReusableMethod {
	
	public XmlPath XMLPaths(Response res)
	{
		String resp = res.asString();
		XmlPath x = new XmlPath(resp);
		return x;
		
		
	}
	
	public static JsonPath JsonPaths(Response res)
	{
		String resp = res.asString();
		JsonPath jp = new JsonPath(resp);
		//System.out.println(resp);
		return jp;
		
	}


}
