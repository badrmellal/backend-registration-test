package registration.backend.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Long>{


	

}
