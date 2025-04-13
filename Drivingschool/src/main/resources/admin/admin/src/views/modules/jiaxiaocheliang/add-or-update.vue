<template>
	<div class="addEdit-block" :style='{"padding":"10px 30px"}' style="width: 100%;">
		<el-form
			:style='{"padding":"30px 15px","boxShadow":"0 0px 0px #999","borderRadius":"0px","flexWrap":"wrap","background":"none","display":"flex","justifyContent":"space-between"}'
			class="add-update-preview"
			ref="ruleForm"
			:model="ruleForm"
			:rules="rules"
			label-width="120px"
		>
			<template >
				<el-form-item :style='{"margin":"0 0 30px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-if="type!='info'"  label="车牌号" prop="chepaihao">
					<el-input v-model="ruleForm.chepaihao" placeholder="车牌号" clearable  :readonly="ro.chepaihao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 30px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-else class="input" label="车牌号" prop="chepaihao">
					<el-input v-model="ruleForm.chepaihao" placeholder="车牌号" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 30px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-if="type!='info'"  label="车辆名称" prop="cheliangmingcheng">
					<el-input v-model="ruleForm.cheliangmingcheng" placeholder="车辆名称" clearable  :readonly="ro.cheliangmingcheng"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 30px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-else class="input" label="车辆名称" prop="cheliangmingcheng">
					<el-input v-model="ruleForm.cheliangmingcheng" placeholder="车辆名称" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 30px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="select" v-if="type!='info'"  label="车辆类型" prop="cheliangleixing">
					<el-select :disabled="ro.cheliangleixing" v-model="ruleForm.cheliangleixing" placeholder="Please select 车辆类型" >
						<el-option
							v-for="(item,index) in cheliangleixingOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 30px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-else class="input" label="车辆类型" prop="cheliangleixing">
					<el-input v-model="ruleForm.cheliangleixing"
						placeholder="车辆类型" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 30px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="select" v-if="type!='info'"  label="科目" prop="kemu">
					<el-select :disabled="ro.kemu" v-model="ruleForm.kemu" placeholder="Please select 科目" >
						<el-option
							v-for="(item,index) in kemuOptions"
							v-bind:key="index"
							:label="item"
							:value="item">
						</el-option>
					</el-select>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 30px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-else class="input" label="科目" prop="kemu">
					<el-input v-model="ruleForm.kemu"
						placeholder="科目" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 30px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="upload" v-if="type!='info' && !ro.cheliangtupian" label="车辆图片" prop="cheliangtupian">
					<file-upload
						tip="点击上传车辆图片"
						action="file/upload"
						:limit="3"
						:multiple="true"
						:fileUrls="ruleForm.cheliangtupian?ruleForm.cheliangtupian:''"
						@change="cheliangtupianUploadChange"
					></file-upload>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 30px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="upload" v-else-if="ruleForm.cheliangtupian" label="车辆图片" prop="cheliangtupian">
					<img v-if="ruleForm.cheliangtupian.substring(0,4)=='http'" class="upload-img" style="margin-right:20px;" v-bind:key="index" :src="ruleForm.cheliangtupian.split(',')[0]" width="100" height="100">
					<img v-else class="upload-img" style="margin-right:20px;" v-bind:key="index" v-for="(item,index) in ruleForm.cheliangtupian.split(',')" :src="$base.url+item" width="100" height="100">
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 30px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-if="type!='info'"  label="Coach account" prop="jiaolianzhanghao">
					<el-input v-model="ruleForm.jiaolianzhanghao" placeholder="Coach account" clearable  :readonly="ro.jiaolianzhanghao"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 30px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-else class="input" label="Coach account" prop="jiaolianzhanghao">
					<el-input v-model="ruleForm.jiaolianzhanghao" placeholder="Coach account" readonly></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 30px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' class="input" v-if="type!='info'"  label="Coach Name" prop="jiaolianxingming">
					<el-input v-model="ruleForm.jiaolianxingming" placeholder="Coach Name" clearable  :readonly="ro.jiaolianxingming"></el-input>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 30px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-else class="input" label="Coach Name" prop="jiaolianxingming">
					<el-input v-model="ruleForm.jiaolianxingming" placeholder="Coach Name" readonly></el-input>
				</el-form-item>
			</template>
				<el-form-item :style='{"margin":"0 0 30px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-if="type!='info'"  label="车辆info" prop="cheliangxiangqing">
					<editor
						style="min-width: 200px; max-width: 600px;"
						v-model="ruleForm.cheliangxiangqing"
						class="editor"
						action="file/upload">
					</editor>
				</el-form-item>
				<el-form-item :style='{"margin":"0 0 30px 0","flexWrap":"wrap","textAlign":"left","background":"none","display":"block","width":"100%","justifyContent":"flex-start"}' v-else-if="ruleForm.cheliangxiangqing" label="车辆info" prop="cheliangxiangqing">
                    <span :style='{"fontSize":"14px","lineHeight":"40px","color":"#333","fontWeight":"500","display":"inline-block"}' v-html="ruleForm.cheliangxiangqing"></span>
                </el-form-item>
			<el-form-item :style='{"padding":"0","margin":"20px 0 0"}' class="btn">
				<el-button :style='{"cursor":"pointer","padding":"0 30px","margin":"0 20px 0 0","borderColor":"#1fbfae","color":"#1fbfae","outline":"none","borderRadius":"0px","background":"#e9faf8","borderWidth":"4px","width":"auto","lineHeight":"40px","fontSize":"14px","borderStyle":"solid double solid double","height":"44px"}'  v-if="type!='info'" type="primary" class="btn-success" @click="onSubmit">submit</el-button>
				<el-button :style='{"cursor":"pointer","padding":"0 24px","margin":"0","borderColor":"#dc333b","color":"#dc333b","outline":"none","borderRadius":"0px","background":"#fbeced","borderWidth":"4px","width":"auto","lineHeight":"40px","fontSize":"14px","borderStyle":"solid double solid double","height":"44px"}' v-if="type!='info'" class="btn-close" @click="back()">cancel</el-button>
				<el-button :style='{"cursor":"pointer","padding":"0 24px","margin":"0","borderColor":"#dc333b","color":"#dc333b","outline":"none","borderRadius":"0px","background":"#fbeced","borderWidth":"4px","width":"auto","lineHeight":"40px","fontSize":"14px","borderStyle":"solid double solid double","height":"44px"}' v-if="type=='info'" class="btn-close" @click="back()">return</el-button>
			</el-form-item>
		</el-form>


  </div>
