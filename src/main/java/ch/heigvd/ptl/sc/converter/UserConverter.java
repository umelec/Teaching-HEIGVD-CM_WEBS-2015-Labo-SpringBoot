package ch.heigvd.ptl.sc.converter;

import ch.heigvd.ptl.sc.model.User;
import ch.heigvd.ptl.sc.to.UserTO;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserConverter {
	public final List<UserTO> convertSourceToTarget(List<User> sources) {
		List<UserTO> results = new ArrayList<>();
		
		for (User source : sources) {
			results.add(convertSourceToTarget(source));
		}
		
		return results;
	}

	public final UserTO convertSourceToTarget(User source) {
		UserTO target = new UserTO();
		fillTargetFromSource(target, source);
		return target;
	}
	
	public final List<User> convertTargetToSource(List<UserTO> targets) {
		List<User> results = new ArrayList<>();
		
		for (UserTO target : targets) {
			results.add(convertTargetToSource(target));
		}
		
		return results;
	}

	public final User convertTargetToSource(UserTO target) {
		User source = new User();
		fillSourceFromTarget(source, target);
		return source;
	}

	public void fillTargetFromSource(UserTO target, User source) {
		target.setId(source.getId());
		target.setFirstname(source.getFirstname());
		target.setLastname(source.getLastname());
		target.setPhone(source.getPhone());
		
		List<String> roles = new ArrayList<>();
		for (String role : source.getRoles()) {
			roles.add(role);
		}
		target.setRoles(roles);
	}

	public void fillSourceFromTarget(User source, UserTO target) {
		source.setFirstname(target.getFirstname());
		source.setLastname(target.getLastname());
		source.setPhone(target.getPhone());

		List<String> roles = new ArrayList<>();
		for (String role : target.getRoles()) {
			roles.add(role);
		}
		source.setRoles(roles);
	}
}
