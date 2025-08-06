package com.hbg.module.community.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.VmState;
import v7.b;

public final class PostDynamicViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final MutableLiveData<VmState<DynamicDetailInfo>> f17626a = new MutableLiveData<>();

    public static /* synthetic */ void j0(PostDynamicViewModel postDynamicViewModel, String str, String str2, String str3, String str4, String str5, String str6, int i11, Object obj) {
        postDynamicViewModel.i0(str, (i11 & 2) != 0 ? null : str2, (i11 & 4) != 0 ? null : str3, (i11 & 8) != 0 ? null : str4, str5, (i11 & 32) != 0 ? null : str6);
    }

    public final MutableLiveData<VmState<DynamicDetailInfo>> h0() {
        return this.f17626a;
    }

    public final void i0(String str, String str2, String str3, String str4, String str5, String str6) {
        RequestExtKt.b(b.a().J0(str, str2, str3, str4, str5, str6), this.f17626a);
    }
}
