package com.paripassu.webdriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ChecklistPrincipal {
	 public static void main(String[] args) throws InterruptedException {
	        WebDriver driver = new FirefoxDriver();
	        driver.get("http://teste.vaga-qa.paripassudev.com/");
	        String usuario = "annabarbaram@gmail.com";
	        String password = "45367d7740";
	        @SuppressWarnings("unused")
			Identificacao id = new Identificacao(driver, usuario, password);
	        String novoAvaliado = "Sele��o Analista de testes";
	        Avaliado avaliado = new Avaliado(driver);
	        avaliado.cadastrarAvaliado(novoAvaliado);
	        String questao1 = "1.1 � Por que voc� est� interessado em trabalhar para esta empresa?";
	        String questao2 = "1.2 � Por que voc� trabalha na �rea de qualidade de software?";
	        String questao3 = "1.3 � Como voc� lida com problemas?";
		 	List<String> nomesQuestoes = new ArrayList<String>(3);
		 	nomesQuestoes.add(questao1);
		 	nomesQuestoes.add(questao2);
		 	nomesQuestoes.add(questao3);
	        Questionario questionario = new Questionario(driver);
			questionario.cadastrarQuestionario(nomesQuestoes);
	        String resposta1 = "A PariPassu existe na intersec��o de dois setores de incompar�vel import�ncia: a alimenta��o, indispens�vel para todos os seres vivos, e a tecnologia, o verdadeiro motor dos avan�os na sociedade humana. Colaborar com o cumprimento dos compromissos com a seguran�a alimentar, a responsabilidade social e o desenvolvimento sustent�vel assumidos pela empresa seria uma honra para mim. Acredito que tenho em comum com a PariPassu os valores �ticos, o desejo de crescer e a energia para avan�ar, o que pode tornar nosso trabalho em conjunto um grande ganho para todas as partes.";
	        String resposta2 = "Confesso que fui parar na �rea de qualidade meio sem querer, ao receber uma proposta de emprego enquanto migrava do setor de comunica��o para a tecnologia. Mas logo vi a import�ncia desse aspecto no desenvolvimento de software e de qualquer outro produto e entendi que minha forma��o havia me auxiliado a ter um olhar privilegiado para as atividades pertinentes, devido � minha aten��o aos detalhes, minha compreens�o da integra��o entre as partes e minha capacidade de avalia��o do todo. Mais do que uma porta de entrada, os testes, primeiramente manuais e depois automatizados, se transformaram na minha forma de abordar as problem�ticas e enfrentar os desafios, tornando o aprimoramento cont�nuo uma marca profunda em meu perfil.";
	        String resposta3 = "Resposta: Eu lido com os problemas da vida da mesma forma que meu primeiro professor de programa��o me ensinou a passar instru��es para o computador: decompondo as tarefas e ideias em pequenas partes, f�ceis de entender, processar, lidar e avan�ar para as pr�ximas. � assim que evito me assustar com o que parece muito diferente, novo, desafiador ou ousado. Ao observar os componentes fundamentais fica mais simples enxergar os padr�es e encontrar semelhan�as com coisas com as quais j� temos familiaridade. Mas quando eu sinto que j� me esforcei ao m�ximo para captar tudo o que posso e j� dei grandes passos a partir de meu ponto de partida, pode ser a hora de apelar para o 'peopleware', contando com a generosidade, vontade de compartilhar e determina��o de alcan�ar resultados em equipe daqueles que possuem mais experi�ncia e conhecimento do que eu.";
		 	List<String> respostas = new ArrayList<String>(3);
		 	respostas.add(resposta1);
		 	respostas.add(resposta2);
		 	respostas.add(resposta3);
	        questionario.aplicarQuestionario(respostas);
	   	 // driver.quit();
	   }
}
