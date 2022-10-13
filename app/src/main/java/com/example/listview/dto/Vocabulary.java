package com.example.listview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Vocabulary {
    private Integer id;
    private String vocabulary;
    private String phonetic;
    private String mean;
    private String audio;
    private String image;
    private String exampleSentences;
    private String meaningExp;
    private Integer topicId;
}
