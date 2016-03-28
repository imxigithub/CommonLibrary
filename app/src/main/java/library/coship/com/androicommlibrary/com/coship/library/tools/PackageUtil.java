package library.coship.com.androicommlibrary.com.coship.library.tools;

import java.io.File;
import java.util.List;
import java.util.Map;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.text.TextUtils;
import android.widget.Toast;


/**
 * 应用的安装 卸载 静默安装
 * @author Kelly
 *
 */
public class PackageUtil {
	
	/**
	 * 调用系统安装应用
	 * @param path
	 * @return
	 */
	public static boolean install(Context context,String path){
		
		boolean result  = false;
		
		if(!TextUtils.isEmpty(path)){
				return result;
		}
		
		File file = new File(path);
		if(file==null||!file.exists()||!file.isFile()){
			return result;
		}
		
		Intent intent = new Intent(Intent.ACTION_VIEW);
		intent.setDataAndType(Uri.fromFile(file), "application/vnd.android.package-archive");
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(intent);
		return true;
	}
	
	/**
	 * 调用系统卸载应用
	 * @return
	 */
	public static boolean uninstall(Context context,String packageName){
		
		boolean result  = false;
		if(TextUtils.isEmpty(packageName)){
				return result;
		}
		Intent intent = new Intent(Intent.ACTION_VIEW);
		Uri packageUri = Uri.parse("package: "+packageName);
		intent.setData(packageUri);
		context.startActivity(intent);
		return true;
	}
	
	/**
	 * 打开已安装应用的详情
	 */
	public void goToInstallApplicationDetail(Context context,String packageName){
			
		 Intent intent = new Intent();
		 int buildSdk = Build.VERSION.SDK_INT;
		 
		 if(buildSdk>Build.VERSION_CODES.GINGERBREAD){
			 intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
			 intent.setData(Uri.fromParts("package",packageName,null));
		 }else {
			 intent.setAction(Intent.ACTION_VIEW);
			 intent.setClassName("com.android.settings", "com.android.settings.InstalledAppDetails");
	         intent.putExtra((buildSdk == Build.VERSION_CODES.FROYO ? "pkg" : "com.android.settings.ApplicationPkgName"), packageName);
		}
		 intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		 context.startActivity(intent);
	}

	
	
	/**
	 * get packageinfo 
	 * @param context
	 * @return
	 */
	public static PackageInfo getPackageInfo(Context context){
		
		if(context!=null){
				PackageManager pm = context.getPackageManager();
				if(pm!=null){
						try {
								return pm.getPackageInfo(context.getPackageName(),0);
						} catch (NameNotFoundException e) {
							e.printStackTrace();
						}
				}
		}
		return null;
	}
	
	/**
	 * whether packageName is system application
	 * @param context
	 * @return
	 */
	public static boolean  isSystemApplication(Context context){
			boolean result  =false;
			if(context==null){
					return result;
			}
			return isSystemApplication(context,context.getPackageName());
	}
	
	
	public static boolean  isSystemApplication(Context context,String packageName){
			
			boolean result  =false;
			if(context==null||TextUtils.isEmpty(packageName)||context.getPackageManager()==null){
				return result;
			}
			try {
						ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(packageName,0);
						return (appInfo!=null&&(appInfo.flags&ApplicationInfo.FLAG_SYSTEM)>0);
			} catch (NameNotFoundException e) {
				e.printStackTrace();
			}
			return result;
	}
	
    /**
     * 获取已安装的全部应用信息
     */
    public static List<PackageInfo> getInsatalledPackages(Context context) {
        return context.getPackageManager().getInstalledPackages(0);
    }
    
    
    /**
     * 获取指定程序信息
     */
    public static ApplicationInfo getApplicationInfo(Context context, String pkg) {
        try {
            return context.getPackageManager().getApplicationInfo(pkg, 0);
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * 启动应用
     */
    public static boolean startAppByPackageName(Context context, String packageName) {
        return startAppByPackageName(context, packageName, null);
    }

    /**
     * 启动应用
     */
    public static boolean startAppByPackageName(Context context, String packageName, Map<String, String> param) {
        PackageInfo pi = null;
        try {
            pi = context.getPackageManager().getPackageInfo(packageName, 0);
            Intent resolveIntent = new Intent(Intent.ACTION_MAIN, null);
            resolveIntent.addCategory(Intent.CATEGORY_LAUNCHER);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.DONUT) {
                resolveIntent.setPackage(pi.packageName);
            }

            List<ResolveInfo> apps = context.getPackageManager().queryIntentActivities(resolveIntent, 0);

            ResolveInfo ri = apps.iterator().next();
            if (ri != null) {
                String packageName1 = ri.activityInfo.packageName;
                String className = ri.activityInfo.name;

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.addCategory(Intent.CATEGORY_LAUNCHER);

                ComponentName cn = new ComponentName(packageName1, className);

                intent.setComponent(cn);
                if (param != null) {
                    for (Map.Entry<String, String> en : param.entrySet()) {
                        intent.putExtra(en.getKey(), en.getValue());
                    }
                }
                context.startActivity(intent);
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context.getApplicationContext(), "启动失败",
                    Toast.LENGTH_LONG).show();
        }
        return false;
    }

    
}
