package sn.gouv.dpm.embarcations.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pirogues")
public class Pirogue implements Serializable
{
    @Id
    @Column(name = "id_pirogue")
    private Integer idPirogue;

    @Column(name = "numero_immatriculation", nullable = false, unique = true,length = 11)
    private String immatriculation;

    @Column(name = "nom_pirogue")
    private String nom;

    @Column(name = "etat_pirogue")
    private String etat;

    @Column(name = "nbre_pecheur")
    private String nbrePecheur;

    @Column(name = "longueur_pirogue")
    private float longueur;

    @Column(name = "largeur_pirogue")
    private float largeur;

    @Column(name = "creux_pirogue")
    private float creux;

    @Column(name = "lieuconst_pirogue")
    private String lieuConstruction;

    @Column(name = "anneeconst_pirogue")
    private String anneeConstruction;

    @Column(name = "id_proprietaire")
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
    
    public Pirogue() 
    {
    	
    }

}
