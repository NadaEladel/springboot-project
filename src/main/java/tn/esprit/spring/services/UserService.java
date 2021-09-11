package tn.esprit.spring.services;

import java.util.List;
import java.util.Optional;

import tn.esprit.spring.entities.User;
public interface UserService {

    List<User> getUsers();

    User  updatePassword(User user, Long IdUser);
    
    User  updateUser(User user, Long IdUser);
    
    public void delete(long id)  ;
}
