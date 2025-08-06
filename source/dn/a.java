package dn;

import android.text.TextUtils;
import android.view.View;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.n;
import com.hbg.lib.network.linear.swap.core.bean.LinearSwapExperienceFundQueryResult;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import java.lang.ref.WeakReference;
import rx.Observer;
import u6.g;

public final class a {

    /* renamed from: c  reason: collision with root package name */
    public static volatile a f76138c;

    /* renamed from: a  reason: collision with root package name */
    public WeakReference<View> f76139a;

    /* renamed from: b  reason: collision with root package name */
    public String f76140b;

    /* renamed from: dn.a$a  reason: collision with other inner class name */
    public class C0805a implements Observer<LinearSwapExperienceFundQueryResult> {
        public C0805a() {
        }

        /* renamed from: a */
        public void onNext(LinearSwapExperienceFundQueryResult linearSwapExperienceFundQueryResult) {
            a.this.h(linearSwapExperienceFundQueryResult.getValue());
        }

        public void onCompleted() {
        }

        public void onError(Throwable th2) {
            if (th2 instanceof APIStatusErrorException) {
                HuobiToastUtil.m(((APIStatusErrorException) th2).getErrMsg());
            } else {
                th2.printStackTrace();
            }
        }
    }

    public static a d() {
        if (f76138c == null) {
            synchronized (a.class) {
                if (f76138c == null) {
                    f76138c = new a();
                }
            }
        }
        return f76138c;
    }

    public void b() {
        this.f76140b = "";
    }

    public String c() {
        return this.f76140b;
    }

    public final void e() {
        h8.a.a().getExperienceFundQuery().b().compose(RxJavaHelper.t((g) null)).subscribe(new C0805a());
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001c A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x001a A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean f() {
        /*
            r5 = this;
            java.lang.String r0 = r5.f76140b
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            r1 = 0
            if (r0 != 0) goto L_0x0015
            java.lang.String r0 = r5.f76140b     // Catch:{ NumberFormatException -> 0x0011 }
            double r3 = java.lang.Double.parseDouble(r0)     // Catch:{ NumberFormatException -> 0x0011 }
            goto L_0x0016
        L_0x0011:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0015:
            r3 = r1
        L_0x0016:
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 <= 0) goto L_0x001c
            r0 = 1
            goto L_0x001d
        L_0x001c:
            r0 = 0
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dn.a.f():boolean");
    }

    public void g(String str) {
        if (!TextUtils.equals(this.f76140b, str)) {
            this.f76140b = str;
            if (!TextUtils.isEmpty(str)) {
                e();
            }
        }
    }

    public final void h(String str) {
        View view;
        if (this.f76139a != null && !TextUtils.isEmpty(str) && (view = (View) this.f76139a.get()) != null) {
            n.o().F(view, str);
        }
    }

    public void i(View view) {
        this.f76139a = new WeakReference<>(view);
    }
}
