package qh;

import android.app.Activity;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.cpiz.android.bubbleview.BubbleTextView;
import com.cpiz.android.bubbleview.d;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.R$id;
import com.hbg.lib.core.R$layout;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.ui.BaseFragment;
import com.hbg.lib.core.util.ConfigPreferences;
import com.hbg.lib.network.hbg.core.bean.AssetDailyData;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.SpotAssertInfo;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$string;
import i6.m;
import java.math.BigDecimal;
import org.greenrobot.eventbus.EventBus;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public final class p0 {

    /* renamed from: g  reason: collision with root package name */
    public static final p0 f47744g = new p0();

    /* renamed from: a  reason: collision with root package name */
    public com.cpiz.android.bubbleview.c f47745a;

    /* renamed from: b  reason: collision with root package name */
    public com.cpiz.android.bubbleview.c f47746b;

    /* renamed from: c  reason: collision with root package name */
    public AssetDailyData f47747c = new AssetDailyData();

    /* renamed from: d  reason: collision with root package name */
    public SpotAssertInfo f47748d;

    /* renamed from: e  reason: collision with root package name */
    public String f47749e;

    /* renamed from: f  reason: collision with root package name */
    public String f47750f;

    public class a extends EasySubscriber<SpotAssertInfo> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(SpotAssertInfo spotAssertInfo) {
            super.onNext(spotAssertInfo);
            p0.this.B(spotAssertInfo);
        }
    }

    public class b extends EasySubscriber<BalanceProfitLossData> {
        public b() {
        }

        /* renamed from: a */
        public void onNext(BalanceProfitLossData balanceProfitLossData) {
            super.onNext(balanceProfitLossData);
            if (balanceProfitLossData != null) {
                p0.this.C(balanceProfitLossData.getTotalBalance());
            }
        }
    }

    public class c extends EasySubscriber<AssetDailyData> {
        public c() {
        }

        /* renamed from: a */
        public void onNext(AssetDailyData assetDailyData) {
            super.onNext(assetDailyData);
            if (assetDailyData != null) {
                String uid = BaseModuleConfig.a().getUid();
                if (TextUtils.isEmpty(uid) || !uid.startsWith(assetDailyData.userId)) {
                    p0.this.f47747c.reset();
                } else {
                    AssetDailyData unused = p0.this.f47747c = assetDailyData;
                }
                EventBus.d().k(p0.this.f47747c);
            }
        }
    }

    public static p0 n() {
        return f47744g;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r() {
        ConfigPreferences.n("user_config", BaseModuleConfig.a().getUid() + "_" + "BUBBLE_ASSERT_TAB_DAILY_GUIDE", true);
        this.f47745a = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(Activity activity, View view) {
        View inflate = LayoutInflater.from(activity).inflate(R$layout.view_light_bubble, (ViewGroup) null);
        BubbleTextView bubbleTextView = (BubbleTextView) inflate.findViewById(R$id.popup_bubble);
        bubbleTextView.setFillColor(l());
        bubbleTextView.setBorderColor(l());
        bubbleTextView.setTextColor(m());
        bubbleTextView.setBorderWidth(0.0f);
        bubbleTextView.setText(inflate.getResources().getString(R$string.n_asset_profitanalysis_tabguide));
        Resources resources = view.getResources();
        int i11 = R$dimen.dimen_12;
        int dimensionPixelOffset = resources.getDimensionPixelOffset(i11);
        Resources resources2 = view.getResources();
        int i12 = R$dimen.dimen_8;
        bubbleTextView.setPadding(dimensionPixelOffset, resources2.getDimensionPixelOffset(i12), view.getResources().getDimensionPixelOffset(i11), view.getResources().getDimensionPixelOffset(i12));
        bubbleTextView.getBubbleImpl().B((float) view.getResources().getDimensionPixelOffset(i12));
        bubbleTextView.getBubbleImpl().y((float) view.getResources().getDimensionPixelOffset(R$dimen.dimen_4));
        bubbleTextView.setMaxWidth(view.getResources().getDimensionPixelOffset(R$dimen.dimen_240));
        this.f47745a = new com.cpiz.android.bubbleview.c(inflate, bubbleTextView);
        d dVar = new d(4, 1);
        this.f47745a.setOnDismissListener(new k0(this));
        this.f47745a.setArrowPosDelta(view.getWidth() / 2);
        this.f47745a.showArrowTo(view, dVar, 0, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t() {
        ConfigPreferences.n("user_config", BaseModuleConfig.a().getUid() + "_" + "BUBBLE_PROFITANALYSIS_GUIDE_GUIDE", true);
        this.f47746b = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u(BaseFragment baseFragment, View view) {
        if (baseFragment.isCanBeSeen()) {
            View inflate = LayoutInflater.from(baseFragment.getActivity()).inflate(R$layout.view_light_bubble, (ViewGroup) null);
            BubbleTextView bubbleTextView = (BubbleTextView) inflate.findViewById(R$id.popup_bubble);
            bubbleTextView.setFillColor(l());
            bubbleTextView.setBorderColor(l());
            bubbleTextView.setBorderWidth(0.0f);
            bubbleTextView.setTextColor(m());
            bubbleTextView.setText(inflate.getResources().getString(R$string.n_asset_profitanalysis_guide));
            Resources resources = view.getResources();
            int i11 = R$dimen.dimen_12;
            int dimensionPixelOffset = resources.getDimensionPixelOffset(i11);
            Resources resources2 = view.getResources();
            int i12 = R$dimen.dimen_8;
            bubbleTextView.setPadding(dimensionPixelOffset, resources2.getDimensionPixelOffset(i12), view.getResources().getDimensionPixelOffset(i11), view.getResources().getDimensionPixelOffset(i12));
            bubbleTextView.getBubbleImpl().B((float) view.getResources().getDimensionPixelOffset(i12));
            bubbleTextView.getBubbleImpl().y((float) view.getResources().getDimensionPixelOffset(R$dimen.dimen_4));
            bubbleTextView.setMaxWidth(view.getResources().getDimensionPixelOffset(R$dimen.dimen_240));
            this.f47746b = new com.cpiz.android.bubbleview.c(inflate, bubbleTextView);
            d dVar = new d(4, 1);
            this.f47746b.setOnDismissListener(new j0(this));
            this.f47746b.setArrowPosDelta(view.getWidth() / 2);
            this.f47746b.showArrowTo(view, dVar, 0, 0);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v() {
        ConfigPreferences.n("user_config", BaseModuleConfig.a().getUid() + "_" + "BUBBLE_PROFITANALYSIS_GUIDE_GUIDE", true);
        this.f47746b = null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void w(View view) {
        View inflate = LayoutInflater.from(view.getContext()).inflate(R$layout.view_light_bubble, (ViewGroup) null);
        BubbleTextView bubbleTextView = (BubbleTextView) inflate.findViewById(R$id.popup_bubble);
        bubbleTextView.setFillColor(l());
        bubbleTextView.setBorderColor(l());
        bubbleTextView.setBorderWidth(0.0f);
        bubbleTextView.setTextColor(m());
        bubbleTextView.setText(inflate.getResources().getString(R$string.n_asset_profitanalysis_guide));
        Resources resources = view.getResources();
        int i11 = R$dimen.dimen_12;
        int dimensionPixelOffset = resources.getDimensionPixelOffset(i11);
        Resources resources2 = view.getResources();
        int i12 = R$dimen.dimen_8;
        bubbleTextView.setPadding(dimensionPixelOffset, resources2.getDimensionPixelOffset(i12), view.getResources().getDimensionPixelOffset(i11), view.getResources().getDimensionPixelOffset(i12));
        bubbleTextView.getBubbleImpl().B((float) view.getResources().getDimensionPixelOffset(i12));
        bubbleTextView.getBubbleImpl().y((float) view.getResources().getDimensionPixelOffset(R$dimen.dimen_4));
        bubbleTextView.setMaxWidth(view.getResources().getDimensionPixelOffset(R$dimen.dimen_240));
        this.f47746b = new com.cpiz.android.bubbleview.c(inflate, bubbleTextView);
        d dVar = new d(4, 1);
        this.f47746b.setOnDismissListener(new l0(this));
        this.f47746b.setArrowPosDelta(view.getWidth() / 2);
        this.f47746b.showArrowTo(view, dVar, 0, 0);
    }

    public void A(String str) {
        this.f47750f = str;
    }

    public void B(SpotAssertInfo spotAssertInfo) {
        this.f47748d = spotAssertInfo;
    }

    public void C(String str) {
        this.f47749e = str;
    }

    public void D(Activity activity, View view) {
        if (view != null) {
            if (!ConfigPreferences.c("user_config", BaseModuleConfig.a().getUid() + "_" + "BUBBLE_ASSERT_TAB_DAILY_GUIDE", false) && this.f47745a == null && this.f47747c.displayGuideDot()) {
                view.postDelayed(new m0(this, activity, view), 0);
            }
        }
    }

    public void E(BaseFragment baseFragment, View view) {
        if (view != null) {
            if (!ConfigPreferences.c("user_config", BaseModuleConfig.a().getUid() + "_" + "BUBBLE_PROFITANALYSIS_GUIDE_GUIDE", false) && this.f47746b == null && this.f47747c.displayGuideDot()) {
                view.postDelayed(new o0(this, baseFragment, view), 0);
            }
        }
    }

    public void F(View view) {
        if (view != null) {
            if (!ConfigPreferences.c("user_config", BaseModuleConfig.a().getUid() + "_" + "BUBBLE_PROFITANALYSIS_GUIDE_GUIDE", false) && this.f47746b == null && this.f47747c.displayGuideDot()) {
                view.postDelayed(new n0(this, view), 0);
            }
        }
    }

    public void i() {
        y();
        z();
    }

    public void j(String str) {
        v7.b.a().getAssertInfo(str).b().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new a());
    }

    public AssetDailyData k() {
        return this.f47747c;
    }

    public final int l() {
        return -11776946;
    }

    public final int m() {
        return -1;
    }

    public SpotAssertInfo o() {
        return this.f47748d;
    }

    public boolean p() {
        if (!AssetModuleConfig.a().c() && m.a(this.f47749e).equals(BigDecimal.ZERO) && !com.huobi.asset2.index.util.b.a().d()) {
            return true;
        }
        return false;
    }

    public boolean q() {
        if (!AssetModuleConfig.a().c() && m.a(this.f47750f).equals(BigDecimal.ZERO) && !com.huobi.asset2.index.util.b.a().d()) {
            return true;
        }
        return false;
    }

    public void x() {
        if (BaseModuleConfig.a().a()) {
            v7.b.a().getAssertDialy().b().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new c());
        }
    }

    public void y() {
        j(AssetModuleConfig.a().T());
    }

    public void z() {
        i0.d().e().subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new b());
    }
}
