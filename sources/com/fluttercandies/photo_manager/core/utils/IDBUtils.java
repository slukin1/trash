package com.fluttercandies.photo_manager.core.utils;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import com.facebook.share.internal.MessengerShareContentUtility;
import com.fluttercandies.photo_manager.core.entity.FilterCond;
import com.fluttercandies.photo_manager.core.entity.FilterOption;
import com.fluttercandies.photo_manager.core.entity.c;
import com.fluttercandies.photo_manager.core.entity.d;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.io.b;

public interface IDBUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final a f65111a = a.f65112a;

    public static final class DefaultImpls {
        public static Void A(IDBUtils iDBUtils, String str) {
            throw new RuntimeException(str);
        }

        public static String a(IDBUtils iDBUtils, ArrayList<String> arrayList, c cVar, String str) {
            if (cVar.a()) {
                return "";
            }
            long c11 = cVar.c();
            long b11 = cVar.b();
            String str2 = "AND ( " + str + " >= ? AND " + str + " <= ? )";
            long j11 = (long) 1000;
            arrayList.add(String.valueOf(c11 / j11));
            arrayList.add(String.valueOf(b11 / j11));
            return str2;
        }

        public static void b(IDBUtils iDBUtils) {
        }

        public static void c(IDBUtils iDBUtils, Context context) {
        }

        public static int d(IDBUtils iDBUtils, int i11) {
            return c.f65119a.a(i11);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0030, code lost:
            r8 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
            kotlin.io.b.a(r9, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0034, code lost:
            throw r8;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static boolean e(com.fluttercandies.photo_manager.core.utils.IDBUtils r7, android.content.Context r8, java.lang.String r9) {
            /*
                java.lang.String r0 = "_id"
                java.lang.String[] r3 = new java.lang.String[]{r0}
                android.content.ContentResolver r1 = r8.getContentResolver()
                android.net.Uri r2 = r7.e()
                r7 = 1
                java.lang.String[] r5 = new java.lang.String[r7]
                r8 = 0
                r5[r8] = r9
                java.lang.String r4 = "_id = ?"
                r6 = 0
                android.database.Cursor r9 = r1.query(r2, r3, r4, r5, r6)
                r0 = 0
                if (r9 != 0) goto L_0x0022
                kotlin.io.b.a(r9, r0)
                return r8
            L_0x0022:
                int r1 = r9.getCount()     // Catch:{ all -> 0x002e }
                if (r1 < r7) goto L_0x0029
                goto L_0x002a
            L_0x0029:
                r7 = r8
            L_0x002a:
                kotlin.io.b.a(r9, r0)
                return r7
            L_0x002e:
                r7 = move-exception
                throw r7     // Catch:{ all -> 0x0030 }
            L_0x0030:
                r8 = move-exception
                kotlin.io.b.a(r9, r7)
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.utils.IDBUtils.DefaultImpls.e(com.fluttercandies.photo_manager.core.utils.IDBUtils, android.content.Context, java.lang.String):boolean");
        }

        public static Uri f(IDBUtils iDBUtils) {
            return IDBUtils.f65111a.a();
        }

        public static List<String> g(IDBUtils iDBUtils, Context context, List<String> list) {
            Throwable th2;
            IDBUtils iDBUtils2 = iDBUtils;
            List<String> list2 = list;
            int i11 = 0;
            if (list.size() > 500) {
                ArrayList arrayList = new ArrayList();
                int size = list.size();
                int i12 = size / 500;
                if (size % 500 != 0) {
                    i12++;
                }
                while (i11 < i12) {
                    arrayList.addAll(iDBUtils2.c(context, list2.subList(i11 * 500, i11 == i12 + -1 ? list.size() : ((i11 + 1) * 500) - 1)));
                    i11++;
                }
                return arrayList;
            }
            Context context2 = context;
            String[] strArr = {"_id", MessengerShareContentUtility.MEDIA_TYPE, "_data"};
            String k02 = CollectionsKt___CollectionsKt.k0(list, Constants.ACCEPT_TIME_SEPARATOR_SP, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, IDBUtils$getAssetsPath$idSelection$1.INSTANCE, 30, (Object) null);
            Cursor query = context.getContentResolver().query(iDBUtils.e(), strArr, "_id in (" + k02 + ')', (String[]) list2.toArray(new String[0]), (String) null);
            if (query == null) {
                return CollectionsKt__CollectionsKt.k();
            }
            ArrayList arrayList2 = new ArrayList();
            HashMap hashMap = new HashMap();
            while (query.moveToNext()) {
                try {
                    hashMap.put(iDBUtils2.u(query, "_id"), iDBUtils2.u(query, "_data"));
                } catch (Throwable th3) {
                    Throwable th4 = th3;
                    b.a(query, th2);
                    throw th4;
                }
            }
            Unit unit = Unit.f56620a;
            b.a(query, (Throwable) null);
            for (String str : list) {
                String str2 = (String) hashMap.get(str);
                if (str2 != null) {
                    arrayList2.add(str2);
                }
            }
            return arrayList2;
        }

        public static String h(IDBUtils iDBUtils, int i11, FilterOption filterOption, ArrayList<String> arrayList) {
            String str;
            String str2;
            StringBuilder sb2 = new StringBuilder();
            d dVar = d.f65120a;
            boolean c11 = dVar.c(i11);
            boolean d11 = dVar.d(i11);
            boolean b11 = dVar.b(i11);
            String str3 = "";
            if (c11) {
                FilterCond d12 = filterOption.d();
                str = MessengerShareContentUtility.MEDIA_TYPE + " = ? ";
                arrayList.add("1");
                if (!d12.d().a()) {
                    String i12 = d12.i();
                    str = str + " AND " + i12;
                    boolean unused = CollectionsKt__MutableCollectionsKt.B(arrayList, d12.h());
                }
            } else {
                str = str3;
            }
            if (d11) {
                FilterCond f11 = filterOption.f();
                String b12 = f11.b();
                String[] a11 = f11.a();
                str2 = MessengerShareContentUtility.MEDIA_TYPE + " = ? AND " + b12;
                arrayList.add("3");
                boolean unused2 = CollectionsKt__MutableCollectionsKt.B(arrayList, a11);
            } else {
                str2 = str3;
            }
            if (b11) {
                FilterCond a12 = filterOption.a();
                String b13 = a12.b();
                String[] a13 = a12.a();
                str3 = MessengerShareContentUtility.MEDIA_TYPE + " = ? AND " + b13;
                arrayList.add("2");
                boolean unused3 = CollectionsKt__MutableCollectionsKt.B(arrayList, a13);
            }
            if (c11) {
                sb2.append("( " + str + " )");
            }
            boolean z11 = true;
            if (d11) {
                if (sb2.length() > 0) {
                    sb2.append("OR ");
                }
                sb2.append("( " + str2 + " )");
            }
            if (b11) {
                if (sb2.length() <= 0) {
                    z11 = false;
                }
                if (z11) {
                    sb2.append("OR ");
                }
                sb2.append("( " + str3 + " )");
            }
            return "AND ( " + sb2 + " )";
        }

        public static String i(IDBUtils iDBUtils, ArrayList<String> arrayList, FilterOption filterOption) {
            String a11 = a(iDBUtils, arrayList, filterOption.c(), "date_added");
            String a12 = a(iDBUtils, arrayList, filterOption.e(), "date_modified");
            return a11 + ' ' + a12;
        }

        public static double j(IDBUtils iDBUtils, Cursor cursor, String str) {
            return cursor.getDouble(cursor.getColumnIndex(str));
        }

        public static String k(IDBUtils iDBUtils) {
            return "_id = ?";
        }

        public static int l(IDBUtils iDBUtils, Cursor cursor, String str) {
            return cursor.getInt(cursor.getColumnIndex(str));
        }

        public static long m(IDBUtils iDBUtils, Cursor cursor, String str) {
            return cursor.getLong(cursor.getColumnIndex(str));
        }

        public static int n(IDBUtils iDBUtils, int i11) {
            if (i11 == 1) {
                return 1;
            }
            if (i11 != 2) {
                return i11 != 3 ? 0 : 2;
            }
            return 3;
        }

        public static String o(IDBUtils iDBUtils, Context context, String str, int i11) {
            return AndroidQDBUtils.f65102b.j(str, i11, false).toString();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0051, code lost:
            r9 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
            kotlin.io.b.a(r8, r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0055, code lost:
            throw r9;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static java.lang.Long p(com.fluttercandies.photo_manager.core.utils.IDBUtils r7, android.content.Context r8, java.lang.String r9) {
            /*
                java.lang.String r0 = "date_modified"
                java.lang.String[] r3 = new java.lang.String[]{r0}
                java.lang.String r1 = "isAll"
                boolean r1 = kotlin.jvm.internal.x.b(r9, r1)
                java.lang.String r6 = "date_modified desc"
                if (r1 == 0) goto L_0x001f
                android.content.ContentResolver r1 = r8.getContentResolver()
                android.net.Uri r2 = r7.e()
                r4 = 0
                r5 = 0
                android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)
                goto L_0x0033
            L_0x001f:
                android.content.ContentResolver r1 = r8.getContentResolver()
                android.net.Uri r2 = r7.e()
                r8 = 1
                java.lang.String[] r5 = new java.lang.String[r8]
                r8 = 0
                r5[r8] = r9
                java.lang.String r4 = "bucket_id = ?"
                android.database.Cursor r8 = r1.query(r2, r3, r4, r5, r6)
            L_0x0033:
                r9 = 0
                if (r8 != 0) goto L_0x0037
                return r9
            L_0x0037:
                boolean r1 = r8.moveToNext()     // Catch:{ all -> 0x004f }
                if (r1 == 0) goto L_0x0049
                long r0 = r7.s(r8, r0)     // Catch:{ all -> 0x004f }
                java.lang.Long r7 = java.lang.Long.valueOf(r0)     // Catch:{ all -> 0x004f }
                kotlin.io.b.a(r8, r9)
                return r7
            L_0x0049:
                kotlin.Unit r7 = kotlin.Unit.f56620a     // Catch:{ all -> 0x004f }
                kotlin.io.b.a(r8, r9)
                return r9
            L_0x004f:
                r7 = move-exception
                throw r7     // Catch:{ all -> 0x0051 }
            L_0x0051:
                r9 = move-exception
                kotlin.io.b.a(r8, r7)
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.utils.IDBUtils.DefaultImpls.p(com.fluttercandies.photo_manager.core.utils.IDBUtils, android.content.Context, java.lang.String):java.lang.Long");
        }

        public static String q(IDBUtils iDBUtils, int i11, int i12, FilterOption filterOption) {
            String g11 = filterOption.g();
            return g11 + " LIMIT " + i12 + " OFFSET " + i11;
        }

        public static String r(IDBUtils iDBUtils, Cursor cursor, String str) {
            String string = cursor.getString(cursor.getColumnIndex(str));
            return string == null ? "" : string;
        }

        public static String s(IDBUtils iDBUtils, Cursor cursor, String str) {
            return cursor.getString(cursor.getColumnIndex(str));
        }

        public static int t(IDBUtils iDBUtils, int i11) {
            if (i11 == 1) {
                return 1;
            }
            if (i11 != 2) {
                return i11 != 3 ? 0 : 2;
            }
            return 3;
        }

        public static d u(IDBUtils iDBUtils) {
            return d.f65120a;
        }

        public static Uri v(IDBUtils iDBUtils, String str, int i11, boolean z11) {
            Uri uri;
            if (i11 == 1) {
                uri = Uri.withAppendedPath(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, str);
            } else if (i11 == 2) {
                uri = Uri.withAppendedPath(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, str);
            } else if (i11 != 3) {
                return Uri.EMPTY;
            } else {
                uri = Uri.withAppendedPath(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, str);
            }
            return z11 ? MediaStore.setRequireOriginal(uri) : uri;
        }

        public static /* synthetic */ Uri w(IDBUtils iDBUtils, String str, int i11, boolean z11, int i12, Object obj) {
            if (obj == null) {
                if ((i12 & 4) != 0) {
                    z11 = false;
                }
                return iDBUtils.j(str, i11, z11);
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: getUri");
        }

        public static void x(IDBUtils iDBUtils, Context context, d dVar) {
            Long n11 = iDBUtils.n(context, dVar.a());
            if (n11 != null) {
                dVar.f(Long.valueOf(n11.longValue()));
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:16:0x007c, code lost:
            r11 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x007d, code lost:
            kotlin.io.b.a(r10, r9);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0080, code lost:
            throw r11;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static void y(com.fluttercandies.photo_manager.core.utils.IDBUtils r9, android.content.Context r10, java.lang.String r11) {
            /*
                z4.a r0 = z4.a.f66723a
                boolean r0 = r0.e()
                if (r0 == 0) goto L_0x009b
                r0 = 40
                r1 = 45
                java.lang.String r2 = ""
                java.lang.String r0 = kotlin.text.StringsKt__StringsKt.u0(r2, r0, r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "log error row "
                r1.append(r2)
                r1.append(r11)
                java.lang.String r3 = " start "
                r1.append(r3)
                r1.append(r0)
                java.lang.String r1 = r1.toString()
                z4.a.d(r1)
                android.content.ContentResolver r3 = r10.getContentResolver()
                android.net.Uri r4 = r9.e()
                r5 = 0
                r9 = 1
                java.lang.String[] r7 = new java.lang.String[r9]
                r9 = 0
                r7[r9] = r11
                r8 = 0
                java.lang.String r6 = "_id = ?"
                android.database.Cursor r10 = r3.query(r4, r5, r6, r7, r8)
                if (r10 == 0) goto L_0x0081
                r1 = 0
                java.lang.String[] r3 = r10.getColumnNames()     // Catch:{ all -> 0x007a }
                boolean r4 = r10.moveToNext()     // Catch:{ all -> 0x007a }
                if (r4 == 0) goto L_0x0074
                int r4 = r3.length     // Catch:{ all -> 0x007a }
            L_0x0052:
                if (r9 >= r4) goto L_0x0074
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x007a }
                r5.<init>()     // Catch:{ all -> 0x007a }
                r6 = r3[r9]     // Catch:{ all -> 0x007a }
                r5.append(r6)     // Catch:{ all -> 0x007a }
                java.lang.String r6 = " : "
                r5.append(r6)     // Catch:{ all -> 0x007a }
                java.lang.String r6 = r10.getString(r9)     // Catch:{ all -> 0x007a }
                r5.append(r6)     // Catch:{ all -> 0x007a }
                java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x007a }
                z4.a.d(r5)     // Catch:{ all -> 0x007a }
                int r9 = r9 + 1
                goto L_0x0052
            L_0x0074:
                kotlin.Unit r9 = kotlin.Unit.f56620a     // Catch:{ all -> 0x007a }
                kotlin.io.b.a(r10, r1)
                goto L_0x0081
            L_0x007a:
                r9 = move-exception
                throw r9     // Catch:{ all -> 0x007c }
            L_0x007c:
                r11 = move-exception
                kotlin.io.b.a(r10, r9)
                throw r11
            L_0x0081:
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                r9.append(r2)
                r9.append(r11)
                java.lang.String r10 = " end "
                r9.append(r10)
                r9.append(r0)
                java.lang.String r9 = r9.toString()
                z4.a.d(r9)
            L_0x009b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fluttercandies.photo_manager.core.utils.IDBUtils.DefaultImpls.y(com.fluttercandies.photo_manager.core.utils.IDBUtils, android.content.Context, java.lang.String):void");
        }

        public static String z(IDBUtils iDBUtils, Integer num, FilterOption filterOption) {
            String str = "";
            if (filterOption.d().d().a() || num == null || !u(iDBUtils).c(num.intValue())) {
                return str;
            }
            if (u(iDBUtils).d(num.intValue())) {
                str = "OR ( " + MessengerShareContentUtility.MEDIA_TYPE + " = 3 )";
            }
            if (u(iDBUtils).b(num.intValue())) {
                str = str + " OR ( " + MessengerShareContentUtility.MEDIA_TYPE + " = 2 )";
            }
            return "AND (" + ("( " + MessengerShareContentUtility.MEDIA_TYPE + " = 1 AND " + "width > 0 AND height > 0" + " )") + ' ' + str + ')';
        }
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ a f65112a = new a();

        /* renamed from: b  reason: collision with root package name */
        public static final boolean f65113b;

        /* renamed from: c  reason: collision with root package name */
        public static final List<String> f65114c;

        /* renamed from: d  reason: collision with root package name */
        public static final List<String> f65115d;

        /* renamed from: e  reason: collision with root package name */
        public static final String[] f65116e = {MessengerShareContentUtility.MEDIA_TYPE, "_display_name"};

        /* renamed from: f  reason: collision with root package name */
        public static final String[] f65117f = {IBridgeMediaLoader.COLUMN_BUCKET_ID, IBridgeMediaLoader.COLUMN_BUCKET_DISPLAY_NAME};

        static {
            int i11 = Build.VERSION.SDK_INT;
            f65113b = i11 >= 29;
            List<String> p11 = CollectionsKt__CollectionsKt.p("_display_name", "_data", "_id", "title", IBridgeMediaLoader.COLUMN_BUCKET_ID, IBridgeMediaLoader.COLUMN_BUCKET_DISPLAY_NAME, "width", "height", "orientation", "date_added", "date_modified", "mime_type", "datetaken");
            if (i11 >= 29) {
                p11.add("datetaken");
            }
            f65114c = p11;
            List<String> p12 = CollectionsKt__CollectionsKt.p("_display_name", "_data", "_id", "title", IBridgeMediaLoader.COLUMN_BUCKET_ID, IBridgeMediaLoader.COLUMN_BUCKET_DISPLAY_NAME, "date_added", "width", "height", "orientation", "date_modified", "mime_type", IBridgeMediaLoader.COLUMN_DURATION);
            if (i11 >= 29) {
                p12.add("datetaken");
            }
            f65115d = p12;
        }

        public final Uri a() {
            return MediaStore.Files.getContentUri("external");
        }

        public final String[] b() {
            return f65117f;
        }

        public final List<String> c() {
            return f65114c;
        }

        public final List<String> d() {
            return f65115d;
        }

        public final String[] e() {
            return f65116e;
        }

        public final boolean f() {
            return f65113b;
        }
    }

    boolean a(Context context);

    void b();

    List<String> c(Context context, List<String> list);

    com.fluttercandies.photo_manager.core.entity.b d(Context context, String str, String str2);

    Uri e();

    void f(Context context);

    void g(Context context, d dVar);

    void h(Context context, String str);

    String i(Context context, String str, int i11);

    Uri j(String str, int i11, boolean z11);

    com.fluttercandies.photo_manager.core.entity.b k(Context context, String str, String str2, String str3, String str4);

    List<com.fluttercandies.photo_manager.core.entity.b> l(Context context, String str, int i11, int i12, int i13, FilterOption filterOption);

    List<d> m(Context context, int i11, FilterOption filterOption);

    Long n(Context context, String str);

    com.fluttercandies.photo_manager.core.entity.b o(Context context, byte[] bArr, String str, String str2, String str3);

    com.fluttercandies.photo_manager.core.entity.b p(Context context, String str, String str2, String str3, String str4);

    List<com.fluttercandies.photo_manager.core.entity.b> q(Context context, String str, int i11, int i12, int i13, FilterOption filterOption);

    List<d> r(Context context, int i11, FilterOption filterOption);

    long s(Cursor cursor, String str);

    boolean t(Context context, String str);

    String u(Cursor cursor, String str);

    String v(Context context, String str, boolean z11);

    com.fluttercandies.photo_manager.core.entity.b w(Context context, String str);

    d x(Context context, String str, int i11, FilterOption filterOption);

    m1.a y(Context context, String str);

    com.fluttercandies.photo_manager.core.entity.b z(Context context, String str, String str2);
}
