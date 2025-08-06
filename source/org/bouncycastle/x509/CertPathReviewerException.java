package org.bouncycastle.x509;

import java.security.cert.CertPath;
import org.bouncycastle.i18n.ErrorBundle;
import org.bouncycastle.i18n.LocalizedException;

public class CertPathReviewerException extends LocalizedException {
    private CertPath certPath = null;
    private int index = -1;

    public CertPathReviewerException(ErrorBundle errorBundle) {
        super(errorBundle);
    }

    public CertPathReviewerException(ErrorBundle errorBundle, Throwable th2) {
        super(errorBundle, th2);
    }

    public CertPathReviewerException(ErrorBundle errorBundle, Throwable th2, CertPath certPath2, int i11) {
        super(errorBundle, th2);
        if (certPath2 == null || i11 == -1) {
            throw new IllegalArgumentException();
        } else if (i11 < -1 || i11 >= certPath2.getCertificates().size()) {
            throw new IndexOutOfBoundsException();
        } else {
            this.certPath = certPath2;
            this.index = i11;
        }
    }

    public CertPathReviewerException(ErrorBundle errorBundle, CertPath certPath2, int i11) {
        super(errorBundle);
        if (certPath2 == null || i11 == -1) {
            throw new IllegalArgumentException();
        } else if (i11 < -1 || i11 >= certPath2.getCertificates().size()) {
            throw new IndexOutOfBoundsException();
        } else {
            this.certPath = certPath2;
            this.index = i11;
        }
    }

    public CertPath getCertPath() {
        return this.certPath;
    }

    public int getIndex() {
        return this.index;
    }
}
