package com.tencent.android.tpns.mqtt;

import com.tencent.android.tpns.mqtt.internal.ClientComms;
import com.tencent.android.tpns.mqtt.internal.wire.MqttPublish;
import com.tencent.android.tpns.mqtt.util.Strings;
import java.io.UnsupportedEncodingException;

public class MqttTopic {
    private static final int MAX_TOPIC_LEN = 65535;
    private static final int MIN_TOPIC_LEN = 1;
    public static final String MULTI_LEVEL_WILDCARD = "#";
    public static final String MULTI_LEVEL_WILDCARD_PATTERN = "/#";
    private static final char NUL = '\u0000';
    public static final String SINGLE_LEVEL_WILDCARD = "+";
    public static final String TOPIC_LEVEL_SEPARATOR = "/";
    public static final String TOPIC_WILDCARDS = "#+";
    private ClientComms comms;
    private String name;

    public MqttTopic(String str, ClientComms clientComms) {
        this.comms = clientComms;
        this.name = str;
    }

    private MqttPublish createPublish(MqttMessage mqttMessage) {
        return new MqttPublish(getName(), mqttMessage);
    }

    public static boolean isMatched(String str, String str2) throws IllegalArgumentException {
        int length = str2.length();
        int length2 = str.length();
        validate(str, true);
        validate(str2, false);
        if (str.equals(str2)) {
            return true;
        }
        int i11 = 0;
        int i12 = 0;
        while (i11 < length2 && i12 < length && ((str2.charAt(i12) != '/' || str.charAt(i11) == '/') && (str.charAt(i11) == '+' || str.charAt(i11) == '#' || str.charAt(i11) == str2.charAt(i12)))) {
            if (str.charAt(i11) == '+') {
                while (true) {
                    int i13 = i12 + 1;
                    if (i13 >= length || str2.charAt(i13) == '/') {
                        break;
                    }
                    i12++;
                }
            } else if (str.charAt(i11) == '#') {
                i12 = length - 1;
            }
            i11++;
            i12++;
        }
        if (i12 == length && i11 == length2) {
            return true;
        }
        return false;
    }

    public static void validate(String str, boolean z11) throws IllegalArgumentException {
        try {
            int length = str.getBytes("UTF-8").length;
            if (length < 1 || length > 65535) {
                throw new IllegalArgumentException(String.format("Invalid topic length, should be in range[%d, %d]!", new Object[]{new Integer(1), new Integer(65535)}));
            } else if (z11) {
                if (!Strings.equalsAny(str, new String[]{"#", "+"})) {
                    if (Strings.countMatches(str, "#") > 1 || (str.contains("#") && !str.endsWith(MULTI_LEVEL_WILDCARD_PATTERN))) {
                        throw new IllegalArgumentException("Invalid usage of multi-level wildcard in topic string: " + str);
                    }
                    validateSingleLevelWildcard(str);
                }
            } else if (Strings.containsAny((CharSequence) str, (CharSequence) TOPIC_WILDCARDS)) {
                throw new IllegalArgumentException("The topic name MUST NOT contain any wildcard characters (#+)");
            }
        } catch (UnsupportedEncodingException e11) {
            throw new IllegalStateException(e11.getMessage());
        }
    }

    private static void validateSingleLevelWildcard(String str) {
        char charAt = "+".charAt(0);
        char charAt2 = "/".charAt(0);
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        int i11 = 0;
        while (i11 < length) {
            int i12 = i11 - 1;
            char c11 = i12 >= 0 ? charArray[i12] : 0;
            int i13 = i11 + 1;
            char c12 = i13 < length ? charArray[i13] : 0;
            if (charArray[i11] != charAt || ((c11 == charAt2 || c11 == 0) && (c12 == charAt2 || c12 == 0))) {
                i11 = i13;
            } else {
                throw new IllegalArgumentException(String.format("Invalid usage of single-level wildcard in topic string '%s'!", new Object[]{str}));
            }
        }
    }

    public String getName() {
        return this.name;
    }

    public MqttDeliveryToken publish(byte[] bArr, int i11, boolean z11) throws MqttException, MqttPersistenceException {
        MqttMessage mqttMessage = new MqttMessage(bArr);
        mqttMessage.setQos(i11);
        mqttMessage.setRetained(z11);
        return publish(mqttMessage);
    }

    public String toString() {
        return getName();
    }

    public MqttDeliveryToken publish(MqttMessage mqttMessage) throws MqttException, MqttPersistenceException {
        MqttDeliveryToken mqttDeliveryToken = new MqttDeliveryToken(this.comms.getClient().getClientId());
        mqttDeliveryToken.setMessage(mqttMessage);
        this.comms.sendNoWait(createPublish(mqttMessage), mqttDeliveryToken);
        mqttDeliveryToken.internalTok.waitUntilSent();
        return mqttDeliveryToken;
    }
}
