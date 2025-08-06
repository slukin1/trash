package com.hbg.module.community.ui;

import android.widget.TextView;
import com.hbg.lib.network.hbg.core.bean.ContentUGCModel;
import com.hbg.module.community.adapter.w;
import com.hbg.module.libkt.base.ext.b;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class PersonalCenterChildFragment$getTaskList$1 extends Lambda implements l<ContentUGCModel, Unit> {
    public final /* synthetic */ PersonalCenterChildFragment this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PersonalCenterChildFragment$getTaskList$1(PersonalCenterChildFragment personalCenterChildFragment) {
        super(1);
        this.this$0 = personalCenterChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((ContentUGCModel) obj);
        return Unit.f56620a;
    }

    public final void invoke(ContentUGCModel contentUGCModel) {
        Unit unit;
        if (contentUGCModel != null) {
            PersonalCenterChildFragment personalCenterChildFragment = this.this$0;
            if (b.w(contentUGCModel.getTasks())) {
                PersonalCenterChildFragment.Th(personalCenterChildFragment).C.setVisibility(8);
            } else {
                TextView textView = PersonalCenterChildFragment.Th(personalCenterChildFragment).I;
                StringBuilder sb2 = new StringBuilder();
                sb2.append(contentUGCModel.getFinished());
                sb2.append('/');
                sb2.append(contentUGCModel.getTasks().size());
                textView.setText(sb2.toString());
                PersonalCenterChildFragment.Th(personalCenterChildFragment).J.setText(String.valueOf(contentUGCModel.getBonusAmountAll()));
                PersonalCenterChildFragment.Th(personalCenterChildFragment).E.setLayoutManager(b.m(personalCenterChildFragment.getActivity()));
                if (personalCenterChildFragment.f17488w == null) {
                    personalCenterChildFragment.f17488w = new w(personalCenterChildFragment.getActivity());
                }
                w Vh = personalCenterChildFragment.f17488w;
                if (Vh != null) {
                    Vh.a(0, contentUGCModel.getTasks());
                }
                PersonalCenterChildFragment.Th(personalCenterChildFragment).E.setAdapter(personalCenterChildFragment.f17488w);
                PersonalCenterChildFragment.Th(personalCenterChildFragment).C.setVisibility(0);
            }
            unit = Unit.f56620a;
        } else {
            unit = null;
        }
        if (unit == null) {
            PersonalCenterChildFragment.Th(this.this$0).C.setVisibility(8);
        }
    }
}
