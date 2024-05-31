package Banco;

public class ContaCorrente extends Conta{

    public static int contadorConta= 1;
    private Usuario usuario;

    public ContaCorrente(Usuario usuario) {
        this.usuario = usuario;
        numero = contadorConta;
        agencia = contadorConta;
        contadorConta ++;
    }


    @Override
    public String toString() {
        return "Agencia:" + agencia +
                "\nNumero: " + numero +
                "\nSaldo conta corrente:" + saldo;
    }
}
