package sn.gouv.dpm.embarcations.entity;

import java.io.Serializable;
import java.util.Date;

//DTO Object
public class Permis implements Serializable
{
  private Integer idPermis;
  private Integer numeroPerception;
  private Character typePermis;
  private String numeroPermis;
  private String region;
  private Date dateQuitance;
  private Date dateDebutValidite;
  private Date dateFinValidite;
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

