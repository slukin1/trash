package jumio.core;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import com.jumio.commons.utils.ScreenUtil;
import com.jumio.core.R;
import jumio.core.s;
import kotlin.jvm.internal.r;

public abstract class t<I extends s> extends RelativeLayout {

    /* renamed from: a  reason: collision with root package name */
    public int f56324a;

    public t(Context context) {
        this(context, (AttributeSet) null, 0, 6, (r) null);
    }

    public t(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (r) null);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(Context context, AttributeSet attributeSet, int i11, int i12, r rVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? 0 : i11);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context != null ? context.obtainStyledAttributes(attributeSet, R.styleable.CheckView, 0, 0) : null;
            if (obtainStyledAttributes != null) {
                try {
                    this.f56324a = obtainStyledAttributes.getDimensionPixelSize(R.styleable.CheckView_jumio_cornerRadius, ScreenUtil.dpToPx(getContext(), 0));
                } catch (Throwable th2) {
                    obtainStyledAttributes.recycle();
                    throw th2;
                }
            }
            if (obtainStyledAttributes != null) {
                obtainStyledAttributes.recycle();
            }
        }
    }

    public final void detach$jumio_core_release() {
        removeAllViews();
    }

    public final int getCornerRadius() {
        return this.f56324a;
    }

    public final void setCornerRadius(int i11) {
        this.f56324a = i11;
    }

    public t(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        this.f56324a = a();
        a(context, attributeSet);
    }

    public final int a() {
        return ScreenUtil.dpToPx(getContext(), 0);
    }
}
