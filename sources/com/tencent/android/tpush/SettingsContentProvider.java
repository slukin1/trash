package com.tencent.android.tpush;

import android.annotation.SuppressLint;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.os.Build;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.tencent.android.tpush.logging.TLogger;
import com.tencent.tpns.baseapi.base.util.Util;
import java.util.Map;

public class SettingsContentProvider extends ContentProvider {
    public static Uri BASE_URI = null;
    public static final String BOOLEAN_TYPE = "boolean";
    public static final String FLOAT_TYPE = "float";
    public static final String INT_TYPE = "integer";
    public static final String KEY = "key";
    public static final String LONG_TYPE = "long";
    public static final String PREFFERENCE_AUTHORITY = "TPUSH_PROVIDER";
    public static final String STRING_TYPE = "string";
    public static final String TYPE = "type";

    /* renamed from: a  reason: collision with root package name */
    private static UriMatcher f67761a;

    /* renamed from: b  reason: collision with root package name */
    private static String f67762b;

    /* renamed from: c  reason: collision with root package name */
    private Object f67763c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private Context f67764d;

    /* renamed from: e  reason: collision with root package name */
    private SharedPreferences f67765e = null;

    public SettingsContentProvider(Context context) {
        if (context != null) {
            this.f67764d = context.getApplicationContext();
        }
    }

    private void a(Context context) {
        if (f67762b == null) {
            f67762b = context.getPackageName() + InstructionFileId.DOT + PREFFERENCE_AUTHORITY;
        }
        if (f67761a == null) {
            UriMatcher uriMatcher = new UriMatcher(-1);
            f67761a = uriMatcher;
            uriMatcher.addURI(f67762b, "*/*", 65536);
        }
        if (BASE_URI == null) {
            BASE_URI = Uri.parse("content://" + f67762b);
        }
        this.f67764d = context.getApplicationContext();
    }

    public static boolean getBooleanValue(Cursor cursor, boolean z11) {
        if (cursor == null) {
            return z11;
        }
        if (cursor.moveToFirst()) {
            z11 = false;
            if (cursor.getInt(0) > 0) {
                z11 = true;
            }
        }
        cursor.close();
        return z11;
    }

    public static final Uri getContentUri(Context context, String str, String str2) {
        if (BASE_URI == null) {
            if (f67762b == null) {
                f67762b = context.getPackageName() + InstructionFileId.DOT + PREFFERENCE_AUTHORITY;
            }
            BASE_URI = Uri.parse("content://" + f67762b);
        }
        return BASE_URI.buildUpon().appendPath(str).appendPath(str2).build();
    }

    public static float getFloatValue(Cursor cursor, float f11) {
        if (cursor == null) {
            return f11;
        }
        if (cursor.moveToFirst()) {
            f11 = cursor.getFloat(0);
        }
        cursor.close();
        return f11;
    }

    public static int getIntValue(Cursor cursor, int i11) {
        if (cursor == null) {
            return i11;
        }
        if (cursor.moveToFirst()) {
            i11 = cursor.getInt(0);
        }
        cursor.close();
        return i11;
    }

    public static long getLongValue(Cursor cursor, long j11) {
        if (cursor == null) {
            return j11;
        }
        if (cursor.moveToFirst()) {
            j11 = cursor.getLong(0);
        }
        cursor.close();
        return j11;
    }

    public static String getStringValue(Cursor cursor, String str) {
        if (cursor == null) {
            return str;
        }
        if (cursor.moveToFirst()) {
            str = cursor.getString(0);
        }
        cursor.close();
        return str;
    }

    public int delete(Uri uri, String str, String[] strArr) {
        a();
        if (f67761a.match(uri) != 65536) {
            TLogger.e("SettingsContentProvider", "Unsupported uri " + uri);
            return 0;
        }
        this.f67765e.edit().clear().commit();
        return 0;
    }

    public String getType(Uri uri) {
        return "vnd.android.cursor.item/vnd.TPUSH_PROVIDER.item";
    }

