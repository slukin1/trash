package com.jumio.sdk;

import android.content.Context;
import android.hardware.Camera;
import android.os.Bundle;
import androidx.annotation.Keep;
import androidx.core.content.ContextCompat;
import com.jumio.commons.log.LogUtils;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.core.ServiceLocator;
import com.jumio.core.environment.Environment;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.core.models.CredentialsModel;
import com.jumio.core.util.DeviceUtilKt;
import com.jumio.sdk.controller.JumioController;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.enums.JumioDataCenter;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.exceptions.PlatformNotSupportedException;
import com.jumio.sdk.interfaces.JumioControllerInterface;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.scanpart.JumioScanPart;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import jumio.core.d2;
import jumio.core.e2;
import jumio.core.m2;
import jumio.core.u0;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;

@Keep
public final class JumioSDK {
    public static final Companion Companion = new Companion((r) null);
    /* access modifiers changed from: private */
    public static final String[] requiredPermissions = {"android.permission.CAMERA"};
    /* access modifiers changed from: private */
    public static final String version = Environment.BUILD_VERSION;
    private int customThemeId;
    private JumioDataCenter dataCenter;
    private String token;

    @Keep
    public static final class Companion {

        public static final class a extends Lambda implements d10.a<e2> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f24954a = new a();

            public a() {
                super(0);
            }

            public final Object invoke() {
                return new u0();
            }
        }

        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final void checkSDKRequirements(Context context) throws PlatformNotSupportedException {
            e2 e2Var = (e2) ServiceLocator.INSTANCE.getServiceImplementation(e2.class, a.f24954a);
            if (Environment.INSTANCE.getAndroidSdkVersion() < 21) {
                throw new PlatformNotSupportedException("SDK Version 21 required");
            } else if (Camera.getNumberOfCameras() != 0) {
                if (!DeviceUtilKt.getDeviceUtil().isSupportedPlatform(context, e2Var.b(d2.EMULATOR) && DeviceUtilKt.getDeviceUtil().isDebug(context))) {
                    throw new PlatformNotSupportedException("ARMv7 CPU Architecture with NEON Intrinsics required");
                }
            } else {
                throw new PlatformNotSupportedException("No usable camera present");
            }
        }

        public static /* synthetic */ void getRequiredPermissions$annotations() {
        }

        public static /* synthetic */ void getVersion$annotations() {
        }

        public final String[] getMissingPermissions(Context context) {
            if (hasAllRequiredPermissions(context)) {
                return new String[0];
            }
            ArrayList arrayList = new ArrayList();
            for (String str : getRequiredPermissions()) {
                if (ContextCompat.checkSelfPermission(context, str) != 0) {
                    arrayList.add(str);
                }
            }
            return (String[]) arrayList.toArray(new String[arrayList.size()]);
        }

        public final String[] getRequiredPermissions() {
            return JumioSDK.requiredPermissions;
        }

        public final String getVersion() {
            return JumioSDK.version;
        }

        public final boolean hasAllRequiredPermissions(Context context) {
            return hasPermissionsFor(context, getRequiredPermissions());
        }

        public final boolean hasPermissionsFor(Context context, String[] strArr) {
            for (String checkSelfPermission : strArr) {
                if (ContextCompat.checkSelfPermission(context, checkSelfPermission) != 0) {
                    return false;
                }
            }
            return true;
        }

        public final boolean isRooted(Context context) {
            return m2.a(context);
        }

