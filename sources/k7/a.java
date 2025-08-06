package k7;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import com.hbg.lib.iplayer.common.mediaplayer.PlayStatus;
import com.hbg.lib.iplayer.common.model.PlayItem;
import com.hbg.lib.iplayer.common.util.PlayerUtil;
import m7.b;
import m7.c;

public abstract class a implements c {

    /* renamed from: a  reason: collision with root package name */
    public final Context f70086a;

    /* renamed from: b  reason: collision with root package name */
    public PlayItem f70087b;

    /* renamed from: c  reason: collision with root package name */
    public l7.b f70088c;

    /* renamed from: d  reason: collision with root package name */
    public m7.b f70089d;

    /* renamed from: e  reason: collision with root package name */
    public c f70090e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f70091f;

    /* renamed from: g  reason: collision with root package name */
    public b f70092g;

    /* renamed from: h  reason: collision with root package name */
    public l7.c f70093h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f70094i;

    /* renamed from: j  reason: collision with root package name */
    public b.C0761b f70095j;

    /* renamed from: k  reason: collision with root package name */
    public c.b f70096k;

    /* renamed from: l  reason: collision with root package name */
    public boolean f70097l;

    /* renamed from: k7.a$a  reason: collision with other inner class name */
    public class C0758a implements b.C0761b {
        public C0758a() {
        }

        public void a() {
            a.this.v("initAudioFocusListener-->onAudioFocusLossTransient");
            boolean unused = a.this.f70097l = true;
            a.this.o(false);
            if (a.this.f70095j != null) {
                a.this.f70095j.a();
            }
        }

        public void b() {
            a.this.v("initAudioFocusListener-->onAudioFocusGain");
            if (a.this.m() && a.this.f70097l) {
                boolean unused = a.this.f70097l = false;
                a.this.a();
            }
            if (a.this.f70095j != null) {
                a.this.f70095j.b();
            }
        }

        public void c() {
            a.this.v("initAudioFocusListener-->onAudioFocusLossTransientCanDuck");
            boolean unused = a.this.f70097l = true;
            if (a.this.f70095j != null) {
                a.this.f70095j.c();
            }
        }

        public void d() {
            a.this.v("initAudioFocusListener-->onAudioFocusLoss");
            boolean unused = a.this.f70097l = false;
            a.this.d();
            if (a.this.f70095j != null) {
                a.this.f70095j.d();
            }
        }
    }

    public class b implements c.b {
        public b() {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            if (a.this.f70096k != null) {
                return a.this.f70096k.onMediaButtonEvent(intent);
            }
            return false;
        }

        public void onPause() {
            a.this.v("initMediaSessionListener-->onPause");
            a.this.B();
            if (a.this.f70096k != null) {
                a.this.f70096k.onPause();
            }
        }

        public void onPlay() {
            a.this.v("initMediaSessionListener-->onPlay");
            a.this.B();
            if (a.this.f70096k != null) {
                a.this.f70096k.onPlay();
            }
        }

        public void onSkipToNext() {
            a.this.v("initMediaSessionListener-->onSkipToNext");
            if (a.this.f70096k != null) {
                a.this.f70096k.onSkipToNext();
            }
        }

        public void onSkipToPrevious() {
            a.this.v("initMediaSessionListener-->onSkipToPrevious");
            if (a.this.f70096k != null) {
                a.this.f70096k.onSkipToPrevious();
            }
        }
    }

    public a(Context context) {
        this.f70086a = context;
    }

    public void A(Uri uri) {
        b(new PlayItem(uri));
    }

    public final void B() {
        if (c() == PlayStatus.PLAYING) {
            this.f70091f = true;
            d();
        } else if (c() == PlayStatus.PAUSED) {
            this.f70091f = false;
            a();
        }
    }

    public boolean a() {
        l7.b bVar;
        if (!z() || (bVar = this.f70088c) == null) {
            return false;
        }
        bVar.a();
        return true;
    }

    public PlayStatus c() {
        l7.b bVar = this.f70088c;
        if (bVar != null) {
            return bVar.c();
        }
        return PlayStatus.STOPED;
    }

    public void d() {
        o(true);
    }

    public void e(String str) {
        b(new PlayItem(str));
    }

    public int f() {
        m7.b bVar = this.f70089d;
        if (bVar != null) {
            return bVar.c();
        }
        return 0;
    }

    public void g(int i11) {
        A(Uri.parse("android.resource://" + this.f70086a.getPackageName() + "/" + i11));
    }

    public boolean m() {
        return !this.f70091f;
    }

    public void n(PlayItem playItem) {
        b bVar = this.f70092g;
        if (bVar == null || !bVar.a(this, playItem)) {
            t();
            setLooping(this.f70094i);
            if (playItem != null) {
                playItem.setPlayType(PlayerUtil.a(playItem.getPlayUrl()));
                return;
            }
            return;
        }
        setLooping(this.f70094i);
    }

    public void o(boolean z11) {
        l7.b bVar = this.f70088c;
        if (bVar != null) {
            bVar.d();
        }
        if (z11) {
            w();
        }
    }

    public void p(int i11) {
        l7.b bVar = this.f70088c;
        if (bVar != null) {
            bVar.e(i11);
        }
    }

    public void q() {
        l7.b bVar = this.f70088c;
        if (bVar != null) {
            bVar.g();
        }
    }

    public int r() {
        l7.b bVar = this.f70088c;
        if (bVar != null) {
            return bVar.getDuration();
        }
        return 0;
    }

    public void release() {
        v("release");
        q();
        w();
        x();
        this.f70087b = null;
    }

    public void s() {
        m7.b bVar = new m7.b(this.f70086a);
        this.f70089d = bVar;
        bVar.h(new C0758a());
    }

    public void setLooping(boolean z11) {
        this.f70094i = z11;
        l7.b bVar = this.f70088c;
        if (bVar != null) {
            bVar.setLooping(z11);
        }
    }

    public void setVolume(int i11) {
        m7.b bVar = this.f70089d;
        if (bVar != null) {
            bVar.i(i11);
        }
    }

    public abstract l7.b t();

    public void u() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("initMediaSessionListener-->");
        int i11 = Build.VERSION.SDK_INT;
        sb2.append(i11);
        v(sb2.toString());
        if (i11 >= 21) {
            c cVar = new c(this.f70086a);
            this.f70090e = cVar;
            cVar.c();
            this.f70090e.e(new b());
        }
    }

    public abstract void v(String str);

    public boolean w() {
        m7.b bVar = this.f70089d;
        if (bVar != null) {
            return bVar.a();
        }
        return false;
    }

    public final void x() {
        y();
        c cVar = this.f70090e;
        if (cVar != null) {
            cVar.d();
        }
    }

    public void y() {
        c cVar = this.f70090e;
        if (cVar != null) {
            cVar.f();
        }
    }

    public boolean z() {
        m7.b bVar = this.f70089d;
        if (bVar == null) {
            return true;
        }
        boolean g11 = bVar.g();
        v("requestAudioFocus-->result:" + g11);
        return g11;
    }
}
