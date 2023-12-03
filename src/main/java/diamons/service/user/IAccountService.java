package diamons.service.user;

import diamons.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public interface IAccountService {
    @Autowired
    int addAccount(User user);
    @Autowired
    User checkAccount(User user);
}
