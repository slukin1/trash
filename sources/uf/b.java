package uf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.network.response.StringStatusResponse;
import com.huobi.otc.bean.Ads;
import java.util.Map;
import rx.Observable;
import vp.c1;

public interface b {
    Fragment A(FragmentActivity fragmentActivity, int i11, String str);

    void B(Activity activity, String str, boolean z11, String str2, boolean z12);

    void C(Context context, String str);

    void D(Context context, boolean z11);

    void E(Activity activity, String str, String str2, String str3, String str4);

    Observable<StringStatusResponse<String>> F(Map<String, Object> map);

    void G(Context context);

    void H(Context context);

    Class<?> I();

    void J(Activity activity);

    void K(Activity activity, Long l11);

    void L();

    void M(Context context, String str, String str2);

    Fragment N(FragmentActivity fragmentActivity, String str, int i11, String str2, String str3, String str4, int i12, String str5);

    void O(Context context, String str);

    void P(Activity activity, Intent intent, Integer num);

    void Q(Context context, c1.b bVar);

    void R(Activity activity);

    void S(Activity activity, int i11, String str, int i12);

    void T(Activity activity, Ads ads, boolean z11, String str, String str2);

    void U(Context context, Intent intent);

    void V(Activity activity);

    void W(Activity activity, String str);

    void X(Activity activity);

    void a(Context context, Intent intent);

    void b(Activity activity);

    Fragment c(FragmentActivity fragmentActivity, String str, int i11, String str2);

    void d(Context context);

    void e(Context context, Intent intent);

    void f(Activity activity, String str);

    Intent g(Context context, String str);

    void h(Activity activity, boolean z11);

    void i(Activity activity);

    Class<?> j();

    void k(Activity activity);

    void l(Context context, String str);

    void m(Activity activity);

    void n(Context context);

    void o(Context context, Intent intent);

    void p();

    void q(Context context, boolean z11);

    void r(Context context, String str, int i11, boolean z11, String str2, String str3);

    Fragment s(FragmentActivity fragmentActivity, int i11, int i12, int i13, String str, int i14, String str2, int i15, int i16);

    void t(Context context, String str);

    void u(Context context, String str, String str2);

    void v(Context context, Intent intent);

    Fragment w(FragmentActivity fragmentActivity, String str, int i11, String str2);

    void x(Context context, String str);

    void y(Context context);

    void z(Context context, Intent intent);
}
