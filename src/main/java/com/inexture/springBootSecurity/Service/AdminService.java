package com.inexture.springBootSecurity.Service;

import java.util.List;

import com.inexture.springBootSecurity.Model.AssignBean;
import com.inexture.springBootSecurity.Model.UserBean;



public interface AdminService {

	List<AssignBean> checkUserType(UserBean uBean);

}