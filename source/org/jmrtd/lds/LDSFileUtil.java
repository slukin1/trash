package org.jmrtd.lds;

import com.tencent.qcloud.tuikit.tuichat.bean.message.TipsMessageBean;
import com.tencent.tpns.mqttchannel.core.common.config.MqttConfigImpl;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.jmrtd.PassportService;
import org.jmrtd.lds.icao.COMFile;
import org.jmrtd.lds.icao.DG11File;
import org.jmrtd.lds.icao.DG12File;
import org.jmrtd.lds.icao.DG14File;
import org.jmrtd.lds.icao.DG15File;
import org.jmrtd.lds.icao.DG1File;
import org.jmrtd.lds.icao.DG2File;
import org.jmrtd.lds.icao.DG3File;
import org.jmrtd.lds.icao.DG4File;
import org.jmrtd.lds.icao.DG5File;
import org.jmrtd.lds.icao.DG6File;
import org.jmrtd.lds.icao.DG7File;

public final class LDSFileUtil {
    public static final Map<Short, Byte> FID_TO_SFI = createFIDToSFIMap();
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");

    private LDSFileUtil() {
    }

    private static Map<Short, Byte> createFIDToSFIMap() {
        HashMap hashMap = new HashMap(20);
        hashMap.put(Short.valueOf(PassportService.EF_COM), (byte) 30);
        hashMap.put(Short.valueOf(PassportService.EF_DG1), (byte) 1);
        hashMap.put(Short.valueOf(PassportService.EF_DG2), (byte) 2);
        hashMap.put(Short.valueOf(PassportService.EF_DG3), (byte) 3);
        hashMap.put(Short.valueOf(PassportService.EF_DG4), (byte) 4);
        hashMap.put(Short.valueOf(PassportService.EF_DG5), (byte) 5);
        hashMap.put(Short.valueOf(PassportService.EF_DG6), (byte) 6);
        hashMap.put(Short.valueOf(PassportService.EF_DG7), (byte) 7);
        hashMap.put(Short.valueOf(PassportService.EF_DG8), (byte) 8);
        hashMap.put(Short.valueOf(PassportService.EF_DG9), (byte) 9);
        hashMap.put(Short.valueOf(PassportService.EF_DG10), (byte) 10);
        hashMap.put(Short.valueOf(PassportService.EF_DG11), (byte) 11);
        hashMap.put(Short.valueOf(PassportService.EF_DG12), (byte) 12);
        hashMap.put(Short.valueOf(PassportService.EF_DG13), (byte) 13);
        hashMap.put(Short.valueOf(PassportService.EF_DG14), (byte) 14);
        hashMap.put(Short.valueOf(PassportService.EF_DG15), (byte) 15);
        hashMap.put(Short.valueOf(PassportService.EF_DG16), (byte) 16);
        hashMap.put((short) 285, (byte) 29);
        hashMap.put((short) 284, (byte) 28);
        return Collections.unmodifiableMap(hashMap);
    }

    public static List<Integer> getDataGroupNumbers(SODFile sODFile) {
        ArrayList arrayList = new ArrayList();
        if (sODFile == null) {
            return arrayList;
        }
        arrayList.addAll(sODFile.getDataGroupHashes().keySet());
        Collections.sort(arrayList);
        return arrayList;
    }

