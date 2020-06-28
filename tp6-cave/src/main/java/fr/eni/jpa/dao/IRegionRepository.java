package fr.eni.jpa.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import fr.eni.jpa.bean.Region;

public interface IRegionRepository extends JpaRepository<Region, Integer>{

	//m�thode pour trier le vin par nom :
		Region findByNomContains(String nom);
}
