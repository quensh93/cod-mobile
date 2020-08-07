package com.srp.carwash.component;

import android.content.Context;
import android.util.AttributeSet;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

public class SmartEditText extends EditText {

    private String XML_NAMESPACE_ANDROID = "http://schemas.android.com/apk/res/android";
    private int mMaxLength;
    private Context mContext;

    public SmartEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public SmartEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        mMaxLength = attrs.getAttributeIntValue(XML_NAMESPACE_ANDROID, "maxLength", -1);
        mContext = context;
    }

    public SmartEditText(Context context) {
        super(context);
    }


    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter) {
        super.onTextChanged(text, start, lengthBefore, lengthAfter);
        if (text.length() > 0 && text.length() == mMaxLength) {
            InputMethodManager imm1 = (InputMethodManager) mContext.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm1.hideSoftInputFromWindow(getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }
}