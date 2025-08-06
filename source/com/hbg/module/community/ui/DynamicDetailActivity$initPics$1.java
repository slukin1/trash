package com.hbg.module.community.ui;

import b2.a;
import com.alibaba.android.arouter.facade.Postcard;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.lib.widgets.photoviewer.PhotoViewerUtils;
import com.hbg.lib.widgets.photoviewer.data.ImageData;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.base.ext.f;
import com.hbg.module.libkt.provider.HbgBaseProvider;
import d10.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class DynamicDetailActivity$initPics$1 extends Lambda implements p<Integer, List<? extends CommunityFeedInfo.imgListBean>, Unit> {
    public final /* synthetic */ DynamicDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicDetailActivity$initPics$1(DynamicDetailActivity dynamicDetailActivity) {
        super(2);
        this.this$0 = dynamicDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
        invoke(((Number) obj).intValue(), (List<? extends CommunityFeedInfo.imgListBean>) (List) obj2);
        return Unit.f56620a;
    }

    public final void invoke(int i11, List<? extends CommunityFeedInfo.imgListBean> list) {
        String shareImage;
        HbgBaseProvider fg2;
        DynamicDetailInfo Gh = this.this$0.f17332n;
        boolean z11 = false;
        if (Gh != null && Gh.getType() == 8) {
            z11 = true;
        }
        if (z11) {
            DynamicDetailInfo Gh2 = this.this$0.f17332n;
            String str = null;
            if (!b.x(Gh2 != null ? Gh2.extend : null)) {
                LiveDetailBean liveDetailBean = (LiveDetailBean) f.e().fromJson(this.this$0.f17332n.extend, new DynamicDetailActivity$initPics$1$invoke$$inlined$gsonToBean$1().getType());
                Postcard a11 = a.d().a("/live/room");
                if (liveDetailBean != null) {
                    str = liveDetailBean.f70249id;
                }
                a11.withString("liveId", str).withInt("liveStatus", liveDetailBean != null ? liveDetailBean.status : 2).navigation();
                return;
            }
            DynamicDetailInfo Gh3 = this.this$0.f17332n;
            if (Gh3 != null && (shareImage = Gh3.getShareImage()) != null && (fg2 = this.this$0.fg()) != null) {
                fg2.g(shareImage);
                return;
            }
            return;
        }
        ArrayList arrayList = new ArrayList();
        if (list != null) {
            for (CommunityFeedInfo.imgListBean imglistbean : list) {
                arrayList.add(new ImageData(imglistbean.getImage(), imglistbean.getThumbImage()));
            }
        }
        PhotoViewerUtils.a(this.this$0, arrayList, i11);
    }
}
