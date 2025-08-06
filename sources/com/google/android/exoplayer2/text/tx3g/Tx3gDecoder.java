package com.google.android.exoplayer2.text.tx3g;

import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.TypefaceSpan;
import android.text.style.UnderlineSpan;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.text.Cue;
import com.google.android.exoplayer2.text.SimpleSubtitleDecoder;
import com.google.android.exoplayer2.text.Subtitle;
import com.google.android.exoplayer2.text.SubtitleDecoderException;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.common.base.Ascii;
import com.google.common.base.Charsets;
import java.util.List;

public final class Tx3gDecoder extends SimpleSubtitleDecoder {
    private static final char BOM_UTF16_BE = '﻿';
    private static final char BOM_UTF16_LE = '￾';
    private static final int DEFAULT_COLOR = -1;
    private static final int DEFAULT_FONT_FACE = 0;
    private static final String DEFAULT_FONT_FAMILY = "sans-serif";
    private static final float DEFAULT_VERTICAL_PLACEMENT = 0.85f;
    private static final int FONT_FACE_BOLD = 1;
    private static final int FONT_FACE_ITALIC = 2;
    private static final int FONT_FACE_UNDERLINE = 4;
    private static final int SIZE_ATOM_HEADER = 8;
    private static final int SIZE_BOM_UTF16 = 2;
    private static final int SIZE_SHORT = 2;
    private static final int SIZE_STYLE_RECORD = 12;
    private static final int SPAN_PRIORITY_HIGH = 0;
    private static final int SPAN_PRIORITY_LOW = 16711680;
    private static final String TAG = "Tx3gDecoder";
    private static final String TX3G_SERIF = "Serif";
    private static final int TYPE_STYL = 1937013100;
    private static final int TYPE_TBOX = 1952608120;
    private final int calculatedVideoTrackHeight;
    private final boolean customVerticalPlacement;
    private final int defaultColorRgba;
    private final int defaultFontFace;
    private final String defaultFontFamily;
    private final float defaultVerticalPlacement;
    private final ParsableByteArray parsableByteArray = new ParsableByteArray();

    public Tx3gDecoder(List<byte[]> list) {
        super(TAG);
        String str = "sans-serif";
        boolean z11 = true;
        if (list.size() == 1 && (list.get(0).length == 48 || list.get(0).length == 53)) {
            byte[] bArr = list.get(0);
            this.defaultFontFace = bArr[24];
            this.defaultColorRgba = ((bArr[26] & 255) << Ascii.CAN) | ((bArr[27] & 255) << 16) | ((bArr[28] & 255) << 8) | (bArr[29] & 255);
            this.defaultFontFamily = TX3G_SERIF.equals(Util.fromUtf8Bytes(bArr, 43, bArr.length - 43)) ? C.SERIF_NAME : str;
            int i11 = bArr[25] * 20;
            this.calculatedVideoTrackHeight = i11;
            z11 = (bArr[0] & 32) == 0 ? false : z11;
            this.customVerticalPlacement = z11;
            if (z11) {
                this.defaultVerticalPlacement = Util.constrainValue(((float) ((bArr[11] & 255) | ((bArr[10] & 255) << 8))) / ((float) i11), 0.0f, 0.95f);
            } else {
                this.defaultVerticalPlacement = DEFAULT_VERTICAL_PLACEMENT;
            }
        } else {
            this.defaultFontFace = 0;
            this.defaultColorRgba = -1;
            this.defaultFontFamily = str;
            this.customVerticalPlacement = false;
            this.defaultVerticalPlacement = DEFAULT_VERTICAL_PLACEMENT;
            this.calculatedVideoTrackHeight = -1;
        }
    }

    private void applyStyleRecord(ParsableByteArray parsableByteArray2, SpannableStringBuilder spannableStringBuilder) throws SubtitleDecoderException {
        int i11;
        assertTrue(parsableByteArray2.bytesLeft() >= 12);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray2.readUnsignedShort();
        parsableByteArray2.skipBytes(2);
        int readUnsignedByte = parsableByteArray2.readUnsignedByte();
        parsableByteArray2.skipBytes(1);
        int readInt = parsableByteArray2.readInt();
        if (readUnsignedShort2 > spannableStringBuilder.length()) {
            int length = spannableStringBuilder.length();
            StringBuilder sb2 = new StringBuilder(68);
            sb2.append("Truncating styl end (");
            sb2.append(readUnsignedShort2);
            sb2.append(") to cueText.length() (");
            sb2.append(length);
            sb2.append(").");
            Log.w(TAG, sb2.toString());
            i11 = spannableStringBuilder.length();
        } else {
            i11 = readUnsignedShort2;
        }
        if (readUnsignedShort >= i11) {
            StringBuilder sb3 = new StringBuilder(60);
            sb3.append("Ignoring styl with start (");
            sb3.append(readUnsignedShort);
            sb3.append(") >= end (");
            sb3.append(i11);
            sb3.append(").");
            Log.w(TAG, sb3.toString());
            return;
        }
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        int i12 = readUnsignedShort;
        int i13 = i11;
        attachFontFace(spannableStringBuilder2, readUnsignedByte, this.defaultFontFace, i12, i13, 0);
        attachColor(spannableStringBuilder2, readInt, this.defaultColorRgba, i12, i13, 0);
    }

