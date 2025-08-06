package l7;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Message;
import android.text.TextUtils;
import com.hbg.lib.iplayer.common.mediaplayer.PlayStatus;
import com.hbg.lib.iplayer.common.model.PlayItem;
import com.hbg.lib.iplayer.common.util.LogUtil;
import m7.a;

@SuppressLint({"NewApi"})
public class a implements b, a.C0760a {

    /* renamed from: a  reason: collision with root package name */
    public final Context f70100a;

    /* renamed from: b  reason: collision with root package name */
    public PlayItem f70101b;

    /* renamed from: c  reason: collision with root package name */
    public MediaPlayer f70102c;

    /* renamed from: d  reason: collision with root package name */
    public c f70103d;

    /* renamed from: e  reason: collision with root package name */
    public PlayStatus f70104e = PlayStatus.STOPED;

    /* renamed from: f  reason: collision with root package name */
    public boolean f70105f;

    /* renamed from: g  reason: collision with root package name */
    public int f70106g;

    /* renamed from: h  reason: collision with root package name */
    public int f70107h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f70108i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f70109j;

    /* renamed from: k  reason: collision with root package name */
    public int f70110k = 3;

    /* renamed from: l  reason: collision with root package name */
    public m7.a f70111l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f70112m;

    /* renamed from: n  reason: collision with root package name */
    public Uri f70113n;

    /* renamed from: l7.a$a  reason: collision with other inner class name */
    public class C0759a implements MediaPlayer.OnInfoListener {
        public C0759a() {
        }

        public boolean onInfo(MediaPlayer mediaPlayer, int i11, int i12) {
            if (i11 == 3) {
                if (a.this.f70102c != null && a.this.f70102c.isPlaying()) {
                    PlayStatus unused = a.this.f70104e = PlayStatus.PLAYING;
                }
                if (a.this.f70103d != null) {
                    a.this.f70103d.d(i12);
                }
            } else if (i11 == 701) {
                PlayStatus unused2 = a.this.f70104e = PlayStatus.BUFFERRING;
                if (a.this.f70103d != null) {
                    a.this.f70103d.b(i12);
                }
            } else if (i11 == 702) {
                if (a.this.f70104e == PlayStatus.PAUSED) {
                    a.this.d();
                } else if (a.this.f70102c != null && a.this.f70102c.isPlaying()) {
                    PlayStatus unused3 = a.this.f70104e = PlayStatus.PLAYING;
                }
                if (a.this.f70103d != null) {
                    a.this.f70103d.a(i12);
                }
            }
            if (a.this.f70103d != null) {
                return a.this.f70103d.c(i11, i12);
            }
            return false;
        }
    }

    public class b implements MediaPlayer.OnCompletionListener {
        public b() {
        }

        public void onCompletion(MediaPlayer mediaPlayer) {
            a.this.r("onCompletion");
            PlayStatus h11 = a.this.f70104e;
            PlayStatus playStatus = PlayStatus.COMPLETED;
            if (h11 != playStatus) {
                PlayStatus unused = a.this.f70104e = playStatus;
                if (a.this.f70103d != null) {
                    a.this.f70103d.h();
                }
            }
        }
    }

    public class c implements MediaPlayer.OnErrorListener {
        public c() {
        }

        public boolean onError(MediaPlayer mediaPlayer, int i11, int i12) {
            a aVar = a.this;
            aVar.r("onError-->what:" + i11 + " extra:" + i12);
            if (a.this.f70103d != null) {
                return a.this.f70103d.onError(i11, i12);
            }
            return false;
        }
    }

    public class d implements MediaPlayer.OnPreparedListener {
        public d() {
        }

        public void onPrepared(MediaPlayer mediaPlayer) {
            boolean unused = a.this.f70105f = true;
            PlayStatus unused2 = a.this.f70104e = PlayStatus.PREPARED;
            if (a.this.f70103d != null) {
                a.this.f70103d.onPrepared();
            }
        }
    }

    public class e implements MediaPlayer.OnVideoSizeChangedListener {
        public e() {
        }

        public void onVideoSizeChanged(MediaPlayer mediaPlayer, int i11, int i12) {
            if (a.this.f70103d != null) {
                a.this.f70103d.g(i11, i12);
            }
        }
    }

    public a(Context context) {
        this.f70100a = context;
        this.f70111l = new m7.a("DefaultMediaPlayer", this);
    }

