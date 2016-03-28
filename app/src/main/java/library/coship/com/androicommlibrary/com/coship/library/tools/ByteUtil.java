package library.coship.com.androicommlibrary.com.coship.library.tools;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;

public class ByteUtil {
	
	public static  Object byteToObject(byte[]buff){
		
		Object object =null;
		if(buff==null){
			return null;
		}
			ObjectInputStream ois  = null;
		try {
					ois  = new ObjectInputStream(new ByteArrayInputStream(buff));
					object = ois.readObject();
					return object;
		} catch (OptionalDataException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
				if(ois!=null){
					try {
						ois.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
		}
		return object;
	}
	
	
	public static byte[] objectTobyteArray(Object object){
		
			byte[] buff = null;
			if(object==null){
					return buff;
			}
			
			ByteArrayOutputStream bos = new ByteArrayOutputStream(4096);
			ObjectOutputStream oos = null;
			try {
					oos = new ObjectOutputStream(bos);
					oos.writeObject(object);
					buff = bos.toByteArray();
			} catch (IOException e) {
				e.printStackTrace();
			}finally{
					if(bos!=null){
							try {
								bos.close();
							} catch (IOException e) {
								e.printStackTrace();
							}
					}
					
					if(oos!=null){
						try {
							oos.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
			}
			return buff;
	}
	
	public static void byteTobit(byte[]bytes){
		if(bytes==null){
			return;
		}
		
		StringBuilder stringBuilder = new StringBuilder();
		for (int i = 0; i < Byte.SIZE * bytes.length; i++)
			stringBuilder.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
	}
	
    public static String byteToBit(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Byte.SIZE * bytes.length; i++)
            sb.append((bytes[i / Byte.SIZE] << i % Byte.SIZE & 0x80) == 0 ? '0' : '1');
        return sb.toString();
    }

}
