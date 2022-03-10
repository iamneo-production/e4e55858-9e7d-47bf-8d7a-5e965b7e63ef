package com.examly.springapp.serviceimpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.examly.springapp.enums.RoleName;
import com.examly.springapp.model.Role;
import com.examly.springapp.model.User;
import com.examly.springapp.repository.RoleRepository;
import com.examly.springapp.repository.UserRepository;

@Service
public class FirstService implements ApplicationListener<ContextRefreshedEvent> {
	
	@Autowired
	private RoleRepository rolerepo;
	
	@Autowired
	private UserRepository userrepo;
	
	@Autowired
	private BCryptPasswordEncoder bCryptEncoder;
	
	private Logger logger=LoggerFactory.getLogger(FirstService.class);

	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {

         insertRoles();
         insertAdmin();
		
	}

	private void insertAdmin() {
		
		if(this.userrepo.checkEmailExist("admin@gmail.com")==null) {
			User user=new User();
			user.setEmail("admin@gmail.com");
			user.setMobileNumber("9999999999");
			user.setUsername("admin123");
			user.setPassword(this.bCryptEncoder.encode("Admin@123"));
			Role role=rolerepo.roleExist(RoleName.ADMIN.toString());
			if(role==null){
				insertRoles();
				role=rolerepo.roleExist(RoleName.ADMIN.toString());
			}
			user.setRole(role);
			this.userrepo.save(user);
		}
		else {
			logger.info("Admin Exist");
		}
		
		
	}

	private void insertRoles() {
		if(this.rolerepo.roleExist(RoleName.ADMIN.toString())==null) {
			Role role=new Role();
			role.setRoleId(1);
			role.setRoleName(RoleName.ADMIN.toString());
			this.rolerepo.save(role);
		}
		else {
			logger.info("Role Exist");
		}
		
		if(this.rolerepo.roleExist(RoleName.USER.toString())==null) {
			Role role=new Role();
			role.setRoleId(2);
			role.setRoleName(RoleName.USER.toString());
			this.rolerepo.save(role);
		}
		else {
			logger.info("Role Exist");
		}
		
	}


}
