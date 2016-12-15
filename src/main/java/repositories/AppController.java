/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Category;
import entities.Recipe;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Robin_000
 */
@CrossOrigin
@RestController
@RequestMapping(value = "/API")
public class AppController {
    
   
    CategoryRepository categoryRepositry;
    RecipeRepository recipeRepository;
    
    @Autowired
    public AppController(CategoryRepository cr, RecipeRepository rr){
        this.categoryRepositry = cr;
        this.recipeRepository = rr;
    }
    
    @RequestMapping(value = "/categories", method = RequestMethod.GET)
    public List<Category> getCategories() {
        return categoryRepositry.findAll();
    }
        
    @RequestMapping(value = "/recipies", method = RequestMethod.GET)
    public List<Recipe> getRecipies() {
        return recipeRepository.findAll();
    }
    
    @RequestMapping(value = "/recipies", method = RequestMethod.POST)
    public List<Recipe> saveRecipie(@RequestBody Recipe recipe){
        recipeRepository.save(recipe);
        return recipeRepository.findAll();
    }
    
    @RequestMapping(value = "/recipies/{id}", method = RequestMethod.POST)
    public List<Recipe> deleteRecipie(@PathVariable int id) {
        recipeRepository.delete(id);
        return recipeRepository.findAll();
    }
    
    @RequestMapping(value = "/recipies/{id}", method = RequestMethod.PUT)
    public List<Recipe> updateRecipie(@PathVariable int id, @RequestBody Recipe newRecipe) {
        Recipe oldRecipe = recipeRepository.findOne(id);
        oldRecipe.setCategory(newRecipe.getCategory());
        oldRecipe.setIngredients(newRecipe.getIngredients());
        oldRecipe.setSteps(newRecipe.getSteps());
        oldRecipe.setTitle(newRecipe.getTitle());
        recipeRepository.save(oldRecipe);
        return recipeRepository.findAll();
    }   
}
