package com.google.zxing.client.result;

public final class VINParsedResult extends ParsedResult {
    private final String countryCode;
    private final int modelYear;
    private final char plantCode;
    private final String sequentialNumber;
    private final String vehicleAttributes;
    private final String vehicleDescriptorSection;
    private final String vehicleIdentifierSection;
    private final String vin;
    private final String worldManufacturerID;

    public VINParsedResult(String str, String str2, String str3, String str4, String str5, String str6, int i11, char c11, String str7) {
        super(ParsedResultType.VIN);
        this.vin = str;
        this.worldManufacturerID = str2;
        this.vehicleDescriptorSection = str3;
        this.vehicleIdentifierSection = str4;
        this.countryCode = str5;
        this.vehicleAttributes = str6;
        this.modelYear = i11;
        this.plantCode = c11;
        this.sequentialNumber = str7;
    }

    public String getCountryCode() {
        return this.countryCode;
    }

    public String getDisplayResult() {
        StringBuilder sb2 = new StringBuilder(50);
        sb2.append(this.worldManufacturerID);
        sb2.append(' ');
        sb2.append(this.vehicleDescriptorSection);
        sb2.append(' ');
        sb2.append(this.vehicleIdentifierSection);
        sb2.append(10);
        String str = this.countryCode;
        if (str != null) {
            sb2.append(str);
            sb2.append(' ');
        }
        sb2.append(this.modelYear);
        sb2.append(' ');
        sb2.append(this.plantCode);
        sb2.append(' ');
        sb2.append(this.sequentialNumber);
        sb2.append(10);
        return sb2.toString();
    }

    public int getModelYear() {
        return this.modelYear;
    }

    public char getPlantCode() {
        return this.plantCode;
    }

    public String getSequentialNumber() {
        return this.sequentialNumber;
    }

    public String getVIN() {
        return this.vin;
    }

    public String getVehicleAttributes() {
        return this.vehicleAttributes;
    }

    public String getVehicleDescriptorSection() {
        return this.vehicleDescriptorSection;
    }

    public String getVehicleIdentifierSection() {
        return this.vehicleIdentifierSection;
    }

    public String getWorldManufacturerID() {
        return this.worldManufacturerID;
    }
}
