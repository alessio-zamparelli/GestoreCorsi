package it.polito.tdp.corsi.model;

import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.model.Corso;

public class GestoreCorsi {

	CorsoDAO dao = new CorsoDAO();

	public List<Corso> getCorsiByPeriodo(int periodo) {

//		List<Corso> corsi = dao.listAll();
//		List<Corso> result = new ArrayList<Corso>();
//
//		for (Corso c : corsi) {
//			if (c.getPd() == periodo)
//				result.add(c);
//		}
//
//		return result;

		return dao.listCorsiByPD(periodo);

	}

	public Map<Corso, Integer> getIscrittiCorsi(int periodo) {
		return dao.getIscrittiCorsi(periodo);
	}

}
