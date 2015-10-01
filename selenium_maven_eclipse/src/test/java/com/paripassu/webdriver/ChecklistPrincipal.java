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
	        String novoAvaliado = "Seleção Analista de testes";
	        Avaliado avaliado = new Avaliado(driver);
	        avaliado.cadastrarAvaliado(novoAvaliado);
	        String questao1 = "1.1 – Por que você está interessado em trabalhar para esta empresa?";
	        String questao2 = "1.2 – Por que você trabalha na área de qualidade de software?";
	        String questao3 = "1.3 – Como você lida com problemas?";
		 	List<String> nomesQuestoes = new ArrayList<String>(3);
		 	nomesQuestoes.add(questao1);
		 	nomesQuestoes.add(questao2);
		 	nomesQuestoes.add(questao3);
	        Questionario questionario = new Questionario(driver);
			questionario.cadastrarQuestionario(nomesQuestoes);
	        String resposta1 = "A PariPassu existe na intersecção de dois setores de incomparável importância: a alimentação, indispensável para todos os seres vivos, e a tecnologia, o verdadeiro motor dos avanços na sociedade humana. Colaborar com o cumprimento dos compromissos com a segurança alimentar, a responsabilidade social e o desenvolvimento sustentável assumidos pela empresa seria uma honra para mim. Acredito que tenho em comum com a PariPassu os valores éticos, o desejo de crescer e a energia para avançar, o que pode tornar nosso trabalho em conjunto um grande ganho para todas as partes.";
	        String resposta2 = "Confesso que fui parar na área de qualidade meio sem querer, ao receber uma proposta de emprego enquanto migrava do setor de comunicação para a tecnologia. Mas logo vi a importância desse aspecto no desenvolvimento de software e de qualquer outro produto e entendi que minha formação havia me auxiliado a ter um olhar privilegiado para as atividades pertinentes, devido à minha atenção aos detalhes, minha compreensão da integração entre as partes e minha capacidade de avaliação do todo. Mais do que uma porta de entrada, os testes, primeiramente manuais e depois automatizados, se transformaram na minha forma de abordar as problemáticas e enfrentar os desafios, tornando o aprimoramento contínuo uma marca profunda em meu perfil.";
	        String resposta3 = "Resposta: Eu lido com os problemas da vida da mesma forma que meu primeiro professor de programação me ensinou a passar instruções para o computador: decompondo as tarefas e ideias em pequenas partes, fáceis de entender, processar, lidar e avançar para as próximas. É assim que evito me assustar com o que parece muito diferente, novo, desafiador ou ousado. Ao observar os componentes fundamentais fica mais simples enxergar os padrões e encontrar semelhanças com coisas com as quais já temos familiaridade. Mas quando eu sinto que já me esforcei ao máximo para captar tudo o que posso e já dei grandes passos a partir de meu ponto de partida, pode ser a hora de apelar para o 'peopleware', contando com a generosidade, vontade de compartilhar e determinação de alcançar resultados em equipe daqueles que possuem mais experiência e conhecimento do que eu.";
		 	List<String> respostas = new ArrayList<String>(3);
		 	respostas.add(resposta1);
		 	respostas.add(resposta2);
		 	respostas.add(resposta3);
	        questionario.aplicarQuestionario(respostas);
	   	 // driver.quit();
	   }
}
