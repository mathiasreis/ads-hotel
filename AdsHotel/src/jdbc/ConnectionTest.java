/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author alexr
 */
public class ConnectionTest {
    public static void main(String[] args) {
        try {
            new ConnectionFactory().getConnection();
            System.out.println("YES");
            JOptionPane.showMessageDialog(null, "Conectado com scucesso");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ops aconteceu um erro");
        }
    }
}
