package com.luck.picture.lib.engine;

import com.luck.picture.lib.basic.IBridgeLoaderFactory;
import com.luck.picture.lib.entity.LocalMedia;
import com.luck.picture.lib.interfaces.OnInjectLayoutResourceListener;
import com.luck.picture.lib.interfaces.OnResultCallbackListener;

public interface PictureSelectorEngine {
    CompressEngine createCompressEngine();

    CompressFileEngine createCompressFileEngine();

    ImageEngine createImageLoaderEngine();

    OnInjectLayoutResourceListener createLayoutResourceListener();

    ExtendLoaderEngine createLoaderDataEngine();

    SandboxFileEngine createSandboxFileEngine();

    UriToFileTransformEngine createUriToFileTransformEngine();

    VideoPlayerEngine createVideoPlayerEngine();

    OnResultCallbackListener<LocalMedia> getResultCallbackListener();

    IBridgeLoaderFactory onCreateLoader();
}
