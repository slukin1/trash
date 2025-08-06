package com.amazonaws.services.kms.model;

import java.io.Serializable;

public class DeleteCustomKeyStoreResult implements Serializable {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof DeleteCustomKeyStoreResult)) {
            return false;
        }
        DeleteCustomKeyStoreResult deleteCustomKeyStoreResult = (DeleteCustomKeyStoreResult) obj;
        return true;
    }

    public int hashCode() {
        return 1;
    }

    public String toString() {
        return "{" + "}";
    }
}
