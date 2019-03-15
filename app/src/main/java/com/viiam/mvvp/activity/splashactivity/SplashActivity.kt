package com.viiam.mvvp.activity.splashactivity

import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.os.Bundle
import android.preference.PreferenceManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.viiam.mvvp.activity.guideactivity.GuideActivity

class SplashActivity : AppCompatActivity() {
    private val TAG = this::class.java.simpleName
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

//        when (checkAppStart()) {
//            AppStart.NORMAL -> {
//                Toast.makeText(applicationContext, "NORMAL", Toast.LENGTH_LONG).show()
//            }
//            AppStart.FIRST_TIME_VERSION -> {
//                Toast.makeText(applicationContext, "FIRST_TIME_VERSION", Toast.LENGTH_LONG).show()
//            }
//            AppStart.FIRST_TIME -> {
//                startActivity(Intent(this, GuideActivity::class.java))
//            }
//        }
        startActivity(Intent(this, GuideActivity::class.java))

        finish()
    }

    /**
     * Distinguishes different kinds of app starts:  *
     *
     * First start ever ([.FIRST_TIME])
     *
     *
     * First start in this version ([.FIRST_TIME_VERSION])
     *
     *
     * Normal app start ([.NORMAL])
     *
     *
     * @author schnatterer
     */
    enum class AppStart {
        FIRST_TIME, FIRST_TIME_VERSION, NORMAL
    }

    /**
     * The app version code (not the version name!) that was used on the last
     * start of the app.
     */
    private val LAST_APP_VERSION = "last_app_version"

    /**
     * Finds out started for the first time (ever or in the current version).<br></br>
     * <br></br>
     * Note: This method is **not idempotent** only the first call will
     * determine the proper result. Any subsequent calls will only return
     * [AppStart.NORMAL] until the app is started again. So you might want
     * to consider caching the result!
     *
     * @return the type of app start
     */
    private fun checkAppStart(): AppStart {
        val pInfo: PackageInfo
        val sharedPreferences = PreferenceManager
                .getDefaultSharedPreferences(this)
        var appStart = AppStart.NORMAL
        try {
            pInfo = packageManager.getPackageInfo(packageName, 0)
            val lastVersionCode = sharedPreferences
                    .getInt(LAST_APP_VERSION, -1)
            val currentVersionCode = pInfo.versionCode
            appStart = checkAppStart(currentVersionCode, lastVersionCode)
            // Update version in preferences
            sharedPreferences.edit()
                    .putInt(LAST_APP_VERSION, currentVersionCode).apply()
        } catch (e: PackageManager.NameNotFoundException) {
            Log.w(TAG, "Unable to determine current app version from pacakge manager. Defenisvely assuming normal app start.")
        }

        return appStart
    }

    private fun checkAppStart(currentVersionCode: Int, lastVersionCode: Int): AppStart {
        return when {
            lastVersionCode == -1 -> AppStart.FIRST_TIME
            lastVersionCode < currentVersionCode -> AppStart.FIRST_TIME_VERSION
            lastVersionCode > currentVersionCode -> {
                Log.d(TAG, "Current version code (" + currentVersionCode
                        + ") is less then the one recognized on last startup ("
                        + lastVersionCode
                        + "). Defenisvely assuming normal app start.")
                AppStart.NORMAL
            }
            else -> AppStart.NORMAL
        }
    }
}