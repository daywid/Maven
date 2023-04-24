import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class teste_gson {

	public static void main(String[] args) {
		String jsonString = "{\"name\":\"Mahesh\", \"age\":21}"; 
	      
	      GsonBuilder builder = new GsonBuilder(); 
	      builder.setPrettyPrinting(); 
	      
	      Gson gson = builder.create(); 
	      student student = gson.fromJson(jsonString, student.class); 
	      System.out.println(student);    
	      
	      jsonString = gson.toJson(student); 
	      System.out.println(jsonString); 
	}

}
