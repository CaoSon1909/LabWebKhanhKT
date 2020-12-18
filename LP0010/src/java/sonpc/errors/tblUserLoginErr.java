/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sonpc.errors;

import java.io.Serializable;

/**
 *
 * @author ACER
 */
public class tblUserLoginErr implements Serializable{
    
    private String userIDLength;
    private String passwordLength;
    private boolean invalidAccount;

    public String getUserIDLength() {
        return userIDLength;
    }

    public void setUserIDLength(String userIDLength) {
        this.userIDLength = userIDLength;
    }

    public String getPasswordLength() {
        return passwordLength;
    }

    public void setPasswordLength(String passwordLength) {
        this.passwordLength = passwordLength;
    }

    public boolean isInvalidAccount() {
        return invalidAccount;
    }

    public void setInvalidAccount(boolean invalidAccount) {
        this.invalidAccount = invalidAccount;
    }

    
    
    
    
}
