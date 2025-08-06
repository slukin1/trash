package com.huobi.woodpecker.model;

import android.text.TextUtils;
import com.huobi.vulcan.model.VulcanInfo;
import com.huobi.woodpecker.kalle.simple.JsonFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HttpDnsConfig implements JsonFormat {
    private String accountID;
    private boolean enable;
    private String region;
    private Map<String, HostPathConfig> whiteList;

    public static class HostPathConfig implements JsonFormat {
        /* access modifiers changed from: private */
        public String host;
        private List<String> paths;

        public HostPathConfig() {
        }

        public static HostPathConfig formatJson(JSONObject jSONObject) {
            ArrayList arrayList;
            if (jSONObject != null) {
                String optString = jSONObject.optString(VulcanInfo.HOST);
                JSONArray optJSONArray = jSONObject.optJSONArray("paths");
                if (optJSONArray == null || optJSONArray.length() <= 0) {
                    arrayList = null;
                } else {
                    arrayList = new ArrayList();
                    for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                        arrayList.add(optJSONArray.optString(i11));
                    }
                }
                if (!TextUtils.isEmpty(optString) && arrayList != null && !arrayList.isEmpty()) {
                    return new HostPathConfig(optString, arrayList);
                }
            }
            return null;
        }

        public boolean canEqual(Object obj) {
            return obj instanceof HostPathConfig;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof HostPathConfig)) {
                return false;
            }
            HostPathConfig hostPathConfig = (HostPathConfig) obj;
            if (!hostPathConfig.canEqual(this)) {
                return false;
            }
            String host2 = getHost();
            String host3 = hostPathConfig.getHost();
            if (host2 != null ? !host2.equals(host3) : host3 != null) {
                return false;
            }
            List<String> paths2 = getPaths();
            List<String> paths3 = hostPathConfig.getPaths();
            return paths2 != null ? paths2.equals(paths3) : paths3 == null;
        }

        public void fromJson(JSONObject jSONObject) {
            if (jSONObject != null) {
                this.host = jSONObject.optString(VulcanInfo.HOST);
                JSONArray optJSONArray = jSONObject.optJSONArray("paths");
                if (optJSONArray != null && optJSONArray.length() > 0) {
                    this.paths = new ArrayList();
                    for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                        this.paths.add(optJSONArray.optString(i11));
                    }
                }
            }
        }

        public String getHost() {
            return this.host;
        }

        public List<String> getPaths() {
            return this.paths;
        }

        public int hashCode() {
            String host2 = getHost();
            int i11 = 43;
            int hashCode = host2 == null ? 43 : host2.hashCode();
            List<String> paths2 = getPaths();
            int i12 = (hashCode + 59) * 59;
            if (paths2 != null) {
                i11 = paths2.hashCode();
            }
            return i12 + i11;
        }

        public void setHost(String str) {
            this.host = str;
        }

        public void setPaths(List<String> list) {
            this.paths = list;
        }

        public JSONObject toJson() {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(VulcanInfo.HOST, this.host);
                JSONArray jSONArray = new JSONArray();
                List<String> list = this.paths;
                if (list != null && !list.isEmpty()) {
                    for (String put : this.paths) {
                        jSONArray.put(put);
                    }
                }
                jSONObject.put("paths", jSONArray);
            } catch (JSONException e11) {
                e11.printStackTrace();
            }
            return jSONObject;
        }

        public String toString() {
            return "HttpDnsConfig.HostPathConfig(host=" + getHost() + ", paths=" + getPaths() + ")";
        }

        public HostPathConfig(String str, List<String> list) {
            this.host = str;
            this.paths = list;
        }
    }

    public HttpDnsConfig() {
    }

    public boolean canEqual(Object obj) {
        return obj instanceof HttpDnsConfig;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof HttpDnsConfig)) {
            return false;
        }
        HttpDnsConfig httpDnsConfig = (HttpDnsConfig) obj;
        if (!httpDnsConfig.canEqual(this) || isEnable() != httpDnsConfig.isEnable()) {
            return false;
        }
        String accountID2 = getAccountID();
        String accountID3 = httpDnsConfig.getAccountID();
        if (accountID2 != null ? !accountID2.equals(accountID3) : accountID3 != null) {
            return false;
        }
        Map<String, HostPathConfig> whiteList2 = getWhiteList();
        Map<String, HostPathConfig> whiteList3 = httpDnsConfig.getWhiteList();
        if (whiteList2 != null ? !whiteList2.equals(whiteList3) : whiteList3 != null) {
            return false;
        }
        String region2 = getRegion();
        String region3 = httpDnsConfig.getRegion();
        return region2 != null ? region2.equals(region3) : region3 == null;
    }

    public void fromJson(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.enable = jSONObject.optBoolean("enable");
            this.accountID = jSONObject.optString("accountID");
            this.region = jSONObject.optString(TtmlNode.TAG_REGION);
            JSONArray optJSONArray = jSONObject.optJSONArray("whiteList");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                this.whiteList = new HashMap();
                for (int i11 = 0; i11 < optJSONArray.length(); i11++) {
                    HostPathConfig formatJson = HostPathConfig.formatJson(optJSONArray.optJSONObject(i11));
                    if (formatJson != null) {
                        this.whiteList.put(formatJson.host, formatJson);
                    }
                }
            }
        }
    }

    public String getAccountID() {
        return this.accountID;
    }

    public ArrayList<String> getAllHostList() {
        Map<String, HostPathConfig> map = this.whiteList;
        if (map == null || map.isEmpty()) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (String add : this.whiteList.keySet()) {
            arrayList.add(add);
        }
        return arrayList;
    }

    public HostPathConfig getHostPathConfig(String str) {
        if (hasHostname(str)) {
            return this.whiteList.get(str);
        }
        return null;
    }

    public String getRegion() {
        return this.region;
    }

    public Map<String, HostPathConfig> getWhiteList() {
        return this.whiteList;
    }

    public boolean hasHostname(String str) {
        return !TextUtils.isEmpty(str) && hasWhiteList() && this.whiteList.containsKey(str);
    }

    public boolean hasWhiteList() {
        Map<String, HostPathConfig> map = this.whiteList;
        return map != null && !map.isEmpty();
    }

    public int hashCode() {
        int i11 = isEnable() ? 79 : 97;
        String accountID2 = getAccountID();
        int i12 = 43;
        int hashCode = ((i11 + 59) * 59) + (accountID2 == null ? 43 : accountID2.hashCode());
        Map<String, HostPathConfig> whiteList2 = getWhiteList();
        int hashCode2 = (hashCode * 59) + (whiteList2 == null ? 43 : whiteList2.hashCode());
        String region2 = getRegion();
        int i13 = hashCode2 * 59;
        if (region2 != null) {
            i12 = region2.hashCode();
        }
        return i13 + i12;
    }

    public boolean isAvailable() {
        return this.enable && !TextUtils.isEmpty(this.accountID);
    }

    public boolean isEnable() {
        return this.enable;
    }

    public boolean isSame(Object obj) {
        if (obj == null || !(obj instanceof HttpDnsConfig)) {
            return false;
        }
        HttpDnsConfig httpDnsConfig = (HttpDnsConfig) obj;
        if (httpDnsConfig.enable != this.enable || TextUtils.isEmpty(httpDnsConfig.accountID) || !this.accountID.equals(httpDnsConfig.accountID)) {
            return false;
        }
        return true;
    }

    public void removeConfig(String str) {
        if (hasHostname(str)) {
            this.whiteList.remove(str);
        }
    }

    public void setAccountID(String str) {
        this.accountID = str;
    }

    public void setEnable(boolean z11) {
        this.enable = z11;
    }

    public void setRegion(String str) {
        this.region = str;
    }

    public void setWhiteList(Map<String, HostPathConfig> map) {
        this.whiteList = map;
    }

    public JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("enable", this.enable);
            jSONObject.put("accountID", this.accountID);
            JSONArray jSONArray = new JSONArray();
            Map<String, HostPathConfig> map = this.whiteList;
            if (map != null && !map.isEmpty()) {
                for (Map.Entry<String, HostPathConfig> value : this.whiteList.entrySet()) {
                    jSONArray.put(((HostPathConfig) value.getValue()).toJson());
                }
            }
            jSONObject.put("whiteList", jSONArray);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        return jSONObject;
    }

    public String toString() {
        return "HttpDnsConfig(enable=" + isEnable() + ", accountID=" + getAccountID() + ", whiteList=" + getWhiteList() + ", region=" + getRegion() + ")";
    }

    public HttpDnsConfig(JSONObject jSONObject) {
        fromJson(jSONObject);
    }
}
