package com.luck.picture.lib.engine;

import android.content.Context;
import android.view.View;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnPlayerListener;

public interface VideoPlayerEngine<T> {
    void addPlayListener(OnPlayerListener onPlayerListener);

    void destroy(T t11);

    boolean isPlaying(T t11);

    View onCreateVideoPlayer(Context context);

    void onPause(T t11);

    void onPlayerAttachedToWindow(T t11);

    void onPlayerDetachedFromWindow(T t11);

    void onResume(T t11);

    void onStarPlayer(T t11, LocalMedia localMedia);

    void removePlayListener(OnPlayerListener onPlayerListener);
}
