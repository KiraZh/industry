package team.fta.industry.mapper;

import org.springframework.stereotype.Repository;
import team.fta.industry.entity.Message;

import java.util.List;

@Repository
public interface MessageMapper {
    public List<Message> selectAllMessage();

}
