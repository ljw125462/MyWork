package com.example.powermanager.base.result;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

@Slf4j
@Data
public class PageTableRequest implements Serializable {
    private Integer page;
    private Integer limit;
    private Integer offset;

    public void countOffset(){
        if (null == this.page || null == this.limit){
            this.offset = 0;
            return;
        }
        this.offset=(this.page - 1) * limit;
    }

    @Override
    public String toString() {
        return "PageTableRequest{" +
                "page=" + page +
                ", limit=" + limit +
                ", offset=" + offset +
                '}';
    }
}
