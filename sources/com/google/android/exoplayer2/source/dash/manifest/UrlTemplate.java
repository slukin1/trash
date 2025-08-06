package com.google.android.exoplayer2.source.dash.manifest;

import com.google.android.gms.common.GoogleApiAvailabilityLight;
import java.util.Locale;

public final class UrlTemplate {
    private static final String BANDWIDTH = "Bandwidth";
    private static final int BANDWIDTH_ID = 3;
    private static final String DEFAULT_FORMAT_TAG = "%01d";
    private static final String ESCAPED_DOLLAR = "$$";
    private static final String NUMBER = "Number";
    private static final int NUMBER_ID = 2;
    private static final String REPRESENTATION = "RepresentationID";
    private static final int REPRESENTATION_ID = 1;
    private static final String TIME = "Time";
    private static final int TIME_ID = 4;
    private final int identifierCount;
    private final String[] identifierFormatTags;
    private final int[] identifiers;
    private final String[] urlPieces;

    private UrlTemplate(String[] strArr, int[] iArr, String[] strArr2, int i11) {
        this.urlPieces = strArr;
        this.identifiers = iArr;
        this.identifierFormatTags = strArr2;
        this.identifierCount = i11;
    }

    public static UrlTemplate compile(String str) {
        String[] strArr = new String[5];
        int[] iArr = new int[4];
        String[] strArr2 = new String[4];
        return new UrlTemplate(strArr, iArr, strArr2, parseTemplate(str, strArr, iArr, strArr2));
    }

    private static int parseTemplate(String str, String[] strArr, int[] iArr, String[] strArr2) {
        String str2;
        strArr[0] = "";
        int i11 = 0;
        int i12 = 0;
        while (i11 < str.length()) {
            int indexOf = str.indexOf("$", i11);
            char c11 = 65535;
            if (indexOf == -1) {
                String valueOf = String.valueOf(strArr[i12]);
                String valueOf2 = String.valueOf(str.substring(i11));
                strArr[i12] = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                i11 = str.length();
            } else if (indexOf != i11) {
                String valueOf3 = String.valueOf(strArr[i12]);
                String valueOf4 = String.valueOf(str.substring(i11, indexOf));
                strArr[i12] = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                i11 = indexOf;
            } else if (str.startsWith(ESCAPED_DOLLAR, i11)) {
                strArr[i12] = String.valueOf(strArr[i12]).concat("$");
                i11 += 2;
            } else {
                int i13 = i11 + 1;
                int indexOf2 = str.indexOf("$", i13);
                String substring = str.substring(i13, indexOf2);
                if (substring.equals(REPRESENTATION)) {
                    iArr[i12] = 1;
                } else {
                    int indexOf3 = substring.indexOf("%0");
                    if (indexOf3 != -1) {
                        str2 = substring.substring(indexOf3);
                        if (!str2.endsWith(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG) && !str2.endsWith("x")) {
                            str2 = str2.concat(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
                        }
                        substring = substring.substring(0, indexOf3);
                    } else {
                        str2 = DEFAULT_FORMAT_TAG;
                    }
                    substring.hashCode();
                    switch (substring.hashCode()) {
                        case -1950496919:
                            if (substring.equals(NUMBER)) {
                                c11 = 0;
                                break;
                            }
                            break;
                        case 2606829:
                            if (substring.equals(TIME)) {
                                c11 = 1;
                                break;
                            }
                            break;
                        case 38199441:
                            if (substring.equals(BANDWIDTH)) {
                                c11 = 2;
                                break;
                            }
                            break;
                    }
                    switch (c11) {
                        case 0:
                            iArr[i12] = 2;
                            break;
                        case 1:
                            iArr[i12] = 4;
                            break;
                        case 2:
                            iArr[i12] = 3;
                            break;
                        default:
                            throw new IllegalArgumentException(str.length() != 0 ? "Invalid template: ".concat(str) : new String("Invalid template: "));
                    }
                    strArr2[i12] = str2;
                }
                i12++;
                strArr[i12] = "";
                i11 = indexOf2 + 1;
            }
        }
        return i12;
    }

    public String buildUri(String str, long j11, int i11, long j12) {
        StringBuilder sb2 = new StringBuilder();
        int i12 = 0;
        while (true) {
            int i13 = this.identifierCount;
            if (i12 < i13) {
                sb2.append(this.urlPieces[i12]);
                int[] iArr = this.identifiers;
                if (iArr[i12] == 1) {
                    sb2.append(str);
                } else if (iArr[i12] == 2) {
                    sb2.append(String.format(Locale.US, this.identifierFormatTags[i12], new Object[]{Long.valueOf(j11)}));
                } else if (iArr[i12] == 3) {
                    sb2.append(String.format(Locale.US, this.identifierFormatTags[i12], new Object[]{Integer.valueOf(i11)}));
                } else if (iArr[i12] == 4) {
                    sb2.append(String.format(Locale.US, this.identifierFormatTags[i12], new Object[]{Long.valueOf(j12)}));
                }
                i12++;
            } else {
                sb2.append(this.urlPieces[i13]);
                return sb2.toString();
            }
        }
    }
}
