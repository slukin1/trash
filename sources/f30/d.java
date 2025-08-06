package f30;

import android.util.SparseArray;
import zendesk.belvedere.MediaResult;
import zendesk.belvedere.h;

public class d {

    /* renamed from: a  reason: collision with root package name */
    public SparseArray<MediaResult> f60256a = new SparseArray<>();

    public void a(int i11) {
        synchronized (this) {
            this.f60256a.remove(i11);
        }
    }

    public MediaResult b(int i11) {
        MediaResult mediaResult;
        synchronized (this) {
            mediaResult = this.f60256a.get(i11);
        }
        return mediaResult;
    }

    public final int c() {
        for (int i11 = 1600; i11 < 1650; i11++) {
            if (this.f60256a.get(i11) == null) {
                return i11;
            }
        }
        h.a("Belvedere", "No slot free. Clearing registry.");
        this.f60256a.clear();
        return c();
    }

    public int d() {
        int c11;
        synchronized (this) {
            c11 = c();
            this.f60256a.put(c11, MediaResult.empty());
        }
        return c11;
    }

    public void e(int i11, MediaResult mediaResult) {
        synchronized (this) {
            this.f60256a.put(i11, mediaResult);
        }
    }
}
