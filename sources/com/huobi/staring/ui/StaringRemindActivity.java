package com.huobi.staring.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.content.res.ResourcesCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.common.BaseApplication;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import com.hbg.lib.core.util.w;
import com.hbg.lib.data.future.bean.FutureContractInfo;
import com.hbg.lib.data.future.controller.FutureContractInfoController;
import com.hbg.lib.data.symbol.PrecisionUtil;
import com.hbg.lib.network.contract.core.bean.ContractCurrencyInfo;
import com.hbg.lib.network.contract.core.util.RemindBusinessType;
import com.hbg.lib.network.contract.core.util.RemindContractType;
import com.hbg.lib.network.hbg.core.bean.NoticeManageResp;
import com.hbg.lib.network.hbg.core.bean.StareConfigListData;
import com.hbg.lib.network.hbg.core.util.MgtConfigNumber;
import com.hbg.lib.network.pro.core.util.Period;
import com.hbg.lib.network.pro.socket.bean.KlineInfo;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;
import com.hbg.lib.network.pro.socket.listener.LastKlineListener;
import com.hbg.lib.network.pro.socket.listener.MarketOverviewListener;
import com.hbg.lib.network.pro.socket.response.LastKlineResponse;
import com.hbg.lib.network.pro.socket.response.MarketOverviewResponse;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.lib.network.retrofit.rxjava.BaseSubscriber;
import com.hbg.lib.network.swap.core.bean.SwapCurrencyInfo;
import com.hbg.lib.network.swap.core.controller.SwapCurrencyInfoController;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.contract.helper.ContractCurrencyUtils;
import com.huobi.currencyconfig.util.LegalCurrencyConfigUtil;
import com.huobi.staring.bean.AllRulesResult;
import com.huobi.staring.bean.CustomPriceInfoResp;
import com.huobi.staring.bean.CustomPriceResp;
import com.huobi.staring.bean.CustomRuleResp;
import com.huobi.staring.bean.CustomSaveResult;
import com.huobi.staring.bean.StareInfo;
import com.huobi.staring.helper.StaringRemindHelper;
import com.huobi.staring.ui.BaseRemindActivity;
import com.huobi.store.AppConfigManager;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import cs.n;
import ds.a1;
import ds.b1;
import ds.c1;
import ds.d1;
import ds.e1;
import ds.f1;
import ds.g1;
import ds.h1;
import ds.i1;
import ds.j1;
import ds.k1;
import ds.l1;
import ds.m1;
import ds.n1;
import ds.o1;
import ds.p1;
import ds.q1;
import ds.z0;
import g9.a;
import i6.m;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import pro.huobi.R;
import sl.d0;
import sn.t;
import tg.r;

public class StaringRemindActivity extends BaseRemindActivity {
    public View A;
    public View B;
    public PriceArrowView C;
    public TextView D;
    public View E;
    public View F;
    public RadioGroup G;
    public LoadingLayout H;
    public View I;
    public View J;
    public TextView K;
    public TextView L;
    public SwitchCompat M;
    public EasyRecyclerView<StareInfo> N;
    public AllRulesResult O;
    public String P;
    public long Q = -1;
    public a.d R = new k();
    public MarketOverviewListener S = new a();
    public LastKlineListener T = new b();

    /* renamed from: r  reason: collision with root package name */
    public int f81259r;

    /* renamed from: s  reason: collision with root package name */
    public String f81260s = "--";

    /* renamed from: t  reason: collision with root package name */
    public TextView f81261t;

    /* renamed from: u  reason: collision with root package name */
    public TextView f81262u;

    /* renamed from: v  reason: collision with root package name */
    public TextView f81263v;

    /* renamed from: w  reason: collision with root package name */
    public TextView f81264w;

    /* renamed from: x  reason: collision with root package name */
    public TextView f81265x;

    /* renamed from: y  reason: collision with root package name */
    public AppCompatTextView f81266y;

    /* renamed from: z  reason: collision with root package name */
    public EditText f81267z;

    public class a extends MarketOverviewListener {
        public a() {
        }

        /* renamed from: k */
        public void f(MarketOverviewResponse marketOverviewResponse) {
            d0.a().d(marketOverviewResponse);
            SymbolPrice b11 = d0.a().b(StaringRemindActivity.this.P);
            if (b11 != null) {
                Double close = b11.getClose();
                StaringRemindActivity.this.sj("OverView", b11.getOpen(), close);
            }
        }
    }

    public class b extends LastKlineListener {
        public b() {
        }

        /* renamed from: j */
        public void f(LastKlineResponse lastKlineResponse) {
            KlineInfo tick = lastKlineResponse.getTick();
            StaringRemindActivity.this.sj("LastKline", Double.valueOf(tick.getOpen()), Double.valueOf(tick.getClose()));
        }
    }

    public class c extends EasySubscriber<CustomSaveResult> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(CustomSaveResult customSaveResult) {
            super.onNext(customSaveResult);
            StaringRemindActivity.this.f81267z.setText("");
            HuobiToastUtil.p(R.string.staring_remind_create_success);
            StaringRemindActivity.this.Xh(false);
            StaringRemindActivity.this.xh();
        }

