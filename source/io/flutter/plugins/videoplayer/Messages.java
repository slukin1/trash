package io.flutter.plugins.videoplayer;

import com.facebook.share.internal.ShareConstants;
import com.tencent.android.tpush.common.Constants;
import java.util.HashMap;

public class Messages {

    public static class CreateMessage {
        private String asset;
        private String formatHint;
        private HashMap httpHeaders;
        private String packageName;
        private String uri;

        public static CreateMessage fromMap(HashMap hashMap) {
            CreateMessage createMessage = new CreateMessage();
            createMessage.asset = (String) hashMap.get("asset");
            createMessage.uri = (String) hashMap.get(ShareConstants.MEDIA_URI);
            createMessage.packageName = (String) hashMap.get(Constants.FLAG_PACKAGE_NAME);
            createMessage.formatHint = (String) hashMap.get("formatHint");
            createMessage.httpHeaders = (HashMap) hashMap.get("httpHeaders");
            return createMessage;
        }

        public String getAsset() {
            return this.asset;
        }

        public String getFormatHint() {
            return this.formatHint;
        }

        public HashMap getHttpHeaders() {
            return this.httpHeaders;
        }

        public String getPackageName() {
            return this.packageName;
        }

        public String getUri() {
            return this.uri;
        }

        public void setAsset(String str) {
            this.asset = str;
        }

        public void setFormatHint(String str) {
            this.formatHint = str;
        }

        public void setHttpHeaders(HashMap hashMap) {
            this.httpHeaders = hashMap;
        }

        public void setPackageName(String str) {
            this.packageName = str;
        }

        public void setUri(String str) {
            this.uri = str;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("asset", this.asset);
            hashMap.put(ShareConstants.MEDIA_URI, this.uri);
            hashMap.put(Constants.FLAG_PACKAGE_NAME, this.packageName);
            hashMap.put("formatHint", this.formatHint);
            hashMap.put("httpHeaders", this.httpHeaders);
            return hashMap;
        }
    }

    public static class LoopingMessage {
        private Boolean isLooping;
        private Long textureId;

        public static LoopingMessage fromMap(HashMap hashMap) {
            Long l11;
            LoopingMessage loopingMessage = new LoopingMessage();
            Object obj = hashMap.get("textureId");
            if (obj == null) {
                l11 = null;
            } else {
                l11 = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            loopingMessage.textureId = l11;
            loopingMessage.isLooping = (Boolean) hashMap.get("isLooping");
            return loopingMessage;
        }

        public Boolean getIsLooping() {
            return this.isLooping;
        }

        public Long getTextureId() {
            return this.textureId;
        }

        public void setIsLooping(Boolean bool) {
            this.isLooping = bool;
        }

        public void setTextureId(Long l11) {
            this.textureId = l11;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("textureId", this.textureId);
            hashMap.put("isLooping", this.isLooping);
            return hashMap;
        }
    }

    public static class MixWithOthersMessage {
        private Boolean mixWithOthers;

        public static MixWithOthersMessage fromMap(HashMap hashMap) {
            MixWithOthersMessage mixWithOthersMessage = new MixWithOthersMessage();
            mixWithOthersMessage.mixWithOthers = (Boolean) hashMap.get("mixWithOthers");
            return mixWithOthersMessage;
        }

        public Boolean getMixWithOthers() {
            return this.mixWithOthers;
        }

        public void setMixWithOthers(Boolean bool) {
            this.mixWithOthers = bool;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("mixWithOthers", this.mixWithOthers);
            return hashMap;
        }
    }

    public static class PlaybackSpeedMessage {
        private Double speed;
        private Long textureId;

