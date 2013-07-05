/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexao;

import dados.*;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;
import javax.swing.JOptionPane;

/**
 *
 * @author Zurawski
 */
public class DocinhoDAO {

    private static final String insertClientes = "insert into clientes(Pessoa,CPF_CNPJ,NomeCompleto,Telefone_Residencial,Telefone_Celular,Telefone_Comercial,Telefone_Comercial_Ramal,Email) values (?,?,?,?,?,?,?,?)";
    private static final String insertProdutos = "insert into produtos(valor,pacote_quantidade,nome,descricao) values (?,?,?,?)";
    private static final String insertPedidos = "insert into pedidos (cod_cliente,data_pedido,contato,data_entrega,valor_total) values (?,?,?,?,?)";
    private static final String insertItensPedidos = "insert into itens_pedidos(cod_pedido,codigo_item) values (?,?)";
    private static final String selectGetNomeProduto = "select nome from produtos where id = ?";
    private static final String selectGetValorProduto = "select valor from produtos where id = ?";

    public static Connection getConexao() throws Exception {
        Connection conexao;
        Statement statement;
        ResultSet resultSet;
        String fileName = "docinho.properties";
        File file = new File(System.getProperty("user.dir") + "/src/Conexao/" + fileName);

        try {
            Properties settings = new Properties();
            settings.load(new FileInputStream(file));


            String host = settings.getProperty("host");
            String port = settings.getProperty("port");
            String database = settings.getProperty("database");
            String usuario = settings.getProperty("usuario");
            String senha = settings.getProperty("senha");

            String url = "jdbc:mysql://" + host + ":" + port + "/" + database;

            conexao = DriverManager.getConnection(url, usuario, senha);

        } catch (Exception e) {
            throw new Exception("Problema na conexao com o banco de dados",e);
        }

        return conexao;
    }

    public static Connection getConexaoLocal() throws Exception {
        Connection con;
        con = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/Docinho", "postgres",
                "senacrs");

