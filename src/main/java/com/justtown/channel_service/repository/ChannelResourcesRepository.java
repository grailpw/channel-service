package com.justtown.channel_service.repository;

import com.justtown.channel_service.entity.ChannelResources;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelResourcesRepository extends JpaRepository<ChannelResources, Long> {

}
