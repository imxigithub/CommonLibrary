package library.coship.com.androicommlibrary.com.coship.library.tools;

import java.io.File;
import java.util.Set;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;


/**
 * SharePreference 工具类
 * @author Kelly
 * 
 * TODO 加入多进程的SharePreference共享
 *
 */
public class SharePreferenceUtil {
	
	
	private Context mContext;
	private SharedPreferences sp;
	private SharedPreferences.Editor editor;
	
	public SharePreferenceUtil(Context context,String  name, int mode){
			mContext = context;
			sp = mContext.getSharedPreferences(name, mode);
			editor = sp.edit();
	}
	
	public void putInt(String key,int value)throws IllegalArgumentException{
		try {
			if(!TextUtils.isEmpty(key)){
				editor.putInt(key, value);
				editor.apply();
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	public void putLong(String key,long value){
		try {
			if(!TextUtils.isEmpty(key)){
				editor.putLong(key, value);
				editor.apply();
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	
	public void putFloat(String key,float value){
		try {
			if(!TextUtils.isEmpty(key)){
				editor.putFloat(key, value);
				editor.apply();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void putBoolean(String key,boolean value){
		try {
			if(!TextUtils.isEmpty(key)){
				editor.putBoolean(key, value);
				editor.apply();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void putString(String key,String value){
		try {
			if(!TextUtils.isEmpty(key)){
				editor.putString(key, value);
				editor.apply();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void putSet(String key,Set values){
		try {
			if(!TextUtils.isEmpty(key)){
				editor.putStringSet(key, values);
				editor.apply();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public int getInt(String key,int defValue){
			return sp.getInt(key, defValue);
	}
	
	public long getLong(String key,long defValue){
		return sp.getLong(key, defValue);
	}
	
	public boolean getBoolean(String key,boolean defValue){
		return sp.getBoolean(key, defValue);
	}
	
	public String getString(String key,String defValue){
		return sp.getString(key, defValue);
	}
	
	public float getFloat(String key,float defValue){
		return sp.getFloat(key, defValue);
	}
	
	public Set<?> getSet(String key,Set defValues){
		return sp.getStringSet(key, defValues);
	}
	
	public void clearSharePreference(){
		
		if(editor!=null){
				editor.clear();
		}
	}
	
	public boolean deleteSharePreference(String path){
		
			boolean result  = false;
			if(!TextUtils.isEmpty(path)){
					File file = new File(path);
					if(file.exists()){
							if(file.delete()){
								result = true;
							}
					}
			}
		return result;
	}
	
}
