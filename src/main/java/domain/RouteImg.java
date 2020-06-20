package domain;

import java.io.Serializable;

/**
 * 鏃呮父绾胯矾鍥剧墖瀹炰綋绫�
 */
public class RouteImg implements Serializable {
    private int rgid;//鍟嗗搧鍥剧墖id
    private int rid;//鏃呮父鍟嗗搧id
    private String bigPic;//璇︽儏鍟嗗搧澶у浘
    private String smallPic;//璇︽儏鍟嗗搧灏忓浘

    /**
     * 鏃犲弬鏋勯�犳柟娉�
     */
    public RouteImg() {
    }

    /**
     * 鏈夊弬鏋勯�犳柟娉�
     * @param rgid
     * @param rid
     * @param bigPic
     * @param smallPic
     */
    public RouteImg(int rgid, int rid, String bigPic, String smallPic) {
        this.rgid = rgid;
        this.rid = rid;
        this.bigPic = bigPic;
        this.smallPic = smallPic;
    }

    public int getRgid() {
        return rgid;
    }

    public void setRgid(int rgid) {
        this.rgid = rgid;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getBigPic() {
        return bigPic;
    }

    public void setBigPic(String bigPic) {
        this.bigPic = bigPic;
    }

    public String getSmallPic() {
        return smallPic;
    }

    public void setSmallPic(String smallPic) {
        this.smallPic = smallPic;
    }
}
