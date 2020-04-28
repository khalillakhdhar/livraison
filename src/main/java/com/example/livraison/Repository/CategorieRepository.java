/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.livraison.Repository;

import com.example.livraison.model.Categorie;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author pro
 */
public interface CategorieRepository extends JpaRepository<Categorie, Long> {
    
}
