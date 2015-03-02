package ch.heigvd.ptl.sc.to;

import java.util.List;

public class IssueTypeTO {

    private String id;
    private String shortName;

    private List<String> roles;

    public String getId() {
        return "http://sheltered-headland-4650.herokuapp.com/api/issuestypes/" + id;
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
