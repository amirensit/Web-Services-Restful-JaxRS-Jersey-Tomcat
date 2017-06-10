import java.io.IOException;
import java.net.URI;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.DefaultClientConfig;

import metier.entities.Categorie;

public class ClientRest {
	
	
	
	public static void main(String[] args) throws Exception {
		
		Client client=Client.create(new DefaultClientConfig());
		URI uri=UriBuilder.fromUri("http://localhost:8080/TPWSJRS/").build();
		
		
		 		
		/*
		 *
		 		//méthode 1
		 		 
		String catStr="{\"idCategorie\":5,\"nomCategorie\":\"AAAA\",\"photo\":\"AAA.jpg\"}";		 
	 	ObjectMapper  mapper=new ObjectMapper();
		ClientResponse resp2=client.resource(uri)
				.path("catalogue")
				.path("categories")
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class,catStr);
				
				
		*/
		
		
					//méthode 2
		
		Categorie ct=new Categorie(9L,"wwwwwwwwww","wwww.jpg");
		ObjectMapper  mapper=new ObjectMapper();
		ClientResponse resp2=client.resource(uri)
				.path("catalogue")
				.path("categories")
				.type(MediaType.APPLICATION_JSON)
				.post(ClientResponse.class,mapper.writeValueAsString(ct));
		
		System.out.println(resp2.getEntity(String.class)); 
		//consulter toutes les categories
		ClientResponse response=client.resource(uri)
				.path("catalogue")
				.path("categories")
				.get(ClientResponse.class);
		String corpsRepHttp=response.getEntity(String.class);
		
		System.out.println(corpsRepHttp);
		
		
		
		Categorie[] cats=mapper.readValue(corpsRepHttp, Categorie[].class); 
		
		for (Categorie c:cats)
			System.out.println(c.getNomCategorie());
	}

}
