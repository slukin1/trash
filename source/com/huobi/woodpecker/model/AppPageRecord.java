package com.huobi.woodpecker.model;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.base.BaseRecord;
import com.huobi.woodpecker.model.base.IRecord;
import org.json.JSONException;
import org.json.JSONObject;

public class AppPageRecord extends BaseRecord<AppPageRecordData> {

    public static class AppPageRecordData implements IRecord {
        private float endMemory;
        private long onCreatedTimeMs;
        private long onResumedTimeMs;
        private long pageLoadTimeMs;
        private String pageName;
        private float startMemory;

        public boolean canEqual(Object obj) {
            return obj instanceof AppPageRecordData;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AppPageRecordData)) {
                return false;
            }
            AppPageRecordData appPageRecordData = (AppPageRecordData) obj;
            if (!appPageRecordData.canEqual(this)) {
                return false;
            }
            String pageName2 = getPageName();
            String pageName3 = appPageRecordData.getPageName();
            if (pageName2 != null ? pageName2.equals(pageName3) : pageName3 == null) {
                return getPageLoadTimeMs() == appPageRecordData.getPageLoadTimeMs() && Float.compare(getStartMemory(), appPageRecordData.getStartMemory()) == 0 && Float.compare(getEndMemory(), appPageRecordData.getEndMemory()) == 0 && getOnCreatedTimeMs() == appPageRecordData.getOnCreatedTimeMs() && getOnResumedTimeMs() == appPageRecordData.getOnResumedTimeMs();
            }
            return false;
        }

        public float getEndMemory() {
            return this.endMemory;
        }

        public long getOnCreatedTimeMs() {
            return this.onCreatedTimeMs;
        }

        public long getOnResumedTimeMs() {
            return this.onResumedTimeMs;
        }

        public long getPageLoadTimeMs() {
            return this.pageLoadTimeMs;
        }

        public String getPageName() {
            return this.pageName;
        }

        public float getStartMemory() {
            return this.startMemory;
        }

        public int hashCode() {
            String pageName2 = getPageName();
            int hashCode = pageName2 == null ? 43 : pageName2.hashCode();
            long pageLoadTimeMs2 = getPageLoadTimeMs();
            int floatToIntBits = ((((((hashCode + 59) * 59) + ((int) (pageLoadTimeMs2 ^ (pageLoadTimeMs2 >>> 32)))) * 59) + Float.floatToIntBits(getStartMemory())) * 59) + Float.floatToIntBits(getEndMemory());
            long onCreatedTimeMs2 = getOnCreatedTimeMs();
            int i11 = (floatToIntBits * 59) + ((int) (onCreatedTimeMs2 ^ (onCreatedTimeMs2 >>> 32)));
            long onResumedTimeMs2 = getOnResumedTimeMs();
            return (i11 * 59) + ((int) ((onResumedTimeMs2 >>> 32) ^ onResumedTimeMs2));
        }

        public void setEndMemory(float f11) {
            this.endMemory = f11;
        }

        public void setOnCreatedTimeMs(long j11) {
            this.onCreatedTimeMs = j11;
        }

        public void setOnResumedTimeMs(long j11) {
            this.onResumedTimeMs = j11;
        }

        public void setPageLoadTimeMs(long j11) {
            this.pageLoadTimeMs = j11;
        }

        public void setPageName(String str) {
            this.pageName = str;
        }

        public void setStartMemory(float f11) {
            this.startMemory = f11;
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("name", this.pageName);
                jSONObject.put(CrashHianalyticsData.TIME, this.pageLoadTimeMs);
                jSONObject.put("mem", (double) (this.endMemory - this.startMemory));
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            return jSONObject;
        }

        public String toJsonString() {
            return toJsonObject().toString();
        }

        public String toString() {
            return "AppPageRecord.AppPageRecordData(pageName=" + getPageName() + ", pageLoadTimeMs=" + getPageLoadTimeMs() + ", startMemory=" + getStartMemory() + ", endMemory=" + getEndMemory() + ", onCreatedTimeMs=" + getOnCreatedTimeMs() + ", onResumedTimeMs=" + getOnResumedTimeMs() + ")";
        }
    }

    public AppPageRecord() {
        setAction(ActionType.APP_PAGE_PERF);
        setData(new AppPageRecordData());
    }
}
