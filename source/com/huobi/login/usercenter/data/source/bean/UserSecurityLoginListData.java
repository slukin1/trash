package com.huobi.login.usercenter.data.source.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class UserSecurityLoginListData implements Serializable {
    @SerializedName("device_name")
    private String deviceName;
    @SerializedName("fail_type")
    private long failType;
    @SerializedName("gmt_created")
    private long gmtCreated;
    @SerializedName("ip")

    /* renamed from: ip  reason: collision with root package name */
    private String f75696ip;
    @SerializedName("ip_country_id")
    private String ipCountryId;
    @SerializedName("ip_detail")
    private long ipDetail;
    @SerializedName("login_way")
    private int loginWay;
    @SerializedName("state")
    private int state;
    @SerializedName("time_zone")
    private long timeZone;
    @SerializedName("way")
    private String way;

    public boolean canEqual(Object obj) {
        return obj instanceof UserSecurityLoginListData;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof UserSecurityLoginListData)) {
            return false;
        }
        UserSecurityLoginListData userSecurityLoginListData = (UserSecurityLoginListData) obj;
        if (!userSecurityLoginListData.canEqual(this)) {
            return false;
        }
        String deviceName2 = getDeviceName();
        String deviceName3 = userSecurityLoginListData.getDeviceName();
        if (deviceName2 != null ? !deviceName2.equals(deviceName3) : deviceName3 != null) {
            return false;
        }
        if (getFailType() != userSecurityLoginListData.getFailType() || getGmtCreated() != userSecurityLoginListData.getGmtCreated()) {
            return false;
        }
        String ip2 = getIp();
        String ip3 = userSecurityLoginListData.getIp();
        if (ip2 != null ? !ip2.equals(ip3) : ip3 != null) {
            return false;
        }
        String ipCountryId2 = getIpCountryId();
        String ipCountryId3 = userSecurityLoginListData.getIpCountryId();
        if (ipCountryId2 != null ? !ipCountryId2.equals(ipCountryId3) : ipCountryId3 != null) {
            return false;
        }
        if (getIpDetail() != userSecurityLoginListData.getIpDetail() || getLoginWay() != userSecurityLoginListData.getLoginWay() || getState() != userSecurityLoginListData.getState() || getTimeZone() != userSecurityLoginListData.getTimeZone()) {
            return false;
        }
        String way2 = getWay();
        String way3 = userSecurityLoginListData.getWay();
        return way2 != null ? way2.equals(way3) : way3 == null;
    }

    public String getDeviceName() {
        return this.deviceName;
    }

    public long getFailType() {
        return this.failType;
    }

    public long getGmtCreated() {
        return this.gmtCreated;
    }

    public String getIp() {
        return this.f75696ip;
    }

    public String getIpCountryId() {
        return this.ipCountryId;
    }

    public long getIpDetail() {
        return this.ipDetail;
    }

    public int getLoginWay() {
        return this.loginWay;
    }

    public int getState() {
        return this.state;
    }

    public long getTimeZone() {
        return this.timeZone;
    }

    public String getWay() {
        return this.way;
    }

    public int hashCode() {
        String deviceName2 = getDeviceName();
        int i11 = 43;
        int hashCode = deviceName2 == null ? 43 : deviceName2.hashCode();
        long failType2 = getFailType();
        int i12 = ((hashCode + 59) * 59) + ((int) (failType2 ^ (failType2 >>> 32)));
        long gmtCreated2 = getGmtCreated();
        int i13 = (i12 * 59) + ((int) (gmtCreated2 ^ (gmtCreated2 >>> 32)));
        String ip2 = getIp();
        int hashCode2 = (i13 * 59) + (ip2 == null ? 43 : ip2.hashCode());
        String ipCountryId2 = getIpCountryId();
        int hashCode3 = (hashCode2 * 59) + (ipCountryId2 == null ? 43 : ipCountryId2.hashCode());
        long ipDetail2 = getIpDetail();
        int loginWay2 = (((((hashCode3 * 59) + ((int) (ipDetail2 ^ (ipDetail2 >>> 32)))) * 59) + getLoginWay()) * 59) + getState();
        long timeZone2 = getTimeZone();
        int i14 = (loginWay2 * 59) + ((int) (timeZone2 ^ (timeZone2 >>> 32)));
        String way2 = getWay();
        int i15 = i14 * 59;
        if (way2 != null) {
            i11 = way2.hashCode();
        }
        return i15 + i11;
    }

    public void setDeviceName(String str) {
        this.deviceName = str;
    }

    public void setFailType(long j11) {
        this.failType = j11;
    }

    public void setGmtCreated(long j11) {
        this.gmtCreated = j11;
    }

    public void setIp(String str) {
        this.f75696ip = str;
    }

    public void setIpCountryId(String str) {
        this.ipCountryId = str;
    }

    public void setIpDetail(long j11) {
        this.ipDetail = j11;
    }

    public void setLoginWay(int i11) {
        this.loginWay = i11;
    }

    public void setState(int i11) {
        this.state = i11;
    }

    public void setTimeZone(long j11) {
        this.timeZone = j11;
    }

    public void setWay(String str) {
        this.way = str;
    }

    public String toString() {
        return "UserSecurityLoginListData{deviceName='" + this.deviceName + '\'' + ", failType=" + this.failType + ", gmtCreated=" + this.gmtCreated + ", ip='" + this.f75696ip + '\'' + ", ipCountryId='" + this.ipCountryId + '\'' + ", ipDetail=" + this.ipDetail + ", loginWay=" + this.loginWay + ", state=" + this.state + ", timeZone=" + this.timeZone + ", way='" + this.way + '\'' + '}';
    }
}
