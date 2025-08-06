package k1;

import androidx.emoji2.text.EmojiCompat;
import androidx.emoji2.text.EmojiCompatInitializer;
import java.util.concurrent.ThreadPoolExecutor;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ EmojiCompatInitializer.c f56544b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ EmojiCompat.MetadataRepoLoaderCallback f56545c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ThreadPoolExecutor f56546d;

    public /* synthetic */ c(EmojiCompatInitializer.c cVar, EmojiCompat.MetadataRepoLoaderCallback metadataRepoLoaderCallback, ThreadPoolExecutor threadPoolExecutor) {
        this.f56544b = cVar;
        this.f56545c = metadataRepoLoaderCallback;
        this.f56546d = threadPoolExecutor;
    }

    public final void run() {
        this.f56544b.d(this.f56545c, this.f56546d);
    }
}
