package com.huobi.otc.persenter;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.common.mvp.ActivityPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.network.hbg.core.HbgIntCodeResponse;
import com.hbg.lib.network.otc.core.OTCStatusExtendResponse;
import com.hbg.lib.network.otc.core.bean.MktRuleBean;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.util.MapParamsBuilder;
import com.hbg.module.otc.OtcModuleConfig;
import com.huobi.otc.ui.OtcCardManagerActivity;
import com.tencent.android.tpush.common.MessageKey;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import java.util.HashMap;
import java.util.Map;
import jp.f;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import u6.g;

public class OtcBindBankCardPresenter extends ActivityPresenter<d> {

    /* renamed from: a  reason: collision with root package name */
    public String f78968a = "1";

    /* renamed from: b  reason: collision with root package name */
    public String f78969b = "2";

    /* renamed from: c  reason: collision with root package name */
    public String f78970c = "3";

    /* renamed from: d  reason: collision with root package name */
    public String f78971d = "4";

    /* renamed from: e  reason: collision with root package name */
    public String f78972e;

    public class a extends EasySubscriber<HbgIntCodeResponse<Map<String, String>>> {

        /* renamed from: b  reason: collision with root package name */
        public HbgIntCodeResponse<Map<String, String>> f78973b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f78974c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f78975d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ Map f78976e;

        /* renamed from: com.huobi.otc.persenter.OtcBindBankCardPresenter$a$a  reason: collision with other inner class name */
        public class C0844a implements cp.b {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ OTCStatusExtendResponse.ExtendBean f78978a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f78979b;

            public C0844a(OTCStatusExtendResponse.ExtendBean extendBean, String str) {
                this.f78978a = extendBean;
                this.f78979b = str;
            }

            public void onConfirm() {
                String unused = OtcBindBankCardPresenter.this.f78972e = this.f78978a.getTraceId();
                a aVar = a.this;
                OtcBindBankCardPresenter.this.Z(aVar.f78974c, aVar.f78976e);
                if (this.f78979b.contains("/mkyc/c3")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("otc_step", "go_kyc");
                    uf.c.b().h("otc_card_info_typein", hashMap);
                }
            }
        }

        public class b implements Observer<String> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f78981b;

            public b(String str) {
                this.f78981b = str;
            }

            /* renamed from: a */
            public void onNext(String str) {
                OtcModuleConfig.b().E(OtcBindBankCardPresenter.this.getActivity(), OtcBindBankCardPresenter.this.f78969b, a.this.f78975d, this.f78981b, str);
            }

            public void onCompleted() {
            }

            public void onError(Throwable th2) {
                OtcModuleConfig.b().E(OtcBindBankCardPresenter.this.getActivity(), OtcBindBankCardPresenter.this.f78969b, a.this.f78975d, this.f78981b, "");
            }
        }

        public a(d dVar, String str, Map map) {
            this.f78974c = dVar;
            this.f78975d = str;
            this.f78976e = map;
        }

