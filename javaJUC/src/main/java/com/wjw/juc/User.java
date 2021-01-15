package com.wjw.juc;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created on 2021/1/15 0015
 *
 * @author weng
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Integer id;
    private String userName;
    private Integer age;

}
