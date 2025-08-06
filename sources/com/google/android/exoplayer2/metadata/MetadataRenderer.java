package com.google.android.exoplayer2.metadata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.google.android.exoplayer2.BaseRenderer;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.FormatHolder;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.s0;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Util;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

public final class MetadataRenderer extends BaseRenderer implements Handler.Callback {
    private static final int MSG_INVOKE_RENDERER = 0;
    private static final String TAG = "MetadataRenderer";
    private final MetadataInputBuffer buffer;
    private MetadataDecoder decoder;
    private final MetadataDecoderFactory decoderFactory;
    private boolean inputStreamEnded;
    private final MetadataOutput output;
    private final Handler outputHandler;
    private boolean outputStreamEnded;
    private Metadata pendingMetadata;
    private long pendingMetadataTimestampUs;
    private long subsampleOffsetUs;

    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper) {
        this(metadataOutput, looper, MetadataDecoderFactory.DEFAULT);
    }

    private void decodeWrappedMetadata(Metadata metadata, List<Metadata.Entry> list) {
        for (int i11 = 0; i11 < metadata.length(); i11++) {
            Format wrappedMetadataFormat = metadata.get(i11).getWrappedMetadataFormat();
            if (wrappedMetadataFormat == null || !this.decoderFactory.supportsFormat(wrappedMetadataFormat)) {
                list.add(metadata.get(i11));
            } else {
                MetadataDecoder createDecoder = this.decoderFactory.createDecoder(wrappedMetadataFormat);
                byte[] bArr = (byte[]) Assertions.checkNotNull(metadata.get(i11).getWrappedMetadataBytes());
                this.buffer.clear();
                this.buffer.ensureSpaceForWrite(bArr.length);
                ((ByteBuffer) Util.castNonNull(this.buffer.data)).put(bArr);
                this.buffer.flip();
                Metadata decode = createDecoder.decode(this.buffer);
                if (decode != null) {
                    decodeWrappedMetadata(decode, list);
                }
            }
        }
    }

    private void invokeRenderer(Metadata metadata) {
        Handler handler = this.outputHandler;
        if (handler != null) {
            handler.obtainMessage(0, metadata).sendToTarget();
        } else {
            invokeRendererInternal(metadata);
        }
    }

    private void invokeRendererInternal(Metadata metadata) {
        this.output.onMetadata(metadata);
    }

    private boolean outputMetadata(long j11) {
        boolean z11;
        Metadata metadata = this.pendingMetadata;
        if (metadata == null || this.pendingMetadataTimestampUs > j11) {
            z11 = false;
        } else {
            invokeRenderer(metadata);
            this.pendingMetadata = null;
            this.pendingMetadataTimestampUs = -9223372036854775807L;
            z11 = true;
        }
        if (this.inputStreamEnded && this.pendingMetadata == null) {
            this.outputStreamEnded = true;
        }
        return z11;
    }

    private void readMetadata() {
        if (!this.inputStreamEnded && this.pendingMetadata == null) {
            this.buffer.clear();
            FormatHolder formatHolder = getFormatHolder();
            int readSource = readSource(formatHolder, this.buffer, 0);
            if (readSource == -4) {
                if (this.buffer.isEndOfStream()) {
                    this.inputStreamEnded = true;
                    return;
                }
                MetadataInputBuffer metadataInputBuffer = this.buffer;
                metadataInputBuffer.subsampleOffsetUs = this.subsampleOffsetUs;
                metadataInputBuffer.flip();
                Metadata decode = ((MetadataDecoder) Util.castNonNull(this.decoder)).decode(this.buffer);
                if (decode != null) {
                    ArrayList arrayList = new ArrayList(decode.length());
                    decodeWrappedMetadata(decode, arrayList);
                    if (!arrayList.isEmpty()) {
                        this.pendingMetadata = new Metadata((List<? extends Metadata.Entry>) arrayList);
                        this.pendingMetadataTimestampUs = this.buffer.timeUs;
                    }
                }
            } else if (readSource == -5) {
                this.subsampleOffsetUs = ((Format) Assertions.checkNotNull(formatHolder.format)).subsampleOffsetUs;
            }
        }
    }

    public String getName() {
        return TAG;
    }

    public boolean handleMessage(Message message) {
        if (message.what == 0) {
            invokeRendererInternal((Metadata) message.obj);
            return true;
        }
        throw new IllegalStateException();
    }

    public boolean isEnded() {
        return this.outputStreamEnded;
    }

    public boolean isReady() {
        return true;
    }

    public void onDisabled() {
        this.pendingMetadata = null;
        this.pendingMetadataTimestampUs = -9223372036854775807L;
        this.decoder = null;
    }

    public void onPositionReset(long j11, boolean z11) {
        this.pendingMetadata = null;
        this.pendingMetadataTimestampUs = -9223372036854775807L;
        this.inputStreamEnded = false;
        this.outputStreamEnded = false;
    }

    public void onStreamChanged(Format[] formatArr, long j11, long j12) {
        this.decoder = this.decoderFactory.createDecoder(formatArr[0]);
    }

    public void render(long j11, long j12) {
        boolean z11 = true;
        while (z11) {
            readMetadata();
            z11 = outputMetadata(j11);
        }
    }

    public int supportsFormat(Format format) {
        if (!this.decoderFactory.supportsFormat(format)) {
            return s0.a(0);
        }
        return s0.a(format.exoMediaCryptoType == null ? 4 : 2);
    }

    public MetadataRenderer(MetadataOutput metadataOutput, Looper looper, MetadataDecoderFactory metadataDecoderFactory) {
        super(5);
        Handler handler;
        this.output = (MetadataOutput) Assertions.checkNotNull(metadataOutput);
        if (looper == null) {
            handler = null;
        } else {
            handler = Util.createHandler(looper, this);
        }
        this.outputHandler = handler;
        this.decoderFactory = (MetadataDecoderFactory) Assertions.checkNotNull(metadataDecoderFactory);
        this.buffer = new MetadataInputBuffer();
        this.pendingMetadataTimestampUs = -9223372036854775807L;
    }
}
