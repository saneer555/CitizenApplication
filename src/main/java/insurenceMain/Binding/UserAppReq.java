package insurenceMain.Binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class UserAppReq {
	

	private String fullName;
	
	private String email;
	
	private String mobile;
	
	private String gender;
	
	private LocalDate dob;
	
	private String ssn;

}
