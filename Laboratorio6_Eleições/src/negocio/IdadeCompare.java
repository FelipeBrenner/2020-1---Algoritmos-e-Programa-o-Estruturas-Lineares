package negocio;

import java.util.Comparator;

public class IdadeCompare implements Comparator<Candidato>{

	@Override
	public int compare(Candidato c1, Candidato c2) {
		if(c1.getIdade()>c2.getIdade())
			return 1;
		if(c1.getIdade()<c2.getIdade())
			return -1;
		return 0;
	}

}
