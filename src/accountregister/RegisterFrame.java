/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package accountregister;

import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JOptionPane;
import java.lang.NumberFormatException;
import java.lang.NullPointerException;

/**
 *
 * @author Strikke
 */
public class RegisterFrame extends JFrame implements ActionListener
{   
    private TextFieldWithLabel accountNumberField;
    private TextFieldWithLabel balanceField;
    private TextFieldWithLabel firstNameField;
    private TextFieldWithLabel lastNameField;
    private JButton registerButton;
    private CreateTextFile textFileCreator;
    
    public RegisterFrame(CreateTextFile createTextFile){
        super("Registrar Conta Bancária");
        
        textFileCreator = createTextFile;
        
        setSize(300, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
        //Definir o layout e suas configurações
        setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.weightx = 1;
        gc.weighty = 1;
        gc.anchor = GridBagConstraints.WEST;
        gc.fill = GridBagConstraints.NONE;
        gc.ipadx = 50;
       
        //Manter as configurações pré-definidas, mudando apenas as coordenadas
        //Instanciar e adicionar à janela cada um dos campos com nome
        gc.gridx = 0;
        gc.gridy = 0;
        accountNumberField = new TextFieldWithLabel("Número da Conta: ", 10);
        add(accountNumberField, gc);
        
        gc.gridy = 1;
        firstNameField = new TextFieldWithLabel("Nome: ", 10);
        add(firstNameField, gc);
        
        gc.gridy = 2;
        lastNameField = new TextFieldWithLabel("Sobrenome: ", 10);
        add(lastNameField, gc);
        
        gc.gridy = 3;
        balanceField = new TextFieldWithLabel("Saldo: ", 10);
        add(balanceField, gc);
        
        gc.gridy = 4;
        gc.gridwidth = 2;
        gc.anchor = GridBagConstraints.CENTER;
        registerButton = new JButton("Enviar");
        registerButton.addActionListener(this);
        add(registerButton, gc);
        
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int accountNumber;
        String firstName;
        String lastName;
        double balance;
        
        try{
            accountNumber = Integer.parseInt(accountNumberField.textField.getText());
        }catch(NumberFormatException numberFormatException){
            JOptionPane.showMessageDialog(null, 
                    "O campo NÚMERO DA CONTA deve conter apenas números.",
                    "Erro ao inserir dados",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
      
        try{
            balance = Double.parseDouble(balanceField.textField.getText());
        }catch(NumberFormatException numberFormatException){
            JOptionPane.showMessageDialog(null, 
                    "O campo SALDO deve conter apenas números.", 
                    "Erro ao inserir dados",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        firstName = firstNameField.textField.getText();
        if(firstName.length() == 0){
            JOptionPane.showMessageDialog(null, 
                    "O campo NOME não pode ser vazio.", 
                    "Erro ao inserir dados",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        lastName = lastNameField.textField.getText();
        if(lastName.length() == 0){
            JOptionPane.showMessageDialog(null, 
                    "O campo SOBRENOME não pode ser vazio.", 
                    "Erro ao inserir dados",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        textFileCreator.addRecords(new AccountRecord(accountNumber, firstName, lastName, balance));
        textFileCreator.closeFile();
        System.exit(0);
    }

       
    //Criar classe que consiste em um JPanel com um JLabel e um JTextField
    
    private class TextFieldWithLabel extends JPanel{
        JTextField textField;
        JLabel label;
        
        public TextFieldWithLabel(String fieldName, int size){
            setLayout(new FlowLayout());
            
            textField = new JTextField(size);
            label = new JLabel(fieldName);
            add(label);
            add(textField);
            
        }
    }
}

    
    

