package org.jmrtd.lds.icao;

import java.io.ByteArrayInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVOutputStream;
import net.sf.scuba.tlv.TLVUtil;
import net.sf.scuba.util.Hex;
import okhttp3.HttpUrl;
import org.jmrtd.lds.DataGroup;

public class DG11File extends DataGroup {
    public static final int CONTENT_SPECIFIC_CONSTRUCTED_TAG = 160;
    public static final int COUNT_TAG = 2;
    public static final int CUSTODY_INFORMATION_TAG = 24344;
    public static final int FULL_DATE_OF_BIRTH_TAG = 24363;
    public static final int FULL_NAME_TAG = 24334;
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    public static final int OTHER_NAME_TAG = 24335;
    public static final int OTHER_VALID_TD_NUMBERS_TAG = 24343;
    public static final int PERMANENT_ADDRESS_TAG = 24386;
    public static final int PERSONAL_NUMBER_TAG = 24336;
    public static final int PERSONAL_SUMMARY_TAG = 24341;
    public static final int PLACE_OF_BIRTH_TAG = 24337;
    public static final int PROFESSION_TAG = 24339;
    public static final int PROOF_OF_CITIZENSHIP_TAG = 24342;
    private static final String SDF = "yyyyMMdd";
    public static final int TAG_LIST_TAG = 92;
    public static final int TELEPHONE_TAG = 24338;
    public static final int TITLE_TAG = 24340;
    private static final long serialVersionUID = 8566312538928662937L;
    private String custodyInformation;
    private String fullDateOfBirth;
    private String nameOfHolder;
    private List<String> otherNames;
    private List<String> otherValidTDNumbers;
    private List<String> permanentAddress;
    private String personalNumber;
    private String personalSummary;
    private List<String> placeOfBirth;
    private String profession;
    private byte[] proofOfCitizenship;
    private List<Integer> tagPresenceList;
    private String telephone;
    private String title;

    public DG11File(InputStream inputStream) throws IOException {
        super(107, inputStream);
    }

    private void parseCustodyInformation(byte[] bArr) {
        try {
            this.custodyInformation = new String(bArr, "UTF-8").trim();
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
            this.custodyInformation = new String(bArr).trim();
        }
    }

    private void parseFullDateOfBirth(byte[] bArr) {
        String str;
        if (bArr.length == 4) {
            str = Hex.bytesToHexString(bArr);
        } else {
            String str2 = new String(bArr);
            try {
                str = new String(bArr, "UTF-8");
            } catch (UnsupportedEncodingException e11) {
                LOGGER.log(Level.WARNING, "Exception", e11);
                str = str2;
            }
        }
        this.fullDateOfBirth = str;
    }

