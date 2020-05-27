package team.fta.industry.mapper;

import java.util.Date;
import team.fta.industry.domain.Generator;

public interface GeneratorMapper {
    int deleteByPrimaryKey(Date time);

    int insert(Generator record);

    int insertSelective(Generator record);

    Generator selectByPrimaryKey(Date time);

    int updateByPrimaryKeySelective(Generator record);

    int updateByPrimaryKey(Generator record);
}