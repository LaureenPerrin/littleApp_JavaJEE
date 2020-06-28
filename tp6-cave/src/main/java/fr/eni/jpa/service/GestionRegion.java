package fr.eni.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.jpa.bean.Bouteille;
import fr.eni.jpa.bean.Couleur;
import fr.eni.jpa.bean.Region;
import fr.eni.jpa.dao.ICouleurRepository;
import fr.eni.jpa.dao.IRegionRepository;

@Service(value = "gestionRegion")
public class GestionRegion {

	@Autowired
	IRegionRepository rdao;

	// liste des bouteilles :
	public List<Region> listeregions() {
		return rdao.findAll();
	}

	// filtrer la liste bouteille et récuéprer une bouteille par son nom :
		public Region rechercherRegionByNom(String nom) {
			return rdao.findByNomContains(nom);
		}
	
}
