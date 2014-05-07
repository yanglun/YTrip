/**
 * @author  杨铁心
 * @version 创建时间：2014-4-30 上午11:26:30
 */

package com.oldyang.main.hotel;

import java.util.ArrayList;

import com.oldyang.R;
import com.oldyang.bean.HotelBean;
import com.oldyang.main.HotelDetailActivity;
import com.oldyang.util.YTripActivityHelper;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class HotelBaseSearchResultActivity extends Activity implements OnItemClickListener, View.OnClickListener
{
    private ListView lv_hotel;
    private ArrayList<HotelBean> mHotelArray;
    private HotHotelAdapter mHotHotelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        this.setContentView(R.layout.ytrip_hotel_base_search_result);
        initHotHotel();
    }

    @Override
    public void onClick(View v)
    {
        // TODO Auto-generated method stub
        switch (v.getId())
        {
        }
    }

    private void initHotHotel()
    {
        lv_hotel = (ListView) this.findViewById(R.id.lv_hotel);
        mHotelArray = new ArrayList<HotelBean>();
        for (int i = 0; i < 10; i++)
        {
            HotelBean hotel = new HotelBean();
            hotel.name = "锦江之心";
            mHotelArray.add(hotel);
        }
        mHotHotelAdapter = new HotHotelAdapter();
        mHotHotelAdapter.setData(mHotelArray);
        lv_hotel.setAdapter(mHotHotelAdapter);
        lv_hotel.setOnItemClickListener(this);
    }

    class HotHotelAdapter<T> extends BaseAdapter
    {
        private ArrayList<T> data;

        void setData(ArrayList<T> data)
        {
            this.data = data;
        }

        @Override
        public int getCount()
        {
            return data.size();
        }

        @Override
        public HotelBean getItem(int position)
        {
            return (HotelBean) data.get(position);
        }

        @Override
        public long getItemId(int position)
        {
            return position;
        }

        @Override
        public View getView(final int position , View convertView , ViewGroup parent)
        {
            ViewHolder holder;
            if (convertView == null)
            {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(HotelBaseSearchResultActivity.this).inflate(R.layout.ytrip_hothotel_list_item, null);
                holder.tv_hotel_name = (TextView) convertView.findViewById(R.id.tv_hotel_name);
                holder.tv_hotel_star = (TextView) convertView.findViewById(R.id.tv_hotel_star);
                holder.tv_hotel_desc = (TextView) convertView.findViewById(R.id.tv_hotel_desc);
                convertView.setTag(holder);
            }
            else
            {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.tv_hotel_name.setText(this.getItem(position).name);
            return convertView;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> arg0 , View arg1 , int arg2 , long arg3)
    {
        YTripActivityHelper.startActivity(this, HotelDetailActivity.class);
    }

    private static class ViewHolder
    {
        ImageView imageView;
        TextView tv_hotel_name;
        TextView tv_hotel_star;
        TextView tv_hotel_desc;
    }
}
