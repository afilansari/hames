package com.hames.service.impl;

import java.util.List;

import org.apache.shiro.authc.credential.DefaultPasswordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.Validator;

import com.hames.dao.UserAccountDao;
import com.hames.exception.RolePermissionException;
import com.hames.exception.StaffException;
import com.hames.exception.ValidationException;
import com.hames.service.GenericService;
import com.hames.service.RolePermissionService;
import com.hames.service.StaffService;
import com.hames.service.UserAccountService;
import com.hames.system.auth.UserAccount;
import com.hames.validator.UserAccountValidator;

@Service
public class UserAccountServiceImpl extends GenericService implements UserAccountService {

	private static final Logger logger = LoggerFactory.getLogger(UserAccountServiceImpl.class);

	@Autowired private UserAccountDao userAccountDao;
	@Autowired private StaffService staffService;
	@Autowired private RolePermissionService rolePermissionService;
	
	@Override
	public Validator getValidator() {
		return new UserAccountValidator();
	}

	@Override
	public Class<?> getEntityClass() {
		return UserAccount.class;
	}

	@Override
	public void save(UserAccount userAccount) {
		
		try{
			validate(userAccount);
		}catch(ValidationException e){
			logger.debug("Validation errors are present while saving the user account. Opeartion aborted");
			throw new ValidationException();
		}

		boolean usernameExists = userAccountDao.isUsernameExists(userAccount.getUsername());
		if(usernameExists){
			logger.debug("Username already present. Opeartion Aborted");
			throw new RolePermissionException("Someone already has that username. Try another?");
		}
		
		boolean staffExistsInUA = userAccountDao.checkUserAccountExistsForStaff(userAccount.getStaffId());
		if(staffExistsInUA){
			logger.debug("UserAccount already exists for staff. Opeartion Aborted");
			throw new RolePermissionException("UserAccount already exists for staff");
		}
		
		boolean staffExists = staffService.isStaffExists(userAccount.getStaffId());
		if(!staffExists){
			logger.debug("Staff not found. Aborting operation");
			throw new StaffException("Invalid Staff");
		}
		
		boolean roleExists = rolePermissionService.isRolePermissionExists(userAccount.getRoleId());
		if(!roleExists){
			logger.debug("Role not found : {}",userAccount.getRolePermission().getRoleId());
			throw new RolePermissionException("Role doesn't exists.!");
		}
		
		DefaultPasswordService passwordService = new DefaultPasswordService();
		String encryptedPassword = passwordService.encryptPassword(userAccount.getPassword());
		userAccount.setPassword(encryptedPassword);
		
		//Setting Auditable details
		userAccount.setAuditableDetails(null);
		
		logger.debug("Saving entity : {}, class: {}",userAccount,UserAccount.class);
		userAccountDao.save(userAccount);
		logger.debug("Entity saved successfully");
	}

	@Override
	public List<UserAccount> getUserAccounts() {
		return userAccountDao.getUserAccounts();
	}

}
