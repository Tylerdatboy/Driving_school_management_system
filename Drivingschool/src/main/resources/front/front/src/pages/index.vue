<template>
  <div class="main-containers">
    <div class="top-container"
         :style='{"boxShadow":"0 0px 0px rgba(64, 158, 255, .3)","padding":"0 0 0 120px","alignItems":"center","display":"flex","justifyContent":"space-between","overflow":"hidden","top":"0","left":"0","background":"linear-gradient(240deg, rgba(238,238,238,1) 0%, rgba(255,255,255,1) 50%, rgba(238,238,238,1) 100%),#fff","width":"100%","position":"fixed","height":"64px","zIndex":"1002"}'>
      <img v-if='false'
           :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","display":"block","height":"44px"}'
           src='http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg'>
      <div v-if="true" :style='{"color":"#333","fontSize":"26px","fontWeight":"600"}'>Driving School Reservation
        Management System
      </div>
      <div>
        <div v-if="false" :style='{"color":"#666","fontSize":"16px","display":"inline-block"}'>0753-1234567</div>
        <div v-if="Token" :style='{"color":"#666","fontSize":"16px","display":"inline-block"}'>{{ username }}</div>
        <el-button v-if="!Token" @click="toLogin()"
                   :style='{"border":"none","padding":"0 20px","margin":"0 0 0 10px","color":"#fff","borderRadius":"2px","background":"#992298","display":"inline-block","fontSize":"14px","lineHeight":"32px","minWidth":"80px","height":"32px"}'>
          Login /Registered
        </el-button>
        <el-button v-if="Token" @click="logout"
                   :style='{"border":"none","padding":"0 20px","margin":"0 20px 0 10px","color":"#333","borderRadius":"2px","background":"#fff000","display":"inline-block","fontSize":"14px","lineHeight":"32px","minWidth":"80px","height":"32px"}'>
          exit
        </el-button>
      </div>
    </div>


    <div class="body-containers"
         :style='"horizontal" == "vertical" ? {"minHeight":"100vh","padding":"64px 0 0","margin":"0 0 0 210px","position":"relative","background":"rgba(64, 158, 255, .3)","display":"block"} : {"minHeight":"100vh","padding":"150px 0 0","margin":"0","position":"relative","background":"#fff"}'>
      <div class="menu-preview"
           :style='{"padding":"0","borderColor":"#efefef","top":"64px","left":"0","background":"url(http://codegen.caihongy.cn/20230131/fb996fdf6c5c4781a7b257b4b91254dd.png) no-repeat center top","borderWidth":"0","width":"100%","position":"fixed","borderStyle":"solid","height":"109px","zIndex":"1002"}'>
        <el-menu  class="el-menu-horizontal-demo"
                 :style='{"border":0,"padding":"0","listStyle":"none","margin":"0","background":"none","display":"flex","position":"relative","justifyContent":"center"}'
                 :default-active="activeIndex" :unique-opened="true" mode="horizontal" :router="true"
                 @select="handleSelect">
          <el-image v-if="false"
                    :style='{"width":"44px","margin":"8px 10px 8px 0","objectFit":"cover","borderRadius":"100%","float":"left","height":"44px"}'
                    src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg"
                    fit="cover"></el-image>
          <el-menu-item v-for="(menu, index) in menuList" :index="index + ''" :key="index" :route="menu.url">
            <i v-if="true"
               :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"16px","lineHeight":"60px","fontSize":"14px","height":"60px"}'
               :class="iconArr[index]"></i>
            <span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"16px","color":"inherit","height":"60px"}'>{{ menu.name }}</span>
          </el-menu-item>
          <!--          <el-menu-item @click="goKaoshi">-->
          <!--            <i v-if="true" :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"16px","lineHeight":"60px","fontSize":"14px","height":"60px"}' class="el-icon-box"></i>-->
          <!--            <span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"16px","color":"inherit","height":"60px"}'>模拟考试</span>-->
          <!--          </el-menu-item>-->
