package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import metier.SingletonConnection;
import metier.entities.Equipe;

public class EquipeDaoImpl implements IEquipeDao {

	@Override
	public Equipe save(Equipe p) {
		 Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("INSERT INTO equipe(NOM_equipe,rank) VALUES(?,?)");
			ps.setString(1, p.getNomEquipe());
			ps.setDouble(2, p.getrank());
			ps.executeUpdate();
			
			
			PreparedStatement ps2= conn.prepareStatement
					("SELECT MAX(ID_equipe) as MAX_ID FROM equipe");
			ResultSet rs =ps2.executeQuery();
			if (rs.next()) {
				p.setIdEquipe(rs.getLong("MAX_ID"));
			}
			ps.close();
			ps2.close();
				 
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public List<Equipe> equipeParMC(String mc) {
	      List<Equipe> prods= new ArrayList<Equipe>();
	       Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from equipe where NOM_equipe LIKE ?");
			ps.setString(1, "%"+mc+"%");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Equipe p = new Equipe();
				p.setIdEquipe(rs.getLong("ID_equipe"));
				p.setNomEquipe(rs.getString("NOM_equipe"));
				p.setrank(rs.getDouble("rank"));
				prods.add(p);								
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}

			return prods;
	}

	@Override
	public Equipe getEquipe(Long id) {
		    
		   Connection conn=SingletonConnection.getConnection();
		    Equipe p = new Equipe();
	       try {
			PreparedStatement ps= conn.prepareStatement("select * from equipe where ID_equipe = ?");
			ps.setLong(1, id);
			ResultSet rs = ps.executeQuery();
			if  (rs.next()) {
				
				p.setIdEquipe(rs.getLong("ID_equipe"));
				p.setNomEquipe(rs.getString("NOM_equipe"));
				p.setrank(rs.getDouble("rank"));
			}
				
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
			return p;
	}

	@Override
	public Equipe updateEquipe(Equipe p) {
		Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("UPDATE equipe SET NOM_equipe=?,rank=? WHERE ID_equipe=?");
			ps.setString(1, p.getNomEquipe());
			ps.setDouble(2, p.getrank());
			ps.setLong(3, p.getIdEquipe());
			ps.executeUpdate();
			ps.close();
					
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		return p;
	}

	@Override
	public void deleteEquipe(Long id) {
		 Connection conn=SingletonConnection.getConnection();
	       try {
			PreparedStatement ps= conn.prepareStatement("DELETE FROM equipe WHERE ID_equipe = ?");
			ps.setLong(1, id);
			ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}