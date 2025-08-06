package uf;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.network.newkyc.bean.UserKycInfoNew;
import com.hbg.lib.network.otc.core.OTCStatusExtendResponse;
import com.hbg.lib.network.otc.core.bean.OtcAdTicket;
import com.hbg.lib.network.otc.core.bean.OtcCountryListData;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.huobi.coupon.bean.Coupon;
import com.huobi.lite.kyc.aliface.AliFaceCertificate;
import com.huobi.otc.bean.VoiceInfo;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import u6.g;

public interface a {
    void A(FragmentActivity fragmentActivity, g gVar, String str);

    void B(Context context, Intent intent);

    Observable<Object> C(Map<String, Object> map);

    boolean D();

    void E(Context context, boolean z11);

    void F(Context context, String str, boolean z11);

    Observable<UserKycInfoNew> G(boolean z11, g gVar);

    boolean H(Activity activity);

    Observable<OTCStatusExtendResponse<OtcAdTicket>> I(String str, Boolean bool, String str2);

    String J();

    void K(Context context);

    void L(t8.a aVar);

    Intent M(Context context);

    Intent N(Activity activity);

    String O();

    void P(Map<String, Object> map, Map<String, String> map2);

    Observable<String> Q(Context context, String str);

    void R(Context context, String str, AliFaceCertificate.b bVar);

    boolean S(BaseCoreActivity baseCoreActivity);

    void T(String str);

    Class U();

    boolean V(Coupon coupon, String str);

    void W(RecyclerView recyclerView, boolean z11);

    Observable<UserVO> X(boolean z11);

    String Y();

    void Z(BaseCoreActivity baseCoreActivity);

    boolean a();

    Intent a0(Context context);

    void b(String str, Map<String, Object> map);

    String b0();

    String c();

    String c0();

    List<Integer> d();

    void d0(Context context, String str, String str2, String str3);

    void e(String str);

    boolean e0();

    String f();

    String g();

    Observable<List<OtcCountryListData>> getCountryList();

    String getUid();

    String getUserEmail();

    void h(CharSequence charSequence, Context context);

    void i(BaseCoreActivity baseCoreActivity);

    int j();

    Class k();

    boolean l(Activity activity, Intent intent, Intent intent2);

    void m(String str, String str2, String str3, Map<String, Object> map);

    Observable<String> n(String str);

    Class o();

    boolean p(Coupon coupon, String str, String str2);

    String q();

    Class r();

    Observable<Boolean> s(Map<String, Object> map);

    String t();

    void track(String str, HashMap hashMap);

    Intent u(Context context);

    String v(String str, int i11);

    void w(Context context, String str, VoiceInfo voiceInfo);

    boolean x();

    Class y();

    void z(String str, String str2, t8.a aVar);
}
