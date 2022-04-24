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
public interface UserRepository extends JpaRepository<User, Long>{
    @Override
    ArrayList<User> findAll();
    ArrayList<User> findByName(String userName);
    Long deleteByName(String userName);
  
}
