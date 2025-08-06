package com.hbg.module.community.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.VmState;
import v7.b;

public final class DelDynamicViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final MutableLiveData<VmState<Object>> f17624a = new MutableLiveData<>();

    public final void h(String str) {
        RequestExtKt.b(b.a().y0(str), this.f17624a);
    }

    public final MutableLiveData<VmState<Object>> h0() {
        return this.f17624a;
    }
}
