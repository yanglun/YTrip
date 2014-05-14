
package com.oldyang.ui.personalsetting;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.oldyang.R;
import com.oldyang.ui.compoment.YTripHeaderView;
import com.oldyang.util.YTripActivityHelper;

/**
 * @author  杨铁心
 * @version 创建时间：2014-5-13 下午1:47:16
 */
public class PersonalSettingActivity extends Activity implements View.OnClickListener
{
    private LinearLayout ll_item_1, ll_item_2, ll_item_3, ll_item_4, ll_item_5, ll_item_6, ll_item_7;
    YTripHeaderView headerView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.ytrip_personal_setting);
        ll_item_1 = (LinearLayout) this.findViewById(R.id.ll_item_1);
        ll_item_2 = (LinearLayout) this.findViewById(R.id.ll_item_2);
        ll_item_3 = (LinearLayout) this.findViewById(R.id.ll_item_3);
        ll_item_4 = (LinearLayout) this.findViewById(R.id.ll_item_4);
        ll_item_5 = (LinearLayout) this.findViewById(R.id.ll_item_5);
        ll_item_6 = (LinearLayout) this.findViewById(R.id.ll_item_6);
        ll_item_7 = (LinearLayout) this.findViewById(R.id.ll_item_7);
        ll_item_1.setOnClickListener(this);
        ll_item_2.setOnClickListener(this);
        ll_item_3.setOnClickListener(this);
        ll_item_4.setOnClickListener(this);
        ll_item_5.setOnClickListener(this);
        ll_item_6.setOnClickListener(this);
        ll_item_7.setOnClickListener(this);
        headerView = (YTripHeaderView) findViewById(R.id.header);
        headerView.leftButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v)
    {
        SelectItemInfo info = new SelectItemInfo();
        ArrayList<String> list = new ArrayList<String>();
        switch (v.getId())
        {
            case R.id.ll_item_1:
                info.isRadio = true;
                info.title = "酒店价格";
                list.add("不限");
                list.add("200~300");
                list.add("300~500");
                list.add("500~1000");
                
                break;
            case R.id.ll_item_2:
                info.isRadio = false;
                info.title = "酒店星级";
                list.add("3星级酒店");
                list.add("4星级酒店");
                list.add("5星级酒店");
                break;
            case R.id.ll_item_3:
                info.isRadio = false;
                info.title = "酒店品牌";
                list.add("汉庭");
                list.add("如家");
                list.add("希尔顿");
                break;
            case R.id.ll_item_4:
                info.isRadio = false;
                info.title = "酒店设施";
                list.add("带泳池");
                list.add("含早餐");
                list.add("带健身房");
                break;
            case R.id.ll_item_5:
                info.isRadio = false;
                info.title = "地铁线路";
                list.add("1号线");
                list.add("2号线");
                list.add("3号线");
                list.add("4号线");
                list.add("5号线");
                list.add("6号线");
                list.add("7号线");
                list.add("8号线");
                list.add("9号线");
                list.add("10号线");
                break;
            case R.id.ll_item_6:
                info.isRadio = false;
                info.title = "出行方式";
                list.add("自驾");
                list.add("火车");
                break;
            case R.id.ll_item_7:
                info.isRadio = false;
                info.title = "所在商圈";
                list.add("陆家嘴");
                list.add("人民广场");
                break;
            default:
                break;
        }
        info.date = list;
        Bundle bundle = new Bundle();
        bundle.putSerializable("data", info);
        YTripActivityHelper.startActivity(this, PersonalSettingEditorActivity.class, bundle);
    }
}
