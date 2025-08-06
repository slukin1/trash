package com.fluttercandies.photo_manager.core.utils;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.fluttercandies.photo_manager.core.entity.FilterOption;
import com.fluttercandies.photo_manager.core.entity.b;
import com.fluttercandies.photo_manager.core.entity.d;
import com.fluttercandies.photo_manager.core.utils.IDBUtils;
import com.fluttercandies.photo_manager.core.utils.f;
import com.luck.picture.lib.config.SelectMimeType;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.xiaomi.mipush.sdk.Constants;
import d10.l;
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import m1.a;

public final class AndroidQDBUtils implements IDBUtils {

    /* renamed from: b  reason: collision with root package name */
    public static final AndroidQDBUtils f65102b = new AndroidQDBUtils();

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f65103c = {IBridgeMediaLoader.COLUMN_BUCKET_ID, IBridgeMediaLoader.COLUMN_BUCKET_DISPLAY_NAME};

    /* renamed from: d  reason: collision with root package name */
    public static final ReentrantLock f65104d = new ReentrantLock();

    public static /* synthetic */ Uri Q(AndroidQDBUtils androidQDBUtils, b bVar, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = false;
        }
        return androidQDBUtils.P(bVar, z11);
    }

    public static final void R(Ref$ObjectRef<ByteArrayInputStream> ref$ObjectRef, byte[] bArr) {
        ref$ObjectRef.element = new ByteArrayInputStream(bArr);
    }

    public static final void S(Ref$ObjectRef<FileInputStream> ref$ObjectRef, String str) {
        ref$ObjectRef.element = new FileInputStream(str);
    }

    public static final void T(Ref$ObjectRef<FileInputStream> ref$ObjectRef, String str) {
        ref$ObjectRef.element = new FileInputStream(str);
    }

    public final List<String> B() {
        IDBUtils.a aVar = IDBUtils.f65111a;
        return CollectionsKt___CollectionsKt.s0(CollectionsKt___CollectionsKt.s0(CollectionsKt___CollectionsKt.q0(aVar.c(), aVar.d()), aVar.e()), new String[]{"relative_path"});
    }

    public final b C(Cursor cursor) {
        long j11;
        Cursor cursor2 = cursor;
        String u11 = u(cursor2, "_id");
        String u12 = u(cursor2, "_data");
        long s11 = s(cursor2, "datetaken");
        long j12 = 0;
        if (s11 == 0) {
            j11 = s(cursor2, "date_added");
        } else {
            j11 = s11 / ((long) 1000);
        }
        long j13 = j11;
        int I = I(cursor2, MessengerShareContentUtility.MEDIA_TYPE);
        String u13 = u(cursor2, "mime_type");
        if (I != 1) {
            j12 = s(cursor2, IBridgeMediaLoader.COLUMN_DURATION);
        }
        int I2 = I(cursor2, "width");
        int I3 = I(cursor2, "height");
        String u14 = u(cursor2, "_display_name");
        long s12 = s(cursor2, "date_modified");
        int I4 = I(cursor2, "orientation");
        String u15 = u(cursor2, "relative_path");
        if ((I2 == 0 || I3 == 0) && (!StringsKt__StringsJVMKt.z(u12)) && new File(u12).exists()) {
            a aVar = new a(u12);
            String g11 = aVar.g("ImageWidth");
            if (g11 != null) {
                I2 = Integer.parseInt(g11);
            }
            String g12 = aVar.g("ImageLength");
            if (g12 != null) {
                I3 = Integer.parseInt(g12);
            }
        }
        return new b(u11, u12, j12, j13, I2, I3, J(I), u14, s12, I4, (Double) null, (Double) null, u15, u13, 3072, (r) null);
    }

    public int D(int i11) {
        return IDBUtils.DefaultImpls.d(this, i11);
    }

    public final void E(Cursor cursor, int i11, int i12, l<? super Cursor, Unit> lVar) {
        if (!a.c()) {
            cursor.moveToPosition(i11 - 1);
        }
        for (int i13 = 0; i13 < i12; i13++) {
            if (cursor.moveToNext()) {
                lVar.invoke(cursor);
            }
        }
    }

    public String F(int i11, FilterOption filterOption, ArrayList<String> arrayList) {
        return IDBUtils.DefaultImpls.h(this, i11, filterOption, arrayList);
    }

    public String G(ArrayList<String> arrayList, FilterOption filterOption) {
        return IDBUtils.DefaultImpls.i(this, arrayList, filterOption);
    }

    public String H() {
        return IDBUtils.DefaultImpls.k(this);
    }

    public int I(Cursor cursor, String str) {
        return IDBUtils.DefaultImpls.l(this, cursor, str);
    }

    public int J(int i11) {
        return IDBUtils.DefaultImpls.n(this, i11);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0035, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0036, code lost:
        kotlin.io.b.a(r8, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String K(android.content.Context r7, java.lang.String r8) {
        /*
            r6 = this;
            android.content.ContentResolver r0 = r7.getContentResolver()
            android.net.Uri r1 = r6.e()
            java.lang.String r7 = "bucket_id"
            java.lang.String r2 = "relative_path"
            java.lang.String[] r2 = new java.lang.String[]{r7, r2}
            r7 = 1
            java.lang.String[] r4 = new java.lang.String[r7]
            r3 = 0
            r4[r3] = r8
            java.lang.String r3 = "bucket_id = ?"
            r5 = 0
            android.database.Cursor r8 = r0.query(r1, r2, r3, r4, r5)
            r0 = 0
            if (r8 != 0) goto L_0x0021
            return r0
        L_0x0021:
            boolean r1 = r8.moveToNext()     // Catch:{ all -> 0x0033 }
            if (r1 != 0) goto L_0x002b
            kotlin.io.b.a(r8, r0)
            return r0
        L_0x002b:
            java.lang.String r7 = r8.getString(r7)     // Catch:{ all -> 0x0033 }
            kotlin.io.b.a(r8, r0)
            return r7
        L_0x0033:
            r7 = move-exception
            throw r7     // Catch:{ all -> 0x0035 }
        L_0x0035:
            r0 = move-exception
            kotlin.io.b.a(r8, r7)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.utils.AndroidQDBUtils.K(android.content.Context, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0048, code lost:
        kotlin.io.b.a(r9, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004b, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public kotlin.Pair<java.lang.String, java.lang.String> L(android.content.Context r8, java.lang.String r9) {
        /*
            r7 = this;
            android.content.ContentResolver r0 = r8.getContentResolver()
            android.net.Uri r1 = r7.e()
            java.lang.String r8 = "bucket_id"
            java.lang.String r2 = "relative_path"
            java.lang.String[] r2 = new java.lang.String[]{r8, r2}
            r8 = 1
            java.lang.String[] r4 = new java.lang.String[r8]
            r6 = 0
            r4[r6] = r9
            java.lang.String r3 = "_id = ?"
            r5 = 0
            android.database.Cursor r9 = r0.query(r1, r2, r3, r4, r5)
            r0 = 0
            if (r9 != 0) goto L_0x0021
            return r0
        L_0x0021:
            boolean r1 = r9.moveToNext()     // Catch:{ all -> 0x0045 }
            if (r1 != 0) goto L_0x002b
            kotlin.io.b.a(r9, r0)
            return r0
        L_0x002b:
            java.lang.String r1 = r9.getString(r6)     // Catch:{ all -> 0x0045 }
            java.lang.String r8 = r9.getString(r8)     // Catch:{ all -> 0x0045 }
            kotlin.Pair r2 = new kotlin.Pair     // Catch:{ all -> 0x0045 }
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0045 }
            r3.<init>(r8)     // Catch:{ all -> 0x0045 }
            java.lang.String r8 = r3.getParent()     // Catch:{ all -> 0x0045 }
            r2.<init>(r1, r8)     // Catch:{ all -> 0x0045 }
            kotlin.io.b.a(r9, r0)
            return r2
        L_0x0045:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0047 }
        L_0x0047:
            r0 = move-exception
            kotlin.io.b.a(r9, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.utils.AndroidQDBUtils.L(android.content.Context, java.lang.String):kotlin.Pair");
    }

    public String M(int i11, int i12, FilterOption filterOption) {
        if (a.c()) {
            return IDBUtils.DefaultImpls.q(this, i11, i12, filterOption);
        }
        return filterOption.g();
    }

    public String N(Cursor cursor, String str) {
        return IDBUtils.DefaultImpls.s(this, cursor, str);
    }

    public int O(int i11) {
        return IDBUtils.DefaultImpls.t(this, i11);
    }

    public final Uri P(b bVar, boolean z11) {
        return j(bVar.e(), bVar.m(), z11);
    }

    public String U(Integer num, FilterOption filterOption) {
        return IDBUtils.DefaultImpls.z(this, num, filterOption);
    }

    public Void V(String str) {
        return IDBUtils.DefaultImpls.A(this, str);
    }

    public boolean a(Context context) {
        Throwable th2;
        boolean z11;
        ReentrantLock reentrantLock = f65104d;
        if (reentrantLock.isLocked()) {
            Log.i("PhotoManagerPlugin", "The removeAllExistsAssets is running.");
            return false;
        }
        reentrantLock.lock();
        try {
            Log.i("PhotoManagerPlugin", "The removeAllExistsAssets is starting.");
            ArrayList arrayList = new ArrayList();
            ContentResolver contentResolver = context.getContentResolver();
            Uri e11 = f65102b.e();
            String[] strArr = {"_id", MessengerShareContentUtility.MEDIA_TYPE, "_data"};
            Integer[] numArr = {2, 3, 1};
            ArrayList arrayList2 = new ArrayList(3);
            for (int i11 = 0; i11 < 3; i11++) {
                arrayList2.add(String.valueOf(numArr[i11].intValue()));
            }
            Cursor query = contentResolver.query(e11, strArr, "media_type in ( ?,?,? )", (String[]) arrayList2.toArray(new String[0]), (String) null);
            if (query == null) {
                return false;
            }
            int i12 = 0;
            while (query.moveToNext()) {
                try {
                    AndroidQDBUtils androidQDBUtils = f65102b;
                    String u11 = androidQDBUtils.u(query, "_id");
                    int I = androidQDBUtils.I(query, MessengerShareContentUtility.MEDIA_TYPE);
                    String N = androidQDBUtils.N(query, "_data");
                    try {
                        InputStream openInputStream = contentResolver.openInputStream(IDBUtils.DefaultImpls.w(androidQDBUtils, u11, androidQDBUtils.O(I), false, 4, (Object) null));
                        if (openInputStream != null) {
                            openInputStream.close();
                        }
                        z11 = true;
                    } catch (Exception unused) {
                        z11 = false;
                    }
                    if (!z11) {
                        arrayList.add(u11);
                        Log.i("PhotoManagerPlugin", "The " + u11 + ", " + N + " media was not exists. ");
                    }
                    i12++;
                    if (i12 % 300 == 0) {
                        Log.i("PhotoManagerPlugin", "Current checked count == " + i12);
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    kotlin.io.b.a(query, th2);
                    throw th4;
                }
            }
            Log.i("PhotoManagerPlugin", "The removeAllExistsAssets was stopped, will be delete ids = " + arrayList);
            kotlin.io.b.a(query, (Throwable) null);
            String k02 = CollectionsKt___CollectionsKt.k0(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, AndroidQDBUtils$removeAllExistsAssets$1$idWhere$1.INSTANCE, 30, (Object) null);
            int delete = contentResolver.delete(f65102b.e(), "_id in ( " + k02 + " )", (String[]) arrayList.toArray(new String[0]));
            StringBuilder sb2 = new StringBuilder();
            sb2.append("Delete rows: ");
            sb2.append(delete);
            Log.i("PhotoManagerPlugin", sb2.toString());
            reentrantLock.unlock();
            return true;
        } finally {
            reentrantLock.unlock();
        }
    }

    public void b() {
        IDBUtils.DefaultImpls.b(this);
    }

    public List<String> c(Context context, List<String> list) {
        return IDBUtils.DefaultImpls.g(this, context, list);
    }

    public b d(Context context, String str, String str2) {
        Throwable th2;
        Throwable th3;
        Context context2 = context;
        String str3 = str;
        String str4 = str2;
        Pair<String, String> L = L(context, str);
        if (L == null) {
            V("Cannot get gallery id of " + str3);
            throw new KotlinNothingValueException();
        } else if (!x.b(str4, L.component1())) {
            b w11 = w(context, str);
            if (w11 != null) {
                ArrayList g11 = CollectionsKt__CollectionsKt.g("_display_name", "title", "date_added", "date_modified", "datetaken", IBridgeMediaLoader.COLUMN_DURATION, "width", "height", "orientation");
                int D = D(w11.m());
                if (D == 3) {
                    g11.add("description");
                }
                ContentResolver contentResolver = context.getContentResolver();
                ContentResolver contentResolver2 = contentResolver;
                Cursor query = contentResolver2.query(e(), (String[]) ArraysKt___ArraysJvmKt.u(g11.toArray(new String[0]), new String[]{"relative_path"}), H(), new String[]{str3}, (String) null);
                if (query == null) {
                    V("Cannot find asset.");
                    throw new KotlinNothingValueException();
                } else if (query.moveToNext()) {
                    Uri c11 = c.f65119a.c(D);
                    String K = K(context2, str4);
                    ContentValues contentValues = new ContentValues();
                    Iterator it2 = g11.iterator();
                    while (it2.hasNext()) {
                        String str5 = (String) it2.next();
                        contentValues.put(str5, f65102b.u(query, str5));
                    }
                    contentValues.put(MessengerShareContentUtility.MEDIA_TYPE, Integer.valueOf(D));
                    contentValues.put("relative_path", K);
                    Uri insert = contentResolver.insert(c11, contentValues);
                    if (insert != null) {
                        OutputStream openOutputStream = contentResolver.openOutputStream(insert);
                        if (openOutputStream != null) {
                            Uri P = P(w11, true);
                            InputStream openInputStream = contentResolver.openInputStream(P);
                            if (openInputStream != null) {
                                try {
                                    kotlin.io.a.b(openInputStream, openOutputStream, 0, 2, (Object) null);
                                    try {
                                        kotlin.io.b.a(openOutputStream, (Throwable) null);
                                        kotlin.io.b.a(openInputStream, (Throwable) null);
                                        query.close();
                                        String lastPathSegment = insert.getLastPathSegment();
                                        if (lastPathSegment != null) {
                                            return w(context2, lastPathSegment);
                                        }
                                        V("Cannot open output stream for " + insert + '.');
                                        throw new KotlinNothingValueException();
                                    } catch (Throwable th4) {
                                        Throwable th5 = th4;
                                        kotlin.io.b.a(openInputStream, th3);
                                        throw th5;
                                    }
                                } catch (Throwable th6) {
                                    Throwable th7 = th6;
                                    kotlin.io.b.a(openOutputStream, th2);
                                    throw th7;
                                }
                            } else {
                                V("Cannot open input stream for " + P);
                                throw new KotlinNothingValueException();
                            }
                        } else {
                            V("Cannot open output stream for " + insert + '.');
                            throw new KotlinNothingValueException();
                        }
                    } else {
                        V("Cannot insert new asset.");
                        throw new KotlinNothingValueException();
                    }
                } else {
                    V("Cannot find asset.");
                    throw new KotlinNothingValueException();
                }
            } else {
                V("No copy required, because the target gallery is the same as the current one.");
                throw new KotlinNothingValueException();
            }
        } else {
            V("No copy required, because the target gallery is the same as the current one.");
            throw new KotlinNothingValueException();
        }
    }

    public Uri e() {
        return IDBUtils.DefaultImpls.f(this);
    }

    public void f(Context context) {
        IDBUtils.DefaultImpls.c(this, context);
    }

    public void g(Context context, d dVar) {
        IDBUtils.DefaultImpls.x(this, context, dVar);
    }

    public void h(Context context, String str) {
        IDBUtils.DefaultImpls.y(this, context, str);
    }

    public String i(Context context, String str, int i11) {
        return IDBUtils.DefaultImpls.o(this, context, str, i11);
    }

    public Uri j(String str, int i11, boolean z11) {
        return IDBUtils.DefaultImpls.v(this, str, i11, z11);
    }

    public b k(Context context, String str, String str2, String str3, String str4) {
        Throwable th2;
        String str5 = str;
        String str6 = str2;
        String str7 = str4;
        a.a(str);
        ContentResolver contentResolver = context.getContentResolver();
        long j11 = (long) 1000;
        long currentTimeMillis = System.currentTimeMillis() / j11;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        T fileInputStream = new FileInputStream(str5);
        ref$ObjectRef.element = fileInputStream;
        int b11 = a.b((InputStream) fileInputStream);
        T(ref$ObjectRef, str5);
        String guessContentTypeFromStream = URLConnection.guessContentTypeFromStream((InputStream) ref$ObjectRef.element);
        if (guessContentTypeFromStream == null) {
            guessContentTypeFromStream = "video/" + FilesKt__UtilsKt.g(new File(str5));
        }
        Uri uri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        f.a b12 = f.f65122a.b(str5);
        ContentValues contentValues = new ContentValues();
        contentValues.put(MessengerShareContentUtility.MEDIA_TYPE, 3);
        contentValues.put("_display_name", str6);
        contentValues.put("mime_type", guessContentTypeFromStream);
        contentValues.put("title", str6);
        contentValues.put("description", str3);
        contentValues.put("date_added", Long.valueOf(currentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
        contentValues.put("datetaken", Long.valueOf(currentTimeMillis * j11));
        contentValues.put("_display_name", str6);
        contentValues.put(IBridgeMediaLoader.COLUMN_DURATION, b12.a());
        contentValues.put("width", b12.c());
        contentValues.put("height", b12.b());
        contentValues.put("orientation", Integer.valueOf(b11));
        if (str7 != null) {
            contentValues.put("relative_path", str7);
        }
        Uri insert = contentResolver.insert(uri, contentValues);
        if (insert == null) {
            return null;
        }
        OutputStream openOutputStream = contentResolver.openOutputStream(insert);
        if (openOutputStream != null) {
            try {
                th = (Closeable) ref$ObjectRef.element;
                try {
                    kotlin.io.a.b((FileInputStream) th, openOutputStream, 0, 2, (Object) null);
                    kotlin.io.b.a(th, (Throwable) null);
                    kotlin.io.b.a(openOutputStream, (Throwable) null);
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    kotlin.io.b.a(th, th2);
                    throw th4;
                }
            } finally {
                Closeable closeable = th;
                try {
                } catch (Throwable th5) {
                    Throwable th6 = th5;
                    kotlin.io.b.a(openOutputStream, closeable);
                    throw th6;
                }
            }
        }
        contentResolver.notifyChange(insert, (ContentObserver) null);
        return w(context, String.valueOf(ContentUris.parseId(insert)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00af, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b0, code lost:
        kotlin.io.b.a(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b3, code lost:
        throw r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.fluttercandies.photo_manager.core.entity.b> l(android.content.Context r10, java.lang.String r11, int r12, int r13, int r14, com.fluttercandies.photo_manager.core.entity.FilterOption r15) {
        /*
            r9 = this;
            int r0 = r11.length()
            r1 = 0
            if (r0 != 0) goto L_0x0009
            r0 = 1
            goto L_0x000a
        L_0x0009:
            r0 = r1
        L_0x000a:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.net.Uri r4 = r9.e()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            if (r0 != 0) goto L_0x001d
            r3.add(r11)
        L_0x001d:
            java.lang.String r11 = r9.F(r14, r15, r3)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            java.lang.String r14 = r9.U(r14, r15)
            java.lang.String r5 = r9.G(r3, r15)
            java.util.List r6 = r9.B()
            java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.S(r6)
            java.lang.String[] r7 = new java.lang.String[r1]
            java.lang.Object[] r6 = r6.toArray(r7)
            java.lang.String[] r6 = (java.lang.String[]) r6
            r7 = 32
            if (r0 == 0) goto L_0x005f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r8 = "bucket_id IS NOT NULL "
            r0.append(r8)
            r0.append(r11)
            r0.append(r7)
            r0.append(r5)
            r0.append(r7)
            r0.append(r14)
            java.lang.String r11 = r0.toString()
            goto L_0x007c
        L_0x005f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r8 = "bucket_id = ? "
            r0.append(r8)
            r0.append(r11)
            r0.append(r7)
            r0.append(r5)
            r0.append(r7)
            r0.append(r14)
            java.lang.String r11 = r0.toString()
        L_0x007c:
            int r13 = r13 - r12
            java.lang.String r8 = r9.M(r12, r13, r15)
            android.content.ContentResolver r10 = r10.getContentResolver()
            java.lang.String[] r14 = new java.lang.String[r1]
            java.lang.Object[] r14 = r3.toArray(r14)
            r7 = r14
            java.lang.String[] r7 = (java.lang.String[]) r7
            r3 = r10
            r5 = r6
            r6 = r11
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)
            if (r10 != 0) goto L_0x009c
            java.util.List r10 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            return r10
        L_0x009c:
            r11 = 0
            com.fluttercandies.photo_manager.core.utils.AndroidQDBUtils r14 = f65102b     // Catch:{ all -> 0x00ad }
            com.fluttercandies.photo_manager.core.utils.AndroidQDBUtils$getAssetFromGalleryIdRange$1$1 r15 = new com.fluttercandies.photo_manager.core.utils.AndroidQDBUtils$getAssetFromGalleryIdRange$1$1     // Catch:{ all -> 0x00ad }
            r15.<init>(r2, r10)     // Catch:{ all -> 0x00ad }
            r14.E(r10, r12, r13, r15)     // Catch:{ all -> 0x00ad }
            kotlin.Unit r12 = kotlin.Unit.f56620a     // Catch:{ all -> 0x00ad }
            kotlin.io.b.a(r10, r11)
            return r2
        L_0x00ad:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x00af }
        L_0x00af:
            r12 = move-exception
            kotlin.io.b.a(r10, r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.utils.AndroidQDBUtils.l(android.content.Context, java.lang.String, int, int, int, com.fluttercandies.photo_manager.core.entity.FilterOption):java.util.List");
    }

    /* JADX INFO: finally extract failed */
    public List<d> m(Context context, int i11, FilterOption filterOption) {
        Throwable th2;
        FilterOption filterOption2 = filterOption;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        String F = F(i11, filterOption2, arrayList2);
        String G = G(arrayList2, filterOption2);
        String U = U(Integer.valueOf(i11), filterOption2);
        Cursor query = context.getContentResolver().query(e(), f65103c, "bucket_id IS NOT NULL " + F + ' ' + G + ' ' + U, (String[]) arrayList2.toArray(new String[0]), filterOption.g());
        if (query == null) {
            return arrayList;
        }
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        try {
            z4.a.f(query, IBridgeMediaLoader.COLUMN_BUCKET_ID);
            while (query.moveToNext()) {
                AndroidQDBUtils androidQDBUtils = f65102b;
                String u11 = androidQDBUtils.u(query, IBridgeMediaLoader.COLUMN_BUCKET_ID);
                if (hashMap.containsKey(u11)) {
                    hashMap2.put(u11, Integer.valueOf(((Number) hashMap2.get(u11)).intValue() + 1));
                } else {
                    hashMap.put(u11, androidQDBUtils.u(query, IBridgeMediaLoader.COLUMN_BUCKET_DISPLAY_NAME));
                    hashMap2.put(u11, 1);
                }
            }
            Unit unit = Unit.f56620a;
            kotlin.io.b.a(query, (Throwable) null);
            for (Map.Entry entry : hashMap.entrySet()) {
                String str = (String) entry.getKey();
                d dVar = new d(str, (String) entry.getValue(), ((Number) hashMap2.get(str)).intValue(), i11, false, (Long) null, 32, (r) null);
                if (filterOption.b()) {
                    f65102b.g(context, dVar);
                } else {
                    Context context2 = context;
                }
                arrayList.add(dVar);
            }
            return arrayList;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            kotlin.io.b.a(query, th2);
            throw th4;
        }
    }

    public Long n(Context context, String str) {
        return IDBUtils.DefaultImpls.p(this, context, str);
    }

    public b o(Context context, byte[] bArr, String str, String str2, String str3) {
        Pair pair;
        String str4;
        Throwable th2;
        byte[] bArr2 = bArr;
        String str5 = str;
        String str6 = str3;
        try {
            Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr2, 0, bArr2.length);
            pair = new Pair(Integer.valueOf(decodeByteArray.getWidth()), Integer.valueOf(decodeByteArray.getHeight()));
        } catch (Exception unused) {
            pair = new Pair(0, 0);
        }
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        T byteArrayInputStream = new ByteArrayInputStream(bArr2);
        ref$ObjectRef.element = byteArrayInputStream;
        int b11 = a.b((InputStream) byteArrayInputStream);
        R(ref$ObjectRef, bArr2);
        if (StringsKt__StringsKt.R(str5, InstructionFileId.DOT, false, 2, (Object) null)) {
            str4 = "image/" + FilesKt__UtilsKt.g(new File(str5));
        } else {
            str4 = URLConnection.guessContentTypeFromStream((InputStream) ref$ObjectRef.element);
            if (str4 == null) {
                str4 = SelectMimeType.SYSTEM_IMAGE;
            }
        }
        long j11 = (long) 1000;
        long currentTimeMillis = System.currentTimeMillis() / j11;
        ContentValues contentValues = new ContentValues();
        contentValues.put(MessengerShareContentUtility.MEDIA_TYPE, 1);
        contentValues.put("_display_name", str5);
        contentValues.put("mime_type", str4);
        contentValues.put("title", str5);
        contentValues.put("description", str2);
        contentValues.put("date_added", Long.valueOf(currentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
        contentValues.put("datetaken", Long.valueOf(currentTimeMillis * j11));
        contentValues.put("width", Integer.valueOf(intValue));
        contentValues.put("height", Integer.valueOf(intValue2));
        contentValues.put("orientation", Integer.valueOf(b11));
        if (str6 != null) {
            contentValues.put("relative_path", str6);
        }
        ContentResolver contentResolver = context.getContentResolver();
        Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (insert == null) {
            return null;
        }
        OutputStream openOutputStream = contentResolver.openOutputStream(insert);
        if (openOutputStream != null) {
            try {
                th = (Closeable) ref$ObjectRef.element;
                try {
                    kotlin.io.a.b((ByteArrayInputStream) th, openOutputStream, 0, 2, (Object) null);
                    kotlin.io.b.a(th, (Throwable) null);
                    kotlin.io.b.a(openOutputStream, (Throwable) null);
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    kotlin.io.b.a(th, th2);
                    throw th4;
                }
            } finally {
                Closeable closeable = th;
                try {
                } catch (Throwable th5) {
                    Throwable th6 = th5;
                    kotlin.io.b.a(openOutputStream, closeable);
                    throw th6;
                }
            }
        }
        contentResolver.notifyChange(insert, (ContentObserver) null);
        return w(context, String.valueOf(ContentUris.parseId(insert)));
    }

    public b p(Context context, String str, String str2, String str3, String str4) {
        Pair pair;
        Throwable th2;
        String str5 = str;
        String str6 = str2;
        String str7 = str4;
        a.a(str);
        ContentResolver contentResolver = context.getContentResolver();
        long j11 = (long) 1000;
        long currentTimeMillis = System.currentTimeMillis() / j11;
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new FileInputStream(str5);
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            pair = new Pair(Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight()));
        } catch (Exception unused) {
            pair = new Pair(0, 0);
        }
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        int b11 = a.b((InputStream) ref$ObjectRef.element);
        S(ref$ObjectRef, str5);
        String guessContentTypeFromStream = URLConnection.guessContentTypeFromStream((InputStream) ref$ObjectRef.element);
        if (guessContentTypeFromStream == null) {
            guessContentTypeFromStream = "image/" + FilesKt__UtilsKt.g(new File(str5));
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MessengerShareContentUtility.MEDIA_TYPE, 1);
        contentValues.put("_display_name", str6);
        contentValues.put("mime_type", guessContentTypeFromStream);
        contentValues.put("title", str6);
        contentValues.put("description", str3);
        contentValues.put("date_added", Long.valueOf(currentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
        contentValues.put("datetaken", Long.valueOf(currentTimeMillis * j11));
        contentValues.put("_display_name", str6);
        contentValues.put(IBridgeMediaLoader.COLUMN_DURATION, 0);
        contentValues.put("width", Integer.valueOf(intValue));
        contentValues.put("height", Integer.valueOf(intValue2));
        contentValues.put("orientation", Integer.valueOf(b11));
        if (str7 != null) {
            contentValues.put("relative_path", str7);
        }
        Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (insert == null) {
            return null;
        }
        OutputStream openOutputStream = contentResolver.openOutputStream(insert);
        if (openOutputStream != null) {
            try {
                th = (Closeable) ref$ObjectRef.element;
                try {
                    kotlin.io.a.b((FileInputStream) th, openOutputStream, 0, 2, (Object) null);
                    kotlin.io.b.a(th, (Throwable) null);
                    kotlin.io.b.a(openOutputStream, (Throwable) null);
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    kotlin.io.b.a(th, th2);
                    throw th4;
                }
            } finally {
                Closeable closeable = th;
                try {
                } catch (Throwable th5) {
                    Throwable th6 = th5;
                    kotlin.io.b.a(openOutputStream, closeable);
                    throw th6;
                }
            }
        }
        contentResolver.notifyChange(insert, (ContentObserver) null);
        return w(context, String.valueOf(ContentUris.parseId(insert)));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:23:0x00af, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b0, code lost:
        kotlin.io.b.a(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b3, code lost:
        throw r12;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.fluttercandies.photo_manager.core.entity.b> q(android.content.Context r10, java.lang.String r11, int r12, int r13, int r14, com.fluttercandies.photo_manager.core.entity.FilterOption r15) {
        /*
            r9 = this;
            int r0 = r11.length()
            r1 = 0
            if (r0 != 0) goto L_0x0009
            r0 = 1
            goto L_0x000a
        L_0x0009:
            r0 = r1
        L_0x000a:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            android.net.Uri r4 = r9.e()
            java.util.ArrayList r3 = new java.util.ArrayList
            r3.<init>()
            if (r0 != 0) goto L_0x001d
            r3.add(r11)
        L_0x001d:
            java.lang.String r11 = r9.F(r14, r15, r3)
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            java.lang.String r14 = r9.U(r14, r15)
            java.lang.String r5 = r9.G(r3, r15)
            java.util.List r6 = r9.B()
            java.util.List r6 = kotlin.collections.CollectionsKt___CollectionsKt.S(r6)
            java.lang.String[] r7 = new java.lang.String[r1]
            java.lang.Object[] r6 = r6.toArray(r7)
            java.lang.String[] r6 = (java.lang.String[]) r6
            r7 = 32
            if (r0 == 0) goto L_0x005f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r8 = "bucket_id IS NOT NULL "
            r0.append(r8)
            r0.append(r11)
            r0.append(r7)
            r0.append(r5)
            r0.append(r7)
            r0.append(r14)
            java.lang.String r11 = r0.toString()
            goto L_0x007c
        L_0x005f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r8 = "bucket_id = ? "
            r0.append(r8)
            r0.append(r11)
            r0.append(r7)
            r0.append(r5)
            r0.append(r7)
            r0.append(r14)
            java.lang.String r11 = r0.toString()
        L_0x007c:
            int r12 = r12 * r13
            java.lang.String r8 = r9.M(r12, r13, r15)
            android.content.ContentResolver r10 = r10.getContentResolver()
            java.lang.String[] r14 = new java.lang.String[r1]
            java.lang.Object[] r14 = r3.toArray(r14)
            r7 = r14
            java.lang.String[] r7 = (java.lang.String[]) r7
            r3 = r10
            r5 = r6
            r6 = r11
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)
            if (r10 != 0) goto L_0x009c
            java.util.List r10 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            return r10
        L_0x009c:
            r11 = 0
            com.fluttercandies.photo_manager.core.utils.AndroidQDBUtils r14 = f65102b     // Catch:{ all -> 0x00ad }
            com.fluttercandies.photo_manager.core.utils.AndroidQDBUtils$getAssetFromGalleryId$1$1 r15 = new com.fluttercandies.photo_manager.core.utils.AndroidQDBUtils$getAssetFromGalleryId$1$1     // Catch:{ all -> 0x00ad }
            r15.<init>(r10, r2)     // Catch:{ all -> 0x00ad }
            r14.E(r10, r12, r13, r15)     // Catch:{ all -> 0x00ad }
            kotlin.Unit r12 = kotlin.Unit.f56620a     // Catch:{ all -> 0x00ad }
            kotlin.io.b.a(r10, r11)
            return r2
        L_0x00ad:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x00af }
        L_0x00af:
            r12 = move-exception
            kotlin.io.b.a(r10, r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.utils.AndroidQDBUtils.q(android.content.Context, java.lang.String, int, int, int, com.fluttercandies.photo_manager.core.entity.FilterOption):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0076, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0077, code lost:
        kotlin.io.b.a(r13, r14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x007a, code lost:
        throw r15;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.fluttercandies.photo_manager.core.entity.d> r(android.content.Context r13, int r14, com.fluttercandies.photo_manager.core.entity.FilterOption r15) {
        /*
            r12 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = r12.F(r14, r15, r1)
            java.lang.String r3 = r12.G(r1, r15)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r14)
            java.lang.String r4 = r12.U(r4, r15)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "bucket_id IS NOT NULL "
            r5.append(r6)
            r5.append(r2)
            r2 = 32
            r5.append(r2)
            r5.append(r3)
            r5.append(r2)
            r5.append(r4)
            java.lang.String r9 = r5.toString()
            android.content.ContentResolver r6 = r13.getContentResolver()
            android.net.Uri r7 = r12.e()
            java.lang.String[] r8 = f65103c
            r13 = 0
            java.lang.String[] r13 = new java.lang.String[r13]
            java.lang.Object[] r13 = r1.toArray(r13)
            r10 = r13
            java.lang.String[] r10 = (java.lang.String[]) r10
            java.lang.String r11 = r15.g()
            android.database.Cursor r13 = r6.query(r7, r8, r9, r10, r11)
            if (r13 != 0) goto L_0x0058
            return r0
        L_0x0058:
            r15 = 0
            int r4 = r13.getCount()     // Catch:{ all -> 0x0074 }
            com.fluttercandies.photo_manager.core.entity.d r10 = new com.fluttercandies.photo_manager.core.entity.d     // Catch:{ all -> 0x0074 }
            java.lang.String r2 = "isAll"
            java.lang.String r3 = "Recent"
            r6 = 1
            r7 = 0
            r8 = 32
            r9 = 0
            r1 = r10
            r5 = r14
            r1.<init>(r2, r3, r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x0074 }
            r0.add(r10)     // Catch:{ all -> 0x0074 }
            kotlin.io.b.a(r13, r15)
            return r0
        L_0x0074:
            r14 = move-exception
            throw r14     // Catch:{ all -> 0x0076 }
        L_0x0076:
            r15 = move-exception
            kotlin.io.b.a(r13, r14)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.utils.AndroidQDBUtils.r(android.content.Context, int, com.fluttercandies.photo_manager.core.entity.FilterOption):java.util.List");
    }

    public long s(Cursor cursor, String str) {
        return IDBUtils.DefaultImpls.m(this, cursor, str);
    }

    public boolean t(Context context, String str) {
        return IDBUtils.DefaultImpls.e(this, context, str);
    }

    public String u(Cursor cursor, String str) {
        return IDBUtils.DefaultImpls.r(this, cursor, str);
    }

    public String v(Context context, String str, boolean z11) {
        b w11 = w(context, str);
        if (w11 == null) {
            return null;
        }
        return w11.k();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x003f, code lost:
        kotlin.io.b.a(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0042, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fluttercandies.photo_manager.core.entity.b w(android.content.Context r9, java.lang.String r10) {
        /*
            r8 = this;
            java.util.List r0 = r8.B()
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.S(r0)
            r1 = 0
            java.lang.String[] r2 = new java.lang.String[r1]
            java.lang.Object[] r0 = r0.toArray(r2)
            r4 = r0
            java.lang.String[] r4 = (java.lang.String[]) r4
            r0 = 1
            java.lang.String[] r6 = new java.lang.String[r0]
            r6[r1] = r10
            android.content.ContentResolver r2 = r9.getContentResolver()
            android.net.Uri r3 = r8.e()
            java.lang.String r5 = "_id = ?"
            r7 = 0
            android.database.Cursor r9 = r2.query(r3, r4, r5, r6, r7)
            r10 = 0
            if (r9 != 0) goto L_0x002a
            return r10
        L_0x002a:
            boolean r0 = r9.moveToNext()     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0037
            com.fluttercandies.photo_manager.core.utils.AndroidQDBUtils r0 = f65102b     // Catch:{ all -> 0x003c }
            com.fluttercandies.photo_manager.core.entity.b r0 = r0.C(r9)     // Catch:{ all -> 0x003c }
            goto L_0x0038
        L_0x0037:
            r0 = r10
        L_0x0038:
            kotlin.io.b.a(r9, r10)
            return r0
        L_0x003c:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x003e }
        L_0x003e:
            r0 = move-exception
            kotlin.io.b.a(r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.utils.AndroidQDBUtils.w(android.content.Context, java.lang.String):com.fluttercandies.photo_manager.core.entity.b");
    }

    public d x(Context context, String str, int i11, FilterOption filterOption) {
        String str2;
        Throwable th2;
        String str3;
        String str4 = str;
        FilterOption filterOption2 = filterOption;
        Uri e11 = e();
        String[] b11 = IDBUtils.f65111a.b();
        boolean b12 = x.b(str4, "");
        ArrayList arrayList = new ArrayList();
        String F = F(i11, filterOption2, arrayList);
        String G = G(arrayList, filterOption2);
        if (b12) {
            str2 = "";
        } else {
            arrayList.add(str4);
            str2 = "AND bucket_id = ?";
        }
        String U = U((Integer) null, filterOption2);
        Cursor query = context.getContentResolver().query(e11, b11, "bucket_id IS NOT NULL " + F + ' ' + G + ' ' + str2 + ' ' + U, (String[]) arrayList.toArray(new String[0]), (String) null);
        if (query == null) {
            return null;
        }
        try {
            if (query.moveToNext()) {
                String string = query.getString(1);
                if (string == null) {
                    str3 = "";
                } else {
                    str3 = string;
                }
                int count = query.getCount();
                Unit unit = Unit.f56620a;
                kotlin.io.b.a(query, (Throwable) null);
                return new d(str, str3, count, i11, b12, (Long) null, 32, (r) null);
            }
            kotlin.io.b.a(query, (Throwable) null);
            return null;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            kotlin.io.b.a(query, th2);
            throw th4;
        }
    }

    public a y(Context context, String str) {
        InputStream openInputStream;
        try {
            b w11 = w(context, str);
            if (w11 == null || (openInputStream = context.getContentResolver().openInputStream(MediaStore.setRequireOriginal(Q(this, w11, false, 2, (Object) null)))) == null) {
                return null;
            }
            return new a(openInputStream);
        } catch (Exception unused) {
            return null;
        }
    }

    public b z(Context context, String str, String str2) {
        Pair<String, String> L = L(context, str);
        if (L == null) {
            V("Cannot get gallery id of " + str);
            throw new KotlinNothingValueException();
        } else if (!x.b(str2, L.component1())) {
            ContentResolver contentResolver = context.getContentResolver();
            String K = K(context, str2);
            ContentValues contentValues = new ContentValues();
            contentValues.put("relative_path", K);
            if (contentResolver.update(e(), contentValues, H(), new String[]{str}) > 0) {
                return w(context, str);
            }
            V("Cannot update " + str + " relativePath");
            throw new KotlinNothingValueException();
        } else {
            V("No move required, because the target gallery is the same as the current one.");
            throw new KotlinNothingValueException();
        }
    }
}