<!--          <el-menu-item @click="goBackend">
            <i v-if="true"
               :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"16px","lineHeight":"60px","fontSize":"14px","height":"60px"}'
               class="el-icon-box"></i>
            <span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"16px","color":"inherit","height":"60px"}'>Backend manage</span>
          </el-menu-item>-->

          <el-menu-item :index="menuList.length + 2 + ''" v-if="Token && notAdmin" @click="goMenu('/index/center')">
            <i v-if="true"
               :style='{"padding":"0 10px","margin":"0","color":"inherit","width":"16px","lineHeight":"60px","fontSize":"14px","height":"60px"}'
               class="el-icon-user"></i>
            <span :style='{"padding":"0 10px","lineHeight":"60px","fontSize":"16px","color":"inherit","height":"60px"}'>Personal Center</span>
          </el-menu-item>
        </el-menu>
      </div>

<!--      <div class="banner-preview" :style='{"width":"100%","height":"auto"}'>
        <el-carousel :style='{"width":"100%","margin":"0 auto"}' trigger="click" indicator-position="inside"
                     arrow="always" type="card" direction="horizontal" height="400px" :autoplay="false" :interval="3000"
                     :loop="true">
          <el-carousel-item :style='{"borderRadius":"10px","width":"50%","height":"100%"}' v-for="item in carouselList"
                            :key="item.id">
            <el-image :style='{"objectFit":"cover","width":"100%","height":"100%"}' :src="baseUrl + item.value"
                      fit="cover"></el-image>
          </el-carousel-item>
        </el-carousel>
      </div>-->

      <router-view></router-view>

      <div class="bottom-preview"
           :style='{"minHeight":"100px","padding":"50px 0 0","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230201/ae87d4647e2f4c4fb314d07248f3fbbd.jpg) no-repeat center top,#273341","flexDirection":"column","display":"flex","width":"100%","justifyContent":"center"}'>
        <img :style='{"width":"44px","objectFit":"cover","borderRadius":"100%","display":"none","height":"44px"}'
             src="http://codegen.caihongy.cn/20201114/7856ba26477849ea828f481fa2773a95.jpg">
        <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#fff"}'></div>
        <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
        <div :style='{"margin":"10px 0 0","fontSize":"14px","lineHeight":"28px","color":"#333"}'></div>
      </div>
    </div>

  </div>
</template>

<script>
import Vue from 'vue'

