package cn.videon.meeting.voice.web.rest.util;

public class ChineseUtil {


    private ChineseUtil() {
    }

    /**
     * 把中文转成Unicode码
     * @param str
     * @return
     */
    public static String chinaToUnicode(String str){
        StringBuilder result= new StringBuilder();
        for (int i = 0; i < str.length(); i++){
            int chr1 = str.charAt(i);
            //汉字范围 \u4e00-\u9fa5 (中文)
            if(chr1 >= 19968){
                result.append("\\u").append(Integer.toHexString(chr1));
            }else{
                result.append(str.charAt(i));
            }
        }
        return result.toString();
    }
}
