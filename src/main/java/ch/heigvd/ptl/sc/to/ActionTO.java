package ch.heigvd.ptl.sc.to;

import java.util.List;

public class ActionTO {

    private String id;
    private String author;
    private String date;
    private String comment;
    private String issueid;

    public String getId() {
        return "localhost:8080/api/actions/" + id;
    }

    public String getIssueId() {
        return issueid;
    }

    public String getAuthor() {
        return author;
    }

    public String getDate() {
        return date;
    }

    public String getComment() {
        return comment;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public void setIssueId(String issueid) {
        this.issueid = issueid;
    }

    public void setId(String id) {
        this.id = id;
    }
}
