package sn.gouv.dpm.proprietaires.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Entity
@Table(name = "proprietaires")
public class Proprietaire implements Serializable
{
    @Id
    @Column(name = "proprietaire_id")
    private Integer proprietaireId;

    @Column(name = "cni_proprietaire", length = 15, nullable = false, unique = true)
    private Long cni;

    @Column(name = "date_delivrance")
    private Date dateDelivrance;

    @Column(name = "date_naissance")
    private Date dateNaissance;

    @Column(name = "nom_proprietaire")
    private String nom;

    @Column(name = "prenom_proprietaire")
    private String prenom;

    @Column(name = "nationalite_proprietaire")
    private String nationalite;

    @Column(name = "adresse_proprietaire")
    private String adresse;

    @Column(name = "telephone1_proprietaire")
    private String telephone1;

    @Column(name = "telephone2_proprietaire")
    private String telephone2;

    @Column(name = "ville_proprietaire")
    private String ville;

    @Column(name = "pays_proprietaire")
    private String pays;

	public Integer getProprietaireId() {
		return proprietaireId;
	}

	public void setProprietaireId(Integer proprietaireId) {
		this.proprietaireId = proprietaireId;
	}

	public Long getCni() {
		return cni;
	}

	public void setCni(Long cni) {
		this.cni = cni;
	}

	public Date getDateDelivrance() {
		return dateDelivrance;
	}

	public void setDateDelivrance(Date dateDelivrance) {
		this.dateDelivrance = dateDelivrance;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getNationalite() {
		return nationalite;
	}

	public void setNationalite(String nationalite) {
		this.nationalite = nationalite;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getTelephone1() {
		return telephone1;
	}

	public void setTelephone1(String telephone1) {
		this.telephone1 = telephone1;
	}

	public String getTelephone2() {
		return telephone2;
	}

	public void setTelephone2(String telephone2) {
		this.telephone2 = telephone2;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getPays() {
		return pays;
	}

	public void setPays(String pays) {
		this.pays = pays;
	}
    
}
