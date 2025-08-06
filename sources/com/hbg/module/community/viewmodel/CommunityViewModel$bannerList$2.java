package com.hbg.module.community.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.LiveBannerData;
import d10.a;
import java.util.List;
import kotlin.jvm.internal.FunctionReferenceImpl;

public /* synthetic */ class CommunityViewModel$bannerList$2 extends FunctionReferenceImpl implements a<MutableLiveData<List<? extends LiveBannerData>>> {
    public static final CommunityViewModel$bannerList$2 INSTANCE = new CommunityViewModel$bannerList$2();

    public CommunityViewModel$bannerList$2() {
        super(0, MutableLiveData.class, "<init>", "<init>()V", 0);
    }

    public final MutableLiveData<List<LiveBannerData>> invoke() {
        return new MutableLiveData<>();
    }
}
