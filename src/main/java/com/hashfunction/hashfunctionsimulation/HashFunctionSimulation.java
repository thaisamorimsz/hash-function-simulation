package com.hashfunction.hashfunctionsimulation;

import java.lang.Math;

/* Classe responsável pela implementação da:
• Função de espalhamento pelo método da divisão
• Função de espalhamento pelo método da multiplicação
@author Thais Amorim Souza
 */

public class HashFunctionSimulation {

	/*
	 * Função de espalhamento pelo método da divisão: no método da divisão, a função
	 * de espalhamento é definida como h(k) = k mod m em que k é um número natural
	 * (chave), h(k) é a função de espalhamento e m é um número natural. Os valores
	 * de h(k) ficam então restritos ao intervalo {0, 1, 2, . . . ,(m − 1)}. Em
	 * geral, recomenda-se que m seja escolhido como um número primo, não muito
	 * próximo de alguma potência de 2.
	 */
	public int divisionMethod(int key, int m) throws Exception {
		return key % m;
	}

	/*
	 * Função de espalhamento pelo método da multiplicação: no método da
	 * multiplicação, a função de espalhamento é definida como h(k) = [m × ((k ×
	 * A)mod 1)] Em que k é a chave, m é o número de posições da tabela, A é uma
	 * constante não negativa, 0 < A < 1. O símbolo [x] representa a função chão,
	 * isto é, o maior inteiro que seja menor que x (arredondamento de x “para
	 * baixo”).
	 */
	public int multiplicationMethod(int key, int m, float a) throws Exception {
		double h = (m * ((key * a) % 1));
		return arredondar(h);
	}

	private static int arredondar(double h) throws Exception {
		return (int) Math.floor(h);
	}
}
