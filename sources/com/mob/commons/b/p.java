package com.mob.commons.b;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.text.TextUtils;
import com.mob.commons.C0891r;
import com.mob.commons.b.h;
import com.mob.commons.l;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;

public class p extends h {

    /* renamed from: c  reason: collision with root package name */
    private a f27098c = null;

    /* renamed from: d  reason: collision with root package name */
    private String f27099d = "100215079";

    public static class a extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        private int f27100a;

        /* renamed from: b  reason: collision with root package name */
        private p f27101b;

        public a(p pVar, int i11) {
            super((Handler) null);
            this.f27100a = i11;
            this.f27101b = pVar;
        }

        public void onChange(boolean z11) {
            p pVar = this.f27101b;
            if (pVar != null) {
                pVar.a(z11, this.f27100a);
            }
        }
    }

    public p(Context context) {
        super(context);
        if (!TextUtils.isEmpty(C0891r.f27330j)) {
            this.f27099d = C0891r.f27330j;
        }
        NLog instance = MobLog.getInstance();
        instance.d("oamt vivo appid: " + this.f27099d, new Object[0]);
    }

    private void c(int i11) {
        if (i11 == 0 && this.f27098c == null) {
            this.f27098c = new a(this, 0);
            this.f27079a.getContentResolver().registerContentObserver(Uri.parse(b(0)), true, this.f27098c);
        }
    }

    public h.b b() {
        h.b bVar = new h.b();
        bVar.f27087a = a(0);
        return bVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r0 != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
        c(r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x004b, code lost:
        if (r0 != null) goto L_0x003b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x004e, code lost:
        return null;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0033 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:20:0x003e */
    /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0055 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String a(int r9) {
        /*
            r8 = this;
            java.lang.String r0 = r8.b(r9)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            android.net.Uri r3 = android.net.Uri.parse(r0)     // Catch:{ all -> 0x0042 }
            android.content.Context r0 = r8.f27079a     // Catch:{ all -> 0x0042 }
            android.content.ContentResolver r2 = r0.getContentResolver()     // Catch:{ all -> 0x0042 }
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            android.database.Cursor r0 = r2.query(r3, r4, r5, r6, r7)     // Catch:{ all -> 0x0042 }
            if (r0 == 0) goto L_0x0039
            boolean r2 = r0.moveToNext()     // Catch:{ all -> 0x0037 }
            if (r2 == 0) goto L_0x0039
            java.lang.String r2 = "005$ff)fiBfi]h"
            java.lang.String r2 = com.mob.commons.l.a((java.lang.String) r2)     // Catch:{ all -> 0x0037 }
            int r2 = r0.getColumnIndex(r2)     // Catch:{ all -> 0x0037 }
            java.lang.String r1 = r0.getString(r2)     // Catch:{ all -> 0x0037 }
            r0.close()     // Catch:{ all -> 0x0033 }
        L_0x0033:
            r8.c(r9)     // Catch:{ all -> 0x0036 }
        L_0x0036:
            return r1
        L_0x0037:
            r2 = move-exception
            goto L_0x0044
        L_0x0039:
            if (r0 == 0) goto L_0x003e
        L_0x003b:
            r0.close()     // Catch:{ all -> 0x003e }
        L_0x003e:
            r8.c(r9)     // Catch:{ all -> 0x004e }
            goto L_0x004e
        L_0x0042:
            r2 = move-exception
            r0 = r1
        L_0x0044:
            com.mob.tools.log.NLog r3 = com.mob.tools.MobLog.getInstance()     // Catch:{ all -> 0x004f }
            r3.d(r2)     // Catch:{ all -> 0x004f }
            if (r0 == 0) goto L_0x003e
            goto L_0x003b
        L_0x004e:
            return r1
        L_0x004f:
            r1 = move-exception
            if (r0 == 0) goto L_0x0055
            r0.close()     // Catch:{ all -> 0x0055 }
        L_0x0055:
            r8.c(r9)     // Catch:{ all -> 0x0058 }
        L_0x0058:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mob.commons.b.p.a(int):java.lang.String");
    }

    private String b(int i11) {
        if (i11 == 0) {
            return l.a("051eBfm,gkhgkmnneIfmfhfnfffkfffmfnfffhhkfnggfeinflfmfffkfe:h^fl2n3ggfe=hgk)fkghfk@h!flggfe4n1ijhfgghn");
        }
        return null;
    }

    /* access modifiers changed from: private */
    public void a(boolean z11, int i11) {
        try {
            String a11 = a(i11);
            if (i11 == 0) {
                a(a11);
            }
        } catch (Throwable unused) {
        }
    }
}
