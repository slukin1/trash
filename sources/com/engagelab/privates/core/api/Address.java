package com.engagelab.privates.core.api;

import android.os.Parcel;
import android.os.Parcelable;

public class Address implements Parcelable {
    public static final Parcelable.Creator<Address> CREATOR = new a();
    private String defaultHost = "conn.push.theengagelab.com";
    private String defaultIp = "159.138.90.61";
    private int defaultPort = 3000;
    private String defaultReportUrl = "https://pushstat.api.engagelab.cc";
    private String[] sisHostArray = {"sis.push.theengagelab.com", "sis.push.engageforce.net", "sis.push.engage7.com"};
    private String[] sisIpArray = {"159.138.85.252", "114.119.186.57"};
    private int sisPort = 19000;

    public static class a implements Parcelable.Creator<Address> {
        /* renamed from: a */
        public Address createFromParcel(Parcel parcel) {
            return new Address(parcel);
        }

        /* renamed from: a */
        public Address[] newArray(int i11) {
            return new Address[i11];
        }
    }

    public Address() {
    }

    public int describeContents() {
        return 0;
    }

    public String getDefaultHost() {
        return this.defaultHost;
    }

    public String getDefaultIp() {
        return this.defaultIp;
    }

    public int getDefaultPort() {
        return this.defaultPort;
    }

    public String getDefaultReportUrl() {
        return this.defaultReportUrl;
    }

    public String[] getSisHostArray() {
        return this.sisHostArray;
    }

    public String[] getSisIpArray() {
        return this.sisIpArray;
    }

    public int getSisPort() {
        return this.sisPort;
    }

    public Address setDefaultHost(String str) {
        this.defaultHost = str;
        return this;
    }

    public Address setDefaultIp(String str) {
        this.defaultIp = str;
        return this;
    }

    public Address setDefaultPort(int i11) {
        this.defaultPort = i11;
        return this;
    }

    public Address setDefaultReportUrl(String str) {
        this.defaultReportUrl = str;
        return this;
    }

    public Address setSisHostArray(String... strArr) {
        this.sisHostArray = strArr;
        return this;
    }

    public Address setSisIpArray(String... strArr) {
        this.sisIpArray = strArr;
        return this;
    }

    public Address setSisPort(int i11) {
        this.sisPort = i11;
        return this;
    }

    public String toString() {
        return "\n{\n  sisHostArray=" + this.sisHostArray + ",\n  sisIpArray=" + this.sisIpArray + ",\n  sisPort=" + this.sisPort + ",\n  defaultHost=" + this.defaultHost + ",\n  defaultIp=" + this.defaultIp + ",\n  defaultHost=" + this.defaultHost + ",\n  defaultPort=" + this.defaultPort + ",\n  defaultReportUrl=" + this.defaultReportUrl + "\n}";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeStringArray(this.sisHostArray);
        parcel.writeStringArray(this.sisIpArray);
        parcel.writeInt(this.sisPort);
        parcel.writeString(this.defaultHost);
        parcel.writeString(this.defaultIp);
        parcel.writeInt(this.defaultPort);
        parcel.writeString(this.defaultReportUrl);
    }

    public Address(Parcel parcel) {
        this.sisHostArray = parcel.createStringArray();
        this.sisIpArray = parcel.createStringArray();
        this.sisPort = parcel.readInt();
        this.defaultHost = parcel.readString();
        this.defaultIp = parcel.readString();
        this.defaultPort = parcel.readInt();
        this.defaultReportUrl = parcel.readString();
    }
}
