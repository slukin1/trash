package com.huobi.otc;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.verificationsdk.ui.IActivityCallback;
import com.alibaba.verificationsdk.ui.VerifyActivity;
import com.alibaba.verificationsdk.ui.VerifyType;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.core.network.response.StringStatusResponse;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.huobi.account.ui.OtcBindCardRecordActivity;
import com.huobi.account.ui.SecurityLinkActivity;
import com.huobi.account.ui.SecuritySetActivity;
import com.huobi.account.ui.UpdateOtcTradePwdActivity;
import com.huobi.coupon.bean.Coupon;
import com.huobi.finance.bean.FinanceRecordItem;
import com.huobi.finance.ui.CurrencySearchActivity;
import com.huobi.finance.ui.UnifyTransferActivity;
import com.huobi.kyc.bean.FlutterKycConfig;
import com.huobi.kyc.ui.KycProBaseInformationActivity;
import com.huobi.login.bean.JumpTarget;
import com.huobi.login.v2.ui.CountryAreaSelectActivityV2;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.flutter.BindCardAsyncResultActivity;
import com.huobi.otc.flutter.OtcAdPublishEditActivity;
import com.huobi.otc.flutter.OtcC2cOrderActivity;
import com.huobi.otc.flutter.OtcFilterMenuFragment;
import com.huobi.otc.flutter.OtcFlutterExchangeActivity;
import com.huobi.otc.flutter.OtcFlutterVideoActivity;
import com.huobi.otc.flutter.OtcMyFollowedFlutterActivity;
import com.huobi.otc.flutter.OtcNewUserVideoTutorialActivity;
import com.huobi.otc.flutter.OtcOrderDepositActivity;
import com.huobi.otc.flutter.OtcOrderDepositFragment;
import com.huobi.otc.flutter.OtcOrderTransConfirmFlutterFragemnt;
import com.huobi.otc.flutter.OtcP2pAdShareFragment;
import com.huobi.otc.flutter.OtcPriceCreateActivity;
import com.huobi.otc.flutter.OtcPricePromptActivity;
import com.huobi.otc.flutter.OtcQuickEditAdFragment;
import com.huobi.otc.flutter.OtcStrictSelectionFragment;
import com.huobi.otc.flutter.OtcTagManagerActivity;
import com.huobi.otc.flutter.OtcTradeLeadingFlutterActivity;
import com.huobi.otc.flutter.OtcTradeSettingFlutterActivity;
import com.huobi.otc.flutter.OtcTutorialFlutterFragment;
import com.huobi.otc.flutter.OtcVideoTutorialActivity;
import com.huobi.otc.flutter.OtcWordAdSearchActivity;
import com.huobi.otc.flutter.P2PPayMethodRootFlutterActivity;
import com.huobi.otc.helper.OtcMerchantProfileSwither;
import com.huobi.otc.service.OTCService;
import com.huobi.otc.ui.CouponActivity;
import com.huobi.otc.ui.OtcBindBankCardActivity;
import com.huobi.otc.ui.OtcRiskWarningActivity;
import com.huobi.otc.ui.OtcScaleImageActivity;
import com.huobi.otc.ui.OtcTradeActivity;
import com.huobi.otc.utils.OtcMarketPriceConfigUtil;
import com.huobi.utils.k0;
import com.tencent.thumbplayer.tcmedia.core.player.TPNativePlayerInitConfig;
import com.zopim.android.sdk.api.ZopimChat;
import com.zopim.android.sdk.prechat.EmailTranscript;
import com.zopim.android.sdk.prechat.PreChatForm;
import java.util.Map;
import pro.huobi.R;
import rn.c;
import rx.Observable;
import sn.f;
import tg.r;
import tq.p;
import uf.b;
import vp.c1;

public class OtcModuleJumpCallbackImpl implements b {

    public class a implements IActivityCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c1.b f78254a;

        public a(c1.b bVar) {
            this.f78254a = bVar;
        }

        public void onNotifyBackPressed() {
            this.f78254a.a();
        }

