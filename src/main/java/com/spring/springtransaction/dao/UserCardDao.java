package com.spring.springtransaction.dao;

import com.spring.springtransaction.domain.UserCard;

public interface UserCardDao {

    void updateCard(UserCard userCard);

    UserCard findUserCardByname(String name);
}
