package com.huobi.index.viewhandler;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.hbg.module.libkt.base.ext.b;
import com.huobi.index.bean.IndexContract;
import com.huobi.view.roundview.RoundTextView;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import pro.huobi.R;

public final class RecommendTagHandler$addInterestTag$1$1 extends Lambda implements l<Boolean, Unit> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ IndexContract.ElemsDTO $tag;
    public final /* synthetic */ RoundTextView $tv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RecommendTagHandler$addInterestTag$1$1(IndexContract.ElemsDTO elemsDTO, Context context, RoundTextView roundTextView) {
        super(1);
        this.$tag = elemsDTO;
        this.$context = context;
        this.$tv = roundTextView;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Boolean) obj);
        return Unit.f56620a;
    }

    public final void invoke(Boolean bool) {
        Drawable drawable;
        IndexContract.ElemsDTO elemsDTO = this.$tag;
        boolean z11 = !elemsDTO.f73180c;
        elemsDTO.f73180c = z11;
        if (z11) {
            drawable = b.p(this.$context, R.attr.tags_selected);
        } else {
            drawable = this.$context.getResources().getDrawable(R.drawable.icon_interest_tag);
        }
        this.$tv.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, drawable, (Drawable) null);
    }
}
