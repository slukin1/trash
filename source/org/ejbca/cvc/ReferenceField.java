package org.ejbca.cvc;

public abstract class ReferenceField extends AbstractDataField {
    private static final long serialVersionUID = 1;
    private String country = null;
    private String mnemonic = null;
    private String sequence = null;

    public ReferenceField(CVCTagEnum cVCTagEnum, String str, String str2, String str3) {
        super(cVCTagEnum);
        if (str.length() != 2) {
            throw new IllegalArgumentException("Country code length must be 2, was " + str.length());
        } else if (!isValidCountry(str)) {
            throw new IllegalArgumentException("Unknown country code: " + str);
        } else if (str2.length() == 0) {
            throw new IllegalArgumentException("Holder mnemonic too short, must have at least one character");
        } else if (str2.length() > 9) {
            throw new IllegalArgumentException("Holder mnemonic too long, max=9, was " + str2.length());
        } else if (str3.length() == 5) {
            int i11 = 0;
            while (i11 < str3.length()) {
                if (Character.isLetterOrDigit(str3.charAt(i11))) {
                    i11++;
                } else {
                    throw new IllegalArgumentException("Sequence number can only contain alphanumerics: " + str3);
                }
            }
            this.country = str;
            this.mnemonic = str2;
            this.sequence = str3;
        } else {
            throw new IllegalArgumentException("Sequence number must have length 5, was " + str3.length());
        }
    }

    private boolean isValidCountry(String str) {
        return okChar(str.charAt(0)) && okChar(str.charAt(1));
    }

    private boolean okChar(char c11) {
        return c11 >= 'A' && c11 <= 'Z';
    }

    public String getConcatenated() {
        return this.country + this.mnemonic + this.sequence;
    }

    public String getCountry() {
        return this.country;
    }

    public byte[] getEncoded() {
        return getConcatenated().getBytes();
    }

    public String getMnemonic() {
        return this.mnemonic;
    }

    public String getSequence() {
        return this.sequence;
    }

    public String valueAsText() {
        return this.country + "/" + this.mnemonic + "/" + this.sequence;
    }

    public ReferenceField(CVCTagEnum cVCTagEnum, byte[] bArr) {
        super(cVCTagEnum);
        String str = new String(bArr);
        this.country = str.substring(0, 2);
        this.mnemonic = str.substring(2, str.length() - 5);
        this.sequence = str.substring(str.length() - 5);
    }
}
