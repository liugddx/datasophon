<!--
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
 -->

<!--
 * @Author: mjzhu
 * @Date: 2022-05-24 10:28:22
 * @LastEditTime: 2022-07-27 15:54:37
 * @FilePath: \ddh-ui\src\pages\colonyManage\frame.vue
-->
<template>
  <a-spin :spinning="spinning">
    <div class="frame-list card-shadow">
      <a-tabs default-active-key="1" @change="callback">
        <a-tab-pane v-for="(item, index) in frameList" :key="index+1" :tab="item.frameCode">
          <a-table :columns="loadTable()" class="release-table-custom" :dataSource="item.frameServiceList" rowKey="id" :pagination="false"></a-table>
        </a-tab-pane>
      </a-tabs>
    </div>
  </a-spin>
</template>

<script>
export default {
  name: "FrameList",
  data() {
    return {
      loading: false,
      spinning: false,
      frameList: [],
      tableColumns: [
        { title: "序号", key: "index" },
        { title: "服务", key: "serviceName" },
        { title: "版本", key: "serviceVersion" },
        { title: "描述", key: "serviceDesc", ellipsis: true },
      ],
    };
  },
  methods: {
    callback(key) {
      console.log(key);
    },
    loadTable() {
      let that = this;
      let columns = that.tableColumns;
      return columns.map((item, index) => {
        return {
          title: item.title,
          key: item.key,
          fixed: item.fixed ? item.fixed : "",
          width: item.width ? item.width : "",
          ellipsis: item.ellipsis ? item.ellipsis : "",
          customRender: (text, record, index) => {
            if (item.key == "index") {
              return `${index + 1}`;
            } else {
              return <span title={record[item.key]}> {record[item.key]} </span>;
            }
          },
        };
      });
    },
    getFrameList() {
      this.spinning = true;
      this.$axiosPost(global.API.getFrameList, {}).then((res) => {
        this.spinning = false;
        if (res.code === 200) {
          this.frameList = res.data;
        }
      });
    },
  },
  mounted() {
    this.getFrameList();
  },
};
</script>

<style lang="less" scoped>
.frame-list {
  background: #fff;
  padding:0 20px 20px;
}
</style>
