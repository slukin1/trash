package p2;

import android.content.SharedPreferences;
import com.hbg.lib.network.pro.core.util.Period;
import java.util.Arrays;
import m2.e;
import q2.a;

public class b extends a implements c {

    /* renamed from: d  reason: collision with root package name */
    public final a f16368d;

    /* renamed from: e  reason: collision with root package name */
    public int f16369e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f16370f = 0;

    /* renamed from: g  reason: collision with root package name */
    public long f16371g = 0;

    public b(a aVar) {
        super(aVar.d().e(), aVar.d().f(), aVar.d().g());
        this.f16368d = aVar;
    }

    public void a(SharedPreferences sharedPreferences) {
        c(sharedPreferences.getString("server_region", ""), w2.a.k(sharedPreferences.getString("serverIps", w2.a.c(e.f16150a))), w2.a.j(sharedPreferences.getString("ports", (String) null)));
        this.f16370f = sharedPreferences.getInt("current", 0);
        this.f16369e = sharedPreferences.getInt("last", 0);
        this.f16371g = sharedPreferences.getLong("servers_last_updated_time", 0);
    }

    public void b(SharedPreferences.Editor editor) {
        editor.putString("serverIps", w2.a.c(e()));
        editor.putString("ports", w2.a.b(f()));
        editor.putInt("current", this.f16370f);
        editor.putInt("last", this.f16369e);
        editor.putLong("servers_last_updated_time", this.f16371g);
        editor.putString("server_region", g());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass() || !super.equals(obj)) {
            return false;
        }
        b bVar = (b) obj;
        return this.f16369e == bVar.f16369e && this.f16370f == bVar.f16370f && this.f16371g == bVar.f16371g && this.f16368d.equals(bVar.f16368d);
    }

    public boolean h(String str, int i11) {
        String[] e11 = e();
        int[] f11 = f();
        if (e11 == null || !str.equals(e11[this.f16370f])) {
            return false;
        }
        if (f11 != null && f11[this.f16370f] != i11) {
            return false;
        }
        int i12 = this.f16370f + 1;
        this.f16370f = i12;
        if (i12 >= e11.length) {
            this.f16370f = 0;
        }
        return this.f16370f == this.f16369e;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(super.hashCode()), this.f16368d, Integer.valueOf(this.f16369e), Integer.valueOf(this.f16370f), Long.valueOf(this.f16371g)});
    }

    public String i() {
        int i11;
        String[] e11 = e();
        if (e11 == null || (i11 = this.f16370f) >= e11.length || i11 < 0) {
            return null;
        }
        return e11[i11];
    }

    public boolean j() {
        return System.currentTimeMillis() - this.f16371g >= Period.DAY_MILLS && e() != null && e().length > 0;
    }

    public boolean k(String str, int i11) {
        String[] e11 = e();
        int[] f11 = f();
        if (e11 == null || !e11[this.f16370f].equals(str) || (f11 != null && f11[this.f16370f] != i11)) {
            return false;
        }
        int i12 = this.f16369e;
        int i13 = this.f16370f;
        if (i12 == i13) {
            return true;
        }
        this.f16369e = i13;
        this.f16368d.f();
        return true;
    }

    public boolean l(String str, String[] strArr, int[] iArr) {
        if (!c(w2.a.h(str), strArr, iArr)) {
            return false;
        }
        this.f16369e = 0;
        this.f16370f = 0;
        if (w2.a.f(strArr, iArr, this.f16368d.d().e(), this.f16368d.d().f())) {
            return true;
        }
        this.f16371g = System.currentTimeMillis();
        this.f16368d.f();
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
        r1 = r3.f16370f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int m() {
        /*
            r3 = this;
            int[] r0 = r3.f()
            if (r0 == 0) goto L_0x001b
            int r1 = r3.f16370f
            int r2 = r0.length
            if (r1 >= r2) goto L_0x001b
            if (r1 >= 0) goto L_0x000e
            goto L_0x001b
        L_0x000e:
            r0 = r0[r1]
        L_0x0010:
            q2.a r1 = r3.f16368d
            java.lang.String r1 = r1.m()
            int r0 = w2.a.a(r0, r1)
            return r0
        L_0x001b:
            r0 = -1
            goto L_0x0010
        */
        throw new UnsupportedOperationException("Method not decompiled: p2.b.m():int");
    }
}
