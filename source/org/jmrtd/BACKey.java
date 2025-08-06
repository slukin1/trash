package org.jmrtd;

import com.jumio.analytics.MobileEvents;
import java.security.GeneralSecurityException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

public class BACKey implements BACKeySpec {
    private static final String SDF = "yyMMdd";
    private static final long serialVersionUID = -1059774581180524710L;
    private String dateOfBirth;
    private String dateOfExpiry;
    private String documentNumber;

    public BACKey() {
    }

    public boolean equals(Object obj) {
        if (obj == null || !obj.getClass().equals(getClass())) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        BACKey bACKey = (BACKey) obj;
        if (!this.documentNumber.equals(bACKey.documentNumber) || !this.dateOfBirth.equals(bACKey.dateOfBirth) || !this.dateOfExpiry.equals(bACKey.dateOfExpiry)) {
            return false;
        }
        return true;
    }

    public String getAlgorithm() {
        return "BAC";
    }

    public String getDateOfBirth() {
        return this.dateOfBirth;
    }

    public String getDateOfExpiry() {
        return this.dateOfExpiry;
    }

    public String getDocumentNumber() {
        return this.documentNumber;
    }

    public byte[] getKey() {
        try {
            return Util.computeKeySeed(this.documentNumber, this.dateOfBirth, this.dateOfExpiry, McElieceCCA2KeyGenParameterSpec.SHA1, true);
        } catch (GeneralSecurityException e11) {
            throw new IllegalArgumentException("Unexpected exception", e11);
        }
    }

    public int hashCode() {
        String str = this.documentNumber;
        int i11 = 0;
        int hashCode = (MobileEvents.EVENTTYPE_EXCEPTION + (str == null ? 0 : str.hashCode())) * 61;
        String str2 = this.dateOfBirth;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 61;
        String str3 = this.dateOfExpiry;
        if (str3 != null) {
            i11 = str3.hashCode();
        }
        return hashCode2 + i11;
    }

    public void setDateOfBirth(String str) {
        this.dateOfBirth = str;
    }

    public void setDateOfExpiry(String str) {
        this.dateOfExpiry = str;
    }

    public void setDocumentNumber(String str) {
        this.documentNumber = str;
    }

    public String toString() {
        return this.documentNumber + ", " + this.dateOfBirth + ", " + this.dateOfExpiry;
    }

    public BACKey(String str, Date date, Date date2) {
        this(str, toString(date), toString(date2));
    }

    private static synchronized String toString(Date date) {
        String format;
        synchronized (BACKey.class) {
            format = new SimpleDateFormat(SDF).format(date);
        }
        return format;
    }

    public BACKey(String str, String str2, String str3) {
        if (str == null) {
            throw new IllegalArgumentException("Illegal document number");
        } else if (str2 == null || str2.length() != 6) {
            throw new IllegalArgumentException("Illegal date: " + str2);
        } else if (str3 == null || str3.length() != 6) {
            throw new IllegalArgumentException("Illegal date: " + str3);
        } else {
            StringBuilder sb2 = new StringBuilder(str);
            while (sb2.length() < 9) {
                sb2.append('<');
            }
            this.documentNumber = sb2.toString().trim();
            this.dateOfBirth = str2;
            this.dateOfExpiry = str3;
        }
    }
}
