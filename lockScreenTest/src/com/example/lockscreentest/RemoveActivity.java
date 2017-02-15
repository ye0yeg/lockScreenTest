package com.example.lockscreentest;

import android.app.Activity;
import android.app.admin.DevicePolicyManager;
import android.content.ComponentName;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class RemoveActivity extends Activity {
	private DevicePolicyManager dpm;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_remove);
		super.onCreate(savedInstanceState);
		dpm = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
		remove(null);
		
	}
	
	public void remove(View v){
		DevicePolicyManager dpm = (DevicePolicyManager) getSystemService(DEVICE_POLICY_SERVICE);
		ComponentName who = new ComponentName(this, DeviceAdminSample.class);
		dpm.removeActiveAdmin(who);//取消激活管理设备
		
		//卸载
		Intent remove = new Intent("android.intent.action.DELETE");
		remove.addCategory("android.intent.category.DEFAULT");
		remove.setData(Uri.parse("package:" + getPackageName()));
		startActivity(remove);//卸载用户apk的界面
	}

}
