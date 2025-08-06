package io.flutter.view;

import android.graphics.SurfaceTexture;

public interface TextureRegistry {

    public interface OnFrameConsumedListener {
        void onFrameConsumed();
    }

    public interface OnTrimMemoryListener {
        void onTrimMemory(int i11);
    }

    public interface SurfaceTextureEntry {
        long id();

        void release();

        void setOnFrameConsumedListener(OnFrameConsumedListener onFrameConsumedListener);

        void setOnTrimMemoryListener(OnTrimMemoryListener onTrimMemoryListener);

        SurfaceTexture surfaceTexture();
    }

    SurfaceTextureEntry createSurfaceTexture();

    void onTrimMemory(int i11);

    SurfaceTextureEntry registerSurfaceTexture(SurfaceTexture surfaceTexture);
}
