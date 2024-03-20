package web;

import java.util.ArrayList;
import java.util.List;

import metier.entities.Equipe;

public class EquipeModele {
	private String motCle;
	List<Equipe> equipes = new ArrayList<>();
	
	
	public String getMotCle() {
		return motCle;
	}
	public void setMotCle(String motCle) {
		this.motCle = motCle;
	}
	public List<Equipe> getEquipes() {
		return equipes;
	}
	public void setEquipes(List<Equipe> equipes) {
		this.equipes = equipes;
	}
	
	

}
