package com.mob.commons.cc;

import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.mob.commons.l;
import com.mob.tools.MobLog;
import com.mob.tools.log.NLog;
import com.mob.tools.utils.Data;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.DataOutputStream;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class r implements t<r> {
    public String b(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        int length = bArr.length;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i11 = 0; i11 < length; i11++) {
            stringBuffer.append(String.format("%02x", new Object[]{Byte.valueOf(bArr[i11])}));
        }
        return stringBuffer.toString();
    }

    public byte[] c(String str, String str2, byte[] bArr, byte[] bArr2) throws Throwable {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, 0, bArr3, 0, Math.min(bArr.length, 16));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr3, l.a("003(hfikgn"));
        Cipher cipher = Data.getCipher(str, str2);
        cipher.init(2, secretKeySpec);
        return cipher.doFinal(bArr2);
    }

    public static void a(Closeable... closeableArr) {
        for (Closeable closeable : closeableArr) {
            if (closeable != null) {
                try {
                    closeable.close();
                } catch (Throwable unused) {
                }
            }
        }
    }

    public String a(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr, 0, bArr.length);
            String a11 = a((InputStream) byteArrayInputStream);
            byteArrayInputStream.close();
            return a11;
        } catch (Throwable unused) {
            return null;
        }
    }

    public byte[] b(String str, String str2, byte[] bArr, byte[] bArr2) throws Throwable {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, 0, bArr3, 0, Math.min(bArr.length, 16));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr3, l.a("003Whfikgn"));
        Cipher cipher = Data.getCipher(str, str2);
        cipher.init(2, secretKeySpec);
        byte[] bArr4 = new byte[cipher.getOutputSize(bArr2.length)];
        cipher.doFinal(bArr4, cipher.update(bArr2, 0, bArr2.length, bArr4, 0));
        return bArr4;
    }

    public String a(InputStream inputStream) {
        byte[] bArr = null;
        if (inputStream == null) {
            return null;
        }
        try {
            byte[] bArr2 = new byte[1024];
            MessageDigest instance = MessageDigest.getInstance(l.a("003Yjehnjk"));
            int read = inputStream.read(bArr2);
            while (read != -1) {
                instance.update(bArr2, 0, read);
                read = inputStream.read(bArr2);
            }
            bArr = instance.digest();
        } catch (Throwable unused) {
        }
        return b(bArr);
    }

    public ArrayList<HashMap<String, String>> a(ArrayList<HashMap<String, String>> arrayList, ArrayList<HashMap<String, String>> arrayList2, String str) {
        ArrayList<HashMap<String, String>> arrayList3 = new ArrayList<>();
        Iterator<HashMap<String, String>> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            HashMap next = it2.next();
            String str2 = (String) next.get(str);
            if (!TextUtils.isEmpty(str2)) {
                boolean z11 = false;
                Iterator<HashMap<String, String>> it3 = arrayList2.iterator();
                while (true) {
                    if (it3.hasNext()) {
                        if (str2.equals(it3.next().get(str))) {
                            z11 = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!z11) {
                    arrayList3.add(next);
                }
            }
        }
        return arrayList3;
    }

    public byte[] a(String str, String str2, byte[] bArr, byte[] bArr2) throws Throwable {
        if (bArr == null || bArr2 == null) {
            return null;
        }
        byte[] bArr3 = new byte[16];
        System.arraycopy(bArr, 0, bArr3, 0, Math.min(bArr.length, 16));
        SecretKeySpec secretKeySpec = new SecretKeySpec(bArr3, l.a("003Bhfikgn"));
        Cipher cipher = Data.getCipher(str, str2);
        cipher.init(1, secretKeySpec);
        byte[] bArr4 = new byte[cipher.getOutputSize(bArr2.length)];
        cipher.doFinal(bArr4, cipher.update(bArr2, 0, bArr2.length, bArr4, 0));
        return bArr4;
    }

    public byte[] a(int i11, byte[] bArr, BigInteger bigInteger, BigInteger bigInteger2) throws Throwable {
        byte[] bArr2 = bArr;
        int i12 = i11 / 8;
        int i13 = i12 - 11;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = null;
        try {
            DataOutputStream dataOutputStream2 = new DataOutputStream(byteArrayOutputStream);
            int i14 = 0;
            while (bArr2.length > i14) {
                try {
                    int min = Math.min(bArr2.length - i14, i13);
                    byte[] a11 = a(bArr, i14, min, bigInteger, bigInteger2, i12);
                    dataOutputStream2.writeInt(a11.length);
                    dataOutputStream2.write(a11);
                    i14 += min;
                } catch (Throwable th2) {
                    th = th2;
                    dataOutputStream = dataOutputStream2;
                    a(dataOutputStream);
                    throw th;
                }
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            a(dataOutputStream2);
            return byteArray;
        } catch (Throwable th3) {
            th = th3;
            a(dataOutputStream);
            throw th;
        }
    }

    private byte[] a(byte[] bArr, int i11, int i12, BigInteger bigInteger, BigInteger bigInteger2, int i13) throws Throwable {
        if (!(bArr.length == i12 && i11 == 0)) {
            byte[] bArr2 = new byte[i12];
            System.arraycopy(bArr, i11, bArr2, 0, i12);
            bArr = bArr2;
        }
        BigInteger bigInteger3 = new BigInteger(a(bArr, i13));
        if (bigInteger3.compareTo(bigInteger2) <= 0) {
            return bigInteger3.modPow(bigInteger, bigInteger2).toByteArray();
        }
        throw new Throwable("the message must be smaller than the modulue");
    }

    private byte[] a(byte[] bArr, int i11) throws Throwable {
        if (bArr.length <= i11 - 1) {
            byte[] bArr2 = new byte[i11];
            bArr2[0] = 1;
            int length = bArr.length;
            bArr2[1] = (byte) (length >> 24);
            bArr2[2] = (byte) (length >> 16);
            bArr2[3] = (byte) (length >> 8);
            bArr2[4] = (byte) length;
            System.arraycopy(bArr, 0, bArr2, i11 - length, length);
            return bArr2;
        }
        throw new Throwable("Message too large");
    }

    public boolean a(r rVar, Class<r> cls, String str, Object[] objArr, boolean[] zArr, Object[] objArr2, Throwable[] thArr) {
        if ("bm5".equals(str) && objArr.length == 1) {
            objArr2[0] = rVar.a(objArr[0]);
            return true;
        } else if ("sm5".equals(str)) {
            objArr2[0] = rVar.a(objArr[0]);
            return true;
        } else if ("thx".equals(str)) {
            objArr2[0] = rVar.b(objArr[0]);
            return true;
        } else if ("fnil".equals(str) && objArr.length == 3) {
            objArr2[0] = rVar.a(objArr[0], objArr[1], objArr[2]);
            return true;
        } else if ("aesen".equals(str) && objArr.length == 4) {
            try {
                objArr2[0] = a(objArr[0], objArr[1], objArr[2], objArr[3]);
            } catch (Throwable th2) {
                objArr2[0] = null;
                thArr[0] = th2;
            }
            return true;
        } else if (l.a("005fhNhkfeVh").equals(str) && objArr.length == 4) {
            try {
                objArr2[0] = b(objArr[0], objArr[1], objArr[2], objArr[3]);
            } catch (Throwable th3) {
                objArr2[0] = null;
                thArr[0] = th3;
            }
            return true;
        } else if (l.a("006fhLhkfehi(l").equals(str) && objArr.length == 4) {
            try {
                objArr2[0] = c(objArr[0], objArr[1], objArr[2], objArr[3]);
            } catch (Throwable th4) {
                objArr2[0] = null;
                thArr[0] = th4;
            }
            return true;
        } else if ("enc".equals(str) && objArr.length == 4) {
            try {
                objArr2[0] = a(objArr[0].intValue(), objArr[1], objArr[2], objArr[3]);
            } catch (Throwable th5) {
                objArr2[0] = null;
                thArr[0] = th5;
            }
            return true;
        } else if (!GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG.equals(str)) {
            return false;
        } else {
            if (objArr.length == 1 && (objArr[0] instanceof String)) {
                NLog instance = MobLog.getInstance();
                instance.d("%s", "[sasa] " + objArr[0]);
            } else if (objArr.length == 1 && (objArr[0] instanceof Throwable)) {
                MobLog.getInstance().d(objArr[0], "%s", "[sasa]");
            }
            return true;
        }
    }
}
