package com.engagelab.privates.core.global;

import android.content.Context;
import android.text.TextUtils;
import com.engagelab.privates.common.g;
import com.engagelab.privates.common.global.MTGlobal;
import com.engagelab.privates.core.api.Address;
import com.engagelab.privates.core.constants.MTCoreConstants;
import java.util.Set;

public class MTCoreGlobal {
    private static Address address = null;
    private static int connectRetryCount = 3;
    private static long heartbeatInterval = 290000;
    private static int loginCode = 0;
    private static boolean onlyBeWakeState = true;
    private static boolean onlyWakeState = true;
    private static String password = null;
    private static int registerCode = -1;
    private static String registrationId = null;
    private static long rid = 0;
    private static int seedId = 0;
    private static long serverTime = 0;
    private static long userId = 0;
    private static boolean wakeAndBeWakeState = true;

    public static Address getAddress() {
        if (address == null) {
            address = new Address();
        }
        return address;
    }

    public static int getConnectRetryCount() {
        return connectRetryCount;
    }

    public static long getHeartbeatInterval() {
        return heartbeatInterval;
    }

    public static Set<String> getHttpAddress(Context context) {
        Set<String> b11 = g.b(context);
        Address address2 = getAddress();
        if (address2 == null) {
            return b11;
        }
        String defaultReportUrl = address2.getDefaultReportUrl();
        if (!TextUtils.isEmpty(defaultReportUrl)) {
            b11.add(defaultReportUrl);
        }
        return b11;
    }

    public static int getLoginCode(Context context) {
        if (loginCode == -1) {
            loginCode = g.c(context);
        }
        return loginCode;
    }

    public static boolean getOnlyBeWakeState() {
        if (MTGlobal.IS_FOR_BINANCE || MTGlobal.IS_FOR_PINGANBANK) {
            return onlyBeWakeState;
        }
        return true;
    }

    public static boolean getOnlyWakeState() {
        if (MTGlobal.IS_FOR_BINANCE || MTGlobal.IS_FOR_PINGANBANK) {
            return onlyWakeState;
        }
        return true;
    }

    public static String getPassword(Context context) {
        if (TextUtils.isEmpty(password)) {
            password = g.d(context);
        }
        return password;
    }

    public static byte getPlatformState(Context context) {
        return g.e(context);
    }

    public static int getRegisterCode(Context context) {
        if (registerCode == -1) {
            registerCode = g.f(context);
        }
        return registerCode;
    }

    public static String getRegistrationId(Context context) {
        if (TextUtils.isEmpty(registrationId)) {
            registrationId = g.g(context);
        }
        return registrationId;
    }

    public static long getRid() {
        long j11 = rid;
        long j12 = 2;
        if (j11 % 2 == 0) {
            j12 = 1;
        }
        long j13 = (j11 + j12) % 32767;
        rid = j13;
        return j13;
    }

    public static int getSeedId(Context context) {
        if (seedId == 0) {
            seedId = g.h(context);
        }
        return seedId;
    }

    public static long getServerTime(Context context) {
        if (serverTime == 0) {
            serverTime = g.i(context);
        }
        return serverTime;
    }

    public static long getUserId(Context context) {
        if (userId == 0) {
            userId = g.m(context);
        }
        return userId;
    }

    public static boolean getWakeAndBeWakeState() {
        return wakeAndBeWakeState;
    }

    public static void setAddress(Address address2) {
    }

    public static void setConnectRetryCount(int i11) {
        if (i11 < 3) {
            connectRetryCount = 3;
        } else {
            connectRetryCount = i11;
        }
    }

    public static void setHeartbeatInterval(long j11) {
        if (j11 <= 0) {
            heartbeatInterval = MTCoreConstants.Heartbeat.DEFAULT_VALUE_HEARTBEAT_INTERVAL;
        } else {
            heartbeatInterval = j11;
        }
    }

    public static void setLoginCode(int i11) {
        loginCode = i11;
    }

    public static void setOnlyBeWakeState(boolean z11) {
        if (MTGlobal.IS_FOR_BINANCE || MTGlobal.IS_FOR_PINGANBANK) {
            onlyBeWakeState = z11;
        }
    }

    public static void setOnlyWakeState(boolean z11) {
        if (MTGlobal.IS_FOR_BINANCE || MTGlobal.IS_FOR_PINGANBANK) {
            onlyWakeState = z11;
        }
    }

    public static void setPassword(String str) {
        password = str;
    }

    public static void setPlatformState(Context context, byte b11) {
        g.a(context, b11);
    }

    public static void setRegisterCode(int i11) {
        registerCode = i11;
    }

    public static void setRegistrationId(String str) {
        registrationId = str;
    }

    public static void setSeedId(int i11) {
        seedId = i11;
    }

    public static void setServerTime(long j11) {
        serverTime = j11;
    }

    public static void setUserId(long j11) {
        userId = j11;
    }

    public static void setWakeAndBeWakeState(boolean z11) {
        wakeAndBeWakeState = z11;
    }
}
