/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xyz.admin.sessionbeans;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import xyz.admin.entities.Comment;

/**
 *
 * @author Daniel GV
 */
@Stateless
public class CommentFacade extends AbstractFacade<Comment> {

    @PersistenceContext(unitName = "xyz.admin_Recepies_war_1.0-SNAPSHOTPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Comment> findByRecipeId(int recipeId) {
        List<Comment> cats = em.createNamedQuery("Comment.findByRecipeId", Comment.class)
                .setParameter("recipeId", recipeId).getResultList();

        if (cats.isEmpty()) {
            return null;
        }

        return cats;
    }
    
    public CommentFacade() {
        super(Comment.class);
    }
    
}
