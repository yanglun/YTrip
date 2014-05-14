/**
 * @author  杨铁心
 * @version 创建时间：2014-4-30 上午11:26:30
 */

package com.oldyang.main.hotel;

import java.util.Calendar;

import com.oldyang.R;
import com.oldyang.ui.CityChoiceActivity;
import com.oldyang.ui.compoment.DatePickerDialog;
import com.oldyang.ui.compoment.YTripHeaderView;
import com.oldyang.util.CommUtil;
import com.oldyang.util.YTripActivityHelper;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class HotelBaseSearchActivity extends Activity implements View.OnClickListener
{
    RelativeLayout rl_city_choice;
    private DatePickerDialog datePickerDialog;
    private Calendar calendar = Calendar.getInstance();
    public static final String DATEPICKER_TAG = "datepicker";
    private TextView tv_date_start, tv_date_end;
    private YTripHeaderView headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.ytrip_hotel_base_search);
        headerView = (YTripHeaderView) findViewById(R.id.header);
        headerView.rightButton.setOnClickListener(this);
        headerView.leftButton.setOnClickListener(this);
        rl_city_choice = (RelativeLayout) this.findViewById(R.id.rl_city_choice);
        rl_city_choice.setOnClickListener(this);
        tv_date_start = (TextView) this.findViewById(R.id.tv_date_start);
        tv_date_start.setText(CommUtil.getDate(0));
        tv_date_end = (TextView) this.findViewById(R.id.tv_date_end);
        tv_date_end.setText(CommUtil.getDate(2));
    }

    @Override
    public void onClick(View v)
    {
        // TODO Auto-generated method stub
        switch (v.getId())
        {
            case R.id.rl_city_choice:
                YTripActivityHelper.startActivity(this, CityChoiceActivity.class);
                break;
            case R.id.btn_header_right:
                YTripActivityHelper.startActivity(this, HotelBaseSearchResultActivity.class);
                break;
            case R.id.btn_header_left:
                this.finish();
                break;
            default:
                break;
        }
    }
}
