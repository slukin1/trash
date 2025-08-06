package com.hbg.module.content.ui.activity;

import android.content.Intent;
import android.view.View;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationCoinTags;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationImage;
import com.hbg.module.content.adapter.g;
import com.hbg.module.content.custom.tag.TagLayout;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.libkt.base.ext.c;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import java.util.List;
import kc.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import lc.q;

public final class NewsDetailActivity$getNewsDetail$1 extends Lambda implements l<NewFlashInformation, Unit> {
    public final /* synthetic */ NewsDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsDetailActivity$getNewsDetail$1(NewsDetailActivity newsDetailActivity) {
        super(1);
        this.this$0 = newsDetailActivity;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void invoke$lambda$0(NewFlashInformation newFlashInformation, NewsDetailActivity newsDetailActivity, View view) {
        Intent intent = new Intent();
        intent.putExtra("url", newFlashInformation.getLink());
        intent.setClass(newsDetailActivity, HBBaseWebActivity.class);
        newsDetailActivity.startActivity(intent);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NewFlashInformation) obj);
        return Unit.f56620a;
    }

    public final void invoke(NewFlashInformation newFlashInformation) {
        NewFlashInformation newFlashInformation2 = newFlashInformation;
        NewsDetailActivity.Dh(this.this$0).Z.finishRefresh();
        NewsDetailActivity.Dh(this.this$0).R.g();
        this.this$0.Wh();
        if (newFlashInformation2 != null) {
            this.this$0.f18296k = newFlashInformation2;
            NewsDetailActivity.Dh(this.this$0).O(newFlashInformation2);
            this.this$0.Vh();
            NewsDetailActivity.Dh(this.this$0).f19301f0.setVisibility((b.x(newFlashInformation.getLinkTitle()) || b.x(newFlashInformation.getLink())) ? 8 : 0);
            NewsDetailActivity.Dh(this.this$0).f19301f0.setOnClickListener(new h(newFlashInformation2, this.this$0));
            if (!b.w(newFlashInformation.getImages())) {
                List<NewFlashInformationImage> images = newFlashInformation.getImages();
                NewFlashInformationImage newFlashInformationImage = images != null ? images.get(0) : null;
                if (newFlashInformationImage != null) {
                    try {
                        NewsDetailActivity.Dh(this.this$0).P.getLayoutParams().height = (int) ((((float) (c.c() - c.a(30.0f))) / ((float) newFlashInformationImage.getWidth())) * ((float) newFlashInformationImage.getHeight()));
                    } catch (Throwable th2) {
                        th2.printStackTrace();
                    }
                    q Dh = NewsDetailActivity.Dh(this.this$0);
                    List<NewFlashInformationImage> images2 = newFlashInformation.getImages();
                    Dh.M(images2 != null ? images2.get(0) : null);
                }
            }
            if (!b.w(newFlashInformation.getCoinTags())) {
                NewsDetailActivity.Dh(this.this$0).Q.removeAllViews();
                int i11 = 0;
                for (NewFlashInformationCoinTags next : newFlashInformation.getCoinTags()) {
                    if (i11 > 2) {
                        break;
                    }
                    TagLayout tagLayout = NewsDetailActivity.Dh(this.this$0).Q;
                    NewsDetailActivity newsDetailActivity = this.this$0;
                    NewFlashInformation Bh = this.this$0.f18296k;
                    String valueOf = String.valueOf(Bh != null ? Long.valueOf(Bh.getId()) : null);
                    NewFlashInformation Bh2 = this.this$0.f18296k;
                    String title = Bh2 != null ? Bh2.getTitle() : null;
                    if (title == null) {
                        title = "";
                    }
                    String str = title;
                    NewFlashInformation Bh3 = this.this$0.f18296k;
                    int isTranslateTag = Bh3 != null ? Bh3.getIsTranslateTag() : 0;
                    a aVar = a.f19139a;
                    tagLayout.addView(a.b(newsDetailActivity, next, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC, valueOf, str, isTranslateTag, true, (String) null, aVar.e(next.getCoin()), aVar.f(), true, (d10.a) null, 2048, (Object) null));
                    i11++;
                }
                NewsDetailActivity.Dh(this.this$0).Q.setVisibility(0);
            } else {
                NewsDetailActivity.Dh(this.this$0).Q.setVisibility(8);
            }
            if (!b.w(newFlashInformation.getRecommends())) {
                g Eh = this.this$0.f18300o;
                if (Eh != null) {
                    Eh.a(0, newFlashInformation.getRecommends());
                }
                NewsDetailActivity.Dh(this.this$0).f19303h0.setVisibility(0);
                NewsDetailActivity.Dh(this.this$0).Y.setVisibility(0);
            } else {
                NewsDetailActivity.Dh(this.this$0).f19303h0.setVisibility(8);
                NewsDetailActivity.Dh(this.this$0).Y.setVisibility(8);
            }
            NewsDetailActivity newsDetailActivity2 = this.this$0;
            NewFlashInformation Bh4 = newsDetailActivity2.f18296k;
            newsDetailActivity2.hi(Bh4 != null ? Bh4.getVotedType() : 0, NewsDetailActivity.Dh(this.this$0).L, NewsDetailActivity.Dh(this.this$0).f19304i0, NewsDetailActivity.Dh(this.this$0).K, NewsDetailActivity.Dh(this.this$0).f19302g0);
            NewsDetailActivity newsDetailActivity3 = this.this$0;
            NewFlashInformation Bh5 = newsDetailActivity3.f18296k;
            newsDetailActivity3.fi(Bh5 != null ? Bh5.praiseStatus : 0, false);
            return;
        }
        NewsDetailActivity.Dh(this.this$0).R.k();
    }
}
