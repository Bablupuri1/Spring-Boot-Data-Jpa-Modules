package com.ecom.UserRespository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecom.Model.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

//	
//	   private String name;
//	    private String email;
//	    
//	    private String password;
//
//
//	    private String mobile;
	boolean existsByMobile(String mobile);

	Users findByMobile(String mobile);
	boolean existsByEmail(String email);
	boolean existsByName(String password);

	boolean existsByPassword(String password);

    Users findByNameAndPassword(String name, String password);


	
	
}
