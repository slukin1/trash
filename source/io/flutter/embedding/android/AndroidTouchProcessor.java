package io.flutter.embedding.android;

import android.graphics.Matrix;
import android.os.Build;
import android.view.InputDevice;
import android.view.MotionEvent;
import io.flutter.embedding.engine.renderer.FlutterRenderer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Map;

public class AndroidTouchProcessor {
    public static final int BYTES_PER_FIELD = 8;
    private static final Matrix IDENTITY_TRANSFORM = new Matrix();
    private static final int POINTER_DATA_FIELD_COUNT = 35;
    private static final int POINTER_DATA_FLAG_BATCHED = 1;
    private final MotionEventTracker motionEventTracker;
    private final Map<Integer, float[]> ongoingPans = new HashMap();
    private final FlutterRenderer renderer;
    private final boolean trackMotionEvents;

    public @interface PointerChange {
        public static final int ADD = 1;
        public static final int CANCEL = 0;
        public static final int DOWN = 4;
        public static final int HOVER = 3;
        public static final int MOVE = 5;
        public static final int PAN_ZOOM_END = 9;
        public static final int PAN_ZOOM_START = 7;
        public static final int PAN_ZOOM_UPDATE = 8;
        public static final int REMOVE = 2;
        public static final int UP = 6;
    }

    public @interface PointerDeviceKind {
        public static final int INVERTED_STYLUS = 3;
        public static final int MOUSE = 1;
        public static final int STYLUS = 2;
        public static final int TOUCH = 0;
        public static final int TRACKPAD = 4;
        public static final int UNKNOWN = 5;
    }

    public @interface PointerSignalKind {
        public static final int NONE = 0;
        public static final int SCALE = 3;
        public static final int SCROLL = 1;
        public static final int SCROLL_INERTIA_CANCEL = 2;
        public static final int UNKNOWN = 4;
    }

    public AndroidTouchProcessor(FlutterRenderer flutterRenderer, boolean z11) {
        this.renderer = flutterRenderer;
        this.motionEventTracker = MotionEventTracker.getInstance();
        this.trackMotionEvents = z11;
    }

    private void addPointerForIndex(MotionEvent motionEvent, int i11, int i12, int i13, Matrix matrix, ByteBuffer byteBuffer) {
        long j11;
        double d11;
        double d12;
        double d13;
        double d14;
        InputDevice.MotionRange motionRange;
        MotionEvent motionEvent2 = motionEvent;
        int i14 = i11;
        int i15 = i12;
        ByteBuffer byteBuffer2 = byteBuffer;
        if (i15 != -1) {
            long id2 = this.trackMotionEvents ? this.motionEventTracker.track(motionEvent2).getId() : 0;
            int pointerDeviceTypeForToolType = getPointerDeviceTypeForToolType(motionEvent.getToolType(i11));
            float[] fArr = {motionEvent.getX(i11), motionEvent.getY(i11)};
            matrix.mapPoints(fArr);
            if (pointerDeviceTypeForToolType == 1) {
                j11 = (long) (motionEvent.getButtonState() & 31);
                if (j11 == 0 && motionEvent.getSource() == 8194 && i15 == 4) {
                    this.ongoingPans.put(Integer.valueOf(motionEvent.getPointerId(i11)), fArr);
                }
            } else {
                j11 = pointerDeviceTypeForToolType == 2 ? (long) ((motionEvent.getButtonState() >> 4) & 15) : 0;
            }
            boolean containsKey = this.ongoingPans.containsKey(Integer.valueOf(motionEvent.getPointerId(i11)));
            int i16 = motionEvent.getActionMasked() == 8 ? 1 : 0;
            byteBuffer2.putLong(id2);
            byteBuffer2.putLong(motionEvent.getEventTime() * 1000);
            if (containsKey) {
                byteBuffer2.putLong((long) getPointerChangeForPanZoom(i15));
                byteBuffer2.putLong(4);
            } else {
                byteBuffer2.putLong((long) i15);
                byteBuffer2.putLong((long) pointerDeviceTypeForToolType);
            }
            byteBuffer2.putLong((long) i16);
            byteBuffer2.putLong((long) motionEvent.getPointerId(i11));
            byteBuffer2.putLong(0);
            if (containsKey) {
                float[] fArr2 = this.ongoingPans.get(Integer.valueOf(motionEvent.getPointerId(i11)));
                byteBuffer2.putDouble((double) fArr2[0]);
                byteBuffer2.putDouble((double) fArr2[1]);
            } else {
                byteBuffer2.putDouble((double) fArr[0]);
                byteBuffer2.putDouble((double) fArr[1]);
            }
            byteBuffer2.putDouble(0.0d);
            byteBuffer2.putDouble(0.0d);
            byteBuffer2.putLong(j11);
            byteBuffer2.putLong(0);
            byteBuffer2.putLong(0);
            byteBuffer2.putDouble((double) motionEvent.getPressure(i11));
            if (motionEvent.getDevice() == null || (motionRange = motionEvent.getDevice().getMotionRange(2)) == null) {
                d12 = 1.0d;
                d11 = 0.0d;
            } else {
                d11 = (double) motionRange.getMin();
                d12 = (double) motionRange.getMax();
            }
            byteBuffer2.putDouble(d11);
            byteBuffer2.putDouble(d12);
            if (pointerDeviceTypeForToolType == 2) {
                byteBuffer2.putDouble((double) motionEvent2.getAxisValue(24, i14));
                d13 = 0.0d;
                byteBuffer2.putDouble(0.0d);
            } else {
                d13 = 0.0d;
                byteBuffer2.putDouble(0.0d);
                byteBuffer2.putDouble(0.0d);
            }
            byteBuffer2.putDouble((double) motionEvent.getSize(i11));
            byteBuffer2.putDouble((double) motionEvent.getToolMajor(i11));
            byteBuffer2.putDouble((double) motionEvent.getToolMinor(i11));
            byteBuffer2.putDouble(d13);
            byteBuffer2.putDouble(d13);
            byteBuffer2.putDouble((double) motionEvent2.getAxisValue(8, i14));
            if (pointerDeviceTypeForToolType == 2) {
                byteBuffer2.putDouble((double) motionEvent2.getAxisValue(25, i14));
            } else {
                byteBuffer2.putDouble(d13);
            }
            byteBuffer2.putLong((long) i13);
            if (i16 == 1) {
                byteBuffer2.putDouble((double) (-motionEvent2.getAxisValue(10)));
                byteBuffer2.putDouble((double) (-motionEvent2.getAxisValue(9)));
            } else {
                byteBuffer2.putDouble(0.0d);
                byteBuffer2.putDouble(0.0d);
            }
            if (containsKey) {
                float[] fArr3 = this.ongoingPans.get(Integer.valueOf(motionEvent.getPointerId(i11)));
                byteBuffer2.putDouble((double) (fArr[0] - fArr3[0]));
                byteBuffer2.putDouble((double) (fArr[1] - fArr3[1]));
                d14 = 0.0d;
            } else {
                d14 = 0.0d;
                byteBuffer2.putDouble(0.0d);
                byteBuffer2.putDouble(0.0d);
            }
            byteBuffer2.putDouble(d14);
            byteBuffer2.putDouble(d14);
            byteBuffer2.putDouble(1.0d);
            byteBuffer2.putDouble(d14);
            if (containsKey && getPointerChangeForPanZoom(i15) == 9) {
                this.ongoingPans.remove(Integer.valueOf(motionEvent.getPointerId(i11)));
            }
        }
    }

