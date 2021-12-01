package com.soumaya.produits.repos;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.soumaya.produits.entities.Client;
import com.soumaya.produits.entities.Produit;

@RepositoryRestResource(path = "rest")
public interface ProduitRepository extends JpaRepository<Produit, Long> {
	//@Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
	//List<Produit> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);
	@Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
	List<Produit> findByNomPrix (String nom, Double prix);
	List<Produit> findByNomProduitContains(String nom);
	List<Produit> findByNomProduit(String string);
	@Query("select p from Produit p where p.client = ?1")
	List<Produit> findByClient (Client client);
	List<Produit> findByClientIdCl(Long id);
	List<Produit> findByOrderByNomProduitAsc();
	@Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
	List<Produit> TrierProduitsNomsPrix();

}