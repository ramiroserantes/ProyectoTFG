package com.proyect.tfg.model.entities.topic;

import com.proyect.tfg.model.entities.topic.Topic;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TopicDao extends PagingAndSortingRepository<Topic, Long> {}
