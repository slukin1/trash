package org.jmrtd;

public interface BACKeySpec extends AccessKeySpec {
    String getDateOfBirth();

    String getDateOfExpiry();

    String getDocumentNumber();
}
