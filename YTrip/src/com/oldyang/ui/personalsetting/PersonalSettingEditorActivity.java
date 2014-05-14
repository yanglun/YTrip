/**
 * @author  杨铁心
 * @version 创建时间：2014-5-13 下午2:49:32
 */

package com.oldyang.ui.personalsetting;

import com.oldyang.R;
import com.oldyang.ui.compoment.YTripHeaderView;
import com.oldyang.ui.view.selectitem.SelectListItemView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class PersonalSettingEditorActivity extends Activity implements View.OnClickListener
{
    private SelectListItemView sliv_itemview;
    YTripHeaderView headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.ytrip_personal_setting_editor);
        headerView = (YTripHeaderView) findViewById(R.id.header);
        headerView.rightButton.setOnClickListener(this);
        headerView.leftButton.setOnClickListener(this);
        sliv_itemview = (SelectListItemView) this.findViewById(R.id.sliv_itemview);
        SelectItemInfo info = (SelectItemInfo) this.getIntent().getExtras().get("data");
        this.setTitle(info.title);
        sliv_itemview.setData(info);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_header_right:
                finish();
                break;
            case R.id.btn_header_left:
                finish();
                break;
            default:
                break;
        }
    }
}
