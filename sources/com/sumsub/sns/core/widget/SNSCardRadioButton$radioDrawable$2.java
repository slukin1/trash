package com.sumsub.sns.core.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import androidx.core.content.res.ResourcesCompat;
import com.sumsub.sns.internal.core.common.i;
import d10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/graphics/drawable/Drawable;", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
public final class SNSCardRadioButton$radioDrawable$2 extends Lambda implements a<Drawable> {
    public final /* synthetic */ Context $context;
    public final /* synthetic */ SNSCardRadioButton this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SNSCardRadioButton$radioDrawable$2(SNSCardRadioButton sNSCardRadioButton, Context context) {
        super(0);
        this.this$0 = sNSCardRadioButton;
        this.$context = context;
    }

    public final Drawable invoke() {
        return ResourcesCompat.f(this.this$0.getResources(), i.b(this.$context, 16843289), this.$context.getTheme());
    }
}
