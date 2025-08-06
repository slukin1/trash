package oupson.apng;

import android.content.Context;
import android.content.SharedPreferences;
import d10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u0004\u0018\u00010\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Landroid/content/SharedPreferences;", "invoke"}, k = 3, mv = {1, 4, 2})
final class ApngAnimator$sharedPreferences$2 extends Lambda implements a<SharedPreferences> {
    public final /* synthetic */ ApngAnimator this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ApngAnimator$sharedPreferences$2(ApngAnimator apngAnimator) {
        super(0);
        this.this$0 = apngAnimator;
    }

    public final SharedPreferences invoke() {
        Context b11 = this.this$0.f52929l;
        if (b11 != null) {
            return b11.getSharedPreferences("apngAnimator", 0);
        }
        return null;
    }
}