    public void a() {
        PlayStatus playStatus;
        r("doPlay");
        if (this.f70102c != null && q() && ((playStatus = this.f70104e) == PlayStatus.PREPARED || playStatus == PlayStatus.PAUSED)) {
            try {
                this.f70102c.start();
                this.f70104e = PlayStatus.PLAYING;
                c cVar = this.f70103d;
                if (cVar != null) {
                    cVar.onPlay();
                }
            } catch (IllegalStateException e11) {
                r("doPlay-->IllegalStateException:" + e11.toString());
                e11.printStackTrace();
            }
        }
        v();
    }

    public void b(PlayItem playItem) {
        this.f70101b = playItem;
        if (this.f70100a != null && playItem != null) {
            Uri uri = playItem.getUri();
            if (uri != null) {
                r("startPlay-->uri:" + uri);
                u(uri);
                return;
            }
            String playUrl = this.f70101b.getPlayUrl();
            if (!TextUtils.isEmpty(playUrl)) {
                r("startPlay-->url:" + playUrl);
                t();
            }
        }
    }

    public PlayStatus c() {
        return this.f70104e;
    }

    public boolean d() {
        MediaPlayer mediaPlayer;
        w();
        r("doPause");
        boolean z11 = false;
        if (this.f70104e == PlayStatus.PLAYING && (mediaPlayer = this.f70102c) != null) {
            try {
                mediaPlayer.pause();
                z11 = true;
                this.f70104e = PlayStatus.PAUSED;
                c cVar = this.f70103d;
                if (cVar != null) {
                    cVar.onPause();
                }
            } catch (IllegalStateException e11) {
                r("doPause-->IllegalStateException:" + e11.toString());
                e11.printStackTrace();
            }
        }
        return z11;
    }

    public void e(int i11) {
        if (i11 < getDuration() && this.f70102c != null) {
            r("doSeek-->targetMsecPosition:" + i11);
            try {
                this.f70102c.seekTo(i11);
            } catch (IllegalStateException e11) {
                r("doSeek-->IllegalStateException:" + e11.toString());
                e11.printStackTrace();
            }
        }
    }

    public void f(c cVar) {
        this.f70103d = cVar;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0051, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void g() {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.w()     // Catch:{ all -> 0x0052 }
            r0 = 0
            r5.f70105f = r0     // Catch:{ all -> 0x0052 }
            boolean r1 = r5.f70108i     // Catch:{ all -> 0x0052 }
            if (r1 == 0) goto L_0x000d
            monitor-exit(r5)
            return
        L_0x000d:
            r1 = 1
            r5.f70108i = r1     // Catch:{ all -> 0x0052 }
            android.media.MediaPlayer r1 = r5.f70102c     // Catch:{ all -> 0x0052 }
            r2 = 0
            if (r1 == 0) goto L_0x0047
            java.lang.String r1 = "gcMediaPlayer"
            r5.r(r1)     // Catch:{ all -> 0x0052 }
            android.media.MediaPlayer r1 = r5.f70102c     // Catch:{ Exception -> 0x0029 }
            r1.reset()     // Catch:{ Exception -> 0x0029 }
            android.media.MediaPlayer r1 = r5.f70102c     // Catch:{ Exception -> 0x0029 }
            r1.release()     // Catch:{ Exception -> 0x0029 }
            com.hbg.lib.iplayer.common.mediaplayer.PlayStatus r1 = com.hbg.lib.iplayer.common.mediaplayer.PlayStatus.STOPED     // Catch:{ Exception -> 0x0029 }
            r5.f70104e = r1     // Catch:{ Exception -> 0x0029 }
            goto L_0x0045
        L_0x0029:
            r1 = move-exception
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0052 }
            r3.<init>()     // Catch:{ all -> 0x0052 }
            java.lang.String r4 = "gcMediaPlayer-->Exception:"
            r3.append(r4)     // Catch:{ all -> 0x0052 }
            java.lang.String r4 = r1.toString()     // Catch:{ all -> 0x0052 }
            r3.append(r4)     // Catch:{ all -> 0x0052 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0052 }
            r5.r(r3)     // Catch:{ all -> 0x0052 }
            r1.printStackTrace()     // Catch:{ all -> 0x0052 }
        L_0x0045:
            r5.f70102c = r2     // Catch:{ all -> 0x0052 }
        L_0x0047:
            r5.f70108i = r0     // Catch:{ all -> 0x0052 }
            m7.a r0 = r5.f70111l     // Catch:{ all -> 0x0052 }
            if (r0 == 0) goto L_0x0050
            r0.removeCallbacksAndMessages(r2)     // Catch:{ all -> 0x0052 }
        L_0x0050:
            monitor-exit(r5)
            return
        L_0x0052:
            r0 = move-exception
            monitor-exit(r5)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: l7.a.g():void");
    }

