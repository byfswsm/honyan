package com.qcby.hongyanredenvelopes.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.qcby.hongyanredenvelopes.entity.Envelope;
import com.qcby.hongyanredenvelopes.mapper.EnvelopeMapper;
import com.qcby.hongyanredenvelopes.service.EnvelopeService;
import org.springframework.stereotype.Service;

@Service
public class EnvelopeServiceImpl extends ServiceImpl<EnvelopeMapper, Envelope> implements EnvelopeService {
}
