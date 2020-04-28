/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.livraison.Repository;

import com.example.livraison.model.Produit;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pro
 */
public interface ProduitRepository extends JpaRepository<Produit, Long> {
    List<Produit> findbyCategorieId(Long categorieId);
    Produit findByIdAndCategorieId(Long id,Long categorieId);
    
}
