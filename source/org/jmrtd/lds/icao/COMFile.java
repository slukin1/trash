package org.jmrtd.lds.icao;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IllegalFormatConversionException;
import java.util.List;
import java.util.StringTokenizer;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.tlv.TLVOutputStream;
import org.jmrtd.lds.AbstractTaggedLDSFile;
import org.jmrtd.lds.LDSFileUtil;

public class COMFile extends AbstractTaggedLDSFile {
    private static final int TAG_LIST_TAG = 92;
    private static final int VERSION_LDS_TAG = 24321;
    private static final int VERSION_UNICODE_TAG = 24374;
    private static final long serialVersionUID = 2002455279067170063L;
    private String majorVersionUnicode;
    private String minorVersionUnicode;
    private String releaseLevelUnicode;
    private List<Integer> tagList;
    private String updateLevelLDS;
    private String versionLDS;

    public COMFile(String str, String str2, String str3, String str4, String str5, int[] iArr) {
        super(96);
        initialize(str, str2, str3, str4, str5, iArr);
    }

    private void initialize(String str, String str2, String str3, String str4, String str5, int[] iArr) {
        if (iArr == null) {
            throw new IllegalArgumentException("Null tag list");
        } else if (str == null || str.length() != 2 || str2 == null || str2.length() != 2 || str3 == null || str3.length() != 2 || str4 == null || str4.length() != 2 || str5 == null || str5.length() != 2) {
            throw new IllegalArgumentException();
        } else {
            this.versionLDS = str;
            this.updateLevelLDS = str2;
            this.majorVersionUnicode = str3;
            this.minorVersionUnicode = str4;
            this.releaseLevelUnicode = str5;
            this.tagList = new ArrayList(iArr.length);
            for (int valueOf : iArr) {
                this.tagList.add(Integer.valueOf(valueOf));
            }
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
        COMFile cOMFile = (COMFile) obj;
        if (!this.versionLDS.equals(cOMFile.versionLDS) || !this.updateLevelLDS.equals(cOMFile.updateLevelLDS) || !this.majorVersionUnicode.equals(cOMFile.majorVersionUnicode) || !this.minorVersionUnicode.equals(cOMFile.minorVersionUnicode) || !this.releaseLevelUnicode.equals(cOMFile.releaseLevelUnicode) || !this.tagList.equals(cOMFile.tagList)) {
            return false;
        }
        return true;
    }

    public String getLDSVersion() {
        try {
            int parseInt = Integer.parseInt(this.versionLDS);
            int parseInt2 = Integer.parseInt(this.updateLevelLDS);
            return parseInt + InstructionFileId.DOT + parseInt2;
        } catch (NumberFormatException unused) {
            return this.versionLDS + InstructionFileId.DOT + this.updateLevelLDS;
        }
    }

    public int[] getTagList() {
        int[] iArr = new int[this.tagList.size()];
        int i11 = 0;
        for (Integer intValue : this.tagList) {
            iArr[i11] = intValue.intValue();
            i11++;
        }
        return iArr;
    }

    public String getUnicodeVersion() {
        try {
            int parseInt = Integer.parseInt(this.majorVersionUnicode);
            int parseInt2 = Integer.parseInt(this.minorVersionUnicode);
            int parseInt3 = Integer.parseInt(this.releaseLevelUnicode);
            return parseInt + InstructionFileId.DOT + parseInt2 + InstructionFileId.DOT + parseInt3;
        } catch (NumberFormatException unused) {
            return this.majorVersionUnicode + InstructionFileId.DOT + this.minorVersionUnicode + InstructionFileId.DOT + this.releaseLevelUnicode;
        }
    }

    public int hashCode() {
        return (this.versionLDS.hashCode() * 3) + (this.updateLevelLDS.hashCode() * 5) + (this.majorVersionUnicode.hashCode() * 7) + (this.minorVersionUnicode.hashCode() * 11) + (this.releaseLevelUnicode.hashCode() * 13) + (this.tagList.hashCode() * 17);
    }

    public void insertTag(Integer num) {
        if (!this.tagList.contains(num)) {
            this.tagList.add(num);
            Collections.sort(this.tagList);
        }
    }

    public void readContent(InputStream inputStream) throws IOException {
        TLVInputStream tLVInputStream = inputStream instanceof TLVInputStream ? (TLVInputStream) inputStream : new TLVInputStream(inputStream);
        int readTag = tLVInputStream.readTag();
        if (readTag != VERSION_LDS_TAG) {
            throw new IllegalArgumentException("Excepected VERSION_LDS_TAG (" + Integer.toHexString(VERSION_LDS_TAG) + "), found " + Integer.toHexString(readTag));
        } else if (tLVInputStream.readLength() == 4) {
            byte[] readValue = tLVInputStream.readValue();
            this.versionLDS = new String(readValue, 0, 2);
            this.updateLevelLDS = new String(readValue, 2, 2);
            int readTag2 = tLVInputStream.readTag();
            if (readTag2 != VERSION_UNICODE_TAG) {
                throw new IllegalArgumentException("Expected VERSION_UNICODE_TAG (" + Integer.toHexString(VERSION_UNICODE_TAG) + "), found " + Integer.toHexString(readTag2));
            } else if (tLVInputStream.readLength() == 6) {
                byte[] readValue2 = tLVInputStream.readValue();
                this.majorVersionUnicode = new String(readValue2, 0, 2);
                this.minorVersionUnicode = new String(readValue2, 2, 2);
                this.releaseLevelUnicode = new String(readValue2, 4, 2);
                int readTag3 = tLVInputStream.readTag();
                if (readTag3 == 92) {
                    tLVInputStream.readLength();
                    byte[] readValue3 = tLVInputStream.readValue();
                    this.tagList = new ArrayList();
                    for (byte b11 : readValue3) {
                        this.tagList.add(Integer.valueOf(b11 & 255));
                    }
                    return;
                }
                throw new IllegalArgumentException("Expected TAG_LIST_TAG (" + Integer.toHexString(92) + "), found " + Integer.toHexString(readTag3));
            } else {
                throw new IllegalArgumentException("Wrong length of LDS version object");
            }
        } else {
            throw new IllegalArgumentException("Wrong length of LDS version object");
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("COMFile ");
        sb2.append("LDS " + this.versionLDS + InstructionFileId.DOT + this.updateLevelLDS);
        sb2.append(", ");
        sb2.append("Unicode " + this.majorVersionUnicode + InstructionFileId.DOT + this.minorVersionUnicode + InstructionFileId.DOT + this.releaseLevelUnicode);
        sb2.append(", ");
        sb2.append("[");
        int size = this.tagList.size();
        int i11 = 0;
        for (Integer intValue : this.tagList) {
            int intValue2 = intValue.intValue();
            sb2.append("DG" + LDSFileUtil.lookupDataGroupNumberByTag(intValue2));
            if (i11 < size - 1) {
                sb2.append(", ");
            }
            i11++;
        }
        sb2.append("]");
        return sb2.toString();
    }

    public void writeContent(OutputStream outputStream) throws IOException {
        TLVOutputStream tLVOutputStream = outputStream instanceof TLVOutputStream ? (TLVOutputStream) outputStream : new TLVOutputStream(outputStream);
        tLVOutputStream.writeTag(VERSION_LDS_TAG);
        tLVOutputStream.writeValue((this.versionLDS + this.updateLevelLDS).getBytes());
        tLVOutputStream.writeTag(VERSION_UNICODE_TAG);
        tLVOutputStream.writeValue((this.majorVersionUnicode + this.minorVersionUnicode + this.releaseLevelUnicode).getBytes());
        tLVOutputStream.writeTag(92);
        tLVOutputStream.writeLength(this.tagList.size());
        for (Integer intValue : this.tagList) {
            tLVOutputStream.write((int) (byte) intValue.intValue());
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public COMFile(String str, String str2, int[] iArr) {
        super(96);
        String str3 = str;
        String str4 = str2;
        if (str3 == null) {
            throw new IllegalArgumentException("Null versionLDS");
        } else if (str4 != null) {
            try {
                StringTokenizer stringTokenizer = new StringTokenizer(str, InstructionFileId.DOT);
                if (stringTokenizer.countTokens() == 2) {
                    Integer valueOf = Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken().trim()));
                    Integer valueOf2 = Integer.valueOf(Integer.parseInt(stringTokenizer.nextToken().trim()));
                    StringTokenizer stringTokenizer2 = new StringTokenizer(str2, InstructionFileId.DOT);
                    if (stringTokenizer2.countTokens() == 3) {
                        Integer valueOf3 = Integer.valueOf(Integer.parseInt(stringTokenizer2.nextToken().trim()));
                        Integer valueOf4 = Integer.valueOf(Integer.parseInt(stringTokenizer2.nextToken().trim()));
                        Integer valueOf5 = Integer.valueOf(Integer.parseInt(stringTokenizer2.nextToken().trim()));
                        initialize(String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{valueOf}), String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{valueOf2}), String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{valueOf3}), String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{valueOf4}), String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, new Object[]{valueOf5}), iArr);
                        return;
                    }
                    throw new IllegalArgumentException("Could not parse unicode version. Expecting 3 level version number x.y.z.");
                }
                throw new IllegalArgumentException("Could not parse LDS version. Expecting 2 level version number x.y.");
            } catch (NumberFormatException e11) {
                throw new IllegalArgumentException("Could not parse version number", e11);
            } catch (IllegalFormatConversionException e12) {
                throw new IllegalArgumentException("Could not parse version number", e12);
            }
        } else {
            throw new IllegalArgumentException("Null versionUnicode");
        }
    }

    public COMFile(InputStream inputStream) throws IOException {
        super(96, inputStream);
    }
}
