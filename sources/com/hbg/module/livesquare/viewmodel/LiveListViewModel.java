package com.hbg.module.livesquare.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.LiveSquareContentData;
import com.hbg.module.community.viewmodel.BaseViewModel;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.VmState;
import v7.b;

public final class LiveListViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final MutableLiveData<VmState<LiveSquareContentData>> f26684a = new MutableLiveData<>();

    public final MutableLiveData<VmState<LiveSquareContentData>> h0() {
        return this.f26684a;
    }

    public final void i0(int i11) {
        RequestExtKt.b(b.a().getLiveListData(i11), this.f26684a);
    }
}
