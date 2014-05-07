/*
 * [文 件 名]:B5MDisplayHelper.java
 * [创 建 人]:allenwang
 * [创建时间]:Oct 23, 2013
 * [编　　码]:UTF-8
 * [版　　权]:Copyright © 2012 B5Msoft Co,Ltd. 
*/

package com.oldyang.util;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 *	[简要描述]:
 *	[详细描述]:
 *	@author	[allenwang]
 *	@email	[allen.wang@b5m.com]
 *	@version	[版本号,Oct 23, 2013]
 *	@see		[B5MDisplayHelper]
 *	@package	[com.b5m.afw.internal]
 *	@since	[afw]
 */
public class DisplayHelper
{
    public static DisplayMetrics metrics;

    /**
     *  App启动时初始化
     */
    public static void init(Context context)
    {
        metrics = context.getResources().getDisplayMetrics();
//        B5MLog.d("w: " + getScreenWidth() + " -- h: " + getScreenHeight() + " -- density: " + getDensity());
    }

    /**
     *  [简要描述]: Display Density
     *  [详细描述]:
     *  @author [jarry]
     *  @email  [jarry.zhu@b5m.com]
     *  @date   [2012-12-4]
     *  @method [getDensity]
     *  @return
     *  @retruntype [float]
     *  @exception
     */
    public static float getDensity()
    {
        return metrics.density;
    }

    /**
     * 屏幕密度DPI
     */
    public static int getDensityDpi()
    {
        return metrics.densityDpi;
    }

    /**
     *  [简要描述]: 获取屏幕宽度（像素值）
     *  [详细描述]:
     *  @author [jarry]
     *  @email  [jarry.zhu@b5m.com]
     *  @date   [2012-10-29]
     *  @method [getScreenWidth]
     *  @return
     *  @retruntype [int]
     *  @exception
     */
    public static int getScreenWidth()
    {
        return metrics.widthPixels;
    }

    /**
     *  [简要描述]: 获取屏幕宽度（Dip值）
     *  [详细描述]: 
     *  @author     [jarry]
     *  @email      [jarry.zhu@b5m.com]
     *  @date       [2012-12-8]
     *  @method     [getWidthDip]
     *  @return
     *  @retruntype [float]
     *  @exception
     */
    public static float getWidthDip()
    {
        return (getScreenWidth() / getDensity());
    }

    /**
     *  [简要描述]:   获取屏幕高度（像素值）
     *  [详细描述]:
     *  @author     [jarry]
     *  @email      [jarry.zhu@b5m.com]
     *  @date       [2012-10-29]
     *  @method     [getScreenHeight]
     *  @return
     *  @retruntype [int]
     *  @exception
     */
    public static int getScreenHeight()
    {
        return metrics.heightPixels;
    }

    /**
     *  [简要描述]:   获取屏幕高度（Dip值）
     *  [详细描述]: 
     *  @author     [jarry]
     *  @email      [jarry.zhu@b5m.com]
     *  @date       [2012-12-8]
     *  @method     [getHeightDip]
     *  @return
     *  @retruntype [float]
     *  @exception
     */
    public static float getHeightDip()
    {
        return (getScreenHeight() / getDensity());
    }

    /**
     *  [简要描述]: 获取Dip值 [Int]
     *  [详细描述]:
     *  @author [jarry]
     *  @email  [jarry.zhu@b5m.com]
     *  @date   [2012-10-29]
     *  @method [getIntDip]
     *  @param value
     *  @return
     *  @retruntype [int]
     *  @exception
     */
    public static int getIntDip(float dpValue)
    {
        return (int) (metrics.density * dpValue + 0.5f);
    }

    /**
     *  [简要描述]: 获取Dip值 [Float]
     *  [详细描述]:
     *  @author [jarry]
     *  @email  [jarry.zhu@b5m.com]
     *  @date   [2012-12-4]
     *  @method [getFloatDip]
     *  @param i
     *  @return
     *  @retruntype [float]
     *  @exception
     */
    public float getFloatDip(int i)
    {
        return (metrics.density * i);
    }

    public static int getIntPx(float pxValue)
    {
        return (int) (pxValue / metrics.density + 0.5f);
    }
}
