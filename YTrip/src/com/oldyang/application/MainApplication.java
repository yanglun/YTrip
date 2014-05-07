
package com.oldyang.application;

import com.oldyang.util.DisplayHelper;

import android.app.Application;
import android.content.Context;

public class MainApplication extends Application
{
    private static MainApplication _instance;

    @Override
    public void onCreate()
    {
        // TODO Auto-generated method stub
        super.onCreate();
        _instance = this;
        DisplayHelper.init(getApplicationContext());
        //        B5MNetworkUtils.CURRENT_NETWORK = B5MNetworkUtils.getNetworkState(getApplicationContext());
        //        GAServiceManager.getInstance();
        //        EasyTracker.getInstance().setContext(this);
        //        B5MDataTracker.uploadChannel(B5MMainifestHelper.getChannelCode(this));
        //        MobclickAgent.onEventBegin(getApplicationContext(), "start");
        //        initImageLoader(this);
    }

    public static MainApplication getInstance()
    {
        return _instance;
    }
    //    public static void initImageLoader(Context context)
    //    {
    //        // This configuration tuning is custom. You can tune every option, you may tune some of them,
    //        // or you can create default configuration by
    //        //  ImageLoaderConfiguration.createDefault(this);
    //        // method.
    //        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).threadPriority(Thread.NORM_PRIORITY - 2).denyCacheImageMultipleSizesInMemory().discCacheFileNameGenerator(new Md5FileNameGenerator())
    //                .tasksProcessingOrder(QueueProcessingType.LIFO).writeDebugLogs() // Remove for release app
    //                .build();
    //        // Initialize ImageLoader with configuration.
    //        ImageLoader.getInstance().init(config);
    //    }
}
