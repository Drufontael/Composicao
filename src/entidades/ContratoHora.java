package entidades;

import java.time.LocalDate;

public class ContratoHora {
    private LocalDate date;
    private Double valorPorHora;
    private Integer horas;

    public ContratoHora() {
    }

    public ContratoHora(LocalDate date, Double valorPorHora, Integer horas) {
        this.date = date;
        this.valorPorHora = valorPorHora;
        this.horas = horas;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getValorPorHora() {
        return valorPorHora;
    }

    public void setValorPorHora(Double valorPorHora) {
        this.valorPorHora = valorPorHora;
    }

    public Integer getHoras() {
        return horas;
    }

    public void setHoras(Integer horas) {
        this.horas = horas;
    }
    public Double valorTotal(){
        return horas*valorPorHora;
    }
}
