package dao;

import java.util.List;

import metier.entities.Equipe;

public interface IEquipeDao {
public Equipe save(Equipe p);
public List<Equipe> equipesParMC(String mc);
public Equipe getEquipe(Long id);
public Equipe updateEquipe(Equipe p);
public void deleteEquipe(Long id);
}
