package com.hbg.lib.core.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.hbg.lib.common.mvp.BaseFragmentPresenter;
import com.hbg.lib.common.mvp.BaseMVPFragment;
import i6.k;
import rx.subjects.BehaviorSubject;
import u6.g;

public abstract class BaseFragment<P extends BaseFragmentPresenter<V>, V extends g> extends BaseMVPFragment<P, V> implements g {

    /* renamed from: j  reason: collision with root package name */
    public BehaviorSubject<Integer> f68531j = BehaviorSubject.create();

    /* renamed from: k  reason: collision with root package name */
    public boolean f68532k;

    public void Ah() {
    }

    public boolean Bh() {
        return false;
    }

    public void afterInit() {
    }

    public void dismissProgressDialog() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).dismissProgressDialog();
        }
    }

    public BehaviorSubject<Integer> getUIChangeSubject() {
        return this.f68531j;
    }

    public void initViews() {
    }

    public boolean isCanBeSeen() {
        return this.f68532k;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (Bh() && onCreateView != null) {
            onCreateView.setPadding(0, BaseActivity.getStatusBarHeight(onCreateView.getContext()), 0, 0);
        }
        return onCreateView;
    }

    public void onDestroy() {
        this.f68531j.onNext(5);
        super.onDestroy();
    }

    public void onDestroyView() {
        this.f68531j.onNext(9);
        super.onDestroyView();
    }

    public void onPause() {
        this.f68531j.onNext(3);
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f68531j.onNext(2);
    }

    public void rh(View view) {
        super.rh(view);
        setHasOptionsMenu(true);
        initViews();
        Ah();
        afterInit();
    }

    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
    }

    public void showProgressDialog() {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).showProgressDialog();
        }
    }

    public void uh(boolean z11) {
        super.uh(z11);
        k.o("ACTION-PAGE", "[onVisibleChangedFinal]" + getClass().getName() + " visible状态：" + z11);
        this.f68532k = z11;
        if (z11) {
            setUserVisibleHint(true);
        }
    }

    public void showProgressDialog(boolean z11) {
        if (getActivity() instanceof BaseActivity) {
            ((BaseActivity) getActivity()).showProgressDialog(z11);
        }
    }
}
