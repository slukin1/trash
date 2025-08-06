package iz;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import com.zendesk.belvedere.BelvedereCallback;
import com.zendesk.belvedere.BelvedereResult;
import java.util.List;

public class c extends AsyncTask<Uri, Void, List<BelvedereResult>> {

    /* renamed from: a  reason: collision with root package name */
    public final BelvedereCallback<List<BelvedereResult>> f52892a;

    /* renamed from: b  reason: collision with root package name */
    public final Context f52893b;

    /* renamed from: c  reason: collision with root package name */
    public final b f52894c;

    /* renamed from: d  reason: collision with root package name */
    public final e f52895d;

    public c(Context context, b bVar, e eVar, BelvedereCallback<List<BelvedereResult>> belvedereCallback) {
        this.f52893b = context;
        this.f52894c = bVar;
        this.f52895d = eVar;
        this.f52892a = belvedereCallback;
    }

    /* JADX WARNING: Removed duplicated region for block: B:57:0x00df A[SYNTHETIC, Splitter:B:57:0x00df] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00ec A[SYNTHETIC, Splitter:B:62:0x00ec] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0108 A[SYNTHETIC, Splitter:B:70:0x0108] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0115 A[SYNTHETIC, Splitter:B:75:0x0115] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0128 A[SYNTHETIC, Splitter:B:83:0x0128] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0135 A[SYNTHETIC, Splitter:B:88:0x0135] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x0120 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0120 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.zendesk.belvedere.BelvedereResult> doInBackground(android.net.Uri... r20) {
        /*
            r19 = this;
            r1 = r19
            r2 = r20
            java.lang.String r3 = "Error closing FileOutputStream"
            java.lang.String r4 = "Error closing InputStream"
            java.lang.String r5 = "BelvedereResolveUriTask"
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>()
            int r7 = r2.length
            r8 = 0
            r9 = r8
        L_0x0012:
            if (r9 >= r7) goto L_0x0141
            r10 = r2[r9]
            android.content.Context r0 = r1.f52893b     // Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00c7, all -> 0x00c1 }
            android.content.ContentResolver r0 = r0.getContentResolver()     // Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00c7, all -> 0x00c1 }
            java.io.InputStream r13 = r0.openInputStream(r10)     // Catch:{ FileNotFoundException -> 0x00f0, IOException -> 0x00c7, all -> 0x00c1 }
            iz.e r0 = r1.f52895d     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            android.content.Context r14 = r1.f52893b     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            java.io.File r0 = r0.k(r14, r10)     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            r14 = 2
            if (r13 == 0) goto L_0x0079
            if (r0 == 0) goto L_0x0079
            iz.b r15 = r1.f52894c     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            java.util.Locale r11 = java.util.Locale.US     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            java.lang.String r12 = "Copying media file into private cache - Uri: %s - Dest: %s"
            java.lang.Object[] r14 = new java.lang.Object[r14]     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            r14[r8] = r10     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            r17 = 1
            r14[r17] = r0     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            java.lang.String r11 = java.lang.String.format(r11, r12, r14)     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            r15.d(r5, r11)     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            java.io.FileOutputStream r11 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            r11.<init>(r0)     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            r12 = 1024(0x400, float:1.435E-42)
            byte[] r12 = new byte[r12]     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006d, all -> 0x0066 }
        L_0x004b:
            int r14 = r13.read(r12)     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006d, all -> 0x0066 }
            if (r14 <= 0) goto L_0x0055
            r11.write(r12, r8, r14)     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006d, all -> 0x0066 }
            goto L_0x004b
        L_0x0055:
            com.zendesk.belvedere.BelvedereResult r12 = new com.zendesk.belvedere.BelvedereResult     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006d, all -> 0x0066 }
            iz.e r14 = r1.f52895d     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006d, all -> 0x0066 }
            android.content.Context r15 = r1.f52893b     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006d, all -> 0x0066 }
            android.net.Uri r14 = r14.i(r15, r0)     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006d, all -> 0x0066 }
            r12.<init>((java.io.File) r0, (android.net.Uri) r14)     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006d, all -> 0x0066 }
            r6.add(r12)     // Catch:{ FileNotFoundException -> 0x0073, IOException -> 0x006d, all -> 0x0066 }
            goto L_0x00a3
        L_0x0066:
            r0 = move-exception
            r2 = r0
            r16 = r11
            r11 = r13
            goto L_0x0126
        L_0x006d:
            r0 = move-exception
            r16 = r11
            r11 = r13
            goto L_0x00cb
        L_0x0073:
            r0 = move-exception
            r16 = r11
            r11 = r13
            goto L_0x00f4
        L_0x0079:
            iz.b r11 = r1.f52894c     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            java.util.Locale r12 = java.util.Locale.US     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            java.lang.String r15 = "Unable to resolve uri. InputStream null = %s, File null = %s"
            java.lang.Object[] r14 = new java.lang.Object[r14]     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            if (r13 != 0) goto L_0x0086
            r18 = 1
            goto L_0x0088
        L_0x0086:
            r18 = r8
        L_0x0088:
            java.lang.Boolean r18 = java.lang.Boolean.valueOf(r18)     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            r14[r8] = r18     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            if (r0 != 0) goto L_0x0092
            r0 = 1
            goto L_0x0093
        L_0x0092:
            r0 = r8
        L_0x0093:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            r17 = 1
            r14[r17] = r0     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            java.lang.String r0 = java.lang.String.format(r12, r15, r14)     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            r11.w(r5, r0)     // Catch:{ FileNotFoundException -> 0x00be, IOException -> 0x00bb, all -> 0x00b7 }
            r11 = 0
        L_0x00a3:
            if (r13 == 0) goto L_0x00b0
            r13.close()     // Catch:{ IOException -> 0x00a9 }
            goto L_0x00b0
        L_0x00a9:
            r0 = move-exception
            r10 = r0
            iz.b r0 = r1.f52894c
            r0.e(r5, r4, r10)
        L_0x00b0:
            if (r11 == 0) goto L_0x0120
            r11.close()     // Catch:{ IOException -> 0x0119 }
            goto L_0x0120
        L_0x00b7:
            r0 = move-exception
            r2 = r0
            r11 = r13
            goto L_0x00c4
        L_0x00bb:
            r0 = move-exception
            r11 = r13
            goto L_0x00c9
        L_0x00be:
            r0 = move-exception
            r11 = r13
            goto L_0x00f2
        L_0x00c1:
            r0 = move-exception
            r2 = r0
            r11 = 0
        L_0x00c4:
            r16 = 0
            goto L_0x0126
        L_0x00c7:
            r0 = move-exception
            r11 = 0
        L_0x00c9:
            r16 = 0
        L_0x00cb:
            iz.b r12 = r1.f52894c     // Catch:{ all -> 0x0124 }
            java.util.Locale r13 = java.util.Locale.US     // Catch:{ all -> 0x0124 }
            java.lang.String r14 = "IO Error copying file, uri: %s"
            r15 = 1
            java.lang.Object[] r15 = new java.lang.Object[r15]     // Catch:{ all -> 0x0124 }
            r15[r8] = r10     // Catch:{ all -> 0x0124 }
            java.lang.String r10 = java.lang.String.format(r13, r14, r15)     // Catch:{ all -> 0x0124 }
            r12.e(r5, r10, r0)     // Catch:{ all -> 0x0124 }
            if (r11 == 0) goto L_0x00ea
            r11.close()     // Catch:{ IOException -> 0x00e3 }
            goto L_0x00ea
        L_0x00e3:
            r0 = move-exception
            r10 = r0
            iz.b r0 = r1.f52894c
            r0.e(r5, r4, r10)
        L_0x00ea:
            if (r16 == 0) goto L_0x0120
            r16.close()     // Catch:{ IOException -> 0x0119 }
            goto L_0x0120
        L_0x00f0:
            r0 = move-exception
            r11 = 0
        L_0x00f2:
            r16 = 0
        L_0x00f4:
            iz.b r12 = r1.f52894c     // Catch:{ all -> 0x0124 }
            java.util.Locale r13 = java.util.Locale.US     // Catch:{ all -> 0x0124 }
            java.lang.String r14 = "File not found error copying file, uri: %s"
            r15 = 1
            java.lang.Object[] r15 = new java.lang.Object[r15]     // Catch:{ all -> 0x0124 }
            r15[r8] = r10     // Catch:{ all -> 0x0124 }
            java.lang.String r10 = java.lang.String.format(r13, r14, r15)     // Catch:{ all -> 0x0124 }
            r12.e(r5, r10, r0)     // Catch:{ all -> 0x0124 }
            if (r11 == 0) goto L_0x0113
            r11.close()     // Catch:{ IOException -> 0x010c }
            goto L_0x0113
        L_0x010c:
            r0 = move-exception
            r10 = r0
            iz.b r0 = r1.f52894c
            r0.e(r5, r4, r10)
        L_0x0113:
            if (r16 == 0) goto L_0x0120
            r16.close()     // Catch:{ IOException -> 0x0119 }
            goto L_0x0120
        L_0x0119:
            r0 = move-exception
            r10 = r0
            iz.b r0 = r1.f52894c
            r0.e(r5, r3, r10)
        L_0x0120:
            int r9 = r9 + 1
            goto L_0x0012
        L_0x0124:
            r0 = move-exception
            r2 = r0
        L_0x0126:
            if (r11 == 0) goto L_0x0133
            r11.close()     // Catch:{ IOException -> 0x012c }
            goto L_0x0133
        L_0x012c:
            r0 = move-exception
            r6 = r0
            iz.b r0 = r1.f52894c
            r0.e(r5, r4, r6)
        L_0x0133:
            if (r16 == 0) goto L_0x0140
            r16.close()     // Catch:{ IOException -> 0x0139 }
            goto L_0x0140
        L_0x0139:
            r0 = move-exception
            r4 = r0
            iz.b r0 = r1.f52894c
            r0.e(r5, r3, r4)
        L_0x0140:
            throw r2
        L_0x0141:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: iz.c.doInBackground(android.net.Uri[]):java.util.List");
    }

    /* renamed from: b */
    public void onPostExecute(List<BelvedereResult> list) {
        super.onPostExecute(list);
        BelvedereCallback<List<BelvedereResult>> belvedereCallback = this.f52892a;
        if (belvedereCallback != null) {
            belvedereCallback.internalSuccess(list);
        }
    }
}
