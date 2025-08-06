package androidx.emoji2.text;

import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.Editable;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import androidx.collection.ArraySet;
import androidx.core.util.h;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import k1.j;

public class EmojiCompat {

    /* renamed from: n  reason: collision with root package name */
    public static final Object f9369n = new Object();

    /* renamed from: o  reason: collision with root package name */
    public static final Object f9370o = new Object();

    /* renamed from: p  reason: collision with root package name */
    public static volatile EmojiCompat f9371p;

    /* renamed from: a  reason: collision with root package name */
    public final ReadWriteLock f9372a = new ReentrantReadWriteLock();

    /* renamed from: b  reason: collision with root package name */
    public final Set<InitCallback> f9373b;

    /* renamed from: c  reason: collision with root package name */
    public volatile int f9374c = 3;

    /* renamed from: d  reason: collision with root package name */
    public final Handler f9375d;

    /* renamed from: e  reason: collision with root package name */
    public final b f9376e;

    /* renamed from: f  reason: collision with root package name */
    public final f f9377f;

    /* renamed from: g  reason: collision with root package name */
    public final boolean f9378g;

    /* renamed from: h  reason: collision with root package name */
    public final boolean f9379h;

    /* renamed from: i  reason: collision with root package name */
    public final int[] f9380i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f9381j;

    /* renamed from: k  reason: collision with root package name */
    public final int f9382k;

    /* renamed from: l  reason: collision with root package name */
    public final int f9383l;

    /* renamed from: m  reason: collision with root package name */
    public final d f9384m;

    public static abstract class InitCallback {
        public void a(Throwable th2) {
        }

        public void b() {
        }
    }

    public static abstract class MetadataRepoLoaderCallback {
        public abstract void a(Throwable th2);

        public abstract void b(c cVar);
    }

    public static final class a extends b {

        /* renamed from: b  reason: collision with root package name */
        public volatile b f9385b;

        /* renamed from: c  reason: collision with root package name */
        public volatile c f9386c;

        /* renamed from: androidx.emoji2.text.EmojiCompat$a$a  reason: collision with other inner class name */
        public class C0038a extends MetadataRepoLoaderCallback {
            public C0038a() {
            }

            public void a(Throwable th2) {
                a.this.f9388a.m(th2);
            }

            public void b(c cVar) {
                a.this.d(cVar);
            }
        }

        public a(EmojiCompat emojiCompat) {
            super(emojiCompat);
        }

        public void a() {
            try {
                this.f9388a.f9377f.a(new C0038a());
            } catch (Throwable th2) {
                this.f9388a.m(th2);
            }
        }

        public CharSequence b(CharSequence charSequence, int i11, int i12, int i13, boolean z11) {
            return this.f9385b.h(charSequence, i11, i12, i13, z11);
        }

        public void c(EditorInfo editorInfo) {
            editorInfo.extras.putInt("android.support.text.emoji.emojiCompat_metadataVersion", this.f9386c.e());
            editorInfo.extras.putBoolean("android.support.text.emoji.emojiCompat_replaceAll", this.f9388a.f9378g);
        }

        public void d(c cVar) {
            if (cVar == null) {
                this.f9388a.m(new IllegalArgumentException("metadataRepo cannot be null"));
                return;
            }
            this.f9386c = cVar;
            c cVar2 = this.f9386c;
            g gVar = new g();
            d a11 = this.f9388a.f9384m;
            EmojiCompat emojiCompat = this.f9388a;
            this.f9385b = new b(cVar2, gVar, a11, emojiCompat.f9379h, emojiCompat.f9380i);
            this.f9388a.n();
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final EmojiCompat f9388a;

        public b(EmojiCompat emojiCompat) {
            this.f9388a = emojiCompat;
        }

        public void a() {
            this.f9388a.n();
        }

        public CharSequence b(CharSequence charSequence, int i11, int i12, int i13, boolean z11) {
            return charSequence;
        }

        public void c(EditorInfo editorInfo) {
        }
    }

    public static abstract class c {

        /* renamed from: a  reason: collision with root package name */
        public final f f9389a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f9390b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f9391c;

        /* renamed from: d  reason: collision with root package name */
        public int[] f9392d;

        /* renamed from: e  reason: collision with root package name */
        public Set<InitCallback> f9393e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f9394f;

        /* renamed from: g  reason: collision with root package name */
        public int f9395g = -16711936;

        /* renamed from: h  reason: collision with root package name */
        public int f9396h = 0;

        /* renamed from: i  reason: collision with root package name */
        public d f9397i = new a();

        public c(f fVar) {
            h.h(fVar, "metadataLoader cannot be null.");
            this.f9389a = fVar;
        }

        public final f a() {
            return this.f9389a;
        }

