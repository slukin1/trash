package com.google.android.datatransport.cct.internal;

import com.facebook.appevents.UserDataStore;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.encoders.FieldDescriptor;
import com.google.firebase.encoders.ObjectEncoder;
import com.google.firebase.encoders.ObjectEncoderContext;
import com.google.firebase.encoders.config.Configurator;
import com.google.firebase.encoders.config.EncoderConfig;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huobi.vulcan.model.VulcanInfo;
import java.io.IOException;

public final class AutoBatchedLogRequestEncoder implements Configurator {
    public static final int CODEGEN_VERSION = 2;
    public static final Configurator CONFIG = new AutoBatchedLogRequestEncoder();

    public static final class AndroidClientInfoEncoder implements ObjectEncoder<AndroidClientInfo> {
        private static final FieldDescriptor APPLICATIONBUILD_DESCRIPTOR = FieldDescriptor.of("applicationBuild");
        private static final FieldDescriptor COUNTRY_DESCRIPTOR = FieldDescriptor.of(UserDataStore.COUNTRY);
        private static final FieldDescriptor DEVICE_DESCRIPTOR = FieldDescriptor.of("device");
        private static final FieldDescriptor FINGERPRINT_DESCRIPTOR = FieldDescriptor.of(HiAnalyticsConstant.HaKey.BI_KEY_FINGERPRINT);
        private static final FieldDescriptor HARDWARE_DESCRIPTOR = FieldDescriptor.of(VulcanInfo.HARDWARE);
        public static final AndroidClientInfoEncoder INSTANCE = new AndroidClientInfoEncoder();
        private static final FieldDescriptor LOCALE_DESCRIPTOR = FieldDescriptor.of("locale");
        private static final FieldDescriptor MANUFACTURER_DESCRIPTOR = FieldDescriptor.of("manufacturer");
        private static final FieldDescriptor MCCMNC_DESCRIPTOR = FieldDescriptor.of("mccMnc");
        private static final FieldDescriptor MODEL_DESCRIPTOR = FieldDescriptor.of(DeviceRequestsHelper.DEVICE_INFO_MODEL);
        private static final FieldDescriptor OSBUILD_DESCRIPTOR = FieldDescriptor.of("osBuild");
        private static final FieldDescriptor PRODUCT_DESCRIPTOR = FieldDescriptor.of("product");
        private static final FieldDescriptor SDKVERSION_DESCRIPTOR = FieldDescriptor.of("sdkVersion");

        private AndroidClientInfoEncoder() {
        }

        public void encode(AndroidClientInfo androidClientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(SDKVERSION_DESCRIPTOR, (Object) androidClientInfo.getSdkVersion());
            objectEncoderContext.add(MODEL_DESCRIPTOR, (Object) androidClientInfo.getModel());
            objectEncoderContext.add(HARDWARE_DESCRIPTOR, (Object) androidClientInfo.getHardware());
            objectEncoderContext.add(DEVICE_DESCRIPTOR, (Object) androidClientInfo.getDevice());
            objectEncoderContext.add(PRODUCT_DESCRIPTOR, (Object) androidClientInfo.getProduct());
            objectEncoderContext.add(OSBUILD_DESCRIPTOR, (Object) androidClientInfo.getOsBuild());
            objectEncoderContext.add(MANUFACTURER_DESCRIPTOR, (Object) androidClientInfo.getManufacturer());
            objectEncoderContext.add(FINGERPRINT_DESCRIPTOR, (Object) androidClientInfo.getFingerprint());
            objectEncoderContext.add(LOCALE_DESCRIPTOR, (Object) androidClientInfo.getLocale());
            objectEncoderContext.add(COUNTRY_DESCRIPTOR, (Object) androidClientInfo.getCountry());
            objectEncoderContext.add(MCCMNC_DESCRIPTOR, (Object) androidClientInfo.getMccMnc());
            objectEncoderContext.add(APPLICATIONBUILD_DESCRIPTOR, (Object) androidClientInfo.getApplicationBuild());
        }
    }

    public static final class BatchedLogRequestEncoder implements ObjectEncoder<BatchedLogRequest> {
        public static final BatchedLogRequestEncoder INSTANCE = new BatchedLogRequestEncoder();
        private static final FieldDescriptor LOGREQUEST_DESCRIPTOR = FieldDescriptor.of("logRequest");

        private BatchedLogRequestEncoder() {
        }

