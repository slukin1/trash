package com.huobi.woodpecker.model;

import com.facebook.appevents.UserDataStore;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.base.BaseRecord;
import com.huobi.woodpecker.model.base.IRecord;
import org.json.JSONException;
import org.json.JSONObject;

public class AppActionRecord extends BaseRecord<AppActionRecordData> {

    public static class AppActionRecordData implements IRecord {
        private String actionType;
        private float cpuIncrement;
        private float endCpuRate;
        private float endMemory;
        private long endTime;

        /* renamed from: id  reason: collision with root package name */
        private String f21136id;
        private float memoryIncrement;
        private String name;
        private float startCpuRate;
        private float startMemory;
        private long startTime;

        public boolean canEqual(Object obj) {
            return obj instanceof AppActionRecordData;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AppActionRecordData)) {
                return false;
            }
            AppActionRecordData appActionRecordData = (AppActionRecordData) obj;
            if (!appActionRecordData.canEqual(this)) {
                return false;
            }
            String id2 = getId();
            String id3 = appActionRecordData.getId();
            if (id2 != null ? !id2.equals(id3) : id3 != null) {
                return false;
            }
            if (Float.compare(getStartMemory(), appActionRecordData.getStartMemory()) != 0 || Float.compare(getEndMemory(), appActionRecordData.getEndMemory()) != 0 || Float.compare(getStartCpuRate(), appActionRecordData.getStartCpuRate()) != 0 || Float.compare(getEndCpuRate(), appActionRecordData.getEndCpuRate()) != 0) {
                return false;
            }
            String name2 = getName();
            String name3 = appActionRecordData.getName();
            if (name2 != null ? !name2.equals(name3) : name3 != null) {
                return false;
            }
            if (Float.compare(getMemoryIncrement(), appActionRecordData.getMemoryIncrement()) != 0 || Float.compare(getCpuIncrement(), appActionRecordData.getCpuIncrement()) != 0) {
                return false;
            }
            String actionType2 = getActionType();
            String actionType3 = appActionRecordData.getActionType();
            if (actionType2 != null ? actionType2.equals(actionType3) : actionType3 == null) {
                return getStartTime() == appActionRecordData.getStartTime() && getEndTime() == appActionRecordData.getEndTime();
            }
            return false;
        }

        public String getActionType() {
            return this.actionType;
        }

        public float getCpuIncrement() {
            return this.cpuIncrement;
        }

        public float getEndCpuRate() {
            return this.endCpuRate;
        }

        public float getEndMemory() {
            return this.endMemory;
        }

        public long getEndTime() {
            return this.endTime;
        }

        public String getId() {
            return this.f21136id;
        }

        public float getMemoryIncrement() {
            return this.memoryIncrement;
        }

        public String getName() {
            return this.name;
        }

        public float getStartCpuRate() {
            return this.startCpuRate;
        }

        public float getStartMemory() {
            return this.startMemory;
        }

        public long getStartTime() {
            return this.startTime;
        }

        public int hashCode() {
            String id2 = getId();
            int i11 = 43;
            int hashCode = (((((((((id2 == null ? 43 : id2.hashCode()) + 59) * 59) + Float.floatToIntBits(getStartMemory())) * 59) + Float.floatToIntBits(getEndMemory())) * 59) + Float.floatToIntBits(getStartCpuRate())) * 59) + Float.floatToIntBits(getEndCpuRate());
            String name2 = getName();
            int hashCode2 = (((((hashCode * 59) + (name2 == null ? 43 : name2.hashCode())) * 59) + Float.floatToIntBits(getMemoryIncrement())) * 59) + Float.floatToIntBits(getCpuIncrement());
            String actionType2 = getActionType();
            int i12 = hashCode2 * 59;
            if (actionType2 != null) {
                i11 = actionType2.hashCode();
            }
            long startTime2 = getStartTime();
            int i13 = ((i12 + i11) * 59) + ((int) (startTime2 ^ (startTime2 >>> 32)));
            long endTime2 = getEndTime();
            return (i13 * 59) + ((int) ((endTime2 >>> 32) ^ endTime2));
        }

        public void setActionType(String str) {
            this.actionType = str;
        }

        public void setCpuIncrement(float f11) {
            this.cpuIncrement = f11;
        }

        public void setEndCpuRate(float f11) {
            this.endCpuRate = f11;
        }

        public void setEndMemory(float f11) {
            this.endMemory = f11;
        }

        public void setEndTime(long j11) {
            this.endTime = j11;
        }

        public void setId(String str) {
            this.f21136id = str;
        }

        public void setMemoryIncrement(float f11) {
            this.memoryIncrement = f11;
        }

        public void setName(String str) {
            this.name = str;
        }

        public void setStartCpuRate(float f11) {
            this.startCpuRate = f11;
        }

        public void setStartMemory(float f11) {
            this.startMemory = f11;
        }

        public void setStartTime(long j11) {
            this.startTime = j11;
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                String str = this.f21136id;
                if (str == null) {
                    str = "";
                }
                jSONObject.put("id", str);
                jSONObject.put("name", this.name);
                jSONObject.put("mem", (double) (this.endMemory - this.startMemory));
                jSONObject.put("cpu", (double) (this.endCpuRate - this.startCpuRate));
                jSONObject.put("type", this.actionType);
                jSONObject.put(UserDataStore.STATE, this.startTime);
                jSONObject.put("et", this.endTime);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            return jSONObject;
        }

        public String toJsonString() {
            return toJsonObject().toString();
        }

        public String toString() {
            return "AppActionRecord.AppActionRecordData(id=" + getId() + ", startMemory=" + getStartMemory() + ", endMemory=" + getEndMemory() + ", startCpuRate=" + getStartCpuRate() + ", endCpuRate=" + getEndCpuRate() + ", name=" + getName() + ", memoryIncrement=" + getMemoryIncrement() + ", cpuIncrement=" + getCpuIncrement() + ", actionType=" + getActionType() + ", startTime=" + getStartTime() + ", endTime=" + getEndTime() + ")";
        }
    }

    public AppActionRecord() {
        setAction(ActionType.APP_ACTION_PERF);
        setData(new AppActionRecordData());
    }
}
