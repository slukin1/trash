package com.hbg.lib.network.otc.core.bean;

import java.io.Serializable;
import java.util.List;

public class OtcPaymentTemplateInfo implements Serializable {
    private List<OtcPaymentTemplateBean> modelFields;
    private String specialReminder;

    public boolean canEqual(Object obj) {
        return obj instanceof OtcPaymentTemplateInfo;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof OtcPaymentTemplateInfo)) {
            return false;
        }
        OtcPaymentTemplateInfo otcPaymentTemplateInfo = (OtcPaymentTemplateInfo) obj;
        if (!otcPaymentTemplateInfo.canEqual(this)) {
            return false;
        }
        List<OtcPaymentTemplateBean> modelFields2 = getModelFields();
        List<OtcPaymentTemplateBean> modelFields3 = otcPaymentTemplateInfo.getModelFields();
        if (modelFields2 != null ? !modelFields2.equals(modelFields3) : modelFields3 != null) {
            return false;
        }
        String specialReminder2 = getSpecialReminder();
        String specialReminder3 = otcPaymentTemplateInfo.getSpecialReminder();
        return specialReminder2 != null ? specialReminder2.equals(specialReminder3) : specialReminder3 == null;
    }

    public List<OtcPaymentTemplateBean> getModelFields() {
        return this.modelFields;
    }

    public String getSpecialReminder() {
        return this.specialReminder;
    }

    public int hashCode() {
        List<OtcPaymentTemplateBean> modelFields2 = getModelFields();
        int i11 = 43;
        int hashCode = modelFields2 == null ? 43 : modelFields2.hashCode();
        String specialReminder2 = getSpecialReminder();
        int i12 = (hashCode + 59) * 59;
        if (specialReminder2 != null) {
            i11 = specialReminder2.hashCode();
        }
        return i12 + i11;
    }

    public void setModelFields(List<OtcPaymentTemplateBean> list) {
        this.modelFields = list;
    }

    public void setSpecialReminder(String str) {
        this.specialReminder = str;
    }

    public String toString() {
        return "OtcPaymentTemplateInfo(modelFields=" + getModelFields() + ", specialReminder=" + getSpecialReminder() + ")";
    }
}
