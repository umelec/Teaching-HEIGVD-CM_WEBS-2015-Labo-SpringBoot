package ch.heigvd.ptl.sc.to;

import java.util.List;

public class IssueTypeTO {

    private String id;
    private String shortName;

    private List<String> roles;

    public String getId() {
        return "http://localhost:8080/api/issuestypes/" + id;
    }

    public String getShortName() {
        return shortName;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String setShortName(String shortName) {
        return this.shortName = shortName;
    }
}
