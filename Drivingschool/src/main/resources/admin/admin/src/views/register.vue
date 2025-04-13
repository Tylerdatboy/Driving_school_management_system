<template>
	<div>
		<div class="container" :style='{"minHeight":"100vh","alignItems":"center","background":"url(http://codegen.caihongy.cn/20221201/ad8b598515704341aed4de6f4d3b36b8.jpg)","display":"flex","width":"100%","backgroundSize":"100% 100%","backgroundPosition":"center center","backgroundRepeat":"no-repeat","justifyContent":"center"}'>
			<el-form v-if="pageFlag=='security1'" :style='{"minHeight":"750px","padding":"30px 0px 60px 600px","margin":"0px auto 0 auto","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20221130/96464fa9ee1447fcac8ed4cef9e06ae1.png) no-repeat right top","width":"1200px","backgroundSize":"auto 100%","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm">
				<div v-if="true" :style='{"width":"550px","margin":"0 0px 16px -34px","lineHeight":"40px","fontSize":"20px","color":"#160f53","textAlign":"center"}' class="title">Driving School Reservation Management System Retrieve password</div>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">account</div>
					<el-input v-model="ruleForm.username" autocomplete="off" placeholder="Please enter your account number" />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">role</div>
                    <el-select v-model="tableName" placeholder="Please choose a role">
                        <el-option label="student" value="xueyuan"></el-option>
                        <el-option label="Driving school coach" value="jiaxiaojiaolian"></el-option>
                    </el-select>
				</el-form-item>
				<button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"20px 120px 4px ","outline":"none","color":"#fff","borderRadius":"0px","background":"#41bec9","display":"block","width":"40%","fontSize":"16px","height":"36px"}' type="button" class="r-btn" @click="getSecurity()">下一步</button>
				<div :style='{"cursor":"pointer","padding":"0 10%","color":"rgba(159, 159, 159, 1)","display":"inline-block","lineHeight":"2","fontSize":"12px","textDecoration":"underline"}' class="r-login" @click="close()">Already have an account, log in directly</div>
            </el-form>
			<el-form v-if="pageFlag=='security2'" :style='{"minHeight":"750px","padding":"30px 0px 60px 600px","margin":"0px auto 0 auto","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20221130/96464fa9ee1447fcac8ed4cef9e06ae1.png) no-repeat right top","width":"1200px","backgroundSize":"auto 100%","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm">
				<div v-if="true" :style='{"width":"550px","margin":"0 0px 16px -34px","lineHeight":"40px","fontSize":"20px","color":"#160f53","textAlign":"center"}' class="title">Driving School Reservation Management SystempasswordReset </div>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">security question</div>
					<el-input v-model="ruleForm.pquestion" readOnly autocomplete="off" placeholder="security question" />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">Secret Answer</div>
					<el-input v-model="ruleForm.myanswer" autocomplete="off" placeholder="Please enter Secret Answer" />
				</el-form-item>
				<button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"20px 120px 4px ","outline":"none","color":"#fff","borderRadius":"0px","background":"#41bec9","display":"block","width":"40%","fontSize":"16px","height":"36px"}' type="button" class="r-btn" @click="validateSecurity()">下一步</button>
				<div :style='{"cursor":"pointer","padding":"0 10%","color":"rgba(159, 159, 159, 1)","display":"inline-block","lineHeight":"2","fontSize":"12px","textDecoration":"underline"}' class="r-login" @click="close()">Already have an account, log in directly</div>
            </el-form>
			<el-form v-if="pageFlag=='security3'" :style='{"minHeight":"750px","padding":"30px 0px 60px 600px","margin":"0px auto 0 auto","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20221130/96464fa9ee1447fcac8ed4cef9e06ae1.png) no-repeat right top","width":"1200px","backgroundSize":"auto 100%","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm">
				<div v-if="true" :style='{"width":"550px","margin":"0 0px 16px -34px","lineHeight":"40px","fontSize":"20px","color":"#160f53","textAlign":"center"}' class="title">Driving School Reservation Management System Password Reset</div>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">New Password</div>
					<el-input v-model="ruleForm.newpassword" autocomplete="off" type="password" placeholder="Please enter a new password" />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">Confirm Password</div>
					<el-input v-model="ruleForm.repassword" autocomplete="off" type="password" placeholder="Please enter a new password" />
				</el-form-item>
				<button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"20px 120px 4px ","outline":"none","color":"#fff","borderRadius":"0px","background":"#41bec9","display":"block","width":"40%","fontSize":"16px","height":"36px"}' type="button" class="r-btn" @click="updatePassword()">modifypassword</button>
				<div :style='{"cursor":"pointer","padding":"0 10%","color":"rgba(159, 159, 159, 1)","display":"inline-block","lineHeight":"2","fontSize":"12px","textDecoration":"underline"}' class="r-login" @click="close()">Already have an account, log in directly</div>
            </el-form>
			<el-form v-if="pageFlag=='register'" :style='{"minHeight":"750px","padding":"30px 0px 60px 600px","margin":"0px auto 0 auto","borderRadius":"0px","background":"url(http://codegen.caihongy.cn/20221130/96464fa9ee1447fcac8ed4cef9e06ae1.png) no-repeat right top","width":"1200px","backgroundSize":"auto 100%","height":"auto"}' ref="rgsForm" class="rgs-form" :model="rgsForm">
				<div v-if="true" :style='{"width":"550px","margin":"0 0px 16px -34px","lineHeight":"40px","fontSize":"20px","color":"#160f53","textAlign":"center"}' class="title">Driving School Reservation Management System register</div>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">Student account</div>
					<el-input  v-model="ruleForm.xueyuanzhanghao"  autocomplete="off" placeholder="Student account"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">password</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="password"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">confirm password</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="confirm password" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">Student name</div>
					<el-input  v-model="ruleForm.xueyuanxingming"  autocomplete="off" placeholder="Student name"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">gender</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="Please select gender" >
                        <el-option
                            v-for="(item,index) in xueyuanxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">Student mobile phone</div>
					<el-input  v-model="ruleForm.xueyuanshouji"  autocomplete="off" placeholder="Student mobile phone"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">ID</div>
					<el-input  v-model="ruleForm.shenfenzheng"  autocomplete="off" placeholder="ID"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">picture</div>
                    <file-upload
                        tip="Click to upload picture"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="xueyuantouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">security question</div>
					<el-input  v-model="ruleForm.pquestion"  autocomplete="off" placeholder="security question"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='xueyuan'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">Secret Answer</div>
					<el-input  v-model="ruleForm.panswer"  autocomplete="off" placeholder="Secret Answer"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaxiaojiaolian'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">Coach account</div>
					<el-input  v-model="ruleForm.jiaolianzhanghao"  autocomplete="off" placeholder="Coach account"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaxiaojiaolian'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">password</div>
					<el-input  v-model="ruleForm.mima"  autocomplete="off" placeholder="password"  type="password"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaxiaojiaolian'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">confirm password</div>
					<el-input  v-model="ruleForm.mima2" autocomplete="off" placeholder="confirm password" type="password" />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaxiaojiaolian'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">Coach Name</div>
					<el-input  v-model="ruleForm.jiaolianxingming"  autocomplete="off" placeholder="Coach Name"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaxiaojiaolian'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">age</div>
					<el-input  v-model="ruleForm.nianling"  autocomplete="off" placeholder="age"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaxiaojiaolian'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">gender</div>
                    <el-select v-model="ruleForm.xingbie" placeholder="Please select gender" >
                        <el-option
                            v-for="(item,index) in jiaxiaojiaolianxingbieOptions"
                            v-bind:key="index"
                            :label="item"
                            :value="item">
                        </el-option>
                    </el-select>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaxiaojiaolian'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">Length of teaching</div>
					<el-input  v-model="ruleForm.jiaoling"  autocomplete="off" placeholder="Length of teaching"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaxiaojiaolian'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">picture</div>
                    <file-upload
                        tip="Click to upload picture"
                        action="file/upload"
                        :limit="3"
                        :multiple="true"
                        :fileUrls="ruleForm.touxiang?ruleForm.touxiang:''"
                        @change="jiaxiaojiaoliantouxiangUploadChange"
                    ></file-upload>
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaxiaojiaolian'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">Contact Number</div>
					<el-input  v-model="ruleForm.lianxidianhua"  autocomplete="off" placeholder="Contact Number"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaxiaojiaolian'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">security question</div>
					<el-input  v-model="ruleForm.pquestion"  autocomplete="off" placeholder="security question"  type="text"  />
				</el-form-item>
				<el-form-item :style='{"width":"80%","padding":"0","margin":"0 auto 10px","flexWrap":"wrap","display":"block","height":"auto"}' class="list-item" v-if="tableName=='jiaxiaojiaolian'">
					<div v-if="false" :style='{"width":"100%","lineHeight":"44px","fontSize":"14px","color":"rgba(64, 158, 255, 1)"}' class="lable">Secret Answer</div>
					<el-input  v-model="ruleForm.panswer"  autocomplete="off" placeholder="Secret Answer"  type="text"  />
				</el-form-item>
				<button :style='{"border":"0","cursor":"pointer","padding":"0 10px","margin":"20px 120px 4px ","outline":"none","color":"#fff","borderRadius":"0px","background":"#41bec9","display":"block","width":"40%","fontSize":"16px","height":"36px"}' type="button" class="r-btn" @click="login()">Registered</button>
				<div :style='{"cursor":"pointer","padding":"0 10%","color":"rgba(159, 159, 159, 1)","display":"inline-block","lineHeight":"2","fontSize":"12px","textDecoration":"underline"}' class="r-login" @click="close()">Already have an account, log in directly</div>
			</el-form>

		</div>
	</div>
