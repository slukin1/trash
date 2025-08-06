package com.fluttercandies.photo_manager.core;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.provider.MediaStore;
import com.facebook.share.internal.ShareConstants;
import com.fluttercandies.photo_manager.core.utils.IDBUtils;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.io.b;
import kotlin.l;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f65038a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f65039b;

    /* renamed from: c  reason: collision with root package name */
    public final a f65040c;

    /* renamed from: d  reason: collision with root package name */
    public final a f65041d;

    /* renamed from: e  reason: collision with root package name */
    public final a f65042e;

    /* renamed from: f  reason: collision with root package name */
    public final Uri f65043f = IDBUtils.f65111a.a();

    /* renamed from: g  reason: collision with root package name */
    public final Uri f65044g = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;

    /* renamed from: h  reason: collision with root package name */
    public final Uri f65045h = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;

    /* renamed from: i  reason: collision with root package name */
    public final Uri f65046i = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;

    /* renamed from: j  reason: collision with root package name */
    public final MethodChannel f65047j;

    public final class a extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public final int f65048a;

        /* renamed from: b  reason: collision with root package name */
        public Uri f65049b = Uri.parse("content://media");

        public a(int i11, Handler handler) {
            super(handler);
            this.f65048a = i11;
        }

        public final Context a() {
            return c.this.b();
        }

        public final ContentResolver b() {
            return a().getContentResolver();
        }

        public final Pair<Long, String> c(long j11, int i11) {
            Throwable th2;
            Throwable th3;
            Throwable th4;
            if (Build.VERSION.SDK_INT >= 29) {
                Cursor query = b().query(c.this.f65043f, new String[]{IBridgeMediaLoader.COLUMN_BUCKET_ID, IBridgeMediaLoader.COLUMN_BUCKET_DISPLAY_NAME}, "_id = ?", new String[]{String.valueOf(j11)}, (String) null);
                if (query != null) {
                    try {
                        if (query.moveToNext()) {
                            long j12 = query.getLong(query.getColumnIndex(IBridgeMediaLoader.COLUMN_BUCKET_ID));
                            Pair<Long, String> pair = new Pair<>(Long.valueOf(j12), query.getString(query.getColumnIndex(IBridgeMediaLoader.COLUMN_BUCKET_DISPLAY_NAME)));
                            b.a(query, (Throwable) null);
                            return pair;
                        }
                        Unit unit = Unit.f56620a;
                        b.a(query, (Throwable) null);
                    } catch (Throwable th5) {
                        Throwable th6 = th5;
                        b.a(query, th4);
                        throw th6;
                    }
                }
            } else if (i11 == 2) {
                Cursor query2 = b().query(c.this.f65043f, new String[]{"album_id", "album"}, "_id = ?", new String[]{String.valueOf(j11)}, (String) null);
                if (query2 != null) {
                    try {
                        if (query2.moveToNext()) {
                            long j13 = query2.getLong(query2.getColumnIndex("album_id"));
                            Pair<Long, String> pair2 = new Pair<>(Long.valueOf(j13), query2.getString(query2.getColumnIndex("album")));
                            b.a(query2, (Throwable) null);
                            return pair2;
                        }
                        Unit unit2 = Unit.f56620a;
                        b.a(query2, (Throwable) null);
                    } catch (Throwable th7) {
                        Throwable th8 = th7;
                        b.a(query2, th3);
                        throw th8;
                    }
                }
            } else {
                Cursor query3 = b().query(c.this.f65043f, new String[]{IBridgeMediaLoader.COLUMN_BUCKET_ID, IBridgeMediaLoader.COLUMN_BUCKET_DISPLAY_NAME}, "_id = ?", new String[]{String.valueOf(j11)}, (String) null);
                if (query3 != null) {
                    try {
                        if (query3.moveToNext()) {
                            long j14 = query3.getLong(query3.getColumnIndex(IBridgeMediaLoader.COLUMN_BUCKET_ID));
                            Pair<Long, String> pair3 = new Pair<>(Long.valueOf(j14), query3.getString(query3.getColumnIndex(IBridgeMediaLoader.COLUMN_BUCKET_DISPLAY_NAME)));
                            b.a(query3, (Throwable) null);
                            return pair3;
                        }
                        Unit unit3 = Unit.f56620a;
                        b.a(query3, (Throwable) null);
                    } catch (Throwable th9) {
                        Throwable th10 = th9;
                        b.a(query3, th2);
                        throw th10;
                    }
                }
            }
            return new Pair<>(null, null);
        }

        public final void d(Uri uri) {
            this.f65049b = uri;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:32:0x009f, code lost:
            r14 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a0, code lost:
            kotlin.io.b.a(r7, r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a3, code lost:
            throw r14;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onChange(boolean r13, android.net.Uri r14) {
            /*
                r12 = this;
                if (r14 != 0) goto L_0x0003
                return
            L_0x0003:
                java.lang.String r13 = r14.getLastPathSegment()
                r0 = 0
                if (r13 == 0) goto L_0x0010
                java.lang.Long r13 = kotlin.text.StringsKt__StringNumberConversionsKt.o(r13)
                r4 = r13
                goto L_0x0011
            L_0x0010:
                r4 = r0
            L_0x0011:
                if (r4 == 0) goto L_0x00a4
                android.content.ContentResolver r5 = r12.b()
                com.fluttercandies.photo_manager.core.c r13 = com.fluttercandies.photo_manager.core.c.this
                android.net.Uri r6 = r13.f65043f
                java.lang.String r13 = "date_added"
                java.lang.String r1 = "date_modified"
                java.lang.String r2 = "media_type"
                java.lang.String[] r7 = new java.lang.String[]{r13, r1, r2}
                r1 = 1
                java.lang.String[] r9 = new java.lang.String[r1]
                r1 = 0
                java.lang.String r3 = r4.toString()
                r9[r1] = r3
                r10 = 0
                java.lang.String r8 = "_id = ?"
                android.database.Cursor r7 = r5.query(r6, r7, r8, r9, r10)
                if (r7 == 0) goto L_0x00cb
                com.fluttercandies.photo_manager.core.c r1 = com.fluttercandies.photo_manager.core.c.this
                boolean r3 = r7.moveToNext()     // Catch:{ all -> 0x009d }
                if (r3 != 0) goto L_0x004f
                java.lang.String r3 = "delete"
                r5 = 0
                int r6 = r12.f65048a     // Catch:{ all -> 0x009d }
                r2 = r14
                r1.d(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x009d }
                kotlin.io.b.a(r7, r0)
                return
            L_0x004f:
                int r13 = r7.getColumnIndex(r13)     // Catch:{ all -> 0x009d }
                long r5 = r7.getLong(r13)     // Catch:{ all -> 0x009d }
                long r8 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x009d }
                r13 = 1000(0x3e8, float:1.401E-42)
                long r10 = (long) r13     // Catch:{ all -> 0x009d }
                long r8 = r8 / r10
                long r8 = r8 - r5
                r5 = 30
                int r13 = (r8 > r5 ? 1 : (r8 == r5 ? 0 : -1))
                if (r13 >= 0) goto L_0x0069
                java.lang.String r13 = "insert"
                goto L_0x006c
            L_0x0069:
                java.lang.String r13 = "update"
            L_0x006c:
                r3 = r13
                int r13 = r7.getColumnIndex(r2)     // Catch:{ all -> 0x009d }
                int r6 = r7.getInt(r13)     // Catch:{ all -> 0x009d }
                long r8 = r4.longValue()     // Catch:{ all -> 0x009d }
                kotlin.Pair r13 = r12.c(r8, r6)     // Catch:{ all -> 0x009d }
                java.lang.Object r2 = r13.component1()     // Catch:{ all -> 0x009d }
                r5 = r2
                java.lang.Long r5 = (java.lang.Long) r5     // Catch:{ all -> 0x009d }
                java.lang.Object r13 = r13.component2()     // Catch:{ all -> 0x009d }
                java.lang.String r13 = (java.lang.String) r13     // Catch:{ all -> 0x009d }
                if (r5 == 0) goto L_0x0099
                if (r13 != 0) goto L_0x008f
                goto L_0x0099
            L_0x008f:
                r2 = r14
                r1.d(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x009d }
                kotlin.Unit r13 = kotlin.Unit.f56620a     // Catch:{ all -> 0x009d }
                kotlin.io.b.a(r7, r0)
                goto L_0x00cb
            L_0x0099:
                kotlin.io.b.a(r7, r0)
                return
            L_0x009d:
                r13 = move-exception
                throw r13     // Catch:{ all -> 0x009f }
            L_0x009f:
                r14 = move-exception
                kotlin.io.b.a(r7, r13)
                throw r14
            L_0x00a4:
                int r13 = android.os.Build.VERSION.SDK_INT
                r0 = 29
                if (r13 >= r0) goto L_0x00bf
                android.net.Uri r13 = r12.f65049b
                boolean r13 = kotlin.jvm.internal.x.b(r14, r13)
                if (r13 == 0) goto L_0x00bf
                com.fluttercandies.photo_manager.core.c r0 = com.fluttercandies.photo_manager.core.c.this
                r3 = 0
                r4 = 0
                int r5 = r12.f65048a
                java.lang.String r2 = "insert"
                r1 = r14
                r0.d(r1, r2, r3, r4, r5)
                return
            L_0x00bf:
                com.fluttercandies.photo_manager.core.c r6 = com.fluttercandies.photo_manager.core.c.this
                r9 = 0
                r10 = 0
                int r11 = r12.f65048a
                java.lang.String r8 = "delete"
                r7 = r14
                r6.d(r7, r8, r9, r10, r11)
            L_0x00cb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.c.a.onChange(boolean, android.net.Uri):void");
        }
    }

    public c(Context context, BinaryMessenger binaryMessenger, Handler handler) {
        this.f65038a = context;
        this.f65040c = new a(3, handler);
        this.f65041d = new a(1, handler);
        this.f65042e = new a(2, handler);
        this.f65047j = new MethodChannel(binaryMessenger, "com.fluttercandies/photo_manager/notify");
    }

    public final Context b() {
        return this.f65038a;
    }

    public final Context c() {
        return this.f65038a;
    }

    public final void d(Uri uri, String str, Long l11, Long l12, int i11) {
        HashMap j11 = MapsKt__MapsKt.j(l.a("platform", "android"), l.a(ShareConstants.MEDIA_URI, String.valueOf(uri)), l.a("type", str), l.a("mediaType", Integer.valueOf(i11)));
        if (l11 != null) {
            j11.put("id", l11);
        }
        if (l12 != null) {
            j11.put("galleryId", l12);
        }
        z4.a.a(j11);
        this.f65047j.invokeMethod("change", j11);
    }

    public final void e(a aVar, Uri uri) {
        c().getContentResolver().registerContentObserver(uri, true, aVar);
        aVar.d(uri);
    }

    public final void f(boolean z11) {
        this.f65047j.invokeMethod("setAndroidQExperimental", MapsKt__MapsJVMKt.e(l.a("open", Boolean.valueOf(z11))));
    }

    public final void g() {
        if (!this.f65039b) {
            e(this.f65041d, this.f65044g);
            e(this.f65040c, this.f65045h);
            e(this.f65042e, this.f65046i);
            this.f65039b = true;
        }
    }

    public final void h() {
        if (this.f65039b) {
            this.f65039b = false;
            c().getContentResolver().unregisterContentObserver(this.f65041d);
            c().getContentResolver().unregisterContentObserver(this.f65040c);
            c().getContentResolver().unregisterContentObserver(this.f65042e);
        }
    }
}
