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

    public CatService() {
        System.out.println("Creating catService");
        this.cats = new ArrayList<>();
    }

    private ArrayList<Cat> cats;
    
    @Autowired
    private CatRepository catRepository;
    
    public ArrayList<Cat> getCats() {
        return this.catRepository.findAll();
    }
    
    
    public Cat findCatByName(String name) {
        return this.catRepository.findByName(name).get(0);
    }
    
    @Transactional
    public void deleteCatByName(String name) {
        this.catRepository.deleteByName(name);
    }


    void addCat(String name, String gender, String breed, String color, String owner, String officialName, String breeder, String number, String chip, String EMS, String dob, String dad, String mum) {
         Cat cat= new Cat(name, gender, breed, color, owner, officialName, breeder, number, chip,EMS, dob, dad, mum);
        this.catRepository.save(cat);
        this.cats.add(cat);
    }

    @Transactional
    public void updateCat(Cat cat) {
        Cat c = this.findCatByName(cat.getName());
        if (cat.getGender()!= c.getGender() && cat.getGender().length()>0) {
            c.setGender(cat.getGender());
            System.out.println("Muutettiin sukupuolta");
        }
        if (cat.getBreed()!= c.getBreed() && cat.getBreed().length()>0) {
            c.setBreed(cat.getBreed());
            System.out.println("Muutettiin rotua");
        }
        if (cat.getColor()!= c.getColor() && cat.getColor().length()>0) {
            c.setColor(cat.getColor());
            System.out.println("Muutettiin väriä");
        }
        if(cat.getOwner()!= c.getOwner() && cat.getOwner().length()>0) {
            c.setOwner(cat.getOwner());
            System.out.println("Muutettiin omistajaa");
        }
        if(cat.getOfficialName()!= c.getOfficialName() && cat.getOfficialName().length()>0) {
            c.setOfficialName(cat.getOfficialName());
            System.out.println("Muutettiin virallista nimeä");
        }
        if(cat.getBreeder()!= c.getBreeder() && cat.getBreeder().length()>0){
            c.setBreeder(cat.getBreeder());
            System.out.println("Muutettiin kasvattajaa");
        }
        if(cat.getNumber()!= c.getNumber() && cat.getNumber().length()>0) {
            c.setNumber(cat.getNumber());
            System.out.println("Muutettiin rekisterinumeroa");
        }
        if(cat.getChip()!= c.getChip() && cat.getChip().length()>0){
            c.setChip(cat.getChip());
            System.out.println("Muutettiin sirunumeroa");
        }
        if(cat.getEMS()!= c.getEMS() && cat.getEMS().length()>0){
            c.setEMS(cat.getEMS());
            System.out.println("Muutettiin EMS-koodia");
        }
        if(cat.getDob()!= c.getDob() && cat.getDob().length()>0){
            c.setDob(cat.getDob());
            System.out.println("Muutettiin syntymäpäivää");
        }
        if(cat.getDad()!= c.getDad() && cat.getDad().length()>0){
                c.setDad(cat.getDad());
                System.out.println("Muutettiin isää");
        }
        if(cat.getMum()!= c.getMum() && cat.getMum().length()>0){
            c.setMum(cat.getMum());
            System.out.println("Muutettiin äitiä");
        }
        this.catRepository.save(c);
        System.out.println("Päivitetty kissa: " + c.getName());
    }
}
