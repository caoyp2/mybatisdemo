package com.spring.transaction.domain;

import java.io.Serializable;

public class UserCard  implements Serializable {
    private String username;
    private float money;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public float getMoney() {
        return money;
    }

    public void setMoney(float money) {
        this.money = money;
    }

}
