package com.huobi.view.pickerview;

import android.graphics.Typeface;
import android.view.View;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.hbg.lib.network.hbg.core.bean.BalanceProfitLossData;
import com.huobi.coupon.bean.CouponReturn;
import com.huobi.view.pickerview.adapter.NumericWheelAdapter;
import com.huobi.view.pickerview.listener.ISelectTimeCallback;
import com.huobi.view.wheelview.WheelView;
import com.huobi.view.wheelview.listener.OnItemSelectedListener;
import com.xiaomi.mipush.sdk.Constants;
import e7.s;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import pro.huobi.R;

public class WheelTime {
    private static final int DEFAULT_END_DAY = 31;
    private static final int DEFAULT_END_MONTH = 12;
    private static final int DEFAULT_END_YEAR = 2100;
    private static final int DEFAULT_START_DAY = 1;
    private static final int DEFAULT_START_MONTH = 1;
    private static final int DEFAULT_START_YEAR = 1900;
    /* access modifiers changed from: private */
    public int currentYear;
    private int dividerColor;
    private WheelView.DividerType dividerType;
    /* access modifiers changed from: private */
    public int endDay = 31;
    /* access modifiers changed from: private */
    public int endMonth = 12;
    /* access modifiers changed from: private */
    public int endYear = DEFAULT_END_YEAR;
    private int[] gravity;
    private float lineSpacingMultiplier;
    /* access modifiers changed from: private */
    public ISelectTimeCallback mSelectChangeCallback;
    /* access modifiers changed from: private */
    public int startDay = 1;
    /* access modifiers changed from: private */
    public int startMonth = 1;
    /* access modifiers changed from: private */
    public int startYear = DEFAULT_START_YEAR;
    private int textColorCenter;
    private int textColorOut;
    private int textSize;
    private boolean[] type;
    private Typeface typeface;
    private View view;
    private WheelView wv_day;
    private WheelView wv_hours;
    private WheelView wv_minutes;
    /* access modifiers changed from: private */
    public WheelView wv_month;
    private WheelView wv_seconds;
    private WheelView wv_year;

    public WheelTime(View view2, boolean[] zArr, int[] iArr, int i11) {
        this.view = view2;
        this.type = zArr;
        this.gravity = iArr;
        this.textSize = i11;
        setView(view2);
    }

    private int getCurrentItem(WheelView wheelView) {
        if (wheelView != null) {
            return wheelView.getCurrentItem();
        }
        return 0;
    }

    private int getGravity(int i11) {
        int[] iArr = this.gravity;
        if (i11 < iArr.length) {
            return iArr[i11];
        }
        return 17;
    }

