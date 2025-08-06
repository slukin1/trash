package com.mob.tools.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.text.TextUtils;
import com.mob.commons.s;
import com.mob.tools.MobLog;
import com.mob.tools.proguard.PublicMemberKeeper;
import com.xiaomi.mipush.sdk.Constants;
import java.io.File;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SQLiteHelper implements PublicMemberKeeper {

    public static class SingleTableDB implements PublicMemberKeeper {

        /* renamed from: a  reason: collision with root package name */
        private String f28142a;

        /* renamed from: b  reason: collision with root package name */
        private String f28143b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public SQLiteDatabase f28144c;

        /* renamed from: d  reason: collision with root package name */
        private LinkedHashMap<String, String> f28145d;

        /* renamed from: e  reason: collision with root package name */
        private HashMap<String, Boolean> f28146e;

        /* renamed from: f  reason: collision with root package name */
        private String f28147f;

        /* renamed from: g  reason: collision with root package name */
        private boolean f28148g;

        public void addField(String str, String str2, boolean z11) {
            if (this.f28144c == null) {
                this.f28145d.put(str, str2);
                this.f28146e.put(str, Boolean.valueOf(z11));
            }
        }

        private SingleTableDB(String str, String str2) {
            this.f28142a = str;
            this.f28143b = str2;
            this.f28145d = new LinkedHashMap<>();
            this.f28146e = new HashMap<>();
        }

        /* JADX WARNING: type inference failed for: r2v0, types: [android.database.sqlite.SQLiteDatabase$CursorFactory, android.database.sqlite.SQLiteDatabase, android.database.Cursor] */
        /* access modifiers changed from: private */
        public void a() throws Throwable {
            if (!TextUtils.isEmpty(this.f28142a)) {
                File file = new File(this.f28142a);
                Cursor cursor = 0;
                if (this.f28144c != null && !file.exists()) {
                    this.f28144c.close();
                    try {
                        File parentFile = file.getParentFile();
                        if (parentFile != null && (!parentFile.exists() || !parentFile.isDirectory())) {
                            parentFile.delete();
                            parentFile.mkdirs();
                        }
                    } catch (Throwable unused) {
                    }
                    this.f28144c = cursor;
                }
                if (this.f28144c == null) {
                    if (!file.exists()) {
                        try {
                            File parentFile2 = file.getParentFile();
                            if (parentFile2 != null && (!parentFile2.exists() || !parentFile2.isDirectory())) {
                                parentFile2.delete();
                                parentFile2.mkdirs();
                                file.createNewFile();
                            }
                        } catch (Throwable unused2) {
                        }
                    }
                    SQLiteDatabase openOrCreateDatabase = SQLiteDatabase.openOrCreateDatabase(file, cursor);
                    this.f28144c = openOrCreateDatabase;
                    try {
                        cursor = openOrCreateDatabase.query(s.a("013Dfide^g]diVifXdhdfEd-fi+if.dj"), (String[]) null, s.a("017iRecRjf]iiihif6deHdcif$ed<df)f@iiih"), new String[]{s.a("005id-ffEgf"), this.f28143b}, (String) null, (String) null, (String) null);
                        if (cursor == null || cursor.getCount() <= 0) {
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("create table  ");
                            sb2.append(this.f28143b);
                            sb2.append("(");
                            for (Map.Entry next : this.f28145d.entrySet()) {
                                String str = (String) next.getKey();
                                String str2 = (String) next.getValue();
                                boolean booleanValue = this.f28146e.get(str).booleanValue();
                                boolean equals = str.equals(this.f28147f);
                                boolean z11 = equals ? this.f28148g : false;
                                sb2.append(str);
                                sb2.append(" ");
                                sb2.append(str2);
                                String str3 = "";
                                sb2.append(booleanValue ? " not null" : str3);
                                if (equals) {
                                    str3 = " primary key";
                                }
                                sb2.append(str3);
                                sb2.append(z11 ? " autoincrement," : Constants.ACCEPT_TIME_SEPARATOR_SP);
                            }
                            sb2.replace(sb2.length() - 1, sb2.length(), ");");
                            try {
                                SQLiteDatabase.class.getMethod(s.a("007f9ei0fcPeljjfe"), new Class[]{String.class}).invoke(this.f28144c, new Object[]{sb2.toString()});
                            } catch (Throwable th2) {
                                MobLog.getInstance().d(th2);
                            }
                        }
                    } finally {
                        if (cursor != 0) {
                            cursor.close();
                        }
                    }
                }
            } else {
                throw new Throwable("path is null");
            }
        }

        /* access modifiers changed from: private */
        public void b() {
            SQLiteDatabase sQLiteDatabase = this.f28144c;
            if (sQLiteDatabase != null) {
                sQLiteDatabase.close();
                this.f28144c = null;
            }
        }

        /* access modifiers changed from: private */
        public String c() {
            return this.f28143b;
        }
    }

    public static void close(SingleTableDB singleTableDB) {
        singleTableDB.b();
    }

    public static int delete(SingleTableDB singleTableDB, String str, String[] strArr) throws Throwable {
        singleTableDB.a();
        return singleTableDB.f28144c.delete(singleTableDB.c(), str, strArr);
    }

    public static SingleTableDB getDatabase(Context context, String str) {
        return getDatabase(context != null ? context.getDatabasePath(str).getPath() : null, str);
    }

    public static long insert(SingleTableDB singleTableDB, ContentValues contentValues) throws Throwable {
        singleTableDB.a();
        return singleTableDB.f28144c.replace(singleTableDB.c(), (String) null, contentValues);
    }

    public static Cursor query(SingleTableDB singleTableDB, String[] strArr, String str, String[] strArr2, String str2) throws Throwable {
        singleTableDB.a();
        return singleTableDB.f28144c.query(singleTableDB.c(), strArr, str, strArr2, (String) null, (String) null, str2);
    }

    public static int update(SingleTableDB singleTableDB, ContentValues contentValues, String str, String[] strArr) throws Throwable {
        singleTableDB.a();
        return singleTableDB.f28144c.update(singleTableDB.c(), contentValues, str, strArr);
    }

    public static SingleTableDB getDatabase(String str, String str2) {
        return new SingleTableDB(str, str2);
    }
}
