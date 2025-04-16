<template>
<div>
	<div class="container" :style='{"minHeight":"100vh","width":"100%","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230131/c788dee9481d4fd896e419a46388d74e.png) no-repeat center bottom,url(http://codegen.caihongy.cn/20230131/fb996fdf6c5c4781a7b257b4b91254dd.png) no-repeat center top,url(http://codegen.caihongy.cn/20230131/bd3718741ba74578b2f69615121a81d9.jpg) no-repeat center bottom / 100% auto","justifyContent":"center","display":"block"}'>
		<el-form ref="loginForm" :model="loginForm" :style='{"padding":"140px 0 0px","boxShadow":"0 0px 0px rgba(64, 158, 255, .8)","margin":"0 auto 0px","borderRadius":"0","alignItems":"center","flexWrap":"wrap","background":"none","display":"flex","width":"800px","position":"relative","justifyContent":"center","height":"auto"}' :rules="rules">
			<div v-if="false" :style='{"margin":"0 0 10px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)"}'>USER / LOGIN</div>
			<div v-if="true" :style='{"width":"100%","margin":"0 0 30px 0","lineHeight":"24px","fontSize":"20px","color":"#333","textAlign":"center"}'>Login to the driving school reservation management system</div>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"80%","margin":"0 0 20px","flexWrap":"wrap","display":"flex"}' prop="username">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>账号：</div>
				<input :style='{"border":"1px solid #ddd","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","color":"#333","borderRadius":"8px","background":"#fff","width":"100%","fontSize":"14px","height":"40px"}' v-model="loginForm.username" placeholder="Please enter your account">
			</el-form-item>
			<el-form-item v-if="loginType==1" class="list-item" :style='{"width":"80%","margin":"0 0 20px","flexWrap":"wrap","display":"flex"}' prop="password">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>password：</div>
				<input :style='{"border":"1px solid #ddd","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","color":"#333","borderRadius":"8px","background":"#fff","width":"100%","fontSize":"14px","height":"40px"}' v-model="loginForm.password" placeholder="Please input a password" type="password">
			</el-form-item>
			<el-form-item v-if="roles.length>1" class="list-type" :style='{"width":"100%","margin":"20px 10% 20px","lineHeight":"44px","height":"44px"}' prop="role">
				<el-radio v-model="loginForm.tableName" :label="item.tableName" v-for="(item, index) in roles" :key="index" @change.native="getCurrentRow(item)">{{item.roleName}}</el-radio>
			</el-form-item>
			<el-form-item :style='{"width":"80%","margin":"0px auto","position":"absolute","bottom":"-90px","display":"flex"}'>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0","outline":"none","color":"#333","borderRadius":"0","background":"linear-gradient(0deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","width":"100%","fontSize":"16px","minWidth":"120px","height":"44px"}' @click="submitForm('loginForm')">Login </el-button>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 5px","outline":"none","color":"#333","borderRadius":"0","textAlign":"right","background":"none","width":"100%","fontSize":"14px","height":"44px"}' @click="resetForm('loginForm')">Reset </el-button>
				<el-button v-if="loginType==1" :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0 5px","outline":"none","color":"#333","borderRadius":"0","textAlign":"right","background":"none","width":"100%","fontSize":"14px","height":"44px"}' @click="goBackend">Backend manage </el-button>
                <el-upload v-if="loginType==2" :action="baseUrl + 'file/upload'" :show-file-list="false" :on-success="faceLogin">
                    <el-button :style='{"border":"0","cursor":"pointer","padding":"0 24px","margin":"0","outline":"none","color":"#333","borderRadius":"0","background":"linear-gradient(0deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","width":"100%","fontSize":"16px","minWidth":"120px","height":"44px"}'>人脸识别Login </el-button>
                </el-upload>
			</el-form-item>
			<div :style='{"width":"80%","margin":"0px auto 60px","justifyContent":"center","display":"flex"}'>
			<router-link :style='{"cursor":"pointer","margin":"0 10px 10px 0","color":"#20ad9e","textAlign":"center","background":"none","fontSize":"16px","textDecoration":"none","minWidth":"100px"}' :to="{path: '/register', query: {role: item.tableName,pageFlag:'register'}}" v-if="item.hasFrontRegister=='是'" v-for="(item, index) in roles" :key="index">Registered{{item.roleName.replace('Registered','')}}</router-link>
			<router-link :style='{"cursor":"pointer","margin":"0 10px 10px 0","color":"#20ad9e","textAlign":"center","background":"none","fontSize":"14px","textDecoration":"none","minWidth":"100px"}' :to="{path: '/register', query: {pageFlag:'security1'}}">forgot password?</router-link>
			</div>
		</el-form>
    </div>
