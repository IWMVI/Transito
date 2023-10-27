package view;

import javax.swing.JOptionPane;

public class Menu {

	private int opcao;

	public int getOpcao() {
		return opcao;
	}

	public void showMenu() {
		opcao = Integer.parseInt(JOptionPane.showInputDialog(null,
				"                   MENU\n\n01. Cadastrar Cidade\n02. Cadastrar acidente\n03. Estatísticas\n04. Gravar arquivo\n05. Ler arquivo\n00. Finalizar"));
	}
}
