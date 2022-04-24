/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MinunKissa.MinunKissa;

import java.util.ArrayList;
import javax.persistence.Entity;
//import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;
/**
 *
 * @author jonna
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data   
public class User extends AbstractPersistable<Long> {

    private String firstName;
    private String lastName;
    private String town;
    private String userName;    // tänne tulee sähköposti
    private String passWord;
    private String name = userName;
    private boolean active = false;



    public User(String afirstName, String alastName, String atown, String auserName, String apassWord) {
       this.firstName = afirstName;
       this.lastName = alastName;
       this.town = atown;
       this.userName=auserName;
       this.passWord=apassWord;
       this.name = userName;
    }

    public boolean getActive() {
        System.out.println("Ollaanko aktiivisia? " + active);
        return active;
        }
    
    public void setActive() {
        this.active = true;
        System.out.println("Käyttäjästä " + firstName + " tehty aktiivinen");
    }
    
    public void setInActive() {
        this.active = false;
        System.out.println("Käyttäjästä " + firstName + " tehty epäaktiivinen");
    }
    
}
