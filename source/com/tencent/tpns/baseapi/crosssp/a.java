package com.tencent.tpns.baseapi.crosssp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.tpns.baseapi.base.SettingsContentProvider;
import com.tencent.tpns.baseapi.base.util.Logger;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static volatile a f49906a;

    /* renamed from: b  reason: collision with root package name */
    private Context f49907b;

    /* renamed from: com.tencent.tpns.baseapi.crosssp.a$a  reason: collision with other inner class name */
    public static class C0633a {

        /* renamed from: a  reason: collision with root package name */
        public Context f49908a;

        /* renamed from: b  reason: collision with root package name */
        private ContentValues f49909b;

        public void a() {
            try {
                ProviderMessage.insert(this.f49908a, SettingsContentProvider.getContentUri(this.f49908a, "key", "type"), this.f49909b);
            } catch (Throwable th2) {
                Logger.e("SettingsPreferences", TUIChatConstants.Group.MEMBER_APPLY, th2);
            }
        }

        public void b() {
            a();
        }

        private C0633a(Context context) {
            this.f49909b = new ContentValues();
            this.f49908a = context;
        }

        public C0633a a(String str, String str2) {
            this.f49909b.put(str, str2);
            return this;
        }

        public C0633a a(String str, long j11) {
            this.f49909b.put(str, Long.valueOf(j11));
            return this;
        }

        public C0633a a(String str, boolean z11) {
            this.f49909b.put(str, Boolean.valueOf(z11));
            return this;
        }

        public C0633a a(String str, int i11) {
            this.f49909b.put(str, Integer.valueOf(i11));
            return this;
        }

        public C0633a a(String str, float f11) {
            this.f49909b.put(str, Float.valueOf(f11));
            return this;
        }

        public C0633a a(ContentValues contentValues) {
            if (contentValues != null) {
                this.f49909b.putAll(contentValues);
            } else {
                Logger.w("SettingsPreferences", "putAll failed, values was null");
            }
            return this;
        }

        public void a(String str) {
            this.f49909b.putNull(str);
        }
    }

    private a(Context context) {
        this.f49907b = context.getApplicationContext();
    }

    public static a a(Context context) {
        if (f49906a == null) {
            synchronized (a.class) {
                if (f49906a == null) {
                    f49906a = new a(context);
                }
            }
        }
        return f49906a;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[], java.lang.String, android.database.Cursor] */
    public Object b(String str, String str2) {
        Boolean bool;
        ? r02 = 0;
        try {
            Cursor query = ProviderMessage.query(this.f49907b, SettingsContentProvider.getContentUri(this.f49907b, str, SettingsContentProvider.MEMORY_TYPE), r02, r02);
            Object objectValue = SettingsContentProvider.getObjectValue(query, str2);
            if (query != null && !query.isClosed()) {
                try {
                    query.close();
                } catch (Throwable unused) {
                }
            }
            return objectValue;
        } catch (Throwable unused2) {
        }
        return bool;
    }

    public C0633a a() {
        return new C0633a(this.f49907b);
    }

    public String a(String str, String str2) {
        Cursor cursor = null;
        try {
            Cursor query = ProviderMessage.query(this.f49907b, SettingsContentProvider.getContentUri(this.f49907b, str, "string"), (String[]) null, (String) null, (String[]) null, (String) null);
            String stringValue = SettingsContentProvider.getStringValue(query, str2);
            if (query != null) {
                try {
                    if (!query.isClosed()) {
                        query.close();
                    }
                } catch (Throwable unused) {
                }
            }
            return stringValue;
        } catch (Throwable unused2) {
        }
        return "";
    }

    public long a(String str, long j11) {
        Cursor cursor = null;
        try {
            Cursor query = ProviderMessage.query(this.f49907b, SettingsContentProvider.getContentUri(this.f49907b, str, "long"), (String[]) null, (String) null, (String[]) null, (String) null);
            long longValue = SettingsContentProvider.getLongValue(query, j11);
            if (query != null) {
                try {
                    if (!query.isClosed()) {
                        query.close();
                    }
                } catch (Throwable unused) {
                }
            }
            return longValue;
        } catch (Throwable unused2) {
        }
        return 0;
    }

    public float a(String str, float f11) {
        Cursor cursor = null;
        try {
            Cursor query = ProviderMessage.query(this.f49907b, SettingsContentProvider.getContentUri(this.f49907b, str, "float"), (String[]) null, (String) null, (String[]) null, (String) null);
            float floatValue = SettingsContentProvider.getFloatValue(query, f11);
            if (query != null) {
                try {
                    if (!query.isClosed()) {
                        query.close();
                    }
                } catch (Throwable unused) {
                }
            }
            return floatValue;
        } catch (Throwable unused2) {
        }
        return 0.0f;
    }

    /* JADX WARNING: type inference failed for: r0v0, types: [java.lang.String[], java.lang.String, android.database.Cursor] */
    public boolean a(String str, boolean z11) {
        ? r02 = 0;
        try {
            Cursor query = ProviderMessage.query(this.f49907b, SettingsContentProvider.getContentUri(this.f49907b, str, "boolean"), r02, r02);
            boolean booleanValue = SettingsContentProvider.getBooleanValue(query, z11);
            if (query != null) {
                try {
                    if (!query.isClosed()) {
                        query.close();
                    }
                } catch (Throwable unused) {
                }
            }
            return booleanValue;
        } catch (Throwable unused2) {
        }
        return false;
    }

    public int a(String str, int i11) {
        Cursor cursor = null;
        try {
            Cursor query = ProviderMessage.query(this.f49907b, SettingsContentProvider.getContentUri(this.f49907b, str, "integer"), (String[]) null, (String) null, (String[]) null, (String) null);
            int intValue = SettingsContentProvider.getIntValue(query, i11);
            if (query != null) {
                try {
                    if (!query.isClosed()) {
                        query.close();
                    }
                } catch (Throwable unused) {
                }
            }
            return intValue;
        } catch (Throwable unused2) {
        }
        return 0;
    }
}
