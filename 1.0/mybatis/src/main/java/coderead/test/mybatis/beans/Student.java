package coderead.test.mybatis.beans;

import org.apache.ibatis.type.Alias;

import java.io.Serializable;

@Alias("student_alias")
public class Student implements Serializable {
    private Integer id;
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
