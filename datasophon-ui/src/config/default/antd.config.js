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
 * @Date: 2022-05-24 10:28:22
 * @LastEditTime: 2022-10-27 19:10:56
 * @FilePath: \ddh-ui\src\config\default\antd.config.js
 */
// antd 配置
const ANTD = {
  primary: {
    color: '#0279FE',
    warning: '#faad14',
    success: '#52c41a',
    error: '#f5222d',
    // light: {
    //   menuColors: ['#000c17', '#001529', '#002140']
    // },
    // dark: {
    //   menuColors: ['#000c17', '#001529', '#002140']
    // },
    light: {
      menuColors: ['#1E222D', '#262F3E', '#313C4F']
    },
    dark: {
      menuColors: ['#1E222D', '#262F3E', '#313C4F']
    },
    night: {
      menuColors: ['#151515', '#1f1f1f', '#1e1e1e'],
    }
  },
  // .ant-layout-sider-dark
  theme: {
    dark: {
      'layout-body-background': '#f0f2f5',
      'body-background': '#fff',
      'component-background': '#fff',
      'heading-color': 'rgba(0, 0, 0, 0.85)',
      'text-color': 'rgba(0, 0, 0, 0.65)',
      'text-color-inverse': '#fff',
      'text-color-secondary': 'rgba(0, 0, 0, 0.45)',
      'shadow-color': 'rgba(0, 0, 0, 0.15)',
      'border-color-split': '#f0f0f0',
      'background-color-light': '#fafafa',
      'background-color-base': '#f5f5f5',
      'table-selected-row-bg': '#fafafa',
      'table-expanded-row-bg': '#fbfbfb',
      'checkbox-check-color': '#fff',
      'disabled-color': 'rgba(0, 0, 0, 0.25)',
      'menu-dark-color': 'rgba(254, 254, 254, 0.65)',
      'menu-dark-highlight-color': '#fefefe',
      'menu-dark-arrow-color': '#fefefe',
      'btn-primary-color': '#fff',
    },
    light: {
      'layout-body-background': '#f0f2f5',
      'body-background': '#fff',
      'component-background': '#fff',
      'heading-color': 'rgba(0, 0, 0, 0.85)',
      'text-color': 'rgba(0, 0, 0, 0.65)',
      'text-color-inverse': '#fff',
      'text-color-secondary': 'rgba(0, 0, 0, 0.45)',
      'shadow-color': 'rgba(0, 0, 0, 0.15)',
      'border-color-split': '#f0f0f0',
      'background-color-light': '#fafafa',
      'background-color-base': '#f5f5f5',
      'table-selected-row-bg': '#fafafa',
      'table-expanded-row-bg': '#fbfbfb',
      'checkbox-check-color': '#fff',
      'disabled-color': 'rgba(0, 0, 0, 0.25)',
      'menu-dark-color': 'rgba(1, 1, 1, 0.65)',
      'menu-dark-highlight-color': '#fefefe',
      'menu-dark-arrow-color': '#fefefe',
      'btn-primary-color': '#fff',
    },
    night: {
      'layout-body-background': '#000',
      'body-background': '#141414',
      'component-background': '#141414',
      'heading-color': 'rgba(255, 255, 255, 0.85)',
      'text-color': 'rgba(255, 255, 255, 0.85)',
      'text-color-inverse': '#141414',
      'text-color-secondary': 'rgba(255, 255, 255, 0.45)',
      'shadow-color': 'rgba(255, 255, 255, 0.15)',
      'border-color-split': '#303030',
      'background-color-light': '#ffffff0a',
      'background-color-base': '#2a2a2a',
      'table-selected-row-bg': '#ffffff0a',
      'table-expanded-row-bg': '#ffffff0b',
      'checkbox-check-color': '#141414',
      'disabled-color': 'rgba(255, 255, 255, 0.25)',
      'menu-dark-color': 'rgba(254, 254, 254, 0.65)',
      'menu-dark-highlight-color': '#fefefe',
      'menu-dark-arrow-color': '#fefefe',
      'btn-primary-color': '#141414',
    }
  }
}
module.exports = ANTD
