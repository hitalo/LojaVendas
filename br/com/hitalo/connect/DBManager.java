package br.com.hitalo.connect;

import br.com.hitalo.forms.Produto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
        
        PreparedStatement statment = connection.prepareStatement("select * from produtos order by nome");
        ResultSet result = statment.executeQuery();
        
        ArrayList<Produto> produtos = new ArrayList<>();
        
        while(result.next()) {
            produtos.add(new Produto(result.getString(1), result.getString(2), result.getString(4), result.getString(5), result.getFloat(3)));
        }
        
        disconnect();
        
        return produtos;
    }
    
    public void addProduto(Produto produto) throws SQLException {
        connect();
        
        PreparedStatement statment = connection.prepareStatement("insert into produtos (nome, marca, unidade, valor)"
                + " values ('"+produto.getNome()+"','"+produto.getMarca()+"', '"+produto.getUnidade()+"', '"+produto.getValor()+"')");
        statment.execute();
        
        disconnect();
    }
    
}
