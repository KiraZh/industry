package team.fta.industry.mapper;

import org.springframework.stereotype.Repository;
import team.fta.industry.entity.WaterQuality;

import java.util.List;

@Repository
public interface WaterQualityMapper {
    public List<WaterQuality> selectAllWaterQuality();
}
