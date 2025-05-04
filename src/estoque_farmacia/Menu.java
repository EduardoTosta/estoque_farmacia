package estoque_farmacia;

import java.util.Scanner;

import estoque_farmacia.controller.EstoqueController;
import estoque_farmacia.model.Produto;

public class Menu {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        EstoqueController controller = new EstoqueController();

        int opcao, id, tipo;
        String nome;
        float preco;

        do {
            System.out.println("\n=================================");
            System.out.println("       ESTOQUE DA FARMÁCIA       ");
            System.out.println("=================================");
            System.out.println("1 - Cadastrar Produto");
            System.out.println("2 - Listar Todos os Produtos");
            System.out.println("3 - Buscar Produto por ID");
            System.out.println("4 - Atualizar Produto");
            System.out.println("5 - Remover Produto");
            System.out.println("0 - Sair");
            System.out.print("Digite a opção desejada: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Digite uma opção válida: ");
                scanner.next();
            }

            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.println("\n--- Cadastro de Produto ---");
                    System.out.print("ID do Produto: ");
                    id = scanner.nextInt();
                    System.out.print("Tipo do Produto (1-Medicamento || 2-Cosmético): ");
                    tipo = scanner.nextInt();
                    scanner.nextLine(); // Limpa buffer
                    System.out.print("Nome do Produto: ");
                    nome = scanner.nextLine();
                    System.out.print("Preço do Produto: ");
                    preco = scanner.nextFloat();

                    Produto novoProduto = new Produto(id, tipo, nome, preco) {
                        // Produto é abstrato, então precisa de uma classe anônima
                    };
                    controller.cadastrar(novoProduto);
                    break;

                case 2:
                    System.out.println("\n--- Lista de Produtos ---");
                    controller.listarTodas();
                    break;

                case 3:
                    System.out.print("\nDigite o ID do produto a buscar: ");
                    id = scanner.nextInt();
                    controller.procurarPorNumero(id);
                    break;

                case 4:
                    System.out.print("\nDigite o ID do produto a atualizar: ");
                    id = scanner.nextInt();
                    Produto atualizarProduto = new Produto(id, 0, "", 0f) {
                        // Dados serão atualizados no controller
                    };
                    controller.atualizar(atualizarProduto);
                    break;

                case 5:
                    System.out.print("\nDigite o ID do produto a remover: ");
                    id = scanner.nextInt();
                    controller.deletar(id);
                    break;

                case 0:
                    System.out.println("Saindo do sistema... Obrigado!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        scanner.close();
    }
}
