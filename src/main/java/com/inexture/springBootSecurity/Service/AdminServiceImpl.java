package com.inexture.springBootSecurity.Service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.inexture.springBootSecurity.Model.AssignBean;
import com.inexture.springBootSecurity.Model.UserBean;
import com.inexture.springBootSecurity.Repo.AdminDaoInterface;
import com.inexture.springBootSecurity.Repo.UserDaoInterface;



@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	private UserDaoInterface userDao;

	@Autowired
	private AdminDaoInterface adminDao;

	@Override
	public List<AssignBean> checkUserType(UserBean uBean) {

		UserBean userBean = userDao.getUserEmail(uBean.getEmail());
		List<AssignBean> usertype = adminDao.userType(userBean.getUserid());

		return usertype;
	}

}
