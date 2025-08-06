package com.hbg.lib.core.screenshot;

import android.content.ContentResolver;
import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.Handler;
import android.os.HandlerThread;
import android.provider.MediaStore;
import android.text.TextUtils;
import com.hbg.lib.common.BaseApplication;
import i6.d;

public class ContentObserverListenerManager implements t6.a {

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f68505h = {"screenshot", "screen_shot", "screen-shot", "screen shot", "screencapture", "screen_capture", "screen-capture", "screen capture", "screencap", "screen_cap", "screen-cap", "screen cap", "snap", "截屏"};

    /* renamed from: i  reason: collision with root package name */
    public static final String[] f68506i = {"_data", "datetaken", "date_added"};

    /* renamed from: a  reason: collision with root package name */
    public Context f68507a = BaseApplication.b();

    /* renamed from: b  reason: collision with root package name */
    public ContentObserver f68508b;

    /* renamed from: c  reason: collision with root package name */
    public ContentObserver f68509c;

    /* renamed from: d  reason: collision with root package name */
    public t6.b f68510d;

    /* renamed from: e  reason: collision with root package name */
    public Handler f68511e = new Handler();

    /* renamed from: f  reason: collision with root package name */
    public String f68512f;

    /* renamed from: g  reason: collision with root package name */
    public Runnable f68513g = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            if (ContentObserverListenerManager.this.f68510d != null) {
                ContentObserverListenerManager.this.f68510d.a("ContentObserver", ContentObserverListenerManager.this.f68512f);
            }
        }
    }

    public class b extends ContentObserver {

        /* renamed from: a  reason: collision with root package name */
        public Uri f68515a;

        public b(Uri uri, Handler handler) {
            super(handler);
            this.f68515a = uri;
        }

        public void onChange(boolean z11) {
            super.onChange(z11);
            d.d("setOnScreenshotListener  MediaContentObserver  listenerManagerName：ContentObserver");
            if (Build.VERSION.SDK_INT >= 29) {
                ContentObserverListenerManager.this.j(this.f68515a);
            } else {
                ContentObserverListenerManager.this.i(this.f68515a);
            }
        }
    }

    public ContentObserverListenerManager() {
        HandlerThread handlerThread = new HandlerThread("ContentObserver");
        handlerThread.start();
        Handler handler = new Handler(handlerThread.getLooper());
        this.f68508b = new b(MediaStore.Images.Media.INTERNAL_CONTENT_URI, handler);
        this.f68509c = new b(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, handler);
    }

    public void a() {
        ContentResolver contentResolver = this.f68507a.getContentResolver();
        Uri uri = MediaStore.Images.Media.INTERNAL_CONTENT_URI;
        int i11 = Build.VERSION.SDK_INT;
        boolean z11 = true;
        contentResolver.registerContentObserver(uri, i11 > 29, this.f68508b);
        ContentResolver contentResolver2 = this.f68507a.getContentResolver();
        Uri uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
        if (i11 <= 29) {
            z11 = false;
        }
        contentResolver2.registerContentObserver(uri2, z11, this.f68509c);
    }

    public void b(t6.b bVar) {
        this.f68510d = bVar;
    }

    public void c() {
        this.f68507a.getContentResolver().unregisterContentObserver(this.f68508b);
        this.f68507a.getContentResolver().unregisterContentObserver(this.f68509c);
    }

    public final boolean h(String str, long j11) {
        String lowerCase = str.toLowerCase();
        for (String contains : f68505h) {
            if (lowerCase.contains(contains)) {
                return true;
            }
        }
        return false;
    }

    public final void i(Uri uri) {
        Cursor cursor = null;
        try {
            cursor = this.f68507a.getContentResolver().query(uri, f68506i, (String) null, (String[]) null, "date_added desc limit 1");
            if (cursor == null) {
                if (cursor != null && !cursor.isClosed()) {
                    cursor.close();
                }
            } else if (cursor.moveToFirst()) {
                int columnIndex = cursor.getColumnIndex("_data");
                int columnIndex2 = cursor.getColumnIndex("datetaken");
                String string = cursor.getString(columnIndex);
                if (h(string, cursor.getLong(columnIndex2))) {
                    this.f68511e.removeCallbacks(this.f68513g);
                    this.f68512f = string;
                    this.f68511e.postDelayed(this.f68513g, 500);
                }
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } else if (!cursor.isClosed()) {
                cursor.close();
            }
        } catch (Throwable th2) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th2;
        }
    }

    public final void j(Uri uri) {
        String[] strArr = {"_data", "datetaken", "date_added", "_display_name", "date_modified"};
        Bundle bundle = new Bundle();
        bundle.putInt("android:query-arg-limit", 1);
        bundle.putInt("android:query-arg-offset", 0);
        bundle.putInt("android:query-arg-sort-direction", 1);
        bundle.putStringArray("android:query-arg-sort-columns", new String[]{"date_modified"});
        bundle.putString("android:query-arg-sql-selection", "(_display_name like '%.png' or _display_name like '%.jpg') and _size > 0");
        Cursor cursor = null;
        try {
            cursor = this.f68507a.getContentResolver().query(uri, strArr, bundle, (CancellationSignal) null);
            if (cursor != null) {
                if (cursor.moveToFirst()) {
                    int columnIndex = cursor.getColumnIndex("_data");
                    int columnIndex2 = cursor.getColumnIndex("datetaken");
                    int columnIndex3 = cursor.getColumnIndex("date_added");
                    String string = cursor.getString(columnIndex);
                    long j11 = cursor.getLong(columnIndex2);
                    long j12 = cursor.getLong(columnIndex3);
                    d.d("setOnScreenshotListener  MediaContentObserver  data：" + string + " dateTaken:" + j11 + " dateAdded:" + j12);
                    if (TextUtils.equals(this.f68512f, string)) {
                        this.f68511e.removeCallbacks(this.f68513g);
                        this.f68511e.postDelayed(this.f68513g, 500);
                    } else if (j11 == 0) {
                        this.f68511e.removeCallbacks(this.f68513g);
                    } else if (h(string, j11)) {
                        this.f68511e.removeCallbacks(this.f68513g);
                        this.f68512f = string;
                        this.f68511e.postDelayed(this.f68513g, 500);
                    }
                }
                if (cursor.isClosed()) {
                    return;
                }
                cursor.close();
            } else if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
        } catch (Throwable th2) {
            if (cursor != null && !cursor.isClosed()) {
                cursor.close();
            }
            throw th2;
        }
    }
}
