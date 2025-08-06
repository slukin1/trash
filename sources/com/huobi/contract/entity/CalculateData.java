package com.huobi.contract.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class CalculateData implements Parcelable {
    public static final Parcelable.Creator<CalculateData> CREATOR = new a();
    private String contractCode;
    private String crossedIsolatedType;
    private String currency;
    private String currentContractCode;
    private String symbol;
    private String unit;

    public class a implements Parcelable.Creator<CalculateData> {
        /* renamed from: a */
        public CalculateData createFromParcel(Parcel parcel) {
            return new CalculateData(parcel);
        }

        /* renamed from: b */
        public CalculateData[] newArray(int i11) {
            return new CalculateData[i11];
        }
    }

    public CalculateData(String str, String str2, String str3) {
        setSymbol(str);
        setUnit(str2);
        setCurrency(str3);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof CalculateData;
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof CalculateData)) {
            return false;
        }
        CalculateData calculateData = (CalculateData) obj;
        if (!calculateData.canEqual(this)) {
            return false;
        }
        String symbol2 = getSymbol();
        String symbol3 = calculateData.getSymbol();
        if (symbol2 != null ? !symbol2.equals(symbol3) : symbol3 != null) {
            return false;
        }
        String unit2 = getUnit();
        String unit3 = calculateData.getUnit();
        if (unit2 != null ? !unit2.equals(unit3) : unit3 != null) {
            return false;
        }
        String currency2 = getCurrency();
        String currency3 = calculateData.getCurrency();
        if (currency2 != null ? !currency2.equals(currency3) : currency3 != null) {
            return false;
        }
        String contractCode2 = getContractCode();
        String contractCode3 = calculateData.getContractCode();
        if (contractCode2 != null ? !contractCode2.equals(contractCode3) : contractCode3 != null) {
            return false;
        }
        String currentContractCode2 = getCurrentContractCode();
        String currentContractCode3 = calculateData.getCurrentContractCode();
        if (currentContractCode2 != null ? !currentContractCode2.equals(currentContractCode3) : currentContractCode3 != null) {
            return false;
        }
        String crossedIsolatedType2 = getCrossedIsolatedType();
        String crossedIsolatedType3 = calculateData.getCrossedIsolatedType();
        return crossedIsolatedType2 != null ? crossedIsolatedType2.equals(crossedIsolatedType3) : crossedIsolatedType3 == null;
    }

    public String getContractCode() {
        return this.contractCode;
    }

    public String getCrossedIsolatedType() {
        return this.crossedIsolatedType;
    }

    public String getCurrency() {
        return this.currency;
    }

    public String getCurrentContractCode() {
        return this.currentContractCode;
    }

    public String getSymbol() {
        return this.symbol;
    }

    public String getUnit() {
        return this.unit;
    }

    public int hashCode() {
        String symbol2 = getSymbol();
        int i11 = 43;
        int hashCode = symbol2 == null ? 43 : symbol2.hashCode();
        String unit2 = getUnit();
        int hashCode2 = ((hashCode + 59) * 59) + (unit2 == null ? 43 : unit2.hashCode());
        String currency2 = getCurrency();
        int hashCode3 = (hashCode2 * 59) + (currency2 == null ? 43 : currency2.hashCode());
        String contractCode2 = getContractCode();
        int hashCode4 = (hashCode3 * 59) + (contractCode2 == null ? 43 : contractCode2.hashCode());
        String currentContractCode2 = getCurrentContractCode();
        int hashCode5 = (hashCode4 * 59) + (currentContractCode2 == null ? 43 : currentContractCode2.hashCode());
        String crossedIsolatedType2 = getCrossedIsolatedType();
        int i12 = hashCode5 * 59;
        if (crossedIsolatedType2 != null) {
            i11 = crossedIsolatedType2.hashCode();
        }
        return i12 + i11;
    }

    public void setContractCode(String str) {
        this.contractCode = str;
    }

    public void setCrossedIsolatedType(String str) {
        this.crossedIsolatedType = str;
    }

    public void setCurrency(String str) {
        this.currency = str;
    }

    public void setCurrentContractCode(String str) {
        this.currentContractCode = str;
    }

    public void setSymbol(String str) {
        this.symbol = str;
    }

    public void setUnit(String str) {
        this.unit = str;
    }

    public String toString() {
        return "CalculateData(symbol=" + getSymbol() + ", unit=" + getUnit() + ", currency=" + getCurrency() + ", contractCode=" + getContractCode() + ", currentContractCode=" + getCurrentContractCode() + ", crossedIsolatedType=" + getCrossedIsolatedType() + ")";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.symbol);
        parcel.writeString(this.unit);
        parcel.writeString(this.currency);
        parcel.writeString(this.contractCode);
        parcel.writeString(this.currentContractCode);
    }

    public CalculateData(String str, String str2, String str3, String str4) {
        setSymbol(str);
        setUnit(str2);
        setCurrency(str3);
        setCrossedIsolatedType(str4);
    }

    public CalculateData(Parcel parcel) {
        this.symbol = parcel.readString();
        this.unit = parcel.readString();
        this.currency = parcel.readString();
        this.contractCode = parcel.readString();
        this.currentContractCode = parcel.readString();
    }
}
