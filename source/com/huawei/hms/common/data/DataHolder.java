package com.huawei.hms.common.data;

import android.content.ContentValues;
import android.database.CharArrayBuffer;
import android.database.Cursor;
import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.common.internal.safeparcel.AbstractSafeParcelable;
import com.huawei.hms.common.internal.safeparcel.SafeParcelWriter;
import com.huawei.hms.common.sqlite.HMSCursorWrapper;
import com.huawei.hms.support.log.HMSLog;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    private static final Builder BUILDER = new DataHolderBuilderCreator(new String[0], (String) null);
    public static final Parcelable.Creator<DataHolder> CREATOR = new DataHolderCreator();
    private static final String TAG = "DataHolder";
    public static final String TYPE_BOOLEAN = "type_boolean";
    public static final String TYPE_BYTE_ARRAY = "type_byte_array";
    public static final String TYPE_DOUBLE = "type_double";
    public static final String TYPE_FLOAT = "type_float";
    public static final String TYPE_INT = "type_int";
    public static final String TYPE_LONG = "type_long";
    public static final String TYPE_STRING = "type_string";
    private String[] columns;
    private Bundle columnsBundle;
    private CursorWindow[] cursorWindows;
    private int dataCount;
    private boolean isInstance;
    private boolean mClosed;
    private Bundle metadata;
    private int[] perCursorCounts;
    private int statusCode;
    private int version;

    public static class Builder {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String[] f37887a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final ArrayList<HashMap<String, Object>> f37888b;

        /* renamed from: c  reason: collision with root package name */
        private final String f37889c;

        /* renamed from: d  reason: collision with root package name */
        private final HashMap<Object, Integer> f37890d;

        public DataHolder build(int i11) {
            return new DataHolder(this, i11, (Bundle) null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
        /* JADX WARNING: Removed duplicated region for block: B:11:0x0040  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public com.huawei.hms.common.data.DataHolder.Builder setDataForContentValuesHashMap(java.util.HashMap<java.lang.String, java.lang.Object> r6) {
            /*
                r5 = this;
                java.lang.String r0 = "contentValuesHashMap cannot be null"
                com.huawei.hms.common.internal.Preconditions.checkNotNull(r6, r0)
                java.lang.String r0 = r5.f37889c
                r1 = 0
                if (r0 == 0) goto L_0x0032
                java.lang.Object r0 = r6.get(r0)
                if (r0 == 0) goto L_0x0032
                java.util.HashMap<java.lang.Object, java.lang.Integer> r2 = r5.f37890d
                java.lang.Object r2 = r2.get(r0)
                java.lang.Integer r2 = (java.lang.Integer) r2
                if (r2 == 0) goto L_0x0023
                int r1 = r2.intValue()
                r0 = 1
                r4 = r1
                r1 = r0
                r0 = r4
                goto L_0x0033
            L_0x0023:
                java.util.HashMap<java.lang.Object, java.lang.Integer> r2 = r5.f37890d
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r3 = r5.f37888b
                int r3 = r3.size()
                java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
                r2.put(r0, r3)
            L_0x0032:
                r0 = r1
            L_0x0033:
                if (r1 == 0) goto L_0x0040
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r1 = r5.f37888b
                r1.remove(r0)
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r1 = r5.f37888b
                r1.add(r0, r6)
                goto L_0x0045
            L_0x0040:
                java.util.ArrayList<java.util.HashMap<java.lang.String, java.lang.Object>> r0 = r5.f37888b
                r0.add(r6)
            L_0x0045:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.data.DataHolder.Builder.setDataForContentValuesHashMap(java.util.HashMap):com.huawei.hms.common.data.DataHolder$Builder");
        }

        public Builder withRow(ContentValues contentValues) {
            Preconditions.checkNotNull(contentValues, "contentValues cannot be null");
            HashMap hashMap = new HashMap(contentValues.size());
            for (Map.Entry next : contentValues.valueSet()) {
                hashMap.put(next.getKey(), next.getValue());
            }
            return setDataForContentValuesHashMap(hashMap);
        }

        private Builder(String[] strArr, String str) {
            Preconditions.checkNotNull(strArr, "builderColumnsP cannot be null");
            this.f37887a = strArr;
            this.f37888b = new ArrayList<>();
            this.f37889c = str;
            this.f37890d = new HashMap<>();
        }

        public DataHolder build(int i11, Bundle bundle) {
            return new DataHolder(this, i11, bundle, -1);
        }

        public Builder(String[] strArr, String str, DataHolderBuilderCreator dataHolderBuilderCreator) {
            this(strArr, (String) null);
        }
    }

    public static class DataHolderException extends RuntimeException {
        public DataHolderException(String str) {
            super(str);
        }
    }

    public static Builder builder(String[] strArr) {
        return new Builder(strArr, (String) null);
    }

    private void checkAvailable(String str, int i11) {
        String str2;
        Bundle bundle = this.columnsBundle;
        if (bundle == null || !bundle.containsKey(str)) {
            str2 = "cannot find column: " + str;
        } else if (isClosed()) {
            str2 = "buffer has been closed";
        } else if (i11 < 0 || i11 >= this.dataCount) {
            str2 = "row is out of index:" + i11;
        } else {
            str2 = "";
        }
        Preconditions.checkArgument(str2.isEmpty(), str2);
    }

    public static DataHolder empty(int i11) {
        return new DataHolder(BUILDER, i11, (Bundle) null);
    }

    private static CursorWindow[] getCursorWindows(HMSCursorWrapper hMSCursorWrapper) {
        int i11;
        ArrayList arrayList = new ArrayList();
        try {
            int count = hMSCursorWrapper.getCount();
            CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null || window.getStartPosition() != 0) {
                i11 = 0;
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow((CursorWindow) null);
                arrayList.add(window);
                i11 = window.getNumRows();
            }
            arrayList.addAll(iterCursorWrapper(hMSCursorWrapper, i11, count));
            return (CursorWindow[]) arrayList.toArray(new CursorWindow[arrayList.size()]);
        } catch (Throwable th2) {
            HMSLog.e(TAG, "fail to getCursorWindows: " + th2.getMessage());
            return new CursorWindow[0];
        } finally {
            hMSCursorWrapper.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2 A[LOOP:2: B:27:0x009c->B:29:0x00a2, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.ArrayList<android.database.CursorWindow> iterCursorWindow(com.huawei.hms.common.data.DataHolder.Builder r10, int r11, java.util.List r12) {
        /*
            java.lang.String r0 = "DataHolder"
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            android.database.CursorWindow r2 = new android.database.CursorWindow
            r3 = 0
            r2.<init>(r3)
            java.lang.String[] r4 = r10.f37887a
            int r4 = r4.length
            r2.setNumColumns(r4)
            r1.add(r2)
            r4 = 0
            r5 = r4
        L_0x001a:
            if (r5 >= r11) goto L_0x00b6
            boolean r6 = r2.allocRow()     // Catch:{ RuntimeException -> 0x0097 }
            if (r6 != 0) goto L_0x0047
            java.lang.String r6 = "Failed to allocate a row"
            com.huawei.hms.support.log.HMSLog.d(r0, r6)     // Catch:{ RuntimeException -> 0x0097 }
            android.database.CursorWindow r6 = new android.database.CursorWindow     // Catch:{ RuntimeException -> 0x0097 }
            r6.<init>(r3)     // Catch:{ RuntimeException -> 0x0097 }
            r6.setStartPosition(r5)     // Catch:{ RuntimeException -> 0x0098 }
            java.lang.String[] r2 = r10.f37887a     // Catch:{ RuntimeException -> 0x0098 }
            int r2 = r2.length     // Catch:{ RuntimeException -> 0x0098 }
            r6.setNumColumns(r2)     // Catch:{ RuntimeException -> 0x0098 }
            boolean r2 = r6.allocRow()     // Catch:{ RuntimeException -> 0x0098 }
            if (r2 != 0) goto L_0x0043
            java.lang.String r2 = "Failed to retry to allocate a row"
            com.huawei.hms.support.log.HMSLog.e(r0, r2)     // Catch:{ RuntimeException -> 0x0098 }
            return r1
        L_0x0043:
            r1.add(r6)     // Catch:{ RuntimeException -> 0x0098 }
            r2 = r6
        L_0x0047:
            java.lang.Object r6 = r12.get(r5)     // Catch:{ RuntimeException -> 0x0097 }
            java.util.HashMap r6 = (java.util.HashMap) r6     // Catch:{ RuntimeException -> 0x0097 }
            r7 = 1
            r8 = r4
        L_0x004f:
            java.lang.String[] r9 = r10.f37887a     // Catch:{ RuntimeException -> 0x0097 }
            int r9 = r9.length     // Catch:{ RuntimeException -> 0x0097 }
            if (r8 >= r9) goto L_0x006a
            java.lang.String[] r7 = r10.f37887a     // Catch:{ RuntimeException -> 0x0097 }
            r7 = r7[r8]     // Catch:{ RuntimeException -> 0x0097 }
            java.lang.Object r7 = r6.get(r7)     // Catch:{ RuntimeException -> 0x0097 }
            boolean r7 = putValue(r2, r7, r5, r8)     // Catch:{ RuntimeException -> 0x0097 }
            if (r7 != 0) goto L_0x0067
            goto L_0x006a
        L_0x0067:
            int r8 = r8 + 1
            goto L_0x004f
        L_0x006a:
            if (r7 != 0) goto L_0x00b2
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ RuntimeException -> 0x0097 }
            r6.<init>()     // Catch:{ RuntimeException -> 0x0097 }
            java.lang.String r7 = "fail to put data for row "
            r6.append(r7)     // Catch:{ RuntimeException -> 0x0097 }
            r6.append(r5)     // Catch:{ RuntimeException -> 0x0097 }
            java.lang.String r6 = r6.toString()     // Catch:{ RuntimeException -> 0x0097 }
            com.huawei.hms.support.log.HMSLog.d(r0, r6)     // Catch:{ RuntimeException -> 0x0097 }
            r2.freeLastRow()     // Catch:{ RuntimeException -> 0x0097 }
            android.database.CursorWindow r6 = new android.database.CursorWindow     // Catch:{ RuntimeException -> 0x0097 }
            r6.<init>(r3)     // Catch:{ RuntimeException -> 0x0097 }
            r6.setStartPosition(r5)     // Catch:{ RuntimeException -> 0x0097 }
            java.lang.String[] r7 = r10.f37887a     // Catch:{ RuntimeException -> 0x0097 }
            int r7 = r7.length     // Catch:{ RuntimeException -> 0x0097 }
            r6.setNumColumns(r7)     // Catch:{ RuntimeException -> 0x0097 }
            r1.add(r6)     // Catch:{ RuntimeException -> 0x0097 }
            goto L_0x00b6
        L_0x0097:
            r6 = r2
        L_0x0098:
            java.util.Iterator r2 = r1.iterator()
        L_0x009c:
            boolean r7 = r2.hasNext()
            if (r7 == 0) goto L_0x00ac
            java.lang.Object r7 = r2.next()
            android.database.CursorWindow r7 = (android.database.CursorWindow) r7
            r7.close()
            goto L_0x009c
        L_0x00ac:
            java.lang.String r2 = "iter CursorWindow failed, RuntimeException occured."
            com.huawei.hms.support.log.HMSLog.w(r0, r2)
            r2 = r6
        L_0x00b2:
            int r5 = r5 + 1
            goto L_0x001a
        L_0x00b6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.hms.common.data.DataHolder.iterCursorWindow(com.huawei.hms.common.data.DataHolder$Builder, int, java.util.List):java.util.ArrayList");
    }

    private static ArrayList<CursorWindow> iterCursorWrapper(HMSCursorWrapper hMSCursorWrapper, int i11, int i12) {
        ArrayList<CursorWindow> arrayList = new ArrayList<>();
        while (i11 < i12 && hMSCursorWrapper.moveToPosition(i11)) {
            CursorWindow window = hMSCursorWrapper.getWindow();
            if (window == null) {
                window = new CursorWindow((String) null);
                window.setStartPosition(i11);
                hMSCursorWrapper.fillWindow(i11, window);
            } else {
                window.acquireReference();
                hMSCursorWrapper.setWindow((CursorWindow) null);
            }
            if (window.getNumRows() == 0) {
                break;
            }
            arrayList.add(window);
            i11 = window.getNumRows() + window.getStartPosition();
        }
        return arrayList;
    }

    private static boolean putValue(CursorWindow cursorWindow, Object obj, int i11, int i12) throws IllegalArgumentException {
        if (obj == null) {
            return cursorWindow.putNull(i11, i12);
        }
        if (obj instanceof Boolean) {
            return cursorWindow.putLong(((Boolean) obj).booleanValue() ? 1 : 0, i11, i12);
        } else if (obj instanceof Integer) {
            return cursorWindow.putLong((long) ((Integer) obj).intValue(), i11, i12);
        } else {
            if (obj instanceof Long) {
                return cursorWindow.putLong(((Long) obj).longValue(), i11, i12);
            }
            if (obj instanceof Float) {
                return cursorWindow.putDouble((double) ((Float) obj).floatValue(), i11, i12);
            }
            if (obj instanceof Double) {
                return cursorWindow.putDouble(((Double) obj).doubleValue(), i11, i12);
            }
            if (obj instanceof String) {
                return cursorWindow.putString((String) obj, i11, i12);
            }
            if (obj instanceof byte[]) {
                return cursorWindow.putBlob((byte[]) obj, i11, i12);
            }
            throw new IllegalArgumentException("unsupported type for column: " + obj);
        }
    }

    public final synchronized void close() {
        if (!this.mClosed) {
            for (CursorWindow close : this.cursorWindows) {
                close.close();
            }
            this.mClosed = true;
        }
    }

    public final void collectColumsAndCount() {
        this.columnsBundle = new Bundle();
        String[] strArr = this.columns;
        int i11 = 0;
        if (strArr == null || strArr.length == 0) {
            this.dataCount = 0;
            return;
        }
        int i12 = 0;
        while (true) {
            String[] strArr2 = this.columns;
            if (i12 >= strArr2.length) {
                break;
            }
            this.columnsBundle.putInt(strArr2[i12], i12);
            i12++;
        }
        CursorWindow[] cursorWindowArr = this.cursorWindows;
        if (cursorWindowArr == null || cursorWindowArr.length == 0) {
            this.dataCount = 0;
            return;
        }
        this.perCursorCounts = new int[cursorWindowArr.length];
        int i13 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr2 = this.cursorWindows;
            if (i11 < cursorWindowArr2.length) {
                this.perCursorCounts[i11] = i13;
                i13 = cursorWindowArr2[i11].getStartPosition() + this.cursorWindows[i11].getNumRows();
                i11++;
            } else {
                this.dataCount = i13;
                return;
            }
        }
    }

    public final void copyToBuffer(String str, int i11, int i12, CharArrayBuffer charArrayBuffer) {
        checkAvailable(str, i11);
        this.cursorWindows[i12].copyStringToBuffer(i11, this.columnsBundle.getInt(str), charArrayBuffer);
    }

    public final void finalize() throws Throwable {
        if (this.isInstance && this.cursorWindows.length > 0 && !isClosed()) {
            close();
        }
        super.finalize();
    }

    public final int getCount() {
        return this.dataCount;
    }

    public final Bundle getMetadata() {
        return this.metadata;
    }

    public final int getStatusCode() {
        return this.statusCode;
    }

    public final Object getValue(String str, int i11, int i12, String str2) {
        str2.hashCode();
        boolean z11 = true;
        char c11 = 65535;
        switch (str2.hashCode()) {
            case -1092271849:
                if (str2.equals(TYPE_FLOAT)) {
                    c11 = 0;
                    break;
                }
                break;
            case -870070237:
                if (str2.equals(TYPE_BOOLEAN)) {
                    c11 = 1;
                    break;
                }
                break;
            case -675993238:
                if (str2.equals(TYPE_INT)) {
                    c11 = 2;
                    break;
                }
                break;
            case 445002870:
                if (str2.equals(TYPE_DOUBLE)) {
                    c11 = 3;
                    break;
                }
                break;
            case 519136353:
                if (str2.equals(TYPE_LONG)) {
                    c11 = 4;
                    break;
                }
                break;
            case 878975158:
                if (str2.equals(TYPE_STRING)) {
                    c11 = 5;
                    break;
                }
                break;
            case 1300508295:
                if (str2.equals(TYPE_BYTE_ARRAY)) {
                    c11 = 6;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                checkAvailable(str, i11);
                return Float.valueOf(this.cursorWindows[i12].getFloat(i11, this.columnsBundle.getInt(str)));
            case 1:
                checkAvailable(str, i11);
                if (this.cursorWindows[i12].getLong(i11, this.columnsBundle.getInt(str)) != 1) {
                    z11 = false;
                }
                return Boolean.valueOf(z11);
            case 2:
                checkAvailable(str, i11);
                return Integer.valueOf(this.cursorWindows[i12].getInt(i11, this.columnsBundle.getInt(str)));
            case 3:
                checkAvailable(str, i11);
                return Double.valueOf(this.cursorWindows[i12].getDouble(i11, this.columnsBundle.getInt(str)));
            case 4:
                checkAvailable(str, i11);
                return Long.valueOf(this.cursorWindows[i12].getLong(i11, this.columnsBundle.getInt(str)));
            case 5:
                checkAvailable(str, i11);
                return this.cursorWindows[i12].getString(i11, this.columnsBundle.getInt(str));
            case 6:
                checkAvailable(str, i11);
                return this.cursorWindows[i12].getBlob(i11, this.columnsBundle.getInt(str));
            default:
                return null;
        }
    }

    public final int getWindowIndex(int i11) {
        int[] iArr;
        int i12 = 0;
        Preconditions.checkArgument(i11 >= 0 || i11 < this.dataCount, "rowIndex is out of index:" + i11);
        while (true) {
            iArr = this.perCursorCounts;
            if (i12 >= iArr.length) {
                break;
            } else if (i11 < iArr[i12]) {
                i12--;
                break;
            } else {
                i12++;
            }
        }
        return i12 == iArr.length ? i12 - 1 : i12;
    }

    public final boolean hasColumn(String str) {
        return this.columnsBundle.containsKey(str);
    }

    public final boolean hasNull(String str, int i11, int i12) {
        checkAvailable(str, i11);
        return this.cursorWindows[i12].getType(i11, this.columnsBundle.getInt(str)) == 0;
    }

    public final synchronized boolean isClosed() {
        return this.mClosed;
    }

    public final void writeToParcel(Parcel parcel, int i11) {
        if (parcel != null) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeStringArray(parcel, 1, this.columns, false);
            SafeParcelWriter.writeTypedArray(parcel, 2, this.cursorWindows, i11, false);
            SafeParcelWriter.writeInt(parcel, 3, getStatusCode());
            SafeParcelWriter.writeBundle(parcel, 4, getMetadata(), false);
            SafeParcelWriter.writeInt(parcel, 1000, this.version);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
            if ((i11 & 1) != 0) {
                close();
            }
        }
    }

    public DataHolder(int i11, String[] strArr, CursorWindow[] cursorWindowArr, int i12, Bundle bundle) {
        this.mClosed = false;
        this.isInstance = true;
        this.version = i11;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i12;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    public DataHolder(String[] strArr, CursorWindow[] cursorWindowArr, int i11, Bundle bundle) {
        Preconditions.checkNotNull(strArr, "columnsP cannot be null");
        Preconditions.checkNotNull(cursorWindowArr, "cursorWindowP cannot be null");
        this.mClosed = false;
        this.isInstance = true;
        this.version = 1;
        this.columns = strArr;
        this.cursorWindows = cursorWindowArr;
        this.statusCode = i11;
        this.metadata = bundle;
        collectColumsAndCount();
    }

    private static CursorWindow[] getCursorWindows(Builder builder, int i11) {
        if (builder.f37887a.length == 0) {
            return new CursorWindow[0];
        }
        if (i11 < 0 || i11 >= builder.f37888b.size()) {
            i11 = builder.f37888b.size();
        }
        ArrayList<CursorWindow> iterCursorWindow = iterCursorWindow(builder, i11, builder.f37888b.subList(0, i11));
        return (CursorWindow[]) iterCursorWindow.toArray(new CursorWindow[iterCursorWindow.size()]);
    }

    private DataHolder(HMSCursorWrapper hMSCursorWrapper, int i11, Bundle bundle) {
        this(hMSCursorWrapper.getColumnNames(), getCursorWindows(hMSCursorWrapper), i11, bundle);
    }

    public DataHolder(Cursor cursor, int i11, Bundle bundle) {
        this(new HMSCursorWrapper(cursor), i11, bundle);
    }

    private DataHolder(Builder builder, int i11, Bundle bundle) {
        this(builder.f37887a, getCursorWindows(builder, -1), i11, (Bundle) null);
    }

    private DataHolder(Builder builder, int i11, Bundle bundle, int i12) {
        this(builder.f37887a, getCursorWindows(builder, -1), i11, bundle);
    }
}
