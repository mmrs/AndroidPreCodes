package com.infancyit.frameapp.core;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.EditText;

/**
 * Created by Siyam on 06-Jun-17.
 */

public class MyCustomEditText extends android.support.v7.widget.AppCompatEditText {
    public MyCustomEditText(Context context) {
        super(context);
        init();
    }

    public MyCustomEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public MyCustomEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),"fonts/Exo-Regular.otf");
        setTypeface(tf);
    }
}
