package ch.heigvd.ptl.sc.to;

import java.util.List;

public class IssueTypeTO {
	private String id;
	private String name;
	

	private List<String> roles;
	
	public String getId() {
		return id;
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
