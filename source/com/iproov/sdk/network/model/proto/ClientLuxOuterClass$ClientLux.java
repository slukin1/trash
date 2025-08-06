package com.iproov.sdk.network.model.proto;

import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import com.google.protobuf.Struct;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

public final class ClientLuxOuterClass$ClientLux extends GeneratedMessageLite implements MessageLiteOrBuilder {
    /* access modifiers changed from: private */
    public static final ClientLuxOuterClass$ClientLux DEFAULT_INSTANCE;
    private static volatile Parser<ClientLuxOuterClass$ClientLux> PARSER = null;
    public static final int PAYLOAD_FIELD_NUMBER = 1;
    private Struct payload_;

    /* renamed from: com.iproov.sdk.network.model.proto.ClientLuxOuterClass$ClientLux$do  reason: invalid class name */
    public static final class Cdo extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
        public /* synthetic */ Cdo(Ctry tryR) {
            this();
        }

        /* renamed from: do  reason: not valid java name */
        public Cdo m1163do(Struct struct) {
            copyOnWrite();
            ((ClientLuxOuterClass$ClientLux) this.instance).setPayload(struct);
            return this;
        }

        private Cdo() {
            super(ClientLuxOuterClass$ClientLux.DEFAULT_INSTANCE);
        }
    }

    static {
        ClientLuxOuterClass$ClientLux clientLuxOuterClass$ClientLux = new ClientLuxOuterClass$ClientLux();
        DEFAULT_INSTANCE = clientLuxOuterClass$ClientLux;
        GeneratedMessageLite.registerDefaultInstance(ClientLuxOuterClass$ClientLux.class, clientLuxOuterClass$ClientLux);
    }

    private ClientLuxOuterClass$ClientLux() {
    }

    /* access modifiers changed from: private */
    public void clearPayload() {
        this.payload_ = null;
    }

    public static ClientLuxOuterClass$ClientLux getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    public void mergePayload(Struct struct) {
        struct.getClass();
        Struct struct2 = this.payload_;
        if (struct2 == null || struct2 == Struct.getDefaultInstance()) {
            this.payload_ = struct;
        } else {
            this.payload_ = (Struct) ((Struct.Builder) Struct.newBuilder(this.payload_).mergeFrom(struct)).buildPartial();
        }
    }

    public static Cdo newBuilder() {
        return (Cdo) DEFAULT_INSTANCE.createBuilder();
    }

    public static ClientLuxOuterClass$ClientLux parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (ClientLuxOuterClass$ClientLux) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientLuxOuterClass$ClientLux parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (ClientLuxOuterClass$ClientLux) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<ClientLuxOuterClass$ClientLux> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setPayload(Struct struct) {
        struct.getClass();
        this.payload_ = struct;
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (Ctry.f1040do[methodToInvoke.ordinal()]) {
            case 1:
                return new ClientLuxOuterClass$ClientLux();
            case 2:
                return new Cdo((Ctry) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"payload_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<ClientLuxOuterClass$ClientLux> parser = PARSER;
                if (parser == null) {
                    synchronized (ClientLuxOuterClass$ClientLux.class) {
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

    public Struct getPayload() {
        Struct struct = this.payload_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    public boolean hasPayload() {
        return this.payload_ != null;
    }

    public static Cdo newBuilder(ClientLuxOuterClass$ClientLux clientLuxOuterClass$ClientLux) {
        return (Cdo) DEFAULT_INSTANCE.createBuilder(clientLuxOuterClass$ClientLux);
    }

    public static ClientLuxOuterClass$ClientLux parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientLuxOuterClass$ClientLux) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientLuxOuterClass$ClientLux parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientLuxOuterClass$ClientLux) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static ClientLuxOuterClass$ClientLux parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (ClientLuxOuterClass$ClientLux) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static ClientLuxOuterClass$ClientLux parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientLuxOuterClass$ClientLux) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static ClientLuxOuterClass$ClientLux parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (ClientLuxOuterClass$ClientLux) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static ClientLuxOuterClass$ClientLux parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (ClientLuxOuterClass$ClientLux) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static ClientLuxOuterClass$ClientLux parseFrom(InputStream inputStream) throws IOException {
        return (ClientLuxOuterClass$ClientLux) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static ClientLuxOuterClass$ClientLux parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientLuxOuterClass$ClientLux) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static ClientLuxOuterClass$ClientLux parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (ClientLuxOuterClass$ClientLux) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static ClientLuxOuterClass$ClientLux parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (ClientLuxOuterClass$ClientLux) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
