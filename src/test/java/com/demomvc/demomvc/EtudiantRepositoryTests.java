package com.demomvc.demomvc;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import com.demomvc.demomvc.entities.*;
import com.demomvc.demomvc.repositories.*;;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class EtudiantRepositoryTests {

	@Autowired
	private EtudiantRepository repo;

	@Test
	@Rollback(false)
	@Order(1)
	public void testCreateEtudiant() {
		Etudiant saveEtudiant = repo.save(new Etudiant("Ethienne", 14)); // save

		assertThat(saveEtudiant.getId()).isGreaterThan(0);
	}

	@Test
	@Order(2)
	public void testFindProductByName() {
		Etudiant etudiant = repo.findByName("14"); // findByName
		assertThat(etudiant.getAge()).isEqualTo("14");
	}

	@Test
	@Order(3)
	public void testListEtudiants() {
		List<Etudiant> etudiants = (List<Etudiant>) repo.findAll();
		assertThat(etudiants).size().isGreaterThan(3);
	}

}
