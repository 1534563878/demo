package com.zyq.demo.es;

import lombok.Data;

@Data
public class EsResponse<T> {
    private Integer state;
    private T  data;
}
