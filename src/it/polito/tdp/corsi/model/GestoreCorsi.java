package it.polito.tdp.corsi.model;

import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.db.StudenteDAO;
import it.polito.tdp.corsi.model.Corso;

public class GestoreCorsi {

	CorsoDAO cdao = new CorsoDAO();
	StudenteDAO sdao = new StudenteDAO();

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

		return cdao.listCorsiByPD(periodo);

	}

	public Map<Corso, Integer> getIscrittiCorsi(int periodo) {
		return cdao.getIscrittiCorsi(periodo);
	}

	public List<Studente> elencaStudenti(String codins) {
		return sdao.elencaStudenti(codins);
	}

	public Map<Corso, Integer> getCDSPerCorso(String corso) {
		return cdao.getCDSPerCorso(corso);
	}

}
