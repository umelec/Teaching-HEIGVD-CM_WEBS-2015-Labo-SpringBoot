package ch.heigvd.ptl.sc.model;

import java.util.List;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class IssueType {
	@Id
	private String id;
	
	private String name;
	

	protected List<String> roles;
	
	public String getName() {
		return name; 
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getId() {
		return id;
	}

	public List<String> getRoles() {
		return roles;
	}

	public void setRoles(List<String> roles) {
		this.roles = roles;
	}
	
	public boolean hasRole(String role) {
		for (String userRole : roles) {
			if (userRole.equals(role)) {
				return true;
			}
		}
		return false;
	}
}
