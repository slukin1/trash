package com.google.android.exoplayer2.video;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;

public class VideoDecoderInputBuffer extends DecoderInputBuffer {
    public Format format;

    public VideoDecoderInputBuffer(int i11) {
        super(i11);
    }

    public VideoDecoderInputBuffer(int i11, int i12) {
        super(i11, i12);
    }
}
