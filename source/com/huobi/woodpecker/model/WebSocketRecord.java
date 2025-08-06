package com.huobi.woodpecker.model;

import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.base.BaseRecord;
import com.huobi.woodpecker.model.base.IRecord;
import com.huobi.woodpecker.utils.RecordUtil;
import org.json.JSONException;
import org.json.JSONObject;

public class WebSocketRecord extends BaseRecord<WebSocketRecordData> {

    public static class WebSocketRecordData implements IRecord {
        private long costTime;
        private int status;
        @Deprecated
        private String topic;
        private String url;

        public boolean canEqual(Object obj) {
            return obj instanceof WebSocketRecordData;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WebSocketRecordData)) {
                return false;
            }
            WebSocketRecordData webSocketRecordData = (WebSocketRecordData) obj;
            if (!webSocketRecordData.canEqual(this)) {
                return false;
            }
            String topic2 = getTopic();
            String topic3 = webSocketRecordData.getTopic();
            if (topic2 != null ? !topic2.equals(topic3) : topic3 != null) {
                return false;
            }
            String url2 = getUrl();
            String url3 = webSocketRecordData.getUrl();
            if (url2 != null ? url2.equals(url3) : url3 == null) {
                return getStatus() == webSocketRecordData.getStatus() && getCostTime() == webSocketRecordData.getCostTime();
            }
            return false;
        }

        public long getCostTime() {
            return this.costTime;
        }

        public int getStatus() {
            return this.status;
        }

        @Deprecated
        public String getTopic() {
            return this.topic;
        }

        public String getUrl() {
            return this.url;
        }

        public int hashCode() {
            String topic2 = getTopic();
            int i11 = 43;
            int hashCode = topic2 == null ? 43 : topic2.hashCode();
            String url2 = getUrl();
            int i12 = (hashCode + 59) * 59;
            if (url2 != null) {
                i11 = url2.hashCode();
            }
            long costTime2 = getCostTime();
            return ((((i12 + i11) * 59) + getStatus()) * 59) + ((int) ((costTime2 >>> 32) ^ costTime2));
        }

        public void setCostTime(long j11) {
            this.costTime = j11;
        }

        public void setStatus(int i11) {
            this.status = i11;
        }

        @Deprecated
        public void setTopic(String str) {
            this.topic = str;
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", this.url);
                jSONObject.put("status", this.status);
                jSONObject.put(CrashHianalyticsData.TIME, this.costTime);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            return jSONObject;
        }

        public String toJsonString() {
            return toJsonObject().toString();
        }

        public String toString() {
            return "WebSocketRecord.WebSocketRecordData(topic=" + getTopic() + ", url=" + getUrl() + ", status=" + getStatus() + ", costTime=" + getCostTime() + ")";
        }
    }

    public WebSocketRecord() {
        setAction(ActionType.APP_SOCKET);
        setData(new WebSocketRecordData());
        RecordUtil.a(this);
    }
}
