package com.soumaya.produits.restcontrollers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;


import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import com.soumaya.produits.entities.Produit;
import com.soumaya.produits.service.ProduitService;
@SpringBootApplication
//@RestController("/search")
@RestController
@RequestMapping("/rest")
@CrossOrigin
@ResponseBody
public class ProduitRESTController {
@Autowired
ProduitService produitService;
@RequestMapping(method = RequestMethod.GET)
public List<Produit> getAllProduits() {
return produitService.getAllProduits();
}

@RequestMapping(value="/{id}",method = RequestMethod.GET)
public Produit getProduitById(@PathVariable("id") Long id) {
return produitService.getProduit(id);

}

@RequestMapping(method = RequestMethod.POST)
public Produit createProduit(@RequestBody Produit produit) {
return produitService.saveProduit(produit);
}

@RequestMapping(method = RequestMethod.PUT)
public Produit updateProduit(@RequestBody Produit produit) {
return produitService.updateProduit(produit);
}
@RequestMapping(value="/{id}",method = RequestMethod.DELETE)
public void deleteProduit(@PathVariable("id") Long id)
{
produitService.deleteProduitById(id);
}

@RequestMapping(value="/prodscl/{idCl}",method = RequestMethod.GET)
public List<Produit> getProduitsByClId(@PathVariable("idCl") Long idCl) {
return produitService.findByClientIdCl(idCl);
}
}