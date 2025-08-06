package com.huobi.woodpecker.model;

import android.text.TextUtils;
import com.huobi.woodpecker.kalle.simple.JsonFormat;
import com.iproov.sdk.bridge.OptionsBridge;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WebSocketConfig implements JsonFormat {
    private String action;
    private List<String> domain;

    /* renamed from: id  reason: collision with root package name */
    private int f21145id;
    private String test;
    private List<Integer> timeout;

    public static List<WebSocketConfig> fromJsonArr(JSONArray jSONArray) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < jSONArray.length(); i11++) {
            WebSocketConfig fromJsonObj = fromJsonObj(jSONArray.optJSONObject(i11));
            if (fromJsonObj != null) {
                fromJsonObj.setId(i11);
                arrayList.add(fromJsonObj);
            }
        }
        return arrayList;
    }

    public static WebSocketConfig fromJsonObj(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        WebSocketConfig webSocketConfig = new WebSocketConfig();
        webSocketConfig.fromJson(jSONObject);
        return webSocketConfig;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof WebSocketConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof WebSocketConfig)) {
            return false;
        }
        WebSocketConfig webSocketConfig = (WebSocketConfig) obj;
        if (!webSocketConfig.canEqual(this) || getId() != webSocketConfig.getId()) {
            return false;
        }
        String action2 = getAction();
        String action3 = webSocketConfig.getAction();
        if (action2 != null ? !action2.equals(action3) : action3 != null) {
            return false;
        }
        List<String> domain2 = getDomain();
        List<String> domain3 = webSocketConfig.getDomain();
        if (domain2 != null ? !domain2.equals(domain3) : domain3 != null) {
            return false;
        }
        String test2 = getTest();
        String test3 = webSocketConfig.getTest();
        if (test2 != null ? !test2.equals(test3) : test3 != null) {
            return false;
        }
        List<Integer> timeout2 = getTimeout();
        List<Integer> timeout3 = webSocketConfig.getTimeout();
        return timeout2 != null ? timeout2.equals(timeout3) : timeout3 == null;
    }

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.action = jSONObject.optString("action");
            this.test = jSONObject.optString("test");
            JSONArray optJSONArray = jSONObject.optJSONArray("domain");
            if (optJSONArray == null || optJSONArray.length() <= 0) {
                String optString = jSONObject.optString("domain");
                if (!TextUtils.isEmpty(optString)) {
                    ArrayList arrayList = new ArrayList();
                    this.domain = arrayList;
                    arrayList.add(optString);
                }
            } else {
                this.domain = new ArrayList();
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    String optString2 = optJSONArray.optString(i11);
                    if (!TextUtils.isEmpty(optString2)) {
                        this.domain.add(optString2);
                    }
                }
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray(OptionsBridge.TIMEOUT_KEY);
            if (optJSONArray2 == null || optJSONArray2.length() <= 0) {
                int optInt = jSONObject.optInt(OptionsBridge.TIMEOUT_KEY);
                if (optInt > 0) {
                    ArrayList arrayList2 = new ArrayList();
                    this.timeout = arrayList2;
                    arrayList2.add(Integer.valueOf(optInt));
                    return;
                }
                return;
            }
            this.timeout = new ArrayList();
            for (int i12 = 0; i12 < optJSONArray2.length(); i12++) {
                int optInt2 = optJSONArray2.optInt(i12);
                if (optInt2 > 0) {
                    this.timeout.add(Integer.valueOf(optInt2));
                }
            }
        }
    }

    public String getAction() {
        return this.action;
    }

    public List<String> getDomain() {
        return this.domain;
    }

    public int getFirstTimeout() {
        List<Integer> list = this.timeout;
        if (list == null || list.isEmpty()) {
            return 0;
        }
        return this.timeout.get(0).intValue();
    }

    public int getId() {
        return this.f21145id;
    }

    public String getTest() {
        return this.test;
    }

    public List<Integer> getTimeout() {
        return this.timeout;
    }

    public int hashCode() {
        String action2 = getAction();
        int i11 = 43;
        int id2 = ((getId() + 59) * 59) + (action2 == null ? 43 : action2.hashCode());
        List<String> domain2 = getDomain();
        int hashCode = (id2 * 59) + (domain2 == null ? 43 : domain2.hashCode());
        String test2 = getTest();
        int hashCode2 = (hashCode * 59) + (test2 == null ? 43 : test2.hashCode());
        List<Integer> timeout2 = getTimeout();
        int i12 = hashCode2 * 59;
        if (timeout2 != null) {
            i11 = timeout2.hashCode();
        }
        return i12 + i11;
    }

    public void setAction(String str) {
        this.action = str;
    }

    public void setDomain(List<String> list) {
        this.domain = list;
    }

    public void setId(int i11) {
        this.f21145id = i11;
    }

    public void setTest(String str) {
        this.test = str;
    }

    public void setTimeout(List<Integer> list) {
        this.timeout = list;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("action", this.action);
            jSONObject.put("test", this.test);
            JSONArray jSONArray = new JSONArray();
            List<String> list = this.domain;
            if (list != null && !list.isEmpty()) {
                for (String put : this.domain) {
                    jSONArray.put(put);
                }
            }
            jSONObject.put("domain", jSONArray);
            JSONArray jSONArray2 = new JSONArray();
            List<Integer> list2 = this.timeout;
            if (list2 != null && !list2.isEmpty()) {
                for (Integer intValue : this.timeout) {
                    jSONArray2.put(intValue.intValue());
                }
            }
            jSONObject.put(OptionsBridge.TIMEOUT_KEY, jSONArray2);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "WebSocketConfig(id=" + getId() + ", action=" + getAction() + ", domain=" + getDomain() + ", test=" + getTest() + ", timeout=" + getTimeout() + ")";
    }

    public int getTimeout(int i11) {
        List<Integer> list = this.timeout;
        if (list == null || list.isEmpty() || i11 < 0 || i11 >= this.timeout.size()) {
            return 0;
        }
        return this.timeout.get(i11).intValue();
    }
}
