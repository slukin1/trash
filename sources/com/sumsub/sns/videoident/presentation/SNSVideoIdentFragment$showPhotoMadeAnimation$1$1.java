package com.sumsub.sns.videoident.presentation;

import android.view.View;
import android.view.animation.Animation;
import d10.a;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J\u0012\u0010\u0007\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016¨\u0006\b"}, d2 = {"com/sumsub/sns/videoident/presentation/SNSVideoIdentFragment$showPhotoMadeAnimation$1$1", "Landroid/view/animation/Animation$AnimationListener;", "onAnimationEnd", "", "animation", "Landroid/view/animation/Animation;", "onAnimationRepeat", "onAnimationStart", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class SNSVideoIdentFragment$showPhotoMadeAnimation$1$1 implements Animation.AnimationListener {
    public final /* synthetic */ a<Unit> $finishCallback;
    public final /* synthetic */ SNSVideoIdentFragment this$0;

    public SNSVideoIdentFragment$showPhotoMadeAnimation$1$1(SNSVideoIdentFragment sNSVideoIdentFragment, a<Unit> aVar) {
        this.this$0 = sNSVideoIdentFragment;
        this.$finishCallback = aVar;
    }

    public void onAnimationEnd(Animation animation) {
        View access$getPhotoMadeIndicator = this.this$0.getPhotoMadeIndicator();
        if (access$getPhotoMadeIndicator != null) {
            access$getPhotoMadeIndicator.setVisibility(8);
        }
        this.$finishCallback.invoke();
    }

    public void onAnimationRepeat(Animation animation) {
    }

    public void onAnimationStart(Animation animation) {
        View access$getPhotoMadeIndicator = this.this$0.getPhotoMadeIndicator();
        if (access$getPhotoMadeIndicator != null) {
            access$getPhotoMadeIndicator.setVisibility(0);
        }
    }
}
