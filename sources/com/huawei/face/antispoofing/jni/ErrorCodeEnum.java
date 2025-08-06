package com.huawei.face.antispoofing.jni;

import java.util.HashMap;
import java.util.Map;

public enum ErrorCodeEnum {
    NO_ERROR(0, "正常"),
    ACTION_TYPE_ERROR(1, "动作类型有误"),
    INPUT_DATA_ERROR(2, "输入数据有误"),
    ACTION_DETECTOR_ERROR(3, "模块初始化异常"),
    FACE_DETECTOR_ERROR(4, "模块初始化异常"),
    HEAD_POSE_ESTIMATOR_ERROR(5, "模块初始化异常"),
    FACE_LANDMARK_DETECTOR_ERROR(6, "模块初始化异常"),
    NO_FACE(7, "未检测到人脸"),
    TOO_BIG_FACE(8, "请离屏幕远点"),
    TOO_SMALL_FACE(9, "请离屏幕近点"),
    TOO_MANY_FACE(10, "检测到多个人脸"),
    FACE_NOT_IN_CENTER(11, "请正对圆形框"),
    FACE_PICTURE_ABNORMAL(12, "FACE_PICTURE_ABNORMAL"),
    TOO_LARGE_PITCH_ANGLE(13, "请正对圆形框"),
    TOO_LARGE_YAW_ANGLE(14, "请正对圆形框"),
    TOO_LARGE_ROLL_ANGLE(15, "请正对圆形框"),
    TOO_STRONG_LIGHT(16, "光线过亮"),
    TOO_WEAK_LIGHT(17, "光线过暗"),
    EYE_OCCLUSION(18, "眼部发生遮挡"),
    MOUTH_OCCLUSION(19, "嘴部发生遮挡"),
    FACE_OCCLUSION(20, "脸部发生遮挡");
    

    /* renamed from: c  reason: collision with root package name */
    private static Map<Integer, ErrorCodeEnum> f37559c;

    /* renamed from: a  reason: collision with root package name */
    private int f37561a;

    /* renamed from: b  reason: collision with root package name */
    private String f37562b;

    /* access modifiers changed from: public */
    static {
        f37559c = new HashMap(values().length);
        for (ErrorCodeEnum errorCodeEnum : values()) {
            f37559c.put(Integer.valueOf(errorCodeEnum.f37561a), errorCodeEnum);
        }
    }

    private ErrorCodeEnum(int i11, String str) {
        this.f37561a = i11;
        this.f37562b = str;
    }

    public static ErrorCodeEnum formCode(int i11) {
        return f37559c.get(Integer.valueOf(i11));
    }

    public int getCode() {
        return this.f37561a;
    }

    public String getDesc() {
        return this.f37562b;
    }
}
