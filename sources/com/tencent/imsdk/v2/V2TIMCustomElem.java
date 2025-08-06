package com.tencent.imsdk.v2;

import com.tencent.imsdk.message.CustomElement;

public class V2TIMCustomElem extends V2TIMElem {
    private byte[] data;
    private String description;
    private byte[] extension;

    public byte[] getData() {
        if (getElement() == null) {
            return this.data;
        }
        return ((CustomElement) getElement()).getData();
    }

    public String getDescription() {
        if (getElement() == null) {
            return this.description;
        }
        return ((CustomElement) getElement()).getDescription();
    }

    public byte[] getExtension() {
        if (getElement() == null) {
            return this.extension;
        }
        return ((CustomElement) getElement()).getExtension();
    }

    public void setData(byte[] bArr) {
        if (getElement() == null) {
            this.data = bArr;
        } else {
            ((CustomElement) getElement()).setData(bArr);
        }
    }

    public void setDescription(String str) {
        if (getElement() == null) {
            this.description = str;
        } else {
            ((CustomElement) getElement()).setDescription(str);
        }
    }

    public void setExtension(byte[] bArr) {
        if (getElement() == null) {
            this.extension = bArr;
        } else {
            ((CustomElement) getElement()).setExtension(bArr);
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        byte[] data2 = getData();
        String str = "";
        String str2 = data2 != null ? new String(data2) : str;
        String description2 = getDescription() != null ? getDescription() : str;
        if (getExtension() != null) {
            str = new String(getExtension());
        }
        sb2.append("V2TIMCustomElem--->");
        sb2.append("data2String:");
        sb2.append(str2);
        sb2.append(", description:");
        sb2.append(description2);
        sb2.append(", extension2String:");
        sb2.append(str);
        return sb2.toString();
    }
}
