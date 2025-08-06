package com.huobi.view.wheelpicker;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.huobi.view.wheelpicker.WheelView;
import java.util.ArrayList;
import java.util.List;

public class LinkagePicker extends WheelPicker {
    private double firstColumnWeight;
    public String firstLabel;
    private OnLinkageListener onLinkageListener;
    /* access modifiers changed from: private */
    public OnWheelListener onWheelListener;
    public DataProvider provider;
    private double secondColumnWeight;
    public String secondLabel;
    public int selectedFirstIndex;
    public String selectedFirstItem;
    public int selectedSecondIndex;
    public String selectedSecondItem;
    public int selectedThirdIndex;
    public String selectedThirdItem;
    private double thirdColumnWeight;
    public String thirdLabel;

    public interface DataProvider {
        boolean isOnlyTwo();

        List<String> provideFirstData();

        List<String> provideSecondData(int i11);

        List<String> provideThirdData(int i11, int i12);
    }

    public static class DefaultDataProvider implements DataProvider {
        private ArrayList<String> firstList = new ArrayList<>();
        private boolean onlyTwo = false;
        private ArrayList<ArrayList<String>> secondList = new ArrayList<>();
        private ArrayList<ArrayList<ArrayList<String>>> thirdList = new ArrayList<>();

        public DefaultDataProvider(ArrayList<String> arrayList, ArrayList<ArrayList<String>> arrayList2, ArrayList<ArrayList<ArrayList<String>>> arrayList3) {
            this.firstList = arrayList;
            this.secondList = arrayList2;
            if (arrayList3 == null || arrayList3.size() == 0) {
                this.onlyTwo = true;
            } else {
                this.thirdList = arrayList3;
            }
        }

        public boolean isOnlyTwo() {
            return this.onlyTwo;
        }

        public List<String> provideFirstData() {
            return this.firstList;
        }

        public List<String> provideSecondData(int i11) {
            return this.secondList.get(i11);
        }

        public List<String> provideThirdData(int i11, int i12) {
            if (this.onlyTwo) {
                return new ArrayList();
            }
            return (List) this.thirdList.get(i11).get(i12);
        }
    }

    public interface OnLinkageListener {
        void onPicked(String str, String str2, String str3);
    }

    public static abstract class OnWheelListener {
        public abstract void onFirstWheeled(int i11, String str);

        public abstract void onSecondWheeled(int i11, String str);

        public void onThirdWheeled(int i11, String str) {
        }
    }

    public LinkagePicker(Activity activity) {
        super(activity);
        this.selectedFirstItem = "";
        this.selectedSecondItem = "";
        this.selectedThirdItem = "";
        this.firstLabel = "";
        this.secondLabel = "";
        this.thirdLabel = "";
        this.selectedFirstIndex = 0;
        this.selectedSecondIndex = 0;
        this.selectedThirdIndex = 0;
        this.firstColumnWeight = 0.0d;
        this.secondColumnWeight = 0.0d;
        this.thirdColumnWeight = 0.0d;
    }

    public int[] getColumnWidths(boolean z11) {
        int[] iArr = new int[3];
        double d11 = this.firstColumnWeight;
        if (((int) d11) != 0 || ((int) this.secondColumnWeight) != 0 || ((int) this.thirdColumnWeight) != 0) {
            int i11 = this.screenWidthPixels;
            iArr[0] = (int) (((double) i11) * d11);
            iArr[1] = (int) (((double) i11) * this.secondColumnWeight);
            iArr[2] = (int) (((double) i11) * this.thirdColumnWeight);
        } else if (z11) {
            iArr[0] = this.screenWidthPixels / 2;
            iArr[1] = iArr[0];
            iArr[2] = 0;
        } else {
            iArr[0] = this.screenWidthPixels / 3;
            iArr[1] = iArr[0];
            iArr[2] = iArr[0];
        }
        return iArr;
    }

    public int getSelectedFirstIndex() {
        return this.selectedFirstIndex;
    }

