package org.jmrtd.lds.icao;

import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVOutputStream;
import net.sf.scuba.tlv.TLVUtil;
import net.sf.scuba.util.Hex;
import org.jmrtd.lds.DataGroup;

public class DG12File extends DataGroup {
    public static final int CONTENT_SPECIFIC_CONSTRUCTED_TAG = 160;
    public static final int COUNT_TAG = 2;
    public static final int DATE_AND_TIME_OF_PERSONALIZATION_TAG = 24405;
    public static final int DATE_OF_ISSUE_TAG = 24358;
    public static final int ENDORSEMENTS_AND_OBSERVATIONS_TAG = 24347;
    public static final int IMAGE_OF_FRONT_TAG = 24349;
    public static final int IMAGE_OF_REAR_TAG = 24350;
    public static final int ISSUING_AUTHORITY_TAG = 24345;
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    public static final int NAME_OF_OTHER_PERSON_TAG = 24346;
    public static final int PERSONALIZATION_SYSTEM_SERIAL_NUMBER_TAG = 24406;
    private static final String SDF = "yyyyMMdd";
    private static final String SDTF = "yyyyMMddhhmmss";
    private static final int TAG_LIST_TAG = 92;
    public static final int TAX_OR_EXIT_REQUIREMENTS_TAG = 24348;
    private static final long serialVersionUID = -1979367459379125674L;
    private String dateAndTimeOfPersonalization;
    private String dateOfIssue;
    private String endorsementsAndObservations;
    private byte[] imageOfFront;
    private byte[] imageOfRear;
    private String issuingAuthority;
    private List<String> namesOfOtherPersons;
    private String personalizationSystemSerialNumber;
    private List<Integer> tagPresenceList;
    private String taxOrExitRequirements;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public DG12File(java.lang.String r14, java.util.Date r15, java.util.List<java.lang.String> r16, java.lang.String r17, java.lang.String r18, byte[] r19, byte[] r20, java.util.Date r21, java.lang.String r22) {
        /*
            r13 = this;
            r0 = r15
            r1 = r21
            r2 = 0
            if (r0 != 0) goto L_0x0008
            r5 = r2
            goto L_0x0014
        L_0x0008:
            java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat
            java.lang.String r4 = "yyyyMMdd"
            r3.<init>(r4)
            java.lang.String r0 = r3.format(r15)
            r5 = r0
        L_0x0014:
            if (r1 != 0) goto L_0x0017
            goto L_0x0022
        L_0x0017:
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyyMMddhhmmss"
            r0.<init>(r2)
            java.lang.String r2 = r0.format(r1)
        L_0x0022:
            r11 = r2
            r3 = r13
            r4 = r14
            r6 = r16
            r7 = r17
            r8 = r18
            r9 = r19
            r10 = r20
            r12 = r22
            r3.<init>((java.lang.String) r4, (java.lang.String) r5, (java.util.List<java.lang.String>) r6, (java.lang.String) r7, (java.lang.String) r8, (byte[]) r9, (byte[]) r10, (java.lang.String) r11, (java.lang.String) r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jmrtd.lds.icao.DG12File.<init>(java.lang.String, java.util.Date, java.util.List, java.lang.String, java.lang.String, byte[], byte[], java.util.Date, java.lang.String):void");
    }

    private void parseDateAndTimeOfPersonalization(byte[] bArr) {
        try {
            this.dateAndTimeOfPersonalization = new String(bArr, "UTF-8").trim();
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
        }
    }

    private void parseDateOfIssue(byte[] bArr) {
        if (bArr != null) {
            if (bArr.length == 8) {
                try {
                    this.dateOfIssue = new String(bArr, "UTF-8").trim();
                    return;
                } catch (UnsupportedEncodingException e11) {
                    LOGGER.log(Level.WARNING, "Exception", e11);
                }
            }
            LOGGER.warning("DG12 date of issue is not in expected ccyymmdd ASCII format");
            if (bArr.length == 4) {
                this.dateOfIssue = Hex.bytesToHexString(bArr).trim();
                return;
            }
            throw new IllegalArgumentException("Wrong date format");
        }
        throw new IllegalArgumentException("Wrong date format");
    }

    private void parseEndorsementsAndObservations(byte[] bArr) {
        try {
            this.endorsementsAndObservations = new String(bArr, "UTF-8").trim();
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
            this.endorsementsAndObservations = new String(bArr).trim();
        }
    }

    private void parseImageOfFront(byte[] bArr) {
        this.imageOfFront = bArr;
    }

    private void parseImageOfRear(byte[] bArr) {
        this.imageOfRear = bArr;
    }

    private void parseIssuingAuthority(byte[] bArr) {
        try {
            this.issuingAuthority = new String(bArr, "UTF-8").trim();
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
            this.issuingAuthority = new String(bArr).trim();
        }
    }

    private synchronized void parseNameOfOtherPerson(byte[] bArr) {
        if (this.namesOfOtherPersons == null) {
            this.namesOfOtherPersons = new ArrayList();
        }
        try {
            this.namesOfOtherPersons.add(new String(bArr, "UTF-8").trim());
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
            this.namesOfOtherPersons.add(new String(bArr).trim());
        }
        return;
    }

    private void parsePersonalizationSystemSerialNumber(byte[] bArr) {
        try {
            this.personalizationSystemSerialNumber = new String(bArr, "UTF-8").trim();
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
            this.personalizationSystemSerialNumber = new String(bArr).trim();
        }
    }

    private void parseTaxOrExitRequirements(byte[] bArr) {
        try {
            this.taxOrExitRequirements = new String(bArr, "UTF-8").trim();
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
            this.taxOrExitRequirements = new String(bArr).trim();
        }
    }

    private void readField(int i11, TLVInputStream tLVInputStream) throws IOException {
        int readTag = tLVInputStream.readTag();
        if (readTag == 160) {
            tLVInputStream.readLength();
            int readTag2 = tLVInputStream.readTag();
            if (readTag2 == 2) {
                int readLength = tLVInputStream.readLength();
                if (readLength == 1) {
                    byte[] readValue = tLVInputStream.readValue();
                    if (readValue == null || readValue.length != 1) {
                        throw new IllegalArgumentException("Number of content specific fields should be encoded in single byte, found " + Arrays.toString(readValue));
                    }
                    int i12 = 0;
                    byte b11 = readValue[0] & 255;
                    while (i12 < b11) {
                        int readTag3 = tLVInputStream.readTag();
                        if (readTag3 == 24346) {
                            tLVInputStream.readLength();
                            parseNameOfOtherPerson(tLVInputStream.readValue());
                            i12++;
                        } else {
                            throw new IllegalArgumentException("Expected " + Integer.toHexString(NAME_OF_OTHER_PERSON_TAG) + ", found " + Integer.toHexString(readTag3));
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("Expected length 1 count length, found " + readLength);
            }
            throw new IllegalArgumentException("Expected " + Integer.toHexString(2) + ", found " + Integer.toHexString(readTag2));
        } else if (readTag == i11) {
            tLVInputStream.readLength();
            byte[] readValue2 = tLVInputStream.readValue();
            if (readTag == 24358) {
                parseDateOfIssue(readValue2);
            } else if (readTag == 24405) {
                parseDateAndTimeOfPersonalization(readValue2);
            } else if (readTag != 24406) {
                switch (readTag) {
                    case ISSUING_AUTHORITY_TAG /*24345*/:
                        parseIssuingAuthority(readValue2);
                        return;
                    case NAME_OF_OTHER_PERSON_TAG /*24346*/:
                        parseNameOfOtherPerson(readValue2);
                        return;
                    case ENDORSEMENTS_AND_OBSERVATIONS_TAG /*24347*/:
                        parseEndorsementsAndObservations(readValue2);
                        return;
                    case TAX_OR_EXIT_REQUIREMENTS_TAG /*24348*/:
                        parseTaxOrExitRequirements(readValue2);
                        return;
                    case IMAGE_OF_FRONT_TAG /*24349*/:
                        parseImageOfFront(readValue2);
                        return;
                    case IMAGE_OF_REAR_TAG /*24350*/:
                        parseImageOfRear(readValue2);
                        return;
                    default:
                        throw new IllegalArgumentException("Unknown field tag in DG12: " + Integer.toHexString(readTag));
                }
            } else {
                parsePersonalizationSystemSerialNumber(readValue2);
            }
        } else {
            throw new IllegalArgumentException("Expected " + Integer.toHexString(i11) + ", but found " + Integer.toHexString(readTag));
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        return toString().equals(((DG12File) obj).toString());
    }

    public String getDateAndTimeOfPersonalization() {
        return this.dateAndTimeOfPersonalization;
    }

    public String getDateOfIssue() {
        return this.dateOfIssue;
    }

    public String getEndorsementsAndObservations() {
        return this.endorsementsAndObservations;
    }

    public byte[] getImageOfFront() {
        return this.imageOfFront;
    }

    public byte[] getImageOfRear() {
        return this.imageOfRear;
    }

    public String getIssuingAuthority() {
        return this.issuingAuthority;
    }

    public List<String> getNamesOfOtherPersons() {
        return this.namesOfOtherPersons;
    }

    public String getPersonalizationSystemSerialNumber() {
        return this.personalizationSystemSerialNumber;
    }

    public int getTag() {
        return 108;
    }

    public List<Integer> getTagPresenceList() {
        List<Integer> list = this.tagPresenceList;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(10);
        this.tagPresenceList = arrayList;
        if (this.issuingAuthority != null) {
            arrayList.add(Integer.valueOf(ISSUING_AUTHORITY_TAG));
        }
        if (this.dateOfIssue != null) {
            this.tagPresenceList.add(Integer.valueOf(DATE_OF_ISSUE_TAG));
        }
        List<String> list2 = this.namesOfOtherPersons;
        if (list2 != null && !list2.isEmpty()) {
            this.tagPresenceList.add(Integer.valueOf(NAME_OF_OTHER_PERSON_TAG));
        }
        if (this.endorsementsAndObservations != null) {
            this.tagPresenceList.add(Integer.valueOf(ENDORSEMENTS_AND_OBSERVATIONS_TAG));
        }
        if (this.taxOrExitRequirements != null) {
            this.tagPresenceList.add(Integer.valueOf(TAX_OR_EXIT_REQUIREMENTS_TAG));
        }
        if (this.imageOfFront != null) {
            this.tagPresenceList.add(Integer.valueOf(IMAGE_OF_FRONT_TAG));
        }
        if (this.imageOfRear != null) {
            this.tagPresenceList.add(Integer.valueOf(IMAGE_OF_REAR_TAG));
        }
        if (this.dateAndTimeOfPersonalization != null) {
            this.tagPresenceList.add(Integer.valueOf(DATE_AND_TIME_OF_PERSONALIZATION_TAG));
        }
        if (this.personalizationSystemSerialNumber != null) {
            this.tagPresenceList.add(Integer.valueOf(PERSONALIZATION_SYSTEM_SERIAL_NUMBER_TAG));
        }
        return this.tagPresenceList;
    }

    public String getTaxOrExitRequirements() {
        return this.taxOrExitRequirements;
    }

    public int hashCode() {
        return (toString().hashCode() * 13) + 112;
    }

    public void readContent(InputStream inputStream) throws IOException {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        if (tLVInputStream.readTag() == 92) {
            int readLength = tLVInputStream.readLength();
            int i11 = 0;
            int i12 = readLength / 2;
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(tLVInputStream.readValue());
            try {
                ArrayList<Integer> arrayList = new ArrayList<>(i12 + 1);
                while (i11 < readLength) {
                    int readTag = new TLVInputStream(byteArrayInputStream).readTag();
                    i11 += TLVUtil.getTagLength(readTag);
                    arrayList.add(Integer.valueOf(readTag));
                }
                for (Integer intValue : arrayList) {
                    readField(intValue.intValue(), tLVInputStream);
                }
            } finally {
                byteArrayInputStream.close();
            }
        } else {
            throw new IllegalArgumentException("Expected tag list in DG12");
        }
    }

    public String toString() {
        String str;
        String str2;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DG12File [");
        String str3 = this.issuingAuthority;
        String str4 = "";
        if (str3 == null) {
            str3 = str4;
        }
        sb2.append(str3);
        sb2.append(", ");
        String str5 = this.dateOfIssue;
        if (str5 == null) {
            str5 = str4;
        }
        sb2.append(str5);
        sb2.append(", ");
        List<String> list = this.namesOfOtherPersons;
        sb2.append((list == null || list.isEmpty()) ? str4 : this.namesOfOtherPersons);
        sb2.append(", ");
        String str6 = this.endorsementsAndObservations;
        if (str6 == null) {
            str6 = str4;
        }
        sb2.append(str6);
        sb2.append(", ");
        String str7 = this.taxOrExitRequirements;
        if (str7 == null) {
            str7 = str4;
        }
        sb2.append(str7);
        sb2.append(", ");
        if (this.imageOfFront == null) {
            str = str4;
        } else {
            str = "image (" + this.imageOfFront.length + ")";
        }
        sb2.append(str);
        sb2.append(", ");
        if (this.imageOfRear == null) {
            str2 = str4;
        } else {
            str2 = "image (" + this.imageOfRear.length + ")";
        }
        sb2.append(str2);
        sb2.append(", ");
        String str8 = this.dateAndTimeOfPersonalization;
        if (str8 == null) {
            str8 = str4;
        }
        sb2.append(str8);
        sb2.append(", ");
        String str9 = this.personalizationSystemSerialNumber;
        if (str9 != null) {
            str4 = str9;
        }
        sb2.append(str4);
        sb2.append("]");
        return sb2.toString();
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        TLVOutputStream tLVOutputStream = outputStream instanceof TLVOutputStream ? (TLVOutputStream) outputStream : new TLVOutputStream(outputStream);
        tLVOutputStream.writeTag(92);
        List<Integer> tagPresenceList2 = getTagPresenceList();
        DataOutputStream dataOutputStream = new DataOutputStream(tLVOutputStream);
        for (Integer intValue : tagPresenceList2) {
            dataOutputStream.writeShort(intValue.intValue());
        }
        dataOutputStream.flush();
        tLVOutputStream.writeValueEnd();
        for (Integer intValue2 : tagPresenceList2) {
            int intValue3 = intValue2.intValue();
            if (intValue3 == 24358) {
                tLVOutputStream.writeTag(intValue3);
                tLVOutputStream.writeValue(this.dateOfIssue.getBytes("UTF-8"));
            } else if (intValue3 == 24405) {
                tLVOutputStream.writeTag(intValue3);
                tLVOutputStream.writeValue(this.dateAndTimeOfPersonalization.getBytes("UTF-8"));
            } else if (intValue3 != 24406) {
                switch (intValue3) {
                    case ISSUING_AUTHORITY_TAG /*24345*/:
                        tLVOutputStream.writeTag(intValue3);
                        tLVOutputStream.writeValue(this.issuingAuthority.trim().getBytes("UTF-8"));
                        break;
                    case NAME_OF_OTHER_PERSON_TAG /*24346*/:
                        if (this.namesOfOtherPersons == null) {
                            this.namesOfOtherPersons = new ArrayList();
                        }
                        tLVOutputStream.writeTag(160);
                        tLVOutputStream.writeTag(2);
                        tLVOutputStream.write(this.namesOfOtherPersons.size());
                        tLVOutputStream.writeValueEnd();
                        for (String trim : this.namesOfOtherPersons) {
                            tLVOutputStream.writeTag(NAME_OF_OTHER_PERSON_TAG);
                            tLVOutputStream.writeValue(trim.trim().getBytes("UTF-8"));
                        }
                        tLVOutputStream.writeValueEnd();
                        break;
                    case ENDORSEMENTS_AND_OBSERVATIONS_TAG /*24347*/:
                        tLVOutputStream.writeTag(intValue3);
                        tLVOutputStream.writeValue(this.endorsementsAndObservations.trim().getBytes("UTF-8"));
                        break;
                    case TAX_OR_EXIT_REQUIREMENTS_TAG /*24348*/:
                        tLVOutputStream.writeTag(intValue3);
                        tLVOutputStream.writeValue(this.taxOrExitRequirements.trim().getBytes("UTF-8"));
                        break;
                    case IMAGE_OF_FRONT_TAG /*24349*/:
                        tLVOutputStream.writeTag(intValue3);
                        tLVOutputStream.writeValue(this.imageOfFront);
                        break;
                    case IMAGE_OF_REAR_TAG /*24350*/:
                        tLVOutputStream.writeTag(intValue3);
                        tLVOutputStream.writeValue(this.imageOfRear);
                        break;
                    default:
                        throw new IllegalArgumentException("Unknown field tag in DG12: " + Integer.toHexString(intValue3));
                }
            } else {
                tLVOutputStream.writeTag(intValue3);
                tLVOutputStream.writeValue(this.personalizationSystemSerialNumber.trim().getBytes("UTF-8"));
            }
        }
    }

    public DG12File(String str, String str2, List<String> list, String str3, String str4, byte[] bArr, byte[] bArr2, String str5, String str6) {
        super(108);
        ArrayList arrayList;
        this.issuingAuthority = str;
        this.dateOfIssue = str2;
        if (list != null) {
            arrayList = new ArrayList(list);
        }
        this.namesOfOtherPersons = arrayList;
        this.endorsementsAndObservations = str3;
        this.taxOrExitRequirements = str4;
        this.imageOfFront = bArr;
        this.imageOfRear = bArr2;
        this.dateAndTimeOfPersonalization = str5;
        this.personalizationSystemSerialNumber = str6;
    }

    public DG12File(InputStream inputStream) throws IOException {
        super(108, inputStream);
    }
}
