import Banco.Conta;
import Banco.ContaCorrente;
import Banco.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {

    static Scanner input = new Scanner(System.in);
    static List<Conta> contas = new ArrayList<>();
    static boolean loop = true;

    public static void main(String[] args) {

        System.out.println("BEM VINDO");
        menu();

        while (true) {

            System.out.println("Digite operação:");
            int opcao = input.nextInt();
            input.nextLine();
            System.out.println("");

            switch (opcao) {
                case 1:
                    criarConta();
                        break;

                case 2:
                    listar();
                        break;

                case 3:
                    depositar();
                    break;

                case 4:
                    sacar();
                    break;

                case 5:
                    imprimirExtrato();
                    break;

                case 7:
                    loop = false;
                    break;

                default:
                    System.out.println("Operação invalida!");
                        break;
            }

        }
    }

    public static void menu(){
        System.out.println("===== MENU BANCO THI =====");
        System.out.println("1 - criar conta           =");
        System.out.println("2 - Listar                 =");
        System.out.println("3 - depositar             =");
        System.out.println("4 - sacar                 =");
        System.out.println("5 - Imprimir Extrato      =");
        System.out.println("6 - Tranferir             =");
        System.out.println("7 - Sair                  =");
        System.out.println("==========================");

    }

    public static void criarConta(){
        System.out.println("======= CRIAR CONTA =======");

        System.out.println("Digite seu nome: ");
        String nome = input.nextLine();

        System.out.println("Digite seu rg: ");
        String rg = input.nextLine();

        System.out.println("Digite seu cpf: ");
        String cpf = input.nextLine();

        System.out.println("Digite sua idade: ");
        short idade = input.nextShort();

        Usuario usuario = new Usuario(nome, rg,cpf, idade);
        LocalDateTime dataHora = LocalDateTime.now();
        Conta conta = new ContaCorrente(usuario,dataHora);

        contas.add(conta);

        System.out.println("Conta criada com sucesso, segue dados cadastrais: ");
        System.out.println("Nome: " + usuario.getNome());
        System.out.println("Rg: " + usuario.getRg());
        System.out.println("Cpf: " + usuario.getCpf());
        System.out.println("Idade: " + usuario.getIdade() + "\n");
        System.out.println("Dados da conta: ");
        System.out.println("Agencia: " + conta.getAgencia());
        System.out.println("Numeros da conta: " + conta.getNumero());
        System.out.println("Saldo: " + conta.getSaldo() + "\n");

        menu();
    }

    public static void listar(){
        if(!contas.isEmpty()){
            for (Conta c : contas) {
                System.out.println(c + "\n");
            }
        }else {
            System.out.println("Nenhuma conta criada! \n");
        }
        menu();
    }

    public static void depositar(){

        if(!contas.isEmpty()) {

            System.out.println("======= DEPOSITAR =======");

            System.out.println("Digite o numero da conta: ");
            int numero = input.nextInt();
            input.nextLine();


            for (Conta c : contas) {
                if (numero != c.getNumero()) {
                    System.out.println("conta não encotrada no sistema! \n");
                } else {
                    Conta conta = c;

                    System.out.println("Digite o valor do deposito: ");
                    double valor = input.nextDouble();

                    conta.depositar(valor);
                }
            }

        }else {
            System.out.println("Nenhuma conta criada! \n");
        }

        menu();
    }

    public static void sacar() {
        if(!contas.isEmpty()) {

            System.out.println("======== SAQUE =========");

            System.out.println("Digite o numero da conta: ");
            int numero = input.nextInt();
            input.nextLine();


            for (Conta c : contas) {
                if (numero != c.getNumero()) {
                    System.out.println("conta não encotrada no sistema! \n");
                } else {
                    Conta conta = c;

                    System.out.println("Digite o valor do saque: ");
                    double valor = input.nextDouble();

                    conta.sacar(valor);
                }
            }
        }else {
            System.out.println("Nenhuma conta criada! \n");
        }
        menu();
    }

    public static void imprimirExtrato(){
        if(!contas.isEmpty()) {
            System.out.println("====== IMPRIMIR EXTRATO =======");

            System.out.println("Digite o numero da conta: ");
            int numero = input.nextInt();
            input.nextLine();

            for (Conta c : contas) {
                if (numero != c.getNumero()) {
                    System.out.println("conta não encotrada no sistema! \n");
                } else {
                    Conta conta = c;

                    c.imprimirExtrato();
                }
            }
        }else {
            System.out.println("Nenhuma conta criada! \n");
        }
        menu();
    }



}