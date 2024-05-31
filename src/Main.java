import Banco.Conta;
import Banco.ContaCorrente;
import Banco.ContaPoupança;
import Banco.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {


        Usuario u = new Usuario("thiago","763.487.384-48", "491.398.398-83",(short) 22);
        System.out.println(u);

        Conta c = new ContaCorrente(u);

        Conta p = new ContaPoupança(c);



        c.depositar(100);

        p.depositar(100);

        System.out.println(c);
        System.out.println(p);


    }

    public static void menu(){
        System.out.println("===== MENU BANCO THI =====");
        System.out.println("1 - criar conta");
        System.out.println("1 - criar conta");
        System.out.println("1 - criar conta");
        System.out.println("1 - criar conta");
        System.out.println("1 - criar conta");

    }
}