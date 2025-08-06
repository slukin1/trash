package ps;

import android.content.Context;
import com.hbg.lib.network.swap.core.bean.SwapTriggerOrderInfo;
import com.huobi.swap.handler.SwapCurrentStopOrderHandler;

public class a implements s9.a {

    /* renamed from: b  reason: collision with root package name */
    public SwapTriggerOrderInfo f84574b;

    /* renamed from: c  reason: collision with root package name */
    public transient String f84575c;

    /* renamed from: d  reason: collision with root package name */
    public C0884a f84576d;

    /* renamed from: ps.a$a  reason: collision with other inner class name */
    public interface C0884a {
        void a(a aVar, Context context);

        void b(a aVar);
    }

    public a(SwapTriggerOrderInfo swapTriggerOrderInfo) {
        this.f84574b = swapTriggerOrderInfo;
    }

    public boolean a(Object obj) {
        return obj instanceof a;
    }

    public C0884a c() {
        return this.f84576d;
    }

    public String d() {
        return this.f84575c;
    }

    public SwapTriggerOrderInfo e() {
        return this.f84574b;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        if (!aVar.a(this)) {
            return false;
        }
        SwapTriggerOrderInfo e11 = e();
        SwapTriggerOrderInfo e12 = aVar.e();
        if (e11 != null ? !e11.equals(e12) : e12 != null) {
            return false;
        }
        C0884a c11 = c();
        C0884a c12 = aVar.c();
        return c11 != null ? c11.equals(c12) : c12 == null;
    }

    public void f(C0884a aVar) {
        this.f84576d = aVar;
    }

    public void g(String str) {
        this.f84575c = str;
    }

    public String getViewHandlerName() {
        return SwapCurrentStopOrderHandler.class.getName();
    }

    public int hashCode() {
        SwapTriggerOrderInfo e11 = e();
        int i11 = 43;
        int hashCode = e11 == null ? 43 : e11.hashCode();
        C0884a c11 = c();
        int i12 = (hashCode + 59) * 59;
        if (c11 != null) {
            i11 = c11.hashCode();
        }
        return i12 + i11;
    }

    public String toString() {
        return "SwapStopOrderListItem(info=" + e() + ", contractFace=" + d() + ", callback=" + c() + ")";
    }
}
