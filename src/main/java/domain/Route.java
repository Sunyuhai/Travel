package domain;

import java.io.Serializable;
import java.util.List;

/**
 * 鏃呮父绾胯矾鍟嗗搧瀹炰綋绫�
 */
public class Route implements Serializable {

    private int rid;//绾胯矾id锛屽繀杈�
    private String rname;//绾胯矾鍚嶇О锛屽繀杈�
    private double price;//浠锋牸锛屽繀杈�
    private String routeIntroduce;//绾胯矾浠嬬粛
    private String rflag;   //鏄惁涓婃灦锛屽繀杈擄紝0浠ｈ〃娌℃湁涓婃灦锛�1浠ｈ〃鏄笂鏋�
    private String rdate;   //涓婃灦鏃堕棿
    private String isThemeTour;//鏄惁涓婚鏃呮父锛屽繀杈擄紝0浠ｈ〃涓嶆槸锛�1浠ｈ〃鏄�
    private int count;//鏀惰棌鏁伴噺
    private int cid;//鎵�灞炲垎绫伙紝蹇呰緭
    private String rimage;//缂╃暐鍥�
    private int sid;//鎵�灞炲晢瀹�
    private String sourceId;//鎶撳彇鏁版嵁鐨勬潵婧恑d

    private Category category;//鎵�灞炲垎绫�
    private Seller seller;//鎵�灞炲晢瀹�
    private List<RouteImg> routeImgList;//鍟嗗搧璇︽儏鍥剧墖鍒楄〃



    /**
     * 鏃犲弬鏋勯�犳柟娉�
     */
    public Route(){}

    /**
     * 鏈夊弬鏋勯�犳柟娉�
     * @param rid
     * @param rname
     * @param price
     * @param routeIntroduce
     * @param rflag
     * @param rdate
     * @param isThemeTour
     * @param count
     * @param cid
     * @param rimage
     * @param sid
     * @param sourceId
     */
    public Route(int rid, String rname, double price, String routeIntroduce, String rflag, String rdate, String isThemeTour, int count, int cid, String rimage, int sid, String sourceId) {
        this.rid = rid;
        this.rname = rname;
        this.price = price;
        this.routeIntroduce = routeIntroduce;
        this.rflag = rflag;
        this.rdate = rdate;
        this.isThemeTour = isThemeTour;
        this.count = count;
        this.cid = cid;
        this.rimage = rimage;
        this.sid = sid;
        this.sourceId = sourceId;
    }

    public List<RouteImg> getRouteImgList() {
        return routeImgList;
    }

    public void setRouteImgList(List<RouteImg> routeImgList) {
        this.routeImgList = routeImgList;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public String getSourceId() {
        return sourceId;
    }

    public void setSourceId(String sourceId) {
        this.sourceId = sourceId;
    }

    public int getRid() {
        return rid;
    }

    public void setRid(int rid) {
        this.rid = rid;
    }

    public String getRname() {
        return rname;
    }

    public void setRname(String rname) {
        this.rname = rname;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getRouteIntroduce() {
        return routeIntroduce;
    }

    public void setRouteIntroduce(String routeIntroduce) {
        this.routeIntroduce = routeIntroduce;
    }

    public String getRflag() {
        return rflag;
    }

    public void setRflag(String rflag) {
        this.rflag = rflag;
    }

    public String getRdate() {
        return rdate;
    }

    public void setRdate(String rdate) {
        this.rdate = rdate;
    }

    public String getIsThemeTour() {
        return isThemeTour;
    }

    public void setIsThemeTour(String isThemeTour) {
        this.isThemeTour = isThemeTour;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getRimage() {
        return rimage;
    }

    public void setRimage(String rimage) {
        this.rimage = rimage;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    @Override
    public String toString() {
        return "Route{" +
                "rid=" + rid +
                ", rname='" + rname + '\'' +
                ", price=" + price +
                ", routeIntroduce='" + routeIntroduce + '\'' +
                ", rflag='" + rflag + '\'' +
                ", rdate='" + rdate + '\'' +
                ", isThemeTour='" + isThemeTour + '\'' +
                ", count=" + count +
                ", cid=" + cid +
                ", rimage='" + rimage + '\'' +
                ", sid=" + sid +
                ", sourceId='" + sourceId + '\'' +
                ", category=" + category +
                ", seller=" + seller +
                ", routeImgList=" + routeImgList +
                '}';
    }
}
