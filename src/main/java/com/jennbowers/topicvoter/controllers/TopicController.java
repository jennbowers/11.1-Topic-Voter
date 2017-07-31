package com.jennbowers.topicvoter.controllers;

import com.jennbowers.topicvoter.models.Topic;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;

@Controller
public class TopicController {
    @RequestMapping("/")
    public String index(Model model) {
        Topic first = new Topic(1, "Java Spring", "Not sure how Spring works");
        Topic second = new Topic(2, "Backend fundamentals", "Node on the backend?! What!!");
        Topic third = new Topic(3, "React & Redux", "What is a single page app anyways??");

        ArrayList<Topic> topics = new ArrayList<>();
        topics.add(first);
        topics.add(second);
        topics.add(third);

        model.addAttribute("topics", topics);

        return "index";
    }
}
