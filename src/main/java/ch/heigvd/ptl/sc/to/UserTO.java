package ch.heigvd.ptl.sc.to;

import java.util.List;

public class UserTO {

    private String id;
    private String firstname;
    private String lastname;
    private String phone;

    private List<String> roles;

    public String getId() {
        return "http://sheltered-headland-4650.herokuapp.com/api/users/"+id;
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setId(String id) {
        this.id = id;
    }
}
