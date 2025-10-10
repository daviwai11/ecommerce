package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/ecommerce";
    private static final String USUARIO = "root";
    private static final String SENHA = "senhaqui";
    public static void main(String[] args) {
        System.out.println("Iniciando conexao...");
        String sql = "SELECT id, nome, preco, quantidade_estoque FROM produtos";
        try (Connection conexao = DriverManager.getConnection(URL, USUARIO, SENHA);
             PreparedStatement ps = conexao.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            System.out.println("conexao deu certo");
            System.out.println("\n--- lista produtos ---");
            while (rs.next()) {
                System.out.printf("id: %d / produto: %-20s / preco: R$ %8.2f | estoqe: %d\n",
            rs.getInt("id"),
            rs.getString("nome"),
            rs.getBigDecimal("preco"),
            rs.getInt("quantidade+estoque"));
            }
        } catch (SQLException e) {
            System.err.println("\ndeu erri ao conectar o banco dados: " + e.getMessage());
        }
        System.out.println("\n-- fim programa ---");
    }
}
