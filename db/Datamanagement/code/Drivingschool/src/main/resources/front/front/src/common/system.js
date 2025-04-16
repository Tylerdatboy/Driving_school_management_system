export function isAuth(tableName, key) {
  let role = localStorage.getItem("UserTableName");
  let menus = [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","modify","delete","发布缴费","Assign coach"],"menu":"student","menuJump":"列表","tableName":"xueyuan"}],"menu":"studentmanage"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","modify","delete"],"menu":"Driving school coach","menuJump":"列表","tableName":"jiaxiaojiaolian"}],"menu":"Driving school coachmanage"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","modify","delete"],"menu":"Assign coach","menuJump":"列表","tableName":"fenpeijiaolian"}],"menu":"Assign coachmanage"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["查看","modify","delete"],"menu":"Appointment Practice","menuJump":"列表","tableName":"yuyuelianxi"}],"menu":"Appointment Practicemanage"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["查看","modify","delete","新增","维护登记"],"menu":"Driving school vehicles","menuJump":"列表","tableName":"jiaxiaocheliang"}],"menu":"Driving school vehiclesmanage"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","modify","delete"],"menu":"Exam arrangements","menuJump":"列表","tableName":"kaoshianpai"}],"menu":"Exam arrangementsmanage"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","delete","modify"],"menu":"study plan","menuJump":"列表","tableName":"xuexijihua"}],"menu":"study planmanage"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看","modify","delete"],"menu":"Payment information","menuJump":"列表","tableName":"jiaofeixinxi"}],"menu":"Payment informationmanage"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","modify","delete"],"menu":"Vehicle maintenance","menuJump":"列表","tableName":"cheliangweihu"}],"menu":"Vehicle maintenancemanage"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["新增","查看","modify","delete"],"menu":"Registration for Driving School","menuJump":"列表","tableName":"jiaxiaobaoming"}],"menu":"Registration for Driving Schoolmanage"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","modify","delete"],"menu":"coach evaluate","menuJump":"列表","tableName":"jiaolianpingjia"}],"menu":"coach evaluatemanage"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","modify"],"menu":"About Us","tableName":"aboutus"},{"appFrontIcon":"cuIcon-qrcode","buttons":["查看","modify"],"menu":"System Introduction","tableName":"systemintro"},{"appFrontIcon":"cuIcon-shop","buttons":["新增","查看","modify","delete"],"menu":"Carousel management","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","modify","delete"],"menu":"Driving School Information","tableName":"news"}],"menu":"System manage"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","报名缴费"],"menu":"Registration for Driving School列表","menuJump":"列表","tableName":"jiaxiaobaoming"}],"menu":"Registration for Driving School模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"admin","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","Appointment Practice"],"menu":"Assign coach","menuJump":"列表","tableName":"fenpeijiaolian"}],"menu":"Assign coachmanage"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["查看","modify","delete","coach evaluate"],"menu":"Appointment Practice","menuJump":"列表","tableName":"yuyuelianxi"}],"menu":"Appointment Practicemanage"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看"],"menu":"Exam arrangements","menuJump":"列表","tableName":"kaoshianpai"}],"menu":"Exam arrangementsmanage"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看"],"menu":"study plan","menuJump":"列表","tableName":"xuexijihua"}],"menu":"study planmanage"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看","支付"],"menu":"Payment information","menuJump":"列表","tableName":"jiaofeixinxi"}],"menu":"Payment informationmanage"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","modify","delete"],"menu":"coach evaluate","menuJump":"列表","tableName":"jiaolianpingjia"}],"menu":"coach evaluatemanage"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","报名缴费"],"menu":"Registration for Driving School列表","menuJump":"列表","tableName":"jiaxiaobaoming"}],"menu":"Registration for Driving School模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"student","tableName":"xueyuan"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","Exam arrangements","study plan"],"menu":"Assign coach","menuJump":"列表","tableName":"fenpeijiaolian"}],"menu":"Assign coachmanage"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["查看","审核"],"menu":"Appointment Practice","menuJump":"列表","tableName":"yuyuelianxi"}],"menu":"Appointment Practicemanage"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["查看","维护登记"],"menu":"Driving school vehicles","menuJump":"列表","tableName":"jiaxiaocheliang"}],"menu":"Driving school vehiclesmanage"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","modify","delete"],"menu":"Exam arrangements","menuJump":"列表","tableName":"kaoshianpai"}],"menu":"Exam arrangementsmanage"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","modify","delete"],"menu":"study plan","menuJump":"列表","tableName":"xuexijihua"}],"menu":"study planmanage"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","modify","delete"],"menu":"Vehicle maintenance","menuJump":"列表","tableName":"cheliangweihu"}],"menu":"Vehicle maintenancemanage"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看"],"menu":"coach evaluate","menuJump":"列表","tableName":"jiaolianpingjia"}],"menu":"coach evaluatemanage"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","报名缴费"],"menu":"Registration for Driving School列表","menuJump":"列表","tableName":"jiaxiaobaoming"}],"menu":"Registration for Driving School模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"Driving school coach","tableName":"jiaxiaojiaolian"}];
  for(let i=0;i<menus.length;i++){
    if(menus[i].tableName==role){
      for(let j=0;j<menus[i].frontMenu.length;j++){
          for(let k=0;k<menus[i].frontMenu[j].child.length;k++){
            if(tableName==menus[i].frontMenu[j].child[k].tableName){
              let buttons = menus[i].frontMenu[j].child[k].buttons.join(',');
              return buttons.indexOf(key) !== -1 || false
            }
          }
      }
    }
  }
  return false;
}

/**
 *  * 获取当前时间（yyyy-MM-dd hh:mm:ss）
 *   */
export function getCurDateTime() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate(),
    hour = currentTime.getHours(),
    minute = currentTime.getMinutes(),
    second = currentTime.getSeconds();
    return year + "-" + month + "-" + day + " " +hour +":" +minute+":"+second;
}

/**
 *  * 获取当前日期（yyyy-MM-dd）
 *   */
export function getCurDate() {
    let currentTime = new Date(),
    year = currentTime.getFullYear(),
    month = currentTime.getMonth() + 1 < 10 ? '0' + (currentTime.getMonth() + 1) : currentTime.getMonth() + 1,
    day = currentTime.getDate() < 10 ? '0' + currentTime.getDate() : currentTime.getDate();
    return year + "-" + month + "-" + day;
}
