package com.edu.online.bean.entity.system;

import com.edu.online.bean.entity.BaseEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * Role.
 *
 * @author zhujunhan
 * @version 1.0
 * @date 2020/1/30
 */
@Getter
@Setter
@Accessors(chain = true)
@Entity
@Table(name = "T_ROLE", schema = "SYSTEM")
public class Role extends BaseEntity {

    @Column(name = "C_NAME",length = 50)
    private String name;
}
