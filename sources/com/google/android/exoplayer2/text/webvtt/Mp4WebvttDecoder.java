package com.google.android.exoplayer2.text.webvtt;

import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Collections;

public final class Mp4WebvttDecoder extends SimpleSubtitleDecoder {
    private static final int BOX_HEADER_SIZE = 8;
    private static final int TYPE_payl = 1885436268;
    private static final int TYPE_sttg = 1937011815;
    private static final int TYPE_vttc = 1987343459;
    private final ParsableByteArray sampleData = new ParsableByteArray();

    public Mp4WebvttDecoder() {
        super("Mp4WebvttDecoder");
    }

    private static Cue parseVttCueBox(ParsableByteArray parsableByteArray, int i11) throws SubtitleDecoderException {
        CharSequence charSequence = null;
        Cue.Builder builder = null;
        while (i11 > 0) {
            if (i11 >= 8) {
                int readInt = parsableByteArray.readInt();
                int readInt2 = parsableByteArray.readInt();
                int i12 = readInt - 8;
                String fromUtf8Bytes = Util.fromUtf8Bytes(parsableByteArray.getData(), parsableByteArray.getPosition(), i12);
                parsableByteArray.skipBytes(i12);
                i11 = (i11 - 8) - i12;
                if (readInt2 == TYPE_sttg) {
                    builder = WebvttCueParser.parseCueSettingsList(fromUtf8Bytes);
                } else if (readInt2 == TYPE_payl) {
                    charSequence = WebvttCueParser.parseCueText((String) null, fromUtf8Bytes.trim(), Collections.emptyList());
                }
            } else {
                throw new SubtitleDecoderException("Incomplete vtt cue box header found.");
            }
        }
        if (charSequence == null) {
            charSequence = "";
        }
        if (builder != null) {
            return builder.setText(charSequence).build();
        }
        return WebvttCueParser.newCueForText(charSequence);
    }

    public Subtitle decode(byte[] bArr, int i11, boolean z11) throws SubtitleDecoderException {
        this.sampleData.reset(bArr, i11);
        ArrayList arrayList = new ArrayList();
        while (this.sampleData.bytesLeft() > 0) {
            if (this.sampleData.bytesLeft() >= 8) {
                int readInt = this.sampleData.readInt();
                if (this.sampleData.readInt() == TYPE_vttc) {
                    arrayList.add(parseVttCueBox(this.sampleData, readInt - 8));
                } else {
                    this.sampleData.skipBytes(readInt - 8);
                }
            } else {
                throw new SubtitleDecoderException("Incomplete Mp4Webvtt Top Level box header found.");
            }
        }
        return new Mp4WebvttSubtitle(arrayList);
    }
}
