package com.hbg.module.content.ui.activity;

import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationVote;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import we.c;

public final class NewsDetailActivity$vote$1$1 extends Lambda implements l<NewFlashInformationVote, Unit> {
    public final /* synthetic */ long $id;
    public final /* synthetic */ NewsDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsDetailActivity$vote$1$1(NewsDetailActivity newsDetailActivity, long j11) {
        super(1);
        this.this$0 = newsDetailActivity;
        this.$id = j11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NewFlashInformationVote) obj);
        return Unit.f56620a;
    }

    public final void invoke(NewFlashInformationVote newFlashInformationVote) {
        if (newFlashInformationVote != null) {
            NewsDetailActivity newsDetailActivity = this.this$0;
            long j11 = this.$id;
            NewFlashInformation Bh = newsDetailActivity.f18296k;
            if (Bh != null) {
                Bh.setBullVote(newFlashInformationVote.getBullVote());
            }
            NewFlashInformation Bh2 = newsDetailActivity.f18296k;
            if (Bh2 != null) {
                Bh2.setBadVote(newFlashInformationVote.getBadVote());
            }
            NewFlashInformation Bh3 = newsDetailActivity.f18296k;
            if (Bh3 != null) {
                Bh3.setVotedType(newFlashInformationVote.getVotedType());
            }
            NewsDetailActivity.Dh(newsDetailActivity).O(newsDetailActivity.f18296k);
            NewFlashInformation Bh4 = newsDetailActivity.f18296k;
            int i11 = 0;
            newsDetailActivity.hi(Bh4 != null ? Bh4.getVotedType() : 0, NewsDetailActivity.Dh(newsDetailActivity).L, NewsDetailActivity.Dh(newsDetailActivity).f19304i0, NewsDetailActivity.Dh(newsDetailActivity).K, NewsDetailActivity.Dh(newsDetailActivity).f19302g0);
            NewFlashInformation Bh5 = newsDetailActivity.f18296k;
            if (Bh5 != null) {
                i11 = Bh5.getVotedType();
            }
            newsDetailActivity.ii(i11, NewsDetailActivity.Dh(newsDetailActivity).U, NewsDetailActivity.Dh(newsDetailActivity).T);
            c.G(j11, newFlashInformationVote.getBullVote(), newFlashInformationVote.getBadVote(), newFlashInformationVote.getVotedType());
        }
    }
}
