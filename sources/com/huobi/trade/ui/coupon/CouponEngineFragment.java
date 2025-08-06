package com.huobi.trade.ui.coupon;

import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.alibaba.fastjson.JSONObject;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.widgets.adapter.recyclerview.StableLinearLayoutManager;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.coupon.bean.CouponReturn;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIConstants;
import gs.g;
import i6.r;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import pro.huobi.R;

public class CouponEngineFragment extends BaseDialogFragment implements View.OnClickListener, BaseDialogFragment.c {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CouponReturn> f82596b;

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f82597c;

    /* renamed from: d  reason: collision with root package name */
    public b f82598d;

    /* renamed from: e  reason: collision with root package name */
    public CouponReturn f82599e;

    /* renamed from: f  reason: collision with root package name */
    public String f82600f = "";

    /* renamed from: g  reason: collision with root package name */
    public String f82601g = "";

    /* renamed from: h  reason: collision with root package name */
    public rj.b f82602h;

    /* renamed from: i  reason: collision with root package name */
    public kt.a f82603i;

    /* renamed from: j  reason: collision with root package name */
    public a f82604j;

    public interface a {
        void onDismiss();
    }

    public interface b {
        void a(CouponReturn couponReturn);
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
        setCanDismissOnBackPress(true);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void doDismiss() {
        super.doDismiss();
        a aVar = this.f82604j;
        if (aVar != null) {
            aVar.onDismiss();
        }
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.layout_coupon_engine;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        rVar.b(R.id.v_root).setOnClickListener(this);
        ((FrameLayout) rVar.b(R.id.engine_coupon_title_fl)).addView(this.f82602h.E("trade_margin_coupon_title.xml", getContext(), false, (JSONObject) null));
        ((FrameLayout) rVar.b(R.id.engine_coupon_confirm_fl)).addView(this.f82602h.E("trade_margin_coupon_confirm.xml", getContext(), false, (JSONObject) null));
        RecyclerView recyclerView = (RecyclerView) rVar.b(R.id.engine_coupon_recycler);
        this.f82597c = recyclerView;
        recyclerView.setLayoutManager(new StableLinearLayoutManager(getContext()));
        kt.a aVar = new kt.a(this.f82602h);
        this.f82603i = aVar;
        aVar.setData(this.f82596b);
        this.f82597c.setAdapter(this.f82603i);
    }

    public boolean isTransparent() {
        return false;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R.id.v_root) {
            sh();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        rj.b bVar = new rj.b(getContext(), FirebaseAnalytics.Param.COUPON);
        this.f82602h = bVar;
        bVar.t("onEvent", CouponEvent.class);
        this.f82602h.H();
        this.f82602h.s(TUIConstants.TUIChat.FRAGMENT, new WeakReference(this));
        this.f82596b = (ArrayList) getArguments().getSerializable("COUPON_DATA");
        this.f82600f = getArguments().getString("DIALOG_MODE");
        this.f82601g = getArguments().getString("DIALOG_VERSION");
        Iterator<CouponReturn> it2 = this.f82596b.iterator();
        while (it2.hasNext()) {
            CouponReturn next = it2.next();
            if (next.isSelected()) {
                this.f82599e = next;
            }
        }
    }

    public void onDestroy() {
        super.onDestroy();
        this.f82602h.B();
    }

    public void onDialogFragmentBackPressed() {
    }

    public void onDialogFragmentPause() {
    }

    public void onDialogFragmentResume() {
    }

    public void sh() {
        doDismiss();
        a aVar = this.f82604j;
        if (aVar != null) {
            aVar.onDismiss();
        }
    }

    public void th() {
        doDismiss();
        b bVar = this.f82598d;
        if (bVar != null) {
            bVar.a(this.f82599e);
        }
    }

    public void uh(long j11, boolean z11) {
        if (z11) {
            HashMap hashMap = new HashMap();
            hashMap.put("trade_mode", this.f82600f);
            hashMap.put("version_type", this.f82601g);
            g.i("app_trade_coupon_expand", hashMap);
        }
        int i11 = 0;
        while (i11 < this.f82596b.size()) {
            if (this.f82596b.get(i11).getId() != j11 || this.f82596b.get(i11).expanded == z11) {
                i11++;
            } else {
                this.f82596b.get(i11).expanded = z11;
                this.f82603i.notifyItemChanged(i11);
                return;
            }
        }
    }

    public void vh(long j11, boolean z11) {
        if (z11) {
            HashMap hashMap = new HashMap();
            hashMap.put("trade_mode", this.f82600f);
            hashMap.put("version_type", this.f82601g);
            g.i("app_trade_coupon_item_click", hashMap);
        }
        for (int i11 = 0; i11 < this.f82596b.size(); i11++) {
            if (this.f82596b.get(i11).getId() == j11) {
                this.f82596b.get(i11).setSelected(z11);
                if (this.f82596b.get(i11).isSelected()) {
                    this.f82599e = this.f82596b.get(i11);
                } else {
                    this.f82599e = null;
                }
                this.f82603i.notifyItemChanged(i11);
            } else if (this.f82596b.get(i11).isSelected()) {
                this.f82596b.get(i11).setSelected(false);
                this.f82603i.notifyItemChanged(i11);
            }
        }
    }
}
