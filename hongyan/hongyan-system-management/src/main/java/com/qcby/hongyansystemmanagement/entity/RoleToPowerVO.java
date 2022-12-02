package com.qcby.hongyansystemmanagement.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class RoleToPowerVO {

    private Map<String, Map<String, List<String>>> resultMap;

}

