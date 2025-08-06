package org.bouncycastle.jce.provider;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.x500.X500Name;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralSubtree;
import org.bouncycastle.asn1.x509.NameConstraintValidatorException;

public class PKIXNameConstraintValidator {
    public org.bouncycastle.asn1.x509.PKIXNameConstraintValidator validator = new org.bouncycastle.asn1.x509.PKIXNameConstraintValidator();

    public void addExcludedSubtree(GeneralSubtree generalSubtree) {
        this.validator.addExcludedSubtree(generalSubtree);
    }

    public void checkExcluded(GeneralName generalName) throws PKIXNameConstraintValidatorException {
        try {
            this.validator.checkExcluded(generalName);
        } catch (NameConstraintValidatorException e11) {
            throw new PKIXNameConstraintValidatorException(e11.getMessage(), e11);
        }
    }

    public void checkExcludedDN(ASN1Sequence aSN1Sequence) throws PKIXNameConstraintValidatorException {
        try {
            this.validator.checkExcludedDN(X500Name.getInstance(aSN1Sequence));
        } catch (NameConstraintValidatorException e11) {
            throw new PKIXNameConstraintValidatorException(e11.getMessage(), e11);
        }
    }

    public void checkPermitted(GeneralName generalName) throws PKIXNameConstraintValidatorException {
        try {
            this.validator.checkPermitted(generalName);
        } catch (NameConstraintValidatorException e11) {
            throw new PKIXNameConstraintValidatorException(e11.getMessage(), e11);
        }
    }

    public void checkPermittedDN(ASN1Sequence aSN1Sequence) throws PKIXNameConstraintValidatorException {
        try {
            this.validator.checkPermittedDN(X500Name.getInstance(aSN1Sequence));
        } catch (NameConstraintValidatorException e11) {
            throw new PKIXNameConstraintValidatorException(e11.getMessage(), e11);
        }
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof PKIXNameConstraintValidator)) {
            return false;
        }
        return this.validator.equals(((PKIXNameConstraintValidator) obj).validator);
    }

    public int hashCode() {
        return this.validator.hashCode();
    }

    public void intersectEmptyPermittedSubtree(int i11) {
        this.validator.intersectEmptyPermittedSubtree(i11);
    }

    public void intersectPermittedSubtree(GeneralSubtree generalSubtree) {
        this.validator.intersectPermittedSubtree(generalSubtree);
    }

    public void intersectPermittedSubtree(GeneralSubtree[] generalSubtreeArr) {
        this.validator.intersectPermittedSubtree(generalSubtreeArr);
    }

    public String toString() {
        return this.validator.toString();
    }
}