</div>
</template>

<script>

export default {
	//数据集合
	data() {
		return {
            baseUrl: this.$config.baseUrl,
            loginType: 1,
			roleMenus: [{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","modify","delete","发布缴费","Assign coach"],"menu":"student","menuJump":"列表","tableName":"xueyuan"}],"menu":"studentmanage"},{"child":[{"appFrontIcon":"cuIcon-skin","buttons":["查看","modify","delete"],"menu":"Driving school coach","menuJump":"列表","tableName":"jiaxiaojiaolian"}],"menu":"Driving school coachmanage"},{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","modify","delete"],"menu":"Assign coach","menuJump":"列表","tableName":"fenpeijiaolian"}],"menu":"Assign coachmanage"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["查看","modify","delete"],"menu":"Appointment Practice","menuJump":"列表","tableName":"yuyuelianxi"}],"menu":"Appointment Practicemanage"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["查看","modify","delete","新增","维护登记"],"menu":"Driving school vehicles","menuJump":"列表","tableName":"jiaxiaocheliang"}],"menu":"Driving school vehiclesmanage"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","modify","delete"],"menu":"Exam arrangements","menuJump":"列表","tableName":"kaoshianpai"}],"menu":"Exam arrangementsmanage"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","delete","modify"],"menu":"study plan","menuJump":"列表","tableName":"xuexijihua"}],"menu":"study planmanage"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看","modify","delete"],"menu":"Payment information","menuJump":"列表","tableName":"jiaofeixinxi"}],"menu":"Payment informationmanage"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","modify","delete"],"menu":"Vehicle maintenance","menuJump":"列表","tableName":"cheliangweihu"}],"menu":"Vehicle maintenancemanage"},{"child":[{"appFrontIcon":"cuIcon-shop","buttons":["新增","查看","modify","delete"],"menu":"Registration for Driving School","menuJump":"列表","tableName":"jiaxiaobaoming"}],"menu":"Registration for Driving Schoolmanage"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","modify","delete"],"menu":"coach evaluate","menuJump":"列表","tableName":"jiaolianpingjia"}],"menu":"coach evaluatemanage"},{"child":[{"appFrontIcon":"cuIcon-goods","buttons":["查看","modify"],"menu":"About Us","tableName":"aboutus"},{"appFrontIcon":"cuIcon-qrcode","buttons":["查看","modify"],"menu":"System Introduction","tableName":"systemintro"},{"appFrontIcon":"cuIcon-shop","buttons":["新增","查看","modify","delete"],"menu":"Carousel management","tableName":"config"},{"appFrontIcon":"cuIcon-news","buttons":["新增","查看","modify","delete"],"menu":"Driving School Information","tableName":"news"}],"menu":"System manage"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","报名缴费"],"menu":"Registration for Driving School列表","menuJump":"列表","tableName":"jiaxiaobaoming"}],"menu":"Registration for Driving School模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"否","hasFrontRegister":"否","roleName":"admin","tableName":"users"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","Appointment Practice"],"menu":"Assign coach","menuJump":"列表","tableName":"fenpeijiaolian"}],"menu":"Assign coachmanage"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["查看","modify","delete","coach evaluate"],"menu":"Appointment Practice","menuJump":"列表","tableName":"yuyuelianxi"}],"menu":"Appointment Practicemanage"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看"],"menu":"Exam arrangements","menuJump":"列表","tableName":"kaoshianpai"}],"menu":"Exam arrangementsmanage"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看"],"menu":"study plan","menuJump":"列表","tableName":"xuexijihua"}],"menu":"study planmanage"},{"child":[{"appFrontIcon":"cuIcon-present","buttons":["查看","支付"],"menu":"Payment information","menuJump":"列表","tableName":"jiaofeixinxi"}],"menu":"Payment informationmanage"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看","modify","delete"],"menu":"coach evaluate","menuJump":"列表","tableName":"jiaolianpingjia"}],"menu":"coach evaluatemanage"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","报名缴费"],"menu":"Registration for Driving School列表","menuJump":"列表","tableName":"jiaxiaobaoming"}],"menu":"Registration for Driving School模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"student","tableName":"xueyuan"},{"backMenu":[{"child":[{"appFrontIcon":"cuIcon-similar","buttons":["查看","Exam arrangements","study plan"],"menu":"Assign coach","menuJump":"列表","tableName":"fenpeijiaolian"}],"menu":"Assign coachmanage"},{"child":[{"appFrontIcon":"cuIcon-circle","buttons":["查看","审核"],"menu":"Appointment Practice","menuJump":"列表","tableName":"yuyuelianxi"}],"menu":"Appointment Practicemanage"},{"child":[{"appFrontIcon":"cuIcon-rank","buttons":["查看","维护登记"],"menu":"Driving school vehicles","menuJump":"列表","tableName":"jiaxiaocheliang"}],"menu":"Driving school vehiclesmanage"},{"child":[{"appFrontIcon":"cuIcon-list","buttons":["查看","modify","delete"],"menu":"Exam arrangements","menuJump":"列表","tableName":"kaoshianpai"}],"menu":"Exam arrangementsmanage"},{"child":[{"appFrontIcon":"cuIcon-time","buttons":["查看","modify","delete"],"menu":"study plan","menuJump":"列表","tableName":"xuexijihua"}],"menu":"study planmanage"},{"child":[{"appFrontIcon":"cuIcon-flashlightopen","buttons":["查看","modify","delete"],"menu":"Vehicle maintenance","menuJump":"列表","tableName":"cheliangweihu"}],"menu":"Vehicle maintenancemanage"},{"child":[{"appFrontIcon":"cuIcon-paint","buttons":["查看"],"menu":"coach evaluate","menuJump":"列表","tableName":"jiaolianpingjia"}],"menu":"coach evaluatemanage"}],"frontMenu":[{"child":[{"appFrontIcon":"cuIcon-explore","buttons":["查看","报名缴费"],"menu":"Registration for Driving School列表","menuJump":"列表","tableName":"jiaxiaobaoming"}],"menu":"Registration for Driving School模块"}],"hasBackLogin":"是","hasBackRegister":"否","hasFrontLogin":"是","hasFrontRegister":"是","roleName":"Driving school coach","tableName":"jiaxiaojiaolian"}],
			loginForm: {
				username: '',
				password: '',
				tableName: '',
				code: '',
			},
			role: '',
            roles: [],
			rules: {
				username: [
					{ required: true, message: 'Please enter your account', trigger: 'blur' }
				],
				password: [
					{ required: true, message: 'Please input a password', trigger: 'blur' }
				]
			},
			codes: [{
				num: 1,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 2,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 3,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}, {
				num: 4,
				color: '#000',
				rotate: '10deg',
				size: '16px'
			}]
		}
	},
	created() {
        for(let item in this.roleMenus) {
            if(this.roleMenus[item].hasFrontLogin=='是') {
                this.roles.push(this.roleMenus[item]);
            }
        }
	},
	mounted() {
	},
    //方法集合
    methods: {

      goBackend() {
        window.open(`${this.$config.baseUrl}admin/dist/index.html`, "_blank");
      },
		randomString() {
			var len = 4;
			var chars = [
			  'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
			  'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			  'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G',
			  'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R',
			  'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2',
			  '3', '4', '5', '6', '7', '8', '9'
			]
			var colors = ['0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f']
			var sizes = ['14', '15', '16', '17', '18']

			var output = []
			for (var i = 0; i < len; i++) {
			  // 随机验证码
			  var key = Math.floor(Math.random() * chars.length)
			  this.codes[i].num = chars[key]
			  // 随机验证码颜色
			  var code = '#'
			  for (var j = 0; j < 6; j++) {
			    var key = Math.floor(Math.random() * colors.length)
			    code += colors[key]
			  }
			  this.codes[i].color = code
			  // 随机验证码方向
			  var rotate = Math.floor(Math.random() * 45)
			  var plus = Math.floor(Math.random() * 2)
			  if (plus == 1) rotate = '-' + rotate
			  this.codes[i].rotate = 'rotate(' + rotate + 'deg)'
			  // 随机验证码字体大小
			  var size = Math.floor(Math.random() * sizes.length)
			  this.codes[i].size = sizes[size] + 'px'
			}
		},
      getCurrentRow(row) {
        this.role = row.roleName;
      },
      submitForm(formName) {
        if (this.roles.length!=1) {
            if (!this.role) {
                this.$message.error("Please select Login User 类型");
                return false;
            }
        } else {
            this.role = this.roles[0].roleName;
            this.loginForm.tableName = this.roles[0].tableName;
        }
        this.$refs[formName].validate((valid) => {
          if (valid) {
            this.$http.get(`${this.loginForm.tableName}/login`, {params: this.loginForm}).then(res => {
              if (res.data.code === 0) {
                localStorage.setItem('Token', res.data.token);
                localStorage.setItem('UserTableName', this.loginForm.tableName);
                localStorage.setItem('username', this.loginForm.username);
                localStorage.setItem('adminName', this.loginForm.username);
                localStorage.setItem('sessionTable', this.loginForm.tableName);
                localStorage.setItem('role', this.role);
                localStorage.setItem('keyPath', this.$config.indexNav.length+2);
                this.$router.push('/index/center');
                this.$message({
                  message: 'Login  success',
                  type: 'success',
                  duration: 1500,
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
          } else {
            return false;
          }
        });
      },
      resetForm(formName) {
        this.$refs[formName].resetFields();
      }
    }
  }
</script>

<style rel="stylesheet/scss" lang="scss" scoped>
	.container {
		position: relative;
		background: url(http://codegen.caihongy.cn/20230131/c788dee9481d4fd896e419a46388d74e.png) no-repeat center bottom,url(http://codegen.caihongy.cn/20230131/fb996fdf6c5c4781a7b257b4b91254dd.png) no-repeat center top,url(http://codegen.caihongy.cn/20230131/bd3718741ba74578b2f69615121a81d9.jpg) no-repeat center bottom / 100% auto;

		.el-form-item {
		  & /deep/ .el-form-item__content {
		    width: 100%;
		  }
		}

		.list-item /deep/ .el-input .el-input__inner {
			border: 1px solid #ddd;
			border-radius: 8px;
			padding: 0 10px;
			box-shadow: 0 0 0px rgba(64, 158, 255, .5);
			color: #333;
			background: #fff;
			width: 100%;
			font-size: 14px;
			height: 40px;
		}

		.list-code /deep/ .el-input .el-input__inner {
			border: 1px solid #ddd;
			border-radius: 8px;
			padding: 0 10px;
			outline: none;
			color: #333;
			background: #fff;
			display: inline-block;
			vertical-align: middle;
			width: calc(100% - 110px);
			font-size: 14px;
			height: 40px;
		}

		.list-type /deep/ .el-radio__input .el-radio__inner {
			background: rgba(53, 53, 53, 0);
			border-color: #666666;
		}
		.list-type /deep/ .el-radio__input.is-checked .el-radio__inner {
			background: #992298;
			border-color: #992298;
		}
		.list-type /deep/ .el-radio__label {
			color: #666666;
			font-size: 14px;
		}
		.list-type /deep/ .el-radio__input.is-checked+.el-radio__label {
			color: #992298;
			font-size: 14px;
		}
	}
</style>
