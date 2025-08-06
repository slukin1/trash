package org.bouncycastle.asn1;

final class ASN1Tag {
    private final int tagClass;
    private final int tagNumber;

    private ASN1Tag(int i11, int i12) {
        this.tagClass = i11;
        this.tagNumber = i12;
    }

    public static ASN1Tag create(int i11, int i12) {
        return new ASN1Tag(i11, i12);
    }

    public int getTagClass() {
        return this.tagClass;
    }

    public int getTagNumber() {
        return this.tagNumber;
    }
}
