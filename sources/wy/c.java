package wy;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import com.ta.a.e.h;
import java.io.File;
import vy.f;
import wy.b;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public SharedPreferences f40639a = null;

    /* renamed from: b  reason: collision with root package name */
    public b f40640b = null;

    public c(Context context, String str, String str2) {
        String str3 = null;
        if (context != null) {
            this.f40639a = context.getSharedPreferences(str2, 0);
            try {
                str3 = Environment.getExternalStorageState();
            } catch (Exception e11) {
                h.d("PersistentConfiguration", e11, new Object[0]);
            }
            boolean z11 = !f.c(str3) && (str3.equals("mounted") || str3.equals("mounted_ro"));
            h.e("PersistentConfiguration", "PersistentConfiguration canRead", Boolean.valueOf(z11));
            if (z11 && !f.c(str)) {
                try {
                    d c11 = c(str);
                    if (c11 != null) {
                        this.f40640b = c11.e(str2, 0);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public int a() {
        SharedPreferences sharedPreferences = this.f40639a;
        int i11 = sharedPreferences != null ? sharedPreferences.getInt("type", 0) : 0;
        h.e("PersistentConfiguration", "getTypeFromSp type", Integer.valueOf(i11));
        return i11;
    }

    public final File b(String str) {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        if (externalStorageDirectory == null) {
            return null;
        }
        File file = new File(String.format("%s%s%s", new Object[]{externalStorageDirectory.getAbsolutePath(), File.separator, str}));
        if (!file.exists()) {
            file.mkdirs();
        }
        return file;
    }

    public final d c(String str) {
        File b11 = b(str);
        if (b11 != null) {
            return new d(b11.getAbsolutePath());
        }
        return null;
    }

    public void d(String str, int i11) {
        if (this.f40639a != null) {
            h.e("PersistentConfiguration", "writeUtdidToSp utdid", str);
            SharedPreferences.Editor edit = this.f40639a.edit();
            edit.putString("UTDID2", str);
            edit.putInt("type", i11);
            if (this.f40639a.getLong("t2", 0) == 0) {
                edit.putLong("t2", System.currentTimeMillis());
            }
            try {
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public boolean e(int i11) {
        boolean z11;
        SharedPreferences sharedPreferences;
        SharedPreferences.Editor edit;
        if (!(this.f40640b == null || (sharedPreferences = this.f40639a) == null || (edit = sharedPreferences.edit()) == null)) {
            edit.clear();
            edit.putString("UTDID2", this.f40640b.getString("UTDID2", ""));
            edit.putInt("type", i11);
            edit.putLong("t2", this.f40640b.getLong("t2", 0));
            try {
                z11 = edit.commit();
            } catch (Exception unused) {
            }
            h.e("PersistentConfiguration", "copyMySPToSP", Boolean.valueOf(z11));
            return z11;
        }
        z11 = false;
        h.e("PersistentConfiguration", "copyMySPToSP", Boolean.valueOf(z11));
        return z11;
    }

    public boolean f() {
        boolean z11;
        if (!(this.f40639a == null || this.f40640b == null)) {
            h.e("PersistentConfiguration", "copySPToMySP");
            b.a a11 = this.f40640b.a();
            if (a11 != null) {
                a11.b();
                a11.a("UTDID2", this.f40639a.getString("UTDID2", ""));
                a11.a("t2", this.f40639a.getLong("t2", 0));
                try {
                    z11 = a11.commit();
                } catch (Exception unused) {
                }
                h.e("PersistentConfiguration", "copySPToMySP", Boolean.valueOf(z11));
                return z11;
            }
        }
        z11 = false;
        h.e("PersistentConfiguration", "copySPToMySP", Boolean.valueOf(z11));
        return z11;
    }

    public void g(String str) {
        if (this.f40639a != null) {
            h.e("PersistentConfiguration", "updateUtdidToSp utdid", str);
            SharedPreferences.Editor edit = this.f40639a.edit();
            edit.putString("UTDID2", str);
            if (this.f40639a.getLong("t2", 0) == 0) {
                edit.putLong("t2", System.currentTimeMillis());
            }
            try {
                edit.commit();
            } catch (Exception unused) {
            }
        }
    }

    public String h() {
        SharedPreferences sharedPreferences = this.f40639a;
        String str = "";
        if (sharedPreferences != null) {
            str = sharedPreferences.getString("UTDID2", str);
        }
        h.e("PersistentConfiguration", "getUtdidFromSp utdid", str);
        return str;
    }

    public String i() {
        b bVar = this.f40640b;
        String str = "";
        if (bVar != null) {
            str = bVar.getString("UTDID2", str);
        }
        h.e("PersistentConfiguration", "getUtdidFromMySp utdid", str);
        return str;
    }
}
