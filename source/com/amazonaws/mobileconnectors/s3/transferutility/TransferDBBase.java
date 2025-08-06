package com.amazonaws.mobileconnectors.s3.transferutility;

import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.text.TextUtils;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;

class TransferDBBase {

    /* renamed from: f  reason: collision with root package name */
    public static final Log f14958f = LogFactory.b(TransferDBBase.class);

    /* renamed from: g  reason: collision with root package name */
    public static final Object f14959g = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Context f14960a;

    /* renamed from: b  reason: collision with root package name */
    public final Uri f14961b;

    /* renamed from: c  reason: collision with root package name */
    public final UriMatcher f14962c;

    /* renamed from: d  reason: collision with root package name */
    public final TransferDatabaseHelper f14963d;

    /* renamed from: e  reason: collision with root package name */
    public SQLiteDatabase f14964e;

    public TransferDBBase(Context context) {
        this.f14960a = context;
        String packageName = context.getApplicationContext().getPackageName();
        TransferDatabaseHelper transferDatabaseHelper = new TransferDatabaseHelper(context);
        this.f14963d = transferDatabaseHelper;
        this.f14964e = transferDatabaseHelper.getWritableDatabase();
        this.f14961b = Uri.parse("content://" + packageName + "/" + "transfers");
        UriMatcher uriMatcher = new UriMatcher(-1);
        this.f14962c = uriMatcher;
        uriMatcher.addURI(packageName, "transfers", 10);
        uriMatcher.addURI(packageName, "transfers/#", 20);
        uriMatcher.addURI(packageName, "transfers/part/#", 30);
        uriMatcher.addURI(packageName, "transfers/state/*", 40);
    }

    public int a(Uri uri, String str, String[] strArr) {
        int match = this.f14962c.match(uri);
        b();
        if (match == 10) {
            return this.f14964e.delete("awstransfer", str, strArr);
        }
        if (match == 20) {
            String lastPathSegment = uri.getLastPathSegment();
            if (TextUtils.isEmpty(str)) {
                SQLiteDatabase sQLiteDatabase = this.f14964e;
                return sQLiteDatabase.delete("awstransfer", "_id=" + lastPathSegment, (String[]) null);
            }
            SQLiteDatabase sQLiteDatabase2 = this.f14964e;
            return sQLiteDatabase2.delete("awstransfer", "_id=" + lastPathSegment + " and " + str, strArr);
        }
        throw new IllegalArgumentException("Unknown URI: " + uri);
    }

    public final void b() {
        synchronized (f14959g) {
            if (!this.f14964e.isOpen()) {
                this.f14964e = this.f14963d.getWritableDatabase();
            }
        }
    }

    public Uri c() {
        return this.f14961b;
    }

    public Cursor d(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        SQLiteQueryBuilder sQLiteQueryBuilder = new SQLiteQueryBuilder();
        sQLiteQueryBuilder.setTables("awstransfer");
        int match = this.f14962c.match(uri);
        if (match == 10) {
            sQLiteQueryBuilder.appendWhere("part_num=0");
        } else if (match == 20) {
            sQLiteQueryBuilder.appendWhere("_id=" + uri.getLastPathSegment());
        } else if (match == 30) {
            sQLiteQueryBuilder.appendWhere("main_upload_id=" + uri.getLastPathSegment());
        } else if (match == 40) {
            sQLiteQueryBuilder.appendWhere("state=");
            sQLiteQueryBuilder.appendWhereEscapeString(uri.getLastPathSegment());
        } else {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        b();
        return sQLiteQueryBuilder.query(this.f14964e, strArr, str, strArr2, (String) null, (String) null, str2);
    }

    public synchronized int e(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        int i11;
        int match = this.f14962c.match(uri);
        b();
        if (match == 10) {
            i11 = this.f14964e.update("awstransfer", contentValues, str, strArr);
        } else if (match == 20) {
            String lastPathSegment = uri.getLastPathSegment();
            if (TextUtils.isEmpty(str)) {
                SQLiteDatabase sQLiteDatabase = this.f14964e;
                i11 = sQLiteDatabase.update("awstransfer", contentValues, "_id=" + lastPathSegment, (String[]) null);
            } else {
                SQLiteDatabase sQLiteDatabase2 = this.f14964e;
                i11 = sQLiteDatabase2.update("awstransfer", contentValues, "_id=" + lastPathSegment + " and " + str, strArr);
            }
        } else {
            throw new IllegalArgumentException("Unknown URI: " + uri);
        }
        return i11;
    }
}
