package library.coship.com.androicommlibrary.com.coship.library.tools.com.coship.library.FileUtils;

import android.text.TextUtils;

import org.w3c.dom.Text;

/**
 * Created by kelly on 2016/3/29.
 */
public class FileUtil {

    /**
     *  创建文件
     */
    public static File  createFile(String path,String fileName){

            File file = null;

            if(TextUtils.isEmpty(path)&&TextUtils.isEmpty(fileName)){
                        return null;
            }
            file = new File(path);
            if(file.exsit()){

            }

        return  null;
    }

    /**
     * 创建文件夹
     */

    /**
     * 删除文件
     */

    /**
     * 删除文件夹
     */

}
