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
import org.springframework.web.bind.annotation.PathVariable;
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
    public String getCats(Model model)
    {
        ArrayList<Cat> cats = catService.getCats();
        model.addAttribute("cats", cats);
        System.out.println(catService.getCats());

        ArrayList<User> users = userService.getUsers();
        for (User u : users) {
            if (u.getActive()) {
                return "cats";
            }
        }
        return "redirect:/";
    }
    
    @GetMapping("/new-cat")
    public String addCat() {

        ArrayList<User> users = userService.getUsers();
        for (User u : users) {
            if (u.getActive()) {
                return "new-cat";
            }
        }
        return "redirect:/";
    }
         
    
    @PostMapping("/new-cat")
    public String addCat(@RequestParam String name, String gender, String breed, String color, String owner, String officialName, String breeder, String number, String chip, String EMS, String dob, String dad, String mum) {
        System.out.println(name+ gender+ breed+ color+ owner+ officialName+ breeder+ number+ chip+EMS+ dob+ dad+ mum);
        catService.addCat(name, gender, breed, color, owner, officialName, breeder, number, chip,EMS, dob, dad, mum);
        return "redirect:/cats";
    }


    @GetMapping("/edit-cat")
    public String editCat() {

        ArrayList<User> users = userService.getUsers();
        for (User u : users) {
            if (u.getActive()) {
                return "edit-cat";
            }
        }
        return "redirect:/";
    }

    @PostMapping("/edit-cat")
    public String editCatData(@RequestParam String name, String gender, String breed, String color, String owner, String officialName, String breeder, String number, String chip, String EMS, String dob, String dad, String mum)
    {
        ArrayList<Cat> cats = catService.getCats();
        Cat cat = new Cat(name, gender, breed, color, owner, officialName, breeder, number, chip,EMS, dob, dad, mum);
        catService.updateCat(cat);
        return "redirect:/cats";
    }

    @GetMapping("delete-cat")
    public String catRemoval(){

        ArrayList<User> users = userService.getUsers();
        for (User u : users) {
            if (u.getActive()) {
                return "delete-cat";
            }
        }
        return "redirect:/";
        }

    @PostMapping("/delete-cat")
    public String removeCat(@RequestParam String name){
        ArrayList<Cat> cats = catService.getCats();
        System.out.println("Poistettava kissa: " + name);
                catService.deleteCatByName(name);
        return "redirect:/cats";
    }

}
