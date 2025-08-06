package com.iproov.sdk.network.model.proto;

import com.google.protobuf.AbstractMessageLite;
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

public final class EdgeVideoOuterClass$EdgeVideo extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int CHUNK_FIELD_NUMBER = 1;
    /* access modifiers changed from: private */
    public static final EdgeVideoOuterClass$EdgeVideo DEFAULT_INSTANCE;
    public static final int FRAME_NUMBER_FIELD_NUMBER = 2;
    public static final int METADATA_FIELD_NUMBER = 4;
    private static volatile Parser<EdgeVideoOuterClass$EdgeVideo> PARSER = null;
    public static final int VSG_FIELD_NUMBER = 3;
    private ByteString chunk_ = ByteString.EMPTY;
    private int frameNumber_;
    private Struct metadata_;
    private String vsg_ = "";

    /* renamed from: com.iproov.sdk.network.model.proto.EdgeVideoOuterClass$EdgeVideo$do  reason: invalid class name */
    public static final class Cdo extends GeneratedMessageLite.Builder implements MessageLiteOrBuilder {
        public /* synthetic */ Cdo(Csuper superR) {
            this();
        }

        private Cdo() {
            super(EdgeVideoOuterClass$EdgeVideo.DEFAULT_INSTANCE);
        }
    }

    static {
        EdgeVideoOuterClass$EdgeVideo edgeVideoOuterClass$EdgeVideo = new EdgeVideoOuterClass$EdgeVideo();
        DEFAULT_INSTANCE = edgeVideoOuterClass$EdgeVideo;
        GeneratedMessageLite.registerDefaultInstance(EdgeVideoOuterClass$EdgeVideo.class, edgeVideoOuterClass$EdgeVideo);
    }

    private EdgeVideoOuterClass$EdgeVideo() {
    }

    /* access modifiers changed from: private */
    public void clearChunk() {
        this.chunk_ = getDefaultInstance().getChunk();
    }

    /* access modifiers changed from: private */
    public void clearFrameNumber() {
        this.frameNumber_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearMetadata() {
        this.metadata_ = null;
    }

    /* access modifiers changed from: private */
    public void clearVsg() {
        this.vsg_ = getDefaultInstance().getVsg();
    }

    public static EdgeVideoOuterClass$EdgeVideo getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    /* access modifiers changed from: private */
    public void mergeMetadata(Struct struct) {
        struct.getClass();
        Struct struct2 = this.metadata_;
        if (struct2 == null || struct2 == Struct.getDefaultInstance()) {
            this.metadata_ = struct;
        } else {
            this.metadata_ = (Struct) ((Struct.Builder) Struct.newBuilder(this.metadata_).mergeFrom(struct)).buildPartial();
        }
    }

    public static Cdo newBuilder() {
        return (Cdo) DEFAULT_INSTANCE.createBuilder();
    }

    public static EdgeVideoOuterClass$EdgeVideo parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (EdgeVideoOuterClass$EdgeVideo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EdgeVideoOuterClass$EdgeVideo parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (EdgeVideoOuterClass$EdgeVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<EdgeVideoOuterClass$EdgeVideo> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setChunk(ByteString byteString) {
        byteString.getClass();
        this.chunk_ = byteString;
    }

    /* access modifiers changed from: private */
    public void setFrameNumber(int i11) {
        this.frameNumber_ = i11;
    }

    /* access modifiers changed from: private */
    public void setMetadata(Struct struct) {
        struct.getClass();
        this.metadata_ = struct;
    }

    /* access modifiers changed from: private */
    public void setVsg(String str) {
        str.getClass();
        this.vsg_ = str;
    }

    /* access modifiers changed from: private */
    public void setVsgBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.vsg_ = byteString.toStringUtf8();
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (Csuper.f1037do[methodToInvoke.ordinal()]) {
            case 1:
                return new EdgeVideoOuterClass$EdgeVideo();
            case 2:
                return new Cdo((Csuper) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\n\u0002\u000b\u0003Ȉ\u0004\t", new Object[]{"chunk_", "frameNumber_", "vsg_", "metadata_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<EdgeVideoOuterClass$EdgeVideo> parser = PARSER;
                if (parser == null) {
                    synchronized (EdgeVideoOuterClass$EdgeVideo.class) {
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

    public ByteString getChunk() {
        return this.chunk_;
    }

    public int getFrameNumber() {
        return this.frameNumber_;
    }

    public Struct getMetadata() {
        Struct struct = this.metadata_;
        return struct == null ? Struct.getDefaultInstance() : struct;
    }

    public String getVsg() {
        return this.vsg_;
    }

    public ByteString getVsgBytes() {
        return ByteString.copyFromUtf8(this.vsg_);
    }

    public boolean hasMetadata() {
        return this.metadata_ != null;
    }

    public static Cdo newBuilder(EdgeVideoOuterClass$EdgeVideo edgeVideoOuterClass$EdgeVideo) {
        return (Cdo) DEFAULT_INSTANCE.createBuilder(edgeVideoOuterClass$EdgeVideo);
    }

    public static EdgeVideoOuterClass$EdgeVideo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EdgeVideoOuterClass$EdgeVideo) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EdgeVideoOuterClass$EdgeVideo parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EdgeVideoOuterClass$EdgeVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static EdgeVideoOuterClass$EdgeVideo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (EdgeVideoOuterClass$EdgeVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static EdgeVideoOuterClass$EdgeVideo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EdgeVideoOuterClass$EdgeVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static EdgeVideoOuterClass$EdgeVideo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (EdgeVideoOuterClass$EdgeVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static EdgeVideoOuterClass$EdgeVideo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (EdgeVideoOuterClass$EdgeVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static EdgeVideoOuterClass$EdgeVideo parseFrom(InputStream inputStream) throws IOException {
        return (EdgeVideoOuterClass$EdgeVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static EdgeVideoOuterClass$EdgeVideo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EdgeVideoOuterClass$EdgeVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static EdgeVideoOuterClass$EdgeVideo parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (EdgeVideoOuterClass$EdgeVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static EdgeVideoOuterClass$EdgeVideo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (EdgeVideoOuterClass$EdgeVideo) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
