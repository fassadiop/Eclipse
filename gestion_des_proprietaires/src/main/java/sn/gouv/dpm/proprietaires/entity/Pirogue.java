package sn.gouv.dpm.proprietaires.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
//DTO Object
public class Pirogue implements Serializable
{
    private Integer idPirogue;
    private String immatriculation;
    private String nom;
    private String etat;
    private String nbrePecheur;
    private float longueur;
    private float largeur;
    private float creux;
    private String lieuConstruction;
    private String anneeConstruction;
    private Integer proprietaireId;
	public Integer getIdPirogue() {
		return idPirogue;
	}
	public void setIdPirogue(Integer idPirogue) {
		this.idPirogue = idPirogue;
	}
	public String getImmatriculation() {
		return immatriculation;
	}
	public void setImmatriculation(String immatriculation) {
		this.immatriculation = immatriculation;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEtat() {
		return etat;
	}
	public void setEtat(String etat) {
		this.etat = etat;
	}
	public String getNbrePecheur() {
		return nbrePecheur;
	}
	public void setNbrePecheur(String nbrePecheur) {
		this.nbrePecheur = nbrePecheur;
	}
	public float getLongueur() {
		return longueur;
	}
	public void setLongueur(float longueur) {
		this.longueur = longueur;
	}
	public float getLargeur() {
		return largeur;
	}
	public void setLargeur(float largeur) {
		this.largeur = largeur;
	}
	public float getCreux() {
		return creux;
	}
	public void setCreux(float creux) {
		this.creux = creux;
	}
	public String getLieuConstruction() {
		return lieuConstruction;
	}
	public void setLieuConstruction(String lieuConstruction) {
		this.lieuConstruction = lieuConstruction;
	}
	public String getAnneeConstruction() {
		return anneeConstruction;
	}
	public void setAnneeConstruction(String anneeConstruction) {
		this.anneeConstruction = anneeConstruction;
	}
	public Integer getProprietaireId() {
		return proprietaireId;
	}
	public void setProprietaireId(Integer proprietaireId) {
		this.proprietaireId = proprietaireId;
	}
	
	

}
