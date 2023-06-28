package entidades;

import entidades.enums.Nivel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Trabalhador {
    private String nome;
    private Nivel nivel;
    private Double salarioBase;
    private Departamento departamento;
    private List<ContratoHora> contratos=new ArrayList<>();
    public Trabalhador(){}

    public Trabalhador(String nome, Nivel nivel, Double salarioBase, Departamento departamento) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departamento = departamento;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Nivel getNivel() {
        return nivel;
    }

    public void setNivel(Nivel nivel) {
        this.nivel = nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<ContratoHora> getContratos() {
        return contratos;
    }

    public void addContrato(ContratoHora contrato){
        this.contratos.add(contrato);
    }
    public void removeContrato(ContratoHora contrato){
        this.contratos.remove(contrato);
    }
    public double renda(int ano,int mes){
        double soma=this.salarioBase;
        for(ContratoHora c:this.contratos){
            if (ano==c.getDate().getYear() && mes==c.getDate().getMonthValue()){
                soma+=c.valorTotal();
            }

        }
        return soma;
    }
}
