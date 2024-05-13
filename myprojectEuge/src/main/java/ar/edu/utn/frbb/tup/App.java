package ar.edu.utn.frbb.tup;

import ar.edu.utn.frbb.tup.input.MenuInputProcessor;
import ar.edu.utn.frbb.tup.model.Banco;


public class App 
{
    public static void main( String[] args )
    {
        Banco banco = new Banco();

        MenuInputProcessor menuInputProcessor = new MenuInputProcessor();
        menuInputProcessor.renderMenu(banco);

        
    }
}
