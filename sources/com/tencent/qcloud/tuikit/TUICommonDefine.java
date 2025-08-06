package com.tencent.qcloud.tuikit;

public class TUICommonDefine {

    public enum AudioPlaybackDevice {
        Earpiece,
        Speakerphone
    }

    public interface Callback {
        void onError(int i11, String str);

        void onSuccess();
    }

    public enum Camera {
        Front,
        Back
    }

    public enum NetworkQuality {
        Unknown,
        Excellent,
        Good,
        Poor,
        Bad,
        Vbad,
        Down
    }

    public static class NetworkQualityInfo {
        public NetworkQuality quality;
        public String userId;

        public String toString() {
            return "NetworkQualityInfo{userId=" + this.userId + ", quality=" + this.quality + '}';
        }
    }

    public interface PlayCallback {
        void onError(String str, int i11, String str2);

        void onLoading(String str);

        void onPlaying(String str);
    }

    public static class RoomId {
        public int intRoomId;
        public String strRoomId;

        public String toString() {
            return "RoomId{intRoomId=" + this.intRoomId + ", strRoomId=" + this.strRoomId + '}';
        }
    }

    public interface ValueCallback<T> {
        void onError(int i11, String str);

        void onSuccess(T t11);
    }

    public static class VideoEncoderParams {
        public Resolution resolution;
        public ResolutionMode resolutionMode;

        public enum Resolution {
            Resolution_640_360(108),
            Resolution_640_480(62),
            Resolution_960_540(110),
            Resolution_960_720(64),
            Resolution_1280_720(112),
            Resolution_1920_1080(114);
            
            private int value;

            private Resolution(int i11) {
                this.value = i11;
            }

            public int getValue() {
                return this.value;
            }
        }

        public enum ResolutionMode {
            Landscape,
            Portrait
        }

        public String toString() {
            return "VideoEncoderParams{resolution=" + this.resolution + ", resolutionMode=" + this.resolutionMode + '}';
        }
    }

    public static class VideoRenderParams {
        public FillMode fillMode;
        public Rotation rotation;

        public enum FillMode {
            Fill,
            Fit
        }

        public enum Rotation {
            Rotation_0,
            Rotation_90,
            Rotation_180,
            Rotation_270
        }

        public String toString() {
            return "VideoRenderParams{fillMode=" + this.fillMode + ", rotation=" + this.rotation + '}';
        }
    }
}
