package com.example.listview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic implements Serializable {
    private Integer id;
    private String represent;
    private String description;
    private String descriptiveMeaning;
    private String lessonId;
}
