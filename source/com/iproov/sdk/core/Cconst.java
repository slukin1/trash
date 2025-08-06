package com.iproov.sdk.core;

import com.google.common.base.Ascii;
import com.iproov.sdk.core.Cnew;
import com.iproov.sdk.core.exception.IProovException;
import com.iproov.sdk.p017implements.Cif;
import com.iproov.sdk.utils.Cdo;
import java.lang.reflect.Method;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import net.sf.scuba.smartcards.ISO7816;
import org.json.JSONArray;
import org.json.JSONException;

/* renamed from: com.iproov.sdk.core.const  reason: invalid class name */
public class Cconst {

    /* renamed from: do  reason: not valid java name */
    public static final Ccatch[] f281do = {Ccatch.AND1, Ccatch.AND2, Ccatch.AND3, Ccatch.AND4, Ccatch.AND5, Ccatch.AND6, Ccatch.AND7, Ccatch.AND8, Ccatch.AND9, Ccatch.AND10, Ccatch.AND11, Ccatch.AND12, Ccatch.AND13, Ccatch.AND14};

    /* renamed from: for  reason: not valid java name */
    public static final Cgoto[] f282for = {Cgoto.AND20, Cgoto.AND21, Cgoto.AND22, Cgoto.AND23, Cgoto.AND24, Cgoto.AND25, Cgoto.AND26, Cgoto.AND27, Cgoto.AND28, Cgoto.AND29, Cgoto.AND30, Cgoto.AND31, Cgoto.AND32};

    /* renamed from: if  reason: not valid java name */
    public static final Cnew.Cdo[] f283if = {Cnew.Cdo.AND15, Cnew.Cdo.AND16, Cnew.Cdo.AND17, Cnew.Cdo.AND18, Cnew.Cdo.AND19};

    /* renamed from: do  reason: not valid java name */
    private static boolean m349do(Ccatch catchR) {
        return Cfinal.m386do(catchR) == Boolean.TRUE;
    }

    /* renamed from: if  reason: not valid java name */
    private static byte[] m355if(String str) {
        return new StringBuilder(str).reverse().toString().getBytes(StandardCharsets.UTF_8);
    }

    /* renamed from: do  reason: not valid java name */
    private static boolean m350do(Cnew.Cdo doVar) {
        return Cfinal.m387do(doVar) == Boolean.TRUE;
    }

    /* renamed from: do  reason: not valid java name */
    private static void m346do(int i11) {
        try {
            for (Method method : Class.forName(Ctry.m479switch()).getMethods()) {
                if (method.getName().equals("error")) {
                    method.invoke((Object) null, new Object[]{Integer.valueOf(i11)});
                    return;
                }
            }
        } catch (Exception unused) {
        }
    }

    /* renamed from: do  reason: not valid java name */
    private static void m347do(int i11, int i12, int i13) {
        if (i12 != i13) {
            m346do(i11);
        }
    }

    /* renamed from: do  reason: not valid java name */
    private static void m348do(JSONArray jSONArray) {
        int i11;
        try {
            int i12 = 0;
            for (Ccatch catchR : f281do) {
                i12 = i11 + 1;
                m347do(i12, jSONArray.getInt(i12), 1);
            }
            for (Cnew.Cdo doVar : f283if) {
                if (doVar == Cnew.Cdo.AND17 || doVar == Cnew.Cdo.AND18) {
                    i11++;
                } else {
                    i11++;
                    m347do(i11, jSONArray.getInt(i11), 0);
                }
            }
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static String m345do() {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(0);
        for (Ccatch catchR : f281do) {
            jSONArray.put(m344do((Object) Boolean.valueOf(m349do(catchR))));
        }
        for (Cnew.Cdo doVar : f283if) {
            jSONArray.put(m344do((Object) Boolean.valueOf(m350do(doVar))));
        }
        for (Cgoto gotoR : f282for) {
            jSONArray.put(m344do(Cfinal.m388do(gotoR)));
        }
        m348do(jSONArray);
        return jSONArray.toString();
    }

    /* renamed from: do  reason: not valid java name */
    public static Object m344do(Object obj) {
        return obj instanceof Boolean ? Integer.valueOf(((Boolean) obj).booleanValue() ? 1 : 0) : obj;
    }

    /* renamed from: do  reason: not valid java name */
    public static byte[] m351do(String str) throws NoSuchAlgorithmException {
        byte[] bArr = new byte[16];
        System.arraycopy(Cif.m1009do(Cdo.m2230do(m355if(str))), 0, bArr, 0, 16);
        return bArr;
    }

    /* renamed from: do  reason: not valid java name */
    public static byte[] m352do(byte[] bArr, String str) throws IProovException {
        try {
            return Cdo.m360do(m345do(), m351do(str), bArr);
        } catch (Exception e11) {
            e11.printStackTrace();
            throw new IProovException("Unknown data", e11);
        }
    }

    /* renamed from: do  reason: not valid java name */
    public static byte[] m353do(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length + 12)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        int length = bArr.length + bArr2.length;
        bArr3[length] = (byte) (bArr2.length >> 16);
        bArr3[length + 1] = (byte) (bArr2.length >> 8);
        bArr3[length + 2] = (byte) bArr2.length;
        bArr3[length + 3] = 0;
        bArr3[length + 4] = 0;
        bArr3[length + 5] = 0;
        bArr3[length + 6] = 0;
        bArr3[length + 7] = 0;
        bArr3[length + 8] = 0;
        bArr3[length + 9] = 0;
        bArr3[length + 10] = ISO7816.INS_MSE;
        bArr3[length + 11] = Ascii.ESC;
        return bArr3;
    }

    /* renamed from: do  reason: not valid java name */
    public static byte[] m354do(byte[] bArr, byte[] bArr2, String str) throws IProovException {
        return m353do(bArr, m352do(bArr2, str));
    }
}
