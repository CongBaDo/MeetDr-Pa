package com.horus.edc.utils

import android.content.Context
import android.content.SharedPreferences

/**
 * Created by doba on 1/27/18.
 */
class PreferenceUtils {


    companion object {
        private  val prefName : String = "DataCap"

        /**
         * Save specific string to SharedPreferences
         * @param context The context of the preferences whose values are wanted.
         * @param key The name of the preference to modify.
         * @param value The menu_new value for the preference.
         */
        fun saveStringPref(context : Context, key: String, value: String){

            val pref = context.getSharedPreferences(prefName, 0)
            val editor : SharedPreferences.Editor = pref.edit()
            editor.putString(key, value)
            editor.apply()
        }

        /**
         * Save specific int to SharedPreferences
         * @param context The context of the preferences whose values are wanted.
         * @param key The name of the preference to modify.
         * @param value The menu_new value for the preference.
         */
        fun saveIntPref(context : Context, key: String, value: Int){

            val pref = context.getSharedPreferences(prefName, 0)
            val editor : SharedPreferences.Editor = pref.edit()
            editor.putInt(key, value)
            editor.apply()
        }

        /**
         * Save specific long to SharedPreferences
         * @param context The context of the preferences whose values are wanted.
         * @param key The name of the preference to modify.
         * @param value The menu_new value for the preference.
         */
        fun saveLongPref(context : Context, key: String, value: Long){

            val pref = context.getSharedPreferences(prefName, 0)
            val editor : SharedPreferences.Editor = pref.edit()
            editor.putLong(key, value)
            editor.apply()
        }

        /**
         * Save specific bool to SharedPreferences
         * @param context The context of the preferences whose values are wanted.
         * @param key The name of the preference to modify.
         * @param value The menu_new value for the preference.
         */
        fun saveBooleanPref(context : Context, key: String, value: Boolean){

            val pref = context.getSharedPreferences(prefName, 0)
            val editor : SharedPreferences.Editor = pref.edit()
            editor.putBoolean(key, value)
            editor.apply()
        }


        /**
         * get specific bool from SharedPreferences
         * @param context The context of the preferences whose values are wanted.
         * @param key The name of the preference to modify.
         * @param defValue The default value if reference not exist
         */
        fun getBooleanPref(context: Context, key: String, defValue: Boolean) : Boolean{
            val settings : SharedPreferences = context.getSharedPreferences(prefName, 0)
            return settings.getBoolean(key, defValue)
        }


        /**
         * get specific int from SharedPreferences
         * @param context The context of the preferences whose values are wanted.
         * @param key The name of the preference to modify.
         * @param defValue The default value if reference not exist
         */
        fun getIntPref(context: Context, key: String, defValue: Int) : Int{
            val settings = context.getSharedPreferences(prefName, 0)
            return settings.getInt(key, defValue)
        }

        /**
         * get specific string from SharedPreferences
         * @param context The context of the preferences whose values are wanted.
         * @param key The name of the preference to modify.
         * @param defValue The default value if reference not exist
         */
        fun getStringPref(context: Context, key: String, defValue: String) : String{
            val settings : SharedPreferences = context.getSharedPreferences(prefName, 0)
            return settings.getString(key, defValue)
        }


        /**
         * get specific long from SharedPreferences
         * @param context The context of the preferences whose values are wanted.
         * @param key The name of the preference to modify.
         * @param defValue The default value if reference not exist
         */
        fun getLongPref(context: Context, key: String, defValue: Long) : Long{
            val settings : SharedPreferences = context.getSharedPreferences(prefName, 0)
            return settings.getLong(key, defValue)
        }
    }
}
