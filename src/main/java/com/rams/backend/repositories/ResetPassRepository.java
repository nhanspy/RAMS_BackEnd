package com.rams.backend.repositories;

import com.rams.backend.entities.role_user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface ResetPassRepository extends JpaRepository<User,Long> {
    @Modifying
    @Query(value = "update users set password =?1,verification_code=null where verification_code=?2 ",nativeQuery = true)
    void saveNewPassword(String password, String code);

    @Query(value = "SELECT email from users where email = ?1", nativeQuery = true)
    String existsByEmail(String email);

    @Query(value = "select * from users where verification_code =?1",nativeQuery = true)
    User findUserByVerificationCode(String verifyCode);


    @Modifying
    @Query(value ="update users set verification_code=?1 where email =?2",nativeQuery = true)
    void addVerificationCode(String code, String email);

}
