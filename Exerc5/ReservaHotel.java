package Exerc5;

public class ReservaHotel {

    String hospede;
    int quarto;
    int dias;
    boolean cafeDaManha;
    double valorDiaria;
    int quantidadeHospedes;

    public ReservaHotel(String hospede, int quarto, int dias, boolean cafeDaManha, double valorDiaria, int quantidadeHospedes) {

        this.hospede = hospede;
        this.quarto = quarto;
        this.dias = dias;
        this.cafeDaManha = cafeDaManha;
        this.valorDiaria = valorDiaria;
        this.quantidadeHospedes = quantidadeHospedes;
    }

    public ReservaHotel(String hospede,
                        int quarto,
                        int dias,
                        double valorDiaria,
                        int quantidadeHospedes) {

        this.hospede = hospede;
        this.quarto = quarto;
        this.dias = dias;

        this.cafeDaManha = false;

        this.valorDiaria = valorDiaria;
        this.quantidadeHospedes = quantidadeHospedes;
    }

    public ReservaHotel(String hospede,
                        int quarto,
                        double valorDiaria) {

        this.hospede = hospede;
        this.quarto = quarto;
        this.valorDiaria = valorDiaria;

        this.dias = 1;
        this.cafeDaManha = false;
        this.quantidadeHospedes = 1;
    }

    public double calcularValorTotal() {

        double diariaFinal = valorDiaria;

        if (cafeDaManha == true) {
            diariaFinal += valorDiaria * 0.20;
        }

        double total = diariaFinal * dias;

        if (quantidadeHospedes > 2) {

            int hospedesExtras = quantidadeHospedes - 2;

            total += hospedesExtras * 50 * dias;
        }

        return total;
    }

    public double calcularValorTotal(double taxaAdicional) {

        return calcularValorTotal() + taxaAdicional;
    }
}