        public static /* synthetic */ void c(cp.b bVar) {
            if (bVar != null) {
                bVar.onConfirm();
            }
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v13, resolved type: java.lang.String} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* renamed from: e */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(com.hbg.lib.network.hbg.core.HbgIntCodeResponse<java.util.Map<java.lang.String, java.lang.String>> r3) {
            /*
                r2 = this;
                super.onNext(r3)
                com.huobi.otc.persenter.OtcBindBankCardPresenter r0 = com.huobi.otc.persenter.OtcBindBankCardPresenter.this
                r1 = 0
                java.lang.String unused = r0.f78972e = r1
                if (r3 == 0) goto L_0x005f
                r2.f78973b = r3
                int r0 = r3.getCode()
                r1 = 200(0xc8, float:2.8E-43)
                if (r0 != r1) goto L_0x005f
                boolean r0 = r3.isSuccess()
                if (r0 == 0) goto L_0x005f
                java.lang.Object r3 = r3.getData()
                java.util.Map r3 = (java.util.Map) r3
                java.lang.String r0 = "paymentUrl"
                java.lang.Object r1 = r3.get(r0)
                if (r1 == 0) goto L_0x0055
                java.lang.Object r0 = r3.get(r0)
                java.lang.String r0 = (java.lang.String) r0
                java.lang.String r1 = "http"
                boolean r1 = r0.startsWith(r1)
                if (r1 != 0) goto L_0x0040
                java.lang.String r0 = "paymentResult"
                java.lang.Object r3 = r3.get(r0)
                r0 = r3
                java.lang.String r0 = (java.lang.String) r0
            L_0x0040:
                android.content.Intent r3 = new android.content.Intent
                android.net.Uri r0 = android.net.Uri.parse(r0)
                java.lang.String r1 = "android.intent.action.VIEW"
                r3.<init>(r1, r0)
                com.huobi.otc.persenter.OtcBindBankCardPresenter r0 = com.huobi.otc.persenter.OtcBindBankCardPresenter.this
                com.hbg.lib.common.ui.BaseCoreActivity r0 = r0.getActivity()
                r0.startActivity(r3)
                goto L_0x005e
            L_0x0055:
                com.huobi.otc.persenter.OtcBindBankCardPresenter r3 = com.huobi.otc.persenter.OtcBindBankCardPresenter.this
                com.huobi.otc.persenter.OtcBindBankCardPresenter$d r0 = r2.f78974c
                java.lang.String r1 = r2.f78975d
                r3.d0(r0, r1)
            L_0x005e:
                return
            L_0x005f:
                com.hbg.lib.network.retrofit.exception.APIStatusErrorException r0 = new com.hbg.lib.network.retrofit.exception.APIStatusErrorException
                int r1 = r3.getCode()
                java.lang.String r1 = java.lang.String.valueOf(r1)
                java.lang.String r3 = r3.getMessage()
                r0.<init>(r1, r3)
                r2.onFailed(r0)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.otc.persenter.OtcBindBankCardPresenter.a.onNext(com.hbg.lib.network.hbg.core.HbgIntCodeResponse):void");
        }

        public void onAfter() {
            super.onAfter();
            ((d) OtcBindBankCardPresenter.this.getUI()).dismissProgressDialog();
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            if (aPIStatusErrorException instanceof APIStatusErrorException) {
                if (OtcBindBankCardPresenter.this.getUI() != null) {
                    ((d) OtcBindBankCardPresenter.this.getUI()).dismissProgressDialog();
                }
                if (this.f78973b == null || !"57605".equals(aPIStatusErrorException.getErrCode())) {
                    String obj = this.f78976e.get("cardNumber").toString();
                    String substring = obj.substring(obj.length() - 4, obj.length());
                    if (!TextUtils.isEmpty(aPIStatusErrorException.getErrMsg())) {
                        OtcModuleConfig.b().E(OtcBindBankCardPresenter.this.getActivity(), OtcBindBankCardPresenter.this.f78969b, this.f78975d, substring, aPIStatusErrorException.getErrMsg());
                        return;
                    }
                    String errCode = aPIStatusErrorException.getErrCode();
                    Observable.just(errCode).subscribeOn(Schedulers.newThread()).map(new qp.b(errCode)).observeOn(AndroidSchedulers.mainThread()).subscribe(new b(substring));
                    return;
                }
                Map data = this.f78973b.getData();
                OTCStatusExtendResponse.ExtendBean extendBean = new OTCStatusExtendResponse.ExtendBean();
                extendBean.setTitle((String) data.get("title"));
                extendBean.setContent((String) data.get("content"));
                extendBean.setCancelText((String) data.get("cancelText"));
                extendBean.setContinueText((String) data.get("continueText"));
                extendBean.setLink((String) data.get("link"));
                extendBean.setTraceId((String) data.get(MessageKey.MSG_TRACE_ID));
                String str = (String) data.get("link");
                f.d().h(OtcBindBankCardPresenter.this.getActivity(), extendBean, new qp.a(new C0844a(extendBean, str)));
                if (str.contains("/mkyc/c3")) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("otc_step", "go_L4");
                    uf.c.b().h("otc_card_info_typein", hashMap);
                }
            }
        }

        public void onStart() {
            super.onStart();
            ((d) OtcBindBankCardPresenter.this.getUI()).showProgressDialog();
        }
    }

    public class b extends RequestCallback1<Map<String, String>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f78983a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f78984b;

        public class a implements Observer<String> {

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ String f78986b;

            /* renamed from: c  reason: collision with root package name */
            public final /* synthetic */ String f78987c;

            public a(String str, String str2) {
                this.f78986b = str;
                this.f78987c = str2;
            }

            /* renamed from: a */
            public void onNext(String str) {
                b bVar = b.this;
                bVar.f78983a.qf(OtcBindBankCardPresenter.this.b0(this.f78986b), b.this.f78984b, str, this.f78987c);
            }

            public void onCompleted() {
            }

            public void onError(Throwable th2) {
                b bVar = b.this;
                bVar.f78983a.qf(OtcBindBankCardPresenter.this.b0(this.f78986b), b.this.f78984b, "", this.f78987c);
            }
        }

