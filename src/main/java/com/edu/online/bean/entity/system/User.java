package com.edu.online.bean.entity.system;

import com.edu.online.bean.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * User.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/1/30
 */
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "T_USER", schema = "SYSTEM")
public class User extends BaseEntity {

    @Column(name = "C_LOGINID", length = 50)
    private String loginId;

    @Column(name = "C_NAME", length = 50)
    private String name;

    @Column(name = "C_PASSWORD", length = 50)
    private String password;
}
