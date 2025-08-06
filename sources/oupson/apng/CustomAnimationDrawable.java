package oupson.apng;

import android.graphics.drawable.AnimationDrawable;
import d10.l;
import kotlin.Metadata;
import kotlin.Unit;

@Metadata(bv = {}, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\n\u0010\u000bJ\u001c\u0010\u0006\u001a\u00020\u00042\u0014\u0010\u0005\u001a\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0003H\u0016¨\u0006\f"}, d2 = {"Loupson/apng/CustomAnimationDrawable;", "Landroid/graphics/drawable/AnimationDrawable;", "Lkotlin/Function1;", "", "", "f", "a", "index", "", "selectDrawable", "<init>", "()V", "apng_library_release"}, k = 1, mv = {1, 4, 2})
public final class CustomAnimationDrawable extends AnimationDrawable {

    /* renamed from: b  reason: collision with root package name */
    public l<? super Integer, Unit> f52930b = CustomAnimationDrawable$onFrameChangeListener$1.INSTANCE;

    public final void a(l<? super Integer, Unit> lVar) {
        this.f52930b = lVar;
    }

    public boolean selectDrawable(int i11) {
        boolean selectDrawable = super.selectDrawable(i11);
        this.f52930b.invoke(Integer.valueOf(i11));
        return selectDrawable;
    }
}
