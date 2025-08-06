package com.amazonaws.services.s3.model;

import java.io.Serializable;

public class AbortIncompleteMultipartUpload implements Serializable {
    private int daysAfterInitiation;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        if (this.daysAfterInitiation == ((AbortIncompleteMultipartUpload) obj).daysAfterInitiation) {
            return true;
        }
        return false;
    }

    public int getDaysAfterInitiation() {
        return this.daysAfterInitiation;
    }

    public int hashCode() {
        return this.daysAfterInitiation;
    }

    public void setDaysAfterInitiation(int i11) {
        this.daysAfterInitiation = i11;
    }

    public AbortIncompleteMultipartUpload withDaysAfterInitiation(int i11) {
        setDaysAfterInitiation(i11);
        return this;
    }

    public AbortIncompleteMultipartUpload clone() throws CloneNotSupportedException {
        try {
            return (AbortIncompleteMultipartUpload) super.clone();
        } catch (CloneNotSupportedException e11) {
            throw new IllegalStateException("Got a CloneNotSupportedException from Object.clone() even though we're Cloneable!", e11);
        }
    }
}
