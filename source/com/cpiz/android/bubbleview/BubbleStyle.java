package com.cpiz.android.bubbleview;

import android.util.SparseArray;
import android.view.View;

public interface BubbleStyle {

    public enum ArrowDirection {
        None(-1),
        Auto(0),
        Left(1),
        Up(2),
        Right(3),
        Down(4);
        
        private static final SparseArray<ArrowDirection> intToTypeDict = null;
        private int mValue;

        /* access modifiers changed from: public */
        static {
            int i11;
            intToTypeDict = new SparseArray<>();
            for (ArrowDirection arrowDirection : values()) {
                intToTypeDict.put(arrowDirection.mValue, arrowDirection);
            }
        }

        private ArrowDirection(int i11) {
            this.mValue = 0;
            this.mValue = i11;
        }

        public int getValue() {
            return this.mValue;
        }

        public boolean isDown() {
            return this == Down;
        }

        public boolean isLeft() {
            return this == Left;
        }

        public boolean isRight() {
            return this == Right;
        }

        public boolean isUp() {
            return this == Up;
        }

        public static ArrowDirection valueOf(int i11) {
            ArrowDirection arrowDirection = intToTypeDict.get(i11);
            return arrowDirection == null ? Auto : arrowDirection;
        }
    }

    public enum ArrowPosPolicy {
        TargetCenter(0),
        SelfCenter(1),
        SelfBegin(2),
        SelfEnd(3);
        
        private static final SparseArray<ArrowPosPolicy> intToTypeDict = null;
        private int mValue;

        /* access modifiers changed from: public */
        static {
            int i11;
            intToTypeDict = new SparseArray<>();
            for (ArrowPosPolicy arrowPosPolicy : values()) {
                intToTypeDict.put(arrowPosPolicy.mValue, arrowPosPolicy);
            }
        }

        private ArrowPosPolicy(int i11) {
            this.mValue = 0;
            this.mValue = i11;
        }

        public int getValue() {
            return this.mValue;
        }

        public static ArrowPosPolicy valueOf(int i11) {
            ArrowPosPolicy arrowPosPolicy = intToTypeDict.get(i11);
            return arrowPosPolicy == null ? TargetCenter : arrowPosPolicy;
        }
    }

    void setArrowDirection(ArrowDirection arrowDirection);

    void setArrowPosDelta(float f11);

    void setArrowPosPolicy(ArrowPosPolicy arrowPosPolicy);

    void setArrowTo(View view);

    void setBorderWidth(float f11);
}
