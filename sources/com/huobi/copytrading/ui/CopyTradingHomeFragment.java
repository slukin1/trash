package com.huobi.copytrading.ui;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Checkable;
import android.widget.LinearLayout;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.z;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.p;
import com.hbg.lib.widgets.dialog.bean.MenuItemBean;
import com.hbg.lib.widgets.dialog.dialogfragment.BottomMenuNewDialogFragment;
import com.huobi.copytrading.p038enum.Module;
import com.huobi.copytrading.vm.CopyTradingViewModel;
import com.huobi.copytrading.widget.CopyTradingMoreDialog;
import com.huobi.copytrading.widget.a;
import com.huobi.utils.a0;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import d10.q;
import java.util.ArrayList;
import java.util.Locale;
import kotlin.Unit;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.u;
import kotlin.jvm.internal.x;
import lj.w;
import org.json.JSONArray;
import pro.huobi.R;
import rd.s;
import sn.f;

public final class CopyTradingHomeFragment extends CopyBaseFragment {

    /* renamed from: l  reason: collision with root package name */
    public static final a f43606l = new a((r) null);

    /* renamed from: f  reason: collision with root package name */
    public final i f43607f = FragmentViewModelLazyKt.c(this, Reflection.b(CopyTradingViewModel.class), new CopyTradingHomeFragment$special$$inlined$activityViewModels$default$1(this), new CopyTradingHomeFragment$special$$inlined$activityViewModels$default$2((d10.a) null, this), new CopyTradingHomeFragment$special$$inlined$activityViewModels$default$3(this));

    /* renamed from: g  reason: collision with root package name */
    public w f43608g;

    /* renamed from: h  reason: collision with root package name */
    public final BottomMenuNewDialogFragment f43609h = new BottomMenuNewDialogFragment();

    /* renamed from: i  reason: collision with root package name */
    public int f43610i;

    /* renamed from: j  reason: collision with root package name */
    public String[] f43611j;

