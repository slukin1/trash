package com.iproov.sdk.network.model.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class EnvelopeOuterClass$Envelope extends GeneratedMessageLite implements MessageLiteOrBuilder {
    /* access modifiers changed from: private */
    public static final EnvelopeOuterClass$Envelope DEFAULT_INSTANCE;
    public static final int ENCRYPTION_ALGORITHM_FIELD_NUMBER = 5;
    public static final int EVENT_TYPE_FIELD_NUMBER = 3;
    private static volatile Parser<EnvelopeOuterClass$Envelope> PARSER = null;
    public static final int SEQUENCE_NUMBER_FIELD_NUMBER = 2;
    public static final int SERIALIZED_MESSAGE_FIELD_NUMBER = 4;
    public static final int VERSION_FIELD_NUMBER = 1;
    private int encryptionAlgorithm_;
    private int eventType_;
    private int sequenceNumber_;
    private ByteString serializedMessage_ = ByteString.EMPTY;
    private int version_;

    /* renamed from: com.iproov.sdk.network.model.proto.EnvelopeOuterClass$Envelope$do  reason: invalid class name */
    public static final class Cdo extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
        public /* synthetic */ Cdo(Cthrow throwR) {
            this();
        }

        /* renamed from: do  reason: not valid java name */
        public Cdo m1170do(int i11) {
            copyOnWrite();
            ((EnvelopeOuterClass$Envelope) this.instance).setSequenceNumber(i11);
            return this;
        }

        /* renamed from: if  reason: not valid java name */
        public Cdo m1174if(int i11) {
            copyOnWrite();
            ((EnvelopeOuterClass$Envelope) this.instance).setVersion(i11);
            return this;
        }

        private Cdo() {
            super(EnvelopeOuterClass$Envelope.DEFAULT_INSTANCE);
        }

        /* renamed from: do  reason: not valid java name */
        public Cdo m1173do(Cwhile whileR) {
            copyOnWrite();
            ((EnvelopeOuterClass$Envelope) this.instance).setEventType(whileR);
            return this;
        }

        /* renamed from: do  reason: not valid java name */
        public Cdo m1171do(ByteString byteString) {
            copyOnWrite();
            ((EnvelopeOuterClass$Envelope) this.instance).setSerializedMessage(byteString);
            return this;
        }

        /* renamed from: do  reason: not valid java name */
        public Cdo m1172do(Cimport importR) {
            copyOnWrite();
            ((EnvelopeOuterClass$Envelope) this.instance).setEncryptionAlgorithm(importR);
            return this;
        }
    }

    static {
        EnvelopeOuterClass$Envelope envelopeOuterClass$Envelope = new EnvelopeOuterClass$Envelope();
        DEFAULT_INSTANCE = envelopeOuterClass$Envelope;
        GeneratedMessageLite.registerDefaultInstance(EnvelopeOuterClass$Envelope.class, envelopeOuterClass$Envelope);
    }

    private EnvelopeOuterClass$Envelope() {
    }

    /* access modifiers changed from: private */
    public void clearEncryptionAlgorithm() {
        this.encryptionAlgorithm_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearEventType() {
        this.eventType_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearSequenceNumber() {
        this.sequenceNumber_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearSerializedMessage() {
        this.serializedMessage_ = getDefaultInstance().getSerializedMessage();
    }

    /* access modifiers changed from: private */
    public void clearVersion() {
        this.version_ = 0;
    }

    public static EnvelopeOuterClass$Envelope getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Cdo newBuilder() {
        return (Cdo) DEFAULT_INSTANCE.createBuilder();
    }

    public static EnvelopeOuterClass$Envelope parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (EnvelopeOuterClass$Envelope) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EnvelopeOuterClass$Envelope parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (EnvelopeOuterClass$Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<EnvelopeOuterClass$Envelope> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setEncryptionAlgorithm(Cimport importR) {
        this.encryptionAlgorithm_ = importR.getNumber();
    }

    /* access modifiers changed from: private */
    public void setEncryptionAlgorithmValue(int i11) {
        this.encryptionAlgorithm_ = i11;
    }

    /* access modifiers changed from: private */
    public void setEventType(Cwhile whileR) {
        this.eventType_ = whileR.getNumber();
    }

    /* access modifiers changed from: private */
    public void setEventTypeValue(int i11) {
        this.eventType_ = i11;
    }

    /* access modifiers changed from: private */
    public void setSequenceNumber(int i11) {
        this.sequenceNumber_ = i11;
    }

    /* access modifiers changed from: private */
    public void setSerializedMessage(ByteString byteString) {
        byteString.getClass();
        this.serializedMessage_ = byteString;
    }

    /* access modifiers changed from: private */
    public void setVersion(int i11) {
        this.version_ = i11;
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (Cthrow.f1039do[methodToInvoke.ordinal()]) {
            case 1:
                return new EnvelopeOuterClass$Envelope();
            case 2:
                return new Cdo((Cthrow) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0005\u0000\u0000\u0001\u0005\u0005\u0000\u0000\u0000\u0001\u000b\u0002\u000b\u0003\f\u0004\n\u0005\f", new Object[]{"version_", "sequenceNumber_", "eventType_", "serializedMessage_", "encryptionAlgorithm_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EnvelopeOuterClass$Envelope> parser = PARSER;
                if (parser == null) {
                    synchronized (EnvelopeOuterClass$Envelope.class) {
                        parser = PARSER;
                        if (parser == null) {
                            parser = new GeneratedMessageLite.DefaultInstanceBasedParser<>(DEFAULT_INSTANCE);
                            PARSER = parser;
                        }
                    }
                }
                return parser;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public Cimport getEncryptionAlgorithm() {
        Cimport importR = Cimport.m1175do(this.encryptionAlgorithm_);
        return importR == null ? Cimport.UNRECOGNIZED : importR;
    }

    public int getEncryptionAlgorithmValue() {
        return this.encryptionAlgorithm_;
    }

    public Cwhile getEventType() {
        Cwhile whileR = Cwhile.m1179do(this.eventType_);
        return whileR == null ? Cwhile.UNRECOGNIZED : whileR;
    }

    public int getEventTypeValue() {
        return this.eventType_;
    }

    public int getSequenceNumber() {
        return this.sequenceNumber_;
    }

    public ByteString getSerializedMessage() {
        return this.serializedMessage_;
    }

    public int getVersion() {
        return this.version_;
    }

    public static Cdo newBuilder(EnvelopeOuterClass$Envelope envelopeOuterClass$Envelope) {
        return (Cdo) DEFAULT_INSTANCE.createBuilder(envelopeOuterClass$Envelope);
    }

    public static EnvelopeOuterClass$Envelope parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EnvelopeOuterClass$Envelope) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EnvelopeOuterClass$Envelope parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EnvelopeOuterClass$Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static EnvelopeOuterClass$Envelope parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (EnvelopeOuterClass$Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static EnvelopeOuterClass$Envelope parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EnvelopeOuterClass$Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static EnvelopeOuterClass$Envelope parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (EnvelopeOuterClass$Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EnvelopeOuterClass$Envelope parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EnvelopeOuterClass$Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static EnvelopeOuterClass$Envelope parseFrom(InputStream inputStream) throws IOException {
        return (EnvelopeOuterClass$Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EnvelopeOuterClass$Envelope parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EnvelopeOuterClass$Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EnvelopeOuterClass$Envelope parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (EnvelopeOuterClass$Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static EnvelopeOuterClass$Envelope parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EnvelopeOuterClass$Envelope) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
