package com.google.android.exoplayer2;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.google.android.exoplayer2.audio.AudioCapabilities;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioRendererEventListener;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.DefaultAudioSink;
import com.google.android.exoplayer2.mediacodec.MediaCodecSelector;
import com.google.android.exoplayer2.metadata.MetadataOutput;
import com.google.android.exoplayer2.metadata.MetadataRenderer;
import com.google.android.exoplayer2.text.TextOutput;
import com.google.android.exoplayer2.text.TextRenderer;
import com.google.android.exoplayer2.video.VideoRendererEventListener;
import com.google.android.exoplayer2.video.spherical.CameraMotionRenderer;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;

public class DefaultRenderersFactory implements RenderersFactory {
    public static final long DEFAULT_ALLOWED_VIDEO_JOINING_TIME_MS = 5000;
    public static final int EXTENSION_RENDERER_MODE_OFF = 0;
    public static final int EXTENSION_RENDERER_MODE_ON = 1;
    public static final int EXTENSION_RENDERER_MODE_PREFER = 2;
    public static final int MAX_DROPPED_VIDEO_FRAME_COUNT_TO_NOTIFY = 50;
    private static final String TAG = "DefaultRenderersFactory";
    private long allowedVideoJoiningTimeMs;
    private final Context context;
    private boolean enableAsyncQueueing;
    private boolean enableAudioTrackPlaybackParams;
    private boolean enableDecoderFallback;
    private boolean enableFloatOutput;
    private boolean enableOffload;
    private boolean enableSynchronizeCodecInteractionsWithQueueing;
    private int extensionRendererMode;
    private boolean forceAsyncQueueingSynchronizationWorkaround;
    private MediaCodecSelector mediaCodecSelector;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ExtensionRendererMode {
    }

