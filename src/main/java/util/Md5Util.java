package util;

import java.security.MessageDigest;

/**
 * 鍐欎竴涓狹D5绠楁硶,杩愯缁撴灉涓嶮ySQL鐨刴d5()鍑芥暟鐩稿悓
 * 灏嗘槑鏂囧瘑鐮佽浆鎴怣D5瀵嗙爜
 * 123456->e10adc3949ba59abbe56e057f20f883e
 */
public final class Md5Util {
	private Md5Util(){}
	/**
	 * 灏嗘槑鏂囧瘑鐮佽浆鎴怣D5瀵嗙爜 
	 */
	public static String encodeByMd5(String password) throws Exception{
		//Java涓璏essageDigest绫诲皝瑁呬簡MD5鍜孲HA绠楁硶锛屼粖澶╂垜浠彧瑕丮D5绠楁硶
		MessageDigest md5 = MessageDigest.getInstance("MD5");
		//璋冪敤MD5绠楁硶锛屽嵆杩斿洖16涓猙yte绫诲瀷鐨勫��
		byte[] byteArray = md5.digest(password.getBytes());
		//娉ㄦ剰锛歁essageDigest鍙兘灏哠tring杞垚byte[]锛屾帴涓嬫潵鐨勪簨鎯咃紝鐢辨垜浠▼搴忓憳鏉ュ畬鎴�
		return byteArrayToHexString(byteArray);
	}
	/**
	 * 灏哹yte[]杞湪16杩涘埗瀛楃涓� 
	 */
	private static String byteArrayToHexString(byte[] byteArray) {
		StringBuffer sb = new StringBuffer();
		//閬嶅巻
		for(byte b : byteArray){//16娆�
			//鍙栧嚭姣忎竴涓猙yte绫诲瀷锛岃繘琛岃浆鎹�
			String hex = byteToHexString(b);
			//灏嗚浆鎹㈠悗鐨勫�兼斁鍏tringBuffer涓�
			sb.append(hex);
		}
		return sb.toString();
	}
	/**
	 * 灏哹yte杞湪16杩涘埗瀛楃涓� 
	 */
	private static String byteToHexString(byte b) {//-31杞垚e1锛�10杞垚0a锛屻�傘�傘��
		//灏哹yte绫诲瀷璧嬬粰int绫诲瀷
		int n = b;
		//濡傛灉n鏄礋鏁�
		if(n < 0){
			//杞鏁�
			//-31鐨�16杩涘埗鏁帮紝绛変环浜庢眰225鐨�16杩涘埗鏁� 
			n = 256 + n;
		}
		//鍟�(14)锛屾暟缁勭殑涓嬫爣
		int d1 = n / 16;
		//浣�(1)锛屾暟缁勭殑涓嬫爣
		int d2 = n % 16;
		//閫氳繃涓嬫爣鍙栧��
		return hex[d1] + hex[d2];
	}
	private static String[] hex = {"0","1","2","3","4","5","6","7","8","9","a","b","c","d","e","f"};
	/**
	 * 娴嬭瘯
	 */
	public static void main(String[] args) throws Exception{
		String password = "123456";
		String passwordMD5 = Md5Util.encodeByMd5(password);
		System.out.println(password);
		System.out.println(passwordMD5);
	}
}
