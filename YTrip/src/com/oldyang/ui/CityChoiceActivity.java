
package com.oldyang.ui;

import java.util.ArrayList;
import java.util.zip.Inflater;

import com.oldyang.R;
import com.oldyang.afw.widget.pulltorefresh.PullToRefreshBase.Mode;
import com.oldyang.afw.widget.pulltorefresh.PullToRefreshListView;
import com.oldyang.db.DbCityHelper;
import com.oldyang.ui.compoment.YTripHeaderView;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class CityChoiceActivity extends Activity implements View.OnClickListener
{
    private DbCityHelper mDbHelper;
    private ListView mListView;
    private CtiyAdapter mCtiyAdapter;
    private ArrayList<String> mArrayList;
    PullToRefreshListView mplv;
    YTripHeaderView headerView;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.ytrip_city_choice);
        mDbHelper = new DbCityHelper(this);
        mDbHelper.openDatabase();
        mArrayList = mDbHelper.getCity();
        mplv = (PullToRefreshListView) findViewById(R.id.lv_global_refreshandloadmore);
        mplv.setMode(Mode.DISABLED);
        mListView = mplv.getRefreshableView();
        mCtiyAdapter = new CtiyAdapter(this, mArrayList);
        mListView.setAdapter(mCtiyAdapter);
        headerView = (YTripHeaderView) findViewById(R.id.header);
        headerView.leftButton.setOnClickListener(this);
        
    }


    @Override
    public void onResume()
    {
        super.onResume();
        //        EventBus.getInstance().subscribes(this, EventName.USERINFO_SCHOOL_CHOICE_SUCCESS);
    }

    @Override
    public void onDestroy()
    {
        super.onDestroy();
        //        EventBus.getInstance().unSubscribes(this, EventName.USERINFO_SCHOOL_CHOICE_SUCCESS);
    }

    public class CtiyAdapter extends BaseAdapter
    {
        private Context mContext;
        private ArrayList mArrayList;

        public CtiyAdapter(Context context, ArrayList arrayList)
        {
            mContext = context;
            mArrayList = arrayList;
        }

        protected void bindData(int position , CityItem baseViewHolderItem)
        {
            final String mProvince = (String) getItem(position);
            final CityItem mCityItem = (CityItem) baseViewHolderItem;
            mCityItem.tv_province_name.setText(mProvince);
        }

        @Override
        public View getView(int position , View convertView , ViewGroup parent)
        {
            CityItem mCityItem;
            if (null == convertView)
            {
                mCityItem = new CityItem();
                convertView = LayoutInflater.from(mContext).inflate(R.layout.ytrip_city_item, null);
                mCityItem.tv_province_name = (TextView) convertView.findViewById(R.id.tv_province_name);
                convertView.setTag(mCityItem);
            }
            else
            {
                mCityItem = (CityItem) convertView.getTag();
            }
            bindData(position, mCityItem);
            return convertView;
        }

        @Override
        public int getCount()
        {
            // TODO Auto-generated method stub
            return mArrayList.size();
        }

        @Override
        public Object getItem(int position)
        {
            // TODO Auto-generated method stub
            return mArrayList.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            // TODO Auto-generated method stub
            return 0;
        }
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.btn_header_left:
                finish();
                break;
            default:
                break;
        }
    }

    class CityItem
    {
        TextView tv_province_name;
    }
}