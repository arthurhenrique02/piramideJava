import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // criar scanner
        Scanner input = new Scanner(System.in);

        // solicitar quantidade de numeros
        int quantNums = Recursos.pegar_quant_nums();

        // mostrar quantidade de numeros
        System.out.println("Quantidade de números: " + quantNums);

        // criar lista de numeros aleatorios
        List<Integer> listNumeros = Recursos.criar_lista(quantNums);
        System.out.println(listNumeros);

        // criar e retornar linhas da piramide
        List<List<Integer>> coletar_dados_piramide = Recursos.retornar_linhas_piramide(listNumeros);
        // mostrar visualmente
        Recursos.mostrar_piramide(coletar_dados_piramide);

        // fazer a soma e mostrar na tela
        System.out.println("RESULTADO DA SOMA: " + Recursos.somar(coletar_dados_piramide));
    }
}