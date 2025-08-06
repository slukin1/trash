package com.hbg.module.livesquare.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.RecommendSpeakerList;
import com.hbg.module.community.viewmodel.BaseViewModel;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.VmState;
import v7.b;

public final class RecommendSpeakerViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final MutableLiveData<VmState<RecommendSpeakerList>> f26686a = new MutableLiveData<>();

    public final void c(int i11) {
        RequestExtKt.b(b.a().getRecommendSpeaker(i11, 30, 2), this.f26686a);
    }

    public final MutableLiveData<VmState<RecommendSpeakerList>> h0() {
        return this.f26686a;
    }
}
