/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Recipe;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Robin_000
 */

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Integer>{
    
    @Query(value = "SELECT r FROM Recipe r WHERE r.author = ?1")
    List<Recipe> findByAuthor(String author);
}
