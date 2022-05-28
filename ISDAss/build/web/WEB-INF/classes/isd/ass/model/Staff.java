/*
 *  Author: 14279842
 */
package isd.ass.model;

public class Staff{
    
    private String staffEmail;
    private String staffName;
    private String staffPosition;
    private String staffAddress;
    private String staffStatus;
    
    public Staff(){
        
    }
    
    public Staff(String email, String name, String position, String address, String status){
        this.staffEmail = email;
        this.staffName = name;
        this.staffPosition = position;
        this.staffAddress = address;
        this.staffStatus = status;
    }
    
    
    public String getStaffName(){
        return this.staffName;
    }
    public void setStaffName(String staffName){
        this.staffName = staffName;
    }
    public String getStaffEmail(){
        return this.staffEmail;
    }
    public void setStaffEmail(String staffEmail){
        this.staffEmail = staffEmail;
    }
    public String getStaffAddress(){
        return this.staffAddress;
    }
    public void setStaffAddress(String staffAddress){
        this.staffAddress = staffAddress;
    }
    public String getStaffPosition(){
        return this.staffPosition;
    }
    public void setStaffPosition(String staffPosition){
        this.staffPosition = staffPosition;
    }
    public String getStaffStatus(){
        return this.staffStatus;
    }
    public void setStaffStatus(String staffStatus){
        this.staffStatus = staffStatus;
    }
    
}
