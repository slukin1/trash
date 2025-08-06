package com.huobi.guide.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.viewpager2.widget.ViewPager2;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.module.libkt.custom.indicator.CoIndicator;
import com.hbg.module.libkt.custom.indicator.TabData;
import com.huobi.guide.ui.ContractGuideContentFragment;
import gs.g;
import i6.n;
import i6.r;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.TimeUnit;
import kl.d;
import kl.e;
import kl.f;
import ne.b;
import pro.huobi.R;
import qk.a;
import qk.v0;
import rx.Observable;

public class ContractGuideNewFragment extends BaseDialogFragment implements ContractGuideContentFragment.a {

    /* renamed from: e  reason: collision with root package name */
    public static String f72461e;

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<TabData> f72462b = new ArrayList<>();

    /* renamed from: c  reason: collision with root package name */
    public boolean f72463c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f72464d = false;

    /* access modifiers changed from: private */
    public /* synthetic */ void vh(int i11) {
        String str;
        String str2;
        int tabId = this.f72462b.get(i11).getTabId();
        String str3 = "";
        if (tabId == 0) {
            str = "limited_price_entrust";
            str2 = "limit_order";
        } else if (tabId == 1) {
            str = "market_price_entrust";
            str2 = "market_order";
        } else if (tabId == 2) {
            str = "stop_surplus_loss";
            str2 = "stop_limit_order";
        } else if (tabId == 3) {
            str = "plan_entrust";
            str2 = "trigger_order";
        } else if (tabId == 4) {
            str = "tracking_entrust";
            str2 = str3;
        } else if (tabId != 5) {
            str = str3;
            str2 = str;
        } else {
            str = "period_entrust";
            str2 = "twap_order";
        }
        if (this.f72463c) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", str2);
            hashMap.put("trade_mode", f72461e);
            g.i("app_trade_order_type_remark_click", hashMap);
            return;
        }
        if (f72461e.contains("Future")) {
            str3 = "usdt_contract";
        } else if (!TextUtils.isEmpty(f72461e)) {
            str3 = "coin_contract";
        }
        g.j("entrust_model_explanation", str3, str, (HashMap) null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void wh(Void voidR) {
        doDismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void xh(Void voidR) {
        doDismiss();
    }

    public static ContractGuideNewFragment yh(int i11, String str) {
        ContractGuideNewFragment contractGuideNewFragment = new ContractGuideNewFragment();
        f72461e = str;
        Bundle bundle = new Bundle();
        bundle.putInt("tabIndex", i11);
        contractGuideNewFragment.setArguments(bundle);
        return contractGuideNewFragment;
    }

    public void Ah(boolean z11) {
        this.f72464d = z11;
    }

    public void addEvent(r rVar) {
    }

    public void afterInit() {
        setCanDismissOnBackPress(true);
        setCanceledOnTouchOutside(true);
        setCancelable(true);
    }

    public void callback() {
        doDismiss();
    }

    public void doDismiss() {
        super.doDismiss();
    }

    public int getAnimationStyle() {
        return R.style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R.layout.contract_guide_container_new;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        r rVar2 = rVar;
        Bundle arguments = getArguments();
        if (arguments != null) {
            int i11 = arguments.getInt("tabIndex", 0);
            this.f72462b.add(new TabData(getContext().getResources().getString(R.string.n_contract_intro_limit), 0, 0));
            this.f72462b.add(new TabData(getContext().getResources().getString(R.string.n_contract_intro_market), 1, 1));
            this.f72462b.add(new TabData(getContext().getResources().getString(R.string.n_contract_intro_tpsl), 2, 2));
            this.f72462b.add(new TabData(getContext().getResources().getString(R.string.n_contract_intro_plan), 3, 3));
            if (!this.f72463c) {
                this.f72462b.add(new TabData(getContext().getResources().getString(R.string.n_contract_intro_follow), 4, 4));
                if (a.b().f()) {
                    this.f72462b.add(new TabData(getContext().getResources().getString(R.string.n_contract_intro_timing), 5, 5));
                }
            } else if (v0.b().c(!this.f72464d)) {
                this.f72462b.add(new TabData(getContext().getResources().getString(R.string.n_contract_intro_timing), 5, 5));
            }
            ViewPager2 viewPager2 = (ViewPager2) rVar2.b(R.id.vp_contract_guide);
            CoIndicator coIndicator = (CoIndicator) rVar2.b(R.id.indicator_contract_guide_container);
            ViewGroup.LayoutParams layoutParams = viewPager2.getLayoutParams();
            layoutParams.height = (int) (((double) n.f(getContext())) * 0.6d);
            viewPager2.setLayoutParams(layoutParams);
            ArrayList arrayList = new ArrayList();
            Iterator<TabData> it2 = this.f72462b.iterator();
            while (it2.hasNext()) {
                int type = it2.next().getType();
                if (type == 0) {
                    arrayList.add(ContractGuideLimitFragment.Jh());
                } else if (type == 1) {
                    ContractGuideMarketFragment Eh = ContractGuideMarketFragment.Eh();
                    Eh.Fh(this.f72463c);
                    arrayList.add(Eh);
                } else if (type == 2) {
                    arrayList.add(ContractGuideOtherFragment.Eh(2));
                } else if (type == 3) {
                    arrayList.add(ContractGuideOtherFragment.Eh(3));
                } else if (type == 4) {
                    arrayList.add(ContractGuideOtherFragment.Eh(4));
                } else if (type == 5) {
                    arrayList.add(ContractGuideOtherFragment.Eh(5));
                }
            }
            he.a aVar = new he.a((Fragment) this);
            aVar.a(arrayList);
            viewPager2.setAdapter(aVar);
            b.k(getActivity(), this.f72462b, coIndicator, viewPager2, 1, 16.0f, 16.0f, new d(this));
            viewPager2.setOffscreenPageLimit(arrayList.size());
            viewPager2.setCurrentItem(i11, false);
            Observable<Void> a11 = dw.a.a(rVar2.b(R.id.close_contract_guide_container));
            TimeUnit timeUnit = TimeUnit.SECONDS;
            a11.throttleFirst(1, timeUnit).subscribe(new e(this));
            dw.a.a(rVar2.b(R.id.cl_contract_guide_root)).throttleFirst(1, timeUnit).subscribe(new f(this));
        }
    }

    public boolean isTransparent() {
        return false;
    }

    public void zh(boolean z11) {
        this.f72463c = z11;
    }
}
