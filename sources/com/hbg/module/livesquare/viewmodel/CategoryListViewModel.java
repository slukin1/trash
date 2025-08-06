package com.hbg.module.livesquare.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.LiveCategoryListData;
import com.hbg.module.community.viewmodel.BaseViewModel;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.hbg.module.libkt.base.ext.VmState;
import v7.b;

public final class CategoryListViewModel extends BaseViewModel {

    /* renamed from: a  reason: collision with root package name */
    public final MutableLiveData<VmState<LiveCategoryListData>> f26683a = new MutableLiveData<>();

    public final MutableLiveData<VmState<LiveCategoryListData>> h0() {
        return this.f26683a;
    }

    public final void i0(int i11, int i12, int i13) {
        RequestExtKt.b(b.a().getLiveCategoryList(i11, i12, i13), this.f26683a);
    }
}
