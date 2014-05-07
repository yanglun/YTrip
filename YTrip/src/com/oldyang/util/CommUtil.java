
package com.oldyang.util;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Build;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.View;
import android.view.accessibility.AccessibilityManager;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("NewApi")
public class CommUtil
{
    public static String getDate(int offSetDay)
    {
        Date date = new Date();//声明一个日期[当前日期]
       
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.add(Calendar.DATE, offSetDay);
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        return f.format(cal.getTime());
    }

    /**
     * 获取星座
     */
    public static String getConstellation(Context context , int constellation)
    {
        //        B5MLog.i("constellation in = " + constellation);
        String[] constellationArr = { "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座", "水瓶座", "双鱼座" };
        if (constellation == 0 || constellation > 12)
            return constellationArr[0];
        return constellationArr[constellation - 1];
    }

    public static String getConstellationText(Context context , int month , int day)
    {
        int[] dayArr = new int[] { 20, 19, 21, 20, 21, 22, 23, 23, 23, 24, 23, 22 };
        String[] constellationArr = { "摩羯座", "水瓶座", "双鱼座", "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座" };
        return day < dayArr[month - 1] ? constellationArr[month - 1] : constellationArr[month];
    }

    public static int getConstellationIndex(Context context , String constellation)
    {
        int index = 1;
        String[] constellationArr = { "白羊座", "金牛座", "双子座", "巨蟹座", "狮子座", "处女座", "天秤座", "天蝎座", "射手座", "摩羯座", "水瓶座", "双鱼座" };
        List<String> tempList = Arrays.asList(constellationArr);
        if (tempList.contains(constellation))
        {
            for (int i = 0; i < tempList.size(); i++)
            {
                if (tempList.get(i).equals(constellation))
                {
                    return i + 1;
                }
            }
        }
        return index;
    }

    public static String NumberFormat(float km)
    {
        if (km >= 1)
            return String.format("%.1fkm", km);
        else if (km > 0.1 && km < 1)
        {
            km = km * 1000;
            return String.format("%.1fm", km);
        }
        return "很近";
    }

    public static int getAge(String age)
    {
        int ageY = 0;
        try
        {
            if (age != null && age.split("-").length > 0)
            {
                ageY = Integer.valueOf(age.split("-")[0]);
            }
        }
        catch (NumberFormatException e)
        {
            e.printStackTrace();
        }
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        return year - ageY;
    }

    public static void lengthFilter(final Context context , final EditText editText , final int max_length , final String err_msg)
    {
        InputFilter[] filters = new InputFilter[1];
        filters[0] = new InputFilter.LengthFilter(max_length)
        {
            @Override
            public CharSequence filter(CharSequence source , int start , int end , Spanned dest , int dstart , int dend)
            {
                int destLen = getCharacterNum(dest.toString()); //获取字符个数(一个中文算2个字座"
                int sourceLen = getCharacterNum(source.toString());
                if (destLen + sourceLen > max_length)
                {
                    Toast.makeText(context, err_msg, Toast.LENGTH_SHORT).show();
                    return "";
                }
                return source;
            }
        };
        editText.setFilters(filters);
    }

    /**

    * @description 获取一段字符串的字符个数（包含中英文，一个中文算2个字符）

    * @param content

    * @return

    */
    public static int getCharacterNum(final String content)
    {
        if (null == content || "".equals(content))
        {
            return 0;
        }
        else
        {
            return (content.length() + getChineseNum(content));
        }
    }

    /**

    * @description 返回字符串里中文字或者全角字符的个数

    * @param s

    * @return

    */
    public static int getChineseNum(String s)
    {
        int num = 0;
        char[] myChar = s.toCharArray();
        for (int i = 0; i < myChar.length; i++)
        {
            if ((char) (byte) myChar[i] != myChar[i])
            {
                num++;
            }
        }
        return num;
    }

    public static int getDaysInMonth(int month , int year)
    {
        switch (month)
        {
            default:
                throw new IllegalArgumentException("Invalid Month");
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return 31;
            case 3:
            case 5:
            case 8:
            case 10:
                return 30;
            case 1:
                if (year % 4 == 0)
                    return 29;
                return 28;
        }
    }

