package com.google.android.exoplayer2.extractor.mkv;

import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public interface EbmlProcessor {
    public static final int ELEMENT_TYPE_BINARY = 4;
    public static final int ELEMENT_TYPE_FLOAT = 5;
    public static final int ELEMENT_TYPE_MASTER = 1;
    public static final int ELEMENT_TYPE_STRING = 3;
    public static final int ELEMENT_TYPE_UNKNOWN = 0;
    public static final int ELEMENT_TYPE_UNSIGNED_INT = 2;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface ElementType {
    }

    void binaryElement(int i11, int i12, ExtractorInput extractorInput) throws IOException;

    void endMasterElement(int i11) throws ParserException;

    void floatElement(int i11, double d11) throws ParserException;

    int getElementType(int i11);

    void integerElement(int i11, long j11) throws ParserException;

    boolean isLevel1Element(int i11);

    void startMasterElement(int i11, long j11, long j12) throws ParserException;

    void stringElement(int i11, String str) throws ParserException;
}
