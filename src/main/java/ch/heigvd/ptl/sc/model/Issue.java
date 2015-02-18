package ch.heigvd.ptl.sc.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Issue {
	@Id
	private String id;
	
	private String author;
	private String issueType;
	private String description;
        private String geoCoordonnee;
        private String statu;
        
        
        public String getAuthor() {
		return author; 
	}
        
        public String getIssueType(){
            return issueType;
        }
	
        

	
	
	
}
