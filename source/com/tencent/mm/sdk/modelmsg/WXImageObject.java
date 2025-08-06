package com.tencent.mm.sdk.modelmsg;

import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.sdk.b.a;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import java.io.ByteArrayOutputStream;
import java.io.File;

public class WXImageObject implements WXMediaMessage.IMediaObject {
    private static final int CONTENT_LENGTH_LIMIT = 10485760;
    private static final int PATH_LENGTH_LIMIT = 10240;
    private static final String TAG = "MicroMsg.SDK.WXImageObject";
    private static final int URL_LENGTH_LIMIT = 10240;
    public byte[] imageData;
    public String imagePath;
    public String imageUrl;

    public WXImageObject() {
    }

    public WXImageObject(Bitmap bitmap) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            bitmap.compress(Bitmap.CompressFormat.JPEG, 85, byteArrayOutputStream);
            this.imageData = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public WXImageObject(byte[] bArr) {
        this.imageData = bArr;
    }

    private int getFileSize(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        File file = new File(str);
        if (!file.exists()) {
            return 0;
        }
        return (int) file.length();
    }

    public boolean checkArgs() {
        String str;
        String str2;
        String str3;
        byte[] bArr = this.imageData;
        if ((bArr == null || bArr.length == 0) && (((str2 = this.imagePath) == null || str2.length() == 0) && ((str3 = this.imageUrl) == null || str3.length() == 0))) {
            str = "checkArgs fail, all arguments are null";
        } else {
            byte[] bArr2 = this.imageData;
            if (bArr2 == null || bArr2.length <= CONTENT_LENGTH_LIMIT) {
                String str4 = this.imagePath;
                if (str4 == null || str4.length() <= 10240) {
                    String str5 = this.imagePath;
                    if (str5 == null || getFileSize(str5) <= CONTENT_LENGTH_LIMIT) {
                        String str6 = this.imageUrl;
                        if (str6 == null || str6.length() <= 10240) {
                            return true;
                        }
                        str = "checkArgs fail, url is invalid";
                    } else {
                        str = "checkArgs fail, image content is too large";
                    }
                } else {
                    str = "checkArgs fail, path is invalid";
                }
            } else {
                str = "checkArgs fail, content is too large";
            }
        }
        a.a(TAG, str);
        return false;
    }

    public void serialize(Bundle bundle) {
        bundle.putByteArray("_wximageobject_imageData", this.imageData);
        bundle.putString("_wximageobject_imagePath", this.imagePath);
        bundle.putString("_wximageobject_imageUrl", this.imageUrl);
    }

    public void setImagePath(String str) {
        this.imagePath = str;
    }

    public int type() {
        return 2;
    }

    public void unserialize(Bundle bundle) {
        this.imageData = bundle.getByteArray("_wximageobject_imageData");
        this.imagePath = bundle.getString("_wximageobject_imagePath");
        this.imageUrl = bundle.getString("_wximageobject_imageUrl");
    }
}
