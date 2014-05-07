/**
 * @author  杨铁心
 * @version 创建时间：2014-4-29 下午1:51:46
 */

package com.oldyang.ui.compoment;

import com.oldyang.R;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class YTripHeaderView extends RelativeLayout
{
    public Button leftButton, rightButton;
    public TextView titleView, rightText;

    public YTripHeaderView(Context context)
    {
        this(context, null, 0);
    }

    public YTripHeaderView(Context context, AttributeSet attrs)
    {
        this(context, attrs, 0);
    }

    public YTripHeaderView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context , AttributeSet attrs , int defStyle)
    {
        LayoutInflater mInflater = LayoutInflater.from(context);
        //        B5MDisplayHelper.init(context);
        mInflater.inflate(R.layout.ytrip_header_view, this, true);
        //        viewQuery.setView(this);
        leftButton = (Button) findViewById(R.id.btn_header_left);
        rightButton = (Button) findViewById(R.id.btn_header_right);
        //        leftImageView = (ImageView) viewQuery.findViewById(R.id.leftImageView);
        //        leftImageViewNet = (RoundedImageView) viewQuery.findViewById(R.id.leftImageViewNet);
        //        rightImageView = viewQuery.findImageView(R.id.rightImageView);
        titleView = (TextView) this.findViewById(R.id.tv_header_title);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.custom);
        titleView.setText(a.getString(R.styleable.custom_text));
        leftButton.setVisibility(a.getBoolean(R.styleable.custom_showLeft, true) ? View.VISIBLE : View.INVISIBLE);
        rightButton.setVisibility(a.getBoolean(R.styleable.custom_showRight, true) ? View.VISIBLE : View.INVISIBLE);
        rightButton.setText(a.getString(R.styleable.custom_rightText));
        leftButton.setText(a.getString(R.styleable.custom_leftText));
        //        leftImageView.setBackgroundResource(a.getResourceId(R.styleable.custom_leftImage, R.drawable.back_btn_selector));
        //        rightImageView.setBackgroundResource(a.getResourceId(R.styleable.custom_rightImage, R.drawable.setting_right_btn_selector));
        //        rightText = viewQuery.findTextView(R.id.right_text);
        //        right_button = (Button) viewQuery.findViewById(R.id.rightButton);
        //        rightText.setText(a.getString(R.styleable.custom_rightText));
        //        right_button.setBackgroundResource(a.getResourceId(R.styleable.custom_rightButton, R.drawable.btn_finish));
        //        right_button.setText(a.getString(R.styleable.custom_rightText));
        //        if (a.getBoolean(R.styleable.custom_showRightText, false))
        //        {
        //            rightText.setVisibility(View.VISIBLE);
        //        }
        //        if (a.getBoolean(R.styleable.custom_showRightButton, false))
        //        {
        //            right_button.setVisibility(View.VISIBLE);
        //        }
        //        if (a.getBoolean(R.styleable.custom_showRightImageView, false))
        //        {
        //            rightImageView.setVisibility(View.VISIBLE);
        //        }
        //        if (a.getBoolean(R.styleable.custom_leftImageFromNet, false))
        //        {
        //            leftImageViewNet.setVisibility(View.VISIBLE);
        //            leftImageView.setVisibility(View.INVISIBLE);
        //        }
        //        titleView.setText(a.getString(R.styleable.custom_text));
        a.recycle();
    }
}
