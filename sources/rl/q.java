package rl;

import android.annotation.SuppressLint;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.module.kline.view.KlineViewWrapper;
import com.hbg.module.market.R$id;
import de.t;
import java.util.ArrayList;
import java.util.List;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public String f76466a;

    /* renamed from: b  reason: collision with root package name */
    public int f76467b;

    /* renamed from: c  reason: collision with root package name */
    public int f76468c;

    /* renamed from: d  reason: collision with root package name */
    public View f76469d;

    /* renamed from: e  reason: collision with root package name */
    public t f76470e;

    /* renamed from: f  reason: collision with root package name */
    public List<b> f76471f;

    public interface b {
        void a(View view, int i11, int i12);
    }

    public static class c {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static q f76472a = new q();
    }

    public static q b() {
        return c.f76472a;
    }

    public void a(b bVar) {
        if (bVar != null) {
            this.f76471f.add(bVar);
        }
    }

    public boolean c(String str) {
        if (TextUtils.isEmpty(this.f76466a)) {
            return false;
        }
        return this.f76466a.equals(str);
    }

    public void d(View view) {
        for (b a11 : this.f76471f) {
            a11.a(view, this.f76467b, this.f76468c);
        }
    }

    public void e(b bVar) {
        if (bVar != null) {
            this.f76471f.remove(bVar);
        }
    }

    public void f(String str, int i11) {
        this.f76466a = str;
        this.f76468c = this.f76467b;
        this.f76467b = i11;
        if (TextUtils.isEmpty(str)) {
            t tVar = this.f76470e;
            if (tVar != null) {
                tVar.l((t.e) null);
                this.f76470e.onPause();
                this.f76470e = null;
            }
            View view = this.f76469d;
            if (view != null) {
                KlineViewWrapper klineViewWrapper = (KlineViewWrapper) view.findViewById(R$id.klineViewWrapper);
                if (klineViewWrapper != null) {
                    klineViewWrapper.G();
                    klineViewWrapper.C();
                }
                if (this.f76469d.getParent() != null) {
                    ((ViewGroup) this.f76469d.getParent()).removeView(this.f76469d);
                }
            }
            this.f76469d = null;
        }
    }

    public q() {
        this.f76471f = new ArrayList();
    }
}