        public void encode(BatchedLogRequest batchedLogRequest, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(LOGREQUEST_DESCRIPTOR, (Object) batchedLogRequest.getLogRequests());
        }
    }

    public static final class ClientInfoEncoder implements ObjectEncoder<ClientInfo> {
        private static final FieldDescriptor ANDROIDCLIENTINFO_DESCRIPTOR = FieldDescriptor.of("androidClientInfo");
        private static final FieldDescriptor CLIENTTYPE_DESCRIPTOR = FieldDescriptor.of("clientType");
        public static final ClientInfoEncoder INSTANCE = new ClientInfoEncoder();

        private ClientInfoEncoder() {
        }

        public void encode(ClientInfo clientInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(CLIENTTYPE_DESCRIPTOR, (Object) clientInfo.getClientType());
            objectEncoderContext.add(ANDROIDCLIENTINFO_DESCRIPTOR, (Object) clientInfo.getAndroidClientInfo());
        }
    }

    public static final class LogEventEncoder implements ObjectEncoder<LogEvent> {
        private static final FieldDescriptor EVENTCODE_DESCRIPTOR = FieldDescriptor.of("eventCode");
        private static final FieldDescriptor EVENTTIMEMS_DESCRIPTOR = FieldDescriptor.of("eventTimeMs");
        private static final FieldDescriptor EVENTUPTIMEMS_DESCRIPTOR = FieldDescriptor.of("eventUptimeMs");
        public static final LogEventEncoder INSTANCE = new LogEventEncoder();
        private static final FieldDescriptor NETWORKCONNECTIONINFO_DESCRIPTOR = FieldDescriptor.of("networkConnectionInfo");
        private static final FieldDescriptor SOURCEEXTENSIONJSONPROTO3_DESCRIPTOR = FieldDescriptor.of("sourceExtensionJsonProto3");
        private static final FieldDescriptor SOURCEEXTENSION_DESCRIPTOR = FieldDescriptor.of("sourceExtension");
        private static final FieldDescriptor TIMEZONEOFFSETSECONDS_DESCRIPTOR = FieldDescriptor.of("timezoneOffsetSeconds");

        private LogEventEncoder() {
        }

        public void encode(LogEvent logEvent, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(EVENTTIMEMS_DESCRIPTOR, logEvent.getEventTimeMs());
            objectEncoderContext.add(EVENTCODE_DESCRIPTOR, (Object) logEvent.getEventCode());
            objectEncoderContext.add(EVENTUPTIMEMS_DESCRIPTOR, logEvent.getEventUptimeMs());
            objectEncoderContext.add(SOURCEEXTENSION_DESCRIPTOR, (Object) logEvent.getSourceExtension());
            objectEncoderContext.add(SOURCEEXTENSIONJSONPROTO3_DESCRIPTOR, (Object) logEvent.getSourceExtensionJsonProto3());
            objectEncoderContext.add(TIMEZONEOFFSETSECONDS_DESCRIPTOR, logEvent.getTimezoneOffsetSeconds());
            objectEncoderContext.add(NETWORKCONNECTIONINFO_DESCRIPTOR, (Object) logEvent.getNetworkConnectionInfo());
        }
    }

    public static final class LogRequestEncoder implements ObjectEncoder<LogRequest> {
        private static final FieldDescriptor CLIENTINFO_DESCRIPTOR = FieldDescriptor.of("clientInfo");
        public static final LogRequestEncoder INSTANCE = new LogRequestEncoder();
        private static final FieldDescriptor LOGEVENT_DESCRIPTOR = FieldDescriptor.of("logEvent");
        private static final FieldDescriptor LOGSOURCENAME_DESCRIPTOR = FieldDescriptor.of("logSourceName");
        private static final FieldDescriptor LOGSOURCE_DESCRIPTOR = FieldDescriptor.of("logSource");
        private static final FieldDescriptor QOSTIER_DESCRIPTOR = FieldDescriptor.of("qosTier");
        private static final FieldDescriptor REQUESTTIMEMS_DESCRIPTOR = FieldDescriptor.of("requestTimeMs");
        private static final FieldDescriptor REQUESTUPTIMEMS_DESCRIPTOR = FieldDescriptor.of("requestUptimeMs");

        private LogRequestEncoder() {
        }