    @PointerChange
    private int getPointerChangeForAction(int i11) {
        if (i11 == 0) {
            return 4;
        }
        if (i11 == 1) {
            return 6;
        }
        if (i11 == 5) {
            return 4;
        }
        if (i11 == 6) {
            return 6;
        }
        if (i11 == 2) {
            return 5;
        }
        if (i11 == 7) {
            return 3;
        }
        if (i11 == 3) {
            return 0;
        }
        return i11 == 8 ? 3 : -1;
    }

    @PointerChange
    private int getPointerChangeForPanZoom(int i11) {
        if (i11 == 4) {
            return 7;
        }
        if (i11 == 5) {
            return 8;
        }
        if (i11 == 6 || i11 == 0) {
            return 9;
        }
        throw new AssertionError("Unexpected pointer change");
    }

    @PointerDeviceKind
    private int getPointerDeviceTypeForToolType(int i11) {
        if (i11 == 1) {
            return 0;
        }
        if (i11 == 2) {
            return 2;
        }
        if (i11 != 3) {
            return i11 != 4 ? 5 : 3;
        }
        return 1;
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        boolean z11 = Build.VERSION.SDK_INT >= 18 && motionEvent.isFromSource(2);
        boolean z12 = motionEvent.getActionMasked() == 7 || motionEvent.getActionMasked() == 8;
        if (!z11 || !z12) {
            return false;
        }
        int pointerChangeForAction = getPointerChangeForAction(motionEvent.getActionMasked());
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(motionEvent.getPointerCount() * 35 * 8);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, IDENTITY_TRANSFORM, allocateDirect);
        if (allocateDirect.position() % 280 == 0) {
            this.renderer.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
            return true;
        }
        throw new AssertionError("Packet position is not on field boundary.");
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return onTouchEvent(motionEvent, IDENTITY_TRANSFORM);
    }

    public boolean onTouchEvent(MotionEvent motionEvent, Matrix matrix) {
        int pointerCount = motionEvent.getPointerCount();
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(pointerCount * 35 * 8);
        allocateDirect.order(ByteOrder.LITTLE_ENDIAN);
        int actionMasked = motionEvent.getActionMasked();
        int pointerChangeForAction = getPointerChangeForAction(motionEvent.getActionMasked());
        boolean z11 = actionMasked == 0 || actionMasked == 5;
        boolean z12 = !z11 && (actionMasked == 1 || actionMasked == 6);
        if (z11) {
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, matrix, allocateDirect);
        } else if (z12) {
            for (int i11 = 0; i11 < pointerCount; i11++) {
                if (i11 != motionEvent.getActionIndex() && motionEvent.getToolType(i11) == 1) {
                    addPointerForIndex(motionEvent, i11, 5, 1, matrix, allocateDirect);
                }
            }
            addPointerForIndex(motionEvent, motionEvent.getActionIndex(), pointerChangeForAction, 0, matrix, allocateDirect);
        } else {
            for (int i12 = 0; i12 < pointerCount; i12++) {
                addPointerForIndex(motionEvent, i12, pointerChangeForAction, 0, matrix, allocateDirect);
            }
        }
        if (allocateDirect.position() % 280 == 0) {
            this.renderer.dispatchPointerDataPacket(allocateDirect, allocateDirect.position());
            return true;
        }
        throw new AssertionError("Packet position is not on field boundary");
    }
}
