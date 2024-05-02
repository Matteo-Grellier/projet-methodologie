package com.demomvc.demomvc.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.demomvc.demomvc.entities.*;;

@Repository
public interface EtudiantRepository extends CrudRepository<Etudiant, Integer> {

	public Etudiant findByName(String nom);
}
