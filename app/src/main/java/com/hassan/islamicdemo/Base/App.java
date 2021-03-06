package com.hassan.islamicdemo.Base;

import android.app.Application;
import android.preference.PreferenceManager;

import com.hassan.islamicdemo.Home.DaoMaster;
import com.hassan.islamicdemo.Home.DaoSession;
import com.hassan.islamicdemo.Home.PrayerTime;
import com.hassan.islamicdemo.Home.PrayerTimeDao;
import com.hassan.islamicdemo.R;

import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

public class App extends Application {

    private DaoSession mDaoSession;

    @Override
    public void onCreate() {
        super.onCreate();

        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                .setFontAttrId(R.attr.fontPath)
                .setDefaultFontPath("jf_flat.ttf")
                .build());
        mDaoSession = new DaoMaster(new DaoMaster.DevOpenHelper(this, "prayer_times.db").getWritableDb()).newSession();
        addPrayersFirstTime();
    }

    public DaoSession getDaoSession() {
        return mDaoSession;
    }

    private void addPrayersFirstTime() {
        boolean isFirstLaunch = PreferenceManager.getDefaultSharedPreferences(this).getBoolean("first_time", true);
        if (isFirstLaunch) {
            PrayerTimeDao prayerTimeDao = getDaoSession().getPrayerTimeDao();
            prayerTimeDao.insert(new PrayerTime(null, PrayerTime.TAG_IMSAK, PrayerTime.NAME_IMSAK, "", false));
            prayerTimeDao.insert(new PrayerTime(null, PrayerTime.TAG_FAJR, PrayerTime.NAME_FAJR, "", false));
            prayerTimeDao.insert(new PrayerTime(null, PrayerTime.TAG_SUNRISE, PrayerTime.NAME_SUNRISE, "", false));
            prayerTimeDao.insert(new PrayerTime(null, PrayerTime.TAG_THUHR, PrayerTime.NAME_THUHR, "", false));
            prayerTimeDao.insert(new PrayerTime(null, PrayerTime.TAG_ASR, PrayerTime.NAME_ASR, "", false));
            prayerTimeDao.insert(new PrayerTime(null, PrayerTime.TAG_SUNSET, PrayerTime.NAME_SUNSET, "", false));
            prayerTimeDao.insert(new PrayerTime(null, PrayerTime.TAG_MAGHRIB, PrayerTime.NAME_MAGHRIB, "", false));
            prayerTimeDao.insert(new PrayerTime(null, PrayerTime.TAG_ISHA, PrayerTime.NAME_ISHA, "", false));
        }
        PreferenceManager.getDefaultSharedPreferences(this).edit().putBoolean("first_time", false).apply();
    }
}