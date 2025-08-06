package com.opensource.svgaplayer;

import android.media.SoundPool;
import ay.b;
import java.io.FileDescriptor;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0017B\t\b\u0002¢\u0006\u0004\b%\u0010&J\u000f\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b\u0003\u0010\u0004J;\u0010\u000e\u001a\u00020\f2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\b\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\fH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\fH\u0000¢\u0006\u0004\b\u0016\u0010\u0013J\b\u0010\u0017\u001a\u00020\u0002H\u0002R\u001c\u0010\u001b\u001a\n \u0019*\u0004\u0018\u00010\u00180\u00188\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0017\u0010\u001aR\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0003\u0010\u001dR \u0010!\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00050\u001f8\u0002X\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010 R\u0016\u0010$\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0014\u0010#¨\u0006'"}, d2 = {"Lcom/opensource/svgaplayer/g;", "", "", "b", "()Z", "Lcom/opensource/svgaplayer/g$a;", "callBack", "Ljava/io/FileDescriptor;", "fd", "", "offset", "length", "", "priority", "c", "(Lcom/opensource/svgaplayer/g$a;Ljava/io/FileDescriptor;JJI)I", "soundId", "", "f", "(I)V", "d", "(I)I", "e", "a", "", "kotlin.jvm.PlatformType", "Ljava/lang/String;", "TAG", "Landroid/media/SoundPool;", "Landroid/media/SoundPool;", "soundPool", "", "Ljava/util/Map;", "soundCallBackMap", "", "F", "volume", "<init>", "()V", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final String f28604a = g.class.getSimpleName();

    /* renamed from: b  reason: collision with root package name */
    public static SoundPool f28605b;

    /* renamed from: c  reason: collision with root package name */
    public static final Map<Integer, a> f28606c = new LinkedHashMap();

    /* renamed from: d  reason: collision with root package name */
    public static float f28607d = 1.0f;

    /* renamed from: e  reason: collision with root package name */
    public static final g f28608e = new g();

    @Metadata(bv = {}, d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b`\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/opensource/svgaplayer/g$a;", "", "com.opensource.svgaplayer"}, k = 1, mv = {1, 4, 0})
    public interface a {
    }

    public final boolean a() {
        boolean b11 = b();
        if (!b11) {
            b.f26389a.b(f28604a, "soundPool is null, you need call init() !!!");
        }
        return b11;
    }

    public final boolean b() {
        return f28605b != null;
    }

    public final int c(a aVar, FileDescriptor fileDescriptor, long j11, long j12, int i11) {
        if (!a()) {
            return -1;
        }
        SoundPool soundPool = f28605b;
        if (soundPool == null) {
            x.j();
        }
        int load = soundPool.load(fileDescriptor, j11, j12, i11);
        b bVar = b.f26389a;
        String str = f28604a;
        bVar.a(str, "load soundId=" + load + " callBack=" + aVar);
        if (aVar != null) {
            Map<Integer, a> map = f28606c;
            if (!map.containsKey(Integer.valueOf(load))) {
                map.put(Integer.valueOf(load), aVar);
            }
        }
        return load;
    }

    public final int d(int i11) {
        if (!a()) {
            return -1;
        }
        b bVar = b.f26389a;
        String str = f28604a;
        bVar.a(str, "play soundId=" + i11);
        SoundPool soundPool = f28605b;
        if (soundPool == null) {
            x.j();
        }
        float f11 = f28607d;
        return soundPool.play(i11, f11, f11, 1, 0, 1.0f);
    }

    public final void e(int i11) {
        if (a()) {
            b bVar = b.f26389a;
            String str = f28604a;
            bVar.a(str, "stop soundId=" + i11);
            SoundPool soundPool = f28605b;
            if (soundPool == null) {
                x.j();
            }
            soundPool.stop(i11);
        }
    }

    public final void f(int i11) {
        if (a()) {
            b bVar = b.f26389a;
            String str = f28604a;
            bVar.a(str, "unload soundId=" + i11);
            SoundPool soundPool = f28605b;
            if (soundPool == null) {
                x.j();
            }
            soundPool.unload(i11);
            f28606c.remove(Integer.valueOf(i11));
        }
    }
}
