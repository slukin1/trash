package androidx.appcompat.widget;

import android.content.res.TypedArray;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.util.AttributeSet;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.appcompat.R$styleable;
import l1.a;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public final EditText f4565a;

    /* renamed from: b  reason: collision with root package name */
    public final a f4566b;

    public f(EditText editText) {
        this.f4565a = editText;
        this.f4566b = new a(editText, false);
    }

    public KeyListener a(KeyListener keyListener) {
        return b(keyListener) ? this.f4566b.a(keyListener) : keyListener;
    }

    public boolean b(KeyListener keyListener) {
        return !(keyListener instanceof NumberKeyListener);
    }

    public boolean c() {
        return this.f4566b.b();
    }

    /* JADX INFO: finally extract failed */
    public void d(AttributeSet attributeSet, int i11) {
        TypedArray obtainStyledAttributes = this.f4565a.getContext().obtainStyledAttributes(attributeSet, R$styleable.AppCompatTextView, i11, 0);
        try {
            int i12 = R$styleable.AppCompatTextView_emojiCompatEnabled;
            boolean z11 = true;
            if (obtainStyledAttributes.hasValue(i12)) {
                z11 = obtainStyledAttributes.getBoolean(i12, true);
            }
            obtainStyledAttributes.recycle();
            f(z11);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }

    public InputConnection e(InputConnection inputConnection, EditorInfo editorInfo) {
        return this.f4566b.c(inputConnection, editorInfo);
    }

    public void f(boolean z11) {
        this.f4566b.d(z11);
    }
}
