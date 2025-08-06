package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;

public class OtcPaymentParamBean implements Serializable {
    private String fieldId;
    private String fieldType;
    private String value;
    private String valueType;

    public OtcPaymentParamBean(String str, String str2, String str3, String str4) {
        this.fieldId = str;
        this.fieldType = str2;
        this.valueType = str3;
        this.value = str4;
    }

    public boolean canEqual(Object obj) {
        return obj instanceof OtcPaymentParamBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcPaymentParamBean)) {
            return false;
        }
        OtcPaymentParamBean otcPaymentParamBean = (OtcPaymentParamBean) obj;
        if (!otcPaymentParamBean.canEqual(this)) {
            return false;
        }
        String fieldId2 = getFieldId();
        String fieldId3 = otcPaymentParamBean.getFieldId();
        if (fieldId2 != null ? !fieldId2.equals(fieldId3) : fieldId3 != null) {
            return false;
        }
        String fieldType2 = getFieldType();
        String fieldType3 = otcPaymentParamBean.getFieldType();
        if (fieldType2 != null ? !fieldType2.equals(fieldType3) : fieldType3 != null) {
            return false;
        }
        String valueType2 = getValueType();
        String valueType3 = otcPaymentParamBean.getValueType();
        if (valueType2 != null ? !valueType2.equals(valueType3) : valueType3 != null) {
            return false;
        }
        String value2 = getValue();
        String value3 = otcPaymentParamBean.getValue();
        return value2 != null ? value2.equals(value3) : value3 == null;
    }

    public String getFieldId() {
        return this.fieldId;
    }

    public String getFieldType() {
        return this.fieldType;
    }

    public String getValue() {
        return this.value;
    }

    public String getValueType() {
        return this.valueType;
    }

    public int hashCode() {
        String fieldId2 = getFieldId();
        int i11 = 43;
        int hashCode = fieldId2 == null ? 43 : fieldId2.hashCode();
        String fieldType2 = getFieldType();
        int hashCode2 = ((hashCode + 59) * 59) + (fieldType2 == null ? 43 : fieldType2.hashCode());
        String valueType2 = getValueType();
        int hashCode3 = (hashCode2 * 59) + (valueType2 == null ? 43 : valueType2.hashCode());
        String value2 = getValue();
        int i12 = hashCode3 * 59;
        if (value2 != null) {
            i11 = value2.hashCode();
        }
        return i12 + i11;
    }

    public void setFieldId(String str) {
        this.fieldId = str;
    }

    public void setFieldType(String str) {
        this.fieldType = str;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public void setValueType(String str) {
        this.valueType = str;
    }

    public String toString() {
        return "OtcPaymentParamBean(fieldId=" + getFieldId() + ", fieldType=" + getFieldType() + ", valueType=" + getValueType() + ", value=" + getValue() + ")";
    }
}
