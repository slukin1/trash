package com.huobi.view.chart.data;

import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.ParcelFormatException;
import android.os.Parcelable;
import com.huobi.view.chart.utils.Utils;

public class Entry extends BaseEntry implements Parcelable {
    public static final Parcelable.Creator<Entry> CREATOR = new Parcelable.Creator<Entry>() {
        public Entry createFromParcel(Parcel parcel) {
            return new Entry(parcel);
        }

        public Entry[] newArray(int i11) {
            return new Entry[i11];
        }
    };

    /* renamed from: x  reason: collision with root package name */
    private float f19009x = 0.0f;

    public Entry() {
    }

    public Entry copy() {
        return new Entry(this.f19009x, getY(), getData());
    }

    public int describeContents() {
        return 0;
    }

    public boolean equalTo(Entry entry) {
        if (entry == null || entry.getData() != getData()) {
            return false;
        }
        float abs = Math.abs(entry.f19009x - this.f19009x);
        float f11 = Utils.FLOAT_EPSILON;
        if (abs <= f11 && Math.abs(entry.getY() - getY()) <= f11) {
            return true;
        }
        return false;
    }

    public float getX() {
        return this.f19009x;
    }

    public void setX(float f11) {
        this.f19009x = f11;
    }

    public String toString() {
        return "Entry, x: " + this.f19009x + " y: " + getY();
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeFloat(this.f19009x);
        parcel.writeFloat(getY());
        if (getData() == null) {
            parcel.writeInt(0);
        } else if (getData() instanceof Parcelable) {
            parcel.writeInt(1);
            parcel.writeParcelable((Parcelable) getData(), i11);
        } else {
            throw new ParcelFormatException("Cannot parcel an Entry with non-parcelable data");
        }
    }

    public Entry(float f11, float f12) {
        super(f12);
        this.f19009x = f11;
    }

    public Entry(float f11, float f12, Object obj) {
        super(f12, obj);
        this.f19009x = f11;
    }

    public Entry(float f11, float f12, Drawable drawable) {
        super(f12, drawable);
        this.f19009x = f11;
    }

    public Entry(float f11, float f12, Drawable drawable, Object obj) {
        super(f12, drawable, obj);
        this.f19009x = f11;
    }

    public Entry(Parcel parcel) {
        this.f19009x = parcel.readFloat();
        setY(parcel.readFloat());
        if (parcel.readInt() == 1) {
            setData(parcel.readParcelable(Object.class.getClassLoader()));
        }
    }
}
