package com.huobi.woodpecker.model.udf;

import com.huobi.woodpecker.model.base.BaseRecord;
import com.huobi.woodpecker.model.base.IRecord;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ActionRecord extends BaseRecord<UdfRecordData> {

    public static class UdfRecordData implements IRecord {
        private Map<String, Object> map = new HashMap();

        public boolean canEqual(Object obj) {
            return obj instanceof UdfRecordData;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof UdfRecordData)) {
                return false;
            }
            UdfRecordData udfRecordData = (UdfRecordData) obj;
            if (!udfRecordData.canEqual(this)) {
                return false;
            }
            Map<String, Object> map2 = getMap();
            Map<String, Object> map3 = udfRecordData.getMap();
            return map2 != null ? map2.equals(map3) : map3 == null;
        }

        public Map<String, Object> getMap() {
            return this.map;
        }

        public int hashCode() {
            Map<String, Object> map2 = getMap();
            return 59 + (map2 == null ? 43 : map2.hashCode());
        }

        public void setMap(Map<String, Object> map2) {
            this.map = map2;
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                for (Map.Entry next : this.map.entrySet()) {
                    if (!(next.getKey() == null || next.getValue() == null)) {
                        jSONObject.put((String) next.getKey(), next.getValue());
                    }
                }
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            return jSONObject;
        }

        public String toJsonString() {
            return toJsonObject().toString();
        }

        public String toString() {
            return "ActionRecord.UdfRecordData(map=" + getMap() + ")";
        }
    }

    public ActionRecord() {
        setData(new UdfRecordData());
    }
}
