package com.tencent.tpns.baseapi.base.device;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.tpns.baseapi.base.PushPreferences;
import com.tencent.tpns.baseapi.base.util.Util;

public class GUIDInfo {
    public int encrypt = 0;
    public int errCode;
    public long expiredSeconds = 0;
    public long guid = 0;
    public long guidLastAccessid = 0;
    public String mqttPortList = "";
    public String mqttServer = "";
    public String mqttServerIP = "";
    public long mqttServerRefreshTime = 0;
    public String passWord = "";
    public long refreshTime = 0;
    public int refuseRate = 0;
    public String result = "";
    public String token = "";
    public String tokenList = "";
    public String userName = "";

    public static GUIDInfo getGuidInfoFromShar(Context context) {
        GUIDInfo gUIDInfo = new GUIDInfo();
        try {
            gUIDInfo.guid = PushPreferences.getLong(context, "XG_GUID_GUID", 0);
            gUIDInfo.expiredSeconds = PushPreferences.getLong(context, "XG_GUID_EXPIRED_SECONDS", 0);
            gUIDInfo.refreshTime = PushPreferences.getLong(context, "XG_GUID_LAST_REFRESH_TIME", 0);
            gUIDInfo.token = PushPreferences.getString(context, "XG_GUID_TOKEN", "");
            gUIDInfo.tokenList = PushPreferences.getString(context, "XG_GUID_TOKEN_LIST", "");
            gUIDInfo.mqttServer = PushPreferences.getString(context, "XG_GUID_MQTT_SERVER", "");
            gUIDInfo.userName = PushPreferences.getString(context, "XG_GUID_MQTT_USERNAME", "");
            gUIDInfo.passWord = PushPreferences.getString(context, "XG_GUID_MQTT_PASSWORD", "");
            gUIDInfo.guidLastAccessid = PushPreferences.getLong(context, "XG_GUID_LAST_ACCESSID", 0);
            gUIDInfo.mqttServerRefreshTime = PushPreferences.getLong(context, "XG_GUID_MQTT_SERVER_LAST_REFRESH_TIME", 0);
            gUIDInfo.refuseRate = PushPreferences.getInt(context, "XG_GUID_SERVER_ABANDON_RATE", 0);
            gUIDInfo.mqttPortList = PushPreferences.getString(context, "XG_GUID_MQTT_PORTLIST", "");
            gUIDInfo.encrypt = PushPreferences.getInt(context, "XG_GUID_SERVER_ENCRYPT_LEVEL", 0);
        } catch (Throwable unused) {
        }
        return gUIDInfo;
    }

    public boolean isError() {
        if (this.errCode != 0) {
            return true;
        }
        if (!Util.isNullOrEmptyString(this.token) && !Util.isNullOrEmptyString(this.mqttServer) && !Util.isNullOrEmptyString(this.userName) && !Util.isNullOrEmptyString(this.passWord)) {
            return false;
        }
        this.errCode = -5;
        this.result = "GUID check result is null";
        return true;
    }

    public void saveGuidToSha(Context context) {
        ContentValues contentValues = new ContentValues();
        if (!Util.isNullOrEmptyString(this.token)) {
            contentValues.put("XG_GUID_TOKEN", this.token);
        }
        if (!Util.isNullOrEmptyString(this.tokenList)) {
            contentValues.put("XG_GUID_TOKEN_LIST", this.tokenList);
        }
        if (!Util.isNullOrEmptyString(this.mqttServer)) {
            contentValues.put("XG_GUID_MQTT_SERVER", this.mqttServer);
        }
        if (!Util.isNullOrEmptyString(this.userName)) {
            contentValues.put("XG_GUID_MQTT_USERNAME", this.userName);
        }
        if (!Util.isNullOrEmptyString(this.passWord)) {
            contentValues.put("XG_GUID_MQTT_PASSWORD", this.passWord);
        }
        long j11 = this.guid;
        if (j11 >= 0) {
            contentValues.put("XG_GUID_GUID", Long.valueOf(j11));
        }
        long j12 = this.expiredSeconds;
        if (j12 >= 0) {
            contentValues.put("XG_GUID_EXPIRED_SECONDS", Long.valueOf(j12));
        }
        long j13 = this.refreshTime;
        if (j13 >= 0) {
            contentValues.put("XG_GUID_LAST_REFRESH_TIME", Long.valueOf(j13));
        }
        long j14 = this.guidLastAccessid;
        if (j14 >= 0) {
            contentValues.put("XG_GUID_LAST_ACCESSID", Long.valueOf(j14));
        }
        int i11 = this.refuseRate;
        if (((long) i11) >= 0) {
            contentValues.put("XG_GUID_SERVER_ABANDON_RATE", Integer.valueOf(i11));
        }
        int i12 = this.encrypt;
        if (i12 >= 0) {
            contentValues.put("XG_GUID_SERVER_ENCRYPT_LEVEL", Integer.valueOf(i12));
        }
        if (!Util.isNullOrEmptyString(this.mqttPortList)) {
            contentValues.put("XG_GUID_MQTT_PORTLIST", this.mqttPortList);
        }
        PushPreferences.putContentValues(context, contentValues);
    }

    public String toString() {
        return "GUIDInfo{token='" + this.token + '\'' + ", tokenList='" + this.tokenList + '\'' + ", mqttServer='" + this.mqttServer + '\'' + ", mqttServerIP='" + this.mqttServerIP + '\'' + ", userName='" + this.userName + '\'' + ", passWord='" + this.passWord + '\'' + ", guid=" + this.guid + ", expiredSeconds=" + this.expiredSeconds + ", refreshTime=" + this.refreshTime + ", guidLastAccessid=" + this.guidLastAccessid + ", refuseRate=" + this.refuseRate + ", mqttPortList='" + this.mqttPortList + '\'' + ", encrypt=" + this.encrypt + ", mqttServerRefreshTime=" + this.mqttServerRefreshTime + ", errCode=" + this.errCode + ", result='" + this.result + '\'' + '}';
    }
}
