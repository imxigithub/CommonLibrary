package library.coship.com.androicommlibrary.com.coship.library.tools;

import java.util.Random;

public class RandomUtil {

    public static final String NUMBERS_AND_LETTERS = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String NUMBERS             = "0123456789";
    public static final String LETTERS             = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String CAPITAL_LETTERS     = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    public static final String LOWER_CASE_LETTERS  = "abcdefghijklmnopqrstuvwxyz";
	
    
    private RandomUtil(){
    	throw new AssertionError();
    }

    /**
     * get fixed-length Mix of letters and numbers random 
     * @param length
     * @return
     */
    public static String getRandomNumorLetters(int length){
    
    	return getRandom(NUMBERS_AND_LETTERS, length);
    }

    /**
     * get fixed-length letters random character string
     * @param length
     * @return
     */
    public static String getRandomLETTERS(int length){
    	
    	return getRandom(LETTERS,length);
    }
	
    /**
     * get fixed-length number random character string
     * @param length
     * @return
     */
    public static String getRandomNumber(int length){
    	
    		return getRandom(NUMBERS, length);
    }
    
    /**
     * get fixed-length lower case letters random character string
     * @param length
     * @return
     */
    public static String getRandomLowerCaseLetter(int length){
    	
		return getRandom(LOWER_CASE_LETTERS, length);
    }
    
    /**
     *  get fixed-length capital letter random character string
     * @param length
     * @return
     */
    public static String getRandomCapitalLetter(int length){
    	
		return getRandom(CAPITAL_LETTERS, length);
    }
    
    
    private static String getRandom(String source,int length){
    	
    	return source==null?null:getRandom(source.toCharArray(),length);
    }

    
    /**
     * get a fixed-length random string, its a mixture of chars in sourceChar
     * @param sourceArray
     * @param length
     * @return
     */
    private static String getRandom(char[]sourceArray,int length){
    	
    		if(sourceArray==null||sourceArray.length==0||length==0){
    			return null;
    		}
    		
    		StringBuilder stringBuilder = new StringBuilder(length);
    		for (int i = 0; i < length; i++) {
    			stringBuilder.append(sourceArray[getRandom(sourceArray.length)]);
			}
    		return stringBuilder.toString();
    }
    
    
    public static int getRandom(int max){
    	
    	return getRandom(0,max);
    }
    
    /**
     * get  random number between max and min
     * @param max
     * @param min
     * @return
     */
    public static int getRandom(int min,int max){
    
    	if(max<min){
    			return 0;
    	}else if(max==min){
			return min;
		}
    	return min+ new Random().nextInt(max-min);
    }
    
    
    /**
     * Shuffling algorithm, Randomly permutes the specified array using a default source of randomness
     */
    public static boolean shuffle(Object[] objArray) {
        if (objArray == null) {
            return false;
        }
        return shuffle(objArray, getRandom(objArray.length));
    }

    /**
     * Shuffling algorithm, Randomly permutes the specified array
     */
    public static boolean shuffle(Object[] objArray, int shuffleCount) {
        int length;
        if (objArray == null || shuffleCount < 0 || (length = objArray.length) < shuffleCount) {
            return false;
        }

        for (int i = 1; i <= shuffleCount; i++) {
            int random = getRandom(length - i);
            Object temp = objArray[length - i];  //两两交换 object[lenght-i]与产生的随机数object[random]位置的数交换
            objArray[length - i] = objArray[random];
            objArray[random] = temp;
        }
        return true;
    }

    /**
     * Shuffling algorithm, Randomly permutes the specified int array using a default source of randomness
     */
    public static int[] shuffle(int[] intArray) {
        if (intArray == null) {
            return null;
        }

        return shuffle(intArray, getRandom(intArray.length));
    }

    /**
     * Shuffling algorithm, Randomly permutes the specified int array
     */
    public static int[] shuffle(int[] intArray, int shuffleCount) {
        int length;
        if (intArray == null || shuffleCount < 0 || (length = intArray.length) < shuffleCount) {
            return null;
        }

        int[] out = new int[shuffleCount];
        for (int i = 1; i <= shuffleCount; i++) {
            int random = getRandom(length - i);
            out[i - 1] = intArray[random];
            int temp = intArray[length - i];
            intArray[length - i] = intArray[random];
            intArray[random] = temp;
        }
        return out;
    }
    
}
