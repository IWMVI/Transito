package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import entities.Cidade;

public class Funcoes {

	Cidade[] c = new Cidade[3];

	public void showFuncoes(int opcao) {
		switch (opcao) {
		case 0:
			JOptionPane.showMessageDialog(null, "Finalizado!");
			break;

		case 1:
			for (int i = 0; i < c.length; i++) {
				String nome = JOptionPane.showInputDialog("Informe o nome da " + (i + 1) + "ª cidade");
				c[i] = new Cidade(nome);
			}
			break;

		case 2:
			if (c[0] != null) {
				for (Cidade atual : c) {
					int qtdAcidentes = Integer.parseInt(JOptionPane.showInputDialog(
							"Informe a quantidade de acidentes ocorridos na cidade: " + atual.getCidade()));
					atual.setAcidentes(qtdAcidentes);
				}
			}
			break;

		case 3:
			float total = 0;
			int cont = 0;

			for (Cidade atual : c) {
				if (atual != null) {
					total += atual.getAcidentes();
					cont++;
				}
			}
			if (cont > 0) {
				float media = total / cont;
				String formattedMedia = String.format("%.2f", media);
				JOptionPane.showMessageDialog(null, "Média de acidentes nas cidades: " + formattedMedia);
			} else {
				JOptionPane.showMessageDialog(null, "Nenhuma cidade cadastrada.");
			}
			break;

		case 4:
			try {
				String nome = JOptionPane.showInputDialog("Informe o nome do arquivo a ser salvo");
				BufferedWriter escrita = new BufferedWriter(new FileWriter(nome + ".txt"));
				for (Cidade atual : c) {
					escrita.write(atual.getCidade() + "\n");
					escrita.write(atual.getAcidentes() + "\n");
				}

				escrita.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo");
			}
			break;

		case 5:
			try {
				String nome = JOptionPane.showInputDialog("Informe o nome do arquivo");
				BufferedReader leitura = new BufferedReader(new FileReader(nome + ".txt"));
				Cidade[] read = new Cidade[3];

				for (int i = 0; i < read.length; i++) {
					read[i] = new Cidade();
					read[i].setCidade(leitura.readLine());
					read[i].setAcidentes(Integer.parseInt(leitura.readLine()));
				}
				c = read; // Carrega as informações da instância read pra instância c

				leitura.close();
			} catch (IOException e) {
				JOptionPane.showMessageDialog(null, "Erro ao ler arquivo");
			}
			break;

		default:
			JOptionPane.showMessageDialog(null, "Opção Inválida!");
			break;
		}
	}
}
