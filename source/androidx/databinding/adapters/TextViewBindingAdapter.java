package androidx.databinding.adapters;

import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.TextView;
import androidx.databinding.library.baseAdapters.R$id;

public class TextViewBindingAdapter {

    public class a implements TextWatcher {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ c f8869b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f8870c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ androidx.databinding.d f8871d;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ b f8872e;

        public a(c cVar, d dVar, androidx.databinding.d dVar2, b bVar) {
            this.f8869b = cVar;
            this.f8870c = dVar;
            this.f8871d = dVar2;
            this.f8872e = bVar;
        }

        public void afterTextChanged(Editable editable) {
            b bVar = this.f8872e;
            if (bVar != null) {
                bVar.afterTextChanged(editable);
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            c cVar = this.f8869b;
            if (cVar != null) {
                cVar.beforeTextChanged(charSequence, i11, i12, i13);
            }
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            d dVar = this.f8870c;
            if (dVar != null) {
                dVar.onTextChanged(charSequence, i11, i12, i13);
            }
            androidx.databinding.d dVar2 = this.f8871d;
            if (dVar2 != null) {
                dVar2.c();
            }
        }
    }

    public interface b {
        void afterTextChanged(Editable editable);
    }

    public interface c {
        void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13);
    }

    public interface d {
        void onTextChanged(CharSequence charSequence, int i11, int i12, int i13);
    }

    public static String a(TextView textView) {
        return textView.getText().toString();
    }

    public static boolean b(CharSequence charSequence, CharSequence charSequence2) {
        if ((charSequence == null) != (charSequence2 == null)) {
            return true;
        }
        if (charSequence == null) {
            return false;
        }
        int length = charSequence.length();
        if (length != charSequence2.length()) {
            return true;
        }
        for (int i11 = 0; i11 < length; i11++) {
            if (charSequence.charAt(i11) != charSequence2.charAt(i11)) {
                return true;
            }
        }
        return false;
    }

    public static void c(TextView textView, CharSequence charSequence) {
        CharSequence text = textView.getText();
        if (charSequence == text) {
            return;
        }
        if (charSequence != null || text.length() != 0) {
            if (charSequence instanceof Spanned) {
                if (charSequence.equals(text)) {
                    return;
                }
            } else if (!b(charSequence, text)) {
                return;
            }
            textView.setText(charSequence);
        }
    }

    public static void d(TextView textView, c cVar, d dVar, b bVar, androidx.databinding.d dVar2) {
        a aVar = (cVar == null && bVar == null && dVar == null && dVar2 == null) ? null : new a(cVar, dVar, dVar2, bVar);
        TextWatcher textWatcher = (TextWatcher) ListenerUtil.a(textView, aVar, R$id.textWatcher);
        if (textWatcher != null) {
            textView.removeTextChangedListener(textWatcher);
        }
        if (aVar != null) {
            textView.addTextChangedListener(aVar);
        }
    }
}
