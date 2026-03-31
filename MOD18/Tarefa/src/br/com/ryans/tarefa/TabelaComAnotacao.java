package br.com.ryans.tarefa;

@TabelaAnotacao(
        value = "Carro Esportivo",
        marcas = {"Ferrari, Lamborghini"},
        potencia = 700
)
public class TabelaComAnotacao {

    @TabelaAnotacao(
            value = "Carro Popular",
            marcas = {"Honda, Chevrolet"},
            potencia = 120
    )
    private String carros;
}