    public String getSelectedFirstItem() {
        return this.selectedFirstItem;
    }

    public int getSelectedSecondIndex() {
        return this.selectedSecondIndex;
    }

    public String getSelectedSecondItem() {
        return this.selectedSecondItem;
    }

    public int getSelectedThirdIndex() {
        return this.selectedThirdIndex;
    }

    public String getSelectedThirdItem() {
        return this.selectedThirdItem;
    }

    public View makeCenterView() {
        DataProvider dataProvider = this.provider;
        if (dataProvider != null) {
            int[] columnWidths = getColumnWidths(dataProvider.isOnlyTwo());
            LinearLayout linearLayout = new LinearLayout(this.activity);
            linearLayout.setOrientation(0);
            linearLayout.setGravity(17);
            WheelView wheelView = new WheelView(this.activity);
            wheelView.setTextSize(this.textSize);
            wheelView.setTextColor(this.textColorNormal, this.textColorFocus);
            wheelView.setLineConfig(this.lineConfig);
            wheelView.setOffset(this.offset);
            wheelView.setCycleDisable(this.cycleDisable);
            linearLayout.addView(wheelView);
            if (TextUtils.isEmpty(this.firstLabel)) {
                wheelView.setLayoutParams(new LinearLayout.LayoutParams(columnWidths[0], -2));
            } else {
                wheelView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                TextView textView = new TextView(this.activity);
                textView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                textView.setTextSize((float) this.textSize);
                textView.setTextColor(this.textColorFocus);
                textView.setText(this.firstLabel);
                linearLayout.addView(textView);
            }
            final WheelView wheelView2 = new WheelView(this.activity);
            wheelView2.setTextSize(this.textSize);
            wheelView2.setTextColor(this.textColorNormal, this.textColorFocus);
            wheelView2.setLineConfig(this.lineConfig);
            wheelView2.setOffset(this.offset);
            wheelView2.setCycleDisable(this.cycleDisable);
            linearLayout.addView(wheelView2);
            if (TextUtils.isEmpty(this.secondLabel)) {
                wheelView2.setLayoutParams(new LinearLayout.LayoutParams(columnWidths[1], -2));
            } else {
                wheelView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                TextView textView2 = new TextView(this.activity);
                textView2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                textView2.setTextSize((float) this.textSize);
                textView2.setTextColor(this.textColorFocus);
                textView2.setText(this.secondLabel);
                linearLayout.addView(textView2);
            }
            final WheelView wheelView3 = new WheelView(this.activity);
            if (!this.provider.isOnlyTwo()) {
                wheelView3.setTextSize(this.textSize);
                wheelView3.setTextColor(this.textColorNormal, this.textColorFocus);
                wheelView3.setLineConfig(this.lineConfig);
                wheelView3.setOffset(this.offset);
                wheelView3.setCycleDisable(this.cycleDisable);
                linearLayout.addView(wheelView3);
                if (TextUtils.isEmpty(this.thirdLabel)) {
                    wheelView3.setLayoutParams(new LinearLayout.LayoutParams(columnWidths[2], -2));
                } else {
                    wheelView3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    TextView textView3 = new TextView(this.activity);
                    textView3.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                    textView3.setTextSize((float) this.textSize);
                    textView3.setTextColor(this.textColorFocus);
                    textView3.setText(this.thirdLabel);
                    linearLayout.addView(textView3);
                }
            }
            wheelView.setItems(this.provider.provideFirstData(), this.selectedFirstIndex);
            wheelView.setOnWheelListener(new WheelView.OnWheelListener() {
                public void onSelected(boolean z11, int i11, String str) {
                    LinkagePicker linkagePicker = LinkagePicker.this;
                    linkagePicker.selectedFirstItem = str;
                    linkagePicker.selectedFirstIndex = i11;
                    if (linkagePicker.onWheelListener != null) {
                        OnWheelListener access$000 = LinkagePicker.this.onWheelListener;
                        LinkagePicker linkagePicker2 = LinkagePicker.this;
                        access$000.onFirstWheeled(linkagePicker2.selectedFirstIndex, linkagePicker2.selectedFirstItem);
                    }
                    if (z11) {
                        LinkagePicker linkagePicker3 = LinkagePicker.this;
                        linkagePicker3.selectedSecondIndex = 0;
                        linkagePicker3.selectedThirdIndex = 0;
                        wheelView2.setItems(linkagePicker3.provider.provideSecondData(linkagePicker3.selectedFirstIndex), LinkagePicker.this.selectedSecondIndex);
                        if (!LinkagePicker.this.provider.isOnlyTwo()) {
                            LinkagePicker linkagePicker4 = LinkagePicker.this;
                            wheelView3.setItems(linkagePicker4.provider.provideThirdData(linkagePicker4.selectedFirstIndex, linkagePicker4.selectedSecondIndex), LinkagePicker.this.selectedThirdIndex);
                        }
                    }
                }
            });
            wheelView2.setItems(this.provider.provideSecondData(this.selectedFirstIndex), this.selectedSecondIndex);
            wheelView2.setOnWheelListener(new WheelView.OnWheelListener() {
                public void onSelected(boolean z11, int i11, String str) {
                    LinkagePicker linkagePicker = LinkagePicker.this;
                    linkagePicker.selectedSecondItem = str;
                    linkagePicker.selectedSecondIndex = i11;
                    if (linkagePicker.onWheelListener != null) {
                        OnWheelListener access$000 = LinkagePicker.this.onWheelListener;
                        LinkagePicker linkagePicker2 = LinkagePicker.this;
                        access$000.onSecondWheeled(linkagePicker2.selectedSecondIndex, linkagePicker2.selectedSecondItem);
                    }
                    if (z11 && !LinkagePicker.this.provider.isOnlyTwo()) {
                        LinkagePicker linkagePicker3 = LinkagePicker.this;
                        linkagePicker3.selectedThirdIndex = 0;
                        wheelView3.setItems(linkagePicker3.provider.provideThirdData(linkagePicker3.selectedFirstIndex, linkagePicker3.selectedSecondIndex), LinkagePicker.this.selectedThirdIndex);
                    }
                }
            });
            if (this.provider.isOnlyTwo()) {
                return linearLayout;
            }
            wheelView3.setItems(this.provider.provideThirdData(this.selectedFirstIndex, this.selectedSecondIndex), this.selectedThirdIndex);
            wheelView3.setOnWheelListener(new WheelView.OnWheelListener() {
                public void onSelected(boolean z11, int i11, String str) {
                    LinkagePicker linkagePicker = LinkagePicker.this;
                    linkagePicker.selectedThirdItem = str;
                    linkagePicker.selectedThirdIndex = i11;
                    if (linkagePicker.onWheelListener != null) {
                        OnWheelListener access$000 = LinkagePicker.this.onWheelListener;
                        LinkagePicker linkagePicker2 = LinkagePicker.this;
                        access$000.onThirdWheeled(linkagePicker2.selectedThirdIndex, linkagePicker2.selectedThirdItem);
                    }
                }
            });
            return linearLayout;
        }
        throw new IllegalArgumentException("please set data provider before make view");
    }

