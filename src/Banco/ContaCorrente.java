package Banco;

import java.time.LocalDateTime;

public class ContaCorrente extends Conta{

    public static int contadorConta= 1;
    private Usuario usuario;

    public ContaCorrente(Usuario usuario, LocalDateTime dataHora) {
        this.usuario = usuario;
        super.dataHorario = dataHora;
        super.numero = contadorConta;
        super.agencia = 1;
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


    @Override
    public void transferir(double valor, ContaCorrente contaDestinataria) {
        if (valor <= 0) {
            System.out.println("Valor incorreto, o valor tem que ser positivo!");
        } else if (valor <= this.saldo) {
            this.saldo -= valor;
            contaDestinataria.saldo += valor;
            System.out.println("Transferência do " + this.usuario.getNome() + " no valor de R$ " + valor + " para a conta " + contaDestinataria.usuario.getNome()+
                    " concluída com sucesso");
        } else {
            System.out.println("Saldo insuficiente na conta remetente, operação cancelada!");
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
