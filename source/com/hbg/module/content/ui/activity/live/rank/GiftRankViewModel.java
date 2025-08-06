package com.hbg.module.content.ui.activity.live.rank;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.LiveGiftRank;
import com.hbg.module.community.viewmodel.BaseViewModel;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.VmState;
import v7.b;

public final class GiftRankViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final MutableLiveData<VmState<LiveGiftRank>> f18695a = new MutableLiveData<>();

    public final MutableLiveData<VmState<LiveGiftRank>> h0() {
        return this.f18695a;
    }

    public final void i0(String str, int i11) {
        RequestExtKt.b(b.a().getGiftTop(str, i11), this.f18695a);
    }
}
