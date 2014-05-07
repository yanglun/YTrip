/**
 * @author  杨铁心
 * @version 创建时间：2014-4-28 下午6:27:24
 */

package com.oldyang.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.oldyang.R;
import com.oldyang.bean.HotelBean;
import com.oldyang.main.hotel.HotelBaseSearchActivity;
import com.oldyang.setting.SettingActivity;
import com.oldyang.util.YTripActivityHelper;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView.ScaleType;
import android.widget.ListView;

public class MainActivity extends Activity implements OnItemClickListener, View.OnClickListener
{
    private ArrayList<Drawable> imgList = new ArrayList<Drawable>();
    private MyGallery gallery;
    private ListView lv_hot_hotel;
    private HotHotelAdapter mHotHotelAdapter;
    private ArrayList<HotelBean> mHotelArray;
    private LinearLayout ll_order_hotel, ll_setting;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ytrip_main);
        initMyGallery();
        initHotHotel();
        ll_order_hotel = (LinearLayout) this.findViewById(R.id.ll_order_hotel);
        ll_order_hotel.setOnClickListener(this);
        ll_setting = (LinearLayout) this.findViewById(R.id.ll_setting);
        ll_setting.setOnClickListener(this);
    }

    private void initImgList()
    {
        // 加载图片数据（本demo仅获取本地资源，实际应用中，可异步加载网络数据）
        imgList.add(this.getResources().getDrawable(R.drawable.logo));
        imgList.add(this.getResources().getDrawable(R.drawable.logo));
        imgList.add(this.getResources().getDrawable(R.drawable.logo));
        imgList.add(this.getResources().getDrawable(R.drawable.logo));
    }

    private void initMyGallery()
    {
        initImgList();
        //        ll_focus_indicator_container = (LinearLayout) viewQuery.findViewById(R.id.ll_focus_indicator_container);
        //        initFocusIndicatorContainer();
        gallery = (MyGallery) findViewById(R.id.banner_gallery);
        gallery.setAdapter(new ImageAdapter(this));
        gallery.setFocusable(true);
        //        gallery.setOnItemSelectedListener(new OnItemSelectedListener() {
        //            public void onItemSelected(AdapterView<?> arg0, View arg1, int selIndex, long arg3) {
        //                // 修改上一次选中项的背景
        //                selIndex = selIndex % imgList.size();
        //                ImageView preSelImg = (ImageView) ll_focus_indicator_container.findViewById(preSelImgIndex);
        //                preSelImg.setImageDrawable(mActivity.getResources().getDrawable(R.drawable.list_focused_holo));
        //                // 修改当前选中项的背景
        //                ImageView curSelImg = (ImageView) ll_focus_indicator_container.findViewById(selIndex);
        //                curSelImg.setImageDrawable(mActivity.getResources().getDrawable(R.drawable.list_longpressed_holo));
        //                preSelImgIndex = selIndex;
        //            }
        //
        //            public void onNothingSelected(AdapterView<?> arg0) {
        //            }
        //        });
        //        gallery.setOnItemClickListener(new OnItemClickListener() {
        //            @Override
        //            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
        //                Bundle bundle = new Bundle();
        //                B5MActivityHelper.startActivity(mActivity, ZhuantiTabsActivity.class, bundle);
        //            }
        //        });
        //        viewQuery.addClickListner(viewQuery.findViewById(R.id.ll_qdsbd), viewQuery.findViewById(R.id.ll_dhsc));
    }

    private void initHotHotel()
    {
        lv_hot_hotel = (ListView) this.findViewById(R.id.lv_hot_hotel);
        mHotelArray = new ArrayList<HotelBean>();
        for (int i = 0; i < 10; i++)
        {
            HotelBean hotel = new HotelBean();
            hotel.name = "锦江之心";
            mHotelArray.add(hotel);
        }
        mHotHotelAdapter = new HotHotelAdapter();
        mHotHotelAdapter.setData(mHotelArray);
        lv_hot_hotel.setAdapter(mHotHotelAdapter);
        lv_hot_hotel.setOnItemClickListener(this);
    }

    public class ImageAdapter extends BaseAdapter
    {
        private Context _context;

        public ImageAdapter(Context context)
        {
            _context = context;
        }

        public int getCount()
        {
            return Integer.MAX_VALUE;
        }

        public Object getItem(int position)
        {
            return position;
        }

        public long getItemId(int position)
        {
            return position;
        }

        public View getView(int position , View convertView , ViewGroup parent)
        {
            ViewHolder viewHolder = null;
            if (convertView == null)
            {
                viewHolder = new ViewHolder();
                ImageView imageView = new ImageView(_context);
                imageView.setAdjustViewBounds(true);
                imageView.setScaleType(ScaleType.FIT_XY);
                imageView.setLayoutParams(new Gallery.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
                convertView = imageView;
                viewHolder.imageView = (ImageView) convertView;
                convertView.setTag(viewHolder);
            }
            else
            {
                viewHolder = (ViewHolder) convertView.getTag();
            }
            viewHolder.imageView.setImageDrawable(imgList.get(position % imgList.size()));
            return convertView;
        }
    }

    private static class ViewHolder
    {
        ImageView imageView;
        TextView tv_hotel_name;
        TextView tv_hotel_star;
        TextView tv_hotel_desc;
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
                convertView = LayoutInflater.from(MainActivity.this).inflate(R.layout.ytrip_hothotel_list_item, null);
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

    @Override
    public void onClick(View v)
    {
        // TODO Auto-generated method stub
        switch (v.getId())
        {
            case R.id.ll_order_hotel:
                YTripActivityHelper.startActivity(this, HotelBaseSearchActivity.class);
                break;
            case R.id.ll_setting:
                YTripActivityHelper.startActivity(this, SettingActivity.class);
                break;
            default:
                break;
        }
    }
}
