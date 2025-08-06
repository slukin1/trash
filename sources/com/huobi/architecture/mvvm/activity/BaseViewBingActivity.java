package com.huobi.architecture.mvvm.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.activity.ComponentActivity;
import com.blankj.utilcode.util.KeyboardUtils;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Objects;
import kotlin.Metadata;
import kotlin.i;
import x1.a;

@Metadata(bv = {}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\b&\u0018\u0000*\b\b\u0000\u0010\u0002*\u00020\u00012\u00020\u0003B\u0007¢\u0006\u0004\b\u0013\u0010\u0014J\u0012\u0010\u0007\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0014J\u0010\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\b\u0010\f\u001a\u00020\u0006H\u0016J\u000f\u0010\r\u001a\u00028\u0000H\u0002¢\u0006\u0004\b\r\u0010\u000eR\u001b\u0010\u0012\u001a\u00028\u00008DX\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\u0011\u0010\u000e¨\u0006\u0015"}, d2 = {"Lcom/huobi/architecture/mvvm/activity/BaseViewBingActivity;", "Lx1/a;", "Binding", "Landroidx/activity/ComponentActivity;", "Landroid/os/Bundle;", "savedInstanceState", "", "onCreate", "Landroid/content/Intent;", "intent", "nf", "if", "initData", "ff", "()Lx1/a;", "b", "Lkotlin/i;", "Ze", "mBinding", "<init>", "()V", "hb_framework_client_release"}, k = 1, mv = {1, 6, 0})
public abstract class BaseViewBingActivity<Binding extends a> extends ComponentActivity {

    /* renamed from: b  reason: collision with root package name */
    public final i f42224b = LazyKt__LazyJVMKt.a(new BaseViewBingActivity$mBinding$2(this));

    public final Binding Ze() {
        return (a) this.f42224b.getValue();
    }

    public final Binding ff() {
        Type type = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        Objects.requireNonNull(type, "null cannot be cast to non-null type java.lang.Class<Binding of com.huobi.architecture.mvvm.activity.BaseViewBingActivity>");
        Class cls = (Class) type;
        Binding invoke = cls.getMethod("inflate", new Class[]{LayoutInflater.class, ViewGroup.class, Boolean.TYPE}).invoke(cls, new Object[]{getLayoutInflater(), null, Boolean.FALSE});
        Objects.requireNonNull(invoke, "null cannot be cast to non-null type Binding of com.huobi.architecture.mvvm.activity.BaseViewBingActivity");
        return (a) invoke;
    }

    /* renamed from: if  reason: not valid java name */
    public abstract void m2305if(Bundle bundle);

    public void initData() {
    }

    public void nf(Intent intent) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(Ze().getRoot());
        KeyboardUtils.e(this);
        KeyboardUtils.c(this);
        nf(getIntent());
        m2305if(bundle);
        initData();
    }
}
