package com.huobi.woodpecker.model;

import cn.sharesdk.framework.InnerShareParams;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.base.BaseRecord;
import com.huobi.woodpecker.model.base.IRecord;
import org.json.JSONException;
import org.json.JSONObject;

public class AppCrashRecord extends BaseRecord<AppCrashRecordData> {

    public static class AppCrashRecordData implements IRecord {
        private String stack;

        public boolean canEqual(Object obj) {
            return obj instanceof AppCrashRecordData;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof AppCrashRecordData)) {
                return false;
            }
            AppCrashRecordData appCrashRecordData = (AppCrashRecordData) obj;
            if (!appCrashRecordData.canEqual(this)) {
                return false;
            }
            String stack2 = getStack();
            String stack3 = appCrashRecordData.getStack();
            return stack2 != null ? stack2.equals(stack3) : stack3 == null;
        }

        public String getStack() {
            return this.stack;
        }

        public int hashCode() {
            String stack2 = getStack();
            return 59 + (stack2 == null ? 43 : stack2.hashCode());
        }

        public void setStack(String str) {
            if (str != null && str.length() > 524288) {
                str = str.substring(0, 524288);
            }
            this.stack = str;
        }

        public JSONObject toJsonObject() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(InnerShareParams.STACK, this.stack);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            return jSONObject;
        }

        public String toJsonString() {
            return toJsonObject().toString();
        }

        public String toString() {
            return "AppCrashRecord.AppCrashRecordData(stack=" + getStack() + ")";
        }
    }

    public AppCrashRecord() {
        setAction(ActionType.APP_CRASH);
        setData(new AppCrashRecordData());
    }
}