        public void onResult(int i11, Map<String, String> map) {
            this.f78254a.b(i11 != 0, map);
        }
    }

    public static void Y(FragmentActivity fragmentActivity, String str) {
        Fragment m02 = fragmentActivity.getSupportFragmentManager().m0(str);
        if (m02 != null) {
            fragmentActivity.getSupportFragmentManager().q().s(m02).k();
        }
    }

    public Fragment A(FragmentActivity fragmentActivity, int i11, String str) {
        OtcStrictSelectionFragment Uh = OtcStrictSelectionFragment.Uh();
        Y(fragmentActivity, str);
        fragmentActivity.getSupportFragmentManager().q().v(R.anim.anim_enter_from_bottom, R.anim.anim_exit_from_bottom).c(i11, Uh, str).k();
        return Uh;
    }

    public void B(Activity activity, String str, boolean z11, String str2, boolean z12) {
        UnifyTransferActivity.Uh(activity, str, "2", z11, str2, z12);
    }

    public void C(Context context, String str) {
        OtcNewUserVideoTutorialActivity.Ei(context, str);
    }

    public void D(Context context, boolean z11) {
        context.startActivity(k0.s(context, "", z11));
    }

    public void E(Activity activity, String str, String str2, String str3, String str4) {
        BindCardAsyncResultActivity.Ji(activity, str, str2, str3, str4);
    }

    public Observable<StringStatusResponse<String>> F(Map<String, Object> map) {
        try {
            if (map.containsKey("type") && (map.get("type") instanceof String)) {
                String str = (String) map.get("type");
                int i11 = 0;
                if (TextUtils.equals(str, FinanceRecordItem.TYPE_OTC_TO_PRO)) {
                    i11 = TPNativePlayerInitConfig.BOOL_VIDEO_KEEP_MEDIA_CODEC_PTS;
                } else if (TextUtils.equals(str, FinanceRecordItem.TYPE_PRO_TO_OTC)) {
                    i11 = 216;
                }
                Map<String, String> d11 = iu.a.f().d(i11);
                if (d11 != null) {
                    map.putAll(d11);
                }
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
        return ((OTCService) p.W(OTCService.class)).getTransferResult(map);
    }

    public void G(Context context) {
        OtcTagManagerActivity.Ei(context);
    }

    public void H(Context context) {
        context.startActivity(new Intent(context, OtcTradeLeadingFlutterActivity.class));
    }

    public Class<?> I() {
        return OtcOrderDepositActivity.class;
    }

    public void J(Activity activity) {
        jp.k0.k(activity);
    }

    public void K(Activity activity, Long l11) {
        OtcMerchantProfileSwither.a(activity, l11);
    }

    public void L() {
        if (r.x().F0()) {
            FlutterKycConfig flutterKycConfig = new FlutterKycConfig();
            flutterKycConfig.setPhone(r.x().F());
            flutterKycConfig.setEmail(r.x().u());
            flutterKycConfig.setAuthBizCode(Coupon.OTC);
            b2.a.d().a("/account/kyc").withSerializable("flag_kyc_config", flutterKycConfig).navigation();
        }
    }

    public void M(Context context, String str, String str2) {
        OtcWordAdSearchActivity.Ji(context, str, str2);
    }

    public Fragment N(FragmentActivity fragmentActivity, String str, int i11, String str2, String str3, String str4, int i12, String str5) {
        OtcP2pAdShareFragment Uh = OtcP2pAdShareFragment.Uh(str, i11, str2, str3, str4);
        Y(fragmentActivity, str5);
        fragmentActivity.getSupportFragmentManager().q().v(R.anim.anim_enter_from_bottom, R.anim.anim_exit_from_bottom).c(i12, Uh, str5).k();
        return Uh;
    }

    public void O(Context context, String str) {
        OtcVideoTutorialActivity.Ei(context, str);
    }

    public void P(Activity activity, Intent intent, Integer num) {
        a0(activity, intent, CountryAreaSelectActivityV2.class, num);
    }

    public void Q(Context context, c1.b bVar) {
        VerifyActivity.startSimpleVerifyUI(context, VerifyType.NOCAPTCHA, "0335", (String) null, new a(bVar));
    }

    public void R(Activity activity) {
        activity.startActivity(new Intent(activity, SecuritySetActivity.class));
    }

    public void S(Activity activity, int i11, String str, int i12) {
        UnifyTransferActivity.Vh(activity, OtcMarketPriceConfigUtil.c(i11), str, true, (String) null, false, i12);
    }

    public void T(Activity activity, Ads ads, boolean z11, String str, String str2) {
        OtcC2cOrderActivity.Ji(activity, ads, z11, str, str2);
    }

    public void U(Context context, Intent intent) {
        Z(context, intent, OtcOrderDepositActivity.class);
    }

    public void V(Activity activity) {
        OtcTradeSettingFlutterActivity.Hi(activity);
    }

    public void W(Activity activity, String str) {
        zn.a.d().v(Uri.parse(str)).a().c();
    }

    public void X(Activity activity) {
        CurrencySearchActivity.lj(activity, "1", false);
    }

    public final void Z(Context context, Intent intent, Class<?> cls) {
        a0(context, intent, cls, (Integer) null);
    }

    public void a(Context context, Intent intent) {
        Z(context, intent, OtcScaleImageActivity.class);
    }

    public final void a0(Context context, Intent intent, Class<?> cls, Integer num) {
        if (context != null && cls != null) {
            if (intent == null) {
                intent = new Intent(context, cls);
            } else {
                intent.setClass(context, cls);
            }
            if (num == null) {
                context.startActivity(intent);
            } else if (context instanceof Activity) {
                ((Activity) context).startActivityForResult(intent, num.intValue());
            }
        }
    }

    public void b(Activity activity) {
        c.i().d(activity, new JumpTarget(new Intent(activity, CouponActivity.class), k0.h(activity)));
    }

    public Fragment c(FragmentActivity fragmentActivity, String str, int i11, String str2) {
        OtcOrderTransConfirmFlutterFragemnt Uh = OtcOrderTransConfirmFlutterFragemnt.Uh(str);
        fragmentActivity.getSupportFragmentManager().q().v(R.anim.anim_enter_from_bottom, R.anim.anim_exit_from_bottom).c(i11, Uh, str2).k();
        return Uh;
    }

    public void d(Context context) {
        OtcPriceCreateActivity.Ei(context);
    }

    public void e(Context context, Intent intent) {
        if (context instanceof Activity) {
            P2PPayMethodRootFlutterActivity.Li((Activity) context, 0);
        }
    }

    public void f(Activity activity, String str) {
        HBBaseWebActivity.showWebView(activity, str, "", "", false);
    }

    public Intent g(Context context, String str) {
        Intent intent = new Intent(context, SecurityLinkActivity.class);
        intent.putExtra("LINK_TYPE_KEY", 1);
        if (!TextUtils.isEmpty(str)) {
            intent.putExtra("BIND_EMAIL_KEY", str);
        }
        return intent;
    }

    public void h(Activity activity, boolean z11) {
        OtcTutorialFlutterFragment otcTutorialFlutterFragment = new OtcTutorialFlutterFragment();
        if (activity instanceof OtcTradeActivity) {
            ((OtcTradeActivity) activity).Ai(otcTutorialFlutterFragment, z11);
        }
    }

    public void i(Activity activity) {
        OtcBindBankCardActivity.Sh(activity);
    }

    public Class<?> j() {
        return OtcOrderDepositFragment.class;
    }

    public void k(Activity activity) {
        activity.startActivity(k0.h(activity));
    }

    public void l(Context context, String str) {
        PreChatForm.Builder builder = new PreChatForm.Builder();
        PreChatForm.Field field = PreChatForm.Field.REQUIRED_EDITABLE;
        f.y(context, new ZopimChat.SessionConfig().preChatForm(builder.email(field).department(field).message(field).build()).emailTranscript(EmailTranscript.DISABLED).fileSending(true));
        ZopimChat.trackEvent(str);
    }

    public void m(Activity activity) {
        OtcMyFollowedFlutterActivity.Ei(activity);
    }

    public void n(Context context) {
        OtcPricePromptActivity.Ei(context);
    }

    public void o(Context context, Intent intent) {
        Z(context, intent, SecuritySetActivity.class);
    }

    public void p() {
        yr.b.p(BaseApplication.b().getApplicationContext()).openWXApp();
    }

    public void q(Context context, boolean z11) {
        OtcRiskWarningActivity.oh(context, z11);
    }

    public void r(Context context, String str, int i11, boolean z11, String str2, String str3) {
        OtcAdPublishEditActivity.Qi(context, str, i11, z11, str2, str3);
    }

    public Fragment s(FragmentActivity fragmentActivity, int i11, int i12, int i13, String str, int i14, String str2, int i15, int i16) {
        OtcFilterMenuFragment Vh = OtcFilterMenuFragment.Vh(i11, i12, i13, str, i15, i16);
        Y(fragmentActivity, str2);
        fragmentActivity.getSupportFragmentManager().q().v(R.anim.anim_enter_from_bottom, R.anim.anim_exit_from_bottom).c(i14, Vh, str2).k();
        return Vh;
    }

    public void t(Context context, String str) {
        OtcFlutterVideoActivity.Ei(context, str);
    }

    public void u(Context context, String str, String str2) {
        OtcFlutterExchangeActivity.Ei(context, str, str2);
    }

    public void v(Context context, Intent intent) {
        Z(context, intent, KycProBaseInformationActivity.class);
    }

    public Fragment w(FragmentActivity fragmentActivity, String str, int i11, String str2) {
        OtcQuickEditAdFragment Zh = OtcQuickEditAdFragment.Zh(str);
        fragmentActivity.getSupportFragmentManager().q().v(R.anim.anim_enter_from_bottom, R.anim.anim_exit_from_bottom).c(i11, Zh, str2).k();
        return Zh;
    }

    public void x(Context context, String str) {
        f.y(context, (ZopimChat.SessionConfig) null);
        ZopimChat.trackEvent(str);
    }

    public void y(Context context) {
        OtcBindCardRecordActivity.Di(context);
    }

    public void z(Context context, Intent intent) {
        Z(context, intent, UpdateOtcTradePwdActivity.class);
    }
}
