package com.google.zxing.client.result;

public abstract class ParsedResult {
    private final ParsedResultType type;

    public ParsedResult(ParsedResultType parsedResultType) {
        this.type = parsedResultType;
    }

    public static void maybeAppend(String str, StringBuilder sb2) {
        if (str != null && !str.isEmpty()) {
            if (sb2.length() > 0) {
                sb2.append(10);
            }
            sb2.append(str);
        }
    }

    public abstract String getDisplayResult();

    public final ParsedResultType getType() {
        return this.type;
    }

    public final String toString() {
        return getDisplayResult();
    }

    public static void maybeAppend(String[] strArr, StringBuilder sb2) {
        if (strArr != null) {
            for (String maybeAppend : strArr) {
                maybeAppend(maybeAppend, sb2);
            }
        }
    }
}
