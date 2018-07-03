package tango.webapp.service;

import tango.webapp.model.User;

import java.util.List;

public interface UserService {

    void save(User user);

    User findById(Long id);

    public User create(User shop);

    public User delete(int id);

    public List<User> findAll();

    public User update(User shop);

}
