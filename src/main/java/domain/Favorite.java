package domain;

import java.io.Serializable;

/**
 * 鏀惰棌瀹炰綋绫�
 */
public class Favorite implements Serializable {
    private Route route;//鏃呮父绾胯矾瀵硅薄
    private String date;//鏀惰棌鏃堕棿
    private User user;//鎵�灞炵敤鎴�

    /**
     * 鏃犲弬鏋勯�犳柟娉�
     */
    public Favorite() {
    }

    /**
     * 鏈夊弬鏋勯�犳柟娉�
     * @param route
     * @param date
     * @param user
     */
    public Favorite(Route route, String date, User user) {
            this.route = route;
            this.date = date;
            this.user = user;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
