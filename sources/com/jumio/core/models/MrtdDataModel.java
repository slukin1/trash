package com.jumio.core.models;

import com.jumio.core.JumioMrzData;
import com.jumio.core.enums.EMRTDStatus;
import com.jumio.core.model.StaticModel;
import java.util.Date;
import java.util.Map;

public interface MrtdDataModel extends StaticModel {
    int getActiveAuthResult();

    int getBacCheckResult();

    int getDscCheckResult();

    int[] getEncodedDataItems();

    Map<String, Integer> getHtCheckResults();

    Date getIssuingDate();

    JumioMrzData getMrzData();

    String getMrzFirstName();

    String getMrzIdNumber();

    String getMrzIssuingCountry();

    String getMrzLastName();

    String getMrzOriginatingCountry();

    String getMrzPersonalNumber();

    String getMrzString();

    String getPlaceOfBirth();

    int getRootCertCheck();

    EMRTDStatus getVerificationStatus();
}
