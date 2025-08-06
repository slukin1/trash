package io.flutter.embedding.engine.systemchannels;

import android.view.KeyEvent;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.tencent.android.tpush.common.Constants;
import io.flutter.Log;
import io.flutter.plugin.common.BasicMessageChannel;
import io.flutter.plugin.common.BinaryMessenger;
import io.flutter.plugin.common.JSONMessageCodec;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public class KeyEventChannel {
    private static final String TAG = "KeyEventChannel";
    public final BasicMessageChannel<Object> channel;

    public interface EventResponseHandler {
        void onFrameworkResponse(boolean z11);
    }

    public static class FlutterKeyEvent {
        public final Character complexCharacter;
        public final KeyEvent event;

        public FlutterKeyEvent(KeyEvent keyEvent) {
            this(keyEvent, (Character) null);
        }

        public FlutterKeyEvent(KeyEvent keyEvent, Character ch2) {
            this.event = keyEvent;
            this.complexCharacter = ch2;
        }
    }

    public KeyEventChannel(BinaryMessenger binaryMessenger) {
        this.channel = new BasicMessageChannel<>(binaryMessenger, "flutter/keyevent", JSONMessageCodec.INSTANCE);
    }

    private static BasicMessageChannel.Reply<Object> createReplyHandler(EventResponseHandler eventResponseHandler) {
        return new a(eventResponseHandler);
    }

    private Map<String, Object> encodeKeyEvent(FlutterKeyEvent flutterKeyEvent, boolean z11) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", z11 ? "keyup" : "keydown");
        hashMap.put("keymap", "android");
        hashMap.put("flags", Integer.valueOf(flutterKeyEvent.event.getFlags()));
        hashMap.put("plainCodePoint", Integer.valueOf(flutterKeyEvent.event.getUnicodeChar(0)));
        hashMap.put("codePoint", Integer.valueOf(flutterKeyEvent.event.getUnicodeChar()));
        hashMap.put("keyCode", Integer.valueOf(flutterKeyEvent.event.getKeyCode()));
        hashMap.put("scanCode", Integer.valueOf(flutterKeyEvent.event.getScanCode()));
        hashMap.put("metaState", Integer.valueOf(flutterKeyEvent.event.getMetaState()));
        Character ch2 = flutterKeyEvent.complexCharacter;
        if (ch2 != null) {
            hashMap.put(FirebaseAnalytics.Param.CHARACTER, ch2.toString());
        }
        hashMap.put("source", Integer.valueOf(flutterKeyEvent.event.getSource()));
        hashMap.put(Constants.FLAG_DEVICE_ID, Integer.valueOf(flutterKeyEvent.event.getDeviceId()));
        hashMap.put("repeatCount", Integer.valueOf(flutterKeyEvent.event.getRepeatCount()));
        return hashMap;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$createReplyHandler$0(EventResponseHandler eventResponseHandler, Object obj) {
        boolean z11 = false;
        if (obj != null) {
            try {
                z11 = ((JSONObject) obj).getBoolean("handled");
            } catch (JSONException e11) {
                Log.e(TAG, "Unable to unpack JSON message: " + e11);
            }
        }
        eventResponseHandler.onFrameworkResponse(z11);
    }

    public void sendFlutterKeyEvent(FlutterKeyEvent flutterKeyEvent, boolean z11, EventResponseHandler eventResponseHandler) {
        this.channel.send(encodeKeyEvent(flutterKeyEvent, z11), createReplyHandler(eventResponseHandler));
    }
}