</template>

<script>

export default {
	data() {
		return {
			ruleForm: {
                xingbie: '',
                xingbie: '',
			},

            pageFlag : '',
			tableName:"",
			rules: {},
            xueyuanxingbieOptions: [],
            jiaxiaojiaolianxingbieOptions: [],
		};
	},
	mounted(){
        this.pageFlag = this.$storage.get("pageFlag");
		let table = this.$storage.get("loginTable");
		this.tableName = table;
        this.xueyuanxingbieOptions = "man,woman".split(',')
        this.jiaxiaojiaolianxingbieOptions = "man,woman".split(',')
	},
	created() {

	},
	destroyed() {
		  	},
	methods: {
		// 获取uuid
		getUUID () {
			return new Date().getTime();
		},
		close(){
			this.$router.push({ path: "/login" });
		},
        xueyuantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },
        jiaxiaojiaoliantouxiangUploadChange(fileUrls) {
            this.ruleForm.touxiang = fileUrls;
        },

        // 多级联动参数


        //获取security question
        getSecurity(){
            if(!this.tableName) {
                this.$message.error("Please select a role");
                return false
            }
            if(!this.ruleForm.username){
                this.$message.error("Please enter your account number");
                return false
            }
            this.$http({
                url: this.tableName+`/security?username=` + this.ruleForm.username,
                method: "get",
            }).then(({
                data
            }) => {
                if (data.data && data.code === 0) {
                    this.ruleForm = data.data;
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
            if(this.ruleForm.panswer!=this.ruleForm.myanswer){
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
            if (this.ruleForm.newpassword != this.ruleForm.repassword) {
                this.$message.error("The two password inputs are inconsistent");
                return;
            }
            this.ruleForm.mima = this.ruleForm.newpassword;
            this.ruleForm.password = this.ruleForm.newpassword;
            this.$http({
                url: this.tableName+`/update`,
                method: "post",
                data: this.ruleForm
            }).then(({
                data
            }) => {
                if (data && data.code === 0) {
                    this.$message({
                        message: "modifypassword success",
                        type: "success",
                        duration: 1500,
                        onClose: () => {}
                    });
                    this.close()
                } else {
                    this.$message.error(data.msg);
                }
            });
        },
		// Registered
		login() {
			var url=this.tableName+"/register";
					if((!this.ruleForm.xueyuanzhanghao) && `xueyuan` == this.tableName){
						this.$message.error(`Student accountCannot be empty`);
						return
					}










					if((!this.ruleForm.mima) && `xueyuan` == this.tableName){
						this.$message.error(`passwordCannot be empty`);
						return
					}










					if((this.ruleForm.mima!=this.ruleForm.mima2) && `xueyuan` == this.tableName){
						this.$message.error(`The two password inputs are inconsistent`);
						return
					}


























					if(`xueyuan` == this.tableName && this.ruleForm.xueyuanshouji&&(!this.$validate.isMobile(this.ruleForm.xueyuanshouji))){
						this.$message.error(`Mobile phone format should be entered`);
						return
					}












					if(`xueyuan` == this.tableName && this.ruleForm.shenfenzheng&&(!this.$validate.checkIdCard(this.ruleForm.shenfenzheng))){
						this.$message.error(`ID应输入ID格式`);
						return
					}


            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }































					if((!this.ruleForm.jiaolianzhanghao) && `jiaxiaojiaolian` == this.tableName){
						this.$message.error(`Coach accountCannot be empty`);
						return
					}










					if((!this.ruleForm.mima) && `jiaxiaojiaolian` == this.tableName){
						this.$message.error(`passwordCannot be empty`);
						return
					}










					if((this.ruleForm.mima!=this.ruleForm.mima2) && `jiaxiaojiaolian` == this.tableName){
						this.$message.error(`The two password inputs are inconsistent`);
						return
					}













					if(`jiaxiaojiaolian` == this.tableName && this.ruleForm.nianling&&(!this.$validate.isIntNumer(this.ruleForm.nianling))){
						this.$message.error(`age应输入整数`);
						return
					}



























            if(this.ruleForm.touxiang!=null) {
                this.ruleForm.touxiang = this.ruleForm.touxiang.replace(new RegExp(this.$base.url,"g"),"");
            }
















					if(`jiaxiaojiaolian` == this.tableName && this.ruleForm.lianxidianhua&&(!this.$validate.isMobile(this.ruleForm.lianxidianhua))){
						this.$message.error(`Contact Number应输入手机格式`);
						return
					}




































			this.$http({
				url: url,
				method: "post",
				data:this.ruleForm
			}).then(({ data }) => {
				if (data && data.code === 0) {
					this.$message({
						message: "Registered success",
						type: "success",
						duration: 1500,
						onClose: () => {
							this.$router.replace({ path: "/login" });
						}
					});
				} else {
					this.$message.error(data.msg);
				}
			});
		}
	}
};
</script>

<style lang="scss" scoped>
	.container {
	  position: relative;
	  background: url(http://codegen.caihongy.cn/20221201/ad8b598515704341aed4de6f4d3b36b8.jpg);

		.el-date-editor.el-input {
		  width: 100%;
		}

		.rgs-form .el-input /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px;
						margin: 0;
						color: #999;
						width: 360px;
						font-size: 14px;
						border-color: #d0cddb;
						border-width: 0 0 1px;
						border-style: solid;
						height: 36px;
					}

		.rgs-form .el-select /deep/ .el-input__inner {
						border: 0px solid #333;
						border-radius: 0px;
						padding: 0 10px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #999;
						width: 360px;
						font-size: 14px;
						border-color: #d0cddb;
						border-width: 0 0 1px;
						border-style: solid;
						height: 36px;
					}

		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #999;
						width: 360px;
						font-size: 14px;
						border-color: #d0cddb;
						border-width: 0 0 1px;
						border-style: solid;
						height: 36px;
					}

		.rgs-form .el-date-editor /deep/ .el-input__inner {
						border-radius: 0px;
						padding: 0 10px 0 30px;
						box-shadow: 0 0 0px rgba(64, 158, 255, .5);
						outline: none;
						color: #999;
						width: 360px;
						font-size: 14px;
						border-color: #d0cddb;
						border-width: 0 0 1px;
						border-style: solid;
						height: 36px;
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
		  		  border: 2px dashed #ccc;
		  		  cursor: pointer;
		  		  border-radius: 4px;
		  		  margin: 10px 0 0;
		  		  color: #bbb;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}

		.rgs-form /deep/ .el-upload-list .el-upload-list__item {
		  		  border: 2px dashed #ccc;
		  		  cursor: pointer;
		  		  border-radius: 4px;
		  		  margin: 10px 0 0;
		  		  color: #bbb;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}

		.rgs-form /deep/ .el-upload .el-icon-plus {
		  		  border: 2px dashed #ccc;
		  		  cursor: pointer;
		  		  border-radius: 4px;
		  		  margin: 10px 0 0;
		  		  color: #bbb;
		  		  width: 160px;
		  		  font-size: 32px;
		  		  line-height: 80px;
		  		  text-align: center;
		  		  height: 80px;
		  		}
	}
</style>
