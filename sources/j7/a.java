package j7;

import android.content.Context;
import com.hbg.lib.iplayer.audio.AudioPlayerConfig;
import com.hbg.lib.iplayer.common.model.PlayItem;
import com.hbg.lib.iplayer.common.util.LogUtil;
import l7.b;
import l7.c;

public class a extends k7.a {

    /* renamed from: m  reason: collision with root package name */
    public AudioPlayerConfig f70084m;

    /* renamed from: j7.a$a  reason: collision with other inner class name */
    public class C0757a implements c {
        public C0757a() {
        }

        public void a(int i11) {
            if (a.this.f70093h != null) {
                a.this.f70093h.a(i11);
            }
        }

        public void b(int i11) {
            if (a.this.f70093h != null) {
                a.this.f70093h.b(i11);
            }
        }

        public boolean c(int i11, int i12) {
            if (a.this.f70093h == null) {
                return false;
            }
            a.this.f70093h.c(i11, i12);
            return false;
        }

        public void d(int i11) {
            if (a.this.f70093h != null) {
                a.this.f70093h.d(i11);
            }
        }

        public void e(int i11) {
            if (a.this.f70093h != null) {
                a.this.f70093h.e(i11);
            }
        }

        public void f() {
            if (a.this.f70093h != null) {
                a.this.f70093h.f();
            }
        }

        public void g(int i11, int i12) {
            if (a.this.f70093h != null) {
                a.this.f70093h.g(i11, i12);
            }
        }

        public void h() {
            if (a.this.f70093h != null) {
                a.this.f70093h.h();
            }
        }

        public boolean onError(int i11, int i12) {
            if (a.this.f70093h == null) {
                return false;
            }
            a.this.f70093h.onError(i11, i12);
            return false;
        }

        public void onPause() {
            if (a.this.f70093h != null) {
                a.this.f70093h.onPause();
            }
        }

        public void onPlay() {
            if (a.this.f70093h != null) {
                a.this.f70093h.onPlay();
            }
        }

        public void onPrepared() {
            if (a.this.f70088c != null) {
                int r11 = a.this.r();
                a aVar = a.this;
                aVar.v("onPrepared-->duration:" + r11);
                a.this.a();
                if (a.this.f70087b != null) {
                    a.this.f70087b.setDuration((long) r11);
                    int startPostion = a.this.f70087b.getStartPostion();
                    a aVar2 = a.this;
                    aVar2.v("onPrepared-->startPostion:" + startPostion);
                    if (startPostion > 0) {
                        a.this.p(startPostion);
                        a.this.f70087b.setStartPostion(0);
                    }
                }
                if (!a.this.m()) {
                    a.this.d();
                }
            }
            if (a.this.f70093h != null) {
                a.this.f70093h.onPrepared();
            }
        }
    }

    public a(Context context, AudioPlayerConfig audioPlayerConfig) {
        super(context);
        this.f70084m = audioPlayerConfig;
        g0();
    }

    public void b(PlayItem playItem) {
        this.f70087b = playItem;
        f0();
    }

    public final void f0() {
        PlayItem playItem = this.f70087b;
        if (playItem != null) {
            n(playItem);
            h0();
        }
    }

    public final void g0() {
        AudioPlayerConfig audioPlayerConfig = this.f70084m;
        if (audioPlayerConfig != null && audioPlayerConfig.a()) {
            s();
        }
        AudioPlayerConfig audioPlayerConfig2 = this.f70084m;
        if (audioPlayerConfig2 != null && audioPlayerConfig2.b()) {
            u();
        }
    }

    public final void h0() {
        b bVar = this.f70088c;
        if (bVar != null) {
            bVar.b(this.f70087b);
        }
    }

    public b t() {
        if (this.f70088c != null) {
            return null;
        }
        l7.a aVar = new l7.a(this.f70086a);
        this.f70088c = aVar;
        aVar.f(new C0757a());
        return null;
    }

    public void v(String str) {
        LogUtil.a("AudioPlayController-->" + str);
    }
}
