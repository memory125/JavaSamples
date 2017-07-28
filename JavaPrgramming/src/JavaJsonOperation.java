import java.io.*;
import com.google.gson.*;

public class JavaJsonOperation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String JsonContext = ReadFile(".\\Test.json");
	
		JsonParser jsonParser = new JsonParser();
		JsonElement jsonEle = jsonParser.parse(JsonContext);
		JsonObject jsonObj = jsonEle.getAsJsonObject();
		
		
		System.out.println("Element: " + jsonEle.toString() + " Object: " + jsonObj.toString());  
        
		int size = jsonObj.size();  
        System.out.println("Size: " + size);  
     	System.out.println("name=" + jsonObj.get("name"));            
              
         
	}
	
	 public static String ReadFile(String Path){  
	        BufferedReader reader = null;  
	        String laststr = "";  
	        try{  
	            FileInputStream fileInputStream = new FileInputStream(Path);  
	            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");  
	            reader = new BufferedReader(inputStreamReader);  
	            String tempString = null;  
	            while((tempString = reader.readLine()) != null){  
	                laststr += tempString;  
	            }  
	            reader.close();  
	        }catch(IOException e){  
	            e.printStackTrace();  
	        }finally{  
	            if(reader != null){  
	                try {  
	                    reader.close();  
	                } catch (IOException e) {  
	                    e.printStackTrace();  
	                }  
	            }  
	        }  
	        return laststr;  
	    } 

}
