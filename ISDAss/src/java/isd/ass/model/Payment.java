/*
 *  Author: 13900509
 */
package isd.ass.model;

public class Payment {
    
    private int paymentId;
    private String userEmail;
    private String cardNo;
    private String cardCVV;
    private String cardName;

    public Payment(int paymentId, String userEmail, String cardNo, String cardCVV, String cardName) {
        this.paymentId = paymentId;
        this.userEmail = userEmail;
        this.cardNo = cardNo;
        this.cardCVV = cardCVV;
        this.cardName = cardName;
    }

    public Payment(String userEmail, String cardNo, String cardCVV, String cardName) {
        this.userEmail = userEmail;
        this.cardNo = cardNo;
        this.cardCVV = cardCVV;
        this.cardName = cardName;
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCardCVV() {
        return cardCVV;
    }

    public void setCardCVV(String cardCVV) {
        this.cardCVV = cardCVV;
    }

    public String getCardName() {
        return cardName;
    }

    public void setCardName(String cardName) {
        this.cardName = cardName;
    }
    
}
