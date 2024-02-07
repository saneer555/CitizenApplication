package insurenceMain.Services;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import insurenceMain.Binding.UserAppReq;
import insurenceMain.Entity.UserApp;
import insurenceMain.Repository.UserAppRespository;

@Service
public class UserServicesImpl implements UserAppServices{
	
	@Autowired
	private UserAppRespository useRepo;

	@Override
	public Integer createUserApp(UserAppReq user) {
		
		String url ="http://example.com/api/checkLocation";
		RestTemplate rs = new RestTemplate();
		ResponseEntity<String> entity = rs.getForEntity(url, String.class, user.getSsn());
		String body = entity.getBody(); 
		if(body.equalsIgnoreCase("Jersey")) {
			UserApp app = new UserApp();
			BeanUtils.copyProperties(user, app);
			UserApp save = useRepo.save(app);
			save.getUserId();
		}
		return -1;
	}

	@Override
	public UserAppReq viewUser(Integer id) {
		
		Optional<UserApp> id2 = useRepo.findById(id);
		if(id2.isPresent()) {
			UserApp userApp = id2.get();
			UserAppReq userReq = new UserAppReq();
			BeanUtils.copyProperties(userApp, userReq);
			return userReq;
		}
		
		return null;
	}

}
