package m7;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.media.session.MediaSession;
import android.media.session.PlaybackState;
import android.os.SystemClock;

@SuppressLint({"NewApi"})
public class c {

    /* renamed from: a  reason: collision with root package name */
    public MediaSession f70125a;

    /* renamed from: b  reason: collision with root package name */
    public b f70126b;

    /* renamed from: c  reason: collision with root package name */
    public String f70127c = "MediaSessionManager";

    /* renamed from: d  reason: collision with root package name */
    public final Context f70128d;

    public class a extends MediaSession.Callback {
        public a() {
        }

        public boolean onMediaButtonEvent(Intent intent) {
            if (c.this.f70126b != null) {
                c.this.f70126b.onMediaButtonEvent(intent);
            }
            return super.onMediaButtonEvent(intent);
        }

        public void onPause() {
            super.onPause();
            if (c.this.f70126b != null) {
                c.this.f70126b.onPause();
            }
            c.this.b(2);
        }

        public void onPlay() {
            super.onPlay();
            if (c.this.f70126b != null) {
                c.this.f70126b.onPlay();
            }
            c.this.b(3);
        }

        public void onSkipToNext() {
            super.onSkipToNext();
            if (c.this.f70126b != null) {
                c.this.f70126b.onSkipToNext();
            }
        }

        public void onSkipToPrevious() {
            super.onSkipToPrevious();
            if (c.this.f70126b != null) {
                c.this.f70126b.onSkipToPrevious();
            }
        }
    }

    public interface b {
        boolean onMediaButtonEvent(Intent intent);

        void onPause();

        void onPlay();

        void onSkipToNext();

        void onSkipToPrevious();
    }

    public c(Context context) {
        this.f70128d = context;
    }

    public void b(int i11) {
        if (this.f70125a != null) {
            this.f70125a.setPlaybackState(new PlaybackState.Builder().setActions(567).setState(i11, -1, (float) SystemClock.elapsedRealtime()).build());
        }
    }

    public void c() {
        MediaSession mediaSession = new MediaSession(this.f70128d, this.f70127c);
        this.f70125a = mediaSession;
        mediaSession.setCallback(new a());
        this.f70125a.setFlags(3);
        b(1);
    }

    public void d() {
        MediaSession mediaSession = this.f70125a;
        if (mediaSession != null) {
            mediaSession.release();
            this.f70125a = null;
        }
    }

    public void e(b bVar) {
        this.f70126b = bVar;
    }

    public void f() {
        MediaSession mediaSession = this.f70125a;
        if (mediaSession != null) {
            mediaSession.setActive(false);
        }
    }
}
