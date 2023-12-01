package registration.backend.login;

import java.io.File;
import java.security.PublicKey;
import java.sql.SQLException;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@CrossOrigin
public class UserController {
    private UserService userService;
    

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    
    @PostMapping(value = "/api/createuser")
    public ResponseEntity<?> createUserApi(@RequestBody UserDetails userDetails) throws Exception {
    	if (userDetails == null) {
            return new ResponseEntity<>("Error: userDetails is null or empty", HttpStatus.BAD_REQUEST);
        }
    	ObjectMapper objectMapper = new ObjectMapper();
    	  	
    	try {
    		
            String userDetailsString = objectMapper.writeValueAsString(userDetails);
			UserDetails userDetailsFromJson = objectMapper.readValue(userDetailsString, UserDetails.class);

            if (userDetailsFromJson.getPassword() == null) {
                userDetailsFromJson.setPassword("defaultPassword");
            }
            System.out.println("Received Password: " + userDetailsFromJson.getPassword());
            System.out.println("Received UserDetails: " + userDetailsFromJson);
                                    
            return new ResponseEntity<>(userService.saveUserDetails(userDetailsFromJson), HttpStatus.CREATED);
            
        } catch (Exception e) {
        	e.printStackTrace();
            return new ResponseEntity<>("Error when trying to save the user: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/api/allusers")
    public ResponseEntity<?> allUsersApi() throws SQLException {
        List<UserDetails> allUsers = userService.getAllUsersDetails();
        
        if (allUsers.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            
        } else {
        	return ResponseEntity.status(HttpStatus.OK).body(allUsers);
     //       return ResponseEntity.status(HttpStatus.OK).contentType(MediaType.valueOf("image/png")).body(dbPhoto);
        }
    }
    

}
