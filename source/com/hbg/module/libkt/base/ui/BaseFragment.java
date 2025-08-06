package com.hbg.module.libkt.base.ui;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.base.state.EBaseViewStatus;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import com.hbg.module.libkt.provider.HbgBaseShareProvider;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import ie.e;
import ie.f;
import ky.j;
import ny.d;
import x1.a;
import z9.g1;

public abstract class BaseFragment<VB extends a> extends Fragment implements d {

    /* renamed from: b  reason: collision with root package name */
    public VB f24531b;

    /* renamed from: c  reason: collision with root package name */
    public Handler f24532c;

    /* renamed from: d  reason: collision with root package name */
    public EBaseViewStatus f24533d = EBaseViewStatus.SUCCESS;

    /* renamed from: e  reason: collision with root package name */
    public LayoutInflater f24534e;

    /* renamed from: f  reason: collision with root package name */
    public ViewGroup f24535f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f24536g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f24537h = true;

    /* renamed from: i  reason: collision with root package name */
    public boolean f24538i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f24539j = true;

    /* renamed from: k  reason: collision with root package name */
    public View f24540k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f24541l;

    /* renamed from: m  reason: collision with root package name */
    public g1 f24542m;

    /* renamed from: n  reason: collision with root package name */
    public HbgBaseProvider f24543n;

    /* renamed from: o  reason: collision with root package name */
    public HbgBaseShareProvider f24544o;

    public static /* synthetic */ void Oh(BaseFragment baseFragment, boolean z11, boolean z12, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                z11 = true;
            }
            if ((i11 & 2) != 0) {
                z12 = true;
            }
            baseFragment.Nh(z11, z12);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showLoadingDialog");
    }

    public static final void Ph(BaseFragment baseFragment, boolean z11) {
        if (b.e(baseFragment.getActivity())) {
            if (baseFragment.f24542m == null) {
                baseFragment.f24542m = new g1(baseFragment.getActivity());
            }
            g1 g1Var = baseFragment.f24542m;
            if (g1Var != null) {
                g1Var.show();
            }
            g1 g1Var2 = baseFragment.f24542m;
            if (g1Var2 != null) {
                g1Var2.setCanceledOnTouchOutside(z11);
            }
            g1 g1Var3 = baseFragment.f24542m;
            if (g1Var3 != null) {
                g1Var3.setCancelable(z11);
            }
        }
    }

    public static final void Qh(BaseFragment baseFragment, boolean z11, boolean z12) {
        if (b.e(baseFragment.getActivity())) {
            if (baseFragment.f24542m == null) {
                baseFragment.f24542m = new g1(baseFragment.getActivity());
            }
            g1 g1Var = baseFragment.f24542m;
            if (g1Var != null) {
                g1Var.show();
            }
            g1 g1Var2 = baseFragment.f24542m;
            if (g1Var2 != null) {
                g1Var2.setCanceledOnTouchOutside(z11);
            }
            g1 g1Var3 = baseFragment.f24542m;
            if (g1Var3 != null) {
                g1Var3.setCancelable(z12);
            }
        }
    }

    public static final void th(BaseFragment baseFragment) {
        g1 g1Var;
        if (b.e(baseFragment.getActivity())) {
            g1 g1Var2 = baseFragment.f24542m;
            boolean z11 = true;
            if (g1Var2 == null || !g1Var2.isShowing()) {
                z11 = false;
            }
            if (z11 && (g1Var = baseFragment.f24542m) != null) {
                g1Var.dismiss();
            }
        }
    }

    public void Ah() {
    }

    public final void Bh() {
        this.f24543n = (HbgBaseProvider) b2.a.d().a("/provider/content").navigation();
        this.f24544o = (HbgBaseShareProvider) b2.a.d().a("/provider/share/h5").navigation();
    }

    public int Ch() {
        return 0;
    }

    public final boolean Dh() {
        return this.f24531b != null;
    }

    public void Eh() {
        System.out.println("On Hidden Fragment ---->>> " + getClass().getName() + ", " + this);
    }

    public void Fh() {
        if (!this.f24541l) {
            this.f24541l = true;
            Ah();
            if (b.e(getActivity())) {
                Ih(new Handler(getActivity().getMainLooper()));
            }
            initView();
        }
        System.out.println("On Visible Fragment ---->>> " + getClass().getName() + ", " + this);
    }

    public final void Gh(LayoutInflater layoutInflater) {
        this.f24534e = layoutInflater;
    }

    public void Hh(VB vb2) {
        this.f24531b = vb2;
    }

    public void Ih(Handler handler) {
        this.f24532c = handler;
    }

    public final void Jh(HbgBaseProvider hbgBaseProvider) {
        this.f24543n = hbgBaseProvider;
    }

    public final void Kh(HbgBaseShareProvider hbgBaseShareProvider) {
        this.f24544o = hbgBaseShareProvider;
    }

    public final void Lh() {
        Mh(true);
    }

    public final void Mh(boolean z11) {
        Handler vh2 = vh();
        if (vh2 != null) {
            vh2.post(new e(this, z11));
        }
    }

    public final void Nh(boolean z11, boolean z12) {
        Handler vh2 = vh();
        if (vh2 != null) {
            vh2.post(new f(this, z12, z11));
        }
    }

    public void P8(j jVar) {
    }

    public void bf(j jVar) {
    }

    public abstract void initView();

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Bh();
        if (this.f24540k == null) {
            Gh(layoutInflater);
            this.f24535f = viewGroup;
            Hh(yh(layoutInflater, viewGroup));
            this.f24540k = uh().getRoot();
            if (Ch() == 1) {
                this.f24541l = true;
                initView();
            }
            zh();
        }
        View view = this.f24540k;
        if (view == null) {
            return null;
        }
        return view;
    }

    public void onDestroy() {
        Handler vh2 = vh();
        if (vh2 != null) {
            vh2.removeCallbacksAndMessages((Object) null);
        }
        super.onDestroy();
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (z11) {
            Eh();
        } else {
            Fh();
        }
        this.f24536g = z11;
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        if (!this.f24536g && this.f24537h) {
            Eh();
        }
        this.f24538i = false;
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        if (getUserVisibleHint() && !this.f24536g && !this.f24538i) {
            Fh();
        }
        if (this.f24538i) {
            this.f24538i = false;
        }
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        this.f24537h = z11;
        if (z11) {
            if (!this.f24538i) {
                this.f24538i = true;
            }
            Fh();
        } else {
            if (!this.f24539j) {
                Eh();
            }
            this.f24539j = false;
        }
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public final void sh() {
        Handler vh2 = vh();
        if (vh2 != null) {
            vh2.post(new ie.d(this));
        }
    }

    public VB uh() {
        VB vb2 = this.f24531b;
        if (vb2 != null) {
            return vb2;
        }
        return null;
    }

    public Handler vh() {
        return this.f24532c;
    }

    public final HbgBaseProvider wh() {
        return this.f24543n;
    }

    public final HbgBaseShareProvider xh() {
        return this.f24544o;
    }

    public abstract VB yh(LayoutInflater layoutInflater, ViewGroup viewGroup);

    public void zh() {
    }
}
