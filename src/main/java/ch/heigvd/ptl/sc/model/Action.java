package ch.heigvd.ptl.sc.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Action {
	@Id
	private String id;
	
	private String author;
	private String date;
	private String comment;
    
        
        public String getAuthor() {
		return author; 
	}
        
        public void setAuthor(String author) {
		this.author = author;
	}
        
        public String getDate(){
            return date;
        }
        
        public void setDate(String date){
             this.date = date;
        }
	
        
        public String getComment(){
            return comment;
        }
        
        public void setComment(String comment){
             this.comment  = comment;
        }
        
        public String getId() {
		return id;
	}

	
}
