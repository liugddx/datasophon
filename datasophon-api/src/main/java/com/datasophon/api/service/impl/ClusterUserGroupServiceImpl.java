/*
 *  Licensed to the Apache Software Foundation (ASF) under one or more
 *  contributor license agreements.  See the NOTICE file distributed with
 *  this work for additional information regarding copyright ownership.
 *  The ASF licenses this file to You under the Apache License, Version 2.0
 *  (the "License"); you may not use this file except in compliance with
 *  the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */

package com.datasophon.api.service.impl;

import com.datasophon.api.service.ClusterGroupService;
import com.datasophon.api.service.ClusterUserService;
import com.datasophon.common.Constants;
import com.datasophon.dao.entity.ClusterGroup;
import com.datasophon.dao.entity.ClusterUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;


import com.datasophon.dao.mapper.ClusterUserGroupMapper;
import com.datasophon.dao.entity.ClusterUserGroup;
import com.datasophon.api.service.ClusterUserGroupService;


@Service("clusterUserGroupService")
public class ClusterUserGroupServiceImpl extends ServiceImpl<ClusterUserGroupMapper, ClusterUserGroup> implements ClusterUserGroupService {

    @Autowired
    private ClusterGroupService clusterGroupService;

    @Autowired
    private ClusterUserService userService;

    @Override
    public Integer countGroupUserNum(Integer groupId) {
        int count = this.count(new QueryWrapper<ClusterUserGroup>().eq(Constants.GROUP_ID, groupId));
        return count;
    }

    @Override
    public void deleteByUser(Integer id) {
        this.remove(new QueryWrapper<ClusterUserGroup>().eq(Constants.USER_ID,id));
    }

    @Override
    public ClusterGroup queryMainGroup(Integer userId) {
        List<ClusterUserGroup> clusterUserGroups = this.list(new QueryWrapper<ClusterUserGroup>().eq(Constants.USER_ID, userId).eq("user_group_type", 1));
        List<Integer> groupIds = clusterUserGroups.stream().map(e -> e.getGroupId()).collect(Collectors.toList());
        return clusterGroupService.getById(groupIds.get(0));
    }

    @Override
    public List<ClusterGroup> listOtherGroups(Integer userId) {
        List<ClusterUserGroup> clusterUserGroups = this.list(new QueryWrapper<ClusterUserGroup>().eq(Constants.USER_ID, userId).eq("user_group_type", 2));
        List<Integer> groupIds = clusterUserGroups.stream().map(e -> e.getGroupId()).collect(Collectors.toList());
        if(Objects.nonNull(groupIds) && !groupIds.isEmpty()){
            List<ClusterGroup> clusterGroups = (List<ClusterGroup>) clusterGroupService.listByIds(groupIds);
            return clusterGroups;
        }
        return null;
    }

    @Override
    public List<ClusterUser> listClusterUsers(Integer groupId) {
        List<ClusterUserGroup> clusterUserGroups = this.list(new QueryWrapper<ClusterUserGroup>().eq(Constants.GROUP_ID, groupId));
        if(!clusterUserGroups.isEmpty()){
            List<Integer> userIds = clusterUserGroups.stream().map(e -> e.getUserId()).collect(Collectors.toList());
            Collection<ClusterUser> clusterUsers = userService.listByIds(userIds);
            return (List<ClusterUser>) clusterUsers;
        }
        return null;
    }
}