export default {
  data() {
    return {
      activeIndex: '0',
      roleMenus: [{
        "backMenu": [{
          "child": [{
            "appFrontIcon": "cuIcon-goods",
            "buttons": ["查看", "modify", "delete", "发布缴费", "Assign coach"],
            "menu": "student",
            "menuJump": "列表",
            "tableName": "xueyuan"
          }], "menu": "studentmanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-skin",
            "buttons": ["查看", "modify", "delete"],
            "menu": "Driving school coach",
            "menuJump": "列表",
            "tableName": "jiaxiaojiaolian"
          }], "menu": "Driving school coachmanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-similar",
            "buttons": ["查看", "modify", "delete"],
            "menu": "Assign coach",
            "menuJump": "列表",
            "tableName": "fenpeijiaolian"
          }], "menu": "Assign coachmanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-circle",
            "buttons": ["查看", "modify", "delete"],
            "menu": "Appointment Practice",
            "menuJump": "列表",
            "tableName": "yuyuelianxi"
          }], "menu": "Appointment Practicemanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-rank",
            "buttons": ["查看", "modify", "delete", "新增", "维护登记"],
            "menu": "Driving school vehicles",
            "menuJump": "列表",
            "tableName": "jiaxiaocheliang"
          }], "menu": "Driving school vehiclesmanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-list",
            "buttons": ["查看", "modify", "delete"],
            "menu": "Exam arrangements",
            "menuJump": "列表",
            "tableName": "kaoshianpai"
          }], "menu": "Exam arrangementsmanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-time",
            "buttons": ["查看", "delete", "modify"],
            "menu": "study plan",
            "menuJump": "列表",
            "tableName": "xuexijihua"
          }], "menu": "study planmanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-present",
            "buttons": ["查看", "modify", "delete"],
            "menu": "Payment information",
            "menuJump": "列表",
            "tableName": "jiaofeixinxi"
          }], "menu": "Payment informationmanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-flashlightopen",
            "buttons": ["查看", "modify", "delete"],
            "menu": "Vehicle maintenance",
            "menuJump": "列表",
            "tableName": "cheliangweihu"
          }], "menu": "Vehicle maintenancemanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-shop",
            "buttons": ["新增", "查看", "modify", "delete"],
            "menu": "Driving School Information",
            "menuJump": "列表",
            "tableName": "jiaxiaobaoming"
          }], "menu": "Registration for Driving Schoolmanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-paint",
            "buttons": ["查看", "modify", "delete"],
            "menu": "coach evaluate",
            "menuJump": "列表",
            "tableName": "jiaolianpingjia"
          }], "menu": "coach evaluatemanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-goods",
            "buttons": ["查看", "modify"],
            "menu": "About Us",
            "tableName": "aboutus"
          }, {
            "appFrontIcon": "cuIcon-qrcode",
            "buttons": ["查看", "modify"],
            "menu": "System Introduction",
            "tableName": "systemintro"
          }, {
            "appFrontIcon": "cuIcon-shop",
            "buttons": ["新增", "查看", "modify", "delete"],
            "menu": "Carousel management",
            "tableName": "config"
          }, {
            "appFrontIcon": "cuIcon-news",
            "buttons": ["新增", "查看", "modify", "delete"],
            "menu": "Driving School Information",
            "tableName": "news"
          }], "menu": "System manage"
        }],
        "frontMenu": [{
          "child": [{
            "appFrontIcon": "cuIcon-explore",
            "buttons": ["查看", "报名缴费"],
            "menu": "Registration for Driving School列表",
            "menuJump": "列表",
            "tableName": "jiaxiaobaoming"
          }], "menu": "Registration for Driving School模块"
        }],
        "hasBackLogin": "是",
        "hasBackRegister": "否",
        "hasFrontLogin": "否",
        "hasFrontRegister": "否",
        "roleName": "admin",
        "tableName": "users"
      }, {
        "backMenu": [{
          "child": [{
            "appFrontIcon": "cuIcon-similar",
            "buttons": ["查看", "Appointment Practice"],
            "menu": "Assign coach",
            "menuJump": "列表",
            "tableName": "fenpeijiaolian"
          }], "menu": "Assign coachmanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-circle",
            "buttons": ["查看", "modify", "delete", "coach evaluate"],
            "menu": "Appointment Practice",
            "menuJump": "列表",
            "tableName": "yuyuelianxi"
          }], "menu": "Appointment Practicemanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-list",
            "buttons": ["查看"],
            "menu": "Exam arrangements",
            "menuJump": "列表",
            "tableName": "kaoshianpai"
          }], "menu": "Exam arrangementsmanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-time",
            "buttons": ["查看"],
            "menu": "study plan",
            "menuJump": "列表",
            "tableName": "xuexijihua"
          }], "menu": "study planmanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-present",
            "buttons": ["查看", "支付"],
            "menu": "Payment information",
            "menuJump": "列表",
            "tableName": "jiaofeixinxi"
          }], "menu": "Payment informationmanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-paint",
            "buttons": ["查看", "modify", "delete"],
            "menu": "coach evaluate",
            "menuJump": "列表",
            "tableName": "jiaolianpingjia"
          }], "menu": "coach evaluatemanage"
        }],
        "frontMenu": [{
          "child": [{
            "appFrontIcon": "cuIcon-explore",
            "buttons": ["查看", "报名缴费"],
            "menu": "Registration for Driving School列表",
            "menuJump": "列表",
            "tableName": "jiaxiaobaoming"
          }], "menu": "Registration for Driving School模块"
        }],
        "hasBackLogin": "是",
        "hasBackRegister": "否",
        "hasFrontLogin": "是",
        "hasFrontRegister": "是",
        "roleName": "student",
        "tableName": "xueyuan"
      }, {
        "backMenu": [{
          "child": [{
            "appFrontIcon": "cuIcon-similar",
            "buttons": ["查看", "Exam arrangements", "study plan"],
            "menu": "Assign coach",
            "menuJump": "列表",
            "tableName": "fenpeijiaolian"
          }], "menu": "Assign coachmanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-circle",
            "buttons": ["查看", "审核"],
            "menu": "Appointment Practice",
            "menuJump": "列表",
            "tableName": "yuyuelianxi"
          }], "menu": "Appointment Practicemanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-rank",
            "buttons": ["查看", "维护登记"],
            "menu": "Driving school vehicles",
            "menuJump": "列表",
            "tableName": "jiaxiaocheliang"
          }], "menu": "Driving school vehiclesmanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-list",
            "buttons": ["查看", "modify", "delete"],
            "menu": "Exam arrangements",
            "menuJump": "列表",
            "tableName": "kaoshianpai"
          }], "menu": "Exam arrangementsmanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-time",
            "buttons": ["查看", "modify", "delete"],
            "menu": "study plan",
            "menuJump": "列表",
            "tableName": "xuexijihua"
          }], "menu": "study planmanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-flashlightopen",
            "buttons": ["查看", "modify", "delete"],
            "menu": "Vehicle maintenance",
            "menuJump": "列表",
            "tableName": "cheliangweihu"
          }], "menu": "Vehicle maintenancemanage"
        }, {
          "child": [{
            "appFrontIcon": "cuIcon-paint",
            "buttons": ["查看"],
            "menu": "coach evaluate",
            "menuJump": "列表",
            "tableName": "jiaolianpingjia"
          }], "menu": "coach evaluatemanage"
        }],
        "frontMenu": [{
          "child": [{
            "appFrontIcon": "cuIcon-explore",
            "buttons": ["查看", "报名缴费"],
            "menu": "Registration for Driving School列表",
            "menuJump": "列表",
            "tableName": "jiaxiaobaoming"
          }], "menu": "Registration for Driving School模块"
        }],
        "hasBackLogin": "是",
        "hasBackRegister": "否",
        "hasFrontLogin": "是",
        "hasFrontRegister": "是",
        "roleName": "Driving school coach",
        "tableName": "jiaxiaojiaolian"
      }],
      baseUrl: '',
      carouselList: [],
      menuList: [],
      form: {
        ask: '',
        userid: localStorage.getItem('userid')
      },
      Token: localStorage.getItem('Token'),
      username: localStorage.getItem('username'),
      notAdmin: localStorage.getItem('sessionTable') != '"users"',
      timer: '',
      iconArr: [
        'el-icon-star-off',
        'el-icon-goods',
        'el-icon-warning',
        'el-icon-question',
        'el-icon-info',
        'el-icon-help',
        'el-icon-picture-outline-round',
        'el-icon-camera-solid',
        'el-icon-video-camera-solid',
        'el-icon-video-camera',
        'el-icon-bell',
        'el-icon-s-cooperation',
        'el-icon-s-order',
        'el-icon-s-platform',
        'el-icon-s-operation',
        'el-icon-s-promotion',
        'el-icon-s-release',
        'el-icon-s-ticket',
        'el-icon-s-management',
        'el-icon-s-open',
        'el-icon-s-shop',
        'el-icon-s-marketing',
        'el-icon-s-flag',
        'el-icon-s-comment',
        'el-icon-s-finance',
        'el-icon-s-claim',
        'el-icon-s-opportunity',
        'el-icon-s-data',
        'el-icon-s-check'
      ],
    }
  },
  created() {
    this.baseUrl = this.$config.baseUrl;
    this.menuList = this.$config.indexNav;
    this.getCarousel();
  },
  mounted() {
    this.activeIndex = localStorage.getItem('keyPath') || '0';
  },
  watch: {
    $route(newValue) {
      let that = this
      let url = window.location.href
      let arr = url.split('#')
      for (let x in this.menuList) {
        if (newValue.path == this.menuList[x].url) {
          this.activeIndex = x
        }
      }
      this.Token = localStorage.getItem('Token')
    },
  },
  methods: {
    handleSelect(keyPath) {
      if (keyPath) {
        localStorage.setItem('keyPath', keyPath)
      }
    },
    toLogin() {
      this.$router.push('/login');
    },
    logout() {
      localStorage.clear();
      Vue.http.headers.common['Token'] = "";
      this.$router.push('/index/home');
      this.activeIndex = '0'
      localStorage.setItem('keyPath', this.activeIndex)
      this.Token = ''
      this.$forceUpdate()
      this.$message({
        message: 'Log out  success',
        type: 'success',
        duration: 1000,
      });
    },
    getCarousel() {
      this.$http.get('config/list', {params: {page: 1, limit: 3}}).then(res => {
        if (res.data.code == 0) {
          this.carouselList = res.data.data.list;
        }
      });
    },
    goBackend() {
      window.open(`${this.$config.baseUrl}admin/dist/index.html`, "_blank");
    },
    goKaoshi() {
      window.open(`www.baidu.com`, "_blank");
    },
    goMenu(path) {
      if (!localStorage.getItem('Token')) {
        this.toLogin();
      } else {
        this.$router.push(path);
      }
    },
  }
}
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
.menu-preview {
  .el-scrollbar {
    height: 100%;

    & /deep/ .scrollbar-wrapper {
      overflow-x: hidden;
    }
  }
}


