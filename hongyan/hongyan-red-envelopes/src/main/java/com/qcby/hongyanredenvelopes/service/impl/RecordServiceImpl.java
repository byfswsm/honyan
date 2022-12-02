package com.qcby.hongyanredenvelopes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qcby.hongyanredenvelopes.entity.Record;
import com.qcby.hongyanredenvelopes.mapper.RecordMapper;
import com.qcby.hongyanredenvelopes.service.RecordService;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl extends ServiceImpl<RecordMapper, Record> implements RecordService {
}
