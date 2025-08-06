package com.hbg.module.livesquare.ui;

import androidx.fragment.app.FragmentActivity;
import com.hbg.lib.network.hbg.core.bean.LiveCategoryData;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.custom.indicator.TabData;
import com.tencent.rtmp.TXVodConstants;
import d10.l;
import he.a;
import java.util.ArrayList;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

public final class LiveCategoryActivity$getCategoryList$1 extends Lambda implements l<ArrayList<LiveCategoryData>, Unit> {
    public final /* synthetic */ LiveCategoryActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveCategoryActivity$getCategoryList$1(LiveCategoryActivity liveCategoryActivity) {
        super(1);
        this.this$0 = liveCategoryActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ArrayList<LiveCategoryData>) (ArrayList) obj);
        return Unit.f56620a;
    }

    public final void invoke(ArrayList<LiveCategoryData> arrayList) {
        ArrayList<LiveCategoryData> arrayList2 = arrayList;
        if (arrayList2 != null) {
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            int size = arrayList.size();
            int i11 = 0;
            for (int i12 = 0; i12 < size; i12++) {
                arrayList3.add(new TabData(arrayList2.get(i12).getTitle(), 0, arrayList2.get(i12).getCategoryId(), 2, (r) null));
                arrayList4.add(LiveCategoryFragment.f26570r.a(arrayList2.get(i12).getCategoryId(), this.this$0.f26561j));
                if (this.this$0.f26560i == arrayList2.get(i12).getCategoryId()) {
                    i11 = i12;
                }
            }
            if (b.w(arrayList3)) {
                LiveCategoryActivity.zh(this.this$0).C.k();
                return;
            }
            a aVar = new a((FragmentActivity) this.this$0);
            aVar.a(arrayList4);
            LiveCategoryActivity.zh(this.this$0).F.setAdapter(aVar);
            LiveCategoryActivity.zh(this.this$0).F.setOffscreenPageLimit(arrayList3.size());
            LiveCategoryActivity liveCategoryActivity = this.this$0;
            ne.b.o(liveCategoryActivity, arrayList3, LiveCategoryActivity.zh(liveCategoryActivity).B, LiveCategoryActivity.zh(this.this$0).F, 16.0f, 0, 0, (Float) null, (Integer) null, (Integer) null, false, TXVodConstants.VOD_PLAY_EVT_TCP_CONNECT_SUCC, (Object) null);
            LiveCategoryActivity.zh(this.this$0).F.setCurrentItem(i11, false);
            LiveCategoryActivity.zh(this.this$0).C.g();
            return;
        }
        LiveCategoryActivity.zh(this.this$0).C.k();
    }
}
