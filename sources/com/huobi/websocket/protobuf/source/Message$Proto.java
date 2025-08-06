package com.huobi.websocket.protobuf.source;

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

public final class Message$Proto extends GeneratedMessageLite<Message$Proto, a> implements MessageLiteOrBuilder {
    public static final int ACTION_FIELD_NUMBER = 3;
    public static final int CHANNEL_FIELD_NUMBER = 2;
    public static final int CONTENT_FIELD_NUMBER = 4;
    /* access modifiers changed from: private */
    public static final Message$Proto DEFAULT_INSTANCE;
    public static final int EXTRA_FIELD_NUMBER = 7;
    public static final int FORMAT_FIELD_NUMBER = 6;
    public static final int FROMID_FIELD_NUMBER = 5;
    public static final int ID_FIELD_NUMBER = 1;
    private static volatile Parser<Message$Proto> PARSER = null;
    public static final int TIMESTAMP_FIELD_NUMBER = 8;
    private int action_;
    private int channel_;
    private String content_ = "";
    private String extra_ = "";
    private int format_;
    private long fromId_;
    private String id_ = "";
    private long timestamp_;

    public static final class a extends GeneratedMessageLite.Builder<Message$Proto, a> implements MessageLiteOrBuilder {
        public /* synthetic */ a(ru.a aVar) {
            this();
        }

        public a b(int i11) {
            copyOnWrite();
            ((Message$Proto) this.instance).setAction(i11);
            return this;
        }

        public a c(int i11) {
            copyOnWrite();
            ((Message$Proto) this.instance).setChannel(i11);
            return this;
        }

        public a d(String str) {
            copyOnWrite();
            ((Message$Proto) this.instance).setContent(str);
            return this;
        }

        public a e(String str) {
            copyOnWrite();
            ((Message$Proto) this.instance).setExtra(str);
            return this;
        }

        public a() {
            super(Message$Proto.DEFAULT_INSTANCE);
        }
    }

    static {
        Message$Proto message$Proto = new Message$Proto();
        DEFAULT_INSTANCE = message$Proto;
        GeneratedMessageLite.registerDefaultInstance(Message$Proto.class, message$Proto);
    }

    private Message$Proto() {
    }

    /* access modifiers changed from: private */
    public void clearAction() {
        this.action_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearChannel() {
        this.channel_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearContent() {
        this.content_ = getDefaultInstance().getContent();
    }

    /* access modifiers changed from: private */
    public void clearExtra() {
        this.extra_ = getDefaultInstance().getExtra();
    }

    /* access modifiers changed from: private */
    public void clearFormat() {
        this.format_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearFromId() {
        this.fromId_ = 0;
    }

    /* access modifiers changed from: private */
    public void clearId() {
        this.id_ = getDefaultInstance().getId();
    }

    /* access modifiers changed from: private */
    public void clearTimestamp() {
        this.timestamp_ = 0;
    }

    public static Message$Proto getDefaultInstance() {
        return DEFAULT_INSTANCE;
    }

    public static a newBuilder() {
        return (a) DEFAULT_INSTANCE.createBuilder();
    }

    public static Message$Proto parseDelimitedFrom(InputStream inputStream) throws IOException {
        return (Message$Proto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Message$Proto parseFrom(ByteBuffer byteBuffer) throws InvalidProtocolBufferException {
        return (Message$Proto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer);
    }

    public static Parser<Message$Proto> parser() {
        return DEFAULT_INSTANCE.getParserForType();
    }

    /* access modifiers changed from: private */
    public void setAction(int i11) {
        this.action_ = i11;
    }

    /* access modifiers changed from: private */
    public void setChannel(int i11) {
        this.channel_ = i11;
    }

    /* access modifiers changed from: private */
    public void setContent(String str) {
        str.getClass();
        this.content_ = str;
    }

    /* access modifiers changed from: private */
    public void setContentBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.content_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setExtra(String str) {
        str.getClass();
        this.extra_ = str;
    }

    /* access modifiers changed from: private */
    public void setExtraBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.extra_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setFormat(int i11) {
        this.format_ = i11;
    }

    /* access modifiers changed from: private */
    public void setFromId(long j11) {
        this.fromId_ = j11;
    }

    /* access modifiers changed from: private */
    public void setId(String str) {
        str.getClass();
        this.id_ = str;
    }

    /* access modifiers changed from: private */
    public void setIdBytes(ByteString byteString) {
        AbstractMessageLite.checkByteStringIsUtf8(byteString);
        this.id_ = byteString.toStringUtf8();
    }

    /* access modifiers changed from: private */
    public void setTimestamp(long j11) {
        this.timestamp_ = j11;
    }

    public final Object dynamicMethod(GeneratedMessageLite.MethodToInvoke methodToInvoke, Object obj, Object obj2) {
        switch (ru.a.f23397a[methodToInvoke.ordinal()]) {
            case 1:
                return new Message$Proto();
            case 2:
                return new a((ru.a) null);
            case 3:
                return GeneratedMessageLite.newMessageInfo(DEFAULT_INSTANCE, "\u0000\b\u0000\u0000\u0001\b\b\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003\u0004\u0004Ȉ\u0005\u0002\u0006\u0004\u0007Ȉ\b\u0002", new Object[]{"id_", "channel_", "action_", "content_", "fromId_", "format_", "extra_", "timestamp_"});
            case 4:
                return DEFAULT_INSTANCE;
            case 5:
                Parser<Message$Proto> parser = PARSER;
                if (parser == null) {
                    synchronized (Message$Proto.class) {
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

    public int getAction() {
        return this.action_;
    }

    public int getChannel() {
        return this.channel_;
    }

    public String getContent() {
        return this.content_;
    }

    public ByteString getContentBytes() {
        return ByteString.copyFromUtf8(this.content_);
    }

    public String getExtra() {
        return this.extra_;
    }

    public ByteString getExtraBytes() {
        return ByteString.copyFromUtf8(this.extra_);
    }

    public int getFormat() {
        return this.format_;
    }

    public long getFromId() {
        return this.fromId_;
    }

    public String getId() {
        return this.id_;
    }

    public ByteString getIdBytes() {
        return ByteString.copyFromUtf8(this.id_);
    }

    public long getTimestamp() {
        return this.timestamp_;
    }

    public static a newBuilder(Message$Proto message$Proto) {
        return (a) DEFAULT_INSTANCE.createBuilder(message$Proto);
    }

    public static Message$Proto parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Message$Proto) GeneratedMessageLite.parseDelimitedFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Message$Proto parseFrom(ByteBuffer byteBuffer, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Message$Proto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteBuffer, extensionRegistryLite);
    }

    public static Message$Proto parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return (Message$Proto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString);
    }

    public static Message$Proto parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Message$Proto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, byteString, extensionRegistryLite);
    }

    public static Message$Proto parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return (Message$Proto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr);
    }

    public static Message$Proto parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return (Message$Proto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, bArr, extensionRegistryLite);
    }

    public static Message$Proto parseFrom(InputStream inputStream) throws IOException {
        return (Message$Proto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream);
    }

    public static Message$Proto parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Message$Proto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, inputStream, extensionRegistryLite);
    }

    public static Message$Proto parseFrom(CodedInputStream codedInputStream) throws IOException {
        return (Message$Proto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream);
    }

    public static Message$Proto parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return (Message$Proto) GeneratedMessageLite.parseFrom(DEFAULT_INSTANCE, codedInputStream, extensionRegistryLite);
    }
}
