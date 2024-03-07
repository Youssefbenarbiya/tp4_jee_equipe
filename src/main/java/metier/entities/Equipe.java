package metier.entities;

import java.io.Serializable;

public class Equipe implements Serializable{
	private Long idEquipe;
	private String nomEquipe;
	private double rank;
	
	public Equipe() {
		super();
	}
	public Equipe(String nomEquipe, double rank) {
		super();
		this.nomEquipe = nomEquipe;
		this.rank = rank;
	}
	public Long getIdEquipe() {
		return idEquipe;
	}
	public void Equipe(Long idEquipe) {
		this.idEquipe = idEquipe;
	}
	public String getNomEquipe() {
		return nomEquipe;
	}
	public void setNomEquipe(long l) {
		this.nomEquipe = l;
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
