package com.google.android.exoplayer2.text.pgs;

import android.graphics.Bitmap;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.zip.Inflater;

public final class PgsDecoder extends SimpleSubtitleDecoder {
    private static final byte INFLATE_HEADER = 120;
    private static final int SECTION_TYPE_BITMAP_PICTURE = 21;
    private static final int SECTION_TYPE_END = 128;
    private static final int SECTION_TYPE_IDENTIFIER = 22;
    private static final int SECTION_TYPE_PALETTE = 20;
    private final ParsableByteArray buffer = new ParsableByteArray();
    private final CueBuilder cueBuilder = new CueBuilder();
    private final ParsableByteArray inflatedBuffer = new ParsableByteArray();
    private Inflater inflater;

    public static final class CueBuilder {
        private final ParsableByteArray bitmapData = new ParsableByteArray();
        private int bitmapHeight;
        private int bitmapWidth;
        private int bitmapX;
        private int bitmapY;
        private final int[] colors = new int[256];
        private boolean colorsSet;
        private int planeHeight;
        private int planeWidth;

        /* access modifiers changed from: private */
        public void parseBitmapSection(ParsableByteArray parsableByteArray, int i11) {
            int readUnsignedInt24;
            if (i11 >= 4) {
                parsableByteArray.skipBytes(3);
                int i12 = i11 - 4;
                if ((parsableByteArray.readUnsignedByte() & 128) != 0) {
                    if (i12 >= 7 && (readUnsignedInt24 = parsableByteArray.readUnsignedInt24()) >= 4) {
                        this.bitmapWidth = parsableByteArray.readUnsignedShort();
                        this.bitmapHeight = parsableByteArray.readUnsignedShort();
                        this.bitmapData.reset(readUnsignedInt24 - 4);
                        i12 -= 7;
                    } else {
                        return;
                    }
                }
                int position = this.bitmapData.getPosition();
                int limit = this.bitmapData.limit();
                if (position < limit && i12 > 0) {
                    int min = Math.min(i12, limit - position);
                    parsableByteArray.readBytes(this.bitmapData.getData(), position, min);
                    this.bitmapData.setPosition(position + min);
                }
            }
        }

        /* access modifiers changed from: private */
        public void parseIdentifierSection(ParsableByteArray parsableByteArray, int i11) {
            if (i11 >= 19) {
                this.planeWidth = parsableByteArray.readUnsignedShort();
                this.planeHeight = parsableByteArray.readUnsignedShort();
                parsableByteArray.skipBytes(11);
                this.bitmapX = parsableByteArray.readUnsignedShort();
                this.bitmapY = parsableByteArray.readUnsignedShort();
            }
        }

        /* access modifiers changed from: private */
        public void parsePaletteSection(ParsableByteArray parsableByteArray, int i11) {
            if (i11 % 5 == 2) {
                parsableByteArray.skipBytes(2);
                Arrays.fill(this.colors, 0);
                int i12 = i11 / 5;
                int i13 = 0;
                while (i13 < i12) {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    int readUnsignedByte4 = parsableByteArray.readUnsignedByte();
                    int readUnsignedByte5 = parsableByteArray.readUnsignedByte();
                    double d11 = (double) readUnsignedByte2;
                    double d12 = (double) (readUnsignedByte3 - 128);
                    int i14 = i13;
                    double d13 = (double) (readUnsignedByte4 - 128);
                    this.colors[readUnsignedByte] = Util.constrainValue((int) (d11 + (d13 * 1.772d)), 0, 255) | (Util.constrainValue((int) ((d11 - (0.34414d * d13)) - (d12 * 0.71414d)), 0, 255) << 8) | (readUnsignedByte5 << 24) | (Util.constrainValue((int) ((1.402d * d12) + d11), 0, 255) << 16);
                    i13 = i14 + 1;
                }
                this.colorsSet = true;
            }
        }

