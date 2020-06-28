package fr.eni.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.jpa.bean.Couleur;

public interface ICouleurRepository extends JpaRepository<Couleur, Integer>{

	//méthode pour trier le vin par nom :
		Couleur findByNomContains(String nom);
}
