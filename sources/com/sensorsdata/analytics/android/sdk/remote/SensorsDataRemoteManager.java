package com.sensorsdata.analytics.android.sdk.remote;

import android.os.CountDownTimer;
import android.os.SystemClock;
import android.text.TextUtils;
import com.sensorsdata.analytics.android.sdk.SAConfigOptions;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.SensorsDataAPI;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbAdapter;
import com.sensorsdata.analytics.android.sdk.encrypt.SensorsDataEncrypt;
import com.sensorsdata.analytics.android.sdk.network.HttpCallback;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager;
import com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager;
import java.security.SecureRandom;
import org.json.JSONObject;

public class SensorsDataRemoteManager extends BaseSensorsDataSDKRemoteManager {
    private static final String SHARED_PREF_REQUEST_TIME = "sensorsdata.request.time";
    private static final String SHARED_PREF_REQUEST_TIME_RANDOM = "sensorsdata.request.time.random";
    private static final String TAG = "SA.SensorsDataRemoteManager";
    private volatile boolean mIsInit = true;
    private CountDownTimer mPullSDKConfigCountDownTimer;
    private final SAStoreManager mStorageManager = SAStoreManager.getInstance();

    /* renamed from: com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager$2  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {
        public static final /* synthetic */ int[] $SwitchMap$com$sensorsdata$analytics$android$sdk$remote$BaseSensorsDataSDKRemoteManager$RandomTimeType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager$RandomTimeType[] r0 = com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$sensorsdata$analytics$android$sdk$remote$BaseSensorsDataSDKRemoteManager$RandomTimeType = r0
                com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager$RandomTimeType r1 = com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeWrite     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$sensorsdata$analytics$android$sdk$remote$BaseSensorsDataSDKRemoteManager$RandomTimeType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager$RandomTimeType r1 = com.sensorsdata.analytics.android.sdk.remote.BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeClean     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.remote.SensorsDataRemoteManager.AnonymousClass2.<clinit>():void");
        }
    }

    public SensorsDataRemoteManager(SensorsDataAPI sensorsDataAPI) {
        super(sensorsDataAPI);
        SALog.i(TAG, "Construct a SensorsDataRemoteManager");
    }

    private void cleanRemoteRequestRandomTime() {
        this.mStorageManager.remove(SHARED_PREF_REQUEST_TIME);
        this.mStorageManager.remove(SHARED_PREF_REQUEST_TIME_RANDOM);
    }

    private boolean isRequestValid() {
        try {
            long longValue = this.mStorageManager.getLong(SHARED_PREF_REQUEST_TIME, 0).longValue();
            int integer = this.mStorageManager.getInteger(SHARED_PREF_REQUEST_TIME_RANDOM, 0);
            if (longValue == 0 || integer == 0) {
                return true;
            }
            float elapsedRealtime = (float) (SystemClock.elapsedRealtime() - longValue);
            if (elapsedRealtime <= 0.0f || elapsedRealtime / 1000.0f >= ((float) (integer * 3600))) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return true;
        }
    }

    private void writeRemoteRequestRandomTime() {
        SAConfigOptions sAConfigOptions = this.mSAConfigOptions;
        if (sAConfigOptions != null) {
            int i11 = sAConfigOptions.mMinRequestInterval;
            long elapsedRealtime = SystemClock.elapsedRealtime();
            SAConfigOptions sAConfigOptions2 = this.mSAConfigOptions;
            if (sAConfigOptions2.mMaxRequestInterval > sAConfigOptions2.mMinRequestInterval) {
                SecureRandom secureRandom = new SecureRandom();
                SAConfigOptions sAConfigOptions3 = this.mSAConfigOptions;
                i11 += secureRandom.nextInt((sAConfigOptions3.mMaxRequestInterval - sAConfigOptions3.mMinRequestInterval) + 1);
            }
            this.mStorageManager.setLong(SHARED_PREF_REQUEST_TIME, elapsedRealtime);
            this.mStorageManager.setInteger(SHARED_PREF_REQUEST_TIME_RANDOM, i11);
        }
    }

    public void applySDKConfigFromCache() {
        String str;
        try {
            if (this.mIsInit) {
                str = DbAdapter.getInstance().getRemoteConfigFromLocal();
                this.mIsInit = false;
            } else {
                str = DbAdapter.getInstance().getRemoteConfig();
            }
            SensorsDataSDKRemoteConfig sDKRemoteConfig = toSDKRemoteConfig(str);
            if (SALog.isLogEnabled()) {
                SALog.i(TAG, "Cache remote config is " + sDKRemoteConfig.toString());
            }
            if (this.mSensorsDataAPI != null) {
                if (sDKRemoteConfig.isDisableDebugMode()) {
                    this.mSensorsDataAPI.setDebugMode(SensorsDataAPI.DebugMode.DEBUG_OFF);
                    SALog.i(TAG, "Set DebugOff Mode");
                }
                if (sDKRemoteConfig.isDisableSDK()) {
                    try {
                        this.mSensorsDataAPI.flush();
                        SALog.i(TAG, "DisableSDK is true");
                    } catch (Exception e11) {
                        SALog.printStackTrace(e11);
                    }
                }
            }
            BaseSensorsDataSDKRemoteManager.mSDKRemoteConfig = sDKRemoteConfig;
        } catch (Exception e12) {
            SALog.printStackTrace(e12);
        }
    }

    public void pullSDKConfigFromServer() {
        SAConfigOptions sAConfigOptions = this.mSAConfigOptions;
        if (sAConfigOptions != null) {
            if (sAConfigOptions.mDisableRandomTimeRequestRemoteConfig || sAConfigOptions.mMinRequestInterval > sAConfigOptions.mMaxRequestInterval) {
                requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeClean, true);
                SALog.i(TAG, "remote config: Request remote config because disableRandomTimeRequestRemoteConfig or minHourInterval greater than maxHourInterval");
                return;
            }
            SensorsDataEncrypt sensorsDataEncrypt = this.mSensorsDataEncrypt;
            if (sensorsDataEncrypt != null && sensorsDataEncrypt.isPublicSecretKeyNull()) {
                requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeWrite, false);
                SALog.i(TAG, "remote config: Request remote config because encrypt key is null");
            } else if (isRequestValid()) {
                requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType.RandomTimeTypeWrite, true);
                SALog.i(TAG, "remote config: Request remote config because satisfy the random request condition");
            }
        }
    }

    public void requestRemoteConfig(BaseSensorsDataSDKRemoteManager.RandomTimeType randomTimeType, boolean z11) {
        if (this.mDisableDefaultRemoteConfig) {
            SALog.i(TAG, "disableDefaultRemoteConfig is true");
            return;
        }
        int i11 = AnonymousClass2.$SwitchMap$com$sensorsdata$analytics$android$sdk$remote$BaseSensorsDataSDKRemoteManager$RandomTimeType[randomTimeType.ordinal()];
        if (i11 == 1) {
            writeRemoteRequestRandomTime();
        } else if (i11 == 2) {
            cleanRemoteRequestRandomTime();
        }
        CountDownTimer countDownTimer = this.mPullSDKConfigCountDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.mPullSDKConfigCountDownTimer = null;
        }
        final boolean z12 = z11;
        AnonymousClass1 r02 = new CountDownTimer(90000, 30000) {
            public void onFinish() {
            }

            public void onTick(long j11) {
                SensorsDataAPI sensorsDataAPI = SensorsDataRemoteManager.this.mSensorsDataAPI;
                if ((sensorsDataAPI == null || sensorsDataAPI.isNetworkRequestEnable()) && !AbstractSensorsDataAPI.isSDKDisabled()) {
                    SensorsDataRemoteManager.this.requestRemoteConfig(z12, (HttpCallback.StringCallback) new HttpCallback.StringCallback() {
                        public void onAfter() {
                        }

                        public void onFailure(int i11, String str) {
                            if (i11 == 304 || i11 == 404) {
                                SensorsDataRemoteManager.this.resetPullSDKConfigTimer();
                            }
                            SALog.i(SensorsDataRemoteManager.TAG, "Remote request failed,responseCode is " + i11 + ",errorMessage is " + str);
                        }

                        public void onResponse(String str) {
                            SensorsDataRemoteManager.this.resetPullSDKConfigTimer();
                            if (!TextUtils.isEmpty(str)) {
                                SensorsDataSDKRemoteConfig sDKRemoteConfig = SensorsDataRemoteManager.this.toSDKRemoteConfig(str);
                                try {
                                    SensorsDataEncrypt sensorsDataEncrypt = SensorsDataRemoteManager.this.mSensorsDataEncrypt;
                                    if (sensorsDataEncrypt != null) {
                                        sensorsDataEncrypt.saveSecretKey(sDKRemoteConfig.getSecretKey());
                                    }
                                } catch (Exception e11) {
                                    SALog.printStackTrace(e11);
                                }
                                SensorsDataRemoteManager.this.setSDKRemoteConfig(sDKRemoteConfig);
                            }
                            SALog.i(SensorsDataRemoteManager.TAG, "Remote request was successful,response data is " + str);
                        }
                    });
                } else {
                    SALog.i(SensorsDataRemoteManager.TAG, "Close network request or sdk is disable");
                }
            }
        };
        this.mPullSDKConfigCountDownTimer = r02;
        r02.start();
    }

    public void resetPullSDKConfigTimer() {
        try {
            CountDownTimer countDownTimer = this.mPullSDKConfigCountDownTimer;
            if (countDownTimer != null) {
                countDownTimer.cancel();
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        } catch (Throwable th2) {
            this.mPullSDKConfigCountDownTimer = null;
            throw th2;
        }
        this.mPullSDKConfigCountDownTimer = null;
    }

    public void setSDKRemoteConfig(SensorsDataSDKRemoteConfig sensorsDataSDKRemoteConfig) {
        try {
            JSONObject jSONObject = new JSONObject();
            String jSONObject2 = sensorsDataSDKRemoteConfig.toJson().toString();
            jSONObject.put("$app_remote_config", jSONObject2);
            SensorsDataAPI.sharedInstance().trackInternal("$AppRemoteConfigChanged", jSONObject);
            SensorsDataAPI.sharedInstance().flush();
            DbAdapter.getInstance().commitRemoteConfig(jSONObject2);
            SALog.i(TAG, "Save remote data");
            if (1 == sensorsDataSDKRemoteConfig.getEffectMode()) {
                applySDKConfigFromCache();
                SALog.i(TAG, "The remote configuration takes effect immediately");
            }
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
        }
    }
}
