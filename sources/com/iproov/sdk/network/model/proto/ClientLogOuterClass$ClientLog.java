package com.iproov.sdk.network.model.proto;

import com.google.protobuf.AbstractMessageLite;
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

public final class ClientLogOuterClass$ClientLog extends GeneratedMessageLite implements MessageLiteOrBuilder {
    /* access modifiers changed from: private */
    public static final ClientLogOuterClass$ClientLog DEFAULT_INSTANCE;
    public static final int LEVEL_FIELD_NUMBER = 1;
    public static final int MESSAGE_FIELD_NUMBER = 2;
    private static volatile Parser<ClientLogOuterClass$ClientLog> PARSER;
    private int level_;
    private String message_ = "";

    /* renamed from: com.iproov.sdk.network.model.proto.ClientLogOuterClass$ClientLog$do  reason: invalid class name */
    public static final class Cdo extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
        public /* synthetic */ Cdo(Cfor forR) {
            this();
        }

        private Cdo() {
            super(ClientLogOuterClass$ClientLog.DEFAULT_INSTANCE);
        }
    }

    static {
        ClientLogOuterClass$ClientLog clientLogOuterClass$ClientLog = new ClientLogOuterClass$ClientLog();
        DEFAULT_INSTANCE = clientLogOuterClass$ClientLog;
        GeneratedMessageLite.registerDefaultInstance(ClientLogOuterClass$ClientLog.class, clientLogOuterClass$ClientLog);
    }

    private ClientLogOuterClass$ClientLog() {
    }

    /* access modifiers changed from: private */
    public void clearLevel() {
        this.level_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearMessage() {
        this.message_ = getDefaultInstance().getMessage();
    }

    public static ClientLogOuterClass$ClientLog getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static Cdo newBuilder() {
        return (Cdo) DEFAULT_INSTANCE.createBuilder();
    }

    public static ClientLogOuterClass$ClientLog parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ClientLogOuterClass$ClientLog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientLogOuterClass$ClientLog parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ClientLogOuterClass$ClientLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ClientLogOuterClass$ClientLog> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setLevel(Cnew newR) {
        this.level_ = newR.getNumber();
    }

    /* access modifiers changed from: private */
    public void setLevelValue(int i11) {
        this.level_ = i11;
    }

    /* access modifiers changed from: private */
    public void setMessage(String str) {
        str.getClass();
        this.message_ = str;
    }

    /* access modifiers changed from: private */
    public void setMessageBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.message_ = byteString.toStringUtf8();
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (Cfor.f1023do[methodToInvoke.ordinal()]) {
            case 1:
                return new ClientLogOuterClass$ClientLog();
            case 2:
                return new Cdo((Cfor) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\f\u0002Ȉ", new Object[]{"level_", "message_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ClientLogOuterClass$ClientLog> parser = PARSER;
                if (parser == null) {
                    synchronized (ClientLogOuterClass$ClientLog.class) {
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

    public Cnew getLevel() {
        Cnew newR = Cnew.m1177do(this.level_);
        return newR == null ? Cnew.UNRECOGNIZED : newR;
    }

    public int getLevelValue() {
        return this.level_;
    }

    public String getMessage() {
        return this.message_;
    }

    public ByteString getMessageBytes() {
        return ByteString.copyFromUtf8(this.message_);
    }

    public static Cdo newBuilder(ClientLogOuterClass$ClientLog clientLogOuterClass$ClientLog) {
        return (Cdo) DEFAULT_INSTANCE.createBuilder(clientLogOuterClass$ClientLog);
    }

    public static ClientLogOuterClass$ClientLog parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientLogOuterClass$ClientLog) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientLogOuterClass$ClientLog parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientLogOuterClass$ClientLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ClientLogOuterClass$ClientLog parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ClientLogOuterClass$ClientLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ClientLogOuterClass$ClientLog parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientLogOuterClass$ClientLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ClientLogOuterClass$ClientLog parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ClientLogOuterClass$ClientLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClientLogOuterClass$ClientLog parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientLogOuterClass$ClientLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ClientLogOuterClass$ClientLog parseFrom(InputStream inputStream) throws IOException {
        return (ClientLogOuterClass$ClientLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientLogOuterClass$ClientLog parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientLogOuterClass$ClientLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientLogOuterClass$ClientLog parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ClientLogOuterClass$ClientLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ClientLogOuterClass$ClientLog parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientLogOuterClass$ClientLog) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
