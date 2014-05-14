/*
 * [文 件 名]:B5MSettingView.java
 * [创 建 人]:allenwang
 * [创建时间]:Nov 4, 2013
 * [编　　码]:UTF-8
 * [版　　权]:Copyright © 2012 B5Msoft Co,Ltd. 
*/

package com.oldyang.ui.view.selectitem;

import com.oldyang.R;
import com.oldyang.ui.personalsetting.SelectItemInfo;

import android.content.Context;

import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SelectListItemView extends LinearLayout implements View.OnClickListener
{
    public ImageView left_imageView, right_imageView;
    public TextView middle_textView;
    private SelectItemInfo mSelectItemInfo;

    public SelectListItemView(Context context)
    {
        super(context);
    }

    public SelectListItemView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    private void init()
    {
        this.setOrientation(VERTICAL);
        for (int i = 0; i < mSelectItemInfo.date.size(); i++)
        {
            SelectItemView item = new SelectItemView(this.getContext());
            item.setOptionItemName(mSelectItemInfo.date.get(i));
            item.setOnClickListener(this);
            item.setTag("item"+i);
            this.addView(item);
        }
    }

    public void setData(SelectItemInfo info)
    {
        mSelectItemInfo = info;
        init();
    }

    @Override
    public void onClick(View v)
    {
        if (mSelectItemInfo.isRadio)
        {
            setAllItemUnchecked();
        }
        ((SelectItemView) v).click();
    }

    private void setAllItemUnchecked()
    {
        for (int i = 0; i < mSelectItemInfo.date.size(); i++)
        {
            SelectItemView item = (SelectItemView) this.findViewWithTag("item"+i);
            item.setUnChecked();
        }
    }
}
