package Banco;


import java.time.format.DateTimeFormatter;

public class ContaPoupança extends Conta{

    public static int contadorDeContaPoupanca = 100;
    private DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    public double saldoPoupanca;
    private Conta conta;


    public ContaPoupança(Conta conta){
        super();
        this.conta = conta;
    }

    public double getSaldoPoupanca() {
        return saldoPoupanca;
    }


    @Override
    public void depositar(double valor){
        if(valor >= 0 ){
            saldoPoupanca += valor;
            System.out.println("Valor R$ " + valor + " depositado na conta poupança com sucesso!");
        }else {
            System.out.println("O Valor tem que ser positivo!");
        }
    }

    @Override
    public void sacar(double valor){
        if(valor <= 0){
            System.out.println("O Valor tem que ser positivo!");
        }else{
            if(saldoPoupanca >= valor){
                saldoPoupanca -= valor;
                System.out.println("Valor R$ " + valor + " sacado com sucesso!");
            }
        }
    }

    @Override
    public String toString() {
        return "Agencia: " + conta.agencia +
                "\nNumero: " + conta.numero +
                "\nSaldo conta corrente: " + conta.saldo +
                "\nSaldo poupança: " + saldoPoupanca;
    }
}
