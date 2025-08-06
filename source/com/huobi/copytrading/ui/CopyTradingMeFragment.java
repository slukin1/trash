package com.huobi.copytrading.ui;

import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import com.blankj.utilcode.util.m;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.huobi.copytrading.p038enum.ActionBar;
import com.huobi.copytrading.p038enum.Module;
import com.huobi.copytrading.p038enum.Tab;
import com.huobi.copytrading.p038enum.TabInfoBean;
import com.huobi.copytrading.ui.CopyTradingTradeFragment;
import com.huobi.copytrading.vm.CopyTradingViewModel;
import com.huobi.copytrading.widget.CopyTradingMoreDialog;
import com.huobi.copytrading.widget.a;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;
import java.util.List;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import lj.y;
import pro.huobi.R;

public final class CopyTradingMeFragment extends CopyBaseFragment {

    /* renamed from: j  reason: collision with root package name */
    public static final a f43627j = new a((r) null);

    /* renamed from: f  reason: collision with root package name */
    public final i f43628f = FragmentViewModelLazyKt.c(this, Reflection.b(CopyTradingViewModel.class), new CopyTradingMeFragment$special$$inlined$activityViewModels$default$1(this), new CopyTradingMeFragment$special$$inlined$activityViewModels$default$2((d10.a) null, this), new CopyTradingMeFragment$special$$inlined$activityViewModels$default$3(this));

    /* renamed from: g  reason: collision with root package name */
    public y f43629g;

