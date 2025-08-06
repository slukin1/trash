package com.hbg.module.community.viewmodel;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.a;
import java.util.List;
import kotlin.jvm.internal.FunctionReferenceImpl;

public /* synthetic */ class CommunityViewModel$commonFeedList$2 extends FunctionReferenceImpl implements a<MutableLiveData<List<? extends CommunityFeedInfo.ListBean>>> {
    public static final CommunityViewModel$commonFeedList$2 INSTANCE = new CommunityViewModel$commonFeedList$2();

    public CommunityViewModel$commonFeedList$2() {
        super(0, MutableLiveData.class, "<init>", "<init>()V", 0);
    }

    public final MutableLiveData<List<CommunityFeedInfo.ListBean>> invoke() {
        return new MutableLiveData<>();
    }
}