        public c b(int i11) {
            this.f9396h = i11;
            return this;
        }
    }

    public interface d {
        boolean a(CharSequence charSequence, int i11, int i12, int i13);
    }

    public static class e implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final List<InitCallback> f9398b;

        /* renamed from: c  reason: collision with root package name */
        public final Throwable f9399c;

        /* renamed from: d  reason: collision with root package name */
        public final int f9400d;

        public e(InitCallback initCallback, int i11) {
            this(Arrays.asList(new InitCallback[]{(InitCallback) h.h(initCallback, "initCallback cannot be null")}), i11, (Throwable) null);
        }

        public void run() {
            int size = this.f9398b.size();
            int i11 = 0;
            if (this.f9400d != 1) {
                while (i11 < size) {
                    this.f9398b.get(i11).a(this.f9399c);
                    i11++;
                }
                return;
            }
            while (i11 < size) {
                this.f9398b.get(i11).b();
                i11++;
            }
        }

        public e(Collection<InitCallback> collection, int i11) {
            this(collection, i11, (Throwable) null);
        }

        public e(Collection<InitCallback> collection, int i11, Throwable th2) {
            h.h(collection, "initCallbacks cannot be null");
            this.f9398b = new ArrayList(collection);
            this.f9400d = i11;
            this.f9399c = th2;
        }
    }

    public interface f {
        void a(MetadataRepoLoaderCallback metadataRepoLoaderCallback);
    }

    public static class g {
        public k1.e a(k1.d dVar) {
            return new j(dVar);
        }
    }

    public EmojiCompat(c cVar) {
        this.f9378g = cVar.f9390b;
        this.f9379h = cVar.f9391c;
        this.f9380i = cVar.f9392d;
        this.f9381j = cVar.f9394f;
        this.f9382k = cVar.f9395g;
        this.f9377f = cVar.f9389a;
        this.f9383l = cVar.f9396h;
        this.f9384m = cVar.f9397i;
        this.f9375d = new Handler(Looper.getMainLooper());
        ArraySet arraySet = new ArraySet();
        this.f9373b = arraySet;
        Set<InitCallback> set = cVar.f9393e;
        if (set != null && !set.isEmpty()) {
            arraySet.addAll(cVar.f9393e);
        }
        this.f9376e = Build.VERSION.SDK_INT < 19 ? new b(this) : new a(this);
        l();
    }

    public static EmojiCompat b() {
        EmojiCompat emojiCompat;
        synchronized (f9369n) {
            emojiCompat = f9371p;
            h.j(emojiCompat != null, "EmojiCompat is not initialized.\n\nYou must initialize EmojiCompat prior to referencing the EmojiCompat instance.\n\nThe most likely cause of this error is disabling the EmojiCompatInitializer\neither explicitly in AndroidManifest.xml, or by including\nandroidx.emoji2:emoji2-bundled.\n\nAutomatic initialization is typically performed by EmojiCompatInitializer. If\nyou are not expecting to initialize EmojiCompat manually in your application,\nplease check to ensure it has not been removed from your APK's manifest. You can\ndo this in Android Studio using Build > Analyze APK.\n\nIn the APK Analyzer, ensure that the startup entry for\nEmojiCompatInitializer and InitializationProvider is present in\n AndroidManifest.xml. If it is missing or contains tools:node=\"remove\", and you\nintend to use automatic configuration, verify:\n\n  1. Your application does not include emoji2-bundled\n  2. All modules do not contain an exclusion manifest rule for\n     EmojiCompatInitializer or InitializationProvider. For more information\n     about manifest exclusions see the documentation for the androidx startup\n     library.\n\nIf you intend to use emoji2-bundled, please call EmojiCompat.init. You can\nlearn more in the documentation for BundledEmojiCompatConfig.\n\nIf you intended to perform manual configuration, it is recommended that you call\nEmojiCompat.init immediately on application startup.\n\nIf you still cannot resolve this issue, please open a bug with your specific\nconfiguration to help improve error message.");
        }
        return emojiCompat;
    }

    public static boolean e(InputConnection inputConnection, Editable editable, int i11, int i12, boolean z11) {
        if (Build.VERSION.SDK_INT >= 19) {
            return b.c(inputConnection, editable, i11, i12, z11);
        }
        return false;
    }

