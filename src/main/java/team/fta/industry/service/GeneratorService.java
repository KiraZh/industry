package team.fta.industry.service;

import org.springframework.stereotype.Service;
import team.fta.industry.domain.Generator;
import team.fta.industry.mapper.GeneratorMapper;

import javax.annotation.Resource;

@Service
public class GeneratorService {

    @Resource
    private GeneratorMapper generatorMapper;


    public int insert(Generator record) {
        return generatorMapper.insert(record);
    }


    public Generator selectRecent() {
        return generatorMapper.selectRecent();
    }
}
