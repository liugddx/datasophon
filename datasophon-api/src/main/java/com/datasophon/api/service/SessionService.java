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

package com.datasophon.api.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.datasophon.dao.entity.SessionEntity;
import com.datasophon.dao.entity.UserInfoEntity;
import javax.servlet.http.HttpServletRequest;

/**
 * @author gaodayu
 * @email gaodayu2022@163.com
 * @date 2022-03-16 11:40:00
 */
public interface SessionService extends IService<SessionEntity> {
    SessionEntity getSession(HttpServletRequest request);

    String createSession(UserInfoEntity user, String ip);

    void signOut(String ip, UserInfoEntity loginUser);
}

