package negocio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class Curso {
	private ArrayList<Aluno> alunos;
	private ArrayList<Disciplina> disciplinas;
	private ArrayList<NotasAlunoDisciplina> notas;
	
	public Curso() {
		alunos = new ArrayList<Aluno>();
		disciplinas = new ArrayList<Disciplina>();
		notas = new ArrayList<NotasAlunoDisciplina>();
	}
	
	public ArrayList<Aluno> getAlunos() {
		return alunos;
	}
	
	public Aluno getAluno(int codigoAluno) {
		for(Aluno a : alunos)
			if(a.getCodigo() == codigoAluno)
				return a;
		return null;
	}
	
	public ArrayList<Disciplina> getDisciplinas() {
		return disciplinas;
	}
	
	public Disciplina getDisciplina(int codigoDisciplina) {
		for(Disciplina d : disciplinas)
			if(d.getCodigo() == codigoDisciplina)
				return d;
		return null;
	}
	
	public ArrayList<NotasAlunoDisciplina> getNotas() {
		return notas;
	}
	
	public NotasAlunoDisciplina getVinculo(int codigoAluno, int codigoDisciplina) {
		for(NotasAlunoDisciplina n : notas)
			if(n.getCodigoAluno() == codigoAluno && n.getCodigoDisciplina() == codigoDisciplina)
				return n;
		return null;
	}
	
	public boolean inserirAluno(Aluno a) {
		// Verifica se aluno já não existe
		for(Aluno i : alunos)
			if(i.getCodigo() == a.getCodigo())
				return false;
		// Adiciona aluno
		alunos.add(a);
		Collections.sort(alunos);
		return true;
	}
	
	public boolean inserirDisciplina(Disciplina d) {
		// Verifica se disciplina já não existe
		for(Disciplina i : disciplinas)
			if(i.getCodigo() == d.getCodigo())
				return false;
		// Adiciona disciplina
		disciplinas.add(d);
		Collections.sort(disciplinas);
		return true;
	}
	
	public boolean vincularDisciplinaAluno(int codigoAluno, int codigoDisciplina) {
		// Verifica se já não existe vínculo
		for(NotasAlunoDisciplina n : notas) {
			if(n.getCodigoAluno() == codigoAluno && n.getCodigoDisciplina() == codigoDisciplina)
				return false;
		}
		// Cria vínculo
		notas.add(new NotasAlunoDisciplina(codigoAluno,codigoDisciplina));
		Collections.sort(notas);
		return true;
	}
	
	public void calcularMedia() {
		for(NotasAlunoDisciplina n : notas) {
			n.calculaMediaAritmetica();
			n.calculaMediaPonderada();
		}
	}
	
	public void leArquivos() throws IOException {
		File objFile;
		InputStream is;
		InputStreamReader isr;
		BufferedReader br;
		String s[];
		String l;
		
		objFile= new File("Alunos.txt");
		if (objFile.exists()) {
			is = new FileInputStream("Alunos.txt");
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			l = br.readLine();
			
			while(l != null) {
				s = l.split(";");
				alunos.add(new Aluno(Integer.valueOf(s[0]),s[1]));
				l = br.readLine();
			}
			
			br.close();
		}
		
		objFile = new File("Disciplinas.txt");
		if (objFile.exists()) {
			is = new FileInputStream("Disciplinas.txt");
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			l = br.readLine();
			
			while(l != null) {
				s = l.split(";");
				disciplinas.add(new Disciplina(Integer.valueOf(s[0]),s[1]));
				l = br.readLine();
			}
			
			br.close();
		}
		
		objFile = new File("Notas.txt");
		if (objFile.exists()) {
			is = new FileInputStream("Notas.txt");
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
			l = br.readLine();
			
			while(l != null) {
				s = l.split(";");
				notas.add(new NotasAlunoDisciplina(Integer.valueOf(s[0]),Integer.valueOf(s[1]),Double.valueOf(s[2]),Double.valueOf(s[3]),Double.valueOf(s[4]),Double.valueOf(s[5])));
				l = br.readLine();
			}
			
			br.close();
		}
	}
	
	public void gravaArquivos() throws IOException {
		FileWriter arq;
		PrintWriter gravarArq;
		
		arq = new FileWriter("Alunos.txt");
		gravarArq = new PrintWriter(arq);
		for(Aluno a : alunos)
			gravarArq.println(a.toStringFile());
		arq.close();
		
		arq = new FileWriter("Disciplinas.txt");
		gravarArq = new PrintWriter(arq);
		for(Disciplina d : disciplinas)
			gravarArq.println(d.toStringFile());
		arq.close();
		
		arq = new FileWriter("Notas.txt");
		gravarArq = new PrintWriter(arq);
		for(NotasAlunoDisciplina n : notas)
			gravarArq.println(n.toStringFile());
		arq.close();
	}
	
}
