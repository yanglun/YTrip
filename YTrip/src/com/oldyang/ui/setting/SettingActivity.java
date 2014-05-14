/**
 * @author  杨铁心
 * @version 创建时间：2014-5-7 下午1:33:17
 */

package com.oldyang.ui.setting;

import com.oldyang.R;
import com.oldyang.ui.compoment.YTripHeaderView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

public class SettingActivity extends Activity implements View.OnClickListener
{
    YTripHeaderView headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.ytrip_setting);
        headerView = (YTripHeaderView) findViewById(R.id.header);
        headerView.leftButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_header_left:
                this.finish();
                break;
            default:
                break;
        }
    }
}
