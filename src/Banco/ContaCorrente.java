package Banco;

import java.time.LocalDateTime;

public class ContaCorrente extends Conta{

    public static int contadorConta= 1;
    private Usuario usuario;

    public ContaCorrente(Usuario usuario, LocalDateTime dataHora) {
        this.usuario = usuario;
        super.dataHorario = dataHora;
        super.numero = contadorConta;
        super.agencia = contadorConta;
        contadorConta ++;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public void imprimirExtrato() {
        System.out.println("===== Extrato Conta =====");
        System.out.println("Nome do titular: " + usuario.getNome());
        System.out.println(String.format("Agencia: %d" , this.agencia));
        System.out.println(String.format("Numero da conta: %d" , this.numero));
        System.out.println(String.format("Saldo: R$%.2f" , this.saldo));
    }



    public static void trenferir(ContaCorrente contaRemetente, double valor,  ContaCorrente contaDestinataria) {

        if(valor <= 0){
            System.out.println("incorreto , o valor tem que ser positivo!");
        }else{
            if(valor <= contaRemetente.saldo){
                contaRemetente.saldo -= valor;
                contaDestinataria.saldo += valor;
                System.out.println("Tranferencia do " + contaRemetente.usuario.getNome() + " no valor de R$ " + valor + " pra conta " + contaDestinataria.usuario.getNome() +
                        " concluida com sucesso");
            }else {
                System.out.println("saldo insuficiente da conta remetente, operação cancelada!");
            }
        }
    }

    @Override
    public String toString() {
        return  "Nome:" + usuario.getNome() +
                "\nAgencia:" + agencia +
                "\nNumero: " + numero +
                "\nSaldo conta corrente: " + saldo +
                "\nData e hora e criação: " + super.fmt.format(dataHorario);
    }
}
