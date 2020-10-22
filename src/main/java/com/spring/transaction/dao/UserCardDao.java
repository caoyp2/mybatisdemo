package com.spring.transaction.dao;

import com.spring.transaction.domain.UserCard;

public interface UserCardDao {

    void updateCard(UserCard userCard);

    UserCard findUserCardByname(String name);
}
