package m7;

import android.content.Context;
import android.media.AudioManager;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public final Context f70120a;

    /* renamed from: b  reason: collision with root package name */
    public AudioManager f70121b;

    /* renamed from: c  reason: collision with root package name */
    public AudioManager.OnAudioFocusChangeListener f70122c;

    /* renamed from: d  reason: collision with root package name */
    public C0761b f70123d;

    public class a implements AudioManager.OnAudioFocusChangeListener {
        public a() {
        }

        public void onAudioFocusChange(int i11) {
            if (i11 != -3) {
                if (i11 != -2) {
                    if (i11 != -1) {
                        if (i11 == 1 && b.this.f70123d != null) {
                            b.this.f70123d.b();
                        }
                    } else if (b.this.f70123d != null) {
                        b.this.f70123d.d();
                    }
                } else if (b.this.f70123d != null) {
                    b.this.f70123d.a();
                }
            } else if (b.this.f70123d != null) {
                b.this.f70123d.c();
            }
        }
    }

    /* renamed from: m7.b$b  reason: collision with other inner class name */
    public interface C0761b {
        void a();

        void b();

        void c();

        void d();
    }

    public b(Context context) {
        this.f70120a = context;
        e();
    }

    public boolean a() {
        return 1 == this.f70121b.abandonAudioFocus(this.f70122c);
    }

    public int c() {
        return this.f70121b.getStreamVolume(3);
    }

    public int d() {
        return this.f70121b.getStreamMaxVolume(3);
    }

    public final void e() {
        this.f70121b = (AudioManager) this.f70120a.getApplicationContext().getSystemService("audio");
        f();
    }

    public final void f() {
        if (this.f70122c == null) {
            this.f70122c = new a();
        }
    }

    public boolean g() {
        if (1 == this.f70121b.requestAudioFocus(this.f70122c, 3, 1)) {
            return true;
        }
        return false;
    }

    public void h(C0761b bVar) {
        this.f70123d = bVar;
    }

    public void i(int i11) {
        if (i11 >= 0 && i11 <= d()) {
            this.f70121b.setStreamVolume(3, i11, 1024);
        }
    }
}