        public b(d dVar, String str) {
            this.f78983a = dVar;
            this.f78984b = str;
        }

        /* renamed from: c */
        public void onRequestSuccess(Map<String, String> map) {
            String str;
            String str2 = map.get("cardState");
            String str3 = map.get("content");
            String str4 = map.get("code");
            if (!TextUtils.isEmpty(map.get("accountNumber"))) {
                str = map.get("accountNumber");
            } else {
                str = "";
            }
            if (!TextUtils.isEmpty(str3)) {
                this.f78983a.qf(OtcBindBankCardPresenter.this.b0(str2), this.f78984b, str3, str);
            } else if (TextUtils.isEmpty(str4)) {
                this.f78983a.qf(OtcBindBankCardPresenter.this.b0(str2), this.f78984b, "", str);
            } else if (OtcBindBankCardPresenter.this.f78969b.equals(OtcBindBankCardPresenter.this.b0(str2))) {
                Observable.just(str4).subscribeOn(Schedulers.newThread()).map(new qp.c(str4)).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(str2, str));
            } else {
                this.f78983a.qf(OtcBindBankCardPresenter.this.b0(str2), this.f78984b, str3, str);
            }
        }

        public void onRequestFailure(Throwable th2) {
            this.f78983a.qf(OtcBindBankCardPresenter.this.f78970c, this.f78984b, "", "");
        }
    }

    public class c extends RequestCallback1<OTCStatusExtendResponse<MktRuleBean>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f78989a;

        public c(d dVar) {
            this.f78989a = dVar;
        }

        /* renamed from: a */
        public void onRequestSuccess(OTCStatusExtendResponse<MktRuleBean> oTCStatusExtendResponse) {
            if (oTCStatusExtendResponse != null && oTCStatusExtendResponse.isSuccess() && oTCStatusExtendResponse.getData() != null) {
                this.f78989a.W(oTCStatusExtendResponse.getData());
            }
        }
    }

    public interface d extends g {
        void W(MktRuleBean mktRuleBean);

        boolean j9();

        void qf(String str, String str2, String str3, String str4);
    }

    public void Z(d dVar, Map<String, Object> map) {
        v7.b.a().addBankCard(map, this.f78972e).compose(RxJavaHelper.t((g) getUI())).subscribe(new a(dVar, ((d) getUI()).j9() ? TUIChatConstants.BUSINESS_ID_CUSTOM_ORDER : "cardManager", map));
    }

    public void a0(d dVar, Map<String, Object> map) {
        s8.a.a().bindCardMktRule(map).d(new c(dVar));
    }

    public final String b0(String str) {
        str.hashCode();
        char c11 = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c11 = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c11 = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c11 = 2;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c11 = 3;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c11 = 4;
                    break;
                }
                break;
        }
        switch (c11) {
            case 0:
                return this.f78971d;
            case 1:
            case 2:
                return this.f78969b;
            case 3:
                return this.f78968a;
            case 4:
                return this.f78970c;
            default:
                return this.f78970c;
        }
    }

    /* renamed from: c0 */
    public void onUIReady(BaseCoreActivity baseCoreActivity, d dVar) {
        super.onUIReady(baseCoreActivity, dVar);
        HashMap hashMap = new HashMap();
        hashMap.put("factor", new MapParamsBuilder().a("appPageId", "21").b());
        a0(dVar, hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put("otc_step", "view_fill_card_info");
        uf.c.b().h("otc_card_info_typein", hashMap2);
    }

    public void d0(d dVar, String str) {
        v7.b.a().requestCardState().d(new b(dVar, str));
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onProTokenUpdate(ProTokenUpdate proTokenUpdate) {
        if (TextUtils.isEmpty(proTokenUpdate.getProToken()) && getUI() != null && ((d) getUI()).isAlive()) {
            Intent M = OtcModuleConfig.a().M(getActivity());
            OtcModuleConfig.a().l(getActivity(), M, M);
            Activity f11 = oa.a.g().f(OtcCardManagerActivity.class);
            if (f11 != null) {
                f11.finish();
            }
        }
    }

    public void onStart() {
        super.onStart();
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void onStop() {
        super.onStop();
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenError(mo.a aVar) {
        if (getUI() != null && ((d) getUI()).isAlive()) {
            Intent M = OtcModuleConfig.a().M(getActivity());
            OtcModuleConfig.a().l(getActivity(), M, M);
            if (getActivity() != null) {
                getActivity().finish();
            }
        }
    }
}
