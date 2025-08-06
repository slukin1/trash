package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputConnectionWrapper;
import android.widget.TextView;
import androidx.emoji2.text.EmojiCompat;

public final class EmojiInputConnection extends InputConnectionWrapper {

    /* renamed from: a  reason: collision with root package name */
    public final TextView f9480a;

    /* renamed from: b  reason: collision with root package name */
    public final EmojiCompatDeleteHelper f9481b;

    public static class EmojiCompatDeleteHelper {
        public boolean a(InputConnection inputConnection, Editable editable, int i11, int i12, boolean z11) {
            return EmojiCompat.e(inputConnection, editable, i11, i12, z11);
        }

        public void b(EditorInfo editorInfo) {
            if (EmojiCompat.h()) {
                EmojiCompat.b().u(editorInfo);
            }
        }
    }

    public EmojiInputConnection(TextView textView, InputConnection inputConnection, EditorInfo editorInfo) {
        this(textView, inputConnection, editorInfo, new EmojiCompatDeleteHelper());
    }

    public final Editable a() {
        return this.f9480a.getEditableText();
    }

    public boolean deleteSurroundingText(int i11, int i12) {
        return this.f9481b.a(this, a(), i11, i12, false) || super.deleteSurroundingText(i11, i12);
    }

    public boolean deleteSurroundingTextInCodePoints(int i11, int i12) {
        return this.f9481b.a(this, a(), i11, i12, true) || super.deleteSurroundingTextInCodePoints(i11, i12);
    }

    public EmojiInputConnection(TextView textView, InputConnection inputConnection, EditorInfo editorInfo, EmojiCompatDeleteHelper emojiCompatDeleteHelper) {
        super(inputConnection, false);
        this.f9480a = textView;
        this.f9481b = emojiCompatDeleteHelper;
        emojiCompatDeleteHelper.b(editorInfo);
    }
}
