package com.jennbowers.topicvoter.interfaces;

import com.jennbowers.topicvoter.models.Topic;

import java.util.List;

public interface TopicRepository {
    List<Topic> findAll();
    void add(String title, String description);
}
