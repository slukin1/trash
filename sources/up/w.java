package up;

import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import androidx.fragment.app.FragmentActivity;
import com.google.android.exoplayer2.analytics.AnalyticsListener;
import com.hbg.lib.core.util.CollectionsUtils;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.otc.core.OTCStatusExtendResponse;
import com.hbg.lib.network.otc.core.bean.OtcAdTicket;
import com.hbg.lib.network.otc.core.bean.TradeReMarkBean;
import com.hbg.lib.network.otc.core.bean.UserVO;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$string;
import com.huobi.coupon.bean.Coupon;
import com.huobi.coupon.bean.CouponsData;
import com.huobi.otc.bean.Ads;
import com.huobi.otc.bean.OtcOptionalPlaceOrderFromBean;
import com.huobi.otc.utils.OtcPayMethodUtil;
import com.tencent.imsdk.BaseConstants;
import com.youth.banner.config.BannerConfig;
import i6.m;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.TimeoutException;
import jp.d1;
import jp.f;
import jp.f0;
import jp.l;
import jp.z1;
import rx.Observable;
import u6.g;

public final class w {

    public class a extends q6.d<OTCStatusExtendResponse> {

        /* renamed from: e  reason: collision with root package name */
        public OTCStatusExtendResponse f84922e;

        /* renamed from: f  reason: collision with root package name */
        public cp.b f84923f = new C0886a();

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f84924g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Ads f84925h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f84926i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f84927j;

        /* renamed from: up.w$a$a  reason: collision with other inner class name */
        public class C0886a implements cp.b {
            public C0886a() {
            }

            public void onConfirm() {
                String traceId = a.this.f84922e.getExtend() != null ? a.this.f84922e.getExtend().getTraceId() : null;
                a aVar = a.this;
                w.n(aVar.f84924g, aVar.f84925h, aVar.f84926i, Boolean.TRUE, aVar.f84927j, traceId);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g gVar, FragmentActivity fragmentActivity, Ads ads, g gVar2, d dVar) {
            super(gVar);
            this.f84924g = fragmentActivity;
            this.f84925h = ads;
            this.f84926i = gVar2;
            this.f84927j = dVar;
        }

        /* renamed from: g */
        public void onNext(OTCStatusExtendResponse oTCStatusExtendResponse) {
            super.onNext(oTCStatusExtendResponse);
            if (oTCStatusExtendResponse != null && !oTCStatusExtendResponse.isSuccess()) {
                this.f84922e = oTCStatusExtendResponse;
                onFailed(new APIStatusErrorException(this.f84922e.getErrCode(), this.f84922e.getErrMsg()));
            }
        }

        public void onError2(Throwable th2) {
            if ((th2 instanceof IOException) || (th2 instanceof TimeoutException)) {
                HashMap hashMap = new HashMap();
                hashMap.put("api_path", "/trade/free/quote");
                uf.c.b().r("api_timeout", "otc.system.api_price_timeout", hashMap);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            HashMap hashMap = new HashMap();
            hashMap.put("api_code", aPIStatusErrorException.getErrCode());
            hashMap.put("api_path", "/trade/free/quote");
            uf.c.b().r("api_failed", "otc.system.api_order_failed", hashMap);
            if (!w.B(this.f84924g, this.f84926i, this.f84925h, this.f84922e, aPIStatusErrorException, this.f84927j, (c) null, (OtcOptionalPlaceOrderFromBean) null, this.f84923f)) {
                super.onFailed(aPIStatusErrorException);
            }
        }
    }

    public class b extends q6.d<Pair<TradeReMarkBean, OTCStatusExtendResponse<OtcAdTicket>>> {

        /* renamed from: e  reason: collision with root package name */
        public OTCStatusExtendResponse f84929e;

        /* renamed from: f  reason: collision with root package name */
        public cp.b f84930f = new a();

        /* renamed from: g  reason: collision with root package name */
        public final /* synthetic */ FragmentActivity f84931g;

