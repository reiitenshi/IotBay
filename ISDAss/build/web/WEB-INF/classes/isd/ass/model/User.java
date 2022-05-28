/*
 *  Author: 1398360
 */
package isd.ass.model;

public class User {

    private String userEmail;
    private String userPassword;
    private String userFName;
    private String userLName;
    private String userAddress;

    public User(String userEmail, String userPassword, String userFName, String userLName, String userAddress) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userFName = userFName;
        this.userLName = userLName;
        this.userAddress = userAddress;
    }
    
    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }
    
    public String getUserFName() {
        return userFName;
    }

    public void setUserFName(String userFName) {
        this.userFName = userFName;
    }
    
    public String getUserLName() {
        return userLName;
    }

    public void setUserLName(String userLName) {
        this.userLName = userLName;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }
   
}
