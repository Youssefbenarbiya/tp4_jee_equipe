package dao;

import java.util.List;

import metier.entities.Equipe;

public interface IEquipeDao {
public Equipe save(Equipe p);
public List<Equipe> Equipe(String mc);
public Equipe Equipe(Long id);
public Equipe updateEquipe(Equipe p);
public void deleteEquipe(Long id);
}