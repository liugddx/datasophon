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
 * @Date: 2022-06-14 20:06:51
 * @LastEditTime: 2022-06-22 17:07:41
 * @FilePath: \ddh-ui\src\store\modules\steps\steps.js
 */

const state = {
  clusterId: '',
  steps1: {
    hosts: '',
    sshUser: '',
    sshPort: ''
  },
  steps7: {},
  commandType: 'INSTALL_SERVICE',
  commandIds: ''
}
const getters = {}
const mutations = {}
Object.keys(state).forEach((item) => {
  mutations[item] = (state, value) => {
    state[item] = value
  }
})

const actions = {
  setSteps1({
    commit
  }, obj) {
    commit('steps1', obj)
  },
  setClusterId({
    commit
  }, obj) {
    commit('clusterId', obj)
  },
  setCommandType({
    commit
  }, obj) {
    commit('commandType', obj)
  },
  setCommandIds({
    commit
  }, obj) {
    commit('commandIds', obj)
  },
}
export default {
  namespaced: 'steps',
  state,
  getters,
  actions,
  mutations
}
