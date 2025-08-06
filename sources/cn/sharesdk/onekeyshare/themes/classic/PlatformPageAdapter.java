package cn.sharesdk.onekeyshare.themes.classic;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.onekeyshare.CustomerLogo;
import com.mob.tools.gui.ViewPagerAdapter;
import com.mob.tools.utils.ResHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.ArrayList;

public abstract class PlatformPageAdapter extends ViewPagerAdapter implements View.OnClickListener {
    public static final int DESIGN_BOTTOM_HEIGHT = 52;
    public static final int MIN_CLICK_INTERVAL = 1000;
    public int bottomHeight;
    public int cellHeight;
    public Object[][] cells;
    private long lastClickTime;
    public int lineSize;
    public int logoHeight;
    public int paddingTop;
    private PlatformPage page;
    public int panelHeight;
    public int sepLineWidth;
    private IndicatorView vInd;

    public PlatformPageAdapter(PlatformPage platformPage, ArrayList<Object> arrayList) {
        this.page = platformPage;
        if (arrayList != null && !arrayList.isEmpty()) {
            calculateSize(platformPage.getContext(), arrayList);
            collectCells(arrayList);
        }
    }

    private View createPanel(Context context) {
        Context context2 = context;
        LinearLayout linearLayout = new LinearLayout(context2);
        int i11 = 1;
        linearLayout.setOrientation(1);
        linearLayout.setBackgroundColor(-855310);
        int i12 = this.panelHeight / this.cellHeight;
        int i13 = this.lineSize * i12;
        LinearLayout[] linearLayoutArr = new LinearLayout[i13];
        linearLayout.setTag(linearLayoutArr);
        int bitmapRes = ResHelper.getBitmapRes(context2, "ssdk_oks_classic_platform_cell_back");
        int i14 = 0;
        while (i14 < i12) {
            LinearLayout linearLayout2 = new LinearLayout(context2);
            linearLayout.addView(linearLayout2, new LinearLayout.LayoutParams(-1, this.cellHeight));
            int i15 = 0;
            while (true) {
                int i16 = this.lineSize;
                if (i15 >= i16) {
                    break;
                }
                linearLayoutArr[(i16 * i14) + i15] = new LinearLayout(context2);
                linearLayoutArr[(this.lineSize * i14) + i15].setBackgroundResource(bitmapRes);
                linearLayoutArr[(this.lineSize * i14) + i15].setOrientation(i11);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, this.cellHeight);
                layoutParams.weight = 1.0f;
                linearLayout2.addView(linearLayoutArr[(this.lineSize * i14) + i15], layoutParams);
                if (i15 < this.lineSize - i11) {
                    linearLayout2.addView(new View(context2), new LinearLayout.LayoutParams(this.sepLineWidth, -1));
                }
                i15++;
                i11 = 1;
            }
            linearLayout.addView(new View(context2), new LinearLayout.LayoutParams(-1, this.sepLineWidth));
            i14++;
            i11 = 1;
        }
        for (int i17 = 0; i17 < i13; i17++) {
            LinearLayout linearLayout3 = linearLayoutArr[i17];
            ImageView imageView = new ImageView(context2);
            imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, this.logoHeight);
            layoutParams2.topMargin = this.paddingTop;
            linearLayout3.addView(imageView, layoutParams2);
            TextView textView = new TextView(context2);
            textView.setTextColor(-10197916);
            textView.setTextSize(2, 14.0f);
            textView.setGravity(17);
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams3.weight = 1.0f;
            linearLayout3.addView(textView, layoutParams3);
        }
        return linearLayout;
    }

    private void refreshPanel(LinearLayout[] linearLayoutArr, Object[] objArr) {
        int bitmapRes = ResHelper.getBitmapRes(this.page.getContext(), "ssdk_oks_classic_platform_cell_back");
        int bitmapRes2 = ResHelper.getBitmapRes(this.page.getContext(), "ssdk_oks_classic_platfrom_cell_back_nor");
        for (int i11 = 0; i11 < objArr.length; i11++) {
            ImageView imageView = (ImageView) ResHelper.forceCast(linearLayoutArr[i11].getChildAt(0));
            TextView textView = (TextView) ResHelper.forceCast(linearLayoutArr[i11].getChildAt(1));
            if (objArr[i11] == null) {
                imageView.setVisibility(4);
                textView.setVisibility(4);
                linearLayoutArr[i11].setBackgroundResource(bitmapRes2);
                linearLayoutArr[i11].setOnClickListener((View.OnClickListener) null);
            } else {
                imageView.setVisibility(0);
                textView.setVisibility(0);
                imageView.requestLayout();
                textView.requestLayout();
                linearLayoutArr[i11].setBackgroundResource(bitmapRes);
                linearLayoutArr[i11].setOnClickListener(this);
                linearLayoutArr[i11].setTag(objArr[i11]);
                if (objArr[i11] instanceof CustomerLogo) {
                    CustomerLogo customerLogo = (CustomerLogo) ResHelper.forceCast(objArr[i11]);
                    Bitmap bitmap = customerLogo.logo;
                    if (bitmap != null) {
                        imageView.setImageBitmap(bitmap);
                    } else {
                        imageView.setImageBitmap((Bitmap) null);
                    }
                    String str = customerLogo.label;
                    if (str != null) {
                        textView.setText(str);
                    } else {
                        textView.setText("");
                    }
                } else {
                    String lowerCase = ((Platform) ResHelper.forceCast(objArr[i11])).getName().toLowerCase();
                    int bitmapRes3 = ResHelper.getBitmapRes(imageView.getContext(), "ssdk_oks_classic_" + lowerCase);
                    if (bitmapRes3 > 0) {
                        imageView.setImageResource(bitmapRes3);
                    } else {
                        imageView.setImageBitmap((Bitmap) null);
                    }
                    int stringRes = ResHelper.getStringRes(textView.getContext(), "ssdk_" + lowerCase);
                    if (stringRes > 0) {
                        textView.setText(stringRes);
                    } else {
                        textView.setText("");
                    }
                }
            }
        }
    }

    public abstract void calculateSize(Context context, ArrayList<Object> arrayList);

    public abstract void collectCells(ArrayList<Object> arrayList);

    public int getBottomHeight() {
        return this.bottomHeight;
    }

    public int getCount() {
        Object[][] objArr = this.cells;
        if (objArr == null) {
            return 0;
        }
        return objArr.length;
    }

    public int getPanelHeight() {
        return this.panelHeight;
    }

    public View getView(int i11, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = createPanel(viewGroup.getContext());
        }
        refreshPanel((LinearLayout[]) ResHelper.forceCast(((LinearLayout) ResHelper.forceCast(view)).getTag()), this.cells[i11]);
        return view;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTime < 1000) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        this.lastClickTime = currentTimeMillis;
        if (view.getTag() instanceof CustomerLogo) {
            this.page.performCustomLogoClick(view, (CustomerLogo) ResHelper.forceCast(view.getTag()));
        } else {
            this.page.showEditPage((Platform) ResHelper.forceCast(view.getTag()));
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onScreenChange(int i11, int i12) {
        IndicatorView indicatorView = this.vInd;
        if (indicatorView != null) {
            indicatorView.setScreenCount(getCount());
            this.vInd.onScreenChange(i11, i12);
        }
    }

    public void setIndicator(IndicatorView indicatorView) {
        this.vInd = indicatorView;
    }
}
