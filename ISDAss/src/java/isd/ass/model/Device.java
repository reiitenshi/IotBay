/*
 *  Author: 14323808
 */
package isd.ass.model;

public class Device {

    private int deviceId;
    private String deviceName;
    private float unitPrice;
    private int deviceStock;
    private String deviceType;
    private String deviceBrand;

    public Device(int deviceId, String deviceName, float unitPrice, int deviceStock, String deviceType, String deviceBrand) {
        this.deviceId = deviceId;
        this.deviceName = deviceName;
        this.unitPrice = unitPrice;
        this.deviceStock = deviceStock;
        this.deviceType = deviceType;
        this.deviceBrand = deviceBrand;
    }

    public Device(String deviceName, float unitPrice, int deviceStock, String deviceType, String deviceBrand) {
        this.deviceName = deviceName;
        this.unitPrice = unitPrice;
        this.deviceStock = deviceStock;
        this.deviceType = deviceType;
        this.deviceBrand = deviceBrand;
    }

    public int getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(int deviceId) {
        this.deviceId = deviceId;
    }

    public String getDeviceName() {
        return deviceName;
    }

    public void setDeviceName(String deviceName) {
        this.deviceName = deviceName;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getDeviceStock() {
        return deviceStock;
    }

    public void setDeviceStock(int deviceStock) {
        this.deviceStock = deviceStock;
    }
    
    public String getDeviceType() {
        return deviceType;
    }

    public void setDeviceType(String deviceType) {
        this.deviceType = deviceType;
    }
    
    public String getDeviceBrand() {
        return deviceBrand;
    }

    public void setDeviceBrand(String deviceBrand) {
        this.deviceBrand = deviceBrand;
    }
}
