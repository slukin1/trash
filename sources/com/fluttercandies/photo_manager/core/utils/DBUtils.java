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
import android.os.Environment;
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
import java.io.ByteArrayInputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.KotlinNothingValueException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class DBUtils implements IDBUtils {

    /* renamed from: b  reason: collision with root package name */
    public static final DBUtils f65105b = new DBUtils();

    /* renamed from: c  reason: collision with root package name */
    public static final String[] f65106c = {"longitude", "latitude"};

    /* renamed from: d  reason: collision with root package name */
    public static final ReentrantLock f65107d = new ReentrantLock();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f65108a;

        /* renamed from: b  reason: collision with root package name */
        public final String f65109b;

        /* renamed from: c  reason: collision with root package name */
        public final String f65110c;

        public a(String str, String str2, String str3) {
            this.f65108a = str;
            this.f65109b = str2;
            this.f65110c = str3;
        }

        public final String a() {
            return this.f65110c;
        }

        public final String b() {
            return this.f65108a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f65108a, aVar.f65108a) && x.b(this.f65109b, aVar.f65109b) && x.b(this.f65110c, aVar.f65110c);
        }

        public int hashCode() {
            return (((this.f65108a.hashCode() * 31) + this.f65109b.hashCode()) * 31) + this.f65110c.hashCode();
        }

        public String toString() {
            return "GalleryInfo(path=" + this.f65108a + ", galleryId=" + this.f65109b + ", galleryName=" + this.f65110c + ')';
        }
    }

    public static final void M(Ref$ObjectRef<ByteArrayInputStream> ref$ObjectRef, byte[] bArr) {
        ref$ObjectRef.element = new ByteArrayInputStream(bArr);
    }

    public static final void N(Ref$ObjectRef<FileInputStream> ref$ObjectRef, File file) {
        ref$ObjectRef.element = new FileInputStream(file);
    }

    public final b A(Cursor cursor, int i11) {
        long j11;
        Cursor cursor2 = cursor;
        String u11 = u(cursor2, "_id");
        String u12 = u(cursor2, "_data");
        long s11 = s(cursor2, "date_added");
        int H = H(cursor2, MessengerShareContentUtility.MEDIA_TYPE);
        if (i11 == 1) {
            j11 = 0;
        } else {
            j11 = s(cursor2, IBridgeMediaLoader.COLUMN_DURATION);
        }
        int H2 = H(cursor2, "width");
        int H3 = H(cursor2, "height");
        String name = new File(u12).getName();
        long s12 = s(cursor2, "date_modified");
        double E = E(cursor2, "latitude");
        double E2 = E(cursor2, "longitude");
        int H4 = H(cursor2, "orientation");
        String u13 = u(cursor2, "mime_type");
        if ((H2 == 0 || H3 == 0) && (true ^ StringsKt__StringsJVMKt.z(u12)) && new File(u12).exists()) {
            m1.a aVar = new m1.a(u12);
            String g11 = aVar.g("ImageWidth");
            if (g11 != null) {
                H2 = Integer.parseInt(g11);
            }
            String g12 = aVar.g("ImageLength");
            if (g12 != null) {
                H3 = Integer.parseInt(g12);
            }
        }
        return new b(u11, u12, j11, s11, H2, H3, I(H), name, s12, H4, Double.valueOf(E), Double.valueOf(E2), (String) null, u13, 4096, (r) null);
    }

    public int B(int i11) {
        return IDBUtils.DefaultImpls.d(this, i11);
    }

    public String C(int i11, FilterOption filterOption, ArrayList<String> arrayList) {
        return IDBUtils.DefaultImpls.h(this, i11, filterOption, arrayList);
    }

    public String D(ArrayList<String> arrayList, FilterOption filterOption) {
        return IDBUtils.DefaultImpls.i(this, arrayList, filterOption);
    }

    public double E(Cursor cursor, String str) {
        return IDBUtils.DefaultImpls.j(this, cursor, str);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0065, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0066, code lost:
        kotlin.io.b.a(r10, r11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0069, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.fluttercandies.photo_manager.core.utils.DBUtils.a F(android.content.Context r10, java.lang.String r11) {
        /*
            r9 = this;
            java.lang.String r0 = "bucket_id"
            java.lang.String r1 = "bucket_display_name"
            java.lang.String r2 = "_data"
            java.lang.String[] r5 = new java.lang.String[]{r0, r1, r2}
            android.content.ContentResolver r3 = r10.getContentResolver()
            android.net.Uri r4 = r9.e()
            r10 = 1
            java.lang.String[] r7 = new java.lang.String[r10]
            r10 = 0
            r7[r10] = r11
            java.lang.String r6 = "bucket_id = ?"
            r8 = 0
            android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)
            r0 = 0
            if (r10 != 0) goto L_0x0023
            return r0
        L_0x0023:
            boolean r3 = r10.moveToNext()     // Catch:{ all -> 0x0063 }
            if (r3 != 0) goto L_0x002d
            kotlin.io.b.a(r10, r0)
            return r0
        L_0x002d:
            com.fluttercandies.photo_manager.core.utils.DBUtils r3 = f65105b     // Catch:{ all -> 0x0063 }
            java.lang.String r2 = r3.L(r10, r2)     // Catch:{ all -> 0x0063 }
            if (r2 != 0) goto L_0x0039
            kotlin.io.b.a(r10, r0)
            return r0
        L_0x0039:
            java.lang.String r1 = r3.L(r10, r1)     // Catch:{ all -> 0x0063 }
            if (r1 != 0) goto L_0x0043
            kotlin.io.b.a(r10, r0)
            return r0
        L_0x0043:
            java.io.File r3 = new java.io.File     // Catch:{ all -> 0x0063 }
            r3.<init>(r2)     // Catch:{ all -> 0x0063 }
            java.io.File r2 = r3.getParentFile()     // Catch:{ all -> 0x0063 }
            if (r2 == 0) goto L_0x0053
            java.lang.String r2 = r2.getAbsolutePath()     // Catch:{ all -> 0x0063 }
            goto L_0x0054
        L_0x0053:
            r2 = r0
        L_0x0054:
            if (r2 != 0) goto L_0x005a
            kotlin.io.b.a(r10, r0)
            return r0
        L_0x005a:
            com.fluttercandies.photo_manager.core.utils.DBUtils$a r3 = new com.fluttercandies.photo_manager.core.utils.DBUtils$a     // Catch:{ all -> 0x0063 }
            r3.<init>(r2, r11, r1)     // Catch:{ all -> 0x0063 }
            kotlin.io.b.a(r10, r0)
            return r3
        L_0x0063:
            r11 = move-exception
            throw r11     // Catch:{ all -> 0x0065 }
        L_0x0065:
            r0 = move-exception
            kotlin.io.b.a(r10, r11)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.utils.DBUtils.F(android.content.Context, java.lang.String):com.fluttercandies.photo_manager.core.utils.DBUtils$a");
    }

    public String G() {
        return IDBUtils.DefaultImpls.k(this);
    }

    public int H(Cursor cursor, String str) {
        return IDBUtils.DefaultImpls.l(this, cursor, str);
    }

    public int I(int i11) {
        return IDBUtils.DefaultImpls.n(this, i11);
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
    public kotlin.Pair<java.lang.String, java.lang.String> J(android.content.Context r8, java.lang.String r9) {
        /*
            r7 = this;
            android.content.ContentResolver r0 = r8.getContentResolver()
            android.net.Uri r1 = r7.e()
            java.lang.String r8 = "bucket_id"
            java.lang.String r2 = "_data"
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
        throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.utils.DBUtils.J(android.content.Context, java.lang.String):kotlin.Pair");
    }

    public String K(int i11, int i12, FilterOption filterOption) {
        return IDBUtils.DefaultImpls.q(this, i11, i12, filterOption);
    }

    public String L(Cursor cursor, String str) {
        return IDBUtils.DefaultImpls.s(this, cursor, str);
    }

    public String O(Integer num, FilterOption filterOption) {
        return IDBUtils.DefaultImpls.z(this, num, filterOption);
    }

    public Void P(String str) {
        return IDBUtils.DefaultImpls.A(this, str);
    }

    public boolean a(Context context) {
        Throwable th2;
        ReentrantLock reentrantLock = f65107d;
        if (reentrantLock.isLocked()) {
            return false;
        }
        reentrantLock.lock();
        try {
            ArrayList arrayList = new ArrayList();
            ContentResolver contentResolver = context.getContentResolver();
            Cursor query = contentResolver.query(f65105b.e(), new String[]{"_id", "_data"}, (String) null, (String[]) null, (String) null);
            if (query == null) {
                return false;
            }
            while (query.moveToNext()) {
                try {
                    DBUtils dBUtils = f65105b;
                    String u11 = dBUtils.u(query, "_id");
                    String u12 = dBUtils.u(query, "_data");
                    if (!new File(u12).exists()) {
                        arrayList.add(u11);
                        Log.i("PhotoManagerPlugin", "The " + u12 + " was not exists. ");
                    }
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    kotlin.io.b.a(query, th2);
                    throw th4;
                }
            }
            Log.i("PhotoManagerPlugin", "will be delete ids = " + arrayList);
            kotlin.io.b.a(query, (Throwable) null);
            String k02 = CollectionsKt___CollectionsKt.k0(arrayList, Constants.ACCEPT_TIME_SEPARATOR_SP, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, DBUtils$removeAllExistsAssets$1$idWhere$1.INSTANCE, 30, (Object) null);
            Uri e11 = f65105b.e();
            int delete = contentResolver.delete(e11, "_id in ( " + k02 + " )", (String[]) arrayList.toArray(new String[0]));
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
        Pair<String, String> J = J(context, str);
        if (J == null) {
            throw new RuntimeException("Cannot get gallery id of " + str3);
        } else if (!x.b(str4, J.component1())) {
            ContentResolver contentResolver = context.getContentResolver();
            b w11 = w(context, str);
            if (w11 != null) {
                ArrayList g11 = CollectionsKt__CollectionsKt.g("_display_name", "title", "date_added", "date_modified", "datetaken", IBridgeMediaLoader.COLUMN_DURATION, "longitude", "latitude", "width", "height");
                int B = B(w11.m());
                if (B != 2) {
                    g11.add("description");
                }
                String str5 = "_data";
                Cursor query = contentResolver.query(e(), (String[]) ArraysKt___ArraysJvmKt.u(g11.toArray(new String[0]), new String[]{"_data"}), G(), new String[]{str3}, (String) null);
                if (query == null) {
                    throw new RuntimeException("Cannot find asset .");
                } else if (query.moveToNext()) {
                    Uri c11 = c.f65119a.c(B);
                    a F = F(context2, str4);
                    if (F != null) {
                        String str6 = F.b() + '/' + w11.b();
                        ContentValues contentValues = new ContentValues();
                        Iterator it2 = g11.iterator();
                        while (it2.hasNext()) {
                            String str7 = (String) it2.next();
                            contentValues.put(str7, f65105b.u(query, str7));
                        }
                        contentValues.put(MessengerShareContentUtility.MEDIA_TYPE, Integer.valueOf(B));
                        contentValues.put(str5, str6);
                        Uri insert = contentResolver.insert(c11, contentValues);
                        if (insert != null) {
                            OutputStream openOutputStream = contentResolver.openOutputStream(insert);
                            if (openOutputStream != null) {
                                FileInputStream fileInputStream = new FileInputStream(new File(w11.k()));
                                try {
                                    kotlin.io.a.b(fileInputStream, openOutputStream, 0, 2, (Object) null);
                                    try {
                                        kotlin.io.b.a(openOutputStream, (Throwable) null);
                                        kotlin.io.b.a(fileInputStream, (Throwable) null);
                                        query.close();
                                        String lastPathSegment = insert.getLastPathSegment();
                                        if (lastPathSegment != null) {
                                            return w(context2, lastPathSegment);
                                        }
                                        throw new RuntimeException("Cannot open output stream for " + insert + '.');
                                    } catch (Throwable th4) {
                                        Throwable th5 = th4;
                                        kotlin.io.b.a(fileInputStream, th3);
                                        throw th5;
                                    }
                                } catch (Throwable th6) {
                                    Throwable th7 = th6;
                                    kotlin.io.b.a(openOutputStream, th2);
                                    throw th7;
                                }
                            } else {
                                throw new RuntimeException("Cannot open output stream for " + insert + '.');
                            }
                        } else {
                            throw new RuntimeException("Cannot insert new asset.");
                        }
                    } else {
                        P("Cannot find gallery info");
                        throw new KotlinNothingValueException();
                    }
                } else {
                    throw new RuntimeException("Cannot find asset .");
                }
            } else {
                throw new RuntimeException("No copy required, because the target gallery is the same as the current one.");
            }
        } else {
            throw new RuntimeException("No copy required, because the target gallery is the same as the current one.");
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
        FileInputStream fileInputStream = new FileInputStream(str5);
        ContentResolver contentResolver = context.getContentResolver();
        long j11 = (long) 1000;
        long currentTimeMillis = System.currentTimeMillis() / j11;
        String guessContentTypeFromStream = URLConnection.guessContentTypeFromStream(fileInputStream);
        if (guessContentTypeFromStream == null) {
            guessContentTypeFromStream = "video/" + FilesKt__UtilsKt.g(new File(str5));
        }
        boolean M = StringsKt__StringsJVMKt.M(new File(str5).getAbsolutePath(), Environment.getExternalStorageDirectory().getPath(), false, 2, (Object) null);
        f.a b11 = f.f65122a.b(str5);
        ContentValues contentValues = new ContentValues();
        contentValues.put("_display_name", str6);
        contentValues.put("mime_type", guessContentTypeFromStream);
        contentValues.put("title", str6);
        contentValues.put("description", str3);
        contentValues.put("date_added", Long.valueOf(currentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
        contentValues.put("datetaken", Long.valueOf(currentTimeMillis * j11));
        contentValues.put("_display_name", str6);
        contentValues.put(IBridgeMediaLoader.COLUMN_DURATION, b11.a());
        contentValues.put("width", b11.c());
        contentValues.put("height", b11.b());
        if (M) {
            contentValues.put("_data", str5);
        }
        Uri insert = contentResolver.insert(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (insert == null) {
            return null;
        }
        b w11 = w(context, String.valueOf(ContentUris.parseId(insert)));
        if (M) {
            fileInputStream.close();
        } else {
            String k11 = w11 != null ? w11.k() : null;
            a.a(k11);
            File file = new File(k11);
            String str7 = file.getParent() + '/' + str6;
            File file2 = new File(str7);
            if (!file2.exists()) {
                file.renameTo(file2);
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("_data", str7);
                contentResolver.update(insert, contentValues2, (String) null, (String[]) null);
                FileOutputStream fileOutputStream = new FileOutputStream(file2);
                try {
                    kotlin.io.a.b(fileInputStream, fileOutputStream, 0, 2, (Object) null);
                    try {
                        kotlin.io.b.a(fileInputStream, (Throwable) null);
                        kotlin.io.b.a(fileOutputStream, (Throwable) null);
                        w11.p(str7);
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        try {
                            throw th4;
                        } catch (Throwable th5) {
                            Throwable th6 = th5;
                            kotlin.io.b.a(fileOutputStream, th4);
                            throw th6;
                        }
                    }
                } catch (Throwable th7) {
                    Throwable th8 = th7;
                    kotlin.io.b.a(fileInputStream, th2);
                    throw th8;
                }
            } else {
                throw new IOException("save target path is ");
            }
        }
        contentResolver.notifyChange(insert, (ContentObserver) null);
        return w11;
    }

    public List<b> l(Context context, String str, int i11, int i12, int i13, FilterOption filterOption) {
        String str2;
        Throwable th2;
        int i14 = i11;
        int i15 = i13;
        FilterOption filterOption2 = filterOption;
        boolean z11 = str.length() == 0;
        ArrayList arrayList = new ArrayList();
        Uri e11 = e();
        ArrayList arrayList2 = new ArrayList();
        if (!z11) {
            arrayList2.add(str);
        }
        String C = C(i15, filterOption2, arrayList2);
        String D = D(arrayList2, filterOption2);
        String O = O(Integer.valueOf(i13), filterOption2);
        IDBUtils.a aVar = IDBUtils.f65111a;
        String[] strArr = (String[]) CollectionsKt___CollectionsKt.S(CollectionsKt___CollectionsKt.s0(CollectionsKt___CollectionsKt.s0(CollectionsKt___CollectionsKt.q0(aVar.c(), aVar.d()), aVar.e()), f65106c)).toArray(new String[0]);
        if (z11) {
            str2 = "bucket_id IS NOT NULL " + C + ' ' + D + ' ' + O;
        } else {
            str2 = "bucket_id = ? " + C + ' ' + D + ' ' + O;
        }
        Cursor query = context.getContentResolver().query(e11, strArr, str2, (String[]) arrayList2.toArray(new String[0]), K(i14, i12 - i14, filterOption2));
        if (query == null) {
            return CollectionsKt__CollectionsKt.k();
        }
        while (query.moveToNext()) {
            try {
                arrayList.add(f65105b.A(query, i15));
            } catch (Throwable th3) {
                Throwable th4 = th3;
                kotlin.io.b.a(query, th2);
                throw th4;
            }
        }
        Unit unit = Unit.f56620a;
        kotlin.io.b.a(query, (Throwable) null);
        return arrayList;
    }

    /* JADX INFO: finally extract failed */
    public List<d> m(Context context, int i11, FilterOption filterOption) {
        Throwable th2;
        FilterOption filterOption2 = filterOption;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Cursor query = context.getContentResolver().query(e(), (String[]) ArraysKt___ArraysJvmKt.u(IDBUtils.f65111a.b(), new String[]{"count(1)"}), "bucket_id IS NOT NULL " + C(i11, filterOption2, arrayList2) + ' ' + D(arrayList2, filterOption2) + ' ' + O(Integer.valueOf(i11), filterOption2) + ") GROUP BY (bucket_id", (String[]) arrayList2.toArray(new String[0]), (String) null);
        if (query == null) {
            return CollectionsKt__CollectionsKt.k();
        }
        while (query.moveToNext()) {
            try {
                String string = query.getString(0);
                String string2 = query.getString(1);
                if (string2 == null) {
                    string2 = "";
                }
                d dVar = new d(string, string2, query.getInt(2), 0, false, (Long) null, 48, (r) null);
                if (filterOption.b()) {
                    f65105b.g(context, dVar);
                } else {
                    Context context2 = context;
                }
                arrayList.add(dVar);
            } catch (Throwable th3) {
                Throwable th4 = th3;
                kotlin.io.b.a(query, th2);
                throw th4;
            }
        }
        Unit unit = Unit.f56620a;
        kotlin.io.b.a(query, (Throwable) null);
        return arrayList;
    }

    public Long n(Context context, String str) {
        return IDBUtils.DefaultImpls.p(this, context, str);
    }

    /* JADX INFO: finally extract failed */
    public b o(Context context, byte[] bArr, String str, String str2, String str3) {
        double[] dArr;
        String str4;
        Cursor query;
        Throwable th2;
        byte[] bArr2 = bArr;
        String str5 = str;
        ContentResolver contentResolver = context.getContentResolver();
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new ByteArrayInputStream(bArr2);
        try {
            dArr = new m1.a((InputStream) ref$ObjectRef.element).m();
            if (dArr == null) {
                dArr = new double[]{0.0d, 0.0d};
            }
        } catch (Exception unused) {
            dArr = new double[]{0.0d, 0.0d};
        }
        M(ref$ObjectRef, bArr2);
        Bitmap decodeStream = BitmapFactory.decodeStream((InputStream) ref$ObjectRef.element);
        int width = decodeStream.getWidth();
        int height = decodeStream.getHeight();
        long currentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        M(ref$ObjectRef, bArr2);
        if (StringsKt__StringsKt.R(str5, InstructionFileId.DOT, false, 2, (Object) null)) {
            str4 = "image/" + FilesKt__UtilsKt.g(new File(str5));
        } else {
            str4 = URLConnection.guessContentTypeFromStream((InputStream) ref$ObjectRef.element);
            if (str4 == null) {
                str4 = SelectMimeType.SYSTEM_IMAGE;
            }
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put(MessengerShareContentUtility.MEDIA_TYPE, 1);
        contentValues.put("_display_name", str5);
        contentValues.put("mime_type", str4);
        contentValues.put("title", str5);
        contentValues.put("description", str2);
        contentValues.put("date_added", Long.valueOf(currentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
        contentValues.put("_display_name", str5);
        contentValues.put("width", Integer.valueOf(width));
        contentValues.put("height", Integer.valueOf(height));
        contentValues.put("latitude", Double.valueOf(dArr[0]));
        contentValues.put("longitude", Double.valueOf(dArr[1]));
        Uri insert = contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        if (insert == null || (query = contentResolver.query(insert, new String[]{"_data"}, (String) null, (String[]) null, (String) null)) == null) {
            return null;
        }
        try {
            if (query.moveToNext()) {
                String string = query.getString(0);
                a.a(string);
                FileOutputStream fileOutputStream = new FileOutputStream(string);
                M(ref$ObjectRef, bArr2);
                try {
                    T t11 = ref$ObjectRef.element;
                    Closeable closeable = (Closeable) t11;
                    try {
                        ByteArrayInputStream byteArrayInputStream = (ByteArrayInputStream) closeable;
                        kotlin.io.a.b((InputStream) t11, fileOutputStream, 0, 2, (Object) null);
                        kotlin.io.b.a(closeable, (Throwable) null);
                        kotlin.io.b.a(fileOutputStream, (Throwable) null);
                    } catch (Throwable th3) {
                        Throwable th4 = th3;
                        kotlin.io.b.a(closeable, th2);
                        throw th4;
                    }
                } catch (Throwable th5) {
                    Throwable th6 = th5;
                    try {
                        throw th6;
                    } catch (Throwable th7) {
                        Throwable th8 = th7;
                        kotlin.io.b.a(fileOutputStream, th6);
                        throw th8;
                    }
                }
            }
            Unit unit = Unit.f56620a;
            kotlin.io.b.a(query, (Throwable) null);
            return w(context, String.valueOf(ContentUris.parseId(insert)));
        } catch (Throwable th9) {
            Throwable th10 = th9;
            try {
                throw th10;
            } catch (Throwable th11) {
                Throwable th12 = th11;
                kotlin.io.b.a(query, th10);
                throw th12;
            }
        }
    }

    public b p(Context context, String str, String str2, String str3, String str4) {
        double[] dArr;
        Pair pair;
        Throwable th2;
        String str5 = str;
        String str6 = str2;
        ContentResolver contentResolver = context.getContentResolver();
        File file = new File(str5);
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = new FileInputStream(file);
        try {
            dArr = new m1.a((InputStream) ref$ObjectRef.element).m();
            if (dArr == null) {
                dArr = new double[]{0.0d, 0.0d};
            }
        } catch (Exception unused) {
            dArr = new double[]{0.0d, 0.0d};
        }
        N(ref$ObjectRef, file);
        try {
            Bitmap decodeFile = BitmapFactory.decodeFile(str);
            pair = new Pair(Integer.valueOf(decodeFile.getWidth()), Integer.valueOf(decodeFile.getHeight()));
        } catch (Exception unused2) {
            pair = new Pair(0, 0);
        }
        int intValue = ((Number) pair.component1()).intValue();
        int intValue2 = ((Number) pair.component2()).intValue();
        long currentTimeMillis = System.currentTimeMillis() / ((long) 1000);
        String guessContentTypeFromStream = URLConnection.guessContentTypeFromStream((InputStream) ref$ObjectRef.element);
        if (guessContentTypeFromStream == null) {
            guessContentTypeFromStream = "image/" + FilesKt__UtilsKt.g(new File(str5));
        }
        N(ref$ObjectRef, file);
        Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        boolean M = StringsKt__StringsJVMKt.M(file.getAbsolutePath(), Environment.getExternalStorageDirectory().getPath(), false, 2, (Object) null);
        ContentValues contentValues = new ContentValues();
        contentValues.put(MessengerShareContentUtility.MEDIA_TYPE, 1);
        contentValues.put("_display_name", str6);
        contentValues.put("mime_type", guessContentTypeFromStream);
        contentValues.put("title", str6);
        contentValues.put("description", str3);
        contentValues.put("date_added", Long.valueOf(currentTimeMillis));
        contentValues.put("date_modified", Long.valueOf(currentTimeMillis));
        contentValues.put("_display_name", str6);
        contentValues.put("latitude", Double.valueOf(dArr[0]));
        contentValues.put("longitude", Double.valueOf(dArr[1]));
        contentValues.put("width", Integer.valueOf(intValue));
        contentValues.put("height", Integer.valueOf(intValue2));
        if (M) {
            contentValues.put("_data", str5);
        }
        Uri insert = contentResolver.insert(uri, contentValues);
        if (insert == null) {
            return null;
        }
        b w11 = w(context, String.valueOf(ContentUris.parseId(insert)));
        if (!M) {
            String k11 = w11 != null ? w11.k() : null;
            a.a(k11);
            File file2 = new File(k11);
            String str7 = file2.getParent() + '/' + str6;
            File file3 = new File(str7);
            if (!file3.exists()) {
                file2.renameTo(file3);
                ContentValues contentValues2 = new ContentValues();
                contentValues2.put("_data", str7);
                contentResolver.update(insert, contentValues2, (String) null, (String[]) null);
                FileOutputStream fileOutputStream = new FileOutputStream(file3);
                try {
                    th = (Closeable) ref$ObjectRef.element;
                    try {
                        kotlin.io.a.b((FileInputStream) th, fileOutputStream, 0, 2, (Object) null);
                        kotlin.io.b.a(th, (Throwable) null);
                        kotlin.io.b.a(fileOutputStream, (Throwable) null);
                        w11.p(str7);
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
                        kotlin.io.b.a(fileOutputStream, closeable);
                        throw th6;
                    }
                }
            } else {
                throw new IOException("save target path is ");
            }
        }
        contentResolver.notifyChange(insert, (ContentObserver) null);
        return w11;
    }

    public List<b> q(Context context, String str, int i11, int i12, int i13, FilterOption filterOption) {
        String str2;
        Throwable th2;
        int i14 = i12;
        int i15 = i13;
        FilterOption filterOption2 = filterOption;
        boolean z11 = str.length() == 0;
        ArrayList arrayList = new ArrayList();
        Uri e11 = e();
        ArrayList arrayList2 = new ArrayList();
        if (!z11) {
            arrayList2.add(str);
        }
        String C = C(i15, filterOption2, arrayList2);
        String D = D(arrayList2, filterOption2);
        String O = O(Integer.valueOf(i13), filterOption2);
        IDBUtils.a aVar = IDBUtils.f65111a;
        String[] strArr = (String[]) CollectionsKt___CollectionsKt.S(CollectionsKt___CollectionsKt.s0(CollectionsKt___CollectionsKt.s0(CollectionsKt___CollectionsKt.q0(aVar.c(), aVar.d()), aVar.e()), f65106c)).toArray(new String[0]);
        if (z11) {
            str2 = "bucket_id IS NOT NULL " + C + ' ' + D + ' ' + O;
        } else {
            str2 = "bucket_id = ? " + C + ' ' + D + ' ' + O;
        }
        Cursor query = context.getContentResolver().query(e11, strArr, str2, (String[]) arrayList2.toArray(new String[0]), K(i11 * i14, i14, filterOption2));
        if (query == null) {
            return CollectionsKt__CollectionsKt.k();
        }
        while (query.moveToNext()) {
            try {
                arrayList.add(f65105b.A(query, i15));
            } catch (Throwable th3) {
                Throwable th4 = th3;
                kotlin.io.b.a(query, th2);
                throw th4;
            }
        }
        Unit unit = Unit.f56620a;
        kotlin.io.b.a(query, (Throwable) null);
        return arrayList;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0090, code lost:
        r14 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0091, code lost:
        kotlin.io.b.a(r12, r13);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0094, code lost:
        throw r14;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.fluttercandies.photo_manager.core.entity.d> r(android.content.Context r12, int r13, com.fluttercandies.photo_manager.core.entity.FilterOption r14) {
        /*
            r11 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.lang.String r2 = r11.C(r13, r14, r1)
            com.fluttercandies.photo_manager.core.utils.IDBUtils$a r3 = com.fluttercandies.photo_manager.core.utils.IDBUtils.f65111a
            java.lang.String[] r3 = r3.b()
            java.lang.String r4 = "count(1)"
            java.lang.String[] r5 = new java.lang.String[]{r4}
            java.lang.Object[] r3 = kotlin.collections.ArraysKt___ArraysJvmKt.u(r3, r5)
            java.lang.String[] r3 = (java.lang.String[]) r3
            java.lang.String r5 = r11.D(r1, r14)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r13)
            java.lang.String r14 = r11.O(r6, r14)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "bucket_id IS NOT NULL "
            r6.append(r7)
            r6.append(r2)
            r2 = 32
            r6.append(r2)
            r6.append(r5)
            r6.append(r2)
            r6.append(r14)
            java.lang.String r8 = r6.toString()
            android.content.ContentResolver r5 = r12.getContentResolver()
            android.net.Uri r6 = r11.e()
            r12 = 0
            java.lang.String[] r12 = new java.lang.String[r12]
            java.lang.Object[] r12 = r1.toArray(r12)
            r9 = r12
            java.lang.String[] r9 = (java.lang.String[]) r9
            r10 = 0
            r7 = r3
            android.database.Cursor r12 = r5.query(r6, r7, r8, r9, r10)
            if (r12 != 0) goto L_0x0066
            return r0
        L_0x0066:
            r14 = 0
            boolean r1 = r12.moveToNext()     // Catch:{ all -> 0x008e }
            if (r1 == 0) goto L_0x0088
            int r1 = kotlin.collections.ArraysKt___ArraysKt.Q(r3, r4)     // Catch:{ all -> 0x008e }
            int r5 = r12.getInt(r1)     // Catch:{ all -> 0x008e }
            com.fluttercandies.photo_manager.core.entity.d r1 = new com.fluttercandies.photo_manager.core.entity.d     // Catch:{ all -> 0x008e }
            java.lang.String r3 = "isAll"
            java.lang.String r4 = "Recent"
            r7 = 1
            r8 = 0
            r9 = 32
            r10 = 0
            r2 = r1
            r6 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)     // Catch:{ all -> 0x008e }
            r0.add(r1)     // Catch:{ all -> 0x008e }
        L_0x0088:
            kotlin.Unit r13 = kotlin.Unit.f56620a     // Catch:{ all -> 0x008e }
            kotlin.io.b.a(r12, r14)
            return r0
        L_0x008e:
            r13 = move-exception
            throw r13     // Catch:{ all -> 0x0090 }
        L_0x0090:
            r14 = move-exception
            kotlin.io.b.a(r12, r13)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.utils.DBUtils.r(android.content.Context, int, com.fluttercandies.photo_manager.core.entity.FilterOption):java.util.List");
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

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x005d, code lost:
        kotlin.io.b.a(r9, r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0060, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.fluttercandies.photo_manager.core.entity.b w(android.content.Context r9, java.lang.String r10) {
        /*
            r8 = this;
            com.fluttercandies.photo_manager.core.utils.IDBUtils$a r0 = com.fluttercandies.photo_manager.core.utils.IDBUtils.f65111a
            java.util.List r1 = r0.c()
            java.util.List r2 = r0.d()
            java.util.List r1 = kotlin.collections.CollectionsKt___CollectionsKt.q0(r1, r2)
            java.lang.String[] r2 = f65106c
            java.util.List r1 = kotlin.collections.CollectionsKt___CollectionsKt.s0(r1, r2)
            java.lang.String[] r0 = r0.e()
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.s0(r1, r0)
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
            if (r9 != 0) goto L_0x0042
            return r10
        L_0x0042:
            boolean r0 = r9.moveToNext()     // Catch:{ all -> 0x005a }
            if (r0 == 0) goto L_0x0055
            com.fluttercandies.photo_manager.core.utils.DBUtils r0 = f65105b     // Catch:{ all -> 0x005a }
            java.lang.String r1 = "media_type"
            int r1 = r0.H(r9, r1)     // Catch:{ all -> 0x005a }
            com.fluttercandies.photo_manager.core.entity.b r0 = r0.A(r9, r1)     // Catch:{ all -> 0x005a }
            goto L_0x0056
        L_0x0055:
            r0 = r10
        L_0x0056:
            kotlin.io.b.a(r9, r10)
            return r0
        L_0x005a:
            r10 = move-exception
            throw r10     // Catch:{ all -> 0x005c }
        L_0x005c:
            r0 = move-exception
            kotlin.io.b.a(r9, r10)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.utils.DBUtils.w(android.content.Context, java.lang.String):com.fluttercandies.photo_manager.core.entity.b");
    }

    public d x(Context context, String str, int i11, FilterOption filterOption) {
        String str2;
        Throwable th2;
        d dVar;
        String str3;
        String str4 = str;
        FilterOption filterOption2 = filterOption;
        Uri e11 = e();
        String[] strArr = (String[]) ArraysKt___ArraysJvmKt.u(IDBUtils.f65111a.b(), new String[]{"count(1)"});
        ArrayList arrayList = new ArrayList();
        String C = C(i11, filterOption2, arrayList);
        String D = D(arrayList, filterOption2);
        if (x.b(str4, "")) {
            str2 = "";
        } else {
            arrayList.add(str4);
            str2 = "AND bucket_id = ?";
        }
        Cursor query = context.getContentResolver().query(e11, strArr, "bucket_id IS NOT NULL " + C + ' ' + D + ' ' + str2 + ' ' + O((Integer) null, filterOption2) + ") GROUP BY (bucket_id", (String[]) arrayList.toArray(new String[0]), (String) null);
        if (query == null) {
            return null;
        }
        try {
            if (query.moveToNext()) {
                String string = query.getString(0);
                String string2 = query.getString(1);
                if (string2 == null) {
                    str3 = "";
                } else {
                    str3 = string2;
                }
                dVar = new d(string, str3, query.getInt(2), 0, false, (Long) null, 48, (r) null);
            } else {
                dVar = null;
            }
            kotlin.io.b.a(query, (Throwable) null);
            return dVar;
        } catch (Throwable th3) {
            Throwable th4 = th3;
            kotlin.io.b.a(query, th2);
            throw th4;
        }
    }

    public m1.a y(Context context, String str) {
        b w11 = w(context, str);
        if (w11 != null && new File(w11.k()).exists()) {
            return new m1.a(w11.k());
        }
        return null;
    }

    public b z(Context context, String str, String str2) {
        Pair<String, String> J = J(context, str);
        if (J != null) {
            String component1 = J.component1();
            a F = F(context, str2);
            if (F == null) {
                P("Cannot get target gallery info");
                throw new KotlinNothingValueException();
            } else if (!x.b(str2, component1)) {
                ContentResolver contentResolver = context.getContentResolver();
                Cursor query = contentResolver.query(e(), new String[]{"_data"}, G(), new String[]{str}, (String) null);
                if (query == null) {
                    P("Cannot find " + str + " path");
                    throw new KotlinNothingValueException();
                } else if (query.moveToNext()) {
                    String string = query.getString(0);
                    query.close();
                    String str3 = F.b() + '/' + new File(string).getName();
                    new File(string).renameTo(new File(str3));
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("_data", str3);
                    contentValues.put(IBridgeMediaLoader.COLUMN_BUCKET_ID, str2);
                    contentValues.put(IBridgeMediaLoader.COLUMN_BUCKET_DISPLAY_NAME, F.a());
                    if (contentResolver.update(e(), contentValues, G(), new String[]{str}) > 0) {
                        return w(context, str);
                    }
                    P("Cannot update " + str + " relativePath");
                    throw new KotlinNothingValueException();
                } else {
                    P("Cannot find " + str + " path");
                    throw new KotlinNothingValueException();
                }
            } else {
                P("No move required, because the target gallery is the same as the current one.");
                throw new KotlinNothingValueException();
            }
        } else {
            P("Cannot get gallery id of " + str);
            throw new KotlinNothingValueException();
        }
    }
}
