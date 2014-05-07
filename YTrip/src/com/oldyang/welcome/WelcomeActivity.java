/**
 * @author  杨铁心
 * @version 创建时间：2014-4-28 下午6:27:24
 */

package com.oldyang.welcome;

import com.oldyang.R;
import com.oldyang.main.MainActivity;
import com.oldyang.util.YTripActivityHelper;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;

public class WelcomeActivity extends Activity
{
    private static final int SPLASH_TIME = 2000; // 闪屏时间 2s
    private static final int MESSAGE_SPLASH_END = 100;

    protected class SplashHandler extends Handler
    {
        @Override
        public void handleMessage(Message msg)
        {
            switch (msg.what)
            {
                case MESSAGE_SPLASH_END:
                    splashDidEnd();
                    break;
                default:
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ytrip_welcome);
        new SplashHandler().sendEmptyMessageDelayed(MESSAGE_SPLASH_END, SPLASH_TIME);
    }

    private void splashDidEnd()
    {
        YTripActivityHelper.startActivity(this, MainActivity.class);
        finish();
    }
}
