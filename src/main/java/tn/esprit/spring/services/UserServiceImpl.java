package tn.esprit.spring.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.User;
import tn.esprit.spring.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
@Transactional
public class UserServiceImpl implements UserService{


    @Autowired
    UserRepository UserRepo;


    @Autowired
    UserService Userservice;


    @Override
    public List<User> getUsers() {
        return UserRepo.findAll();

    }


    @Override
    public User updatePassword (User user, Long IdUser) {

        User userById = UserRepo.findById(IdUser).get();
        userById.setPassword(user.getPassword());

        return UserRepo.save(userById);
    }

    public void delete(long id)
    {
        UserRepo.deleteById(id);
    }


	@Override
	public User updateUser(User user, Long IdUser) {
		// TODO Auto-generated method stub
		
		User userById = UserRepo.findById(IdUser).get();
        userById.setEmail(user.getEmail());
        userById.setUsername(user.getUsername());

        return UserRepo.save(userById);
		
	}
}
