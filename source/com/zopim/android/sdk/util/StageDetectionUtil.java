package com.zopim.android.sdk.util;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import com.zendesk.logger.Logger;
import java.io.ByteArrayInputStream;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.security.auth.x500.X500Principal;

class StageDetectionUtil {
    private static final X500Principal DEBUG_DN = new X500Principal("CN=Android Debug,O=Android,C=US");
    private static final String LOG_TAG = "StageDetectionUtil";

    private StageDetectionUtil() {
    }

    private static boolean checkBuildFlag(Context context) {
        try {
            return ((Boolean) Class.forName(context.getPackageName() + ".BuildConfig").getField("DEBUG").get((Object) null)).booleanValue();
        } catch (Exception e11) {
            Logger.k(LOG_TAG, "Error, not able to receive 'BuildConfig.DEBUG'", e11, new Object[0]);
            return false;
        }
    }

    private static boolean checkDebugCertificate(Context context) {
        boolean z11;
        try {
            Signature[] signatureArr = context.getPackageManager().getPackageInfo(context.getPackageName(), 64).signatures;
            CertificateFactory instance = CertificateFactory.getInstance("X.509");
            if (signatureArr == null) {
                return false;
            }
            int length = signatureArr.length;
            int i11 = 0;
            z11 = false;
            while (i11 < length) {
                try {
                    Certificate generateCertificate = instance.generateCertificate(new ByteArrayInputStream(signatureArr[i11].toByteArray()));
                    if ((generateCertificate instanceof X509Certificate) && (z11 = DEBUG_DN.equals(((X509Certificate) generateCertificate).getSubjectX500Principal()))) {
                        break;
                    }
                    i11++;
                } catch (PackageManager.NameNotFoundException | CertificateException e11) {
                    e = e11;
                    Logger.k(LOG_TAG, "Error, not able to read the certificate", e, new Object[0]);
                    return z11;
                }
            }
            return z11;
        } catch (PackageManager.NameNotFoundException | CertificateException e12) {
            e = e12;
            z11 = false;
            Logger.k(LOG_TAG, "Error, not able to read the certificate", e, new Object[0]);
            return z11;
        }
    }

    private static boolean checkDebuggableFlag(Context context) {
        return (context.getApplicationInfo().flags & 2) != 0;
    }

    public static boolean isDebug(Context context) {
        if (context == null) {
            return false;
        }
        try {
            return isDebugInternal(context);
        } catch (Exception unused) {
            Logger.l(LOG_TAG, "Error determining if build is debug. Will treat the build as debug.", new Object[0]);
            return true;
        }
    }

    private static boolean isDebugInternal(Context context) {
        boolean checkDebuggableFlag = checkDebuggableFlag(context);
        boolean checkDebugCertificate = checkDebugCertificate(context);
        boolean checkBuildFlag = checkBuildFlag(context);
        Logger.b(LOG_TAG, "Debug flag: " + checkDebuggableFlag + " | Debug certificate: " + checkDebugCertificate + " | Build flag: " + checkBuildFlag, new Object[0]);
        List asList = Arrays.asList(new Boolean[]{Boolean.valueOf(checkDebuggableFlag), Boolean.valueOf(checkDebugCertificate), Boolean.valueOf(checkBuildFlag)});
        if (Collections.frequency(asList, Boolean.TRUE) >= asList.size() - 1) {
            return true;
        }
        return false;
    }
}
