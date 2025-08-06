package com.xiaomi.push;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.xiaomi.push.af;
import com.xiaomi.push.service.ah;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class bx {

    /* renamed from: a  reason: collision with root package name */
    private static volatile bx f51462a;

    /* renamed from: a  reason: collision with other field name */
    private Context f2573a;

    /* renamed from: a  reason: collision with other field name */
    private bw f2574a;
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with other field name */
    public final ArrayList<a> f2575a = new ArrayList<>();

    /* renamed from: a  reason: collision with other field name */
    private final HashMap<String, bv> f2576a = new HashMap<>();

    /* renamed from: a  reason: collision with other field name */
    private ThreadPoolExecutor f2577a = new ThreadPoolExecutor(1, 1, 15, TimeUnit.SECONDS, new LinkedBlockingQueue());

    public static class d extends a {

        /* renamed from: a  reason: collision with root package name */
        private String f51473a;

        /* renamed from: a  reason: collision with other field name */
        public String[] f2587a;

        public d(String str, String str2, String[] strArr) {
            super(str);
            this.f51473a = str2;
            this.f2587a = strArr;
        }

        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.delete(this.f51465b, this.f51473a, this.f2587a);
        }
    }

    public static class e extends a {

        /* renamed from: a  reason: collision with root package name */
        private ContentValues f51474a;

        public e(String str, ContentValues contentValues) {
            super(str);
            this.f51474a = contentValues;
        }

        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            sQLiteDatabase.insert(this.f51465b, (String) null, this.f51474a);
        }
    }

    private bx(Context context) {
        this.f2573a = context;
    }

    public void b(a aVar) {
        bv bvVar;
        if (aVar != null) {
            if (this.f2574a != null) {
                String a11 = aVar.a();
                synchronized (this.f2576a) {
                    bvVar = this.f2576a.get(a11);
                    if (bvVar == null) {
                        bvVar = this.f2574a.a(this.f2573a, a11);
                        this.f2576a.put(a11, bvVar);
                    }
                }
                if (!this.f2577a.isShutdown()) {
                    aVar.a(bvVar, this.f2573a);
                    a((Runnable) aVar);
                    return;
                }
                return;
            }
            throw new IllegalStateException("should exec init method first!");
        }
    }

    public static class c extends a {

        /* renamed from: a  reason: collision with root package name */
        private ArrayList<a> f51472a;

        public c(String str, ArrayList<a> arrayList) {
            super(str);
            ArrayList<a> arrayList2 = new ArrayList<>();
            this.f51472a = arrayList2;
            arrayList2.addAll(arrayList);
        }

        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            Iterator<a> it2 = this.f51472a.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                if (next != null) {
                    next.a(context, sQLiteDatabase);
                }
            }
        }

        public final void a(Context context) {
            super.a(context);
            Iterator<a> it2 = this.f51472a.iterator();
            while (it2.hasNext()) {
                a next = it2.next();
                if (next != null) {
                    next.a(context);
                }
            }
        }
    }

    public static bx a(Context context) {
        if (f51462a == null) {
            synchronized (bx.class) {
                if (f51462a == null) {
                    f51462a = new bx(context);
                }
            }
        }
        return f51462a;
    }

    public static abstract class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private int f51464a = 0;

        /* renamed from: a  reason: collision with other field name */
        public bv f2578a = null;

        /* renamed from: a  reason: collision with other field name */
        private a f2579a;

        /* renamed from: a  reason: collision with other field name */
        private String f2580a;

        /* renamed from: a  reason: collision with other field name */
        private WeakReference<Context> f2581a;

        /* renamed from: a  reason: collision with other field name */
        private Random f2582a = new Random();

        /* renamed from: b  reason: collision with root package name */
        public String f51465b;

        public a(String str) {
            this.f2580a = str;
        }

        /* renamed from: a  reason: collision with other method in class */
        public Object m2448a() {
            return null;
        }

        public abstract void a(Context context, SQLiteDatabase sQLiteDatabase);

        public void a(bv bvVar, Context context) {
            this.f2578a = bvVar;
            this.f51465b = bvVar.a();
            this.f2581a = new WeakReference<>(context);
        }

        public void b(Context context) {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
            r0 = (android.content.Context) r0.get();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void run() {
            /*
                r4 = this;
                java.lang.ref.WeakReference<android.content.Context> r0 = r4.f2581a
                if (r0 != 0) goto L_0x0005
                return
            L_0x0005:
                java.lang.Object r0 = r0.get()
                android.content.Context r0 = (android.content.Context) r0
                if (r0 == 0) goto L_0x0040
                java.io.File r1 = r0.getFilesDir()
                if (r1 == 0) goto L_0x0040
                com.xiaomi.push.bv r1 = r4.f2578a
                if (r1 == 0) goto L_0x0040
                java.lang.String r1 = r4.f2580a
                boolean r1 = android.text.TextUtils.isEmpty(r1)
                if (r1 == 0) goto L_0x0020
                goto L_0x0040
            L_0x0020:
                java.io.File r1 = new java.io.File
                java.lang.String r2 = r4.f2580a
                r1.<init>(r2)
                java.io.File r2 = new java.io.File
                java.io.File r3 = r1.getParentFile()
                java.lang.String r1 = r1.getAbsolutePath()
                java.lang.String r1 = com.xiaomi.push.bb.b(r1)
                r2.<init>(r3, r1)
                com.xiaomi.push.bx$a$1 r1 = new com.xiaomi.push.bx$a$1
                r1.<init>(r0)
                com.xiaomi.push.v.a(r0, r2, r1)
            L_0x0040:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xiaomi.push.bx.a.run():void");
        }

        /* renamed from: a  reason: collision with other method in class */
        public boolean m2450a() {
            return this.f2578a == null || TextUtils.isEmpty(this.f51465b) || this.f2581a == null;
        }

        public void a(a aVar) {
            this.f2579a = aVar;
        }

        public void a(Context context, Object obj) {
            bx.a(context).a(this);
        }

        /* renamed from: a  reason: collision with other method in class */
        public String m2449a() {
            return this.f2580a;
        }

        public SQLiteDatabase a() {
            return this.f2578a.getWritableDatabase();
        }

        public void a(Context context) {
            a aVar = this.f2579a;
            if (aVar != null) {
                aVar.a(context, a());
            }
            b(context);
        }
    }

    private void a() {
        af.a(this.f2573a).b(new af.a() {
            public String a() {
                return "100957";
            }

            public void run() {
                synchronized (bx.this.f2575a) {
                    if (bx.this.f2575a.size() > 0) {
                        if (bx.this.f2575a.size() > 1) {
                            bx bxVar = bx.this;
                            bxVar.a((ArrayList<a>) bxVar.f2575a);
                        } else {
                            bx bxVar2 = bx.this;
                            bxVar2.b((a) bxVar2.f2575a.get(0));
                        }
                        bx.this.f2575a.clear();
                        System.gc();
                    }
                }
            }
        }, ah.a(this.f2573a).a(gl.StatDataProcessFrequency.a(), 5));
    }

    public static abstract class b<T> extends a {

        /* renamed from: a  reason: collision with root package name */
        private int f51467a;

        /* renamed from: a  reason: collision with other field name */
        private String f2584a;

        /* renamed from: a  reason: collision with other field name */
        private List<String> f2585a;

        /* renamed from: a  reason: collision with other field name */
        private String[] f2586a;

        /* renamed from: b  reason: collision with root package name */
        private List<T> f51468b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private String f51469c;

        /* renamed from: d  reason: collision with root package name */
        private String f51470d;

        /* renamed from: e  reason: collision with root package name */
        private String f51471e;

        public b(String str, List<String> list, String str2, String[] strArr, String str3, String str4, String str5, int i11) {
            super(str);
            this.f2585a = list;
            this.f2584a = str2;
            this.f2586a = strArr;
            this.f51469c = str3;
            this.f51470d = str4;
            this.f51471e = str5;
            this.f51467a = i11;
        }

        public abstract T a(Context context, Cursor cursor);

        public void a(Context context, SQLiteDatabase sQLiteDatabase) {
            String[] strArr;
            this.f51468b.clear();
            List<String> list = this.f2585a;
            String str = null;
            if (list == null || list.size() <= 0) {
                strArr = null;
            } else {
                String[] strArr2 = new String[this.f2585a.size()];
                this.f2585a.toArray(strArr2);
                strArr = strArr2;
            }
            int i11 = this.f51467a;
            if (i11 > 0) {
                str = String.valueOf(i11);
            }
            Cursor query = sQLiteDatabase.query(this.f51465b, strArr, this.f2584a, this.f2586a, this.f51469c, this.f51470d, this.f51471e, str);
            if (query != null && query.moveToFirst()) {
                do {
                    Object a11 = a(context, query);
                    if (a11 != null) {
                        this.f51468b.add(a11);
                    }
                } while (query.moveToNext());
                query.close();
            }
            a(context, this.f51468b);
        }

        public abstract void a(Context context, List<T> list);

        public SQLiteDatabase a() {
            return this.f2578a.getReadableDatabase();
        }
    }

    public void a(a aVar) {
        bv bvVar;
        if (aVar != null) {
            if (this.f2574a != null) {
                String a11 = aVar.a();
                synchronized (this.f2576a) {
                    bvVar = this.f2576a.get(a11);
                    if (bvVar == null) {
                        bvVar = this.f2574a.a(this.f2573a, a11);
                        this.f2576a.put(a11, bvVar);
                    }
                }
                if (!this.f2577a.isShutdown()) {
                    aVar.a(bvVar, this.f2573a);
                    synchronized (this.f2575a) {
                        this.f2575a.add(aVar);
                        a();
                    }
                    return;
                }
                return;
            }
            throw new IllegalStateException("should exec init method first!");
        }
    }

    public void a(Runnable runnable) {
        if (!this.f2577a.isShutdown()) {
            this.f2577a.execute(runnable);
        }
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2447a(String str) {
        return a(str).a();
    }

    public void a(ArrayList<a> arrayList) {
        if (this.f2574a != null) {
            HashMap hashMap = new HashMap();
            if (!this.f2577a.isShutdown()) {
                Iterator<a> it2 = arrayList.iterator();
                while (it2.hasNext()) {
                    a next = it2.next();
                    if (next.a()) {
                        next.a(a(next.a()), this.f2573a);
                    }
                    ArrayList arrayList2 = (ArrayList) hashMap.get(next.a());
                    if (arrayList2 == null) {
                        arrayList2 = new ArrayList();
                        hashMap.put(next.a(), arrayList2);
                    }
                    arrayList2.add(next);
                }
                for (String str : hashMap.keySet()) {
                    ArrayList arrayList3 = (ArrayList) hashMap.get(str);
                    if (arrayList3 != null && arrayList3.size() > 0) {
                        c cVar = new c(str, arrayList3);
                        cVar.a(((a) arrayList3.get(0)).f2578a, this.f2573a);
                        this.f2577a.execute(cVar);
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalStateException("should exec setDbHelperFactory method first!");
    }

    private bv a(String str) {
        bv bvVar = this.f2576a.get(str);
        if (bvVar == null) {
            synchronized (this.f2576a) {
                if (bvVar == null) {
                    bvVar = this.f2574a.a(this.f2573a, str);
                    this.f2576a.put(str, bvVar);
                }
            }
        }
        return bvVar;
    }
}
