package accountregister;


public class AccountRegister {
    public static void main(String[] args) {
        CreateTextFile textFileCreator = new CreateTextFile();
        textFileCreator.openFile();
        
        RegisterFrame registerFrame = new RegisterFrame(textFileCreator);
        
    }
    
}