    public DefaultRenderersFactory(Context context2) {
        this.context = context2;
        this.extensionRendererMode = 0;
        this.allowedVideoJoiningTimeMs = 5000;
        this.mediaCodecSelector = MediaCodecSelector.DEFAULT;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x006c, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0074, code lost:
        throw new java.lang.RuntimeException("Error instantiating Opus extension", r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00a5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00ad, code lost:
        throw new java.lang.RuntimeException("Error instantiating FLAC extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x006c A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x00a5 A[ExcHandler: Exception (r0v6 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:20:0x0078] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildAudioRenderers(android.content.Context r15, int r16, com.google.android.exoplayer2.mediacodec.MediaCodecSelector r17, boolean r18, com.google.android.exoplayer2.audio.AudioSink r19, android.os.Handler r20, com.google.android.exoplayer2.audio.AudioRendererEventListener r21, java.util.ArrayList<com.google.android.exoplayer2.Renderer> r22) {
        /*
            r14 = this;
            r1 = r14
            r0 = r16
            r9 = r22
            java.lang.String r10 = "DefaultRenderersFactory"
            java.lang.Class<com.google.android.exoplayer2.audio.AudioSink> r11 = com.google.android.exoplayer2.audio.AudioSink.class
            java.lang.Class<com.google.android.exoplayer2.audio.AudioRendererEventListener> r12 = com.google.android.exoplayer2.audio.AudioRendererEventListener.class
            com.google.android.exoplayer2.audio.MediaCodecAudioRenderer r13 = new com.google.android.exoplayer2.audio.MediaCodecAudioRenderer
            r2 = r13
            r3 = r15
            r4 = r17
            r5 = r18
            r6 = r20
            r7 = r21
            r8 = r19
            r2.<init>((android.content.Context) r3, (com.google.android.exoplayer2.mediacodec.MediaCodecSelector) r4, (boolean) r5, (android.os.Handler) r6, (com.google.android.exoplayer2.audio.AudioRendererEventListener) r7, (com.google.android.exoplayer2.audio.AudioSink) r8)
            boolean r2 = r1.enableAsyncQueueing
            r13.experimentalSetAsynchronousBufferQueueingEnabled(r2)
            boolean r2 = r1.forceAsyncQueueingSynchronizationWorkaround
            r13.experimentalSetForceAsyncQueueingSynchronizationWorkaround(r2)
            boolean r2 = r1.enableSynchronizeCodecInteractionsWithQueueing
            r13.experimentalSetSynchronizeCodecInteractionsWithQueueingEnabled(r2)
            r9.add(r13)
            if (r0 != 0) goto L_0x0031
            return
        L_0x0031:
            int r2 = r22.size()
            r3 = 2
            if (r0 != r3) goto L_0x003a
            int r2 = r2 + -1
        L_0x003a:
            r0 = 0
            r4 = 3
            r5 = 1
            java.lang.String r6 = "com.google.android.exoplayer2.ext.opus.LibopusAudioRenderer"
            java.lang.Class r6 = java.lang.Class.forName(r6)     // Catch:{ ClassNotFoundException -> 0x0075, Exception -> 0x006c }
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x0075, Exception -> 0x006c }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r7[r0] = r8     // Catch:{ ClassNotFoundException -> 0x0075, Exception -> 0x006c }
            r7[r5] = r12     // Catch:{ ClassNotFoundException -> 0x0075, Exception -> 0x006c }
            r7[r3] = r11     // Catch:{ ClassNotFoundException -> 0x0075, Exception -> 0x006c }
            java.lang.reflect.Constructor r6 = r6.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x0075, Exception -> 0x006c }
            java.lang.Object[] r7 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x0075, Exception -> 0x006c }
            r7[r0] = r20     // Catch:{ ClassNotFoundException -> 0x0075, Exception -> 0x006c }
            r7[r5] = r21     // Catch:{ ClassNotFoundException -> 0x0075, Exception -> 0x006c }
            r7[r3] = r19     // Catch:{ ClassNotFoundException -> 0x0075, Exception -> 0x006c }
            java.lang.Object r6 = r6.newInstance(r7)     // Catch:{ ClassNotFoundException -> 0x0075, Exception -> 0x006c }
            com.google.android.exoplayer2.Renderer r6 = (com.google.android.exoplayer2.Renderer) r6     // Catch:{ ClassNotFoundException -> 0x0075, Exception -> 0x006c }
            int r7 = r2 + 1
            r9.add(r2, r6)     // Catch:{ ClassNotFoundException -> 0x006a, Exception -> 0x006c }
            java.lang.String r2 = "Loaded LibopusAudioRenderer."
            com.google.android.exoplayer2.util.Log.i(r10, r2)     // Catch:{ ClassNotFoundException -> 0x006a, Exception -> 0x006c }
            goto L_0x0076
        L_0x006a:
            r2 = r7
            goto L_0x0075
        L_0x006c:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating Opus extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x0075:
            r7 = r2
        L_0x0076:
            java.lang.String r2 = "com.google.android.exoplayer2.ext.flac.LibflacAudioRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00ae, Exception -> 0x00a5 }
            java.lang.Class[] r6 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x00ae, Exception -> 0x00a5 }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r6[r0] = r8     // Catch:{ ClassNotFoundException -> 0x00ae, Exception -> 0x00a5 }
            r6[r5] = r12     // Catch:{ ClassNotFoundException -> 0x00ae, Exception -> 0x00a5 }
            r6[r3] = r11     // Catch:{ ClassNotFoundException -> 0x00ae, Exception -> 0x00a5 }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r6)     // Catch:{ ClassNotFoundException -> 0x00ae, Exception -> 0x00a5 }
            java.lang.Object[] r6 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x00ae, Exception -> 0x00a5 }
            r6[r0] = r20     // Catch:{ ClassNotFoundException -> 0x00ae, Exception -> 0x00a5 }
            r6[r5] = r21     // Catch:{ ClassNotFoundException -> 0x00ae, Exception -> 0x00a5 }
            r6[r3] = r19     // Catch:{ ClassNotFoundException -> 0x00ae, Exception -> 0x00a5 }
            java.lang.Object r2 = r2.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x00ae, Exception -> 0x00a5 }
            com.google.android.exoplayer2.Renderer r2 = (com.google.android.exoplayer2.Renderer) r2     // Catch:{ ClassNotFoundException -> 0x00ae, Exception -> 0x00a5 }
            int r6 = r7 + 1
            r9.add(r7, r2)     // Catch:{ ClassNotFoundException -> 0x00a3, Exception -> 0x00a5 }
            java.lang.String r2 = "Loaded LibflacAudioRenderer."
            com.google.android.exoplayer2.util.Log.i(r10, r2)     // Catch:{ ClassNotFoundException -> 0x00a3, Exception -> 0x00a5 }
            goto L_0x00af
        L_0x00a3:
            r7 = r6
            goto L_0x00ae
        L_0x00a5:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating FLAC extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x00ae:
            r6 = r7
        L_0x00af:
            java.lang.String r2 = "com.google.android.exoplayer2.ext.ffmpeg.FfmpegAudioRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00e3, Exception -> 0x00da }
            java.lang.Class[] r7 = new java.lang.Class[r4]     // Catch:{ ClassNotFoundException -> 0x00e3, Exception -> 0x00da }
            java.lang.Class<android.os.Handler> r8 = android.os.Handler.class
            r7[r0] = r8     // Catch:{ ClassNotFoundException -> 0x00e3, Exception -> 0x00da }
            r7[r5] = r12     // Catch:{ ClassNotFoundException -> 0x00e3, Exception -> 0x00da }
            r7[r3] = r11     // Catch:{ ClassNotFoundException -> 0x00e3, Exception -> 0x00da }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r7)     // Catch:{ ClassNotFoundException -> 0x00e3, Exception -> 0x00da }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ ClassNotFoundException -> 0x00e3, Exception -> 0x00da }
            r4[r0] = r20     // Catch:{ ClassNotFoundException -> 0x00e3, Exception -> 0x00da }
            r4[r5] = r21     // Catch:{ ClassNotFoundException -> 0x00e3, Exception -> 0x00da }
            r4[r3] = r19     // Catch:{ ClassNotFoundException -> 0x00e3, Exception -> 0x00da }
            java.lang.Object r0 = r2.newInstance(r4)     // Catch:{ ClassNotFoundException -> 0x00e3, Exception -> 0x00da }
            com.google.android.exoplayer2.Renderer r0 = (com.google.android.exoplayer2.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x00e3, Exception -> 0x00da }
            r9.add(r6, r0)     // Catch:{ ClassNotFoundException -> 0x00e3, Exception -> 0x00da }
            java.lang.String r0 = "Loaded FfmpegAudioRenderer."
            com.google.android.exoplayer2.util.Log.i(r10, r0)     // Catch:{ ClassNotFoundException -> 0x00e3, Exception -> 0x00da }
            goto L_0x00e3
        L_0x00da:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating FFmpeg extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.DefaultRenderersFactory.buildAudioRenderers(android.content.Context, int, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, boolean, com.google.android.exoplayer2.audio.AudioSink, android.os.Handler, com.google.android.exoplayer2.audio.AudioRendererEventListener, java.util.ArrayList):void");
    }

    public AudioSink buildAudioSink(Context context2, boolean z11, boolean z12, boolean z13) {
        return new DefaultAudioSink(AudioCapabilities.getCapabilities(context2), new DefaultAudioSink.DefaultAudioProcessorChain(new AudioProcessor[0]), z11, z12, z13 ? 1 : 0);
    }

    public void buildCameraMotionRenderers(Context context2, int i11, ArrayList<Renderer> arrayList) {
        arrayList.add(new CameraMotionRenderer());
    }

    public void buildMetadataRenderers(Context context2, MetadataOutput metadataOutput, Looper looper, int i11, ArrayList<Renderer> arrayList) {
        arrayList.add(new MetadataRenderer(metadataOutput, looper));
    }

    public void buildMiscellaneousRenderers(Context context2, Handler handler, int i11, ArrayList<Renderer> arrayList) {
    }

    public void buildTextRenderers(Context context2, TextOutput textOutput, Looper looper, int i11, ArrayList<Renderer> arrayList) {
        arrayList.add(new TextRenderer(textOutput, looper));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0080, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0088, code lost:
        throw new java.lang.RuntimeException("Error instantiating VP9 extension", r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0080 A[ExcHandler: Exception (r0v7 'e' java.lang.Exception A[CUSTOM_DECLARE]), Splitter:B:7:0x0043] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void buildVideoRenderers(android.content.Context r16, int r17, com.google.android.exoplayer2.mediacodec.MediaCodecSelector r18, boolean r19, android.os.Handler r20, com.google.android.exoplayer2.video.VideoRendererEventListener r21, long r22, java.util.ArrayList<com.google.android.exoplayer2.Renderer> r24) {
        /*
            r15 = this;
            r1 = r15
            r0 = r17
            r11 = r24
            java.lang.String r12 = "DefaultRenderersFactory"
            java.lang.Class<com.google.android.exoplayer2.video.VideoRendererEventListener> r13 = com.google.android.exoplayer2.video.VideoRendererEventListener.class
            com.google.android.exoplayer2.video.MediaCodecVideoRenderer r14 = new com.google.android.exoplayer2.video.MediaCodecVideoRenderer
            r10 = 50
            r2 = r14
            r3 = r16
            r4 = r18
            r5 = r22
            r7 = r19
            r8 = r20
            r9 = r21
            r2.<init>(r3, r4, r5, r7, r8, r9, r10)
            boolean r2 = r1.enableAsyncQueueing
            r14.experimentalSetAsynchronousBufferQueueingEnabled(r2)
            boolean r2 = r1.forceAsyncQueueingSynchronizationWorkaround
            r14.experimentalSetForceAsyncQueueingSynchronizationWorkaround(r2)
            boolean r2 = r1.enableSynchronizeCodecInteractionsWithQueueing
            r14.experimentalSetSynchronizeCodecInteractionsWithQueueingEnabled(r2)
            r11.add(r14)
            if (r0 != 0) goto L_0x0032
            return
        L_0x0032:
            int r2 = r24.size()
            r3 = 2
            if (r0 != r3) goto L_0x003b
            int r2 = r2 + -1
        L_0x003b:
            r0 = 50
            r4 = 3
            r5 = 0
            r6 = 4
            r7 = 1
            java.lang.String r8 = "com.google.android.exoplayer2.ext.vp9.LibvpxVideoRenderer"
            java.lang.Class r8 = java.lang.Class.forName(r8)     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            java.lang.Class[] r9 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            java.lang.Class r10 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            r9[r5] = r10     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            java.lang.Class<android.os.Handler> r10 = android.os.Handler.class
            r9[r7] = r10     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            r9[r3] = r13     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            r9[r4] = r10     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            java.lang.reflect.Constructor r8 = r8.getConstructor(r9)     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            java.lang.Object[] r9 = new java.lang.Object[r6]     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            java.lang.Long r10 = java.lang.Long.valueOf(r22)     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            r9[r5] = r10     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            r9[r7] = r20     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            r9[r3] = r21     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            r9[r4] = r10     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            java.lang.Object r8 = r8.newInstance(r9)     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            com.google.android.exoplayer2.Renderer r8 = (com.google.android.exoplayer2.Renderer) r8     // Catch:{ ClassNotFoundException -> 0x0089, Exception -> 0x0080 }
            int r9 = r2 + 1
            r11.add(r2, r8)     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0080 }
            java.lang.String r2 = "Loaded LibvpxVideoRenderer."
            com.google.android.exoplayer2.util.Log.i(r12, r2)     // Catch:{ ClassNotFoundException -> 0x007e, Exception -> 0x0080 }
            goto L_0x008a
        L_0x007e:
            r2 = r9
            goto L_0x0089
        L_0x0080:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating VP9 extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x0089:
            r9 = r2
        L_0x008a:
            java.lang.String r2 = "com.google.android.exoplayer2.ext.av1.Libgav1VideoRenderer"
            java.lang.Class r2 = java.lang.Class.forName(r2)     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            java.lang.Class[] r8 = new java.lang.Class[r6]     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            java.lang.Class r10 = java.lang.Long.TYPE     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            r8[r5] = r10     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            java.lang.Class<android.os.Handler> r10 = android.os.Handler.class
            r8[r7] = r10     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            r8[r3] = r13     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            java.lang.Class r10 = java.lang.Integer.TYPE     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            r8[r4] = r10     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            java.lang.reflect.Constructor r2 = r2.getConstructor(r8)     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            java.lang.Long r8 = java.lang.Long.valueOf(r22)     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            r6[r5] = r8     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            r6[r7] = r20     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            r6[r3] = r21     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            r6[r4] = r0     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            java.lang.Object r0 = r2.newInstance(r6)     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            com.google.android.exoplayer2.Renderer r0 = (com.google.android.exoplayer2.Renderer) r0     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            r11.add(r9, r0)     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            java.lang.String r0 = "Loaded Libgav1VideoRenderer."
            com.google.android.exoplayer2.util.Log.i(r12, r0)     // Catch:{ ClassNotFoundException -> 0x00ce, Exception -> 0x00c5 }
            goto L_0x00ce
        L_0x00c5:
            r0 = move-exception
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            java.lang.String r3 = "Error instantiating AV1 extension"
            r2.<init>(r3, r0)
            throw r2
        L_0x00ce:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.DefaultRenderersFactory.buildVideoRenderers(android.content.Context, int, com.google.android.exoplayer2.mediacodec.MediaCodecSelector, boolean, android.os.Handler, com.google.android.exoplayer2.video.VideoRendererEventListener, long, java.util.ArrayList):void");
    }

    public Renderer[] createRenderers(Handler handler, VideoRendererEventListener videoRendererEventListener, AudioRendererEventListener audioRendererEventListener, TextOutput textOutput, MetadataOutput metadataOutput) {
        ArrayList arrayList = new ArrayList();
        buildVideoRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, handler, videoRendererEventListener, this.allowedVideoJoiningTimeMs, arrayList);
        AudioSink buildAudioSink = buildAudioSink(this.context, this.enableFloatOutput, this.enableAudioTrackPlaybackParams, this.enableOffload);
        if (buildAudioSink != null) {
            buildAudioRenderers(this.context, this.extensionRendererMode, this.mediaCodecSelector, this.enableDecoderFallback, buildAudioSink, handler, audioRendererEventListener, arrayList);
        }
        ArrayList arrayList2 = arrayList;
        buildTextRenderers(this.context, textOutput, handler.getLooper(), this.extensionRendererMode, arrayList2);
        buildMetadataRenderers(this.context, metadataOutput, handler.getLooper(), this.extensionRendererMode, arrayList2);
        buildCameraMotionRenderers(this.context, this.extensionRendererMode, arrayList);
        Handler handler2 = handler;
        buildMiscellaneousRenderers(this.context, handler, this.extensionRendererMode, arrayList);
        return (Renderer[]) arrayList.toArray(new Renderer[0]);
    }

    public DefaultRenderersFactory experimentalSetAsynchronousBufferQueueingEnabled(boolean z11) {
        this.enableAsyncQueueing = z11;
        return this;
    }

    public DefaultRenderersFactory experimentalSetForceAsyncQueueingSynchronizationWorkaround(boolean z11) {
        this.forceAsyncQueueingSynchronizationWorkaround = z11;
        return this;
    }

    public DefaultRenderersFactory experimentalSetSynchronizeCodecInteractionsWithQueueingEnabled(boolean z11) {
        this.enableSynchronizeCodecInteractionsWithQueueing = z11;
        return this;
    }

    public DefaultRenderersFactory setAllowedVideoJoiningTimeMs(long j11) {
        this.allowedVideoJoiningTimeMs = j11;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioFloatOutput(boolean z11) {
        this.enableFloatOutput = z11;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioOffload(boolean z11) {
        this.enableOffload = z11;
        return this;
    }

    public DefaultRenderersFactory setEnableAudioTrackPlaybackParams(boolean z11) {
        this.enableAudioTrackPlaybackParams = z11;
        return this;
    }

    public DefaultRenderersFactory setEnableDecoderFallback(boolean z11) {
        this.enableDecoderFallback = z11;
        return this;
    }

    public DefaultRenderersFactory setExtensionRendererMode(int i11) {
        this.extensionRendererMode = i11;
        return this;
    }

    public DefaultRenderersFactory setMediaCodecSelector(MediaCodecSelector mediaCodecSelector2) {
        this.mediaCodecSelector = mediaCodecSelector2;
        return this;
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, int i11) {
        this(context2, i11, 5000);
    }

    @Deprecated
    public DefaultRenderersFactory(Context context2, int i11, long j11) {
        this.context = context2;
        this.extensionRendererMode = i11;
        this.allowedVideoJoiningTimeMs = j11;
        this.mediaCodecSelector = MediaCodecSelector.DEFAULT;
    }
}
