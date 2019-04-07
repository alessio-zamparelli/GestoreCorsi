package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.model.Corso;

public class CorsoDAO {

	public List<Corso> listAll() {
		String sql = "SELECT * FROM corso";
		List<Corso> result = new LinkedList<Corso>();

		try {

			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"),
						rs.getInt("pd"));
				result.add(c);
			}

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;

	}

	public List<Corso> listCorsiByPD(int periodo) {
		String sql = "SELECT * FROM corso WHERE pd=?";
		List<Corso> result = new LinkedList<Corso>();

		try {

			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"),
						rs.getInt("pd"));
				result.add(c);
			}

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	public Map<Corso, Integer> getIscrittiCorsi(int periodo) {

		String sql = "SELECT c.codins, c.nome, c.crediti, c.pd, COUNT(*) AS tot FROM corso AS C, iscrizione as i "
				+ "WHERE c.codins = i.codins and c.pd=? GROUP BY c.codins, c.nome, c.crediti, c.pd";

		Map<Corso, Integer> result = new HashMap<Corso, Integer>();

		try {

			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setInt(1, periodo);
			ResultSet rs = st.executeQuery();

			while (rs.next())

				result.put(
						new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd")),
						rs.getInt("tot"));

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

		return result;
	}

	public Map<Corso, Integer> getCDSPerCorso(String corso) {
		String sql = "SELECT s.CDS, COUNT(s.CDS) as cnt FROM iscrizione i, studente s, corso c "
				+ "WHERE i.codins = c.codins AND s.matricola = i.matricola AND i.codins = ? GROUP BY s.cds";

		Map<Corso, Integer> result = new HashMap<Corso, Integer>();

		try {

			Connection conn = ConnectDB.getConnection();
			PreparedStatement st = conn.prepareStatement(sql);
			st.setString(1, corso);
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				Corso c = new Corso(rs.getString("codins"), rs.getInt("crediti"), rs.getString("nome"), rs.getInt("pd"));
				result.put(c, rs.getInt("cnt"));
			}

			conn.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

}