    public static AbstractLDSFile getLDSFile(short s11, InputStream inputStream) throws IOException {
        switch (s11) {
            case 257:
                return new DG1File(inputStream);
            case 258:
                return new DG2File(inputStream);
            case 259:
                return new DG3File(inputStream);
            case TipsMessageBean.MSG_TYPE_GROUP_QUITE:
                return new DG4File(inputStream);
            case TipsMessageBean.MSG_TYPE_GROUP_KICK:
                return new DG5File(inputStream);
            case TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NAME:
                return new DG6File(inputStream);
            case 263:
                return new DG7File(inputStream);
            case 264:
                throw new IllegalArgumentException("DG8 files are not yet supported");
            case 265:
                throw new IllegalArgumentException("DG9 files are not yet supported");
            case 266:
                throw new IllegalArgumentException("DG10 files are not yet supported");
            case 267:
                return new DG11File(inputStream);
            case 268:
                return new DG12File(inputStream);
            case 269:
                throw new IllegalArgumentException("DG13 files are not yet supported");
            case 270:
                return new DG14File(inputStream);
            case 271:
                return new DG15File(inputStream);
            case 272:
                throw new IllegalArgumentException("DG16 files are not yet supported");
            default:
                switch (s11) {
                    case 284:
                        return new CVCAFile(inputStream);
                    case MqttConfigImpl.DEFAULT_KEEP_ALIVE_INTERVAL:
                        return new SODFile(inputStream);
                    case 286:
                        return new COMFile(inputStream);
                    default:
                        BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream, 37);
                        try {
                            bufferedInputStream.mark(37);
                            return new CVCAFile(s11, (InputStream) bufferedInputStream);
                        } catch (Exception e11) {
                            Logger logger = LOGGER;
                            Level level = Level.WARNING;
                            logger.log(level, "Unknown file " + Integer.toHexString(s11), e11);
                            bufferedInputStream.reset();
                            throw new NumberFormatException("Unknown file " + Integer.toHexString(s11));
                        }
                }
        }
    }

    public static int lookupDataGroupNumberByFID(short s11) {
        switch (s11) {
            case 257:
                return 1;
            case 258:
                return 2;
            case 259:
                return 3;
            case TipsMessageBean.MSG_TYPE_GROUP_QUITE:
                return 4;
            case TipsMessageBean.MSG_TYPE_GROUP_KICK:
                return 5;
            case TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NAME:
                return 6;
            case 263:
                return 7;
            case 264:
                return 8;
            case 265:
                return 9;
            case 266:
                return 10;
            case 267:
                return 11;
            case 268:
                return 12;
            case 269:
                return 13;
            case 270:
                return 14;
            case 271:
                return 15;
            case 272:
                return 16;
            default:
                throw new NumberFormatException("Unknown fid " + Integer.toHexString(s11));
        }
    }

    public static int lookupDataGroupNumberByTag(int i11) {
        if (i11 == 97) {
            return 1;
        }
        if (i11 == 99) {
            return 3;
        }
        if (i11 == 117) {
            return 2;
        }
        if (i11 == 118) {
            return 4;
        }
        switch (i11) {
            case 101:
                return 5;
            case 102:
                return 6;
            case 103:
                return 7;
            case 104:
                return 8;
            case 105:
                return 9;
            case 106:
                return 10;
            case 107:
                return 11;
            case 108:
                return 12;
            case 109:
                return 13;
            case 110:
                return 14;
            case 111:
                return 15;
            case 112:
                return 16;
            default:
                throw new NumberFormatException("Unknown tag " + Integer.toHexString(i11));
        }
    }

    public static short lookupFIDByDataGroupNumber(int i11) {
        switch (i11) {
            case 1:
                return PassportService.EF_DG1;
            case 2:
                return PassportService.EF_DG2;
            case 3:
                return PassportService.EF_DG3;
            case 4:
                return PassportService.EF_DG4;
            case 5:
                return PassportService.EF_DG5;
            case 6:
                return PassportService.EF_DG6;
            case 7:
                return PassportService.EF_DG7;
            case 8:
                return PassportService.EF_DG8;
            case 9:
                return PassportService.EF_DG9;
            case 10:
                return PassportService.EF_DG10;
            case 11:
                return PassportService.EF_DG11;
            case 12:
                return PassportService.EF_DG12;
            case 13:
                return PassportService.EF_DG13;
            case 14:
                return PassportService.EF_DG14;
            case 15:
                return PassportService.EF_DG15;
            case 16:
                return PassportService.EF_DG16;
            default:
                throw new NumberFormatException("Unknown number " + i11);
        }
    }

    public static short lookupFIDBySFI(byte b11) {
        switch (b11) {
            case 1:
                return PassportService.EF_DG1;
            case 2:
                return PassportService.EF_DG2;
            case 3:
                return PassportService.EF_DG3;
            case 4:
                return PassportService.EF_DG4;
            case 5:
                return PassportService.EF_DG5;
            case 6:
                return PassportService.EF_DG6;
            case 7:
                return PassportService.EF_DG7;
            case 8:
                return PassportService.EF_DG8;
            case 9:
                return PassportService.EF_DG9;
            case 10:
                return PassportService.EF_DG10;
            case 11:
                return PassportService.EF_DG11;
            case 12:
                return PassportService.EF_DG12;
            case 13:
                return PassportService.EF_DG13;
            case 14:
                return PassportService.EF_DG14;
            case 15:
                return PassportService.EF_DG15;
            case 16:
                return PassportService.EF_DG16;
            default:
                switch (b11) {
                    case 28:
                        return 284;
                    case 29:
                        return 285;
                    case 30:
                        return PassportService.EF_COM;
                    default:
                        throw new NumberFormatException("Unknown SFI " + Integer.toHexString(b11));
                }
        }
    }

    public static short lookupFIDByTag(int i11) {
        switch (i11) {
            case 96:
                return PassportService.EF_COM;
            case 97:
                return PassportService.EF_DG1;
            case 99:
                return PassportService.EF_DG3;
            case 101:
                return PassportService.EF_DG5;
            case 102:
                return PassportService.EF_DG6;
            case 103:
                return PassportService.EF_DG7;
            case 104:
                return PassportService.EF_DG8;
            case 105:
                return PassportService.EF_DG9;
            case 106:
                return PassportService.EF_DG10;
            case 107:
                return PassportService.EF_DG11;
            case 108:
                return PassportService.EF_DG12;
            case 109:
                return PassportService.EF_DG13;
            case 110:
                return PassportService.EF_DG14;
            case 111:
                return PassportService.EF_DG15;
            case 112:
                return PassportService.EF_DG16;
            case 117:
                return PassportService.EF_DG2;
            case 118:
                return PassportService.EF_DG4;
            case 119:
                return 285;
            default:
                throw new NumberFormatException("Unknown tag " + Integer.toHexString(i11));
        }
    }

    public static String lookupFileNameByFID(int i11) {
        if (i11 == 285) {
            return "EF_SOD";
        }
        if (i11 == 286) {
            return "EF_COM";
        }
        switch (i11) {
            case 257:
                return "EF_DG1";
            case 258:
                return "EF_DG2";
            case 259:
                return "EF_DG3";
            case TipsMessageBean.MSG_TYPE_GROUP_QUITE:
                return "EF_DG4";
            case TipsMessageBean.MSG_TYPE_GROUP_KICK:
                return "EF_DG5";
            case TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NAME:
                return "EF_DG6";
            case 263:
                return "EF_DG7";
            case 264:
                return "EF_DG8";
            case 265:
                return "EF_DG9";
            case 266:
                return "EF_DG10";
            case 267:
                return "EF_DG11";
            case 268:
                return "EF_DG12";
            case 269:
                return "EF_DG13";
            case 270:
                return "EF_DG14";
            case 271:
                return "EF_DG15";
            case 272:
                return "EF_DG16";
            default:
                return "File with FID 0x" + Integer.toHexString(i11);
        }
    }

    public static String lookupFileNameByTag(int i11) {
        switch (i11) {
            case 96:
                return "EF_COM";
            case 97:
                return "EF_DG1";
            case 99:
                return "EF_DG3";
            case 101:
                return "EF_DG5";
            case 102:
                return "EF_DG6";
            case 103:
                return "EF_DG7";
            case 104:
                return "EF_DG8";
            case 105:
                return "EF_DG9";
            case 106:
                return "EF_DG10";
            case 107:
                return "EF_DG11";
            case 108:
                return "EF_DG12";
            case 109:
                return "EF_DG13";
            case 110:
                return "EF_DG14";
            case 111:
                return "EF_DG15";
            case 112:
                return "EF_DG16";
            case 117:
                return "EF_DG2";
            case 118:
                return "EF_DG4";
            case 119:
                return "EF_SOD";
            default:
                return "File with tag 0x" + Integer.toHexString(i11);
        }
    }

    public static int lookupSFIByFID(short s11) {
        Byte b11 = FID_TO_SFI.get(Short.valueOf(s11));
        if (b11 != null) {
            return b11.byteValue() & 255;
        }
        throw new NumberFormatException("Unknown FID " + Integer.toHexString(s11));
    }

    public static int lookupTagByDataGroupNumber(int i11) {
        switch (i11) {
            case 1:
                return 97;
            case 2:
                return 117;
            case 3:
                return 99;
            case 4:
                return 118;
            case 5:
                return 101;
            case 6:
                return 102;
            case 7:
                return 103;
            case 8:
                return 104;
            case 9:
                return 105;
            case 10:
                return 106;
            case 11:
                return 107;
            case 12:
                return 108;
            case 13:
                return 109;
            case 14:
                return 110;
            case 15:
                return 111;
            case 16:
                return 112;
            default:
                throw new NumberFormatException("Unknown number " + i11);
        }
    }

    public static short lookupTagByFID(short s11) {
        if (s11 == 285) {
            return 119;
        }
        if (s11 == 286) {
            return 96;
        }
        switch (s11) {
            case 257:
                return 97;
            case 258:
                return 117;
            case 259:
                return 99;
            case TipsMessageBean.MSG_TYPE_GROUP_QUITE:
                return 118;
            case TipsMessageBean.MSG_TYPE_GROUP_KICK:
                return 101;
            case TipsMessageBean.MSG_TYPE_GROUP_MODIFY_NAME:
                return 102;
            case 263:
                return 103;
            case 264:
                return 104;
            case 265:
                return 105;
            case 266:
                return 106;
            case 267:
                return 107;
            case 268:
                return 108;
            case 269:
                return 109;
            case 270:
                return 110;
            case 271:
                return 111;
            case 272:
                return 112;
            default:
                throw new NumberFormatException("Unknown fid " + Integer.toHexString(s11));
        }
    }

    private static List<Integer> toDataGroupList(int[] iArr) {
        if (iArr == null) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList(iArr.length);
        for (int i11 : iArr) {
            try {
                arrayList.add(Integer.valueOf(lookupDataGroupNumberByTag(i11)));
            } catch (NumberFormatException e11) {
                LOGGER.log(Level.WARNING, "Could not find DG number for tag: " + Integer.toHexString(i11), e11);
            }
        }
        return arrayList;
    }

    public static List<Integer> getDataGroupNumbers(COMFile cOMFile) {
        ArrayList arrayList = new ArrayList();
        if (cOMFile == null) {
            return arrayList;
        }
        arrayList.addAll(toDataGroupList(cOMFile.getTagList()));
        Collections.sort(arrayList);
        return arrayList;
    }
}
