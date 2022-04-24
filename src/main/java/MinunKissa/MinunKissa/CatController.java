/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MinunKissa.MinunKissa;
import java.util.ArrayList;
//import java.util.List;
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
public class CatController {
    
    @Autowired
    private CatService catService;
             
    @Autowired
     private UserService userService;
    
    
    @GetMapping("/cats")
    public String getCats() {
        return "cats";
    }
    
    @GetMapping("new-cat")
    public String addCat() {
        return "new-cat";
    }
         
    
    @PostMapping("/new-cat")
    public String addCat(@RequestParam String name, String gender, String breed, String color, String owner, String officialName, String breeder, String number, String chip, String EMS, String dob, String dad, String mum) {    //TODO: lisää attribuutit
        catService.addCat(name, gender, breed, color, owner, officialName, breeder, number, chip,EMS, dob, dad, mum);
        return "redirect:/cats";
    }
    /*
            public String newUser(@RequestParam String firstName, String lastName, String town, String userName, String passWord){
             System.out.println(firstName + lastName + town + userName + passWord);
             userService.addUser(firstName, lastName, town, userName, passWord);
             return "redirect:/";
    */
    @PostMapping("/deletecat")
    public String deleteCat(@RequestParam String number) {
        catService.deleteCatByName(number);
        return "redirect:/cats";
    }
}
