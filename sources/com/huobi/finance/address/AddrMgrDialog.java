package com.huobi.finance.address;

import android.animation.ValueAnimator;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.annotation.Keep;
import com.hbg.lib.common.utils.SoftInputUtils;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.network.pro.core.bean.ProTokenUpdate;
import com.hbg.lib.network.pro.core.bean.UserAddrInfo;
import com.hbg.lib.network.retrofit.request.callback.RequestCallback1;
import com.hbg.lib.network.retrofit.rxjava.RxJavaHelper;
import com.hbg.lib.widgets.LoadingView;
import com.hbg.lib.widgets.dialog.BaseDialogFragment;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.hbg.module.asset.AssetModuleConfig;
import com.hbg.module.asset.R$dimen;
import com.hbg.module.asset.R$id;
import com.hbg.module.asset.R$layout;
import com.hbg.module.asset.R$raw;
import com.hbg.module.asset.R$string;
import com.hbg.module.asset.R$style;
import com.huobi.finance.address.BindAddressView;
import com.huobi.finance.address.ManageAddressView;
import com.huobi.finance.bean.ManageAddressListItem;
import com.huobi.finance.bean.ManageTabListItem;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.r;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import uk.f;

public class AddrMgrDialog extends BaseDialogFragment {

    /* renamed from: b  reason: collision with root package name */
    public BindAddressView f45202b;

    /* renamed from: c  reason: collision with root package name */
    public ManageAddressView f45203c;

    /* renamed from: d  reason: collision with root package name */
    public FrameLayout f45204d;

    /* renamed from: e  reason: collision with root package name */
    public View f45205e;

    /* renamed from: f  reason: collision with root package name */
    public View f45206f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f45207g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f45208h;

    /* renamed from: i  reason: collision with root package name */
    public View f45209i;

    /* renamed from: j  reason: collision with root package name */
    public LoadingView f45210j;

    /* renamed from: k  reason: collision with root package name */
    public boolean f45211k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f45212l = true;

    /* renamed from: m  reason: collision with root package name */
    public int f45213m;

    /* renamed from: n  reason: collision with root package name */
    public UserAddrInfo f45214n;

    /* renamed from: o  reason: collision with root package name */
    public List<UserAddrInfo> f45215o;

    /* renamed from: p  reason: collision with root package name */
    public e f45216p;

    public class a implements BindAddressView.d {
        public a() {
        }

        public void a(List<String> list, String str) {
            AddrMgrDialog.this.Jh(list, str);
        }
    }

    public class b implements ManageAddressView.c {
        public b() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void d(String str, String str2, HBDialogFragment hBDialogFragment) {
            hBDialogFragment.dismiss();
            AddrMgrDialog.this.Kh(str, str2);
        }

        public void a() {
            AddrMgrDialog.this.Eh(true, true);
        }

        public void b(ManageTabListItem manageTabListItem, ManageAddressListItem manageAddressListItem) {
            String str;
            if (manageTabListItem != null) {
                String chain = manageTabListItem.d().getChain();
                String address = manageAddressListItem.c().getAddress();
                if (AddrMgrDialog.this.f45203c.getAllAddressItemSize() > 1) {
                    str = AddrMgrDialog.this.getResources().getString(R$string.n_on_chain_asset_rm_addr_confirm);
                } else {
                    str = AddrMgrDialog.this.getResources().getString(R$string.n_on_chain_asset_rm_addr_all_confirm);
                }
                DialogUtils.b0(AddrMgrDialog.this.getActivity(), AddrMgrDialog.this.getResources().getString(R$string.lite_market_info_price_notice_title), str, "", AddrMgrDialog.this.getResources().getString(R$string.n_cancel), AddrMgrDialog.this.getResources().getString(R$string.n_sure), ad.b.f3517a, new f(this, chain, address));
            }
        }
    }

    public class c extends EasySubscriber<String> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f45219b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f45220c;

        public c(String str, String str2) {
            this.f45219b = str;
            this.f45220c = str2;
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
            UserAddrInfo p11 = AddrMgrDialog.this.f45203c.p(this.f45219b, this.f45220c);
            if (AddrMgrDialog.this.f45216p != null) {
                AddrMgrDialog.this.f45216p.a(p11);
            }
            HuobiToastUtil.s(R$string.n_on_chain_asset_rm_addr_success);
        }