    /* renamed from: h  reason: collision with root package name */
    public String f43630h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f43631i;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final CopyTradingMeFragment a() {
            return new CopyTradingMeFragment();
        }
    }

    public static final class b implements TabLayout.OnTabSelectedListener {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ TabInfoBean f43632b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ CopyTradingMeFragment f43633c;

        public b(TabInfoBean tabInfoBean, CopyTradingMeFragment copyTradingMeFragment) {
            this.f43632b = tabInfoBean;
            this.f43633c = copyTradingMeFragment;
        }

        public void onTabReselected(TabLayout.Tab tab) {
        }

        @SensorsDataInstrumented
        public void onTabSelected(TabLayout.Tab tab) {
            Tab tab2;
            String onAppear;
            String module;
            List<Tab> tabs = this.f43632b.getTabs();
            y yVar = null;
            if (tabs != null) {
                tab2 = tabs.get(tab != null ? tab.getPosition() : 0);
            } else {
                tab2 = null;
            }
            boolean z11 = true;
            if (tab2 == null || (module = tab2.getModule()) == null || !module.equals("historyFollowOrders")) {
                z11 = false;
            }
            if (z11) {
                y xh2 = this.f43633c.f43629g;
                if (xh2 != null) {
                    yVar = xh2;
                }
                yVar.F.setVisibility(0);
            } else {
                y xh3 = this.f43633c.f43629g;
                if (xh3 != null) {
                    yVar = xh3;
                }
                yVar.F.setVisibility(8);
            }
            if (!(tab2 == null || (onAppear = tab2.getOnAppear()) == null)) {
                this.f43633c.zh().h0().I(onAppear + "()");
            }
            SensorsDataAutoTrackHelper.trackTabLayoutSelected(this, tab);
        }

        public void onTabUnselected(TabLayout.Tab tab) {
        }
    }

    public static final class c implements a.C0566a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CopyTradingMeFragment f43634a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CopyTradingMoreDialog f43635b;

        public c(CopyTradingMeFragment copyTradingMeFragment, CopyTradingMoreDialog copyTradingMoreDialog) {
            this.f43634a = copyTradingMeFragment;
            this.f43635b = copyTradingMoreDialog;
        }

        public void a(com.huobi.copytrading.widget.a aVar) {
            Integer valueOf = aVar != null ? Integer.valueOf(aVar.d()) : null;
            if (valueOf != null && valueOf.intValue() == 0) {
                this.f43634a.zh().h0().I("meTopPage.toSetting()");
            } else if (valueOf != null && valueOf.intValue() == 1) {
                this.f43634a.zh().h0().I("meTopPage.toTransferHistory()");
            } else if (valueOf != null && valueOf.intValue() == 2) {
                this.f43634a.zh().h0().I("meTopPage.toCapitalFlow()");
            } else {
                this.f43634a.zh().h0().I("meTopPage.shareAction()");
            }
            this.f43635b.dismiss();
        }
    }

    public static final void Bh(CopyTradingMeFragment copyTradingMeFragment, Object obj) {
        FragmentActivity activity = copyTradingMeFragment.getActivity();
        boolean z11 = true;
        if (!(activity != null && activity.isFinishing()) && (obj instanceof String) && !TextUtils.isEmpty((CharSequence) obj)) {
            String str = (String) obj;
            y yVar = null;
            if (!StringsKt__StringsJVMKt.x(copyTradingMeFragment.f43630h, str, false, 2, (Object) null)) {
                copyTradingMeFragment.f43630h = str;
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                TabInfoBean tabInfoBean = (TabInfoBean) m.c(str, TabInfoBean.class);
                ActionBar actionBar = tabInfoBean.getActionBar();
                if (actionBar != null) {
                    y yVar2 = copyTradingMeFragment.f43629g;
                    if (yVar2 == null) {
                        yVar2 = null;
                    }
                    yVar2.G.setText(actionBar.getTitle());
                    y yVar3 = copyTradingMeFragment.f43629g;
                    if (yVar3 == null) {
                        yVar3 = null;
                    }
                    com.hbg.module.libkt.base.ext.b.J(yVar3.B, actionBar.getIcon());
                }
                List<Tab> tabs = tabInfoBean.getTabs();
                if (tabs != null) {
                    int i11 = 0;
                    for (T next : tabs) {
                        int i12 = i11 + 1;
                        if (i11 < 0) {
                            CollectionsKt__CollectionsKt.t();
                        }
                        Tab tab = (Tab) next;
                        CopyTradingViewModel zh2 = copyTradingMeFragment.zh();
                        StringBuilder sb2 = new StringBuilder();
                        String template = tab.getTemplate();
                        String str2 = "";
                        if (template == null) {
                            template = str2;
                        }
                        sb2.append(template);
                        sb2.append(".xml");
                        String sb3 = sb2.toString();
                        String module = tab.getModule();
                        if (module == null) {
                            module = str2;
                        }
                        View k02 = zh2.k0(sb3, module);
                        if (k02 != null) {
                            arrayList.add(k02);
                        }
                        String title = tab.getTitle();
                        if (title == null) {
                            title = str2;
                        }
                        arrayList2.add(title);
                        CopyTradingViewModel zh3 = copyTradingMeFragment.zh();
                        String onTitleChange = tab.getOnTitleChange();
                        if (onTitleChange != null) {
                            str2 = onTitleChange;
                        }
                        zh3.p0(str2, new p(copyTradingMeFragment, i11));
                        i11 = i12;
                    }
                }
                Integer hasTraderRight = tabInfoBean.getHasTraderRight();
                if (hasTraderRight != null) {
                    if (hasTraderRight.intValue() != 1) {
                        z11 = false;
                    }
                    copyTradingMeFragment.f43631i = z11;
                }
                y yVar4 = copyTradingMeFragment.f43629g;
                if (yVar4 == null) {
                    yVar4 = null;
                }
                yVar4.H.setUserInputEnabled(false);
                y yVar5 = copyTradingMeFragment.f43629g;
                if (yVar5 == null) {
                    yVar5 = null;
                }
                yVar5.H.setOffscreenPageLimit(arrayList.size());
                y yVar6 = copyTradingMeFragment.f43629g;
                if (yVar6 == null) {
                    yVar6 = null;
                }
                yVar6.H.setAdapter(new CopyTradingTradeFragment.b(arrayList));
                y yVar7 = copyTradingMeFragment.f43629g;
                if (yVar7 == null) {
                    yVar7 = null;
                }
                TabLayout tabLayout = yVar7.E;
                y yVar8 = copyTradingMeFragment.f43629g;
                if (yVar8 == null) {
                    yVar8 = null;
                }
                new TabLayoutMediator(tabLayout, yVar8.H, new m(arrayList2)).attach();
                y yVar9 = copyTradingMeFragment.f43629g;
                if (yVar9 != null) {
                    yVar = yVar9;
                }
                yVar.E.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new b(tabInfoBean, copyTradingMeFragment));
            }
        }
    }

    public static final void Ch(CopyTradingMeFragment copyTradingMeFragment, int i11, Object obj) {
        if ((obj instanceof String) && !TextUtils.isEmpty((CharSequence) obj)) {
            y yVar = copyTradingMeFragment.f43629g;
            y yVar2 = null;
            if (yVar == null) {
                yVar = null;
            }
            if (yVar.E.getTabCount() > i11) {
                y yVar3 = copyTradingMeFragment.f43629g;
                if (yVar3 != null) {
                    yVar2 = yVar3;
                }
                TabLayout.Tab tabAt = yVar2.E.getTabAt(i11);
                if (tabAt != null) {
                    tabAt.setText((CharSequence) obj.toString());
                }
            }
        }
    }

    public static final void Dh(ArrayList arrayList, TabLayout.Tab tab, int i11) {
        tab.setText((CharSequence) arrayList.get(i11));
    }

    public static final void Eh(CopyTradingMeFragment copyTradingMeFragment, Object obj) {
        FragmentActivity activity = copyTradingMeFragment.getActivity();
        boolean z11 = true;
        if (activity == null || !activity.isFinishing()) {
            z11 = false;
        }
        if (!z11 && (obj instanceof String) && !TextUtils.isEmpty((CharSequence) obj)) {
            try {
                Log.d("ActionBar", "NickData:" + obj);
                ActionBar actionBar = ((TabInfoBean) m.c((String) obj, TabInfoBean.class)).getActionBar();
                if (actionBar != null) {
                    y yVar = copyTradingMeFragment.f43629g;
                    y yVar2 = null;
                    if (yVar == null) {
                        yVar = null;
                    }
                    yVar.G.setText(actionBar.getTitle());
                    y yVar3 = copyTradingMeFragment.f43629g;
                    if (yVar3 != null) {
                        yVar2 = yVar3;
                    }
                    com.hbg.module.libkt.base.ext.b.J(yVar2.B, actionBar.getIcon());
                }
            } catch (Exception e11) {
                Log.d("ActionBar", "E:" + e11.getMessage());
            }
        }
    }

    public final void Ah() {
        CopyTradingViewModel zh2 = zh();
        Module module = Module.ME_TOP;
        y yVar = this.f43629g;
        if (yVar == null) {
            yVar = null;
        }
        zh2.m0(module, yVar.C);
        zh().p0("meTopPage.tabInfo", new o(this));
        zh().p0("meTopPage.nickData", new n(this));
    }

    public final void Fh() {
        CopyTradingMoreDialog copyTradingMoreDialog = new CopyTradingMoreDialog(zh().y0(), 1, this.f43631i);
        copyTradingMoreDialog.sh(new c(this, copyTradingMoreDialog));
        copyTradingMoreDialog.show(getChildFragmentManager(), "");
    }

    public final void Gh() {
        FragmentActivity activity = getActivity();
        if (activity != null) {
            activity.finish();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        y yVar = (y) androidx.databinding.c.e(layoutInflater, R.layout.fragment_copy_trading_me, viewGroup, false);
        this.f43629g = yVar;
        y yVar2 = null;
        if (yVar == null) {
            yVar = null;
        }
        yVar.K(this);
        Ah();
        y yVar3 = this.f43629g;
        if (yVar3 != null) {
            yVar2 = yVar3;
        }
        return yVar2.getRoot();
    }

    public void ph() {
    }

    public void qh() {
    }

    public void sh() {
        super.sh();
        zh().h0().I("meTopPage.onAppear()");
    }

    public final CopyTradingViewModel zh() {
        return (CopyTradingViewModel) this.f43628f.getValue();
    }
}
