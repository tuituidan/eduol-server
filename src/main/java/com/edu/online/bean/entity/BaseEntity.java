package com.edu.online.bean.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import lombok.Getter;
import lombok.Setter;

/**
 * BaseDO.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/1/30
 */
@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @Column(name = "C_ID", columnDefinition = "CHAR(32)")
    private String id;

    @Column(name = "DT_CREATE_TIME")
    private Date createTime;

    @Column(name = "DT_UPDATE_TIME")
    private Date updateTime;
}
