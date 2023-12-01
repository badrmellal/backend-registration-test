package registration.backend.login;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Base64;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;
import javax.sql.rowset.serial.SerialBlob;
import javax.swing.ImageIcon;

import org.hibernate.engine.jdbc.BlobProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;


@Service
public class UserService {
    private UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    
    public UserDetails saveUserDetails(UserDetails userDetails) throws IOException {
    	
        if (userDetails.getPassword() == null) {
           throw new IllegalArgumentException("Password cannot be null!");
        }
        String encodedPassword = bCryptPasswordEncoder.encode(userDetails.getPassword());
        userDetails.setPassword(encodedPassword); 
        
        return userRepository.save(userDetails);
        
    }
    

    public List<UserDetails> getAllUsersDetails() throws SQLException {
    	List<UserDetails> allUsers = userRepository.findAll();
    	
    	return allUsers;
    }
    
}
    	
  //  	for (UserDetails userDetails : allUsers) {
   // 		try {
    //			 String base64Photo = userDetails.getBase64Photo();
    //	            if (base64Photo != null) {
    	            	
      //                  byte[] photoBytes = Base64.getDecoder().decode(base64Photo);
        //        BufferedImage decodedPhoto = ImageIO.read(new ByteArrayInputStream(photoBytes));
          //      userDetails.setPhoto(decodedPhoto);
                
    	  //          } 

    

