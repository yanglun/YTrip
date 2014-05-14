/**
 * @author  杨铁心
 * @version 创建时间：2014-4-28 下午8:12:11
 */
package com.oldyang.util;

import com.oldyang.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;


public class YTripActivityHelper
{
    /**
     * @param context
     * @param clazz
     */
    public static void startActivity(Activity activity , Class<?> clazz)
    {
        Intent intent = new Intent();
        intent.setClass(activity, clazz);
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.activity_in_right, R.anim.activity_out_left);
    }
    
    /**
     * @param context
     * @param clazz
     * @param bundle
     */
    public static void startActivity(Activity activity , Class<?> clazz , Bundle bundle)
    {
        Intent intent = new Intent();
        intent.setClass(activity, clazz);
        if (bundle != null)
        {
            intent.putExtras(bundle);
        }
        activity.startActivity(intent);
        activity.overridePendingTransition(R.anim.activity_in_right, R.anim.activity_out_left);
    }
    
}

