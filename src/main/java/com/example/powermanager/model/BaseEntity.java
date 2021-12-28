package com.example.powermanager.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class BaseEntity<ID extends Serializable> implements Serializable {

    private static final long serialVersionUID = 8925514045582235838L;
    private ID id;
    private Date createTime = new Date();
    @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    private Date updateTime = new Date();
}
