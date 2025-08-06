package com.google.firebase.crashlytics.internal.model.serialization;

import android.util.Base64;
import android.util.JsonReader;
import cn.sharesdk.framework.InnerShareParams;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.google.firebase.crashlytics.internal.model.AutoCrashlyticsReportEncoder;
import com.google.firebase.crashlytics.internal.model.CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.ImmutableList;
import com.google.firebase.encoders.DataEncoder;
import com.google.firebase.encoders.json.JsonDataEncoderBuilder;
import com.sensorsdata.analytics.android.sdk.data.adapter.DbParams;
import com.sumsub.sentry.a;
import com.sumsub.sentry.q;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;

public class CrashlyticsReportJsonTransform {
    private static final DataEncoder CRASHLYTICS_REPORT_JSON_ENCODER = new JsonDataEncoderBuilder().configureWith(AutoCrashlyticsReportEncoder.CONFIG).ignoreNullValues(true).build();

    public interface ObjectParser<T> {
        T parse(JsonReader jsonReader) throws IOException;
    }

    private static CrashlyticsReport.Session.Application parseApp(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Application.Builder builder = CrashlyticsReport.Session.Application.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1618432855:
                    if (nextName.equals(Constants.IDENTIFIER)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -519438642:
                    if (nextName.equals("developmentPlatform")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 213652010:
                    if (nextName.equals("developmentPlatformVersion")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c11 = 5;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    builder.setIdentifier(jsonReader.nextString());
                    break;
                case 1:
                    builder.setDevelopmentPlatform(jsonReader.nextString());
                    break;
                case 2:
                    builder.setDevelopmentPlatformVersion(jsonReader.nextString());
                    break;
                case 3:
                    builder.setVersion(jsonReader.nextString());
                    break;
                case 4:
                    builder.setInstallationUuid(jsonReader.nextString());
                    break;
                case 5:
                    builder.setDisplayVersion(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.ApplicationExitInfo parseAppExitInfo(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.ApplicationExitInfo.Builder builder = CrashlyticsReport.ApplicationExitInfo.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1516200806:
                    if (nextName.equals("buildIdMappingForArch")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 110987:
                    if (nextName.equals("pid")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 111312:
                    if (nextName.equals("pss")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 113234:
                    if (nextName.equals("rss")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals("timestamp")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 202325402:
                    if (nextName.equals("processName")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 722137681:
                    if (nextName.equals("reasonCode")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 723857505:
                    if (nextName.equals("traceFile")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c11 = 8;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    builder.setBuildIdMappingForArch(parseArray(jsonReader, b.f67070a));
                    break;
                case 1:
                    builder.setPid(jsonReader.nextInt());
                    break;
                case 2:
                    builder.setPss(jsonReader.nextLong());
                    break;
                case 3:
                    builder.setRss(jsonReader.nextLong());
                    break;
                case 4:
                    builder.setTimestamp(jsonReader.nextLong());
                    break;
                case 5:
                    builder.setProcessName(jsonReader.nextString());
                    break;
                case 6:
                    builder.setReasonCode(jsonReader.nextInt());
                    break;
                case 7:
                    builder.setTraceFile(jsonReader.nextString());
                    break;
                case 8:
                    builder.setImportance(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static <T> ImmutableList<T> parseArray(JsonReader jsonReader, ObjectParser<T> objectParser) throws IOException {
        ArrayList arrayList = new ArrayList();
        jsonReader.beginArray();
        while (jsonReader.hasNext()) {
            arrayList.add(objectParser.parse(jsonReader));
        }
        jsonReader.endArray();
        return ImmutableList.from(arrayList);
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch parseBuildIdMappingForArch(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.Builder builder = CrashlyticsReport.ApplicationExitInfo.BuildIdMappingForArch.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -609862170:
                    if (nextName.equals("libraryName")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 230943785:
                    if (nextName.equals(Constants.BUILD_ID)) {
                        c11 = 2;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    builder.setLibraryName(jsonReader.nextString());
                    break;
                case 1:
                    builder.setArch(jsonReader.nextString());
                    break;
                case 2:
                    builder.setBuildId(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.CustomAttribute parseCustomAttribute(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.CustomAttribute.Builder builder = CrashlyticsReport.CustomAttribute.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("key")) {
                builder.setKey(jsonReader.nextString());
            } else if (!nextName.equals("value")) {
                jsonReader.skipValue();
            } else {
                builder.setValue(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Device parseDevice(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Device.Builder builder = CrashlyticsReport.Session.Device.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1981332476:
                    if (nextName.equals("simulator")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1969347631:
                    if (nextName.equals("manufacturer")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 112670:
                    if (nextName.equals("ram")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 3002454:
                    if (nextName.equals("arch")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 81784169:
                    if (nextName.equals("diskSpace")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 94848180:
                    if (nextName.equals("cores")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 104069929:
                    if (nextName.equals(DeviceRequestsHelper.DEVICE_INFO_MODEL)) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 109757585:
                    if (nextName.equals("state")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 2078953423:
                    if (nextName.equals("modelClass")) {
                        c11 = 8;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    builder.setSimulator(jsonReader.nextBoolean());
                    break;
                case 1:
                    builder.setManufacturer(jsonReader.nextString());
                    break;
                case 2:
                    builder.setRam(jsonReader.nextLong());
                    break;
                case 3:
                    builder.setArch(jsonReader.nextInt());
                    break;
                case 4:
                    builder.setDiskSpace(jsonReader.nextLong());
                    break;
                case 5:
                    builder.setCores(jsonReader.nextInt());
                    break;
                case 6:
                    builder.setModel(jsonReader.nextString());
                    break;
                case 7:
                    builder.setState(jsonReader.nextInt());
                    break;
                case 8:
                    builder.setModelClass(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.Session.Event parseEvent(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Builder builder = CrashlyticsReport.Session.Event.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1335157162:
                    if (nextName.equals("device")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals(a.f30241h)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 107332:
                    if (nextName.equals("log")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 55126294:
                    if (nextName.equals("timestamp")) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    builder.setDevice(parseEventDevice(jsonReader));
                    break;
                case 1:
                    builder.setApp(parseEventApp(jsonReader));
                    break;
                case 2:
                    builder.setLog(parseEventLog(jsonReader));
                    break;
                case 3:
                    builder.setType(jsonReader.nextString());
                    break;
                case 4:
                    builder.setTimestamp(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application parseEventApp(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Builder builder = CrashlyticsReport.Session.Event.Application.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1332194002:
                    if (nextName.equals("background")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1090974952:
                    if (nextName.equals("execution")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -80231855:
                    if (nextName.equals("internalKeys")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 555169704:
                    if (nextName.equals("customAttributes")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 928737948:
                    if (nextName.equals("uiOrientation")) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    builder.setBackground(Boolean.valueOf(jsonReader.nextBoolean()));
                    break;
                case 1:
                    builder.setExecution(parseEventExecution(jsonReader));
                    break;
                case 2:
                    builder.setInternalKeys(parseArray(jsonReader, g.f67075a));
                    break;
                case 3:
                    builder.setCustomAttributes(parseArray(jsonReader, g.f67075a));
                    break;
                case 4:
                    builder.setUiOrientation(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.Session.Event.Application.Execution.BinaryImage parseEventBinaryImage(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.BinaryImage.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case 3373707:
                    if (nextName.equals("name")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3530753:
                    if (nextName.equals("size")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 3601339:
                    if (nextName.equals(ZendeskIdentityStorage.UUID_KEY)) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1153765347:
                    if (nextName.equals("baseAddress")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    builder.setName(jsonReader.nextString());
                    break;
                case 1:
                    builder.setSize(jsonReader.nextLong());
                    break;
                case 2:
                    builder.setUuidFromUtf8Bytes(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 3:
                    builder.setBaseAddress(jsonReader.nextLong());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Device parseEventDevice(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Device.Builder builder = CrashlyticsReport.Session.Event.Device.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1708606089:
                    if (nextName.equals("batteryLevel")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1455558134:
                    if (nextName.equals("batteryVelocity")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1439500848:
                    if (nextName.equals("orientation")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 279795450:
                    if (nextName.equals("diskUsed")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 976541947:
                    if (nextName.equals("ramUsed")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 1516795582:
                    if (nextName.equals("proximityOn")) {
                        c11 = 5;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    builder.setBatteryLevel(Double.valueOf(jsonReader.nextDouble()));
                    break;
                case 1:
                    builder.setBatteryVelocity(jsonReader.nextInt());
                    break;
                case 2:
                    builder.setOrientation(jsonReader.nextInt());
                    break;
                case 3:
                    builder.setDiskUsed(jsonReader.nextLong());
                    break;
                case 4:
                    builder.setRamUsed(jsonReader.nextLong());
                    break;
                case 5:
                    builder.setProximityOn(jsonReader.nextBoolean());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application.Execution parseEventExecution(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1375141843:
                    if (nextName.equals("appExitInfo")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1337936983:
                    if (nextName.equals("threads")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -902467928:
                    if (nextName.equals("signal")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 937615455:
                    if (nextName.equals("binaries")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 1481625679:
                    if (nextName.equals(Constants.EXCEPTION)) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    builder.setAppExitInfo(parseAppExitInfo(jsonReader));
                    break;
                case 1:
                    builder.setThreads(parseArray(jsonReader, d.f67072a));
                    break;
                case 2:
                    builder.setSignal(parseEventSignal(jsonReader));
                    break;
                case 3:
                    builder.setBinaries(parseArray(jsonReader, f.f67074a));
                    break;
                case 4:
                    builder.setException(parseEventExecutionException(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application.Execution.Exception parseEventExecutionException(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Exception.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Exception.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -934964668:
                    if (nextName.equals(Constants.REASON)) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 3575610:
                    if (nextName.equals("type")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 91997906:
                    if (nextName.equals("causedBy")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 581754413:
                    if (nextName.equals("overflowCount")) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    builder.setFrames(parseArray(jsonReader, c.f67071a));
                    break;
                case 1:
                    builder.setReason(jsonReader.nextString());
                    break;
                case 2:
                    builder.setType(jsonReader.nextString());
                    break;
                case 3:
                    builder.setCausedBy(parseEventExecutionException(jsonReader));
                    break;
                case 4:
                    builder.setOverflowCount(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame parseEventFrame(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Thread.Frame.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1019779949:
                    if (nextName.equals(com.tencent.android.tpush.common.Constants.FLAG_TAG_OFFSET)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -887523944:
                    if (nextName.equals("symbol")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 3571:
                    if (nextName.equals("pc")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 3143036:
                    if (nextName.equals("file")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c11 = 4;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    builder.setOffset(jsonReader.nextLong());
                    break;
                case 1:
                    builder.setSymbol(jsonReader.nextString());
                    break;
                case 2:
                    builder.setPc(jsonReader.nextLong());
                    break;
                case 3:
                    builder.setFile(jsonReader.nextString());
                    break;
                case 4:
                    builder.setImportance(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Log parseEventLog(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Log.Builder builder = CrashlyticsReport.Session.Event.Log.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals("content")) {
                jsonReader.skipValue();
            } else {
                builder.setContent(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.Event.Application.Execution.Signal parseEventSignal(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Signal.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Signal.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1147692044:
                    if (nextName.equals(InnerShareParams.ADDRESS)) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3059181:
                    if (nextName.equals("code")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals("name")) {
                        c11 = 2;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    builder.setAddress(jsonReader.nextLong());
                    break;
                case 1:
                    builder.setCode(jsonReader.nextString());
                    break;
                case 2:
                    builder.setName(jsonReader.nextString());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.Session.Event.Application.Execution.Thread parseEventThread(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Event.Application.Execution.Thread.Builder builder = CrashlyticsReport.Session.Event.Application.Execution.Thread.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -1266514778:
                    if (nextName.equals("frames")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case 3373707:
                    if (nextName.equals("name")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 2125650548:
                    if (nextName.equals("importance")) {
                        c11 = 2;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    builder.setFrames(parseArray(jsonReader, c.f67071a));
                    break;
                case 1:
                    builder.setName(jsonReader.nextString());
                    break;
                case 2:
                    builder.setImportance(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    /* access modifiers changed from: private */
    public static CrashlyticsReport.FilesPayload.File parseFile(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.FilesPayload.File.Builder builder = CrashlyticsReport.FilesPayload.File.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("filename")) {
                builder.setFilename(jsonReader.nextString());
            } else if (!nextName.equals("contents")) {
                jsonReader.skipValue();
            } else {
                builder.setContents(Base64.decode(jsonReader.nextString(), 2));
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.FilesPayload parseNdkPayload(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.FilesPayload.Builder builder = CrashlyticsReport.FilesPayload.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (nextName.equals("files")) {
                builder.setFiles(parseArray(jsonReader, e.f67073a));
            } else if (!nextName.equals("orgId")) {
                jsonReader.skipValue();
            } else {
                builder.setOrgId(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.OperatingSystem parseOs(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.OperatingSystem.Builder builder = CrashlyticsReport.Session.OperatingSystem.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -293026577:
                    if (nextName.equals("jailbroken")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case 351608024:
                    if (nextName.equals("version")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c11 = 3;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    builder.setBuildVersion(jsonReader.nextString());
                    break;
                case 1:
                    builder.setJailbroken(jsonReader.nextBoolean());
                    break;
                case 2:
                    builder.setVersion(jsonReader.nextString());
                    break;
                case 3:
                    builder.setPlatform(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport parseReport(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Builder builder = CrashlyticsReport.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -2118372775:
                    if (nextName.equals("ndkPayload")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1962630338:
                    if (nextName.equals("sdkVersion")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1907185581:
                    if (nextName.equals("appQualitySessionId")) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -1375141843:
                    if (nextName.equals("appExitInfo")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -911706486:
                    if (nextName.equals("buildVersion")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case 344431858:
                    if (nextName.equals("gmpAppId")) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 719853845:
                    if (nextName.equals("installationUuid")) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 1047652060:
                    if (nextName.equals("firebaseInstallationId")) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 1874684019:
                    if (nextName.equals("platform")) {
                        c11 = 8;
                        break;
                    }
                    break;
                case 1975623094:
                    if (nextName.equals("displayVersion")) {
                        c11 = 9;
                        break;
                    }
                    break;
                case 1984987798:
                    if (nextName.equals(SettingsJsonConstants.SESSION_KEY)) {
                        c11 = 10;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    builder.setNdkPayload(parseNdkPayload(jsonReader));
                    break;
                case 1:
                    builder.setSdkVersion(jsonReader.nextString());
                    break;
                case 2:
                    builder.setAppQualitySessionId(jsonReader.nextString());
                    break;
                case 3:
                    builder.setAppExitInfo(parseAppExitInfo(jsonReader));
                    break;
                case 4:
                    builder.setBuildVersion(jsonReader.nextString());
                    break;
                case 5:
                    builder.setGmpAppId(jsonReader.nextString());
                    break;
                case 6:
                    builder.setInstallationUuid(jsonReader.nextString());
                    break;
                case 7:
                    builder.setFirebaseInstallationId(jsonReader.nextString());
                    break;
                case 8:
                    builder.setPlatform(jsonReader.nextInt());
                    break;
                case 9:
                    builder.setDisplayVersion(jsonReader.nextString());
                    break;
                case 10:
                    builder.setSession(parseSession(jsonReader));
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session parseSession(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.Builder builder = CrashlyticsReport.Session.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            char c11 = 65535;
            switch (nextName.hashCode()) {
                case -2128794476:
                    if (nextName.equals("startedAt")) {
                        c11 = 0;
                        break;
                    }
                    break;
                case -1907185581:
                    if (nextName.equals("appQualitySessionId")) {
                        c11 = 1;
                        break;
                    }
                    break;
                case -1618432855:
                    if (nextName.equals(Constants.IDENTIFIER)) {
                        c11 = 2;
                        break;
                    }
                    break;
                case -1606742899:
                    if (nextName.equals("endedAt")) {
                        c11 = 3;
                        break;
                    }
                    break;
                case -1335157162:
                    if (nextName.equals("device")) {
                        c11 = 4;
                        break;
                    }
                    break;
                case -1291329255:
                    if (nextName.equals(DbParams.TABLE_EVENTS)) {
                        c11 = 5;
                        break;
                    }
                    break;
                case 3556:
                    if (nextName.equals(q.f30469g)) {
                        c11 = 6;
                        break;
                    }
                    break;
                case 96801:
                    if (nextName.equals(a.f30241h)) {
                        c11 = 7;
                        break;
                    }
                    break;
                case 3599307:
                    if (nextName.equals("user")) {
                        c11 = 8;
                        break;
                    }
                    break;
                case 286956243:
                    if (nextName.equals("generator")) {
                        c11 = 9;
                        break;
                    }
                    break;
                case 1025385094:
                    if (nextName.equals("crashed")) {
                        c11 = 10;
                        break;
                    }
                    break;
                case 2047016109:
                    if (nextName.equals("generatorType")) {
                        c11 = 11;
                        break;
                    }
                    break;
            }
            switch (c11) {
                case 0:
                    builder.setStartedAt(jsonReader.nextLong());
                    break;
                case 1:
                    builder.setAppQualitySessionId(jsonReader.nextString());
                    break;
                case 2:
                    builder.setIdentifierFromUtf8Bytes(Base64.decode(jsonReader.nextString(), 2));
                    break;
                case 3:
                    builder.setEndedAt(Long.valueOf(jsonReader.nextLong()));
                    break;
                case 4:
                    builder.setDevice(parseDevice(jsonReader));
                    break;
                case 5:
                    builder.setEvents(parseArray(jsonReader, a.f67069a));
                    break;
                case 6:
                    builder.setOs(parseOs(jsonReader));
                    break;
                case 7:
                    builder.setApp(parseApp(jsonReader));
                    break;
                case 8:
                    builder.setUser(parseUser(jsonReader));
                    break;
                case 9:
                    builder.setGenerator(jsonReader.nextString());
                    break;
                case 10:
                    builder.setCrashed(jsonReader.nextBoolean());
                    break;
                case 11:
                    builder.setGeneratorType(jsonReader.nextInt());
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    private static CrashlyticsReport.Session.User parseUser(JsonReader jsonReader) throws IOException {
        CrashlyticsReport.Session.User.Builder builder = CrashlyticsReport.Session.User.builder();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName.hashCode();
            if (!nextName.equals(Constants.IDENTIFIER)) {
                jsonReader.skipValue();
            } else {
                builder.setIdentifier(jsonReader.nextString());
            }
        }
        jsonReader.endObject();
        return builder.build();
    }

    public CrashlyticsReport.ApplicationExitInfo applicationExitInfoFromJson(String str) throws IOException {
        JsonReader jsonReader;
        try {
            jsonReader = new JsonReader(new StringReader(str));
            CrashlyticsReport.ApplicationExitInfo parseAppExitInfo = parseAppExitInfo(jsonReader);
            jsonReader.close();
            return parseAppExitInfo;
        } catch (IllegalStateException e11) {
            throw new IOException(e11);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public String applicationExitInfoToJson(CrashlyticsReport.ApplicationExitInfo applicationExitInfo) {
        return CRASHLYTICS_REPORT_JSON_ENCODER.encode(applicationExitInfo);
    }

    public CrashlyticsReport.Session.Event eventFromJson(String str) throws IOException {
        JsonReader jsonReader;
        try {
            jsonReader = new JsonReader(new StringReader(str));
            CrashlyticsReport.Session.Event parseEvent = parseEvent(jsonReader);
            jsonReader.close();
            return parseEvent;
        } catch (IllegalStateException e11) {
            throw new IOException(e11);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public String eventToJson(CrashlyticsReport.Session.Event event) {
        return CRASHLYTICS_REPORT_JSON_ENCODER.encode(event);
    }

    public CrashlyticsReport reportFromJson(String str) throws IOException {
        JsonReader jsonReader;
        try {
            jsonReader = new JsonReader(new StringReader(str));
            CrashlyticsReport parseReport = parseReport(jsonReader);
            jsonReader.close();
            return parseReport;
        } catch (IllegalStateException e11) {
            throw new IOException(e11);
        } catch (Throwable th2) {
            th.addSuppressed(th2);
        }
        throw th;
    }

    public String reportToJson(CrashlyticsReport crashlyticsReport) {
        return CRASHLYTICS_REPORT_JSON_ENCODER.encode(crashlyticsReport);
    }
}
