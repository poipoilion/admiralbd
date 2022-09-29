package ru.admiralnsk.admiralbd.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Node {

    private String nodeId;
    private String parentId;
    private String text;
    private String href;
}