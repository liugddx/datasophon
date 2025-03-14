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

package com.datasophon.dao.mapper;

import com.datasophon.dao.entity.ClusterHostEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 集群主机表 
 * 
 * @author gaodayu
 * @email gaodayu2022@163.com
 * @date 2022-04-14 20:32:39
 */
@Mapper
public interface ClusterHostMapper extends BaseMapper<ClusterHostEntity> {

    ClusterHostEntity getClusterHostByHostname(@Param("hostname") String hostname);

    void updateBatchNodeLabel(@Param("hostIds") String hostIds,@Param("nodeLabel") String nodeLabel);
}
