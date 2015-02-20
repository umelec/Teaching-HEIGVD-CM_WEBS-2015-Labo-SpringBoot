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
        private String status;
        
        /**Objet autheur lié**/
        public String getAuthor() {
		return author; 
	}
        
        public void setAuthor(String author) {
		this.author = author;
	}
        
        /** Un ou plusieurs issueType **/
        public String getIssueType(){
            return issueType;
        }
        
        public void setIssueType(String issueType){
             this.issueType = issueType;
        }
	
        public String getDescription(){
            return description;
        }
        
        public void setDescription(String description){
             this.description  = description;
        }
        
        public String getGeoCoordonnee(){
            return geoCoordonnee;
        }
        
        public void setGeoCoordonnee(String geoCoordonnee){
             this.geoCoordonnee = geoCoordonnee;
        }
        
         public String getStatus(){
            return geoCoordonnee;
        }
        
        public void setStatus(String status){
             this.status = status;
        }        
        
        public String getId() {
		return id;
	}
	
}
