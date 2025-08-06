package com.google.android.gms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.CursorIndexOutOfBoundsException;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.internal.Asserts;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@KeepName
@KeepForSdk
@SafeParcelable.Class(creator = "DataHolderCreator", validate = true)
public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    @KeepForSdk
    public static final Parcelable.Creator<DataHolder> CREATOR = new zaf();
    private static final Builder zaf = new zab(new String[0], (String) null);
    @SafeParcelable.VersionField(id = 1000)
    public final int zaa;
    public Bundle zab;
    public int[] zac;
    public int zad;
    public boolean zae;
    @SafeParcelable.Field(getter = "getColumns", id = 1)
    private final String[] zag;
    @SafeParcelable.Field(getter = "getWindows", id = 2)
    private final CursorWindow[] zah;
    @SafeParcelable.Field(getter = "getStatusCode", id = 3)
    private final int zai;
    @SafeParcelable.Field(getter = "getMetadata", id = 4)
    private final Bundle zaj;
    private boolean zak;

    @KeepForSdk
    public static class Builder {
        /* access modifiers changed from: private */
        public final String[] zaa;
        /* access modifiers changed from: private */
        public final ArrayList<HashMap<String, Object>> zab = new ArrayList<>();
        private final HashMap<Object, Integer> zac = new HashMap<>();

        public /* synthetic */ Builder(String[] strArr, String str, zac zac2) {
            this.zaa = (String[]) Preconditions.checkNotNull(strArr);
        }

        @KeepForSdk
        public DataHolder build(int i11) {
            return new DataHolder(this, i11);
        }

        @KeepForSdk
        public Builder withRow(ContentValues contentValues) {
            Asserts.checkNotNull(contentValues);
            HashMap hashMap = new HashMap(contentValues.size());
            for (Map.Entry next : contentValues.valueSet()) {
                hashMap.put((String) next.getKey(), next.getValue());
            }
            return zaa(hashMap);
        }

        public Builder zaa(HashMap<String, Object> hashMap) {
            Asserts.checkNotNull(hashMap);
            this.zab.add(hashMap);
            return this;
        }

        @KeepForSdk
        public DataHolder build(int i11, Bundle bundle) {
            return new DataHolder(this, i11, bundle);
        }
    }

    @SafeParcelable.Constructor
    public DataHolder(@SafeParcelable.Param(id = 1000) int i11, @SafeParcelable.Param(id = 1) String[] strArr, @SafeParcelable.Param(id = 2) CursorWindow[] cursorWindowArr, @SafeParcelable.Param(id = 3) int i12, @SafeParcelable.Param(id = 4) Bundle bundle) {
        this.zae = false;
        this.zak = true;
        this.zaa = i11;
        this.zag = strArr;
        this.zah = cursorWindowArr;
        this.zai = i12;
        this.zaj = bundle;
    }

    @KeepForSdk
    public static Builder builder(String[] strArr) {
        return new Builder(strArr, (String) null, (zac) null);
    }

    @KeepForSdk
    public static DataHolder empty(int i11) {
        return new DataHolder(zaf, i11, (Bundle) null);
    }

    private final void zae(String str, int i11) {
        String str2;
        Bundle bundle = this.zab;
        if (bundle == null || !bundle.containsKey(str)) {
            String valueOf = String.valueOf(str);
            if (valueOf.length() != 0) {
                str2 = "No such column: ".concat(valueOf);
            } else {
                str2 = new String("No such column: ");
            }
            throw new IllegalArgumentException(str2);
        } else if (isClosed()) {
            throw new IllegalArgumentException("Buffer is closed.");
        } else if (i11 < 0 || i11 >= this.zad) {
            throw new CursorIndexOutOfBoundsException(i11, this.zad);
        }
    }

    private static CursorWindow[] zaf(Builder builder, int i11) {
        if (builder.zaa.length == 0) {
            return new CursorWindow[0];
        }
        ArrayList zab2 = builder.zab;
        int size = zab2.size();
        CursorWindow cursorWindow = new CursorWindow(false);
        ArrayList arrayList = new ArrayList();
        arrayList.add(cursorWindow);
        cursorWindow.setNumColumns(builder.zaa.length);
        int i12 = 0;
        boolean z11 = false;
        while (i12 < size) {
            try {
                if (!cursorWindow.allocRow()) {
                    StringBuilder sb2 = new StringBuilder(72);
                    sb2.append("Allocating additional cursor window for large data set (row ");
                    sb2.append(i12);
                    sb2.append(")");
                    Log.d("DataHolder", sb2.toString());
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i12);
                    cursorWindow.setNumColumns(builder.zaa.length);
                    arrayList.add(cursorWindow);
                    if (!cursorWindow.allocRow()) {
                        Log.e("DataHolder", "Unable to allocate row to hold data.");
                        arrayList.remove(cursorWindow);
                        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
                    }
                }
                Map map = (Map) zab2.get(i12);
                int i13 = 0;
                boolean z12 = true;
                while (true) {
                    if (i13 < builder.zaa.length) {
                        if (!z12) {
                            break;
                        }
                        String str = builder.zaa[i13];
                        Object obj = map.get(str);
                        if (obj == null) {
                            z12 = cursorWindow.putNull(i12, i13);
                        } else if (obj instanceof String) {
                            z12 = cursorWindow.putString((String) obj, i12, i13);
                        } else if (obj instanceof Long) {
                            z12 = cursorWindow.putLong(((Long) obj).longValue(), i12, i13);
                        } else if (obj instanceof Integer) {
                            z12 = cursorWindow.putLong((long) ((Integer) obj).intValue(), i12, i13);
                        } else if (obj instanceof Boolean) {
                            z12 = cursorWindow.putLong(true != ((Boolean) obj).booleanValue() ? 0 : 1, i12, i13);
                        } else if (obj instanceof byte[]) {
                            z12 = cursorWindow.putBlob((byte[]) obj, i12, i13);
                        } else if (obj instanceof Double) {
                            z12 = cursorWindow.putDouble(((Double) obj).doubleValue(), i12, i13);
                        } else if (obj instanceof Float) {
                            z12 = cursorWindow.putDouble((double) ((Float) obj).floatValue(), i12, i13);
                        } else {
                            String obj2 = obj.toString();
                            StringBuilder sb3 = new StringBuilder(String.valueOf(str).length() + 32 + obj2.length());
                            sb3.append("Unsupported object for column ");
                            sb3.append(str);
                            sb3.append(l.f34627b);
                            sb3.append(obj2);
                            throw new IllegalArgumentException(sb3.toString());
                        }
                        i13++;
                    } else if (z12) {
                        z11 = false;
                    }
                }
                if (!z11) {
                    StringBuilder sb4 = new StringBuilder(74);
                    sb4.append("Couldn't populate window data for row ");
                    sb4.append(i12);
                    sb4.append(" - allocating new window.");
                    Log.d("DataHolder", sb4.toString());
                    cursorWindow.freeLastRow();
                    cursorWindow = new CursorWindow(false);
                    cursorWindow.setStartPosition(i12);
                    cursorWindow.setNumColumns(builder.zaa.length);
                    arrayList.add(cursorWindow);
                    i12--;
                    z11 = true;
                    i12++;
                } else {
                    throw new zad("Could not add the value to a new CursorWindow. The size of value may be larger than what a CursorWindow can handle.");
                }
            } catch (RuntimeException e11) {
                int size2 = arrayList.size();
                for (int i14 = 0; i14 < size2; i14++) {
                    ((CursorWindow) arrayList.get(i14)).close();
                }
                throw e11;
            }
        }
        return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
    }

    @KeepForSdk
    public void close() {
        synchronized (this) {
            if (!this.zae) {
                this.zae = true;
                int i11 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.zah;
                    if (i11 >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i11].close();
                    i11++;
                }
            }
        }
    }

    public final void finalize() throws Throwable {
        try {
            if (this.zak && this.zah.length > 0 && !isClosed()) {
                close();
                String obj = toString();
                StringBuilder sb2 = new StringBuilder(String.valueOf(obj).length() + 178);
                sb2.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb2.append(obj);
                sb2.append(")");
                Log.e("DataBuffer", sb2.toString());
            }
        } finally {
            super.finalize();
        }
    }

    @KeepForSdk
    public boolean getBoolean(String str, int i11, int i12) {
        zae(str, i11);
        return Long.valueOf(this.zah[i12].getLong(i11, this.zab.getInt(str))).longValue() == 1;
    }

    @KeepForSdk
    public byte[] getByteArray(String str, int i11, int i12) {
        zae(str, i11);
        return this.zah[i12].getBlob(i11, this.zab.getInt(str));
    }

    @KeepForSdk
    public int getCount() {
        return this.zad;
    }

    @KeepForSdk
    public int getInteger(String str, int i11, int i12) {
        zae(str, i11);
        return this.zah[i12].getInt(i11, this.zab.getInt(str));
    }

    @KeepForSdk
    public long getLong(String str, int i11, int i12) {
        zae(str, i11);
        return this.zah[i12].getLong(i11, this.zab.getInt(str));
    }

    @KeepForSdk
    public Bundle getMetadata() {
        return this.zaj;
    }

    @KeepForSdk
    public int getStatusCode() {
        return this.zai;
    }

    @KeepForSdk
    public String getString(String str, int i11, int i12) {
        zae(str, i11);
        return this.zah[i12].getString(i11, this.zab.getInt(str));
    }

    @KeepForSdk
    public int getWindowIndex(int i11) {
        int length;
        int i12 = 0;
        Preconditions.checkState(i11 >= 0 && i11 < this.zad);
        while (true) {
            int[] iArr = this.zac;
            length = iArr.length;
            if (i12 >= length) {
                break;
            } else if (i11 < iArr[i12]) {
                i12--;
                break;
            } else {
                i12++;
            }
        }
        return i12 == length ? i12 - 1 : i12;
    }

    @KeepForSdk
    public boolean hasColumn(String str) {
        return this.zab.containsKey(str);
    }

    @KeepForSdk
    public boolean hasNull(String str, int i11, int i12) {
        zae(str, i11);
        return this.zah[i12].isNull(i11, this.zab.getInt(str));
    }

    @KeepForSdk
    public boolean isClosed() {
        boolean z11;
        synchronized (this) {
            z11 = this.zae;
        }
        return z11;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeStringArray(parcel, 1, this.zag, false);
        SafeParcelWriter.writeTypedArray(parcel, 2, this.zah, i11, false);
        SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
        SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
        SafeParcelWriter.writeInt(parcel, 1000, this.zaa);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        if ((i11 & 1) != 0) {
            close();
        }
    }

    public final double zaa(String str, int i11, int i12) {
        zae(str, i11);
        return this.zah[i12].getDouble(i11, this.zab.getInt(str));
    }

    public final float zab(String str, int i11, int i12) {
        zae(str, i11);
        return this.zah[i12].getFloat(i11, this.zab.getInt(str));
    }

    public final void zac(String str, int i11, int i12, CharArrayBuffer charArrayBuffer) {
        zae(str, i11);
        this.zah[i12].copyStringToBuffer(i11, this.zab.getInt(str), charArrayBuffer);
    }

    public final void zad() {
        this.zab = new Bundle();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            String[] strArr = this.zag;
            if (i12 >= strArr.length) {
                break;
            }
            this.zab.putInt(strArr[i12], i12);
            i12++;
        }
        this.zac = new int[this.zah.length];
        int i13 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.zah;
            if (i11 < cursorWindowArr.length) {
                this.zac[i11] = i13;
                i13 += this.zah[i11].getNumRows() - (i13 - cursorWindowArr[i11].getStartPosition());
                i11++;
            } else {
                this.zad = i13;
                return;
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* JADX WARNING: Illegal instructions before constructor call */
    @com.google.android.gms.common.annotation.KeepForSdk
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DataHolder(android.database.Cursor r8, int r9, android.os.Bundle r10) {
        /*
            r7 = this;
            com.google.android.gms.common.sqlite.CursorWrapper r0 = new com.google.android.gms.common.sqlite.CursorWrapper
            r0.<init>(r8)
            java.lang.String[] r8 = r0.getColumnNames()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            int r2 = r0.getCount()     // Catch:{ all -> 0x0076 }
            android.database.CursorWindow r3 = r0.getWindow()     // Catch:{ all -> 0x0076 }
            r4 = 0
            r5 = 0
            if (r3 == 0) goto L_0x002e
            int r6 = r3.getStartPosition()     // Catch:{ all -> 0x0076 }
            if (r6 != 0) goto L_0x002e
            r3.acquireReference()     // Catch:{ all -> 0x0076 }
            r0.setWindow(r4)     // Catch:{ all -> 0x0076 }
            r1.add(r3)     // Catch:{ all -> 0x0076 }
            int r3 = r3.getNumRows()     // Catch:{ all -> 0x0076 }
            goto L_0x002f
        L_0x002e:
            r3 = r5
        L_0x002f:
            if (r3 >= r2) goto L_0x0063
            boolean r6 = r0.moveToPosition(r3)     // Catch:{ all -> 0x0076 }
            if (r6 == 0) goto L_0x0063
            android.database.CursorWindow r6 = r0.getWindow()     // Catch:{ all -> 0x0076 }
            if (r6 == 0) goto L_0x0044
            r6.acquireReference()     // Catch:{ all -> 0x0076 }
            r0.setWindow(r4)     // Catch:{ all -> 0x0076 }
            goto L_0x004f
        L_0x0044:
            android.database.CursorWindow r6 = new android.database.CursorWindow     // Catch:{ all -> 0x0076 }
            r6.<init>(r5)     // Catch:{ all -> 0x0076 }
            r6.setStartPosition(r3)     // Catch:{ all -> 0x0076 }
            r0.fillWindow(r3, r6)     // Catch:{ all -> 0x0076 }
        L_0x004f:
            int r3 = r6.getNumRows()     // Catch:{ all -> 0x0076 }
            if (r3 != 0) goto L_0x0056
            goto L_0x0063
        L_0x0056:
            r1.add(r6)     // Catch:{ all -> 0x0076 }
            int r3 = r6.getStartPosition()     // Catch:{ all -> 0x0076 }
            int r6 = r6.getNumRows()     // Catch:{ all -> 0x0076 }
            int r3 = r3 + r6
            goto L_0x002f
        L_0x0063:
            r0.close()
            int r0 = r1.size()
            android.database.CursorWindow[] r0 = new android.database.CursorWindow[r0]
            java.lang.Object[] r0 = r1.toArray(r0)
            android.database.CursorWindow[] r0 = (android.database.CursorWindow[]) r0
            r7.<init>((java.lang.String[]) r8, (android.database.CursorWindow[]) r0, (int) r9, (android.os.Bundle) r10)
            return
        L_0x0076:
            r8 = move-exception
            r0.close()
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.data.DataHolder.<init>(android.database.Cursor, int, android.os.Bundle):void");
    }

    private DataHolder(Builder builder, int i11, Bundle bundle) {
        this(builder.zaa, zaf(builder, -1), i11, (Bundle) null);
    }

    @KeepForSdk
    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i11, Bundle bundle) {
        this.zae = false;
        this.zak = true;
        this.zaa = 1;
        this.zag = (String[]) Preconditions.checkNotNull(strArr);
        this.zah = (CursorWindow[]) Preconditions.checkNotNull(cursorWindowArr);
        this.zai = i11;
        this.zaj = bundle;
        zad();
    }
}
