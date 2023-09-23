package com.justtown.channel_service.repository;

import com.justtown.channel_service.entity.ChannelDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelDetailsRepository extends JpaRepository<ChannelDetails, Long> {

}