    public static boolean f(Editable editable, int i11, KeyEvent keyEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return b.d(editable, i11, keyEvent);
        }
        return false;
    }

    public static EmojiCompat g(c cVar) {
        EmojiCompat emojiCompat = f9371p;
        if (emojiCompat == null) {
            synchronized (f9369n) {
                emojiCompat = f9371p;
                if (emojiCompat == null) {
                    emojiCompat = new EmojiCompat(cVar);
                    f9371p = emojiCompat;
                }
            }
        }
        return emojiCompat;
    }

    public static boolean h() {
        return f9371p != null;
    }

    public int c() {
        return this.f9382k;
    }

    public int d() {
        this.f9372a.readLock().lock();
        try {
            return this.f9374c;
        } finally {
            this.f9372a.readLock().unlock();
        }
    }

    public boolean i() {
        return this.f9381j;
    }

    public final boolean j() {
        return d() == 1;
    }

    public void k() {
        boolean z11 = true;
        if (this.f9383l != 1) {
            z11 = false;
        }
        h.j(z11, "Set metadataLoadStrategy to LOAD_STRATEGY_MANUAL to execute manual loading");
        if (!j()) {
            this.f9372a.writeLock().lock();
            try {
                if (this.f9374c != 0) {
                    this.f9374c = 0;
                    this.f9372a.writeLock().unlock();
                    this.f9376e.a();
                }
            } finally {
                this.f9372a.writeLock().unlock();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    public final void l() {
        this.f9372a.writeLock().lock();
        try {
            if (this.f9383l == 0) {
                this.f9374c = 0;
            }
            this.f9372a.writeLock().unlock();
            if (d() == 0) {
                this.f9376e.a();
            }
        } catch (Throwable th2) {
            this.f9372a.writeLock().unlock();
            throw th2;
        }
    }

    /* JADX INFO: finally extract failed */
    public void m(Throwable th2) {
        ArrayList arrayList = new ArrayList();
        this.f9372a.writeLock().lock();
        try {
            this.f9374c = 2;
            arrayList.addAll(this.f9373b);
            this.f9373b.clear();
            this.f9372a.writeLock().unlock();
            this.f9375d.post(new e(arrayList, this.f9374c, th2));
        } catch (Throwable th3) {
            this.f9372a.writeLock().unlock();
            throw th3;
        }
    }

    /* JADX INFO: finally extract failed */
    public void n() {
        ArrayList arrayList = new ArrayList();
        this.f9372a.writeLock().lock();
        try {
            this.f9374c = 1;
            arrayList.addAll(this.f9373b);
            this.f9373b.clear();
            this.f9372a.writeLock().unlock();
            this.f9375d.post(new e((Collection<InitCallback>) arrayList, this.f9374c));
        } catch (Throwable th2) {
            this.f9372a.writeLock().unlock();
            throw th2;
        }
    }

    public CharSequence o(CharSequence charSequence) {
        return p(charSequence, 0, charSequence == null ? 0 : charSequence.length());
    }

    public CharSequence p(CharSequence charSequence, int i11, int i12) {
        return q(charSequence, i11, i12, Integer.MAX_VALUE);
    }

    public CharSequence q(CharSequence charSequence, int i11, int i12, int i13) {
        return r(charSequence, i11, i12, i13, 0);
    }

    public CharSequence r(CharSequence charSequence, int i11, int i12, int i13, int i14) {
        boolean z11;
        h.j(j(), "Not initialized yet");
        h.e(i11, "start cannot be negative");
        h.e(i12, "end cannot be negative");
        h.e(i13, "maxEmojiCount cannot be negative");
        boolean z12 = false;
        h.b(i11 <= i12, "start should be <= than end");
        if (charSequence == null) {
            return null;
        }
        h.b(i11 <= charSequence.length(), "start should be < than charSequence length");
        h.b(i12 <= charSequence.length(), "end should be < than charSequence length");
        if (charSequence.length() == 0 || i11 == i12) {
            return charSequence;
        }
        if (i14 != 1) {
            if (i14 != 2) {
                z12 = this.f9378g;
            }
            z11 = z12;
        } else {
            z11 = true;
        }
        return this.f9376e.b(charSequence, i11, i12, i13, z11);
    }

    public void s(InitCallback initCallback) {
        h.h(initCallback, "initCallback cannot be null");
        this.f9372a.writeLock().lock();
        try {
            if (this.f9374c != 1) {
                if (this.f9374c != 2) {
                    this.f9373b.add(initCallback);
                }
            }
            this.f9375d.post(new e(initCallback, this.f9374c));
        } finally {
            this.f9372a.writeLock().unlock();
        }
    }

    public void t(InitCallback initCallback) {
        h.h(initCallback, "initCallback cannot be null");
        this.f9372a.writeLock().lock();
        try {
            this.f9373b.remove(initCallback);
        } finally {
            this.f9372a.writeLock().unlock();
        }
    }

    public void u(EditorInfo editorInfo) {
        if (j() && editorInfo != null) {
            if (editorInfo.extras == null) {
                editorInfo.extras = new Bundle();
            }
            this.f9376e.c(editorInfo);
        }
    }
}
