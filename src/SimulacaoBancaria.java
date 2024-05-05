import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

public class SimulacaoBancaria {
   public static void main(String[] args) {
       Locale.setDefault(Locale.US);
    //Scanner scanner = new Scanner(System.in);

        try {
           menu();
        } catch (InputMismatchException e) {
            System.out.println("Valor incorreto tente novamente");
            menu();
        }

    }

    static void menu(){
        Scanner scanner = new Scanner(System.in);
        double saldo = 0.0;
        int opcao = 3;
        while (opcao !=0) {
            double valor = 0.0;

            System.out.println("Bem vindo ao nosso Banco \n" +
                    "Por favor escolha uma das opções abaixo: \n" +
                    "1) Depósito \n" +
                    "2) Saques \n" +
                    "3) Consultar saldo \n" +
                    "0) Encerrar ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Digite o valor do deposito");
                    valor = scanner.nextDouble();
                    saldo = saldo + valor;
                    System.out.printf("Saldo atual: %.1f \n", saldo);
                    break;

                case 2:
                    System.out.println("Digite o valor do saque");
                    valor = scanner.nextDouble();
                    if (saldo >= valor) {
                        saldo = saldo - valor;
                        System.out.printf("Saldo atual: %.1f \n", saldo);
                    } else {
                        System.out.println("Saldo Insuficiente.");
                    }
                    break;

                case 3:
                    System.out.printf("Saldo atual: %.1f \n", saldo);
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");

            }

        }
        scanner.close();
    }
}
