package domain;

import java.io.Serializable;

/**
 * 鐢ㄦ埛瀹炰綋绫�
 */
public class User implements Serializable {
    private int uid;//鐢ㄦ埛id
    private String username;//鐢ㄦ埛鍚嶏紝璐﹀彿
    private String password;//瀵嗙爜
    private String name;//鐪熷疄濮撳悕
    private String birthday;//鍑虹敓鏃ユ湡
    private String sex;//鐢锋垨濂�
    private String telephone;//鎵嬫満鍙�
    private String email;//閭
    private String status;//婵�娲荤姸鎬侊紝Y浠ｈ〃婵�娲伙紝N浠ｈ〃鏈縺娲�
    private String code;//婵�娲荤爜锛堣姹傚敮涓�锛�

    /**
     * 鏃犲弬鏋勯�犳柟娉�
     */
    public User() {
    }

    /**
     * 鏈夊弬鏋勬柟娉�
     * @param uid
     * @param username
     * @param password
     * @param name
     * @param birthday
     * @param sex
     * @param telephone
     * @param email
     * @param status
     * @param code
     */
    public User(int uid, String username, String password, String name, String birthday, String sex, String telephone, String email, String status, String code) {
        this.uid = uid;
        this.username = username;
        this.password = password;
        this.name = name;
        this.birthday = birthday;
        this.sex = sex;
        this.telephone = telephone;
        this.email = email;
        this.status = status;
        this.code = code;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "User{" +
                "uid=" + uid +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", birthday='" + birthday + '\'' +
                ", sex='" + sex + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", status='" + status + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
