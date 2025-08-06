package com.google.zxing.client.android;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.widget.Toolbar;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.DecodeHintType;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.client.android.Intents;
import com.google.zxing.client.android.camera.CameraManager;
import com.google.zxing.client.android.utils.CodeUtils;
import com.google.zxing.client.android.utils.ImageUtil;
import com.hbg.lib.core.ui.EmptyMVPActivity;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.luck.picture.lib.config.SelectMimeType;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import gs.g;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import pro.huobi.R;

public final class CaptureActivity extends EmptyMVPActivity implements SurfaceHolder.Callback {
    public static final String PARAM_HINT_TEXT = "HINT_TEXT";
    public static final int REQUEST_IMAGE = 112;
    public static final String RESULT_STRING = "result_string";
    private static final String TAG = CaptureActivity.class.getSimpleName();
    private static final String[] ZXING_URLS = {"http://zxing.appspot.com/scan", "zxing://scan/"};
    private AmbientLightManager ambientLightManager;
    private CameraManager cameraManager;
    private Toolbar captureToolbar;
    private String characterSet;
    private Collection<BarcodeFormat> decodeFormats;
    private Map<DecodeHintType, ?> decodeHints;
    private CaptureActivityHandler handler;
    private boolean hasSurface;
    private ImageView importTv;
    private InactivityTimer inactivityTimer;
    private Result savedResultToShow;
    private ViewfinderView viewfinderView;

    private void decodeOrStoreSavedBitmap(Result result) {
        CaptureActivityHandler captureActivityHandler = this.handler;
        if (captureActivityHandler == null) {
            this.savedResultToShow = result;
            return;
        }
        if (result != null) {
            this.savedResultToShow = result;
        }
        Result result2 = this.savedResultToShow;
        if (result2 != null) {
            this.handler.sendMessage(Message.obtain(captureActivityHandler, R.id.decode_succeeded, result2));
        }
        this.savedResultToShow = null;
    }

    private void displayFrameworkBugMessageAndExit() {
        HBDialogFragment j02 = new DialogUtils.b.d(this).C0(getString(R.string.app_name)).R0(getString(R.string.msg_camera_framework_bug)).T0(true).P0(getString(R.string.button_ok)).s0(getString(R.string.button_cancel)).Q0(new c(this)).n0(true).N0(new b(this)).j0();
        j02.vh(new FinishListener(this));
        j02.show(getSupportFragmentManager(), "");
    }

    private static void drawLine(Canvas canvas, Paint paint, ResultPoint resultPoint, ResultPoint resultPoint2, float f11) {
        if (resultPoint != null && resultPoint2 != null) {
            canvas.drawLine(f11 * resultPoint.getX(), f11 * resultPoint.getY(), f11 * resultPoint2.getX(), f11 * resultPoint2.getY(), paint);
        }
    }

    private void drawResultPoints(Bitmap bitmap, float f11, Result result) {
        ResultPoint[] resultPoints = result.getResultPoints();
        if (resultPoints != null && resultPoints.length > 0) {
            Canvas canvas = new Canvas(bitmap);
            Paint paint = new Paint();
            paint.setColor(getResources().getColor(R.color.result_points));
            if (resultPoints.length == 2) {
                paint.setStrokeWidth(4.0f);
                drawLine(canvas, paint, resultPoints[0], resultPoints[1], f11);
            } else if (resultPoints.length == 4 && (result.getBarcodeFormat() == BarcodeFormat.UPC_A || result.getBarcodeFormat() == BarcodeFormat.EAN_13)) {
                drawLine(canvas, paint, resultPoints[0], resultPoints[1], f11);
                drawLine(canvas, paint, resultPoints[2], resultPoints[3], f11);
            } else {
                paint.setStrokeWidth(10.0f);
                for (ResultPoint resultPoint : resultPoints) {
                    if (resultPoint != null) {
                        canvas.drawPoint(resultPoint.getX() * f11, resultPoint.getY() * f11, paint);
                    }
                }
            }
        }
    }

