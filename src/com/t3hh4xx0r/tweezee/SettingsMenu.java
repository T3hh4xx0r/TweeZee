package com.t3hh4xx0r.tweezee;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;
import android.preference.PreferenceManager;
import android.preference.PreferenceScreen;
import android.view.MenuItem;

public class SettingsMenu extends PreferenceActivity{
    private CheckBoxPreference mBoot;
    private CheckBoxPreference mNotify;
    SharedPreferences prefs;
	public void onCreate(Bundle icicle) {
		super.onCreate(icicle);
		addPreferencesFromResource(R.layout.settings);
		prefs = PreferenceManager.getDefaultSharedPreferences(this);

		mBoot = (CheckBoxPreference) findPreference("boot");
		mNotify = (CheckBoxPreference) findPreference("notify");
	}
	
    public boolean onPreferenceTreeClick(PreferenceScreen preferenceScreen, Preference preference) {
	    boolean value;
	    Editor e = prefs.edit();
	    if (preference == mBoot){
            value = mBoot.isChecked();
            e.putBoolean("boot", value);            
	    } else if (preference == mNotify) {
            value = mNotify.isChecked();
            e.putBoolean("notify", value); 
	    }
        e.commit();
	return true;
   }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
        case android.R.id.home:
            Intent intent = new Intent(this, MainActivity.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
            return true;
            default:
	            return super.onOptionsItemSelected(item);
	    }
	}
}