package com.google.firebase.crashlytics.internal.model;

import com.google.auto.value.AutoValue;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_ApplicationExitInfo;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_CustomAttribute;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_FilesPayload_File;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Application_Organization;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Device;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Device;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_Event_Log;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_OperatingSystem;
import com.google.firebase.crashlytics.internal.model.AutoValue_CrashlyticsReport_Session_User;
import com.google.firebase.encoders.annotations.Encodable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.nio.charset.Charset;

@AutoValue
@Encodable
public abstract class CrashlyticsReport {
    /* access modifiers changed from: private */
    public static final Charset UTF_8 = Charset.forName("UTF-8");

    @AutoValue
    public static abstract class ApplicationExitInfo {

        @AutoValue
        public static abstract class BuildIdMappingForArch {

            @AutoValue.Builder
            public static abstract class Builder {
                public abstract BuildIdMappingForArch build();

                public abstract Builder setArch(String str);

                public abstract Builder setBuildId(String str);

                public abstract Builder setLibraryName(String str);
            }

            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_ApplicationExitInfo_BuildIdMappingForArch.Builder();
            }

            public abstract String getArch();

            public abstract String getBuildId();

            public abstract String getLibraryName();
        }

        @AutoValue.Builder
        public static abstract class Builder {
            public abstract ApplicationExitInfo build();

            public abstract Builder setBuildIdMappingForArch(ImmutableList<BuildIdMappingForArch> immutableList);

            public abstract Builder setImportance(int i11);

            public abstract Builder setPid(int i11);

            public abstract Builder setProcessName(String str);

            public abstract Builder setPss(long j11);

            public abstract Builder setReasonCode(int i11);

            public abstract Builder setRss(long j11);

            public abstract Builder setTimestamp(long j11);

            public abstract Builder setTraceFile(String str);
        }

        public static Builder builder() {
            return new AutoValue_CrashlyticsReport_ApplicationExitInfo.Builder();
        }

        public abstract ImmutableList<BuildIdMappingForArch> getBuildIdMappingForArch();

        public abstract int getImportance();

        public abstract int getPid();

        public abstract String getProcessName();

        public abstract long getPss();

        public abstract int getReasonCode();

        public abstract long getRss();

        public abstract long getTimestamp();

        public abstract String getTraceFile();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Architecture {
        public static final int ARM64 = 9;
        public static final int ARMV6 = 5;
        public static final int ARMV7 = 6;
        public static final int UNKNOWN = 7;
        public static final int X86_32 = 0;
        public static final int X86_64 = 1;
    }

    @AutoValue.Builder
    public static abstract class Builder {
        public abstract CrashlyticsReport build();

        public abstract Builder setAppExitInfo(ApplicationExitInfo applicationExitInfo);

        public abstract Builder setAppQualitySessionId(String str);

        public abstract Builder setBuildVersion(String str);

        public abstract Builder setDisplayVersion(String str);

        public abstract Builder setFirebaseInstallationId(String str);

        public abstract Builder setGmpAppId(String str);

        public abstract Builder setInstallationUuid(String str);

        public abstract Builder setNdkPayload(FilesPayload filesPayload);

        public abstract Builder setPlatform(int i11);

        public abstract Builder setSdkVersion(String str);

        public abstract Builder setSession(Session session);
    }

    @AutoValue
    public static abstract class CustomAttribute {

        @AutoValue.Builder
        public static abstract class Builder {
            public abstract CustomAttribute build();

            public abstract Builder setKey(String str);

            public abstract Builder setValue(String str);
        }

        public static Builder builder() {
            return new AutoValue_CrashlyticsReport_CustomAttribute.Builder();
        }

        public abstract String getKey();

        public abstract String getValue();
    }

    @AutoValue
    public static abstract class FilesPayload {

        @AutoValue.Builder
        public static abstract class Builder {
            public abstract FilesPayload build();

            public abstract Builder setFiles(ImmutableList<File> immutableList);

            public abstract Builder setOrgId(String str);
        }

