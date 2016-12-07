/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "recipe")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Recipe.findAll", query = "SELECT r FROM Recipe r"),
    @NamedQuery(name = "Recipe.findByRecipeId", query = "SELECT r FROM Recipe r WHERE r.recipeId = :recipeId"),
    @NamedQuery(name = "Recipe.findByTitle", query = "SELECT r FROM Recipe r WHERE r.title = :title"),
    @NamedQuery(name = "Recipe.findByAuthor", query = "SELECT r FROM Recipe r WHERE r.author = :author"),
    @NamedQuery(name = "Recipe.findByIngredients", query = "SELECT r FROM Recipe r WHERE r.ingredients = :ingredients"),
    @NamedQuery(name = "Recipe.findBySteps", query = "SELECT r FROM Recipe r WHERE r.steps = :steps")})
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "recipe_id")
    private Integer recipeId;
    @Size(max = 45)
    @Column(name = "title")
    private String title;
    @Size(max = 45)
    @Column(name = "author")
    private String author;
    @Size(max = 3000)
    @Column(name = "ingredients")
    private String ingredients;
    @Size(max = 3000)
    @Column(name = "steps")
    private String steps;
    @JoinColumn(name = "category", referencedColumnName = "category_id")
    @ManyToOne
    private Category category;

    public Recipe() {
    }

    public Recipe(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public Integer getRecipeId() {
        return recipeId;
    }

    public void setRecipeId(Integer recipeId) {
        this.recipeId = recipeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSteps() {
        return steps;
    }

    public void setSteps(String steps) {
        this.steps = steps;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (recipeId != null ? recipeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Recipe)) {
            return false;
        }
        Recipe other = (Recipe) object;
        if ((this.recipeId == null && other.recipeId != null) || (this.recipeId != null && !this.recipeId.equals(other.recipeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Recipe[ recipeId=" + recipeId + " ]";
    }
    
}
