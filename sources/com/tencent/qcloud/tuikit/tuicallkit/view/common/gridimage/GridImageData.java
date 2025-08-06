package com.tencent.qcloud.tuikit.tuicallkit.view.common.gridimage;

import android.graphics.Bitmap;
import android.graphics.Color;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GridImageData implements Cloneable {
    private static final int MAX_SIZE = 9;
    public int bgColor = Color.parseColor("#cfd3d8");
    public Map<Integer, Bitmap> bitmapMap;
    public int columnCount;
    public int defaultImageResId;
    public int gap = 6;
    public List<Object> imageUrlList;
    public int maxHeight;
    public int maxWidth;
    public int rowCount;
    public int targetImageSize;

    public GridImageData() {
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

    public List<Object> getImageUrlList() {
        return this.imageUrlList;
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

    public void setImageUrlList(List<Object> list) {
        this.imageUrlList = list;
    }

    public int size() {
        List<Object> list = this.imageUrlList;
        if (list != null) {
            return Math.min(list.size(), 9);
        }
        return 0;
    }

    public GridImageData clone() throws CloneNotSupportedException {
        GridImageData gridImageData = (GridImageData) super.clone();
        if (this.imageUrlList != null) {
            ArrayList arrayList = new ArrayList(this.imageUrlList.size());
            gridImageData.imageUrlList = arrayList;
            arrayList.addAll(this.imageUrlList);
        }
        if (this.bitmapMap != null) {
            HashMap hashMap = new HashMap();
            gridImageData.bitmapMap = hashMap;
            hashMap.putAll(this.bitmapMap);
        }
        return gridImageData;
    }

    public GridImageData(List<Object> list, int i11) {
        this.imageUrlList = list;
        this.defaultImageResId = i11;
    }
}
