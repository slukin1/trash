package i7;

import android.content.Context;
import com.hbg.lib.iplayer.audio.AudioPlayerConfig;
import k7.c;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f70081a;

    /* renamed from: b  reason: collision with root package name */
    public c f70082b;

    /* renamed from: c  reason: collision with root package name */
    public AudioPlayerConfig f70083c;

    public a(Context context) {
        b(context, (AudioPlayerConfig) null, (c) null);
    }

    public c a() {
        return this.f70082b;
    }

    public final void b(Context context, AudioPlayerConfig audioPlayerConfig, c cVar) {
        this.f70081a = context;
        this.f70083c = audioPlayerConfig;
        if (audioPlayerConfig == null) {
            this.f70083c = new AudioPlayerConfig();
        }
        if (cVar == null) {
            this.f70082b = new j7.a(this.f70081a, this.f70083c);
        }
    }
}
