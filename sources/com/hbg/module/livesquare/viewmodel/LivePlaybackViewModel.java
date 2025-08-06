package com.hbg.module.livesquare.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.LiveSquareSubData;
import com.hbg.module.community.viewmodel.BaseViewModel;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.VmState;
import v7.b;

public final class LivePlaybackViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final MutableLiveData<VmState<LiveSquareSubData>> f26685a = new MutableLiveData<>();

    public final MutableLiveData<VmState<LiveSquareSubData>> h0() {
        return this.f26685a;
    }

    public final void i0(int i11, int i12) {
        RequestExtKt.b(b.a().getLiveSquareCategoryData(3, i11, i12), this.f26685a);
    }
}
