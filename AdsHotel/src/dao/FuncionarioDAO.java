/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import jdbc.ConnectionFactory;
import model.Funcionario;

/**
 *
 * @author alexr
 */
public class FuncionarioDAO {
    private Connection con;
    
    public FuncionarioDAO(){
        this.con = new ConnectionFactory().getConnection();
    }
    
    // Método cadastrarFuncionario
    public void cadastrarFuncionario(Funcionario obj) {
        try {
            //1 - criar comando sql
            String sql = "insert into tb_funcionarios (nome,cpf,email,telefone) "
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
    
    // Método alterarFuncionario
    public void alterarFuncionario(Funcionario obj) {
        try {
            //1 - criar comando sql
            String sql = "update tb_funcionarios set nome=?,cpf=?,email=?,telefone=? where cpf=?";
            
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
    
    // Método excluirFuncionario
    public void excluirFuncionario(Funcionario obj) {
        try {
            //1 - criar comando sql
            String sql = "delete from tb_funcionarios where cpf = ?";
            
            //2 - conectar o banco de dados e organizar o comando sql
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,obj.getCpf());
            
            //3 - executar o comando sql
            stmt.execute();
            stmt.close();
            
            JOptionPane.showMessageDialog(null, "Excluído com sucesso");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);

        }
    }
    
    // Método listarFuncionarios
    public List<Funcionario> listarFuncionarios() {
        try {
            //1 - criar a lista
            List<Funcionario> lista = new ArrayList<>();
            
            //2 - criar sql, organizar e executar
            String sql = "select * from tb_funcionarios";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Funcionario obj = new Funcionario();
                
                obj.setFuncionario(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("telefone"));
                
                lista.add(obj);
            }
            
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }
    
    //Método buscar funcionário por Nome
    public List<Funcionario> consultaFuncionariosPorNome(String nome) {
        try {
            
            // 1 - criar a lista
            List<Funcionario> lista = new ArrayList<>();
            
            //2 - criar o sql, organizar e executar
            String sql = "select * from tb_funcionarios where nome like ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, nome);
            
            ResultSet rs = stmt.executeQuery();
            
            while(rs.next()) {
                Funcionario obj = new Funcionario();
                
                obj.setFuncionario(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("telefone"));
                
                lista.add(obj);
            }
            
            return lista;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }
    
    //Método buscar funcionário por CPF
    public Funcionario buscaFuncionarioPorCpf(String cpf) {
        try {
            // 1 - criar o sql, organizar e executar
            String sql = "select * from tb_funcionarios where cpf=?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1, cpf);
            
            ResultSet rs = stmt.executeQuery();
            
            Funcionario obj = new Funcionario();

            
            if(rs.next()) {
                
                obj.setFuncionario(rs.getString("nome"), rs.getString("cpf"), rs.getString("email"), rs.getString("telefone"));

            }
            
            return obj;
           
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Erro: " + e);
            return null;
        }
    }
}
