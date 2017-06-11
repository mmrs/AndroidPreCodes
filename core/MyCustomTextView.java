package com.infancyit.frameapp.core;

import android.content.Context;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.util.AttributeSet;

import com.infancyit.banglachord.R;

/**
 * Created by Siyam on 06-Jun-17.
 */
public class MyCustomTextView extends android.support.v7.widget.AppCompatTextView {

    public MyCustomTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public MyCustomTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyCustomTextView(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"fonts/Exo-Regular.otf");
        setTypeface(tf);
    }

}