.menu-preview .el-menu-horizontal-demo .el-menu-item {
  cursor: pointer;
  border: 0;
  padding: 0 20px;
  color: #fff;
  white-space: nowrap;
  display: flex;
  font-size: 16px;
  line-height: 60px;
  background: none;
  align-items: center;
  position: relative;
  list-style: none;
  height: 60px;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item:hover {
  cursor: pointer;
  border: 0;
  padding: 0 20px;
  color: #fff000;
  white-space: nowrap;
  background: none;
  font-size: 16px;
  line-height: 60px;
  position: relative;
  list-style: none;
  height: 60px;
}

.menu-preview .el-menu-horizontal-demo .el-menu-item.is-active {
  cursor: pointer;
  border: 0;
  padding: 0 20px;
  color: #fff000;
  white-space: nowrap;
  background: none;
  font-size: 16px;
  line-height: 60px;
  position: relative;
  list-style: none;
  height: 60px;
}

.banner-preview {
  .el-carousel /deep/ .el-carousel__indicator button {
    width: 0;
    height: 0;
    display: none;
  }
}

.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left {
  width: 36px;
  font-size: 12px;
  height: 36px;
}

.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--left:hover {
  background: #abb340;
}

.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right {
  width: 36px;
  font-size: 12px;
  height: 36px;
}

.banner-preview .el-carousel /deep/ .el-carousel__container .el-carousel__arrow--right:hover {
  background: #abb340;
}

.banner-preview .el-carousel /deep/ .el-carousel__indicators {
  padding: 0;
  margin: 0;
  z-index: 2;
  position: absolute;
  list-style: none;
}

.banner-preview .el-carousel /deep/ .el-carousel__indicators li {
  padding: 0;
  margin: 0 4px;
  background: #fff;
  display: inline-block;
  width: 12px;
  opacity: 0.4;
  transition: 0.3s;
  height: 12px;
}

.banner-preview .el-carousel /deep/ .el-carousel__indicators li:hover {
  padding: 0;
  margin: 0 4px;
  background: #fff;
  display: inline-block;
  width: 24px;
  opacity: 0.7;
  height: 12px;
}

.banner-preview .el-carousel /deep/ .el-carousel__indicators li.is-active {
  padding: 0;
  margin: 0 4px;
  background: #fff;
  display: inline-block;
  width: 24px;
  opacity: 1;
  height: 12px;
}

.chat-content {
  .left-content {
    width: 100%;
    text-align: left;
  }

  .right-content {
    width: 100%;
    text-align: right;
  }
}
</style>
