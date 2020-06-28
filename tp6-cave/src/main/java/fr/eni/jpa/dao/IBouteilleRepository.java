package fr.eni.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.jpa.bean.Bouteille;

public interface IBouteilleRepository extends JpaRepository<Bouteille, Integer>{
	
	//méthode pour trier les attributs par ordre asc ou desc :
	List<Bouteille> findAllByOrderByNomAsc();
	List<Bouteille> findAllByOrderByNomDesc();
	
	List<Bouteille> findAllByOrderByMillesimeAsc();
	List<Bouteille> findAllByOrderByMillesimeDesc();
	
	List<Bouteille> findAllByOrderByPetillantAsc();
	List<Bouteille> findAllByOrderByPetillantDesc();
	
	List<Bouteille> findAllByOrderByQuantiteAsc();
	List<Bouteille> findAllByOrderByQuantiteDesc();
	
	List<Bouteille> findAllByOrderByCouleurNomAsc();
	List<Bouteille> findAllByOrderByCouleurNomDesc();
	
	List<Bouteille> findAllByOrderByRegionNomAsc();
	List<Bouteille> findAllByOrderByRegionNomDesc();
	
	//méthode pour trier le vin par nom :
	List<Bouteille> findByNomContains(String nom);

}
