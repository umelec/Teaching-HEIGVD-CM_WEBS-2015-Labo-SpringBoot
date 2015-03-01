package ch.heigvd.ptl.sc.to;

import java.util.Date;
import java.util.List;

public class IssueTO {

    private String id;

    private String author;
    private String issueType;
    private String description;
    private String geoCoordonnee;
    private String status;
    private Date date;
    private List<String> roles;

    public String getId() {
        return "http://localhost:8080/api/issues/" + id;
    }

    public String getAuthor() {
        return author;
    }

    public String getIssueType() {
        return issueType;
    }

    public String getDescription() {
        return description;
    }

    public String getGeoCoordonnee() {
        return geoCoordonnee;
    }

    public String getStatus() {
        return status;
    }
    
    public Date getDate() {
        return date;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setIssueType(String issueType) {
        this.issueType = issueType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void SetGeoCoordonnee(String geoCoordonnee) {
        this.geoCoordonnee = geoCoordonnee;
    }

    public void SetStatus(String status) {
        this.status = status;
    }

    public void setId(String id) {
        this.id = id;
        System.out.println("id");
    }

    public void setDate(Date date) {
        this.date = date;
        System.out.println(date);
    }
}
