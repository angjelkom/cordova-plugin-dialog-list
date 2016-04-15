<!--
#
# Licensed to the Apache Software Foundation (ASF) under one
# or more contributor license agreements.  See the NOTICE file
# distributed with this work for additional information
# regarding copyright ownership.  The ASF licenses this file
# to you under the Apache License, Version 2.0 (the
# "License"); you may not use this file except in compliance
# with the License.  You may obtain a copy of the License at
#
# http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing,
# software distributed under the License is distributed on an
# "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
#  KIND, either express or implied.  See the License for the
# specific language governing permissions and limitations
# under the License.
#
-->

# cordova-plugin-dialog-list

This is a cordova plugin which allows you to display a Native Dialog List on Android.
NOTE: You must wait for the `deviceready` event.

    document.addEventListener("deviceready", onDeviceReady, false);
    function onDeviceReady() {
        console.log(device.cordova);
    }

## Installation

    cordova plugin add cordova-plugin-dialog-list

    phonegap plugin add cordova-plugin-dialog-list

## Usage

    cordova.plugins.dialogList(success, error, title, array);

    success - Success callback function, which returns index of the clicked list item.

    error - Error callback function, which returns Error String

    title - String for the Title of the Dialog List

    array - Array of Strings which will be used as List in the Dialog

## Example

    document.addEventListener("deviceready", onDeviceReady, false);
    function onDeviceReady() {
        cordova.plugins.dialogList(function(index){

          //index of the clicked item

          console.log(index);

          }, function(error){
              console.log(error);
            }, "Dialog Title", ["Item 1", "Item 2", "Item 3"]);
    }

### Supported Platforms

- Android

### Screenshot

<img src="https://github.com/echonox/cordova-plugin-dialog-list/raw/master/Screenshot.png"></img>
