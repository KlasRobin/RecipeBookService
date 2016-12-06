/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Robin_000
 */
@Entity
@Table(name = "recipe_ingredient")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RecipeIngredient.findAll", query = "SELECT r FROM RecipeIngredient r"),
    @NamedQuery(name = "RecipeIngredient.findByRecipeId", query = "SELECT r FROM RecipeIngredient r WHERE r.recipeIngredientPK.recipeId = :recipeId"),
    @NamedQuery(name = "RecipeIngredient.findByIngredientId", query = "SELECT r FROM RecipeIngredient r WHERE r.recipeIngredientPK.ingredientId = :ingredientId"),
    @NamedQuery(name = "RecipeIngredient.findByAmount", query = "SELECT r FROM RecipeIngredient r WHERE r.amount = :amount")})
public class RecipeIngredient implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected RecipeIngredientPK recipeIngredientPK;
    @Size(max = 45)
    @Column(name = "amount")
    private String amount;
    @JoinColumn(name = "recipe_id", referencedColumnName = "recipe_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Recipe recipe;
    @JoinColumn(name = "ingredient_id", referencedColumnName = "ingredient_id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Ingredient ingredient;

    public RecipeIngredient() {
    }

    public RecipeIngredient(RecipeIngredientPK recipeIngredientPK) {
        this.recipeIngredientPK = recipeIngredientPK;
    }

    public RecipeIngredient(int recipeId, int ingredientId) {
        this.recipeIngredientPK = new RecipeIngredientPK(recipeId, ingredientId);
    }

    public RecipeIngredientPK getRecipeIngredientPK() {
        return recipeIngredientPK;
    }

    public void setRecipeIngredientPK(RecipeIngredientPK recipeIngredientPK) {
        this.recipeIngredientPK = recipeIngredientPK;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public Recipe getRecipe() {
        return recipe;
    }

    public void setRecipe(Recipe recipe) {
        this.recipe = recipe;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recipeIngredientPK != null ? recipeIngredientPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof RecipeIngredient)) {
            return false;
        }
        RecipeIngredient other = (RecipeIngredient) object;
        if ((this.recipeIngredientPK == null && other.recipeIngredientPK != null) || (this.recipeIngredientPK != null && !this.recipeIngredientPK.equals(other.recipeIngredientPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.RecipeIngredient[ recipeIngredientPK=" + recipeIngredientPK + " ]";
    }

}
