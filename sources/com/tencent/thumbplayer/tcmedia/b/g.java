package com.tencent.thumbplayer.tcmedia.b;

import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaTrack;
import com.tencent.thumbplayer.tcmedia.api.composition.ITPMediaTrackClip;
import com.tencent.thumbplayer.tcmedia.utils.TPLogUtil;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class g extends d implements ITPMediaTrack, Serializable {

    /* renamed from: a  reason: collision with root package name */
    private int f48993a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f48994b;

    /* renamed from: c  reason: collision with root package name */
    private List<ITPMediaTrackClip> f48995c;

    public g(int i11) {
        this.f48994b = i11;
        this.f48995c = new ArrayList();
    }

    public g(int i11, int i12) {
        this.f48993a = i11;
        this.f48994b = i12;
        this.f48995c = new ArrayList();
    }

    private synchronized void a(ITPMediaTrackClip iTPMediaTrackClip) {
        if (iTPMediaTrackClip != null) {
            try {
                if (iTPMediaTrackClip.getMediaType() != this.f48994b) {
                    throw new IllegalArgumentException("add track clip failed, media type is not same");
                }
            } catch (Throwable th2) {
                throw th2;
            }
        } else {
            throw new IllegalArgumentException("add track clip , clip can not be null");
        }
    }

    public synchronized int addTrackClip(ITPMediaTrackClip iTPMediaTrackClip) {
        a(iTPMediaTrackClip);
        if (this.f48995c.contains(iTPMediaTrackClip)) {
            TPLogUtil.i("TPMediaCompositionTrack", "add track clip failed, clip already exists : " + iTPMediaTrackClip.getClipId());
            return iTPMediaTrackClip.getClipId();
        }
        this.f48995c.add(iTPMediaTrackClip);
        return iTPMediaTrackClip.getClipId();
    }

    public synchronized List<ITPMediaTrackClip> getAllTrackClips() {
        return this.f48995c;
    }

    public synchronized int getMediaType() {
        return this.f48994b;
    }

    public synchronized long getTimelineDurationMs() {
        long j11;
        j11 = 0;
        for (ITPMediaTrackClip originalDurationMs : this.f48995c) {
            j11 += originalDurationMs.getOriginalDurationMs();
        }
        return j11;
    }

    public synchronized ITPMediaTrackClip getTrackClip(int i11) {
        for (ITPMediaTrackClip next : this.f48995c) {
            if (next.getClipId() == i11) {
                return next;
            }
        }
        return null;
    }

    public synchronized int getTrackId() {
        return this.f48993a;
    }

    public synchronized String getUrl() {
        try {
        } catch (IOException e11) {
            TPLogUtil.e("TPMediaCompositionTrack", (Throwable) e11);
            return null;
        }
        return i.a(this.f48995c, this.f48994b);
    }

    public synchronized int insertTrackClip(ITPMediaTrackClip iTPMediaTrackClip, int i11) {
        a(iTPMediaTrackClip);
        if (this.f48995c.contains(iTPMediaTrackClip)) {
            TPLogUtil.i("TPMediaCompositionTrack", "add track clip failed, clip already exists : " + iTPMediaTrackClip.getClipId());
            return iTPMediaTrackClip.getClipId();
        }
        if (i11 == -1) {
            this.f48995c.add(0, iTPMediaTrackClip);
            return iTPMediaTrackClip.getClipId();
        }
        int size = this.f48995c.size();
        for (int i12 = 0; i12 < size; i12++) {
            if (this.f48995c.get(i12).getClipId() == i11) {
                this.f48995c.add(i12 + 1, iTPMediaTrackClip);
                return iTPMediaTrackClip.getClipId();
            }
        }
        this.f48995c.add(iTPMediaTrackClip);
        TPLogUtil.i("TPMediaCompositionTrack", "insert track clip into the end, coz after clip not found :".concat(String.valueOf(i11)));
        return iTPMediaTrackClip.getClipId();
    }

    public synchronized void removeAllTrackClips() {
        this.f48995c.clear();
    }

    public synchronized boolean removeTrackClip(ITPMediaTrackClip iTPMediaTrackClip) {
        if (iTPMediaTrackClip != null) {
        } else {
            throw new IllegalArgumentException("remove track clip , clip can not be null");
        }
        return this.f48995c.remove(iTPMediaTrackClip);
    }

    public synchronized boolean swapTrackClip(int i11, int i12) {
        if (i11 >= 0) {
            if (i11 < this.f48995c.size()) {
                if (i12 >= 0) {
                    if (i12 < this.f48995c.size()) {
                        Collections.swap(this.f48995c, i11, i12);
                        return true;
                    }
                }
                TPLogUtil.w("TPMediaCompositionTrack", "swap clip failed, to pos invalid , to pos :".concat(String.valueOf(i12)));
                return false;
            }
        }
        TPLogUtil.w("TPMediaCompositionTrack", "swap clip failed, from pos invalid , from pos : ".concat(String.valueOf(i11)));
        return false;
    }
}
