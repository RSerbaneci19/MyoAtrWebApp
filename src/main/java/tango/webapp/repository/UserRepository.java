package tango.webapp.repository;

import tango.webapp.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rserbaneci on 21-Nov-16.
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findById(Long id);
}
