/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MinunKissa.MinunKissa;


import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author jonna
 */

@Controller
public class UserController {
         @Autowired
     private UserService userService;
         
         @Autowired
         private CatService catService;
         

         @GetMapping("/login")           
         public String checkUser(@RequestParam String userName, String passWord) {

             System.out.println(userName);
             System.out.println(passWord);
             ArrayList<User> users = userService.getUsers();
             
             for (User u : users) {
                 if (
                 u.getUserName().equals(userName));
                 if(u.getPassWord().equals(passWord))
                         {
                 System.out.println("It's a match! " + passWord);
                 User user = u;
                 //user.setActive(true);
                 userService.setActivity(userName);
                 //userService.deleteUser(userName);
                 //userService.addUser(user.getFirstName(), user.getLastName(), user.getTown(), userName, passWord);
                 return "me";
             }
             }            
                System.out.println("It's not a match");
               return "redirect:/";
         }
       

         @GetMapping("/delete-account") 
            public String deleting() {
                return "delete-account";
        }
         
         @GetMapping("remove-confirm")
         public String deletePage(){
             ArrayList<User> users = userService.getUsers();
             for (User u : users) {
                 System.out.println("Testataan, löytyykö poistettavaa");
                 if (u.getActive())
                         {
                    System.out.println("Löytyi poistettavaa");
                 userService.deleteUser(u.getUserName());
             }
                 else System.out.println("Ei vielä");
             }            
               return "redirect:/";
         }


         
         // ohjataan käyttäjätilin luontiin
        @GetMapping("/new-user")
        public String getUserCreation() {
           return "new-user";
       }
 
         
         // lisää käyttäjä
         @PostMapping("/new-user") 
         public String newUser(@RequestParam String firstName, String lastName, String town, String userName, String passWord){
             System.out.println(firstName + lastName + town + userName + passWord);
             userService.addUser(firstName, lastName, town, userName, passWord);
             return "redirect:/";
         }

         
         @GetMapping("/user-info")
         public String userPage() {
             return "user-info";
         }
        // käyttäjätilin tiedot
       // @GetMapping("/user-info/{userName}")
       // public String getUserPage(@PathVariable String userName, Model model) {
        //    User user = userService.findUserByName(userName);
        //    model.addAttribute("user", user);
        //   return "user-info";
       //} 


        @GetMapping("/me")
        public String getUserPage() {
             ArrayList<User> users = userService.getUsers();
             User user = null;
             for (User u : users) {
                 if (u.getActive())
                         {
                             user = u;
                         }
        }
             if (user==null)return "me";
            else {
                 return "redirect:/me/" + user.getUserName();
             }
     }
        
        
        @GetMapping("/logout")
        public String logOut() {
            ArrayList<User> users = userService.getUsers();
             for (User u : users) {
                 System.out.println("Testataan, löytyykö poistettavaa");
                 if (u.getActive())
                         {
                             userService.setActivity(u.getUserName());
                         }

        }
              return "/";           
}
        
        
}
