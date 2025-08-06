package org.bouncycastle.asn1.util;

import java.io.FileInputStream;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Primitive;

public class Dump {
    public static void main(String[] strArr) throws Exception {
        FileInputStream fileInputStream = new FileInputStream(strArr[0]);
        try {
            ASN1InputStream aSN1InputStream = new ASN1InputStream((InputStream) fileInputStream);
            while (true) {
                ASN1Primitive readObject = aSN1InputStream.readObject();
                if (readObject != null) {
                    System.out.println(ASN1Dump.dumpAsString(readObject));
                } else {
                    return;
                }
            }
        } finally {
            fileInputStream.close();
        }
    }
}
