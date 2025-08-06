package com.tencent.imsdk.group;

import java.io.Serializable;

public class GroupInfoChangeItem implements Serializable {
    private boolean boolValueChanged;
    private String customInfoKey;
    private int groupInfoChangeType;
    private int intValueChanged;
    private String valueChanged;

    public boolean getBoolValueChanged() {
        return this.boolValueChanged;
    }

    public String getCustomInfoKey() {
        return this.customInfoKey;
    }

    public int getGroupInfoChangeType() {
        return this.groupInfoChangeType;
    }

    public int getIntValueChanged() {
        return this.intValueChanged;
    }

    public String getValueChanged() {
        return this.valueChanged;
    }

    public void setCustomInfoKey(String str) {
        this.customInfoKey = str;
    }

    public void setGroupInfoChangeType(int i11) {
        this.groupInfoChangeType = i11;
    }

    public void setValueChanged(String str) {
        this.valueChanged = str;
    }
}