    private static void assertTrue(boolean z11) throws SubtitleDecoderException {
        if (!z11) {
            throw new SubtitleDecoderException("Unexpected subtitle format.");
        }
    }

    private static void attachColor(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13, int i14, int i15) {
        if (i11 != i12) {
            spannableStringBuilder.setSpan(new ForegroundColorSpan((i11 >>> 8) | ((i11 & 255) << 24)), i13, i14, i15 | 33);
        }
    }

    private static void attachFontFace(SpannableStringBuilder spannableStringBuilder, int i11, int i12, int i13, int i14, int i15) {
        if (i11 != i12) {
            int i16 = i15 | 33;
            boolean z11 = true;
            boolean z12 = (i11 & 1) != 0;
            boolean z13 = (i11 & 2) != 0;
            if (z12) {
                if (z13) {
                    spannableStringBuilder.setSpan(new StyleSpan(3), i13, i14, i16);
                } else {
                    spannableStringBuilder.setSpan(new StyleSpan(1), i13, i14, i16);
                }
            } else if (z13) {
                spannableStringBuilder.setSpan(new StyleSpan(2), i13, i14, i16);
            }
            if ((i11 & 4) == 0) {
                z11 = false;
            }
            if (z11) {
                spannableStringBuilder.setSpan(new UnderlineSpan(), i13, i14, i16);
            }
            if (!z11 && !z12 && !z13) {
                spannableStringBuilder.setSpan(new StyleSpan(0), i13, i14, i16);
            }
        }
    }

    private static void attachFontFamily(SpannableStringBuilder spannableStringBuilder, String str, int i11, int i12) {
        if (str != "sans-serif") {
            spannableStringBuilder.setSpan(new TypefaceSpan(str), i11, i12, 16711713);
        }
    }

    private static String readSubtitleText(ParsableByteArray parsableByteArray2) throws SubtitleDecoderException {
        char peekChar;
        assertTrue(parsableByteArray2.bytesLeft() >= 2);
        int readUnsignedShort = parsableByteArray2.readUnsignedShort();
        if (readUnsignedShort == 0) {
            return "";
        }
        if (parsableByteArray2.bytesLeft() < 2 || ((peekChar = parsableByteArray2.peekChar()) != 65279 && peekChar != 65534)) {
            return parsableByteArray2.readString(readUnsignedShort, Charsets.UTF_8);
        }
        return parsableByteArray2.readString(readUnsignedShort, Charsets.UTF_16);
    }

    public Subtitle decode(byte[] bArr, int i11, boolean z11) throws SubtitleDecoderException {
        this.parsableByteArray.reset(bArr, i11);
        String readSubtitleText = readSubtitleText(this.parsableByteArray);
        if (readSubtitleText.isEmpty()) {
            return Tx3gSubtitle.EMPTY;
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(readSubtitleText);
        SpannableStringBuilder spannableStringBuilder2 = spannableStringBuilder;
        attachFontFace(spannableStringBuilder2, this.defaultFontFace, 0, 0, spannableStringBuilder.length(), SPAN_PRIORITY_LOW);
        attachColor(spannableStringBuilder2, this.defaultColorRgba, -1, 0, spannableStringBuilder.length(), SPAN_PRIORITY_LOW);
        attachFontFamily(spannableStringBuilder, this.defaultFontFamily, 0, spannableStringBuilder.length());
        float f11 = this.defaultVerticalPlacement;
        while (this.parsableByteArray.bytesLeft() >= 8) {
            int position = this.parsableByteArray.getPosition();
            int readInt = this.parsableByteArray.readInt();
            int readInt2 = this.parsableByteArray.readInt();
            boolean z12 = true;
            if (readInt2 == TYPE_STYL) {
                if (this.parsableByteArray.bytesLeft() < 2) {
                    z12 = false;
                }
                assertTrue(z12);
                int readUnsignedShort = this.parsableByteArray.readUnsignedShort();
                for (int i12 = 0; i12 < readUnsignedShort; i12++) {
                    applyStyleRecord(this.parsableByteArray, spannableStringBuilder);
                }
            } else if (readInt2 == TYPE_TBOX && this.customVerticalPlacement) {
                if (this.parsableByteArray.bytesLeft() < 2) {
                    z12 = false;
                }
                assertTrue(z12);
                f11 = Util.constrainValue(((float) this.parsableByteArray.readUnsignedShort()) / ((float) this.calculatedVideoTrackHeight), 0.0f, 0.95f);
            }
            this.parsableByteArray.setPosition(position + readInt);
        }
        return new Tx3gSubtitle(new Cue.Builder().setText(spannableStringBuilder).setLine(f11, 0).setLineAnchor(0).build());
    }
}
