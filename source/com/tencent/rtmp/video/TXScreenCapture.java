package com.tencent.rtmp.video;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.material.badge.BadgeDrawable;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.tencent.liteav.base.system.LiteavSystemInfo;
import com.tencent.liteav.base.util.LiteavLog;
import com.tencent.liteav.videoproducer.capture.VirtualDisplayManager;

public class TXScreenCapture {

    public static class TXScreenCaptureAssistantActivity extends Activity {
        private static final int REQUEST_CODE = 100;
        private static final String TAG = "TXScreenCaptureAssistantActivity";
        private MediaProjectionManager mMediaProjectionManager;

        private void createOnePixelActivity() {
            Window window = getWindow();
            window.setGravity(BadgeDrawable.TOP_START);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.x = 0;
            attributes.y = 0;
            attributes.height = 1;
            attributes.width = 1;
            window.setAttributes(attributes);
        }

        public void onActivityResult(int i11, int i12, Intent intent) {
            LiteavLog.i(TAG, "onActivityResult " + this + ", resultCode:" + i12 + ", data:" + intent);
            MediaProjection mediaProjection = null;
            if (intent == null) {
                VirtualDisplayManager.a((Context) this).a((MediaProjection) null);
                finish();
                return;
            }
            if (LiteavSystemInfo.getSystemOSVersionInt() >= 26) {
                LiteavLog.i(TAG, "startForegroundService");
                Intent intent2 = new Intent(this, ScreenCaptureService.class);
                intent2.putExtra("code", i12);
                intent2.putExtra("data", intent);
                startForegroundService(intent2);
            } else {
                try {
                    mediaProjection = this.mMediaProjectionManager.getMediaProjection(i12, intent);
                } catch (Throwable th2) {
                    LiteavLog.e(TAG, "onActivityResult mMediaProjectionManager.getMediaProjection fail.", th2);
                }
                LiteavLog.i(TAG, "ProjectionManger get mediaProjection:".concat(String.valueOf(mediaProjection)));
                VirtualDisplayManager.a((Context) this).a(mediaProjection);
            }
            finish();
        }

        public void onCreate(Bundle bundle) {
            super.onCreate(bundle);
            LiteavLog.i(TAG, "onCreate ".concat(String.valueOf(this)));
            requestWindowFeature(1);
            createOnePixelActivity();
            MediaProjectionManager mediaProjectionManager = (MediaProjectionManager) getSystemService("media_projection");
            this.mMediaProjectionManager = mediaProjectionManager;
            try {
                startActivityForResult(mediaProjectionManager.createScreenCaptureIntent(), 100);
            } catch (Throwable th2) {
                LiteavLog.e(TAG, "Start permission activity failed. ".concat(String.valueOf(th2)));
                VirtualDisplayManager.a((Context) this).a((MediaProjection) null);
                finish();
            }
        }

        public void onDestroy() {
            super.onDestroy();
            LiteavLog.i(TAG, "onDestroy ".concat(String.valueOf(this)));
        }

        @SensorsDataInstrumented
        public void onNewIntent(Intent intent) {
            super.onNewIntent(intent);
            PushAutoTrackHelper.onNewIntent(this, intent);
        }
    }
}
