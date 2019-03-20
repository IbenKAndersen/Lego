package Lego.logic;

/**
 * The purpose of LoginException is to show a message, when the user is not valid.
 * 
 * @author ibenk
 */
public class LoginException extends Exception {

    public LoginException(String msg) {
        super(msg);
    }
    
}
