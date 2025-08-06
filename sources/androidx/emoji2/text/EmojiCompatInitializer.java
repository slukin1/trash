package androidx.emoji2.text;

import android.content.Context;
import android.os.Build;
import androidx.core.os.n;
import androidx.emoji2.text.EmojiCompat;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ProcessLifecycleInitializer;
import androidx.lifecycle.j;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

public class EmojiCompatInitializer implements t1.b<Boolean> {

    public class a implements DefaultLifecycleObserver {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Lifecycle f9401b;

        public a(Lifecycle lifecycle) {
            this.f9401b = lifecycle;
        }

        public /* synthetic */ void onCreate(LifecycleOwner lifecycleOwner) {
            j.a(this, lifecycleOwner);
        }

        public /* synthetic */ void onDestroy(LifecycleOwner lifecycleOwner) {
            j.b(this, lifecycleOwner);
        }

        public /* synthetic */ void onPause(LifecycleOwner lifecycleOwner) {
            j.c(this, lifecycleOwner);
        }

        public void onResume(LifecycleOwner lifecycleOwner) {
            EmojiCompatInitializer.this.c();
            this.f9401b.d(this);
        }

        public /* synthetic */ void onStart(LifecycleOwner lifecycleOwner) {
            j.e(this, lifecycleOwner);
        }

        public /* synthetic */ void onStop(LifecycleOwner lifecycleOwner) {
            j.f(this, lifecycleOwner);
        }
    }

    public static class b extends EmojiCompat.c {
        public b(Context context) {
            super(new c(context));
            b(1);
        }
    }

    public static class c implements EmojiCompat.f {

        /* renamed from: a  reason: collision with root package name */
        public final Context f9403a;

        public class a extends EmojiCompat.MetadataRepoLoaderCallback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback f9404a;

            /* renamed from: b  reason: collision with root package name */
            public final /* synthetic */ ThreadPoolExecutor f9405b;

            public a(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
                this.f9404a = metadataRepoLoaderCallback;
                this.f9405b = threadPoolExecutor;
            }

            public void a(Throwable th2) {
                try {
                    this.f9404a.a(th2);
                } finally {
                    this.f9405b.shutdown();
                }
            }

            public void b(c cVar) {
                try {
                    this.f9404a.b(cVar);
                } finally {
                    this.f9405b.shutdown();
                }
            }
        }

        public c(Context context) {
            this.f9403a = context.getApplicationContext();
        }

        public void a(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback) {
            ThreadPoolExecutor b11 = k1.b.b("EmojiCompatInitializer");
            b11.execute(new k1.c(this, metadataRepoLoaderCallback, b11));
        }

        /* renamed from: c */
        public void d(EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
            try {
                FontRequestEmojiCompatConfig a11 = DefaultEmojiCompatConfig.a(this.f9403a);
                if (a11 != null) {
                    a11.c(threadPoolExecutor);
                    a11.a().a(new a(metadataRepoLoaderCallback, threadPoolExecutor));
                    return;
                }
                throw new RuntimeException("EmojiCompat font provider not available on this device.");
            } catch (Throwable th2) {
                metadataRepoLoaderCallback.a(th2);
                threadPoolExecutor.shutdown();
            }
        }
    }

    public static class d implements Runnable {
        public void run() {
            try {
                n.a("EmojiCompat.EmojiCompatInitializer.run");
                if (EmojiCompat.h()) {
                    EmojiCompat.b().k();
                }
            } finally {
                n.b();
            }
        }
    }

    /* renamed from: a */
    public Boolean create(Context context) {
        if (Build.VERSION.SDK_INT < 19) {
            return Boolean.FALSE;
        }
        EmojiCompat.g(new b(context));
        b(context);
        return Boolean.TRUE;
    }

    public void b(Context context) {
        Lifecycle lifecycle = ((LifecycleOwner) t1.a.e(context).f(ProcessLifecycleInitializer.class)).getLifecycle();
        lifecycle.a(new a(lifecycle));
    }

    public void c() {
        k1.b.d().postDelayed(new d(), 500);
    }

    public List<Class<? extends t1.b<?>>> dependencies() {
        return Collections.singletonList(ProcessLifecycleInitializer.class);
    }
}