        public void onAfter() {
            super.onAfter();
            StaringRemindActivity.this.dismissProgressDialog();
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            String errCode = aPIStatusErrorException.getErrCode();
            errCode.hashCode();
            char c11 = 65535;
            switch (errCode.hashCode()) {
                case 52471:
                    if (errCode.equals("502")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 1507455:
                    if (errCode.equals("1011")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 46789751:
                    if (errCode.equals("12008")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 46789752:
                    if (errCode.equals("12009")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    HuobiToastUtil.k(BaseApplication.b(), R.string.common_tips_server_error);
                    return;
                case 1:
                    return;
                case 2:
                    HuobiToastUtil.l(BaseApplication.b(), String.format(Locale.US, StaringRemindActivity.this.getString(R.string.staring_remind_sorry_max_symbol_tps), new Object[]{"" + StaringRemindHelper.f()}));
                    return;
                case 3:
                    HuobiToastUtil.l(BaseApplication.b(), String.format(Locale.US, StaringRemindActivity.this.getString(R.string.staring_remind_sorry_max_tps), new Object[]{"" + StaringRemindHelper.d()}));
                    return;
                default:
                    super.onFailed(aPIStatusErrorException);
                    return;
            }
        }

        public void onStart() {
            super.onStart();
            StaringRemindActivity.this.showProgressDialog(true);
        }
    }

    public class d implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public String f81271b;

        public d() {
        }

        public void afterTextChanged(Editable editable) {
            try {
                String obj = editable.toString();
                i6.d.b("StaringRemindActivity-->afterTextChanged-->" + obj);
                if (!TextUtils.isEmpty(obj)) {
                    if (obj.startsWith(InstructionFileId.DOT)) {
                        String str = "0" + obj;
                        StaringRemindActivity.this.f81267z.setText(str);
                        StaringRemindActivity.this.f81267z.setSelection(str.length());
                        return;
                    }
                }
                if (!TextUtils.isEmpty(obj)) {
                    if ("0".equalsIgnoreCase(obj) || obj.startsWith("0.") || !obj.startsWith("0")) {
                        StaringRemindActivity staringRemindActivity = StaringRemindActivity.this;
                        int zh2 = staringRemindActivity.zh(staringRemindActivity.f81208n, staringRemindActivity.f81209o, staringRemindActivity.P);
                        if (obj.contains(InstructionFileId.DOT) && !obj.endsWith(InstructionFileId.DOT)) {
                            String[] split = obj.split("\\.");
                            String str2 = split[0];
                            String str3 = split[1];
                            if (!TextUtils.isEmpty(str3) && str3.length() > zh2) {
                                StaringRemindActivity.this.f81267z.setText(this.f81271b);
                                StaringRemindActivity.this.f81267z.setSelection(this.f81271b.length());
                                return;
                            } else if (str2.length() > 16 - zh2) {
                                StaringRemindActivity.this.f81267z.setText(this.f81271b);
                                StaringRemindActivity.this.f81267z.setSelection(this.f81271b.length());
                                return;
                            }
                        }
                        int i11 = 16;
                        if (obj.contains(InstructionFileId.DOT) || obj.length() <= 16 - zh2) {
                            if (obj.contains(InstructionFileId.DOT)) {
                                i11 = 17;
                            }
                            if (obj.length() > i11) {
                                StaringRemindActivity.this.f81267z.setText(this.f81271b);
                                StaringRemindActivity.this.f81267z.setSelection(this.f81271b.length());
                                return;
                            }
                        } else {
                            StaringRemindActivity.this.f81267z.setText(this.f81271b);
                            StaringRemindActivity.this.f81267z.setSelection(this.f81271b.length());
                            return;
                        }
                    } else {
                        String substring = obj.substring(1, obj.length());
                        StaringRemindActivity.this.f81267z.setText(substring);
                        StaringRemindActivity.this.f81267z.setSelection(substring.length());
                        return;
                    }
                }
                this.f81271b = obj;
                if (TextUtils.isEmpty(obj)) {
                    StaringRemindActivity.this.f81267z.setTypeface(ResourcesCompat.h(StaringRemindActivity.this.f81267z.getContext(), R.font.roboto_regular));
                } else {
                    StaringRemindActivity.this.f81267z.setTypeface(ResourcesCompat.h(StaringRemindActivity.this.f81267z.getContext(), R.font.roboto_medium));
                }
                if (TextUtils.isEmpty(obj)) {
                    obj = "0.00";
                }
                AppCompatTextView Ei = StaringRemindActivity.this.f81266y;
                StaringRemindActivity staringRemindActivity2 = StaringRemindActivity.this;
                Ei.setText(staringRemindActivity2.yh(staringRemindActivity2.f81208n, staringRemindActivity2.f81209o, obj, staringRemindActivity2.P));
                StaringRemindActivity.this.rj();
            } catch (Exception e11) {
                e11.printStackTrace();
                i6.d.f("StaringRemindActivity-->afterTextChanged-->e: ", e11);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public class e extends BaseSubscriber<StareConfigListData> {

        public class a implements StareInfo.a {
            public a() {
            }

            public void a(int i11, int i12, boolean z11) {
                if (!z11) {
                    StaringRemindActivity.this.mj(i12, i11);
                } else if (StaringRemindActivity.this.Si() == 0) {
                    StaringRemindActivity.this.Ri(i12, i11);
                } else {
                    StaringRemindActivity.this.lj(true, i12, i11);
                }
            }

            public void b(int i11) {
                StaringRemindActivity.this.N.d(i11);
            }
        }

        public e() {
        }

        /* access modifiers changed from: private */
        @SensorsDataInstrumented
        public /* synthetic */ void b(View view) {
            HashMap hashMap = new HashMap();
            StaringRemindActivity staringRemindActivity = StaringRemindActivity.this;
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, staringRemindActivity.Ah(staringRemindActivity.f81208n, staringRemindActivity.f81209o, staringRemindActivity.P));
            if (StaringRemindActivity.this.M.isChecked()) {
                gs.g.i("DTA_SDT_Open_click_count_with_one_click", hashMap);
                StaringRemindActivity.this.showProgressDialog();
                StaringRemindActivity.this.Qi();
            } else {
                gs.g.i("DTA_SDT_Close_click_count-with_one_click", hashMap);
                StaringRemindActivity.this.nj();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }

        /* renamed from: c */
        public void onNext(StareConfigListData stareConfigListData) {
            super.onNext(stareConfigListData);
            StaringRemindActivity.this.dismissProgressDialog();
            if (stareConfigListData != null) {
                StaringRemindActivity.this.M.setChecked(stareConfigListData.getOpenStare() == 1);
                StaringRemindActivity.this.M.setOnClickListener(new q1(this));
                ArrayList arrayList = new ArrayList();
                for (com.hbg.lib.network.hbg.core.bean.StareInfo next : stareConfigListData.getList()) {
                    StareInfo stareInfo = new StareInfo();
                    stareInfo.setStatus(next.getStatus());
                    stareInfo.setDescription(next.getDescription());
                    stareInfo.setStrategyId(next.getStrategyId());
                    stareInfo.setStrategyName(next.getStrategyName());
                    stareInfo.setIsSupport(next.getIsSupport());
                    stareInfo.setRate(next.getRate());
                    stareInfo.setBusinessType(StaringRemindActivity.this.f81209o);
                    stareInfo.setPrice(StaringRemindActivity.this.f81260s);
                    stareInfo.setSymbol(StaringRemindActivity.this.P);
                    stareInfo.setStatusChangeListener(new a());
                    arrayList.add(stareInfo);
                }
                if (arrayList.size() > 0) {
                    try {
                        StaringRemindActivity.this.H.g();
                        ((LinearLayout.LayoutParams) StaringRemindActivity.this.H.getLayoutParams()).setMargins(0, 0, 0, 0);
                    } catch (Exception e11) {
                        e11.printStackTrace();
                    }
                    LinearLayoutManager linearLayoutManager = new LinearLayoutManager(StaringRemindActivity.this);
                    linearLayoutManager.setOrientation(1);
                    StaringRemindActivity.this.N.setLayoutManager(linearLayoutManager);
                    StaringRemindActivity.this.N.setData(arrayList);
                    return;
                }
                StaringRemindActivity.this.kj();
                return;
            }
            StaringRemindActivity.this.kj();
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            StaringRemindActivity.this.dismissProgressDialog();
            StaringRemindActivity.this.kj();
        }

        public void printLog(Throwable th2) {
            super.printLog(th2);
            StaringRemindActivity.this.dismissProgressDialog();
            StaringRemindActivity.this.kj();
        }
    }

    public class f extends BaseSubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f81275b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ boolean f81276c;

        public f(int i11, boolean z11) {
            this.f81275b = i11;
            this.f81276c = z11;
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
            StaringRemindActivity.this.dismissProgressDialog();
            int i11 = this.f81275b;
            if (i11 == -1) {
                for (StareInfo status : StaringRemindActivity.this.N.getDataList()) {
                    status.setStatus(this.f81276c ? 1 : 0);
                }
                StaringRemindActivity.this.N.c();
            } else {
                StaringRemindActivity.this.Oi(i11, this.f81276c ? 1 : 0);
                StaringRemindActivity.this.M.setChecked(StaringRemindActivity.this.Si() > 0);
            }
            HuobiToastUtil.m(StaringRemindActivity.this.getString(this.f81276c ? R.string.n_open_feature_success : R.string.otc_pay_method_close_success_toast));
        }

        public void onError(Throwable th2) {
            super.onError(th2);
            int i11 = this.f81275b;
            if (i11 == -1) {
                StaringRemindActivity.this.M.setChecked(!this.f81276c);
            } else {
                StaringRemindActivity.this.Oi(i11, this.f81276c ^ true ? 1 : 0);
            }
            StaringRemindActivity.this.dismissProgressDialog();
        }

        public void printLog(Throwable th2) {
            super.printLog(th2);
        }
    }

    public class g extends BaseSubscriber<List<NoticeManageResp>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f81278b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int[] f81279c;

        public g(String str, int[] iArr) {
            this.f81278b = str;
            this.f81279c = iArr;
        }

        public void onError(Throwable th2) {
            super.onError(th2);
        }

        public void onNext(List<NoticeManageResp> list) {
            super.onNext(list);
            if (list != null) {
                for (int i11 = 0; i11 < list.size(); i11++) {
                    NoticeManageResp noticeManageResp = list.get(i11);
                    if (noticeManageResp != null) {
                        if (!noticeManageResp.getLabelName().equals(this.f81278b)) {
                            List<NoticeManageResp> subList = noticeManageResp.getSubList();
                            if (!(subList == null || subList.size() == 0)) {
                                int i12 = 0;
                                while (i12 < subList.size()) {
                                    NoticeManageResp noticeManageResp2 = subList.get(i11);
                                    if (noticeManageResp2 == null || !noticeManageResp2.getLabelName().equals(this.f81278b)) {
                                        i12++;
                                    } else if (noticeManageResp2.getSubState().equals("2")) {
                                        this.f81279c[0] = noticeManageResp2.getId();
                                        StaringRemindActivity.this.Wi(this.f81279c[0]);
                                        return;
                                    } else {
                                        return;
                                    }
                                }
                                continue;
                            }
                        } else if (noticeManageResp.getSubState().equals("2")) {
                            this.f81279c[0] = noticeManageResp.getId();
                            StaringRemindActivity.this.Wi(this.f81279c[0]);
                            return;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
    }

    public class h extends EasySubscriber<List<String>> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f81281b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f81282c;

        public h(int i11, int i12) {
            this.f81281b = i11;
            this.f81282c = i12;
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            StaringRemindActivity.this.dismissProgressDialog();
            HuobiToastUtil.m(StaringRemindActivity.this.getString(R.string.n_no_network));
            int i11 = this.f81282c;
            if (i11 == -1) {
                StaringRemindActivity.this.M.setChecked(false);
            } else {
                StaringRemindActivity.this.Oi(i11, 0);
            }
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
            StaringRemindActivity.this.dismissProgressDialog();
            HuobiToastUtil.m(StaringRemindActivity.this.getString(R.string.n_no_network));
            int i11 = this.f81282c;
            if (i11 == -1) {
                StaringRemindActivity.this.M.setChecked(false);
            } else {
                StaringRemindActivity.this.Oi(i11, 0);
            }
        }

        public void onNext(List<String> list) {
            super.onNext(list);
            if (t.r().contains(StaringRemindActivity.this.P)) {
                StaringRemindActivity.this.lj(true, this.f81281b, this.f81282c);
            } else {
                StaringRemindActivity.this.Ni(this.f81281b, this.f81282c);
            }
        }
    }

    public class i extends EasySubscriber<Object> {
        public i() {
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
        }

        public void onFailed(APIStatusErrorException aPIStatusErrorException) {
            super.onFailed(aPIStatusErrorException);
        }

        public void onNext(Object obj) {
            super.onNext(obj);
        }
    }

    public class j extends BaseRemindActivity.e<AllRulesResult> {
        public j() {
            super();
        }

        /* renamed from: b */
        public void a(AllRulesResult allRulesResult) {
            AllRulesResult unused = StaringRemindActivity.this.O = allRulesResult;
        }
    }

    public class k implements a.d {
        public k() {
        }

        public void a() {
            x8.a.a().e(true, StaringRemindActivity.this.S);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Dh(View view) {
        if (this.f81211q.x()) {
            this.f81211q.F();
        }
        if (this.f81207m) {
            ai(false);
            this.f81201g.j();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Eh(View view) {
        is.a.w("3112", this.P);
        if (this.f81211q.x()) {
            this.f81211q.F();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        ai(false);
        AllRemindActivity.ji(this, this.f81208n, this.f81209o);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static Intent Pi(Context context, String str, RemindContractType remindContractType, RemindBusinessType remindBusinessType) {
        if (context == null) {
            return null;
        }
        Intent intent = new Intent(context, StaringRemindActivity.class);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        intent.putExtra("PARAM_SYMBOL", str);
        if (remindContractType != null) {
            intent.putExtra("PARAM_CONTRACT_TYPE", remindContractType.toString());
        }
        if (remindBusinessType != null) {
            intent.putExtra("PARAM_BUSINESS_TYPE", remindBusinessType.toString());
        }
        return intent;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Yi(View view, boolean z11) {
        this.E.setEnabled(z11);
        if (z11) {
            if (this.f81211q.x()) {
                this.f81211q.F();
            }
            if (this.f81207m) {
                ai(false);
                this.f81201g.j();
            }
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void Zi(View view) {
        Xh(false);
        if (this.f81211q.x()) {
            this.f81211q.F();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void aj(int i11, int i12, Object obj) {
        lj(true, i11, i12);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void bj(APIStatusErrorException aPIStatusErrorException) {
        dismissProgressDialog();
        HuobiToastUtil.m(getString(R.string.market_add_collection_failed));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void cj(Throwable th2) {
        dismissProgressDialog();
        HuobiToastUtil.m(getString(R.string.market_add_collection_failed));
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void dj(RadioGroup radioGroup, int i11) {
        switch (i11) {
            case R.id.rbPriceRemind:
                Wh(this.f81207m);
                this.H.setVisibility(8);
                this.J.setVisibility(0);
                gs.g.i("DTA_PA_Create_price_PV", (HashMap) null);
                break;
            case R.id.rbStare:
                Wh(false);
                this.J.setVisibility(8);
                this.H.setVisibility(0);
                gs.g.i("DTA_SDT_Open_click_count_PV", (HashMap) null);
                break;
        }
        SensorsDataAutoTrackHelper.trackRadioGroup(radioGroup, i11);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void ej(CompoundButton compoundButton, boolean z11) {
        Log.d("TAG", "isChecked:" + z11);
        if (z11 && r.x().F0()) {
            Ti();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(compoundButton);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void fj(int i11, int i12, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        lj(false, i11, i12);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void gj(int i11, HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        Oi(i11, 1);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void hj(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        this.M.setChecked(true);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void ij(HBDialogFragment hBDialogFragment) {
        hBDialogFragment.dismiss();
        showProgressDialog();
        lj(false, 0, -1);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void jj() {
        ViewGroup.LayoutParams layoutParams = this.f81266y.getLayoutParams();
        layoutParams.width = this.B.getWidth();
        this.f81266y.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        Xh(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$3(View view) {
        HashMap hashMap = new HashMap();
        boolean z11 = true;
        hashMap.put("Page_name", this.f81259r == 1 ? Ch() ? "Me_derivatives" : "Me_spot" : "Markets");
        gs.g.i("Alert_Create_alert_Me_click", hashMap);
        HashMap hashMap2 = new HashMap();
        hashMap2.put(FirebaseAnalytics.Param.CURRENCY, Ah(this.f81208n, this.f81209o, this.P));
        gs.g.i("DTA_PA_Create_price_alert_click_count", hashMap2);
        if (this.f81211q.x()) {
            this.f81211q.F();
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else if (m.a(this.f81267z.getText().toString()).compareTo(m.a(this.f81262u.getText().toString())) == 0) {
            HuobiToastUtil.j(R.string.staring_remind_same_price_tips);
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        } else {
            String obj = this.f81267z.getText().toString();
            if (!TextUtils.isEmpty(obj) && obj.endsWith(InstructionFileId.DOT)) {
                obj = obj.replaceAll("\\.", "");
            }
            String charSequence = this.f81262u.getText().toString();
            if (TextUtils.isEmpty(obj) || obj.equalsIgnoreCase(charSequence)) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            int i11 = (m.h0(obj) > m.h0(charSequence) ? 1 : (m.h0(obj) == m.h0(charSequence) ? 0 : -1));
            if (i11 == 0) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            if (i11 <= 0) {
                z11 = false;
            }
            c cVar = new c();
            RemindBusinessType remindBusinessType = this.f81209o;
            if (remindBusinessType != null) {
                n.x(this.f81208n, remindBusinessType, this.Q, Vi(), obj, z11, getUI(), cVar);
            } else {
                StaringRemindHelper.p(this.Q, this.P, obj, z11, getUI(), cVar);
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$initView$1(View view) {
        Ui(true);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static void oj(Context context, String str, RemindContractType remindContractType, RemindBusinessType remindBusinessType) {
        if (context != null) {
            context.startActivity(Pi(context, str, remindContractType, remindBusinessType));
        }
    }

    public static void pj(Context context, String str, RemindContractType remindContractType, RemindBusinessType remindBusinessType) {
        if (context != null) {
            Intent intent = new Intent(context, StaringRemindActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("PARAM_SYMBOL", str);
            intent.putExtra("PARAM_FROM", 1);
            if (remindContractType != null) {
                intent.putExtra("PARAM_CONTRACT_TYPE", remindContractType.toString());
            }
            if (remindBusinessType != null) {
                intent.putExtra("PARAM_BUSINESS_TYPE", remindBusinessType.toString());
            }
            context.startActivity(intent);
        }
    }

    public static void qj(Context context, String str, RemindContractType remindContractType, RemindBusinessType remindBusinessType, int i11) {
        if (context != null) {
            Intent intent = new Intent(context, StaringRemindActivity.class);
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            intent.putExtra("PARAM_SYMBOL", str);
            intent.putExtra("PARAM_FROM", 1);
            if (remindContractType != null) {
                intent.putExtra("PARAM_CONTRACT_TYPE", remindContractType.toString());
            }
            if (remindBusinessType != null) {
                intent.putExtra("PARAM_BUSINESS_TYPE", remindBusinessType.toString());
            }
            intent.putExtra("PARAM_TAB_INDEX", i11);
            context.startActivity(intent);
        }
    }

    public final void Ni(int i11, int i12) {
        t.h(this.P, this).compose(RxJavaHelper.t(getUI())).subscribe(EasySubscriber.create(new g1(this, i11, i12), new e1(this), new f1(this)));
    }

    public final void Oi(int i11, int i12) {
        List<StareInfo> dataList = this.N.getDataList();
        if (dataList != null && i11 >= 0 && dataList.size() > i11) {
            dataList.get(i11).setStatus(i12);
            this.N.d(i11);
        }
    }

    public void Ph(List<bs.a> list) {
        CustomRuleResp custom;
        CustomPriceInfoResp priceInfo;
        AllRulesResult allRulesResult = this.O;
        if (allRulesResult != null && (custom = allRulesResult.getCustom()) != null && (priceInfo = custom.getPriceInfo()) != null) {
            this.Q = priceInfo.getRuleId();
            List<CustomPriceResp> prices = priceInfo.getPrices();
            if (prices != null && !prices.isEmpty()) {
                for (int i11 = 0; i11 < prices.size(); i11++) {
                    CustomPriceResp customPriceResp = prices.get(i11);
                    if (customPriceResp != null) {
                        list.add(new bs.a(customPriceResp.getPriceId(), this.P, customPriceResp.getPrice(), 0, customPriceResp.getDirection(), customPriceResp.getContractType(), customPriceResp.getBusinessType(), this.f81211q));
                    }
                }
            }
        }
    }

    public final void Qi() {
        Ri(0, -1);
    }

    public void Rh() {
        super.Rh();
        is.a.w("3113", this.P);
    }

    public final void Ri(int i11, int i12) {
        if (t.w(this.P)) {
            lj(true, i11, i12);
        } else {
            t.s(false, this).compose(RxJavaHelper.t((u6.g) null)).subscribe(new h(i11, i12));
        }
    }

    public void Sh(boolean z11) {
        super.Sh(z11);
        if (z11) {
            ai(false);
            Wh(false);
        }
    }

    public final int Si() {
        int i11 = 0;
        for (StareInfo status : this.N.getDataList()) {
            if (status.getStatus() == 1) {
                i11++;
            }
        }
        return i11;
    }

    public void Ti() {
        v7.b.a().B().b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new g(AppConfigManager.l(MgtConfigNumber.MARKET_PUSH_STATUS.number, "tag", "Push-Market"), new int[1]));
    }

    public final void Ui(boolean z11) {
        if (z11) {
            showProgressDialog();
        }
        v7.b.a().getStareConfigList(this.P).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new e());
    }

    public final String Vi() {
        FutureContractInfo o11;
        RemindBusinessType remindBusinessType = this.f81209o;
        if (remindBusinessType == RemindBusinessType.CONTRACT) {
            ContractCurrencyInfo b11 = ContractCurrencyUtils.b(this.P);
            if (b11 != null) {
                return b11.getSymbol();
            }
            return "";
        } else if (remindBusinessType == RemindBusinessType.SWAP) {
            SwapCurrencyInfo c11 = SwapCurrencyInfoController.k().c(this.P);
            if (c11 != null) {
                return c11.getSymbol();
            }
            return "";
        } else if (remindBusinessType != RemindBusinessType.LINEAR_SWAP || (o11 = FutureContractInfoController.n().o(this.P)) == null) {
            return "";
        } else {
            return o11.getSymbol();
        }
    }

    public final void Wi(int i11) {
        Log.d("TAG", "pushMarketId:" + i11);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Integer.valueOf(i11));
        v7.b.a().F0(arrayList, 1).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new i());
    }

    public void Xh(boolean z11) {
        super.Xh(z11);
        boolean isEmpty = TextUtils.isEmpty(this.f81267z.getText().toString());
        if (z11) {
            ViewUtil.m(this.F, false);
            ViewUtil.n(this.f81267z, true);
            this.f81267z.requestFocus();
            SoftInputUtils.m(this, this.f81267z);
            return;
        }
        this.f81267z.clearFocus();
        ViewUtil.n(this.f81267z, !isEmpty);
        ViewUtil.m(this.F, isEmpty);
        SoftInputUtils.f(this);
    }

    public final void Xi(boolean z11) {
        if ((StaringRemindHelper.h(this.P) || (getIntent().getStringExtra("PARAM_CONTRACT_TYPE") != null && n.l(this.P))) && StaringRemindHelper.i(this.P)) {
            gs.g.i("DTA_SDT_Open_click_count_PV", (HashMap) null);
            this.G.setOnCheckedChangeListener(new o1(this));
            Ui(z11);
        } else if (StaringRemindHelper.h(this.P) || (getIntent().getStringExtra("PARAM_CONTRACT_TYPE") != null && n.l(this.P))) {
            this.G.setVisibility(8);
            this.H.setVisibility(8);
            this.viewFinder.b(R.id.vSpace).setVisibility(8);
            this.J.setVisibility(0);
        } else {
            this.G.setVisibility(8);
            this.H.setVisibility(0);
            this.viewFinder.b(R.id.vSpace).setVisibility(8);
            this.J.setVisibility(8);
            Ui(z11);
        }
    }

    public void addEvent() {
        super.addEvent();
        this.F.setOnClickListener(new j1(this));
        this.f81265x.setOnClickListener(new h1(this));
        this.f81267z.addTextChangedListener(new d());
        this.f81267z.setOnFocusChangeListener(new m1(this));
        this.f81267z.setOnClickListener(new i1(this));
        this.A.setOnClickListener(new k1(this));
        AppCompatTextView appCompatTextView = this.f81266y;
        appCompatTextView.setText("≈ " + LegalCurrencyConfigUtil.w() + "0.00");
        this.viewFinder.b(R.id.id_remind_up_layout).setOnClickListener(new l1(this));
    }

    public void afterInit() {
        super.afterInit();
        Intent intent = getIntent();
        this.P = intent.getStringExtra("PARAM_SYMBOL");
        String stringExtra = intent.getStringExtra("PARAM_CONTRACT_TYPE");
        if (stringExtra != null) {
            this.f81208n = RemindContractType.valueOf(stringExtra);
        }
        boolean z11 = true;
        Xi(true);
        String stringExtra2 = intent.getStringExtra("PARAM_BUSINESS_TYPE");
        if (stringExtra2 != null) {
            this.f81209o = RemindBusinessType.valueOf(stringExtra2);
        }
        int intExtra = intent.getIntExtra("PARAM_FROM", 0);
        this.f81259r = intExtra;
        View view = this.A;
        if (intExtra == 1) {
            z11 = false;
        }
        ViewUtil.m(view, z11);
        this.f81261t.setText(Ah(this.f81208n, this.f81209o, this.P));
        this.E.setEnabled(false);
        rj();
    }

    public boolean altFocusableIM() {
        return true;
    }

    public int getContentView() {
        return R.layout.activity_staring_remind;
    }

    public void initView() {
        super.initView();
        this.f81261t = (TextView) this.viewFinder.b(R.id.id_reminder_actionbar_title);
        this.f81262u = (TextView) this.viewFinder.b(R.id.id_remind_title_tv);
        this.f81263v = (TextView) this.viewFinder.b(R.id.id_remind_legal_tv);
        this.f81264w = (TextView) this.viewFinder.b(R.id.id_remind_percent_tv);
        this.f81265x = (TextView) this.viewFinder.b(R.id.id_remind_create_rule_btn);
        this.f81266y = (AppCompatTextView) this.viewFinder.b(R.id.id_remind_edit_legal_text);
        this.f81267z = (EditText) this.viewFinder.b(R.id.id_remind_edit_text);
        this.A = this.viewFinder.b(R.id.id_reminder_actionbar_all_btn);
        this.B = this.viewFinder.b(R.id.id_remind_input_icon_layout);
        this.C = (PriceArrowView) this.viewFinder.b(R.id.id_remind_input_icon_iv);
        this.D = (TextView) this.viewFinder.b(R.id.id_remind_input_icon_tv);
        this.E = this.viewFinder.b(R.id.id_remind_create_rule_divider);
        this.G = (RadioGroup) this.viewFinder.b(R.id.rgCheck);
        this.H = (LoadingLayout) this.viewFinder.b(R.id.loading_layout);
        this.I = this.viewFinder.b(R.id.layStareList);
        this.J = this.viewFinder.b(R.id.layPriceRecomind);
        this.K = (TextView) this.viewFinder.b(R.id.tvOpenStare);
        this.L = (TextView) this.viewFinder.b(R.id.tvOpenDesc);
        SwitchCompat switchCompat = (SwitchCompat) this.viewFinder.b(R.id.scSwitch);
        this.M = switchCompat;
        switchCompat.setOnCheckedChangeListener(new n1(this));
        this.N = (EasyRecyclerView) this.viewFinder.b(R.id.rvStareConfigList);
        this.F = this.viewFinder.b(R.id.id_remind_edit_text_cover);
        this.H.setOnRetryClickListener(new z0(this));
        this.H.g();
    }

    public final void kj() {
        try {
            this.H.k();
            ((LinearLayout.LayoutParams) this.H.getLayoutParams()).setMargins(0, PixelUtils.a(80.0f), 0, 0);
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public final void lj(boolean z11, int i11, int i12) {
        showProgressDialog();
        if (i12 != -1) {
            HashMap hashMap = new HashMap();
            hashMap.put("strategyId", Integer.valueOf(i11));
            hashMap.put(FirebaseAnalytics.Param.CURRENCY, Ah(this.f81208n, this.f81209o, this.P));
            gs.g.i("DTA_SDT_Number_of_clicks_on_sub_switches", hashMap);
        }
        v7.b.a().setStareConfig(this.P, i11, z11 ? 1 : 0).b().compose(RxJavaHelper.t((u6.g) null)).subscribe(new f(i12, z11));
    }

    public final void mj(int i11, int i12) {
        if (Si() == 1) {
            DialogUtils.b0(this, getString(R.string.n_mine_turn_off_marking_reminder), getString(R.string.n_mine_close_will_no_signal), "", getString(R.string.n_cancel), getString(R.string.n_confirm), new b1(this, i12), new c1(this, i11, i12));
            return;
        }
        lj(false, i11, i12);
    }

    public final void nj() {
        DialogUtils.b0(this, getString(R.string.n_mine_turn_off_marking_reminder), getString(R.string.n_mine_close_will_no_signal), "", getString(R.string.n_cancel), getString(R.string.n_confirm), new p1(this), new a1(this));
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        if (i12 == -1 && i11 == 255 && this.f81208n == null && !d7.a1.v().p0(this.P)) {
            this.G.check(R.id.rbPriceRemind);
        }
    }

    public void onPause() {
        super.onPause();
        RemindBusinessType remindBusinessType = this.f81209o;
        if (remindBusinessType == RemindBusinessType.CONTRACT) {
            q7.a.a().c(this.R);
            q7.a.a().g(false, this.P, Period.day, this.T);
        } else if (remindBusinessType == RemindBusinessType.SWAP) {
            l9.a.a().c(this.R);
            l9.a.a().g(false, this.P, Period.day, this.T);
        } else if (remindBusinessType == RemindBusinessType.LINEAR_SWAP) {
            h8.a.a().c(this.R);
            h8.a.a().g(false, this.P, Period.day, this.T);
        } else {
            x8.a.a().c(this.R);
            x8.a.a().e(false, this.S);
            x8.a.a().g(false, this.P, Period.day, this.T);
        }
    }

    public void onResume() {
        super.onResume();
        RemindBusinessType remindBusinessType = this.f81209o;
        if (remindBusinessType == RemindBusinessType.CONTRACT) {
            q7.a.a().d(this.R);
            q7.a.a().g(true, this.P, Period.day, this.T);
        } else if (remindBusinessType == RemindBusinessType.SWAP) {
            l9.a.a().d(this.R);
            l9.a.a().g(true, this.P, Period.day, this.T);
        } else if (remindBusinessType == RemindBusinessType.LINEAR_SWAP) {
            h8.a.a().d(this.R);
            h8.a.a().g(true, this.P, Period.day, this.T);
        } else {
            x8.a.a().d(this.R);
            x8.a.a().e(true, this.S);
            x8.a.a().g(true, this.P, Period.day, this.T);
        }
    }

    public final void rj() {
        BigDecimal a11 = m.a(this.f81267z.getText().toString());
        BigDecimal a12 = m.a(this.f81262u.getText().toString());
        boolean z11 = !"--".equalsIgnoreCase(this.f81262u.getText().toString()) && a11.compareTo(BigDecimal.ZERO) != 0;
        if (z11) {
            this.f81265x.setTextColor(getResources().getColor(R.color.white));
        } else {
            this.f81265x.setTextColor(getResources().getColor(R.color.market_price_create_remind_color));
        }
        this.f81265x.setEnabled(z11);
        if (!z11) {
            this.B.animate().setDuration(200).alpha(0.0f);
        } else if (a11.compareTo(a12) > 0) {
            this.C.c(true);
            this.D.setTextColor(getResources().getColor(w.h()));
            this.D.setText(getString(R.string.staring_remind_up_to));
            this.B.animate().setDuration(270).alpha(1.0f);
        } else if (a11.compareTo(a12) < 0) {
            this.C.c(false);
            this.D.setTextColor(getResources().getColor(w.d()));
            this.D.setText(getString(R.string.staring_remind_down_to));
            this.B.animate().setDuration(270).alpha(1.0f);
        } else {
            this.B.animate().setDuration(270).alpha(0.0f);
        }
        this.B.post(new d1(this));
    }

    public final void sj(String str, Double d11, Double d12) {
        String str2;
        i6.d.b("StaringRemindActivity-->updatePrice-->" + str);
        double doubleValue = (d12 == null || d11 == null) ? 0.0d : d12.doubleValue() - d11.doubleValue();
        if (d12 == null || Double.compare(d12.doubleValue(), 0.0d) == 0) {
            str2 = "--";
        } else {
            StringBuilder sb2 = new StringBuilder();
            sb2.append(Double.compare(doubleValue, 0.0d) > 0 ? "+" : "");
            sb2.append(m.i((doubleValue / d11.doubleValue()) * 100.0d, PrecisionUtil.v(this.P)));
            sb2.append("%");
            str2 = sb2.toString();
        }
        this.f81264w.setText(str2);
        if (Double.compare(doubleValue, 0.0d) > 0) {
            this.f81264w.setTextColor(getResources().getColor(w.h()));
        } else if (Double.compare(doubleValue, 0.0d) < 0) {
            this.f81264w.setTextColor(getResources().getColor(w.d()));
        } else {
            this.f81264w.setTextColor(getResources().getColor(R.color.color_flat));
        }
        if (d12 != null) {
            String valueOf = String.valueOf(d12);
            this.f81260s = valueOf;
            this.f81260s = m.m(valueOf, zh(this.f81208n, this.f81209o, this.P));
        }
        try {
            String price = this.N.getDataList().get(0).getPrice();
            if ((price == null || price.equals("--") || Double.parseDouble(price) == 0.0d) && d12 != null && d12.doubleValue() > 0.0d) {
                for (StareInfo next : this.N.getDataList()) {
                    next.setBusinessType(this.f81209o);
                    next.setPrice(this.f81260s);
                    next.setSymbol(this.P);
                }
                this.N.c();
            }
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
        this.f81262u.setText(this.f81260s);
        this.f81263v.setText(yh(this.f81208n, this.f81209o, this.f81260s, this.P));
        rj();
    }

    public boolean useNewStatusBarFunc() {
        return true;
    }

    public void xh() {
        j jVar = new j();
        if (Ch()) {
            n.s(this.f81208n, Vi(), getUI(), jVar);
        } else {
            StaringRemindHelper.k(this.P, getUI(), jVar);
        }
    }
}
