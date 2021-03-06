package com.inexture.springBootSecurity.Repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.inexture.springBootSecurity.Model.AddressBean;




public interface AddressDaoInterface extends JpaRepository<AddressBean, Integer> {

	@Query("Select AddressId from AddressBean where user_Userid=?1")
	List<Integer> getAddressIds(int userid);

}
