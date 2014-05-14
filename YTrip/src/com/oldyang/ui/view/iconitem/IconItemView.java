/*
 * [文 件 名]:B5MSettingView.java
 * [创 建 人]:allenwang
 * [创建时间]:Nov 4, 2013
 * [编　　码]:UTF-8
 * [版　　权]:Copyright © 2012 B5Msoft Co,Ltd. 
*/

package com.oldyang.ui.view.iconitem;


import com.oldyang.R;
import com.oldyang.util.DisplayHelper;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;



/**
 *	[简要描述]:
 *	[详细描述]:
 *	@author	[allenwang]
 *	@email	[allen.wang@b5m.com]
 *	@version	[版本号,Nov 4, 2013]
 *	@see		[B5MSettingView]
 *	@package	[com.b5m.afw.view]
 *	@since	[afw]
 */
public class IconItemView extends RelativeLayout
{
    public ImageView left_imageView, right_imageView;
    public TextView middle_textView;
//    private B5MViewQuery viewQuery = new B5MViewQuery();;

    public IconItemView(Context context)
    {
        super(context);
        init(context, null, 0);
    }

    public IconItemView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init(context, attrs, 0);
    }

    public IconItemView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        init(context, attrs, defStyle);
    }

    private void init(Context context , AttributeSet attrs , int defStyle)
    {
        LayoutInflater.from(getContext()).inflate(R.layout.ytrip_icon_item_view, this, true);

        left_imageView = (ImageView)findViewById(R.id.leftImageView);
        right_imageView = (ImageView)findViewById(R.id.rightImageView);
        middle_textView = (TextView)findViewById(R.id.middle_textview);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.custom);
        int width = DisplayHelper.getIntDip(a.getInteger(R.styleable.custom_leftImageHeight, 30));
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(width, width);
        left_imageView.setLayoutParams(params);
        left_imageView.setImageResource(a.getResourceId(R.styleable.custom_leftImage, android.R.drawable.ic_dialog_info));
        left_imageView.setVisibility(a.getBoolean(R.styleable.custom_showLeft, true) ? View.VISIBLE : View.INVISIBLE);
        right_imageView.setVisibility(a.getBoolean(R.styleable.custom_showRight, true) ? View.VISIBLE : View.INVISIBLE);
        middle_textView.setText(a.getString(R.styleable.custom_text));
        int id = a.getResourceId(R.styleable.custom_item_background, 0);
        if (id != 0)
        {
            RelativeLayout item_relative = (RelativeLayout) findViewById(R.id.item_relative);
            item_relative.setBackgroundResource(id);
        }
        a.recycle();
    }
}
