package com.jennbowers.topicvoter.repositories;

import com.jennbowers.topicvoter.interfaces.TopicRepository;
import com.jennbowers.topicvoter.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


//ALL STUFF THAT TALKS TO DB GOES HERE
@Repository
public class TopicRepositoryImpl implements TopicRepository{

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<Topic> findAll() {
        return jdbcTemplate.query("SELECT * FROM topic", new TopicMapper());
    }

    @Override
    public void add(String title, String description) {
        jdbcTemplate.update("INSERT INTO topic (title, description) values(?, ?)", title, description);
    }

    private static class TopicMapper implements RowMapper<Topic> {
//        resultset is what comes back from a jdbc query
//        so this says that for every row that comes back we want to do something
        @Override
        public Topic mapRow(ResultSet resultSet, int i) throws SQLException {
            Topic topic = new Topic(resultSet.getInt("id"),
                                    resultSet.getString("title"),
                                    resultSet.getString("description"));
            return topic;
        }
    }


}
