package com.huochat.community.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import com.amazonaws.services.s3.model.InstructionFileId;
import com.huobi.finance.bean.LoanOrderItem;
import i6.d;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class NetTool {
    public static List<String> hosts = new ArrayList();

    public static String getIpAddress(Context context, int i11) {
        WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
        if (wifiManager.isWifiEnabled()) {
            return intToIp(wifiManager.getConnectionInfo().getIpAddress());
        }
        return getIpAddress(i11);
    }

    public static String getLocalIpAddress() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && !nextElement.isLinkLocalAddress()) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
            }
            return null;
        } catch (SocketException e11) {
            e11.printStackTrace();
            return null;
        }
    }

    private static String intToIp(int i11) {
        return (i11 & 255) + InstructionFileId.DOT + ((i11 >> 8) & 255) + InstructionFileId.DOT + ((i11 >> 16) & 255) + InstructionFileId.DOT + ((i11 >> 24) & 255);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r0 = r0.getActiveNetworkInfo();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isNetworkAvailable() {
        /*
            android.app.Application r0 = com.hbg.lib.common.BaseApplication.b()
            java.lang.String r1 = "connectivity"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.net.ConnectivityManager r0 = (android.net.ConnectivityManager) r0
            if (r0 == 0) goto L_0x002a
            android.net.NetworkInfo r0 = r0.getActiveNetworkInfo()
            if (r0 == 0) goto L_0x002a
            boolean r1 = r0.isConnected()
            if (r1 == 0) goto L_0x002a
            boolean r1 = r0.isAvailable()
            if (r1 == 0) goto L_0x002a
            android.net.NetworkInfo$State r0 = r0.getState()
            android.net.NetworkInfo$State r1 = android.net.NetworkInfo.State.CONNECTED
            if (r0 != r1) goto L_0x002a
            r0 = 1
            return r0
        L_0x002a:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huochat.community.util.NetTool.isNetworkAvailable():boolean");
    }

    @SuppressLint({"MissingPermission"})
    public static boolean isWifi(Context context) {
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) context.getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1) {
            return false;
        }
        return true;
    }

    public static final boolean ping() {
        StringBuilder sb2;
        String str;
        try {
            Runtime runtime = Runtime.getRuntime();
            Process exec = runtime.exec("ping -c 3 -w 100 " + "www.baidu.com");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(exec.getInputStream()));
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    break;
                }
                stringBuffer.append(readLine);
            }
            if (exec.waitFor() == 0) {
                d.d("----result = " + "success");
                return true;
            }
            str = LoanOrderItem.FAILED;
            sb2 = new StringBuilder();
            sb2.append("----result = ");
            sb2.append(str);
            d.d(sb2.toString());
            return false;
        } catch (IOException unused) {
            str = "IOException";
            sb2 = new StringBuilder();
        } catch (InterruptedException unused2) {
            str = "InterruptedException";
            sb2 = new StringBuilder();
        }
    }

    private static String getIpAddress(int i11) {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    hosts.add(inetAddresses.nextElement().getHostAddress());
                }
            }
        } catch (SocketException e11) {
            e11.printStackTrace();
        }
        if (i11 < hosts.size()) {
            return hosts.get(i11);
        }
        return null;
    }
}
