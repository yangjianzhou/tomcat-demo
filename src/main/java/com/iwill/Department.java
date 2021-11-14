package com.iwill;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Department {

    private String name;

    private String code;

    private Map<String, String> extension = new HashMap<String, String>();

    private List<User> users = new LinkedList<User>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void putExtension(String name, String value) {
        this.extension.put(name, value);
    }
}