    public static ObjectAnimator getPulseAnimator(View view , float animVal1 , float animVal2)
    {
        Keyframe keyframe1 = Keyframe.ofFloat(0.0F, 1.0F);
        Keyframe keyframe2 = Keyframe.ofFloat(0.275F, animVal1);
        Keyframe keyframe3 = Keyframe.ofFloat(0.69F, animVal2);
        Keyframe keyframe4 = Keyframe.ofFloat(1.0F, 1.0F);
        ObjectAnimator animator = ObjectAnimator.ofPropertyValuesHolder(view,
                new PropertyValuesHolder[] {
                        PropertyValuesHolder.ofKeyframe("scaleX", new Keyframe[] { keyframe1, keyframe2, keyframe3, keyframe4 }),
                        PropertyValuesHolder.ofKeyframe("scaleY", new Keyframe[] { keyframe1, keyframe2, keyframe3, keyframe4 }) });
        animator.setDuration(544L);
        return animator;
    }

    public static boolean isJellybeanOrLater()
    {
        return Build.VERSION.SDK_INT >= 16;
    }

    public static void tryAccessibilityAnnounce(Object obj , Object announcement)
    {
        //TODO
    }

    public static boolean isTouchExplorationEnabled(AccessibilityManager accessibilityManager)
    {
        if (Build.VERSION.SDK_INT >= 14)
        {
            return accessibilityManager.isTouchExplorationEnabled();
        }
        else
        {
            return false;
        }
    }

    public static String getDeviceInfo(Context context)
    {
        try
        {
            org.json.JSONObject json = new org.json.JSONObject();
            android.telephony.TelephonyManager tm = (android.telephony.TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
            String device_id = tm.getDeviceId();
            android.net.wifi.WifiManager wifi = (android.net.wifi.WifiManager) context.getSystemService(Context.WIFI_SERVICE);
            String mac = wifi.getConnectionInfo().getMacAddress();
            json.put("mac", mac);
            if (TextUtils.isEmpty(device_id))
            {
                device_id = mac;
            }
            if (TextUtils.isEmpty(device_id))
            {
                device_id = android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
            }
            json.put("device_id", device_id);
            return json.toString();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return null;
    }

    /**
    * 读取图片属性：旋转的角座"
    * @param path 图片绝对路径
    * @return degree旋转的角座"
    */
    public static int readPictureDegree(ContentResolver cr , Uri uri)
    {
        Cursor cursor = cr.query(uri, null, null, null, null);// 根据Uri从数据库中找  
        int degree = 0;
        if (cursor != null)
        {
            cursor.moveToFirst();// 把游标移动到首位，因为这里的Uri是包含ID的所以是唯一的不需要循环找指向第一个就是了  
            //String filePath = cursor.getString(cursor.getColumnIndex("_data"));// 获取图片座" 
            String orientation = cursor.getString(cursor.getColumnIndex("orientation"));// 获取旋转的角座" 
            cursor.close();
            if (orientation != null && !"".equals(orientation))
            {
                degree = Integer.parseInt(orientation);
            }
        }
        return degree;
    }

    private static int computeSampleSize(BitmapFactory.Options options , int target)
    {
        int w = options.outWidth;
        int h = options.outHeight;
        int candidateW = w / target;
        int candidateH = h / target;
        int candidate = Math.max(candidateW, candidateH);
        if (candidate == 0)
            return 1;
        if (candidate > 1)
        {
            if ((w > target) && (w / candidate) < target)
                candidate -= 1;
        }
        if (candidate > 1)
        {
            if ((h > target) && (h / candidate) < target)
                candidate -= 1;
        }
        return candidate;
    }

    /**
     * 缩放图片
     * @param bmp
     * @param width
     * @param height
     * @return
     */
    public static Bitmap PicZoom(Bitmap bmp , int width , int height)
    {
        int bmpWidth = bmp.getWidth();
        int bmpHeght = bmp.getHeight();
        Matrix matrix = new Matrix();
        matrix.postScale((float) width / bmpWidth, (float) height / bmpHeght);
        return Bitmap.createBitmap(bmp, 0, 0, bmpWidth, bmpHeght, matrix, true);
    }

    public static String getConstellation(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int month = c.get(Calendar.MONTH) + 1;
        int day = c.get(Calendar.DAY_OF_MONTH);
        String s = "魔羯水瓶双鱼白羊金牛双子巨蟹狮子处女天秤天蝎射手魔羯";
        Integer[] arr = { 20, 19, 21, 21, 21, 22, 23, 23, 23, 23, 22, 22 };
        Integer num = month * 2 - (day < arr[month - 1] ? 2 : 0);
        return s.substring(num, num + 2) + "座";
    }

    public static int getAge(Date date)
    {
        return new Date().getYear() - date.getYear();
    }
}
