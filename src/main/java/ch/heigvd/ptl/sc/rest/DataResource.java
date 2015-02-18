package ch.heigvd.ptl.sc.rest;

import ch.heigvd.ptl.sc.model.User;
import ch.heigvd.ptl.sc.model.IssueType;
import ch.heigvd.ptl.sc.persistence.UserRepository;
import ch.heigvd.ptl.sc.persistence.IssueTypeRepository;
import ch.heigvd.ptl.sc.converter.UserConverter;
import ch.heigvd.ptl.sc.converter.IssueTypeConverter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Path("/data")
public class DataResource {
	private final Random rand = new Random(Calendar.getInstance().getTimeInMillis());
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("YYYY-MM-DD");
	
	private static final String[] DESCRIPTIONS_AND_COMMENTS = new String[] {
		"Morbi a odio cursus, finibus lorem ut, pellentesque elit.",
		"Nunc sollicitudin lorem at dolor placerat, eget ornare erat fringilla.",
		"Sed eget ipsum sit amet lacus dictum porttitor at facilisis velit.",
		"Integer at metus vitae erat porta pellentesque.",
		"Pellentesque iaculis ante vestibulum dolor finibus hendrerit.",
		"Mauris tempus orci quis orci lacinia cursus.",
		"Nam semper ligula quis nisl egestas, at pellentesque nunc tincidunt.",
		"Integer venenatis justo ac urna accumsan, eget hendrerit ligula eleifend.",
		"Ut sagittis ipsum sed nisl ultrices rutrum.",
		"Proin pretium lacus nec lectus congue, a finibus elit consequat.",
		"Sed id ligula semper, auctor metus et, mattis tortor.",
		"Aenean non massa quis urna pellentesque pellentesque in nec ex.",
		"Vestibulum non erat venenatis, finibus lorem ac, eleifend eros.",
		"Proin ac mi et turpis volutpat facilisis id eget est.",
		"Pellentesque mattis quam tincidunt sem rhoncus finibus."
	};
	
	private static final String[] TAGS = new String[] {
		"Proin", "Orci", "Egestas", "Lobortis", "Quam", "Non", "Posuere", "Lorem", "Etiam"
	};
	
	private static final String[] ISSUE_STATES = new String[] {
		"created", "acknowledged", "assigned", "in_progress", "solved", "rejected"
	};
	
	private static final String[] FIRSTNAMES = new String[] {
		"Alfred", "Henri", "Romain", "Benoit", "Alain", "Alex"
	};
	
	private static final String[] LASTNAMES = new String[] {
		"Dupont", "Dutoit", "Ducroc", "Desportes", "Terieur" 
	};
	
	private static final List<String[]> ROLES = new ArrayList<>(
		Arrays.asList(
			new String[] { "citizen" },
			new String[] { "staff" },
			new String[] { "citizen", "staff" }
		)
	);
        
        private static final String[] ISSUETYPE_NAME = new String[] {
		"broken streetlight", "dangerous crossroad ", "graffiti", "broken street"
	};
	
	private static final float MIN_LAT = 46.766129f;
	private static final float MAX_LAT = 46.784234f;
	private static final float MIN_LNG = 6.622009f;
	private static final float MAX_LNG = 6.651878f;
	
	@Autowired
	private UserRepository userRepository;
        private IssueTypeRepository issueTypeRepository;
	
	@Autowired
	private UserConverter userConverter;
        private IssueTypeConverter issueTypeConverter;
	
	private List<User> users = new ArrayList<>();
	private List<User> citizen = new ArrayList<>();
	private List<User> staff = new ArrayList<>();
        
        private List<IssueType> issuesTypes = new ArrayList<>();
	
	private float random (float low, float high) {
    return rand.nextFloat() * (high - low) + low;
	}

	private int randomInt (int low, int high) {
		return (int) Math.floor(rand.nextFloat() * (high - low) + low);
	}

	private Date randomDate(Date start, Date end) {
    return new Date(start.getTime() + (int) (rand.nextFloat() * (end.getTime() - start.getTime())));
	}

	private String[] generateRoles() {
		return ROLES.get(randomInt(0, ROLES.size()));
	}
	
	private List<String> generateTags() {
		List<String> tags = new ArrayList<>();
		
		for (int i = 0; i < randomInt(1, 10); i++) {
			String tag = TAGS[randomInt(0, TAGS.length)];
			if (!tags.contains(tag)) {
				tags.add(tag);
			}
		}

		return tags;
	}

	private void populateUsers() {
		for (int i = 0; i < 15; i++) {
			User u = new User();
			
			u.setFirstname(FIRSTNAMES[randomInt(0, FIRSTNAMES.length)]);
			u.setLastname(LASTNAMES[randomInt(0, LASTNAMES.length)]);
			u.setPhone("+" + randomInt(1000000, 10000000));
			u.setRoles(Arrays.asList(generateRoles()));
			
			u = userRepository.save(u);
			
			users.add(u);
			
			for (String role : u.getRoles()) {
				if (null != role) switch (role) {
					case "citizen":
						citizen.add(u);
						break;
					case "staff":
						staff.add(u);
						break;
				}
			}
		}
	}
        
        private void populateIssueType() {
            for (int i = 0; i < 15; i++) {
                IssueType it = new IssueType();
                
                it.setName(ISSUETYPE_NAME[randomInt(0, ISSUETYPE_NAME.length)]);
                
                it = issueTypeRepository.save(it);
                issuesTypes.add(it);
                
                
                
            }
}
        
        
        @Path("/populateit")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response populateit() throws ParseException {
		issueTypeRepository.deleteAll();

		populateIssueType();
		
		return Response.ok().build();
	}
        
        @Path("/populate")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	public Response populate() throws ParseException {
		userRepository.deleteAll();

		populateUsers();
		
		return Response.ok().build();
	}
	

        
      
}
