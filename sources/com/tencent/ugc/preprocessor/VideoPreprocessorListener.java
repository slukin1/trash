package com.tencent.ugc.preprocessor;

import com.tencent.ugc.videobase.base.DetectResult;
import com.tencent.ugc.videobase.frame.PixelFrame;

public interface VideoPreprocessorListener {
    void didDetectFacePoints(int i11, DetectResult detectResult);

    void didProcessFrame(int i11, PixelFrame pixelFrame);
}