        public Cue build() {
            int i11;
            int i12;
            int i13;
            if (this.planeWidth == 0 || this.planeHeight == 0 || this.bitmapWidth == 0 || this.bitmapHeight == 0 || this.bitmapData.limit() == 0 || this.bitmapData.getPosition() != this.bitmapData.limit() || !this.colorsSet) {
                return null;
            }
            this.bitmapData.setPosition(0);
            int i14 = this.bitmapWidth * this.bitmapHeight;
            int[] iArr = new int[i14];
            int i15 = 0;
            while (i15 < i14) {
                int readUnsignedByte = this.bitmapData.readUnsignedByte();
                if (readUnsignedByte != 0) {
                    i13 = i15 + 1;
                    iArr[i15] = this.colors[readUnsignedByte];
                } else {
                    int readUnsignedByte2 = this.bitmapData.readUnsignedByte();
                    if (readUnsignedByte2 != 0) {
                        if ((readUnsignedByte2 & 64) == 0) {
                            i11 = readUnsignedByte2 & 63;
                        } else {
                            i11 = ((readUnsignedByte2 & 63) << 8) | this.bitmapData.readUnsignedByte();
                        }
                        if ((readUnsignedByte2 & 128) == 0) {
                            i12 = 0;
                        } else {
                            i12 = this.colors[this.bitmapData.readUnsignedByte()];
                        }
                        i13 = i11 + i15;
                        Arrays.fill(iArr, i15, i13, i12);
                    }
                }
                i15 = i13;
            }
            return new Cue.Builder().setBitmap(Bitmap.createBitmap(iArr, this.bitmapWidth, this.bitmapHeight, Bitmap.Config.ARGB_8888)).setPosition(((float) this.bitmapX) / ((float) this.planeWidth)).setPositionAnchor(0).setLine(((float) this.bitmapY) / ((float) this.planeHeight), 0).setLineAnchor(0).setSize(((float) this.bitmapWidth) / ((float) this.planeWidth)).setBitmapHeight(((float) this.bitmapHeight) / ((float) this.planeHeight)).build();
        }

        public void reset() {
            this.planeWidth = 0;
            this.planeHeight = 0;
            this.bitmapX = 0;
            this.bitmapY = 0;
            this.bitmapWidth = 0;
            this.bitmapHeight = 0;
            this.bitmapData.reset(0);
            this.colorsSet = false;
        }
    }

    public PgsDecoder() {
        super("PgsDecoder");
    }

    private void maybeInflateData(ParsableByteArray parsableByteArray) {
        if (parsableByteArray.bytesLeft() > 0 && parsableByteArray.peekUnsignedByte() == 120) {
            if (this.inflater == null) {
                this.inflater = new Inflater();
            }
            if (Util.inflate(parsableByteArray, this.inflatedBuffer, this.inflater)) {
                parsableByteArray.reset(this.inflatedBuffer.getData(), this.inflatedBuffer.limit());
            }
        }
    }

    private static Cue readNextSection(ParsableByteArray parsableByteArray, CueBuilder cueBuilder2) {
        int limit = parsableByteArray.limit();
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int position = parsableByteArray.getPosition() + readUnsignedShort;
        Cue cue = null;
        if (position > limit) {
            parsableByteArray.setPosition(limit);
            return null;
        }
        if (readUnsignedByte != 128) {
            switch (readUnsignedByte) {
                case 20:
                    cueBuilder2.parsePaletteSection(parsableByteArray, readUnsignedShort);
                    break;
                case 21:
                    cueBuilder2.parseBitmapSection(parsableByteArray, readUnsignedShort);
                    break;
                case 22:
                    cueBuilder2.parseIdentifierSection(parsableByteArray, readUnsignedShort);
                    break;
            }
        } else {
            cue = cueBuilder2.build();
            cueBuilder2.reset();
        }
        parsableByteArray.setPosition(position);
        return cue;
    }

    public Subtitle decode(byte[] bArr, int i11, boolean z11) throws SubtitleDecoderException {
        this.buffer.reset(bArr, i11);
        maybeInflateData(this.buffer);
        this.cueBuilder.reset();
        ArrayList arrayList = new ArrayList();
        while (this.buffer.bytesLeft() >= 3) {
            Cue readNextSection = readNextSection(this.buffer, this.cueBuilder);
            if (readNextSection != null) {
                arrayList.add(readNextSection);
            }
        }
        return new PgsSubtitle(Collections.unmodifiableList(arrayList));
    }
}
