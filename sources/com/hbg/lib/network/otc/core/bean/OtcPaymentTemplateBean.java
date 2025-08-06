package com.hbg.lib.network.otc.core.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Objects;

public class OtcPaymentTemplateBean implements Serializable, Parcelable {
    public static final Parcelable.Creator<OtcPaymentTemplateBean> CREATOR = new a();
    private boolean copyable;
    private String fieldId;
    private String fieldType;
    private int index;
    private int maxLength;
    private String name;
    private String remindWord;
    private boolean required;
    private String value;
    private String valueType;

    public class a implements Parcelable.Creator<OtcPaymentTemplateBean> {
        /* renamed from: a */
        public OtcPaymentTemplateBean createFromParcel(Parcel parcel) {
            return new OtcPaymentTemplateBean(parcel);
        }

        /* renamed from: b */
        public OtcPaymentTemplateBean[] newArray(int i11) {
            return new OtcPaymentTemplateBean[i11];
        }
    }

    public OtcPaymentTemplateBean(Parcel parcel) {
        this.fieldId = parcel.readString();
        this.name = parcel.readString();
        this.fieldType = parcel.readString();
        this.index = parcel.readInt();
        this.maxLength = parcel.readInt();
        boolean z11 = true;
        this.required = parcel.readByte() != 0;
        this.copyable = parcel.readByte() == 0 ? false : z11;
        this.remindWord = parcel.readString();
        this.valueType = parcel.readString();
        this.value = parcel.readString();
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Objects.equals(this.fieldId, ((OtcPaymentTemplateBean) obj).fieldId);
    }

    public String getFieldId() {
        return this.fieldId;
    }

    public String getFieldType() {
        return this.fieldType;
    }

    public int getIndex() {
        return this.index;
    }

    public int getMaxLength() {
        return this.maxLength;
    }

    public String getName() {
        return this.name;
    }

    public String getRemindWord() {
        return this.remindWord;
    }

    public String getValue() {
        return this.value;
    }

    public String getValueType() {
        return this.valueType;
    }

    public int hashCode() {
        return Objects.hash(new Object[]{this.fieldId});
    }

    public boolean isCopyable() {
        return this.copyable;
    }

    public boolean isRequired() {
        return this.required;
    }

    public void setCopyable(boolean z11) {
        this.copyable = z11;
    }

    public void setFieldId(String str) {
        this.fieldId = str;
    }

    public void setFieldType(String str) {
        this.fieldType = str;
    }

    public void setIndex(int i11) {
        this.index = i11;
    }

    public void setMaxLength(int i11) {
        this.maxLength = i11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setRemindWord(String str) {
        this.remindWord = str;
    }

    public void setRequired(boolean z11) {
        this.required = z11;
    }

    public void setValue(String str) {
        this.value = str;
    }

    public void setValueType(String str) {
        this.valueType = str;
    }

    public String toString() {
        return "OtcPaymentTemplateBean(fieldId=" + getFieldId() + ", name=" + getName() + ", fieldType=" + getFieldType() + ", index=" + getIndex() + ", maxLength=" + getMaxLength() + ", required=" + isRequired() + ", copyable=" + isCopyable() + ", remindWord=" + getRemindWord() + ", valueType=" + getValueType() + ", value=" + getValue() + ")";
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.fieldId);
        parcel.writeString(this.name);
        parcel.writeString(this.fieldType);
        parcel.writeInt(this.index);
        parcel.writeInt(this.maxLength);
        parcel.writeByte(this.required ? (byte) 1 : 0);
        parcel.writeByte(this.copyable ? (byte) 1 : 0);
        parcel.writeString(this.remindWord);
        parcel.writeString(this.valueType);
        parcel.writeString(this.value);
    }
}
