package ch.heigvd.ptl.sc.to;

import java.util.List;

public class IssueTypeTO {
	private String id;
	private String shortname;
	

	private List<String> roles;
	
	public String getId() {
		return id;
	}

        public String getName() {
		return shortname;
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
         
        public String setName(String shortname) {
		return this.shortname = shortname;
	}
}
