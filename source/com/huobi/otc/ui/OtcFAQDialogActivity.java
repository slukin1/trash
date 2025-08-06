package com.huobi.otc.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.facebook.places.model.PlaceFields;
import com.hbg.lib.core.ui.BaseActivity;
import com.hbg.lib.network.otc.core.bean.OtcFAQBean;
import com.hbg.lib.widgets.LoadingLayout;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.otc.OtcModuleConfig;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import com.hbg.module.otc.R$string;
import com.huobi.otc.bean.OtcFAQDialogDataType;
import com.huobi.otc.bean.UserSecuritySetData;
import com.huobi.otc.persenter.OtcFAQPresenter;
import com.huobi.otc.widget.FAQGestureFrameLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import dp.p;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.functions.Action1;

public class OtcFAQDialogActivity extends BaseActivity<OtcFAQPresenter, OtcFAQPresenter.c> implements OtcFAQPresenter.c, OtcFAQDialogDataType.OnItemClickListener {

    /* renamed from: b  reason: collision with root package name */
    public View f79431b;

    /* renamed from: c  reason: collision with root package name */
    public View f79432c;

    /* renamed from: d  reason: collision with root package name */
    public FAQGestureFrameLayout f79433d;

    /* renamed from: e  reason: collision with root package name */
    public EasyRecyclerView f79434e;

    /* renamed from: f  reason: collision with root package name */
    public LoadingLayout f79435f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f79436g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f79437h;

    /* renamed from: i  reason: collision with root package name */
    public SafeLottieView f79438i;

    /* renamed from: j  reason: collision with root package name */
    public String f79439j;

    /* renamed from: k  reason: collision with root package name */
    public String f79440k;