        public void encode(LogRequest logRequest, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(REQUESTTIMEMS_DESCRIPTOR, logRequest.getRequestTimeMs());
            objectEncoderContext.add(REQUESTUPTIMEMS_DESCRIPTOR, logRequest.getRequestUptimeMs());
            objectEncoderContext.add(CLIENTINFO_DESCRIPTOR, (Object) logRequest.getClientInfo());
            objectEncoderContext.add(LOGSOURCE_DESCRIPTOR, (Object) logRequest.getLogSource());
            objectEncoderContext.add(LOGSOURCENAME_DESCRIPTOR, (Object) logRequest.getLogSourceName());
            objectEncoderContext.add(LOGEVENT_DESCRIPTOR, (Object) logRequest.getLogEvents());
            objectEncoderContext.add(QOSTIER_DESCRIPTOR, (Object) logRequest.getQosTier());
        }
    }

    public static final class NetworkConnectionInfoEncoder implements ObjectEncoder<NetworkConnectionInfo> {
        public static final NetworkConnectionInfoEncoder INSTANCE = new NetworkConnectionInfoEncoder();
        private static final FieldDescriptor MOBILESUBTYPE_DESCRIPTOR = FieldDescriptor.of("mobileSubtype");
        private static final FieldDescriptor NETWORKTYPE_DESCRIPTOR = FieldDescriptor.of("networkType");

        private NetworkConnectionInfoEncoder() {
        }

        public void encode(NetworkConnectionInfo networkConnectionInfo, ObjectEncoderContext objectEncoderContext) throws IOException {
            objectEncoderContext.add(NETWORKTYPE_DESCRIPTOR, (Object) networkConnectionInfo.getNetworkType());
            objectEncoderContext.add(MOBILESUBTYPE_DESCRIPTOR, (Object) networkConnectionInfo.getMobileSubtype());
        }
    }

    private AutoBatchedLogRequestEncoder() {
    }

    public void configure(EncoderConfig<?> encoderConfig) {
        BatchedLogRequestEncoder batchedLogRequestEncoder = BatchedLogRequestEncoder.INSTANCE;
        encoderConfig.registerEncoder((Class<U>) BatchedLogRequest.class, (ObjectEncoder<? super U>) batchedLogRequestEncoder);
        encoderConfig.registerEncoder((Class<U>) AutoValue_BatchedLogRequest.class, (ObjectEncoder<? super U>) batchedLogRequestEncoder);
        LogRequestEncoder logRequestEncoder = LogRequestEncoder.INSTANCE;
        encoderConfig.registerEncoder((Class<U>) LogRequest.class, (ObjectEncoder<? super U>) logRequestEncoder);
        encoderConfig.registerEncoder((Class<U>) AutoValue_LogRequest.class, (ObjectEncoder<? super U>) logRequestEncoder);
        ClientInfoEncoder clientInfoEncoder = ClientInfoEncoder.INSTANCE;
        encoderConfig.registerEncoder((Class<U>) ClientInfo.class, (ObjectEncoder<? super U>) clientInfoEncoder);
        encoderConfig.registerEncoder((Class<U>) AutoValue_ClientInfo.class, (ObjectEncoder<? super U>) clientInfoEncoder);
        AndroidClientInfoEncoder androidClientInfoEncoder = AndroidClientInfoEncoder.INSTANCE;
        encoderConfig.registerEncoder((Class<U>) AndroidClientInfo.class, (ObjectEncoder<? super U>) androidClientInfoEncoder);
        encoderConfig.registerEncoder((Class<U>) AutoValue_AndroidClientInfo.class, (ObjectEncoder<? super U>) androidClientInfoEncoder);
        LogEventEncoder logEventEncoder = LogEventEncoder.INSTANCE;
        encoderConfig.registerEncoder((Class<U>) LogEvent.class, (ObjectEncoder<? super U>) logEventEncoder);
        encoderConfig.registerEncoder((Class<U>) AutoValue_LogEvent.class, (ObjectEncoder<? super U>) logEventEncoder);
        NetworkConnectionInfoEncoder networkConnectionInfoEncoder = NetworkConnectionInfoEncoder.INSTANCE;
        encoderConfig.registerEncoder((Class<U>) NetworkConnectionInfo.class, (ObjectEncoder<? super U>) networkConnectionInfoEncoder);
        encoderConfig.registerEncoder((Class<U>) AutoValue_NetworkConnectionInfo.class, (ObjectEncoder<? super U>) networkConnectionInfoEncoder);
    }
}
