/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package accountregister;

/**
 *
 * @author Strikke
 */
public class AccountRegister {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CreateTextFile textFileCreator = new CreateTextFile();
        textFileCreator.openFile();
        
        RegisterFrame registerFrame = new RegisterFrame(textFileCreator);
        
    }
    
}
