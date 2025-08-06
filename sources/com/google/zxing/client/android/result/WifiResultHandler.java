package com.google.zxing.client.android.result;

import android.app.Activity;
import android.net.wifi.WifiManager;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import com.google.zxing.client.android.CaptureActivity;
import com.google.zxing.client.android.wifi.WifiConfigManager;
import com.google.zxing.client.result.ParsedResult;
import com.google.zxing.client.result.WifiParsedResult;
import pro.huobi.R;

public final class WifiResultHandler extends ResultHandler {
    private static final String TAG = "WifiResultHandler";
    private final CaptureActivity parent;

    public WifiResultHandler(CaptureActivity captureActivity, ParsedResult parsedResult) {
        super(captureActivity, parsedResult);
        this.parent = captureActivity;
    }

    public int getButtonCount() {
        return 1;
    }

    public int getButtonText(int i11) {
        return R.string.button_wifi;
    }

    public CharSequence getDisplayContents() {
        WifiParsedResult wifiParsedResult = (WifiParsedResult) getResult();
        return wifiParsedResult.getSsid() + " (" + wifiParsedResult.getNetworkEncryption() + ')';
    }

    public int getDisplayTitle() {
        return R.string.result_wifi;
    }

    public void handleButtonPress(int i11) {
        if (i11 == 0) {
            WifiParsedResult wifiParsedResult = (WifiParsedResult) getResult();
            WifiManager wifiManager = (WifiManager) getActivity().getApplicationContext().getSystemService("wifi");
            if (wifiManager == null) {
                Log.w(TAG, "No WifiManager available from device");
                return;
            }
            final Activity activity = getActivity();
            activity.runOnUiThread(new Runnable() {
                public void run() {
                    Toast.makeText(activity.getApplicationContext(), R.string.wifi_changing_network, 0).show();
                }
            });
            new WifiConfigManager(wifiManager).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new WifiParsedResult[]{wifiParsedResult});
            this.parent.restartPreviewAfterDelay(0);
        }
    }
}
