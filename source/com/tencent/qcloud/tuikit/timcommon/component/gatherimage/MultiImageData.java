package com.tencent.qcloud.tuikit.timcommon.component.gatherimage;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MultiImageData implements Cloneable {
    public static final int maxSize = 9;
    public int bgColor = Color.parseColor("#cfd3d8");
    public Map<Integer, Bitmap> bitmapMap;
    public int columnCount;
    public int defaultImageResId;
    public int gap = 6;
    public List<Object> imageUrls;
    public int maxHeight;
    public int maxWidth;
    public int rowCount;
    public int targetImageSize;

    public MultiImageData() {
    }

    public Bitmap getBitmap(int i11) {
        Bitmap bitmap;
        Map<Integer, Bitmap> map = this.bitmapMap;
        if (map == null) {
            return null;
        }
        synchronized (map) {
            bitmap = this.bitmapMap.get(Integer.valueOf(i11));
        }
        return bitmap;
    }

    public int getDefaultImageResId() {
        return this.defaultImageResId;
    }

    public List<Object> getImageUrls() {
        return this.imageUrls;
    }

    public void putBitmap(Bitmap bitmap, int i11) {
        Map<Integer, Bitmap> map = this.bitmapMap;
        if (map != null) {
            synchronized (map) {
                this.bitmapMap.put(Integer.valueOf(i11), bitmap);
            }
            return;
        }
        HashMap hashMap = new HashMap();
        this.bitmapMap = hashMap;
        synchronized (hashMap) {
            this.bitmapMap.put(Integer.valueOf(i11), bitmap);
        }
    }

    public void setDefaultImageResId(int i11) {
        this.defaultImageResId = i11;
    }

    public void setImageUrls(List<Object> list) {
        this.imageUrls = list;
    }

    public int size() {
        List<Object> list = this.imageUrls;
        if (list == null) {
            return 0;
        }
        if (list.size() > 9) {
            return 9;
        }
        return this.imageUrls.size();
    }

    public MultiImageData clone() throws CloneNotSupportedException {
        MultiImageData multiImageData = (MultiImageData) super.clone();
        if (this.imageUrls != null) {
            ArrayList arrayList = new ArrayList(this.imageUrls.size());
            multiImageData.imageUrls = arrayList;
            arrayList.addAll(this.imageUrls);
        }
        if (this.bitmapMap != null) {
            HashMap hashMap = new HashMap();
            multiImageData.bitmapMap = hashMap;
            hashMap.putAll(this.bitmapMap);
        }
        return multiImageData;
    }

    public MultiImageData(int i11) {
        this.defaultImageResId = i11;
    }

    public MultiImageData(List<Object> list, int i11) {
        this.imageUrls = list;
        this.defaultImageResId = i11;
    }
}
