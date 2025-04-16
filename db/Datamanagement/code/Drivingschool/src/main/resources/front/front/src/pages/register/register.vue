<template>
	<div>

	<div class="container" :style='{"minHeight":"100vh","width":"100%","alignItems":"center","background":"url(http://codegen.caihongy.cn/20230131/c788dee9481d4fd896e419a46388d74e.png) no-repeat center bottom,url(http://codegen.caihongy.cn/20230131/fb996fdf6c5c4781a7b257b4b91254dd.png) no-repeat center top,url(http://codegen.caihongy.cn/20230131/bd3718741ba74578b2f69615121a81d9.jpg) no-repeat center bottom / 100% auto","justifyContent":"center","display":"block"}'>
        <el-form class='rgs-form' v-if="pageFlag=='security1'" :style='{"padding":"80px 0 220px","boxShadow":"0 0px 0px rgba(64, 158, 255, .8)","margin":"0 auto","borderRadius":"0","flexWrap":"wrap","background":"none","display":"flex","width":"800px","justifyContent":"center","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="true" :style='{"width":"100%","margin":"0 auto 20px","lineHeight":"44px","fontSize":"20px","color":"#333","textAlign":"center"}'>retrieve password</div>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' prop="username">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>账号：</div>
				<el-input v-model="registerForm.username" placeholder="Please enter your account number" />
			</el-form-item>
            <el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' prop="tableName">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>角色：</div>
                <el-select v-model="tableName" placeholder="Please choose a role" >
                      <el-option label="student" value="xueyuan"></el-option>
                      <el-option label="Driving school coach" value="jiaxiaojiaolian"></el-option>
                </el-select>
            </el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"20px 20px 10px 0","color":"#333","display":"block","outline":"none","borderRadius":"30px","background":"linear-gradient(0deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","width":"140px","fontSize":"16px","height":"44px"}' type="primary" @click="getSecurity('registerForm')">下一步</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0","color":"#333","textAlign":"right","display":"inline-block","width":"100%","lineHeight":"1","fontSize":"12px","textDecoration":"none"}' to="/login">Already have an account Login </router-link>
        </el-form>

        <el-form class='rgs-form' v-if="pageFlag=='security2'" :style='{"padding":"80px 0 220px","boxShadow":"0 0px 0px rgba(64, 158, 255, .8)","margin":"0 auto","borderRadius":"0","flexWrap":"wrap","background":"none","display":"flex","width":"800px","justifyContent":"center","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="true" :style='{"width":"100%","margin":"0 auto 20px","lineHeight":"44px","fontSize":"20px","color":"#333","textAlign":"center"}'>retrieve password</p></div>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' prop="pquestion">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>security question：</div>
				<el-input readonly v-model="registerForm.pquestion" placeholder="security question" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' prop="myanswer">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Secret Answer：</div>
				<el-input v-model="registerForm.myanswer" placeholder="Please enter Secret Answer" />
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"20px 20px 10px 0","color":"#333","display":"block","outline":"none","borderRadius":"30px","background":"linear-gradient(0deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","width":"140px","fontSize":"16px","height":"44px"}' type="primary" @click="validateSecurity('registerForm')">下一步</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0","color":"#333","textAlign":"right","display":"inline-block","width":"100%","lineHeight":"1","fontSize":"12px","textDecoration":"none"}' to="/login">Already have an account Login </router-link>
        </el-form>

        <el-form class='rgs-form' v-if="pageFlag=='security3'" :style='{"padding":"80px 0 220px","boxShadow":"0 0px 0px rgba(64, 158, 255, .8)","margin":"0 auto","borderRadius":"0","flexWrap":"wrap","background":"none","display":"flex","width":"800px","justifyContent":"center","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="true" :style='{"width":"100%","margin":"0 auto 20px","lineHeight":"44px","fontSize":"20px","color":"#333","textAlign":"center"}'>retrieve password</p></div>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' prop="newpassword">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>new password：</div>
				<el-input v-model="registerForm.newpassword" type="password" placeholder="Please enter a new password" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' prop="repassword">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>confirm password：</div>
				<el-input v-model="registerForm.repassword" type="password" placeholder="Please confirm password" />
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"20px 20px 10px 0","color":"#333","display":"block","outline":"none","borderRadius":"30px","background":"linear-gradient(0deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","width":"140px","fontSize":"16px","height":"44px"}' type="primary" @click="updatePassword('registerForm')">modifypassword</el-button>
			<router-link :style='{"cursor":"pointer","padding":"0","color":"#333","textAlign":"right","display":"inline-block","width":"100%","lineHeight":"1","fontSize":"12px","textDecoration":"none"}' to="/login">Already have an account Login </router-link>
        </el-form>
		<el-form class='rgs-form' v-if="pageFlag=='register'" :style='{"padding":"80px 0 220px","boxShadow":"0 0px 0px rgba(64, 158, 255, .8)","margin":"0 auto","borderRadius":"0","flexWrap":"wrap","background":"none","display":"flex","width":"800px","justifyContent":"center","height":"auto"}' ref="registerForm" :model="registerForm" :rules="rules">
			<div v-if="false" :style='{"margin":"0 0 10px 0","color":"rgba(64, 158, 255, 1)","textAlign":"center","width":"100%","lineHeight":"44px","fontSize":"20px","textShadow":"4px 4px 2px rgba(64, 158, 255, .5)"}'>USER / REGISTER</div>
			<div v-if="true" :style='{"width":"100%","margin":"0 auto 20px","lineHeight":"44px","fontSize":"20px","color":"#333","textAlign":"center"}'>Driving School Reservation Management SystemRegistered</p></div>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='xueyuan'" prop="xueyuanzhanghao">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Student account：</div>
				<el-input v-model="registerForm.xueyuanzhanghao"  placeholder="Enter Student account" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='xueyuan'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>password：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="Please input a password" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='xueyuan'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>confirm password：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="Please enter again password" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='xueyuan'" prop="xueyuanxingming">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Student name：</div>
				<el-input v-model="registerForm.xueyuanxingming"  placeholder="Enter Student name" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='xueyuan'" prop="xingbie">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>gender：</div>
                <el-select v-model="registerForm.xingbie" placeholder="Please select gender" >
                  <el-option
                      v-for="(item,index) in xueyuanxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='xueyuan'" prop="xueyuanshouji">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Student mobile phone：</div>
				<el-input v-model="registerForm.xueyuanshouji"  placeholder="Enter Student mobile phone" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='xueyuan'" prop="shenfenzheng">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>ID：</div>
				<el-input v-model="registerForm.shenfenzheng"  placeholder="Enter ID" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='xueyuan'" prop="touxiang">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>picture：</div>
                <file-upload
					tip="Click to upload picture"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="xueyuantouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='xueyuan'" prop="pquestion">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>security question：</div>
				<el-input v-model="registerForm.pquestion"  placeholder="Enter security question" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='xueyuan'" prop="panswer">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Secret Answer：</div>
				<el-input v-model="registerForm.panswer"  placeholder="Enter Secret Answer" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='jiaxiaojiaolian'" prop="jiaolianzhanghao">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Coach account：</div>
				<el-input v-model="registerForm.jiaolianzhanghao"  placeholder="Enter Coach account" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='jiaxiaojiaolian'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>password：</div>
				<el-input v-model="registerForm.mima" type="password" placeholder="Please input a password" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='jiaxiaojiaolian'" prop="mima">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>confirm password：</div>
				<el-input v-model="registerForm.mima2" type="password" placeholder="Please enter again password" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='jiaxiaojiaolian'" prop="jiaolianxingming">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Coach Name：</div>
				<el-input v-model="registerForm.jiaolianxingming"  placeholder="Enter Coach Name" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='jiaxiaojiaolian'" prop="nianling">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>age：</div>
				<el-input v-model="registerForm.nianling"  placeholder="Enter age" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='jiaxiaojiaolian'" prop="xingbie">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>gender：</div>
                <el-select v-model="registerForm.xingbie" placeholder="Please select gender" >
                  <el-option
                      v-for="(item,index) in jiaxiaojiaolianxingbieOptions"
                      :key="index"
                      :label="item"
                      :value="item">
                  </el-option>
                </el-select>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='jiaxiaojiaolian'" prop="jiaoling">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Length of teaching：</div>
				<el-input v-model="registerForm.jiaoling"  placeholder="Enter Length of teaching" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='jiaxiaojiaolian'" prop="touxiang">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>picture：</div>
                <file-upload
					tip="Click to upload picture"
					action="file/upload"
					:limit="1"
					:multiple="true"
					:fileUrls="registerForm.touxiang?registerForm.touxiang:''"
					@change="jiaxiaojiaoliantouxiangUploadChange"
				></file-upload>
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='jiaxiaojiaolian'" prop="lianxidianhua">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Contact Number：</div>
				<el-input v-model="registerForm.lianxidianhua"  placeholder="Enter Contact Number" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='jiaxiaojiaolian'" prop="pquestion">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>security question：</div>
				<el-input v-model="registerForm.pquestion"  placeholder="Enter security question" />
			</el-form-item>
			<el-form-item :style='{"width":"100%","padding":"0","margin":"0 auto 26px","height":"auto"}' v-if="tableName=='jiaxiaojiaolian'" prop="panswer">
				<div v-if="false" :style='{"width":"64px","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}'>Secret Answer：</div>
				<el-input v-model="registerForm.panswer"  placeholder="Enter Secret Answer" />
			</el-form-item>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"20px 20px 10px 0","color":"#333","display":"block","outline":"none","borderRadius":"30px","background":"linear-gradient(0deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","width":"140px","fontSize":"16px","height":"44px"}' type="primary" @click="submitForm('registerForm')">Registered</el-button>
			<el-button :style='{"border":"0","cursor":"pointer","padding":"0 10px","boxShadow":"0 0 0px rgba(64, 158, 255, .5)","margin":"20px 20px 10px 0","color":"#333","display":"block","outline":"none","borderRadius":"30px","background":"linear-gradient(0deg, rgba(238,177,238,1) 0%, rgba(165,228,222,1) 30%, rgba(165,228,222,1) 100%)","width":"140px","fontSize":"16px","height":"44px"}' @click="resetForm('registerForm')">Reset </el-button>
			<router-link :style='{"cursor":"pointer","padding":"0","color":"#333","textAlign":"right","display":"inline-block","width":"100%","lineHeight":"1","fontSize":"12px","textDecoration":"none"}' to="/login">Already have an account Login </router-link>
		</el-form>
    </div>
  </div>
