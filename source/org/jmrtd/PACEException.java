package org.jmrtd;

@Deprecated
public class PACEException extends CardServiceProtocolException {
    private static final long serialVersionUID = 8383980807753919040L;

    public PACEException(String str, int i11) {
        super(str, i11);
    }

    public PACEException(String str, int i11, Throwable th2) {
        super(str, i11, th2);
    }

    public PACEException(String str, int i11, int i12) {
        super(str, i11, i12);
    }

    public PACEException(String str, int i11, Throwable th2, int i12) {
        super(str, i11, th2, i12);
    }
}
