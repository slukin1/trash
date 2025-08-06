package com.google.android.exoplayer2.metadata.emsg;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class EventMessageEncoder {
    private final ByteArrayOutputStream byteArrayOutputStream;
    private final DataOutputStream dataOutputStream;

    public EventMessageEncoder() {
        ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream(512);
        this.byteArrayOutputStream = byteArrayOutputStream2;
        this.dataOutputStream = new DataOutputStream(byteArrayOutputStream2);
    }

    private static void writeNullTerminatedString(DataOutputStream dataOutputStream2, String str) throws IOException {
        dataOutputStream2.writeBytes(str);
        dataOutputStream2.writeByte(0);
    }

    private static void writeUnsignedInt(DataOutputStream dataOutputStream2, long j11) throws IOException {
        dataOutputStream2.writeByte(((int) (j11 >>> 24)) & 255);
        dataOutputStream2.writeByte(((int) (j11 >>> 16)) & 255);
        dataOutputStream2.writeByte(((int) (j11 >>> 8)) & 255);
        dataOutputStream2.writeByte(((int) j11) & 255);
    }

    public byte[] encode(EventMessage eventMessage) {
        this.byteArrayOutputStream.reset();
        try {
            writeNullTerminatedString(this.dataOutputStream, eventMessage.schemeIdUri);
            String str = eventMessage.value;
            if (str == null) {
                str = "";
            }
            writeNullTerminatedString(this.dataOutputStream, str);
            writeUnsignedInt(this.dataOutputStream, eventMessage.durationMs);
            writeUnsignedInt(this.dataOutputStream, eventMessage.f65945id);
            this.dataOutputStream.write(eventMessage.messageData);
            this.dataOutputStream.flush();
            return this.byteArrayOutputStream.toByteArray();
        } catch (IOException e11) {
            throw new RuntimeException(e11);
        }
    }
}
