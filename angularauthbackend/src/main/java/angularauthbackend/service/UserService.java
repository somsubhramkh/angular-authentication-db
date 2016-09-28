package angularauthbackend.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import angularauthbackend.dao.UserDAO;
import angularauthbackend.model.User;

@Service("userService")
public class UserService{
    
	@Autowired
	private UserDAO userDAO;
     
    
 
    public List<User> findAllUsers() {
        
    	List<User> users=userDAO.list();
    	return users;
    }
     
    public User findById(long id) {
        
    	return userDAO.get(id);
    }
     
    public User findByName(String name) {
        
    	return userDAO.getUserByName(name);
    }
    
    
 public User findByUsername(String username) {
        
    	return userDAO.getUserByUsername(username);
    }
     
    public void saveUser(User user) {
        
    	userDAO.saveOrUpdate(user);
    }
 
    public void updateUser(User user) {
        
    	userDAO.saveOrUpdate(user);
    }
 
    public void deleteUserById(long id) {
         
        userDAO.delete(id);
    }
 
    public boolean isUserExist(User user) {
        return findByName(user.getUsername())!=null;
    }
      

 
}
