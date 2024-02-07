package insurenceMain.Services;

import insurenceMain.Binding.UserAppReq;

public interface UserAppServices {
	
	public Integer createUserApp(UserAppReq user);
	
	public UserAppReq viewUser(Integer id);

}
