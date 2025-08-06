package com.hbg.module.community.ui;

import com.hbg.lib.network.hbg.core.bean.PersonalCenterInfo;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class PersonalCenterActivity$getHeaderInfo$1 extends Lambda implements l<PersonalCenterInfo, Unit> {
    public final /* synthetic */ PersonalCenterActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonalCenterActivity$getHeaderInfo$1(PersonalCenterActivity personalCenterActivity) {
        super(1);
        this.this$0 = personalCenterActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((PersonalCenterInfo) obj);
        return Unit.f56620a;
    }

    public final void invoke(PersonalCenterInfo personalCenterInfo) {
        this.this$0.Df();
        PersonalCenterActivity personalCenterActivity = this.this$0;
        if (personalCenterInfo != null) {
            personalCenterActivity.f17443s = personalCenterInfo;
            personalCenterActivity.f17444t = personalCenterActivity.f17443s.getUidUnique();
            PersonalCenterActivity.zh(personalCenterActivity).M(personalCenterActivity.f17443s);
            personalCenterActivity.bi();
        }
    }
}
