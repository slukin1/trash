package com.hbg.lib.common.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.google.firebase.crashlytics.FirebaseCrashlytics;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.ui.BaseCoreActivity;
import com.hbg.lib.common.utils.Assert;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.woodpecker.monitor.OpPathMonitor;
import h6.a;
import i6.r;

public abstract class BaseMVPFragment<P extends BaseFragmentPresenter<V>, V extends a> extends LazyLoadFragment {

    /* renamed from: h  reason: collision with root package name */
    public P f67459h;

    /* renamed from: i  reason: collision with root package name */
    public r f67460i;

    public boolean isAlive() {
        return isAdded() && ((BaseCoreActivity) getActivity()).isAlive();
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        this.f67459h.S(bundle);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        super.onActivityResult(i11, i12, intent);
        P p11 = this.f67459h;
        if (p11 != null) {
            p11.onActivityResult(i11, i12, intent);
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        if (this.f67459h == null) {
            this.f67459h = xh();
        }
        this.f67459h.T(context, this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f67459h.U(bundle);
    }

    public /* bridge */ /* synthetic */ View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onDestroy() {
        super.onDestroy();
        this.f67459h.onDestroy();
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f67459h.V();
    }

    public void onDetach() {
        super.onDetach();
        this.f67459h.W();
    }

    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        this.f67459h.X(z11);
    }

    public void onPause() {
        super.onPause();
        this.f67459h.onPause();
    }

    public void onRequestPermissionsResult(int i11, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i11, strArr, iArr);
        this.f67459h.onRequestPermissionsResult(i11, strArr, iArr);
    }

    public void onResume() {
        super.onResume();
        this.f67459h.onResume();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.f67459h.onSaveInstanceState(bundle);
    }

    public void onStart() {
        super.onStart();
        this.f67459h.onStart();
    }

    public void onStop() {
        super.onStop();
        this.f67459h.onStop();
    }

    public void qh() {
        Assert.b(getActivity() instanceof BaseCoreActivity, "请继承BaseCoreActivity");
        this.f67459h.onUIReady((BaseCoreActivity) getActivity(), zh());
    }

    public void rh(View view) {
        super.rh(view);
        this.f67460i = new r(getRootView());
    }

    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        P p11 = this.f67459h;
        if (p11 != null) {
            p11.a0(z11);
        }
    }

    public void sh() {
        super.sh();
        P p11 = this.f67459h;
        if (p11 != null) {
            p11.R();
        }
    }

    public void th(boolean z11) {
        super.th(z11);
        P p11 = this.f67459h;
        if (p11 != null) {
            p11.Y(z11);
        }
    }

    public void uh(boolean z11) {
        super.uh(z11);
        P p11 = this.f67459h;
        if (p11 != null) {
            p11.Z(z11);
        }
        if (z11) {
            try {
                String simpleName = getClass().getSimpleName();
                String simpleName2 = getActivity().getClass().getSimpleName();
                String bundle = getArguments() == null ? null : getArguments().toString();
                OpPathMonitor.c().b(simpleName, simpleName2, bundle);
                FirebaseCrashlytics instance = FirebaseCrashlytics.getInstance();
                instance.setCustomKey("lastPagePath", simpleName + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + simpleName2 + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + bundle);
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public /* bridge */ /* synthetic */ boolean vh() {
        return super.vh();
    }

    public abstract P xh();

    public P yh() {
        return this.f67459h;
    }

    public abstract V zh();
}
