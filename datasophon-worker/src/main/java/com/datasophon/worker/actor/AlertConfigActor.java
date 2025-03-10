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

package com.datasophon.worker.actor;

import akka.actor.UntypedActor;
import com.datasophon.common.command.GenerateAlertConfigCommand;
import com.datasophon.common.model.AlertItem;
import com.datasophon.common.model.Generators;
import com.datasophon.common.utils.ExecResult;
import com.datasophon.worker.utils.FreemakerUtils;


import java.util.HashMap;
import java.util.List;

public class AlertConfigActor extends UntypedActor {
    @Override
    public void onReceive(Object message) throws Throwable, Throwable {
        if(message instanceof GenerateAlertConfigCommand){
            GenerateAlertConfigCommand command = (GenerateAlertConfigCommand) message;
            ExecResult execResult = new ExecResult();
            HashMap<Generators, List<AlertItem>> configFileMap = command.getConfigFileMap();
            for (Generators generators : configFileMap.keySet()) {
                List<AlertItem> alertItems = configFileMap.get(generators);
                FreemakerUtils.generatePromAlertFile(generators,alertItems,generators.getFilename().replace(".yml","").toUpperCase());
            }
            execResult.setExecResult(true);
            getSender().tell(execResult,getSelf());
        }else {
            unhandled(message);
        }
    }
}
