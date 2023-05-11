import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class JogoDoDado {
    public static Scanner digite = new Scanner(System.in);
    public static Random gerarNumeroAleatorio = new Random();
    public static int dado = gerarNumeroAleatorio.nextInt(6) + 1;
    public static String nomeDoJogador;

    public static void main(String[] args) {
        System.out.println("Digite seu nome de jogador: ");
        nomeDoJogador = digite.next();

        menuDoJogo();
    }
    public static void menuDoJogo() {
        System.out.println("==========================");
        System.out.println("Menu do Jogo dos Dados");
        System.out.println("==========================");
        System.out.println("1-Para jogar | 2-Sair");
        System.out.println("");
        System.out.println("Digite a opção que deseja: ");
        opcaoEscolhida(digite.nextInt());
    }
    public static void opcaoEscolhida(int opcaoEscolhida) {
        switch (opcaoEscolhida) {
            case 1:
                receberNumeroDoUsuario();
                break;

            case 2:
                System.exit(0);
                break;

            default:
                System.out.println("Opção inválida");
        }
    }
    public static int numeroDoJogador;
    public static List<Integer> listaPontuacao = new ArrayList<>();
    public static void receberNumeroDoUsuario() {
        System.out.println("==========================");
        System.out.println("Jogue 4 rounds");
        System.out.println("==========================");

        for (int i = 1; i < 5; i++) {
            System.out.println("Round - " + i);
            System.out.println("Digite um número de 1 a 6: ");
            numeroDoJogador = digite.nextInt();
            verificarNumeroDoUsuario();

            System.out.println("Sua pontuação atual é de: " + pontuacaoAtual);
            System.out.println("==========================");
        }
        resultadoFinal();
    }
    public static int pontuacao, pontuacaoAtual, acertou, errou;
    public static void verificarNumeroDoUsuario() {
        if (numeroDoJogador < 1 || numeroDoJogador > 6) {
            System.out.println("Número inválido");
            System.exit(0);
        }
        else if (numeroDoJogador == dado) {
            System.out.println("----------");
            System.out.println("Você acertou o número do dado - ganhou 10 pontos!!");
            pontuacao = 10;
            pontuacaoAtual += pontuacao;
            acertou++;
            listaPontuacao.add(pontuacao);
        }
        else if (numeroDoJogador + 1 == dado || numeroDoJogador - 1 == dado) {
            System.out.println("----------");
            System.out.println("Você quase acertou o número do dado - ganhou 5 pontos");
            pontuacao = 5;
            pontuacaoAtual += pontuacao;
            acertou++;
            listaPontuacao.add(pontuacao);
        }
        else {
            System.out.println("----------");
            System.out.println("Você perdeu!");
            errou++;
        }
        System.out.println("----------");
        System.out.println("Número que você escolheu: " + numeroDoJogador);
        System.out.println("Número do dado: " + dado);
        System.out.println("----------");
    }
    public static void resultadoFinal() {
        System.out.println("FIM DE JOGO");
        System.out.println("==========================");
        System.out.println("Jogador: "+nomeDoJogador);

        int pontuacaoTotal = 0;
        for (int i = 0; i < listaPontuacao.size(); i++) {
            pontuacaoTotal += listaPontuacao.get(i);
        }

        System.out.println("Sua pontuação final foi de: " + pontuacaoTotal + " pontos");

        if (acertou == 4) {
            System.out.println("Você acertou todos os rounds");
        }
        else if (errou == 4) {
            System.out.println("Você errou todos os rounds");
        }
        else {
            System.out.println("Você acertou " +acertou +" round e errou " +errou);
        }
        jogadorDesejaContinuarJogando();
    }
    public static void jogadorDesejaContinuarJogando() {
        System.out.println("-------------");
        System.out.println("Você deseja: ");
        System.out.println("1-Jogar novamente | 2-Sair");
        int opcaoDoJogador = digite.nextInt();

        switch (opcaoDoJogador) {
            case 1:
                listaPontuacao.clear();
                pontuacaoAtual=0;
                acertou=0;
                errou=0;
                receberNumeroDoUsuario();
                break;

            case 2:
                System.out.println("Obrigado por jogar!");
                System.exit(0);
                break;

            default:
                System.out.println("Opção inválida");
        }
    }
}