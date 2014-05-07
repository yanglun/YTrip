/**
 * @author  杨铁心
 * @version 创建时间：2014-4-29 下午1:47:52
 */

package com.oldyang.main;

import com.oldyang.R;
import com.oldyang.ui.compoment.YTripHeaderView;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class HotelDetailActivity extends Activity implements View.OnClickListener
{
    private YTripHeaderView header;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.ytrip_hotel_detail);
        header = (YTripHeaderView) this.findViewById(R.id.header);
        header.rightButton.setOnClickListener(this);
        header.leftButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v)
    {
        // TODO Auto-generated method stub
        switch (v.getId())
        {
            case R.id.btn_header_left:
                this.finish();
                break;
            case R.id.btn_header_right:
                break;
            default:
                break;
        }
    }
}
