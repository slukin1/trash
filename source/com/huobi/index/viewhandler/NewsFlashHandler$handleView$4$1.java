package com.huobi.index.viewhandler;

import android.widget.ImageView;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.hbg.lib.network.hbg.core.bean.NewFlashInformation;
import d10.l;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class NewsFlashHandler$handleView$4$1 extends Lambda implements l<NewFlashInformation, Unit> {
    public final /* synthetic */ ImageView $imagePut;
    public final /* synthetic */ ImageView $imageRise;
    public final /* synthetic */ LottieAnimationView $lottiePut;
    public final /* synthetic */ LottieAnimationView $lottieRise;
    public final /* synthetic */ TextView $tvPut;
    public final /* synthetic */ TextView $tvRise;
    public final /* synthetic */ NewsFlashHandler this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public NewsFlashHandler$handleView$4$1(NewsFlashHandler newsFlashHandler, ImageView imageView, TextView textView, ImageView imageView2, TextView textView2, LottieAnimationView lottieAnimationView, LottieAnimationView lottieAnimationView2) {
        super(1);
        this.this$0 = newsFlashHandler;
        this.$imageRise = imageView;
        this.$tvRise = textView;
        this.$imagePut = imageView2;
        this.$tvPut = textView2;
        this.$lottieRise = lottieAnimationView;
        this.$lottiePut = lottieAnimationView2;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((NewFlashInformation) obj);
        return Unit.f56620a;
    }

    public final void invoke(NewFlashInformation newFlashInformation) {
        this.this$0.h(newFlashInformation.getVotedType(), this.$imageRise, this.$tvRise, this.$imagePut, this.$tvPut);
        this.$tvRise.setText(String.valueOf(newFlashInformation.getBullVote()));
        this.$tvPut.setText(String.valueOf(newFlashInformation.getBadVote()));
        this.this$0.i(newFlashInformation.getVotedType(), this.$imageRise, this.$lottieRise, this.$imagePut, this.$lottiePut);
    }
}
