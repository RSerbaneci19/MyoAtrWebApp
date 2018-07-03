package tango.webapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tango.webapp.model.User;
import tango.webapp.repository.UserRepository;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public User findById(Long id) {
        userRepository.findById(id);
        return null;
    }

    @Override
    public User create(User shop) {
        return null;
    }

    @Override
    public User delete(int id) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return null;
    }

    @Override
    public User update(User shop) {
        return null;
    }
}
