package diamons.service.user;

import diamons.DAO.UserDAO;
import diamons.entity.User;
import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AccountServiceImpl implements IAccountService{
    @Autowired
    UserDAO userDAO = new UserDAO();
    @Override
    public int addAccount(User user) {
        user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt(12)));
        return userDAO.addAccount(user);
    }

    @Override
    public User checkAccount(User user) {
        String pass = user.getPassword();
        user = userDAO.getUserByAcc(user);
        if (user!=null){
            if (BCrypt.checkpw(pass,user.getPassword())){
                return user;
            }
            return null;
        }
        return null;
    }
}
