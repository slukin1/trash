package creativemaybeno.wakelock;

import io.flutter.plugin.common.StandardMessageCodec;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;

public class Messages {

    public static class IsEnabledMessage {

        /* renamed from: a  reason: collision with root package name */
        public Boolean f53465a;

        public static IsEnabledMessage a(Map<String, Object> map) {
            IsEnabledMessage isEnabledMessage = new IsEnabledMessage();
            isEnabledMessage.f53465a = (Boolean) map.get(Constants.ENABLED);
            return isEnabledMessage;
        }

        public void b(Boolean bool) {
            this.f53465a = bool;
        }

        public Map<String, Object> c() {
            HashMap hashMap = new HashMap();
            hashMap.put(Constants.ENABLED, this.f53465a);
            return hashMap;
        }
    }

    public static class ToggleMessage {

        /* renamed from: a  reason: collision with root package name */
        public Boolean f53466a;

        public static ToggleMessage a(Map<String, Object> map) {
            ToggleMessage toggleMessage = new ToggleMessage();
            toggleMessage.f53466a = (Boolean) map.get("enable");
            return toggleMessage;
        }

        public Boolean b() {
            return this.f53466a;
        }

        public Map<String, Object> c() {
            HashMap hashMap = new HashMap();
            hashMap.put("enable", this.f53466a);
            return hashMap;
        }
    }

    public interface a {
        void a(ToggleMessage toggleMessage);

        IsEnabledMessage isEnabled();
    }

    public static class b extends StandardMessageCodec {

        /* renamed from: a  reason: collision with root package name */
        public static final b f53467a = new b();

        public Object readValueOfType(byte b11, ByteBuffer byteBuffer) {
            if (b11 == Byte.MIN_VALUE) {
                return IsEnabledMessage.a((Map) readValue(byteBuffer));
            }
            if (b11 != -127) {
                return super.readValueOfType(b11, byteBuffer);
            }
            return ToggleMessage.a((Map) readValue(byteBuffer));
        }

        public void writeValue(ByteArrayOutputStream byteArrayOutputStream, Object obj) {
            if (obj instanceof IsEnabledMessage) {
                byteArrayOutputStream.write(128);
                writeValue(byteArrayOutputStream, ((IsEnabledMessage) obj).c());
            } else if (obj instanceof ToggleMessage) {
                byteArrayOutputStream.write(129);
                writeValue(byteArrayOutputStream, ((ToggleMessage) obj).c());
            } else {
                super.writeValue(byteArrayOutputStream, obj);
            }
        }
    }

    public static Map<String, Object> b(Throwable th2) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", th2.toString());
        hashMap.put("code", th2.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
