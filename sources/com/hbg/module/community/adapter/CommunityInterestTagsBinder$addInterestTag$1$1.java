package com.hbg.module.community.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.AppCompatTextView;
import com.hbg.lib.network.hbg.core.bean.CommunityFeedInfo;
import com.hbg.module.content.R$attr;
import com.hbg.module.content.R$drawable;
import com.hbg.module.libkt.base.ext.b;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class CommunityInterestTagsBinder$addInterestTag$1$1 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ CommunityFeedInfo.InterestTag $tag;
    public final /* synthetic */ AppCompatTextView $tv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CommunityInterestTagsBinder$addInterestTag$1$1(CommunityFeedInfo.InterestTag interestTag, Context context, AppCompatTextView appCompatTextView) {
        super(1);
        this.$tag = interestTag;
        this.$context = context;
        this.$tv = appCompatTextView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.f56620a;
    }

    public final void invoke(Boolean bool) {
        Drawable drawable;
        CommunityFeedInfo.InterestTag interestTag = this.$tag;
        boolean z11 = !interestTag.isSel;
        interestTag.isSel = z11;
        if (z11) {
            drawable = b.p(this.$context, R$attr.tags_selected);
        } else {
            drawable = this.$context.getResources().getDrawable(R$drawable.icon_interest_tag);
        }
        this.$tv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
    }
}
