package com.sumsub.sns.videoident.presentation;

import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.videoident.presentation.a;
import d10.l;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0010\u0005\u001a\u00020\u00022\u0006\u0010\u0001\u001a\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"Lcom/sumsub/sns/internal/videoident/presentation/a$c$b;", "item", "", "invoke", "(Lcom/sumsub/sns/internal/videoident/presentation/a$c$b;)V", "<anonymous>"}, k = 3, mv = {1, 7, 1})
public final class LanguageSelectionFragment$onViewCreated$1$1 extends Lambda implements l<a.c.b, Unit> {
    public final /* synthetic */ LanguageSelectionFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LanguageSelectionFragment$onViewCreated$1$1(LanguageSelectionFragment languageSelectionFragment) {
        super(1);
        this.this$0 = languageSelectionFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((a.c.b) obj);
        return Unit.f56620a;
    }

    public final void invoke(a.c.b bVar) {
        this.this$0.getAnalyticsDelegate().b(this.this$0.getScreen(), this.this$0.getIdDocSetType(), Control.ListItem, MapsKt__MapsKt.l(kotlin.l.a("lang", String.valueOf(bVar.g())), kotlin.l.a("waitTimeSec", Long.valueOf(bVar.l()))));
        this.this$0.getViewModel().a(bVar);
    }
}