    @SuppressLint({"NewApi"})
    public Uri insert(Uri uri, ContentValues contentValues) {
        a();
        try {
            if (f67761a.match(uri) != 65536) {
                TLogger.e("SettingsContentProvider", "Unsupported uri " + uri);
                return null;
            }
            SharedPreferences.Editor edit = this.f67765e.edit();
            for (Map.Entry next : contentValues.valueSet()) {
                Object value = next.getValue();
                String key = Util.getKey((String) next.getKey());
                if (value == null) {
                    edit.remove(key);
                } else if (value instanceof String) {
                    edit.putString(key, (String) value);
                } else if (value instanceof Boolean) {
                    edit.putBoolean(key, ((Boolean) value).booleanValue());
                } else if (value instanceof Long) {
                    edit.putLong(key, ((Long) value).longValue());
                } else if (value instanceof Integer) {
                    edit.putInt(key, ((Integer) value).intValue());
                } else if (value instanceof Float) {
                    edit.putFloat(key, ((Float) value).floatValue());
                } else {
                    TLogger.e("SettingsContentProvider", "Unsupported type " + uri);
                }
            }
            if (Build.VERSION.SDK_INT > 8) {
                edit.apply();
                return null;
            }
            edit.commit();
            return null;
        } catch (Throwable th2) {
            TLogger.e("SettingsContentProvider", "insert exception uri " + uri, th2);
            return null;
        }
    }

    public boolean onCreate() {
        TLogger.d("SettingsContentProvider", "action - onCreate");
        a(getContext());
        return true;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        Object obj;
        a();
        MatrixCursor matrixCursor = null;
        try {
            if (f67761a.match(uri) != 65536) {
                TLogger.e("SettingsContentProvider", "Unsupported uri " + uri);
                return null;
            }
            int i11 = 0;
            String key = Util.getKey(uri.getPathSegments().get(0));
            String str3 = uri.getPathSegments().get(1);
            MatrixCursor matrixCursor2 = new MatrixCursor(new String[]{key});
            try {
                if (!this.f67765e.contains(key)) {
                    return matrixCursor2;
                }
                MatrixCursor.RowBuilder newRow = matrixCursor2.newRow();
                if ("string".equals(str3)) {
                    obj = this.f67765e.getString(key, (String) null);
                } else if ("boolean".equals(str3)) {
                    if (this.f67765e.getBoolean(key, false)) {
                        i11 = 1;
                    }
                    obj = Integer.valueOf(i11);
                } else if ("long".equals(str3)) {
                    obj = Long.valueOf(this.f67765e.getLong(key, 0));
                } else if ("integer".equals(str3)) {
                    obj = Integer.valueOf(this.f67765e.getInt(key, 0));
                } else if ("float".equals(str3)) {
                    obj = Float.valueOf(this.f67765e.getFloat(key, 0.0f));
                } else {
                    TLogger.e("SettingsContentProvider", "Unsupported type " + uri);
                    return matrixCursor2;
                }
                newRow.add(obj);
                return matrixCursor2;
            } catch (Throwable th2) {
                th = th2;
                matrixCursor = matrixCursor2;
                TLogger.e("SettingsContentProvider", "query exception uri " + uri, th);
                return matrixCursor;
            }
        } catch (Throwable th3) {
            th = th3;
            TLogger.e("SettingsContentProvider", "query exception uri " + uri, th);
            return matrixCursor;
        }
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        a();
        TLogger.e("SettingsContentProvider", "UnsupportedOperation: update!");
        return 0;
    }

    public SettingsContentProvider() {
    }

    private void a() {
        if (this.f67765e == null) {
            synchronized (this.f67763c) {
                if (this.f67765e == null) {
                    if (this.f67764d == null) {
                        this.f67764d = getContext().getApplicationContext();
                    }
                    Context context = this.f67764d;
                    if (context != null) {
                        this.f67765e = context.getApplicationContext().getSharedPreferences(".xg.vip.settings.xml", 0);
                    }
                }
            }
        }
    }
}
