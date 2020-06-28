package fr.eni.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.jpa.bean.Bouteille;
import fr.eni.jpa.bean.Couleur;
import fr.eni.jpa.dao.ICouleurRepository;

@Service(value = "gestionCouleur")
public class GestionCouleur {

	
	@Autowired
	ICouleurRepository cdao;

	// liste des bouteilles :
	public List<Couleur> listeCouleurs() {
		return cdao.findAll();
	}
	
	public Couleur rechercherCouleurById(int id) {
		return cdao.findOne(id);
	}

	// filtrer la liste bouteille et récuéprer une bouteille par son nom :
		public Couleur rechercherCouleurByNom(String nom) {
			return cdao.findByNomContains(nom);
		}
}
