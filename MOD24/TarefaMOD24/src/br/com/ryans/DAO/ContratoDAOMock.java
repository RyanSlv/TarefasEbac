package br.com.ryans.DAO;
import br.com.ryans.DAO.IContratoDAO;

public class ContratoDAOMock implements IContratoDAO {

    private double valorTotal;

    @Override
    public void salvar() {
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }
}
