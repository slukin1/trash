package com.adjust.sdk;

import com.iproov.sdk.bridge.OptionsBridge;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamField;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class AdjustAttribution implements Serializable {
    private static final ObjectStreamField[] serialPersistentFields;
    private static final long serialVersionUID = 1;
    public String adgroup;
    public String campaign;
    public String clickLabel;
    public Double costAmount;
    public String costCurrency;
    public String costType;
    public String creative;
    public String fbInstallReferrer;
    public String network;
    public String trackerName;
    public String trackerToken;

    static {
        Class<String> cls = String.class;
        serialPersistentFields = new ObjectStreamField[]{new ObjectStreamField("trackerToken", cls), new ObjectStreamField("trackerName", cls), new ObjectStreamField(OptionsBridge.NETWORK_KEY, cls), new ObjectStreamField("campaign", cls), new ObjectStreamField("adgroup", cls), new ObjectStreamField("creative", cls), new ObjectStreamField("clickLabel", cls), new ObjectStreamField("costType", cls), new ObjectStreamField("costAmount", Double.class), new ObjectStreamField("costCurrency", cls), new ObjectStreamField("fbInstallReferrer", cls)};
    }

    private void readObject(ObjectInputStream objectInputStream) {
        objectInputStream.defaultReadObject();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) {
        objectOutputStream.defaultWriteObject();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        AdjustAttribution adjustAttribution = (AdjustAttribution) obj;
        return Util.equalString(this.trackerToken, adjustAttribution.trackerToken) && Util.equalString(this.trackerName, adjustAttribution.trackerName) && Util.equalString(this.network, adjustAttribution.network) && Util.equalString(this.campaign, adjustAttribution.campaign) && Util.equalString(this.adgroup, adjustAttribution.adgroup) && Util.equalString(this.creative, adjustAttribution.creative) && Util.equalString(this.clickLabel, adjustAttribution.clickLabel) && Util.equalString(this.costType, adjustAttribution.costType) && Util.equalsDouble(this.costAmount, adjustAttribution.costAmount) && Util.equalString(this.costCurrency, adjustAttribution.costCurrency) && Util.equalString(this.fbInstallReferrer, adjustAttribution.fbInstallReferrer);
    }

    public int hashCode() {
        return Util.hashString(this.fbInstallReferrer, Util.hashString(this.costCurrency, Util.hashDouble(this.costAmount, Util.hashString(this.costType, Util.hashString(this.clickLabel, Util.hashString(this.creative, Util.hashString(this.adgroup, Util.hashString(this.campaign, Util.hashString(this.network, Util.hashString(this.trackerName, Util.hashString(this.trackerToken, 17)))))))))));
    }

    public Map<String, String> toMap() {
        HashMap hashMap = new HashMap();
        String str = this.trackerToken;
        if (str != null) {
            hashMap.put("trackerToken", str);
        }
        String str2 = this.trackerName;
        if (str2 != null) {
            hashMap.put("trackerName", str2);
        }
        String str3 = this.network;
        if (str3 != null) {
            hashMap.put(OptionsBridge.NETWORK_KEY, str3);
        }
        String str4 = this.campaign;
        if (str4 != null) {
            hashMap.put("campaign", str4);
        }
        String str5 = this.adgroup;
        if (str5 != null) {
            hashMap.put("adgroup", str5);
        }
        String str6 = this.creative;
        if (str6 != null) {
            hashMap.put("creative", str6);
        }
        String str7 = this.clickLabel;
        if (str7 != null) {
            hashMap.put("clickLabel", str7);
        }
        String str8 = this.costType;
        if (str8 != null) {
            hashMap.put("costType", str8);
        }
        Double d11 = this.costAmount;
        if (d11 != null) {
            hashMap.put("costAmount", d11.toString());
        }
        String str9 = this.costCurrency;
        if (str9 != null) {
            hashMap.put("costCurrency", str9);
        }
        String str10 = this.fbInstallReferrer;
        if (str10 != null) {
            hashMap.put("fbInstallReferrer", str10);
        }
        return hashMap;
    }

    public String toString() {
        return Util.formatString("tt:%s tn:%s net:%s cam:%s adg:%s cre:%s cl:%s ct:%s ca:%.2f cc:%s fir:%s", this.trackerToken, this.trackerName, this.network, this.campaign, this.adgroup, this.creative, this.clickLabel, this.costType, this.costAmount, this.costCurrency, this.fbInstallReferrer);
    }
}
