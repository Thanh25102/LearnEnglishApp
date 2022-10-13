package com.example.listview.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Lesson {
    private Integer id;
    private String name;
    private String target;
    private String description;
    private List<Topic> topics;
}
