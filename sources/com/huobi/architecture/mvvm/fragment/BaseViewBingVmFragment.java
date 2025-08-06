package com.huobi.architecture.mvvm.fragment;

import android.os.Bundle;
import android.view.View;
import androidx.lifecycle.ViewModelProvider;
import com.huobi.architecture.mvvm.lifecycle.BaseViewModel;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.i;
import x1.a;

@Metadata(bv = {}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u0001*\b\b\u0001\u0010\u0004*\u00020\u00032\b\u0012\u0004\u0012\u00028\u00000\u0005B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u001a\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\t\u001a\u0004\u0018\u00010\bH\u0016J\b\u0010\f\u001a\u00020\nH&J\u000f\u0010\r\u001a\u00028\u0001H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00028\u00018DX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/huobi/architecture/mvvm/fragment/BaseViewBingVmFragment;", "Lx1/a;", "V", "Lcom/huobi/architecture/mvvm/lifecycle/BaseViewModel;", "VM", "Lcom/huobi/architecture/mvvm/fragment/BaseViewBingFragment;", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "", "onViewCreated", "th", "sh", "()Lcom/huobi/architecture/mvvm/lifecycle/BaseViewModel;", "c", "Lkotlin/i;", "getMViewModel", "mViewModel", "<init>", "()V", "hb_framework_client_release"}, k = 1, mv = {1, 6, 0})
public abstract class BaseViewBingVmFragment<V extends a, VM extends BaseViewModel> extends BaseViewBingFragment<V> {

    /* renamed from: c  reason: collision with root package name */
    public final i f42234c = LazyKt__LazyJVMKt.a(new BaseViewBingVmFragment$mViewModel$2(this));

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        th();
    }

    public final VM sh() {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[1];
        Objects.requireNonNull(type, "null cannot be cast to non-null type java.lang.Class<VM of com.huobi.architecture.mvvm.fragment.BaseViewBingVmFragment>");
        return (BaseViewModel) new ViewModelProvider(this).a((Class) type);
    }

    public abstract void th();
}
