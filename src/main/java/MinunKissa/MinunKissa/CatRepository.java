/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package MinunKissa.MinunKissa;
import java.util.ArrayList;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 *
 * @author jonna
 */
public interface CatRepository extends JpaRepository<Cat, Long>  {
        ArrayList<Cat> findByName(String number);
        ArrayList<Cat> findAll();
        Long deleteByName(String number);
}
