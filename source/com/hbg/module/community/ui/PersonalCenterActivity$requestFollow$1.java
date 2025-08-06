package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import d10.l;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import nc.c;

public final class PersonalCenterActivity$requestFollow$1 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ int $followStatus;
    public final /* synthetic */ PersonalCenterActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonalCenterActivity$requestFollow$1(PersonalCenterActivity personalCenterActivity, int i11) {
        super(1);
        this.this$0 = personalCenterActivity;
        this.$followStatus = i11;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.f56620a;
    }

    public final void invoke(Boolean bool) {
        this.this$0.Df();
        if (bool != null) {
            PersonalCenterActivity personalCenterActivity = this.this$0;
            int i11 = this.$followStatus;
            if (bool.booleanValue()) {
                personalCenterActivity.Vh(i11);
                personalCenterActivity.Th(i11);
                personalCenterActivity.f17443s.setFocusStatus(i11);
                String str = null;
                if (personalCenterActivity.f17443s.getFocusStatus() == 1) {
                    PersonalCenterInfo Ah = personalCenterActivity.f17443s;
                    Ah.setFansNum(Ah.getFansNum() + 1);
                    Pair[] pairArr = new Pair[1];
                    String Bh = personalCenterActivity.f17444t;
                    if (Bh == null) {
                        Bh = null;
                    }
                    pairArr[0] = kotlin.l.a("uid", Bh);
                    c.a("app_community_gz", MapsKt__MapsKt.j(pairArr));
                } else {
                    PersonalCenterInfo Ah2 = personalCenterActivity.f17443s;
                    Ah2.setFansNum(Ah2.getFansNum() - 1);
                }
                PersonalCenterActivity.zh(personalCenterActivity).M(personalCenterActivity.f17443s);
                String Bh2 = personalCenterActivity.f17444t;
                if (Bh2 != null) {
                    str = Bh2;
                }
                we.c.q(str, i11);
            }
        }
    }
}
