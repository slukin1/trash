package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class MktRulePageBean implements Serializable {
    public String code;
    public List<Map<String, Object>> content;
    public int priority;
    public int rule;

    public boolean canEqual(Object obj) {
        return obj instanceof MktRulePageBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MktRulePageBean)) {
            return false;
        }
        MktRulePageBean mktRulePageBean = (MktRulePageBean) obj;
        if (!mktRulePageBean.canEqual(this)) {
            return false;
        }
        String code2 = getCode();
        String code3 = mktRulePageBean.getCode();
        if (code2 != null ? !code2.equals(code3) : code3 != null) {
            return false;
        }
        if (getPriority() != mktRulePageBean.getPriority() || getRule() != mktRulePageBean.getRule()) {
            return false;
        }
        List<Map<String, Object>> content2 = getContent();
        List<Map<String, Object>> content3 = mktRulePageBean.getContent();
        return content2 != null ? content2.equals(content3) : content3 == null;
    }

    public String getCode() {
        return this.code;
    }

    public List<Map<String, Object>> getContent() {
        return this.content;
    }

    public int getPriority() {
        return this.priority;
    }

    public int getRule() {
        return this.rule;
    }

    public int hashCode() {
        String code2 = getCode();
        int i11 = 43;
        int hashCode = (((((code2 == null ? 43 : code2.hashCode()) + 59) * 59) + getPriority()) * 59) + getRule();
        List<Map<String, Object>> content2 = getContent();
        int i12 = hashCode * 59;
        if (content2 != null) {
            i11 = content2.hashCode();
        }
        return i12 + i11;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void setContent(List<Map<String, Object>> list) {
        this.content = list;
    }

    public void setPriority(int i11) {
        this.priority = i11;
    }

    public void setRule(int i11) {
        this.rule = i11;
    }

    public String toString() {
        return "MktRulePageBean(code=" + getCode() + ", priority=" + getPriority() + ", rule=" + getRule() + ", content=" + getContent() + ")";
    }
}
