/**
 * @author  杨铁心
 * @version 创建时间：2014-5-13 下午3:03:18
 */

package com.oldyang.ui.view.selectitem;

import com.oldyang.R;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SelectItemView extends LinearLayout
{
    private boolean bSelected = false;
    private TextView tv_option_item_name;
    private ImageView iv_item_selected;

    public SelectItemView(Context context)
    {
        super(context);
        init();
    }

    public SelectItemView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        init();
    }

    void init()
    {
        LayoutInflater.from(getContext()).inflate(R.layout.ytrip_select_item_view, this, true);
        tv_option_item_name = (TextView) this.findViewById(R.id.tv_option_item_name);
        iv_item_selected = (ImageView) this.findViewById(R.id.iv_item_selected);
        if (bSelected)
        {
            iv_item_selected.setVisibility(View.VISIBLE);
        }
        else
        {
            iv_item_selected.setVisibility(View.INVISIBLE);
        }
    }

    public void setOptionItemName(String name)
    {
        tv_option_item_name.setText(name);
    }

    public void click()
    {
        bSelected = !bSelected;
        if (bSelected)
        {
            iv_item_selected.setVisibility(View.VISIBLE);
        }
        else
        {
            iv_item_selected.setVisibility(View.INVISIBLE);
        }
    }
    
    public void setUnChecked(){
        bSelected = false;
        iv_item_selected.setVisibility(View.INVISIBLE);
    }
}
