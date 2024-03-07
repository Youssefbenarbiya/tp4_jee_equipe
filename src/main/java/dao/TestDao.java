package dao;

import java.util.List;

import metier.entities.Equipe;

public class TestDao {

	public static void main(String[] args) {
		EquipeDaoImpl pdao= new EquipeDaoImpl();
		Equipe prod= pdao.getEquipe(2L);
		System.out.println(prod);
		prod.setNomEquipe("toto");
		pdao.updateEquipe(prod);
		System.out.println("after update " +prod);
		
		
	}

}