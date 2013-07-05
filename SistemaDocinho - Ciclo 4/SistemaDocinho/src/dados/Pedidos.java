
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;
import java.util.ArrayList;

/**
 *
 * @author Lucas
 */
public class Pedidos 
{
    public Integer codigo;
    public Integer codigo_cliente;
    public String Data_Pedido;
    public double Valor_Total;
    public String Contato;
    public String Data_Entrega;
    public String Status_pedido;
    
    
    public Pedidos(Integer nCod,Integer nCodCliente, String nDataPedido, String nDataEntrega, double vTotal)
    {
        this.codigo = nCod;
        this.codigo_cliente = nCodCliente;
        this.Data_Pedido = nDataPedido;
        this.Valor_Total = vTotal;
        this.Data_Entrega = nDataEntrega;
        this.Status_pedido = "Pendente";
    }
    
    private double setValorTotal(ArrayList<Produtos> nProd)
    {
        double valorProd;
        if (!(nProd.isEmpty()))
        {
            for(int i =0; i < nProd.size(); i++)
            {
                valorProd = nProd.get(i).getValor();
                this.Valor_Total += valorProd;
            }
            return this.Valor_Total;
        }
        else
        {
            return 0.0;
        }
       
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo_cliente() {
        return codigo_cliente;
    }

    public void setCodigo_cliente(Integer codigo_cliente) {
        this.codigo_cliente = codigo_cliente;
    }

    public String getData_Pedido() {
        return Data_Pedido;
    }

    public void setData_Pedido(String Data_Pedido) {
        this.Data_Pedido = Data_Pedido;
    }

    public double getValor_Total() {
        return Valor_Total;
    }

    public void setValor_Total(double Valor_Total) {
        this.Valor_Total = Valor_Total;
    }

    public String getContato() {
        return Contato;
    }

    public void setContato(String Contato) {
        this.Contato = Contato;
    }

    public String getData_Entrega() {
        return Data_Entrega;
    }

    public void setData_Entrega(String Data_Entrega) {
        this.Data_Entrega = Data_Entrega;
    }

    public String getStatus_pedido() {
        return Status_pedido;
    }

    public void setStatus_pedido(String Status_pedido) {
        this.Status_pedido = Status_pedido;
    }


}
