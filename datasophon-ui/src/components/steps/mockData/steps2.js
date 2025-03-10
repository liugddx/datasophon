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

/*
 * @Author: mjzhu
 * @describe: 
 * @Date: 2022-06-15 10:00:47
 * @LastEditTime: 2022-06-15 10:03:42
 * @FilePath: \ddh-ui\src\components\steps\mockData\steps2.js
 */
export const data = {
    "msg": "success",

    "total": 3,

    "code": 200,

    "data": [{
            "hostname": "iflytek016",

            "ip": "172.31.96.16",

            "managed": false,

            "checkResult": {
                "msg": "主机连接失败",

                "code": 10003

            },

            "sshUser": "root",

            "sshPort": 22,

            "progress": 0,

            "clusterCode": "test1",

            "installState": "正在安装"

        },
        {
            "hostname": "iflytek017",

            "ip": "172.31.96.17",

            "managed": true,

            "checkResult": {
                "msg": "主机连接失败",

                "code": 10003

            },

            "sshUser": "root",

            "sshPort": 22,

            "progress": 100,

            "clusterCode": "test1",

            "installState": "安装成功"

        }
    ]

}