        public final boolean isSupportedPlatform(Context context) {
            try {
                checkSDKRequirements(context);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public final boolean isTablet(Context context) {
            return DeviceRotationManager.isTabletDevice(context);
        }
    }

    private JumioSDK() {
        this.token = "";
    }

    private static final void checkSDKRequirements(Context context) throws PlatformNotSupportedException {
        Companion.checkSDKRequirements(context);
    }

    public static final String[] getMissingPermissions(Context context) {
        return Companion.getMissingPermissions(context);
    }

    public static final String[] getRequiredPermissions() {
        return Companion.getRequiredPermissions();
    }

    public static final String getVersion() {
        return Companion.getVersion();
    }

    public static final boolean hasAllRequiredPermissions(Context context) {
        return Companion.hasAllRequiredPermissions(context);
    }

    public static final boolean hasPermissionsFor(Context context, String[] strArr) {
        return Companion.hasPermissionsFor(context, strArr);
    }

    public static final boolean isRooted(Context context) {
        return Companion.isRooted(context);
    }

    public static final boolean isSupportedPlatform(Context context) {
        return Companion.isSupportedPlatform(context);
    }

    public static final boolean isTablet(Context context) {
        return Companion.isTablet(context);
    }

    public final int getCustomThemeId() {
        return this.customThemeId;
    }

    public final JumioDataCenter getDataCenter() {
        return this.dataCenter;
    }

    public final String getToken() {
        return this.token;
    }

    public final void restore(Context context, Bundle bundle, JumioControllerInterface jumioControllerInterface, JumioScanPartInterface jumioScanPartInterface, d10.r<? super JumioController, ? super List<JumioCredentialInfo>, ? super JumioCredential, ? super JumioScanPart, Unit> rVar) {
        JumioScanPart activeScanPart$jumio_core_release;
        JumioController jumioController = new JumioController(context, bundle, jumioControllerInterface, jumioScanPartInterface);
        ArrayList c11 = ((CredentialsModel) jumioController.getController$jumio_core_release().getDataManager().get(CredentialsModel.class)).c();
        JumioCredential activeCredential$jumio_core_release = jumioController.getController$jumio_core_release().getActiveCredential$jumio_core_release();
        JumioCredential activeCredential$jumio_core_release2 = jumioController.getController$jumio_core_release().getActiveCredential$jumio_core_release();
        rVar.invoke(jumioController, c11, activeCredential$jumio_core_release, activeCredential$jumio_core_release2 != null ? activeCredential$jumio_core_release2.getActiveScanPart$jumio_core_release() : null);
        JumioCredential activeCredential$jumio_core_release3 = jumioController.getController$jumio_core_release().getActiveCredential$jumio_core_release();
        if (activeCredential$jumio_core_release3 != null && (activeScanPart$jumio_core_release = activeCredential$jumio_core_release3.getActiveScanPart$jumio_core_release()) != null) {
            JumioScanStep scanStep = activeScanPart$jumio_core_release.getScanPart$jumio_core_release().getScanPartModel().getScanStep();
            if (scanStep == JumioScanStep.STARTED || scanStep == JumioScanStep.SCAN_VIEW || scanStep == JumioScanStep.RETRY) {
                if (activeScanPart$jumio_core_release.getScanPart$jumio_core_release().getScanPartModel().getLastRetryReason() == null) {
                    activeScanPart$jumio_core_release.getScanPart$jumio_core_release().getScanPartModel().setLastRetryReason(new JumioRetryReason(1, ""));
                }
                activeScanPart$jumio_core_release.retry(activeScanPart$jumio_core_release.getScanPart$jumio_core_release().getScanPartModel().getLastRetryReason());
            }
        }
    }

    public final void setCustomThemeId(int i11) {
        this.customThemeId = i11;
    }

    public final void setDataCenter(JumioDataCenter jumioDataCenter) {
        this.dataCenter = jumioDataCenter;
    }

    public final void setToken(String str) {
        this.token = str;
    }

    public final JumioController start(Context context, JumioControllerInterface jumioControllerInterface) {
        JumioDataCenter jumioDataCenter = this.dataCenter;
        String str = this.token;
        boolean z11 = true;
        if (!(str.length() > 0) || jumioDataCenter == null) {
            z11 = false;
        }
        if (z11) {
            LogUtils.INSTANCE.init();
            AuthorizationModel authorizationModel = new AuthorizationModel();
            authorizationModel.setToken(str);
            authorizationModel.setDataCenter(jumioDataCenter);
            authorizationModel.getSessionKey().generate();
            Logger.getLogger("org.jmrtd").setLevel(Level.OFF);
            return new JumioController(context, authorizationModel, jumioControllerInterface, this.customThemeId);
        }
        throw new IllegalArgumentException("token and dataCenter need to be set".toString());
    }

    public JumioSDK(Context context) {
        this();
        Environment.INSTANCE.checkOcrVersion(context);
    }
}