</div>
</template>

<script>

export default {
    //数据集合
    data() {
		return {
            pageFlag : '',
			tableName: '',
			registerForm: {
                xingbie: '',
                xingbie: '',
            },
			rules: {},
            xueyuanxingbieOptions: [],
            jiaxiaojiaolianxingbieOptions: [],
		}
    },
	mounted() {
	},
    created() {
      this.pageFlag = this.$route.query.pageFlag;
      this.tableName = this.$route.query.role;
      if ('xueyuan' == this.tableName) {
        this.rules.xueyuanzhanghao = [{ required: true, message: 'Enter Student account', trigger: 'blur' }];
      }
      if ('xueyuan' == this.tableName) {
        this.rules.mima = [{ required: true, message: 'Please input a password', trigger: 'blur' }];
      }
        this.xueyuanxingbieOptions = "man,woman".split(',');
      if ('xueyuan' == this.tableName) {
        this.rules.xueyuanshouji = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
      if ('xueyuan' == this.tableName) {
        this.rules.shenfenzheng = [{ required: true, validator: this.$validate.isIdCard, trigger: 'blur' }];
      }
      if ('jiaxiaojiaolian' == this.tableName) {
        this.rules.jiaolianzhanghao = [{ required: true, message: 'Enter Coach account', trigger: 'blur' }];
      }
      if ('jiaxiaojiaolian' == this.tableName) {
        this.rules.mima = [{ required: true, message: 'Please input a password', trigger: 'blur' }];
      }
      if ('jiaxiaojiaolian' == this.tableName) {
        this.rules.nianling = [{ required: true, validator: this.$validate.isIntNumer, trigger: 'blur' }];
      }
        this.jiaxiaojiaolianxingbieOptions = "man,woman".split(',');
      if ('jiaxiaojiaolian' == this.tableName) {
        this.rules.lianxidianhua = [{ required: true, validator: this.$validate.isMobile, trigger: 'blur' }];
      }
    },
    //方法集合
    methods: {
      // 获取uuid
      getUUID () {
        return new Date().getTime();
      },
        // 下二随
      xueyuantouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },
      jiaxiaojiaoliantouxiangUploadChange(fileUrls) {
          this.registerForm.touxiang = fileUrls.replace(new RegExp(this.$config.baseUrl,"g"),"");
      },

        // 多级联动参数


//获取security question
        getSecurity(){
            if(!this.tableName) {
                this.$message.error("Please select a role");
                return false
            }
            if(!this.registerForm.username){
                this.$message.error("Please enter your account number");
                return false
            }
            this.$http({
                url: this.tableName+`/security?username=` + this.registerForm.username,
                method: "get",
            }).then(({
                data
            }) => {
                if (data.data && data.code === 0) {
                    this.registerForm = data.data;
                    this.pageFlag="security2"
                } else {
                    if(!data.data) {
                        this.$message.error("user does not exist");
                    } else {
                        this.$message.error(data.msg);
                    }
                }
            });
        },
        //验证security question
        validateSecurity(){
            let that = this
            if(this.registerForm.panswer!=this.registerForm.myanswer){
                this.$message.error("Incorrect answer input");
                return false
            }
            this.$message.success("Correct answer");
            setTimeout(()=>{
                this.pageFlag="security3";
            },1000)

        },
        // modifypassword
        updatePassword() {
            if (!this.registerForm.newpassword) {
                this.$message.error("Enter new password");
                return;
            }
            if (this.registerForm.newpassword != this.registerForm.repassword) {
                this.$message.error("The two password inputs are inconsistent");
                return;
            }
            this.registerForm.mima = this.registerForm.newpassword;
            this.registerForm.password = this.registerForm.newpassword;
            this.$http.post(this.tableName+`/update`, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                    message: "passwordmodify success",
                    type: "success",
                    duration: 1500,
                    onClose: () => {
                      this.$router.push('/login');
                    }
                });
              } else {
                this.$message.error(res.data.msg);
              }
            });
        },
      submitForm(formName) {
        this.$refs[formName].validate((valid) => {
          if (valid) {
            var url=this.tableName+"/register";
               if(`xueyuan` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`The two password inputs are inconsistent`);
                return
               }
               if(`jiaxiaojiaolian` == this.tableName && this.registerForm.mima!=this.registerForm.mima2) {
                this.$message.error(`The two password inputs are inconsistent`);
                return
               }
            this.$http.post(url, this.registerForm).then(res => {
              if (res.data.code === 0) {
                this.$message({
                  message: 'Registered success',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.$router.push('/login');
                  }
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

		.el-date-editor.el-input {
			width: 100%;
		}

		.rgs-form .el-input /deep/ .el-input__inner {
						border: 1px solid #ddd;
						border-radius: 8px;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #333;
						width: 100%;
						font-size: 14px;
						height: 40px;
					}

		.rgs-form .el-select /deep/ .el-input__inner {
						border: 1px solid #ddd;
						border-radius: 8px;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #333;
						width: 388px;
						font-size: 14px;
						height: 40px;
					}

		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #ddd;
						border-radius: 8px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #333;
						width: 388px;
						font-size: 14px;
						height: 40px;
					}

		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border: 1px solid #ddd;
						border-radius: 8px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #333;
						width: 388px;
						font-size: 14px;
						height: 40px;
					}

		.rgs-form /deep/ .el-upload--picture-card {
			background: transparent;
			border: 0;
			border-radius: 0;
			width: auto;
			height: auto;
			line-height: initial;
			vertical-align: middle;
		}

		.rgs-form /deep/ .upload .upload-img {
		  		  border: 1px dashed #20ad9e;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #333;
		  		  width: 100px;
		  		  font-size: 32px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: 100px;
		  		}

		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 1px dashed #20ad9e;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #333;
		  		  width: 100px;
		  		  font-size: 32px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: 100px;
		  		}

		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 1px dashed #20ad9e;
		  		  cursor: pointer;
		  		  border-radius: 8px;
		  		  color: #333;
		  		  width: 100px;
		  		  font-size: 32px;
		  		  line-height: 100px;
		  		  text-align: center;
		  		  height: 100px;
		  		}
	}
</style>
