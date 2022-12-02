package com.qcby.hongyanredenvelopes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.qcby.hongyanredenvelopes.entity.WareStock;
import com.qcby.hongyanredenvelopes.mapper.WareStockMapper;
import com.qcby.hongyanredenvelopes.service.WareStockService;
import org.springframework.stereotype.Service;

@Service
public class WareStockServiceImpl extends ServiceImpl<WareStockMapper, WareStock> implements WareStockService {
}
