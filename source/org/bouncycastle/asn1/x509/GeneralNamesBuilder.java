package org.bouncycastle.asn1.x509;

import java.util.Vector;

public class GeneralNamesBuilder {
    private Vector names = new Vector();

    public GeneralNamesBuilder addName(GeneralName generalName) {
        this.names.addElement(generalName);
        return this;
    }

    public GeneralNamesBuilder addNames(GeneralNames generalNames) {
        GeneralName[] names2 = generalNames.getNames();
        for (int i11 = 0; i11 != names2.length; i11++) {
            this.names.addElement(names2[i11]);
        }
        return this;
    }

    public GeneralNames build() {
        int size = this.names.size();
        GeneralName[] generalNameArr = new GeneralName[size];
        for (int i11 = 0; i11 != size; i11++) {
            generalNameArr[i11] = (GeneralName) this.names.elementAt(i11);
        }
        return new GeneralNames(generalNameArr);
    }
}
