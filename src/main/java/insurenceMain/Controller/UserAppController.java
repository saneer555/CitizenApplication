package insurenceMain.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import insurenceMain.Binding.UserAppReq;
import insurenceMain.Services.UserAppServices;

@RestController
public class UserAppController {

	@Autowired
	private UserAppServices userServices;

	@PostMapping("/createUser")
	public ResponseEntity<String>createApp(@RequestBody UserAppReq user){

		Integer app = userServices.createUserApp(user);
		if(app >0 && app !=null) {
			return new ResponseEntity<>("created Suceess",HttpStatus.CREATED);
		}else {
			return new ResponseEntity<>("created unsuccess",HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/user/{id}")
	public ResponseEntity<UserAppReq>viewApp(@PathVariable Integer id){
		UserAppReq viewUser = userServices.viewUser(id);

		if(viewUser != null) {
			return new ResponseEntity<>(viewUser,HttpStatus.OK);

		}else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

	}
}
