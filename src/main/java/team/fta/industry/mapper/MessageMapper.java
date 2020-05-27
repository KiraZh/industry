package team.fta.industry.mapper;

import team.fta.industry.domain.Message;

import java.util.List;

public interface MessageMapper {
    int insert(Message record);

    int insertSelective(Message record);

    List<Message> selectAll();
}