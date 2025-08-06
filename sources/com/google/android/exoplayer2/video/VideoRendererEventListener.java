package com.google.android.exoplayer2.video;

import android.os.Handler;
import android.os.SystemClock;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.decoder.DecoderCounters;
import com.google.android.exoplayer2.decoder.DecoderReuseEvaluation;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;

public interface VideoRendererEventListener {

    public static final class EventDispatcher {
        private final Handler handler;
        private final VideoRendererEventListener listener;

        public EventDispatcher(Handler handler2, VideoRendererEventListener videoRendererEventListener) {
            this.handler = videoRendererEventListener != null ? (Handler) Assertions.checkNotNull(handler2) : null;
            this.listener = videoRendererEventListener;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$decoderInitialized$1(String str, long j11, long j12) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoDecoderInitialized(str, j11, j12);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$decoderReleased$7(String str) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoDecoderReleased(str);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$disabled$8(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoDisabled(decoderCounters);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$droppedFrames$3(int i11, long j11) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onDroppedFrames(i11, j11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$enabled$0(DecoderCounters decoderCounters) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoEnabled(decoderCounters);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$inputFormatChanged$2(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoInputFormatChanged(format);
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoInputFormatChanged(format, decoderReuseEvaluation);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$renderedFirstFrame$6(Object obj, long j11) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onRenderedFirstFrame(obj, j11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$reportVideoFrameProcessingOffset$4(long j11, int i11) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoFrameProcessingOffset(j11, i11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$videoCodecError$9(Exception exc) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoCodecError(exc);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void lambda$videoSizeChanged$5(VideoSize videoSize) {
            ((VideoRendererEventListener) Util.castNonNull(this.listener)).onVideoSizeChanged(videoSize);
        }

        public void decoderInitialized(String str, long j11, long j12) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new l(this, str, j11, j12));
            }
        }

        public void decoderReleased(String str) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new k(this, str));
            }
        }

        public void disabled(DecoderCounters decoderCounters) {
            decoderCounters.ensureUpdated();
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new f(this, decoderCounters));
            }
        }

        public void droppedFrames(int i11, long j11) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new c(this, i11, j11));
            }
        }

        public void enabled(DecoderCounters decoderCounters) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new g(this, decoderCounters));
            }
        }

        public void inputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new e(this, format, decoderReuseEvaluation));
            }
        }

        public void renderedFirstFrame(Object obj) {
            if (this.handler != null) {
                this.handler.post(new j(this, obj, SystemClock.elapsedRealtime()));
            }
        }

        public void reportVideoFrameProcessingOffset(long j11, int i11) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new d(this, j11, i11));
            }
        }

        public void videoCodecError(Exception exc) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new i(this, exc));
            }
        }

        public void videoSizeChanged(VideoSize videoSize) {
            Handler handler2 = this.handler;
            if (handler2 != null) {
                handler2.post(new h(this, videoSize));
            }
        }
    }

    void onDroppedFrames(int i11, long j11);

    void onRenderedFirstFrame(Object obj, long j11);

    void onVideoCodecError(Exception exc);

    void onVideoDecoderInitialized(String str, long j11, long j12);

    void onVideoDecoderReleased(String str);

    void onVideoDisabled(DecoderCounters decoderCounters);

    void onVideoEnabled(DecoderCounters decoderCounters);

    void onVideoFrameProcessingOffset(long j11, int i11);

    @Deprecated
    void onVideoInputFormatChanged(Format format);

    void onVideoInputFormatChanged(Format format, DecoderReuseEvaluation decoderReuseEvaluation);

    void onVideoSizeChanged(VideoSize videoSize);
}
