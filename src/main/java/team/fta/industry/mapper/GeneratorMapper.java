package team.fta.industry.mapper;

import team.fta.industry.entity.Generator;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface GeneratorMapper {
    /**
     * 查询所有发电机信息
     * @return 发电机信息集合
     */
    List<Generator> selectAllGenerator();

}
