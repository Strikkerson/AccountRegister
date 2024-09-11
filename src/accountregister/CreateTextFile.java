package accountregister;

import java.io.FileNotFoundException;
import java.lang.SecurityException;
import java.util.Formatter;
import javax.swing.JOptionPane;


public class CreateTextFile
{
    private Formatter output;

    public void openFile()
    {
        try
        {
            output = new Formatter( "clients.txt ");
        }

        catch ( SecurityException securityException )
        {
            JOptionPane.showMessageDialog(null, 
                    "Você não tem acesso para escrever neste arquivo.", 
                    "Erro ao inicializar arquivo de registro",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
        catch ( FileNotFoundException fileNotFoundException)
        {
            JOptionPane.showMessageDialog(null, 
                    "Erro ao abrir ou criar o arquivo.", 
                    "Erro ao inicializar arquivo de registro",
                    JOptionPane.ERROR_MESSAGE);
            System.exit(1);
        }
    }

    public void addRecords(AccountRecord record)
    {
        output.format( "%d %s %s %.2f\n", record.getAccount(), record.getFirstName(), record.getLastName(), record.getBalance() );
        JOptionPane.showMessageDialog(null, "Dados inseridos com sucesso.");
        
    }

    public void closeFile()
    {
        if ( output != null )
        {
            output.close();
        }
    }
}
