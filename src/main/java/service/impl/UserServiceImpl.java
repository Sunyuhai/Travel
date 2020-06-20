package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import domain.User;
import service.UserService;
import util.MailUtils;
import util.UuidUtil;

public class UserServiceImpl implements UserService {
    private UserDao dao = new UserDaoImpl();
    /**
     * 注册用户
     * @param user 从表单中获取并封装的user对象
     * @return 成功为true，失败为false
     */
    @Override
    public boolean register(User user) {
        if(dao.findUserByUsername(user.getUsername())==null){
            String code = UuidUtil.getUuid();
            user.setCode(code);
            user.setStatus("N");
            dao.save(user);
            String content="<a href='http://localhost:8080/travel/user/active?code=" + user.getCode() + "'>点击激活【咩咩】</a>";
            MailUtils.sendMail(user.getEmail(),content,"激活邮件");
            return true;
        }else{
            return false;
        }
    }
    /**
     * 邮件激活
     * @param code 激活码
     * @return 激活成功返回true ，失败返回 false
     */
    @Override
    public boolean active(String code) {
        User user = dao.findUserByCode(code);
        if(user!=null){
            dao.upDateStatus(user);
            return true;
        }else{
            return false;
        }
    }
    /**
     * 登录
     * @param user 表单提交的用户名及密码
     * @return user对象
     */
    @Override
    public User login(User user) {
        return dao.findUserByLoginInfo(user);
    }
}
