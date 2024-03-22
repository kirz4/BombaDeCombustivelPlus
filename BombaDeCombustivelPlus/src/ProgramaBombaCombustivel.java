import java.util.Scanner;

public class ProgramaBombaCombustivel {
    private static int opcao = 0;
    private static String[] tiposCombustivel = {"Gasolina Comum", "Gasolina Aditivada", "Álcool", "Diesel"};
    private static BombaCombustivel[] bombas = {
        new BombaCombustivel("Gasolina Comum", 5.50, 1000),
        new BombaCombustivel("Gasolina Aditivada", 6.00, 800),
        new BombaCombustivel("Álcool", 4.00, 1200),
        new BombaCombustivel("Diesel", 4.50, 1500)
    };

    private static double lerDouble() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextDouble();
        } finally {
            scanner.nextLine();  // Limpa o buffer do Scanner
        }
    }

    private static int lerInt() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } finally {
            scanner.nextLine();  // Limpa o buffer do Scanner
        }
    }

    private static String lerString() {
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextLine();
        } finally {
            scanner.nextLine();  // Limpa o buffer do Scanner
        }
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\nEscolha uma opção:");
            System.out.println("1. Abastecer por valor");
            System.out.println("2. Abastecer por litro");
            System.out.println("3. Alterar valor do litro");
            System.out.println("4. Alterar tipo de combustível");
            System.out.println("5. Mostrar quantidade total abastecida");
            System.out.println("6. Sair");

            opcao = lerInt();

            try {
                switch (opcao) {
                    case 1:
                    case 2:
                        System.out.println("Digite o valor:");
                        double valor = lerDouble();
                        bombas[opcao - 1].abastecerPorValor(valor);
                        break;
                    case 3:
                        System.out.println("Digite o novo valor do litro:");
                        double novoValor = lerDouble();
                        for (BombaCombustivel bomba : bombas) {
                            bomba.alterarValor(novoValor);
                        }
                        break;
                    case 4:
                        System.out.println("Escolha o tipo de combustível:");
                        for (int i = 0; i < tiposCombustivel.length; i++) {
                            System.out.println((i + 1) + ". " + tiposCombustivel[i]);
                        }
                        int escolhaCombustivel = lerInt() - 1;
                        for (BombaCombustivel bomba : bombas) {
                            bomba.alterarTipoCombustivel(tiposCombustivel[escolhaCombustivel]);
                        }
                        break;
                    case 5:
                        for (BombaCombustivel bomba : bombas) {
                            System.out.println("Quantidade de " + bomba.getQuantidadeCombustivel() + " litros de " + bomba.getTipoCombustivel());
                        }
                        break;
                    case 6:
                        System.out.println("Programa encerrado.");
                        System.exit(0);
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido. Tente novamente.");
            }
        }
    }
}