package domain;

import java.io.Serializable;

/**
 * 鍟嗗瀹炰綋绫�
 */
public class Seller implements Serializable {
    private int sid;//鍟嗗id
    private String sname;//鍟嗗鍚嶇О
    private String consphone;//鍟嗗鐢佃瘽
    private String address;//鍟嗗鍦板潃

    /**
     * 鏃犲弬鏋勯�犳柟娉�
     */
    public Seller(){}

    /**
     * 鏋勯�犳柟娉�
     * @param sid
     * @param sname
     * @param consphone
     * @param address
     */
    public Seller(int sid, String sname, String consphone, String address) {
        this.sid = sid;
        this.sname = sname;
        this.consphone = consphone;
        this.address = address;
    }

    public int getSid() {
        return sid;
    }

    public void setSid(int sid) {
        this.sid = sid;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getConsphone() {
        return consphone;
    }

    public void setConsphone(String consphone) {
        this.consphone = consphone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
