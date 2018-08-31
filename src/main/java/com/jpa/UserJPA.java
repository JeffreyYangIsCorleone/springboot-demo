package com.jpa;

import com.pojo.JefUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.io.Serializable;

public interface UserJPA extends JpaRepository<JefUser,Integer>, JpaSpecificationExecutor<JefUser>, Serializable {

    @Query(value = "select userId,userName,account,createAt from jef_user where account= ?1 and password = ?2",nativeQuery = true)
    JefUser findJefUserByAccount(String account, String password);

    @Query(value = "select userId,userName,account,createAt,password from jef_user where account= ?1",nativeQuery = true)
    JefUser findByOnlyAccount(String account);
}
