package entities;

public class Cidade {

	private String cidade;
	private int acidentes;
	private double estatisticas;

	public Cidade() {

	}

	public Cidade(String cidade) {
		this.cidade = cidade;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public int getAcidentes() {
		return acidentes;
	}

	public void setAcidentes(int acidentes) {
		this.acidentes = acidentes;
	}

	public double getEstatisticas() {
		return estatisticas;
	}

	public void setEstatisticas(double estatisticas) {
		this.estatisticas = estatisticas;
	}
}
