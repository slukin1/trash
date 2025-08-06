package com.huobi.architecture.mvvm.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import kotlin.Metadata;
import x1.a;

@Metadata(bv = {}, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\r\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0018\u0010\u0019J&\u0010\u000b\u001a\u0004\u0018\u00010\n2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\u000e\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\nH&J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\u0011\u001a\u00020\rH\u0016J\u0019\u0010\u0013\u001a\u00028\u00002\b\u0010\u0012\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0017\u001a\u00028\u00008DX\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u001a"}, d2 = {"Lcom/huobi/architecture/mvvm/fragment/BaseViewBingFragment;", "Lx1/a;", "Binding", "Landroidx/fragment/app/Fragment;", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/os/Bundle;", "savedInstanceState", "Landroid/view/View;", "onCreateView", "rootView", "", "initView", "arguments", "initData", "onDestroy", "v", "qh", "(Landroid/view/View;)Lx1/a;", "ph", "()Lx1/a;", "mBinding", "<init>", "()V", "hb_framework_client_release"}, k = 1, mv = {1, 6, 0})
public abstract class BaseViewBingFragment<Binding extends a> extends Fragment {

    /* renamed from: b  reason: collision with root package name */
    public Binding f42233b;

    public void initData(Bundle bundle) {
    }

    public abstract void initView(View view);

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f42233b = qh(getView());
        initView(ph().getRoot());
        initData(getArguments());
        return ph().getRoot();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f42233b = null;
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public final Binding ph() {
        return this.f42233b;
    }

    public final Binding qh(View view) {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Objects.requireNonNull(type, "null cannot be cast to non-null type java.lang.Class<Binding of com.huobi.architecture.mvvm.fragment.BaseViewBingFragment>");
        Class cls = (Class) type;
        Binding invoke = cls.getMethod("inflate", new Class[]{LayoutInflater.class, ViewGroup.class, Boolean.TYPE}).invoke(cls, new Object[]{getLayoutInflater(), view, Boolean.FALSE});
        Objects.requireNonNull(invoke, "null cannot be cast to non-null type Binding of com.huobi.architecture.mvvm.fragment.BaseViewBingFragment");
        return (a) invoke;
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }
}
