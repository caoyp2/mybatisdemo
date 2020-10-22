package com.spring.springtransaction.service.impl;

import com.spring.springtransaction.dao.impl.UserCardDaoImpl;
import com.spring.springtransaction.service.UserCardService;
import com.spring.springtransaction.domain.UserCard;


public class UserCardServiceImpl implements UserCardService {
    private UserCardDaoImpl userCardDao;
    public void setUserCardDao(UserCardDaoImpl userCardDao) {
        this.userCardDao = userCardDao;
    }

    public void transfer(String source, String target, Float money) {
        UserCard userCardSource = userCardDao.findUserCardByname(source);
        float sourceMoney = userCardSource.getMoney();
        UserCard userCardTarget = userCardDao.findUserCardByname(target);
        float targetMoney = userCardTarget.getMoney();
        sourceMoney = sourceMoney - money;
        targetMoney = targetMoney + money;
        userCardSource.setMoney(sourceMoney);
        userCardTarget.setMoney(targetMoney);
        userCardDao.updateCard(userCardSource);
//            int i=1/0;
        userCardDao.updateCard(userCardTarget);
    }
}
