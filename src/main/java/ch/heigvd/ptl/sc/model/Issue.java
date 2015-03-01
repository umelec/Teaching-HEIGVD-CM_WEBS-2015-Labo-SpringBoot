package ch.heigvd.ptl.sc.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Issue {

    @Id
    private String id;
    private String userId;
    private String author;
    private String issueType;
    private String description;
    private String geoCoordonnee;
    private String status;
    private Date date;
    

    public String getAuthor() {
        return author;
    }

    //pris en charge par l'orm
    @DBRef
    private List<Action> action = new ArrayList();

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<Action> getActions() {
        return action;
    }

    public void setActions(List<Action> action) {
        this.action = action;
    }

    public String getUserId() {
        return "http://localhost:8080/api/authors/" +userId;
    }

    public void setUserId(String userid) {
        this.userId = userid;
    }

    public String getIssueType() {
        return "http://localhost:8080/api/issuestypes/" +issueType;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getGeoCoordonnee() {
        return geoCoordonnee;
    }

    public void setGeoCoordonnee(String geoCoordonnee) {
        this.geoCoordonnee = geoCoordonnee;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDate() {
        System.out.println("....");
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
        System.out.println("issue" + date);
    }

    public String getId() {
        return id;
    }

}
