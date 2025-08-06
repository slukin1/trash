package com.hbg.module.community.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.VmState;
import v7.b;

public final class DynamicDetailViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final MutableLiveData<VmState<DynamicDetailInfo>> f17625a = new MutableLiveData<>();

    public final MutableLiveData<VmState<DynamicDetailInfo>> h0() {
        return this.f17625a;
    }

    public final void i0(String str) {
        RequestExtKt.b(b.a().getDynamicDetail(str), this.f17625a);
    }
}
