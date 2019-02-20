package com.itheima.service.Impl;

import com.itheima.dao.AccountDao;
import com.itheima.dao.Impl.AccountDaoImpl;
import com.itheima.service.AccountService;

/**
 * 账户的业务层实现类
 */
public class AccountServiceImpl implements AccountService {

    private AccountDao accountDao = new AccountDaoImpl();

    public void saveAccount() {
        accountDao.saveAccount();
    }

}
