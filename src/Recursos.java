import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.function.IntBinaryOperator;
import java.util.stream.Collectors;

public class Recursos {
    public static void mostrar_piramide(List<List<Integer>> listaDeListas){
        // efeito visual para o cmd
        System.out.println("-----PIRÂMIDE-----");
        for (List<Integer> lista: listaDeListas) {
            System.out.println(lista);
        }
    }
    public static List<List<Integer>> retornar_linhas_piramide(List<Integer> listaNums){
        // criar uma lista de listas
        List<List<Integer>> tempListaDeListas = new ArrayList<>();

        // variavel para percorrer o index
        int index = 0;
        // tamanho da lista (-1 para ir até o ultimo indice)
        int len = listaNums.size() - 1;

        // mostrar na tela
        for (int i = 0; i < len; i++) {
            // criar lista temporaria
            List<Integer> tempList = new ArrayList<>();
            for (int j = 0; j < i; j++) {

                // verificar se é o index é maior que o tamanho da lista
                if (index > len)
                        break;

                // percorrer atraves da linked list usando get e adicionando na temp list
                tempList.add(listaNums.get(index));
                System.out.print(tempList);

                // incrementar index
                index++;
            }
            // copiar valores da temp list e alocar na lista de listas
            tempListaDeListas.add(tempList.stream().collect(Collectors.toList()));
            // remover listas vazias
            tempListaDeListas.removeIf(List::isEmpty);

            // limpar a lista e pular uma linha
            tempList.clear();
            System.out.println();

            // verificar se é o index é maior que o tamanho da lista e parar loop
            if (index > len) {
                break;
            }
        }
        return tempListaDeListas;
    }
    // criar a classe de inicio para pegar a quantidade de numeros
    public static int pegar_quant_nums(){
        // criar scanner
        Scanner input = new Scanner(System.in);

        // solicitar quantidade de numeros
        System.out.println("Digite a quantidade de numeros da piramide");
        String quantNums = input.nextLine();

        // tratar dado
        int quantNumsInInt = 0;
        try{
            quantNumsInInt = Integer.parseInt(quantNums);
        }
        catch (NumberFormatException nfe){
            // tratar exceção
            System.out.println("Digite um valor válido!");
            // pegar quantidade de numeros novamente
            quantNumsInInt = pegar_quant_nums();
        }

        return quantNumsInInt;
    }

    public static List<Integer>criar_lista(int quantNums){
        // criar lista temporaria
        List<Integer> tempList = new LinkedList<Integer>();

        for (int i = 0; i < quantNums; i++) {
            // numero temporario entre 10 e 100
            int tempRandom = (int)Math.floor(Math.random() * (100 - 0 + 1) + 0);
            // adicionar numero a lista
            tempList.add(tempRandom);
        }

        // retornar lista temporaria
        return tempList;
    }

    public static int somar(List<List<Integer>> listaDeListas){
        // variavel de soma
        int soma = 0;

        // percorrer entre a lista de listas para pegar uma lista
        for (List<Integer> lista: listaDeListas) {
            // variavel para pegar o menor (definido com o primeiro numero da lista)
           int menor = lista.get(0);

           // percorrer os numeros da lista
            for (int numero: lista) {
                // checar se há algum numero menor
                if (numero < menor)
                        menor = numero;
            }
            soma += menor;
        }
        return soma;
    }
}