    public void onSubmit() {
        if (this.onLinkageListener != null) {
            if (this.provider.isOnlyTwo()) {
                this.onLinkageListener.onPicked(this.selectedFirstItem, this.selectedSecondItem, (String) null);
            } else {
                this.onLinkageListener.onPicked(this.selectedFirstItem, this.selectedSecondItem, this.selectedThirdItem);
            }
        }
    }

    public void setColumnWeight(double d11, double d12, double d13) {
        this.firstColumnWeight = d11;
        this.secondColumnWeight = d12;
        this.thirdColumnWeight = d13;
    }

    public void setLabel(String str, String str2) {
        setLabel(str, str2, "");
    }

    public void setOnLinkageListener(OnLinkageListener onLinkageListener2) {
        this.onLinkageListener = onLinkageListener2;
    }

    public void setOnWheelListener(OnWheelListener onWheelListener2) {
        this.onWheelListener = onWheelListener2;
    }

    public void setProvider(DataProvider dataProvider) {
        this.provider = dataProvider;
    }

    public void setSelectedIndex(int i11, int i12) {
        setSelectedIndex(i11, i12, 0);
    }

    public void setSelectedItem(String str, String str2) {
        setSelectedItem(str, str2, "");
    }

    public void setLabel(String str, String str2, String str3) {
        this.firstLabel = str;
        this.secondLabel = str2;
        this.thirdLabel = str3;
    }

