package com.amazonaws.services.s3.internal;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.regex.Pattern;

public enum BucketNameUtils {
    ;
    
    private static final Pattern IP_ADDRESS_PATTERN = null;
    private static final int MAX_BUCKET_NAME_LENGTH = 63;
    private static final int MIN_BUCKET_NAME_LENGTH = 3;

    /* access modifiers changed from: public */
    static {
        IP_ADDRESS_PATTERN = Pattern.compile("(\\d+\\.){3}\\d+");
    }

    private static boolean exception(boolean z11, String str) {
        if (!z11) {
            return false;
        }
        throw new IllegalArgumentException(str);
    }

    public static boolean isDNSBucketName(String str) {
        return isValidV2BucketName(str);
    }

    public static boolean isValidV2BucketName(String str) {
        return isValidV2BucketName(str, false);
    }

    public static void validateBucketName(String str) {
        isValidV2BucketName(str, true);
    }

    private static boolean isValidV2BucketName(String str, boolean z11) {
        if (str == null) {
            return exception(z11, "Bucket name cannot be null");
        }
        if (str.length() < 3 || str.length() > 63) {
            return exception(z11, "Bucket name should be between 3 and 63 characters long");
        }
        if (IP_ADDRESS_PATTERN.matcher(str).matches()) {
            return exception(z11, "Bucket name must not be formatted as an IP Address");
        }
        int i11 = 0;
        char c11 = 0;
        while (i11 < str.length()) {
            char charAt = str.charAt(i11);
            if (charAt >= 'A' && charAt <= 'Z') {
                return exception(z11, "Bucket name should not contain uppercase characters");
            }
            if (charAt == ' ' || charAt == 9 || charAt == 13 || charAt == 10) {
                return exception(z11, "Bucket name should not contain white space");
            }
            if (charAt == '.') {
                if (c11 == 0) {
                    return exception(z11, "Bucket name should not begin with a period");
                }
                if (c11 == '.') {
                    return exception(z11, "Bucket name should not contain two adjacent periods");
                }
                if (c11 == '-') {
                    return exception(z11, "Bucket name should not contain dashes next to periods");
                }
            } else if (charAt == '-') {
                if (c11 == '.') {
                    return exception(z11, "Bucket name should not contain dashes next to periods");
                }
                if (c11 == 0) {
                    return exception(z11, "Bucket name should not begin with a '-'");
                }
            } else if (charAt < '0' || ((charAt > '9' && charAt < 'a') || charAt > 'z')) {
                return exception(z11, "Bucket name should not contain '" + charAt + "'");
            }
            i11++;
            c11 = charAt;
        }
        if (c11 == '.' || c11 == '-') {
            return exception(z11, "Bucket name should not end with '-' or '.'");
        }
        if (str.contains(InstructionFileId.DOT)) {
            return false;
        }
        return true;
    }
}
