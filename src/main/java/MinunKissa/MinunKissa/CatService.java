/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MinunKissa.MinunKissa;

import java.util.ArrayList;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 *
 * @author jonna
 */
@Service
public class CatService {
    
    private ArrayList<Cat> cats;
    
    @Autowired
    private CatRepository catRepository;
    
    public ArrayList<Cat> getCats() {
        return this.catRepository.findAll();
    }
    
    
    public Cat findCatByName(String number) {
        return this.catRepository.findByName(number).get(0);
    }
    
    @Transactional
    public void deleteCatByName(String number) {
        this.catRepository.deleteByName(number);
    }


    void addCat(String name, String gender, String breed, String color, String owner, String officialName, String breeder, String number, String chip, String EMS, String dob, String dad, String mum) {
         this.catRepository.save(new Cat(name, gender, breed, color, owner, officialName, breeder, number, chip,EMS, dob, dad, mum));
         this.cats.add(new Cat(name, gender, breed, color, owner, officialName, breeder, number, chip,EMS, dob, dad, mum));
    }
}
