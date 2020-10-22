package com.spring.transaction.service;

import com.spring.transaction.domain.UserCard;

public interface UserCardService {

    public void transfer(String source, String target, Float money);
}
