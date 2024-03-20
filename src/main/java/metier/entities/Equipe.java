package metier.entities;

import java.io.Serializable;

public class Equipe implements Serializable{
	private Long idEquipe;
	private String nomEquipe;
	private double rank;
	
	public Equipe() {
		super();
	}
	public Equipe(String nomEquipe, double rank2) {
		super();
		this.nomEquipe = nomEquipe;
		this.rank = rank2;
	}
	public Long getIdEquipe() {
		return idEquipe;
	}
	public void setIdEquipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}
	public String getNomEquipe() {
		return nomEquipe;
	}
	public void setNomEquipe(String nomEquipe) {
		this.nomEquipe = nomEquipe;
	}
	public double getrank() {
		return rank;
	}
	public void setrank(double rank) {
		this.rank = rank;
	}
	@Override
	public String toString() {
		return "Equipe [idEquipe=" + idEquipe + ", nomEquipe=" + nomEquipe + ", rank=" + rank + "]";
	}
	
	
	
}
