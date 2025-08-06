package l1;

import android.graphics.Rect;
import android.text.method.TransformationMethod;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

public class f implements TransformationMethod {

    /* renamed from: b  reason: collision with root package name */
    public final TransformationMethod f16072b;

    public f(TransformationMethod transformationMethod) {
        this.f16072b = transformationMethod;
    }

    public TransformationMethod a() {
        return this.f16072b;
    }

    public CharSequence getTransformation(CharSequence charSequence, View view) {
        if (view.isInEditMode()) {
            return charSequence;
        }
        TransformationMethod transformationMethod = this.f16072b;
        if (transformationMethod != null) {
            charSequence = transformationMethod.getTransformation(charSequence, view);
        }
        return (charSequence == null || EmojiCompat.b().d() != 1) ? charSequence : EmojiCompat.b().o(charSequence);
    }

    public void onFocusChanged(View view, CharSequence charSequence, boolean z11, int i11, Rect rect) {
        TransformationMethod transformationMethod = this.f16072b;
        if (transformationMethod != null) {
            transformationMethod.onFocusChanged(view, charSequence, z11, i11, rect);
        }
    }
}