    /* renamed from: l  reason: collision with root package name */
    public Runnable f79441l = new a();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            OtcFAQDialogActivity.this.finish();
            OtcFAQDialogActivity.this.overridePendingTransition(-1, -1);
        }
    }

    public class b implements Action1<Void> {
        public b() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            OtcFAQDialogActivity.this.f79433d.k(OtcFAQDialogActivity.this.f79441l);
        }
    }

    public class c implements Action1<Void> {
        public c() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            OtcFAQDialogActivity.this.f79433d.k(OtcFAQDialogActivity.this.f79441l);
        }
    }

    public class d implements View.OnClickListener {
        public d() {
        }

        @SensorsDataInstrumented
        public void onClick(View view) {
            if (OtcFAQDialogActivity.this.getPresenter() != null) {
                OtcFAQDialogActivity.this.getPresenter().V();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public class e implements Action1<Void> {
        public e() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            OtcFAQDialogActivity.this.f79433d.k(OtcFAQDialogActivity.this.f79441l);
            OtcFAQActivity.zh(OtcFAQDialogActivity.this);
        }
    }

    public class f implements Action1<Void> {

        public class a implements Runnable {
            public a() {
            }

            public void run() {
                OtcFAQDialogActivity.this.f79441l.run();
                OtcFAQActivity.zh(OtcFAQDialogActivity.this);
                OtcModuleConfig.a().b("6180", (Map<String, Object>) null);
            }
        }

        public f() {
        }

        /* renamed from: a */
        public void call(Void voidR) {
            OtcFAQDialogActivity.this.f79433d.k(new a());
        }
    }

    public static void gg(Activity activity, String str, String str2) {
        Intent intent = new Intent(activity, OtcFAQDialogActivity.class);
        intent.putExtra(PlaceFields.PAGE, str);
        if (!TextUtils.isEmpty(str2)) {
            intent.putExtra("orderId", str2);
        }
        activity.startActivity(intent);
    }

    public void D7(String str, boolean z11, String str2) {
    }

    public final void Og(Activity activity) {
        if (Build.VERSION.SDK_INT == 26) {
            activity.setRequestedOrientation(-1);
        } else {
            activity.setRequestedOrientation(1);
        }
    }

    /* renamed from: Zf */
    public OtcFAQPresenter createPresenter() {
        OtcFAQPresenter otcFAQPresenter = new OtcFAQPresenter();
        otcFAQPresenter.c0(this.f79439j);
        otcFAQPresenter.b0(this.f79440k);
        return otcFAQPresenter;
    }

    public void addEvent() {
        Observable<Void> a11 = dw.a.a(this.f79431b);
        TimeUnit timeUnit = TimeUnit.MILLISECONDS;
        a11.throttleFirst(300, timeUnit).subscribe(new b());
        dw.a.a(this.f79432c).throttleFirst(300, timeUnit).subscribe(new c());
        this.f79435f.setOnRetryClickListener(new d());
        dw.a.a(this.f79436g).throttleFirst(300, timeUnit).subscribe(new e());
        dw.a.a(this.f79437h).throttleFirst(300, timeUnit).subscribe(new f());
    }

    /* renamed from: f2 */
    public OtcFAQPresenter getPresenter() {
        return (OtcFAQPresenter) super.getPresenter();
    }

    /* renamed from: fg */
    public OtcFAQPresenter.c getUI() {
        return this;
    }

    public int getContentView() {
        return R$layout.dialog_faq_layout;
    }

    public ViewGroup getParentLayout() {
        LinearLayout linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(1);
        return linearLayout;
    }

    public final void initData() {
        Intent intent = getIntent();
        this.f79439j = intent.getStringExtra(PlaceFields.PAGE);
        if (intent.hasExtra("orderId")) {
            this.f79440k = intent.getStringExtra("orderId");
        }
    }

    public void initView() {
        initData();
        this.f79432c = this.viewFinder.b(R$id.view_top);
        FAQGestureFrameLayout fAQGestureFrameLayout = (FAQGestureFrameLayout) this.viewFinder.b(R$id.fl_faq_gesture);
        this.f79433d = fAQGestureFrameLayout;
        fAQGestureFrameLayout.setEndRunnable(this.f79441l);
        this.f79431b = this.viewFinder.b(R$id.tv_top_close);
        SafeLottieView safeLottieView = (SafeLottieView) this.viewFinder.b(R$id.slv_left);
        this.f79438i = safeLottieView;
        safeLottieView.setRepeatCount(2);
        this.f79438i.resumeAnimation();
        this.f79434e = (EasyRecyclerView) this.viewFinder.b(R$id.rv_faq_dialog);
        this.f79435f = (LoadingLayout) this.viewFinder.b(R$id.loading_layout);
        this.f79436g = (TextView) this.viewFinder.b(R$id.tv_bottom_help);
        this.f79437h = (TextView) this.viewFinder.b(R$id.tv_bottom_hide);
    }

    public boolean isLightStatusBar() {
        return true;
    }

    public void n4(String str) {
        this.f79435f.k();
    }

    public void onBackPressed() {
        this.f79433d.k(this.f79441l);
    }

    public void onChangeClick(OtcFAQDialogDataType otcFAQDialogDataType) {
        otcFAQDialogDataType.getDataBean().changePageSize();
        v9.a adapter = this.f79434e.getAdapter();
        adapter.notifyItemChanged(adapter.c().indexOf(otcFAQDialogDataType), otcFAQDialogDataType);
    }

    public void onClick(OtcFAQDialogDataType otcFAQDialogDataType, OtcFAQBean otcFAQBean) {
        HashMap hashMap = new HashMap();
        hashMap.put("faq_code", otcFAQBean.getCode());
        hashMap.put(PlaceFields.PAGE, this.f79439j);
        uf.c.b().i("faq_first_srceen_faq", hashMap);
        v9.a adapter = this.f79434e.getAdapter();
        OtcFAQDialogDataType otcFAQDialogDataType2 = new OtcFAQDialogDataType();
        otcFAQDialogDataType2.setDataBean(otcFAQBean);
        otcFAQDialogDataType2.setOnItemClickListener(this);
        adapter.c().add(otcFAQDialogDataType2);
        int size = adapter.c().size();
        adapter.notifyItemInserted(size);
        this.f79434e.smoothScrollToPosition(size);
    }

    public void onClickAction(Context context, OtcFAQBean otcFAQBean) {
        p.y(this, otcFAQBean, this);
    }

    public void onClickGreat(OtcFAQDialogDataType otcFAQDialogDataType, int i11) {
        OtcFAQBean dataBean;
        HashMap hashMap = new HashMap();
        hashMap.put("faq_code", otcFAQDialogDataType.getDataBean().getCode());
        boolean z11 = true;
        if (i11 != 1) {
            z11 = false;
        }
        hashMap.put("useful", Boolean.valueOf(z11));
        uf.c.b().i("click_faq_useful", hashMap);
        OtcFAQBean dataBean2 = otcFAQDialogDataType.getDataBean();
        if (i11 != dataBean2.getLike()) {
            getPresenter().S(dataBean2.getCode(), i11);
            dataBean2.setLike(i11);
            v9.a adapter = this.f79434e.getAdapter();
            List c11 = adapter.c();
            for (int i12 = 0; i12 < c11.size(); i12++) {
                s9.a aVar = (s9.a) c11.get(i12);
                if ((aVar instanceof OtcFAQDialogDataType) && (dataBean = ((OtcFAQDialogDataType) aVar).getDataBean()) != null && TextUtils.equals(dataBean.getCode(), dataBean2.getCode())) {
                    adapter.notifyItemChanged(i12, aVar);
                }
            }
        }
    }

    public void onCreate(Bundle bundle) {
        Og(this);
        super.onCreate(bundle);
    }

    public void rf(List<OtcFAQBean> list) {
        OtcFAQBean otcFAQBean = list.get(0);
        if (!otcFAQBean.hasSubset()) {
            otcFAQBean.setSubset(new ArrayList());
        }
        List<OtcFAQBean> subset = otcFAQBean.getSubset();
        ArrayList arrayList = new ArrayList();
        for (OtcFAQBean next : list) {
            if (next != otcFAQBean && next.hasSubset()) {
                subset.addAll(next.getSubset());
            }
        }
        if (otcFAQBean.hasSubset()) {
            OtcFAQDialogDataType otcFAQDialogDataType = new OtcFAQDialogDataType();
            otcFAQBean.setLocalAll(true);
            otcFAQDialogDataType.setDataBean(otcFAQBean);
            otcFAQDialogDataType.setOnItemClickListener(this);
            arrayList.add(otcFAQDialogDataType);
            this.f79434e.setData(arrayList);
            this.f79435f.g();
            return;
        }
        this.f79435f.k();
    }

    public void w6(UserSecuritySetData userSecuritySetData) {
        if (userSecuritySetData == null || userSecuritySetData.getUserVO() == null) {
            HuobiToastUtil.g(R$string.otc_retry_later);
        } else if (userSecuritySetData.getUserVO().isIsTradeBind()) {
            OtcModuleConfig.b().z(this, new Intent());
        } else if (userSecuritySetData.getUserVO().isVerifyWayHaveSet()) {
            nb.c.j(this, false);
        } else {
            startActivity(new Intent(this, OtcTradeSettingActivity.class));
        }
    }
}
