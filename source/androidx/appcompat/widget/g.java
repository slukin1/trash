package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.R$styleable;
import l1.d;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f4568a;

    /* renamed from: b  reason: collision with root package name */
    public final d f4569b;

    public g(TextView textView) {
        this.f4568a = textView;
        this.f4569b = new d(textView, false);
    }

    public InputFilter[] a(InputFilter[] inputFilterArr) {
        return this.f4569b.a(inputFilterArr);
    }

    public boolean b() {
        return this.f4569b.b();
    }

    /* JADX INFO: finally extract failed */
    public void c(AttributeSet attributeSet, int i11) {
        TypedArray obtainStyledAttributes = this.f4568a.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i11, 0);
        try {
            int i12 = R$styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z11 = true;
            if (obtainStyledAttributes.hasValue(i12)) {
                z11 = obtainStyledAttributes.getBoolean(i12, true);
            }
            obtainStyledAttributes.recycle();
            e(z11);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public void d(boolean z11) {
        this.f4569b.c(z11);
    }

    public void e(boolean z11) {
        this.f4569b.d(z11);
    }

    public TransformationMethod f(TransformationMethod transformationMethod) {
        return this.f4569b.e(transformationMethod);
    }
}
