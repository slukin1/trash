package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.services.s3.model.PartETag;
import com.amazonaws.services.s3.model.UploadPartRequest;
import com.google.gson.Gson;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

class TransferDBUtil {

    /* renamed from: b  reason: collision with root package name */
    public static final Log f14965b = LogFactory.b(TransferDBUtil.class);

    /* renamed from: c  reason: collision with root package name */
    public static final Object f14966c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public static TransferDBBase f14967d;

    /* renamed from: a  reason: collision with root package name */
    public Gson f14968a = new Gson();

    public TransferDBUtil(Context context) {
        synchronized (f14966c) {
            if (f14967d == null) {
                f14967d = new TransferDBBase(context);
            }
        }
    }

    public final String a(int i11) {
        if (i11 <= 0) {
            f14965b.c("Cannot create a string of 0 or less placeholders.");
            return null;
        }
        StringBuilder sb2 = new StringBuilder((i11 * 2) - 1);
        sb2.append("?");
        for (int i12 = 1; i12 < i11; i12++) {
            sb2.append(",?");
        }
        return sb2.toString();
    }

    public int b(int i11) {
        return f14967d.a(e(i11), (String) null, (String[]) null);
    }

    public List<UploadPartRequest> c(int i11, String str) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor d11 = f14967d.d(d(i11), (String[]) null, (String) null, (String[]) null, (String) null);
            while (d11.moveToNext()) {
                if (!TransferState.PART_COMPLETED.equals(TransferState.getState(d11.getString(d11.getColumnIndexOrThrow("state"))))) {
                    UploadPartRequest withPartSize = new UploadPartRequest().withId(d11.getInt(d11.getColumnIndexOrThrow("_id"))).withMainUploadId(d11.getInt(d11.getColumnIndexOrThrow("main_upload_id"))).withBucketName(d11.getString(d11.getColumnIndexOrThrow("bucket_name"))).withKey(d11.getString(d11.getColumnIndexOrThrow("key"))).withUploadId(str).withFile(new File(d11.getString(d11.getColumnIndexOrThrow("file")))).withFileOffset(d11.getLong(d11.getColumnIndexOrThrow("file_offset"))).withPartNumber(d11.getInt(d11.getColumnIndexOrThrow("part_num"))).withPartSize(d11.getLong(d11.getColumnIndexOrThrow("bytes_total")));
                    boolean z11 = true;
                    if (1 != d11.getInt(d11.getColumnIndexOrThrow("is_last_part"))) {
                        z11 = false;
                    }
                    arrayList.add(withPartSize.withLastPart(z11));
                }
            }
            d11.close();
            return arrayList;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public Uri d(int i11) {
        return Uri.parse(f14967d.c() + "/part/" + i11);
    }

    public Uri e(int i11) {
        return Uri.parse(f14967d.c() + "/" + i11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v3, resolved type: com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v1, types: [android.database.Cursor] */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v5 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord f(int r4) {
        /*
            r3 = this;
            r0 = 0
            android.database.Cursor r1 = r3.i(r4)     // Catch:{ all -> 0x001a }
            boolean r2 = r1.moveToFirst()     // Catch:{ all -> 0x0017 }
            if (r2 == 0) goto L_0x0013
            com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord r0 = new com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord     // Catch:{ all -> 0x0017 }
            r0.<init>(r4)     // Catch:{ all -> 0x0017 }
            r0.g(r1)     // Catch:{ all -> 0x0017 }
        L_0x0013:
            r1.close()
            return r0
        L_0x0017:
            r4 = move-exception
            r0 = r1
            goto L_0x001b
        L_0x001a:
            r4 = move-exception
        L_0x001b:
            if (r0 == 0) goto L_0x0020
            r0.close()
        L_0x0020:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.mobileconnectors.s3.transferutility.TransferDBUtil.f(int):com.amazonaws.mobileconnectors.s3.transferutility.TransferRecord");
    }

    public long g(int i11) {
        Cursor cursor = null;
        try {
            Cursor d11 = f14967d.d(d(i11), (String[]) null, (String) null, (String[]) null, (String) null);
            long j11 = 0;
            while (d11.moveToNext()) {
                if (TransferState.PART_COMPLETED.equals(TransferState.getState(d11.getString(d11.getColumnIndexOrThrow("state"))))) {
                    j11 += d11.getLong(d11.getColumnIndexOrThrow("bytes_total"));
                }
            }
            d11.close();
            return j11;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public List<PartETag> h(int i11) {
        ArrayList arrayList = new ArrayList();
        Cursor cursor = null;
        try {
            Cursor d11 = f14967d.d(d(i11), (String[]) null, (String) null, (String[]) null, (String) null);
            while (d11.moveToNext()) {
                arrayList.add(new PartETag(d11.getInt(d11.getColumnIndexOrThrow("part_num")), d11.getString(d11.getColumnIndexOrThrow("etag"))));
            }
            d11.close();
            return arrayList;
        } catch (Throwable th2) {
            if (cursor != null) {
                cursor.close();
            }
            throw th2;
        }
    }

    public Cursor i(int i11) {
        return f14967d.d(e(i11), (String[]) null, (String) null, (String[]) null, (String) null);
    }

    public Cursor j(TransferType transferType, TransferState[] transferStateArr) {
        String[] strArr;
        String str;
        int length = transferStateArr.length;
        String a11 = a(length);
        int i11 = 0;
        if (transferType == TransferType.ANY) {
            String str2 = "state in (" + a11 + ")";
            String[] strArr2 = new String[length];
            while (i11 < length) {
                strArr2[i11] = transferStateArr[i11].toString();
                i11++;
            }
            str = str2;
            strArr = strArr2;
        } else {
            String str3 = "state in (" + a11 + ") and " + "type" + "=?";
            String[] strArr3 = new String[(length + 1)];
            while (i11 < length) {
                strArr3[i11] = transferStateArr[i11].toString();
                i11++;
            }
            strArr3[i11] = transferType.toString();
            str = str3;
            strArr = strArr3;
        }
        TransferDBBase transferDBBase = f14967d;
        return transferDBBase.d(transferDBBase.c(), (String[]) null, str, strArr, (String) null);
    }

    public int k(int i11, long j11) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("bytes_current", Long.valueOf(j11));
        return f14967d.e(e(i11), contentValues, (String) null, (String[]) null);
    }

    public int l(int i11, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("etag", str);
        return f14967d.e(e(i11), contentValues, (String) null, (String[]) null);
    }

    public int m(int i11, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("multipart_id", str);
        return f14967d.e(e(i11), contentValues, (String) null, (String[]) null);
    }

    public int n(int i11, TransferState transferState) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("state", transferState.toString());
        if (!TransferState.FAILED.equals(transferState)) {
            return f14967d.e(e(i11), contentValues, (String) null, (String[]) null);
        }
        return f14967d.e(e(i11), contentValues, "state not in (?,?,?,?,?) ", new String[]{TransferState.COMPLETED.toString(), TransferState.PENDING_NETWORK_DISCONNECT.toString(), TransferState.PAUSED.toString(), TransferState.CANCELED.toString(), TransferState.WAITING_FOR_NETWORK.toString()});
    }

    public int o(TransferRecord transferRecord) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("_id", Integer.valueOf(transferRecord.f14977a));
        contentValues.put("state", transferRecord.f14991o.toString());
        contentValues.put("bytes_total", Long.valueOf(transferRecord.f14984h));
        contentValues.put("bytes_current", Long.valueOf(transferRecord.f14985i));
        return f14967d.e(e(transferRecord.f14977a), contentValues, (String) null, (String[]) null);
    }
}
