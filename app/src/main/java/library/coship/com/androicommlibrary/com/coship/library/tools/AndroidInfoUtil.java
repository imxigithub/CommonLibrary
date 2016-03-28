package library.coship.com.androicommlibrary.com.coship.library.tools;

import android.content.Context;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.os.SystemClock;
import android.util.Log;


/**
 * 获取Android信息
 * @author Kelly
 *
 */
public class AndroidInfoUtil {
	
	
	public static final String TAG = "AndroidInfoUtil";
	
	private static AndroidInfoUtil androidInfoUtil;
	
	private AndroidInfoUtil(){
	}
	
	public static AndroidInfoUtil getInstance(){
		
		if(androidInfoUtil==null){
			synchronized (AndroidInfoUtil.class) {
				if(androidInfoUtil==null){
						androidInfoUtil = new AndroidInfoUtil();
				}
			}
		}
		return androidInfoUtil;
	}

	/**
	 * 获取Wifi地址
	 * @param context
	 * @return
	 */
	public String getMacAddr(Context context){
		
		String macAddr = "";
		WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		WifiInfo wifiInfo = wifiManager.getConnectionInfo();
		if(wifiInfo!=null){
			macAddr = wifiInfo.getMacAddress();
		}
		return macAddr;
	}
	
   /**
    * 获取开机时间
    * @return
    */
	public String getBootTime(){
		//实现方式1
		StringBuffer stringBuffer = new StringBuffer();
		int hours = 0;
		int minute = 0;
		int second = 0;
		long bootTime = SystemClock.elapsedRealtime()/1000;  //convert to second
		 hours = (int)(bootTime/3600);  //小时
		if(bootTime%3600>60){
				 minute = ((int)(bootTime%3600)/60);
				 second = ((int)(bootTime%3600%60));
		}
		stringBuffer.append(hours).append("时")
		.append(minute).append("分")
		.append(second).append("秒");
		
		return stringBuffer.toString();
		
		//实现方式2
		/*	int hour = (int)(bootTime/3600);
			int minute = (int)(bootTime/60%60);*/
	}
	
	/**
	 * 获取系统信息
	 * @return
	 */
	public String getSystemInfo(){
		StringBuilder stringBuilder = new StringBuilder();
		stringBuilder.append("----------").append("SystemInof").append("----------")
		.append("\nID: ").append(Build.ID)  //ID
		.append("\nBRAND: ").append(Build.BRAND)  //
		.append("\nMODEL: ").append(Build.MODEL)  //model
		.append("\nRELEASE: ").append(Build.VERSION.RELEASE)  //release version
		.append("\nSDK: ").append(Build.VERSION.SDK_INT); //sdk version
		
		stringBuilder.append("\n----------").append("Other").append("----------")
		.append("\nBOARD: ").append(Build.BOARD)
		.append("\nPRODUCT: ").append(Build.PRODUCT)
		.append("\nDEVICE: ").append(Build.DEVICE)
		.append("\nFINGERPRINT: ").append(Build.FINGERPRINT)
		.append("\nHOSTS: ").append(Build.HOST)
		.append("\nTAGS: ").append(Build.TAGS)
		.append("\nTYPE: ").append(Build.TYPE)
		.append("\nTIME: ").append(Build.TIME)
		.append("\nINCREMENTAL: ").append(Build.VERSION.INCREMENTAL);
		
		if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.GINGERBREAD){
			stringBuilder.append("\nSERIAL: ").append(Build.SERIAL);
		}
		return stringBuilder.toString();
	}
}
