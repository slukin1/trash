package com.huobi.homemarket.helper;

import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;

public class DividerHelper {
    public static void a(Canvas canvas, Drawable drawable, View view, ViewGroup.MarginLayoutParams marginLayoutParams) {
        int bottom = view.getBottom() + marginLayoutParams.bottomMargin;
        drawable.setBounds((view.getLeft() - marginLayoutParams.leftMargin) - drawable.getIntrinsicWidth(), bottom, view.getRight() + marginLayoutParams.rightMargin + drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight() + bottom);
        drawable.draw(canvas);
    }

    public static void b(Canvas canvas, Drawable drawable, View view, ViewGroup.MarginLayoutParams marginLayoutParams) {
        int bottom = view.getBottom() + marginLayoutParams.bottomMargin;
        drawable.setBounds(view.getLeft() - marginLayoutParams.leftMargin, bottom, view.getRight() + marginLayoutParams.rightMargin, drawable.getIntrinsicHeight() + bottom);
        drawable.draw(canvas);
    }

    public static void c(Canvas canvas, Drawable drawable, View view, ViewGroup.MarginLayoutParams marginLayoutParams) {
        int left = (view.getLeft() - marginLayoutParams.leftMargin) - drawable.getIntrinsicWidth();
        drawable.setBounds(left, (view.getTop() - marginLayoutParams.topMargin) - drawable.getIntrinsicHeight(), drawable.getIntrinsicWidth() + left, view.getBottom() + marginLayoutParams.bottomMargin + drawable.getIntrinsicHeight());
        drawable.draw(canvas);
    }

    public static void d(Canvas canvas, Drawable drawable, View view, ViewGroup.MarginLayoutParams marginLayoutParams) {
        int right = view.getRight() + marginLayoutParams.rightMargin;
        drawable.setBounds(right, (view.getTop() - marginLayoutParams.topMargin) - drawable.getIntrinsicHeight(), drawable.getIntrinsicWidth() + right, view.getBottom() + marginLayoutParams.bottomMargin + drawable.getIntrinsicHeight());
        drawable.draw(canvas);
    }
}
