package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;
import com.tencent.thumbplayer.tcmedia.core.common.TPCodecParamers;
import com.twitter.sdk.android.core.internal.TwitterApiConstants;

final class GeneralAppIdDecoder {
    private final StringBuilder buffer = new StringBuilder();
    private final CurrentParsingState current = new CurrentParsingState();
    private final BitArray information;

    public GeneralAppIdDecoder(BitArray bitArray) {
        this.information = bitArray;
    }

    private DecodedChar decodeAlphanumeric(int i11) {
        char c11;
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i11, 5);
        if (extractNumericValueFromBitArray == 15) {
            return new DecodedChar(i11 + 5, DecodedChar.FNC1);
        }
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 15) {
            return new DecodedChar(i11 + 5, (char) ((extractNumericValueFromBitArray + 48) - 5));
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i11, 6);
        if (extractNumericValueFromBitArray2 >= 32 && extractNumericValueFromBitArray2 < 58) {
            return new DecodedChar(i11 + 6, (char) (extractNumericValueFromBitArray2 + 33));
        }
        switch (extractNumericValueFromBitArray2) {
            case 58:
                c11 = '*';
                break;
            case 59:
                c11 = ',';
                break;
            case 60:
                c11 = '-';
                break;
            case 61:
                c11 = '.';
                break;
            case 62:
                c11 = '/';
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: ".concat(String.valueOf(extractNumericValueFromBitArray2)));
        }
        return new DecodedChar(i11 + 6, c11);
    }

    private DecodedChar decodeIsoIec646(int i11) throws FormatException {
        char c11;
        int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i11, 5);
        if (extractNumericValueFromBitArray == 15) {
            return new DecodedChar(i11 + 5, DecodedChar.FNC1);
        }
        if (extractNumericValueFromBitArray >= 5 && extractNumericValueFromBitArray < 15) {
            return new DecodedChar(i11 + 5, (char) ((extractNumericValueFromBitArray + 48) - 5));
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i11, 7);
        if (extractNumericValueFromBitArray2 >= 64 && extractNumericValueFromBitArray2 < 90) {
            return new DecodedChar(i11 + 7, (char) (extractNumericValueFromBitArray2 + 1));
        }
        if (extractNumericValueFromBitArray2 >= 90 && extractNumericValueFromBitArray2 < 116) {
            return new DecodedChar(i11 + 7, (char) (extractNumericValueFromBitArray2 + 7));
        }
        switch (extractNumericValueFromBitArray(i11, 8)) {
            case 232:
                c11 = '!';
                break;
            case 233:
                c11 = '\"';
                break;
            case 234:
                c11 = '%';
                break;
            case 235:
                c11 = '&';
                break;
            case 236:
                c11 = '\'';
                break;
            case 237:
                c11 = '(';
                break;
            case 238:
                c11 = ')';
                break;
            case TwitterApiConstants.Errors.GUEST_AUTH_ERROR_CODE:
                c11 = '*';
                break;
            case 240:
                c11 = '+';
                break;
            case 241:
                c11 = ',';
                break;
            case 242:
                c11 = '-';
                break;
            case 243:
                c11 = '.';
                break;
            case TPCodecParamers.TP_PROFILE_H264_HIGH_444_PREDICTIVE:
                c11 = '/';
                break;
            case 245:
                c11 = ':';
                break;
            case 246:
                c11 = ';';
                break;
            case TPCodecParamers.TP_PROFILE_MJPEG_JPEG_LS:
                c11 = '<';
                break;
            case 248:
                c11 = '=';
                break;
            case 249:
                c11 = '>';
                break;
            case 250:
                c11 = '?';
                break;
            case 251:
                c11 = '_';
                break;
            case 252:
                c11 = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new DecodedChar(i11 + 8, c11);
    }

    private DecodedNumeric decodeNumeric(int i11) throws FormatException {
        int i12 = i11 + 7;
        if (i12 > this.information.getSize()) {
            int extractNumericValueFromBitArray = extractNumericValueFromBitArray(i11, 4);
            if (extractNumericValueFromBitArray == 0) {
                return new DecodedNumeric(this.information.getSize(), 10, 10);
            }
            return new DecodedNumeric(this.information.getSize(), extractNumericValueFromBitArray - 1, 10);
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i11, 7) - 8;
        return new DecodedNumeric(i12, extractNumericValueFromBitArray2 / 11, extractNumericValueFromBitArray2 % 11);
    }

    private boolean isAlphaOr646ToNumericLatch(int i11) {
        int i12 = i11 + 3;
        if (i12 > this.information.getSize()) {
            return false;
        }
        while (i11 < i12) {
            if (this.information.get(i11)) {
                return false;
            }
            i11++;
        }
        return true;
    }

    private boolean isAlphaTo646ToAlphaLatch(int i11) {
        int i12;
        if (i11 + 1 > this.information.getSize()) {
            return false;
        }
        int i13 = 0;
        while (i13 < 5 && (i12 = i13 + i11) < this.information.getSize()) {
            if (i13 == 2) {
                if (!this.information.get(i11 + 2)) {
                    return false;
                }
            } else if (this.information.get(i12)) {
                return false;
            }
            i13++;
        }
        return true;
    }

    private boolean isNumericToAlphaNumericLatch(int i11) {
        int i12;
        if (i11 + 1 > this.information.getSize()) {
            return false;
        }
        int i13 = 0;
        while (i13 < 4 && (i12 = i13 + i11) < this.information.getSize()) {
            if (this.information.get(i12)) {
                return false;
            }
            i13++;
        }
        return true;
    }

    private boolean isStillAlpha(int i11) {
        int extractNumericValueFromBitArray;
        if (i11 + 5 > this.information.getSize()) {
            return false;
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i11, 5);
        if (extractNumericValueFromBitArray2 >= 5 && extractNumericValueFromBitArray2 < 16) {
            return true;
        }
        if (i11 + 6 <= this.information.getSize() && (extractNumericValueFromBitArray = extractNumericValueFromBitArray(i11, 6)) >= 16 && extractNumericValueFromBitArray < 63) {
            return true;
        }
        return false;
    }

    private boolean isStillIsoIec646(int i11) {
        int extractNumericValueFromBitArray;
        if (i11 + 5 > this.information.getSize()) {
            return false;
        }
        int extractNumericValueFromBitArray2 = extractNumericValueFromBitArray(i11, 5);
        if (extractNumericValueFromBitArray2 >= 5 && extractNumericValueFromBitArray2 < 16) {
            return true;
        }
        if (i11 + 7 > this.information.getSize()) {
            return false;
        }
        int extractNumericValueFromBitArray3 = extractNumericValueFromBitArray(i11, 7);
        if (extractNumericValueFromBitArray3 >= 64 && extractNumericValueFromBitArray3 < 116) {
            return true;
        }
        if (i11 + 8 <= this.information.getSize() && (extractNumericValueFromBitArray = extractNumericValueFromBitArray(i11, 8)) >= 232 && extractNumericValueFromBitArray < 253) {
            return true;
        }
        return false;
    }

    private boolean isStillNumeric(int i11) {
        if (i11 + 7 <= this.information.getSize()) {
            int i12 = i11;
            while (true) {
                int i13 = i11 + 3;
                if (i12 >= i13) {
                    return this.information.get(i13);
                }
                if (this.information.get(i12)) {
                    return true;
                }
                i12++;
            }
        } else if (i11 + 4 <= this.information.getSize()) {
            return true;
        } else {
            return false;
        }
    }

    private BlockParsedResult parseAlphaBlock() {
        while (isStillAlpha(this.current.getPosition())) {
            DecodedChar decodeAlphanumeric = decodeAlphanumeric(this.current.getPosition());
            this.current.setPosition(decodeAlphanumeric.getNewPosition());
            if (decodeAlphanumeric.isFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodeAlphanumeric.getValue());
        }
        if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
            this.current.incrementPosition(3);
            this.current.setNumeric();
        } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
            if (this.current.getPosition() + 5 < this.information.getSize()) {
                this.current.incrementPosition(5);
            } else {
                this.current.setPosition(this.information.getSize());
            }
            this.current.setIsoIec646();
        }
        return new BlockParsedResult(false);
    }

    private DecodedInformation parseBlocks() throws FormatException {
        boolean z11;
        BlockParsedResult blockParsedResult;
        do {
            int position = this.current.getPosition();
            if (this.current.isAlpha()) {
                blockParsedResult = parseAlphaBlock();
                z11 = blockParsedResult.isFinished();
            } else if (this.current.isIsoIec646()) {
                blockParsedResult = parseIsoIec646Block();
                z11 = blockParsedResult.isFinished();
            } else {
                blockParsedResult = parseNumericBlock();
                z11 = blockParsedResult.isFinished();
            }
            if (!(position != this.current.getPosition()) && !z11) {
                break;
            }
        } while (!z11);
        return blockParsedResult.getDecodedInformation();
    }

    private BlockParsedResult parseIsoIec646Block() throws FormatException {
        while (isStillIsoIec646(this.current.getPosition())) {
            DecodedChar decodeIsoIec646 = decodeIsoIec646(this.current.getPosition());
            this.current.setPosition(decodeIsoIec646.getNewPosition());
            if (decodeIsoIec646.isFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodeIsoIec646.getValue());
        }
        if (isAlphaOr646ToNumericLatch(this.current.getPosition())) {
            this.current.incrementPosition(3);
            this.current.setNumeric();
        } else if (isAlphaTo646ToAlphaLatch(this.current.getPosition())) {
            if (this.current.getPosition() + 5 < this.information.getSize()) {
                this.current.incrementPosition(5);
            } else {
                this.current.setPosition(this.information.getSize());
            }
            this.current.setAlpha();
        }
        return new BlockParsedResult(false);
    }

    private BlockParsedResult parseNumericBlock() throws FormatException {
        DecodedInformation decodedInformation;
        while (isStillNumeric(this.current.getPosition())) {
            DecodedNumeric decodeNumeric = decodeNumeric(this.current.getPosition());
            this.current.setPosition(decodeNumeric.getNewPosition());
            if (decodeNumeric.isFirstDigitFNC1()) {
                if (decodeNumeric.isSecondDigitFNC1()) {
                    decodedInformation = new DecodedInformation(this.current.getPosition(), this.buffer.toString());
                } else {
                    decodedInformation = new DecodedInformation(this.current.getPosition(), this.buffer.toString(), decodeNumeric.getSecondDigit());
                }
                return new BlockParsedResult(decodedInformation, true);
            }
            this.buffer.append(decodeNumeric.getFirstDigit());
            if (decodeNumeric.isSecondDigitFNC1()) {
                return new BlockParsedResult(new DecodedInformation(this.current.getPosition(), this.buffer.toString()), true);
            }
            this.buffer.append(decodeNumeric.getSecondDigit());
        }
        if (isNumericToAlphaNumericLatch(this.current.getPosition())) {
            this.current.setAlpha();
            this.current.incrementPosition(4);
        }
        return new BlockParsedResult(false);
    }

    public String decodeAllCodes(StringBuilder sb2, int i11) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            DecodedInformation decodeGeneralPurposeField = decodeGeneralPurposeField(i11, str);
            String parseFieldsInGeneralPurpose = FieldParser.parseFieldsInGeneralPurpose(decodeGeneralPurposeField.getNewString());
            if (parseFieldsInGeneralPurpose != null) {
                sb2.append(parseFieldsInGeneralPurpose);
            }
            String valueOf = decodeGeneralPurposeField.isRemaining() ? String.valueOf(decodeGeneralPurposeField.getRemainingValue()) : null;
            if (i11 == decodeGeneralPurposeField.getNewPosition()) {
                return sb2.toString();
            }
            i11 = decodeGeneralPurposeField.getNewPosition();
            str = valueOf;
        }
    }

    public DecodedInformation decodeGeneralPurposeField(int i11, String str) throws FormatException {
        this.buffer.setLength(0);
        if (str != null) {
            this.buffer.append(str);
        }
        this.current.setPosition(i11);
        DecodedInformation parseBlocks = parseBlocks();
        if (parseBlocks == null || !parseBlocks.isRemaining()) {
            return new DecodedInformation(this.current.getPosition(), this.buffer.toString());
        }
        return new DecodedInformation(this.current.getPosition(), this.buffer.toString(), parseBlocks.getRemainingValue());
    }

    public int extractNumericValueFromBitArray(int i11, int i12) {
        return extractNumericValueFromBitArray(this.information, i11, i12);
    }

    public static int extractNumericValueFromBitArray(BitArray bitArray, int i11, int i12) {
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            if (bitArray.get(i11 + i14)) {
                i13 |= 1 << ((i12 - i14) - 1);
            }
        }
        return i13;
    }
}
