package library.coship.com.androicommlibrary.com.coship.library.tools;

import java.io.IOException;
import java.io.InputStream;
import java.security.DigestException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import android.R.integer;


public class MD5Util {
	
	private static  String hexdigital[] = { "0", "1", "2", "3", "4", "5", "6",  "7", "8", "9", "a", "b", "c", "d", "e", "f" };

	 /**
	 * 获取文本的MD5
	 * @param value
	 * @return
	 */
	public static String getTextMd5(String value){
		String textMD5 = "";
		try {
					MessageDigest messageDigest = MessageDigest.getInstance("MD5");
					byte[] result = messageDigest.digest(value.getBytes());
					textMD5 = byteToHex(result);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return textMD5;
	}



	private static String byteToHex(byte[] result) {
		StringBuilder stringBuilder = new StringBuilder();
		if(result!=null&&result.length>0){
				int i = 0;
				while(result.length>i){
					
					    stringBuilder.append(hexdigital[result[i]>>>4&0x0f])
					    .append(hexdigital[result[i]&0x0f]);
					    i++;
				}
		}
		return stringBuilder.toString();
	}

	/**
	 * 获取文件的md5
	 * @param is
	 * @return
	 */
	public static String getStreamMD5(InputStream is){

		byte[]buff = new byte[8192];
		String streamMD5 = "";
		try {
				int len = 0;
				MessageDigest messageDigest = MessageDigest.getInstance("MD5");
				while((len = is.read(buff))!=-1){
						  messageDigest.update(buff, 0, len);;//这里的0是buff的起始位置,不是加密位置的起始
				}
				byte[]result = messageDigest.digest();
				streamMD5 = byteToHex(result);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return streamMD5;
	}
}