    private void setChangedListener(WheelView wheelView) {
        if (this.mSelectChangeCallback != null && wheelView != null) {
            wheelView.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(int i11) {
                    WheelTime.this.mSelectChangeCallback.onTimeSelectChanged();
                }
            });
        }
    }

    private void setContentTextSize() {
        WheelView wheelView = this.wv_year;
        if (wheelView != null) {
            wheelView.setTextSize((float) this.textSize);
        }
        WheelView wheelView2 = this.wv_month;
        if (wheelView2 != null) {
            wheelView2.setTextSize((float) this.textSize);
        }
        WheelView wheelView3 = this.wv_day;
        if (wheelView3 != null) {
            wheelView3.setTextSize((float) this.textSize);
        }
        WheelView wheelView4 = this.wv_hours;
        if (wheelView4 != null) {
            wheelView4.setTextSize((float) this.textSize);
        }
        WheelView wheelView5 = this.wv_minutes;
        if (wheelView5 != null) {
            wheelView5.setTextSize((float) this.textSize);
        }
        WheelView wheelView6 = this.wv_seconds;
        if (wheelView6 != null) {
            wheelView6.setTextSize((float) this.textSize);
        }
    }

    private void setDividerColor() {
        WheelView wheelView = this.wv_year;
        if (wheelView != null) {
            wheelView.setDividerColor(this.dividerColor);
        }
        WheelView wheelView2 = this.wv_month;
        if (wheelView2 != null) {
            wheelView2.setDividerColor(this.dividerColor);
        }
        WheelView wheelView3 = this.wv_day;
        if (wheelView3 != null) {
            wheelView3.setDividerColor(this.dividerColor);
        }
        WheelView wheelView4 = this.wv_hours;
        if (wheelView4 != null) {
            wheelView4.setDividerColor(this.dividerColor);
        }
        WheelView wheelView5 = this.wv_minutes;
        if (wheelView5 != null) {
            wheelView5.setDividerColor(this.dividerColor);
        }
        WheelView wheelView6 = this.wv_seconds;
        if (wheelView6 != null) {
            wheelView6.setDividerColor(this.dividerColor);
        }
    }

    private void setDividerType() {
        WheelView wheelView = this.wv_year;
        if (wheelView != null) {
            wheelView.setDividerType(this.dividerType);
        }
        WheelView wheelView2 = this.wv_month;
        if (wheelView2 != null) {
            wheelView2.setDividerType(this.dividerType);
        }
        WheelView wheelView3 = this.wv_day;
        if (wheelView3 != null) {
            wheelView3.setDividerType(this.dividerType);
        }
        WheelView wheelView4 = this.wv_hours;
        if (wheelView4 != null) {
            wheelView4.setDividerType(this.dividerType);
        }
        WheelView wheelView5 = this.wv_minutes;
        if (wheelView5 != null) {
            wheelView5.setDividerType(this.dividerType);
        }
        WheelView wheelView6 = this.wv_seconds;
        if (wheelView6 != null) {
            wheelView6.setDividerType(this.dividerType);
        }
    }

    private void setLineSpacingMultiplier() {
        WheelView wheelView = this.wv_year;
        if (wheelView != null) {
            wheelView.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        }
        WheelView wheelView2 = this.wv_month;
        if (wheelView2 != null) {
            wheelView2.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        }
        WheelView wheelView3 = this.wv_day;
        if (wheelView3 != null) {
            wheelView3.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        }
        WheelView wheelView4 = this.wv_hours;
        if (wheelView4 != null) {
            wheelView4.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        }
        WheelView wheelView5 = this.wv_minutes;
        if (wheelView5 != null) {
            wheelView5.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        }
        WheelView wheelView6 = this.wv_seconds;
        if (wheelView6 != null) {
            wheelView6.setLineSpacingMultiplier(this.lineSpacingMultiplier);
        }
    }

    /* access modifiers changed from: private */
    public void setReDay(int i11, int i12, int i13, int i14, List<String> list, List<String> list2) {
        WheelView wheelView = this.wv_day;
        if (wheelView != null) {
            int currentItem = wheelView.getCurrentItem();
            if (list.contains(String.valueOf(i12))) {
                if (i14 > 31) {
                    i14 = 31;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(i13, i14));
            } else if (list2.contains(String.valueOf(i12))) {
                if (i14 > 30) {
                    i14 = 30;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(i13, i14));
            } else if ((i11 % 4 != 0 || i11 % 100 == 0) && i11 % 400 != 0) {
                if (i14 > 28) {
                    i14 = 28;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(i13, i14));
            } else {
                if (i14 > 29) {
                    i14 = 29;
                }
                this.wv_day.setAdapter(new NumericWheelAdapter(i13, i14));
            }
            if (currentItem > this.wv_day.getAdapter().getItemsCount() - 1) {
                this.wv_day.setCurrentItem(this.wv_day.getAdapter().getItemsCount() - 1);
            }
        }
    }

    private void setSolar(int i11, int i12, int i13, int i14, int i15, int i16) {
        int i17;
        int i18;
        int i19 = i11;
        int i21 = i12;
        String[] strArr = {"1", "3", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_OTC, BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_SWAP, "8", CouponReturn.TYPE_EXPERIENCE, "12"};
        String[] strArr2 = {"4", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_POOL, "9", BalanceProfitLossData.AccountBalance.DISTRIBUTION_TYPE_FUTURE_LINEAR_SWAP};
        final List asList = Arrays.asList(strArr);
        final List asList2 = Arrays.asList(strArr2);
        this.currentYear = i19;
        WheelView wheelView = (WheelView) this.view.findViewById(R.id.year);
        this.wv_year = wheelView;
        int i22 = 0;
        if (wheelView != null) {
            wheelView.setAdapter(new NumericWheelAdapter(this.startYear, this.endYear));
            this.wv_year.setCurrentItem(i19 - this.startYear);
            this.wv_year.setGravity(getGravity(0));
        }
        WheelView wheelView2 = (WheelView) this.view.findViewById(R.id.month);
        this.wv_month = wheelView2;
        int i23 = this.startYear;
        int i24 = this.endYear;
        if (i23 == i24) {
            wheelView2.setAdapter(new NumericWheelAdapter(this.startMonth, this.endMonth));
            this.wv_month.setCurrentItem((i21 + 1) - this.startMonth);
        } else if (i19 == i23) {
            wheelView2.setAdapter(new NumericWheelAdapter(this.startMonth, 12));
            this.wv_month.setCurrentItem((i21 + 1) - this.startMonth);
        } else if (i19 == i24) {
            wheelView2.setAdapter(new NumericWheelAdapter(1, this.endMonth));
            this.wv_month.setCurrentItem(i21);
        } else {
            wheelView2.setAdapter(new NumericWheelAdapter(1, 12));
            this.wv_month.setCurrentItem(i21);
        }
        WheelView wheelView3 = this.wv_month;
        if (wheelView3 != null) {
            wheelView3.setGravity(getGravity(1));
        }
        this.wv_day = (WheelView) this.view.findViewById(R.id.day);
        int i25 = this.startYear;
        int i26 = this.endYear;
        if (i25 == i26 && this.startMonth == this.endMonth) {
            int i27 = i21 + 1;
            if (asList.contains(String.valueOf(i27))) {
                if (this.endDay > 31) {
                    this.endDay = 31;
                }
                WheelView wheelView4 = this.wv_day;
                if (wheelView4 != null) {
                    wheelView4.setAdapter(new NumericWheelAdapter(this.startDay, this.endDay));
                }
            } else if (asList2.contains(String.valueOf(i27))) {
                if (this.endDay > 30) {
                    this.endDay = 30;
                }
                WheelView wheelView5 = this.wv_day;
                if (wheelView5 != null) {
                    wheelView5.setAdapter(new NumericWheelAdapter(this.startDay, this.endDay));
                }
            } else if ((i19 % 4 != 0 || i19 % 100 == 0) && i19 % 400 != 0) {
                if (this.endDay > 28) {
                    this.endDay = 28;
                }
                WheelView wheelView6 = this.wv_day;
                if (wheelView6 != null) {
                    wheelView6.setAdapter(new NumericWheelAdapter(this.startDay, this.endDay));
                }
            } else {
                if (this.endDay > 29) {
                    this.endDay = 29;
                }
                WheelView wheelView7 = this.wv_day;
                if (wheelView7 != null) {
                    wheelView7.setAdapter(new NumericWheelAdapter(this.startDay, this.endDay));
                }
            }
            WheelView wheelView8 = this.wv_day;
            if (wheelView8 != null) {
                wheelView8.setCurrentItem(i13 - this.startDay);
            }
        } else if (i19 == i25 && (i18 = i21 + 1) == this.startMonth) {
            if (asList.contains(String.valueOf(i18))) {
                WheelView wheelView9 = this.wv_day;
                if (wheelView9 != null) {
                    wheelView9.setAdapter(new NumericWheelAdapter(this.startDay, 31));
                }
            } else if (asList2.contains(String.valueOf(i18))) {
                WheelView wheelView10 = this.wv_day;
                if (wheelView10 != null) {
                    wheelView10.setAdapter(new NumericWheelAdapter(this.startDay, 30));
                }
            } else if ((i19 % 4 != 0 || i19 % 100 == 0) && i19 % 400 != 0) {
                WheelView wheelView11 = this.wv_day;
                if (wheelView11 != null) {
                    wheelView11.setAdapter(new NumericWheelAdapter(this.startDay, 28));
                }
            } else {
                WheelView wheelView12 = this.wv_day;
                if (wheelView12 != null) {
                    wheelView12.setAdapter(new NumericWheelAdapter(this.startDay, 29));
                }
            }
            WheelView wheelView13 = this.wv_day;
            if (wheelView13 != null) {
                wheelView13.setCurrentItem(i13 - this.startDay);
            }
        } else if (i19 == i26 && (i17 = i21 + 1) == this.endMonth) {
            if (asList.contains(String.valueOf(i17))) {
                if (this.endDay > 31) {
                    this.endDay = 31;
                }
                WheelView wheelView14 = this.wv_day;
                if (wheelView14 != null) {
                    wheelView14.setAdapter(new NumericWheelAdapter(1, this.endDay));
                }
            } else if (asList2.contains(String.valueOf(i17))) {
                if (this.endDay > 30) {
                    this.endDay = 30;
                }
                WheelView wheelView15 = this.wv_day;
                if (wheelView15 != null) {
                    wheelView15.setAdapter(new NumericWheelAdapter(1, this.endDay));
                }
            } else if ((i19 % 4 != 0 || i19 % 100 == 0) && i19 % 400 != 0) {
                if (this.endDay > 28) {
                    this.endDay = 28;
                }
                WheelView wheelView16 = this.wv_day;
                if (wheelView16 != null) {
                    wheelView16.setAdapter(new NumericWheelAdapter(1, this.endDay));
                }
            } else {
                if (this.endDay > 29) {
                    this.endDay = 29;
                }
                WheelView wheelView17 = this.wv_day;
                if (wheelView17 != null) {
                    wheelView17.setAdapter(new NumericWheelAdapter(1, this.endDay));
                }
            }
            WheelView wheelView18 = this.wv_day;
            if (wheelView18 != null) {
                wheelView18.setCurrentItem(i13 - 1);
            }
        } else {
            int i28 = i21 + 1;
            if (asList.contains(String.valueOf(i28))) {
                WheelView wheelView19 = this.wv_day;
                if (wheelView19 != null) {
                    wheelView19.setAdapter(new NumericWheelAdapter(1, 31));
                }
            } else if (asList2.contains(String.valueOf(i28))) {
                WheelView wheelView20 = this.wv_day;
                if (wheelView20 != null) {
                    wheelView20.setAdapter(new NumericWheelAdapter(1, 30));
                }
            } else if ((i19 % 4 != 0 || i19 % 100 == 0) && i19 % 400 != 0) {
                WheelView wheelView21 = this.wv_day;
                if (wheelView21 != null) {
                    wheelView21.setAdapter(new NumericWheelAdapter(1, 28));
                }
            } else {
                WheelView wheelView22 = this.wv_day;
                if (wheelView22 != null) {
                    wheelView22.setAdapter(new NumericWheelAdapter(1, 29));
                }
            }
            WheelView wheelView23 = this.wv_day;
            if (wheelView23 != null) {
                wheelView23.setCurrentItem(i13 - 1);
            }
        }
        WheelView wheelView24 = this.wv_day;
        if (wheelView24 != null) {
            wheelView24.setGravity(getGravity(2));
        }
        WheelView wheelView25 = (WheelView) this.view.findViewById(R.id.hour);
        this.wv_hours = wheelView25;
        if (wheelView25 != null) {
            wheelView25.setAdapter(new NumericWheelAdapter(0, 23));
        }
        WheelView wheelView26 = this.wv_hours;
        if (wheelView26 != null) {
            wheelView26.setCurrentItem(i14);
            this.wv_hours.setGravity(getGravity(3));
        }
        WheelView wheelView27 = (WheelView) this.view.findViewById(R.id.min);
        this.wv_minutes = wheelView27;
        if (wheelView27 != null) {
            wheelView27.setAdapter(new NumericWheelAdapter(0, 59));
            this.wv_minutes.setCurrentItem(i15);
            this.wv_minutes.setGravity(getGravity(4));
        }
        WheelView wheelView28 = (WheelView) this.view.findViewById(R.id.second);
        this.wv_seconds = wheelView28;
        if (wheelView28 != null) {
            wheelView28.setAdapter(new NumericWheelAdapter(0, 59));
            this.wv_seconds.setCurrentItem(i16);
            this.wv_seconds.setGravity(getGravity(5));
        }
        WheelView wheelView29 = this.wv_year;
        if (wheelView29 != null) {
            wheelView29.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(int i11) {
                    int access$000 = i11 + WheelTime.this.startYear;
                    int unused = WheelTime.this.currentYear = access$000;
                    int currentItem = WheelTime.this.wv_month.getCurrentItem();
                    if (WheelTime.this.startYear == WheelTime.this.endYear) {
                        WheelTime.this.wv_month.setAdapter(new NumericWheelAdapter(WheelTime.this.startMonth, WheelTime.this.endMonth));
                        if (currentItem > WheelTime.this.wv_month.getAdapter().getItemsCount() - 1) {
                            currentItem = WheelTime.this.wv_month.getAdapter().getItemsCount() - 1;
                            WheelTime.this.wv_month.setCurrentItem(currentItem);
                        }
                        int access$400 = currentItem + WheelTime.this.startMonth;
                        if (WheelTime.this.startMonth == WheelTime.this.endMonth) {
                            WheelTime wheelTime = WheelTime.this;
                            wheelTime.setReDay(access$000, access$400, wheelTime.startDay, WheelTime.this.endDay, asList, asList2);
                        } else if (access$400 == WheelTime.this.startMonth) {
                            WheelTime wheelTime2 = WheelTime.this;
                            wheelTime2.setReDay(access$000, access$400, wheelTime2.startDay, 31, asList, asList2);
                        } else if (access$400 == WheelTime.this.endMonth) {
                            WheelTime wheelTime3 = WheelTime.this;
                            wheelTime3.setReDay(access$000, access$400, 1, wheelTime3.endDay, asList, asList2);
                        } else {
                            WheelTime.this.setReDay(access$000, access$400, 1, 31, asList, asList2);
                        }
                    } else if (access$000 == WheelTime.this.startYear) {
                        WheelTime.this.wv_month.setAdapter(new NumericWheelAdapter(WheelTime.this.startMonth, 12));
                        if (currentItem > WheelTime.this.wv_month.getAdapter().getItemsCount() - 1) {
                            currentItem = WheelTime.this.wv_month.getAdapter().getItemsCount() - 1;
                            WheelTime.this.wv_month.setCurrentItem(currentItem);
                        }
                        int access$4002 = currentItem + WheelTime.this.startMonth;
                        if (access$4002 == WheelTime.this.startMonth) {
                            WheelTime wheelTime4 = WheelTime.this;
                            wheelTime4.setReDay(access$000, access$4002, wheelTime4.startDay, 31, asList, asList2);
                        } else {
                            WheelTime.this.setReDay(access$000, access$4002, 1, 31, asList, asList2);
                        }
                    } else if (access$000 == WheelTime.this.endYear) {
                        WheelTime.this.wv_month.setAdapter(new NumericWheelAdapter(1, WheelTime.this.endMonth));
                        if (currentItem > WheelTime.this.wv_month.getAdapter().getItemsCount() - 1) {
                            currentItem = WheelTime.this.wv_month.getAdapter().getItemsCount() - 1;
                            WheelTime.this.wv_month.setCurrentItem(currentItem);
                        }
                        int i12 = 1 + currentItem;
                        if (i12 == WheelTime.this.endMonth) {
                            WheelTime wheelTime5 = WheelTime.this;
                            wheelTime5.setReDay(access$000, i12, 1, wheelTime5.endDay, asList, asList2);
                        } else {
                            WheelTime.this.setReDay(access$000, i12, 1, 31, asList, asList2);
                        }
                    } else {
                        WheelTime.this.wv_month.setAdapter(new NumericWheelAdapter(1, 12));
                        WheelTime wheelTime6 = WheelTime.this;
                        wheelTime6.setReDay(access$000, 1 + wheelTime6.wv_month.getCurrentItem(), 1, 31, asList, asList2);
                    }
                    if (WheelTime.this.mSelectChangeCallback != null) {
                        WheelTime.this.mSelectChangeCallback.onTimeSelectChanged();
                    }
                }
            });
        }
        WheelView wheelView30 = this.wv_month;
        if (wheelView30 != null) {
            wheelView30.setOnItemSelectedListener(new OnItemSelectedListener() {
                public void onItemSelected(int i11) {
                    int i12 = i11 + 1;
                    if (WheelTime.this.startYear == WheelTime.this.endYear) {
                        int access$400 = (i12 + WheelTime.this.startMonth) - 1;
                        if (WheelTime.this.startMonth == WheelTime.this.endMonth) {
                            WheelTime wheelTime = WheelTime.this;
                            wheelTime.setReDay(wheelTime.currentYear, access$400, WheelTime.this.startDay, WheelTime.this.endDay, asList, asList2);
                        } else if (WheelTime.this.startMonth == access$400) {
                            WheelTime wheelTime2 = WheelTime.this;
                            wheelTime2.setReDay(wheelTime2.currentYear, access$400, WheelTime.this.startDay, 31, asList, asList2);
                        } else if (WheelTime.this.endMonth == access$400) {
                            WheelTime wheelTime3 = WheelTime.this;
                            wheelTime3.setReDay(wheelTime3.currentYear, access$400, 1, WheelTime.this.endDay, asList, asList2);
                        } else {
                            WheelTime wheelTime4 = WheelTime.this;
                            wheelTime4.setReDay(wheelTime4.currentYear, access$400, 1, 31, asList, asList2);
                        }
                    } else if (WheelTime.this.currentYear == WheelTime.this.startYear) {
                        int access$4002 = (i12 + WheelTime.this.startMonth) - 1;
                        if (access$4002 == WheelTime.this.startMonth) {
                            WheelTime wheelTime5 = WheelTime.this;
                            wheelTime5.setReDay(wheelTime5.currentYear, access$4002, WheelTime.this.startDay, 31, asList, asList2);
                        } else {
                            WheelTime wheelTime6 = WheelTime.this;
                            wheelTime6.setReDay(wheelTime6.currentYear, access$4002, 1, 31, asList, asList2);
                        }
                    } else if (WheelTime.this.currentYear != WheelTime.this.endYear) {
                        WheelTime wheelTime7 = WheelTime.this;
                        wheelTime7.setReDay(wheelTime7.currentYear, i12, 1, 31, asList, asList2);
                    } else if (i12 == WheelTime.this.endMonth) {
                        WheelTime wheelTime8 = WheelTime.this;
                        wheelTime8.setReDay(wheelTime8.currentYear, WheelTime.this.wv_month.getCurrentItem() + 1, 1, WheelTime.this.endDay, asList, asList2);
                    } else {
                        WheelTime wheelTime9 = WheelTime.this;
                        wheelTime9.setReDay(wheelTime9.currentYear, WheelTime.this.wv_month.getCurrentItem() + 1, 1, 31, asList, asList2);
                    }
                    if (WheelTime.this.mSelectChangeCallback != null) {
                        WheelTime.this.mSelectChangeCallback.onTimeSelectChanged();
                    }
                }
            });
        }
        setChangedListener(this.wv_day);
        setChangedListener(this.wv_hours);
        setChangedListener(this.wv_minutes);
        setChangedListener(this.wv_seconds);
        boolean[] zArr = this.type;
        if (zArr.length == 6) {
            WheelView wheelView31 = this.wv_year;
            if (wheelView31 != null) {
                wheelView31.setVisibility(zArr[0] ? 0 : 8);
            }
            WheelView wheelView32 = this.wv_month;
            if (wheelView32 != null) {
                wheelView32.setVisibility(this.type[1] ? 0 : 8);
            }
            WheelView wheelView33 = this.wv_day;
            if (wheelView33 != null) {
                wheelView33.setVisibility(this.type[2] ? 0 : 8);
            }
            WheelView wheelView34 = this.wv_hours;
            if (wheelView34 != null) {
                wheelView34.setVisibility(this.type[3] ? 0 : 8);
            }
            WheelView wheelView35 = this.wv_minutes;
            if (wheelView35 != null) {
                wheelView35.setVisibility(this.type[4] ? 0 : 8);
            }
            WheelView wheelView36 = this.wv_seconds;
            if (wheelView36 != null) {
                if (!this.type[5]) {
                    i22 = 8;
                }
                wheelView36.setVisibility(i22);
            }
            setContentTextSize();
            return;
        }
        throw new IllegalArgumentException("type[] length is not 6");
    }

    private void setTextColorCenter() {
        WheelView wheelView = this.wv_year;
        if (wheelView != null) {
            wheelView.setTextColorCenter(this.textColorCenter);
        }
        WheelView wheelView2 = this.wv_month;
        if (wheelView2 != null) {
            wheelView2.setTextColorCenter(this.textColorCenter);
        }
        WheelView wheelView3 = this.wv_day;
        if (wheelView3 != null) {
            wheelView3.setTextColorCenter(this.textColorCenter);
        }
        WheelView wheelView4 = this.wv_hours;
        if (wheelView4 != null) {
            wheelView4.setTextColorCenter(this.textColorCenter);
        }
        WheelView wheelView5 = this.wv_minutes;
        if (wheelView5 != null) {
            wheelView5.setTextColorCenter(this.textColorCenter);
        }
        WheelView wheelView6 = this.wv_seconds;
        if (wheelView6 != null) {
            wheelView6.setTextColorCenter(this.textColorCenter);
        }
    }

    private void setTextColorOut() {
        WheelView wheelView = this.wv_year;
        if (wheelView != null) {
            wheelView.setTextColorOut(this.textColorOut);
        }
        WheelView wheelView2 = this.wv_month;
        if (wheelView2 != null) {
            wheelView2.setTextColorOut(this.textColorOut);
        }
        WheelView wheelView3 = this.wv_day;
        if (wheelView3 != null) {
            wheelView3.setTextColorOut(this.textColorOut);
        }
        WheelView wheelView4 = this.wv_hours;
        if (wheelView4 != null) {
            wheelView4.setTextColorOut(this.textColorOut);
        }
        WheelView wheelView5 = this.wv_minutes;
        if (wheelView5 != null) {
            wheelView5.setTextColorOut(this.textColorOut);
        }
        WheelView wheelView6 = this.wv_seconds;
        if (wheelView6 != null) {
            wheelView6.setTextColorOut(this.textColorOut);
        }
    }

    private void setTypeface() {
        WheelView wheelView = this.wv_year;
        if (wheelView != null) {
            wheelView.setTypeface(this.typeface);
        }
        WheelView wheelView2 = this.wv_month;
        if (wheelView2 != null) {
            wheelView2.setTypeface(this.typeface);
        }
        WheelView wheelView3 = this.wv_day;
        if (wheelView3 != null) {
            wheelView3.setTypeface(this.typeface);
        }
        WheelView wheelView4 = this.wv_hours;
        if (wheelView4 != null) {
            wheelView4.setTypeface(this.typeface);
        }
        WheelView wheelView5 = this.wv_minutes;
        if (wheelView5 != null) {
            wheelView5.setTypeface(this.typeface);
        }
        WheelView wheelView6 = this.wv_seconds;
        if (wheelView6 != null) {
            wheelView6.setTypeface(this.typeface);
        }
    }

    public int getEndYear() {
        return this.endYear;
    }

    public int getStartYear() {
        return this.startYear;
    }

    public String getTime() {
        StringBuilder sb2 = new StringBuilder();
        if (this.currentYear == this.startYear) {
            int currentItem = getCurrentItem(this.wv_month);
            int i11 = this.startMonth;
            if (currentItem + i11 == i11) {
                sb2.append(getCurrentItem(this.wv_year) + this.startYear);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb2.append(getCurrentItem(this.wv_month) + this.startMonth);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb2.append(getCurrentItem(this.wv_day) + this.startDay);
                sb2.append(" ");
                sb2.append(getCurrentItem(this.wv_hours));
                sb2.append(":");
                sb2.append(getCurrentItem(this.wv_minutes));
                sb2.append(":");
                sb2.append(getCurrentItem(this.wv_seconds));
            } else {
                sb2.append(getCurrentItem(this.wv_year) + this.startYear);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb2.append(getCurrentItem(this.wv_month) + this.startMonth);
                sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
                sb2.append(getCurrentItem(this.wv_day) + 1);
                sb2.append(" ");
                sb2.append(getCurrentItem(this.wv_hours));
                sb2.append(":");
                sb2.append(getCurrentItem(this.wv_minutes));
                sb2.append(":");
                sb2.append(getCurrentItem(this.wv_seconds));
            }
        } else {
            sb2.append(getCurrentItem(this.wv_year) + this.startYear);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb2.append(getCurrentItem(this.wv_month) + 1);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SERVER);
            sb2.append(getCurrentItem(this.wv_day) + 1);
            sb2.append(" ");
            sb2.append(getCurrentItem(this.wv_hours));
            sb2.append(":");
            sb2.append(getCurrentItem(this.wv_minutes));
            sb2.append(":");
            sb2.append(getCurrentItem(this.wv_seconds));
        }
        return sb2.toString();
    }

    public View getView() {
        return this.view;
    }

    public void isCenterLabel(boolean z11) {
        WheelView wheelView = this.wv_day;
        if (wheelView != null) {
            wheelView.isCenterLabel(z11);
        }
        WheelView wheelView2 = this.wv_month;
        if (wheelView2 != null) {
            wheelView2.isCenterLabel(z11);
        }
        WheelView wheelView3 = this.wv_year;
        if (wheelView3 != null) {
            wheelView3.isCenterLabel(z11);
        }
        WheelView wheelView4 = this.wv_hours;
        if (wheelView4 != null) {
            wheelView4.isCenterLabel(z11);
        }
        WheelView wheelView5 = this.wv_minutes;
        if (wheelView5 != null) {
            wheelView5.isCenterLabel(z11);
        }
        WheelView wheelView6 = this.wv_seconds;
        if (wheelView6 != null) {
            wheelView6.isCenterLabel(z11);
        }
    }

    public void setCyclic(boolean z11) {
        WheelView wheelView = this.wv_year;
        if (wheelView != null) {
            wheelView.setCyclic(z11);
        }
        WheelView wheelView2 = this.wv_month;
        if (wheelView2 != null) {
            wheelView2.setCyclic(z11);
        }
        WheelView wheelView3 = this.wv_day;
        if (wheelView3 != null) {
            wheelView3.setCyclic(z11);
        }
        WheelView wheelView4 = this.wv_hours;
        if (wheelView4 != null) {
            wheelView4.setCyclic(z11);
        }
        WheelView wheelView5 = this.wv_minutes;
        if (wheelView5 != null) {
            wheelView5.setCyclic(z11);
        }
        WheelView wheelView6 = this.wv_seconds;
        if (wheelView6 != null) {
            wheelView6.setCyclic(z11);
        }
    }

    public void setEndYear(int i11) {
        this.endYear = i11;
    }

    public void setLabels(String str, String str2, String str3, String str4, String str5, String str6) {
        WheelView wheelView = this.wv_year;
        if (wheelView != null) {
            if (str != null) {
                wheelView.setLabel(str);
            } else {
                wheelView.setLabel("y");
            }
        }
        WheelView wheelView2 = this.wv_month;
        if (wheelView2 != null) {
            if (str2 != null) {
                wheelView2.setLabel(str2);
            } else {
                wheelView2.setLabel("M");
            }
        }
        WheelView wheelView3 = this.wv_day;
        if (wheelView3 != null) {
            if (str3 != null) {
                wheelView3.setLabel(str3);
            } else {
                wheelView3.setLabel(GoogleApiAvailabilityLight.TRACKING_SOURCE_DIALOG);
            }
        }
        WheelView wheelView4 = this.wv_hours;
        if (wheelView4 != null) {
            if (str4 != null) {
                wheelView4.setLabel(str4);
            } else {
                wheelView4.setLabel("h");
            }
        }
        WheelView wheelView5 = this.wv_minutes;
        if (wheelView5 != null) {
            if (str5 != null) {
                wheelView5.setLabel(str5);
            } else {
                wheelView5.setLabel("m");
            }
        }
        WheelView wheelView6 = this.wv_seconds;
        if (wheelView6 == null) {
            return;
        }
        if (str6 != null) {
            wheelView6.setLabel(str6);
        } else {
            wheelView6.setLabel(s.f70071a);
        }
    }

    public void setPicker(int i11, int i12, int i13, int i14, int i15, int i16) {
        setSolar(i11, i12, i13, i14, i15, i16);
    }

    public void setRangDate(Calendar calendar, Calendar calendar2) {
        if (calendar == null && calendar2 != null) {
            int i11 = calendar2.get(1);
            int i12 = calendar2.get(2) + 1;
            int i13 = calendar2.get(5);
            int i14 = this.startYear;
            if (i11 > i14) {
                this.endYear = i11;
                this.endMonth = i12;
                this.endDay = i13;
            } else if (i11 == i14) {
                int i15 = this.startMonth;
                if (i12 > i15) {
                    this.endYear = i11;
                    this.endMonth = i12;
                    this.endDay = i13;
                } else if (i12 == i15 && i13 > this.startDay) {
                    this.endYear = i11;
                    this.endMonth = i12;
                    this.endDay = i13;
                }
            }
        } else if (calendar != null && calendar2 == null) {
            int i16 = calendar.get(1);
            int i17 = calendar.get(2) + 1;
            int i18 = calendar.get(5);
            int i19 = this.endYear;
            if (i16 < i19) {
                this.startMonth = i17;
                this.startDay = i18;
                this.startYear = i16;
            } else if (i16 == i19) {
                int i21 = this.endMonth;
                if (i17 < i21) {
                    this.startMonth = i17;
                    this.startDay = i18;
                    this.startYear = i16;
                } else if (i17 == i21 && i18 < this.endDay) {
                    this.startMonth = i17;
                    this.startDay = i18;
                    this.startYear = i16;
                }
            }
        } else if (calendar != null && calendar2 != null) {
            this.startYear = calendar.get(1);
            this.endYear = calendar2.get(1);
            this.startMonth = calendar.get(2) + 1;
            this.endMonth = calendar2.get(2) + 1;
            this.startDay = calendar.get(5);
            this.endDay = calendar2.get(5);
        }
    }

    public void setSelectChangeCallback(ISelectTimeCallback iSelectTimeCallback) {
        this.mSelectChangeCallback = iSelectTimeCallback;
    }

    public void setStartYear(int i11) {
        this.startYear = i11;
    }

    public void setTextXOffset(int i11, int i12, int i13, int i14, int i15, int i16) {
        WheelView wheelView = this.wv_year;
        if (wheelView != null) {
            wheelView.setTextXOffset(i11);
        }
        WheelView wheelView2 = this.wv_month;
        if (wheelView2 != null) {
            wheelView2.setTextXOffset(i12);
        }
        WheelView wheelView3 = this.wv_day;
        if (wheelView3 != null) {
            wheelView3.setTextXOffset(i13);
        }
        WheelView wheelView4 = this.wv_hours;
        if (wheelView4 != null) {
            wheelView4.setTextXOffset(i14);
        }
        WheelView wheelView5 = this.wv_minutes;
        if (wheelView5 != null) {
            wheelView5.setTextXOffset(i15);
        }
        WheelView wheelView6 = this.wv_seconds;
        if (wheelView6 != null) {
            wheelView6.setTextXOffset(i16);
        }
    }

    public void setView(View view2) {
        this.view = view2;
    }

    public void setDividerColor(int i11) {
        this.dividerColor = i11;
        setDividerColor();
    }

    public void setDividerType(WheelView.DividerType dividerType2) {
        this.dividerType = dividerType2;
        setDividerType();
    }

    public void setLineSpacingMultiplier(float f11) {
        this.lineSpacingMultiplier = f11;
        setLineSpacingMultiplier();
    }

    public void setTextColorCenter(int i11) {
        this.textColorCenter = i11;
        setTextColorCenter();
    }

    public void setTextColorOut(int i11) {
        this.textColorOut = i11;
        setTextColorOut();
    }

    public void setTypeface(Typeface typeface2) {
        this.typeface = typeface2;
        setTypeface();
    }
}
