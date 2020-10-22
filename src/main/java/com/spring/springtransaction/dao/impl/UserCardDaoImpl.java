package com.spring.springtransaction.dao.impl;


import com.spring.springtransaction.dao.UserCardDao;
import com.spring.springtransaction.domain.UserCard;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;
import java.util.Map;

public class UserCardDaoImpl implements UserCardDao {

    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public void updateCard(UserCard userCard) {
        String username = userCard.getUsername();
        float money = userCard.getMoney();
        jdbcTemplate.update("update usercard set money=? where username=?",money,username);
    }

    public UserCard findUserCardByname(String name) {
        List<Map<String, Object>> maps = jdbcTemplate.queryForList("select * from usercard where username=?", name);
        UserCard userCard = new UserCard();
        if(maps.size() > 0){
            Map<String, Object> map = maps.get(0);
            String username = (String)map.get("username");
            float money = (Float) map.get("money");
            userCard.setUsername(username);
            userCard.setMoney(money);
        }
        return userCard;
    }
}
