package com.hbg.module.content.ui.ability;

import com.hbg.lib.network.hbg.core.bean.CommentPraiseBean;
import d10.l;
import d10.p;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class ContentAbility$requestLike$1 extends Lambda implements l<CommentPraiseBean, Unit> {
    public final /* synthetic */ p<Integer, Integer, Unit> $onUpdateUI;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ContentAbility$requestLike$1(p<? super Integer, ? super Integer, Unit> pVar) {
        super(1);
        this.$onUpdateUI = pVar;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((CommentPraiseBean) obj);
        return Unit.f56620a;
    }

    public final void invoke(CommentPraiseBean commentPraiseBean) {
        if (commentPraiseBean != null) {
            this.$onUpdateUI.invoke(Integer.valueOf(commentPraiseBean.praiseNum), Integer.valueOf(commentPraiseBean.praiseStatus));
        }
    }
}
