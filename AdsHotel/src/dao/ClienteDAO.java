/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Cliente;

/**
 *
 * @author alexr
 */
public class ClienteDAO {
    private Connection con;
    
    public ClienteDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    // Método cadastrarCliente
    public void cadastrarCliente(Cliente obj) {
        try {
            //1 - criar comando sql
            String sql = "insert into tb_clientes (nome,cpf,email,telefone) "
                    + "values (?,?,?,?)";
            
            //2 - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            
            //3 - executar o comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Cadastrado com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);

        }
    }
    
    // Método alterarCliente
    public void alterarCliente(Cliente obj) {
        try {
            //1 - criar comando sql
            String sql = "update tb_clientes set nome=?,cpf=?,email=?,telefone=? where cpf=?";
            
            //2 - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, obj.getNome());
            stmt.setString(2, obj.getCpf());
            stmt.setString(3, obj.getEmail());
            stmt.setString(4, obj.getTelefone());
            stmt.setString(5, obj.getCpf());
            
            //3 - executar o comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Alterar com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);

        }
    }
}
