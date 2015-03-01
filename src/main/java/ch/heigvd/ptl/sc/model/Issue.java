package ch.heigvd.ptl.sc.model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
    private Date date;

    /**
     * Objet autheur lié*
     */
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

    /**
     * Un ou plusieurs issueType *
     */
    public String getIssueType() {
        return issueType;
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

    public String getDate() {
        return "" + date + "";
    }

    public void setDate(String dateInput) throws ParseException {
        DateFormat format = new SimpleDateFormat("d MMMM yyyy", Locale.FRENCH);
        Date date = format.parse(dateInput);
        this.date = date;
    }

    public String getId() {
        return id;
    }

}
