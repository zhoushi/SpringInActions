package com.spring.Bean;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/11/18.
 */

/**
 * 告知Spring要为这个类创建bean
 */
@Component
public class SgtPeppers implements CompactDisc {
    private String title = "sgt peoper";
    private String artist = "the beatles";
    public void play() {
        System.out.println("Playing"+title+"by"+artist);
    }
}
