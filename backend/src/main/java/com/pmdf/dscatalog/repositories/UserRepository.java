package com.pmdf.dscatalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.pmdf.dscatalog.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	
	// Método que busque no BD um usuário pelo e-mail (esse método está sendo usado na classe UserInsertValidator)
	User findByEmail (String email);

}
