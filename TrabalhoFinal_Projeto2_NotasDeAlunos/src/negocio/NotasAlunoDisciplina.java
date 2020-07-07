package negocio;

import java.text.DecimalFormat;

public class NotasAlunoDisciplina implements Comparable<NotasAlunoDisciplina> {
	private int codigoAluno;
	private int codigoDisciplina;
	private double nota1;
	private double nota2;
	private double mediaAritmetica;
	private double mediaPonderada;
	
	public NotasAlunoDisciplina(int codigoAluno, int codigoDisciplina) {
		this.codigoAluno = codigoAluno;
		this.codigoDisciplina = codigoDisciplina;
	}
	
	public NotasAlunoDisciplina(int codigoAluno, int codigoDisciplina, double nota1, double nota2) {
		this.codigoAluno = codigoAluno;
		this.codigoDisciplina = codigoDisciplina;
		this.nota1 = nota1;
		this.nota2 = nota2;
	}
	
	public NotasAlunoDisciplina(int codigoAluno, int codigoDisciplina, double nota1, double nota2, double mediaAritmetica, double mediaPonderada) {
		this.codigoAluno = codigoAluno;
		this.codigoDisciplina = codigoDisciplina;
		this.nota1 = nota1;
		this.nota2 = nota2;
		this.mediaAritmetica = mediaAritmetica;
		this.mediaPonderada = mediaPonderada;
	}
	
	public int getCodigoAluno() {
		return codigoAluno;
	}
	
	public void setCodigoAluno(int codigoAluno) {
		this.codigoAluno = codigoAluno;
	}
	
	public int getCodigoDisciplina() {
		return codigoDisciplina;
	}
	
	public void setCodigoDisciplina(int codigoDisciplina) {
		this.codigoDisciplina = codigoDisciplina;
	}
	
	public double getNota1() {
		return nota1;
	}
	
	public void setNota1(double nota1) {
		this.nota1 = nota1;
	}
	
	public double getNota2() {
		return nota2;
	}
	
	public void setNota2(double nota2) {
		this.nota2 = nota2;
	}
	
	public double getMediaAritmetica() {
		return mediaAritmetica;
	}
	
	public void setMediaAritmetica(double mediaAritmetica) {
		this.mediaAritmetica = mediaAritmetica;
	}
	
	public void calculaMediaAritmetica() {
		mediaAritmetica = (nota1+nota2)/2;
	}
	
	public double getMediaPonderada() {
		return mediaPonderada;
	}
	
	public void setMediaPonderada(double mediaPonderada) {
		this.mediaPonderada = mediaPonderada;
	}
	
	public void calculaMediaPonderada() {
		mediaPonderada = (nota1+2*nota2)/3;
	}
	
	public double converterDoubleDoisDecimais(double d) {
	    DecimalFormat df = new DecimalFormat("0.00");      
	    String string = df.format(d);
	    String[] part = string.split("[,]");
	    String string2 = part[0]+"."+part[1];
	        double d2 = Double.parseDouble(string2);
	    return d2;
	}
	
	public String toStringFile() {
		return codigoAluno + ";" + codigoDisciplina + ";" + nota1 + ";" + nota2 + ";" + mediaAritmetica + ";" + mediaPonderada;
	}
	
	@Override
	public String toString() {
		String s = "\tNota 1: " + nota1 + "\tNota 2: " +  nota2 + "\tMédia Aritmética: " + converterDoubleDoisDecimais(mediaAritmetica) + "\tMédia Ponderada: " + converterDoubleDoisDecimais(mediaPonderada);
		
				if(mediaPonderada>=7)
					s += "\tAprovado";
				else
					s += "\tReprovado";
				
				return s;
	}
	
	@Override
	public int compareTo(NotasAlunoDisciplina c) {
		if(codigoAluno > c.codigoAluno || codigoAluno == c.codigoAluno && codigoDisciplina > c.codigoDisciplina)
			return 1;
		if(codigoAluno < c.codigoAluno || codigoAluno == c.codigoAluno && codigoDisciplina < c.codigoDisciplina)
			return -1;
		return 0;
	}
	
}
