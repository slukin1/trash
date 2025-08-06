package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.f0;

public abstract class AbstractParser<MessageType extends f0> implements n0<MessageType> {

    /* renamed from: a  reason: collision with root package name */
    public static final l f8974a = l.b();

    public final MessageType c(MessageType messagetype) throws InvalidProtocolBufferException {
        if (messagetype == null || messagetype.isInitialized()) {
            return messagetype;
        }
        throw d(messagetype).asInvalidProtocolBufferException().setUnfinishedMessage(messagetype);
    }

    public final UninitializedMessageException d(MessageType messagetype) {
        if (messagetype instanceof AbstractMessageLite) {
            return ((AbstractMessageLite) messagetype).g();
        }
        return new UninitializedMessageException((f0) messagetype);
    }

    /* renamed from: e */
    public MessageType b(ByteString byteString, l lVar) throws InvalidProtocolBufferException {
        return c(f(byteString, lVar));
    }

    public MessageType f(ByteString byteString, l lVar) throws InvalidProtocolBufferException {
        MessageType messagetype;
        try {
            g newCodedInput = byteString.newCodedInput();
            messagetype = (f0) a(newCodedInput, lVar);
            newCodedInput.a(0);
            return messagetype;
        } catch (InvalidProtocolBufferException e11) {
            throw e11.setUnfinishedMessage(messagetype);
        } catch (InvalidProtocolBufferException e12) {
            throw e12;
        }
    }
}
