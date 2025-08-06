package com.hbg.module.exchange.grid.ui;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import cd.a0;
import cd.b0;
import cd.y;
import cd.z;
import com.google.android.material.appbar.AppBarLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.widgets.CommonEditText;
import com.hbg.module.exchange.R$drawable;
import com.hbg.module.exchange.R$id;
import com.hbg.module.exchange.R$layout;
import com.hbg.module.exchange.R$styleable;
import com.huobi.view.keyboard.CustomBoardView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import i6.n;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class GridTradeInputView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public GridTradeActivity f19559b;

    /* renamed from: c  reason: collision with root package name */
    public View f19560c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f19561d;

    /* renamed from: e  reason: collision with root package name */
    public CommonEditText f19562e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f19563f;

    /* renamed from: g  reason: collision with root package name */
    public b f19564g;

    public class a implements TextWatcher {
        public a() {
        }

        public void afterTextChanged(Editable editable) {
            if (GridTradeInputView.this.f19564g != null) {
                GridTradeInputView.this.f19564g.onTextChanged(GridTradeInputView.this.getText());
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }
    }

    public interface b {
        void a(boolean z11, String str);

        void onTextChanged(String str);
    }

    public GridTradeInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void g(CustomBoardView customBoardView, int i11, int i12) {
        int height = customBoardView.getHeight();
        int f11 = n.f(this.f19562e.getContext());
        int a11 = PixelUtils.a(30.0f);
        int i13 = f11 - height;
        if (i13 < i11 + i12 + a11) {
            l(((i13 - i11) - i12) - a11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void h(View view, boolean z11) {
        b bVar = this.f19564g;
        if (bVar != null) {
            bVar.a(z11, getText());
        }
        if (z11) {
            f();
            this.f19560c.setBackgroundResource(R$drawable.shape_grid_trade_input_bg_focus);
            return;
        }
        this.f19560c.setBackgroundResource(R$drawable.shape_grid_trade_input_bg);
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public /* synthetic */ void i(View view) {
        this.f19562e.requestFocus();
        this.f19559b.Nh().showKeyboard(this.f19562e);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static /* synthetic */ void j(AppBarLayout appBarLayout, AppBarLayout.Behavior behavior) {
        try {
            Method declaredMethod = appBarLayout.getClass().getDeclaredMethod("onOffsetChanged", new Class[]{Integer.TYPE});
            declaredMethod.setAccessible(true);
            declaredMethod.invoke(appBarLayout, new Object[]{Integer.valueOf(behavior.getTopAndBottomOffset())});
        } catch (NoSuchMethodException e11) {
            e11.printStackTrace();
        } catch (IllegalAccessException e12) {
            e12.printStackTrace();
        } catch (InvocationTargetException e13) {
            e13.printStackTrace();
        } catch (Exception e14) {
            e14.printStackTrace();
        }
    }

    public final void f() {
        int[] iArr = new int[2];
        this.f19562e.getLocationOnScreen(iArr);
        int i11 = iArr[1];
        int height = this.f19562e.getHeight();
        CustomBoardView boardView = this.f19559b.Nh().getBoardView();
        boardView.post(new b0(this, boardView, i11, height));
    }

    public String getText() {
        Editable text = this.f19562e.getText();
        return text != null ? text.toString() : "";
    }

    public void k() {
        this.f19562e.clearFocus();
    }

    public void l(int i11) {
        AppBarLayout appBarLayout = (AppBarLayout) this.f19559b.findViewById(R$id.id_grid_trade_appbar_layout);
        if (appBarLayout != null) {
            CoordinatorLayout.Behavior f11 = ((CoordinatorLayout.LayoutParams) appBarLayout.getLayoutParams()).f();
            if (f11 instanceof AppBarLayout.Behavior) {
                AppBarLayout.Behavior behavior = (AppBarLayout.Behavior) f11;
                behavior.setTopAndBottomOffset(behavior.getTopAndBottomOffset() + i11);
                appBarLayout.post(new a0(appBarLayout, behavior));
            }
        }
    }

    public void setActivity(GridTradeActivity gridTradeActivity) {
        this.f19559b = gridTradeActivity;
        gridTradeActivity.Nh().attach(this.f19559b).registerInput(this.f19562e);
    }

    public void setCallback(b bVar) {
        this.f19564g = bVar;
    }

    public void setFloatPrecision(int i11) {
        this.f19562e.setFloatPrecision(i11);
    }

    public void setInputHint(String str) {
        if (str == null) {
            str = "";
        }
        this.f19562e.setHint(str);
    }

    public void setInputText(String str) {
        if (str == null) {
            str = "";
        }
        this.f19562e.setText(str);
    }

    public void setInputType(int i11) {
        this.f19562e.setInputType(i11);
    }

    public void setIntPrecision(int i11) {
        this.f19562e.setIntPrecision(i11);
    }

    public void setTitle(String str) {
        if (str == null) {
            str = "";
        }
        this.f19561d.setText(str);
    }

    public void setUnit(String str) {
        if (str == null) {
            str = "";
        }
        this.f19563f.setText(str);
    }

    public GridTradeInputView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.GridTradeInputView, i11, 0);
        String string = obtainStyledAttributes.getString(R$styleable.GridTradeInputView_grid_trade_input_title);
        String string2 = obtainStyledAttributes.getString(R$styleable.GridTradeInputView_grid_trade_input_hint);
        String string3 = obtainStyledAttributes.getString(R$styleable.GridTradeInputView_grid_trade_input_text);
        String string4 = obtainStyledAttributes.getString(R$styleable.GridTradeInputView_grid_trade_input_unit);
        obtainStyledAttributes.recycle();
        FrameLayout.inflate(context, R$layout.grid_trade_input_view, this);
        this.f19560c = findViewById(R$id.id_grid_trade_input_view);
        this.f19561d = (TextView) findViewById(R$id.id_grid_trade_input_title);
        this.f19562e = (CommonEditText) findViewById(R$id.id_grid_trade_input_et);
        this.f19563f = (TextView) findViewById(R$id.id_grid_trade_input_unit);
        setTitle(string);
        setInputHint(string2);
        setInputText(string3);
        setUnit(string4);
        this.f19562e.addTextChangedListener(new a());
        this.f19562e.setOnFocusChangeListener(new z(this));
        this.f19560c.setOnClickListener(new y(this));
    }
}
