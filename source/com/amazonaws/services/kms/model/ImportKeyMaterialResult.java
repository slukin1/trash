package com.amazonaws.services.kms.model;

import java.io.Serializable;

public class ImportKeyMaterialResult implements Serializable {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof ImportKeyMaterialResult)) {
            return false;
        }
        ImportKeyMaterialResult importKeyMaterialResult = (ImportKeyMaterialResult) obj;
        return true;
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "{" + "}";
    }
}
