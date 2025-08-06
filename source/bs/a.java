package bs;

import android.view.View;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.huobi.staring.viewhandler.AllRemindListItemHandler;
import pro.huobi.R;

public class a implements ka.a {

    /* renamed from: b  reason: collision with root package name */
    public long f77025b;

    /* renamed from: c  reason: collision with root package name */
    public String f77026c;

    /* renamed from: d  reason: collision with root package name */
    public String f77027d;

    /* renamed from: e  reason: collision with root package name */
    public int f77028e;

    /* renamed from: f  reason: collision with root package name */
    public int f77029f;

    /* renamed from: g  reason: collision with root package name */
    public RemindContractType f77030g;

    /* renamed from: h  reason: collision with root package name */
    public RemindBusinessType f77031h;

    /* renamed from: i  reason: collision with root package name */
    public C0828a f77032i;

    /* renamed from: bs.a$a  reason: collision with other inner class name */
    public interface C0828a {
        boolean a();

        void b(boolean z11);

        boolean c(a aVar);

        void d(boolean z11, a aVar);

        int e(RemindContractType remindContractType, RemindBusinessType remindBusinessType, String str);

        boolean f();

        String g(RemindContractType remindContractType, RemindBusinessType remindBusinessType, String str);

        void h(a aVar, View view, View view2);

        void i(a aVar);

        void j(a aVar);

        String k(RemindContractType remindContractType, RemindBusinessType remindBusinessType, String str, String str2);
    }

    public a(long j11, String str, String str2, int i11, int i12, RemindContractType remindContractType, RemindBusinessType remindBusinessType, C0828a aVar) {
        this.f77025b = j11;
        this.f77026c = str;
        this.f77027d = str2;
        this.f77028e = i11;
        this.f77029f = i12;
        this.f77030g = remindContractType;
        this.f77031h = remindBusinessType;
        this.f77032i = aVar;
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public RemindBusinessType b() {
        return this.f77031h;
    }

    public C0828a c() {
        return this.f77032i;
    }

    public int d() {
        return this.f77028e;
    }

    public RemindContractType e() {
        return this.f77030g;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.a(this) || h() != aVar.h()) {
            return false;
        }
        String i11 = i();
        String i12 = aVar.i();
        if (i11 != null ? !i11.equals(i12) : i12 != null) {
            return false;
        }
        String f11 = f();
        String f12 = aVar.f();
        if (f11 != null ? !f11.equals(f12) : f12 != null) {
            return false;
        }
        if (d() != aVar.d() || g() != aVar.g()) {
            return false;
        }
        RemindContractType e11 = e();
        RemindContractType e12 = aVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        RemindBusinessType b11 = b();
        RemindBusinessType b12 = aVar.b();
        if (b11 != null ? !b11.equals(b12) : b12 != null) {
            return false;
        }
        C0828a c11 = c();
        C0828a c12 = aVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public String f() {
        return this.f77027d;
    }

    public int g() {
        return this.f77029f;
    }

    public int getResId() {
        return R.layout.staring_layout_all_remind_list_item;
    }

    public String getViewHandlerName() {
        return AllRemindListItemHandler.class.getName();
    }

    public long h() {
        return this.f77025b;
    }

    public int hashCode() {
        long h11 = h();
        String i11 = i();
        int i12 = 43;
        int hashCode = ((((int) (h11 ^ (h11 >>> 32))) + 59) * 59) + (i11 == null ? 43 : i11.hashCode());
        String f11 = f();
        int hashCode2 = (((((hashCode * 59) + (f11 == null ? 43 : f11.hashCode())) * 59) + d()) * 59) + g();
        RemindContractType e11 = e();
        int hashCode3 = (hashCode2 * 59) + (e11 == null ? 43 : e11.hashCode());
        RemindBusinessType b11 = b();
        int hashCode4 = (hashCode3 * 59) + (b11 == null ? 43 : b11.hashCode());
        C0828a c11 = c();
        int i13 = hashCode4 * 59;
        if (c11 != null) {
            i12 = c11.hashCode();
        }
        return i13 + i12;
    }

    public String i() {
        return this.f77026c;
    }

    public boolean isSticky() {
        return false;
    }

    public void j(int i11) {
        this.f77028e = i11;
    }

    public String toString() {
        return "AllRemindListItem(id=" + h() + ", title=" + i() + ", desc=" + f() + ", cancelBtnStatus=" + d() + ", direction=" + g() + ", contractType=" + e() + ", businessType=" + b() + ", callback=" + c() + ")";
    }
}
