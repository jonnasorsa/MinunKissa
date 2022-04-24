/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MinunKissa.MinunKissa;

/**
 *
 * @author jonna
 */
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SiteController {
    // oletussivu
    @GetMapping("/")
    public String getIndex() {
        return"index";
    }


    // ohjaa takaisin pääsivulle virheellisestä osoitteesta
    @GetMapping("*")
    public String getDefault() {
        return "redirect:/";
    }
    

}
