package com.jumio.sdk.reject;

public final class JumioRejectReason {
    public static final String BLACK_WHITE_COPY = "102";
    public static final String BLURRY = "2001";
    public static final String COLOR_PHOTOCOPY = "103";
    public static final String DAMAGED_DOCUMENT = "2005";
    public static final String DIGITAL_COPY = "104";
    public static final String GLARE = "2006";
    public static final String HIDDEN_PART_DOC = "2004";
    public static final JumioRejectReason INSTANCE = new JumioRejectReason();
    public static final String MISSING_BACK = "206";
    public static final String MISSING_FRONT = "214";
    public static final String MISSING_PART_DOC = "2003";
    public static final String NOT_READABLE = "200";
    public static final String NO_DOC = "201";
}
