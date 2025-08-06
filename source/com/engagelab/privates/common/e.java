package com.engagelab.privates.common;

import android.content.Context;
import android.text.TextUtils;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.common.utils.AESUtil;
import com.engagelab.privates.common.utils.GZipUtil;
import com.engagelab.privates.common.utils.SM4Util;
import com.engagelab.privates.common.utils.StringUtil;
import com.engagelab.privates.common.utils.SystemUtil;
import com.engagelab.privates.core.api.Address;
import com.engagelab.privates.core.api.MTCorePrivatesApi;
import com.engagelab.privates.core.api.Outputer;
import com.engagelab.privates.core.global.MTCoreGlobal;
import com.huochat.community.network.domain.DomainTool;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONObject;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public DatagramSocket f64957a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f64958b;

    public final boolean a(Context context, String str, int i11) {
        try {
            if (TextUtils.isEmpty(str) || i11 <= 0) {
                return false;
            }
            MTCommonLog.d("UdpClient", "udp connect " + str + ":" + i11);
            InetAddress byName = InetAddress.getByName(str);
            byte[] a11 = a(context);
            if (a11 == null) {
                return false;
            }
            DatagramPacket datagramPacket = new DatagramPacket(a11, a11.length, byName, i11);
            DatagramSocket datagramSocket = new DatagramSocket();
            this.f64957a = datagramSocket;
            datagramSocket.setSoTimeout(6000);
            this.f64957a.send(datagramPacket);
            byte[] bArr = new byte[1024];
            this.f64957a.receive(new DatagramPacket(bArr, 1024));
            return a(context, bArr);
        } catch (Throwable th2) {
            MTCommonLog.d("UdpClient", "udp connect failed " + th2.getMessage());
            return false;
        }
    }

    public final Set<String> b(Context context) {
        Set<String> l11 = g.l(context);
        Address address = MTCoreGlobal.getAddress();
        int sisPort = address.getSisPort();
        if (sisPort <= 0) {
            return l11;
        }
        String[] sisHostArray = address.getSisHostArray();
        if (sisHostArray != null && sisHostArray.length > 0) {
            for (String str : sisHostArray) {
                l11.add(str + ":" + sisPort);
            }
        }
        String[] sisIpArray = address.getSisIpArray();
        if (sisIpArray != null && sisIpArray.length > 0) {
            for (String str2 : sisIpArray) {
                l11.add(str2 + ":" + sisPort);
            }
        }
        return l11;
    }

    public void c(Context context) {
        if (this.f64958b) {
            MTCommonLog.d("UdpClient", "can't connect, isUdpConnecting");
            return;
        }
        this.f64958b = true;
        Set<String> b11 = b(context);
        if (b11.isEmpty()) {
            MTCommonLog.d("UdpClient", "there are no udp connect address");
            return;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i11 = 0; i11 < 3; i11++) {
            arrayList.addAll(b11);
        }
        for (String str : arrayList) {
            if (!g.a(context)) {
                MTCommonLog.d("UdpClient", "can't connect ,connect state is false");
                d(context);
                return;
            } else if (!SystemUtil.isNetworkConnecting(context)) {
                MTCommonLog.d("UdpClient", "can't connect, network is disConnected");
                return;
            } else {
                String[] split = str.split(":");
                String str2 = split[split.length - 1];
                if (a(context, str.substring(0, (str.length() - str2.length()) - 1), Integer.parseInt(str2))) {
                    return;
                }
            }
        }
    }

    public void d(Context context) {
        this.f64958b = false;
        if (this.f64957a != null) {
            MTCommonLog.d("UdpClient", "udp disconnect");
            this.f64957a.close();
        }
    }

    public final byte[] a(Context context) {
        int i11;
        byte[] bArr;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("platform", 0);
            jSONObject.put("sdkver", MTCorePrivatesApi.SDK_VERSION_NAME);
            jSONObject.put("appkey", MTGlobal.getAppKey(context));
            jSONObject.put("uid", g.m(context));
            jSONObject.put("type", MTGlobal.getNetworkType());
            jSONObject.put("opera", MTGlobal.getNetworkName());
            MTCommonLog.d("UdpClient", "udp send:" + MTCommonLog.toLogString(jSONObject));
            byte[] stringToUtf8Bytes = StringUtil.stringToUtf8Bytes(jSONObject.toString());
            byte[] zip = GZipUtil.zip(stringToUtf8Bytes);
            if (zip == null) {
                i11 = 0;
            } else {
                stringToUtf8Bytes = zip;
                i11 = 1;
            }
            int length = stringToUtf8Bytes.length;
            int generateSeed = AESUtil.generateSeed();
            long j11 = (long) generateSeed;
            String md5AesKey = AESUtil.getMd5AesKey(j11);
            byte b11 = i11 != 0 ? (byte) 1 : 0;
            int encryptType = MTGlobal.getEncryptType();
            if (encryptType == 1) {
                b11 = (byte) (b11 | 16);
                bArr = AESUtil.encryptBytes(stringToUtf8Bytes, md5AesKey, md5AesKey.substring(0, 16));
            } else if (encryptType != 2) {
                bArr = AESUtil.encryptBytes(stringToUtf8Bytes, md5AesKey);
            } else {
                b11 = (byte) (b11 | 32);
                bArr = SM4Util.encryptBytes(stringToUtf8Bytes, md5AesKey, md5AesKey.substring(0, 16));
            }
            Outputer outputer = new Outputer(bArr.length + 10);
            outputer.writeU16(0);
            outputer.writeByteArray("UG".getBytes());
            outputer.writeU32(j11);
            outputer.writeU8At(b11, 4);
            outputer.writeU16(length);
            outputer.writeByteArray(bArr);
            outputer.writeU16At(outputer.current(), 0);
            MTCommonLog.d("UdpClient", "send totalLength:" + outputer.current() + ", encryption:" + encryptType + ", compress:" + i11 + ", sid:" + generateSeed);
            return outputer.toByteArray();
        } catch (Throwable th2) {
            MTCommonLog.w("UdpClient", "packageRequest failed " + th2.getMessage());
            return null;
        }
    }

    public final boolean a(Context context, byte[] bArr) {
        byte[] bArr2;
        try {
            byte[] bArr3 = new byte[10];
            System.arraycopy(bArr, 0, bArr3, 0, 10);
            ByteBuffer wrap = ByteBuffer.wrap(bArr3);
            short s11 = wrap.getShort();
            wrap.getShort();
            int i11 = wrap.getInt();
            int i12 = i11 >>> 24;
            long j11 = (long) (i11 & FlexItem.MAX_SIZE);
            wrap.getShort();
            int i13 = i12 >>> 4;
            int i14 = i12 & 1;
            String md5AesKey = AESUtil.getMd5AesKey(j11);
            MTCommonLog.d("UdpClient", "receive totalLength:" + s11 + ", encryption:" + i13 + ", compress:" + i14 + ", sid:" + j11);
            int i15 = s11 - 10;
            byte[] bArr4 = new byte[i15];
            System.arraycopy(bArr, 10, bArr4, 0, i15);
            if (i13 == 1) {
                bArr2 = AESUtil.decryptBytes(bArr4, md5AesKey, md5AesKey.substring(0, 16));
            } else if (i13 != 2) {
                bArr2 = AESUtil.decryptBytes(bArr4, md5AesKey);
            } else {
                bArr2 = SM4Util.decryptBytes(bArr4, md5AesKey);
            }
            if (i14 == 1) {
                bArr2 = GZipUtil.unzip(bArr2);
            }
            JSONObject jSONObject = new JSONObject(new String(bArr2));
            MTCommonLog.d("UdpClient", "udp receive " + MTCommonLog.toLogString(jSONObject));
            JSONArray optJSONArray = jSONObject.optJSONArray("sis_ips");
            if (optJSONArray != null && optJSONArray.length() > 0) {
                Set<String> l11 = g.l(context);
                for (int i16 = 0; i16 < optJSONArray.length(); i16++) {
                    l11.add(String.valueOf(optJSONArray.get(i16)));
                }
                g.c(context, l11);
            }
            JSONArray optJSONArray2 = jSONObject.optJSONArray("ips");
            if (optJSONArray2 != null && optJSONArray2.length() > 0) {
                Set<String> k11 = g.k(context);
                for (int i17 = 0; i17 < optJSONArray2.length(); i17++) {
                    k11.add(String.valueOf(optJSONArray2.get(i17)));
                }
                g.b(context, k11);
            }
            JSONArray optJSONArray3 = jSONObject.optJSONArray("ssl_ips");
            if (optJSONArray3 != null && optJSONArray3.length() > 0) {
                Set<String> k12 = g.k(context);
                for (int i18 = 0; i18 < optJSONArray3.length(); i18++) {
                    k12.add(String.valueOf(optJSONArray3.get(i18)));
                }
                g.b(context, k12);
            }
            JSONArray optJSONArray4 = jSONObject.optJSONArray("http_report");
            if (optJSONArray4 != null && optJSONArray4.length() > 0) {
                Set<String> b11 = g.b(context);
                for (int i19 = 0; i19 < optJSONArray4.length(); i19++) {
                    b11.add(DomainTool.DOMAIN_PREFIX_HTTP + optJSONArray4.get(i19));
                }
                g.a(context, b11);
            }
            JSONArray optJSONArray5 = jSONObject.optJSONArray("https_report");
            if (optJSONArray5 != null && optJSONArray5.length() > 0) {
                Set<String> b12 = g.b(context);
                for (int i21 = 0; i21 < optJSONArray5.length(); i21++) {
                    b12.add(DomainTool.DOMAIN_PREFIX + optJSONArray5.get(i21));
                }
                g.a(context, b12);
            }
            return true;
        } catch (Throwable th2) {
            MTCommonLog.w("UdpClient", "parseResponse failed " + th2.getMessage());
            return false;
        }
    }
}
