package ch.heigvd.ptl.sc.to;

import java.util.List;

public class IssueTO {

    private String id;

    private String author;
    private String issueType;
    private String description;
    private String geoCoordonnee;
    private String status;

    private List<String> roles;

    public String getId() {
        return id;
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

    /**
     * Sera un object -> user *
     */
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
    }
}
