package com.tencent.thumbplayer.tcmedia.b;

import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaComposition;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.util.ArrayList;
import java.util.List;

public class e extends d implements ITPMediaComposition {

    /* renamed from: a  reason: collision with root package name */
    private int f48983a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f48984b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f48985c = 0;

    /* renamed from: d  reason: collision with root package name */
    private List<ITPMediaTrack> f48986d = new ArrayList(1);

    /* renamed from: e  reason: collision with root package name */
    private List<ITPMediaTrack> f48987e = new ArrayList(1);

    /* renamed from: f  reason: collision with root package name */
    private List<ITPMediaTrack> f48988f = new ArrayList(1);

    private synchronized int d() {
        int i11;
        i11 = this.f48983a + 1;
        this.f48983a = i11;
        return i11;
    }

    private synchronized int e() {
        int i11;
        i11 = this.f48984b + 1;
        this.f48984b = i11;
        return i11;
    }

    private synchronized int f() {
        int i11;
        i11 = this.f48985c + 1;
        this.f48985c = i11;
        return i11;
    }

    public long a() {
        List<ITPMediaTrack> list = this.f48986d;
        long j11 = 0;
        if (list != null) {
            for (ITPMediaTrack next : list) {
                if (j11 < next.getTimelineDurationMs()) {
                    j11 = next.getTimelineDurationMs();
                }
            }
        }
        return j11;
    }

    public synchronized ITPMediaTrack addAVTrack() {
        g gVar;
        gVar = new g(f(), 1);
        this.f48988f.add(gVar);
        return gVar;
    }

    public synchronized ITPMediaTrack addAudioTrack() {
        g gVar;
        gVar = new g(e(), 3);
        this.f48987e.add(gVar);
        return gVar;
    }

    public synchronized ITPMediaTrack addVideoTrack() {
        g gVar;
        gVar = new g(d(), 2);
        this.f48986d.add(gVar);
        return gVar;
    }

    public long b() {
        List<ITPMediaTrack> list = this.f48987e;
        long j11 = 0;
        if (list != null) {
            for (ITPMediaTrack next : list) {
                if (j11 < next.getTimelineDurationMs()) {
                    j11 = next.getTimelineDurationMs();
                }
            }
        }
        return j11;
    }

    public long c() {
        List<ITPMediaTrack> list = this.f48988f;
        long j11 = 0;
        if (list != null) {
            for (ITPMediaTrack next : list) {
                if (j11 < next.getTimelineDurationMs()) {
                    j11 = next.getTimelineDurationMs();
                }
            }
        }
        return j11;
    }

    public List<ITPMediaTrack> getAllAVTracks() {
        return this.f48988f;
    }

    public synchronized List<ITPMediaTrack> getAllAudioTracks() {
        return this.f48987e;
    }

    public synchronized List<ITPMediaTrack> getAllVideoTracks() {
        return this.f48986d;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004e, code lost:
        if (r4 > 0) goto L_0x0050;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long getDurationMs() {
        /*
            r10 = this;
            java.util.List<com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaTrack> r0 = r10.f48988f
            boolean r0 = com.tencent.thumbplayer.tcmedia.utils.b.a((java.util.Collection<? extends java.lang.Object>) r0)
            if (r0 != 0) goto L_0x000d
            long r0 = r10.c()
            return r0
        L_0x000d:
            long r0 = r10.b()
            long r2 = r10.a()
            int r4 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r4 <= 0) goto L_0x001b
            r5 = r2
            goto L_0x001c
        L_0x001b:
            r5 = r0
        L_0x001c:
            java.lang.String r7 = com.tencent.thumbplayer.tcmedia.b.f.f48989a
            r7.hashCode()
            r8 = -1
            int r9 = r7.hashCode()
            switch(r9) {
                case -2046821033: goto L_0x0040;
                case -491658008: goto L_0x0035;
                case -472621683: goto L_0x002a;
                default: goto L_0x0029;
            }
        L_0x0029:
            goto L_0x004a
        L_0x002a:
            java.lang.String r9 = "base_video"
            boolean r7 = r7.equals(r9)
            if (r7 != 0) goto L_0x0033
            goto L_0x004a
        L_0x0033:
            r8 = 2
            goto L_0x004a
        L_0x0035:
            java.lang.String r9 = "base_audio"
            boolean r7 = r7.equals(r9)
            if (r7 != 0) goto L_0x003e
            goto L_0x004a
        L_0x003e:
            r8 = 1
            goto L_0x004a
        L_0x0040:
            java.lang.String r9 = "base_longer"
            boolean r7 = r7.equals(r9)
            if (r7 != 0) goto L_0x0049
            goto L_0x004a
        L_0x0049:
            r8 = 0
        L_0x004a:
            switch(r8) {
                case 0: goto L_0x004e;
                case 1: goto L_0x0051;
                case 2: goto L_0x0050;
                default: goto L_0x004d;
            }
        L_0x004d:
            goto L_0x0052
        L_0x004e:
            if (r4 <= 0) goto L_0x0051
        L_0x0050:
            r0 = r2
        L_0x0051:
            r5 = r0
        L_0x0052:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.thumbplayer.tcmedia.b.e.getDurationMs():long");
    }

    public int getMediaType() {
        return 4;
    }

    public String getUrl() {
        try {
            return i.a((ITPMediaComposition) this);
        } catch (Exception e11) {
            TPLogUtil.e("TPMediaComposition", (Throwable) e11);
            return null;
        }
    }

    public void release() {
        List<ITPMediaTrack> list = this.f48986d;
        if (list != null) {
            list.clear();
            this.f48986d = null;
        }
        List<ITPMediaTrack> list2 = this.f48987e;
        if (list2 != null) {
            list2.clear();
            this.f48987e = null;
        }
        List<ITPMediaTrack> list3 = this.f48988f;
        if (list3 != null) {
            list3.clear();
            this.f48988f = null;
        }
    }

    public boolean removeAVTrack(ITPMediaTrack iTPMediaTrack) {
        if (iTPMediaTrack != null) {
            return this.f48988f.remove(iTPMediaTrack);
        }
        throw new IllegalArgumentException("remove audio track , track is null .");
    }

    public synchronized boolean removeAudioTrack(ITPMediaTrack iTPMediaTrack) {
        if (iTPMediaTrack != null) {
        } else {
            throw new IllegalArgumentException("remove audio track , track is null .");
        }
        return this.f48987e.remove(iTPMediaTrack);
    }

    public synchronized boolean removeVideoTrack(ITPMediaTrack iTPMediaTrack) {
        if (iTPMediaTrack != null) {
        } else {
            throw new IllegalArgumentException("remove video track , track is null .");
        }
        return this.f48986d.remove(iTPMediaTrack);
    }
}
