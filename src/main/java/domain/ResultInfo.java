package domain;

import java.io.Serializable;
import java.util.Objects;

/**
 * 鐢ㄤ簬灏佽鍚庣杩斿洖鍓嶇鏁版嵁瀵硅薄
 */
public class ResultInfo implements Serializable {
    private boolean flag;//鍚庣杩斿洖缁撴灉姝ｅ父涓簍rue锛屽彂鐢熷紓甯歌繑鍥瀎alse
    private Object data;//鍚庣杩斿洖缁撴灉鏁版嵁瀵硅薄
    private String errorMsg;//鍙戠敓寮傚父鐨勯敊璇秷鎭�

    //鏃犲弬鏋勯�犳柟娉�
    public ResultInfo() {
    }
    public ResultInfo(boolean flag) {
        this.flag = flag;
    }
    /**
     * 鏈夊弬鏋勯�犳柟娉�
     * @param flag
     * @param errorMsg
     */
    public ResultInfo(boolean flag, String errorMsg) {
        this.flag = flag;
        this.errorMsg = errorMsg;
    }
    /**
     * 鏈夊弬鏋勯�犳柟娉�
     * @param flag
     * @param data
     * @param errorMsg
     */
    public ResultInfo(boolean flag, Object data, String errorMsg) {
        this.flag = flag;
        this.data = data;
        this.errorMsg = errorMsg;
    }

    public boolean isFlag() {
        return flag;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }
}
