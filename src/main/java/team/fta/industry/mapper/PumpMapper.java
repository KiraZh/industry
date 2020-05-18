package team.fta.industry.mapper;

import org.springframework.stereotype.Repository;
import team.fta.industry.entity.Pump;

import java.util.List;

@Repository
public interface PumpMapper {
    List<Pump> selectAllPump();
}
