package l1;

import android.os.Build;
import android.text.method.KeyListener;
import android.text.method.NumberKeyListener;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.EditText;
import androidx.core.util.h;
import androidx.emoji2.viewsintegration.EmojiInputConnection;
import androidx.emoji2.viewsintegration.EmojiKeyListener;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public final b f16048a;

    /* renamed from: b  reason: collision with root package name */
    public int f16049b = Integer.MAX_VALUE;

    /* renamed from: c  reason: collision with root package name */
    public int f16050c = 0;

    /* renamed from: l1.a$a  reason: collision with other inner class name */
    public static class C0088a extends b {

        /* renamed from: a  reason: collision with root package name */
        public final EditText f16051a;

        /* renamed from: b  reason: collision with root package name */
        public final e f16052b;

        public C0088a(EditText editText, boolean z11) {
            this.f16051a = editText;
            e eVar = new e(editText, z11);
            this.f16052b = eVar;
            editText.addTextChangedListener(eVar);
            editText.setEditableFactory(b.getInstance());
        }

        public KeyListener a(KeyListener keyListener) {
            if (keyListener instanceof EmojiKeyListener) {
                return keyListener;
            }
            if (keyListener == null) {
                return null;
            }
            if (keyListener instanceof NumberKeyListener) {
                return keyListener;
            }
            return new EmojiKeyListener(keyListener);
        }

        public boolean b() {
            return this.f16052b.b();
        }

        public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
            if (inputConnection instanceof EmojiInputConnection) {
                return inputConnection;
            }
            return new EmojiInputConnection(this.f16051a, inputConnection, editorInfo);
        }

        public void d(boolean z11) {
            this.f16052b.d(z11);
        }
    }

    public static class b {
        public KeyListener a(KeyListener keyListener) {
            return keyListener;
        }

        public boolean b() {
            return false;
        }

        public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
            return inputConnection;
        }

        public void d(boolean z11) {
        }
    }

    public a(EditText editText, boolean z11) {
        h.h(editText, "editText cannot be null");
        if (Build.VERSION.SDK_INT < 19) {
            this.f16048a = new b();
        } else {
            this.f16048a = new C0088a(editText, z11);
        }
    }

    public KeyListener a(KeyListener keyListener) {
        return this.f16048a.a(keyListener);
    }

    public boolean b() {
        return this.f16048a.b();
    }

    public InputConnection c(InputConnection inputConnection, EditorInfo editorInfo) {
        if (inputConnection == null) {
            return null;
        }
        return this.f16048a.c(inputConnection, editorInfo);
    }

    public void d(boolean z11) {
        this.f16048a.d(z11);
    }
}
