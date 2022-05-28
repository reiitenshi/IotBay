/*
 *  Author: 14270375
 */
package isd.ass.model;

public class Order {
    
    private int orderId;
    private int deviceId;
    private int quantity;
    private boolean submitted;
    private String orderDate;

    public Order(int orderId, int deviceId, int quantity, boolean submitted, String orderDate) {
        this.orderId = orderId;
        this.deviceId = deviceId;
        this.quantity = quantity;
        this.submitted = submitted;
        this.orderDate = orderDate;
    }

    public Order(int deviceId, int quantity, boolean submitted, String orderDate) {
        this.deviceId = deviceId;
        this.quantity = quantity;
        this.submitted = submitted;
        this.orderDate = orderDate;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public boolean isSubmitted() {
        return submitted;
    }

    public void setSubmitted(boolean submitted) {
        this.submitted = submitted;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }
    
}
