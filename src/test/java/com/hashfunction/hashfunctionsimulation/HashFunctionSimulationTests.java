package com.hashfunction.hashfunctionsimulation;

import java.awt.Color;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.junit.Before;
import org.junit.Test;

public class HashFunctionSimulationTests {

	private HashFunctionSimulation hash;

	@Before
	public void startup() {
		hash = new HashFunctionSimulation();
	}

	// Função de espalhamento pelo método da divisão:

	/*
	 * (a) Usando m = 12, faça um programa que teste sua função com valores de chave
	 * variando de 0 até 100. Quando o resultado h(x) for igual a 3, imprima o valor
	 * de chave correspondente. Você consegue notar um padrão para esses valores de
	 * chave?
	 */
	@Test
	public void TestAlpha() throws Exception {
		int m = 12;

		for (int key = 0; key < 100; key = key + 1) {
			int h = hash.divisionMethod(key, m);
			if (h == 3) {
				System.out.println("chave " + String.valueOf(key));
			}

		}
	}

	/*
	 * (b) Repita o item anterior com m = 11 e imprimindo as chaves que resultam em
	 * h(x) = 3. Você consegue notar um padrão para esses valores de chave?
	 */
	@Test
	public void TestBetha() throws Exception {
		int m = 11;

		for (int key = 0; key < 100; key = key + 1) {
			int h = hash.divisionMethod(key, m);
			if (h == 3) {
				System.out.println("chave " + String.valueOf(key));
			}

		}
	}

	/*
	 * (c) Usando m = 97 (um número primo) conte o número de colisões para cada
	 * valor diferente de h(k), usando chaves no intervalo {1, 2, 3, . . . , 10000}.
	 * Dica: você pode acumular as contagens em um vetor de m posições, inicialmente
	 * preenchido com zeros. A cada vez que você calcular um novo valor h(k),
	 * incremente a posição correspondente no vetor de contagens. Salve os
	 * resultados dessas contagens em um arquivo e faça um gráfico de número de
	 * colisões em função do valor do hash. Você pode salvar as contagens em um
	 * arquivo de valores separados por vírgula, em que cada linha tem o formato
	 * chave, contagem. O gráfico pode ser construído em um programa qualquer de
	 * planilhas, por exemplo.
	 */
	@Test
	public void TestGamma() throws Exception {
		int m = 97;
		int[] array = new int[m];
		int sum = 0;

		for (int i = 0; i < m; i++) {
			array[i] = 0;
		}

		for (int key = 0; key < 10000; key = key + 1) {
			int h = hash.divisionMethod(key, m);
			array[h] = array[h] + 1;

		}

		for (int i = 0; i < m; i++) {
			sum = sum + array[i];
			System.out.println("chave: " + i + "- contagem: " + array[i]);
		}
		System.out.println("Quantidade de keys: " + sum);

		createGraphic("ContagemTestGamma", array);

	}

	// Função de espalhamento pelo método da multiplicação:

	/*
	 * (a) Usando m = 200 e A = 0.62, faça um programa que teste sua função com
	 * valores de chave variando de 1 até 500 mil. Conte o número de colisões para
	 * cada valor diferente de h(k). Salve os resultados dessas contagens em um
	 * arquivo e faça um gráfico de número de colisões em função do valor do hash.
	 * 
	 */
	@Test
	public void TestDelta() throws Exception {
		int m = 200;
		float a = Float.valueOf("0.62");
		int sum = 0;
		int[] array = new int[m];

		for (int i = 0; i < m; i++) {
			array[i] = 0;
		}

		for (int key = 1; key < 500000; key = key + 1) {
			int h = hash.multiplicationMethod(key, m, a);
			array[h] = array[h] + 1;

		}

		for (int i = 0; i < m; i++) {
			sum = sum + array[i];
			System.out.println("chave: " + i + "- contagem: " + array[i]);
		}
		System.out.println("Quantidade de keys: " + sum);

		createGraphic("ContagemTestDelta", array);
	}

	/*
	 * (b) Usando m = 200 e A = 0.61803398875 (número derivado da razão áurea),
	 * repita o item anterior. Compare os resultados de distribuição das colisões.
	 */
	@Test
	public void TestEpsilon() throws Exception {
		int m = 200;
		float a = Float.valueOf("0.61803398875");
		int sum = 0;
		int[] array = new int[m];

		for (int i = 0; i < m; i++) {
			array[i] = 0;
		}

		for (int key = 1; key < 500000; key = key + 1) {
			int h = hash.multiplicationMethod(key, m, a);
			array[h] = array[h] + 1;

		}

		for (int i = 0; i < m; i++) {
			sum = sum + array[i];
			System.out.println("chave: " + i + "- contagem: " + array[i]);
		}
		System.out.println("Quantidade de keys: " + sum);
		createGraphic("ContagemTestEpsilon", array);
	}

	private void createGraphic(String title, int[] array) throws IOException {

		File arquivotxt = new File(title + ".csv");
		FileWriter fw = new FileWriter(arquivotxt);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write("hash" + "," + "número de colisões");
		bw.newLine();

		XYSeries series = new XYSeries("Quantidade de colisões");
		for (int i = 0; i < array.length; i++) {
			series.add(i, array[i]);

			// escreve no arquivo
			bw.write(String.valueOf(i) + "," + String.valueOf(array[i]));
			bw.newLine();
		}
		bw.close();
		fw.close();

		XYDataset dataset = new XYSeriesCollection(series);

		JFreeChart chart = ChartFactory.createXYLineChart("Quantidade de colisões", "hash", "número de colisões",
				dataset, org.jfree.chart.plot.PlotOrientation.VERTICAL, true, false, false);
		XYPlot xyPlot = (XYPlot) chart.getPlot();
		xyPlot.getRenderer().setSeriesPaint(0, Color.BLUE);
		chart.getPlot().setBackgroundPaint(Color.WHITE);

		try {
			ChartUtilities.saveChartAsJPEG(new java.io.File(title + ".jpg"), chart, 2480, 1748);
		} catch (java.io.IOException exc) {
			System.err.println("Error writing image to file");
		}
	}

}
