package com.google.android.exoplayer2.audio;

import android.media.AudioAttributes;
import android.media.AudioFormat;
import android.media.AudioManager;
import android.media.AudioTrack;
import android.media.PlaybackParams;
import android.os.ConditionVariable;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.audio.AudioProcessor;
import com.google.android.exoplayer2.audio.AudioSink;
import com.google.android.exoplayer2.audio.AudioTrackPositionTracker;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.Util;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public final class DefaultAudioSink implements AudioSink {
    private static final int AC3_BUFFER_MULTIPLICATION_FACTOR = 2;
    private static final int AUDIO_TRACK_RETRY_DURATION_MS = 100;
    private static final int BUFFER_MULTIPLICATION_FACTOR = 4;
    public static final float DEFAULT_PLAYBACK_SPEED = 1.0f;
    private static final boolean DEFAULT_SKIP_SILENCE = false;
    private static final int ERROR_NATIVE_DEAD_OBJECT = -32;
    private static final long MAX_BUFFER_DURATION_US = 750000;
    public static final float MAX_PITCH = 8.0f;
    public static final float MAX_PLAYBACK_SPEED = 8.0f;
    private static final long MIN_BUFFER_DURATION_US = 250000;
    public static final float MIN_PITCH = 0.1f;
    public static final float MIN_PLAYBACK_SPEED = 0.1f;
    private static final long OFFLOAD_BUFFER_DURATION_US = 50000000;
    public static final int OFFLOAD_MODE_DISABLED = 0;
    public static final int OFFLOAD_MODE_ENABLED_GAPLESS_NOT_REQUIRED = 2;
    public static final int OFFLOAD_MODE_ENABLED_GAPLESS_REQUIRED = 1;
    private static final int OUTPUT_MODE_OFFLOAD = 1;
    private static final int OUTPUT_MODE_PASSTHROUGH = 2;
    private static final int OUTPUT_MODE_PCM = 0;
    private static final long PASSTHROUGH_BUFFER_DURATION_US = 250000;
    private static final String TAG = "DefaultAudioSink";
    public static boolean failOnSpuriousAudioTimestamp = false;
    private AudioProcessor[] activeAudioProcessors;
    private MediaPositionParameters afterDrainParameters;
    private AudioAttributes audioAttributes;
    private final AudioCapabilities audioCapabilities;
    private final AudioProcessorChain audioProcessorChain;
    private int audioSessionId;
    /* access modifiers changed from: private */
    public AudioTrack audioTrack;
    private PlaybackParameters audioTrackPlaybackParameters;
    private final AudioTrackPositionTracker audioTrackPositionTracker;
    private AuxEffectInfo auxEffectInfo;
    private ByteBuffer avSyncHeader;
    private int bytesUntilNextAvSync;
    private final ChannelMappingAudioProcessor channelMappingAudioProcessor;
    private Configuration configuration;
    private int drainingAudioProcessorIndex;
    private final boolean enableAudioTrackPlaybackParams;
    private final boolean enableFloatOutput;
    private boolean externalAudioSessionIdProvided;
    private int framesPerEncodedSample;
    private boolean handledEndOfStream;
    private final PendingExceptionHolder<AudioSink.InitializationException> initializationExceptionPendingExceptionHolder;
    private ByteBuffer inputBuffer;
    private int inputBufferAccessUnitCount;
    private boolean isWaitingForOffloadEndOfStreamHandled;
    /* access modifiers changed from: private */
    public long lastFeedElapsedRealtimeMs;
    /* access modifiers changed from: private */
    public AudioSink.Listener listener;
    private MediaPositionParameters mediaPositionParameters;
    private final ArrayDeque<MediaPositionParameters> mediaPositionParametersCheckpoints;
    private boolean offloadDisabledUntilNextConfiguration;
    private final int offloadMode;
    private StreamEventCallbackV29 offloadStreamEventCallbackV29;
    private ByteBuffer outputBuffer;
    private ByteBuffer[] outputBuffers;
    private Configuration pendingConfiguration;
    /* access modifiers changed from: private */
    public boolean playing;
    private byte[] preV21OutputBuffer;
    private int preV21OutputBufferOffset;
    /* access modifiers changed from: private */
    public final ConditionVariable releasingConditionVariable;
    private long startMediaTimeUs;
    private boolean startMediaTimeUsNeedsInit;
    private boolean startMediaTimeUsNeedsSync;
    private boolean stoppedAudioTrack;
    private long submittedEncodedFrames;
    private long submittedPcmBytes;
    private final AudioProcessor[] toFloatPcmAvailableAudioProcessors;
    private final AudioProcessor[] toIntPcmAvailableAudioProcessors;
    private final TrimmingAudioProcessor trimmingAudioProcessor;
    private boolean tunneling;
    private float volume;
    private final PendingExceptionHolder<AudioSink.WriteException> writeExceptionPendingExceptionHolder;
    private long writtenEncodedFrames;
    private long writtenPcmBytes;

    public interface AudioProcessorChain {
        PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters);

        boolean applySkipSilenceEnabled(boolean z11);

        AudioProcessor[] getAudioProcessors();

        long getMediaDuration(long j11);

        long getSkippedOutputFrameCount();
    }

    public static final class Configuration {
        public final AudioProcessor[] availableAudioProcessors;
        public final int bufferSize;
        public final Format inputFormat;
        public final int inputPcmFrameSize;
        public final int outputChannelConfig;
        public final int outputEncoding;
        public final int outputMode;
        public final int outputPcmFrameSize;
        public final int outputSampleRate;

        public Configuration(Format format, int i11, int i12, int i13, int i14, int i15, int i16, int i17, boolean z11, AudioProcessor[] audioProcessorArr) {
            this.inputFormat = format;
            this.inputPcmFrameSize = i11;
            this.outputMode = i12;
            this.outputPcmFrameSize = i13;
            this.outputSampleRate = i14;
            this.outputChannelConfig = i15;
            this.outputEncoding = i16;
            this.availableAudioProcessors = audioProcessorArr;
            this.bufferSize = computeBufferSize(i17, z11);
        }

        private int computeBufferSize(int i11, boolean z11) {
            if (i11 != 0) {
                return i11;
            }
            int i12 = this.outputMode;
            if (i12 == 0) {
                return getPcmDefaultBufferSize(z11 ? 8.0f : 1.0f);
            } else if (i12 == 1) {
                return getEncodedDefaultBufferSize(DefaultAudioSink.OFFLOAD_BUFFER_DURATION_US);
            } else {
                if (i12 == 2) {
                    return getEncodedDefaultBufferSize(250000);
                }
                throw new IllegalStateException();
            }
        }

        private AudioTrack createAudioTrack(boolean z11, AudioAttributes audioAttributes, int i11) {
            int i12 = Util.SDK_INT;
            if (i12 >= 29) {
                return createAudioTrackV29(z11, audioAttributes, i11);
            }
            if (i12 >= 21) {
                return createAudioTrackV21(z11, audioAttributes, i11);
            }
            return createAudioTrackV9(audioAttributes, i11);
        }

        private AudioTrack createAudioTrackV21(boolean z11, AudioAttributes audioAttributes, int i11) {
            return new AudioTrack(getAudioTrackAttributesV21(audioAttributes, z11), DefaultAudioSink.getAudioFormat(this.outputSampleRate, this.outputChannelConfig, this.outputEncoding), this.bufferSize, 1, i11);
        }

        private AudioTrack createAudioTrackV29(boolean z11, AudioAttributes audioAttributes, int i11) {
            AudioFormat access$1000 = DefaultAudioSink.getAudioFormat(this.outputSampleRate, this.outputChannelConfig, this.outputEncoding);
            AudioAttributes audioTrackAttributesV21 = getAudioTrackAttributesV21(audioAttributes, z11);
            boolean z12 = true;
            AudioTrack.Builder sessionId = new AudioTrack.Builder().setAudioAttributes(audioTrackAttributesV21).setAudioFormat(access$1000).setTransferMode(1).setBufferSizeInBytes(this.bufferSize).setSessionId(i11);
            if (this.outputMode != 1) {
                z12 = false;
            }
            return sessionId.setOffloadedPlayback(z12).build();
        }

        private AudioTrack createAudioTrackV9(AudioAttributes audioAttributes, int i11) {
            int streamTypeForAudioUsage = Util.getStreamTypeForAudioUsage(audioAttributes.usage);
            if (i11 == 0) {
                return new AudioTrack(streamTypeForAudioUsage, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1);
            }
            return new AudioTrack(streamTypeForAudioUsage, this.outputSampleRate, this.outputChannelConfig, this.outputEncoding, this.bufferSize, 1, i11);
        }

        private static AudioAttributes getAudioTrackAttributesV21(AudioAttributes audioAttributes, boolean z11) {
            if (z11) {
                return getAudioTrackTunnelingAttributesV21();
            }
            return audioAttributes.getAudioAttributesV21();
        }

        private static AudioAttributes getAudioTrackTunnelingAttributesV21() {
            return new AudioAttributes.Builder().setContentType(3).setFlags(16).setUsage(1).build();
        }

        private int getEncodedDefaultBufferSize(long j11) {
            int access$1100 = DefaultAudioSink.getMaximumEncodedRateBytesPerSecond(this.outputEncoding);
            if (this.outputEncoding == 5) {
                access$1100 *= 2;
            }
            return (int) ((j11 * ((long) access$1100)) / 1000000);
        }

        private int getPcmDefaultBufferSize(float f11) {
            int minBufferSize = AudioTrack.getMinBufferSize(this.outputSampleRate, this.outputChannelConfig, this.outputEncoding);
            Assertions.checkState(minBufferSize != -2);
            int constrainValue = Util.constrainValue(minBufferSize * 4, ((int) durationUsToFrames(250000)) * this.outputPcmFrameSize, Math.max(minBufferSize, ((int) durationUsToFrames(DefaultAudioSink.MAX_BUFFER_DURATION_US)) * this.outputPcmFrameSize));
            return f11 != 1.0f ? Math.round(((float) constrainValue) * f11) : constrainValue;
        }

        public AudioTrack buildAudioTrack(boolean z11, AudioAttributes audioAttributes, int i11) throws AudioSink.InitializationException {
            try {
                AudioTrack createAudioTrack = createAudioTrack(z11, audioAttributes, i11);
                int state = createAudioTrack.getState();
                if (state == 1) {
                    return createAudioTrack;
                }
                try {
                    createAudioTrack.release();
                } catch (Exception unused) {
                }
                throw new AudioSink.InitializationException(state, this.outputSampleRate, this.outputChannelConfig, this.bufferSize, this.inputFormat, outputModeIsOffload(), (Exception) null);
            } catch (IllegalArgumentException | UnsupportedOperationException e11) {
                throw new AudioSink.InitializationException(0, this.outputSampleRate, this.outputChannelConfig, this.bufferSize, this.inputFormat, outputModeIsOffload(), e11);
            }
        }

        public boolean canReuseAudioTrack(Configuration configuration) {
            return configuration.outputMode == this.outputMode && configuration.outputEncoding == this.outputEncoding && configuration.outputSampleRate == this.outputSampleRate && configuration.outputChannelConfig == this.outputChannelConfig && configuration.outputPcmFrameSize == this.outputPcmFrameSize;
        }

        public long durationUsToFrames(long j11) {
            return (j11 * ((long) this.outputSampleRate)) / 1000000;
        }

        public long framesToDurationUs(long j11) {
            return (j11 * 1000000) / ((long) this.outputSampleRate);
        }

        public long inputFramesToDurationUs(long j11) {
            return (j11 * 1000000) / ((long) this.inputFormat.sampleRate);
        }

        public boolean outputModeIsOffload() {
            return this.outputMode == 1;
        }
    }

    public static class DefaultAudioProcessorChain implements AudioProcessorChain {
        private final AudioProcessor[] audioProcessors;
        private final SilenceSkippingAudioProcessor silenceSkippingAudioProcessor;
        private final SonicAudioProcessor sonicAudioProcessor;

        public DefaultAudioProcessorChain(AudioProcessor... audioProcessorArr) {
            this(audioProcessorArr, new SilenceSkippingAudioProcessor(), new SonicAudioProcessor());
        }

        public PlaybackParameters applyPlaybackParameters(PlaybackParameters playbackParameters) {
            this.sonicAudioProcessor.setSpeed(playbackParameters.speed);
            this.sonicAudioProcessor.setPitch(playbackParameters.pitch);
            return playbackParameters;
        }

        public boolean applySkipSilenceEnabled(boolean z11) {
            this.silenceSkippingAudioProcessor.setEnabled(z11);
            return z11;
        }

        public AudioProcessor[] getAudioProcessors() {
            return this.audioProcessors;
        }

        public long getMediaDuration(long j11) {
            return this.sonicAudioProcessor.getMediaDuration(j11);
        }

        public long getSkippedOutputFrameCount() {
            return this.silenceSkippingAudioProcessor.getSkippedFrames();
        }

        public DefaultAudioProcessorChain(AudioProcessor[] audioProcessorArr, SilenceSkippingAudioProcessor silenceSkippingAudioProcessor2, SonicAudioProcessor sonicAudioProcessor2) {
            AudioProcessor[] audioProcessorArr2 = new AudioProcessor[(audioProcessorArr.length + 2)];
            this.audioProcessors = audioProcessorArr2;
            System.arraycopy(audioProcessorArr, 0, audioProcessorArr2, 0, audioProcessorArr.length);
            this.silenceSkippingAudioProcessor = silenceSkippingAudioProcessor2;
            this.sonicAudioProcessor = sonicAudioProcessor2;
            audioProcessorArr2[audioProcessorArr.length] = silenceSkippingAudioProcessor2;
            audioProcessorArr2[audioProcessorArr.length + 1] = sonicAudioProcessor2;
        }
    }

    public static final class InvalidAudioTrackTimestampException extends RuntimeException {
        private InvalidAudioTrackTimestampException(String str) {
            super(str);
        }
    }

    public static final class MediaPositionParameters {
        public final long audioTrackPositionUs;
        public final long mediaTimeUs;
        public final PlaybackParameters playbackParameters;
        public final boolean skipSilence;

        private MediaPositionParameters(PlaybackParameters playbackParameters2, boolean z11, long j11, long j12) {
            this.playbackParameters = playbackParameters2;
            this.skipSilence = z11;
            this.mediaTimeUs = j11;
            this.audioTrackPositionUs = j12;
        }
    }

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface OffloadMode {
    }

    public static final class PendingExceptionHolder<T extends Exception> {
        private T pendingException;
        private long throwDeadlineMs;
        private final long throwDelayMs;

        public PendingExceptionHolder(long j11) {
            this.throwDelayMs = j11;
        }

        public void clear() {
            this.pendingException = null;
        }

        public void throwExceptionIfDeadlineIsReached(T t11) throws Exception {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            if (this.pendingException == null) {
                this.pendingException = t11;
                this.throwDeadlineMs = this.throwDelayMs + elapsedRealtime;
            }
            if (elapsedRealtime >= this.throwDeadlineMs) {
                T t12 = this.pendingException;
                if (t12 != t11) {
                    t12.addSuppressed(t11);
                }
                T t13 = this.pendingException;
                clear();
                throw t13;
            }
        }
    }

    public final class PositionTrackerListener implements AudioTrackPositionTracker.Listener {
        private PositionTrackerListener() {
        }

        public void onInvalidLatency(long j11) {
            StringBuilder sb2 = new StringBuilder(61);
            sb2.append("Ignoring impossibly large audio latency: ");
            sb2.append(j11);
            Log.w(DefaultAudioSink.TAG, sb2.toString());
        }

        public void onPositionAdvancing(long j11) {
            if (DefaultAudioSink.this.listener != null) {
                DefaultAudioSink.this.listener.onPositionAdvancing(j11);
            }
        }

        public void onPositionFramesMismatch(long j11, long j12, long j13, long j14) {
            long access$600 = DefaultAudioSink.this.getSubmittedFrames();
            long access$700 = DefaultAudioSink.this.getWrittenFrames();
            StringBuilder sb2 = new StringBuilder(182);
            sb2.append("Spurious audio timestamp (frame position mismatch): ");
            sb2.append(j11);
            sb2.append(", ");
            sb2.append(j12);
            sb2.append(", ");
            sb2.append(j13);
            sb2.append(", ");
            sb2.append(j14);
            sb2.append(", ");
            sb2.append(access$600);
            sb2.append(", ");
            sb2.append(access$700);
            String sb3 = sb2.toString();
            if (!DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                Log.w(DefaultAudioSink.TAG, sb3);
                return;
            }
            throw new InvalidAudioTrackTimestampException(sb3);
        }

        public void onSystemTimeUsMismatch(long j11, long j12, long j13, long j14) {
            long access$600 = DefaultAudioSink.this.getSubmittedFrames();
            long access$700 = DefaultAudioSink.this.getWrittenFrames();
            StringBuilder sb2 = new StringBuilder(180);
            sb2.append("Spurious audio timestamp (system clock mismatch): ");
            sb2.append(j11);
            sb2.append(", ");
            sb2.append(j12);
            sb2.append(", ");
            sb2.append(j13);
            sb2.append(", ");
            sb2.append(j14);
            sb2.append(", ");
            sb2.append(access$600);
            sb2.append(", ");
            sb2.append(access$700);
            String sb3 = sb2.toString();
            if (!DefaultAudioSink.failOnSpuriousAudioTimestamp) {
                Log.w(DefaultAudioSink.TAG, sb3);
                return;
            }
            throw new InvalidAudioTrackTimestampException(sb3);
        }

        public void onUnderrun(int i11, long j11) {
            if (DefaultAudioSink.this.listener != null) {
                DefaultAudioSink.this.listener.onUnderrun(i11, j11, SystemClock.elapsedRealtime() - DefaultAudioSink.this.lastFeedElapsedRealtimeMs);
            }
        }
    }

    public final class StreamEventCallbackV29 {
        private final AudioTrack.StreamEventCallback callback;
        private final Handler handler = new Handler();

        public StreamEventCallbackV29() {
            this.callback = new AudioTrack.StreamEventCallback(DefaultAudioSink.this) {
                public void onDataRequest(AudioTrack audioTrack, int i11) {
                    Assertions.checkState(audioTrack == DefaultAudioSink.this.audioTrack);
                    if (DefaultAudioSink.this.listener != null && DefaultAudioSink.this.playing) {
                        DefaultAudioSink.this.listener.onOffloadBufferEmptying();
                    }
                }

                public void onTearDown(AudioTrack audioTrack) {
                    Assertions.checkState(audioTrack == DefaultAudioSink.this.audioTrack);
                    if (DefaultAudioSink.this.listener != null && DefaultAudioSink.this.playing) {
                        DefaultAudioSink.this.listener.onOffloadBufferEmptying();
                    }
                }
            };
        }

        public void register(AudioTrack audioTrack) {
            Handler handler2 = this.handler;
            Objects.requireNonNull(handler2);
            audioTrack.registerStreamEventCallback(new o(handler2), this.callback);
        }

        public void unregister(AudioTrack audioTrack) {
            audioTrack.unregisterStreamEventCallback(this.callback);
            this.handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public DefaultAudioSink(AudioCapabilities audioCapabilities2, AudioProcessor[] audioProcessorArr) {
        this(audioCapabilities2, audioProcessorArr, false);
    }

    private void applyAudioProcessorPlaybackParametersAndSkipSilence(long j11) {
        PlaybackParameters playbackParameters;
        if (shouldApplyAudioProcessorPlaybackParameters()) {
            playbackParameters = this.audioProcessorChain.applyPlaybackParameters(getAudioProcessorPlaybackParameters());
        } else {
            playbackParameters = PlaybackParameters.DEFAULT;
        }
        PlaybackParameters playbackParameters2 = playbackParameters;
        boolean applySkipSilenceEnabled = shouldApplyAudioProcessorPlaybackParameters() ? this.audioProcessorChain.applySkipSilenceEnabled(getSkipSilenceEnabled()) : false;
        this.mediaPositionParametersCheckpoints.add(new MediaPositionParameters(playbackParameters2, applySkipSilenceEnabled, Math.max(0, j11), this.configuration.framesToDurationUs(getWrittenFrames())));
        setupAudioProcessors();
        AudioSink.Listener listener2 = this.listener;
        if (listener2 != null) {
            listener2.onSkipSilenceEnabledChanged(applySkipSilenceEnabled);
        }
    }

    private long applyMediaPositionParameters(long j11) {
        while (!this.mediaPositionParametersCheckpoints.isEmpty() && j11 >= this.mediaPositionParametersCheckpoints.getFirst().audioTrackPositionUs) {
            this.mediaPositionParameters = this.mediaPositionParametersCheckpoints.remove();
        }
        MediaPositionParameters mediaPositionParameters2 = this.mediaPositionParameters;
        long j12 = j11 - mediaPositionParameters2.audioTrackPositionUs;
        if (mediaPositionParameters2.playbackParameters.equals(PlaybackParameters.DEFAULT)) {
            return this.mediaPositionParameters.mediaTimeUs + j12;
        }
        if (this.mediaPositionParametersCheckpoints.isEmpty()) {
            return this.mediaPositionParameters.mediaTimeUs + this.audioProcessorChain.getMediaDuration(j12);
        }
        MediaPositionParameters first = this.mediaPositionParametersCheckpoints.getFirst();
        return first.mediaTimeUs - Util.getMediaDurationForPlayoutDuration(first.audioTrackPositionUs - j11, this.mediaPositionParameters.playbackParameters.speed);
    }

    private long applySkipping(long j11) {
        return j11 + this.configuration.framesToDurationUs(this.audioProcessorChain.getSkippedOutputFrameCount());
    }

    private AudioTrack buildAudioTrack() throws AudioSink.InitializationException {
        try {
            return ((Configuration) Assertions.checkNotNull(this.configuration)).buildAudioTrack(this.tunneling, this.audioAttributes, this.audioSessionId);
        } catch (AudioSink.InitializationException e11) {
            maybeDisableOffload();
            AudioSink.Listener listener2 = this.listener;
            if (listener2 != null) {
                listener2.onAudioSinkError(e11);
            }
            throw e11;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0033  */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean drainToEndOfStream() throws com.google.android.exoplayer2.audio.AudioSink.WriteException {
        /*
            r9 = this;
            int r0 = r9.drainingAudioProcessorIndex
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != r1) goto L_0x000b
            r9.drainingAudioProcessorIndex = r3
        L_0x0009:
            r0 = r2
            goto L_0x000c
        L_0x000b:
            r0 = r3
        L_0x000c:
            int r4 = r9.drainingAudioProcessorIndex
            com.google.android.exoplayer2.audio.AudioProcessor[] r5 = r9.activeAudioProcessors
            int r6 = r5.length
            r7 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r4 >= r6) goto L_0x002f
            r4 = r5[r4]
            if (r0 == 0) goto L_0x001f
            r4.queueEndOfStream()
        L_0x001f:
            r9.processBuffers(r7)
            boolean r0 = r4.isEnded()
            if (r0 != 0) goto L_0x0029
            return r3
        L_0x0029:
            int r0 = r9.drainingAudioProcessorIndex
            int r0 = r0 + r2
            r9.drainingAudioProcessorIndex = r0
            goto L_0x0009
        L_0x002f:
            java.nio.ByteBuffer r0 = r9.outputBuffer
            if (r0 == 0) goto L_0x003b
            r9.writeBuffer(r0, r7)
            java.nio.ByteBuffer r0 = r9.outputBuffer
            if (r0 == 0) goto L_0x003b
            return r3
        L_0x003b:
            r9.drainingAudioProcessorIndex = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.audio.DefaultAudioSink.drainToEndOfStream():boolean");
    }

    private void flushAudioProcessors() {
        int i11 = 0;
        while (true) {
            AudioProcessor[] audioProcessorArr = this.activeAudioProcessors;
            if (i11 < audioProcessorArr.length) {
                AudioProcessor audioProcessor = audioProcessorArr[i11];
                audioProcessor.flush();
                this.outputBuffers[i11] = audioProcessor.getOutput();
                i11++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: private */
    public static AudioFormat getAudioFormat(int i11, int i12, int i13) {
        return new AudioFormat.Builder().setSampleRate(i11).setChannelMask(i12).setEncoding(i13).build();
    }

    private PlaybackParameters getAudioProcessorPlaybackParameters() {
        return getMediaPositionParameters().playbackParameters;
    }

    private static int getChannelConfigForPassthrough(int i11) {
        int i12 = Util.SDK_INT;
        if (i12 <= 28) {
            if (i11 == 7) {
                i11 = 8;
            } else if (i11 == 3 || i11 == 4 || i11 == 5) {
                i11 = 6;
            }
        }
        if (i12 <= 26 && "fugu".equals(Util.DEVICE) && i11 == 1) {
            i11 = 2;
        }
        return Util.getAudioTrackChannelConfig(i11);
    }

    private static Pair<Integer, Integer> getEncodingAndChannelConfigForPassthrough(Format format, AudioCapabilities audioCapabilities2) {
        if (audioCapabilities2 == null) {
            return null;
        }
        int encoding = MimeTypes.getEncoding((String) Assertions.checkNotNull(format.sampleMimeType), format.codecs);
        int i11 = 6;
        if (!(encoding == 5 || encoding == 6 || encoding == 18 || encoding == 17 || encoding == 7 || encoding == 8 || encoding == 14)) {
            return null;
        }
        if (encoding == 18 && !audioCapabilities2.supportsEncoding(18)) {
            encoding = 6;
        } else if (encoding == 8 && !audioCapabilities2.supportsEncoding(8)) {
            encoding = 7;
        }
        if (!audioCapabilities2.supportsEncoding(encoding)) {
            return null;
        }
        if (encoding != 18) {
            i11 = format.channelCount;
            if (i11 > audioCapabilities2.getMaxChannelCount()) {
                return null;
            }
        } else if (Util.SDK_INT >= 29 && (i11 = getMaxSupportedChannelCountForPassthroughV29(18, format.sampleRate)) == 0) {
            Log.w(TAG, "E-AC3 JOC encoding supported but no channel count supported");
            return null;
        }
        int channelConfigForPassthrough = getChannelConfigForPassthrough(i11);
        if (channelConfigForPassthrough == 0) {
            return null;
        }
        return Pair.create(Integer.valueOf(encoding), Integer.valueOf(channelConfigForPassthrough));
    }

    private static int getFramesPerEncodedSample(int i11, ByteBuffer byteBuffer) {
        switch (i11) {
            case 5:
            case 6:
            case 18:
                return Ac3Util.parseAc3SyncframeAudioSampleCount(byteBuffer);
            case 7:
            case 8:
                return DtsUtil.parseDtsAudioSampleCount(byteBuffer);
            case 9:
                int parseMpegAudioFrameSampleCount = MpegAudioUtil.parseMpegAudioFrameSampleCount(Util.getBigEndianInt(byteBuffer, byteBuffer.position()));
                if (parseMpegAudioFrameSampleCount != -1) {
                    return parseMpegAudioFrameSampleCount;
                }
                throw new IllegalArgumentException();
            case 10:
                return 1024;
            case 11:
            case 12:
                return 2048;
            case 14:
                int findTrueHdSyncframeOffset = Ac3Util.findTrueHdSyncframeOffset(byteBuffer);
                if (findTrueHdSyncframeOffset == -1) {
                    return 0;
                }
                return Ac3Util.parseTrueHdSyncframeAudioSampleCount(byteBuffer, findTrueHdSyncframeOffset) * 16;
            case 15:
                return 512;
            case 16:
                return 1024;
            case 17:
                return Ac4Util.parseAc4SyncframeAudioSampleCount(byteBuffer);
            default:
                StringBuilder sb2 = new StringBuilder(38);
                sb2.append("Unexpected audio encoding: ");
                sb2.append(i11);
                throw new IllegalStateException(sb2.toString());
        }
    }

    private static int getMaxSupportedChannelCountForPassthroughV29(int i11, int i12) {
        AudioAttributes build = new AudioAttributes.Builder().setUsage(1).setContentType(3).build();
        for (int i13 = 8; i13 > 0; i13--) {
            if (AudioTrack.isDirectPlaybackSupported(new AudioFormat.Builder().setEncoding(i11).setSampleRate(i12).setChannelMask(Util.getAudioTrackChannelConfig(i13)).build(), build)) {
                return i13;
            }
        }
        return 0;
    }

    /* access modifiers changed from: private */
    public static int getMaximumEncodedRateBytesPerSecond(int i11) {
        switch (i11) {
            case 5:
                return 80000;
            case 6:
            case 18:
                return Ac3Util.E_AC3_MAX_RATE_BYTES_PER_SECOND;
            case 7:
                return DtsUtil.DTS_MAX_RATE_BYTES_PER_SECOND;
            case 8:
                return DtsUtil.DTS_HD_MAX_RATE_BYTES_PER_SECOND;
            case 9:
                return MpegAudioUtil.MAX_RATE_BYTES_PER_SECOND;
            case 10:
                return AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND;
            case 11:
                return 16000;
            case 12:
                return AacUtil.AAC_HE_V2_MAX_RATE_BYTES_PER_SECOND;
            case 14:
                return Ac3Util.TRUEHD_MAX_RATE_BYTES_PER_SECOND;
            case 15:
                return 8000;
            case 16:
                return AacUtil.AAC_XHE_MAX_RATE_BYTES_PER_SECOND;
            case 17:
                return Ac4Util.MAX_RATE_BYTES_PER_SECOND;
            default:
                throw new IllegalArgumentException();
        }
    }

    private MediaPositionParameters getMediaPositionParameters() {
        MediaPositionParameters mediaPositionParameters2 = this.afterDrainParameters;
        if (mediaPositionParameters2 != null) {
            return mediaPositionParameters2;
        }
        if (!this.mediaPositionParametersCheckpoints.isEmpty()) {
            return this.mediaPositionParametersCheckpoints.getLast();
        }
        return this.mediaPositionParameters;
    }

    /* access modifiers changed from: private */
    public long getSubmittedFrames() {
        Configuration configuration2 = this.configuration;
        if (configuration2.outputMode == 0) {
            return this.submittedPcmBytes / ((long) configuration2.inputPcmFrameSize);
        }
        return this.submittedEncodedFrames;
    }

    /* access modifiers changed from: private */
    public long getWrittenFrames() {
        Configuration configuration2 = this.configuration;
        if (configuration2.outputMode == 0) {
            return this.writtenPcmBytes / ((long) configuration2.outputPcmFrameSize);
        }
        return this.writtenEncodedFrames;
    }

    private void initializeAudioTrack() throws AudioSink.InitializationException {
        this.releasingConditionVariable.block();
        AudioTrack buildAudioTrack = buildAudioTrack();
        this.audioTrack = buildAudioTrack;
        if (isOffloadedPlayback(buildAudioTrack)) {
            registerStreamEventCallbackV29(this.audioTrack);
            AudioTrack audioTrack2 = this.audioTrack;
            Format format = this.configuration.inputFormat;
            audioTrack2.setOffloadDelayPadding(format.encoderDelay, format.encoderPadding);
        }
        this.audioSessionId = this.audioTrack.getAudioSessionId();
        AudioTrackPositionTracker audioTrackPositionTracker2 = this.audioTrackPositionTracker;
        AudioTrack audioTrack3 = this.audioTrack;
        Configuration configuration2 = this.configuration;
        audioTrackPositionTracker2.setAudioTrack(audioTrack3, configuration2.outputMode == 2, configuration2.outputEncoding, configuration2.outputPcmFrameSize, configuration2.bufferSize);
        setVolumeInternal();
        int i11 = this.auxEffectInfo.effectId;
        if (i11 != 0) {
            this.audioTrack.attachAuxEffect(i11);
            this.audioTrack.setAuxEffectSendLevel(this.auxEffectInfo.sendLevel);
        }
        this.startMediaTimeUsNeedsInit = true;
    }

    private static boolean isAudioTrackDeadObject(int i11) {
        return (Util.SDK_INT >= 24 && i11 == -6) || i11 == ERROR_NATIVE_DEAD_OBJECT;
    }

    private boolean isAudioTrackInitialized() {
        return this.audioTrack != null;
    }

    private static boolean isOffloadedGaplessPlaybackSupported() {
        return Util.SDK_INT >= 30 && Util.MODEL.startsWith("Pixel");
    }

    private static boolean isOffloadedPlayback(AudioTrack audioTrack2) {
        return Util.SDK_INT >= 29 && audioTrack2.isOffloadedPlayback();
    }

    private static boolean isPassthroughPlaybackSupported(Format format, AudioCapabilities audioCapabilities2) {
        return getEncodingAndChannelConfigForPassthrough(format, audioCapabilities2) != null;
    }

    private void maybeDisableOffload() {
        if (this.configuration.outputModeIsOffload()) {
            this.offloadDisabledUntilNextConfiguration = true;
        }
    }

    private void playPendingData() {
        if (!this.stoppedAudioTrack) {
            this.stoppedAudioTrack = true;
            this.audioTrackPositionTracker.handleEndOfStream(getWrittenFrames());
            this.audioTrack.stop();
            this.bytesUntilNextAvSync = 0;
        }
    }

    private void processBuffers(long j11) throws AudioSink.WriteException {
        ByteBuffer byteBuffer;
        int length = this.activeAudioProcessors.length;
        int i11 = length;
        while (i11 >= 0) {
            if (i11 > 0) {
                byteBuffer = this.outputBuffers[i11 - 1];
            } else {
                byteBuffer = this.inputBuffer;
                if (byteBuffer == null) {
                    byteBuffer = AudioProcessor.EMPTY_BUFFER;
                }
            }
            if (i11 == length) {
                writeBuffer(byteBuffer, j11);
            } else {
                AudioProcessor audioProcessor = this.activeAudioProcessors[i11];
                if (i11 > this.drainingAudioProcessorIndex) {
                    audioProcessor.queueInput(byteBuffer);
                }
                ByteBuffer output = audioProcessor.getOutput();
                this.outputBuffers[i11] = output;
                if (output.hasRemaining()) {
                    i11++;
                }
            }
            if (!byteBuffer.hasRemaining()) {
                i11--;
            } else {
                return;
            }
        }
    }

    private void registerStreamEventCallbackV29(AudioTrack audioTrack2) {
        if (this.offloadStreamEventCallbackV29 == null) {
            this.offloadStreamEventCallbackV29 = new StreamEventCallbackV29();
        }
        this.offloadStreamEventCallbackV29.register(audioTrack2);
    }

    private void resetSinkStateForFlush() {
        this.submittedPcmBytes = 0;
        this.submittedEncodedFrames = 0;
        this.writtenPcmBytes = 0;
        this.writtenEncodedFrames = 0;
        this.isWaitingForOffloadEndOfStreamHandled = false;
        this.framesPerEncodedSample = 0;
        this.mediaPositionParameters = new MediaPositionParameters(getAudioProcessorPlaybackParameters(), getSkipSilenceEnabled(), 0, 0);
        this.startMediaTimeUs = 0;
        this.afterDrainParameters = null;
        this.mediaPositionParametersCheckpoints.clear();
        this.inputBuffer = null;
        this.inputBufferAccessUnitCount = 0;
        this.outputBuffer = null;
        this.stoppedAudioTrack = false;
        this.handledEndOfStream = false;
        this.drainingAudioProcessorIndex = -1;
        this.avSyncHeader = null;
        this.bytesUntilNextAvSync = 0;
        this.trimmingAudioProcessor.resetTrimmedFrameCount();
        flushAudioProcessors();
    }

    private void setAudioProcessorPlaybackParametersAndSkipSilence(PlaybackParameters playbackParameters, boolean z11) {
        MediaPositionParameters mediaPositionParameters2 = getMediaPositionParameters();
        if (!playbackParameters.equals(mediaPositionParameters2.playbackParameters) || z11 != mediaPositionParameters2.skipSilence) {
            MediaPositionParameters mediaPositionParameters3 = new MediaPositionParameters(playbackParameters, z11, -9223372036854775807L, -9223372036854775807L);
            if (isAudioTrackInitialized()) {
                this.afterDrainParameters = mediaPositionParameters3;
            } else {
                this.mediaPositionParameters = mediaPositionParameters3;
            }
        }
    }

    private void setAudioTrackPlaybackParametersV23(PlaybackParameters playbackParameters) {
        if (isAudioTrackInitialized()) {
            try {
                this.audioTrack.setPlaybackParams(new PlaybackParams().allowDefaults().setSpeed(playbackParameters.speed).setPitch(playbackParameters.pitch).setAudioFallbackMode(2));
            } catch (IllegalArgumentException e11) {
                Log.w(TAG, "Failed to set playback params", e11);
            }
            playbackParameters = new PlaybackParameters(this.audioTrack.getPlaybackParams().getSpeed(), this.audioTrack.getPlaybackParams().getPitch());
            this.audioTrackPositionTracker.setAudioTrackPlaybackSpeed(playbackParameters.speed);
        }
        this.audioTrackPlaybackParameters = playbackParameters;
    }

    private void setVolumeInternal() {
        if (isAudioTrackInitialized()) {
            if (Util.SDK_INT >= 21) {
                setVolumeInternalV21(this.audioTrack, this.volume);
            } else {
                setVolumeInternalV3(this.audioTrack, this.volume);
            }
        }
    }

    private static void setVolumeInternalV21(AudioTrack audioTrack2, float f11) {
        audioTrack2.setVolume(f11);
    }

    private static void setVolumeInternalV3(AudioTrack audioTrack2, float f11) {
        audioTrack2.setStereoVolume(f11, f11);
    }

    private void setupAudioProcessors() {
        AudioProcessor[] audioProcessorArr = this.configuration.availableAudioProcessors;
        ArrayList arrayList = new ArrayList();
        for (AudioProcessor audioProcessor : audioProcessorArr) {
            if (audioProcessor.isActive()) {
                arrayList.add(audioProcessor);
            } else {
                audioProcessor.flush();
            }
        }
        int size = arrayList.size();
        this.activeAudioProcessors = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[size]);
        this.outputBuffers = new ByteBuffer[size];
        flushAudioProcessors();
    }

    private boolean shouldApplyAudioProcessorPlaybackParameters() {
        return !this.tunneling && MimeTypes.AUDIO_RAW.equals(this.configuration.inputFormat.sampleMimeType) && !shouldUseFloatOutput(this.configuration.inputFormat.pcmEncoding);
    }

    private boolean shouldUseFloatOutput(int i11) {
        return this.enableFloatOutput && Util.isEncodingHighResolutionPcm(i11);
    }

    private boolean useOffloadedPlayback(Format format, AudioAttributes audioAttributes2) {
        int encoding;
        int audioTrackChannelConfig;
        if (Util.SDK_INT < 29 || this.offloadMode == 0 || (encoding = MimeTypes.getEncoding((String) Assertions.checkNotNull(format.sampleMimeType), format.codecs)) == 0 || (audioTrackChannelConfig = Util.getAudioTrackChannelConfig(format.channelCount)) == 0 || !AudioManager.isOffloadedPlaybackSupported(getAudioFormat(format.sampleRate, audioTrackChannelConfig, encoding), audioAttributes2.getAudioAttributesV21())) {
            return false;
        }
        boolean z11 = (format.encoderDelay == 0 && format.encoderPadding == 0) ? false : true;
        boolean z12 = this.offloadMode == 1;
        if (!z11 || !z12 || isOffloadedGaplessPlaybackSupported()) {
            return true;
        }
        return false;
    }

    private void writeBuffer(ByteBuffer byteBuffer, long j11) throws AudioSink.WriteException {
        int i11;
        if (byteBuffer.hasRemaining()) {
            ByteBuffer byteBuffer2 = this.outputBuffer;
            boolean z11 = true;
            if (byteBuffer2 != null) {
                Assertions.checkArgument(byteBuffer2 == byteBuffer);
            } else {
                this.outputBuffer = byteBuffer;
                if (Util.SDK_INT < 21) {
                    int remaining = byteBuffer.remaining();
                    byte[] bArr = this.preV21OutputBuffer;
                    if (bArr == null || bArr.length < remaining) {
                        this.preV21OutputBuffer = new byte[remaining];
                    }
                    int position = byteBuffer.position();
                    byteBuffer.get(this.preV21OutputBuffer, 0, remaining);
                    byteBuffer.position(position);
                    this.preV21OutputBufferOffset = 0;
                }
            }
            int remaining2 = byteBuffer.remaining();
            if (Util.SDK_INT < 21) {
                int availableBufferSize = this.audioTrackPositionTracker.getAvailableBufferSize(this.writtenPcmBytes);
                if (availableBufferSize > 0) {
                    i11 = this.audioTrack.write(this.preV21OutputBuffer, this.preV21OutputBufferOffset, Math.min(remaining2, availableBufferSize));
                    if (i11 > 0) {
                        this.preV21OutputBufferOffset += i11;
                        byteBuffer.position(byteBuffer.position() + i11);
                    }
                } else {
                    i11 = 0;
                }
            } else if (this.tunneling) {
                Assertions.checkState(j11 != -9223372036854775807L);
                i11 = writeNonBlockingWithAvSyncV21(this.audioTrack, byteBuffer, remaining2, j11);
            } else {
                i11 = writeNonBlockingV21(this.audioTrack, byteBuffer, remaining2);
            }
            this.lastFeedElapsedRealtimeMs = SystemClock.elapsedRealtime();
            if (i11 < 0) {
                boolean isAudioTrackDeadObject = isAudioTrackDeadObject(i11);
                if (isAudioTrackDeadObject) {
                    maybeDisableOffload();
                }
                AudioSink.WriteException writeException = new AudioSink.WriteException(i11, this.configuration.inputFormat, isAudioTrackDeadObject);
                AudioSink.Listener listener2 = this.listener;
                if (listener2 != null) {
                    listener2.onAudioSinkError(writeException);
                }
                if (!writeException.isRecoverable) {
                    this.writeExceptionPendingExceptionHolder.throwExceptionIfDeadlineIsReached(writeException);
                    return;
                }
                throw writeException;
            }
            this.writeExceptionPendingExceptionHolder.clear();
            if (isOffloadedPlayback(this.audioTrack)) {
                long j12 = this.writtenEncodedFrames;
                if (j12 > 0) {
                    this.isWaitingForOffloadEndOfStreamHandled = false;
                }
                if (this.playing && this.listener != null && i11 < remaining2 && !this.isWaitingForOffloadEndOfStreamHandled) {
                    this.listener.onOffloadBufferFull(this.audioTrackPositionTracker.getPendingBufferDurationMs(j12));
                }
            }
            int i12 = this.configuration.outputMode;
            if (i12 == 0) {
                this.writtenPcmBytes += (long) i11;
            }
            if (i11 == remaining2) {
                if (i12 != 0) {
                    if (byteBuffer != this.inputBuffer) {
                        z11 = false;
                    }
                    Assertions.checkState(z11);
                    this.writtenEncodedFrames += (long) (this.framesPerEncodedSample * this.inputBufferAccessUnitCount);
                }
                this.outputBuffer = null;
            }
        }
    }

    private static int writeNonBlockingV21(AudioTrack audioTrack2, ByteBuffer byteBuffer, int i11) {
        return audioTrack2.write(byteBuffer, i11, 1);
    }

    private int writeNonBlockingWithAvSyncV21(AudioTrack audioTrack2, ByteBuffer byteBuffer, int i11, long j11) {
        if (Util.SDK_INT >= 26) {
            return audioTrack2.write(byteBuffer, i11, 1, j11 * 1000);
        }
        if (this.avSyncHeader == null) {
            ByteBuffer allocate = ByteBuffer.allocate(16);
            this.avSyncHeader = allocate;
            allocate.order(ByteOrder.BIG_ENDIAN);
            this.avSyncHeader.putInt(1431633921);
        }
        if (this.bytesUntilNextAvSync == 0) {
            this.avSyncHeader.putInt(4, i11);
            this.avSyncHeader.putLong(8, j11 * 1000);
            this.avSyncHeader.position(0);
            this.bytesUntilNextAvSync = i11;
        }
        int remaining = this.avSyncHeader.remaining();
        if (remaining > 0) {
            int write = audioTrack2.write(this.avSyncHeader, remaining, 1);
            if (write < 0) {
                this.bytesUntilNextAvSync = 0;
                return write;
            } else if (write < remaining) {
                return 0;
            }
        }
        int writeNonBlockingV21 = writeNonBlockingV21(audioTrack2, byteBuffer, i11);
        if (writeNonBlockingV21 < 0) {
            this.bytesUntilNextAvSync = 0;
            return writeNonBlockingV21;
        }
        this.bytesUntilNextAvSync -= writeNonBlockingV21;
        return writeNonBlockingV21;
    }

    public void configure(Format format, int i11, int[] iArr) throws AudioSink.ConfigurationException {
        AudioProcessor[] audioProcessorArr;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        AudioProcessor[] audioProcessorArr2;
        int[] iArr2;
        Format format2 = format;
        if (MimeTypes.AUDIO_RAW.equals(format2.sampleMimeType)) {
            Assertions.checkArgument(Util.isEncodingLinearPcm(format2.pcmEncoding));
            i17 = Util.getPcmFrameSize(format2.pcmEncoding, format2.channelCount);
            if (shouldUseFloatOutput(format2.pcmEncoding)) {
                audioProcessorArr2 = this.toFloatPcmAvailableAudioProcessors;
            } else {
                audioProcessorArr2 = this.toIntPcmAvailableAudioProcessors;
            }
            this.trimmingAudioProcessor.setTrimFrameCount(format2.encoderDelay, format2.encoderPadding);
            if (Util.SDK_INT < 21 && format2.channelCount == 8 && iArr == null) {
                iArr2 = new int[6];
                for (int i18 = 0; i18 < 6; i18++) {
                    iArr2[i18] = i18;
                }
            } else {
                iArr2 = iArr;
            }
            this.channelMappingAudioProcessor.setChannelMap(iArr2);
            AudioProcessor.AudioFormat audioFormat = new AudioProcessor.AudioFormat(format2.sampleRate, format2.channelCount, format2.pcmEncoding);
            int length = audioProcessorArr2.length;
            int i19 = 0;
            while (i19 < length) {
                AudioProcessor audioProcessor = audioProcessorArr2[i19];
                try {
                    AudioProcessor.AudioFormat configure = audioProcessor.configure(audioFormat);
                    if (audioProcessor.isActive()) {
                        audioFormat = configure;
                    }
                    i19++;
                } catch (AudioProcessor.UnhandledAudioFormatException e11) {
                    throw new AudioSink.ConfigurationException((Throwable) e11, format2);
                }
            }
            int i21 = audioFormat.encoding;
            i14 = audioFormat.sampleRate;
            i13 = Util.getAudioTrackChannelConfig(audioFormat.channelCount);
            audioProcessorArr = audioProcessorArr2;
            i12 = i21;
            i15 = Util.getPcmFrameSize(i21, audioFormat.channelCount);
            i16 = 0;
        } else {
            AudioProcessor[] audioProcessorArr3 = new AudioProcessor[0];
            int i22 = format2.sampleRate;
            if (useOffloadedPlayback(format2, this.audioAttributes)) {
                audioProcessorArr = audioProcessorArr3;
                i17 = -1;
                i12 = MimeTypes.getEncoding((String) Assertions.checkNotNull(format2.sampleMimeType), format2.codecs);
                i15 = -1;
                i14 = i22;
                i16 = 1;
                i13 = Util.getAudioTrackChannelConfig(format2.channelCount);
            } else {
                Pair<Integer, Integer> encodingAndChannelConfigForPassthrough = getEncodingAndChannelConfigForPassthrough(format2, this.audioCapabilities);
                if (encodingAndChannelConfigForPassthrough != null) {
                    audioProcessorArr = audioProcessorArr3;
                    i17 = -1;
                    i12 = ((Integer) encodingAndChannelConfigForPassthrough.first).intValue();
                    i13 = ((Integer) encodingAndChannelConfigForPassthrough.second).intValue();
                    i14 = i22;
                    i16 = 2;
                    i15 = -1;
                } else {
                    String valueOf = String.valueOf(format);
                    StringBuilder sb2 = new StringBuilder(valueOf.length() + 37);
                    sb2.append("Unable to configure passthrough for: ");
                    sb2.append(valueOf);
                    throw new AudioSink.ConfigurationException(sb2.toString(), format2);
                }
            }
        }
        if (i12 == 0) {
            String valueOf2 = String.valueOf(format);
            StringBuilder sb3 = new StringBuilder(valueOf2.length() + 48);
            sb3.append("Invalid output encoding (mode=");
            sb3.append(i16);
            sb3.append(") for: ");
            sb3.append(valueOf2);
            throw new AudioSink.ConfigurationException(sb3.toString(), format2);
        } else if (i13 != 0) {
            this.offloadDisabledUntilNextConfiguration = false;
            Configuration configuration2 = new Configuration(format, i17, i16, i15, i14, i13, i12, i11, this.enableAudioTrackPlaybackParams, audioProcessorArr);
            if (isAudioTrackInitialized()) {
                this.pendingConfiguration = configuration2;
            } else {
                this.configuration = configuration2;
            }
        } else {
            String valueOf3 = String.valueOf(format);
            StringBuilder sb4 = new StringBuilder(valueOf3.length() + 54);
            sb4.append("Invalid output channel config (mode=");
            sb4.append(i16);
            sb4.append(") for: ");
            sb4.append(valueOf3);
            throw new AudioSink.ConfigurationException(sb4.toString(), format2);
        }
    }

    public void disableTunneling() {
        if (this.tunneling) {
            this.tunneling = false;
            flush();
        }
    }

    public void enableTunnelingV21() {
        Assertions.checkState(Util.SDK_INT >= 21);
        Assertions.checkState(this.externalAudioSessionIdProvided);
        if (!this.tunneling) {
            this.tunneling = true;
            flush();
        }
    }

    public void experimentalFlushWithoutAudioTrackRelease() {
        if (Util.SDK_INT < 25) {
            flush();
            return;
        }
        this.writeExceptionPendingExceptionHolder.clear();
        this.initializationExceptionPendingExceptionHolder.clear();
        if (isAudioTrackInitialized()) {
            resetSinkStateForFlush();
            if (this.audioTrackPositionTracker.isPlaying()) {
                this.audioTrack.pause();
            }
            this.audioTrack.flush();
            this.audioTrackPositionTracker.reset();
            AudioTrackPositionTracker audioTrackPositionTracker2 = this.audioTrackPositionTracker;
            AudioTrack audioTrack2 = this.audioTrack;
            Configuration configuration2 = this.configuration;
            audioTrackPositionTracker2.setAudioTrack(audioTrack2, configuration2.outputMode == 2, configuration2.outputEncoding, configuration2.outputPcmFrameSize, configuration2.bufferSize);
            this.startMediaTimeUsNeedsInit = true;
        }
    }

    public void flush() {
        if (isAudioTrackInitialized()) {
            resetSinkStateForFlush();
            if (this.audioTrackPositionTracker.isPlaying()) {
                this.audioTrack.pause();
            }
            if (isOffloadedPlayback(this.audioTrack)) {
                ((StreamEventCallbackV29) Assertions.checkNotNull(this.offloadStreamEventCallbackV29)).unregister(this.audioTrack);
            }
            final AudioTrack audioTrack2 = this.audioTrack;
            this.audioTrack = null;
            if (Util.SDK_INT < 21 && !this.externalAudioSessionIdProvided) {
                this.audioSessionId = 0;
            }
            Configuration configuration2 = this.pendingConfiguration;
            if (configuration2 != null) {
                this.configuration = configuration2;
                this.pendingConfiguration = null;
            }
            this.audioTrackPositionTracker.reset();
            this.releasingConditionVariable.close();
            new Thread("ExoPlayer:AudioTrackReleaseThread") {
                public void run() {
                    try {
                        audioTrack2.flush();
                        audioTrack2.release();
                    } finally {
                        DefaultAudioSink.this.releasingConditionVariable.open();
                    }
                }
            }.start();
        }
        this.writeExceptionPendingExceptionHolder.clear();
        this.initializationExceptionPendingExceptionHolder.clear();
    }

    public long getCurrentPositionUs(boolean z11) {
        if (!isAudioTrackInitialized() || this.startMediaTimeUsNeedsInit) {
            return Long.MIN_VALUE;
        }
        return applySkipping(applyMediaPositionParameters(Math.min(this.audioTrackPositionTracker.getCurrentPositionUs(z11), this.configuration.framesToDurationUs(getWrittenFrames()))));
    }

    public int getFormatSupport(Format format) {
        if (!MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
            return ((this.offloadDisabledUntilNextConfiguration || !useOffloadedPlayback(format, this.audioAttributes)) && !isPassthroughPlaybackSupported(format, this.audioCapabilities)) ? 0 : 2;
        }
        if (!Util.isEncodingLinearPcm(format.pcmEncoding)) {
            int i11 = format.pcmEncoding;
            StringBuilder sb2 = new StringBuilder(33);
            sb2.append("Invalid PCM encoding: ");
            sb2.append(i11);
            Log.w(TAG, sb2.toString());
            return 0;
        }
        int i12 = format.pcmEncoding;
        if (i12 == 2 || (this.enableFloatOutput && i12 == 4)) {
            return 2;
        }
        return 1;
    }

    public PlaybackParameters getPlaybackParameters() {
        if (this.enableAudioTrackPlaybackParams) {
            return this.audioTrackPlaybackParameters;
        }
        return getAudioProcessorPlaybackParameters();
    }

    public boolean getSkipSilenceEnabled() {
        return getMediaPositionParameters().skipSilence;
    }

    public boolean handleBuffer(ByteBuffer byteBuffer, long j11, int i11) throws AudioSink.InitializationException, AudioSink.WriteException {
        ByteBuffer byteBuffer2 = byteBuffer;
        long j12 = j11;
        int i12 = i11;
        ByteBuffer byteBuffer3 = this.inputBuffer;
        Assertions.checkArgument(byteBuffer3 == null || byteBuffer2 == byteBuffer3);
        if (this.pendingConfiguration != null) {
            if (!drainToEndOfStream()) {
                return false;
            }
            if (!this.pendingConfiguration.canReuseAudioTrack(this.configuration)) {
                playPendingData();
                if (hasPendingData()) {
                    return false;
                }
                flush();
            } else {
                this.configuration = this.pendingConfiguration;
                this.pendingConfiguration = null;
                if (isOffloadedPlayback(this.audioTrack)) {
                    this.audioTrack.setOffloadEndOfStream();
                    AudioTrack audioTrack2 = this.audioTrack;
                    Format format = this.configuration.inputFormat;
                    audioTrack2.setOffloadDelayPadding(format.encoderDelay, format.encoderPadding);
                    this.isWaitingForOffloadEndOfStreamHandled = true;
                }
            }
            applyAudioProcessorPlaybackParametersAndSkipSilence(j12);
        }
        if (!isAudioTrackInitialized()) {
            try {
                initializeAudioTrack();
            } catch (AudioSink.InitializationException e11) {
                AudioSink.InitializationException initializationException = e11;
                if (!initializationException.isRecoverable) {
                    this.initializationExceptionPendingExceptionHolder.throwExceptionIfDeadlineIsReached(initializationException);
                    return false;
                }
                throw initializationException;
            }
        }
        this.initializationExceptionPendingExceptionHolder.clear();
        if (this.startMediaTimeUsNeedsInit) {
            this.startMediaTimeUs = Math.max(0, j12);
            this.startMediaTimeUsNeedsSync = false;
            this.startMediaTimeUsNeedsInit = false;
            if (this.enableAudioTrackPlaybackParams && Util.SDK_INT >= 23) {
                setAudioTrackPlaybackParametersV23(this.audioTrackPlaybackParameters);
            }
            applyAudioProcessorPlaybackParametersAndSkipSilence(j12);
            if (this.playing) {
                play();
            }
        }
        if (!this.audioTrackPositionTracker.mayHandleBuffer(getWrittenFrames())) {
            return false;
        }
        if (this.inputBuffer == null) {
            Assertions.checkArgument(byteBuffer.order() == ByteOrder.LITTLE_ENDIAN);
            if (!byteBuffer.hasRemaining()) {
                return true;
            }
            Configuration configuration2 = this.configuration;
            if (configuration2.outputMode != 0 && this.framesPerEncodedSample == 0) {
                int framesPerEncodedSample2 = getFramesPerEncodedSample(configuration2.outputEncoding, byteBuffer2);
                this.framesPerEncodedSample = framesPerEncodedSample2;
                if (framesPerEncodedSample2 == 0) {
                    return true;
                }
            }
            if (this.afterDrainParameters != null) {
                if (!drainToEndOfStream()) {
                    return false;
                }
                applyAudioProcessorPlaybackParametersAndSkipSilence(j12);
                this.afterDrainParameters = null;
            }
            long inputFramesToDurationUs = this.startMediaTimeUs + this.configuration.inputFramesToDurationUs(getSubmittedFrames() - this.trimmingAudioProcessor.getTrimmedFrameCount());
            if (!this.startMediaTimeUsNeedsSync && Math.abs(inputFramesToDurationUs - j12) > 200000) {
                this.listener.onAudioSinkError(new AudioSink.UnexpectedDiscontinuityException(j12, inputFramesToDurationUs));
                this.startMediaTimeUsNeedsSync = true;
            }
            if (this.startMediaTimeUsNeedsSync) {
                if (!drainToEndOfStream()) {
                    return false;
                }
                long j13 = j12 - inputFramesToDurationUs;
                this.startMediaTimeUs += j13;
                this.startMediaTimeUsNeedsSync = false;
                applyAudioProcessorPlaybackParametersAndSkipSilence(j12);
                AudioSink.Listener listener2 = this.listener;
                if (!(listener2 == null || j13 == 0)) {
                    listener2.onPositionDiscontinuity();
                }
            }
            if (this.configuration.outputMode == 0) {
                this.submittedPcmBytes += (long) byteBuffer.remaining();
            } else {
                this.submittedEncodedFrames += (long) (this.framesPerEncodedSample * i12);
            }
            this.inputBuffer = byteBuffer2;
            this.inputBufferAccessUnitCount = i12;
        }
        processBuffers(j12);
        if (!this.inputBuffer.hasRemaining()) {
            this.inputBuffer = null;
            this.inputBufferAccessUnitCount = 0;
            return true;
        } else if (!this.audioTrackPositionTracker.isStalled(getWrittenFrames())) {
            return false;
        } else {
            Log.w(TAG, "Resetting stalled audio track");
            flush();
            return true;
        }
    }

    public void handleDiscontinuity() {
        this.startMediaTimeUsNeedsSync = true;
    }

    public boolean hasPendingData() {
        return isAudioTrackInitialized() && this.audioTrackPositionTracker.hasPendingData(getWrittenFrames());
    }

    public boolean isEnded() {
        return !isAudioTrackInitialized() || (this.handledEndOfStream && !hasPendingData());
    }

    public void pause() {
        this.playing = false;
        if (isAudioTrackInitialized() && this.audioTrackPositionTracker.pause()) {
            this.audioTrack.pause();
        }
    }

    public void play() {
        this.playing = true;
        if (isAudioTrackInitialized()) {
            this.audioTrackPositionTracker.start();
            this.audioTrack.play();
        }
    }

    public void playToEndOfStream() throws AudioSink.WriteException {
        if (!this.handledEndOfStream && isAudioTrackInitialized() && drainToEndOfStream()) {
            playPendingData();
            this.handledEndOfStream = true;
        }
    }

    public void reset() {
        flush();
        for (AudioProcessor reset : this.toIntPcmAvailableAudioProcessors) {
            reset.reset();
        }
        for (AudioProcessor reset2 : this.toFloatPcmAvailableAudioProcessors) {
            reset2.reset();
        }
        this.playing = false;
        this.offloadDisabledUntilNextConfiguration = false;
    }

    public void setAudioAttributes(AudioAttributes audioAttributes2) {
        if (!this.audioAttributes.equals(audioAttributes2)) {
            this.audioAttributes = audioAttributes2;
            if (!this.tunneling) {
                flush();
            }
        }
    }

    public void setAudioSessionId(int i11) {
        if (this.audioSessionId != i11) {
            this.audioSessionId = i11;
            this.externalAudioSessionIdProvided = i11 != 0;
            flush();
        }
    }

    public void setAuxEffectInfo(AuxEffectInfo auxEffectInfo2) {
        if (!this.auxEffectInfo.equals(auxEffectInfo2)) {
            int i11 = auxEffectInfo2.effectId;
            float f11 = auxEffectInfo2.sendLevel;
            AudioTrack audioTrack2 = this.audioTrack;
            if (audioTrack2 != null) {
                if (this.auxEffectInfo.effectId != i11) {
                    audioTrack2.attachAuxEffect(i11);
                }
                if (i11 != 0) {
                    this.audioTrack.setAuxEffectSendLevel(f11);
                }
            }
            this.auxEffectInfo = auxEffectInfo2;
        }
    }

    public void setListener(AudioSink.Listener listener2) {
        this.listener = listener2;
    }

    public void setPlaybackParameters(PlaybackParameters playbackParameters) {
        PlaybackParameters playbackParameters2 = new PlaybackParameters(Util.constrainValue(playbackParameters.speed, 0.1f, 8.0f), Util.constrainValue(playbackParameters.pitch, 0.1f, 8.0f));
        if (!this.enableAudioTrackPlaybackParams || Util.SDK_INT < 23) {
            setAudioProcessorPlaybackParametersAndSkipSilence(playbackParameters2, getSkipSilenceEnabled());
        } else {
            setAudioTrackPlaybackParametersV23(playbackParameters2);
        }
    }

    public void setSkipSilenceEnabled(boolean z11) {
        setAudioProcessorPlaybackParametersAndSkipSilence(getAudioProcessorPlaybackParameters(), z11);
    }

    public void setVolume(float f11) {
        if (this.volume != f11) {
            this.volume = f11;
            setVolumeInternal();
        }
    }

    public boolean supportsFormat(Format format) {
        return getFormatSupport(format) != 0;
    }

    public DefaultAudioSink(AudioCapabilities audioCapabilities2, AudioProcessor[] audioProcessorArr, boolean z11) {
        this(audioCapabilities2, new DefaultAudioProcessorChain(audioProcessorArr), z11, false, 0);
    }

    public DefaultAudioSink(AudioCapabilities audioCapabilities2, AudioProcessorChain audioProcessorChain2, boolean z11, boolean z12, int i11) {
        this.audioCapabilities = audioCapabilities2;
        this.audioProcessorChain = (AudioProcessorChain) Assertions.checkNotNull(audioProcessorChain2);
        int i12 = Util.SDK_INT;
        this.enableFloatOutput = i12 >= 21 && z11;
        this.enableAudioTrackPlaybackParams = i12 >= 23 && z12;
        this.offloadMode = i12 < 29 ? 0 : i11;
        this.releasingConditionVariable = new ConditionVariable(true);
        this.audioTrackPositionTracker = new AudioTrackPositionTracker(new PositionTrackerListener());
        ChannelMappingAudioProcessor channelMappingAudioProcessor2 = new ChannelMappingAudioProcessor();
        this.channelMappingAudioProcessor = channelMappingAudioProcessor2;
        TrimmingAudioProcessor trimmingAudioProcessor2 = new TrimmingAudioProcessor();
        this.trimmingAudioProcessor = trimmingAudioProcessor2;
        ArrayList arrayList = new ArrayList();
        Collections.addAll(arrayList, new BaseAudioProcessor[]{new ResamplingAudioProcessor(), channelMappingAudioProcessor2, trimmingAudioProcessor2});
        Collections.addAll(arrayList, audioProcessorChain2.getAudioProcessors());
        this.toIntPcmAvailableAudioProcessors = (AudioProcessor[]) arrayList.toArray(new AudioProcessor[0]);
        this.toFloatPcmAvailableAudioProcessors = new AudioProcessor[]{new FloatResamplingAudioProcessor()};
        this.volume = 1.0f;
        this.audioAttributes = AudioAttributes.DEFAULT;
        this.audioSessionId = 0;
        this.auxEffectInfo = new AuxEffectInfo(0, 0.0f);
        PlaybackParameters playbackParameters = PlaybackParameters.DEFAULT;
        this.mediaPositionParameters = new MediaPositionParameters(playbackParameters, false, 0, 0);
        this.audioTrackPlaybackParameters = playbackParameters;
        this.drainingAudioProcessorIndex = -1;
        this.activeAudioProcessors = new AudioProcessor[0];
        this.outputBuffers = new ByteBuffer[0];
        this.mediaPositionParametersCheckpoints = new ArrayDeque<>();
        this.initializationExceptionPendingExceptionHolder = new PendingExceptionHolder<>(100);
        this.writeExceptionPendingExceptionHolder = new PendingExceptionHolder<>(100);
    }
}
