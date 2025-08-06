package com.yalantis.ucrop.model;

public class ExifInfo {
    private int mExifDegrees;
    private int mExifOrientation;
    private int mExifTranslation;

    public ExifInfo(int i11, int i12, int i13) {
        this.mExifOrientation = i11;
        this.mExifDegrees = i12;
        this.mExifTranslation = i13;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        ExifInfo exifInfo = (ExifInfo) obj;
        if (this.mExifOrientation != exifInfo.mExifOrientation || this.mExifDegrees != exifInfo.mExifDegrees) {
            return false;
        }
        if (this.mExifTranslation == exifInfo.mExifTranslation) {
            return true;
        }
        return false;
    }

    public int getExifDegrees() {
        return this.mExifDegrees;
    }

    public int getExifOrientation() {
        return this.mExifOrientation;
    }

    public int getExifTranslation() {
        return this.mExifTranslation;
    }

    public int hashCode() {
        return (((this.mExifOrientation * 31) + this.mExifDegrees) * 31) + this.mExifTranslation;
    }

    public void setExifDegrees(int i11) {
        this.mExifDegrees = i11;
    }

    public void setExifOrientation(int i11) {
        this.mExifOrientation = i11;
    }

    public void setExifTranslation(int i11) {
        this.mExifTranslation = i11;
    }
}
