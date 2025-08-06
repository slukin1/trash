package androidx.constraintlayout.core.parser;

public class CLParsingException extends Exception {
    private final String mElementClass = "unknown";
    private final int mLineNumber = 0;
    private final String mReason;

    public CLParsingException(String str, a aVar) {
        this.mReason = str;
    }

    public String reason() {
        return this.mReason + " (" + this.mElementClass + " at line " + this.mLineNumber + ")";
    }

    public String toString() {
        return "CLParsingException (" + hashCode() + ") : " + reason();
    }
}
