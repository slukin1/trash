package com.huobi.woodpecker.model;

import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.base.BaseRecord;
import com.huobi.woodpecker.model.base.IRecord;
import com.huobi.woodpecker.utils.RecordUtil;
import com.sumsub.sns.internal.core.common.n0;
import org.json.JSONException;
import org.json.JSONObject;

public class WSTimeoutRecord extends BaseRecord<WSData> {

    public static class WSData implements IRecord {
        private String action;
        private int hitNum;
        private String host;
        private String topic;

        public boolean canEqual(Object obj) {
            return obj instanceof WSData;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof WSData)) {
                return false;
            }
            WSData wSData = (WSData) obj;
            if (!wSData.canEqual(this)) {
                return false;
            }
            String host2 = getHost();
            String host3 = wSData.getHost();
            if (host2 != null ? !host2.equals(host3) : host3 != null) {
                return false;
            }
            if (getHitNum() != wSData.getHitNum()) {
                return false;
            }
            String action2 = getAction();
            String action3 = wSData.getAction();
            if (action2 != null ? !action2.equals(action3) : action3 != null) {
                return false;
            }
            String topic2 = getTopic();
            String topic3 = wSData.getTopic();
            return topic2 != null ? topic2.equals(topic3) : topic3 == null;
        }

        public String getAction() {
            return this.action;
        }

        public int getHitNum() {
            return this.hitNum;
        }

        public String getHost() {
            return this.host;
        }

        public String getTopic() {
            return this.topic;
        }

        public int hashCode() {
            String host2 = getHost();
            int i11 = 43;
            int hashCode = (((host2 == null ? 43 : host2.hashCode()) + 59) * 59) + getHitNum();
            String action2 = getAction();
            int hashCode2 = (hashCode * 59) + (action2 == null ? 43 : action2.hashCode());
            String topic2 = getTopic();
            int i12 = hashCode2 * 59;
            if (topic2 != null) {
                i11 = topic2.hashCode();
            }
            return i12 + i11;
        }

        public void setAction(String str) {
            this.action = str;
        }

        public void setHitNum(int i11) {
            this.hitNum = i11;
        }

        public void setHost(String str) {
            this.host = str;
        }

        public void setTopic(String str) {
            this.topic = str;
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("url", this.host);
                jSONObject.put("hitNum", this.hitNum);
                jSONObject.put("action", this.action);
                jSONObject.put(n0.j.a.f32241v, this.topic);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            return jSONObject;
        }

        public String toJsonString() {
            return toJsonObject().toString();
        }

        public String toString() {
            return "WSTimeoutRecord.WSData(host=" + getHost() + ", hitNum=" + getHitNum() + ", action=" + getAction() + ", topic=" + getTopic() + ")";
        }
    }

    public WSTimeoutRecord() {
        setAction(ActionType.APP_SOCKET_TIMEOUT);
        setData(new WSData());
        RecordUtil.a(this);
    }
}
