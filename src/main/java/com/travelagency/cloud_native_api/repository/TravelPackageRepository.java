package com.travelagency.cloud_native_api.repository;

import com.travelagency.cloud_native_api.model.TravelPackage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Questa interfaccia è il nostro Data Access Object (DAO).
 * Estendendo JpaRepository, Spring Data JPA ci fornirà automaticamente
 * tutti i metodi CRUD (Create, Read, Update, Delete) per l'entità TravelPackage.
 * Non dobbiamo scrivere alcuna implementazione!
 */
@Repository
public interface TravelPackageRepository extends JpaRepository<TravelPackage, Long> {
    // La magia è qui: questo file è intenzionalmente vuoto.
    // Metodi come save(), findById(), findAll(), deleteById() sono già disponibili.
}