package com.google.android.exoplayer2.extractor.ogg;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.audio.OpusUtil;
import com.google.android.exoplayer2.extractor.ogg.StreamReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.util.Arrays;
import net.sf.scuba.smartcards.ISO7816;
import okio.Utf8;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;

final class OpusReader extends StreamReader {
    private static final int OPUS_CODE = 1332770163;
    private static final byte[] OPUS_SIGNATURE = {79, ISO7816.INS_MANAGE_CHANNEL, 117, 115, 72, 101, 97, 100};
    private boolean headerRead;

    private long getPacketDurationUs(byte[] bArr) {
        byte b11 = bArr[0] & 255;
        byte b12 = b11 & 3;
        byte b13 = 2;
        if (b12 == 0) {
            b13 = 1;
        } else if (!(b12 == 1 || b12 == 2)) {
            b13 = bArr[1] & Utf8.REPLACEMENT_BYTE;
        }
        int i11 = b11 >> 3;
        int i12 = i11 & 3;
        return ((long) b13) * ((long) (i11 >= 16 ? DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_MS << i12 : i11 >= 12 ? 10000 << (i12 & 1) : i12 == 3 ? 60000 : 10000 << i12));
    }

    public static boolean verifyBitstreamType(ParsableByteArray parsableByteArray) {
        int bytesLeft = parsableByteArray.bytesLeft();
        byte[] bArr = OPUS_SIGNATURE;
        if (bytesLeft < bArr.length) {
            return false;
        }
        byte[] bArr2 = new byte[bArr.length];
        parsableByteArray.readBytes(bArr2, 0, bArr.length);
        return Arrays.equals(bArr2, bArr);
    }

    public long preparePayload(ParsableByteArray parsableByteArray) {
        return convertTimeToGranule(getPacketDurationUs(parsableByteArray.getData()));
    }

    @EnsuresNonNullIf(expression = {"#3.format"}, result = false)
    public boolean readHeaders(ParsableByteArray parsableByteArray, long j11, StreamReader.SetupData setupData) {
        boolean z11 = true;
        if (!this.headerRead) {
            byte[] copyOf = Arrays.copyOf(parsableByteArray.getData(), parsableByteArray.limit());
            setupData.format = new Format.Builder().setSampleMimeType(MimeTypes.AUDIO_OPUS).setChannelCount(OpusUtil.getChannelCount(copyOf)).setSampleRate(48000).setInitializationData(OpusUtil.buildInitializationData(copyOf)).build();
            this.headerRead = true;
            return true;
        }
        Assertions.checkNotNull(setupData.format);
        if (parsableByteArray.readInt() != 1332770163) {
            z11 = false;
        }
        parsableByteArray.setPosition(0);
        return z11;
    }

    public void reset(boolean z11) {
        super.reset(z11);
        if (z11) {
            this.headerRead = false;
        }
    }
}
