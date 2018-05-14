package com.nalan.swipeitem.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/**
 * Created by ShiLiang on 2018/4/19.
 */

public class MyLinearLayout extends LinearLayout {

    private ViewGroup mChildAt;

    public MyLinearLayout(Context context) {
        this(context,null);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,0);
    }

    public MyLinearLayout(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        post(new Runnable() {
            @Override
            public void run() {
                mChildAt = (ViewGroup) getChildAt(1);
            }
        });
    }


    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        if (mChildAt instanceof SwipeItemLayoutNew){
            return mChildAt.onInterceptTouchEvent(ev);
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (mChildAt instanceof SwipeItemLayoutNew){
            return mChildAt.onTouchEvent(event);
        }
        return super.onTouchEvent(event);
    }
}
