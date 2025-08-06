package com.google.android.gms.common.images;

import android.graphics.Bitmap;
import android.net.Uri;
import android.os.SystemClock;
import com.google.android.gms.common.images.ImageManager;
import com.google.android.gms.common.internal.Asserts;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;

final class zac implements Runnable {
    public final /* synthetic */ ImageManager zaa;
    private final Uri zab;
    private final Bitmap zac;
    private final CountDownLatch zad;

    public zac(ImageManager imageManager, Uri uri, Bitmap bitmap, boolean z11, CountDownLatch countDownLatch) {
        this.zaa = imageManager;
        this.zab = uri;
        this.zac = bitmap;
        this.zad = countDownLatch;
    }

    public final void run() {
        Asserts.checkMainThread("OnBitmapLoadedRunnable must be executed in the main thread");
        Bitmap bitmap = this.zac;
        ImageManager.ImageReceiver imageReceiver = (ImageManager.ImageReceiver) this.zaa.zai.remove(this.zab);
        if (imageReceiver != null) {
            ArrayList zaa2 = imageReceiver.zac;
            int size = zaa2.size();
            for (int i11 = 0; i11 < size; i11++) {
                zag zag = (zag) zaa2.get(i11);
                Bitmap bitmap2 = this.zac;
                if (bitmap2 == null || bitmap == null) {
                    this.zaa.zaj.put(this.zab, Long.valueOf(SystemClock.elapsedRealtime()));
                    ImageManager imageManager = this.zaa;
                    zag.zab(imageManager.zad, imageManager.zag, false);
                } else {
                    zag.zac(this.zaa.zad, bitmap2, false);
                }
                if (!(zag instanceof zaf)) {
                    this.zaa.zah.remove(zag);
                }
            }
        }
        this.zad.countDown();
        synchronized (ImageManager.zaa) {
            ImageManager.zab.remove(this.zab);
        }
    }
}
