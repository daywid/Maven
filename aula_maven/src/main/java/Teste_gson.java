import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Teste_gson {

	public static void main(String[] args) {
		String jsonString = "{\"name\":\"Mahesh\", \"age\":21}"; 
	      Student s = new Student();
	      GsonBuilder builder = new GsonBuilder(); 
	      builder.setPrettyPrinting(); 
	      Gson gson = builder.create();
	      
	   // Mapear a string JSON para um objeto Java
	      Student student = gson.fromJson(jsonString, Student.class); 
	      System.out.println(student);    
	      
	   // Serializar o objeto Java de volta para uma string JSON
	      jsonString = gson.toJson(student); 
	      System.out.println(jsonString); 
	}

}
