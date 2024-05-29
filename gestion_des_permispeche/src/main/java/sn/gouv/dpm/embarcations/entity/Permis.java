package sn.gouv.dpm.embarcations.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "permis")
public class Permis implements Serializable
{
    @Id
    @Column(name = "id_permis")
    private Integer idPermis;

    @Column(name = "numero_perception", nullable = false, unique = true, length = 10)
    private Integer numeroPerception;

    @Column(name = "type_permis")
    private Character typePermis;

    @Column(name = "numero_permis", nullable = false, length = 11, unique = true)
    private String numeroPermis;

    @Column(name = "region_permis")
    private String region;

    @Column(name = "date_quitance")
    private Date dateQuitance;

    @Column(name = "date_debut_validite")
    private Date dateDebutValidite;

    @Column(name = "date_fin_validite")
    private Date dateFinValidite;

    @Column(name = "id_pirogue")
    private Integer idPirogue;

	public Integer getIdPermis() {
		return idPermis;
	}

	public void setIdPermis(Integer idPermis) {
		this.idPermis = idPermis;
	}

	public Integer getNumeroPerception() {
		return numeroPerception;
	}

	public void setNumeroPerception(Integer numeroPerception) {
		this.numeroPerception = numeroPerception;
	}

	public Character getTypePermis() {
		return typePermis;
	}

	public void setTypePermis(Character typePermis) {
		this.typePermis = typePermis;
	}

	public String getNumeroPermis() {
		return numeroPermis;
	}

	public void setNumeroPermis(String numeroPermis) {
		this.numeroPermis = numeroPermis;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public Date getDateQuitance() {
		return dateQuitance;
	}

	public void setDateQuitance(Date dateQuitance) {
		this.dateQuitance = dateQuitance;
	}

	public Date getDateDebutValidite() {
		return dateDebutValidite;
	}

	public void setDateDebutValidite(Date dateDebutValidite) {
		this.dateDebutValidite = dateDebutValidite;
	}

	public Date getDateFinValidite() {
		return dateFinValidite;
	}

	public void setDateFinValidite(Date dateFinValidite) {
		this.dateFinValidite = dateFinValidite;
	}

	public Integer getIdPirogue() {
		return idPirogue;
	}

	public void setIdPirogue(Integer idPirogue) {
		this.idPirogue = idPirogue;
	}
    
    public Permis() {}
}