    /* renamed from: k  reason: collision with root package name */
    public final q<View, MenuItemBean, Integer, Unit> f43612k = new CopyTradingHomeFragment$dialogSelectListener$1(this);

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final CopyTradingHomeFragment a() {
            return new CopyTradingHomeFragment();
        }
    }

    public static final class b implements View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ View f43613b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ long f43614c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ CopyTradingHomeFragment f43615d;

        public b(View view, long j11, CopyTradingHomeFragment copyTradingHomeFragment) {
            this.f43613b = view;
            this.f43614c = j11;
            this.f43615d = copyTradingHomeFragment;
        }

        @SensorsDataInstrumented
        public final void onClick(View view) {
            long currentTimeMillis = System.currentTimeMillis();
            s sVar = s.f23381a;
            if (currentTimeMillis - sVar.b(this.f43613b) > this.f43614c || (this.f43613b instanceof Checkable)) {
                sVar.e(this.f43613b, currentTimeMillis);
                LinearLayout linearLayout = (LinearLayout) this.f43613b;
                this.f43615d.Uh();
            }
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
        }
    }

    public static final class c implements a.C0566a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CopyTradingHomeFragment f43616a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CopyTradingMoreDialog f43617b;

        public c(CopyTradingHomeFragment copyTradingHomeFragment, CopyTradingMoreDialog copyTradingMoreDialog) {
            this.f43616a = copyTradingHomeFragment;
            this.f43617b = copyTradingMoreDialog;
        }

        public void a(com.huobi.copytrading.widget.a aVar) {
            String str;
            Integer valueOf = aVar != null ? Integer.valueOf(aVar.d()) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                zn.a.d().v(Uri.parse(BaseModuleConfig.a().k("tradingbot/h5/futures/trader-apply"))).a().c();
            } else if (valueOf != null && valueOf.intValue() == 1) {
                zn.a.d().v(Uri.parse(BaseModuleConfig.a().j() + "/support" + f.s() + "list/54917195353341")).a().c();
            } else {
                String lowerCase = p.a(this.f43616a.Ih().h0().d()).toLowerCase(Locale.getDefault());
                if (this.f43616a.Ih().y0()) {
                    str = a0.j() + "/support/" + lowerCase + "/detail/84918830711117";
                } else {
                    str = a0.j() + "/support/" + lowerCase + "/detail/104918827613976";
                }
                zn.a.d().v(Uri.parse(str)).a().c();
            }
            this.f43617b.dismiss();
        }
    }

    public static final class d implements z, u {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l f43618b;

        public d(l lVar) {
            this.f43618b = lVar;
        }

        public final boolean equals(Object obj) {
            if (!(obj instanceof z) || !(obj instanceof u)) {
                return false;
            }
            return x.b(getFunctionDelegate(), ((u) obj).getFunctionDelegate());
        }

        public final kotlin.f<?> getFunctionDelegate() {
            return this.f43618b;
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }

        public final /* synthetic */ void onChanged(Object obj) {
            this.f43618b.invoke(obj);
        }
    }

    public static final void Kh(q qVar, View view, MenuItemBean menuItemBean, int i11) {
        qVar.invoke(view, menuItemBean, Integer.valueOf(i11));
    }

    public static final void Lh(q qVar, View view, MenuItemBean menuItemBean, int i11) {
        qVar.invoke(view, menuItemBean, Integer.valueOf(i11));
    }

    public static final void Mh(q qVar, View view, MenuItemBean menuItemBean, int i11) {
        qVar.invoke(view, menuItemBean, Integer.valueOf(i11));
    }

    public static final void Nh(q qVar, View view, MenuItemBean menuItemBean, int i11) {
        qVar.invoke(view, menuItemBean, Integer.valueOf(i11));
    }

    public static final void Oh(q qVar, View view, MenuItemBean menuItemBean, int i11) {
        qVar.invoke(view, menuItemBean, Integer.valueOf(i11));
    }

    public static final void Ph(CopyTradingHomeFragment copyTradingHomeFragment, AppBarLayout appBarLayout, int i11) {
        float abs = Math.abs(((float) i11) * 1.0f) / ((float) appBarLayout.getTotalScrollRange());
        w wVar = copyTradingHomeFragment.f43608g;
        w wVar2 = null;
        if (wVar == null) {
            wVar = null;
        }
        wVar.I.setAlpha(abs);
        w wVar3 = copyTradingHomeFragment.f43608g;
        if (wVar3 != null) {
            wVar2 = wVar3;
        }
        wVar2.C.setAlpha(((float) 1) - abs);
    }

    public static final void Qh(CopyTradingHomeFragment copyTradingHomeFragment, Object obj) {
        if (obj != null) {
            try {
                JSONArray jSONArray = new JSONArray(obj.toString());
                int length = jSONArray.length();
                String[] strArr = new String[length];
                for (int i11 = 0; i11 < length; i11++) {
                    strArr[i11] = jSONArray.getString(i11);
                }
                copyTradingHomeFragment.f43611j = strArr;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    @SensorsDataInstrumented
    public static final void Rh(CopyTradingHomeFragment copyTradingHomeFragment, View view) {
        CopyTradingMoreDialog copyTradingMoreDialog = new CopyTradingMoreDialog(copyTradingHomeFragment.Ih().y0(), 0, false, 6, (r) null);
        copyTradingMoreDialog.sh(new c(copyTradingHomeFragment, copyTradingMoreDialog));
        copyTradingMoreDialog.show(copyTradingHomeFragment.getChildFragmentManager(), "");
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void Vh(q qVar, View view, MenuItemBean menuItemBean, int i11) {
        qVar.invoke(view, menuItemBean, Integer.valueOf(i11));
    }

    public final CopyTradingViewModel Ih() {
        return (CopyTradingViewModel) this.f43607f.getValue();
    }

    public final MenuItemBean Jh(int i11) {
        MenuItemBean menuItemBean;
        if (i11 == 0) {
            menuItemBean = new MenuItemBean(getString(R.string.n_copy_trading_trader_rank_comprehensive), this.f43610i == 0 ? MenuItemBean.MenuItemStyle.STRESS : MenuItemBean.MenuItemStyle.COMMON, new h(this.f43612k));
        } else if (i11 == 1) {
            menuItemBean = new MenuItemBean(getString(R.string.copy_trading_total_rate), this.f43610i == 1 ? MenuItemBean.MenuItemStyle.STRESS : MenuItemBean.MenuItemStyle.COMMON, new f(this.f43612k));
        } else if (i11 == 2) {
            menuItemBean = new MenuItemBean(getString(R.string.copy_trading_total_profits), this.f43610i == 2 ? MenuItemBean.MenuItemStyle.STRESS : MenuItemBean.MenuItemStyle.COMMON, new e(this.f43612k));
        } else if (i11 != 3) {
            menuItemBean = new MenuItemBean(getString(R.string.n_copy_trading_trader_rank_comprehensive), this.f43610i == 0 ? MenuItemBean.MenuItemStyle.STRESS : MenuItemBean.MenuItemStyle.COMMON, new d(this.f43612k));
        } else {
            menuItemBean = new MenuItemBean(getString(R.string.copy_trading_follow_profits), this.f43610i == 3 ? MenuItemBean.MenuItemStyle.STRESS : MenuItemBean.MenuItemStyle.COMMON, new g(this.f43612k));
        }
        return menuItemBean;
    }

    public final void Sh() {
        CopyTradingViewModel Ih = Ih();
        Module module = Module.TRADE_LIST;
        w wVar = this.f43608g;
        if (wVar == null) {
            wVar = null;
        }
        Ih.m0(module, wVar.G);
    }

    public final void Th() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public final void Uh() {
        BottomMenuNewDialogFragment bottomMenuNewDialogFragment = this.f43609h;
        ArrayList arrayList = new ArrayList();
        String[] strArr = this.f43611j;
        int i11 = 0;
        if (strArr != null) {
            if (!(strArr != null && strArr.length == 0)) {
                int length = strArr.length;
                while (i11 < length) {
                    arrayList.add(new MenuItemBean(strArr[i11], this.f43610i == i11 ? MenuItemBean.MenuItemStyle.STRESS : MenuItemBean.MenuItemStyle.COMMON, new c(this.f43612k)));
                    i11++;
                }
                bottomMenuNewDialogFragment.vh(arrayList);
                this.f43609h.show(getChildFragmentManager(), "");
            }
        }
        arrayList.add(Jh(0));
        arrayList.add(Jh(1));
        arrayList.add(Jh(2));
        arrayList.add(Jh(3));
        bottomMenuNewDialogFragment.vh(arrayList);
        this.f43609h.show(getChildFragmentManager(), "");
    }

    public final void initListener() {
        w wVar = this.f43608g;
        w wVar2 = null;
        if (wVar == null) {
            wVar = null;
        }
        wVar.B.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new b(this));
        Ih().h0().u("traderData.filterInfo", new i(this));
        s sVar = s.f23381a;
        w wVar3 = this.f43608g;
        if (wVar3 == null) {
            wVar3 = null;
        }
        LinearLayout linearLayout = wVar3.F;
        linearLayout.setOnClickListener(new b(linearLayout, 800, this));
        w wVar4 = this.f43608g;
        if (wVar4 != null) {
            wVar2 = wVar4;
        }
        wVar2.E.setOnClickListener(new a(this));
        Ih().x0().observe(getViewLifecycleOwner(), new d(new CopyTradingHomeFragment$initListener$5(this)));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        w wVar = (w) androidx.databinding.c.e(layoutInflater, R.layout.fragment_copy_trading_home, viewGroup, false);
        this.f43608g = wVar;
        if (wVar == null) {
            wVar = null;
        }
        return wVar.getRoot();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        w wVar = this.f43608g;
        w wVar2 = null;
        if (wVar == null) {
            wVar = null;
        }
        wVar.L(Ih());
        w wVar3 = this.f43608g;
        if (wVar3 == null) {
            wVar3 = null;
        }
        wVar3.K(this);
        w wVar4 = this.f43608g;
        if (wVar4 != null) {
            wVar2 = wVar4;
        }
        wVar2.F(this);
        getLifecycle().a(Ih());
        Sh();
        initListener();
    }

    public void ph() {
        Ih().h0().I("traderListData.requestTraderList(false)");
    }

    public void qh() {
    }
}
