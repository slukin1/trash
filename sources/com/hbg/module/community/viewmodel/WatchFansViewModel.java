package com.hbg.module.community.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.WatchFansBean;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.VmState;
import java.util.List;
import v7.b;

public final class WatchFansViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final MutableLiveData<VmState<List<WatchFansBean>>> f17628a = new MutableLiveData<>();

    public final MutableLiveData<VmState<List<WatchFansBean>>> h0() {
        return this.f17628a;
    }

    public final void i0(String str, String str2, long j11) {
        RequestExtKt.b(b.a().getWatchOrFansList(str, str2, j11), this.f17628a);
    }
}
