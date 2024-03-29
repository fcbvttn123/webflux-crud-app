package ca.sheridancollege.vutran.beans;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection="students")
public class Student {
	@Id
	private Long id;
	private String name;
}



/*

	{
	    "id": 1,
	    "name": "John"
	}

*/
