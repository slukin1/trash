package l1;

import android.text.InputFilter;
import android.text.Selection;
import android.text.Spannable;
import android.text.Spanned;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

public final class c implements InputFilter {

    /* renamed from: b  reason: collision with root package name */
    public final TextView f16056b;

    /* renamed from: c  reason: collision with root package name */
    public EmojiCompat.InitCallback f16057c;

    public static class a extends EmojiCompat.InitCallback {

        /* renamed from: a  reason: collision with root package name */
        public final Reference<TextView> f16058a;

        /* renamed from: b  reason: collision with root package name */
        public final Reference<c> f16059b;

        public a(TextView textView, c cVar) {
            this.f16058a = new WeakReference(textView);
            this.f16059b = new WeakReference(cVar);
        }

        public void b() {
            CharSequence text;
            CharSequence o11;
            super.b();
            TextView textView = this.f16058a.get();
            if (c(textView, this.f16059b.get()) && textView.isAttachedToWindow() && (text = textView.getText()) != (o11 = EmojiCompat.b().o(text))) {
                int selectionStart = Selection.getSelectionStart(o11);
                int selectionEnd = Selection.getSelectionEnd(o11);
                textView.setText(o11);
                if (o11 instanceof Spannable) {
                    c.b((Spannable) o11, selectionStart, selectionEnd);
                }
            }
        }

        public final boolean c(TextView textView, InputFilter inputFilter) {
            InputFilter[] filters;
            if (inputFilter == null || textView == null || (filters = textView.getFilters()) == null) {
                return false;
            }
            for (InputFilter inputFilter2 : filters) {
                if (inputFilter2 == inputFilter) {
                    return true;
                }
            }
            return false;
        }
    }

    public c(TextView textView) {
        this.f16056b = textView;
    }

    public static void b(Spannable spannable, int i11, int i12) {
        if (i11 >= 0 && i12 >= 0) {
            Selection.setSelection(spannable, i11, i12);
        } else if (i11 >= 0) {
            Selection.setSelection(spannable, i11);
        } else if (i12 >= 0) {
            Selection.setSelection(spannable, i12);
        }
    }

    public final EmojiCompat.InitCallback a() {
        if (this.f16057c == null) {
            this.f16057c = new a(this.f16056b, this);
        }
        return this.f16057c;
    }

    public CharSequence filter(CharSequence charSequence, int i11, int i12, Spanned spanned, int i13, int i14) {
        if (this.f16056b.isInEditMode()) {
            return charSequence;
        }
        int d11 = EmojiCompat.b().d();
        if (d11 != 0) {
            boolean z11 = true;
            if (d11 == 1) {
                if (i14 == 0 && i13 == 0 && spanned.length() == 0 && charSequence == this.f16056b.getText()) {
                    z11 = false;
                }
                if (!z11 || charSequence == null) {
                    return charSequence;
                }
                if (!(i11 == 0 && i12 == charSequence.length())) {
                    charSequence = charSequence.subSequence(i11, i12);
                }
                return EmojiCompat.b().p(charSequence, 0, charSequence.length());
            } else if (d11 != 3) {
                return charSequence;
            }
        }
        EmojiCompat.b().s(a());
        return charSequence;
    }
}