    private void parseNameOfHolder(byte[] bArr) {
        String str = new String(bArr);
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
        }
        this.nameOfHolder = str.trim();
    }

    private synchronized void parseOtherName(byte[] bArr) {
        if (this.otherNames == null) {
            this.otherNames = new ArrayList();
        }
        try {
            this.otherNames.add(new String(bArr, "UTF-8").trim());
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
            this.otherNames.add(new String(bArr).trim());
        }
        return;
    }

    private void parseOtherValidTDNumbers(byte[] bArr) {
        String trim = new String(bArr).trim();
        try {
            trim = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
        }
        this.otherValidTDNumbers = new ArrayList();
        StringTokenizer stringTokenizer = new StringTokenizer(trim, "<");
        while (stringTokenizer.hasMoreTokens()) {
            this.otherValidTDNumbers.add(stringTokenizer.nextToken().trim());
        }
    }

    private void parsePermanentAddress(byte[] bArr) {
        String str = new String(bArr);
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, "<");
        this.permanentAddress = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            this.permanentAddress.add(stringTokenizer.nextToken().trim());
        }
    }

    private void parsePersonalNumber(byte[] bArr) {
        String str = new String(bArr);
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
        }
        this.personalNumber = str.trim();
    }

    private void parsePersonalSummary(byte[] bArr) {
        try {
            this.personalSummary = new String(bArr, "UTF-8").trim();
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
            this.personalSummary = new String(bArr).trim();
        }
    }

    private void parsePlaceOfBirth(byte[] bArr) {
        String str = new String(bArr);
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
        }
        StringTokenizer stringTokenizer = new StringTokenizer(str, "<");
        this.placeOfBirth = new ArrayList();
        while (stringTokenizer.hasMoreTokens()) {
            this.placeOfBirth.add(stringTokenizer.nextToken().trim());
        }
    }

    private void parseProfession(byte[] bArr) {
        String str = new String(bArr);
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
        }
        this.profession = str.trim();
    }

    private void parseProofOfCitizenShip(byte[] bArr) {
        this.proofOfCitizenship = bArr;
    }

    private void parseTelephone(byte[] bArr) {
        String str = new String(bArr);
        try {
            str = new String(bArr, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
        }
        this.telephone = str.replace("<", " ").trim();
    }

    private void parseTitle(byte[] bArr) {
        try {
            this.title = new String(bArr, "UTF-8").trim();
        } catch (UnsupportedEncodingException e11) {
            LOGGER.log(Level.WARNING, "Exception", e11);
            this.title = new String(bArr).trim();
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
                        if (readTag3 == 24335) {
                            tLVInputStream.readLength();
                            parseOtherName(tLVInputStream.readValue());
                            i12++;
                        } else {
                            throw new IllegalArgumentException("Expected " + Integer.toHexString(OTHER_NAME_TAG) + ", found " + Integer.toHexString(readTag3));
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
            if (readTag == 24363) {
                parseFullDateOfBirth(readValue2);
            } else if (readTag != 24386) {
                switch (readTag) {
                    case FULL_NAME_TAG /*24334*/:
                        parseNameOfHolder(readValue2);
                        return;
                    case OTHER_NAME_TAG /*24335*/:
                        parseOtherName(readValue2);
                        return;
                    case PERSONAL_NUMBER_TAG /*24336*/:
                        parsePersonalNumber(readValue2);
                        return;
                    case PLACE_OF_BIRTH_TAG /*24337*/:
                        parsePlaceOfBirth(readValue2);
                        return;
                    case TELEPHONE_TAG /*24338*/:
                        parseTelephone(readValue2);
                        return;
                    case PROFESSION_TAG /*24339*/:
                        parseProfession(readValue2);
                        return;
                    case TITLE_TAG /*24340*/:
                        parseTitle(readValue2);
                        return;
                    case PERSONAL_SUMMARY_TAG /*24341*/:
                        parsePersonalSummary(readValue2);
                        return;
                    case PROOF_OF_CITIZENSHIP_TAG /*24342*/:
                        parseProofOfCitizenShip(readValue2);
                        return;
                    case OTHER_VALID_TD_NUMBERS_TAG /*24343*/:
                        parseOtherValidTDNumbers(readValue2);
                        return;
                    case CUSTODY_INFORMATION_TAG /*24344*/:
                        parseCustodyInformation(readValue2);
                        return;
                    default:
                        throw new IllegalArgumentException("Unknown field tag in DG11: " + Integer.toHexString(readTag));
                }
            } else {
                parsePermanentAddress(readValue2);
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
        return toString().equals(((DG11File) obj).toString());
    }

    public String getCustodyInformation() {
        return this.custodyInformation;
    }

    public String getFullDateOfBirth() {
        return this.fullDateOfBirth;
    }

    public String getNameOfHolder() {
        return this.nameOfHolder;
    }

    public List<String> getOtherNames() {
        return this.otherNames == null ? new ArrayList() : new ArrayList(this.otherNames);
    }

    public List<String> getOtherValidTDNumbers() {
        return this.otherValidTDNumbers;
    }

    public List<String> getPermanentAddress() {
        return this.permanentAddress;
    }

    public String getPersonalNumber() {
        return this.personalNumber;
    }

    public String getPersonalSummary() {
        return this.personalSummary;
    }

    public List<String> getPlaceOfBirth() {
        return this.placeOfBirth;
    }

    public String getProfession() {
        return this.profession;
    }

    public byte[] getProofOfCitizenship() {
        return this.proofOfCitizenship;
    }

    public int getTag() {
        return 107;
    }

    public List<Integer> getTagPresenceList() {
        List<Integer> list = this.tagPresenceList;
        if (list != null) {
            return list;
        }
        ArrayList arrayList = new ArrayList(12);
        this.tagPresenceList = arrayList;
        if (this.nameOfHolder != null) {
            arrayList.add(Integer.valueOf(FULL_NAME_TAG));
        }
        List<String> list2 = this.otherNames;
        if (list2 != null && !list2.isEmpty()) {
            this.tagPresenceList.add(Integer.valueOf(OTHER_NAME_TAG));
        }
        if (this.personalNumber != null) {
            this.tagPresenceList.add(Integer.valueOf(PERSONAL_NUMBER_TAG));
        }
        if (this.fullDateOfBirth != null) {
            this.tagPresenceList.add(Integer.valueOf(FULL_DATE_OF_BIRTH_TAG));
        }
        List<String> list3 = this.placeOfBirth;
        if (list3 != null && !list3.isEmpty()) {
            this.tagPresenceList.add(Integer.valueOf(PLACE_OF_BIRTH_TAG));
        }
        List<String> list4 = this.permanentAddress;
        if (list4 != null && !list4.isEmpty()) {
            this.tagPresenceList.add(Integer.valueOf(PERMANENT_ADDRESS_TAG));
        }
        if (this.telephone != null) {
            this.tagPresenceList.add(Integer.valueOf(TELEPHONE_TAG));
        }
        if (this.profession != null) {
            this.tagPresenceList.add(Integer.valueOf(PROFESSION_TAG));
        }
        if (this.title != null) {
            this.tagPresenceList.add(Integer.valueOf(TITLE_TAG));
        }
        if (this.personalSummary != null) {
            this.tagPresenceList.add(Integer.valueOf(PERSONAL_SUMMARY_TAG));
        }
        if (this.proofOfCitizenship != null) {
            this.tagPresenceList.add(Integer.valueOf(PROOF_OF_CITIZENSHIP_TAG));
        }
        List<String> list5 = this.otherValidTDNumbers;
        if (list5 != null && !list5.isEmpty()) {
            this.tagPresenceList.add(Integer.valueOf(OTHER_VALID_TD_NUMBERS_TAG));
        }
        if (this.custodyInformation != null) {
            this.tagPresenceList.add(Integer.valueOf(CUSTODY_INFORMATION_TAG));
        }
        return this.tagPresenceList;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (toString().hashCode() * 13) + 111;
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
            throw new IllegalArgumentException("Expected tag list in DG11");
        }
    }

    public String toString() {
        String str;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("DG11File [");
        String str2 = this.nameOfHolder;
        String str3 = "";
        if (str2 == null) {
            str2 = str3;
        }
        sb2.append(str2);
        sb2.append(", ");
        List<String> list = this.otherNames;
        String str4 = HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        sb2.append((list == null || list.isEmpty()) ? str4 : this.otherNames);
        sb2.append(", ");
        String str5 = this.personalNumber;
        if (str5 == null) {
            str5 = str3;
        }
        sb2.append(str5);
        sb2.append(", ");
        String str6 = this.fullDateOfBirth;
        if (str6 == null) {
            str6 = str3;
        }
        sb2.append(str6);
        sb2.append(", ");
        List<String> list2 = this.placeOfBirth;
        sb2.append((list2 == null || list2.isEmpty()) ? str4 : this.placeOfBirth.toString());
        sb2.append(", ");
        List<String> list3 = this.permanentAddress;
        sb2.append((list3 == null || list3.isEmpty()) ? str4 : this.permanentAddress.toString());
        sb2.append(", ");
        String str7 = this.telephone;
        if (str7 == null) {
            str7 = str3;
        }
        sb2.append(str7);
        sb2.append(", ");
        String str8 = this.profession;
        if (str8 == null) {
            str8 = str3;
        }
        sb2.append(str8);
        sb2.append(", ");
        String str9 = this.title;
        if (str9 == null) {
            str9 = str3;
        }
        sb2.append(str9);
        sb2.append(", ");
        String str10 = this.personalSummary;
        if (str10 == null) {
            str10 = str3;
        }
        sb2.append(str10);
        sb2.append(", ");
        if (this.proofOfCitizenship == null) {
            str = str3;
        } else {
            str = "image (" + this.proofOfCitizenship.length + ")";
        }
        sb2.append(str);
        sb2.append(", ");
        List<String> list4 = this.otherValidTDNumbers;
        if (list4 != null && !list4.isEmpty()) {
            str4 = this.otherValidTDNumbers.toString();
        }
        sb2.append(str4);
        sb2.append(", ");
        String str11 = this.custodyInformation;
        if (str11 != null) {
            str3 = str11;
        }
        sb2.append(str3);
        sb2.append("]");
        return sb2.toString();
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        TLVOutputStream tLVOutputStream = outputStream instanceof TLVOutputStream ? (TLVOutputStream) outputStream : new TLVOutputStream(outputStream);
        tLVOutputStream.writeTag(92);
        DataOutputStream dataOutputStream = new DataOutputStream(tLVOutputStream);
        List<Integer> tagPresenceList2 = getTagPresenceList();
        for (Integer intValue : tagPresenceList2) {
            dataOutputStream.writeShort(intValue.intValue());
        }
        dataOutputStream.flush();
        tLVOutputStream.writeValueEnd();
        for (Integer intValue2 : tagPresenceList2) {
            int intValue3 = intValue2.intValue();
            if (intValue3 != 24363) {
                boolean z11 = true;
                if (intValue3 != 24386) {
                    switch (intValue3) {
                        case FULL_NAME_TAG /*24334*/:
                            tLVOutputStream.writeTag(intValue3);
                            tLVOutputStream.writeValue(this.nameOfHolder.trim().getBytes("UTF-8"));
                            break;
                        case OTHER_NAME_TAG /*24335*/:
                            if (this.otherNames == null) {
                                this.otherNames = new ArrayList();
                            }
                            tLVOutputStream.writeTag(160);
                            tLVOutputStream.writeTag(2);
                            tLVOutputStream.write(this.otherNames.size());
                            tLVOutputStream.writeValueEnd();
                            for (String trim : this.otherNames) {
                                tLVOutputStream.writeTag(OTHER_NAME_TAG);
                                tLVOutputStream.writeValue(trim.trim().getBytes("UTF-8"));
                            }
                            tLVOutputStream.writeValueEnd();
                            break;
                        case PERSONAL_NUMBER_TAG /*24336*/:
                            tLVOutputStream.writeTag(intValue3);
                            tLVOutputStream.writeValue(this.personalNumber.trim().getBytes("UTF-8"));
                            break;
                        case PLACE_OF_BIRTH_TAG /*24337*/:
                            tLVOutputStream.writeTag(intValue3);
                            for (String next : this.placeOfBirth) {
                                if (next != null) {
                                    if (z11) {
                                        z11 = false;
                                    } else {
                                        tLVOutputStream.write(60);
                                    }
                                    tLVOutputStream.write(next.trim().getBytes("UTF-8"));
                                }
                            }
                            tLVOutputStream.writeValueEnd();
                            break;
                        case TELEPHONE_TAG /*24338*/:
                            tLVOutputStream.writeTag(intValue3);
                            tLVOutputStream.writeValue(this.telephone.trim().replace(' ', '<').getBytes("UTF-8"));
                            break;
                        case PROFESSION_TAG /*24339*/:
                            tLVOutputStream.writeTag(intValue3);
                            tLVOutputStream.writeValue(this.profession.trim().replace(' ', '<').getBytes("UTF-8"));
                            break;
                        case TITLE_TAG /*24340*/:
                            tLVOutputStream.writeTag(intValue3);
                            tLVOutputStream.writeValue(this.title.trim().replace(' ', '<').getBytes("UTF-8"));
                            break;
                        case PERSONAL_SUMMARY_TAG /*24341*/:
                            tLVOutputStream.writeTag(intValue3);
                            tLVOutputStream.writeValue(this.personalSummary.trim().replace(' ', '<').getBytes("UTF-8"));
                            break;
                        case PROOF_OF_CITIZENSHIP_TAG /*24342*/:
                            tLVOutputStream.writeTag(intValue3);
                            tLVOutputStream.writeValue(this.proofOfCitizenship);
                            break;
                        case OTHER_VALID_TD_NUMBERS_TAG /*24343*/:
                            tLVOutputStream.writeTag(intValue3);
                            for (String next2 : this.otherValidTDNumbers) {
                                if (next2 != null) {
                                    if (z11) {
                                        z11 = false;
                                    } else {
                                        tLVOutputStream.write(60);
                                    }
                                    tLVOutputStream.write(next2.trim().replace(' ', '<').getBytes("UTF-8"));
                                }
                            }
                            tLVOutputStream.writeValueEnd();
                            break;
                        case CUSTODY_INFORMATION_TAG /*24344*/:
                            tLVOutputStream.writeTag(intValue3);
                            tLVOutputStream.writeValue(this.custodyInformation.trim().replace(' ', '<').getBytes("UTF-8"));
                            break;
                        default:
                            throw new IllegalStateException("Unknown tag in DG11: " + Integer.toHexString(intValue3));
                    }
                } else {
                    tLVOutputStream.writeTag(intValue3);
                    for (String next3 : this.permanentAddress) {
                        if (next3 != null) {
                            if (z11) {
                                z11 = false;
                            } else {
                                tLVOutputStream.write(60);
                            }
                            tLVOutputStream.write(next3.trim().getBytes("UTF-8"));
                        }
                    }
                    tLVOutputStream.writeValueEnd();
                }
            } else {
                tLVOutputStream.writeTag(intValue3);
                tLVOutputStream.writeValue(this.fullDateOfBirth.getBytes("UTF-8"));
            }
        }
    }

    public DG11File(String str, List<String> list, String str2, Date date, List<String> list2, List<String> list3, String str3, String str4, String str5, String str6, byte[] bArr, List<String> list4, String str7) {
        this(str, list, str2, new SimpleDateFormat(SDF).format(date), list2, list3, str3, str4, str5, str6, bArr, list4, str7);
    }

    public DG11File(String str, List<String> list, String str2, String str3, List<String> list2, List<String> list3, String str4, String str5, String str6, String str7, byte[] bArr, List<String> list4, String str8) {
        super(107);
        ArrayList arrayList;
        ArrayList arrayList2;
        ArrayList arrayList3;
        this.nameOfHolder = str;
        if (list != null) {
            arrayList = new ArrayList(list);
        }
        this.otherNames = arrayList;
        this.personalNumber = str2;
        this.fullDateOfBirth = str3;
        if (list2 != null) {
            arrayList2 = new ArrayList(list2);
        }
        this.placeOfBirth = arrayList2;
        this.permanentAddress = list3;
        this.telephone = str4;
        this.profession = str5;
        this.title = str6;
        this.personalSummary = str7;
        this.proofOfCitizenship = bArr;
        if (list4 != null) {
            arrayList3 = new ArrayList(list4);
        }
        this.otherValidTDNumbers = arrayList3;
        this.custodyInformation = str8;
    }
}
