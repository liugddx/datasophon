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

package com.datasophon.worker.strategy;

import cn.hutool.core.io.FileUtil;
import com.datasophon.common.Constants;
import com.datasophon.common.cache.CacheUtils;
import com.datasophon.common.command.ServiceRoleOperateCommand;
import com.datasophon.common.utils.ExecResult;
import com.datasophon.worker.handler.ServiceHandler;
import com.datasophon.worker.utils.KerberosUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.SQLException;

public class NodeManagerHandlerStrategy implements ServiceRoleStrategy {
    private static final Logger logger = LoggerFactory.getLogger(NodeManagerHandlerStrategy.class);

    @Override
    public ExecResult handler(ServiceRoleOperateCommand command) throws SQLException, ClassNotFoundException {
        ExecResult startResult = new ExecResult();
        ServiceHandler serviceHandler = new ServiceHandler();
        if (command.getEnableKerberos()) {
            logger.info("start to get nodemanager keytab file");
            String hostname = CacheUtils.getString(Constants.HOSTNAME);
            KerberosUtils.createKeytabDir();
            if(!FileUtil.exist("/etc/security/keytab/nm.service.keytab")){
                KerberosUtils.downloadKeytabFromMaster("nm/" + hostname, "nm.service.keytab");
            }
            startResult = serviceHandler.start(command.getStartRunner(), command.getStatusRunner(), command.getDecompressPackageName(), command.getRunAs());
        } else {
            startResult = serviceHandler.start(command.getStartRunner(), command.getStatusRunner(), command.getDecompressPackageName(), command.getRunAs());
        }
        return startResult;
    }
}
