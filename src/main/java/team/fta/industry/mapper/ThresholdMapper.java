package team.fta.industry.mapper;

import org.springframework.stereotype.Repository;
import team.fta.industry.entity.Threshold;

import java.util.List;

@Repository
public interface ThresholdMapper {
    public List<Threshold> selectAllThreshold();
}
