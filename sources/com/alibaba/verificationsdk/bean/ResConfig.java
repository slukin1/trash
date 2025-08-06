package com.alibaba.verificationsdk.bean;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import android.widget.ImageView;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class ResConfig {
    public Context context;
    public Map<String, String> images;
    public String resRootPath = null;
    public Map<String, String> texts;

    public ResConfig(Context context2, String str) {
        this.context = context2;
        this.resRootPath = str;
        this.images = new HashMap();
        this.texts = new HashMap();
    }

    public void addImage(String str, String str2) {
        this.images.put(str, str2);
    }

    public void addString(String str, String str2) {
        this.texts.put(str, str2);
    }

    public void fromJson(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            JSONObject jSONObject2 = jSONObject.getJSONObject("image");
            if (jSONObject2 != null) {
                Iterator<String> keys = jSONObject2.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    addImage(next, jSONObject2.getString(next));
                }
            }
            JSONObject jSONObject3 = jSONObject.getJSONObject("text");
            if (jSONObject3 != null) {
                Iterator<String> keys2 = jSONObject3.keys();
                while (keys2.hasNext()) {
                    String next2 = keys2.next();
                    addString(next2, jSONObject3.getString(next2));
                }
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    public Bitmap getBitmap(String str) {
        String image = getImage(str);
        if (TextUtils.isEmpty(image)) {
            return null;
        }
        String str2 = this.resRootPath + File.separator + image;
        File file = new File(str2);
        if (!file.isFile() || !file.exists()) {
            return null;
        }
        return BitmapFactory.decodeFile(str2);
    }

    public String getImage(String str) {
        return this.images.get(str);
    }

    public String getString(String str) {
        return this.texts.get(str);
    }

    public void setImageDrawable(ImageView imageView, String str, int i11) {
        if (getBitmap(str) != null) {
            imageView.setImageBitmap(getBitmap(str));
        } else {
            imageView.setImageDrawable(this.context.getResources().getDrawable(i11));
        }
    }

    public String getString(String str, int i11) {
        if (!TextUtils.isEmpty(getString(str))) {
            return getString(str);
        }
        return this.context.getResources().getString(i11);
    }

    public Bitmap getBitmap(String str, int i11) {
        return getBitmap(str) != null ? getBitmap(str) : BitmapFactory.decodeResource(this.context.getResources(), i11);
    }
}
