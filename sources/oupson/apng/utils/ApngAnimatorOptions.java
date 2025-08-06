package oupson.apng.utils;

import android.widget.ImageView;
import kotlin.Metadata;
import kotlin.jvm.internal.r;

@Metadata(bv = {}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0007\u0010\bR\u0019\u0010\u0006\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0003\u0010\u0005¨\u0006\t"}, d2 = {"Loupson/apng/utils/ApngAnimatorOptions;", "", "Landroid/widget/ImageView$ScaleType;", "a", "Landroid/widget/ImageView$ScaleType;", "()Landroid/widget/ImageView$ScaleType;", "scaleType", "<init>", "(Landroid/widget/ImageView$ScaleType;)V", "apng_library_release"}, k = 1, mv = {1, 4, 2})
public final class ApngAnimatorOptions {

    /* renamed from: a  reason: collision with root package name */
    public final ImageView.ScaleType f52971a;

    public ApngAnimatorOptions() {
        this((ImageView.ScaleType) null, 1, (r) null);
    }

    public ApngAnimatorOptions(ImageView.ScaleType scaleType) {
        this.f52971a = scaleType;
    }

    public final ImageView.ScaleType a() {
        return this.f52971a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ApngAnimatorOptions(ImageView.ScaleType scaleType, int i11, r rVar) {
        this((i11 & 1) != 0 ? ImageView.ScaleType.FIT_CENTER : scaleType);
    }
}
