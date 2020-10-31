package com.bp.projectmanagment.dao;

import com.bp.projectmanagment.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface UserAccountRepository extends PagingAndSortingRepository<UserAccount, Long> {
}
