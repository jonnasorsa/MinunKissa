/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MinunKissa.MinunKissa;


import java.util.ArrayList;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author jonna
 */

@Service
public class UserService {


    @Transactional
    public void setActivity(String userName) {
      User user = this.findUserByName(userName);
      if(user.getActive())
          user.setInActive();
      else user.setActive();
      this.userRepository.save(user);
    }
    
    private ArrayList<User> users;
    
    @Autowired
    private CatService catService;
    
    @Autowired
    private UserRepository userRepository;
    
    public UserService() {
        System.out.println("Creating userService");
        this.users = new ArrayList<>();
        users.add(new User("Demo", "Demo", "Demotown", "demo@demo.fi", "Demo"));
}
    
    public ArrayList<User>getUsers() {
        return this.userRepository.findAll();
    }
    
   public void addUser(String firstName, String lastName, String town, String userName, String passWord) {
   this.userRepository.save(new User(firstName,lastName, town, userName, passWord));
   this.users.add(new User(firstName,lastName, town, userName, passWord));
  }


    public User findUserByName(String userName) {
        return this.userRepository.findByName(userName).get(0);
     }
    
    @Transactional 
    public void deleteUser(String userName) {
        System.out.println("Poistetaan " + userName);
        this.userRepository.deleteByName(userName);
        System.out.println("Poistettu!");
    }

   }
           
    
            