    private void handleDecodeInternally(Result result) {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        bundle.putString("result_string", result.getText());
        intent.putExtras(bundle);
        setResult(-1, intent);
        finish();
    }

    private void initCamera(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalStateException("No SurfaceHolder provided");
        } else if (this.cameraManager.isOpen()) {
            Log.w(TAG, "initCamera() while already open -- late SurfaceView callback?");
        } else {
            try {
                this.cameraManager.openDriver(surfaceHolder);
                if (this.handler == null) {
                    this.handler = new CaptureActivityHandler(this, this.decodeFormats, this.decodeHints, this.characterSet, this.cameraManager);
                }
                decodeOrStoreSavedBitmap((Result) null);
            } catch (IOException e11) {
                Log.w(TAG, e11);
                displayFrameworkBugMessageAndExit();
            } catch (RuntimeException e12) {
                Log.w(TAG, "Unexpected error initializing camera", e12);
                displayFrameworkBugMessageAndExit();
            }
        }
    }

    private static boolean isZXingURL(String str) {
        if (str == null) {
            return false;
        }
        for (String startsWith : ZXING_URLS) {
            if (str.startsWith(startsWith)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void lambda$addEvent$0(View view) {
        Intent intent = new Intent();
        intent.setAction("android.intent.action.PICK");
        intent.setType(SelectMimeType.SYSTEM_IMAGE);
        startActivityForResult(intent, 112);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$displayFrameworkBugMessageAndExit$1(HBDialogFragment hBDialogFragment) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$displayFrameworkBugMessageAndExit$2(HBDialogFragment hBDialogFragment) {
        finish();
    }

    private void resetStatusView() {
        this.viewfinderView.setVisibility(0);
    }

    public void addEvent() {
        super.addEvent();
        this.importTv.setOnClickListener(new a(this));
    }

    public boolean canFullScreen() {
        return false;
    }

    public void drawViewfinder() {
        this.viewfinderView.drawViewfinder();
    }

    public CameraManager getCameraManager() {
        return this.cameraManager;
    }

    public int getContentView() {
        return R.layout.capture;
    }

    public Handler getHandler() {
        return this.handler;
    }

    public ViewfinderView getViewfinderView() {
        return this.viewfinderView;
    }

    public void handleDecode(Result result, Bitmap bitmap, float f11) {
        this.inactivityTimer.onActivity();
        if (bitmap != null) {
            drawResultPoints(bitmap, f11, result);
        }
        handleDecodeInternally(result);
    }

    public void initView() {
        super.initView();
        this.captureToolbar = (Toolbar) this.viewFinder.b(R.id.capture_toolbar);
        this.hasSurface = false;
        this.inactivityTimer = new InactivityTimer(this);
        this.ambientLightManager = new AmbientLightManager(this);
        this.importTv = (ImageView) this.viewFinder.b(R.id.import_tv);
        setToolBar(this.captureToolbar, "", true);
    }

    public void onActivityResult(int i11, int i12, Intent intent) {
        if (i11 == 112 && intent != null) {
            try {
                Result analyzeBitmap = CodeUtils.analyzeBitmap(ImageUtil.getImageAbsolutePath(this, intent.getData()));
                if (analyzeBitmap == null) {
                    HuobiToastUtil.j(R.string.scan_qr_error);
                } else {
                    decodeOrStoreSavedBitmap(analyzeBitmap);
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
    }

    public void onDestroy() {
        this.inactivityTimer.shutdown();
        super.onDestroy();
    }

    public boolean onKeyDown(int i11, KeyEvent keyEvent) {
        if (i11 != 4) {
            if (!(i11 == 27 || i11 == 80)) {
                if (i11 == 24) {
                    this.cameraManager.setTorch(true);
                } else if (i11 != 25) {
                    return super.onKeyDown(i11, keyEvent);
                } else {
                    this.cameraManager.setTorch(false);
                    return true;
                }
            }
            return true;
        }
        setResult(0);
        finish();
        return super.onKeyDown(i11, keyEvent);
    }

    public void onPause() {
        CaptureActivityHandler captureActivityHandler = this.handler;
        if (captureActivityHandler != null) {
            captureActivityHandler.quitSynchronously();
            this.handler = null;
        }
        this.inactivityTimer.onPause();
        this.ambientLightManager.stop();
        this.cameraManager.closeDriver();
        if (!this.hasSurface) {
            ((SurfaceView) findViewById(R.id.preview_view)).getHolder().removeCallback(this);
        }
        super.onPause();
    }

    public void onResume() {
        int intExtra;
        super.onResume();
        this.cameraManager = new CameraManager(getApplication());
        ViewfinderView viewfinderView2 = (ViewfinderView) findViewById(R.id.viewfinder_view);
        this.viewfinderView = viewfinderView2;
        viewfinderView2.setCameraManager(this.cameraManager);
        String stringExtra = getIntent().getStringExtra(PARAM_HINT_TEXT);
        if (stringExtra != null) {
            this.viewfinderView.setTextHint(stringExtra);
        }
        this.handler = null;
        resetStatusView();
        this.ambientLightManager.start(this.cameraManager);
        this.inactivityTimer.onResume();
        Intent intent = getIntent();
        this.decodeFormats = null;
        this.characterSet = null;
        if (intent != null) {
            String action = intent.getAction();
            String dataString = intent.getDataString();
            if (Intents.Scan.ACTION.equals(action)) {
                this.decodeFormats = DecodeFormatManager.parseDecodeFormats(intent);
                this.decodeHints = DecodeHintManager.parseDecodeHints(intent);
                if (intent.hasExtra(Intents.Scan.WIDTH) && intent.hasExtra(Intents.Scan.HEIGHT)) {
                    int intExtra2 = intent.getIntExtra(Intents.Scan.WIDTH, 0);
                    int intExtra3 = intent.getIntExtra(Intents.Scan.HEIGHT, 0);
                    if (intExtra2 > 0 && intExtra3 > 0) {
                        this.cameraManager.setManualFramingRect(intExtra2, intExtra3);
                    }
                }
                if (intent.hasExtra(Intents.Scan.CAMERA_ID) && (intExtra = intent.getIntExtra(Intents.Scan.CAMERA_ID, -1)) >= 0) {
                    this.cameraManager.setManualCameraId(intExtra);
                }
            } else if (dataString != null && dataString.contains("http://www.google") && dataString.contains("/m/products/scan")) {
                this.decodeFormats = DecodeFormatManager.PRODUCT_FORMATS;
            } else if (isZXingURL(dataString)) {
                Uri parse = Uri.parse(dataString);
                this.decodeFormats = DecodeFormatManager.parseDecodeFormats(parse);
                this.decodeHints = DecodeHintManager.parseDecodeHints(parse);
            }
            this.characterSet = intent.getStringExtra(Intents.Scan.CHARACTER_SET);
        }
        SurfaceHolder holder = ((SurfaceView) findViewById(R.id.preview_view)).getHolder();
        if (this.hasSurface) {
            initCamera(holder);
        } else {
            holder.addCallback(this);
        }
        g.i("App_scan_view", (HashMap) null);
    }

    public void restartPreviewAfterDelay(long j11) {
        CaptureActivityHandler captureActivityHandler = this.handler;
        if (captureActivityHandler != null) {
            captureActivityHandler.sendEmptyMessageDelayed(R.id.restart_preview, j11);
        }
        resetStatusView();
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i11, int i12, int i13) {
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            Log.e(TAG, "*** WARNING *** surfaceCreated() gave us a null surface!");
        }
        if (!this.hasSurface) {
            this.hasSurface = true;
            initCamera(surfaceHolder);
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.hasSurface = false;
    }
}
