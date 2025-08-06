package com.tencent.liteav.txcvodplayer.renderer;

import android.view.MotionEvent;
import android.view.Surface;
import android.view.View;
import com.tencent.liteav.txcplayer.ITXVCubePlayer;

public interface a {

    /* renamed from: com.tencent.liteav.txcvodplayer.renderer.a$a  reason: collision with other inner class name */
    public interface C0173a {
        void a(b bVar);

        void a(b bVar, int i11, int i12);

        boolean a(MotionEvent motionEvent);

        void b(b bVar);
    }

    public interface b {
        a a();

        void a(ITXVCubePlayer iTXVCubePlayer);

        Surface b();

        Surface c();
    }

    void a(int i11, int i12);

    void a(C0173a aVar);

    boolean a();

    void b(int i11, int i12);

    void b(C0173a aVar);

    View getView();

    void setAspectRatio(int i11);

    void setVideoRotation(int i11);
}
