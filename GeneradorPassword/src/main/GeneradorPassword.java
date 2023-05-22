package main;

import java.awt.List;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import objetos.Password;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */

/**
 *
 * @author Usuario
 */
public class GeneradorPassword {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int tamanio = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la cantidad de contraseñas: "));        
        int longitudPassword = Integer.parseInt(JOptionPane.showInputDialog("Ingrese la longitud que tendrá cada contraseña: "));
        Password [] passwords  = new Password [tamanio];
        boolean [] fortaleza = new boolean [tamanio];
        String salida = "";
        for(int i = 0; i<passwords.length; i++){
            passwords[i] = new Password(longitudPassword);
            fortaleza[i] = passwords[i].esFuerte();
            salida += passwords[i].getContrasenia() + " " + fortaleza[i] + "\n";
        }
        JOptionPane.showMessageDialog(null, salida, 
                    "Información de contraseñas", JOptionPane.INFORMATION_MESSAGE);
        
    }
    
}
