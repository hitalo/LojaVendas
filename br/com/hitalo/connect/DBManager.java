package br.com.hitalo.connect;

import br.com.hitalo.forms.Produto;
import br.com.hitalo.forms.Venda;
import br.com.hitalo.utils.LojaVendas;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DBManager {

    private String url = "jdbc:mysql://localhost:3306/loja";
    private String username = "root";
    private String password = "";
    private Connection connection;
    
    private void connect() {
        System.out.println("Connecting database...");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected!");
        } catch (SQLException e) {
            throw new IllegalStateException("Cannot connect the database!", e);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }
    
    private void disconnect() {
        try {
            if(!connection.isClosed())
                connection.close();
            
            System.out.println("Database disconnected!");
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public ArrayList<Produto> getProdutos() throws SQLException {
        connect();
        
        PreparedStatement statement = connection.prepareStatement("select * from produtos order by nome");
        ResultSet result = statement.executeQuery();
        
        ArrayList<Produto> produtos = new ArrayList<>();
        
        while(result.next()) {
            produtos.add(new Produto(result.getString(1), result.getString(2), result.getString(4), result.getString(5), result.getFloat(3)));
        }
        
        disconnect();
        
        return produtos;
    }
    
    public void addProduto(Produto produto) throws SQLException {
        connect();
        
        connection.prepareStatement("insert into produtos (nome, marca, unidade, valor)"
                + " values ('"+produto.getNome()+"','"+produto.getMarca()+"', '"+produto.getUnidade()+"', '"+produto.getValor()+"')").execute();
        
        disconnect();
    }
    
    public void editarProduto(Produto produto) throws SQLException {
        connect();
        PreparedStatement statement = connection.prepareStatement("update produtos set nome='"+produto.getNome()+"', marca='"+produto.getMarca()+"', "
                + "unidade='"+produto.getUnidade()+"', valor='"+produto.getValor()+"' where idProduto = ?");
        statement.setString(1, produto.getId());
        statement.execute();
        disconnect();
        
    }
    
    public void excluirProduto(String id) throws SQLException {
        connect();
        connection.prepareStatement("set foreign_key_checks=0").execute();
        PreparedStatement statement = connection.prepareStatement("delete from produtos where idProduto = ?;");
        statement.setString(1, id);
        statement.execute();
        connection.prepareStatement("set foreign_key_checks=1").execute();
        disconnect();
    }
    
    public void addVenda(Venda venda) throws SQLException {
        connect();
        
        PreparedStatement statement = connection.prepareStatement("insert into venda (data, hora, rua, bairro, cidade, numeroEndereco, idFuncionario, cliente)"
                + " values ('"+LojaVendas.getCurrentDate()+"','"+LojaVendas.getCurrentTime()+"', '"+venda.getRua()+"', '"+venda.getBairro()+"', "
                + "'"+venda.getCidade()+"', '"+venda.getNumeroEndereco()+"', '"+venda.getIdFuncionario()+"', '"+venda.getCliente()+"')", Statement.RETURN_GENERATED_KEYS);
        statement.execute();
        
        
        ResultSet resultSet = statement.getGeneratedKeys();
        if(resultSet.next()) {
            int key = resultSet.getInt(1);
            for(Produto produto : venda.getProdutos()) {
                statement = connection.prepareStatement("insert into venda_produto (idVenda, idProduto, quantidade, valor) "
                        + "values ('"+key+"', '"+produto.getId()+"', '"+produto.getQuantidade()+"', '"+produto.getValor()+"')");

                statement.execute();
            }
        }
        disconnect();
    }
        
}
