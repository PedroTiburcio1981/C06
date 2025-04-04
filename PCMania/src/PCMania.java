import java.util.Scanner;

public class PCMania {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Bem-vindo à PC Mania!");
            System.out.print("Digite seu nome: ");
            String nomeCliente = scanner.nextLine();
            System.out.print("Digite seu CPF: ");
            long cpfCliente = scanner.nextLong();
            System.out.print("Digite sua matrícula: ");
            int matricula = scanner.nextInt();
            scanner.nextLine();
            
            Cliente cliente = new Cliente(nomeCliente, cpfCliente, 10);
            
            int opcao;
            do {
                System.out.println("\nPromoções disponíveis:");
                System.out.println("1 - Promoção 1 (Apple)");
                System.out.println("2 - Promoção 2 (Samsung)");
                System.out.println("3 - Promoção 3 (Dell)");
                System.out.println("0 - Finalizar compra");
                System.out.print("Escolha uma promoção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();
                
                if (opcao >= 1 && opcao <= 3) {
                    Computador pc = criarComputadorPromocao(opcao, matricula);
                    cliente.addComputador(pc);
                    System.out.println("PC adicionado ao carrinho!");
                } else if (opcao != 0) {
                    System.out.println("Opção inválida!");
                }
            } while (opcao != 0);
            
            System.out.println("\nResumo da Compra:");
            System.out.println("Cliente: " + cliente.getNome());
            System.out.println("CPF: " + cliente.getCpf());
            System.out.println("\nPCs adquiridos:");
            
            for (int i = 0; i < cliente.getNumComputadores(); i++) {
                System.out.println("\nPC " + (i+1) + ":");
                cliente.getComputadores()[i].mostraPCConfigs();
            }
            
            System.out.println("\nTotal da compra: R$" + cliente.calculaTotalCompra());
            System.out.println("\nObrigado por comprar na PC Mania!");
        }
    }
    
    private static Computador criarComputadorPromocao(int promocao, int matricula) {
        switch (promocao) {
            case 1:
            {
                Computador pc = new Computador("Apple", matricula);
                pc.hardware[0] = new Hardwarebasico("Pentium Core i3", 2200);
                pc.hardware[1] = new Hardwarebasico("Memória RAM", 8);
                pc.hardware[2] = new Hardwarebasico("HD", 500);
                pc.sistemaOperacional = new SistemaOperacional("Linux Ubuntu", 32);
                pc.addMemoriaUSB(new MemoriaUSB("Pen-drive", 16));
                return pc;
            }
            case 2:
            {
                Computador pc = new Computador("Samsung", matricula + 1234);
                pc.hardware[0] = new Hardwarebasico("Pentium Core i5", 3370);
                pc.hardware[1] = new Hardwarebasico("Memória RAM", 16);
                pc.hardware[2] = new Hardwarebasico("HD", 1000);
                pc.sistemaOperacional = new SistemaOperacional("Windows 8", 64);
                pc.addMemoriaUSB(new MemoriaUSB("Pen-drive", 32));
                return pc;
            }
            case 3:
            {
                Computador pc = new Computador("Dell", matricula + 5678);
                pc.hardware[0] = new Hardwarebasico("Pentium Core i7", 4500);
                pc.hardware[1] = new Hardwarebasico("Memória RAM", 32);
                pc.hardware[2] = new Hardwarebasico("HD", 2000);
                pc.sistemaOperacional = new SistemaOperacional("Windows 10", 64);
                pc.addMemoriaUSB(new MemoriaUSB("HD Externo", 1));
                return pc;
            }
            default:
                break;
        }
        return null;
    }
}