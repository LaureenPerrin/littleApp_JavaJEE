package fr.eni.jpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.eni.jpa.bean.Bouteille;
import fr.eni.jpa.dao.IBouteilleRepository;

@Service(value = "gestionBouteille")
public class GestionBouteille {

	@Autowired
	IBouteilleRepository bdao;

	// liste des bouteilles :
	public List<Bouteille> listeBouteille() {
		return bdao.findAll();
	}

	// récupérer une bouteille :
	public Bouteille rechercherBouteille(int id) {
		return bdao.findOne(id);
	}

	// filtrer la liste bouteille et récuéprer une bouteille par son nom :
	public List<Bouteille> rechercherBouteilleByNom(String nom) {
		return bdao.findByNomContains(nom);
	}

	// Trier les colonnes asc ou desc :
	// pour le nom :
	public List<Bouteille> trierListeByNomAsc() {
		return bdao.findAllByOrderByNomAsc();
	}

	public List<Bouteille> trierListeByNomDesc() {
		return bdao.findAllByOrderByNomDesc();
	}

	// pour le millesime :
	public List<Bouteille> trierListeByMillesimeAsc() {
		return bdao.findAllByOrderByMillesimeAsc();
	}

	public List<Bouteille> trierListeByMillesimeDesc() {
		return bdao.findAllByOrderByMillesimeDesc();
	}

	// pour le pettilant :
	public List<Bouteille> trierListeByPetillantAsc() {
		return bdao.findAllByOrderByPetillantAsc();
	}

	public List<Bouteille> trierListeByPetillantDesc() {
		return bdao.findAllByOrderByPetillantDesc();
	}

	// pour la quantité :
	public List<Bouteille> trierListeByQuantiteAsc() {
		return bdao.findAllByOrderByQuantiteAsc();
	}

	public List<Bouteille> trierListeByQuantiteDesc() {
		return bdao.findAllByOrderByQuantiteDesc();
	}
	
	// pour la couleur :
	public List<Bouteille> trierListeByCouleurAsc() {
		return bdao.findAllByOrderByCouleurNomAsc();
	}

	public List<Bouteille> trierListeByCouleurDesc() {
		return bdao.findAllByOrderByCouleurNomDesc();
	}
	
	// pour la région :
	public List<Bouteille> trierListeByRegionAsc() {
		return bdao.findAllByOrderByRegionNomAsc();
	}

	public List<Bouteille> trierListeByRegionDesc() {
		return bdao.findAllByOrderByRegionNomDesc();
	}

	// Crud :
	  //ajouter une bouteille :
	public void ajouterBouteille(Bouteille b){
		bdao.save(b);
	}	
	
	  //modifier une bouteille :
	public void modifierBouteille(Bouteille b){
		bdao.save(b);
	}	
	
	  //supprimer une bouteille avec l'objet :
	public void supprimerBouteille(Bouteille b){
		bdao.delete(b);
	}
	
	  //suppimer une bouteille avec l'id :
	public void supprimerBouteille(int id){
		bdao.delete(id);
	}
	

}
