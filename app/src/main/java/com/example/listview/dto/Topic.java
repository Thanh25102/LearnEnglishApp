package com.example.listview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {
    private Integer id;
    private String represent;
    private String description;
    private String descriptiveMeaning;
    private String lessonId;
}
