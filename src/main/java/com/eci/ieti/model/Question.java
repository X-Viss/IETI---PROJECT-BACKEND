package com.eci.ieti.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Quests")
public class Question {
    private String quest;
    private String answer;
    public String getQuest() {
        return quest;
    }
    public void setQuest(String quest) {
        this.quest = quest;
    }
    public String getAnswer() {
        return answer;
    }
    public void setAnswer(String answer) {
        this.answer = answer;
    }
    @Override
    public String toString() {
        return "Question [answer=" + answer + ", quest=" + quest + "]";
    }
}