    public void setSelectedIndex(int i11, int i12, int i13) {
        this.selectedFirstIndex = i11;
        this.selectedSecondIndex = i12;
        this.selectedThirdIndex = i13;
    }

    public void setSelectedItem(String str, String str2, String str3) {
        DataProvider dataProvider = this.provider;
        if (dataProvider != null) {
            List<String> provideFirstData = dataProvider.provideFirstData();
            int i11 = 0;
            while (true) {
                if (i11 >= provideFirstData.size()) {
                    break;
                } else if (provideFirstData.get(i11).contains(str)) {
                    this.selectedFirstIndex = i11;
                    break;
                } else {
                    i11++;
                }
            }
            List<String> provideSecondData = this.provider.provideSecondData(this.selectedFirstIndex);
            int i12 = 0;
            while (true) {
                if (i12 >= provideSecondData.size()) {
                    break;
                } else if (provideSecondData.get(i12).contains(str2)) {
                    this.selectedSecondIndex = i12;
                    break;
                } else {
                    i12++;
                }
            }
            if (!this.provider.isOnlyTwo()) {
                List<String> provideThirdData = this.provider.provideThirdData(this.selectedFirstIndex, this.selectedSecondIndex);
                for (int i13 = 0; i13 < provideThirdData.size(); i13++) {
                    if (provideThirdData.get(i13).contains(str3)) {
                        this.selectedThirdIndex = i13;
                        return;
                    }
                }
                return;
            }
            return;
        }
        throw new IllegalArgumentException("please set data provider at first");
    }

    public void setColumnWeight(double d11, double d12) {
        this.firstColumnWeight = d11;
        this.secondColumnWeight = d12;
        this.thirdColumnWeight = 0.0d;
    }

    public LinkagePicker(Activity activity, DataProvider dataProvider) {
        super(activity);
        this.selectedFirstItem = "";
        this.selectedSecondItem = "";
        this.selectedThirdItem = "";
        this.firstLabel = "";
        this.secondLabel = "";
        this.thirdLabel = "";
        this.selectedFirstIndex = 0;
        this.selectedSecondIndex = 0;
        this.selectedThirdIndex = 0;
        this.firstColumnWeight = 0.0d;
        this.secondColumnWeight = 0.0d;
        this.thirdColumnWeight = 0.0d;
        this.provider = dataProvider;
    }

    @Deprecated
    public LinkagePicker(Activity activity, ArrayList<String> arrayList, ArrayList<ArrayList<String>> arrayList2) {
        this(activity, arrayList, arrayList2, (ArrayList<ArrayList<ArrayList<String>>>) null);
    }

    @Deprecated
    public LinkagePicker(Activity activity, ArrayList<String> arrayList, ArrayList<ArrayList<String>> arrayList2, ArrayList<ArrayList<ArrayList<String>>> arrayList3) {
        super(activity);
        this.selectedFirstItem = "";
        this.selectedSecondItem = "";
        this.selectedThirdItem = "";
        this.firstLabel = "";
        this.secondLabel = "";
        this.thirdLabel = "";
        this.selectedFirstIndex = 0;
        this.selectedSecondIndex = 0;
        this.selectedThirdIndex = 0;
        this.firstColumnWeight = 0.0d;
        this.secondColumnWeight = 0.0d;
        this.thirdColumnWeight = 0.0d;
        this.provider = new DefaultDataProvider(arrayList, arrayList2, arrayList3);
    }
}
