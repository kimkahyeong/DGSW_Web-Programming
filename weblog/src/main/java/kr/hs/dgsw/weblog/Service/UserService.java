package kr.hs.dgsw.weblog.Service;

import kr.hs.dgsw.weblog.Domain.User;

import java.util.List;

public interface UserService {
    User create(User user);
    User read(Long id);
    User update(Long id, User user);
    boolean delete(Long id);
    List<User> readAll();
    
}