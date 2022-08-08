package com.mysite.sbb.Repository;

import com.mysite.sbb.Dao.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {
}
