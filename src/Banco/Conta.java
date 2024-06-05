package Banco;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Conta implements ContaIn{


    protected double saldo = 0;
    protected int agencia;
    protected int numero;
    protected LocalDateTime dataHorario;
    protected DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");


    public Conta(){
    }


    public double getSaldo() {
        return saldo;
    }

    public int getAgencia() {
        return agencia;
    }

    public int getNumero() {
        return numero;
    }

    public LocalDateTime getDataHorario(){
        return dataHorario;
    }



    public void depositar(double valor){
        if(valor > 0){
            saldo += valor;
            System.out.println("Valor R$ " + valor + " depositado com sucesso!");
        }else{
            System.out.println("incorreto , o valor tem que ser positivo!");
        }
    }



    public void sacar(double valor){
        if (valor <= 0){
            System.out.println("Operação incorreto , o valor tem que ser positivo!");
        }else {
            if (saldo >= valor) {
                saldo -= valor;
                System.out.println("Valor " + valor + " sacado com sucesso!");
            } else {
                System.out.println("saldo insuficiente, operação incerrada!");
            }
        }
    }



    public void imprimirExtrato(){
        System.out.println("===== Extrato Conta =====");
        System.out.println(String.format("Agencia: %d" , this.agencia));
        System.out.println(String.format("Numero: %d" , this.numero));
        System.out.println(String.format("Saldo: R$%.2f" , this.saldo));
    }




    public static void trenferir(Conta contaRemetente, double valor,  Conta contaDestinataria) {

        if(valor <= 0){
            System.out.println("incorreto , o valor tem que ser positivo!");
        }else{
            if(valor <= contaRemetente.saldo){
                contaRemetente.saldo -= valor;
                contaDestinataria.saldo += valor;
                System.out.println("Tranferencia do " + contaRemetente.numero + " no valor de R$ " + valor + " pra conta " + contaDestinataria.numero +
                        " concluida com sucesso");
            }else {
                System.out.println("saldo insuficiente da conta remetente, operação cancelada!");
            }
        }
    }



    public String toString(){
        return "\nnumero da conta: " + getNumero()
              +"\nagencia: " + getAgencia()
              +"\nsaldo: " + getSaldo()
              +"\nData e hora e criação: " + fmt.format(dataHorario);
    }
}
