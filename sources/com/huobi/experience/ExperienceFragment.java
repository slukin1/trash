package com.huobi.experience;

import android.os.Bundle;
import android.view.View;
import com.hbg.lib.network.hbg.socket.response.BaseHbgResponse;
import com.hbg.lib.widgets.adapter.recyclerview.EasyRecyclerView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.otc.widget.ExperienceItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import i6.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import pro.huobi.R;

public class ExperienceFragment extends BaseDialogFragment implements View.OnClickListener, BaseDialogFragment.c, ExperienceItem.e {

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<CouponReturn> f44614b;

    /* renamed from: c  reason: collision with root package name */
    public ArrayList<CouponReturn> f44615c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    public EasyRecyclerView f44616d;

    /* renamed from: e  reason: collision with root package name */
    public b f44617e;

    /* renamed from: f  reason: collision with root package name */
    public String f44618f = "";

    /* renamed from: g  reason: collision with root package name */
    public a f44619g;

    public interface a {
        void onDismiss();
    }

    public interface b {
        void a(List<CouponReturn> list);
    }

    public static ExperienceFragment sh() {
        return new ExperienceFragment();
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
        a aVar = this.f44619g;
        if (aVar != null) {
            aVar.onDismiss();
        }
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.dialog_contract_experience_layout;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        rVar.b(R.id.v_root).setOnClickListener(this);
        rVar.c(R.id.iv_close).setOnClickListener(this);
        rVar.b(R.id.ll_confirm).setOnClickListener(this);
        EasyRecyclerView easyRecyclerView = (EasyRecyclerView) rVar.b(R.id.easy_recycler_view_coupon);
        this.f44616d = easyRecyclerView;
        easyRecyclerView.setData(this.f44614b);
        rVar.b(R.id.ll_confirm).setEnabled(false);
    }

    public boolean isTransparent() {
        return false;
    }

    public void l0(View view, CouponReturn couponReturn) {
        for (int i11 = 0; i11 < this.f44614b.size(); i11++) {
            if (this.f44614b.get(i11) == couponReturn) {
                if (!this.f44614b.get(i11).isSelected()) {
                    this.f44614b.get(i11).setSelected(true);
                    this.f44615c.add(this.f44614b.get(i11));
                } else {
                    this.f44614b.get(i11).setSelected(false);
                    this.f44615c.remove(this.f44614b.get(i11));
                }
                this.f44616d.d(i11);
            }
        }
        if (this.f44615c.size() > 0) {
            this.viewFinder.b(R.id.ll_confirm).setEnabled(true);
        } else {
            this.viewFinder.b(R.id.ll_confirm).setEnabled(false);
        }
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (view.getId() == R.id.v_root || view.getId() == R.id.iv_close) {
            doDismiss();
            a aVar = this.f44619g;
            if (aVar != null) {
                aVar.onDismiss();
            }
            HashMap hashMap = new HashMap();
            hashMap.put("trade_firtab_name", this.f44618f);
            hashMap.put("coupons_pop_click", "close");
        } else if (view.getId() == R.id.ll_confirm) {
            doDismiss();
            b bVar = this.f44617e;
            if (bVar != null) {
                bVar.a(this.f44615c);
            }
            HashMap hashMap2 = new HashMap();
            hashMap2.put("trade_firtab_name", this.f44618f);
            hashMap2.put("coupons_pop_click", BaseHbgResponse.STATUS_OK);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f44614b = (ArrayList) getArguments().getSerializable("COUPON_DATA");
        this.f44618f = getArguments().getString("DIALOG_ENTRY");
        Iterator<CouponReturn> it2 = this.f44614b.iterator();
        while (it2.hasNext()) {
            CouponReturn next = it2.next();
            next.setExCallback(this);
            next.setSelected(false);
            next.expanded = false;
        }
    }

    public void onDialogFragmentBackPressed() {
    }

    public void onDialogFragmentPause() {
    }

    public void onDialogFragmentResume() {
        HashMap hashMap = new HashMap();
        hashMap.put("trade_firtab_name", this.f44618f);
        g.i("App_trade_coupons_pop_show", hashMap);
    }

    public void th(b bVar) {
        this.f44617e = bVar;
    }
}
