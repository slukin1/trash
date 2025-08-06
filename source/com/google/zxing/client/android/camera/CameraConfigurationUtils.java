package com.google.zxing.client.android.camera;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import okhttp3.HttpUrl;

@TargetApi(15)
public final class CameraConfigurationUtils {
    private static final int AREA_PER_1000 = 400;
    private static final double MAX_ASPECT_DISTORTION = 0.15d;
    private static final float MAX_EXPOSURE_COMPENSATION = 1.5f;
    private static final int MAX_FPS = 20;
    private static final float MIN_EXPOSURE_COMPENSATION = 0.0f;
    private static final int MIN_FPS = 10;
    private static final int MIN_PREVIEW_PIXELS = 153600;
    private static final Pattern SEMICOLON = Pattern.compile(";");
    private static final String TAG = "CameraConfiguration";

    private CameraConfigurationUtils() {
    }

    private static List<Camera.Area> buildMiddleArea(int i11) {
        int i12 = -i11;
        return Collections.singletonList(new Camera.Area(new Rect(i12, i12, i11, i11), 1));
    }

    public static String collectStats(Camera.Parameters parameters) {
        return collectStats((CharSequence) parameters.flatten());
    }

    public static Point findBestPreviewSizeValue(Camera.Parameters parameters, Point point) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        if (supportedPreviewSizes == null) {
            Log.w(TAG, "Device returned no supported preview sizes; using default");
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                return new Point(previewSize.width, previewSize.height);
            }
            throw new IllegalStateException("Parameters contained no preview size!");
        }
        ArrayList<Camera.Size> arrayList = new ArrayList<>(supportedPreviewSizes);
        Collections.sort(arrayList, new Comparator<Camera.Size>() {
            public int compare(Camera.Size size, Camera.Size size2) {
                int i11 = size.height * size.width;
                int i12 = size2.height * size2.width;
                if (i12 < i11) {
                    return -1;
                }
                return i12 > i11 ? 1 : 0;
            }
        });
        if (Log.isLoggable(TAG, 4)) {
            StringBuilder sb2 = new StringBuilder();
            for (Camera.Size size : arrayList) {
                sb2.append(size.width);
                sb2.append('x');
                sb2.append(size.height);
                sb2.append(' ');
            }
            Log.i(TAG, "Supported preview sizes: " + sb2);
        }
        double d11 = ((double) point.x) / ((double) point.y);
        Iterator it2 = arrayList.iterator();
        while (true) {
            boolean z11 = false;
            if (it2.hasNext()) {
                Camera.Size size2 = (Camera.Size) it2.next();
                int i11 = size2.width;
                int i12 = size2.height;
                if (i11 * i12 < MIN_PREVIEW_PIXELS) {
                    it2.remove();
                } else {
                    if (i11 < i12) {
                        z11 = true;
                    }
                    int i13 = z11 ? i12 : i11;
                    int i14 = z11 ? i11 : i12;
                    if (Math.abs((((double) i13) / ((double) i14)) - d11) > MAX_ASPECT_DISTORTION) {
                        it2.remove();
                    } else if (i13 == point.x && i14 == point.y) {
                        Point point2 = new Point(i11, i12);
                        Log.i(TAG, "Found preview size exactly matching screen size: " + point2);
                        return point2;
                    }
                }
            } else if (!arrayList.isEmpty()) {
                Camera.Size size3 = (Camera.Size) arrayList.get(0);
                Point point3 = new Point(size3.width, size3.height);
                Log.i(TAG, "Using largest suitable preview size: " + point3);
                return point3;
            } else {
                Camera.Size previewSize2 = parameters.getPreviewSize();
                if (previewSize2 != null) {
                    Point point4 = new Point(previewSize2.width, previewSize2.height);
                    Log.i(TAG, "No suitable preview sizes, using default: " + point4);
                    return point4;
                }
                throw new IllegalStateException("Parameters contained no preview size!");
            }
        }
    }

    private static String findSettableValue(String str, Collection<String> collection, String... strArr) {
        Log.i(TAG, "Requesting " + str + " value from among: " + Arrays.toString(strArr));
        Log.i(TAG, "Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    Log.i(TAG, "Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        Log.i(TAG, "No supported values match");
        return null;
    }

    private static Integer indexOfClosestZoom(Camera.Parameters parameters, double d11) {
        List<Integer> zoomRatios = parameters.getZoomRatios();
        Log.i(TAG, "Zoom ratios: " + zoomRatios);
        int maxZoom = parameters.getMaxZoom();
        if (zoomRatios == null || zoomRatios.isEmpty() || zoomRatios.size() != maxZoom + 1) {
            Log.w(TAG, "Invalid zoom ratios!");
            return null;
        }
        double d12 = d11 * 100.0d;
        double d13 = Double.POSITIVE_INFINITY;
        int i11 = 0;
        for (int i12 = 0; i12 < zoomRatios.size(); i12++) {
            double abs = Math.abs(((double) zoomRatios.get(i12).intValue()) - d12);
            if (abs < d13) {
                i11 = i12;
                d13 = abs;
            }
        }
        Log.i(TAG, "Chose zoom ratio of " + (((double) zoomRatios.get(i11).intValue()) / 100.0d));
        return Integer.valueOf(i11);
    }

    public static void setBarcodeSceneMode(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            Log.i(TAG, "Barcode scene mode already set");
            return;
        }
        String findSettableValue = findSettableValue("scene mode", parameters.getSupportedSceneModes(), "barcode");
        if (findSettableValue != null) {
            parameters.setSceneMode(findSettableValue);
        }
    }

    public static void setBestExposure(Camera.Parameters parameters, boolean z11) {
        int minExposureCompensation = parameters.getMinExposureCompensation();
        int maxExposureCompensation = parameters.getMaxExposureCompensation();
        float exposureCompensationStep = parameters.getExposureCompensationStep();
        if (!(minExposureCompensation == 0 && maxExposureCompensation == 0)) {
            float f11 = 0.0f;
            if (exposureCompensationStep > 0.0f) {
                if (!z11) {
                    f11 = 1.5f;
                }
                int round = Math.round(f11 / exposureCompensationStep);
                float f12 = exposureCompensationStep * ((float) round);
                int max = Math.max(Math.min(round, maxExposureCompensation), minExposureCompensation);
                if (parameters.getExposureCompensation() == max) {
                    Log.i(TAG, "Exposure compensation already set to " + max + " / " + f12);
                    return;
                }
                Log.i(TAG, "Setting exposure compensation to " + max + " / " + f12);
                parameters.setExposureCompensation(max);
                return;
            }
        }
        Log.i(TAG, "Camera does not support exposure compensation");
    }

    public static void setBestPreviewFPS(Camera.Parameters parameters) {
        setBestPreviewFPS(parameters, 10, 20);
    }

    public static void setFocus(Camera.Parameters parameters, boolean z11, boolean z12, boolean z13) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String findSettableValue = z11 ? (z13 || z12) ? findSettableValue("focus mode", supportedFocusModes, TtmlNode.TEXT_EMPHASIS_AUTO) : findSettableValue("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", TtmlNode.TEXT_EMPHASIS_AUTO) : null;
        if (!z13 && findSettableValue == null) {
            findSettableValue = findSettableValue("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (findSettableValue == null) {
            return;
        }
        if (findSettableValue.equals(parameters.getFocusMode())) {
            Log.i(TAG, "Focus mode already set to " + findSettableValue);
            return;
        }
        parameters.setFocusMode(findSettableValue);
    }

    public static void setFocusArea(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() > 0) {
            Log.i(TAG, "Old focus areas: " + toString((Iterable<Camera.Area>) parameters.getFocusAreas()));
            List<Camera.Area> buildMiddleArea = buildMiddleArea(400);
            Log.i(TAG, "Setting focus area to : " + toString((Iterable<Camera.Area>) buildMiddleArea));
            parameters.setFocusAreas(buildMiddleArea);
            return;
        }
        Log.i(TAG, "Device does not support focus areas");
    }

    public static void setInvertColor(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            Log.i(TAG, "Negative effect already set");
            return;
        }
        String findSettableValue = findSettableValue("color effect", parameters.getSupportedColorEffects(), "negative");
        if (findSettableValue != null) {
            parameters.setColorEffect(findSettableValue);
        }
    }

    public static void setMetering(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() > 0) {
            Log.i(TAG, "Old metering areas: " + parameters.getMeteringAreas());
            List<Camera.Area> buildMiddleArea = buildMiddleArea(400);
            Log.i(TAG, "Setting metering area to : " + toString((Iterable<Camera.Area>) buildMiddleArea));
            parameters.setMeteringAreas(buildMiddleArea);
            return;
        }
        Log.i(TAG, "Device does not support metering areas");
    }

    public static void setTorch(Camera.Parameters parameters, boolean z11) {
        String str;
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        if (z11) {
            str = findSettableValue("flash mode", supportedFlashModes, "torch", "on");
        } else {
            str = findSettableValue("flash mode", supportedFlashModes, "off");
        }
        if (str == null) {
            return;
        }
        if (str.equals(parameters.getFlashMode())) {
            Log.i(TAG, "Flash mode already set to " + str);
            return;
        }
        Log.i(TAG, "Setting flash mode to " + str);
        parameters.setFlashMode(str);
    }

    public static void setVideoStabilization(Camera.Parameters parameters) {
        if (!parameters.isVideoStabilizationSupported()) {
            Log.i(TAG, "This device does not support video stabilization");
        } else if (parameters.getVideoStabilization()) {
            Log.i(TAG, "Video stabilization already enabled");
        } else {
            Log.i(TAG, "Enabling video stabilization...");
            parameters.setVideoStabilization(true);
        }
    }

    public static void setZoom(Camera.Parameters parameters, double d11) {
        if (parameters.isZoomSupported()) {
            Integer indexOfClosestZoom = indexOfClosestZoom(parameters, d11);
            if (indexOfClosestZoom != null) {
                if (parameters.getZoom() == indexOfClosestZoom.intValue()) {
                    Log.i(TAG, "Zoom is already set to " + indexOfClosestZoom);
                    return;
                }
                Log.i(TAG, "Setting zoom to " + indexOfClosestZoom);
                parameters.setZoom(indexOfClosestZoom.intValue());
                return;
            }
            return;
        }
        Log.i(TAG, "Zoom is not supported");
    }

    private static String toString(Collection<int[]> collection) {
        if (collection == null || collection.isEmpty()) {
            return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append('[');
        Iterator<int[]> it2 = collection.iterator();
        while (it2.hasNext()) {
            sb2.append(Arrays.toString(it2.next()));
            if (it2.hasNext()) {
                sb2.append(", ");
            }
        }
        sb2.append(']');
        return sb2.toString();
    }

    public static String collectStats(CharSequence charSequence) {
        StringBuilder sb2 = new StringBuilder(1000);
        sb2.append("BOARD=");
        sb2.append(Build.BOARD);
        sb2.append(10);
        sb2.append("BRAND=");
        sb2.append(Build.BRAND);
        sb2.append(10);
        sb2.append("CPU_ABI=");
        sb2.append(Build.CPU_ABI);
        sb2.append(10);
        sb2.append("DEVICE=");
        sb2.append(Build.DEVICE);
        sb2.append(10);
        sb2.append("DISPLAY=");
        sb2.append(Build.DISPLAY);
        sb2.append(10);
        sb2.append("FINGERPRINT=");
        sb2.append(Build.FINGERPRINT);
        sb2.append(10);
        sb2.append("HOST=");
        sb2.append(Build.HOST);
        sb2.append(10);
        sb2.append("ID=");
        sb2.append(Build.ID);
        sb2.append(10);
        sb2.append("MANUFACTURER=");
        sb2.append(Build.MANUFACTURER);
        sb2.append(10);
        sb2.append("MODEL=");
        sb2.append(Build.MODEL);
        sb2.append(10);
        sb2.append("PRODUCT=");
        sb2.append(Build.PRODUCT);
        sb2.append(10);
        sb2.append("TAGS=");
        sb2.append(Build.TAGS);
        sb2.append(10);
        sb2.append("TIME=");
        sb2.append(Build.TIME);
        sb2.append(10);
        sb2.append("TYPE=");
        sb2.append(Build.TYPE);
        sb2.append(10);
        sb2.append("USER=");
        sb2.append(Build.USER);
        sb2.append(10);
        sb2.append("VERSION.CODENAME=");
        sb2.append(Build.VERSION.CODENAME);
        sb2.append(10);
        sb2.append("VERSION.INCREMENTAL=");
        sb2.append(Build.VERSION.INCREMENTAL);
        sb2.append(10);
        sb2.append("VERSION.RELEASE=");
        sb2.append(Build.VERSION.RELEASE);
        sb2.append(10);
        sb2.append("VERSION.SDK_INT=");
        sb2.append(Build.VERSION.SDK_INT);
        sb2.append(10);
        if (charSequence != null) {
            String[] split = SEMICOLON.split(charSequence);
            Arrays.sort(split);
            for (String append : split) {
                sb2.append(append);
                sb2.append(10);
            }
        }
        return sb2.toString();
    }

    public static void setBestPreviewFPS(Camera.Parameters parameters, int i11, int i12) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        Log.i(TAG, "Supported FPS ranges: " + toString((Collection<int[]>) supportedPreviewFpsRange));
        if (supportedPreviewFpsRange != null && !supportedPreviewFpsRange.isEmpty()) {
            int[] iArr = null;
            Iterator<int[]> it2 = supportedPreviewFpsRange.iterator();
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                int[] next = it2.next();
                int i13 = next[0];
                int i14 = next[1];
                if (i13 >= i11 * 1000 && i14 <= i12 * 1000) {
                    iArr = next;
                    break;
                }
            }
            if (iArr == null) {
                Log.i(TAG, "No suitable FPS range?");
                return;
            }
            int[] iArr2 = new int[2];
            parameters.getPreviewFpsRange(iArr2);
            if (Arrays.equals(iArr2, iArr)) {
                Log.i(TAG, "FPS range already set to " + Arrays.toString(iArr));
                return;
            }
            Log.i(TAG, "Setting FPS range to " + Arrays.toString(iArr));
            parameters.setPreviewFpsRange(iArr[0], iArr[1]);
        }
    }

    private static String toString(Iterable<Camera.Area> iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (Camera.Area next : iterable) {
            sb2.append(next.rect);
            sb2.append(':');
            sb2.append(next.weight);
            sb2.append(' ');
        }
        return sb2.toString();
    }
}
