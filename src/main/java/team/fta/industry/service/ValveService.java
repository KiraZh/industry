package team.fta.industry.service;

import org.springframework.stereotype.Service;
import team.fta.industry.domain.Valve;
import team.fta.industry.mapper.ValveMapper;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ValveService {

    @Resource
    private ValveMapper valveMapper;


    public List<Valve> selectRecents() {
        return valveMapper.selectRecents();
    }

    public Valve selectRecent() {
        return valveMapper.selectRecent();
    }

}