    public int getDuration() {
        MediaPlayer mediaPlayer;
        int i11 = this.f70106g;
        if (i11 != 0 || (mediaPlayer = this.f70102c) == null) {
            return i11;
        }
        PlayStatus playStatus = this.f70104e;
        if (playStatus != PlayStatus.PLAYING && playStatus != PlayStatus.PAUSED && playStatus != PlayStatus.PREPARED && playStatus != PlayStatus.COMPLETED && playStatus != PlayStatus.BUFFERRING) {
            return i11;
        }
        int duration = mediaPlayer.getDuration();
        this.f70106g = duration;
        return duration;
    }

    public void handleMessage(Message message) {
        m7.a aVar;
        int i11 = message.what;
        if (i11 == 1) {
            n();
        } else if (i11 == 2) {
            x();
            if (this.f70112m && (aVar = this.f70111l) != null) {
                aVar.sendEmptyMessageDelayed(2, 1000);
            }
        }
    }

    public final void n() {
        r("doPrepare");
        this.f70105f = false;
        this.f70104e = PlayStatus.PREPARRING;
        try {
            MediaPlayer mediaPlayer = this.f70102c;
            if (mediaPlayer != null) {
                Uri uri = this.f70113n;
                if (uri != null) {
                    mediaPlayer.setDataSource(this.f70100a, uri);
                } else {
                    String playUrl = this.f70101b.getPlayUrl();
                    PlayItem playItem = this.f70101b;
                    if (playItem == null || playItem.getPlayType() != PlayItem.PlayType.LOCAL) {
                        this.f70102c.setDataSource(this.f70100a, Uri.parse(playUrl));
                    } else {
                        this.f70102c.setDataSource(playUrl);
                    }
                }
                this.f70102c.prepareAsync();
            }
        } catch (Exception e11) {
            e11.printStackTrace();
            r("setDataSource-->error:" + e11.toString());
            c cVar = this.f70103d;
            if (cVar != null) {
                cVar.onError(1, Integer.MIN_VALUE);
            }
        }
    }

    public int o() {
        PlayStatus playStatus;
        MediaPlayer mediaPlayer = this.f70102c;
        if (mediaPlayer != null && ((playStatus = this.f70104e) == PlayStatus.PLAYING || playStatus == PlayStatus.PAUSED || playStatus == PlayStatus.PREPARED || playStatus == PlayStatus.COMPLETED || playStatus == PlayStatus.BUFFERRING)) {
            try {
                this.f70107h = mediaPlayer.getCurrentPosition();
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
        return this.f70107h;
    }

    public final void p() {
        r("initMediaPlayer");
        if (this.f70102c == null) {
            this.f70102c = new MediaPlayer();
            setLooping(this.f70109j);
            this.f70102c.setAudioStreamType(this.f70110k);
            s(1);
            this.f70102c.setOnInfoListener(new C0759a());
            this.f70102c.setOnCompletionListener(new b());
            this.f70102c.setOnErrorListener(new c());
            this.f70102c.setOnPreparedListener(new d());
            this.f70102c.setOnVideoSizeChangedListener(new e());
        }
    }

    public boolean q() {
        return this.f70105f;
    }

    public final void r(String str) {
        LogUtil.a("DefaultMediaPlayer-->" + str);
    }

    public void s(int i11) {
        MediaPlayer mediaPlayer = this.f70102c;
        if (mediaPlayer != null) {
            mediaPlayer.setWakeMode(this.f70100a, i11);
        }
    }

    public void setLooping(boolean z11) {
        this.f70109j = z11;
        MediaPlayer mediaPlayer = this.f70102c;
        if (mediaPlayer != null) {
            mediaPlayer.setLooping(z11);
        }
    }

    public final void t() {
        this.f70107h = 0;
        this.f70106g = 0;
        this.f70105f = false;
        g();
        c cVar = this.f70103d;
        if (cVar != null) {
            cVar.f();
        }
        p();
        m7.a aVar = this.f70111l;
        if (aVar != null) {
            aVar.sendEmptyMessage(1);
        }
        n();
    }

    public void u(Uri uri) {
        this.f70113n = uri;
        r("startPlay-->uri:" + uri);
        if (this.f70113n != null) {
            t();
        }
    }

    public final void v() {
        w();
        this.f70112m = true;
        m7.a aVar = this.f70111l;
        if (aVar != null) {
            aVar.sendEmptyMessage(2);
        }
    }

    public final void w() {
        this.f70112m = false;
        m7.a aVar = this.f70111l;
        if (aVar != null) {
            aVar.removeMessages(2);
        }
    }

    public final void x() {
        c cVar = this.f70103d;
        if (cVar != null) {
            cVar.e(o());
        }
    }
}
