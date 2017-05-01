package com.skeleton.beans;

/**
 * A very simple bean with an id and a text. This is our
 * POJO that will be returned from our API
 *
 * @author saifasif
 */
public class MyBean {

    private Long id;
    private String someText;

    public MyBean(long id, String someText) {
        this.id = id;
        this.someText = someText;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSomeText() {
        return someText;
    }

    public void setSomeText(String someText) {
        this.someText = someText;
    }
}
