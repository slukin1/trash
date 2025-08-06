package com.huobi.share.helper;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.huobi.contract.entity.ContractPosition;
import com.huobi.share.fragment.ContractSimpleShareView;
import com.huobi.sharev2.manager.ShareManager;
import java.util.ArrayList;
import mr.a;
import mr.b;
import org.json.JSONException;
import org.json.JSONObject;

public class CaptureShareHelper {

    public enum ContractType {
        Contract,
        LinearSwap,
        Swap
    }

    public static /* synthetic */ void c(ArrayList arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("shareChannel", 5);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        ShareManager.getInstance().newShareWithImages(arrayList, true, false, "contract_share[14]", jSONObject.toString());
    }

    public static /* synthetic */ void d(ArrayList arrayList) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("shareChannel", 5);
        } catch (JSONException e11) {
            e11.printStackTrace();
        }
        ShareManager.getInstance().newShareWithImages(arrayList, true, false, "contract_share[14]", jSONObject.toString());
    }

    public static Bitmap e(View view) {
        if (view == null || view.getWidth() == 0 || view.getHeight() == 0) {
            return null;
        }
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        view.setDrawingCacheEnabled(true);
        Bitmap drawingCache = view.getDrawingCache();
        Bitmap createBitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_4444);
        new Canvas(createBitmap).drawBitmap(drawingCache, 0.0f, 0.0f, paint);
        view.setDrawingCacheEnabled(false);
        return createBitmap;
    }

    public static Bitmap f(View view) {
        if (view == null || view.getContext() == null) {
            return null;
        }
        view.setDrawingCacheEnabled(true);
        view.buildDrawingCache();
        if (Build.VERSION.SDK_INT >= 11) {
            view.measure(View.MeasureSpec.makeMeasureSpec(view.getWidth(), 1073741824), View.MeasureSpec.makeMeasureSpec(view.getHeight(), 1073741824));
            view.layout((int) view.getX(), (int) view.getY(), ((int) view.getX()) + view.getMeasuredWidth(), ((int) view.getY()) + view.getMeasuredHeight());
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        }
        Bitmap createBitmap = Bitmap.createBitmap(view.getDrawingCache(), 0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
        view.setDrawingCacheEnabled(false);
        view.destroyDrawingCache();
        return createBitmap;
    }

    public static void g(AppCompatActivity appCompatActivity, ContractPosition contractPosition, ContractType contractType) {
        ContractSimpleShareView contractSimpleShareView = new ContractSimpleShareView(appCompatActivity);
        contractSimpleShareView.d(contractPosition, contractType);
        contractSimpleShareView.a(a.f58249a);
    }

    public static void h(Activity activity, String str, String str2, String str3, String str4, String str5, boolean z11, int i11) {
        Activity activity2 = activity;
        ContractSimpleShareView contractSimpleShareView = new ContractSimpleShareView(activity);
        contractSimpleShareView.c(str, str2, str3, str4, str5, Boolean.valueOf(z11), Integer.valueOf(i11));
        contractSimpleShareView.a(b.f58250a);
    }
}
