/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dados;

/**
 *
 * @author Lucas
 */
public class Itens_Pedidos 
{
    public Integer codigo;
    public Integer codigo_pedido;
    public Integer codigo_item;

    public Itens_Pedidos(Integer codigo, Integer codigo_pedido, Integer codigo_item) {
        this.codigo = codigo;
        this.codigo_pedido = codigo_pedido;
        this.codigo_item = codigo_item;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public Integer getCodigo_pedido() {
        return codigo_pedido;
    }

    public void setCodigo_pedido(Integer codigo_pedido) {
        this.codigo_pedido = codigo_pedido;
    }

    public Integer getCodigo_item() {
        return codigo_item;
    }

    public void setCodigo_item(Integer codigo_item) {
        this.codigo_item = codigo_item;
    }
    
    
    
    
}