</template>
<script>
// 数字，邮件，手机，url，ID校验
import { isNumber,isIntNumer,isEmail,isPhone, isMobile,isURL,checkIdCard } from "@/utils/validate";
export default {
	data() {
		let self = this
		var validateIdCard = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!checkIdCard(value)) {
				callback(new Error("Please enter the correct ID number"));
			} else {
				callback();
			}
		};
		var validateUrl = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isURL(value)) {
				callback(new Error("Please enter the correct URL address"));
			} else {
				callback();
			}
		};
		var validateMobile = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isMobile(value)) {
				callback(new Error("Please enter the correct phone number"));
			} else {
				callback();
			}
		};
		var validatePhone = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isPhone(value)) {
				callback(new Error("Please enter the correct phone number"));
			} else {
				callback();
			}
		};
		var validateEmail = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isEmail(value)) {
				callback(new Error("Please enter the correct email address"));
			} else {
				callback();
			}
		};
		var validateNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isNumber(value)) {
				callback(new Error("Please enter a number"));
			} else {
				callback();
			}
		};
		var validateIntNumber = (rule, value, callback) => {
			if(!value){
				callback();
			} else if (!isIntNumer(value)) {
				callback(new Error("Please enter an integer"));
			} else {
				callback();
			}
		};
		return {
			id: '',
			type: '',


			ro:{
				chepaihao : false,
				cheliangmingcheng : false,
				cheliangleixing : false,
				kemu : false,
				cheliangtupian : false,
				cheliangxiangqing : false,
				jiaolianzhanghao : false,
				jiaolianxingming : false,
			},


			ruleForm: {
				chepaihao: '',
				cheliangmingcheng: '',
				cheliangleixing: '',
				kemu: '',
				cheliangtupian: '',
				cheliangxiangqing: '',
				jiaolianzhanghao: '',
				jiaolianxingming: '',
			},

			cheliangleixingOptions: [],
			kemuOptions: [],

			rules: {
				chepaihao: [
				],
				cheliangmingcheng: [
					{ required: true, message: '车辆名称Cannot be empty', trigger: 'blur' },
				],
				cheliangleixing: [
					{ required: true, message: '车辆类型Cannot be empty', trigger: 'blur' },
				],
				kemu: [
				],
				cheliangtupian: [
				],
				cheliangxiangqing: [
				],
				jiaolianzhanghao: [
				],
				jiaolianxingming: [
				],
			}
		};
	},
	props: ["parent"],
	computed: {



	},
	created() {
	},
	methods: {

		// 下载
		download(file){
			window.open(`${file}`)
		},
		// 初始化
		init(id,type) {
			if (id) {
				this.id = id;
				this.type = type;
			}
			if(this.type=='info'||this.type=='else'){
				this.info(id);
			}else if(this.type=='logistics'){
				this.logistics=false;
				this.info(id);
			}else if(this.type=='cross'){
				var obj = this.$storage.getObj('crossObj');
				for (var o in obj){
						if(o=='chepaihao'){
							this.ruleForm.chepaihao = obj[o];
							this.ro.chepaihao = true;
							continue;
						}
						if(o=='cheliangmingcheng'){
							this.ruleForm.cheliangmingcheng = obj[o];
							this.ro.cheliangmingcheng = true;
							continue;
						}
						if(o=='cheliangleixing'){
							this.ruleForm.cheliangleixing = obj[o];
							this.ro.cheliangleixing = true;
							continue;
						}
						if(o=='kemu'){
							this.ruleForm.kemu = obj[o];
							this.ro.kemu = true;
							continue;
						}
						if(o=='cheliangtupian'){
							this.ruleForm.cheliangtupian = obj[o];
							this.ro.cheliangtupian = true;
							continue;
						}
						if(o=='cheliangxiangqing'){
							this.ruleForm.cheliangxiangqing = obj[o];
							this.ro.cheliangxiangqing = true;
							continue;
						}
						if(o=='jiaolianzhanghao'){
							this.ruleForm.jiaolianzhanghao = obj[o];
							this.ro.jiaolianzhanghao = true;
							continue;
						}
						if(o=='jiaolianxingming'){
							this.ruleForm.jiaolianxingming = obj[o];
							this.ro.jiaolianxingming = true;
							continue;
						}
				}









			}


			// 获取User 信息
			this.$http({
				url: `${this.$storage.get('sessionTable')}/session`,
				method: "get"
			}).then(({ data }) => {
				if (data && data.code === 0) {

					var json = data.data;
					if(((json.jiaolianzhanghao!=''&&json.jiaolianzhanghao) || json.jiaolianzhanghao==0) && this.$storage.get("role")!="admin"){
						this.ruleForm.jiaolianzhanghao = json.jiaolianzhanghao
						this.ro.jiaolianzhanghao = true;
					}
					if(((json.jiaolianxingming!=''&&json.jiaolianxingming) || json.jiaolianxingming==0) && this.$storage.get("role")!="admin"){
						this.ruleForm.jiaolianxingming = json.jiaolianxingming
						this.ro.jiaolianxingming = true;
					}
				} else {
					this.$message.error(data.msg);
				}
			});

            this.cheliangleixingOptions = "训练车,考试车".split(',')
            this.kemuOptions = "科目二,科目三".split(',')

		},
    // 多级联动参数

    info(id) {
      this.$http({
        url: `jiaxiaocheliang/info/${id}`,
        method: "get"
      }).then(({ data }) => {
        if (data && data.code === 0) {
        this.ruleForm = data.data;
        //解决前台上传图片Backend 不显示的问题
        let reg=new RegExp('../../../upload','g')//g代表全部
        this.ruleForm.cheliangxiangqing = this.ruleForm.cheliangxiangqing.replace(reg,'../../../Drivingschool/upload');
        } else {
          this.$message.error(data.msg);
        }
      });
    },


    // submit
    onSubmit() {










	if(this.ruleForm.cheliangtupian!=null) {
		this.ruleForm.cheliangtupian = this.ruleForm.cheliangtupian.replace(new RegExp(this.$base.url,"g"),"");
	}







var objcross = this.$storage.getObj('crossObj');

      //更新跨表属性
       var crossuserid;
       var crossrefid;
       var crossoptnum;
       if(this.type=='cross'){
                var statusColumnName = this.$storage.get('statusColumnName');
                var statusColumnValue = this.$storage.get('statusColumnValue');
                if(statusColumnName!='') {
                        var obj = this.$storage.getObj('crossObj');
                       if(statusColumnName && !statusColumnName.startsWith("[")) {
                               for (var o in obj){
                                 if(o==statusColumnName){
                                   obj[o] = statusColumnValue;
                                 }
                               }
                               var table = this.$storage.get('crossTable');
                             this.$http({
                                 url: `${table}/update`,
                                 method: "post",
                                 data: obj
                               }).then(({ data }) => {});
                       } else {
                               crossuserid=this.$storage.get('userid');
                               crossrefid=obj['id'];
                               crossoptnum=this.$storage.get('statusColumnName');
                               crossoptnum=crossoptnum.replace(/\[/,"").replace(/\]/,"");
                        }
                }
        }
       this.$refs["ruleForm"].validate(valid => {
         if (valid) {
		 if(crossrefid && crossuserid) {
			 this.ruleForm.crossuserid = crossuserid;
			 this.ruleForm.crossrefid = crossrefid;
			let params = {
				page: 1,
				limit: 10,
				crossuserid:this.ruleForm.crossuserid,
				crossrefid:this.ruleForm.crossrefid,
			}
			this.$http({
				url: "jiaxiaocheliang/page",
				method: "get",
				params: params
			}).then(({
				data
			}) => {
				if (data && data.code === 0) {
				       if(data.data.total>=crossoptnum) {
					     this.$message.error(this.$storage.get('tips'));
					       return false;
				       } else {
					 this.$http({
					   url: `jiaxiaocheliang/${!this.ruleForm.id ? "save" : "update"}`,
					   method: "post",
					   data: this.ruleForm
					 }).then(({ data }) => {
					   if (data && data.code === 0) {
					     this.$message({
					       message: "operate success",
					       type: "success",
					       duration: 1500,
					       onClose: () => {
						 this.parent.showFlag = true;
						 this.parent.addOrUpdateFlag = false;
						 this.parent.jiaxiaocheliangCrossAddOrUpdateFlag = false;
						 this.parent.search();
						 this.parent.contentStyleChange();
					       }
					     });
					   } else {
					     this.$message.error(data.msg);
					   }
					 });

				       }
				} else {
				}
			});
		 } else {
			 this.$http({
			   url: `jiaxiaocheliang/${!this.ruleForm.id ? "save" : "update"}`,
			   method: "post",
			   data: this.ruleForm
			 }).then(({ data }) => {
			   if (data && data.code === 0) {
			     this.$message({
			       message: "operate success",
			       type: "success",
			       duration: 1500,
			       onClose: () => {
				 this.parent.showFlag = true;
				 this.parent.addOrUpdateFlag = false;
				 this.parent.jiaxiaocheliangCrossAddOrUpdateFlag = false;
				 this.parent.search();
				 this.parent.contentStyleChange();
			       }
			     });
			   } else {
			     this.$message.error(data.msg);
			   }
			 });
		 }
         }
       });
    },
    // 获取uuid
    getUUID () {
      return new Date().getTime();
    },
    // return
    back() {
      this.parent.showFlag = true;
      this.parent.addOrUpdateFlag = false;
      this.parent.jiaxiaocheliangCrossAddOrUpdateFlag = false;
      this.parent.contentStyleChange();
    },
    cheliangtupianUploadChange(fileUrls) {
	    this.ruleForm.cheliangtupian = fileUrls;
    },
  }
};
</script>
<style lang="scss" scoped>
	.amap-wrapper {
		width: 100%;
		height: 500px;
	}

	.search-box {
		position: absolute;
	}

	.el-date-editor.el-input {
		width: auto;
	}

	.add-update-preview .el-form-item /deep/ .el-form-item__label {
	  	  padding: 0 10px 0 0;
	  	  text-shadow: 0 1px 10px #fff;
	  	  color: #666;
	  	  background: none;
	  	  font-weight: 500;
	  	  display: block;
	  	  width: 120px;
	  	  font-size: 14px;
	  	  line-height: 40px;
	  	  text-align: right;
	  	}

	.add-update-preview .el-form-item /deep/ .el-form-item__content {
	  margin-left: 120px;
	}

	.add-update-preview .el-input /deep/ .el-input__inner {
	  	  border-radius: 0px;
	  	  padding: 0 12px;
	  	  box-shadow: 0 0 0px #4b681d;
	  	  outline: none;
	  	  color: #666;
	  	  background: #fff;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  border-color: #2adbcb;
	  	  border-width: 4px;
	  	  border-style: solid double solid double;
	  	  height: 40px;
	  	}

	.add-update-preview .el-select /deep/ .el-input__inner {
	  	  border-radius: 0px;
	  	  padding: 0 10px;
	  	  box-shadow: 0 0 0px #4b681d;
	  	  outline: none;
	  	  color: #666;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  border-color: #2adbcb;
	  	  border-width: 4px;
	  	  border-style: solid double solid double;
	  	  height: 40px;
	  	}

	.add-update-preview .el-date-editor /deep/ .el-input__inner {
	  	  border: 0px solid #333;
	  	  border-radius: 0px;
	  	  padding: 0 10px 0 30px;
	  	  box-shadow: 0 0 0px #4b681d;
	  	  outline: none;
	  	  color: #666;
	  	  width: 400px;
	  	  font-size: 14px;
	  	  border-color: #2adbcb;
	  	  border-width: 4px;
	  	  border-style: solid double solid double;
	  	  height: 40px;
	  	}

	.add-update-preview /deep/ .el-upload--picture-card {
		background: transparent;
		border: 0;
		border-radius: 0;
		width: auto;
		height: auto;
		line-height: initial;
		vertical-align: middle;
	}

	.add-update-preview /deep/ .upload .upload-img {
	  	  border: 2px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: #2adbcb;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  border-color: #2adbcb;
	  	  border-width: 4px;
	  	  line-height: 90px;
	  	  border-style: solid double solid double;
	  	  text-align: center;
	  	  height: 100px;
	  	}

	.add-update-preview /deep/ .el-upload-list .el-upload-list__item {
	  	  border: 2px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: #2adbcb;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  border-color: #2adbcb;
	  	  border-width: 4px;
	  	  line-height: 90px;
	  	  border-style: solid double solid double;
	  	  text-align: center;
	  	  height: 100px;
	  	}

	.add-update-preview /deep/ .el-upload .el-icon-plus {
	  	  border: 2px solid #ddd;
	  	  cursor: pointer;
	  	  border-radius: 0px;
	  	  color: #2adbcb;
	  	  width: 200px;
	  	  font-size: 32px;
	  	  border-color: #2adbcb;
	  	  border-width: 4px;
	  	  line-height: 90px;
	  	  border-style: solid double solid double;
	  	  text-align: center;
	  	  height: 100px;
	  	}

	.add-update-preview .el-textarea /deep/ .el-textarea__inner {
	  	  border-radius: 0px;
	  	  padding: 12px;
	  	  box-shadow: 0 0 0px #4b681d;
	  	  outline: none;
	  	  color: #666;
	  	  width: 500px;
	  	  font-size: 14px;
	  	  min-height: 120px;
	  	  border-color: #2adbcb;
	  	  border-width: 4px;
	  	  border-style: solid double solid double;
	  	  height: auto;
	  	}
</style>