        /* renamed from: h  reason: collision with root package name */
        public final /* synthetic */ Ads f84932h;

        /* renamed from: i  reason: collision with root package name */
        public final /* synthetic */ g f84933i;

        /* renamed from: j  reason: collision with root package name */
        public final /* synthetic */ d f84934j;

        public class a implements cp.b {
            public a() {
            }

            public void onConfirm() {
                String traceId = b.this.f84929e.getExtend() != null ? b.this.f84929e.getExtend().getTraceId() : null;
                b bVar = b.this;
                w.n(bVar.f84931g, bVar.f84932h, bVar.f84933i, Boolean.TRUE, bVar.f84934j, traceId);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(g gVar, FragmentActivity fragmentActivity, Ads ads, g gVar2, d dVar) {
            super(gVar);
            this.f84931g = fragmentActivity;
            this.f84932h = ads;
            this.f84933i = gVar2;
            this.f84934j = dVar;
        }

        /* renamed from: g */
        public void onNext(Pair<TradeReMarkBean, OTCStatusExtendResponse<OtcAdTicket>> pair) {
            super.onNext(pair);
            Objects.requireNonNull(pair);
            OTCStatusExtendResponse oTCStatusExtendResponse = (OTCStatusExtendResponse) pair.second;
            Objects.requireNonNull(oTCStatusExtendResponse);
            if (!oTCStatusExtendResponse.isSuccess()) {
                this.f84929e = oTCStatusExtendResponse;
                onFailed(new APIStatusErrorException(oTCStatusExtendResponse.getErrCode(), oTCStatusExtendResponse.getErrMsg()));
                return;
            }
            d dVar = this.f84934j;
            if (dVar != null) {
                dVar.a((TradeReMarkBean) pair.first, (OtcAdTicket) oTCStatusExtendResponse.getData(), (List<Coupon>) null);
            }
        }

        public void onError2(Throwable th2) {
            if ((th2 instanceof IOException) || (th2 instanceof TimeoutException)) {
                HashMap hashMap = new HashMap();
                hashMap.put("api_path", "/trade/free/quote");
                uf.c.b().r("api_timeout", "otc.system.api_price_timeout", hashMap);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            HashMap hashMap = new HashMap();
            hashMap.put("api_code", aPIStatusErrorException.getErrCode());
            hashMap.put("api_path", "/trade/free/quote");
            uf.c.b().r("api_failed", "otc.system.api_order_failed", hashMap);
            if (!w.B(this.f84931g, this.f84933i, this.f84932h, this.f84929e, aPIStatusErrorException, this.f84934j, (c) null, (OtcOptionalPlaceOrderFromBean) null, this.f84930f)) {
                super.onFailed(aPIStatusErrorException);
            }
        }
    }

    public interface c {
        void a();
    }

    public interface d {
        void a(TradeReMarkBean tradeReMarkBean, OtcAdTicket otcAdTicket, List<Coupon> list);

        void b();
    }

    public static /* synthetic */ void A(FragmentActivity fragmentActivity, d dVar, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        OtcModuleConfig.b().o(fragmentActivity, new Intent());
        if (dVar != null) {
            dVar.b();
        }
    }

    public static boolean B(FragmentActivity fragmentActivity, g gVar, Ads ads, OTCStatusExtendResponse oTCStatusExtendResponse, APIStatusErrorException aPIStatusErrorException, d dVar, c cVar, OtcOptionalPlaceOrderFromBean otcOptionalPlaceOrderFromBean, cp.b bVar) {
        FragmentActivity fragmentActivity2 = fragmentActivity;
        String errMsg = aPIStatusErrorException.getErrMsg();
        int k02 = m.k0(aPIStatusErrorException.getErrCode());
        String str = "";
        switch (k02) {
            case 401:
                break;
            case BannerConfig.SCROLL_TIME:
                d1.a(fragmentActivity, true);
                break;
            case 605:
                if (oTCStatusExtendResponse != null && oTCStatusExtendResponse.getExtend() != null) {
                    f.d().h(fragmentActivity, oTCStatusExtendResponse.getExtend(), new u(bVar));
                    break;
                } else {
                    HuobiToastUtil.j(R$string.ali_vsdk_network_error);
                    break;
                }
                break;
            case 1000:
            case 1023:
                DialogUtils.c0(fragmentActivity, errMsg, "", fragmentActivity.getString(R$string.otc_ppace_order_dialog_btn_cancel), fragmentActivity.getString(R$string.otc_ppace_order_dialog_btn_setting), ad.b.f3517a, new r(fragmentActivity));
                break;
            case 1002:
            case 1004:
            case 1007:
            case 1008:
            case AnalyticsListener.EVENT_AUDIO_CODEC_ERROR:
            case BaseConstants.ERR_SVR_MSG_PKG_PARSE_FAILED:
                String string = fragmentActivity.getString(R$string.otc_advance_verification_step_note);
                if (k02 != 1037) {
                    DialogUtils.c0(fragmentActivity, errMsg, "", fragmentActivity.getString(R$string.otc_ppace_order_dialog_btn_cancel), fragmentActivity.getString(R$string.otc_ppace_order_dialog_btn_auth), ad.b.f3517a, new s(fragmentActivity));
                    break;
                } else {
                    if (otcOptionalPlaceOrderFromBean.getCouponId() > 0) {
                        errMsg = fragmentActivity.getString(R$string.n_otc_coupon_need_senior_china_title);
                    } else {
                        str = string;
                    }
                    DialogUtils.b0(fragmentActivity, fragmentActivity.getString(R$string.otc_coupon_use_tip), errMsg, str, fragmentActivity.getString(R$string.otc_ppace_order_dialog_btn_cancel), fragmentActivity.getString(R$string.otc_ppace_order_dialog_btn_auth), ad.b.f3517a, new i(fragmentActivity));
                    break;
                }
            case 1005:
                DialogUtils.c0(fragmentActivity, errMsg, "", fragmentActivity.getString(R$string.otc_ppace_order_dialog_btn_cancel), fragmentActivity.getString(R$string.otc_ppace_order_dialog_btn_auth), ad.b.f3517a, new p(fragmentActivity));
                break;
            case 1022:
                DialogUtils.c0(fragmentActivity, errMsg, "", fragmentActivity.getString(R$string.allow_access_dialog_positive_btn), fragmentActivity.getString(R$string.otc_ppace_order_dialog_btn_setting), ad.b.f3517a, new n(fragmentActivity));
                break;
            case 1024:
            case 1026:
                if (cVar == null) {
                    return false;
                }
                cVar.a();
                return false;
            case 10000:
                return false;
            case 10012:
                DialogUtils.c0(fragmentActivity, errMsg, "", fragmentActivity.getString(R$string.otc_ppace_order_dialog_btn_cancel), fragmentActivity.getString(R$string.n_otc_go_check), ad.b.f3517a, new o(fragmentActivity));
                break;
            case 12000:
                if (oTCStatusExtendResponse.getExtend() != null) {
                    OtcModuleConfig.a().m("5090", str, (String) null, (Map<String, Object>) null);
                    break;
                } else {
                    HuobiToastUtil.j(R$string.ali_vsdk_network_error);
                    break;
                }
            case BaseConstants.ERR_SVR_MSG_INTERNAL_AUTH_FAILED:
                d dVar2 = dVar;
                DialogUtils.c0(fragmentActivity, errMsg, "", fragmentActivity.getString(R$string.otc_ppace_order_dialog_btn_cancel), fragmentActivity.getString(R$string.otc_ppace_order_dialog_btn_setting), ad.b.f3517a, new t(fragmentActivity, dVar));
                break;
            case BaseConstants.ERR_SVR_MSG_IN_PEER_BLACKLIST:
                DialogUtils.c0(fragmentActivity, errMsg, "", fragmentActivity.getString(R$string.otc_ppace_order_dialog_btn_cancel), fragmentActivity.getString(R$string.otc_ppace_order_dialog_btn_add), ad.b.f3517a, new q(fragmentActivity));
                break;
            default:
                HuobiToastUtil.l(fragmentActivity, errMsg);
                break;
        }
        return true;
    }

    public static void n(FragmentActivity fragmentActivity, Ads ads, g gVar, Boolean bool, d dVar, String str) {
        Observable<R> onErrorReturn = s8.a.a().tradeRemark(ads.getId()).b().compose(RxJavaHelper.t(gVar)).onErrorReturn(k.f60908b);
        if (!ads.getTradeType().isBuy()) {
            Observable.zip(onErrorReturn, OtcModuleConfig.a().I(ads.getId(), bool, str).compose(RxJavaHelper.t(gVar)), z1.d(OtcModuleConfig.a().J()).compose(RxJavaHelper.t(gVar)), new m(ads, dVar)).subscribe(new a(gVar, fragmentActivity, ads, gVar, dVar));
        } else {
            Observable.zip(onErrorReturn, OtcModuleConfig.a().I(ads.getId(), bool, str).compose(RxJavaHelper.t(gVar)), l.f60909b).subscribe(new b(gVar, fragmentActivity, ads, gVar, dVar));
        }
    }

    public static /* synthetic */ TradeReMarkBean o(Throwable th2) {
        return null;
    }

    public static /* synthetic */ OTCStatusExtendResponse p(Ads ads, d dVar, TradeReMarkBean tradeReMarkBean, OTCStatusExtendResponse oTCStatusExtendResponse, CouponsData couponsData) {
        List<Coupon> c11 = (couponsData == null || CollectionsUtils.b(couponsData.getCoupons())) ? null : z1.c(couponsData.getCoupons(), "-1", va.b.k(ads.getCurrency()), va.b.d(ads.getCoinId()));
        Objects.requireNonNull(oTCStatusExtendResponse);
        if (oTCStatusExtendResponse.isSuccess() && dVar != null) {
            dVar.a(tradeReMarkBean, (OtcAdTicket) oTCStatusExtendResponse.getData(), c11);
        }
        return oTCStatusExtendResponse;
    }

    public static /* synthetic */ void q(FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        OtcPayMethodUtil.e(fragmentActivity);
    }

    public static /* synthetic */ void r(FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        OtcModuleConfig.b().U(fragmentActivity, new Intent());
    }

    public static /* synthetic */ void s(cp.b bVar) {
        if (bVar != null) {
            bVar.onConfirm();
        }
    }

    public static /* synthetic */ void t(FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        f0.a().c(fragmentActivity, true);
    }

    public static /* synthetic */ void u(FragmentActivity fragmentActivity, UserVO userVO) {
        if (userVO == null || userVO.isVerifyWayHaveSet()) {
            OtcModuleConfig.b().V(fragmentActivity);
        } else {
            OtcModuleConfig.b().H(fragmentActivity);
        }
    }

    public static /* synthetic */ void v(FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        l.q(false).compose(RxJavaHelper.t((g) null)).subscribe(q6.d.c((g) null, new v(fragmentActivity)));
    }

    public static /* synthetic */ void w(FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        OtcPayMethodUtil.e(fragmentActivity);
    }

    public static /* synthetic */ void x(FragmentActivity fragmentActivity, UserVO userVO) {
        if ((fragmentActivity instanceof Activity) && !fragmentActivity.isFinishing()) {
            f0.a().b(fragmentActivity, true);
        }
    }

    public static /* synthetic */ void y(FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        OtcModuleConfig.a().X(false).compose(RxJavaHelper.t((g) null)).subscribe(new j(fragmentActivity));
    }

    public static /* synthetic */ void z(FragmentActivity fragmentActivity, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        f0.a().d(fragmentActivity, false, true);
    }
}
