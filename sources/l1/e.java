package l1;

import android.text.Editable;
import android.text.Selection;
import android.text.Spannable;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class e implements TextWatcher {

    /* renamed from: b  reason: collision with root package name */
    public final EditText f16065b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f16066c;

    /* renamed from: d  reason: collision with root package name */
    public EmojiCompat.InitCallback f16067d;

    /* renamed from: e  reason: collision with root package name */
    public int f16068e = Integer.MAX_VALUE;

    /* renamed from: f  reason: collision with root package name */
    public int f16069f = 0;

    /* renamed from: g  reason: collision with root package name */
    public boolean f16070g;

    public static class a extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        public final Reference<EditText> f16071a;

        public a(EditText editText) {
            this.f16071a = new WeakReference(editText);
        }

        public void b() {
            super.b();
            e.c(this.f16071a.get(), 1);
        }
    }

    public e(EditText editText, boolean z11) {
        this.f16065b = editText;
        this.f16066c = z11;
        this.f16070g = true;
    }

    public static void c(EditText editText, int i11) {
        if (i11 == 1 && editText != null && editText.isAttachedToWindow()) {
            Editable editableText = editText.getEditableText();
            int selectionStart = Selection.getSelectionStart(editableText);
            int selectionEnd = Selection.getSelectionEnd(editableText);
            EmojiCompat.b().o(editableText);
            c.b(editableText, selectionStart, selectionEnd);
        }
    }

    public final EmojiCompat.InitCallback a() {
        if (this.f16067d == null) {
            this.f16067d = new a(this.f16065b);
        }
        return this.f16067d;
    }

    public void afterTextChanged(Editable editable) {
    }

    public boolean b() {
        return this.f16070g;
    }

    public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
    }

    public void d(boolean z11) {
        if (this.f16070g != z11) {
            if (this.f16067d != null) {
                EmojiCompat.b().t(this.f16067d);
            }
            this.f16070g = z11;
            if (z11) {
                c(this.f16065b, EmojiCompat.b().d());
            }
        }
    }

    public final boolean e() {
        return !this.f16070g || (!this.f16066c && !EmojiCompat.h());
    }

    public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        if (!this.f16065b.isInEditMode() && !e() && i12 <= i13 && (charSequence instanceof Spannable)) {
            int d11 = EmojiCompat.b().d();
            if (d11 != 0) {
                if (d11 == 1) {
                    EmojiCompat.b().r((Spannable) charSequence, i11, i11 + i13, this.f16068e, this.f16069f);
                    return;
                } else if (d11 != 3) {
                    return;
                }
            }
            EmojiCompat.b().s(a());
        }
    }
}
