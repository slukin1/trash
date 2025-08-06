package com.huawei.hms.common.data;

import android.database.CharArrayBuffer;
import android.net.Uri;
import com.huawei.hms.common.internal.Objects;
import com.huawei.hms.common.internal.Preconditions;

public class DataBufferRef {

    /* renamed from: a  reason: collision with root package name */
    private int f37886a;
    public final DataHolder mDataHolder;
    public int mDataRow;

    public DataBufferRef(DataHolder dataHolder, int i11) {
        Preconditions.checkNotNull(dataHolder, "dataHolder cannot be null");
        this.mDataHolder = dataHolder;
        getWindowIndex(i11);
    }

    public void copyToBuffer(String str, CharArrayBuffer charArrayBuffer) {
        this.mDataHolder.copyToBuffer(str, this.mDataRow, this.f37886a, charArrayBuffer);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof DataBufferRef)) {
            return false;
        }
        DataBufferRef dataBufferRef = (DataBufferRef) obj;
        if (dataBufferRef.mDataRow == this.mDataRow && dataBufferRef.f37886a == this.f37886a && dataBufferRef.mDataHolder == this.mDataHolder) {
            return true;
        }
        return false;
    }

    public boolean getBoolean(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f37886a, DataHolder.TYPE_BOOLEAN);
        if (value != null) {
            return ((Boolean) value).booleanValue();
        }
        return false;
    }

    public byte[] getByteArray(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f37886a, DataHolder.TYPE_BYTE_ARRAY);
        if (value != null) {
            return (byte[]) value;
        }
        return null;
    }

    public int getDataRow() {
        return this.mDataRow;
    }

    public double getDouble(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f37886a, DataHolder.TYPE_DOUBLE);
        if (value != null) {
            return ((Double) value).doubleValue();
        }
        return -1.0d;
    }

    public float getFloat(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f37886a, DataHolder.TYPE_FLOAT);
        if (value != null) {
            return ((Float) value).floatValue();
        }
        return -1.0f;
    }

    public int getInteger(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f37886a, DataHolder.TYPE_INT);
        if (value != null) {
            return ((Integer) value).intValue();
        }
        return -1;
    }

    public long getLong(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f37886a, DataHolder.TYPE_LONG);
        if (value != null) {
            return ((Long) value).longValue();
        }
        return -1;
    }

    public String getString(String str) {
        Object value = this.mDataHolder.getValue(str, this.mDataRow, this.f37886a, DataHolder.TYPE_STRING);
        return value != null ? (String) value : "";
    }

    public final void getWindowIndex(int i11) {
        Preconditions.checkArgument(i11 >= 0 && i11 < this.mDataHolder.getCount(), "rowNum is out of index");
        this.mDataRow = i11;
        this.f37886a = this.mDataHolder.getWindowIndex(i11);
    }

    public boolean hasColumn(String str) {
        return this.mDataHolder.hasColumn(str);
    }

    public boolean hasNull(String str) {
        return this.mDataHolder.hasNull(str, this.mDataRow, this.f37886a);
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(this.mDataRow), Integer.valueOf(this.f37886a), this.mDataHolder);
    }

    public boolean isDataValid() {
        return !this.mDataHolder.isClosed();
    }

    public Uri parseUri(String str) {
        String str2 = (String) this.mDataHolder.getValue(str, this.mDataRow, this.f37886a, DataHolder.TYPE_STRING);
        if (str2 == null) {
            return null;
        }
        return Uri.parse(str2);
    }
}