        public static PlaybackSpeedMessage fromMap(HashMap hashMap) {
            Long l11;
            PlaybackSpeedMessage playbackSpeedMessage = new PlaybackSpeedMessage();
            Object obj = hashMap.get("textureId");
            if (obj == null) {
                l11 = null;
            } else {
                l11 = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            playbackSpeedMessage.textureId = l11;
            playbackSpeedMessage.speed = (Double) hashMap.get("speed");
            return playbackSpeedMessage;
        }

        public Double getSpeed() {
            return this.speed;
        }

        public Long getTextureId() {
            return this.textureId;
        }

        public void setSpeed(Double d11) {
            this.speed = d11;
        }

        public void setTextureId(Long l11) {
            this.textureId = l11;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("textureId", this.textureId);
            hashMap.put("speed", this.speed);
            return hashMap;
        }
    }

    public static class PositionMessage {
        private Long position;
        private Long textureId;

        public static PositionMessage fromMap(HashMap hashMap) {
            Long l11;
            PositionMessage positionMessage = new PositionMessage();
            Object obj = hashMap.get("textureId");
            Long l12 = null;
            if (obj == null) {
                l11 = null;
            } else {
                l11 = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            positionMessage.textureId = l11;
            Object obj2 = hashMap.get("position");
            if (obj2 != null) {
                l12 = Long.valueOf(obj2 instanceof Integer ? (long) ((Integer) obj2).intValue() : ((Long) obj2).longValue());
            }
            positionMessage.position = l12;
            return positionMessage;
        }

        public Long getPosition() {
            return this.position;
        }

        public Long getTextureId() {
            return this.textureId;
        }

        public void setPosition(Long l11) {
            this.position = l11;
        }

        public void setTextureId(Long l11) {
            this.textureId = l11;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("textureId", this.textureId);
            hashMap.put("position", this.position);
            return hashMap;
        }
    }

    public static class TextureMessage {
        private Long textureId;

        public static TextureMessage fromMap(HashMap hashMap) {
            Long l11;
            TextureMessage textureMessage = new TextureMessage();
            Object obj = hashMap.get("textureId");
            if (obj == null) {
                l11 = null;
            } else {
                l11 = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            textureMessage.textureId = l11;
            return textureMessage;
        }

        public Long getTextureId() {
            return this.textureId;
        }

        public void setTextureId(Long l11) {
            this.textureId = l11;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("textureId", this.textureId);
            return hashMap;
        }
    }

    public interface VideoPlayerApi {
        TextureMessage create(CreateMessage createMessage);

        void dispose(TextureMessage textureMessage);

        void initialize();

        void pause(TextureMessage textureMessage);

        void play(TextureMessage textureMessage);

        PositionMessage position(TextureMessage textureMessage);

        void seekTo(PositionMessage positionMessage);

        void setLooping(LoopingMessage loopingMessage);

        void setMixWithOthers(MixWithOthersMessage mixWithOthersMessage);

        void setPlaybackSpeed(PlaybackSpeedMessage playbackSpeedMessage);

        void setVolume(VolumeMessage volumeMessage);
    }

    public static class VolumeMessage {
        private Long textureId;
        private Double volume;

        public static VolumeMessage fromMap(HashMap hashMap) {
            Long l11;
            VolumeMessage volumeMessage = new VolumeMessage();
            Object obj = hashMap.get("textureId");
            if (obj == null) {
                l11 = null;
            } else {
                l11 = Long.valueOf(obj instanceof Integer ? (long) ((Integer) obj).intValue() : ((Long) obj).longValue());
            }
            volumeMessage.textureId = l11;
            volumeMessage.volume = (Double) hashMap.get("volume");
            return volumeMessage;
        }

        public Long getTextureId() {
            return this.textureId;
        }

        public Double getVolume() {
            return this.volume;
        }

        public void setTextureId(Long l11) {
            this.textureId = l11;
        }

        public void setVolume(Double d11) {
            this.volume = d11;
        }

        public HashMap toMap() {
            HashMap hashMap = new HashMap();
            hashMap.put("textureId", this.textureId);
            hashMap.put("volume", this.volume);
            return hashMap;
        }
    }

    /* access modifiers changed from: private */
    public static HashMap wrapError(Exception exc) {
        HashMap hashMap = new HashMap();
        hashMap.put("message", exc.toString());
        hashMap.put("code", exc.getClass().getSimpleName());
        hashMap.put("details", (Object) null);
        return hashMap;
    }
}
