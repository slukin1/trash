package com.hbg.module.community.adapter;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.widgets.photoviewer.PhotoViewerUtils;
import com.hbg.lib.widgets.photoviewer.data.ImageData;
import d10.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityFeedItemBinder$onBindViewHolder$1 extends Lambda implements p<Integer, List<? extends CommunityFeedInfo.imgListBean>, Unit> {
    public final /* synthetic */ Context $context;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityFeedItemBinder$onBindViewHolder$1(Context context) {
        super(2);
        this.$context = context;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (List<? extends CommunityFeedInfo.imgListBean>) (List) obj2);
        return Unit.f56620a;
    }

    public final void invoke(int i11, List<? extends CommunityFeedInfo.imgListBean> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (CommunityFeedInfo.imgListBean imglistbean : list) {
                arrayList.add(new ImageData(imglistbean.getImage(), imglistbean.getThumbImage()));
            }
        }
        PhotoViewerUtils.a((FragmentActivity) this.$context, arrayList, i11);
    }
}
