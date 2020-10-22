package com.spring.transaction.dao.impl;

import com.spring.transaction.dao.UserCardDao;
import com.spring.transaction.domain.UserCard;
import com.spring.transaction.utils.ConnectionUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayListHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.springframework.jdbc.core.JdbcTemplate;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class UserCardDaoImpl implements UserCardDao {

    private QueryRunner queryRunner;
    private ConnectionUtils connectionUtils;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public void setConnectionUtils(ConnectionUtils connectionUtils) {
        this.connectionUtils = connectionUtils;
    }

    public void updateCard(UserCard userCard) {
        String username = userCard.getUsername();
        float money = userCard.getMoney();
        try {
            queryRunner.update(connectionUtils.getConnection(),"update usercard set money=? where username=?",money,username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public UserCard findUserCardByname(String name) {
        UserCard userCard = null;
        try {
            BeanHandler<UserCard> handler = new BeanHandler<>(UserCard.class);
            userCard = queryRunner.query(connectionUtils.getConnection(), "select * from usercard where username=?", handler, name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return userCard;
    }
}