        @AutoValue
        public static abstract class File {

            @AutoValue.Builder
            public static abstract class Builder {
                public abstract File build();

                public abstract Builder setContents(byte[] bArr);

                public abstract Builder setFilename(String str);
            }

            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_FilesPayload_File.Builder();
            }

            public abstract byte[] getContents();

            public abstract String getFilename();
        }

        public static Builder builder() {
            return new AutoValue_CrashlyticsReport_FilesPayload.Builder();
        }

        public abstract ImmutableList<File> getFiles();

        public abstract String getOrgId();

        public abstract Builder toBuilder();
    }

    @AutoValue
    public static abstract class Session {

        @AutoValue
        public static abstract class Application {

            @AutoValue.Builder
            public static abstract class Builder {
                public abstract Application build();

                public abstract Builder setDevelopmentPlatform(String str);

                public abstract Builder setDevelopmentPlatformVersion(String str);

                public abstract Builder setDisplayVersion(String str);

                public abstract Builder setIdentifier(String str);

                public abstract Builder setInstallationUuid(String str);

                public abstract Builder setOrganization(Organization organization);

                public abstract Builder setVersion(String str);
            }

            @AutoValue
            public static abstract class Organization {

                @AutoValue.Builder
                public static abstract class Builder {
                    public abstract Organization build();

                    public abstract Builder setClsId(String str);
                }

                public static Builder builder() {
                    return new AutoValue_CrashlyticsReport_Session_Application_Organization.Builder();
                }

                public abstract String getClsId();

                public abstract Builder toBuilder();
            }

            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_Session_Application.Builder();
            }

            public abstract String getDevelopmentPlatform();

            public abstract String getDevelopmentPlatformVersion();

            public abstract String getDisplayVersion();

            public abstract String getIdentifier();

            public abstract String getInstallationUuid();

            public abstract Organization getOrganization();

            public abstract String getVersion();

            public abstract Builder toBuilder();

            public Application withOrganizationId(String str) {
                Organization organization = getOrganization();
                return toBuilder().setOrganization((organization != null ? organization.toBuilder() : Organization.builder()).setClsId(str).build()).build();
            }
        }

        @AutoValue.Builder
        public static abstract class Builder {
            public abstract Session build();

            public abstract Builder setApp(Application application);

            public abstract Builder setAppQualitySessionId(String str);

            public abstract Builder setCrashed(boolean z11);

            public abstract Builder setDevice(Device device);

            public abstract Builder setEndedAt(Long l11);

            public abstract Builder setEvents(ImmutableList<Event> immutableList);

            public abstract Builder setGenerator(String str);

            public abstract Builder setGeneratorType(int i11);

            public abstract Builder setIdentifier(String str);

            public Builder setIdentifierFromUtf8Bytes(byte[] bArr) {
                return setIdentifier(new String(bArr, CrashlyticsReport.UTF_8));
            }

            public abstract Builder setOs(OperatingSystem operatingSystem);

            public abstract Builder setStartedAt(long j11);

            public abstract Builder setUser(User user);
        }

        @AutoValue
        public static abstract class Device {

            @AutoValue.Builder
            public static abstract class Builder {
                public abstract Device build();

                public abstract Builder setArch(int i11);

                public abstract Builder setCores(int i11);

                public abstract Builder setDiskSpace(long j11);

                public abstract Builder setManufacturer(String str);

                public abstract Builder setModel(String str);

                public abstract Builder setModelClass(String str);

                public abstract Builder setRam(long j11);

                public abstract Builder setSimulator(boolean z11);

                public abstract Builder setState(int i11);
            }

            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_Session_Device.Builder();
            }

            public abstract int getArch();

            public abstract int getCores();

            public abstract long getDiskSpace();

            public abstract String getManufacturer();

            public abstract String getModel();

            public abstract String getModelClass();

            public abstract long getRam();

            public abstract int getState();

            public abstract boolean isSimulator();
        }

        @AutoValue
        public static abstract class Event {

            @AutoValue
            public static abstract class Application {

                @AutoValue.Builder
                public static abstract class Builder {
                    public abstract Application build();

                    public abstract Builder setBackground(Boolean bool);

                    public abstract Builder setCustomAttributes(ImmutableList<CustomAttribute> immutableList);

                    public abstract Builder setExecution(Execution execution);

                    public abstract Builder setInternalKeys(ImmutableList<CustomAttribute> immutableList);

                    public abstract Builder setUiOrientation(int i11);
                }

                @AutoValue
                public static abstract class Execution {

                    @AutoValue
                    public static abstract class BinaryImage {

                        @AutoValue.Builder
                        public static abstract class Builder {
                            public abstract BinaryImage build();

                            public abstract Builder setBaseAddress(long j11);

                            public abstract Builder setName(String str);

                            public abstract Builder setSize(long j11);

                            public abstract Builder setUuid(String str);

                            public Builder setUuidFromUtf8Bytes(byte[] bArr) {
                                return setUuid(new String(bArr, CrashlyticsReport.UTF_8));
                            }
                        }

                        public static Builder builder() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_BinaryImage.Builder();
                        }

                        public abstract long getBaseAddress();

                        public abstract String getName();

                        public abstract long getSize();

                        @Encodable.Ignore
                        public abstract String getUuid();

                        @Encodable.Field(name = "uuid")
                        public byte[] getUuidUtf8Bytes() {
                            String uuid = getUuid();
                            if (uuid != null) {
                                return uuid.getBytes(CrashlyticsReport.UTF_8);
                            }
                            return null;
                        }
                    }

                    @AutoValue.Builder
                    public static abstract class Builder {
                        public abstract Execution build();

                        public abstract Builder setAppExitInfo(ApplicationExitInfo applicationExitInfo);

                        public abstract Builder setBinaries(ImmutableList<BinaryImage> immutableList);

                        public abstract Builder setException(Exception exception);

                        public abstract Builder setSignal(Signal signal);

                        public abstract Builder setThreads(ImmutableList<Thread> immutableList);
                    }

                    @AutoValue
                    public static abstract class Exception {

                        @AutoValue.Builder
                        public static abstract class Builder {
                            public abstract Exception build();

                            public abstract Builder setCausedBy(Exception exception);

                            public abstract Builder setFrames(ImmutableList<Thread.Frame> immutableList);

                            public abstract Builder setOverflowCount(int i11);

                            public abstract Builder setReason(String str);

                            public abstract Builder setType(String str);
                        }

                        public static Builder builder() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Exception.Builder();
                        }

                        public abstract Exception getCausedBy();

                        public abstract ImmutableList<Thread.Frame> getFrames();

                        public abstract int getOverflowCount();

                        public abstract String getReason();

                        public abstract String getType();
                    }

                    @AutoValue
                    public static abstract class Signal {

                        @AutoValue.Builder
                        public static abstract class Builder {
                            public abstract Signal build();

                            public abstract Builder setAddress(long j11);

                            public abstract Builder setCode(String str);

                            public abstract Builder setName(String str);
                        }

                        public static Builder builder() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Signal.Builder();
                        }

                        public abstract long getAddress();

                        public abstract String getCode();

                        public abstract String getName();
                    }

                    @AutoValue
                    public static abstract class Thread {

                        @AutoValue.Builder
                        public static abstract class Builder {
                            public abstract Thread build();

                            public abstract Builder setFrames(ImmutableList<Frame> immutableList);

                            public abstract Builder setImportance(int i11);

                            public abstract Builder setName(String str);
                        }

                        @AutoValue
                        public static abstract class Frame {

                            @AutoValue.Builder
                            public static abstract class Builder {
                                public abstract Frame build();

                                public abstract Builder setFile(String str);

                                public abstract Builder setImportance(int i11);

                                public abstract Builder setOffset(long j11);

                                public abstract Builder setPc(long j11);

                                public abstract Builder setSymbol(String str);
                            }

                            public static Builder builder() {
                                return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread_Frame.Builder();
                            }

                            public abstract String getFile();

                            public abstract int getImportance();

                            public abstract long getOffset();

                            public abstract long getPc();

                            public abstract String getSymbol();
                        }

                        public static Builder builder() {
                            return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution_Thread.Builder();
                        }

                        public abstract ImmutableList<Frame> getFrames();

                        public abstract int getImportance();

                        public abstract String getName();
                    }

                    public static Builder builder() {
                        return new AutoValue_CrashlyticsReport_Session_Event_Application_Execution.Builder();
                    }

                    public abstract ApplicationExitInfo getAppExitInfo();

                    public abstract ImmutableList<BinaryImage> getBinaries();

                    public abstract Exception getException();

                    public abstract Signal getSignal();

                    public abstract ImmutableList<Thread> getThreads();
                }

                public static Builder builder() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Application.Builder();
                }

                public abstract Boolean getBackground();

                public abstract ImmutableList<CustomAttribute> getCustomAttributes();

                public abstract Execution getExecution();

                public abstract ImmutableList<CustomAttribute> getInternalKeys();

                public abstract int getUiOrientation();

                public abstract Builder toBuilder();
            }

            @AutoValue.Builder
            public static abstract class Builder {
                public abstract Event build();

                public abstract Builder setApp(Application application);

                public abstract Builder setDevice(Device device);

                public abstract Builder setLog(Log log);

                public abstract Builder setTimestamp(long j11);

                public abstract Builder setType(String str);
            }

            @AutoValue
            public static abstract class Device {

                @AutoValue.Builder
                public static abstract class Builder {
                    public abstract Device build();

                    public abstract Builder setBatteryLevel(Double d11);

                    public abstract Builder setBatteryVelocity(int i11);

                    public abstract Builder setDiskUsed(long j11);

                    public abstract Builder setOrientation(int i11);

                    public abstract Builder setProximityOn(boolean z11);

                    public abstract Builder setRamUsed(long j11);
                }

                public static Builder builder() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Device.Builder();
                }

                public abstract Double getBatteryLevel();

                public abstract int getBatteryVelocity();

                public abstract long getDiskUsed();

                public abstract int getOrientation();

                public abstract long getRamUsed();

                public abstract boolean isProximityOn();
            }

            @AutoValue
            public static abstract class Log {

                @AutoValue.Builder
                public static abstract class Builder {
                    public abstract Log build();

                    public abstract Builder setContent(String str);
                }

                public static Builder builder() {
                    return new AutoValue_CrashlyticsReport_Session_Event_Log.Builder();
                }

                public abstract String getContent();
            }

            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_Session_Event.Builder();
            }

            public abstract Application getApp();

            public abstract Device getDevice();

            public abstract Log getLog();

            public abstract long getTimestamp();

            public abstract String getType();

            public abstract Builder toBuilder();
        }

        @AutoValue
        public static abstract class OperatingSystem {

            @AutoValue.Builder
            public static abstract class Builder {
                public abstract OperatingSystem build();

                public abstract Builder setBuildVersion(String str);

                public abstract Builder setJailbroken(boolean z11);

                public abstract Builder setPlatform(int i11);

                public abstract Builder setVersion(String str);
            }

            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_Session_OperatingSystem.Builder();
            }

            public abstract String getBuildVersion();

            public abstract int getPlatform();

            public abstract String getVersion();

            public abstract boolean isJailbroken();
        }

        @AutoValue
        public static abstract class User {

            @AutoValue.Builder
            public static abstract class Builder {
                public abstract User build();

                public abstract Builder setIdentifier(String str);
            }

            public static Builder builder() {
                return new AutoValue_CrashlyticsReport_Session_User.Builder();
            }

            public abstract String getIdentifier();
        }

        public static Builder builder() {
            return new AutoValue_CrashlyticsReport_Session.Builder().setCrashed(false);
        }

        public abstract Application getApp();

        public abstract String getAppQualitySessionId();

        public abstract Device getDevice();

        public abstract Long getEndedAt();

        public abstract ImmutableList<Event> getEvents();

        public abstract String getGenerator();

        public abstract int getGeneratorType();

        @Encodable.Ignore
        public abstract String getIdentifier();

        @Encodable.Field(name = "identifier")
        public byte[] getIdentifierUtf8Bytes() {
            return getIdentifier().getBytes(CrashlyticsReport.UTF_8);
        }

        public abstract OperatingSystem getOs();

        public abstract long getStartedAt();

        public abstract User getUser();

        public abstract boolean isCrashed();

        public abstract Builder toBuilder();

        public Session withAppQualitySessionId(String str) {
            return toBuilder().setAppQualitySessionId(str).build();
        }

        public Session withEvents(ImmutableList<Event> immutableList) {
            return toBuilder().setEvents(immutableList).build();
        }

        public Session withOrganizationId(String str) {
            return toBuilder().setApp(getApp().withOrganizationId(str)).build();
        }

        public Session withSessionEndFields(long j11, boolean z11, String str) {
            Builder builder = toBuilder();
            builder.setEndedAt(Long.valueOf(j11));
            builder.setCrashed(z11);
            if (str != null) {
                builder.setUser(User.builder().setIdentifier(str).build());
            }
            return builder.build();
        }
    }

    public enum Type {
        INCOMPLETE,
        JAVA,
        NATIVE
    }

    public static Builder builder() {
        return new AutoValue_CrashlyticsReport.Builder();
    }

    public abstract ApplicationExitInfo getAppExitInfo();

    public abstract String getAppQualitySessionId();

    public abstract String getBuildVersion();

    public abstract String getDisplayVersion();

    public abstract String getFirebaseInstallationId();

    public abstract String getGmpAppId();

    public abstract String getInstallationUuid();

    public abstract FilesPayload getNdkPayload();

    public abstract int getPlatform();

    public abstract String getSdkVersion();

    public abstract Session getSession();

    @Encodable.Ignore
    public Type getType() {
        if (getSession() != null) {
            return Type.JAVA;
        }
        if (getNdkPayload() != null) {
            return Type.NATIVE;
        }
        return Type.INCOMPLETE;
    }

    public abstract Builder toBuilder();

    public CrashlyticsReport withAppQualitySessionId(String str) {
        Builder appQualitySessionId = toBuilder().setAppQualitySessionId(str);
        if (getSession() != null) {
            appQualitySessionId.setSession(getSession().withAppQualitySessionId(str));
        }
        return appQualitySessionId.build();
    }

    public CrashlyticsReport withApplicationExitInfo(ApplicationExitInfo applicationExitInfo) {
        return applicationExitInfo == null ? this : toBuilder().setAppExitInfo(applicationExitInfo).build();
    }

    public CrashlyticsReport withEvents(ImmutableList<Session.Event> immutableList) {
        if (getSession() != null) {
            return toBuilder().setSession(getSession().withEvents(immutableList)).build();
        }
        throw new IllegalStateException("Reports without sessions cannot have events added to them.");
    }

    public CrashlyticsReport withFirebaseInstallationId(String str) {
        return toBuilder().setFirebaseInstallationId(str).build();
    }

    public CrashlyticsReport withNdkPayload(FilesPayload filesPayload) {
        return toBuilder().setSession((Session) null).setNdkPayload(filesPayload).build();
    }

    public CrashlyticsReport withOrganizationId(String str) {
        Builder builder = toBuilder();
        FilesPayload ndkPayload = getNdkPayload();
        if (ndkPayload != null) {
            builder.setNdkPayload(ndkPayload.toBuilder().setOrgId(str).build());
        }
        Session session = getSession();
        if (session != null) {
            builder.setSession(session.withOrganizationId(str));
        }
        return builder.build();
    }

    public CrashlyticsReport withSessionEndFields(long j11, boolean z11, String str) {
        Builder builder = toBuilder();
        if (getSession() != null) {
            builder.setSession(getSession().withSessionEndFields(j11, z11, str));
        }
        return builder.build();
    }
}
