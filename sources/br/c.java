package br;

import android.app.Application;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import bh.j;
import i6.d;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import rx.Observable;
import rx.schedulers.Schedulers;

public class c {

    /* renamed from: c  reason: collision with root package name */
    public static volatile c f77020c;

    /* renamed from: a  reason: collision with root package name */
    public d f77021a;

    /* renamed from: b  reason: collision with root package name */
    public SQLiteDatabase f77022b = null;

    public c(Context context) {
        f77020c = this;
        p(context);
    }

    public static synchronized c g(Context context) {
        c cVar;
        synchronized (c.class) {
            if (f77020c == null) {
                f77020c = new c(context);
            }
            cVar = f77020c;
        }
        return cVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object n(List list) {
        SQLiteDatabase writableDatabase = this.f77021a.getWritableDatabase();
        this.f77022b = writableDatabase;
        writableDatabase.enableWriteAheadLogging();
        this.f77022b.beginTransaction();
        Iterator it2 = list.iterator();
        while (it2.hasNext()) {
            this.f77022b.delete("local_collecation_symbol_table", "symbolid=?", new String[]{(String) it2.next()});
        }
        this.f77022b.setTransactionSuccessful();
        this.f77022b.endTransaction();
        return 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object o(List list, List list2) {
        SQLiteDatabase writableDatabase = this.f77021a.getWritableDatabase();
        this.f77022b = writableDatabase;
        writableDatabase.enableWriteAheadLogging();
        this.f77022b.beginTransaction();
        this.f77022b.delete("local_collecation_symbol_table", (String) null, (String[]) null);
        for (int size = list2.size() - 1; size >= 0; size--) {
            if (!h((String) list2.get(size))) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("symbolid", (String) list.get(size));
                this.f77022b.insert("local_collecation_symbol_table", (String) null, contentValues);
            }
        }
        this.f77022b.setTransactionSuccessful();
        this.f77022b.endTransaction();
        return 0;
    }

    public void c() {
        try {
            this.f77021a.close();
        } catch (Exception unused) {
        }
    }

    public void d(List<String> list) {
        if (list != null && !list.isEmpty()) {
            Observable.just(list).map(new a(this)).observeOn(Schedulers.io()).subscribe();
        }
    }

    public void e(String str) {
        SQLiteDatabase writableDatabase = this.f77021a.getWritableDatabase();
        this.f77022b = writableDatabase;
        writableDatabase.enableWriteAheadLogging();
        this.f77022b.beginTransaction();
        this.f77022b.delete("local_collecation_symbol_table", "symbolid=?", new String[]{str});
        this.f77022b.setTransactionSuccessful();
        this.f77022b.endTransaction();
    }

    public int f(String str) {
        try {
            SQLiteDatabase writableDatabase = this.f77021a.getWritableDatabase();
            this.f77022b = writableDatabase;
            writableDatabase.enableWriteAheadLogging();
            this.f77022b.beginTransaction();
            int delete = this.f77022b.delete("user_symbol_table", "uid=?", new String[]{str});
            this.f77022b.setTransactionSuccessful();
            this.f77022b.endTransaction();
            return delete;
        } catch (Exception e11) {
            e11.printStackTrace();
            return -1;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003c, code lost:
        if (r2 == null) goto L_0x0041;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean h(java.lang.String r12) {
        /*
            r11 = this;
            br.d r0 = r11.f77021a
            android.database.sqlite.SQLiteDatabase r0 = r0.getReadableDatabase()
            r11.f77022b = r0
            r0.enableWriteAheadLogging()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "symbolid=?"
            r0.append(r1)
            r1 = 0
            r2 = 0
            android.database.sqlite.SQLiteDatabase r3 = r11.f77022b     // Catch:{ Exception -> 0x0038 }
            java.lang.String r4 = "local_collecation_symbol_table"
            r5 = 0
            java.lang.String r6 = r0.toString()     // Catch:{ Exception -> 0x0038 }
            r0 = 1
            java.lang.String[] r7 = new java.lang.String[r0]     // Catch:{ Exception -> 0x0038 }
            r7[r1] = r12     // Catch:{ Exception -> 0x0038 }
            r8 = 0
            r9 = 0
            r10 = 0
            android.database.Cursor r2 = r3.query(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ Exception -> 0x0038 }
            boolean r12 = r2.moveToNext()     // Catch:{ Exception -> 0x0038 }
            if (r12 == 0) goto L_0x003e
            r2.close()
            return r0
        L_0x0036:
            r12 = move-exception
            goto L_0x0042
        L_0x0038:
            r12 = move-exception
            i6.d.g(r12)     // Catch:{ all -> 0x0036 }
            if (r2 == 0) goto L_0x0041
        L_0x003e:
            r2.close()
        L_0x0041:
            return r1
        L_0x0042:
            if (r2 == 0) goto L_0x0047
            r2.close()
        L_0x0047:
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: br.c.h(java.lang.String):boolean");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0049, code lost:
        if (r1 == null) goto L_0x004e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<java.lang.String> i() {
        /*
            r10 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            br.d r1 = r10.f77021a
            android.database.sqlite.SQLiteDatabase r1 = r1.getReadableDatabase()
            r10.f77022b = r1
            r1.enableWriteAheadLogging()
            r1 = 0
            android.database.sqlite.SQLiteDatabase r2 = r10.f77022b     // Catch:{ Exception -> 0x0045 }
            java.lang.String r3 = "local_collecation_symbol_table"
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            java.lang.String r9 = "_id desc"
            android.database.Cursor r1 = r2.query(r3, r4, r5, r6, r7, r8, r9)     // Catch:{ Exception -> 0x0045 }
            int r2 = r1.getCount()     // Catch:{ Exception -> 0x0045 }
            if (r2 <= 0) goto L_0x004b
            boolean r2 = r1.moveToNext()     // Catch:{ Exception -> 0x0045 }
            if (r2 == 0) goto L_0x004b
        L_0x002c:
            boolean r2 = r1.isAfterLast()     // Catch:{ Exception -> 0x0045 }
            if (r2 != 0) goto L_0x004b
            java.lang.String r2 = "symbolid"
            int r2 = r1.getColumnIndex(r2)     // Catch:{ Exception -> 0x0045 }
            java.lang.String r2 = r1.getString(r2)     // Catch:{ Exception -> 0x0045 }
            r0.add(r2)     // Catch:{ Exception -> 0x0045 }
            r1.moveToNext()     // Catch:{ Exception -> 0x0045 }
            goto L_0x002c
        L_0x0043:
            r0 = move-exception
            goto L_0x004f
        L_0x0045:
            r2 = move-exception
            i6.d.g(r2)     // Catch:{ all -> 0x0043 }
            if (r1 == 0) goto L_0x004e
        L_0x004b:
            r1.close()
        L_0x004e:
            return r0
        L_0x004f:
            if (r1 == 0) goto L_0x0054
            r1.close()
        L_0x0054:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: br.c.i():java.util.List");
    }

    public List<String> j(String str) {
        ArrayList arrayList = new ArrayList();
        try {
            SQLiteDatabase readableDatabase = this.f77021a.getReadableDatabase();
            this.f77022b = readableDatabase;
            readableDatabase.enableWriteAheadLogging();
            Cursor rawQuery = this.f77022b.rawQuery("SELECT * FROM user_symbol_table WHERE uid = ? ORDER BY search_time DESC", new String[]{str});
            if (rawQuery.getCount() == 0) {
                return arrayList;
            }
            rawQuery.moveToFirst();
            do {
                arrayList.add(rawQuery.getString(rawQuery.getColumnIndex("search_key_word")));
            } while (rawQuery.moveToNext());
            rawQuery.close();
            this.f77022b.close();
            return arrayList;
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public Observable<Object> k(List<String> list) {
        return Observable.just(list).subscribeOn(Schedulers.io()).map(new b(this, list));
    }

    public void l(String str) {
        if (!h(str)) {
            SQLiteDatabase writableDatabase = this.f77021a.getWritableDatabase();
            this.f77022b = writableDatabase;
            writableDatabase.enableWriteAheadLogging();
            this.f77022b.beginTransaction();
            ContentValues contentValues = new ContentValues();
            contentValues.put("symbolid", str);
            this.f77022b.insert("local_collecation_symbol_table", (String) null, contentValues);
            this.f77022b.setTransactionSuccessful();
            this.f77022b.endTransaction();
        }
    }

    public long m(String str, String str2) {
        String str3 = str;
        String str4 = str2;
        if (TextUtils.isEmpty(str2)) {
            return -1;
        }
        try {
            SQLiteDatabase writableDatabase = this.f77021a.getWritableDatabase();
            this.f77022b = writableDatabase;
            writableDatabase.enableWriteAheadLogging();
            Cursor rawQuery = this.f77022b.rawQuery("SELECT * FROM user_symbol_table WHERE uid = ? AND search_key_word = ?", new String[]{str3, str4});
            boolean z11 = rawQuery.getCount() != 1;
            rawQuery.close();
            Cursor rawQuery2 = this.f77022b.rawQuery("SELECT * FROM user_symbol_table WHERE uid = ? ORDER BY search_time DESC", new String[]{str3});
            if (rawQuery2.getCount() >= 12 && z11) {
                rawQuery2.moveToLast();
                this.f77022b.delete("user_symbol_table", "search_key_word = ? AND uid = ?", new String[]{rawQuery2.getString(rawQuery2.getColumnIndex("search_key_word")), str3});
            }
            rawQuery2.close();
            ContentValues contentValues = new ContentValues();
            contentValues.put("uid", str3);
            contentValues.put("search_key_word", str4);
            contentValues.put("search_time", String.valueOf(System.currentTimeMillis()));
            if (z11) {
                return this.f77022b.insert("user_symbol_table", (String) null, contentValues);
            }
            return (long) this.f77022b.update("user_symbol_table", contentValues, "search_key_word = ? AND uid = ?", new String[]{str4, str3});
        } catch (Exception e11) {
            e11.printStackTrace();
            this.f77022b.close();
            return -1;
        }
    }

    public c p(Context context) {
        try {
            if (context instanceof Application) {
                this.f77021a = new d(context);
            } else if (context != null) {
                this.f77021a = new d(context.getApplicationContext());
            } else {
                this.f77021a = new d(j.c());
            }
        } catch (Exception e11) {
            d.g(e11);
        }
        return this;
    }
}
