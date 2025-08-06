package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import d10.l;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import xe.e;

public final class CommunityKLineChildFragment$initObservers$6 extends Lambda implements l<e, Unit> {
    public final /* synthetic */ CommunityKLineChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityKLineChildFragment$initObservers$6(CommunityKLineChildFragment communityKLineChildFragment) {
        super(1);
        this.this$0 = communityKLineChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((e) obj);
        return Unit.f56620a;
    }

    public final void invoke(e eVar) {
        this.this$0.Lh();
        List<Object> bi2 = this.this$0.bi();
        CommunityKLineChildFragment communityKLineChildFragment = this.this$0;
        int i11 = 0;
        for (T next : bi2) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.t();
            }
            if (next instanceof CommunityFeedInfo.ListBean) {
                CommunityFeedInfo.ListBean listBean = (CommunityFeedInfo.ListBean) next;
                if (listBean.getItemType() == 2) {
                    List<CommunityFeedInfo.FocusBean> focusList = listBean.getFocusList();
                    if (focusList != null) {
                        for (CommunityFeedInfo.FocusBean focusBean : focusList) {
                            if (x.b(focusBean.getUidUnique(), eVar.b()) && focusBean.getFocusStatus() != eVar.a()) {
                                focusBean.setFocusStatus(eVar.a());
                                communityKLineChildFragment.ai().notifyItemChanged(i11, 0);
                            }
                        }
                    }
                } else if (x.b(eVar.b(), listBean.getUidUnique()) && eVar.a() != listBean.getFocusStatus()) {
                    listBean.setFocusStatus(eVar.a());
                    communityKLineChildFragment.ai().notifyItemChanged(i11, 0);
                }
            }
            i11 = i12;
        }
        this.this$0.sh();
    }
}
