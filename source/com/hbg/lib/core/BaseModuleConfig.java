package com.hbg.lib.core;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.Pair;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.core.lang.BaseLang;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.hbg.core.bean.UserOtherInfoData;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.huobi.statistics.hbg.bean.AnalyticsExposureItem;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rj.b;
import rx.Observable;

public class BaseModuleConfig {

    /* renamed from: a  reason: collision with root package name */
    public static a f68402a;

    public interface a {
        void A(Context context, String str, int i11, String str2, int i12);

        void B(Activity activity);

        void C(String str);

        String D();

        void E(Activity activity, String str, int i11, int i12);

        b F(Context context, String str);

        boolean G(Activity activity, String str);

        void H();

        void I(UserOtherInfoData userOtherInfoData);

        void J(Context context, int i11);

        void K(BaseActivity baseActivity);

        boolean L();

        String M();

        void N(Context context);

        String O(String str, int i11);

        String P();

        String Q(String str);

        void R(Context context);

        void S(Activity activity, String str);

        void T();

        boolean U(String str);

        View V(Context context);

        String W();

        Pair<Boolean, String> X(String str);

        void Y(AnalyticsExposureItem analyticsExposureItem);

        UserOtherInfoData Z();

        boolean a();

        String a0(String str);

        void b(String str, Map<String, Object> map);

        boolean b0();

        boolean c();

        void c0();

        void d(String str, Map<String, Object> map, String str2);

        void d0(Context context, String str);

        void e(Exception exc);

        boolean e0();

        String f();

        String f0();

        void g(Activity activity);

        void g0(Activity activity, String str, int i11, int i12, String str2, String str3, int i13);

        String getAvatar();

        String getUid();

        void h(FragmentActivity fragmentActivity);

        void h0(Context context);

        String i();

        String i0();

        String j();

        String j0();

        String k(String str);

        void k0(String str);

        void l(Context context, String str);

        void l0(String str, boolean z11);

        String m(String str, HashMap<BaseLang, List<BaseLang>> hashMap);

        boolean m0(Activity activity);

        boolean n();

        Observable<Boolean> n0(boolean z11);

        void newShareWithImages(Bitmap bitmap, String str, String str2);

        void newShareWithImages(ArrayList<Bitmap> arrayList, boolean z11, boolean z12, String str);

        String o(String str);

        void o0(String str);

        int p(Context context);

        boolean p0(String str, String str2);

        UserKycInfoNew q();

        void q0(AnalyticsExposureItem analyticsExposureItem);

        void r(Activity activity, String str, int i11);

        int s();

        boolean t();

        String u();

        boolean v(FragmentActivity fragmentActivity, String str);

        void w(String str, HashMap hashMap);

        void x(String str);

        String y(String str);

        void z(String str, String str2, String str3, boolean z11);
    }

    public static a a() {
        return f68402a;
    }

    public static void b(a aVar) {
        f68402a = aVar;
    }
}
