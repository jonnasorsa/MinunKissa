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
         

         @GetMapping("/login/me")
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
                 userService.setActivity(userName);
                 return "redirect:/me";
             }
             }            
                System.out.println("It's not a match");
               return "redirect:/";
         }
       

         @GetMapping("/delete-account") 
            public String deleting() {
             ArrayList<User> users = userService.getUsers();
             for (User u : users) {
                 if (u.getActive()) {
                     return "delete-account";
                 }
             }
             return "redirect:/";
         }


         @GetMapping("remove-confirm")
         public String deletePage(){
             ArrayList<User> users = userService.getUsers();
             for (User u : users) {
                 System.out.println("Testataan, l??ytyyk?? poistettavaa");
                 if (u.getActive())
                         {
                    System.out.println("L??ytyi poistettavaa");
                 userService.deleteUser(u.getUserName());
             }
                 else System.out.println("Ei viel??");
             }            
               return "redirect:/";
         }


         
         // ohjataan k??ytt??j??tilin luontiin
        @GetMapping("/new-user")
        public String getUserCreation() {
           return "new-user";
       }
 
         
         // lis???? k??ytt??j??
         @PostMapping("/new-user") 
         public String newUser(@RequestParam String firstName, String lastName, String town, String userName, String passWord){
             System.out.println(firstName + lastName + town + userName + passWord);
             userService.addUser(firstName, lastName, town, userName, passWord);
             return "redirect:/";
         }




        @GetMapping("/me")
        public String getUserPage() {

            ArrayList<User> users = userService.getUsers();
            System.out.println(userService.getUsers());

            for (User u : users) {
                if (u.getActive()) {
                    return "me";
                }
            }
            return "redirect:/";
     }

        
        @GetMapping("/logout")
        public String logOut() {
            ArrayList<User> users = userService.getUsers();
             for (User u : users) {
                 System.out.println("etsit????n aktiivinen k??ytt??j??");
                 if (u.getActive())
                         {
                             System.out.println("Kirjataan k??ytt??j?? " + u.getUserName() + " ulos");
                             String userName = u.getUserName();
                             userService.setActivity(userName);
                         }
                    else System.out.println(u.getUserName() + " ei ole aktiivinen");
        }
              return "redirect:/";
}
        
        
}
