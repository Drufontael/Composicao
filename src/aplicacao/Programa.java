package aplicacao;

import entidades.ContratoHora;
import entidades.Departamento;
import entidades.Trabalhador;
import entidades.enums.Nivel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Programa {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        DateTimeFormatter dma=DateTimeFormatter.ofPattern("dd/MM/yyyy");
        System.out.print("Digite o departamento: ");
        String departamento=in.nextLine();
        System.out.println("Entre com os dados do funcionario: ");
        System.out.print("Nome: ");
        String nome=in.nextLine();
        System.out.print("Nível: ");
        Nivel nivel=Nivel.valueOf(in.nextLine());
        System.out.print("Salario base: ");
        double salBase=in.nextDouble();
        Trabalhador trabalhador=new Trabalhador(nome,nivel,salBase,new Departamento(departamento));
        System.out.println("Quantos contratos para esse trabalhador? ");
        int n= in.nextInt();
        in.nextLine();
        for(int i=1; i<=n;i++){
            System.out.println("Dados do contrato #"+i+": ");
            System.out.print("Data (dd/mm/aaaa): ");
            LocalDate data=LocalDate.parse(in.nextLine(),dma);
            System.out.print("Valor/Hora: ");
            double valorHora=in.nextDouble();
            System.out.print("Duração (horas): ");
            int duracao=in.nextInt();
            in.nextLine();
            trabalhador.addContrato(new ContratoHora(data,valorHora,duracao));
        }
        System.out.println();
        System.out.print("Digite o mês e o ano para calcular renda (mm/aaaa): ");
        String mesAno=in.nextLine();
        String[] divideMesAno=mesAno.split("/");
        int mes=Integer.parseInt(divideMesAno[0]);
        int ano=Integer.parseInt(divideMesAno[1]);
        System.out.println("Nome: "+trabalhador.getNome());
        System.out.println("Departamento: "+trabalhador.getDepartamento().getName());
        System.out.println("Renda em "+mesAno+" foi de R$"+trabalhador.renda(ano,mes));
    }
}
