package com.tencent.imsdk.message;

import android.text.TextUtils;
import java.io.UnsupportedEncodingException;

public class TextElement extends MessageBaseElement {
    private byte[] textContentBytes;

    public TextElement() {
        setElementType(1);
    }

    public String getTextContent() {
        byte[] bArr = this.textContentBytes;
        if (bArr != null && bArr.length > 0) {
            try {
                return new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
        return "";
    }

    public void setTextContent(String str) {
        if (!TextUtils.isEmpty(str)) {
            try {
                this.textContentBytes = str.getBytes("UTF-8");
            } catch (UnsupportedEncodingException e11) {
                e11.printStackTrace();
            }
        }
    }
}
