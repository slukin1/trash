package com.huobi.woodpecker.model;

import com.huobi.vulcan.model.VulcanInfo;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.base.BaseRecord;
import com.huobi.woodpecker.model.base.IRecord;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class AppStartRecord extends BaseRecord<AppStartRecordData> {

    public static class AppStartRecordData implements IRecord {
        private long appLaunchEndTime;
        private long appLaunchStartTime;
        private long sys = 0;

        public boolean canEqual(Object obj) {
            return obj instanceof AppStartRecordData;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AppStartRecordData)) {
                return false;
            }
            AppStartRecordData appStartRecordData = (AppStartRecordData) obj;
            return appStartRecordData.canEqual(this) && getAppLaunchStartTime() == appStartRecordData.getAppLaunchStartTime() && getAppLaunchEndTime() == appStartRecordData.getAppLaunchEndTime() && getSys() == appStartRecordData.getSys();
        }

        public long getAppLaunchEndTime() {
            return this.appLaunchEndTime;
        }

        public long getAppLaunchStartTime() {
            return this.appLaunchStartTime;
        }

        public long getSys() {
            return this.sys;
        }

        public long getUser() {
            long j11 = this.appLaunchEndTime - this.appLaunchStartTime;
            if (j11 > 0) {
                return j11;
            }
            return 0;
        }

        public int hashCode() {
            long appLaunchStartTime2 = getAppLaunchStartTime();
            long appLaunchEndTime2 = getAppLaunchEndTime();
            int i11 = ((((int) (appLaunchStartTime2 ^ (appLaunchStartTime2 >>> 32))) + 59) * 59) + ((int) (appLaunchEndTime2 ^ (appLaunchEndTime2 >>> 32)));
            long sys2 = getSys();
            return (i11 * 59) + ((int) ((sys2 >>> 32) ^ sys2));
        }

        public void setAppLaunchEndTime(long j11) {
            this.appLaunchEndTime = j11;
        }

        public void setAppLaunchStartTime(long j11) {
            this.appLaunchStartTime = j11;
        }

        public void setSys(long j11) {
            this.sys = j11;
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(VulcanInfo.SYS, this.sys);
                jSONObject.put("user", getUser());
                jSONObject.put("costs", new JSONArray());
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            return jSONObject;
        }

        public String toJsonString() {
            return toJsonObject().toString();
        }

        public String toString() {
            return "AppStartRecord.AppStartRecordData(appLaunchStartTime=" + getAppLaunchStartTime() + ", appLaunchEndTime=" + getAppLaunchEndTime() + ", sys=" + getSys() + ")";
        }
    }

    public AppStartRecord() {
        setData(new AppStartRecordData());
        setAction(ActionType.APP_START);
    }
}
