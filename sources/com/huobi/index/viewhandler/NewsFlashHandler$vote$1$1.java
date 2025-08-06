package com.huobi.index.viewhandler;

import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformationVote;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsFlashHandler$vote$1$1 extends Lambda implements l<NewFlashInformationVote, Unit> {
    public final /* synthetic */ NewFlashInformation $newFlashInfo;
    public final /* synthetic */ l<NewFlashInformation, Unit> $onSuccess;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsFlashHandler$vote$1$1(NewFlashInformation newFlashInformation, l<? super NewFlashInformation, Unit> lVar) {
        super(1);
        this.$newFlashInfo = newFlashInformation;
        this.$onSuccess = lVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NewFlashInformationVote) obj);
        return Unit.f56620a;
    }

    public final void invoke(NewFlashInformationVote newFlashInformationVote) {
        if (newFlashInformationVote != null) {
            NewFlashInformation newFlashInformation = this.$newFlashInfo;
            l<NewFlashInformation, Unit> lVar = this.$onSuccess;
            newFlashInformation.setBullVote(newFlashInformationVote.getBullVote());
            newFlashInformation.setBadVote(newFlashInformationVote.getBadVote());
            newFlashInformation.setVotedType(newFlashInformationVote.getVotedType());
            lVar.invoke(newFlashInformation);
        }
    }
}
