package team.fta.industry.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import team.fta.industry.entity.Generator;
import team.fta.industry.mapper.GeneratorMapper;

import java.util.List;

@Service
public class GeneratorService {
    @Autowired
    GeneratorMapper generatorMapper;
    public List<Generator> selectAllGenerator(){
        return generatorMapper.selectAllGenerator();
    }

}
