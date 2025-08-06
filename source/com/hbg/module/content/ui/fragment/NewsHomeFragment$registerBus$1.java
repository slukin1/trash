package com.hbg.module.content.ui.fragment;

import com.hbg.module.libkt.custom.indicator.TabData;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import xe.f;

public final class NewsHomeFragment$registerBus$1 extends Lambda implements l<f, Unit> {
    public final /* synthetic */ NewsHomeFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsHomeFragment$registerBus$1(NewsHomeFragment newsHomeFragment) {
        super(1);
        this.this$0 = newsHomeFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((f) obj);
        return Unit.f56620a;
    }

    public final void invoke(f fVar) {
        NewsHomeFragment newsHomeFragment = this.this$0;
        if ((x.b(fVar.b(), "newsPage") && newsHomeFragment.f18801s == 1) || (x.b(fVar.b(), "deepNewsPage") && newsHomeFragment.f18801s == 3)) {
            try {
                if (fVar.a() == 0) {
                    NewsHomeFragment.Vh(newsHomeFragment).I.setCurrentItem(fVar.a(), false);
                } else if (newsHomeFragment.f18800r == null || newsHomeFragment.f18800r.size() <= 0) {
                    newsHomeFragment.f18803u = fVar.a();
                } else {
                    int size = newsHomeFragment.f18800r.size();
                    for (int i11 = 0; i11 < size; i11++) {
                        if (((TabData) newsHomeFragment.f18800r.get(i11)).getTabId() == fVar.a()) {
                            NewsHomeFragment.Vh(newsHomeFragment).I.setCurrentItem(i11, false);
                            return;
                        }
                    }
                }
            } catch (IndexOutOfBoundsException e11) {
                e11.printStackTrace();
            }
        }
    }
}
