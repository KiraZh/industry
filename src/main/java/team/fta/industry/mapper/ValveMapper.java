package team.fta.industry.mapper;

import org.springframework.stereotype.Repository;
import team.fta.industry.entity.Valve;

import java.util.List;

@Repository
public interface ValveMapper {
    public List<Valve> selectAllValve();
}