        public void onError2(Throwable th2) {
            super.onError2(th2);
            HuobiToastUtil.j(R$string.n_on_chain_asset_rm_addr_fail);
        }
    }

    public class d extends EasySubscriber<String> {
        public d() {
        }

        /* renamed from: a */
        public void onNext(String str) {
            super.onNext(str);
            SoftInputUtils.f(AddrMgrDialog.this.getActivity());
            if (AddrMgrDialog.this.f45216p != null) {
                AddrMgrDialog.this.f45216p.onBindSuccess();
            }
            AddrMgrDialog.this.f45202b.m();
            if (!AddrMgrDialog.this.f45205e.isShown() || AddrMgrDialog.this.f45205e.getAlpha() != 1.0f) {
                AddrMgrDialog.this.dismiss();
            } else {
                AddrMgrDialog.this.Eh(false, true);
            }
            HuobiToastUtil.s(R$string.n_on_chain_asset_add_addr_success);
        }

        public void onAfter() {
            super.onAfter();
            AddrMgrDialog.this.f45202b.n();
        }

        public void onStart() {
            super.onStart();
            AddrMgrDialog.this.f45202b.v();
        }
    }

    public interface e {
        void a(UserAddrInfo userAddrInfo);

        void onBindSuccess();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Hh(ValueAnimator valueAnimator) {
        Ph(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Ih(boolean z11, boolean z12) {
        int i11;
        if (z11) {
            this.f45202b.u();
        }
        if (!z11 || this.f45212l) {
            this.f45208h.setText(getResources().getString(R$string.n_on_chain_asset_address_management));
        } else {
            this.f45208h.setText(getResources().getString(R$string.n_on_chain_asset_bind_address));
        }
        int i12 = getResources().getDisplayMetrics().widthPixels;
        int i13 = getResources().getDisplayMetrics().heightPixels;
        if (z11) {
            i11 = this.f45202b.getRealHeight();
        } else {
            i11 = this.f45203c.getRealHeight();
        }
        int min = Math.min(i11, (i13 - ViewUtil.g()) - getResources().getDimensionPixelOffset(R$dimen.dimen_100));
        if (this.f45213m == 0) {
            this.f45213m = this.f45204d.getHeight();
        }
        if (z12) {
            if (!z11) {
                this.f45207g.animate().alpha(0.0f);
                this.f45208h.animate().alpha(1.0f);
            } else if (this.f45212l) {
                this.f45207g.animate().alpha(1.0f);
                this.f45208h.animate().alpha(0.0f);
            } else {
                this.f45207g.animate().alpha(0.0f);
                this.f45208h.animate().alpha(1.0f);
            }
            if (!this.f45212l || !z11) {
                this.f45205e.animate().alpha(0.0f);
            } else {
                this.f45205e.animate().alpha(1.0f);
            }
            ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{this.f45213m, min});
            ofInt.addUpdateListener(new uk.a(this));
            ofInt.setDuration(300);
            ofInt.setInterpolator(new DecelerateInterpolator());
            ofInt.start();
            if (z11) {
                this.f45202b.animate().setDuration(300).translationX(0.0f);
                this.f45203c.animate().setDuration(300).translationX((float) (-i12));
            } else {
                this.f45202b.animate().setDuration(300).translationX((float) i12);
                this.f45203c.animate().setDuration(300).translationX(0.0f);
            }
        } else {
            if (!z11) {
                this.f45207g.setAlpha(0.0f);
                this.f45208h.setAlpha(1.0f);
            } else if (this.f45212l) {
                this.f45207g.setAlpha(1.0f);
                this.f45208h.setAlpha(0.0f);
            } else {
                this.f45207g.setAlpha(0.0f);
                this.f45208h.setAlpha(1.0f);
            }
            if (!this.f45212l || !z11) {
                this.f45205e.setAlpha(0.0f);
            } else {
                this.f45205e.setAlpha(1.0f);
            }
            Ph(min);
            if (z11) {
                this.f45202b.setTranslationX(0.0f);
                this.f45203c.setTranslationX((float) (-i12));
            } else {
                this.f45202b.setTranslationX((float) i12);
                this.f45203c.setTranslationX(0.0f);
            }
        }
        SoftInputUtils.g(getActivity(), this.f45202b.getEditText());
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$1(View view) {
        if (this.f45212l && this.f45211k) {
            Eh(false, true);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$2(View view) {
        dismiss();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void Eh(boolean z11, boolean z12) {
        this.f45211k = z11;
        this.f45204d.post(new uk.e(this, z11, z12));
    }

    public UserAddrInfo Fh() {
        ManageAddressView manageAddressView = this.f45203c;
        if (manageAddressView != null) {
            return manageAddressView.getCurrentAddressInfo();
        }
        return null;
    }

    public void Gh() {
        ViewUtil.m(this.f45209i, false);
        LoadingView loadingView = this.f45210j;
        if (loadingView != null) {
            loadingView.d();
        }
    }

    public final void Jh(List<String> list, String str) {
        if (TextUtils.isEmpty(str)) {
            HuobiToastUtil.j(R$string.n_on_chain_asset_addr_input_hint);
        } else {
            x8.a.a().u(BaseModuleConfig.a().f(), AssetModuleConfig.a().getUid(), list, str).b().compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new d());
        }
    }

    public final void Kh(String str, String str2) {
        x8.a.a().A(BaseModuleConfig.a().f(), AssetModuleConfig.a().getUid(), str, str2).b().compose(RxJavaHelper.g((RequestCallback1) null)).subscribe(new c(str, str2));
    }

    public void Lh(e eVar) {
        this.f45216p = eVar;
    }

    public void Mh(UserAddrInfo userAddrInfo) {
        this.f45214n = userAddrInfo;
        ManageAddressView manageAddressView = this.f45203c;
        if (manageAddressView != null) {
            manageAddressView.setCurrentUserAddressInfo(userAddrInfo);
        }
    }

    public void Nh(boolean z11) {
        this.f45211k = z11;
    }

    public void Oh(boolean z11) {
        this.f45212l = z11;
    }

    public final void Ph(int i11) {
        this.f45213m = i11;
        ViewGroup.LayoutParams layoutParams = this.f45204d.getLayoutParams();
        layoutParams.height = i11;
        this.f45204d.setLayoutParams(layoutParams);
    }

    public void addEvent(r rVar) {
        rVar.b(R$id.id_on_chain_root_layout).setOnClickListener(new uk.d(this));
        this.f45205e.setOnClickListener(new uk.c(this));
        this.f45202b.setCallback(new a());
        this.f45203c.setCallback(new b());
        this.f45206f.setOnClickListener(new uk.b(this));
    }

    public void afterInit() {
        Eh(this.f45211k, false);
        this.f45203c.setCurrentUserAddressInfo(this.f45214n);
        this.f45203c.setDataList(this.f45215o);
        this.f45202b.m();
        this.f45210j.setLottieAnimationRes(R$raw.nd_middle_bg);
    }

    public int getAnimationStyle() {
        return R$style.bottom_dialog_animation;
    }

    public int getContentViewResId() {
        return R$layout.dialog_on_chain_addr_mgr;
    }

    public int getGravity() {
        return 80;
    }

    public void initView(r rVar) {
        this.f45202b = (BindAddressView) rVar.b(R$id.id_on_chain_bind_layout);
        this.f45203c = (ManageAddressView) rVar.b(R$id.id_on_chain_manage_layout);
        this.f45204d = (FrameLayout) rVar.b(R$id.id_on_chain_content_layout);
        this.f45207g = (TextView) rVar.b(R$id.id_on_chain_addr_mgr_head_title_bind_tv);
        this.f45208h = (TextView) rVar.b(R$id.id_on_chain_addr_mgr_head_title_manage_tv);
        this.f45205e = rVar.b(R$id.id_on_chain_addr_mgr_head_back_btn);
        this.f45206f = rVar.b(R$id.id_on_chain_addr_mgr_head_close_btn);
        this.f45209i = rVar.b(R$id.id_on_chain_loadingView);
        this.f45210j = (LoadingView) rVar.b(R$id.loading_dialog_loading_view);
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public boolean isTransparent() {
        return false;
    }

    public void onBackPressed() {
        if (!this.f45211k || !this.f45212l) {
            super.onBackPressed();
        } else {
            Eh(false, true);
        }
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onTokenUpdate(ProTokenUpdate proTokenUpdate) {
        if (TextUtils.isEmpty(proTokenUpdate.getProToken()) && isVisible()) {
            dismiss();
        }
    }

    public void showLoading() {
        ViewUtil.m(this.f45209i, true);
        LoadingView loadingView = this.f45210j;
        if (loadingView != null) {
            loadingView.c();
        }
    }

    public void tc(List<UserAddrInfo> list) {
        this.f45215o = list;
        ManageAddressView manageAddressView = this.f45203c;
        if (manageAddressView != null) {
            manageAddressView.setDataList(list);
        }
    }
}
