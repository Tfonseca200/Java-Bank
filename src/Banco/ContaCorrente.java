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

    @Override
    public void imprimirExtrato() {
        System.out.println("===== Extrato Conta =====");
        System.out.println("Nome do titular: " + usuario.getNome());
        System.out.println(String.format("Agencia: %d" , this.agencia));
        System.out.println(String.format("Numero da conta: %d" , this.numero));
        System.out.println(String.format("Saldo: R$%.2f" , this.saldo));
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
