package team.fta.industry.mapper;

import team.fta.industry.domain.Message;

public interface MessageMapper {
    int insert(Message record);

    int insertSelective(Message record);
}