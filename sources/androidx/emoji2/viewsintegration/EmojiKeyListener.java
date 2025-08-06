package androidx.emoji2.viewsintegration;

import android.text.Editable;
import android.text.method.KeyListener;
import android.view.KeyEvent;
import android.view.View;
import androidx.emoji2.text.EmojiCompat;

public final class EmojiKeyListener implements KeyListener {

    /* renamed from: b  reason: collision with root package name */
    public final KeyListener f9482b;

    /* renamed from: c  reason: collision with root package name */
    public final EmojiCompatHandleKeyDownHelper f9483c;

    public static class EmojiCompatHandleKeyDownHelper {
        public boolean a(Editable editable, int i11, KeyEvent keyEvent) {
            return EmojiCompat.f(editable, i11, keyEvent);
        }
    }

    public EmojiKeyListener(KeyListener keyListener) {
        this(keyListener, new EmojiCompatHandleKeyDownHelper());
    }

    public void clearMetaKeyState(View view, Editable editable, int i11) {
        this.f9482b.clearMetaKeyState(view, editable, i11);
    }

    public int getInputType() {
        return this.f9482b.getInputType();
    }

    public boolean onKeyDown(View view, Editable editable, int i11, KeyEvent keyEvent) {
        return this.f9483c.a(editable, i11, keyEvent) || this.f9482b.onKeyDown(view, editable, i11, keyEvent);
    }

    public boolean onKeyOther(View view, Editable editable, KeyEvent keyEvent) {
        return this.f9482b.onKeyOther(view, editable, keyEvent);
    }

    public boolean onKeyUp(View view, Editable editable, int i11, KeyEvent keyEvent) {
        return this.f9482b.onKeyUp(view, editable, i11, keyEvent);
    }

    public EmojiKeyListener(KeyListener keyListener, EmojiCompatHandleKeyDownHelper emojiCompatHandleKeyDownHelper) {
        this.f9482b = keyListener;
        this.f9483c = emojiCompatHandleKeyDownHelper;
    }
}