        return con;
    }

    public void addClientes(Clientes cli) throws ClassNotFoundException {
        if (cli == null) {
            throw new IllegalArgumentException("A conta não pode ser null!");
        }


        try {

            //   DriverManager.registerDriver(new com.mysql.jdbc.Driver());
            Connection con;


            con = getConexao();
            PreparedStatement stmt = con.prepareStatement(insertClientes);
            stmt.setString(1, cli.getPessoa());
            stmt.setString(2, cli.getCPF_CNPJ());
            stmt.setString(3, cli.getNomeCompleto());
            stmt.setString(4, cli.getTelefoneResidencial());
            stmt.setString(5, cli.getTelefoneCelular());
            stmt.setString(6, cli.getTelefoneComercial());
            stmt.setString(7, cli.getTelefoneComercial_Ramal());
            stmt.setString(8, cli.getEmail());
            int r = stmt.executeUpdate();
            if (r != 1) {
                throw new RuntimeException("Erro ao inserir operação");
            }

            if (cli != null) {
                stmt.close();
            }

            if (con != null) {
                stmt.close();
            }

            if (stmt != null) {
                stmt.close();
            }
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
        } catch (Exception e) {
            // FIXME: comunicar erro ao programa
            e.printStackTrace();
        }

    }

    public void addProdutos(Produtos pro) {
        if (pro == null) {
            throw new IllegalArgumentException("A conta não pode ser null!");
        }
        Connection con = null;
        try {


            con = getConexao();

            PreparedStatement stmt = con.prepareStatement(insertProdutos);
            stmt.setDouble(1, pro.getValor());
            stmt.setInt(2, pro.getQuantidade());
            stmt.setString(3, pro.getNome());
            stmt.setString(4, pro.getDescricao());
            int r = stmt.executeUpdate();
            if (r != 1) {
                throw new RuntimeException("Erro ao inserir operação");
            }



            if (pro != null) {
                stmt.close();
            }

            if (con != null) {
                stmt.close();
            }

            if (stmt != null) {
                stmt.close();
            }
            JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso!");
        } catch (Exception e) {
            // FIXME: comunicar erro ao programa
            e.printStackTrace();
        }

    }

    public String setCodigoPedido() {

        Integer cod = null;
        String codigo;
        ResultSet rs = null;
        PreparedStatement stmt = null;

        Connection con = null;
        try {
            con = getConexao();

            stmt = con.prepareStatement("select * from produtos");
            rs = stmt.executeQuery();
            while (rs.next()) {
                cod = rs.getInt(1);
            }
            cod = cod + 1;
            return cod.toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cod.toString();
    }

    public String getPrecoProduto(String num) {
        double CodP = Double.parseDouble(num);
        double preco = 0;
        String retorno = null;

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = getConexao();

            stmt = con.prepareStatement(selectGetValorProduto);
            stmt.setDouble(1, CodP);
            rs = stmt.executeQuery();
            if (rs.next()) {
                preco = rs.getDouble("valor");
            }
            retorno = String.valueOf(preco);
            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            // FIXME: comunicar erro ao programa cliente
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    stmt.close();
                }
                if (con != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // FIXME: comunicar erro ao programa cliente
            }
        }
        return retorno;
    }

    public String getNomeProduto(String num) {
        double CodP = Double.parseDouble(num);
        String retorno = null;

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {
            con = getConexao();

            stmt = con.prepareStatement(selectGetNomeProduto);
            stmt.setDouble(1, CodP);
            rs = stmt.executeQuery();
            if (rs.next()) {
                retorno = rs.getString("nome");
            }

            return retorno;
        } catch (Exception e) {
            e.printStackTrace();
            // FIXME: comunicar erro ao programa cliente
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    stmt.close();
                }
                if (con != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // FIXME: comunicar erro ao programa cliente
            }
        }
        return retorno;
    }

    public boolean addPedido(ArrayList<Integer> array, Pedidos pedido, Integer codPedido) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        boolean retorno = false;
        try {
            con = getConexao();

            stmt = con.prepareStatement(insertPedidos);
            stmt.setInt(1, pedido.getCodigo_cliente());
            stmt.setDate(2, pedido.Data_Pedido);
            stmt.setString(3, pedido.getContato());
            stmt.setDate(4, pedido.Data_Entrega);
            stmt.setDouble(5, pedido.getValor_Total());

            int r = stmt.executeUpdate();
            if (r != 1) {
                throw new RuntimeException("Erro ao inserir operação");
            } else {
                retorno = addItensPedidos(codPedido, array);
            }

        } catch (Exception e) {
            e.printStackTrace();
            // FIXME: comunicar erro ao programa cliente
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    stmt.close();
                }
                if (con != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // FIXME: comunicar erro ao programa cliente
            }
        }
        return retorno;
    }

    public boolean addItensPedidos(Integer codPedido, ArrayList<Integer> listaItensPedidos) {
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        boolean retorno = false;
        int r = 0;
        try {
            con = getConexao();

            for (int i = 0; i < listaItensPedidos.size(); i++) {
                stmt = con.prepareStatement(insertItensPedidos);
                stmt.setInt(1, codPedido);
                stmt.setInt(2, listaItensPedidos.get(i));
                r = stmt.executeUpdate();
                if (r != 1) {
                    throw new RuntimeException("Erro ao inserir operação");
                } else {
                    retorno = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            // FIXME: comunicar erro ao programa cliente
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    stmt.close();
                }
                if (con != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                throw new RuntimeException("Error");
            }
        }
        return retorno;
    }

    public ArrayList<String> fillComboProdutos() {
        ArrayList<String> retorna = new ArrayList<String>();
        String retorno = null;

        PreparedStatement stmt = null;
        ResultSet rs = null;
        Connection con = null;
        try {

            try {
                con = getConexao();

                stmt = con.prepareStatement("select * from produtos");
                rs = stmt.executeQuery();
                while (rs.next()) {
                    String nome = rs.getInt("id") + " - " + rs.getString("nome");
                    retorna.add(nome);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (rs != null) {
                    stmt.close();
                }
                if (con != null) {
                    stmt.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
                // FIXME: comunicar erro ao programa cliente
            }
        }
        return retorna;
    }
}
