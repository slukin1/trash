package com.huobi.copytrading.ui;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.ImageView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.p;
import com.huobi.copytrading.p038enum.Module;
import com.huobi.copytrading.vm.CopyTradingViewModel;
import com.huobi.copytrading.widget.CopyTradingMoreDialog;
import com.huobi.copytrading.widget.a;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import java.util.Locale;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.l;
import lj.a0;
import pro.huobi.R;
import sn.f;

public final class CopyTradingNewHomeFragment extends CopyBaseFragment {

    /* renamed from: h  reason: collision with root package name */
    public static final a f43636h = new a((r) null);

    /* renamed from: f  reason: collision with root package name */
    public final i f43637f = FragmentViewModelLazyKt.c(this, Reflection.b(CopyTradingViewModel.class), new CopyTradingNewHomeFragment$special$$inlined$activityViewModels$default$1(this), new CopyTradingNewHomeFragment$special$$inlined$activityViewModels$default$2((d10.a) null, this), new CopyTradingNewHomeFragment$special$$inlined$activityViewModels$default$3(this));

    /* renamed from: g  reason: collision with root package name */
    public a0 f43638g;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final CopyTradingNewHomeFragment a() {
            return new CopyTradingNewHomeFragment();
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f43639b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f43640c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CopyTradingNewHomeFragment f43641d;

        public b(View view, long j11, CopyTradingNewHomeFragment copyTradingNewHomeFragment) {
            this.f43639b = view;
            this.f43640c = j11;
            this.f43641d = copyTradingNewHomeFragment;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            com.hbg.module.libkt.utils.r rVar = com.hbg.module.libkt.utils.r.f24939a;
            if (currentTimeMillis - rVar.b(this.f43639b) > this.f43640c || (this.f43639b instanceof Checkable)) {
                rVar.e(this.f43639b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f43639b;
                g.i("appclick_copytrading", MapsKt__MapsKt.j(l.a("business_category", "copytrading_app_home"), l.a("button_name", "more")));
                CopyTradingMoreDialog copyTradingMoreDialog = new CopyTradingMoreDialog(this.f43641d.uh().y0(), 0, false, 6, (r) null);
                copyTradingMoreDialog.sh(new d(this.f43641d, copyTradingMoreDialog));
                copyTradingMoreDialog.show(this.f43641d.getChildFragmentManager(), "");
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f43642b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f43643c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CopyTradingNewHomeFragment f43644d;

        public c(View view, long j11, CopyTradingNewHomeFragment copyTradingNewHomeFragment) {
            this.f43642b = view;
            this.f43643c = j11;
            this.f43644d = copyTradingNewHomeFragment;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            com.hbg.module.libkt.utils.r rVar = com.hbg.module.libkt.utils.r.f24939a;
            if (currentTimeMillis - rVar.b(this.f43642b) > this.f43643c || (this.f43642b instanceof Checkable)) {
                rVar.e(this.f43642b, currentTimeMillis);
                ImageView imageView = (ImageView) this.f43642b;
                g.i("appclick_copytrading", MapsKt__MapsKt.j(l.a("business_category", "copytrading_app_home"), l.a("button_name", FirebaseAnalytics.Event.SEARCH)));
                this.f43644d.uh().h0().I("goToSearchPage()");
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class d implements a.C0566a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CopyTradingNewHomeFragment f43645a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CopyTradingMoreDialog f43646b;

        public d(CopyTradingNewHomeFragment copyTradingNewHomeFragment, CopyTradingMoreDialog copyTradingMoreDialog) {
            this.f43645a = copyTradingNewHomeFragment;
            this.f43646b = copyTradingMoreDialog;
        }

        public void a(com.huobi.copytrading.widget.a aVar) {
            String str;
            Integer valueOf = aVar != null ? Integer.valueOf(aVar.d()) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                g.i("appclick_copytrading", MapsKt__MapsKt.j(l.a("business_category", "copytrading_app_home"), l.a("button_name", "apply_for_trader")));
                zn.a.d().v(Uri.parse(BaseModuleConfig.a().k("tradingbot/h5/futures/trader-apply"))).a().c();
            } else if (valueOf != null && valueOf.intValue() == 1) {
                zn.a.d().v(Uri.parse(BaseModuleConfig.a().j() + "/support" + f.s() + "list/54917195353341")).a().c();
            } else {
                g.i("appclick_copytrading", MapsKt__MapsKt.j(l.a("business_category", "copytrading_app_home"), l.a("button_name", "beginner's_guide")));
                String lowerCase = p.a(this.f43645a.uh().h0().d()).toLowerCase(Locale.getDefault());
                if (this.f43645a.uh().y0()) {
                    str = com.huobi.utils.a0.j() + "/support/" + lowerCase + "/detail/84918830711117";
                } else {
                    str = com.huobi.utils.a0.j() + "/support/" + lowerCase + "/detail/104918827613976";
                }
                zn.a.d().v(Uri.parse(str)).a().c();
            }
            this.f43646b.dismiss();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        a0 a0Var = (a0) androidx.databinding.c.e(layoutInflater, R.layout.fragment_copy_trading_new_home, viewGroup, false);
        this.f43638g = a0Var;
        if (a0Var == null) {
            a0Var = null;
        }
        return a0Var.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        a0 a0Var = this.f43638g;
        a0 a0Var2 = null;
        if (a0Var == null) {
            a0Var = null;
        }
        a0Var.L(uh());
        a0 a0Var3 = this.f43638g;
        if (a0Var3 == null) {
            a0Var3 = null;
        }
        a0Var3.K(this);
        a0 a0Var4 = this.f43638g;
        if (a0Var4 == null) {
            a0Var4 = null;
        }
        a0Var4.F(this);
        getLifecycle().a(uh());
        vh();
        com.hbg.module.libkt.utils.r rVar = com.hbg.module.libkt.utils.r.f24939a;
        a0 a0Var5 = this.f43638g;
        if (a0Var5 == null) {
            a0Var5 = null;
        }
        ImageView imageView = a0Var5.B;
        imageView.setOnClickListener(new b(imageView, 800, this));
        a0 a0Var6 = this.f43638g;
        if (a0Var6 != null) {
            a0Var2 = a0Var6;
        }
        ImageView imageView2 = a0Var2.C;
        imageView2.setOnClickListener(new c(imageView2, 800, this));
    }

    public void ph() {
    }

    public void qh() {
    }

    public void sh() {
        super.sh();
        uh().h0().I("tradePanel.onAppear()");
    }

    public final CopyTradingViewModel uh() {
        return (CopyTradingViewModel) this.f43637f.getValue();
    }

    public final void vh() {
        CopyTradingViewModel uh2 = uh();
        Module module = Module.HOME_PAGE;
        a0 a0Var = this.f43638g;
        a0 a0Var2 = null;
        if (a0Var == null) {
            a0Var = null;
        }
        uh2.m0(module, a0Var.F);
        CopyTradingViewModel uh3 = uh();
        Module module2 = Module.HOME_SORT_POP;
        a0 a0Var3 = this.f43638g;
        if (a0Var3 == null) {
            a0Var3 = null;
        }
        uh3.m0(module2, a0Var3.G);
        CopyTradingViewModel uh4 = uh();
        Module module3 = Module.TRADE_LIST;
        a0 a0Var4 = this.f43638g;
        if (a0Var4 != null) {
            a0Var2 = a0Var4;
        }
        uh4.m0(module3, a0Var2.D);
    }

    public final void wh() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }
}
