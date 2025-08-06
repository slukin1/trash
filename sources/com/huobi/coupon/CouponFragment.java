package com.huobi.coupon;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import com.hbg.lib.network.hbg.socket.response.BaseHbgResponse;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.otc.widget.CouponReturnItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import pro.huobi.R;

public class CouponFragment extends BaseDialogFragment implements View.OnClickListener, BaseDialogFragment.c, CouponReturnItem.b {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CouponReturn> f43736b;

    /* renamed from: c  reason: collision with root package name */
    public EasyRecyclerView f43737c;

    /* renamed from: d  reason: collision with root package name */
    public b f43738d;

    /* renamed from: e  reason: collision with root package name */
    public CouponReturn f43739e;

    /* renamed from: f  reason: collision with root package name */
    public String f43740f = "";

    /* renamed from: g  reason: collision with root package name */
    public a f43741g;

    public interface a {
        void onDismiss();
    }

    public interface b {
        void a(CouponReturn couponReturn);
    }

    public void Qg(CouponReturn couponReturn) {
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
        a aVar = this.f43741g;
        if (aVar != null) {
            aVar.onDismiss();
        }
    }

    public void f4(HBDialogFragment hBDialogFragment, CouponReturn couponReturn) {
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.layout_coupon_layout;
    }

    public int getGravity() {
        return 80;
    }

    public Activity getRootActivity() {
        return getActivity();
    }

    public void initView(r rVar) {
        rVar.b(R.id.v_root).setOnClickListener(this);
        rVar.b(R.id.tv_close).setOnClickListener(this);
        rVar.b(R.id.ll_confirm).setOnClickListener(this);
        EasyRecyclerView easyRecyclerView = (EasyRecyclerView) rVar.b(R.id.easy_recycler_view_coupon);
        this.f43737c = easyRecyclerView;
        easyRecyclerView.setData(this.f43736b);
    }

    public boolean isTransparent() {
        return false;
    }

    public void l0(View view, CouponReturn couponReturn) {
        for (int i11 = 0; i11 < this.f43736b.size(); i11++) {
            if (this.f43736b.get(i11) == couponReturn) {
                this.f43736b.get(i11).setSelected(!this.f43736b.get(i11).isSelected());
                if (this.f43736b.get(i11).isSelected()) {
                    this.f43739e = couponReturn;
                } else {
                    this.f43739e = null;
                }
                this.f43737c.d(i11);
            } else if (this.f43736b.get(i11).isSelected()) {
                this.f43736b.get(i11).setSelected(false);
                this.f43737c.d(i11);
            }
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R.id.v_root || view.getId() == R.id.tv_close) {
            doDismiss();
            a aVar = this.f43741g;
            if (aVar != null) {
                aVar.onDismiss();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("trade_firtab_name", this.f43740f);
            hashMap.put("coupons_pop_click", "close");
            g.i("App_trade_coupons_pop_click", hashMap);
        } else if (view.getId() == R.id.ll_confirm) {
            doDismiss();
            b bVar = this.f43738d;
            if (bVar != null) {
                bVar.a(this.f43739e);
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("trade_firtab_name", this.f43740f);
            hashMap2.put("coupons_pop_click", BaseHbgResponse.STATUS_OK);
            g.i("App_trade_coupons_pop_click", hashMap2);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f43736b = (ArrayList) getArguments().getSerializable("COUPON_DATA");
        this.f43740f = getArguments().getString("DIALOG_ENTRY");
        Iterator<CouponReturn> it2 = this.f43736b.iterator();
        while (it2.hasNext()) {
            CouponReturn next = it2.next();
            next.setCallback(this);
            next.showNoThreshold = true;
            if (next.isSelected()) {
                this.f43739e = next;
            }
        }
    }

    public void onDialogFragmentBackPressed() {
    }

    public void onDialogFragmentPause() {
    }

    public void onDialogFragmentResume() {
        HashMap hashMap = new HashMap();
        hashMap.put("trade_firtab_name", this.f43740f);
        g.i("App_trade_coupons_pop_show", hashMap);
    }
}
