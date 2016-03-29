package library.coship.com.androicommlibrary.com.coship.library.tools.com.coship.library.FileUtils;

import android.text.TextUtils;

import java.io.File;
import java.io.IOException;

/**
 * Created by kelly on 2016/3/29.
 */
public class FileUtil {

    /**
     *create empty file
     * @param path
     * @param suffix file's suffix
     * @return
     */
    public static File createFile(String path,String suffix){

            File file = null;
            if(TextUtils.isEmpty(path)&&TextUtils.isEmpty(suffix)){
                        return null;
            }
            file = new File(path+suffix);
            if(!file.exists()){
                try {
                          file.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        return  file;
    }

    /**
     * create empty folder
     * @param path
     * @return
     */

    public static File mkDir(String path){
            File folder = null;
            if(!TextUtils.isEmpty(path)){
                    return null;
            }

            folder = new File(path);
            if(!folder.isDirectory()&&!folder.exists()){
                    folder.mkdirs();
            }
        return folder;
    }


    /**
     * delete exist file
     * @param path
     * @return
     */
    public static boolean deletFile(String path){

            boolean result = false;
            if(TextUtils.isEmpty(path)){
                    return false;
            }
            File file = new File(path);
            if(file.exists()&&file.isFile()){
                     result = file.delete();
            }
        return result;
    }

    /**
     * 删除文件夹
     * 无法直接删除文件夹 必须要先迭代删除文件夹中的文件
     */
    public static  boolean deleteFolder(String path){
            boolean result = false;
            if(TextUtils.isEmpty(path)){
                return result;
            }
           File folder = new File(path);
           if(folder.exists()&&folder.isDirectory()){
                    File[]files = folder.listFiles();
                    if(files!=null){
                            for(int i = 0;i<files.length;i++){
                                    if(files[i].isDirectory()){
                                            File[]files1 = files[i].listFiles();//继续列出
                                            if(files1!=null){
                                                    for (int j = 0;j<files1.length;j++){
                                                                if(files1[j].isFile()){
                                                                        files1[j].delete();
                                                                }
                                                    }
                                            }
                                    }else{
                                        result = files[i].delete();
                                    }
                            }
                    }else{
                        result  = folder.delete();
                    }
           }
        return result;
    }

    /**
     * 列出指定目录下的所有文件
     */

}
