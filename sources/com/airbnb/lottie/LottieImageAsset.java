package com.airbnb.lottie;

import android.graphics.Bitmap;

public class LottieImageAsset {
    private Bitmap bitmap;
    private final String dirName;
    private final String fileName;
    private final int height;

    /* renamed from: id  reason: collision with root package name */
    private final String f13981id;
    private final int width;

    public LottieImageAsset(int i11, int i12, String str, String str2, String str3) {
        this.width = i11;
        this.height = i12;
        this.f13981id = str;
        this.fileName = str2;
        this.dirName = str3;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public String getDirName() {
        return this.dirName;
    }

    public String getFileName() {
        return this.fileName;
    }

    public int getHeight() {
        return this.height;
    }

    public String getId() {
        return this.f13981id;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean hasBitmap() {
        return this.bitmap != null || (this.fileName.startsWith("data:") && this.fileName.indexOf("base64,") > 0);
    }

    public void setBitmap(Bitmap bitmap2) {
        this.bitmap = bitmap2;
    }
}
