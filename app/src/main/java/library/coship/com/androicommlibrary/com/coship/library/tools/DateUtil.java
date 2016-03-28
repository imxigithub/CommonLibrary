package library.coship.com.androicommlibrary.com.coship.library.tools;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import android.database.DatabaseUtils;
import android.os.SystemClock;

public class DateUtil {

	private static DateUtil dateUtil;
	//private static SimpleDateFormat simpleDateFormat;
	
	private DateUtil(){
		//
		//simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	}
	
	public static DateUtil getInstance(){
		
		if(dateUtil==null){
			synchronized (DateUtil.class) {
				if(dateUtil==null){
					dateUtil = new DateUtil();
				}
			}
		}
		return dateUtil;
	}
	
	public String getCurrentTime(){
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss",Locale.CHINA);
		return simpleDateFormat.format(new Date(System.currentTimeMillis()));
	}
	
	/**
	 * 指定时间的输出格式 如 yyyy-MM-dd HH:mm:ss,默认此种格式输出
	 * @param format
	 */
	public String getCurrentTime(String format){
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format,Locale.CHINA);
		return simpleDateFormat.format(new Date(System.currentTimeMillis()));
	}
}
