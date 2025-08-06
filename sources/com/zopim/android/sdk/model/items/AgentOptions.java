package com.zopim.android.sdk.model.items;

import com.zopim.android.sdk.model.items.RowItem;
import java.util.Arrays;

public class AgentOptions extends AgentItem<AgentOptions> implements Disableable {
    private boolean disabled;
    private String message;
    private String[] options = new String[0];

    public AgentOptions() {
        super.setType(RowItem.Type.AGENT_OPTIONS);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AgentOptions) || !super.equals(obj)) {
            return false;
        }
        AgentOptions agentOptions = (AgentOptions) obj;
        if (this.disabled != agentOptions.disabled || !Arrays.equals(this.options, agentOptions.options)) {
            return false;
        }
        String str = this.message;
        String str2 = agentOptions.message;
        if (str != null) {
            return str.equals(str2);
        }
        if (str2 == null) {
            return true;
        }
        return false;
    }

    public String getMessage() {
        String str = this.message;
        return str != null ? str : "";
    }

    public String[] getOptions() {
        String[] strArr = this.options;
        return strArr != null ? strArr : new String[0];
    }

    public int hashCode() {
        int hashCode = ((super.hashCode() * 31) + Arrays.hashCode(this.options)) * 31;
        String str = this.message;
        return ((hashCode + (str != null ? str.hashCode() : 0)) * 31) + (this.disabled ? 1 : 0);
    }

    public boolean isDisabled() {
        return this.disabled;
    }

    public void setDisabled(boolean z11) {
        this.disabled = z11;
    }

    public void setMessage(String str) {
        this.message = str;
    }

    public void setOptions(String[] strArr) {
        this.options = strArr;
    }

    public String toString() {
        return "options:" + this.options + super.toString();
    }

    public void update(AgentOptions agentOptions) {
        super.update(agentOptions);
        this.options = agentOptions.options;
        this.message = agentOptions.message;
        this.disabled = agentOptions.disabled;
    }
}
