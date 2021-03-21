# Projeto 01 – Funções de Espalhamento (hashing)

Neste projeto você irá encontrar a implementação de:

1. Função de espalhamento pelo método da divisão
1. Função de espalhamento pelo método da multiplicação

As quais estão presentes na classe HashFunctionSimulation no package com.hashfunction.hashfunctionsimulation;

Para a elaboração deste projeto, foi utilizado o Apache Maven e também o Spring Boot Framework, acesse [Tutorial maven](https://www.devmedia.com.br/introducao-ao-maven/25128) para mais informações, que torna o processo de compilação, gerenciamento do projeto, execução e validação muito mais simples, se você não utilizar o maven, pode seguir os passos abaixo

## Baixar os jars das dependências presentes no pom 

Acesse [mvnrepository](https://mvnrepository.com/) para baixar os jars

## Compilando os arquivos .java

Em Java a compilação também existe, só que não é gerado um arquivo contendo código em linguagem de máquina. É gerado uma forma intermediária entre o código de máquina e a linguagem de programação Java, chamado de Bytecode.
Os Bytecodes não são executados diretamente pelo sistema operacional, e sim interpretados por uma máquina virtual, a JVM (Java Virtual Machine). O arquivo .class pode ser interpretado em qualquer versão do Windows, Mac, Linux e Unix em geral desde que se tenha uma JVM específica para aquela plataforma instalada.
Após a compilação, o segundo passo é o carregador de classes ler os arquivos .class que contêm bytecodes a partir do disco rígido e colocar esses bytecodes na memória; após o carregamento, a próxima etapa é de verificação: o verificador de bytecode confirma que todos os bytecodes  são válidos e não  violam as restrições  de segurança do Java; por último, para executar  o programa, a JVM lê os bytecodes  e os compila (isto é, traduz) no momento certo (ou Just-in-Time) para uma linguagem que o computador possa entender. Fonte: [Compilando e Executando um Arquivo Java pela Linha de Comando](https://autociencia.blogspot.com/2016/09/compilando-e-executando-um-arquivo-java.html). Agora vamos ao passo a passo:

1. abrir o prompt de Comando(cmd);
1. `cd Desktop` , para acessar o diretório do desktop;
1. `java -version`, para saber a versão do Java instalado;
1. `dir`, lista todos os arquivos e pastas do diretório atual;
1. Identificando que o arquivo HashFunctionSimulation.java está presente no seu diretório atual, execute o próximo comando;
1. `javac -cp . HashFunctionSimulation.java`, o argumento `-cp` (classpath) destina em qual diretório a classe deverá ser armazenada. Nesse caso -cp aponta para o "." que é o diretório atual. Se nenhum diretório for especificado, com a omissão do argumento, então é armazenado no diretório atual.

Esses comandos são para windows, mas você pode ler em [Compilando e Executando um Arquivo Java pela Linha de Comando](https://autociencia.blogspot.com/2016/09/compilando-e-executando-um-arquivo-java.html) sobre os comandos no Linux e no Mac.

Os mesmos passos devem ser seguidos para compilar a classe HashFunctionSimulationTests, porém o comando 6 deve ser executado um pouco diferente: `javac -cp junit-4.12.jar;`. HashFunctionSimulationTests.java

## Executar os testes do JUnit Test

1. `java -cp junit-4.12.jar;jasperreports-6.4.0.jar;. org.junit.runner.JUnitCore HashFunctionSimulationTests`, é importante ressaltar que na nossa classe de teste também usamos recursos da biblioteca Jasper Reports


## O que irei obter com a execução dos testes?

Como vimos a classe HashFunctionSimulationTests, é responsável por executar uma serie de testes para demosntrar o funcionamento das funções de espalahmento, os testes são os seguintes:

### Função de espalhamento pelo método da divisão:
A função de espalhamento é definida como
h(k) = k mod m 
em que k é um número natural (chave), h(k) é a função de espalhamento e m é um número
natural. Os valores de h(k) ficam então restritos ao intervalo (0; 1; 2; : : : ; (m - 1)). Em geral,
recomenda-se que m seja escolhido como um número primo, não muito próximo de alguma potência de 2.

(a) Usando m = 12, faça um programa que teste sua função com valores de chave variando de 0 até 100. Quando o resultado h(x) for igual a 3, imprima o valor de chave correspondente. Você consegue notar um padrão para esses valores de chave?

```
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
```
A execução deste teste resulta na sáida:

|Valores de chave|
|----------------|
|chave 3|
|chave 15|
|chave 27|
|chave 39|
|chave 51|
|chave 63|
|chave 75|
|chave 87|
|chave 99|

O padrão dessas chaves é que elas fazem parte de uma progressão aritmética, na qual a
razão é 12.

(b) Repita o item anterior com m = 11 e imprimindo as chaves que resultam em h(x) = 3. Você consegue notar um padrão para esses valores de chave?

```
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
```
A execução deste teste resulta na sáida:

|Valores de chave|
|----------------|
|chave 3|
|chave 14|
|chave 25|
|chave 36|
|chave 47|
|chave 58|
|chave 69|
|chave 80|
|chave 91|

O padrão dessas chaves é que elas fazem parte de uma progressão aritmética, na qual a
razão é 11.

(c) Usando m = 97 (um número primo) conte o número de colisões para cada  valor diferente de h(k), usando chaves no intervalo {1, 2, 3, . . . , 10000}. Dica: você pode acumular as contagens em um vetor de m posições, inicialmente preenchido com zeros. A cada vez que você calcular um novo valor h(k), incremente a posição correspondente no vetor de contagens. Salve os resultados dessas contagens em um arquivo e faça um gráfico de número de colisões em função do valor do hash. Você pode salvar as contagens em um chave, contagem. O gráfico pode ser construído em um programa qualquer de planilhas, por exemplo.
```
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
```

A execução deste teste resultará na geração do gráfico, presente no arquivo *ContagemTestGamma.png* e de um arquivo csv chamado *ContagemTestGamma.csv*

### Função de espalhamento pelo método da multiplicação:
A função de espalhamento é definida como h(k) = [m × ((k × A)mod 1)] Em que k é a chave, m é o número de posições da tabela, A é uma constante não negativa, 0 < A < 1. O símbolo [x] representa a função chão, isto é, o maior inteiro que seja menor que x (arredondamento de x “para baixo”).

(a) Usando m = 200 e A = 0.62, faça um programa que teste sua função com valores de chave variando de 1 até 500 mil. Conte o número de colisões para cada valor diferente de h(k). Salve os resultados dessas contagens em um arquivo e faça um gráfico de número de colisões em função do valor do hash.
```
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
```
A execução deste teste resultará na geração do gráfico, presente no arquivo *ContagemTestDelta.png* e de um arquivo csv chamado *ContagemTestDelta.csv*

(b) Usando m = 200 e A = 0.61803398875 (número derivado da razão áurea), repita o item anterior. Compare os resultados de distribuição das colisões.
```
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
```
A execução deste teste resultará na geração do gráfico, presente no arquivo *ContagemTestEpsilon.png* e de um arquivo csv chamado *ContagemTestEpsilon.csv*]

O metódo *createGraphic(String title, int[] array)* é descrito abaixo:
```
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
```
